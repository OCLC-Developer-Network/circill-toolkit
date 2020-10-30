/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Identifies the type of BibliographicRecordIdentifierCode.
 */
public class BibliographicRecordIdentifierCode extends SchemeValuePair {

    /**
     * Construct a {@link BibliographicRecordIdentifierCode}.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public BibliographicRecordIdentifierCode(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the BibliographicRecordIdentifierCode that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an BibliographicRecordIdentifierCode that matches, or null if none is found to match.
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static BibliographicRecordIdentifierCode find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (BibliographicRecordIdentifierCode) find(scheme, value, BibliographicRecordIdentifierCode.class);
    }

}
