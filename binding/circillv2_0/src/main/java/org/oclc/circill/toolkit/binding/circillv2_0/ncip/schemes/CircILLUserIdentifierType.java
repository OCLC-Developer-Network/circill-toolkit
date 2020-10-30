/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.ncip.UserIdentifierType;

import org.apache.log4j.Logger;

/**
 * The Circ/ILL Item Identifier Type
 */
public class CircILLUserIdentifierType extends UserIdentifierType {

    private static final Logger LOG = Logger.getLogger(CircILLUserIdentifierType.class);

    public static final String URI = "http://oclc.org/ncip/schemes/userid/oclcids.scm";

    /**
     * OCLC Institution Symbol
     */
    public static final CircILLUserIdentifierType OCLC_INSTITUTION_SYMBOL = new CircILLUserIdentifierType(URI, "OCLC Institution Symbol");

    public CircILLUserIdentifierType(final String scheme, final String value) {
        super(scheme, value);
    }

    public static void loadAll() {
        LOG.debug("Loading CircILLUserIdentifierType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }
}
