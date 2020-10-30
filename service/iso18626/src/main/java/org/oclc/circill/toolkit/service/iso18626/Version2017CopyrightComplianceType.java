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
 * Codes for {@link CopyrightComplianceType} defined in ISO 3166-1, per ISO 18626-2017 p. 19.
 */
public class Version2017CopyrightComplianceType extends CopyrightComplianceType {

    private static final Logger LOG = Logger.getLogger(Version2017CopyrightComplianceType.class);

    public static final String SCHEME = "http://illtransactions.org/ISO18626/OpenCodeList/CopyrightComplianceList-V1.0";

    // Copyright Cat S183 – Commonwealth (Australia)
    public static final Version2017CopyrightComplianceType AU_COPYRCATS183COMW = new Version2017CopyrightComplianceType(SCHEME, "AU-CopyRCatS183ComW");

    // Copyright Act S183 – State (Australia)
    public static final Version2017CopyrightComplianceType AU_COPYRCATS183STATE = new Version2017CopyrightComplianceType(SCHEME, "AU-CopyRCatS183State");

    // Copyright Act S49 (Australia)
    public static final Version2017CopyrightComplianceType AU_COPYRIGHTACTS49 = new Version2017CopyrightComplianceType(SCHEME, "AU-CopyrightActS49");

    // Copyright Act S50[7] (Australia)
    public static final Version2017CopyrightComplianceType AU_COPYRIGHTACTS50_1 = new Version2017CopyrightComplianceType(SCHEME, "AU-CopyrightActS50–1");

    // Copyright Act S50[3] A (Australia)
    public static final Version2017CopyrightComplianceType AU_COPYRIGHTACTS50_7A = new Version2017CopyrightComplianceType(SCHEME, "AU-CopyrightActS50–7A");

    // Copyright Act S50[3] B (Australia)
    public static final Version2017CopyrightComplianceType AU_COPYRIGHTACTS50_7B = new Version2017CopyrightComplianceType(SCHEME, "AU-CopyrightActS50–7B");

    // Copyright Cleared (Australia)
    public static final Version2017CopyrightComplianceType AU_COPYRIGHTCLEARED = new Version2017CopyrightComplianceType(SCHEME, "AU-CopyrightCleared");

    // General Business (Australia)
    public static final Version2017CopyrightComplianceType AU_GENBUS = new Version2017CopyrightComplianceType(SCHEME, "AU-GenBus");

    // Copyright Act S54 (New Zealand)
    public static final Version2017CopyrightComplianceType NZ_COPYRIGHTACTS54 = new Version2017CopyrightComplianceType(SCHEME, "NZ-CopyrightActS54");

    // Copyright Act S55 (New Zealand)
    public static final Version2017CopyrightComplianceType NZ_COPYRIGHTACTS55 = new Version2017CopyrightComplianceType(SCHEME, "NZ-CopyrightActS55");

    // Other types of copyright compliance. Use Note in ServiceInfo for details.
    public static final Version2017CopyrightComplianceType OTHER = new Version2017CopyrightComplianceType(SCHEME, "Other");

    // Copyright Fee Paid (UK)
    public static final Version2017CopyrightComplianceType UK_COPYRFEEPAID = new Version2017CopyrightComplianceType(SCHEME, "UK-CopyRFeePaid");

    // Fair Dealing (UK)
    public static final Version2017CopyrightComplianceType UK_FAIRDEALING = new Version2017CopyrightComplianceType(SCHEME, "UK-FairDealing");

    // CCG (US)
    public static final Version2017CopyrightComplianceType US_CCG = new Version2017CopyrightComplianceType(SCHEME, "US-CCG");

    // CCL (US code)
    public static final Version2017CopyrightComplianceType US_CCL = new Version2017CopyrightComplianceType(SCHEME, "US-CCL");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017CopyrightComplianceType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017CopyrightComplianceType(final String scheme, final String value) {
        super(scheme, value);
    }
}
