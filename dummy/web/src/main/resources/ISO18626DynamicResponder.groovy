/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

import org.oclc.circill.toolkit.dummy.web.DynamicConfigurableServiceHandler
import org.oclc.circill.toolkit.service.base.ServiceException
import org.oclc.circill.toolkit.service.base.ServiceInitiationData
import org.oclc.circill.toolkit.service.base.ServiceResponseData
import org.oclc.circill.toolkit.service.iso18626.*

class ISO18626DynamicResponder implements DynamicConfigurableServiceHandler {
    private List<String> options = Arrays.asList(
        "Respond OK",
        "Respond UnsupportedActionType",
        "Respond UnsupportedReasonForMessageType",
        "Respond UnrecognisedDataElement",
        "Respond UnrecognisedDataValue",
        "Respond BadlyFormedMessage",
        "Respond with un-caught exception")

    private String option = "Respond OK"

    boolean canHandle(ServiceInitiationData initiationData) {
        return initiationData instanceof ISO18626RequestData
    }

    ServiceResponseData handle(ServiceInitiationData initiationData) {
        final ISO18626ConfirmationData confirmationData
        if (initiationData instanceof RequestData) {
            confirmationData = new RequestConfirmationData()
        } else if (initiationData instanceof RequestingAgencyMessageData) {
            confirmationData = new RequestingAgencyMessageConfirmationData()
        } else if (initiationData instanceof SupplyingAgencyMessageData) {
            confirmationData = new SupplyingAgencyMessageConfirmationData()
        } else {
            throw new ServiceException(String.format("InitiationData is not an ISO message.", initiationData.getClass().getName()))
        }
        final Header header = ((ISO18626RequestData)initiationData).getHeader()
        final ConfirmationHeader confirmationHeader = new ConfirmationHeader()
        final ErrorData errorData = new ErrorData()
        final String currentOption = currentOption()
        if (currentOption.contains("OK")) {
            confirmationHeader.setMessageStatus(MessageStatus.OK)
        } else if (currentOption.contains("Respond with Exception")) {
            throw new IllegalArgumentException("Responder is configured to respond with exception")
        } else {
            confirmationHeader.setMessageStatus(MessageStatus.ERROR)
            errorData.setErrorType(ErrorType.valueOf(currentOption.replace("Respond", "").trim()))
            errorData.setErrorValue(currentOption)
            confirmationData.setErrorData(errorData)
        }
        confirmationHeader.setRequestingAgencyId(header.getRequestingAgencyId())
        confirmationHeader.setSupplyingAgencyId(header.getSupplyingAgencyId())
        confirmationHeader.setTimestamp(header.getTimestamp())
        confirmationHeader.setRequestingAgencyRequestId(header.getRequestingAgencyRequestId())
        confirmationHeader.setMultipleItemRequestId(header.getMultipleItemRequestId())
        confirmationHeader.setTimestampReceived(GregorianCalendar.newInstance())
        confirmationData.setConfirmationHeader(confirmationHeader)
        return confirmationData
    }

    @Override
    List<String> getOptions() {
        return options
    }

    @Override
    void setOption(final String description) throws IllegalArgumentException {
        if (options.contains(description)) {
            option = description
        } else {
            throw new IllegalArgumentException("The option is not supported by this handler")
        }
    }

    @Override
    String currentOption() {
        return option
    }
}
