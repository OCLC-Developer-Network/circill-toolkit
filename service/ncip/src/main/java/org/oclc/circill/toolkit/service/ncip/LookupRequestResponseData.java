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

/**
 * Carries data elements describing the LookupRequestResponse.
 */
public class LookupRequestResponseData implements NCIPResponseData {

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
     * RequestId
     */
    protected RequestId requestId;

    /**
     * Set RequestId.
     *
     * @param requestId the {@link RequestId}
     */
    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    /**
     * Get RequestId.
     *
     * @return the {@link RequestId}
     */
    public RequestId getRequestId() {
        return requestId;
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
     * RequestStatusType
     */
    protected RequestStatusType requestStatusType;

    /**
     * Set RequestStatusType.
     *
     * @param requestStatusType the {@link RequestStatusType}
     */
    public void setRequestStatusType(final RequestStatusType requestStatusType) {
        this.requestStatusType = requestStatusType;
    }

    /**
     * Get RequestStatusType.
     *
     * @return the {@link RequestStatusType}
     */
    public RequestStatusType getRequestStatusType() {
        return requestStatusType;
    }

    /**
     * HoldQueuePosition
     */
    protected BigDecimal holdQueuePosition;

    /**
     * Set HoldQueuePosition.
     *
     * @param holdQueuePosition the position in the hold queue
     */
    public void setHoldQueuePosition(final BigDecimal holdQueuePosition) {
        this.holdQueuePosition = holdQueuePosition;
    }

    /**
     * Get HoldQueuePosition.
     *
     * @return the {@link BigDecimal}
     */
    public BigDecimal getHoldQueuePosition() {
        return holdQueuePosition;
    }

    /**
     * ShippingInformation
     */
    protected ShippingInformation shippingInformation;

    /**
     * Set ShippingInformation.
     *
     * @param shippingInformation the {@link ShippingInformation}
     */
    public void setShippingInformation(final ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    /**
     * Get ShippingInformation.
     *
     * @return the {@link ShippingInformation}
     */
    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    /**
     * EarliestDateNeeded
     */
    protected GregorianCalendar earliestDateNeeded;

    /**
     * Set EarliestDateNeeded.
     *
     * @param earliestDateNeeded the earliest-date-needed
     */
    public void setEarliestDateNeeded(final GregorianCalendar earliestDateNeeded) {
        this.earliestDateNeeded = earliestDateNeeded;
    }

    /**
     * Get EarliestDateNeeded.
     *
     * @return the earliest date the item is needed
     */
    public GregorianCalendar getEarliestDateNeeded() {
        return earliestDateNeeded;
    }

    /**
     * NeedBeforeDate
     */
    protected GregorianCalendar needBeforeDate;

    /**
     * Set NeedBeforeDate.
     *
     * @param needBeforeDate the need-before date
     */
    public void setNeedBeforeDate(final GregorianCalendar needBeforeDate) {
        this.needBeforeDate = needBeforeDate;
    }

    /**
     * Get NeedBeforeDate.
     *
     * @return the need-before date
     */
    public GregorianCalendar getNeedBeforeDate() {
        return needBeforeDate;
    }

    /**
     * PickupDate
     */
    protected GregorianCalendar pickupDate;

    /**
     * Set PickupDate.
     *
     * @param pickupDate the pickup date
     */
    public void setPickupDate(final GregorianCalendar pickupDate) {
        this.pickupDate = pickupDate;
    }

    /**
     * Get PickupDate.
     *
     * @return the pickup date
     */
    public GregorianCalendar getPickupDate() {
        return pickupDate;
    }

    /**
     * PickupLocation
     */
    protected PickupLocation pickupLocation;

    /**
     * Set PickupLocation.
     *
     * @param pickupLocation the {@link PickupLocation}
     */
    public void setPickupLocation(final PickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    /**
     * Get PickupLocation.
     *
     * @return the {@link PickupLocation}
     */
    public PickupLocation getPickupLocation() {
        return pickupLocation;
    }

    /**
     * PickupExpiryDate
     */
    protected GregorianCalendar pickupExpiryDate;

    /**
     * Set PickupExpiryDate.
     *
     * @param pickupExpiryDate the pickup-expiry date
     */
    public void setPickupExpiryDate(final GregorianCalendar pickupExpiryDate) {
        this.pickupExpiryDate = pickupExpiryDate;
    }

    /**
     * Get PickupExpiryDate.
     *
     * @return the pickup expiry date
     */
    public GregorianCalendar getPickupExpiryDate() {
        return pickupExpiryDate;
    }

    /**
     * DateOfUserRequest
     */
    protected GregorianCalendar dateOfUserRequest;

    /**
     * Set DateOfUserRequest.
     *
     * @param dateOfUserRequest the date of the user's request
     */
    public void setDateOfUserRequest(final GregorianCalendar dateOfUserRequest) {
        this.dateOfUserRequest = dateOfUserRequest;
    }

    /**
     * Get DateOfUserRequest.
     *
     * @return the date of the user's request
     */
    public GregorianCalendar getDateOfUserRequest() {
        return dateOfUserRequest;
    }

    /**
     * DateAvailable
     */
    protected GregorianCalendar dateAvailable;

    /**
     * Set DateAvailable.
     *
     * @param dateAvailable the date-available
     */
    public void setDateAvailable(final GregorianCalendar dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    /**
     * Get DateAvailable.
     *
     * @return the date the item will be available
     */
    public GregorianCalendar getDateAvailable() {
        return dateAvailable;
    }

    /**
     * AcknowledgedFeeAmount
     */
    protected AcknowledgedFeeAmount acknowledgedFeeAmount;

    /**
     * Set AcknowledgedFeeAmount.
     *
     * @param acknowledgedFeeAmount the {@link AcknowledgedFeeAmount}
     */
    public void setAcknowledgedFeeAmount(final AcknowledgedFeeAmount acknowledgedFeeAmount) {
        this.acknowledgedFeeAmount = acknowledgedFeeAmount;
    }

    /**
     * Get AcknowledgedFeeAmount.
     *
     * @return the {@link AcknowledgedFeeAmount}
     */
    public AcknowledgedFeeAmount getAcknowledgedFeeAmount() {
        return acknowledgedFeeAmount;
    }

    /**
     * PaidFeeAmount
     */
    protected PaidFeeAmount paidFeeAmount;

    /**
     * Set PaidFeeAmount.
     *
     * @param paidFeeAmount the {@link PaidFeeAmount}
     */
    public void setPaidFeeAmount(final PaidFeeAmount paidFeeAmount) {
        this.paidFeeAmount = paidFeeAmount;
    }

    /**
     * Get PaidFeeAmount.
     *
     * @return the {@link PaidFeeAmount}
     */
    public PaidFeeAmount getPaidFeeAmount() {
        return paidFeeAmount;
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
        final LookupRequestResponseData rhs = (LookupRequestResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems).append(itemId, rhs.itemId)
            .append(requestId, rhs.requestId).append(userId, rhs.userId).append(requestType, rhs.requestType).append(requestScopeType, rhs.requestScopeType)
            .append(requestStatusType, rhs.requestStatusType).append(holdQueuePosition, rhs.holdQueuePosition).append(shippingInformation, rhs.shippingInformation)
            .append(earliestDateNeeded, rhs.earliestDateNeeded).append(needBeforeDate, rhs.needBeforeDate).append(pickupDate, rhs.pickupDate)
            .append(pickupLocation, rhs.pickupLocation).append(pickupExpiryDate, rhs.pickupExpiryDate).append(dateOfUserRequest, rhs.dateOfUserRequest)
            .append(dateAvailable, rhs.dateAvailable).append(acknowledgedFeeAmount, rhs.acknowledgedFeeAmount).append(paidFeeAmount, rhs.paidFeeAmount)
            .append(itemOptionalFields, rhs.itemOptionalFields).append(userOptionalFields, rhs.userOptionalFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(736277271, 748768595).append(responseHeader).append(problems).append(itemId).append(requestId).append(userId)
            .append(requestType).append(requestScopeType).append(requestStatusType).append(holdQueuePosition).append(shippingInformation).append(earliestDateNeeded)
            .append(needBeforeDate).append(pickupDate).append(pickupLocation).append(pickupExpiryDate).append(dateOfUserRequest).append(dateAvailable).append(acknowledgedFeeAmount)
            .append(paidFeeAmount).append(itemOptionalFields).append(userOptionalFields).toHashCode();
        return result;
    }
}
