/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.log4j.Logger;

/**
 * Codes for {@link BillingMethodType} defined in ISO 18626-2017 p. 19.
 */
public class Version2017BillingMethodType extends BillingMethodType {

    private static final Logger LOG = Logger.getLogger(Version2017BillingMethodType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/BillingMethodList-V1.0";

    // Account
    public static final Version2017BillingMethodType DNUCNI = new Version2017BillingMethodType(SCHEME, "Account");

    // There are no payments involved in the ILL transaction.
    public static final Version2017BillingMethodType FREE_OF_CHARGE = new Version2017BillingMethodType(SCHEME, "FreeOfCharge");

    // Invoice
    public static final Version2017BillingMethodType INVOICE = new Version2017BillingMethodType(SCHEME, "Invoice");

    // Some other payment method, not included here, is used.
    public static final Version2017BillingMethodType OTHER = new Version2017BillingMethodType(SCHEME, "Other");

    // Requesting and supplying agencies have an agreement on how payment shall be taken care of.
    public static final Version2017BillingMethodType RECIPROCITY_AGREEMENT = new Version2017BillingMethodType(SCHEME, "ReciprocityAgreement");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017BillingMethodType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017BillingMethodType(final String scheme, final String value) {
        super(scheme, value);
    }
}
