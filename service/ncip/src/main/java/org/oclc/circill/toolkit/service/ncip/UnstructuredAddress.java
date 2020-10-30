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

public class UnstructuredAddress {
    /**
     * Unstructured Address Data
     */
    protected String unstructuredAddressData;
    /**
     * Unstructured Address Type
     */
    protected UnstructuredAddressType unstructuredAddressType;

    public String getUnstructuredAddressData() {
        return unstructuredAddressData;
    }

    public void setUnstructuredAddressData(final String unstructuredAddressData) {
        this.unstructuredAddressData = unstructuredAddressData;
    }

    public UnstructuredAddressType getUnstructuredAddressType() {
        return unstructuredAddressType;
    }

    public void setUnstructuredAddressType(final UnstructuredAddressType unstructuredAddressType) {
        this.unstructuredAddressType = unstructuredAddressType;
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
        final UnstructuredAddress rhs = (UnstructuredAddress) obj;
        return new EqualsBuilder().append(unstructuredAddressData, rhs.unstructuredAddressData).append(unstructuredAddressType, rhs.unstructuredAddressType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1265352451, 821625633).append(unstructuredAddressData).append(unstructuredAddressType).toHashCode();
        return result;
    }

}
