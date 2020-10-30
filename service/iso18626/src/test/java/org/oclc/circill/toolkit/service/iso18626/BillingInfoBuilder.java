/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.PaymentMethodType;

@SuppressWarnings("ReturnOfThis")
public final class BillingInfoBuilder {

    private PaymentMethodType paymentMethod;
    private Costs maximumCosts;
    private BillingMethodType billingMethod;
    private String billingName;
    private Address address;

    /**
     * This utility class does not allow instances.
     */
    private BillingInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link BillingInfo}
     */
    public static BillingInfoBuilder aBillingInfo() {
        final BillingInfoBuilder builder = new BillingInfoBuilder();
        return builder;
    }

    public BillingInfoBuilder withPaymentMethod(final PaymentMethodType paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public BillingInfoBuilder withMaximumCosts(final Costs maximumCosts) {
        this.maximumCosts = maximumCosts;
        return this;
    }

    public BillingInfoBuilder withBillingMethod(final BillingMethodType billingMethod) {
        this.billingMethod = billingMethod;
        return this;
    }

    public BillingInfoBuilder withBillingName(final String billingName) {
        this.billingName = billingName;
        return this;
    }

    public BillingInfoBuilder withAddress(final Address address) {
        this.address = address;
        return this;
    }

    public BillingInfo build() {
        final BillingInfo billingInfo = new BillingInfo();
        billingInfo.setPaymentMethod(paymentMethod);
        billingInfo.setMaximumCosts(maximumCosts);
        billingInfo.setBillingMethod(billingMethod);
        billingInfo.setBillingName(billingName);
        billingInfo.setAddress(address);
        return billingInfo;
    }

}

