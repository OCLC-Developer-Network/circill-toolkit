/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.ExceptionDescription;
import org.oclc.circill.toolkit.service.base.ProtocolHelper;
import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceData;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.NCIPData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.Problem;
import org.oclc.circill.toolkit.service.ncip.ProblemResponseData;
import org.oclc.circill.toolkit.service.ncip.ProblemType;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.log4j.Logger;

/**
 * An implementation of {@link ProtocolHelper} for the NCIP protocol (NISO Z39.83).
 * {@inheritDoc}
 */
public class NCIPProtocolHelper implements ProtocolHelper<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> {

    private static final Logger LOG = Logger.getLogger(NCIPProtocolHelper.class);

    private static final String NAMESPACE_URIS_DEFAULT = "http://www.niso.org/2008/ncip";
    private static final String PROTOCOL_VERSION_VERSION_ATTRIBUTE_DEFAULT = "http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd";
    private static final String INITIATION_DATA_SUFFIX = "InitiationData";
    private static final int LENGTH_OF_INITIATION_DATA_LITERAL = INITIATION_DATA_SUFFIX.length();
    private static final int LENGTH_OF_RESPONSE_DATA_LITERAL = "ResponseData".length();
    private static final int LENGTH_OF_DATA_LITERAL = "Data".length();

    @Override
    public String getMessageName(final NCIPMessage<NCIPInitiationData, NCIPResponseData> message) throws ToolkitInternalException {
        if (message.isInitiationMessage()) {
            return message.getInitiationData().getMessageName();
        } else {
            return message.getResponseData().getMessageName();
        }
    }

    @Override
    public NCIPResponseData convertExceptionToResponse(final Exception e) {
        final ProblemResponseData problemResponseData = new ProblemResponseData();
        final List<Problem> problems;
        if (e instanceof ToolkitException && !((ToolkitException) e).getExceptionDescriptions().isEmpty()) {
            problems = createProblemsFromToolkitException((ToolkitException) e);
        } else {
            problems = createProblemsFromException(e);
        }
        problemResponseData.setProblems(problems);
        return problemResponseData;
    }

    private static List<Problem> createProblemsFromToolkitException(final ToolkitException e) {
        final List<Problem> problems;
        problems = new ArrayList<>();
        for (final ExceptionDescription ed : e.getExceptionDescriptions()) {
            final Problem problem = new Problem();
            problem.setProblemDetail(ed.getExceptionDetail());
            problem.setProblemValue(ed.getExceptionValue());
            problem.setProblemElement(ed.getExceptionLocation());
            try {
                problem.setProblemType(ProblemType.find(ed.getExceptionCodeScheme(), ed.getExceptionCodeValue()));
            } catch (ConfigurationException | ToolkitInternalException innerException) {
                problem.setProblemType(new ProblemType(ed.getExceptionCodeScheme(), ed.getExceptionValue()));
            }
            problems.add(problem);
        }
        return problems;
    }

    private static List<Problem> createProblemsFromException(final Exception e) {
        final List<Problem> problems = new ArrayList<>();
        final Problem problem = new Problem();
        if (e.getLocalizedMessage() != null) {
            problem.setProblemDetail(e.getLocalizedMessage());
        } else if (e.getCause() != null) {
            problem.setProblemDetail(e.getCause().getLocalizedMessage());
        } else {
            problem.setProblemDetail(e.getClass().getName());
        }
        problems.add(problem);
        return problems;
    }

    @Override
    public NCIPResponseData createProblemResponse(final String msg, final NCIPInitiationData initiationData) {
        final ProblemResponseData problemResponseData = new ProblemResponseData();
        final List<Problem> problems = new ArrayList<>();
        final Problem problem = new Problem();
        if (msg != null) {
            problem.setProblemDetail(msg);
        } else {
            problem.setProblemDetail("Unable to process request.");
        }
        if (initiationData != null) {
            problem.setProblemElement(initiationData.getServiceName());
        }
        problems.add(problem);
        problemResponseData.setProblems(problems);
        return problemResponseData;
    }

    @Override
    public NCIPMessage<NCIPInitiationData, NCIPResponseData> createServiceMessage(final NCIPInitiationData initiationData) throws ToolkitInternalException {
        final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage = new NCIPMessage<>();
        final String msgName = initiationData.getMessageName();
        ReflectionHelper.setField(ncipMessage, initiationData, msgName);
        return ncipMessage;
    }

