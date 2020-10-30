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
 * Codes for {@link AgencyIdType} defined in ISO 18626-2017 p. 19.
 */
public class Version2017AgencyIdType extends AgencyIdType {

    private static final Logger LOG = Logger.getLogger(Version2017AgencyIdType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/AgencyIdTypeList-V1.0";

    // Danish National Union Catalogue Non-ISIL Identifier
    public static final Version2017AgencyIdType DNUCNI = new Version2017AgencyIdType(SCHEME, "DNUCNI");

    // ISO 15511
    public static final Version2017AgencyIdType ISIL = new Version2017AgencyIdType(SCHEME, "ISIL");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017AgencyIdType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017AgencyIdType(final String scheme, final String value) {
        super(scheme, value);
    }
}
