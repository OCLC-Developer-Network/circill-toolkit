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
public final class DeliveryInfoBuilder {

    private Calendar dateSent;
    private String itemId;
    private SentViaType sentVia;
    private Boolean sentToPatron;
    private LoanConditionType loanCondition;
    private DeliveredFormatType deliveredFormat;
    private Costs deliveryCosts;

    /**
     * This utility class does not allow instances.
     */
    private DeliveryInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link DeliveryInfo}
     */
    public static DeliveryInfoBuilder aDeliveryInfo() {
        final DeliveryInfoBuilder builder = new DeliveryInfoBuilder();
        return builder;
    }

    public DeliveryInfoBuilder withDateSent(final Calendar dateSent) {
        this.dateSent = dateSent;
        return this;
    }

    public DeliveryInfoBuilder withItemId(final String itemId) {
        this.itemId = itemId;
        return this;
    }

    public DeliveryInfoBuilder withSentVia(final SentViaType sentVia) {
        this.sentVia = sentVia;
        return this;
    }

    public DeliveryInfoBuilder withSentToPatron(final Boolean sentToPatron) {
        this.sentToPatron = sentToPatron;
        return this;
    }

    public DeliveryInfoBuilder withLoanCondition(final LoanConditionType loanCondition) {
        this.loanCondition = loanCondition;
        return this;
    }

    public DeliveryInfoBuilder withDeliveredFormat(final DeliveredFormatType deliveredFormat) {
        this.deliveredFormat = deliveredFormat;
        return this;
    }

    public DeliveryInfoBuilder withDeliveryCosts(final Costs deliveryCosts) {
        this.deliveryCosts = deliveryCosts;
        return this;
    }

    public DeliveryInfo build() {
        final DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setDateSent(dateSent);
        deliveryInfo.setItemId(itemId);
        deliveryInfo.setSentVia(sentVia);
        deliveryInfo.setSentToPatron(sentToPatron);
        deliveryInfo.setLoanCondition(loanCondition);
        deliveryInfo.setDeliveredFormat(deliveredFormat);
        deliveryInfo.setDeliveryCosts(deliveryCosts);
        return deliveryInfo;
    }

}

