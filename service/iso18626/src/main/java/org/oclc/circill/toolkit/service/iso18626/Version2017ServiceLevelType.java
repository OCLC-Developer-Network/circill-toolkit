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
 * Codes for {@link ServiceLevelType} defined in ISO 18626-2017 p. 22.
 */
public class Version2017ServiceLevelType extends ServiceLevelType {

    private static final Logger LOG = Logger.getLogger(Version2017ServiceLevelType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/ServiceLevelList-V1.0";

    // Express (Australia)
    public static final Version2017ServiceLevelType EXPRESS = new Version2017ServiceLevelType(SCHEME, "Express");

    // Normal
    public static final Version2017ServiceLevelType NORMAL = new Version2017ServiceLevelType(SCHEME, "Normal");

    // Rush (Australia)
    public static final Version2017ServiceLevelType RUSH = new Version2017ServiceLevelType(SCHEME, "Rush");

    // Secondary mail
    public static final Version2017ServiceLevelType SECONDARY_MAIL = new Version2017ServiceLevelType(SCHEME, "SecondaryMail");

    // Standard (Australia)
    public static final Version2017ServiceLevelType STANDARD = new Version2017ServiceLevelType(SCHEME, "Standard");

    // Urgent
    public static final Version2017ServiceLevelType URGENT = new Version2017ServiceLevelType(SCHEME, "Urgent");

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
    public Version2017ServiceLevelType(final String scheme, final String value) {
        super(scheme, value);
    }

}
