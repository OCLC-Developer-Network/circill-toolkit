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
 * Data to initiate the ItemUpdated service.
 */
public class ItemUpdatedInitiationData implements NCIPInitiationData {

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
     * DeleteItemFields
     */
    protected DeleteItemFields deleteItemFields;

    /**
     * Set DeleteItemFields.
     *
     * @param deleteItemFields the {@link DeleteItemFields}
     */
    public void setDeleteItemFields(final DeleteItemFields deleteItemFields) {

        this.deleteItemFields = deleteItemFields;

    }

    /**
     * Get DeleteItemFields.
     *
     * @return the {@link DeleteItemFields}
     */
    public DeleteItemFields getDeleteItemFields() {

        return deleteItemFields;

    }

    /**
     * AddItemFields
     */
    protected AddItemFields addItemFields;

    /**
     * Set AddItemFields.
     *
     * @param addItemFields the {@link AddItemFields}
     */
    public void setAddItemFields(final AddItemFields addItemFields) {

        this.addItemFields = addItemFields;

    }

    /**
     * Get AddItemFields.
     *
     * @return the {@link AddItemFields}
     */
    public AddItemFields getAddItemFields() {

        return addItemFields;

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
        final ItemUpdatedInitiationData rhs = (ItemUpdatedInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId).append(itemId, rhs.itemId)
            .append(deleteItemFields, rhs.deleteItemFields).append(addItemFields, rhs.addItemFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(803690305, 1066030279).append(initiationHeader).append(relyingPartyId).append(itemId).append(deleteItemFields)
            .append(addItemFields).toHashCode();
        return result;
    }
}
