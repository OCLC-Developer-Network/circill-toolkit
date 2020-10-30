/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.PaymentMethodType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserPrivilegeFee {
    /**
     * Amount
     */
    protected Amount amount;
    /**
     * Payment Method Type
     */
    protected PaymentMethodType paymentMethodType;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(final Amount amount) {
        this.amount = amount;
    }

    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(final PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    /**
     * Generic toString() implementation.
     *
     * @return String
     */
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
        final UserPrivilegeFee rhs = (UserPrivilegeFee) obj;
        return new EqualsBuilder().append(amount, rhs.amount).append(paymentMethodType, rhs.paymentMethodType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1366359379, 1918612889).append(amount).append(paymentMethodType).toHashCode();
        return result;
    }

}
