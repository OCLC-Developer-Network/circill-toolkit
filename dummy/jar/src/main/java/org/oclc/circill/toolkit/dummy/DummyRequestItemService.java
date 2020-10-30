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
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.BibliographicRecordId;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.RequestId;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestItemService;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.Version1BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.Version1RequestItemProcessingError;
import org.oclc.circill.toolkit.service.ncip.Version1RequestScopeType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Request Item service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. request id) and responds that the hold
 * was a success.
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyRequestItemService extends BaseDummyService<RequestItemInitiationData, RequestItemResponseData> implements RequestItemService {

    /**
     * Handles a NCIP RequestItem service by returning hard-coded data. This only looks for the first
     * item or bib id.
     *
     * @param initData       the RequestItemInitiationData
     * @param serviceManager provides access to remote services
     * @return RequestItemResponseData
     */
    @Override
    public RequestItemResponseData performService(final RequestItemInitiationData initData, final ServiceContext serviceContext, final RemoteServiceManager serviceManager) {

        final RequestItemResponseData responseData = new RequestItemResponseData();

        final DummyRemoteServiceManager dummySvcMgr = (DummyRemoteServiceManager) serviceManager;

        DummyDatabase.ItemInfo chosenItem = null;

        // Get userNo
        String userNo = null;
        final UserId userId = initData.getUserId();
        if (userId != null) {

            userNo = userId.getUserIdentifierValue();

        }

        List<DummyDatabase.BibInfo> bibInfos = null;
        if (userNo != null) {

            if (initData.getBibliographicIds() != null && !initData.getBibliographicIds().isEmpty() && initData.getBibliographicIds().get(0).getBibliographicRecordId() != null) {

                final BibliographicRecordId bibliographicRecordId = initData.getBibliographicIds().get(0).getBibliographicRecordId();

                if (bibliographicRecordId.getBibliographicRecordIdentifierCode() != null && bibliographicRecordId.getBibliographicRecordIdentifierCode()
                    .equals(Version1BibliographicRecordIdentifierCode.OCLC)) {

                    bibInfos = DummyDatabase.BibInfo.getBibsByOCLCNo(bibliographicRecordId.getBibliographicRecordIdentifier());

                } else if (bibliographicRecordId.getAgencyId() != null && bibliographicRecordId.getAgencyId().equals(dummySvcMgr.getAgencyId())) {

                    final DummyDatabase.BibInfo bibInfo = DummyDatabase.BibInfo.getByBibNo(bibliographicRecordId.getBibliographicRecordIdentifier());

                    if (bibInfo != null) {

                        bibInfos = new ArrayList<>();
                        bibInfos.add(bibInfo);

                    }

                }

                if (bibInfos != null) {

                    for (final DummyDatabase.BibInfo bibInfo : bibInfos) {

                        for (final DummyDatabase.HoldingInfo holdingInfo : bibInfo.holdings) {

                            final DummyDatabase.ItemInfo[] itemInfos = holdingInfo.items;
                            if (itemInfos != null && itemInfos.length > 0) {

                                for (final DummyDatabase.ItemInfo itemInfo : itemInfos) {

                                    if (itemInfo.circStatus == DummyDatabase.CircStatus.ON_SHELF) {

                                        chosenItem = itemInfos[0];
                                        break;

                                    }

                                }

                            }

                            if (chosenItem != null) {

                                break;

                            }

                        }

                        if (chosenItem != null) {

                            break;

                        }

                    }

                }

            } else if (initData.getItemIds() != null && !initData.getItemIds().isEmpty()) {

                final DummyDatabase.ItemInfo itemInfo = DummyDatabase.ItemInfo.getByBarcode(initData.getItemIds().get(0).getItemIdentifierValue());

                if (itemInfo != null && itemInfo.circStatus == DummyDatabase.CircStatus.ON_SHELF) {

                    chosenItem = itemInfo;

                }

            }

            if (chosenItem != null) {

                final String incomingRequestNo = initData.getRequestId() != null ? initData.getRequestId().getRequestIdentifierValue() : null;
                final String incomingPickupLoc = initData.getPickupLocation() != null ? initData.getPickupLocation().getValue() : null;

                final DummyDatabase.RequestInfo requestInfo;
                try {
                    requestInfo = chosenItem.placeOnHold(incomingRequestNo, userNo, incomingPickupLoc);

                    responseData.setUserId(initData.getUserId());
                    responseData.setRequestScopeType(Version1RequestScopeType.ITEM);
                    responseData.setRequestType(initData.getRequestType());

                    final String requestIdString;
                    if (initData.getRequestId() != null) {

                        requestIdString = initData.getRequestId().getRequestIdentifierValue();

                    } else {

                        requestIdString = requestInfo.requestNo;

                    }
                    final RequestId requestId = new RequestId();
                    requestId.setRequestIdentifierValue(requestIdString);
                    responseData.setRequestId(requestId);

                    responseData.setHoldQueuePosition(BigDecimal.ONE);

                    responseData.setDateAvailable(requestInfo.pickupStart);

                    final ItemId itemId = new ItemId();
                    itemId.setItemIdentifierValue(requestInfo.itemBarcode);
                    responseData.setItemId(itemId);

                } catch (ToolkitException e) {

                    responseData.setProblems(protocolHelper.generateProblems(Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE, null, null, null, e));

                }
            } else {

                if (initData.getBibliographicIds() != null && !initData.getBibliographicIds().isEmpty()
                    && initData.getBibliographicIds().get(0).getBibliographicRecordId() != null) {

                    if (bibInfos != null && !bibInfos.isEmpty()) {

                        responseData.setProblems(protocolHelper.generateProblems(Version1RequestItemProcessingError.ITEM_NOT_AVAILABLE_BY_NEED_BEFORE_DATE, "//BibliographicId",
                            initData.getBibliographicIds().get(0).getBibliographicRecordId().getBibliographicRecordIdentifier(), "No items are on shelf."));

                    } else {

                        responseData.setProblems(protocolHelper.generateProblems(Version1RequestItemProcessingError.UNKNOWN_ITEM, "//BibliographicId",
                            initData.getBibliographicIds().get(0).getBibliographicRecordId().getBibliographicRecordIdentifier(), "No matching bib record."));
                    }

                } else if (initData.getItemIds() != null && !initData.getItemIds().isEmpty()) {

                    responseData.setProblems(protocolHelper
                        .generateProblems(Version1RequestItemProcessingError.UNKNOWN_ITEM, "//ItemId", initData.getItemIds().get(0).getItemIdentifierValue(),
                            "No matching item record."));

                } else {

                    responseData.setProblems(protocolHelper
                        .generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "//ItemId | //BibliographicId", null, "No bib or item record id supplied."));

                }

            }
        } else {

            responseData.setProblems(protocolHelper.generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "//UserId", null, "No user id."));

        }

        return responseData;
    }

}
