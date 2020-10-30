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
public class AgencyId {
    protected AgencyIdType agencyIdType;
    protected String agencyIdValue;

    public AgencyIdType getAgencyIdType() {
        return agencyIdType;
    }

    public void setAgencyIdType(final AgencyIdType agencyIdType) {
        this.agencyIdType = agencyIdType;
    }

    public String getAgencyIdValue() {
        return agencyIdValue;
    }

    public void setAgencyIdValue(final String agencyIdValue) {
        this.agencyIdValue = agencyIdValue;
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
        final AgencyId rhs = (AgencyId) obj;
        final boolean result = new EqualsBuilder().append(agencyIdType, rhs.agencyIdType).append(agencyIdValue, rhs.agencyIdValue).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1455581671, 1227639411).append(agencyIdType).append(agencyIdValue).toHashCode();
        return result;
    }
}
