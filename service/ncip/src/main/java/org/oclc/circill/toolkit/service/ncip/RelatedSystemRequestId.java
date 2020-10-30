/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.FromSystemId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The RequestId from an 'other' system that is involved in this request.
 * E.g. An ILL system might include this for an ILL request that began as a Circ Hold request,
 * or the borrowing circ system might include this for a resource sharing request that was
 * filled by another circulation system (e.g. the lender in a direct-consortial borrowing profile).
 *
 */
public class RelatedSystemRequestId {

    /**
     * From System Id.
     */
    protected FromSystemId fromSystemId;

    /**
     * Request Id.
     */
    protected RequestId requestId;

    public FromSystemId getFromSystemId() {
        return fromSystemId;
    }

    public void setFromSystemId(final FromSystemId fromSystemId) {
        this.fromSystemId = fromSystemId;
    }

    public RequestId getRequestId() {
        return requestId;
    }

    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
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
        final RelatedSystemRequestId rhs = (RelatedSystemRequestId) obj;
        return new EqualsBuilder().append(fromSystemId, rhs.fromSystemId).append(requestId, rhs.requestId).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(795927281, 540641583).append(fromSystemId).append(requestId).toHashCode();
        return result;
    }
}
