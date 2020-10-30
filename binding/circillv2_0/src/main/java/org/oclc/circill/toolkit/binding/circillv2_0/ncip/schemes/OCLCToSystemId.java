/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.ncip.common.ToSystemId;

import org.apache.log4j.Logger;

/**
 * The OCLC System Id Scheme, when used in the ToSystemId element.
 * <p>
 * Note: This is the same Scheme as represented by {@link OCLCFromSystemId}, but because the NCIP 2 Toolkit associates these
 * classes with one and only one underlying element (the one it extends, e.g. ToSystemId), the Toolkit requires a class for each element.
 * Objects of this class will <em>not</em> be equal to objects of the {@link OCLCFromSystemId},
 * but they will <em>match</em> them (i.e. {@link SchemeValuePair#matches(String, String)} will return true).
 * </p>
 */
public class OCLCToSystemId extends ToSystemId {

    private static final Logger LOG = Logger.getLogger(OCLCToSystemId.class);

    public static final String OCLC_SYSTEM_ID_SCHEME_URI = "http://oclc.org/ncip/schemes/systemid/oclcsystemid.scm";

    /**
     * WorldShare ILL.
     */
    public static final OCLCToSystemId WSILL = new OCLCToSystemId(OCLC_SYSTEM_ID_SCHEME_URI, "WSILL");

    /**
     * WMS Circulation.
     */
    public static final OCLCToSystemId WMS_CIRC = new OCLCToSystemId(OCLC_SYSTEM_ID_SCHEME_URI, "WMS Circ");

    /**
     * WMS Acquisitions.
     */
    public static final OCLCToSystemId WMS_ACQ = new OCLCToSystemId(OCLC_SYSTEM_ID_SCHEME_URI, "WMS Acq");

    /**
     * Relais D2D.
     */
    public static final OCLCToSystemId D2D = new OCLCToSystemId(OCLC_SYSTEM_ID_SCHEME_URI, "Relais D2D");

    public OCLCToSystemId(final String scheme, final String value) {
        super(scheme, value);
    }

    public static void loadAll() {
        LOG.debug("Loading OCLCToSystemId.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }
}
