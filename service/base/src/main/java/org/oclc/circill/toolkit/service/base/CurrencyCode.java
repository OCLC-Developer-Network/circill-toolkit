/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Identifies a currency code.
 */
@SuppressWarnings("squid:S1206") // See SchemeValuePair.addToHashCode for explanation.
public class CurrencyCode extends SchemeValuePair {

    protected int minorUnit = 0;

    /**
     * Construct a CurrencyCode.
     * @param scheme the Scheme URI
     * @param value the value
     * @param minorUnit the minor unit of the currency (e.g. for USD and most currencies this is 2)
     */
    public CurrencyCode(final String scheme, final String value, final int minorUnit) {
        super(scheme, value);
        this.minorUnit = minorUnit;
        addToHashCode(this, minorUnit);
    }

    /**
     * Construct a CurrencyCode.
     * @param value the value
     * @param minorUnit the minor unit of the currency (e.g. for USD and most currencies this is 2)
     */
    public CurrencyCode(final String value, final int minorUnit) {
        super(value);
        this.minorUnit = minorUnit;
        addToHashCode(this, minorUnit);
    }

    /**
     * Find the CurrencyCode that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an CurrencyCode that matches, or null if none is found to match.
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static CurrencyCode find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (CurrencyCode) find(scheme, value, CurrencyCode.class);
    }

    public int getMinorUnit() {
        return minorUnit;
    }

    @SuppressWarnings("checkstyle:EqualsHashCode") // See SchemeValuePair#addToHashCode for why a hashCode method is not in subclasses.
    @Override
    public boolean equals(final Object obj) {
        if (super.equals(obj)) {
            final CurrencyCode ccOther = (CurrencyCode) obj;
            return ccOther.minorUnit == this.minorUnit;
        } else {
            return false;
        }
    }

}
