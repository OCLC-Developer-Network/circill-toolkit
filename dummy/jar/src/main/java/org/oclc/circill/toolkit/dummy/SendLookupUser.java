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
import org.oclc.circill.toolkit.service.ncip.LookupUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import org.apache.log4j.Logger;

/**
 * Command line utility to send a simple LookkupUser message.
 */
public class SendLookupUser {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SendLookupUser.class);
    /** Description of usage. */
    protected static final String USAGE_STRING = "Usage: SendLookupUser agencyId userId";
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
    public SendLookupUser() throws ConfigurationException {
        messageHandler = ConfigurationHelper.getComponent(ToolkitComponent.MESSAGE_HANDLER_COMPONENT_NAME);
        serviceContextFactory = ConfigurationHelper.getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
    }

    /**
     * Perform the service.
     * @param agencyIdString the agency id
     * @param userIdString the user id of the user to look up
     * @return the {@link NCIPResponseData}
     * @throws ServiceException if the external service call fails
     * @throws ToolkitInternalException if there is an internal problem in the Toolkit
     * @throws ConfigurationException if there's an error in the toolkit's configuration
     * @throws ValidationException if the initiation or response messages are invalide
     */
    public NCIPResponseData performService(final String agencyIdString, final String userIdString)
        throws ServiceException, ConfigurationException, ValidationException, ToolkitInternalException {
        final LookupUserInitiationData initData = new LookupUserInitiationData();
        final AgencyId agencyId = new AgencyId(agencyIdString);
        final InitiationHeader initHdr = new InitiationHeader();
        final ToAgencyId toAgencyId = new ToAgencyId();
        toAgencyId.setAgencyId(agencyId);
        initHdr.setToAgencyId(toAgencyId);
        final FromAgencyId fromAgencyId = new FromAgencyId();
        fromAgencyId.setAgencyId(agencyId);
        initHdr.setFromAgencyId(fromAgencyId);
        initData.setInitiationHeader(initHdr);
        final UserId userId = new UserId();
        userId.setAgencyId(agencyId);
        userId.setUserIdentifierValue(userIdString);
        initData.setUserId(userId);
        initData.setLoanedItemsDesired(true);
        initData.setRequestedItemsDesired(true);
        initData.setUserFiscalAccountDesired(true);

        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext = serviceContextFactory
            .getInitialServiceContext();

        final NCIPResponseData responseData = messageHandler.performService(initData, serviceContext);
        return responseData;
    }

    /**
     * Construct and send a LookupUser message.
     * @param args command line arguments
     * @throws ConfigurationException if the Toolkit isn't configured correctly
     * @throws ToolkitInternalException if there's an internal error in the Toolkit
     * @throws ServiceException if the external service returns a failure
     * @throws ValidationException if the LookupUser message or the LookupUserResponse are invalid
     */
    public static void main(final String[] args) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {

        if (args == null || args.length < NUMBER_OF_REQUIRED_PARMS) {
            LOG.error("Error: Missing required parameter.");
            LOG.error(USAGE_STRING);
        } else if (args.length == NUMBER_OF_REQUIRED_PARMS) {
            final SendLookupUser lookupUserService = new SendLookupUser();
            final NCIPResponseData responseData = lookupUserService.performService(args[0], args[1]);
            LOG.info("Response: " + responseData);
        } else {
            LOG.error("Error: Too many parameters - found " + args.length + ", expecting " + NUMBER_OF_REQUIRED_PARMS + ".");
            LOG.error(USAGE_STRING);
        }
    }
}
