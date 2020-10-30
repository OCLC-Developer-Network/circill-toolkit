/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.ncip.AcceptItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.AcceptItemResponseData;
import org.oclc.circill.toolkit.service.ncip.AcceptItemService;
import org.oclc.circill.toolkit.service.ncip.ItemId;

import java.util.UUID;

/**
 * This class implements the Accept Item service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. due date).
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyAcceptItemService extends BaseDummyService<AcceptItemInitiationData, AcceptItemResponseData> implements AcceptItemService {

    /**
     * Handles a NCIP AcceptItem service by returning hard-coded data.
     *
     * @param initData       the AcceptItemInitiationData
     * @param serviceManager provides access to remote services
     * @return AcceptItemResponseData
     */
    @Override
    @SuppressWarnings("PMD.UnusedLocalVariable")
    public AcceptItemResponseData performService(final AcceptItemInitiationData initData, final ServiceContext serviceContext, final RemoteServiceManager serviceManager) {

        final AcceptItemResponseData responseData = new AcceptItemResponseData();

        // Echo back the same request id that came in
        responseData.setRequestId(initData.getRequestId());

        // Generate an item barcode
        final ItemId itemId = new ItemId();
        itemId.setAgencyId(initData.getInitiationHeader().getToAgencyId().getAgencyId());
        itemId.setItemIdentifierValue(UUID.randomUUID().toString());
        responseData.setItemId(itemId);

        return responseData;
    }

}
