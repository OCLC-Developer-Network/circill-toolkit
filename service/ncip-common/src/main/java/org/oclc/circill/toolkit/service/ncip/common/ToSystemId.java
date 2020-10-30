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
 * Identifies the system to which a message is sent.
 */
public class ToSystemId extends SchemeValuePair {

    /**
     * Construct an {@link ToSystemId}.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public ToSystemId(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Construct an {@link ToSystemId}.
     * @param value the value
     */
    public ToSystemId(final String value) {
        super(value);
    }

    /**
     * Find the ToSystemId that matches the scheme &amp;value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return a ToSystemId that matches, or null if none is found to match.
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static ToSystemId find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (ToSystemId) find(scheme, value, ToSystemId.class);
    }

}
