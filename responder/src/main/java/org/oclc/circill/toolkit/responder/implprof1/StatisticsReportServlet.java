/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.responder.implprof1;

import org.oclc.circill.toolkit.common.base.StatisticsBean;

import static java.lang.String.format;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Pattern;

import static org.springframework.web.context.support.WebApplicationContextUtils.getRequiredWebApplicationContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;

/**
 * Displays statistics for the associated end-point and allows the stats to be cleared.
 */
public class StatisticsReportServlet extends HttpServlet {
    /** Logger. */
    private static final Logger LOG = Logger.getLogger(StatisticsReportServlet.class);
    /** The initial StringBuilder size. */
    private static final int INITIAL_HTML_REPORT_SIZE = 3000;
    /** The format for percentages. */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
    /** The URL parameter for the action in POST method. */
    private static final String ACTION_PARAMTER_NAME = "action";
    /** The Regex for the clear or reset action's name. */
    private static final Pattern CLEAR_ACTION_REGEX = Pattern.compile("(?i)^(clear|reset)$");
    /** The message for exceptions when the StatisticsBean can't be obtained. */
    private static final String STATISTICS_BEAN_EXCEPTION_MESSAGE = "Statistics bean '%s' not found in web app context.";
    /** The message for when an exception occurs closing the servlet output stream. */
    private static final String OUTPUT_STREAM_CLOSURE_EXCEPTION_MESSAGE = "Exception trying to close servlet output stream.";

    /** The associated statistics bean. */
    private StatisticsBean statisticsBean;

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        final String overrideBeanName = servletConfig.getInitParameter("beanName");
        final String beanName = StringUtils.isNotBlank(overrideBeanName) ? overrideBeanName : "statisticsBean";
        final WebApplicationContext appContext = getRequiredWebApplicationContext(servletConfig.getServletContext());
        statisticsBean = (StatisticsBean) appContext.getBean(beanName);
        if (statisticsBean == null) {
            throw new IllegalStateException(format(STATISTICS_BEAN_EXCEPTION_MESSAGE, beanName));
        }
    }

    /** [@inheritDoc} */
    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {

        ServletOutputStream outputStream = null;
        try {
            response.setContentType("text/html; charset=\"utf-8\"");

            final StringBuilder htmlReport = new StringBuilder(INITIAL_HTML_REPORT_SIZE);
            htmlReport.append("<html><body><img src=\"logo.jpg\"/><br/>Message parsing statistics:<br/>Statistics captured since: ")
                .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(statisticsBean.getStartDateTime())).append("<br/><table border=\"2\"><tr><td align=\"center\"")
                .append("\">Type</td><td align=\"center\">Count</td><td align=\"center\">Total ms.</td><td align=\"center\">Average ms.</td></tr>");

            for (final Map.Entry<StatisticsBean.Step, Map<String, StatisticsBean.StatsRecord>> statRecordStepMap : statisticsBean.getStatsRecords().entrySet()) {
                for (final Map.Entry<String, StatisticsBean.StatsRecord> statRecord : statRecordStepMap.getValue().entrySet()) {
                    htmlReport.append("<tr>");
                    buildKeyHTML(htmlReport, statRecord.getValue().getLabel());

                    final float floatAvg = ((float) statRecord.getValue().getTotalIntervals()) / ((float) statRecord.getValue().getCount());
                    htmlReport.append("<td align=\"right\">").append(statRecord.getValue().getCount()).append("</td><td align=\"right\">")
                        .append(statRecord.getValue().getTotalIntervals()).append("</td><td align=\"right\">").append(DECIMAL_FORMAT.format(floatAvg)).append("</td></tr>");
                }
            }

            htmlReport.append("</table><form name=\"clearForm\" action=\"").append(request.getRequestURI())
                .append("\" method=\"POST\"><input type=hidden name=action value=\"clear\"><input type=\"submit\" value=\"clear\"></form></body></html>");
            response.setContentLength(htmlReport.length());

            outputStream = response.getOutputStream();
            outputStream.write(htmlReport.toString().getBytes(StandardCharsets.UTF_8));
            outputStream.flush();

        } catch (final IOException e) {
            final String message = "Exception writing response: " + e.getMessage();
            LOG.error(message);
            if (outputStream != null) {
                try {
                    outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                    outputStream.flush();
                } catch (IOException ioe) {
                    LOG.error(OUTPUT_STREAM_CLOSURE_EXCEPTION_MESSAGE, e);
                }
            }
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    LOG.error(OUTPUT_STREAM_CLOSURE_EXCEPTION_MESSAGE, e);
                }
            }
        }
    }

    /**
     * Append "&lt;td&gt;" + keyPart + "&lt;/td&gt;" to the htmlReport; but if keyPart is an array
     * call this method recursively on each entry in the array.
     *
     * @param htmlReport the report to append the key to
     * @param keyPart the partial array of key objects
     */
    private void buildKeyHTML(final StringBuilder htmlReport, final Object keyPart) {
        if (keyPart != null && keyPart.getClass().isArray()) {
            final Object[] keyPartArray = (Object[]) keyPart;
            for (final Object obj : keyPartArray) {
                buildKeyHTML(htmlReport, obj);
            }
        } else {
            htmlReport.append("<td>").append(keyPart).append("</td>");
        }
    }

    /**
     * Clear the statistics bean.
     * @param request the {@link }HttpServletRequest
     * @param response the {@link HttpServletResponse}
     * @throws IOException if {@link HttpServletResponse#sendRedirect(String)} throws this
     * @throws ServletException if {@link HttpServletResponse#sendRedirect(String)} throws this
     */
    @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        ServletOutputStream outputStream = null;
        final String action = request.getParameter(ACTION_PARAMTER_NAME);
        if (action != null && CLEAR_ACTION_REGEX.matcher(action).matches()) {
            statisticsBean.clear();
        }
        try {
            response.sendRedirect(request.getRequestURI());
        } catch (IOException e) {
            final String message = "Exception redirecting: " + e.getMessage();
            LOG.error(message);
            try {
                outputStream = response.getOutputStream();
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            } catch (IOException e1) {
                LOG.error(OUTPUT_STREAM_CLOSURE_EXCEPTION_MESSAGE, e);
            }
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    LOG.error(OUTPUT_STREAM_CLOSURE_EXCEPTION_MESSAGE, e);
                }
            }
        }
    }
}
