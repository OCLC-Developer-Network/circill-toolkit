/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 */
public class RequestedDeliveryInfo {

    protected Integer sortOrder;
    protected Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Integer getSortOrder() {

        return sortOrder;
    }

    public void setSortOrder(final Integer sortOrder) {
        this.sortOrder = sortOrder;
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
        final RequestedDeliveryInfo rhs = (RequestedDeliveryInfo) obj;
        final boolean result = new EqualsBuilder().append(sortOrder, rhs.sortOrder).append(address, rhs.address).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(899745581, 1420488129).append(sortOrder).append(address).toHashCode();
        return result;
    }

}
