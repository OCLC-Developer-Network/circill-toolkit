/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the FromAgencyId.
 */
public class FromAgencyId {

    /**
     * AgencyId
     */
    protected List<AgencyId> agencyIds = new ArrayList<>();

    /**
     * Set AgencyId.
     * @param agencyId the {@link AgencyId}
     */
    public void setAgencyId(final AgencyId agencyId) {

        this.agencyIds.add(agencyId);

    }

    /**
     * Set the list of AgencyIds.
     * @param agencyIds the list of AgencyIds
     */
    public void setAgencyIds(final List<AgencyId> agencyIds) {

        this.agencyIds = agencyIds;

    }

    /**
     * Get AgencyId.
     * @return the {@link AgencyId}
     */
    public AgencyId getAgencyId() {

        return agencyIds != null ? (agencyIds.size() > 0 ? agencyIds.get(agencyIds.size() - 1) : null) : null;

    }

    /**
     * Get the list of AgencyIds
     * @return the list of AgencyIds
     */
    public List<AgencyId> getAgencyIds() {

        return agencyIds;

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
        final FromAgencyId rhs = (FromAgencyId) obj;
        return new EqualsBuilder().append(agencyIds, rhs.agencyIds).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(817955299, 1320306035).append(agencyIds).toHashCode();
        return result;
    }
}
