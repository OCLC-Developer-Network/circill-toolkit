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
import org.oclc.circill.toolkit.service.ncip.RequestScopeType;

import org.apache.log4j.Logger;

/**
 * RequestScopeType for WCL's "Special Request", where the scope of the request is defined by the user's note.
 */
public class WCLv1_1RequestScopeType extends RequestScopeType {

    private static final Logger LOG = Logger.getLogger(WCLv1_1RequestScopeType.class);

    public WCLv1_1RequestScopeType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the WCLv1_1RequestScopeType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an WCLv1_1RequestScopeType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static WCLv1_1RequestScopeType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (WCLv1_1RequestScopeType) find(scheme, value, WCLv1_1RequestScopeType.class);
    }

    public static final String WCL_V1_1_REQUEST_SCOPE_TYPE_TYPE = "http://worldcat.org/ncip/schemes/v2/extensions/v1_1/requestscopetype.scm";

    /** Special Request. */
    public static final WCLv1_1RequestScopeType SPECIAL_REQUEST = new WCLv1_1RequestScopeType(WCL_V1_1_REQUEST_SCOPE_TYPE_TYPE, "Special Request");

    public static void loadAll() {
        LOG.debug("Loading WCLv1_1RequestScopeType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

}
