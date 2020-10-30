/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 */
public class RequestingAgencyInfo {

    protected String name;
    protected String contactName;
    protected List<Address> addresses = new ArrayList<>();

    public String getContactName() {
        return contactName;
    }

    public void setContactName(final String contactName) {
        this.contactName = contactName;
    }

    public String getName() {

        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Address getAddress() {
        return addresses != null ? (addresses.size() > 0 ? addresses.get(addresses.size() - 1) : null) : null;
    }

    public Address getAddress(final int index) {
        return addresses != null ? (addresses.size() > 0 ? addresses.get(index) : null) : null;
    }

    public void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setAddress(final int index, final Address address) {
        addresses.set(index, address);
    }

    public void setAddress(final Address address) {
        if (this.addresses != null) {
            this.addresses.clear();
        }
        if (address != null) {
            if (this.addresses == null) {
                this.addresses = new ArrayList<>();
            }
            this.addresses.add(address);
        } else {
            this.addresses = null;
        }
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
        final RequestingAgencyInfo rhs = (RequestingAgencyInfo) obj;
        final boolean result = new EqualsBuilder().append(name, rhs.name).append(contactName, rhs.contactName).append(addresses, rhs.addresses).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1439181623, 389257907).append(name).append(contactName).append(addresses).toHashCode();
        return result;
    }
}

