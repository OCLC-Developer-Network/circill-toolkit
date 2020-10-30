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

public class UserPrivilegeStatus {

    /**
     * User Privilege Status Type
     */
    protected UserPrivilegeStatusType userPrivilegeStatusType;
    /**
     * Date Of User Privilege Status
     */
    protected GregorianCalendar dateOfUserPrivilegeStatus;

    public UserPrivilegeStatusType getUserPrivilegeStatusType() {
        return userPrivilegeStatusType;
    }

    public void setUserPrivilegeStatusType(final UserPrivilegeStatusType userPrivilegeStatusType) {
        this.userPrivilegeStatusType = userPrivilegeStatusType;
    }

    public GregorianCalendar getDateOfUserPrivilegeStatus() {
        return dateOfUserPrivilegeStatus;
    }

    public void setDateOfUserPrivilegeStatus(final GregorianCalendar dateOfUserPrivilegeStatus) {
        this.dateOfUserPrivilegeStatus = dateOfUserPrivilegeStatus;
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
        final UserPrivilegeStatus rhs = (UserPrivilegeStatus) obj;
        return new EqualsBuilder().append(userPrivilegeStatusType, rhs.userPrivilegeStatusType).append(dateOfUserPrivilegeStatus, rhs.dateOfUserPrivilegeStatus).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(134354947, 947693151).append(userPrivilegeStatusType).append(dateOfUserPrivilegeStatus).toHashCode();
        return result;
    }

}
