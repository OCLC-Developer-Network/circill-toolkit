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
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.UpdateRequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.UpdateRequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.UpdateRequestItemService;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.Version1RequestScopeType;

/**
 * This class implements the Request Item service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. request id) and responds that the hold
 * was a success.
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyUpdateRequestItemService extends BaseDummyService<UpdateRequestItemInitiationData, UpdateRequestItemResponseData> implements UpdateRequestItemService {

    /**
     * Handles a NCIP UpdateRequestItem service by returning hard-coded data. This only looks for the first
     * item or bib id.
     *
     * @param initData       the UpdateRequestItemInitiationData
     * @param serviceManager provides access to remote services
     * @return UpdateRequestItemResponseData
     */
    @Override
    @SuppressWarnings("PMD.UnusedLocalVariable")
    public UpdateRequestItemResponseData performService(final UpdateRequestItemInitiationData initData, final ServiceContext serviceContext,
        final RemoteServiceManager serviceManager) {

        final UpdateRequestItemResponseData responseData = new UpdateRequestItemResponseData();

        responseData.setUserId(initData.getUserId());

        final ItemId itemId;
        if (initData.getRequestId() != null) {

            // Make up an item id
            final String itemIdString = "1209381209";
            itemId = new ItemId();
            itemId.setItemIdentifierValue(itemIdString);

        } else {

            itemId = initData.getItemId();

        }

        if (itemId != null) {

            responseData.setItemId(itemId);
            if (initData.getRequestType() != null) {

                responseData.setRequestType(initData.getRequestType());
                responseData.setRequestScopeType(Version1RequestScopeType.ITEM);

            } else {

                responseData.setProblems(
                    protocolHelper.generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "//RequestType", null, "RequestType is required if RequestId is omitted."));

            }

        } else {

            responseData.setProblems(
                protocolHelper.generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "//RequestId or //ItemId", null, "RequestId or ItemId is required."));

        }

        return responseData;
    }

}
