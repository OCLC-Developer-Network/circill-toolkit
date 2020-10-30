/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ElectronicAddress;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserAddressInformation {
    /**
     * User Address Role Type
     */
    protected UserAddressRoleType userAddressRoleType;
    /**
     * Valid From Date
     */
    protected GregorianCalendar validFromDate;
    /**
     * Valid To Date
     */
    protected GregorianCalendar validToDate;
    /**
     * Physical Address
     */
    protected PhysicalAddress physicalAddress;
    /**
     * Electronic Address
     */
    protected ElectronicAddress electronicAddress;

    public UserAddressRoleType getUserAddressRoleType() {
        return userAddressRoleType;
    }

    public void setUserAddressRoleType(final UserAddressRoleType userAddressRoleType) {
        this.userAddressRoleType = userAddressRoleType;
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

    public PhysicalAddress getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(final PhysicalAddress physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public ElectronicAddress getElectronicAddress() {
        return electronicAddress;
    }

    public void setElectronicAddress(final ElectronicAddress electronicAddress) {
        this.electronicAddress = electronicAddress;
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
        final UserAddressInformation rhs = (UserAddressInformation) obj;
        return new EqualsBuilder().append(userAddressRoleType, rhs.userAddressRoleType).append(validFromDate, rhs.validFromDate).append(validToDate, rhs.validToDate)
            .append(physicalAddress, rhs.physicalAddress).append(electronicAddress, rhs.electronicAddress).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1671592897, 1323047669).append(userAddressRoleType).append(validFromDate).append(validToDate).append(physicalAddress)
            .append(electronicAddress).toHashCode();
        return result;
    }
}
