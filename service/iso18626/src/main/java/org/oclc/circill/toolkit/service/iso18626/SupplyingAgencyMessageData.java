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
 * The Supplying Agency Message.
 */
public class SupplyingAgencyMessageData implements ISO18626RequestData {
    /**
     * Header
     */
    protected Header header;
    /**
     * MessageInfo
     */
    protected MessageInfo messageInfo;
    /**
     * StatusInfo
     */
    protected StatusInfo statusInfo;
    /**
     * DeliveryInfo
     */
    protected DeliveryInfo deliveryInfo;
    /**
     * ReturnInfo
     */
    protected ReturnInfo returnInfo;

    /**
     * Get the header.
     *
     * @return the header
     */
    @Override
    public Header getHeader() {
        return header;
    }

    /**
     * Set the header.
     *
     * @param header the header
     */
    @Override
    public void setHeader(final Header header) {
        this.header = header;
    }

    public MessageInfo getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(final MessageInfo messageInfo) {
        this.messageInfo = messageInfo;
    }

    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(final StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(final DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public ReturnInfo getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(final ReturnInfo returnInfo) {
        this.returnInfo = returnInfo;
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
        final SupplyingAgencyMessageData rhs = (SupplyingAgencyMessageData) obj;
        return new EqualsBuilder().append(header, rhs.header).append(messageInfo, rhs.messageInfo).append(statusInfo, rhs.statusInfo).append(deliveryInfo, rhs.deliveryInfo)
            .append(returnInfo, rhs.returnInfo).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1687572403, 1699550485).append(header).append(messageInfo).append(statusInfo).append(deliveryInfo).append(returnInfo).toHashCode();
        return result;
    }
}
