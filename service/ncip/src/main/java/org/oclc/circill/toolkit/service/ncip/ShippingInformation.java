/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ElectronicAddress;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ShippingInformation {
    /**
     * Shipping Instructions
     */
    protected String shippingInstructions;
    /**
     * Shipping Notes
     */
    protected String shippingNote;
    /**
     * Physical Address
     */
    protected PhysicalAddress physicalAddress;
    /**
     * Electronic Address
     */
    protected ElectronicAddress electronicAddress;

    public String getShippingInstructions() {
        return shippingInstructions;
    }

    public void setShippingInstructions(final String shippingInstructions) {
        this.shippingInstructions = shippingInstructions;
    }

    public String getShippingNote() {
        return shippingNote;
    }

    public void setShippingNote(final String shippingNote) {
        this.shippingNote = shippingNote;
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
        final ShippingInformation rhs = (ShippingInformation) obj;
        return new EqualsBuilder().append(shippingInstructions, rhs.shippingInstructions).append(shippingNote, rhs.shippingNote).append(physicalAddress, rhs.physicalAddress)
            .append(electronicAddress, rhs.electronicAddress).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(113904473, 1544410473).append(shippingInstructions).append(shippingNote).append(physicalAddress).append(electronicAddress)
            .toHashCode();
        return result;
    }
}
