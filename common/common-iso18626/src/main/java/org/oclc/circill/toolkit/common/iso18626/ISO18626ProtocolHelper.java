/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.iso18626;

import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.ExceptionDescription;
import org.oclc.circill.toolkit.service.base.ProtocolHelper;
import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.iso18626.ErrorData;
import org.oclc.circill.toolkit.service.iso18626.ErrorType;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;
import org.oclc.circill.toolkit.service.iso18626.RequestConfirmationData;

import javax.xml.bind.DatatypeConverter;
import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * {@link ProtocolHelper} for ISO 18626.
 */
public class ISO18626ProtocolHelper implements ProtocolHelper<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> {

    private static final Logger LOG = Logger.getLogger(ISO18626ProtocolHelper.class);
    private static final int LENGTH_OF_DATA_LITERAL = "Data".length();

    @Override
    public String getMessageName(final ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> message) throws ToolkitInternalException {
        if (message.isInitiationMessage()) {
            return message.getRequestData().getMessageName();
        } else {
            return message.getConfirmationData().getMessageName();
        }
    }

    /**
     * Note that this implementation returns a {@link RequestConfirmationData} object - ideally the protocol would have an object to return in cases where the type of
     * input message was unknown (e.g. parse error), and we'd return that instead; but that is not possible as of the 2017 edition of ISO 18626.
     * This implementation sets the {@link ErrorType} to {@link ErrorType#BadlyFormedMessage} - ideally there would be an "other" value but not as of 2017.
     * This implementation sets the {@link ErrorData#errorValue} to a formatted rendering of the {@link ToolkitException#exceptionDescriptions} if the exception {@code e}
     * is a {@link ToolkitException}, otherwise to the exception message if there is one, otherwise to the exception class name.
     *
     * @param e an {@link Exception}
     * @return a {@link RequestConfirmationData} object
     */
    @Override
    public ISO18626ConfirmationData convertExceptionToResponse(final Exception e) {
        // TODO Work with ISO 18626 Maint Agency to figure out what confirmation message to return.
        // For now we're defaulting to RequestConfirmationData.
        final RequestConfirmationData requestConfirmationData = new RequestConfirmationData();
        final ErrorData errorData = new ErrorData();
        errorData.setErrorType(ErrorType.BadlyFormedMessage);
        final StringBuilder errorString = new StringBuilder();
        if (e instanceof ToolkitException && !((ToolkitException) e).getExceptionDescriptions().isEmpty()) {
            for (final ExceptionDescription ed : ((ToolkitException) e).getExceptionDescriptions()) {
                if (StringUtils.isNotBlank(ed.getExceptionDetail())) {
                    errorString.append("Detail: ").append(ed.getExceptionDetail());
                }
                if (StringUtils.isNotBlank(ed.getExceptionValue())) {
                    errorString.append("Value: ").append(ed.getExceptionValue());
                }
                if (StringUtils.isNotBlank(ed.getExceptionLocation())) {
                    errorString.append("Location: ").append(ed.getExceptionLocation());
                }
                if (StringUtils.isNotBlank(ed.getExceptionCodeScheme())) {
                    errorString.append("Error scheme: ").append(ed.getExceptionCodeScheme());
                }
                if (StringUtils.isNotBlank(ed.getExceptionCodeValue())) {
                    errorString.append("Error code: ").append(ed.getExceptionCodeValue());
                }
                errorString.append(System.lineSeparator());
            }
        } else {
            if (e.getLocalizedMessage() != null) {
                errorString.append("Exception message: ").append(e.getLocalizedMessage());
            } else if (e.getCause() != null) {
                errorString.append("Exception cause: ").append(e.getCause().getLocalizedMessage());
            } else {
                errorString.append("Exception: ").append(e.getClass().getName());
            }
        }
        errorData.setErrorValue(errorString.toString());

        requestConfirmationData.setErrorData(errorData);
        return requestConfirmationData;
    }

    @Override
    public ISO18626ConfirmationData createProblemResponse(final String msg, final ISO18626RequestData initiationData) {
        return null;
    }

    @Override
    public String returnProblem(final String detail) {
        return returnProblem(detail, null);
    }

