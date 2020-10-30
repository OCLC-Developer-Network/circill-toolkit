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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the ItemRequestUpdated service.
 */
public class ItemRequestUpdatedInitiationData implements NCIPInitiationData {

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
     * DeleteRequestFields
     */
    protected DeleteRequestFields deleteRequestFields;

    /**
     * Set DeleteRequestFields.
     *
     * @param deleteRequestFields the {@link DeleteRequestFields}
     */
    public void setDeleteRequestFields(final DeleteRequestFields deleteRequestFields) {

        this.deleteRequestFields = deleteRequestFields;

    }

    /**
     * Get DeleteRequestFields.
     *
     * @return the {@link DeleteRequestFields}
     */
    public DeleteRequestFields getDeleteRequestFields() {

        return deleteRequestFields;

    }

    /**
     * AddRequestFields
     */
    protected AddRequestFields addRequestFields;

    /**
     * Set AddRequestFields.
     *
     * @param addRequestFields the {@link AddRequestFields}
     */
    public void setAddRequestFields(final AddRequestFields addRequestFields) {

        this.addRequestFields = addRequestFields;

    }

    /**
     * Get AddRequestFields.
     *
     * @return the {@link AddRequestFields}
     */
    public AddRequestFields getAddRequestFields() {

        return addRequestFields;

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
        final ItemRequestUpdatedInitiationData rhs = (ItemRequestUpdatedInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId).append(userId, rhs.userId)
            .append(itemId, rhs.itemId).append(requestType, rhs.requestType).append(requestId, rhs.requestId).append(deleteRequestFields, rhs.deleteRequestFields)
            .append(addRequestFields, rhs.addRequestFields).append(itemOptionalFields, rhs.itemOptionalFields).append(userOptionalFields, rhs.userOptionalFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(658739579, 187389481).append(initiationHeader).append(relyingPartyId).append(userId).append(itemId).append(requestType)
            .append(requestId).append(deleteRequestFields).append(addRequestFields).append(itemOptionalFields).append(userOptionalFields).toHashCode();
        return result;
    }
}
