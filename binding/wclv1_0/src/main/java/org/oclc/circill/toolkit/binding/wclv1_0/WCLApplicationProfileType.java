/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.common.ApplicationProfileType;

import org.apache.log4j.Logger;

public class WCLApplicationProfileType extends ApplicationProfileType {

    private static final Logger LOG = Logger.getLogger(WCLApplicationProfileType.class);

    public WCLApplicationProfileType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the WCLApplicationProfileType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an WCLApplicationProfileType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static WCLApplicationProfileType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (WCLApplicationProfileType) find(scheme, value, WCLApplicationProfileType.class);
    }

    public static final String VERSION_1_WCL_APPLICATION_PROFILE_TYPE = "http://worldcat.org/ncip/schemes/v2/extensions/applicationprofiletype.scm";

    public static final WCLApplicationProfileType VERSION_2011 = new WCLApplicationProfileType(VERSION_1_WCL_APPLICATION_PROFILE_TYPE, "Version 2011");

    public static final WCLApplicationProfileType VERSION_2017 = new WCLApplicationProfileType(VERSION_1_WCL_APPLICATION_PROFILE_TYPE, "Version 2017");

    public static void loadAll() {
        LOG.debug("Loading WCLApplicationProfileType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

}
