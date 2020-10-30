/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.ncip.common.FromSystemId;

import org.apache.log4j.Logger;

/**
 * The OCLC System Id Scheme, when used in the FromSystemId element.
 * <p>
 * Note: This is the same Scheme as represented by {@link OCLCToSystemId}, but because the NCIP 2 Toolkit associates these
 * classes with one and only one underlying element (the one it extends, e.g. FromSystemId), the Toolkit requires a class for each element.
 * Objects of this class will <em>not</em> be equal to objects of the {@link OCLCToSystemId},
 * but they will <em>match</em> them (i.e. {@link SchemeValuePair#matches(String, String)} will return true).
 * </p>
 */
public class OCLCFromSystemId extends FromSystemId {

    private static final Logger LOG = Logger.getLogger(OCLCFromSystemId.class);

    /**
     * WorldShare ILL.
     */
    public static final OCLCFromSystemId WSILL = new OCLCFromSystemId(OCLCToSystemId.OCLC_SYSTEM_ID_SCHEME_URI, "WSILL");

    /**
     * WMS Circ.
     */
    public static final OCLCFromSystemId WMS_CIRC = new OCLCFromSystemId(OCLCToSystemId.OCLC_SYSTEM_ID_SCHEME_URI, "WMS Circ");

    /**
     * WMS Acq.
     */
    public static final OCLCFromSystemId WMS_ACQ = new OCLCFromSystemId(OCLCToSystemId.OCLC_SYSTEM_ID_SCHEME_URI, "WMS Acq");

    /**
     * Relais D2D.
     */
    public static final OCLCFromSystemId D2D = new OCLCFromSystemId(OCLCToSystemId.OCLC_SYSTEM_ID_SCHEME_URI, "Relais D2D");

    public OCLCFromSystemId(final String scheme, final String value) {
        super(scheme, value);
    }

    public static void loadAll() {
        LOG.debug("Loading OCLCFromSystemId.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }
}
