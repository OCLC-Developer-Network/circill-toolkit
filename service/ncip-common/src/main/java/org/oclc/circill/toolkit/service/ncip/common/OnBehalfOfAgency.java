/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the OnBehalfOfAgency.
 */
public class OnBehalfOfAgency {

    /**
     * AgencyId
     */
    protected AgencyId agencyId;

    /**
     * Set AgencyId.
     * @param agencyId the {@link AgencyId}
     */
    public void setAgencyId(final AgencyId agencyId) {

        this.agencyId = agencyId;

    }

    /**
     * Get AgencyId.
     * @return the {@link AgencyId}
     */
    public AgencyId getAgencyId() {

        return agencyId;

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
        final OnBehalfOfAgency rhs = (OnBehalfOfAgency) obj;
        return new EqualsBuilder().append(agencyId, rhs.agencyId).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(623161055, 388071157).append(agencyId).toHashCode();
        return result;
    }
}
