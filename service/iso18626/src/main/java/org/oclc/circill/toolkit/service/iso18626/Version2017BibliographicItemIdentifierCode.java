/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BibliographicItemIdentifierCode;

import org.apache.log4j.Logger;

/**
 * Codes for {@link BibliographicItemIdentifierCode} defined in ISO 18626-2017 p. 19.
 */
public class Version2017BibliographicItemIdentifierCode extends BibliographicItemIdentifierCode {

    private static final Logger LOG = Logger.getLogger(Version2017BibliographicItemIdentifierCode.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/BibliographicItemIdCodeList-V1.0";

    // ISO 2108
    public static final Version2017BibliographicItemIdentifierCode ISBN = new Version2017BibliographicItemIdentifierCode(SCHEME, "ISBN");

    // ISO 3297
    public static final Version2017BibliographicItemIdentifierCode ISSN = new Version2017BibliographicItemIdentifierCode(SCHEME, "ISSN");

    // ISO 10957
    public static final Version2017BibliographicItemIdentifierCode ISMN = new Version2017BibliographicItemIdentifierCode(SCHEME, "ISMN");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017BibliographicItemIdentifierCode.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance of {@link Version2017BibliographicItemIdentifierCode}.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017BibliographicItemIdentifierCode(final String scheme, final String value) {
        super(scheme, value);
    }

}
