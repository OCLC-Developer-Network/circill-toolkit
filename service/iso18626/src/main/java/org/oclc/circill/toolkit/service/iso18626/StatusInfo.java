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
public class StatusInfo {

    protected Status status;
    protected Calendar expectedDeliveryDate;
    protected Calendar dueDate;
    protected Calendar lastChange;

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Calendar getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(final Calendar expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(final Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Calendar getLastChange() {
        return lastChange;
    }

    public void setLastChange(final Calendar lastChange) {
        this.lastChange = lastChange;
    }

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
        final StatusInfo rhs = (StatusInfo) obj;
        final boolean result = new EqualsBuilder().append(status, rhs.status).append(expectedDeliveryDate, rhs.expectedDeliveryDate).append(dueDate, rhs.dueDate)
            .append(lastChange, rhs.lastChange).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1185433597, 1086955935).append(status).append(expectedDeliveryDate).append(dueDate).append(lastChange).toHashCode();
        return result;
    }

}
