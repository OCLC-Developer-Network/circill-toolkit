/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.ElectronicAddress;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An electronic of physical address.
 */
public class Address {

    protected ElectronicAddress electronicAddress;
    protected PhysicalAddress physicalAddress;

    /**
     * Gets the value of the electronicAddress property.
     *
     * @return
     *     possible object is
     *     {@link ElectronicAddress }
     *
     */
    public ElectronicAddress getElectronicAddress() {
        return electronicAddress;
    }

    /**
     * Sets the value of the electronicAddress property.
     *
     * @param electronicAddress
     *     allowed object is
     *     {@link ElectronicAddress }
     *
     */
    public void setElectronicAddress(final ElectronicAddress electronicAddress) {
        this.electronicAddress = electronicAddress;
    }

    /**
     * Gets the value of the physicalAddress property.
     *
     * @return
     *     possible object is
     *     {@link PhysicalAddress }
     *
     */
    public PhysicalAddress getPhysicalAddress() {
        return physicalAddress;
    }

    /**
     * Sets the value of the physicalAddress property.
     *
     * @param physicalAddress
     *     allowed object is
     *     {@link PhysicalAddress }
     *
     */
    public void setPhysicalAddress(final PhysicalAddress physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

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
        final Address rhs = (Address) obj;
        final boolean result = new EqualsBuilder().append(physicalAddress, rhs.physicalAddress).append(electronicAddress, rhs.electronicAddress).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(440087809, 360385799).append(physicalAddress).append(electronicAddress).toHashCode();
        return result;
    }
}
