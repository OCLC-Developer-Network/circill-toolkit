/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Electronic resource entity, such as a computer file or the full text of the Item.
 */
public class ElectronicResource {

    /**
     * The electronic resource entity, such as a computer file or the full text of the Item
     */
    protected String actualResource;
    /**
     * the data type of the electronic resource. Values are specified in the IANA Registry of Media Types
     */
    protected ElectronicDataFormatType electronicDataFormatType;
    /**
     * Provides a pointer to the resource rather than providing the resource itself
     */
    protected String referenceToResource;
    /**
     * Count of views (downloads, uses, etc.) remaining
     */
    protected BigDecimal remainingViewsCount;

    /**
     * Date on which this resource expires.
     */
    protected GregorianCalendar expiryDate;

    /**
     * Whether the resource has expired.
     */
    protected boolean isExpired = false;

    public String getActualResource() {
        return actualResource;
    }

    public void setActualResource(final String actualResource) {
        this.actualResource = actualResource;
    }

    public ElectronicDataFormatType getElectronicDataFormatType() {
        return electronicDataFormatType;
    }

    public void setElectronicDataFormatType(final ElectronicDataFormatType electronicDataFormatType) {
        this.electronicDataFormatType = electronicDataFormatType;
    }

    public String getReferenceToResource() {
        return referenceToResource;
    }

    public void setReferenceToResource(final String referenceToResource) {
        this.referenceToResource = referenceToResource;
    }

    public BigDecimal getRemainingViewsCount() {
        return remainingViewsCount;
    }

    public void setRemainingViewsCount(final BigDecimal remainingViewsCount) {
        this.remainingViewsCount = remainingViewsCount;
    }

    public GregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(final GregorianCalendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(final boolean isExpired) {
        this.isExpired = isExpired;
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
        final ElectronicResource rhs = (ElectronicResource) obj;
        return new EqualsBuilder().append(actualResource, rhs.actualResource).append(electronicDataFormatType, rhs.electronicDataFormatType)
            .append(referenceToResource, rhs.referenceToResource).append(remainingViewsCount, rhs.remainingViewsCount).append(expiryDate, rhs.expiryDate)
            .append(isExpired, rhs.isExpired).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1255745517, 1994663559).append(actualResource).append(electronicDataFormatType).append(referenceToResource)
            .append(remainingViewsCount).append(expiryDate).append(isExpired).toHashCode();
        return result;
    }
}
