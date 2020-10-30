/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_1;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.MediumType;

import org.apache.log4j.Logger;

/**
 * Created by bodfishj on 11/21/14.
 */
public class WCLv1_1MediumType extends MediumType {

    private static final Logger LOG = Logger.getLogger(WCLv1_1MediumType.class);

    public WCLv1_1MediumType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the WCLv1_1MediumType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an WCLv1_1MediumType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static WCLv1_1MediumType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (WCLv1_1MediumType) find(scheme, value, WCLv1_1MediumType.class);
    }

    public static final String WCL_V1_1_MEDIUM_TYPE = "http://worldcat.org/ncip/schemes/v2/extensions/v1_1/mediumtype.scm";

    /** Archival Material. */
    public static final WCLv1_1MediumType BOOK_PRINTBOOK = new WCLv1_1MediumType(WCL_V1_1_MEDIUM_TYPE, "Book PrintBook");

    public static void loadAll() {
        LOG.debug("Loading WCLv1_1MediumType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

}
