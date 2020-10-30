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
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RenewItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.UserId;

import org.apache.log4j.Logger;

/**
 * Command line utility to send a simple RenewItem message.
 */
public class SendRenewItem {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SendRenewItem.class);
    /** Description of usage. */
    protected static final String USAGE_STRING = "Usage: SendRenewItem itemId userId";
    /** The number of required parameters. */
    protected static final int NUMBER_OF_REQUIRED_PARMS = 2;
    /** The {@link MessageHandler}. */
    private final MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> messageHandler;
    /** The {@link ServiceContextFactory}. */
    private final ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContextFactory;

    /**
     * Construct an instance.
     * @throws ConfigurationException if there's an error in the toolkit's configuration
     */
    public SendRenewItem() throws ConfigurationException {
        messageHandler = ConfigurationHelper.getComponent(ToolkitComponent.MESSAGE_HANDLER_COMPONENT_NAME);
        serviceContextFactory = ConfigurationHelper.getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
    }

    /**
     * Perform the service.
     * @param itemIdentifier the identifier of the item to renew
     * @param userIdentifier the identifier of the user to whom the item is presently checked-out
     * @return the {@link NCIPResponseData}
     * @throws ServiceException if the external service call fails
     * @throws ToolkitInternalException if there is an internal problem in the Toolkit
     * @throws ConfigurationException if there's an error in the toolkit's configuration
     * @throws ValidationException if the initiation or response messages are invalide
     */
    public NCIPResponseData performService(final String itemIdentifier, final String userIdentifier)
        throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {
        final RenewItemInitiationData initData = new RenewItemInitiationData();
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue(itemIdentifier);
        initData.setItemId(itemId);
        final UserId userId = new UserId();
        userId.setUserIdentifierValue(userIdentifier);
        initData.setUserId(userId);

        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext = serviceContextFactory
            .getInitialServiceContext();
        final NCIPResponseData responseData = messageHandler.performService(initData, serviceContext);
        return responseData;
    }

    /**
     * Construct and send a RenewItem message.
     * @param args command line arguments
     * @throws ConfigurationException if the Toolkit isn't configured correctly
     * @throws ToolkitInternalException if there's an internal error in the Toolkit
     * @throws ServiceException if the external service returns a failure
     * @throws ValidationException if the RenewItem message or the RenewItemResponse are invalid
     */
    public static void main(final String[] args) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {
        if (args == null || args.length < 2) {
            LOG.error("Error: Missing required parameter 'itemIdentifier', 'userIdentifier', or both.");
            LOG.error("Usage: SendRenewItem itemIdentifier userIdentifier");
        } else if (args.length == 2) {
            final SendRenewItem sendRenewItemService = new SendRenewItem();
            final NCIPResponseData responseData = sendRenewItemService.performService(args[0], args[1]);
            LOG.info("Response: " + responseData);
        } else {
            LOG.error("Error: Too many parameters - found " + args.length + ", expecting 2.");
            LOG.error("Usage: SendRenewItem itemIdentifier userIdentifier");
        }
    }
}
