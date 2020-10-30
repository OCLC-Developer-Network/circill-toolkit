/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 */
public class Header {

    protected AgencyId supplyingAgencyId;
    protected AgencyId requestingAgencyId;
    protected String multipleItemRequestId;
    protected Calendar timestamp;
    protected String requestingAgencyRequestId;
    protected String supplyingAgencyRequestId;
    protected RequestingAgencyAuthentication requestingAgencyAuthentication;

    public AgencyId getSupplyingAgencyId() {
        return supplyingAgencyId;
    }

    public void setSupplyingAgencyId(final AgencyId supplyingAgencyId) {
        this.supplyingAgencyId = supplyingAgencyId;
    }

    public AgencyId getRequestingAgencyId() {
        return requestingAgencyId;
    }

    public void setRequestingAgencyId(final AgencyId requestingAgencyId) {
        this.requestingAgencyId = requestingAgencyId;
    }

    public String getMultipleItemRequestId() {
        return multipleItemRequestId;
    }

    public void setMultipleItemRequestId(final String multipleItemRequestId) {
        this.multipleItemRequestId = multipleItemRequestId;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestingAgencyRequestId() {
        return requestingAgencyRequestId;
    }

    public void setRequestingAgencyRequestId(final String requestingAgencyRequestId) {
        this.requestingAgencyRequestId = requestingAgencyRequestId;
    }

    public String getSupplyingAgencyRequestId() {
        return supplyingAgencyRequestId;
    }

    public void setSupplyingAgencyRequestId(final String supplyingAgencyRequestId) {
        this.supplyingAgencyRequestId = supplyingAgencyRequestId;
    }

    public RequestingAgencyAuthentication getRequestingAgencyAuthentication() {
        return requestingAgencyAuthentication;
    }

    public void setRequestingAgencyAuthentication(final RequestingAgencyAuthentication requestingAgencyAuthentication) {
        this.requestingAgencyAuthentication = requestingAgencyAuthentication;
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
        final Header rhs = (Header) obj;
        return new EqualsBuilder().append(supplyingAgencyId, rhs.supplyingAgencyId).append(requestingAgencyId, rhs.requestingAgencyId)
            .append(multipleItemRequestId, rhs.multipleItemRequestId).append(timestamp, rhs.timestamp).append(requestingAgencyRequestId, rhs.requestingAgencyRequestId)
            .append(supplyingAgencyRequestId, rhs.supplyingAgencyRequestId).append(requestingAgencyAuthentication, rhs.requestingAgencyAuthentication).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1396423585, 2108301551).append(supplyingAgencyId).append(requestingAgencyId).append(multipleItemRequestId).append(timestamp)
            .append(requestingAgencyRequestId).append(supplyingAgencyRequestId).append(requestingAgencyAuthentication).toHashCode();
        return result;
    }
}
