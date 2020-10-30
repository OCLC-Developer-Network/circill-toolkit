/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.common.ncip.NCIPProtocolHelper;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.LookupItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupItemResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupItemService;
import org.oclc.circill.toolkit.service.ncip.Problem;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.Version1LookupItemProcessingError;

import java.util.List;

/**
 * This class implements the Lookup Item service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. title, call #, etc.).
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyLookupItemService extends BaseDummyService<LookupItemInitiationData, LookupItemResponseData> implements LookupItemService {

    /**
     * Handles a NCIP LookupItem service by returning hard-coded data.
     *
     * @param initData       the LookupItemInitiationData
     * @param serviceManager provides access to remote services
     * @return LookupItemResponseData
     */
    @Override
    public LookupItemResponseData performService(final LookupItemInitiationData initData, final ServiceContext serviceContext, final RemoteServiceManager serviceManager) {

        final LookupItemResponseData responseData = new LookupItemResponseData();

        final DummyRemoteServiceManager dummySvcMgr = (DummyRemoteServiceManager) serviceManager;

        DummyDatabase.ItemInfo itemInfo = null;
        List<Problem> problems = null;

        if (initData.getItemId() != null) {

            itemInfo = DummyDatabase.ItemInfo.getByBarcode(initData.getItemId().getItemIdentifierValue());
            if (itemInfo == null) {
                problems = protocolHelper
                    .generateProblems(Version1LookupItemProcessingError.UNKNOWN_ITEM, "LookupItem", null, "Item " + initData.getItemId().getItemIdentifierValue() + " not found.");
            }

        } else if (initData.getRequestId() != null) {

            final DummyDatabase.RequestInfo requestInfo = DummyDatabase.RequestInfo.getByRequestNo(initData.getRequestId().getRequestIdentifierValue());
            if (requestInfo != null) {
                itemInfo = DummyDatabase.ItemInfo.getByBarcode(requestInfo.itemBarcode);
                if (itemInfo == null) {
                    problems = protocolHelper.generateProblems(Version1LookupItemProcessingError.UNKNOWN_ITEM, "LookupItem", null,
                        "Item " + initData.getItemId().getItemIdentifierValue() + " not found.");
                }
            } else {
                problems = protocolHelper.generateProblems(Version1LookupItemProcessingError.UNKNOWN_ITEM, "LookupItem", null,
                    "Request " + initData.getRequestId().getRequestIdentifierValue() + " not found.");
            }

        } else {

            problems = protocolHelper.generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "LookupItem", null, "Either ItemId or RequestId is required.");

        }

        if (itemInfo != null) {

            final ItemId itemId = new ItemId();
            itemId.setItemIdentifierValue(itemInfo.barcode);
            responseData.setItemId(itemId);
            if (initData.getRequestId() != null) {
                responseData.setRequestId(initData.getRequestId());
            }

            final DummyDatabase.HoldingInfo holdingInfo = itemInfo.holdingInfo;
            final DummyDatabase.BibInfo bibInfo = holdingInfo.bibInfo;

            try {
                responseData.setItemOptionalFields(DummyDatabase.populateItemOptionalFields(dummySvcMgr, bibInfo, holdingInfo, itemInfo));
            } catch (ToolkitInternalException | ConfigurationException e) {
                problems = protocolHelper
                    .generateProblems(Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE, "LookupItem", null, "Unknown logic or configuration error.");
                responseData.setProblems(problems);
            }

        } else if (problems == null) {

            problems = protocolHelper.generateProblems(Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE, "LookupItem", null, "Unknown logic error.");
            responseData.setProblems(problems);

        } else {

            responseData.setProblems(problems);

        }

        return responseData;
    }

    @Override
    public NCIPProtocolHelper getProtocolHelper() {
        return protocolHelper;
    }

    @Override
    public void setProtocolHelper(final NCIPProtocolHelper protocolHelper) {
        this.protocolHelper = protocolHelper;
    }

}
