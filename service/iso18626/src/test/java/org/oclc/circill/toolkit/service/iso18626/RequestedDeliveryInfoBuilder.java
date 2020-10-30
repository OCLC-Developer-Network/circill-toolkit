/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class RequestedDeliveryInfoBuilder {

    private Integer sortOrder;
    private Address address;

    /**
     * This utility class does not allow instances.
     */
    private RequestedDeliveryInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link RequestedDeliveryInfo}
     */
    public static RequestedDeliveryInfoBuilder aRequestedDeliveryInfo() {
        final RequestedDeliveryInfoBuilder builder = new RequestedDeliveryInfoBuilder();
        return builder;
    }

    public RequestedDeliveryInfoBuilder withSortOrder(final Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public RequestedDeliveryInfoBuilder withAddress(final Address address) {
        this.address = address;
        return this;
    }

    public RequestedDeliveryInfo build() {
        final RequestedDeliveryInfo requestedDeliveryInfo = new RequestedDeliveryInfo();
        requestedDeliveryInfo.setSortOrder(sortOrder);
        requestedDeliveryInfo.setAddress(address);
        return requestedDeliveryInfo;
    }

}

