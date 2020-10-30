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
import org.oclc.circill.toolkit.service.base.BibliographicItemId;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.BibliographicId;
import org.oclc.circill.toolkit.service.ncip.BibliographicRecordId;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.Version1BibliographicItemIdentifierCode;
import org.oclc.circill.toolkit.service.ncip.Version1BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.ncip.Version1RequestScopeType;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Command line utility to send a simple RequestItem message.
 */
public class SendRequestItem {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SendRequestItem.class);
    /** Description of usage. */
    protected static final String USAGE_STRING = "Usage: SendRequestItem agencyId targetId targetIdType userIdentifier";
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
    public SendRequestItem() throws ConfigurationException {
        messageHandler = ConfigurationHelper.getComponent(ToolkitComponent.MESSAGE_HANDLER_COMPONENT_NAME);
        serviceContextFactory = ConfigurationHelper.getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
    }

    /**
     * Perform the service.
     * @param agencyIdString the identifier of the agency at which the request will be made
     * @param bibRecordId the bibliographic record identifier
     * @param bibRecordIdType the type of bibliographic record identifier: localctrlno, oclc, ibsn or barcode
     * @param userIdentifier the identifier of the user to whom the item is presently checked-out
     * @return the {@link NCIPResponseData}
     * @throws ServiceException if the external service call fails
     * @throws ToolkitInternalException if there is an internal problem in the Toolkit
     * @throws ConfigurationException if there's an error in the toolkit's configuration
     * @throws ValidationException if the initiation or response messages are invalide
     */
    public NCIPResponseData performService(final String agencyIdString, final String bibRecordId, final String bibRecordIdType, final String userIdentifier)
        throws ServiceException, ValidationException, ToolkitInternalException, ConfigurationException {

        final RequestItemInitiationData initData = new RequestItemInitiationData();
        final AgencyId agencyId = new AgencyId(agencyIdString);
        final List<BibliographicId> bibIdList = createBibRecordId(agencyId, bibRecordId, bibRecordIdType);
        initData.setBibliographicIds(bibIdList);
        final UserId userId = new UserId();
        userId.setUserIdentifierValue(userIdentifier);
        initData.setUserId(userId);
        initData.setRequestScopeType(Version1RequestScopeType.BIBLIOGRAPHIC_ITEM);

        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext = serviceContextFactory
            .getInitialServiceContext();

        final NCIPResponseData responseData = messageHandler.performService(initData, serviceContext);
        return responseData;
    }

    private List<BibliographicId> createBibRecordId(final AgencyId agencyId, final String bibRecordId, final String bibRecordIdType) throws ServiceException {
        final List<BibliographicId> bibIdList = new ArrayList<>();
        if (bibRecordIdType.compareToIgnoreCase("localctrlno") == 0) {
            final BibliographicId bibId = new BibliographicId();
            final BibliographicRecordId bibRecId = new BibliographicRecordId();
            bibRecId.setBibliographicRecordIdentifier(bibRecordId);
            bibRecId.setAgencyId(agencyId);
            bibId.setBibliographicRecordId(bibRecId);
            bibIdList.add(bibId);
        } else if (bibRecordIdType.compareToIgnoreCase("oclc") == 0) {
            final BibliographicId bibId = new BibliographicId();
            final BibliographicRecordId bibRecId = new BibliographicRecordId();
            bibRecId.setBibliographicRecordIdentifier(bibRecordId);
            bibRecId.setBibliographicRecordIdentifierCode(Version1BibliographicRecordIdentifierCode.OCLC);
            bibId.setBibliographicRecordId(bibRecId);
            bibIdList.add(bibId);
        } else if (bibRecordIdType.compareToIgnoreCase("isbn") == 0) {
            final BibliographicId bibId = new BibliographicId();
            final BibliographicItemId bibItemId = new BibliographicItemId();
            bibItemId.setBibliographicItemIdentifier(bibRecordId);
            bibItemId.setBibliographicItemIdentifierCode(Version1BibliographicItemIdentifierCode.ISBN);
            bibId.setBibliographicItemId(bibItemId);
            bibIdList.add(bibId);
        } else if (bibRecordIdType.compareToIgnoreCase("barcode") == 0) {
            final ItemId itemId = new ItemId();
            itemId.setItemIdentifierValue(bibRecordId);
            final List<ItemId> itemIdList = new ArrayList<>();
            itemIdList.add(itemId);
        } else {
            throw new ServiceException("Unrecognized bibRecordIdType of '" + bibRecordIdType + "'.");
        }
        return bibIdList;
    }

    /**
     * Construct and send a RequestItem message.
     * @param args command line arguments
     * @throws ConfigurationException if the Toolkit isn't configured correctly
     * @throws ToolkitInternalException if there's an internal error in the Toolkit
     * @throws ServiceException if the external service returns a failure
     * @throws ValidationException if the RequestItem message or the RequestItemResponse are invalid
     */
    public static void main(final String[] args) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {
        if (args == null || args.length < 4) {
            LOG.error("Error: Missing required parameter.");
            LOG.error(USAGE_STRING);
        } else if (args.length == 4) {
            final SendRequestItem sendReequestItemService = new SendRequestItem();
            final NCIPResponseData responseData = sendReequestItemService.performService(args[0], args[1], args[2], args[3]);
            LOG.info("Response: " + responseData);
        } else {
            LOG.error("Error: Too many parameters - found " + args.length + ", expecting 4.");
            LOG.error(USAGE_STRING);
        }
    }
}
