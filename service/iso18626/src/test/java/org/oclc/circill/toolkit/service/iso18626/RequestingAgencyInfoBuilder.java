/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ReturnOfThis")
public final class RequestingAgencyInfoBuilder {

    private String name;
    private String contactName;
    private List<Address> addresses = new ArrayList<>();

    /**
     * This utility class does not allow instances.
     */
    private RequestingAgencyInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link RequestingAgencyInfo}
     */
    public static RequestingAgencyInfoBuilder aRequestingAgencyInfo() {
        final RequestingAgencyInfoBuilder builder = new RequestingAgencyInfoBuilder();
        return builder;
    }

    public RequestingAgencyInfoBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    public RequestingAgencyInfoBuilder withContactName(final String contactName) {
        this.contactName = contactName;
        return this;
    }

    public RequestingAgencyInfoBuilder withAddresses(final List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public RequestingAgencyInfo build() {
        final RequestingAgencyInfo requestingAgencyInfo = new RequestingAgencyInfo();
        requestingAgencyInfo.setName(name);
        requestingAgencyInfo.setContactName(contactName);
        requestingAgencyInfo.setAddresses(addresses);
        return requestingAgencyInfo;
    }

}

