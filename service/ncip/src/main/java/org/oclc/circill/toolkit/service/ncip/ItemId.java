/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents identifiers for items.
 * Note: an "item" in NCIP is typically the circulating unit.
 */
public class ItemId {

    /**
     * The identifier of this item.
     */
    protected String itemIdentifierValue;
    /**
     * The id of the agency associated with this item.
     */
    protected AgencyId agencyId;
    /**
     * The type of the identifier, indicates whether e.g. this is an item barcode, item record #, etc.
     */
    protected ItemIdentifierType itemIdentifierType;

    public void setItemIdentifierValue(final String itemIdentifierValue) {
        this.itemIdentifierValue = itemIdentifierValue;
    }

    /**
     * Returns the identifier value.
     *
     * @return the identifier value
     */
    public String getItemIdentifierValue() {
        return itemIdentifierValue;
    }

    public void setItemIdentifierType(final ItemIdentifierType itemIdentifierType) {
        this.itemIdentifierType = itemIdentifierType;
    }

    /**
     * Returns the id's identifier type.
     *
     * @return the id's identifier type
     */
    public ItemIdentifierType getItemIdentifierType() {
        return itemIdentifierType;
    }

    public void setAgencyId(final AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * Returns the id's agency id.
     *
     * @return the id's agency id
     */
    public AgencyId getAgencyId() {
        return agencyId;
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
        final ItemId rhs = (ItemId) obj;
        return new EqualsBuilder().append(itemIdentifierValue, rhs.itemIdentifierValue).append(agencyId, rhs.agencyId).append(itemIdentifierType, rhs.itemIdentifierType)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1895508875, 652749153).append(itemIdentifierValue).append(agencyId).append(itemIdentifierType).toHashCode();
        return result;
    }
}
