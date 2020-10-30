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
public class RequestConfirmationData implements ISO18626ConfirmationData {
    /**
     * Confirmation header
     */
    protected ConfirmationHeader confirmationHeader;

    /**
     * Error data
     */
    protected ErrorData errorData;

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
        final RequestConfirmationData rhs = (RequestConfirmationData) obj;
        return new EqualsBuilder().append(confirmationHeader, rhs.confirmationHeader).append(errorData, rhs.errorData).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1127600585, 160835031).append(confirmationHeader).append(errorData).toHashCode();
        return result;
    }
}
