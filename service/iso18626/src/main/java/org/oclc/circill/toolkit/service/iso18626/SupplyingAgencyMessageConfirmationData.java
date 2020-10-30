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
 * Created by bodfishj on 2/13/18.
 */
public class SupplyingAgencyMessageConfirmationData implements ISO18626ConfirmationData {
    /**
     * Confirmation header
     */
    protected ConfirmationHeader confirmationHeader;

    /**
     * Error data
     */
    protected ErrorData errorData;

    /**
     * Reason for message
     */
    protected ReasonForMessage reasonForMessage;

    @Override
    public ConfirmationHeader getConfirmationHeader() {
        return confirmationHeader;
    }

    @Override
    public void setConfirmationHeader(final ConfirmationHeader confirmationHeader) {
        this.confirmationHeader = confirmationHeader;
    }

    @Override
    public ErrorData getErrorData() {
        return errorData;
    }

    @Override
    public void setErrorData(final ErrorData errorData) {
        this.errorData = errorData;
    }

    public ReasonForMessage getReasonForMessage() {
        return reasonForMessage;
    }

    public void setReasonForMessage(final ReasonForMessage reasonForMessage) {
        this.reasonForMessage = reasonForMessage;
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
        final SupplyingAgencyMessageConfirmationData rhs = (SupplyingAgencyMessageConfirmationData) obj;
        return new EqualsBuilder().append(confirmationHeader, rhs.confirmationHeader).append(reasonForMessage, rhs.reasonForMessage).append(errorData, rhs.errorData).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1246549229, 33375069).append(confirmationHeader).append(reasonForMessage).append(errorData).toHashCode();
        return result;
    }
}
