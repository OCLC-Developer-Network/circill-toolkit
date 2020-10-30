/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0;

import org.oclc.circill.toolkit.service.ncip.ProblemType;

import org.apache.log4j.Logger;

public class WCLRenewItemProcessingError extends ProblemType {

    private static final Logger LOG = Logger.getLogger(WCLRenewItemProcessingError.class);

    public static final String WCL_V1_0_RENEW_ITEM_PROCESSING_ERROR = "http://worldcat.org/ncip/schemes/v2/processingerrortype/wclrenewitemprocessingerror.scm";

    public static final WCLRenewItemProcessingError MAXIMUM_LOST_ITEM_CLAIMS_EXCEEDED = new WCLRenewItemProcessingError(WCL_V1_0_RENEW_ITEM_PROCESSING_ERROR,
        "Maximum Lost Item Claims Exceeded");
    public static final WCLRenewItemProcessingError MAXIMUM_NEVER_HAD_ITEM_CLAIMS_EXCEEDED = new WCLRenewItemProcessingError(WCL_V1_0_RENEW_ITEM_PROCESSING_ERROR,
        "Maximum Never Had Item Claims Exceeded");
    public static final WCLRenewItemProcessingError MAXIMUM_RETURNED_ITEM_CLAIMS_EXCEEDED = new WCLRenewItemProcessingError(WCL_V1_0_RENEW_ITEM_PROCESSING_ERROR,
        "Maximum Returned Item Claims Exceeded");
    public static final WCLRenewItemProcessingError RECALLED_ITEMS_NOT_RENEWABLE = new WCLRenewItemProcessingError(WCL_V1_0_RENEW_ITEM_PROCESSING_ERROR,
        "Recalled Items Not Renewable");

    public static void loadAll() {
        LOG.debug("Loading WCLRenewItemProcessingError.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    public WCLRenewItemProcessingError(final String scheme, final String value) {
        super(scheme, value);
    }
}
