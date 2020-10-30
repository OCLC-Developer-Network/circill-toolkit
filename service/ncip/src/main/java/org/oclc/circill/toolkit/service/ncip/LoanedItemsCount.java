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
 * Describes a LoanedItemsCount result from an NCIP response
 */
public class LoanedItemsCount {

    protected CirculationStatus circulationStatus;
    protected ItemUseRestrictionType itemUseRestrictionType;
    protected BigDecimal loanedItemCountValue;

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

    public BigDecimal getLoanedItemCountValue() {
        return loanedItemCountValue;
    }

    public void setLoanedItemCountValue(final BigDecimal loanedItemCountValue) {
        this.loanedItemCountValue = loanedItemCountValue;
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
        final LoanedItemsCount rhs = (LoanedItemsCount) obj;
        return new EqualsBuilder().append(circulationStatus, rhs.circulationStatus).append(itemUseRestrictionType, rhs.itemUseRestrictionType)
            .append(loanedItemCountValue, rhs.loanedItemCountValue).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(714266185, 1808718639).append(circulationStatus).append(itemUseRestrictionType).append(loanedItemCountValue).toHashCode();
        return result;
    }
}
