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
public final class HeaderBuilder {

    private AgencyId supplyingAgencyId;
    private AgencyId requestingAgencyId;
    private String multipleItemRequestId;
    private Calendar timestamp;
    private String requestingAgencyRequestId;
    private String supplyingAgencyRequestId;
    private RequestingAgencyAuthentication requestingAgencyAuthentication;

    /**
     * This utility class does not allow instances.
     */
    private HeaderBuilder() {
    }

    /**
     * -
     * @return a builder for {@link Header}
     */
    public static HeaderBuilder aHeader() {
        final HeaderBuilder builder = new HeaderBuilder();
        return builder;
    }

    public HeaderBuilder withSupplyingAgencyId(final AgencyId supplyingAgencyId) {
        this.supplyingAgencyId = supplyingAgencyId;
        return this;
    }

    public HeaderBuilder withRequestingAgencyId(final AgencyId requestingAgencyId) {
        this.requestingAgencyId = requestingAgencyId;
        return this;
    }

    public HeaderBuilder withMultipleItemRequestId(final String multipleItemRequestId) {
        this.multipleItemRequestId = multipleItemRequestId;
        return this;
    }

    public HeaderBuilder withTimestamp(final Calendar timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public HeaderBuilder withRequestingAgencyRequestId(final String requestingAgencyRequestId) {
        this.requestingAgencyRequestId = requestingAgencyRequestId;
        return this;
    }

    public HeaderBuilder withSupplyingAgencyRequestId(final String supplyingAgencyRequestId) {
        this.supplyingAgencyRequestId = supplyingAgencyRequestId;
        return this;
    }

    public HeaderBuilder withRequestingAgencyAuthentication(final RequestingAgencyAuthentication requestingAgencyAuthentication) {
        this.requestingAgencyAuthentication = requestingAgencyAuthentication;
        return this;
    }

    public Header build() {
        final Header header = new Header();
        header.setSupplyingAgencyId(supplyingAgencyId);
        header.setRequestingAgencyId(requestingAgencyId);
        header.setMultipleItemRequestId(multipleItemRequestId);
        header.setTimestamp(timestamp);
        header.setRequestingAgencyRequestId(requestingAgencyRequestId);
        header.setSupplyingAgencyRequestId(supplyingAgencyRequestId);
        header.setRequestingAgencyAuthentication(requestingAgencyAuthentication);
        return header;
    }

}

