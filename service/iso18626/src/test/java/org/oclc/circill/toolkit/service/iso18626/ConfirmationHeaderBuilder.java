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
public final class ConfirmationHeaderBuilder {

    private AgencyId supplyingAgencyId;
    private AgencyId requestingAgencyId;
    private Calendar timestamp;
    private String requestingAgencyRequestId;
    private String multipleItemRequestId;
    private Calendar timestampReceived;
    private MessageStatus messageStatus;

    /**
     * This utility class does not allow instances.
     */
    private ConfirmationHeaderBuilder() {
    }

    /**
     * -
     * @return a builder for {@link ConfirmationHeader}
     */
    public static ConfirmationHeaderBuilder aConfirmationHeader() {
        final ConfirmationHeaderBuilder builder = new ConfirmationHeaderBuilder();
        return builder;
    }

    public ConfirmationHeaderBuilder withSupplyingAgencyId(final AgencyId supplyingAgencyId) {
        this.supplyingAgencyId = supplyingAgencyId;
        return this;
    }

    public ConfirmationHeaderBuilder withRequestingAgencyId(final AgencyId requestingAgencyId) {
        this.requestingAgencyId = requestingAgencyId;
        return this;
    }

    public ConfirmationHeaderBuilder withTimestamp(final Calendar timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ConfirmationHeaderBuilder withRequestingAgencyRequestId(final String requestingAgencyRequestId) {
        this.requestingAgencyRequestId = requestingAgencyRequestId;
        return this;
    }

    public ConfirmationHeaderBuilder withMultipleItemRequestId(final String multipleItemRequestId) {
        this.multipleItemRequestId = multipleItemRequestId;
        return this;
    }

    public ConfirmationHeaderBuilder withTimestampReceived(final Calendar timestampReceived) {
        this.timestampReceived = timestampReceived;
        return this;
    }

    public ConfirmationHeaderBuilder withMessageStatus(final MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
        return this;
    }

    public ConfirmationHeader build() {
        final ConfirmationHeader confirmationHeader = new ConfirmationHeader();
        confirmationHeader.setSupplyingAgencyId(supplyingAgencyId);
        confirmationHeader.setRequestingAgencyId(requestingAgencyId);
        confirmationHeader.setTimestamp(timestamp);
        confirmationHeader.setRequestingAgencyRequestId(requestingAgencyRequestId);
        confirmationHeader.setMultipleItemRequestId(multipleItemRequestId);
        confirmationHeader.setTimestampReceived(timestampReceived);
        confirmationHeader.setMessageStatus(messageStatus);
        return confirmationHeader;
    }

}

