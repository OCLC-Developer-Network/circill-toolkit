/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.PaymentMethodType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 */
public class BillingInfo {

    protected PaymentMethodType paymentMethod;
    protected Costs maximumCosts;
    protected BillingMethodType billingMethod;
    protected String billingName;
    protected Address address;

    public void setPaymentMethod(final PaymentMethodType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethodType getPaymentMethod() {
        return paymentMethod;
    }

    public void setMaximumCosts(final Costs maximumCosts) {
        this.maximumCosts = maximumCosts;
    }

    public Costs getMaximumCosts() {
        return maximumCosts;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setBillingMethod(final BillingMethodType billingMethod) {
        this.billingMethod = billingMethod;
    }

    public BillingMethodType getBillingMethod() {
        return billingMethod;
    }

    public void setBillingName(final String billingName) {
        this.billingName = billingName;
    }

    public String getBillingName() {
        return billingName;
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
        final BillingInfo rhs = (BillingInfo) obj;
        final boolean result = new EqualsBuilder().append(paymentMethod, rhs.paymentMethod).append(maximumCosts, rhs.maximumCosts).append(billingMethod, rhs.billingMethod)
            .append(billingName, rhs.billingName).append(address, rhs.address).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1426193549, 78268979).append(paymentMethod).append(maximumCosts).append(billingMethod).append(billingName).append(address)
            .toHashCode();
        return result;
    }
}
