/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0;

import org.oclc.circill.toolkit.common.ncip.NCIPServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.ItemUseRestrictionType;
import org.oclc.circill.toolkit.service.ncip.LoanedItemsCount;
import org.oclc.circill.toolkit.service.ncip.LookupUserResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestedItemsCount;
import org.oclc.circill.toolkit.service.ncip.Version1CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.common.ApplicationProfileType;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Confirm whether this class should be included in the open-source project
public class WCLNCIPServiceContext extends NCIPServiceContext {

    protected static final Map<CirculationStatus, CirculationStatus> NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS = new HashMap<>();

    static {

        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.AVAILABLE_FOR_PICKUP, WCLv1_0CirculationStatus.ON_HOLD);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.AVAILABLE_ON_SHELF, WCLv1_0CirculationStatus.AVAILABLE);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.CIRCULATION_STATUS_UNDEFINED, WCLv1_0CirculationStatus.UNAVAILABLE);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.CLAIMED_RETURNED_OR_NEVER_BORROWED, WCLv1_0CirculationStatus.CLAIMED_RETURNED);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.IN_PROCESS, WCLv1_0CirculationStatus.RECENTLY_RECEIVED);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.IN_TRANSIT_BETWEEN_LIBRARY_LOCATIONS, WCLv1_0CirculationStatus.DISPATCHED);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.LOST, WCLv1_0CirculationStatus.LOST);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.MISSING, WCLv1_0CirculationStatus.MISSING);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.NOT_AVAILABLE, WCLv1_0CirculationStatus.UNAVAILABLE);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.ON_LOAN, WCLv1_0CirculationStatus.ON_LOAN);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.ON_ORDER, WCLv1_0CirculationStatus.ON_ORDER);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.PENDING_TRANSFER, WCLv1_0CirculationStatus.TRANSIT);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.RECALLED, WCLv1_0CirculationStatus.RECALLED);
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(Version1CirculationStatus.WAITING_TO_BE_RESHELVED, WCLv1_0CirculationStatus.RECENTLY_RETURNED);
        // The following is a non-standard Value which WMS's connector includes in the Version1 Scheme.
        NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.put(new CirculationStatus(Version1CirculationStatus.VERSION_1_CIRCULATION_STATUS, "Overdue"), WCLv1_0CirculationStatus.OVERDUE);

    }

    protected static final ApplicationProfileType EXPECTED_APPLICATION_PROFILE_TYPE = WCLApplicationProfileType.VERSION_2011;

    @Override
    public void validateAfterUnmarshalling(final NCIPMessage ncipMessage) throws ValidationException {

        super.validateAfterUnmarshalling(ncipMessage);
        validatePerWCL(ncipMessage);

    }

    @Override
    public void validateBeforeMarshalling(final NCIPMessage ncipMessage) throws ValidationException {

        super.validateBeforeMarshalling(ncipMessage);
        validatePerWCL(ncipMessage);

    }

    /**
     * Validate the NCIP message against the WCL (OCLC OPAC NCIP Application Profile) rules.
     *
     * @param ncipMessage the message to validate
     * @throws ValidationException if the message does not conform or an exception occurs
     */
    private void validatePerWCL(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ValidationException {

        try {

            if (ncipMessage.isInitiationMessage()) {

                if (requiresApplicationProfileType()) {

                    InitiationHeader initHdr = null;
                    final NCIPInitiationData initData = ncipMessage.getInitiationData();
                    if (initData != null) {
                        initHdr = initData.getInitiationHeader();
                    }

                    if (initHdr == null || initHdr.getApplicationProfileType() == null) {

                        throw new ValidationException("NCIPMessage does not have ApplicationProfileType and it is required by this ServiceContext.",
                            Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(), Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null,
                            null);

                    } else if (!initHdr.getApplicationProfileType().equals(EXPECTED_APPLICATION_PROFILE_TYPE)) {

                        throw new ValidationException("NCIPMessage does not have the Application Profile Type required by this ServiceContext." + " The required scheme URI is '"
                            + EXPECTED_APPLICATION_PROFILE_TYPE.getScheme() + "' and the required value is '" + EXPECTED_APPLICATION_PROFILE_TYPE.getValue() + "'.",
                            Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(), Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null,
                            null);
                    }

                }

            } else if (ncipMessage.isResponseMessage()) {

                final NCIPResponseData ncipRespData = ncipMessage.getResponseData();
                if (ncipRespData instanceof LookupUserResponseData) {

                    final LookupUserResponseData lookupUserRespData = (LookupUserResponseData) ncipRespData;

                    final List<LoanedItemsCount> inLoanedItemsCounts = lookupUserRespData.getLoanedItemsCounts();
                    final Map<CirculationStatus, Map<ItemUseRestrictionType, LoanedItemsCount>> circStatusToItemUseRestrictionToLoanedItemsCountMap = new HashMap<>();
                    if (inLoanedItemsCounts != null && !inLoanedItemsCounts.isEmpty()) {
                        for (final LoanedItemsCount loanedItemsCount : inLoanedItemsCounts) {

                            if (loanedItemsCount.getCirculationStatus() != null && NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.containsKey(loanedItemsCount.getCirculationStatus())) {

                                loanedItemsCount.setCirculationStatus(NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.get(loanedItemsCount.getCirculationStatus()));

                            }

                            if (circStatusToItemUseRestrictionToLoanedItemsCountMap.containsKey(loanedItemsCount.getCirculationStatus())) {

                                final Map<ItemUseRestrictionType, LoanedItemsCount> itemUseRestrictionTypeLoanedItemsCountMap = circStatusToItemUseRestrictionToLoanedItemsCountMap
                                    .get(loanedItemsCount.getCirculationStatus());

                                if (itemUseRestrictionTypeLoanedItemsCountMap.containsKey(loanedItemsCount.getItemUseRestrictionType())) {

                                    final LoanedItemsCount matchingLoanedItemsCount = itemUseRestrictionTypeLoanedItemsCountMap.get(loanedItemsCount.getItemUseRestrictionType());
                                    matchingLoanedItemsCount
                                        .setLoanedItemCountValue(matchingLoanedItemsCount.getLoanedItemCountValue().add(loanedItemsCount.getLoanedItemCountValue()));

                                } else {

                                    itemUseRestrictionTypeLoanedItemsCountMap.put(loanedItemsCount.getItemUseRestrictionType(), loanedItemsCount);

                                }

                            } else {

                                final Map<ItemUseRestrictionType, LoanedItemsCount> itemUseRestrictionTypeLoanedItemsCountMap = new HashMap<>();
                                itemUseRestrictionTypeLoanedItemsCountMap.put(loanedItemsCount.getItemUseRestrictionType(), loanedItemsCount);
                                circStatusToItemUseRestrictionToLoanedItemsCountMap.put(loanedItemsCount.getCirculationStatus(), itemUseRestrictionTypeLoanedItemsCountMap);
                            }

                        }

                        inLoanedItemsCounts.clear();
                        for (final Map.Entry<CirculationStatus, Map<ItemUseRestrictionType, LoanedItemsCount>> circStatusPair : circStatusToItemUseRestrictionToLoanedItemsCountMap
                            .entrySet()) {

                            for (final Map.Entry<ItemUseRestrictionType, LoanedItemsCount> itemUseRestrictionTypePair : circStatusPair.getValue().entrySet()) {

                                inLoanedItemsCounts.add(itemUseRestrictionTypePair.getValue());

                            }

                        }

                    }

                    final List<RequestedItemsCount> inRequestedItemsCounts = lookupUserRespData.getRequestedItemsCounts();
                    final Map<CirculationStatus, Map<ItemUseRestrictionType, RequestedItemsCount>> circStatusToItemUseRestrictionToRequestedItemsCountMap = new HashMap<>();
                    if (inRequestedItemsCounts != null && !inRequestedItemsCounts.isEmpty()) {
                        for (final RequestedItemsCount requestedItemsCount : inRequestedItemsCounts) {

                            if (requestedItemsCount.getCirculationStatus() != null && NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.containsKey(requestedItemsCount.getCirculationStatus())) {

                                requestedItemsCount.setCirculationStatus(NCIP_CIRC_STATUS_TO_WCL_CIRC_STATUS.get(requestedItemsCount.getCirculationStatus()));

                            }

                            if (circStatusToItemUseRestrictionToRequestedItemsCountMap.containsKey(requestedItemsCount.getCirculationStatus())) {

                                final Map<ItemUseRestrictionType, RequestedItemsCount> itemUseRestrictionTypeRequestedItemsCountMap
                                    = circStatusToItemUseRestrictionToRequestedItemsCountMap.get(requestedItemsCount.getCirculationStatus());

                                if (itemUseRestrictionTypeRequestedItemsCountMap.containsKey(requestedItemsCount.getItemUseRestrictionType())) {

                                    final RequestedItemsCount matchingRequestedItemsCount = itemUseRestrictionTypeRequestedItemsCountMap
                                        .get(requestedItemsCount.getItemUseRestrictionType());
                                    matchingRequestedItemsCount
                                        .setRequestedItemCountValue(matchingRequestedItemsCount.getRequestedItemCountValue().add(requestedItemsCount.getRequestedItemCountValue()));

                                } else {

                                    itemUseRestrictionTypeRequestedItemsCountMap.put(requestedItemsCount.getItemUseRestrictionType(), requestedItemsCount);

                                }

                            } else {

                                final Map<ItemUseRestrictionType, RequestedItemsCount> itemUseRestrictionTypeRequestedItemsCountMap = new HashMap<>();
                                itemUseRestrictionTypeRequestedItemsCountMap.put(requestedItemsCount.getItemUseRestrictionType(), requestedItemsCount);
                                circStatusToItemUseRestrictionToRequestedItemsCountMap
                                    .put(requestedItemsCount.getCirculationStatus(), itemUseRestrictionTypeRequestedItemsCountMap);
                            }

                        }

                        inRequestedItemsCounts.clear();
                        for (final Map.Entry<CirculationStatus, Map<ItemUseRestrictionType, RequestedItemsCount>> circStatusPair
                            : circStatusToItemUseRestrictionToRequestedItemsCountMap.entrySet()) {

                            for (final Map.Entry<ItemUseRestrictionType, RequestedItemsCount> itemUseRestrictionTypePair : circStatusPair.getValue().entrySet()) {

                                inRequestedItemsCounts.add(itemUseRestrictionTypePair.getValue());

                            }

                        }

                    }

                } // else do nothing if the service type isn't one we need to handle.

            } else {
                throw new ValidationException("NCIPMessage is neither an Initiation or Response message.", Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(),
                    Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null, null);
            }

        } catch (ToolkitException e) {
            throw new ValidationException("ServiceException getting NCIPData object from NCIPMessage object.",
                Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(), Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null, null, e);
        }

    }

}
