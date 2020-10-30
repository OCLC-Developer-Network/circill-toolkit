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
 * Codes for {@link ReasonRetryType} defined in ISO 18626-2017 p. 21.
 */
public class Version2017ReasonRetryType extends ReasonRetryType{

    private static final Logger LOG = Logger.getLogger(Version2017ReasonRetryType.class);

    public static final String SCHEME = "http://illtransactions.org/ISO18626/OpenCodeList/ReasonRetryList-V1.0";

    // At bindery
    public static final Version2017ReasonRetryType AT_BINDERY = new Version2017ReasonRetryType(SCHEME, "AtBindery");

    // The highest amount the requesting library is prepared to pay is lower than the cost to supply
    public static final Version2017ReasonRetryType COST_EXCEEDS_MAX_COST = new Version2017ReasonRetryType(SCHEME, "CostExceedsMaxCost");

    // If the only copy is requested and loan is possible, but not the copy
    public static final Version2017ReasonRetryType LOAN_POSSIBLE = new Version2017ReasonRetryType(SCHEME, "LoanPossible");

    // Not currently available for ill
    public static final Version2017ReasonRetryType NOT_CURRENT_AVAILABLE_FOR_ILL = new Version2017ReasonRetryType(SCHEME, "NotCurrentAvailableForILL");

    // Not found as cited
    public static final Version2017ReasonRetryType NOT_FOUND_AS_CITED = new Version2017ReasonRetryType(SCHEME, "NotFoundAsCited");

    // On loan
    public static final Version2017ReasonRetryType ON_LOAN = new Version2017ReasonRetryType(SCHEME, "OnLoan");

    // On order
    public static final Version2017ReasonRetryType ON_ORDER = new Version2017ReasonRetryType(SCHEME, "OnOrder");

    // Requested delivery date not possible
    public static final Version2017ReasonRetryType REQ_DEL_DATE_NOT_POSSIBLE = new Version2017ReasonRetryType(SCHEME, "ReqDelDateNotPossible");

    // Requested delivery method not supported
    public static final Version2017ReasonRetryType REQ_DEL_METHOD_NOT_SUPP = new Version2017ReasonRetryType(SCHEME, "ReqDelMethodNotSupp");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017ReasonRetryType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017ReasonRetryType(final String scheme, final String value) {
        super(scheme, value);
    }

}
