/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_1;

import org.oclc.circill.toolkit.service.ncip.ProblemType;
import org.oclc.circill.toolkit.service.ncip.RenewAllItemService;

import org.apache.log4j.Logger;

/**
 * {@link ProblemType}s for the {@link RenewAllItemService}.
 */
public class WCLRenewAllItemProcessingError extends ProblemType {

    private static final Logger LOG = Logger.getLogger(WCLRenewAllItemProcessingError.class);

    public static final String WCL_V1_1_RENEW_ALL_ITEM_PROCESSING_ERROR = "http://worldcat.org/ncip/schemes/v2/processingerrortype/wclrenewallitemprocessingerror.scm";

    public static final WCLRenewAllItemProcessingError NO_ITEMS_CHECKED_OUT = new WCLRenewAllItemProcessingError(WCL_V1_1_RENEW_ALL_ITEM_PROCESSING_ERROR, "No Items Checked Out");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading WCLRenewAllItemProcessingError.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance with the provided scheme and value.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public WCLRenewAllItemProcessingError(final String scheme, final String value) {
        super(scheme, value);
    }
}
