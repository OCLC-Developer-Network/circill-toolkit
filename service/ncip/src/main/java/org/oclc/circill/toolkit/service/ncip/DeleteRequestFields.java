/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the DeleteRequestFields.
 */
public class DeleteRequestFields {

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
     * @param earliestDateNeeded the earliest date the item is needed
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
     * @return the pickup-expiry date
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
     * @param dateAvailable the date the item will be available
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

    protected GregorianCalendar suspensionStartDate;

    protected GregorianCalendar suspensionEndDate;

    public GregorianCalendar getSuspensionStartDate() {
        return suspensionStartDate;
    }

    public void setSuspensionStartDate(final GregorianCalendar suspensionStartDate) {
        this.suspensionStartDate = suspensionStartDate;
    }

    public GregorianCalendar getSuspensionEndDate() {
        return suspensionEndDate;
    }

    public void setSuspensionEndDate(final GregorianCalendar suspensionEndDate) {
        this.suspensionEndDate = suspensionEndDate;
    }

    /** ItemOptionalFields */
    protected ItemOptionalFields itemOptionalFields;

    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    /** User note */
    protected String userNote;

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(final String userNote) {
        this.userNote = userNote;
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
        final DeleteRequestFields rhs = (DeleteRequestFields) obj;
        return new EqualsBuilder().append(userId, rhs.userId).append(itemId, rhs.itemId).append(requestType, rhs.requestType).append(requestScopeType, rhs.requestScopeType)
            .append(requestStatusType, rhs.requestStatusType).append(shippingInformation, rhs.shippingInformation).append(earliestDateNeeded, rhs.earliestDateNeeded)
            .append(needBeforeDate, rhs.needBeforeDate).append(pickupLocation, rhs.pickupLocation).append(pickupExpiryDate, rhs.pickupExpiryDate)
            .append(dateOfUserRequest, rhs.dateOfUserRequest).append(dateAvailable, rhs.dateAvailable).append(acknowledgedFeeAmount, rhs.acknowledgedFeeAmount)
            .append(paidFeeAmount, rhs.paidFeeAmount).append(suspensionStartDate, rhs.suspensionStartDate).append(suspensionEndDate, rhs.suspensionEndDate)
            .append(itemOptionalFields, rhs.itemOptionalFields).append(userNote, rhs.userNote).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1744715439, 191477441).append(userId).append(itemId).append(requestType).append(requestScopeType).append(requestStatusType)
            .append(shippingInformation).append(earliestDateNeeded).append(needBeforeDate).append(pickupLocation).append(pickupExpiryDate).append(dateOfUserRequest)
            .append(dateAvailable).append(acknowledgedFeeAmount).append(paidFeeAmount).append(suspensionStartDate).append(suspensionEndDate).append(itemOptionalFields)
            .append(userNote).toHashCode();
        return result;
    }
}
