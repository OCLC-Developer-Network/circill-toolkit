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
import org.oclc.circill.toolkit.service.ncip.FiscalActionType;

import org.apache.log4j.Logger;

public class WCLv1_0FiscalActionType extends FiscalActionType {

    private static final Logger LOG = Logger.getLogger(WCLv1_0FiscalActionType.class);

    public WCLv1_0FiscalActionType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the WCLv1_0FiscalActionType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an WCLv1_0FiscalActionType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static WCLv1_0FiscalActionType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (WCLv1_0FiscalActionType) find(scheme, value, WCLv1_0FiscalActionType.class);
    }

    public static final String VERSION_1_WCL_FISCAL_ACTION_TYPE = "http://worldcat.org/ncip/schemes/v2/extensions/fiscalactiontype.scm";

    public static final WCLv1_0FiscalActionType BALANCE = new WCLv1_0FiscalActionType(VERSION_1_WCL_FISCAL_ACTION_TYPE, "Balance");

    public static void loadAll() {
        LOG.debug("Loading WCLv1_0FiscalActionType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

}