    /**
     * Create a valid ISO18626 response indicating a problem, without relying on any facilities of the Toolkit.
     * This method is to be used when handling exceptions that indicate that the Toolkit itself may be failing to severely to return a valid response.
     *
     * @param detail         the text message to include in the ProblemDetail element
     * @param serviceContext the {@link ServiceContext} for this invocation of the service - not used in this implementation
     * @return a String containing an NCIP message with a Problem element describing the problem
     */
    @Override
    public String returnProblem(final String detail,
        final ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> serviceContext) {
        final String now = DatatypeConverter.printDateTime(Calendar.getInstance());
        final StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<ns1:ISO18626Message\n"
            + "        xmlns:ns1=\"http://illtransactions.org/2013/iso18626\" ns1:version=\"v1_2_2017\">\n" + "    <ns1:requestConfirmation>\n"
            + "        <ns1:confirmationHeader>\n" + "            <ns1:supplyingAgencyId>\n"
            + "                <ns1:agencyIdType ns1:scheme=\"http://illtransactions.org/ISO 18626/OpenCodeList/AgencyIdTypeList-V1.0\">ISIL</ns1:agencyIdType>\n"
            + "                <ns1:agencyIdValue>US-ocolcwe</ns1:agencyIdValue>\n" + "            </ns1:supplyingAgencyId>\n" + "            <ns1:requestingAgencyId>\n"
            + "                <ns1:agencyIdType ns1:scheme=\"http://illtransactions.org/ISO 18626/OpenCodeList/AgencyIdTypeList-V1.0\">ISIL</ns1:agencyIdType>\n"
            + "                <ns1:agencyIdValue>US-ocolcm</ns1:agencyIdValue>\n" + "            </ns1:requestingAgencyId>\n"
            + "            <ns1:timestamp>2018-02-08T08:34:54Z</ns1:timestamp>\n" + "            <ns1:requestingAgencyRequestId></ns1:requestingAgencyRequestId>\n"
            + "            <ns1:multipleItemRequestId></ns1:multipleItemRequestId>\n" + "            <ns1:timestampReceived>" + now + "</ns1:timestampReceived>\n"
            + "            <ns1:messageStatus>ERROR</ns1:messageStatus>\n" + "        </ns1:confirmationHeader>\n" + "        <ns1:errorData>\n"
            + "            <ns1:errorType>BadlyFormedMessage</ns1:errorType>\n" + "            <ns1:errorValue>" + detail + "</ns1:errorValue>\n" + "        </ns1:errorData>\n"
            + "    </ns1:requestConfirmation>\n" + "</ns1:ISO18626Message>\n\n");
        return sb.toString();
    }

    @Override
    public String returnException(final String msg, final Throwable e,
        final ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> serviceContext,
        final boolean includeStackTracesInProblemResponse, final boolean includeExceptionMessagesInProblemResponse) {
        final String response;
        LOG.debug("Returning Problem for this exception: ", e);
        if (includeStackTracesInProblemResponse) {
            response = returnProblem(
                ToolkitHelper.convertExceptionMessagesToString(msg, e) + System.lineSeparator() + "Stacktrace from responder:" + System.lineSeparator() + ToolkitHelper
                    .convertExceptionToString(e), serviceContext);
        } else if (includeExceptionMessagesInProblemResponse) {
            response = returnProblem(ToolkitHelper.convertExceptionMessagesToString(msg, e), serviceContext);
        } else {
            response = returnProblem("Exception occurred during processing", serviceContext);
        }
        return response;
    }

    @Override
    public ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> createServiceMessage(final ISO18626RequestData requestData) throws ToolkitInternalException {
        final ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> iso18626Message = new ISO18626Message<>();
        final String msgName = requestData.getMessageName();
        ReflectionHelper.setField(iso18626Message, requestData, msgName);
        return iso18626Message;
    }

    @Override
    public ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> createServiceMessage(final ISO18626ConfirmationData confirmationData) throws ToolkitInternalException {
        final ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> iso18626Message = new ISO18626Message<>();
        final String msgName = confirmationData.getMessageName();
        ReflectionHelper.setField(iso18626Message, confirmationData, msgName);
        return iso18626Message;
    }

    @Override
    public ISO18626RequestData getInitiationData(final ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> iso18626Message) throws ToolkitInternalException {
        return iso18626Message.getRequestData();
    }

    @Override
    public ISO18626ConfirmationData getResponseData(final ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> iso18626Message) throws ToolkitInternalException {
        return iso18626Message.getConfirmationData();
    }

    @Override
    public String getElementName(final Class<?> svcClass) {
        final String simpleName = svcClass.getSimpleName();
        final String elementName;
        if (simpleName
            .matches("(Request|RequestConfirmation|RequestingAgencyMessage|RequestingAgencyMessageConfirmation|SupplyingAgencyMessage|SupplyingAgencyMessageConfirmation)Data$")) {
            elementName = simpleName.substring(0, simpleName.length() - LENGTH_OF_DATA_LITERAL);
        } else {
            elementName = simpleName;
        }
        return elementName;
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

}
