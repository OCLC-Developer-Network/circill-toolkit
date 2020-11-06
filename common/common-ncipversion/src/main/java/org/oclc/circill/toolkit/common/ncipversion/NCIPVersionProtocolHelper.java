/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncipversion;

import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.ProtocolHelper;
import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionInitiationData;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionResponseData;
import org.oclc.circill.toolkit.service.ncipversion.NCIPVersionMessage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Collections;

import org.apache.log4j.Logger;

/**
 * {@link ProtocolHelper} for NCIP Version service.
 */
public class NCIPVersionProtocolHelper
    implements ProtocolHelper<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> {

    private static final Logger LOG = Logger.getLogger(NCIPVersionProtocolHelper.class);

    private static final String INITIATION_DATA_SUFFIX = "InitiationData";
    private static final int LENGTH_OF_INITIATION_DATA_LITERAL = INITIATION_DATA_SUFFIX.length();
    private static final int LENGTH_OF_DATA_LITERAL = "Data".length();

    @Override
    public String getMessageName(final NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> message) throws ToolkitInternalException {
        if (message.isInitiationMessage()) {
            return message.getInitiationData().getMessageName();
        } else {
            return message.getResponseData().getMessageName();
        }
    }

    @Override
    public LookupVersionResponseData convertExceptionToResponse(final Exception e) {
        return createProblemResponse("Internal error processing LookupVersion service.", null);
    }

    @Override
    public LookupVersionResponseData createProblemResponse(final String msg, final LookupVersionInitiationData initiationData) {
        final LookupVersionResponseData problemResponseData = new LookupVersionResponseData();
        problemResponseData.setServiceSupporteds(Collections.singletonList(msg));
        return problemResponseData;
    }

    @Override
    public NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> createServiceMessage(final LookupVersionInitiationData initiationData)
        throws ToolkitInternalException {
        final NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> ncipMessage = new NCIPVersionMessage<>();
        final String msgName = initiationData.getMessageName();
        ReflectionHelper.setField(ncipMessage, initiationData, msgName);
        return ncipMessage;
    }

    @Override
    public NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> createServiceMessage(final LookupVersionResponseData responseData)
        throws ToolkitInternalException {
        final NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> ncipMessage = new NCIPVersionMessage<>();
        final String msgName = responseData.getMessageName();
        ReflectionHelper.setField(ncipMessage, responseData, msgName);
        return ncipMessage;
    }

    @Override
    public LookupVersionInitiationData getInitiationData(final NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> ncipMessage)
        throws ToolkitInternalException {
        return ncipMessage.getInitiationData();
    }

    @Override
    public LookupVersionResponseData getResponseData(final NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> ncipMessage) throws ToolkitInternalException {
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
     * Note: Because the LookupVersionResponse does not support a Problem element, the problem is returned in the VersionSupported element.
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
     * This method is to be used when handling exceptions that
     * indicate that the Toolkit itself may be failing to severely to return a valid response.
     * Note: Because the LookupVersionResponse does not support a Problem element, the problem is returned in the VersionSupported element.
     *
     * @param detail         the text message to include in the ProblemDetail element
     * @param serviceContext the {@link ServiceContext} for this invocation of the service - not used in this implementation
     * @return a String containing an NCIP message with a Problem element describing the problem
     */
    @Override
    public String returnProblem(final String detail,
        final ServiceContext<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> serviceContext) {

        final StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n").append("<NCIPVersionMessage version=\"http://www.niso.org/ncip/v1_0/imp1/xsd/ncip_version.xsd\">\n")
            .append("<LookupVersionResponse>\n").append("<FromAgencyId>\n").append("<UniqueAgencyId>\n").append("<Scheme>Unknown</Scheme>\n").append("<Value>Unknown</Value>\n")
            .append("</UniqueAgencyId>\n").append("</FromAgencyId>\n").append("<ToAgencyId>\n").append("<UniqueAgencyId>\n").append("<Scheme>Unknown</Scheme>\n")
            .append("<Value>Unknown</Value>\n").append("</UniqueAgencyId>\n").append("</ToAgencyId>\n")
            .append("<VersionSupported>This is the problem - no data</VersionSupported>\n").append("</LookupVersionResponse>\n").append("</NCIPVersionMessage>\n");
        return sb.toString();

    }

    @Override
    public String returnException(final String msg, final Throwable e,
        final ServiceContext<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> serviceContext,
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
