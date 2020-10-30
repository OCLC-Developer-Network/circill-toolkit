/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.CurrencyCode;

import java.math.BigDecimal;

@SuppressWarnings("ReturnOfThis")
public final class CostsBuilder {

    private CurrencyCode currencyCode;
    private BigDecimal monetaryValue;

    /**
     * This utility class does not allow instances.
     */
    private CostsBuilder() {
    }

    /**
     * -
     * @return a builder for {@link Costs}
     */
    public static CostsBuilder aCosts() {
        final CostsBuilder builder = new CostsBuilder();
        return builder;
    }

    public CostsBuilder withCurrencyCode(final CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public CostsBuilder withMonetaryValue(final BigDecimal monetaryValue) {
        this.monetaryValue = monetaryValue;
        return this;
    }

    public Costs build() {
        final Costs costs = new Costs();
        costs.setCurrencyCode(currencyCode);
        costs.setMonetaryValue(monetaryValue);
        return costs;
    }

}

