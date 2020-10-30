/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.client;

import org.oclc.circill.toolkit.common.base.StatisticsBean;
import org.oclc.circill.toolkit.service.base.ServiceException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Implementation of {@link HttpClient}.
 */
public class HttpClientImpl extends BaseClient implements HttpClient {

    private static final Logger LOG = Logger.getLogger(HttpClientImpl.class);

    protected static final Integer HTTP_SUCCESS = 200;
    protected static final Integer HTTP_CREATED = 201;
    protected static final List<Integer> HTTP_GOOD_RESPONSE_CODES;
    static {
        final List<Integer> tmpList = new ArrayList<>();
        tmpList.add(HTTP_SUCCESS);
        tmpList.add(HTTP_CREATED);
        HTTP_GOOD_RESPONSE_CODES = Collections.unmodifiableList(tmpList);
    }

    /**
     * The {@link SSLSocketFactory} to use, if any.
     */
    protected SSLSocketFactory sslSocketFactory = null;

    /**
     * Construct a new client with the provided {@link StatisticsBean} and default timeout values.
     *
     * @param statisticsBean the {@link StatisticsBean} to which to write statistics
     */
    public HttpClientImpl(final StatisticsBean statisticsBean) {
        super(statisticsBean);
    }

    /**
     * Get the {@link SSLSocketFactory} for this client.
     *
     * @return the sslSocketFactory
     */
    public SSLSocketFactory getSSLSocketFactory() {
        return sslSocketFactory;
    }

    /**
     * Set the {@link SSLSocketFactory} for this client.
     *
     * @param sslSocketFactory the SSLSocketFactory used by this client
     */
    public void setSSLSocketFactory(final SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
    }

    /**
     * Send the provided initiation message with no additional headers to the current target address.
     *
     * @param initiationMsgBytes the initiation message as an array of bytes (network octets)
     * @param targetURL the URL of the target responder
     * @return the {@link InputStream} from which the response message can be read
     * @throws ServiceException if the service fails
     */
    public InputStream sendMessage(final byte[] initiationMsgBytes, final String targetURL) throws ServiceException {
        return sendMessage(initiationMsgBytes, Collections.emptyMap(), targetURL);
    }

    /**
     * Send the provided initiation message (with supplied headers), represented as an array of bytes,
     * to the current target address using the current connect and read timeouts.
     *
     * @param initiationMsgBytes the initiation message as an array of bytes (network octets)
     * @param targetURL the URL of the target responder
     * @param headers a map of HTTP headers
     * @return the {@link InputStream} from which the response message can be read
     * @throws ServiceException if the exchange of messages with the responder fails
     */
    public InputStream sendMessage(final byte[] initiationMsgBytes, final Map<String, String> headers, final String targetURL) throws ServiceException {
        OutputStream outputStream = null;
        InputStream inputStream = null;

        try {

            validateURL(targetURL);

            final HttpURLConnection con = (HttpURLConnection) new URL(targetURL).openConnection();

            if (hostnameVerifier != null && con instanceof HttpsURLConnection) {
                ((HttpsURLConnection) con).setHostnameVerifier(hostnameVerifier);
            }

            if (sslSocketFactory != null && con instanceof HttpsURLConnection) {
                ((HttpsURLConnection) con).setSSLSocketFactory(sslSocketFactory);
            }

            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setConnectTimeout(connectTimeout);
            con.setReadTimeout(readTimeout);
            con.setRequestProperty("Content-Type", "application/xml; charset=\"utf-8\"");
            con.setRequestProperty("Content-length", String.valueOf(initiationMsgBytes.length));
            con.setRequestProperty("Accept", "application/xml");
            setHeaders(con, headers);

            outputStream = con.getOutputStream();
            outputStream.write(initiationMsgBytes);
            outputStream.flush();
            final long initPerfSvcStartTime = System.currentTimeMillis();

            final int httpResponseCode = con.getResponseCode();
            final long initPerfSvcEndTime = System.currentTimeMillis();

            if (statisticsBean != null) {
                statisticsBean.record(StatisticsBean.Step.PERFORM_SERVICE, initPerfSvcStartTime, initPerfSvcEndTime, "External Service at " + targetURL);
            }

            if (HTTP_GOOD_RESPONSE_CODES.contains(httpResponseCode)) {
                inputStream = con.getInputStream();
            } else {
                logResponseHeaders(con);
                throw new ServiceException(
                    String.format("Service failed; responder returned HTTP status code %d, with response '%s'.", httpResponseCode, con.getResponseMessage()));
            }
        } catch (IOException e) {
            throw new ServiceException(String.format("Exception connecting to or exchanging messages with target at '%s'.", targetURL), e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    LOG.debug("Ignoring IOException when calling close() in finally block.", e);
                }
            }
        }

        return inputStream;
    }

    /**
     * Set the HTTP headers for this request.
     * @param connection the connection
     * @param headers the headers
     */
    protected void setHeaders(final HttpURLConnection connection, final Map<String, String> headers) {

        if (headers != null && !headers.isEmpty()) {
            for (final Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Log the response's HTTP headers.
     * @param connection the connection
     */
    protected void logResponseHeaders(final HttpURLConnection connection) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response Headers:");
            final Map<String, List<String>> requestProperties = connection.getHeaderFields();
            for (final Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                for (final String propertyValue : entry.getValue()) {
                    LOG.debug("  " + entry.getKey() + ": " + propertyValue);
                }
            }
        }
    }
}
