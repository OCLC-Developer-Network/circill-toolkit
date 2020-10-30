/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Identifies a user.
 */
public class UserId {

    protected AgencyId agencyId;

    protected UserIdentifierType userIdentifierType;

    protected String userIdentifierValue;

    public AgencyId getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(final AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public UserIdentifierType getUserIdentifierType() {
        return userIdentifierType;
    }

    public void setUserIdentifierType(final UserIdentifierType userIdentifierType) {
        this.userIdentifierType = userIdentifierType;
    }

    public String getUserIdentifierValue() {
        return userIdentifierValue;
    }

    public void setUserIdentifierValue(final String userIdentifierValue) {
        this.userIdentifierValue = userIdentifierValue;
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
        final UserId rhs = (UserId) obj;
        return new EqualsBuilder().append(agencyId, rhs.agencyId).append(userIdentifierType, rhs.userIdentifierType).append(userIdentifierValue, rhs.userIdentifierValue)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1674651051, 1956145625).append(agencyId).append(userIdentifierType).append(userIdentifierValue).toHashCode();
        return result;
    }

}
