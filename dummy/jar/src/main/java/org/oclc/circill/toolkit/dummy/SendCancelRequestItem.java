/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.common.base.ConfigurationHelper;
import org.oclc.circill.toolkit.common.base.MessageHandler;
import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.ToolkitComponent;
import org.oclc.circill.toolkit.common.ncip.NCIPProtocolHelper;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.CancelRequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestId;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import org.apache.log4j.Logger;

/**
 * Command line utility to send a simple CancelRequestItem message.
 */
public class SendCancelRequestItem {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SendCancelRequestItem.class);

    protected static final String USAGE_STRING = "Usage: SendCancelRequestItem agencyId reservationId";
    protected static final int NUMBER_OF_REQUIRED_PARMS = 2;

    private final MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> messageHandler;

    private final NCIPProtocolHelper protocolHelper;

    private final ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContextFactory;

    /**
     * Construct an instance.
     * @throws ConfigurationException if there's an error in the toolkit's configuration
     */
    public SendCancelRequestItem() throws ConfigurationException {
        messageHandler = ConfigurationHelper.getComponent(ToolkitComponent.MESSAGE_HANDLER_COMPONENT_NAME);
        protocolHelper = new NCIPProtocolHelper();
        serviceContextFactory = ConfigurationHelper.getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
    }

    /**
     * Perform the service.
     * @param agencyIdString the agency id
     * @param reservationId the reservation to cancel
     * @return the {@link NCIPResponseData}
     * @throws ServiceException if the external service call fails
     * @throws ToolkitInternalException if there is an internal problem in the Toolkit
     * @throws ConfigurationException if there's an error in the toolkit's configuration
     * @throws ValidationException if the initiation or response messages are invalide
     */
    public NCIPResponseData performService(final String agencyIdString, final String reservationId)
        throws ServiceException, ToolkitInternalException, ConfigurationException, ValidationException {
        final CancelRequestItemInitiationData initData = new CancelRequestItemInitiationData();
        final AgencyId agencyId = protocolHelper.createAgencyId(agencyIdString);
        final ToAgencyId toAgencyId = new ToAgencyId();
        toAgencyId.setAgencyId(agencyId);
        final FromAgencyId fromAgencyId = new FromAgencyId();
        fromAgencyId.setAgencyId(agencyId);
        final InitiationHeader initHeader = new InitiationHeader();
        initHeader.setToAgencyId(toAgencyId);
        initHeader.setFromAgencyId(fromAgencyId);
        initData.setInitiationHeader(initHeader);
        final RequestId requestId = new RequestId();
        requestId.setRequestIdentifierValue(reservationId);
        initData.setRequestId(requestId);

        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext = serviceContextFactory
            .getInitialServiceContext();

        final NCIPResponseData responseData = messageHandler.performService(initData, serviceContext);
        return responseData;
    }

    /**
     * Construct and send a CancelRequestItem message.
     * @param args command line arguments
     * @throws ConfigurationException if the Toolkit isn't configured correctly
     * @throws ToolkitInternalException if there's an internal error in the Toolkit
     * @throws ServiceException if the external service returns a failure
     * @throws ValidationException if the CancelRequestItem message or the CancelRequestItemResponse are invalid
     */
    public static void main(final String[] args) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {

        if (args == null || args.length < NUMBER_OF_REQUIRED_PARMS) {
            LOG.error("Error: Missing required parameter.");
            LOG.error(USAGE_STRING);
        } else if (args.length == NUMBER_OF_REQUIRED_PARMS) {
            final SendCancelRequestItem cancelRequestItemService = new SendCancelRequestItem();
            final NCIPResponseData responseData = cancelRequestItemService.performService(args[0], args[1]);
            LOG.info("Response: " + responseData);
        } else {
            LOG.error("Error: Too many parameters - found " + args.length + ", expecting " + NUMBER_OF_REQUIRED_PARMS + ".");
            LOG.error(USAGE_STRING);
        }
    }
}
