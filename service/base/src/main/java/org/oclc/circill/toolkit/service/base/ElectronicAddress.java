/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An electronic address.
 */
public class ElectronicAddress {
    /**
     * Electronic Address Data
     */
    protected String electronicAddressData;
    /**
     * Electronic Address Type
     */
    protected ElectronicAddressType electronicAddressType;

    /**
     * Gets the value of the electronicAddressData property.
     *
     * @return the address data
     */
    public String getElectronicAddressData() {
        return electronicAddressData;
    }

    /**
     * Sets the value of the electronicAddressData property.
     *
     * @param electronicAddressData the electronic address data
     */
    public void setElectronicAddressData(final String electronicAddressData) {
        this.electronicAddressData = electronicAddressData;
    }

    /**
     * Gets the value of the electronicAddressType property.
     *
     * @return the {@link ElectronicAddressType}
     */
    public ElectronicAddressType getElectronicAddressType() {
        return electronicAddressType;
    }

    /**
     * Sets the value of the electronicAddressType property.
     *
     * @param electronicAddressType the {@link ElectronicAddressType}
     */
    public void setElectronicAddressType(final ElectronicAddressType electronicAddressType) {
        this.electronicAddressType = electronicAddressType;
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
        final ElectronicAddress rhs = (ElectronicAddress) obj;
        return new EqualsBuilder().append(electronicAddressData, rhs.electronicAddressData).append(electronicAddressType, rhs.electronicAddressType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1867542859, 1901226651).append(electronicAddressData).append(electronicAddressType).toHashCode();
        return result;
    }

}
