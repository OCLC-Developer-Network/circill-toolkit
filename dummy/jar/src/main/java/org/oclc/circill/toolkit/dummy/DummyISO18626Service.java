/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.iso18626.ConfirmationHeader;
import org.oclc.circill.toolkit.service.iso18626.Header;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;
import org.oclc.circill.toolkit.service.iso18626.MessageStatus;
import org.oclc.circill.toolkit.service.iso18626.RequestConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.RequestData;
import org.oclc.circill.toolkit.service.iso18626.RequestingAgencyMessageConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.RequestingAgencyMessageData;
import org.oclc.circill.toolkit.service.iso18626.SupplyingAgencyMessageConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.SupplyingAgencyMessageData;

import java.util.Calendar;

/**
 * An ISO 18626 {@link Service} that responds OK to all messages.
 */
public class DummyISO18626Service implements Service<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> {

    @Override
    public ISO18626ConfirmationData performService(final ISO18626RequestData initiationData,
        final ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> serviceContext,
        final RemoteServiceManager serviceManager) throws ServiceException, ValidationException {

        final Header header = initiationData.getHeader();
        final ConfirmationHeader confirmationHeader = new ConfirmationHeader();
        confirmationHeader.setTimestampReceived(header.getTimestamp());
        confirmationHeader.setTimestamp(Calendar.getInstance());
        confirmationHeader.setMultipleItemRequestId(""); // Bug in ISO 18626 schema - this field should be optional
        confirmationHeader.setSupplyingAgencyId(header.getSupplyingAgencyId());
        confirmationHeader.setRequestingAgencyId(header.getRequestingAgencyId());
        confirmationHeader.setMessageStatus(MessageStatus.OK);
        confirmationHeader.setRequestingAgencyRequestId(header.getRequestingAgencyRequestId());

        final ISO18626ConfirmationData confirmationData;

        if (initiationData instanceof RequestData) {
            confirmationData = new RequestConfirmationData();
        } else if (initiationData instanceof RequestingAgencyMessageData) {
            final RequestingAgencyMessageData requestingAgencyMessageData = (RequestingAgencyMessageData) initiationData;
            final RequestingAgencyMessageConfirmationData requestingAgencyMessageConfirmationData = new RequestingAgencyMessageConfirmationData();
            requestingAgencyMessageConfirmationData.setAction(requestingAgencyMessageData.getAction());
            confirmationData = requestingAgencyMessageConfirmationData;
        } else if (initiationData instanceof SupplyingAgencyMessageData) {
            final SupplyingAgencyMessageData supplyingAgencyMessageData = (SupplyingAgencyMessageData) initiationData;
            final SupplyingAgencyMessageConfirmationData supplyingAgencyMessageConfirmationData = new SupplyingAgencyMessageConfirmationData();
            supplyingAgencyMessageConfirmationData.setReasonForMessage(supplyingAgencyMessageData.getMessageInfo().getReasonForMessage());
            confirmationData = supplyingAgencyMessageConfirmationData;
        } else {
            throw new IllegalArgumentException("InitiationData parameter is not an instance of RequestData, RequestingAgencyMessageData or SupplyingAgencyMessageData.");
        }
        confirmationData.setConfirmationHeader(confirmationHeader);
        return confirmationData;
    }
}
