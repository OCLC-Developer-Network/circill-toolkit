/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BibliographicRecordIdentifierCode;

import org.apache.log4j.Logger;

/**
 * Codes for {@link BibliographicRecordIdentifierCode} defined in ISO 18626-2017 p. 19.
 */
public class Version2017BibliographicRecordIdentifierCode extends BibliographicRecordIdentifierCode {

    private static final Logger LOG = Logger.getLogger(Version2017BibliographicRecordIdentifierCode.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/BibliographicRecordIdCodeList-V1.0";

    // Canadian National Catalogue code
    public static final Version2017BibliographicRecordIdentifierCode AMICUS = new Version2017BibliographicRecordIdentifierCode(SCHEME, "AMICUS");

    // British Library
    public static final Version2017BibliographicRecordIdentifierCode BL = new Version2017BibliographicRecordIdentifierCode(SCHEME, "BL");

    // FAUST number (Denmark)
    public static final Version2017BibliographicRecordIdentifierCode FAUST = new Version2017BibliographicRecordIdentifierCode(SCHEME, "FAUST");

    // Japanese National Bibliography
    public static final Version2017BibliographicRecordIdentifierCode JNB = new Version2017BibliographicRecordIdentifierCode(SCHEME, "JNB");

    // Libraries Australia
    public static final Version2017BibliographicRecordIdentifierCode LA = new Version2017BibliographicRecordIdentifierCode(SCHEME, "LA");

    // Library of Congress Cataloging Number (US)
    public static final Version2017BibliographicRecordIdentifierCode LCCN = new Version2017BibliographicRecordIdentifierCode(SCHEME, "LCCN");

    // Medline
    public static final Version2017BibliographicRecordIdentifierCode MEDLINE = new Version2017BibliographicRecordIdentifierCode(SCHEME, "Medline");

    // NACSIS-CAT bibliographic record identifier (Japan)
    public static final Version2017BibliographicRecordIdentifierCode NCID  = new Version2017BibliographicRecordIdentifierCode(SCHEME, "NCID");

    // OCLC
    public static final Version2017BibliographicRecordIdentifierCode OCLC = new Version2017BibliographicRecordIdentifierCode(SCHEME, "OCLC");

    // PubMed Id
    public static final Version2017BibliographicRecordIdentifierCode PMID = new Version2017BibliographicRecordIdentifierCode(SCHEME, "PMID");

    // Te Puna (New Zealand)
    public static final Version2017BibliographicRecordIdentifierCode TP = new Version2017BibliographicRecordIdentifierCode(SCHEME, "TP");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017BibliographicRecordIdentifierCode.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance of {@link Version2017BibliographicRecordIdentifierCode}.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017BibliographicRecordIdentifierCode(final String scheme, final String value) {
        super(scheme, value);
    }

}
