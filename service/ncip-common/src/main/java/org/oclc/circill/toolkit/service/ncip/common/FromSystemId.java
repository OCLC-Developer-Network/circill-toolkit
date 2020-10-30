/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip.common;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

/**
 * Identifies the system from which a message is sent.
 */
public class FromSystemId extends SchemeValuePair {

    /**
     * Construct an {@link FromSystemId}.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public FromSystemId(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Construct an {@link FromSystemId}.
     * @param value the value
     */
    public FromSystemId(final String value) {
        super(value);
    }

    /**
     * Find the FromSystemId that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return a FromSystemId that matches, or null if none is found to match.
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static FromSystemId find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (FromSystemId) find(scheme, value, FromSystemId.class);
    }

}
