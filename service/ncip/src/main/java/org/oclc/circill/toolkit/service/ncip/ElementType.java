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

import java.util.Iterator;

/**
 * Identifies an Element, such as Account Details.
 */
public class ElementType extends SchemeValuePair {

    public ElementType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the ElementType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return a ElementType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static ElementType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (ElementType) find(scheme, value, ElementType.class);
    }

    public static Iterator<UserElementType> iterator() {
        return getIterator(UserElementType.class);
    }

}
