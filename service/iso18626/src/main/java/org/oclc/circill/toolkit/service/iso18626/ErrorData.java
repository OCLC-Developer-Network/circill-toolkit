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
 * Created by bodfishj on 2/7/18.
 */
public class ErrorData {
    protected ErrorType errorType;
    protected String errorValue;

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(final ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(final String errorValue) {
        this.errorValue = errorValue;
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
        final ErrorData rhs = (ErrorData) obj;
        return new EqualsBuilder().append(errorType, rhs.errorType).append(errorValue, rhs.errorValue).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(611208367, 1291135661).append(errorType).append(errorValue).toHashCode();
        return result;
    }
}
