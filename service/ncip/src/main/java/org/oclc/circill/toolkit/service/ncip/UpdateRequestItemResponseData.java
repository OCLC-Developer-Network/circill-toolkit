/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the UpdateRequestItemResponse.
 */
public class UpdateRequestItemResponseData implements NCIPResponseData {

    /**
     * ResponseHeader
     */
    protected ResponseHeader responseHeader;

    /**
     * Set ResponseHeader.
     * @param responseHeader the {@link ResponseHeader}
     */
    public void setResponseHeader(final ResponseHeader responseHeader) {

        this.responseHeader = responseHeader;

    }

    /**
     * Get ResponseHeader.
     *
     * @return the {@link ResponseHeader}
     */
    public ResponseHeader getResponseHeader() {

        return responseHeader;

    }

    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();

    /**
     * Set Problems.
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    public void setProblems(final List<Problem> problems) {

        this.problems = problems;

    }

    /**
     * Get Problems.
     */
    @Override
    public List<Problem> getProblems() {

        return problems;

    }

    /**
     * RequiredFeeAmount
     */
    protected RequiredFeeAmount requiredFeeAmount;

    /**
     * Set RequiredFeeAmount.
     *
     * @param requiredFeeAmount the {@link RequiredFeeAmount}
     */
    public void setRequiredFeeAmount(final RequiredFeeAmount requiredFeeAmount) {

        this.requiredFeeAmount = requiredFeeAmount;

    }

    /**
     * Get RequiredFeeAmount.
     *
     * @return the {@link RequiredFeeAmount}
     */
    public RequiredFeeAmount getRequiredFeeAmount() {

        return requiredFeeAmount;

    }

    /**
     * ItemId
     */
    protected ItemId itemId;

    /**
     * Set ItemId.
     * @param itemId the {@link ItemId}
     */
    public void setItemId(final ItemId itemId) {

        this.itemId = itemId;

    }

    /**
     * Get ItemId.
     *
     * @return the {@link ItemId}
     */
    public ItemId getItemId() {

        return itemId;

    }

    /**
     * UserId
     */
    protected UserId userId;

    /**
     * Set UserId.
     * @param userId the {@link UserId}
     */
    public void setUserId(final UserId userId) {

        this.userId = userId;

    }

    /**
     * Get UserId.
     *
     * @return the {@link UserId}
     */
    public UserId getUserId() {

        return userId;

    }

    /**
     * RequestType
     */
    protected RequestType requestType;

    /**
     * Set RequestType.
     *
     * @param requestType the {@link RequestType}
     */
    public void setRequestType(final RequestType requestType) {

        this.requestType = requestType;

    }

    /**
     * Get RequestType.
     *
     * @return the {@link RequestType}
     */
    public RequestType getRequestType() {

        return requestType;

    }

    /**
     * RequestScopeType
     */
    protected RequestScopeType requestScopeType;

    /**
     * Set RequestScopeType.
     *
     * @param requestScopeType the {@link RequestScopeType}
     */
    public void setRequestScopeType(final RequestScopeType requestScopeType) {

        this.requestScopeType = requestScopeType;

    }

    /**
     * Get RequestScopeType.
     *
     * @return the {@link RequestScopeType}
     */
    public RequestScopeType getRequestScopeType() {

        return requestScopeType;

    }

    /**
     * DateAvailable
     */
    protected GregorianCalendar dateAvailable;

    /**
     * Set DateAvailable.
     *
     * @param dateAvailable the date the requested item is expected to be available
     */
    public void setDateAvailable(final GregorianCalendar dateAvailable) {

        this.dateAvailable = dateAvailable;

    }

    /**
     * Get DateAvailable.
     *
     * @return the date/time the requested item was or will be available
     */
    public GregorianCalendar getDateAvailable() {

        return dateAvailable;

    }

    /**
     * HoldPickupDate
     */
    protected GregorianCalendar holdPickupDate;

    /**
     * Set HoldPickupDate.
     *
     * @param holdPickupDate the date the hold expires
     */
    public void setHoldPickupDate(final GregorianCalendar holdPickupDate) {

        this.holdPickupDate = holdPickupDate;

    }

    /**
     * Get HoldPickupDate.
     *
     * @return the date/time at which the hold expires
     */
    public GregorianCalendar getHoldPickupDate() {

        return holdPickupDate;

    }

    /**
     * FiscalTransactionInformation
     */
    protected FiscalTransactionInformation fiscalTransactionInformation;

    /**
     * Set FiscalTransactionInformation.
     *
     * @param fiscalTransactionInformation the {@link FiscalTransactionInformation}
     */
    public void setFiscalTransactionInformation(final FiscalTransactionInformation fiscalTransactionInformation) {

        this.fiscalTransactionInformation = fiscalTransactionInformation;

    }

    /**
     * Get FiscalTransactionInformation.
     *
     * @return the {@link FiscalTransactionInformation}
     */
    public FiscalTransactionInformation getFiscalTransactionInformation() {

        return fiscalTransactionInformation;

    }

    /**
     * ItemOptionalFields
     */
    protected ItemOptionalFields itemOptionalFields;

    /**
     * Set ItemOptionalFields.
     *
     * @param itemOptionalFields the {@link ItemOptionalFields}
     */
    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {

        this.itemOptionalFields = itemOptionalFields;

    }

    /**
     * Get ItemOptionalFields.
     *
     * @return the {@link ItemOptionalFields}
     */
    public ItemOptionalFields getItemOptionalFields() {

        return itemOptionalFields;

    }

    /**
     * UserOptionalFields
     */
    protected UserOptionalFields userOptionalFields;

    /**
     * Set the UserOptionalFields.
     *
     * @param userOptionalFields the {@link UserOptionalFields}
     */
    public void setUserOptionalFields(final UserOptionalFields userOptionalFields) {

        this.userOptionalFields = userOptionalFields;

    }

    /**
     * Get UserOptionalFields.
     *
     * @return the {@link UserOptionalFields}
     */
    public UserOptionalFields getUserOptionalFields() {

        return userOptionalFields;

    }

    /**
     * Generic toString() implementation.
     *
     * @return String
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);

    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final UpdateRequestItemResponseData rhs = (UpdateRequestItemResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems)
            .append(requiredFeeAmount, rhs.requiredFeeAmount).append(itemId, rhs.itemId).append(userId, rhs.userId).append(requestType, rhs.requestType)
            .append(requestScopeType, rhs.requestScopeType).append(dateAvailable, rhs.dateAvailable).append(holdPickupDate, rhs.holdPickupDate)
            .append(fiscalTransactionInformation, rhs.fiscalTransactionInformation).append(itemOptionalFields, rhs.itemOptionalFields)
            .append(userOptionalFields, rhs.userOptionalFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1582209955, 1398070133).append(responseHeader).append(problems).append(requiredFeeAmount).append(itemId).append(userId)
            .append(requestType).append(requestScopeType).append(dateAvailable).append(holdPickupDate).append(fiscalTransactionInformation).append(itemOptionalFields)
            .append(userOptionalFields).toHashCode();
        return result;
    }
}
