/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

/**
 * Identifies a billing method.
 */
public class BillingMethodType extends SchemeValuePair {

    /**
     * Construct a {@link BillingMethodType}.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public BillingMethodType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the BillingMethodType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return a BillingMethodType that matches, or null if none is found to match.
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static BillingMethodType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (BillingMethodType) find(scheme, value, BillingMethodType.class);
    }
}
