/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Contains Holdings Chronology AND/OR Holdings Enumeration.
 */
public class StructuredHoldingsData {
    protected HoldingsChronology holdingsChronology;
    protected HoldingsEnumeration holdingsEnumeration;

    public HoldingsChronology getHoldingsChronology() {
        return holdingsChronology;
    }

    public void setHoldingsChronology(final HoldingsChronology holdingsChronology) {
        this.holdingsChronology = holdingsChronology;
    }

    public HoldingsEnumeration getHoldingsEnumeration() {
        return holdingsEnumeration;
    }

    public void setHoldingsEnumeration(final HoldingsEnumeration holdingsEnumeration) {
        this.holdingsEnumeration = holdingsEnumeration;
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
        final StructuredHoldingsData rhs = (StructuredHoldingsData) obj;
        return new EqualsBuilder().append(holdingsChronology, rhs.holdingsChronology).append(holdingsEnumeration, rhs.holdingsEnumeration).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(402640255, 1341226599).append(holdingsChronology).append(holdingsEnumeration).toHashCode();
        return result;
    }
}
