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

/**
 * Carries data elements describing the AgencyAddressInformation.
 */
public class AgencyAddressInformation {

    /**
     * AgencyAddressRoleType
     */
    protected AgencyAddressRoleType agencyAddressRoleType;

    /**
     * Set AgencyAddressRoleType.
     *
     * @param agencyAddressRoleType the {@link AgencyAddressRoleType}
     */
    public void setAgencyAddressRoleType(final AgencyAddressRoleType agencyAddressRoleType) {

        this.agencyAddressRoleType = agencyAddressRoleType;

    }

    /**
     * Get AgencyAddressRoleType.
     *
     * @return the {@link AgencyAddressRoleType}
     */
    public AgencyAddressRoleType getAgencyAddressRoleType() {

        return agencyAddressRoleType;

    }

    /**
     * ValidFromDate
     */
    protected GregorianCalendar validFromDate;

    /**
     * Set ValidFromDate.
     *
     * @param validFromDate the valid-from date
     */
    public void setValidFromDate(final GregorianCalendar validFromDate) {

        this.validFromDate = validFromDate;

    }

    /**
     * Get ValidFromDate.
     *
     * @return the valid-from date
     */
    public GregorianCalendar getValidFromDate() {

        return validFromDate;

    }

    /**
     * ValidToDate
     */
    protected GregorianCalendar validToDate;

    /**
     * Set ValidToDate.
     *
     * @param validToDate the valid-to date
     */
    public void setValidToDate(final GregorianCalendar validToDate) {

        this.validToDate = validToDate;

    }

    /**
     * Get ValidToDate.
     *
     * @return the valid-to date
     */
    public GregorianCalendar getValidToDate() {

        return validToDate;

    }

    /**
     * PhysicalAddress
     */
    protected PhysicalAddress physicalAddress;

    /**
     * Set PhysicalAddress.
     *
     * @param physicalAddress the {@link PhysicalAddress}
     */
    public void setPhysicalAddress(final PhysicalAddress physicalAddress) {

        this.physicalAddress = physicalAddress;

    }

    /**
     * Get PhysicalAddress.
     *
     * @return the {@link PhysicalAddress}
     */
    public PhysicalAddress getPhysicalAddress() {

        return physicalAddress;

    }

    /**
     * ElectronicAddress
     */
    protected ElectronicAddress electronicAddress;

    /**
     * Set ElectronicAddress.
     *
     * @param electronicAddress the {@link ElectronicAddress}
     */
    public void setElectronicAddress(final ElectronicAddress electronicAddress) {

        this.electronicAddress = electronicAddress;

    }

    /**
     * Get ElectronicAddress.
     *
     * @return the {@link ElectronicAddress}
     */
    public ElectronicAddress getElectronicAddress() {

        return electronicAddress;

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
        final AgencyAddressInformation rhs = (AgencyAddressInformation) obj;
        return new EqualsBuilder().append(agencyAddressRoleType, rhs.agencyAddressRoleType).append(validFromDate, rhs.validFromDate).append(validToDate, rhs.validToDate)
            .append(physicalAddress, rhs.physicalAddress).append(electronicAddress, rhs.electronicAddress).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2133176635, 1738001861).append(agencyAddressRoleType).append(validFromDate).append(validToDate).append(physicalAddress)
            .append(electronicAddress).toHashCode();
        return result;
    }
}
