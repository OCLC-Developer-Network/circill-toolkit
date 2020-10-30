/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.ncip.common.ApplicationProfileType;

import org.apache.log4j.Logger;

/**
 * The Circ/ILL Application Profile Type Scheme.
 */
public class CircILLApplicationProfileType extends ApplicationProfileType {

    private static final Logger LOG = Logger.getLogger(CircILLApplicationProfileType.class);

    public static final String URI = "http://oclc.org/ncip/schemes/applicationprofiletype/circillapplicationprofiletype.scm";

    /**
     * The version used by OCLC VDX and Navigator applications.
     */
    public static final CircILLApplicationProfileType VERSION_1_0 = new CircILLApplicationProfileType(URI, "1.00");

    /**
     * The version used by OCLC WorldShare ILL and WMS Circ applications.
     */
    public static final CircILLApplicationProfileType VERSION_2_0 = new CircILLApplicationProfileType(URI, "2.00");

    public CircILLApplicationProfileType(final String scheme, final String value) {
        super(scheme, value);
    }

    public static void loadAll() {
        LOG.debug("Loading CircILLApplicationProfileType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }
}
