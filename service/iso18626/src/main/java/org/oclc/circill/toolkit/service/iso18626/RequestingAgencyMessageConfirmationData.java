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
public class RequestingAgencyMessageConfirmationData implements ISO18626ConfirmationData {
    /**
     * Confirmation header
     */
    protected ConfirmationHeader confirmationHeader;

    /**
     * Error data
     */
    protected ErrorData errorData;

    /**
     * Action
     */
    protected Action action;

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

    public Action getAction() {
        return action;
    }

    public void setAction(final Action action) {
        this.action = action;
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
        final RequestingAgencyMessageConfirmationData rhs = (RequestingAgencyMessageConfirmationData) obj;
        return new EqualsBuilder().append(confirmationHeader, rhs.confirmationHeader).append(action, rhs.action).append(errorData, rhs.errorData).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1246549229, 33375069).append(confirmationHeader).append(action).append(errorData).toHashCode();
        return result;
    }
}
