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
import org.oclc.circill.toolkit.service.ncip.SortOrderType;

import org.apache.log4j.Logger;

public class WCLv1_0SortOrderType extends SortOrderType {

    private static final Logger LOG = Logger.getLogger(WCLv1_0SortOrderType.class);

    public WCLv1_0SortOrderType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the WCLv1_0SortOrderType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an WCLv1_0SortOrderType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static WCLv1_0SortOrderType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (WCLv1_0SortOrderType) find(scheme, value, WCLv1_0SortOrderType.class);
    }

    public static final String VERSION_1_WCL_SORT_ORDER_TYPE = "http://worldcat.org/ncip/schemes/v2/extensions/sortordertype.scm";

    public static final WCLv1_0SortOrderType ASCENDING = new WCLv1_0SortOrderType(VERSION_1_WCL_SORT_ORDER_TYPE, "Ascending");
    public static final WCLv1_0SortOrderType DESCENDING = new WCLv1_0SortOrderType(VERSION_1_WCL_SORT_ORDER_TYPE, "Descending");

    public static void loadAll() {
        LOG.debug("Loading WCLv1_0SortOrderType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

}
