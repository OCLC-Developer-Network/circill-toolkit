/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Identifies the type of PaymentMethodType.
 */
public class PaymentMethodType extends SchemeValuePair {

    /**
     * Construct a PaymentMethodType.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public PaymentMethodType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the PaymentMethodType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an PaymentMethodType that matches, or null if none is found to match.
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static PaymentMethodType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (PaymentMethodType) find(scheme, value, PaymentMethodType.class);
    }
}
