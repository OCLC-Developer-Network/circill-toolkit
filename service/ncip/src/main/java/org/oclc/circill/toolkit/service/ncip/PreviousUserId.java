/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PreviousUserId {
    /**
     * Agency Id
     */
    protected AgencyId agencyId;
    /**
     * User Identifier Value
     */
    protected String userIdentifierValue;
    /**
     * Valid From Date
     */
    protected GregorianCalendar validFromDate;
    /**
     * ValidToDate
     */
    protected GregorianCalendar validToDate;

    public AgencyId getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(final AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public String getUserIdentifierValue() {
        return userIdentifierValue;
    }

    public void setUserIdentifierValue(final String userIdentifierValue) {
        this.userIdentifierValue = userIdentifierValue;
    }

    public GregorianCalendar getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(final GregorianCalendar validFromDate) {
        this.validFromDate = validFromDate;
    }

    public GregorianCalendar getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(final GregorianCalendar validToDate) {
        this.validToDate = validToDate;
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
        final PreviousUserId rhs = (PreviousUserId) obj;
        return new EqualsBuilder().append(agencyId, rhs.agencyId).append(userIdentifierValue, rhs.userIdentifierValue).append(validFromDate, rhs.validFromDate)
            .append(validToDate, rhs.validToDate).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(4086363, 277314857).append(agencyId).append(userIdentifierValue).append(validFromDate).append(validToDate).toHashCode();
        return result;
    }
}
