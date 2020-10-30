/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class SupplyingAgencyMessageDataBuilder {

    private Header header;
    private MessageInfo messageInfo;
    private StatusInfo statusInfo;
    private DeliveryInfo deliveryInfo;
    private ReturnInfo returnInfo;

    /**
     * This utility class does not allow instances.
     */
    private SupplyingAgencyMessageDataBuilder() {
    }

    /**
     * -
     * @return a builder for {@link SupplyingAgencyMessageData}
     */
    public static SupplyingAgencyMessageDataBuilder aSupplyingAgencyMessageData() {
        final SupplyingAgencyMessageDataBuilder builder = new SupplyingAgencyMessageDataBuilder();
        return builder;
    }

    public SupplyingAgencyMessageDataBuilder withHeader(final Header header) {
        this.header = header;
        return this;
    }

    public SupplyingAgencyMessageDataBuilder withMessageInfo(final MessageInfo messageInfo) {
        this.messageInfo = messageInfo;
        return this;
    }

    public SupplyingAgencyMessageDataBuilder withStatusInfo(final StatusInfo statusInfo) {
        this.statusInfo = statusInfo;
        return this;
    }

    public SupplyingAgencyMessageDataBuilder withDeliveryInfo(final DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
        return this;
    }

    public SupplyingAgencyMessageDataBuilder withReturnInfo(final ReturnInfo returnInfo) {
        this.returnInfo = returnInfo;
        return this;
    }

    public SupplyingAgencyMessageData build() {
        final SupplyingAgencyMessageData supplyingAgencyMessageData = new SupplyingAgencyMessageData();
        supplyingAgencyMessageData.setHeader(header);
        supplyingAgencyMessageData.setMessageInfo(messageInfo);
        supplyingAgencyMessageData.setStatusInfo(statusInfo);
        supplyingAgencyMessageData.setDeliveryInfo(deliveryInfo);
        supplyingAgencyMessageData.setReturnInfo(returnInfo);
        return supplyingAgencyMessageData;
    }

}

