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
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.LookupRequestInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupRequestResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupRequestService;
import org.oclc.circill.toolkit.service.ncip.Problem;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.Version1LookupRequestProcessingError;

import java.util.List;

/**
 * This class implements the Lookup Request service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. title, call #, etc.).
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyLookupRequestService extends BaseDummyService<LookupRequestInitiationData, LookupRequestResponseData> implements LookupRequestService {

    /**
     * Handles a NCIP LookupRequest service by returning hard-coded data.
     *
     * @param initData       the LookupRequestInitiationData
     * @param serviceManager provides access to remote services
     * @return LookupRequestResponseData
     */
    @Override
    public LookupRequestResponseData performService(final LookupRequestInitiationData initData, final ServiceContext serviceContext, final RemoteServiceManager serviceManager)
        throws ServiceException {

        final LookupRequestResponseData responseData = new LookupRequestResponseData();

        final DummyRemoteServiceManager dummySvcMgr = (DummyRemoteServiceManager) serviceManager;

        DummyDatabase.ItemInfo itemInfo = null;
        List<Problem> problems = null;

        if (initData.getItemId() != null && (initData.getUserId() != null || initData.getAuthenticationInputs() != null && !initData.getAuthenticationInputs().isEmpty())) {

            // Note: We don't validate the RequestType, despite its being required by NCIP.

            itemInfo = DummyDatabase.ItemInfo.getByBarcode(initData.getItemId().getItemIdentifierValue());
            if (itemInfo == null) {

                problems = NCIPProtocolHelper.generateProblems(Version1LookupRequestProcessingError.UNKNOWN_REQUEST, "LookupRequest", null,
                    "Item " + initData.getItemId().getItemIdentifierValue() + " not found.");

            } else if (itemInfo.userNo.compareToIgnoreCase(initData.getUserId().getUserIdentifierValue()) != 0) {

                problems = NCIPProtocolHelper.generateProblems(Version1LookupRequestProcessingError.UNKNOWN_REQUEST, "LookupRequest", null,
                    "Item " + initData.getItemId().getItemIdentifierValue() + " found but User " + initData.getUserId().getUserIdentifierValue() + " does not match.");

            }

        } else if (initData.getRequestId() != null) {

            final DummyDatabase.RequestInfo requestInfo = DummyDatabase.RequestInfo.getByRequestNo(initData.getRequestId().getRequestIdentifierValue());
            if (requestInfo != null) {
                itemInfo = DummyDatabase.ItemInfo.getByBarcode(requestInfo.itemBarcode);
                if (itemInfo == null) {
                    problems = NCIPProtocolHelper.generateProblems(Version1LookupRequestProcessingError.UNKNOWN_REQUEST, "LookupRequest", null,
                        "Item " + initData.getItemId().getItemIdentifierValue() + " not found.");
                }
            } else {
                problems = NCIPProtocolHelper.generateProblems(Version1LookupRequestProcessingError.UNKNOWN_REQUEST, "LookupRequest", null,
                    "Request " + initData.getRequestId().getRequestIdentifierValue() + " not found.");
            }

        } else {

            problems = NCIPProtocolHelper.generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "LookupRequest", null, "Either ItemId or RequestId is required.");

        }

        if (problems == null) {

            final ItemId itemId = new ItemId();
            itemId.setItemIdentifierValue(itemInfo != null ? itemInfo.barcode : null);
            responseData.setItemId(itemId);
            if (initData.getRequestId() != null) {
                responseData.setRequestId(initData.getRequestId());
            }

            final DummyDatabase.HoldingInfo holdingInfo = itemInfo != null ? itemInfo.holdingInfo : null;
            final DummyDatabase.BibInfo bibInfo = holdingInfo != null ? holdingInfo.bibInfo : null;

            try {
                responseData.setItemOptionalFields(DummyDatabase.populateItemOptionalFields(dummySvcMgr, bibInfo, holdingInfo, itemInfo));
            } catch (ToolkitInternalException | ConfigurationException e) {
                problems = NCIPProtocolHelper
                    .generateProblems(Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE, "LookupRequest", null, "Unknown logic or configuration error.");
                responseData.setProblems(problems);
            }

        } else {

            responseData.setProblems(problems);

        }

        return responseData;
    }

}
