/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0;

import org.oclc.circill.toolkit.service.ncip.RequestType;

import org.apache.log4j.Logger;

public class WCLv1_0RequestType extends RequestType {

    private static final Logger LOG = Logger.getLogger(WCLv1_0RequestType.class);

    public static final String WCL_REQUEST_TYPE = "http://worldcat.org/ncip/schemes/v2/requesttype/wclrequesttype.scm";

    // Request is to reserve the Item for future use. If the Item is not currently available, the request is placed
    // in an ordered list or queue so that the request is satisfied when the Item becomes available. Alternatively
    // the request can specify a specific date/time when the Item is required.
    public static final WCLv1_0RequestType HOLD = new WCLv1_0RequestType(WCL_REQUEST_TYPE, "Hold");
    public static final WCLv1_0RequestType RECALL = new WCLv1_0RequestType(WCL_REQUEST_TYPE, "Recall");

    public static void loadAll() {
        LOG.debug("Loading " + WCLv1_0RequestType.class.getSimpleName());
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    public WCLv1_0RequestType(final String scheme, final String value) {
        super(scheme, value);
    }
}
