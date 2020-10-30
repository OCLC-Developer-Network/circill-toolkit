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

public class UserPrivilege {
    /**
     * Agency Id
     */
    protected AgencyId agencyId;
    /**
     * Agency User Privilege Type
     */
    protected AgencyUserPrivilegeType agencyUserPrivilegeType;
    /**
     * Valid From Date
     */
    protected GregorianCalendar validFromDate;
    /**
     * Valid To Date
     */
    protected GregorianCalendar validToDate;
    /**
     * User Privilege Fee
     */
    protected UserPrivilegeFee userPrivilegeFee;
    /**
     * UserPrivilegeStatus
     */
    protected UserPrivilegeStatus userPrivilegeStatus;
    /**
     * UserPrivilegeDescription
     */
    protected String userPrivilegeDescription;

    public AgencyId getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(final AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public AgencyUserPrivilegeType getAgencyUserPrivilegeType() {
        return agencyUserPrivilegeType;
    }

    public void setAgencyUserPrivilegeType(final AgencyUserPrivilegeType agencyUserPrivilegeType) {
        this.agencyUserPrivilegeType = agencyUserPrivilegeType;
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

    public UserPrivilegeFee getUserPrivilegeFee() {
        return userPrivilegeFee;
    }

    public void setUserPrivilegeFee(final UserPrivilegeFee userPrivilegeFee) {
        this.userPrivilegeFee = userPrivilegeFee;
    }

    public UserPrivilegeStatus getUserPrivilegeStatus() {
        return userPrivilegeStatus;
    }

    public void setUserPrivilegeStatus(final UserPrivilegeStatus userPrivilegeStatus) {
        this.userPrivilegeStatus = userPrivilegeStatus;
    }

    public String getUserPrivilegeDescription() {
        return userPrivilegeDescription;
    }

    public void setUserPrivilegeDescription(final String userPrivilegeDescription) {
        this.userPrivilegeDescription = userPrivilegeDescription;
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
        final UserPrivilege rhs = (UserPrivilege) obj;
        return new EqualsBuilder().append(agencyId, rhs.agencyId).append(agencyUserPrivilegeType, rhs.agencyUserPrivilegeType).append(validFromDate, rhs.validFromDate)
            .append(validToDate, rhs.validToDate).append(userPrivilegeFee, rhs.userPrivilegeFee).append(userPrivilegeStatus, rhs.userPrivilegeStatus)
            .append(userPrivilegeDescription, rhs.userPrivilegeDescription).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(908340999, 1800095579).append(agencyId).append(agencyUserPrivilegeType).append(validFromDate).append(validToDate)
            .append(userPrivilegeFee).append(userPrivilegeStatus).append(userPrivilegeDescription).toHashCode();
        return result;
    }
}
