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
import org.oclc.circill.toolkit.service.ncip.Amount;
import org.oclc.circill.toolkit.service.ncip.CancelRequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.CancelRequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.CancelRequestItemService;
import org.oclc.circill.toolkit.service.ncip.FiscalTransactionInformation;
import org.oclc.circill.toolkit.service.ncip.FiscalTransactionReferenceId;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.RequestId;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.Version1FiscalActionType;
import org.oclc.circill.toolkit.service.ncip.Version1FiscalTransactionType;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 * This class implements the Request Item service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. request id) and responds that the hold
 * was a success.
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyCancelRequestItemService extends BaseDummyService<CancelRequestItemInitiationData, CancelRequestItemResponseData> implements CancelRequestItemService {

    /**
     * Handles a NCIP CancelRequestItem service by returning hard-coded data. This only looks for the first
     * item or bib id.
     *
     * @param initData       the CancelRequestItemInitiationData
     * @param serviceManager provides access to remote services
     * @return CancelRequestItemResponseData
     */
    @Override
    @SuppressWarnings("PMD.UnusedLocalVariable")
    public CancelRequestItemResponseData performService(final CancelRequestItemInitiationData initData, final ServiceContext serviceContext,
        final RemoteServiceManager serviceManager) {

        final CancelRequestItemResponseData responseData = new CancelRequestItemResponseData();

        responseData.setUserId(initData.getUserId());

        if (initData.getItemId() != null) {
            // Echo back the same item id that came in
            final String itemIdString = initData.getItemId().getItemIdentifierValue();
            final ItemId itemId = new ItemId();
            itemId.setItemIdentifierValue(itemIdString);
            responseData.setItemId(itemId);
        }

        if (initData.getRequestId() != null) {
            // Echo back the same request id that came in
            final String requestIdString = initData.getRequestId().getRequestIdentifierValue();
            final RequestId requestId = new RequestId();
            requestId.setRequestIdentifierValue(requestIdString);
            responseData.setRequestId(requestId);
        }

        if (initData.getUserId() != null) {
            // Echo back the same user id that came in
            final String userIdString = initData.getUserId().getUserIdentifierValue();
            final UserId userId = new UserId();
            userId.setUserIdentifierValue(userIdString);
            responseData.setUserId(userId);
        }

        // If the request id is even, return fiscal transaction info
        final String id = initData.getRequestId() != null ? initData.getRequestId().getRequestIdentifierValue()
            : initData.getItemId() != null ? initData.getItemId().getItemIdentifierValue() : null;
        if (id != null && id.length() > 0) {

            final FiscalTransactionInformation fti = new FiscalTransactionInformation();
            final Amount fee = new Amount();
            fee.setMonetaryValue(new BigDecimal(2));
            fee.setCurrencyCode(Version1CurrencyCode.USD);
            fti.setAmount(fee);
            fti.setFiscalActionType(Version1FiscalActionType.ASSESS);
            fti.setFiscalTransactionType(Version1FiscalTransactionType.RESERVATION_CHARGE);
            fti.setFiscalTransactionDescription("Charge for canceling partially-processed hold.");
            final FiscalTransactionReferenceId ftri = new FiscalTransactionReferenceId();
            ftri.setFiscalTransactionIdentifierValue(id + "-001");
            fti.setFiscalTransactionReferenceId(ftri);
            fti.setRequestId(initData.getRequestId());
            fti.setValidFromDate(new GregorianCalendar());
        }

        return responseData;
    }

}
