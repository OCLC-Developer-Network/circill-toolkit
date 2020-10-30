/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Describes a RequestedItemsCount result from an NCIP response
 */
public class RequestedItemsCount {

    protected RequestType requestType;
    protected CirculationStatus circulationStatus;
    protected ItemUseRestrictionType itemUseRestrictionType;
    protected BigDecimal requestedItemCountValue;

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(final RequestType requestType) {
        this.requestType = requestType;
    }

    public CirculationStatus getCirculationStatus() {
        return circulationStatus;
    }

    public void setCirculationStatus(final CirculationStatus circulationStatus) {
        this.circulationStatus = circulationStatus;
    }

    public ItemUseRestrictionType getItemUseRestrictionType() {
        return itemUseRestrictionType;
    }

    public void setItemUseRestrictionType(final ItemUseRestrictionType itemUseRestrictionType) {
        this.itemUseRestrictionType = itemUseRestrictionType;
    }

    public BigDecimal getRequestedItemCountValue() {
        return requestedItemCountValue;
    }

    public void setRequestedItemCountValue(final BigDecimal requestedItemCountValue) {
        this.requestedItemCountValue = requestedItemCountValue;
    }

    /*
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
        final RequestedItemsCount rhs = (RequestedItemsCount) obj;
        return new EqualsBuilder().append(requestType, rhs.requestType).append(circulationStatus, rhs.circulationStatus).append(itemUseRestrictionType, rhs.itemUseRestrictionType)
            .append(requestedItemCountValue, rhs.requestedItemCountValue).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(21246821, 1156381965).append(requestType).append(circulationStatus).append(itemUseRestrictionType).append(requestedItemCountValue)
            .toHashCode();
        return result;
    }
}
