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

public class MandatedAction {

    /**
     * Date Event Occurred
     */
    protected GregorianCalendar dateEventOccurred;

    public GregorianCalendar getDateEventOccurred() {
        return dateEventOccurred;
    }

    public void setDateEventOccurred(final GregorianCalendar dateEventOccurred) {
        this.dateEventOccurred = dateEventOccurred;
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
        final MandatedAction rhs = (MandatedAction) obj;
        return new EqualsBuilder().append(dateEventOccurred, rhs.dateEventOccurred).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(254718231, 1247391367).append(dateEventOccurred).toHashCode();
        return result;
    }
}
