/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.ncip.BibInformation;
import org.oclc.circill.toolkit.service.ncip.BibliographicDescription;
import org.oclc.circill.toolkit.service.ncip.BibliographicId;
import org.oclc.circill.toolkit.service.ncip.BibliographicRecordId;
import org.oclc.circill.toolkit.service.ncip.CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.HoldingsInformation;
import org.oclc.circill.toolkit.service.ncip.HoldingsSet;
import org.oclc.circill.toolkit.service.ncip.ItemDescription;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.ItemInformation;
import org.oclc.circill.toolkit.service.ncip.ItemOptionalFields;
import org.oclc.circill.toolkit.service.ncip.LookupItemSetInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupItemSetResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupItemSetService;
import org.oclc.circill.toolkit.service.ncip.Version1BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.ncip.Version1CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.Version1LookupItemProcessingError;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements the Lookup Item Set service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. title, call #, etc.).
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyLookupItemSetService extends BaseDummyService<LookupItemSetInitiationData, LookupItemSetResponseData> implements LookupItemSetService {
    /**
     * Handles a NCIP LookupItemSet service by returning hard-coded data.
     *
     * @param initData       the LookupItemSetInitiationData
     * @param serviceManager provides access to remote services
     * @return LookupItemSetResponseData
     */
    @Override
    public LookupItemSetResponseData performService(final LookupItemSetInitiationData initData, final ServiceContext serviceContext, final RemoteServiceManager serviceManager) {
        final LookupItemSetResponseData responseData = new LookupItemSetResponseData();
        final DummyRemoteServiceManager dummySvcMgr = (DummyRemoteServiceManager) serviceManager;
        final List<BibInformation> bibInformationsList = new ArrayList<>();
        final Map<String, List<DummyDatabase.ItemInfo>> itemInfosByBibNo = new HashMap<>();
        if (initData.getBibliographicIds() != null && initData.getBibliographicIds().size() > 0) {
            for (final BibliographicId bibId : initData.getBibliographicIds()) {
                if (bibId.getBibliographicRecordId() != null) {
                    if (bibId.getBibliographicRecordId().getAgencyId() != null) {
                        final String bibNo = bibId.getBibliographicRecordId().getBibliographicRecordIdentifier();
                        if (bibNo != null) {
                            final DummyDatabase.BibInfo bibInfo = DummyDatabase.BibInfo.getByBibNo(bibNo);
                            if (bibInfo != null) {
                                insertItemIdsForBib(itemInfosByBibNo, bibInfo);
                            } else {
                                final BibInformation bibInformation = new BibInformation();
                                bibInformation.setProblems(protocolHelper
                                    .generateProblems(Version1LookupItemProcessingError.UNKNOWN_ITEM, "//BibliographicRecordId", bibNo, "Bib # '" + bibNo + "' not found."));
                                bibInformationsList.add(bibInformation);
                            }
                        } else {
                            final BibInformation bibInformation = new BibInformation();
                            bibInformation.setProblems(protocolHelper
                                .generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "//BibliographicRecordId/BibliographicRecordIdentifier", null,
                                    "BibliographicRecordIdentifier is empty."));
                            bibInformationsList.add(bibInformation);
                        }
                    } else {
                        final BibliographicRecordIdentifierCode code = bibId.getBibliographicRecordId().getBibliographicRecordIdentifierCode();
                        if (code.equals(Version1BibliographicRecordIdentifierCode.OCLC)) {
                            final String oclcNum = bibId.getBibliographicRecordId().getBibliographicRecordIdentifier();
                            final List<DummyDatabase.BibInfo> bibInfos = DummyDatabase.BibInfo.getBibsByOCLCNo(oclcNum);
                            if (bibInfos != null && bibInfos.size() > 0) {
                                for (final DummyDatabase.BibInfo bibInfo : bibInfos) {
                                    insertItemIdsForBib(itemInfosByBibNo, bibInfo);
                                }
                            } else {
                                final BibInformation bibInformation = new BibInformation();
                                bibInformation.setProblems(protocolHelper
                                    .generateProblems(Version1LookupItemProcessingError.UNKNOWN_ITEM, "//BibliographicRecordId", oclcNum, "OCLC # '" + oclcNum + "' not found."));
                                bibInformationsList.add(bibInformation);
                            }
                        } else {
                            final BibInformation bibInformation = new BibInformation();
                            bibInformation.setProblems(protocolHelper.generateProblems(Version1GeneralProcessingError.UNAUTHORIZED_COMBINATION_OF_ELEMENT_VALUES_FOR_SYSTEM,
                                "//BibliographicRecordId/BibliographicRecordIdentifierCode", code.getScheme() + ": " + code.getValue(),
                                "Bib Id type '" + code.getScheme() + ": " + code.getValue() + "' not supported."));
                            bibInformationsList.add(bibInformation);
                        }
                    }
                } else {
                    final BibInformation bibInformation = new BibInformation();
                    bibInformation.setProblems(protocolHelper.generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "//BibliographicRecordId", null,
                        "BibliographicRecordId is the only bib-level identifier supported by this responder."));
                    bibInformationsList.add(bibInformation);
                }
            }
        } else if (initData.getItemIds() != null && initData.getItemIds().size() > 0) {
            for (final ItemId itemId : initData.getItemIds()) {
                final DummyDatabase.ItemInfo itemInfo = DummyDatabase.ItemInfo.getByBarcode(itemId.getItemIdentifierValue());
                if (itemInfo != null) {
                    final DummyDatabase.BibInfo bibInfo = itemInfo.holdingInfo.bibInfo;
                    List<DummyDatabase.ItemInfo> itemInfosForThisBib = itemInfosByBibNo.get(bibInfo.bibNo);
                    if (itemInfosForThisBib == null) {
                        itemInfosForThisBib = new ArrayList<>();
                        itemInfosByBibNo.put(bibInfo.bibNo, itemInfosForThisBib);
                    }
                    itemInfosForThisBib.add(itemInfo);
                } else {
                    final ItemInformation itemInformation = new ItemInformation();
                    itemInformation.setProblems(protocolHelper
                        .generateProblems(Version1LookupItemProcessingError.UNKNOWN_ITEM, "//BibliographicRecordId", itemId.getItemIdentifierValue(),
                            "Item # '" + itemId.getItemIdentifierValue() + "' not found."));
                    final List<ItemInformation> itemInformationList = new ArrayList<>();
                    itemInformationList.add(itemInformation);
                    final HoldingsSet holdingsSet = new HoldingsSet();
                    holdingsSet.setItemInformations(itemInformationList);
                    final List<HoldingsSet> holdingsSetList = new ArrayList<>();
                    final BibInformation bibInformation = new BibInformation();
                    bibInformation.setHoldingsSets(holdingsSetList);
                    bibInformationsList.add(bibInformation);
                }
            }
        } ///else - Do nothing, the fact that the bibInformationsList is empty will cause a Problem to be created below

        if (itemInfosByBibNo.size() > 0) {
            int currentItem = 0;
            int startItem = 1;
            if (initData.getNextItemToken() != null) {
                try {
                    startItem = Integer.valueOf(initData.getNextItemToken());
                } catch (NumberFormatException e) {
                    final BibInformation bibInformation = new BibInformation();
                    bibInformation.setProblems(protocolHelper
                        .generateProblems(Version1GeneralProcessingError.UNAUTHORIZED_COMBINATION_OF_ELEMENT_VALUES_FOR_SYSTEM, "//NextItemToken", initData.getNextItemToken(),
                            "Invalid token of '" + initData.getNextItemToken() + "'."));
                }
            }

            int maximumItemsCount = 0;
            if (initData.getMaximumItemsCount() != null) {
                maximumItemsCount = initData.getMaximumItemsCount().intValue();
            }

            for (final String bibNo : itemInfosByBibNo.keySet()) {
                final BibInformation bibInformation = new BibInformation();
                final BibliographicId bibId = new BibliographicId();
                final BibliographicRecordId bibliographicRecordId = new BibliographicRecordId();
                bibliographicRecordId.setBibliographicRecordIdentifier(bibNo);
                bibliographicRecordId.setAgencyId(dummySvcMgr.getAgencyId());
                bibId.setBibliographicRecordId(bibliographicRecordId);
                bibInformation.setBibliographicId(bibId);
                final BibliographicDescription bibDesc = dummySvcMgr.getBibliographicDescription(DummyDatabase.BibInfo.getByBibNo(bibNo));
                bibInformation.setBibliographicDescription(bibDesc);
                final List<HoldingsSet> holdingsSetList = new ArrayList<>();
                if ((currentItem + itemInfosByBibNo.get(bibNo).size()) >= startItem) {
                    final HoldingsSet holdingsSet = new HoldingsSet();
                    // Item information
                    final List<ItemInformation> itemInformationList = new ArrayList<>();
                    for (final DummyDatabase.ItemInfo itemInfo : itemInfosByBibNo.get(bibNo)) {
                        currentItem++;
                        if (currentItem < startItem) {
                            continue; // Skip this item because it was returned in a previous message (theoretically).
                        }
                        if (maximumItemsCount != 0 && currentItem >= (startItem + maximumItemsCount)) {
                            responseData.setNextItemToken(Integer.toString(currentItem));
                            break;
                        }
                        final ItemInformation itemInformation = getItemInformation(itemInfo);
                        itemInformationList.add(itemInformation);
                    }
                    if (itemInformationList.size() > 0) {
                        holdingsSet.setItemInformations(itemInformationList);
                        holdingsSetList.add(holdingsSet);
                    }
                } else {
                    currentItem += itemInfosByBibNo.get(bibNo).size();
                }

                if (maximumItemsCount != 0 && currentItem >= (startItem + maximumItemsCount)) {
                    break;
                }
                bibInformation.setHoldingsSets(holdingsSetList);
                bibInformationsList.add(bibInformation);
            }
            responseData.setBibInformations(bibInformationsList);
        } else {
            if (!bibInformationsList.isEmpty()) {
                responseData.setBibInformations(bibInformationsList);
            } else {
                responseData.setProblems(protocolHelper
                    .generateProblems(Version1GeneralProcessingError.NEEDED_DATA_MISSING, "//BibliographicRecordId or //ItemId", null, "No BibIds or ItemIds supplied."));
            }
        }
        return responseData;
    }

    /**
     * Insert item ids for the provided bib.
     * @param itemInfosByBibNo the map of itemids to insert into
     * @param bibInfo the bib to insert the id of
     */
    public static void insertItemIdsForBib(final Map<String, List<DummyDatabase.ItemInfo>> itemInfosByBibNo, final DummyDatabase.BibInfo bibInfo) {
        if (!itemInfosByBibNo.containsKey(bibInfo.bibNo)) {
            for (final DummyDatabase.HoldingInfo holdingInfo : bibInfo.holdings) {
                final DummyDatabase.ItemInfo[] itemInfos = holdingInfo.items;
                if (itemInfos != null && itemInfos.length > 0) {
                    itemInfosByBibNo.put(bibInfo.bibNo, Arrays.asList(itemInfos));
                } // else - no items
            }
        }
    }

    public ItemInformation getItemInformation(final DummyDatabase.ItemInfo itemInfo) {
        // Lookup the item's circulation status
        final DummyDatabase.CircStatus ilsCircStatus = itemInfo.circStatus;
        // Map from the Dummy ILS's circulation status values to the Scheme Value Pair used in NCIP.
        final CirculationStatus circStatus;
        switch (ilsCircStatus) {
        case ON_ORDER: {
            circStatus = Version1CirculationStatus.IN_PROCESS;
            break;
        }
        case ON_SHELF: {
            circStatus = Version1CirculationStatus.AVAILABLE_ON_SHELF;
            break;
        }
        case CHECKED_OUT: {
            circStatus = Version1CirculationStatus.ON_LOAN;
            break;
        }
        case IN_TRANSIT: {
            circStatus = Version1CirculationStatus.IN_TRANSIT_BETWEEN_LIBRARY_LOCATIONS;
            break;
        }
        default: {
            circStatus = Version1CirculationStatus.CIRCULATION_STATUS_UNDEFINED;
            break;
        }
        }

        // Item Description
        final ItemDescription itemDescription = new ItemDescription();
        itemDescription.setCallNumber(itemInfo.callNo);
        final HoldingsInformation holdingsInfo = new HoldingsInformation();
        holdingsInfo.setUnstructuredHoldingsData(itemInfo.holdingInfo.summaryHoldings);
        itemDescription.setHoldingsInformation(holdingsInfo);
        itemDescription.setNumberOfPieces(BigDecimal.ONE);
        // Assemble the ItemOptionalFields where most of the data is returned
        final ItemOptionalFields itemOptionalFields = new ItemOptionalFields();
        itemOptionalFields.setCirculationStatus(circStatus);
        itemOptionalFields.setItemDescription(itemDescription);
        final ItemInformation itemInformation = new ItemInformation();
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue(itemInfo.barcode);
        itemInformation.setItemId(itemId);
        itemInformation.setItemOptionalFields(itemOptionalFields);
        return itemInformation;
    }
}
