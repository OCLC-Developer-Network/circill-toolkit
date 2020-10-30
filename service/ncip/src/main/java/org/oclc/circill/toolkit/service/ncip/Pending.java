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
 * Carries data elements describing the Pending.
 */
public class Pending {

    /**
     * DateOfExpectedReply
     */
    protected GregorianCalendar dateOfExpectedReply;

    /**
     * Set DateOfExpectedReply.
     *
     * @param dateOfExpectedReply the date by which the reply is expected
     */
    public void setDateOfExpectedReply(final GregorianCalendar dateOfExpectedReply) {

        this.dateOfExpectedReply = dateOfExpectedReply;

    }

    /**
     * Get DateOfExpectedReply.
     *
     * @return the date by which a reply is expected
     */
    public GregorianCalendar getDateOfExpectedReply() {

        return dateOfExpectedReply;

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
        final Pending rhs = (Pending) obj;
        return new EqualsBuilder().append(dateOfExpectedReply, rhs.dateOfExpectedReply).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(623161055, 388071157).append(dateOfExpectedReply).toHashCode();
        return result;
    }
}
