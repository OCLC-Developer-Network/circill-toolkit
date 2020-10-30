/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.log4j.Logger;

/**
 * Codes for {@link LoanConditionType} defined in ISO 18626-2017 p. 20.
 */
public class Version2017LoanConditionType extends LoanConditionType {

    private static final Logger LOG = Logger.getLogger(Version2017LoanConditionType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/LoanConditionList-V1.0";

    // Use in library only
    public static final Version2017LoanConditionType LIBRARY_USE_ONLY = new Version2017LoanConditionType(SCHEME, "LibraryUseOnly");

    // No reproduction
    public static final Version2017LoanConditionType NO_REPRODUCTION = new Version2017LoanConditionType(SCHEME, "NoReproduction");

    // Signature required
    public static final Version2017LoanConditionType SIGNATURE_REQUIRED = new Version2017LoanConditionType(SCHEME, "SignatureRequired");

    // Special collections supervision required
    public static final Version2017LoanConditionType SPEC_COLL_SUPERV_REQ = new Version2017LoanConditionType(SCHEME, "SpecCollSupervReq");

    // Watch over use in library
    public static final Version2017LoanConditionType WATCH_LIBRARY_USE_ONLY = new Version2017LoanConditionType(SCHEME, "WatchLibraryUseOnly");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017LoanConditionType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017LoanConditionType(final String scheme, final String value) {
        super(scheme, value);
    }

}
