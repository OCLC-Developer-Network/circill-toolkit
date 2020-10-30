/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RequestItemResponseData implements NCIPResponseData {

    /**
     * Response Header
     */
    protected ResponseHeader responseHeader;
    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();
    /**
     * Required Fee Amount
     */
    protected RequiredFeeAmount requiredFeeAmount;
    /**
     * Required Item Use Restriction Types
     */
    protected List<ItemUseRestrictionType> requiredItemUseRestrictionTypes = new ArrayList<>();
    /**
     * Item Id
     */
    protected ItemId itemId;
    /**
     * Request Id
     */
    protected RequestId requestId;
    /**
     * User Id
     */
    protected UserId userId;
    /**
     * Request Type
     */
    protected RequestType requestType;
    /**
     * Request Scope Type
     */
    protected RequestScopeType requestScopeType;
    /**
     * Shipping Information
     */
    protected ShippingInformation shippingInformation;
    /**
     * Date Available
     */
    protected GregorianCalendar dateAvailable;
    /**
     * Hold Pickup Date
     */
    protected GregorianCalendar holdPickupDate;
    /**
     * Fiscal Transaction Information
     */
    protected FiscalTransactionInformation fiscalTransactionInformation;
    /**
     * Item Optional Fields
     */
    protected ItemOptionalFields itemOptionalFields;
    /**
     * User Optional Fields
     */
    protected UserOptionalFields userOptionalFields;

    /**
     * HoldQueuePosition
     */
    protected BigDecimal holdQueuePosition;

    /**
     * HoldQueueLength
     */
    protected BigDecimal holdQueueLength;

    /**
     * Retrieve the response header.
     *
     * @return the response header
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Set the response header
     *
     * @param responseHeader the {@link ResponseHeader}
     */
    public void setResponseHeader(final ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    /**
     * Retrieve the list of {@link Problem}s.
     *
     * @return the list of problems
     */
    @Override
    public List<Problem> getProblems() {
        return problems;
    }

    /**
     * Retrieve the indexed Problem from the list of {@link Problem}s.
     *
     * @param index the ordinal position of the problem to get
     * @return the indexed problem
     */
    public Problem getProblem(final int index) {
        return problems != null ? (problems.size() > 0 ? problems.get(index) : null) : null;
    }

    /**
     * Set the list of {@link Problem}s.
     *
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    public void setProblems(final List<Problem> problems) {
        this.problems = problems;
    }

    public void setProblem(final int index, final Problem problem) {
        problems.set(index, problem);
    }

    public RequiredFeeAmount getRequiredFeeAmount() {
        return requiredFeeAmount;
    }

    public void setRequiredFeeAmount(final RequiredFeeAmount requiredFeeAmount) {
        this.requiredFeeAmount = requiredFeeAmount;
    }

    public List<ItemUseRestrictionType> getRequiredItemUseRestrictionTypes() {
        return requiredItemUseRestrictionTypes;
    }

    public ItemUseRestrictionType getRequiredItemUseRestrictionType(final int index) {
        return requiredItemUseRestrictionTypes != null ? (requiredItemUseRestrictionTypes.size() > 0 ? requiredItemUseRestrictionTypes.get(index) : null) : null;
    }

    public void setRequiredItemUseRestrictionTypes(final List<ItemUseRestrictionType> requiredItemUseRestrictionTypes) {
        this.requiredItemUseRestrictionTypes = requiredItemUseRestrictionTypes;
    }

    public void setRequiredItemUseRestrictionType(final int index, final ItemUseRestrictionType requiredItemUseRestrictionType) {
        requiredItemUseRestrictionTypes.set(index, requiredItemUseRestrictionType);
    }

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    public RequestId getRequestId() {
        return requestId;
    }

    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(final UserId userId) {
        this.userId = userId;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(final RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestScopeType getRequestScopeType() {
        return requestScopeType;
    }

    public void setRequestScopeType(final RequestScopeType requestScopeType) {
        this.requestScopeType = requestScopeType;
    }

    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(final ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public GregorianCalendar getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(final GregorianCalendar dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public GregorianCalendar getHoldPickupDate() {
        return holdPickupDate;
    }

    public void setHoldPickupDate(final GregorianCalendar holdPickupDate) {
        this.holdPickupDate = holdPickupDate;
    }

    public FiscalTransactionInformation getFiscalTransactionInformation() {
        return fiscalTransactionInformation;
    }

    public void setFiscalTransactionInformation(final FiscalTransactionInformation fiscalTransactionInformation) {
        this.fiscalTransactionInformation = fiscalTransactionInformation;
    }

    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public UserOptionalFields getUserOptionalFields() {
        return userOptionalFields;
    }

    public void setUserOptionalFields(final UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

    /**
     * Set HoldQueueLength.
     * @param holdQueueLength the length of the hold queue
     */
    public void setHoldQueueLength(final BigDecimal holdQueueLength) {

        this.holdQueueLength = holdQueueLength;

    }

    /**
     * Get HoldQueueLength.
     * @return the hold queue length
     */
    public BigDecimal getHoldQueueLength() {

        return holdQueueLength;

    }

    /**
     * Set HoldQueuePosition.
     * @param holdQueuePosition the position in the hold queue of this requested item
     */
    public void setHoldQueuePosition(final BigDecimal holdQueuePosition) {

        this.holdQueuePosition = holdQueuePosition;

    }

    /**
     * Get HoldQueuePosition.
     * @return the hold queue position of this requested item
     */
    public BigDecimal getHoldQueuePosition() {

        return holdQueuePosition;

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
        final RequestItemResponseData rhs = (RequestItemResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems)
            .append(requiredFeeAmount, rhs.requiredFeeAmount).append(requiredItemUseRestrictionTypes, rhs.requiredItemUseRestrictionTypes).append(itemId, rhs.itemId)
            .append(requestId, rhs.requestId).append(userId, rhs.userId).append(requestType, rhs.requestType).append(requestScopeType, rhs.requestScopeType)
            .append(shippingInformation, rhs.shippingInformation).append(dateAvailable, rhs.dateAvailable).append(holdPickupDate, rhs.holdPickupDate)
            .append(fiscalTransactionInformation, rhs.fiscalTransactionInformation).append(itemOptionalFields, rhs.itemOptionalFields)
            .append(userOptionalFields, rhs.userOptionalFields).append(holdQueuePosition, rhs.holdQueuePosition).append(holdQueueLength, rhs.holdQueueLength).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1021714959, 393090629).append(responseHeader).append(problems).append(requiredFeeAmount)
            .append(requiredItemUseRestrictionTypes).append(itemId).append(requestId).append(userId).append(requestType).append(requestScopeType).append(shippingInformation)
            .append(dateAvailable).append(holdPickupDate).append(fiscalTransactionInformation).append(itemOptionalFields).append(userOptionalFields).append(holdQueuePosition)
            .append(holdQueueLength).toHashCode();
        return result;
    }
}
