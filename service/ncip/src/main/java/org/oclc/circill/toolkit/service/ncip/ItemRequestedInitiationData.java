/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the ItemRequested service.
 */
public class ItemRequestedInitiationData implements NCIPInitiationData {

    /**
     * InitiationHeader
     */
    protected InitiationHeader initiationHeader;

    /**
     * Set InitiationHeader.
     */
    @Override
    public void setInitiationHeader(final InitiationHeader initiationHeader) {

        this.initiationHeader = initiationHeader;

    }

    /**
     * Get InitiationHeader.
     */
    @Override
    public InitiationHeader getInitiationHeader() {

        return initiationHeader;

    }

    /**
     * Relying Party Id
     */
    protected AgencyId relyingPartyId;

    /**
     * Get the RelyingPartyId.
     *
     * @return the RelyingPartyId
     */
    @Override
    public AgencyId getRelyingPartyId() {
        return relyingPartyId;
    }

    /**
     * Set the RelyingPartyId.
     *
     * @param relyingPartyId the RelyingPartyId
     */
    @Override
    public void setRelyingPartyId(final AgencyId relyingPartyId) {
        this.relyingPartyId = relyingPartyId;
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
     * BibliographicId
     */
    protected BibliographicId bibliographicId;

    /**
     * Set BibliographicId.
     *
     * @param bibliographicId the {@link BibliographicId}
     */
    public void setBibliographicId(final BibliographicId bibliographicId) {

        this.bibliographicId = bibliographicId;

    }

    /**
     * Get BibliographicId.
     *
     * @return the {@link BibliographicId}
     */
    public BibliographicId getBibliographicId() {

        return bibliographicId;

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
     * @return the earliest date needed
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
     * @param needBeforeDate the need-before-date
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
     * @param pickupExpiryDate the pickup expiry date
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
     * @param dateAvailable the date the item is expected to be available to the user
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
        final ItemRequestedInitiationData rhs = (ItemRequestedInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId).append(userId, rhs.userId)
            .append(itemId, rhs.itemId).append(bibliographicId, rhs.bibliographicId).append(requestId, rhs.requestId).append(requestType, rhs.requestType)
            .append(requestScopeType, rhs.requestScopeType).append(shippingInformation, rhs.shippingInformation).append(earliestDateNeeded, rhs.earliestDateNeeded)
            .append(needBeforeDate, rhs.needBeforeDate).append(pickupLocation, rhs.pickupLocation).append(pickupExpiryDate, rhs.pickupExpiryDate)
            .append(dateOfUserRequest, rhs.dateOfUserRequest).append(dateAvailable, rhs.dateAvailable).append(itemOptionalFields, rhs.itemOptionalFields)
            .append(userOptionalFields, rhs.userOptionalFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(658739579, 187389481).append(initiationHeader).append(relyingPartyId).append(userId).append(itemId).append(bibliographicId)
            .append(requestId).append(requestType).append(requestScopeType).append(shippingInformation).append(earliestDateNeeded).append(needBeforeDate).append(pickupLocation)
            .append(pickupExpiryDate).append(dateOfUserRequest).append(dateAvailable).append(itemOptionalFields).append(userOptionalFields).toHashCode();
        return result;
    }
}
