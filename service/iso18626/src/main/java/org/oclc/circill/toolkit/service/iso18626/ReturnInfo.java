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
 * If the Supplier asks the Requester to return the item to another address.
 */
public class ReturnInfo {

    protected AgencyId returnAgencyId;
    protected String name;
    protected PhysicalAddress physicalAddress;

    public AgencyId getReturnAgencyId() {
        return returnAgencyId;
    }

    public void setReturnAgencyId(final AgencyId returnAgencyId) {
        this.returnAgencyId = returnAgencyId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public PhysicalAddress getPhysicalAddress() {
        return physicalAddress;
    }

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
        final ReturnInfo rhs = (ReturnInfo) obj;
        final boolean result = new EqualsBuilder().append(returnAgencyId, rhs.returnAgencyId).append(name, rhs.name).append(physicalAddress, rhs.physicalAddress).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1667177175, 1235913607).append(returnAgencyId).append(name).append(physicalAddress).toHashCode();
        return result;
    }

}
