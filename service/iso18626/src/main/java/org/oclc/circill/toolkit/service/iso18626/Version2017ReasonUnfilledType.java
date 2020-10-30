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
 * Codes for {@link ReasonUnfilledType} defined in ISO 18626-2017 p. 22.
 */
public class Version2017ReasonUnfilledType extends ReasonUnfilledType {

    private static final Logger LOG = Logger.getLogger(Version2017ReasonUnfilledType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/ReasonUnfilledList-V1.0";

    // Non-circulating (e.g. handbook)
    public static final Version2017ReasonUnfilledType NON_CIRCULATING = new Version2017ReasonUnfilledType(SCHEME, "NonCirculating");

    // Not available for ILL
    public static final Version2017ReasonUnfilledType NOT_AVAILABLE_FOR_ILL = new Version2017ReasonUnfilledType(SCHEME, "NotAvailableForILL");

    // Not held
    public static final Version2017ReasonUnfilledType NOT_HELD = new Version2017ReasonUnfilledType(SCHEME, "NotHeld");

    // Not on shelf
    public static final Version2017ReasonUnfilledType NOT_ON_SHELF = new Version2017ReasonUnfilledType(SCHEME, "NotOnShelf");

    // Policy problem
    public static final Version2017ReasonUnfilledType POLICY_PROBLEM = new Version2017ReasonUnfilledType(SCHEME, "PolicyProblem");

    // Poor condition
    public static final Version2017ReasonUnfilledType POOR_CONDITION = new Version2017ReasonUnfilledType(SCHEME, "PoorCondition");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017PreferredFormatType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017ReasonUnfilledType(final String scheme, final String value) {
        super(scheme, value);
    }

}
