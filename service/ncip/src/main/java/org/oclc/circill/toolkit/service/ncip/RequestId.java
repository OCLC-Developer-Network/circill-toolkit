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
 * Request Id
 */
public class RequestId {

    protected String requestIdentifierValue;
    protected AgencyId agencyId;
    protected RequestIdentifierType requestIdentifierType;

    /**
     * Set the request id's value
     *
     * @param requestIdentifierValue the identifier of the request
     */
    public void setRequestIdentifierValue(final String requestIdentifierValue) {
        this.requestIdentifierValue = requestIdentifierValue;
    }

    /**
     * Returns the request identifier.
     *
     * @return the identifier of the request
     */
    public String getRequestIdentifierValue() {
        return requestIdentifierValue;
    }

    public void setRequestIdentifierType(final RequestIdentifierType requestIdentifierType) {
        this.requestIdentifierType = requestIdentifierType;
    }

    /**
     * Returns the identifier's type (e.g. hold #, external request identifier, etc.)
     *
     * @return the identifier's type
     */
    public RequestIdentifierType getRequestIdentifierType() {
        return requestIdentifierType;
    }

    public void setAgencyId(final AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * Returns the id of the agency associated with this request.
     *
     * @return the agency id for the agency associated with this request
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
        final RequestId rhs = (RequestId) obj;
        return new EqualsBuilder().append(requestIdentifierValue, rhs.requestIdentifierValue).append(agencyId, rhs.agencyId)
            .append(requestIdentifierType, rhs.requestIdentifierType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(21246821, 1156381965).append(requestIdentifierValue).append(agencyId).append(requestIdentifierType).toHashCode();
        return result;
    }
}
