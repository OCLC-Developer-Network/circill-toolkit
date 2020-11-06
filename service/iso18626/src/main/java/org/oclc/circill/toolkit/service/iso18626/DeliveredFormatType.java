/*
 * Copyright (c) 2019 OCLC, Inc.
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
 * Format of the delivered item.
 */
public class DeliveredFormatType extends SchemeValuePair {

    /**
     * Construct a {@link DeliveredFormatType}.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public DeliveredFormatType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the DeliveredFormatType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return a DeliveredFormatType that matches, or null if none is found to match.
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static DeliveredFormatType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (DeliveredFormatType) find(scheme, value, DeliveredFormatType.class);
    }
}
