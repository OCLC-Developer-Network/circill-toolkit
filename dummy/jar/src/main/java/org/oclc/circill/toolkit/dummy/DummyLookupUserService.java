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
import org.oclc.circill.toolkit.service.ncip.Version1CurrencyCode;
import org.oclc.circill.toolkit.service.ncip.AccountBalance;
import org.oclc.circill.toolkit.service.ncip.AccountDetails;
import org.oclc.circill.toolkit.service.ncip.Amount;
import org.oclc.circill.toolkit.service.ncip.BibliographicDescription;
import org.oclc.circill.toolkit.service.ncip.CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.FiscalTransactionInformation;
import org.oclc.circill.toolkit.service.ncip.FiscalTransactionReferenceId;
import org.oclc.circill.toolkit.service.ncip.ItemDetails;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.LoanedItem;
import org.oclc.circill.toolkit.service.ncip.LoanedItemsCount;
import org.oclc.circill.toolkit.service.ncip.LookupUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupUserResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupUserService;
import org.oclc.circill.toolkit.service.ncip.NameInformation;
import org.oclc.circill.toolkit.service.ncip.PersonalNameInformation;
import org.oclc.circill.toolkit.service.ncip.PickupLocation;
import org.oclc.circill.toolkit.service.ncip.RequestId;
import org.oclc.circill.toolkit.service.ncip.RequestedItem;
import org.oclc.circill.toolkit.service.ncip.RequestedItemsCount;
import org.oclc.circill.toolkit.service.ncip.UserFiscalAccount;
import org.oclc.circill.toolkit.service.ncip.UserFiscalAccountSummary;
import org.oclc.circill.toolkit.service.ncip.UserOptionalFields;
import org.oclc.circill.toolkit.service.ncip.Version1FiscalActionType;
import org.oclc.circill.toolkit.service.ncip.Version1FiscalTransactionType;
import org.oclc.circill.toolkit.service.ncip.Version1LookupUserProcessingError;
import org.oclc.circill.toolkit.service.ncip.Version1RequestStatusType;
import org.oclc.circill.toolkit.service.ncip.Version1RequestType;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * This class implements the Lookup User service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. title, call #, etc.).
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyLookupUserService extends BaseDummyService<LookupUserInitiationData, LookupUserResponseData> implements LookupUserService {

    private static final int LATE_FEE_AMOUNT = 750;
    private static final int LATE_FEE_DUE_DATE = 50;
    private static final int LATE_ITEM_CHECKOUT_OFFSET = 75;
    private static final int LATE_FEE_RETURNED_DATE = 45;
    private static final int LATE_FEE_FINE_ACCRUAL_OFFSET = 5;
    private static final Integer ILL_FINE_AMOUNT = 450;

    /**
     * Handles a NCIP LookupUser service by returning hard-coded data.
     *
     * @param initData       the LookupUserInitiationData
     * @param serviceManager provides access to remote services
     * @return LookupUserResponseData
     */
    @Override
    @SuppressWarnings("PMD.EmptyIfStmt")
    public LookupUserResponseData performService(final LookupUserInitiationData initData, final ServiceContext serviceContext, final RemoteServiceManager serviceManager) {

        final LookupUserResponseData responseData = new LookupUserResponseData();

        final DummyRemoteServiceManager dummySvcMgr = (DummyRemoteServiceManager) serviceManager;
        final AgencyId agencyId = new AgencyId(dummySvcMgr.getLibraryName());

        final UserOptionalFields userOptionalFields = new UserOptionalFields();

        final String userNo = initData.getUserId().getUserIdentifierValue();

        if (DummyDatabase.UserInfo.getByUserNo(userNo) != null) {

            if (initData.getLoanedItemsDesired()) {

                final List<DummyDatabase.ItemInfo> itemInfos = DummyDatabase.ItemInfo.getChargedItemsByUserNo(userNo);
                if (itemInfos != null && itemInfos.size() > 0) {

                    final List<LoanedItem> loanedItemsList = new ArrayList<>(itemInfos.size());

                    for (final DummyDatabase.ItemInfo itemInfo : itemInfos) {

                        final LoanedItem loanedItem = new LoanedItem();
                        final ItemId itemId = new ItemId();
                        itemId.setItemIdentifierValue(itemInfo.barcode);
                        loanedItem.setItemId(itemId);
                        loanedItem.setDateDue(GregorianCalendar.from(itemInfo.dateDue));
                        if (itemInfo.overdueReminderCount == 0) {

                            loanedItem.setReminderLevel(BigDecimal.ONE);

                        } else {

                            loanedItem.setReminderLevel(new BigDecimal(itemInfo.overdueReminderCount));

                        }
                        // Note: NCIP v2 schema requires an Amount here; by convention of the ILS-DI implementers
                        // we set it to zero when there is no amount. In the circ system we're simulating, there is
                        // no amount for charged items.
                        final Amount amount = new Amount();
                        amount.setCurrencyCode(Version1CurrencyCode.USD);
                        amount.setMonetaryValue(BigDecimal.ZERO);
                        loanedItem.setAmount(amount);

                        loanedItem.setRenewalCount(new BigDecimal(itemInfo.renewalCount));

                        loanedItem.setDateCheckedOut(GregorianCalendar.from(itemInfo.checkoutDate));

                        final DummyDatabase.HoldingInfo holdingInfo = DummyDatabase.HoldingInfo.getByItemBarcode(itemInfo.barcode);
                        final BibliographicDescription bibDescription = dummySvcMgr.getBibliographicDescription(holdingInfo.bibInfo);
                        loanedItem.setBibliographicDescription(bibDescription);

                        loanedItemsList.add(loanedItem);

                    }
                    responseData.setLoanedItems(loanedItemsList);
                    final List<LoanedItemsCount> loanedItemsCountsList = new ArrayList<>(1);
                    final LoanedItemsCount checkedOutLoanedItemsCount = new LoanedItemsCount();
                    checkedOutLoanedItemsCount.setCirculationStatus(DummyRemoteServiceManager.translateCircStatus(DummyDatabase.CircStatus.CHECKED_OUT));
                    checkedOutLoanedItemsCount.setLoanedItemCountValue(new BigDecimal(loanedItemsList.size()));
                    loanedItemsCountsList.add(checkedOutLoanedItemsCount);
                    responseData.setLoanedItemsCounts(loanedItemsCountsList);

                } // else no charged items - omit the LoanedItem element.

            }

            if (initData.getUserFiscalAccountDesired()) {

                // Add a user fiscal account
                final UserFiscalAccount userFiscalAccount = new UserFiscalAccount();
                final List<AccountDetails> accountDetailsList = new ArrayList<>();
                final List<UserFiscalAccount> userFiscalAccountsList = new ArrayList<>();
                userFiscalAccount.setAccountDetails(accountDetailsList);
                userFiscalAccountsList.add(userFiscalAccount);
                responseData.setUserFiscalAccounts(userFiscalAccountsList);
                long accountBalanceValue = 0;

                // Create an account detail for a late fee
                final AccountDetails lateFeeAccountDetails = new AccountDetails();
                final GregorianCalendar lateFeeAccrualDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                lateFeeAccrualDate.add(Calendar.DAY_OF_YEAR, -LATE_FEE_RETURNED_DATE);
                lateFeeAccountDetails.setAccrualDate(lateFeeAccrualDate);
                accountDetailsList.add(lateFeeAccountDetails);

                final FiscalTransactionInformation lateFeeFiscalTransactionInformation = new FiscalTransactionInformation();
                lateFeeAccountDetails.setFiscalTransactionInformation(lateFeeFiscalTransactionInformation);

                final Amount lateFeeAmount = new Amount();
                lateFeeAmount.setCurrencyCode(Version1CurrencyCode.USD);
                lateFeeAmount.setMonetaryValue(new BigDecimal(LATE_FEE_AMOUNT));
                accountBalanceValue += LATE_FEE_AMOUNT;
                lateFeeFiscalTransactionInformation.setAmount(lateFeeAmount);
                lateFeeFiscalTransactionInformation.setFiscalActionType(Version1FiscalActionType.ASSESS);
                lateFeeFiscalTransactionInformation.setFiscalTransactionDescription("Late fee.");
                final FiscalTransactionReferenceId lateFeeFiscalTransactionReferenceId = new FiscalTransactionReferenceId();
                lateFeeFiscalTransactionReferenceId.setFiscalTransactionIdentifierValue("19xkq2701hshjq0183nkjxs17_bcrq");
                lateFeeFiscalTransactionReferenceId.setAgencyId(agencyId);
                lateFeeFiscalTransactionInformation.setFiscalTransactionReferenceId(lateFeeFiscalTransactionReferenceId);
                lateFeeFiscalTransactionInformation.setFiscalTransactionType(Version1FiscalTransactionType.FINE);
                final ItemDetails lateFeeItemDetails = new ItemDetails();
                final BibliographicDescription lateFeeBibDescription = dummySvcMgr.getBibliographicDescription(DummyDatabase.BibInfo.getByBibNo("123"));
                lateFeeItemDetails.setBibliographicDescription(lateFeeBibDescription);
                final GregorianCalendar lateFeeCheckoutDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                lateFeeCheckoutDate.add(Calendar.DAY_OF_YEAR, -LATE_ITEM_CHECKOUT_OFFSET);
                lateFeeItemDetails.setDateCheckedOut(lateFeeCheckoutDate);
                final GregorianCalendar lateFeeDateDue = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                lateFeeDateDue.add(Calendar.DAY_OF_YEAR, -LATE_FEE_DUE_DATE);
                lateFeeItemDetails.setDateDue(lateFeeDateDue);
                final GregorianCalendar lateFeeDateReturned = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                lateFeeDateReturned.add(Calendar.DAY_OF_YEAR, -LATE_FEE_RETURNED_DATE);
                lateFeeItemDetails.setDateReturned(lateFeeDateReturned);
                final ItemId lateFeeItemId = new ItemId();
                lateFeeItemId.setItemIdentifierValue("25556192919132");
                lateFeeItemDetails.setItemId(lateFeeItemId);
                lateFeeFiscalTransactionInformation.setItemDetails(lateFeeItemDetails);
                final GregorianCalendar lateFeeValidFromDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                lateFeeValidFromDate.add(Calendar.DAY_OF_YEAR, -LATE_FEE_RETURNED_DATE);
                lateFeeFiscalTransactionInformation.setValidFromDate(lateFeeValidFromDate);
                final GregorianCalendar lateFeeValidToDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                lateFeeValidToDate.add(Calendar.YEAR, 1);
                lateFeeFiscalTransactionInformation.setValidToDate(lateFeeValidToDate);

                // Create an account detail for an ILL request
                final AccountDetails illFineAccountDetails = new AccountDetails();
                final GregorianCalendar illFineAccrualDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                illFineAccrualDate.add(Calendar.DAY_OF_YEAR, -LATE_FEE_FINE_ACCRUAL_OFFSET);
                illFineAccountDetails.setAccrualDate(illFineAccrualDate);
                accountDetailsList.add(illFineAccountDetails);

                final FiscalTransactionInformation illFineFiscalTransactionInformation = new FiscalTransactionInformation();
                illFineAccountDetails.setFiscalTransactionInformation(illFineFiscalTransactionInformation);

                final Amount illFineAmount = new Amount();
                illFineAmount.setCurrencyCode(Version1CurrencyCode.USD);
                illFineAmount.setMonetaryValue(new BigDecimal(ILL_FINE_AMOUNT.toString()));
                accountBalanceValue += ILL_FINE_AMOUNT;
                illFineFiscalTransactionInformation.setAmount(illFineAmount);
                illFineFiscalTransactionInformation.setFiscalActionType(Version1FiscalActionType.ASSESS);
                illFineFiscalTransactionInformation.setFiscalTransactionDescription("ILL fee.");
                final FiscalTransactionReferenceId illFineFiscalTransactionReferenceId = new FiscalTransactionReferenceId();
                illFineFiscalTransactionReferenceId.setFiscalTransactionIdentifierValue("VDX-1291831");
                illFineFiscalTransactionReferenceId.setAgencyId(agencyId);
                illFineFiscalTransactionInformation.setFiscalTransactionReferenceId(illFineFiscalTransactionReferenceId);
                illFineFiscalTransactionInformation.setFiscalTransactionType(Version1FiscalTransactionType.INTERLIBRARY_LOAN_FEE);
                final RequestId illFineRequestId = new RequestId();
                illFineRequestId.setRequestIdentifierValue("VDX-1291831");
                illFineFiscalTransactionInformation.setRequestId(illFineRequestId);

                // Now set the Account Balance
                final AccountBalance accountBalance = new AccountBalance();
                accountBalance.setCurrencyCode(Version1CurrencyCode.USD);
                accountBalance.setMonetaryValue(new BigDecimal(accountBalanceValue));
                userFiscalAccount.setAccountBalance(accountBalance);

                // Now create summary
                final UserFiscalAccountSummary userFiscalAcctSummary = new UserFiscalAccountSummary();
                userFiscalAcctSummary.setAccountBalance(accountBalance);
                userFiscalAcctSummary.setChargesCount(new BigDecimal(accountDetailsList.size()));
                responseData.setUserFiscalAccountSummary(userFiscalAcctSummary);
            }

            if (initData.getRequestedItemsDesired()) {

                final List<DummyDatabase.RequestInfo> requestInfos = DummyDatabase.RequestInfo.getByUserNo(userNo);
                if (requestInfos != null && requestInfos.size() > 0) {

                    final List<RequestedItem> requestedItemsList = new ArrayList<>(requestInfos.size());
                    final Map<CirculationStatus, BigDecimal> countByCircStatus = new HashMap<>();

                    for (final DummyDatabase.RequestInfo requestInfo : requestInfos) {

                        final RequestedItem requestedItem = new RequestedItem();
                        final ItemId itemId = new ItemId();
                        itemId.setItemIdentifierValue(requestInfo.itemBarcode);
                        requestedItem.setItemId(itemId);
                        final RequestId requestId = new RequestId();
                        requestId.setRequestIdentifierValue(requestInfo.requestNo);
                        requestedItem.setDatePlaced(requestInfo.createDate);
                        requestedItem.setRequestId(requestId);
                        final DummyDatabase.HoldingInfo holdingInfo = DummyDatabase.HoldingInfo.getByItemBarcode(requestInfo.itemBarcode);
                        final BibliographicDescription bibDescription = dummySvcMgr.getBibliographicDescription(holdingInfo.bibInfo);
                        requestedItem.setBibliographicDescription(bibDescription);

                        requestedItem.setRequestType(Version1RequestType.HOLD);
                        if (requestInfo.status == DummyDatabase.HoldStatus.ON_SHELF) {
                            requestedItem.setRequestStatusType(Version1RequestStatusType.AVAILABLE_FOR_PICKUP);
                        } else {
                            requestedItem.setRequestStatusType(Version1RequestStatusType.IN_PROCESS);
                        }
                        requestedItem.setPickupLocation(new PickupLocation(null, requestInfo.pickupLoc));
                        final int queuePosition = requestInfo.getQueuePosition();

                        if (queuePosition == 0) {

                            requestedItem.setHoldQueuePosition(BigDecimal.ONE);

                        } else {

                            requestedItem.setHoldQueuePosition(new BigDecimal(queuePosition));

                        }

                        if (queuePosition == 0) {

                            requestedItem.setPickupDate(requestInfo.pickupStart);
                            requestedItem.setPickupExpiryDate(requestInfo.pickupEnd);
                            if (requestInfo.itemAvailableCount == 0) {

                                requestedItem.setReminderLevel(BigDecimal.ONE);

                            } else {

                                requestedItem.setReminderLevel(new BigDecimal(requestInfo.itemAvailableCount));

                            }

                        }

                        requestedItemsList.add(requestedItem);
                        final DummyDatabase.ItemInfo itemInfo = DummyDatabase.ItemInfo.getByBarcode(requestInfo.itemBarcode);
                        assert itemInfo != null;
                        final CirculationStatus ncipCircStatus = DummyRemoteServiceManager.translateCircStatus(itemInfo.circStatus);
                        BigDecimal count = countByCircStatus.get(ncipCircStatus);
                        if (count != null) {

                            count = count.add(BigDecimal.ONE);

                        } else {

                            count = BigDecimal.ONE;

                        }
                        countByCircStatus.put(ncipCircStatus, count);

                    }
                    responseData.setRequestedItems(requestedItemsList);

                    if (countByCircStatus.size() > 0) {

                        final List<RequestedItemsCount> requestedItemsCountsList = new ArrayList<>(countByCircStatus.size());

                        for (final Map.Entry<CirculationStatus, BigDecimal> entry : countByCircStatus.entrySet()) {

                            final RequestedItemsCount requestedItemsCount = new RequestedItemsCount();
                            requestedItemsCount.setCirculationStatus(entry.getKey());
                            requestedItemsCount.setRequestedItemCountValue(entry.getValue());
                            requestedItemsCountsList.add(requestedItemsCount);

                        }

                        responseData.setRequestedItemsCounts(requestedItemsCountsList);

                    }

                } // else no charged items - omit the LoanedItem element.

            }

            if (initData.getNameInformationDesired()) {

                final PersonalNameInformation pni = new PersonalNameInformation();
                pni.setUnstructuredPersonalUserName("Jane Doer");

                final NameInformation ni = new NameInformation();
                ni.setPersonalNameInformation(pni);
                userOptionalFields.setNameInformation(ni);

            }

            responseData.setUserOptionalFields(userOptionalFields);

            // Echo back the same item id that came in
            responseData.setUserId(initData.getUserId());

        } else {
            responseData.setProblems(protocolHelper.generateProblems(Version1LookupUserProcessingError.UNKNOWN_USER, "//UserId/UserIdentifierValue", userNo, null));
        }

        return responseData;
    }

}
