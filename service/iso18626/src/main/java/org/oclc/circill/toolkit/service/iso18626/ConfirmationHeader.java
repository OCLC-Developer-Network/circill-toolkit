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
 * Created by bodfishj on 2/13/18.
 */
public class ConfirmationHeader {

    protected AgencyId supplyingAgencyId;
    protected AgencyId requestingAgencyId;
    protected Calendar timestamp;
    protected String requestingAgencyRequestId;
    protected String multipleItemRequestId;
    protected Calendar timestampReceived;
    protected MessageStatus messageStatus;

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

    public String getMultipleItemRequestId() {
        return multipleItemRequestId;
    }

    public void setMultipleItemRequestId(final String multipleItemRequestId) {
        this.multipleItemRequestId = multipleItemRequestId;
    }

    public Calendar getTimestampReceived() {
        return timestampReceived;
    }

    public void setTimestampReceived(final Calendar timestampReceived) {
        this.timestampReceived = timestampReceived;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(final MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
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
        final ConfirmationHeader rhs = (ConfirmationHeader) obj;
        return new EqualsBuilder().append(supplyingAgencyId, rhs.supplyingAgencyId).append(requestingAgencyId, rhs.requestingAgencyId).append(timestamp, rhs.timestamp)
            .append(requestingAgencyRequestId, rhs.requestingAgencyRequestId).append(multipleItemRequestId, rhs.multipleItemRequestId)
            .append(timestampReceived, rhs.timestampReceived).append(messageStatus, rhs.messageStatus).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1497903539, 2069645667).append(supplyingAgencyId).append(requestingAgencyId).append(timestamp).append(requestingAgencyRequestId)
            .append(multipleItemRequestId).append(timestampReceived).append(messageStatus).toHashCode();
        return result;
    }
}
