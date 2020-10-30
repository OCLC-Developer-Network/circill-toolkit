/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.Calendar;

@SuppressWarnings("ReturnOfThis")
public final class StatusInfoBuilder {

    private Status status;
    private Calendar expectedDeliveryDate;
    private Calendar dueDate;
    private Calendar lastChange;

    /**
     * This utility class does not allow instances.
     */
    private StatusInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link StatusInfo}
     */
    public static StatusInfoBuilder aStatusInfo() {
        final StatusInfoBuilder builder = new StatusInfoBuilder();
        return builder;
    }

    public StatusInfoBuilder withStatus(final Status status) {
        this.status = status;
        return this;
    }

    public StatusInfoBuilder withExpectedDeliveryDate(final Calendar expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
        return this;
    }

    public StatusInfoBuilder withDueDate(final Calendar dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public StatusInfoBuilder withLastChange(final Calendar lastChange) {
        this.lastChange = lastChange;
        return this;
    }

    public StatusInfo build() {
        final StatusInfo statusInfo = new StatusInfo();
        statusInfo.setStatus(status);
        statusInfo.setExpectedDeliveryDate(expectedDeliveryDate);
        statusInfo.setDueDate(dueDate);
        statusInfo.setLastChange(lastChange);
        return statusInfo;
    }

}

