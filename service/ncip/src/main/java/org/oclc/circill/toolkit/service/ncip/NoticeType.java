/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

/**
 * Identifies the type of NoticeType.
 */
public class NoticeType extends SchemeValuePair {

    public NoticeType(final String scheme, final String value) {
        super(scheme, value);
    }

    public NoticeType(final String value) {
        super(value);
    }

    /**
     * Find the NoticeType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an NoticeType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static NoticeType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (NoticeType) find(scheme, value, NoticeType.class);
    }

}