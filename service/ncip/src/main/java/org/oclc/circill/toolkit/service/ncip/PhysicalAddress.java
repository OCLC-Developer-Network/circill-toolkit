/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PhysicalAddress {

    /**
     * Structured Address
     */
    protected StructuredAddress structuredAddress;
    /**
     * Unstructured Address
     */
    protected UnstructuredAddress unstructuredAddress;
    /**
     * PhysicalAddressType
     */
    protected PhysicalAddressType physicalAddressType;

    public StructuredAddress getStructuredAddress() {
        return structuredAddress;
    }

    public void setStructuredAddress(final StructuredAddress structuredAddress) {
        this.structuredAddress = structuredAddress;
    }

    public UnstructuredAddress getUnstructuredAddress() {
        return unstructuredAddress;
    }

    public void setUnstructuredAddress(final UnstructuredAddress unstructuredAddress) {
        this.unstructuredAddress = unstructuredAddress;
    }

    public PhysicalAddressType getPhysicalAddressType() {
        return physicalAddressType;
    }

    public void setPhysicalAddressType(final PhysicalAddressType physicalAddressType) {
        this.physicalAddressType = physicalAddressType;
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
        final PhysicalAddress rhs = (PhysicalAddress) obj;
        return new EqualsBuilder().append(structuredAddress, rhs.structuredAddress).append(unstructuredAddress, rhs.unstructuredAddress)
            .append(physicalAddressType, rhs.physicalAddressType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(4086363, 277314857).append(structuredAddress).append(unstructuredAddress).append(physicalAddressType).toHashCode();
        return result;
    }
}