    @Override
    public NCIPMessage<NCIPInitiationData, NCIPResponseData> createServiceMessage(final NCIPResponseData responseData) throws ToolkitInternalException {
        final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage = new NCIPMessage<>();
        final String msgName = responseData.getMessageName();
        ReflectionHelper.setField(ncipMessage, responseData, msgName);
        return ncipMessage;
    }

    @Override
    public NCIPInitiationData getInitiationData(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ToolkitInternalException {
        return ncipMessage.getInitiationData();
    }

    @Override
    public NCIPResponseData getResponseData(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ToolkitInternalException {
        return ncipMessage.getResponseData();
    }

    @Override
    public String getElementName(final Class<?> svcClass) {
        final String msgClassSimpleName = svcClass.getSimpleName();
        if (msgClassSimpleName.matches(".*InitiationData$")) {
            return msgClassSimpleName.substring(0, msgClassSimpleName.length() - LENGTH_OF_INITIATION_DATA_LITERAL);
        } else if (msgClassSimpleName.matches(".*ResponseData$")) {
            return msgClassSimpleName.substring(0, msgClassSimpleName.length() - LENGTH_OF_DATA_LITERAL);
        } else {
            return msgClassSimpleName;
        }
    }

    /**
     * Get the service name associated with the {@link ServiceData} object.
     * @param ncipData the {@link ServiceData} object
     * @return the service name
     */
    public String getServiceName(final NCIPData ncipData) {
        final String serviceName;
        if (ncipData != null) {
            // Note that this calculation is *slightly* different than that in the getMessageName method -
            // this is stripping "InitiationData" or "ResponseData" to get the *service* name, which is the same for both the
            // initiation and response messages.
            final int lengthOfSuffix = ncipData instanceof NCIPInitiationData ? LENGTH_OF_INITIATION_DATA_LITERAL : LENGTH_OF_RESPONSE_DATA_LITERAL;
            final String dataClassName = ncipData.getClass().getSimpleName();
            serviceName = dataClassName.substring(0, dataClassName.length() - lengthOfSuffix);
        } else {
            serviceName = "null";
        }
        return serviceName;
    }

    @SuppressWarnings(value = { "unchecked" }) // Because Method.invoke returns Object.
    public static List<Problem> getProblems(final NCIPResponseData responseData) throws ServiceException {
        final Method getProblemsMethod = ReflectionHelper.findMethod(responseData.getClass(), "getProblems");
        final List<Problem> problems;
        try {
            problems = (List<Problem>) getProblemsMethod.invoke(responseData);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Exception getting problems from response data:", e);
        }
        return problems;
    }

    /**
     * Builds a Problem object for an error that indicates the problem type, the problem element, and some detailed
     * information about the problem.
     *
     * @param type         the SchemeValuePair that identifies the problem; must not be null
     * @param elementXPath an XPath expression pointing to the problem element in the initiation message; may be null
     * @param value        the content of the element that is a problem
     * @param details      textual information about the problem; may be null
     * @return Problem
     */
    public static List<Problem> generateProblems(final ProblemType type, final String elementXPath, final String value, final String details) {
        final List<Problem> problems = new ArrayList<>();
        final Problem problem = new Problem();
        problem.setProblemType(type);
        if (elementXPath != null) {
            problem.setProblemElement(elementXPath);
        }
        if (details != null) {
            problem.setProblemDetail(details);
        }
        if (value != null) {
            problem.setProblemValue(value);
        }
        problems.add(problem);
        return problems;
    }

    /**
     * Generate a list of {@link Problem} elements.
     * @param type the {@link ProblemType}
     * @param elementXPath an XPath expression identifying the element associated with the problem; may be null
     * @param value the value of the element that is in error; may be null
     * @param details text detailing the problem; may be null
     * @param exception the exception which signalled the problem
     * @return a list of {@link Problem} objects
     */
    public static List<Problem> generateProblems(final ProblemType type, final String elementXPath, final String value, final String details, final Throwable exception) {
        return generateProblems(type, elementXPath, value, details + System.lineSeparator() + convertExceptionToString(exception));
    }

    /**
     * Converts the exception, including the stack trace, to a string.
     * @param e the Exception to render as a string
     * @return the String rendering of the Exception
     */
    public static String convertExceptionToString(final Throwable e) {

        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    @Override
    public BigDecimal decimalize(final BigDecimal amount, final CurrencyCode cc) {
        return amount.movePointLeft(cc.getMinorUnit());
    }

    @Override
    public BigDecimal undecimalize(final BigDecimal amount, final CurrencyCode cc) {
        return amount.movePointRight(cc.getMinorUnit());
    }

    @Override
    public String formatMonetaryAmount(final BigDecimal amount, final CurrencyCode cc) {
        return decimalize(amount, cc).toPlainString();
    }

    /**
     * Creates an {@link AgencyId} from the supplied string. If the string contains a '/' character
     * this will assume the characters following the last '/' are the {@link AgencyId#value} and
     * everything preceding the last '/' are the {@link AgencyId#scheme}. If there is no '/' it
     * will create an AgencyId with a null scheme and the value will be the entire supplied string.
     *
     * @param agencyIdString the string containing the value, and optionally the scheme, for the AgencyId.
     * @return the AgencyId
     */
    public static AgencyId createAgencyId(final String agencyIdString) {

        final AgencyId agencyId;
        final int lastSlashOffset = agencyIdString.lastIndexOf('/');
        if (lastSlashOffset >= 0) {

            agencyId = new AgencyId(agencyIdString.substring(0, lastSlashOffset), agencyIdString.substring(lastSlashOffset + 1));

        } else {

            agencyId = new AgencyId(agencyIdString);

        }

        return agencyId;

    }

    /**
     * Create a valid version 2 NCIPMessage response indicating a "Temporary Processing Failure", without
     * relying on any facilities of the Toolkit. This method is to be used when handling exceptions that
     * indicate that the Toolkit itself may be failing to severely to return a valid response.
     *
     * @param detail         the text message to include in the ProblemDetail element
     * @return a String containing an NCIP message with a Problem element describing the problem
     */
    @Override
    public String returnProblem(final String detail) {
        return returnProblem(detail, null);
    }

    /**
     * Create a valid version 2 NCIPMessage response indicating a "Temporary Processing Failure".
     * If the {@code serviceContext} is an instance of {@link NCIPServiceContext}, it will be used to get the
     * NCIP version attribute's value for the response.
     * This method is to be used when handling exceptions that
     * indicate that the Toolkit itself may be failing to severely to return a valid response.
     *
     * @param detail         the text message to include in the ProblemDetail element
     * @param serviceContext the {@link ServiceContext} for this invocation of the service
     * @return a String containing an NCIP message with a Problem element describing the problem
     */
    @Override
    public String returnProblem(final String detail, final ServiceContext serviceContext) {

        final String namespace = NAMESPACE_URIS_DEFAULT;
        String version = PROTOCOL_VERSION_VERSION_ATTRIBUTE_DEFAULT;
        if (serviceContext instanceof NCIPServiceContext) {
            final NCIPServiceContext ncipServiceContext = (NCIPServiceContext) serviceContext;
            version = ncipServiceContext.getVersion().getVersionAttribute();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n").append("<ns1:NCIPMessage ns1:version=\"").append(version).append("\"").append(" xmlns:ns1=\"").append(namespace)
            .append("\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"").append(" xsi:schemaLocation=\"").append(version).append("\">\n").append("  <ns1:Problem>\n")
            .append("    <ns1:ProblemType ns1:Scheme=\"http://www.niso.org/ncip/v1_0/schemes/processingerrortype/")
            .append("generalprocessingerror.scm\">Temporary Processing Failure</ns1:ProblemType>\n").append("    <ns1:ProblemDetail>").append(StringEscapeUtils.escapeXml10(detail))
            .append("</ns1:ProblemDetail>\n").append("  </ns1:Problem>\n").append("</ns1:NCIPMessage>");

        return sb.toString();

    }

    @Override
    public String returnException(final String msg, final Throwable e, final ServiceContext serviceContext, final boolean includeStackTracesInProblemResponse,
        final boolean includeExceptionMessagesInProblemResponse) {
        final String response;
        LOG.debug("Returning Problem for this exception: ", e);
        if (includeStackTracesInProblemResponse) {
            response = returnProblem(
                ToolkitHelper.convertExceptionMessagesToString(msg, e) + System.lineSeparator() + "Stacktrace from responder:" + System.lineSeparator()
                    + ToolkitHelper.convertExceptionToString(e), serviceContext);
        } else if (includeExceptionMessagesInProblemResponse) {
            response = returnProblem(ToolkitHelper.convertExceptionMessagesToString(msg, e), serviceContext);
        } else {
            response = returnProblem("Exception occurred during processing", serviceContext);
        }
        return response;
    }

}
