/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
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
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.CheckInItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

import org.apache.log4j.Logger;

/**
 * Command line utility to send a simple CheckInItem message.
 */
public class SendCheckInItem {

    private static final Logger LOG = Logger.getLogger(SendCheckInItem.class);

    private final MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> messageHandler;

    private final ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContextFactory;

    /**
     * Construct an instance.
     * @throws ConfigurationException if there's an error in the toolkit's configuration
     */
    public SendCheckInItem() throws ConfigurationException {
        messageHandler = ConfigurationHelper.getComponent(ToolkitComponent.MESSAGE_HANDLER_COMPONENT_NAME);
        serviceContextFactory = ConfigurationHelper.getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
    }

    /**
     * Perform the service.
     * @param itemIdentifier the item identifier
     * @return the {@link NCIPResponseData}
     * @throws ServiceException if the external service call fails
     * @throws ToolkitInternalException if there is an internal problem in the Toolkit
     * @throws ConfigurationException if there's an error in the toolkit's configuration
     * @throws ValidationException if the initiation or response messages are invalide
     */
    public NCIPResponseData performService(final String itemIdentifier) throws ServiceException, ToolkitInternalException, ConfigurationException, ValidationException {

        final CheckInItemInitiationData initData = new CheckInItemInitiationData();
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue(itemIdentifier);
        initData.setItemId(itemId);

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

        if (args == null || args.length < 1) {
            LOG.error("Error: Missing required parameter 'itemIdentifier'.");
            LOG.error("Usage: SendCheckInItem itemIdentifier");
        } else if (args.length == 1) {
            final SendCheckInItem checkInItemService = new SendCheckInItem();
            final NCIPResponseData responseData = checkInItemService.performService(args[0]);
            LOG.info("Response: " + responseData);
        } else {
            LOG.error("Error: Too many parameters - found " + args.length + ", expecting 1.");
            LOG.error("Usage: SendCheckInItem itemIdentifier");

        }
    }
}
