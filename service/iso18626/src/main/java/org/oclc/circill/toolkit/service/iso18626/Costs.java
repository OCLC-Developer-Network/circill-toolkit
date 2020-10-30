/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.CurrencyCode;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 */
public class Costs {
    protected CurrencyCode currencyCode;
    protected BigDecimal monetaryValue;

    public void setCurrencyCode(final CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setMonetaryValue(final BigDecimal monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    public BigDecimal getMonetaryValue() {
        return monetaryValue;
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
        final Costs rhs = (Costs) obj;
        final boolean result = new EqualsBuilder().append(currencyCode, rhs.currencyCode).append(monetaryValue, rhs.monetaryValue).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(37076143, 25663175).append(currencyCode).append(monetaryValue).toHashCode();
        return result;
    }
}
