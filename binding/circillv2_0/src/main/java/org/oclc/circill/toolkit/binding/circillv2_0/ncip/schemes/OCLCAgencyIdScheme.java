/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.base.SchemeValueBehavior;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import org.apache.log4j.Logger;

/**
 * The OCLC Agency Id Scheme.
 */
public class OCLCAgencyIdScheme extends AgencyId {

    private static final Logger LOG = Logger.getLogger(OCLCAgencyIdScheme.class);

    /*
       The values for this Scheme are the OCLC-issued Institution Symbols,
       e.g.&nbsp;"EQO” for the University of Oxford, England, and “OSU” for the Ohio State University, United States.
     */
    public static final String SYMBOL_SCHEME_URI = "http://oclc.org/ncip/schemes/agencyid/symbol.scm";

    /**
     * This instance establishes this Scheme URI as one that allows any values, i.e.&nbsp;the Toolkit does not validate the values,
     * and calls to {@link SchemeValuePair#find} will always succeed (returning either the existing instance or a new instance).
     */
    public static final OCLCAgencyIdScheme SYMBOL_ANY_VALUES = new OCLCAgencyIdScheme(SYMBOL_SCHEME_URI, SchemeValueBehavior.ANY_VALUES_FLAG);

    /*
       The values for this Scheme are the OCLC-issued Institution Registry Ids,
       e.g.&nbsp;"46516” for the University of Oxford, England, and “2315” for the Ohio State University, United States.
     */
    public static final String INSTITUTION_ID_SCHEME_URI = "http://oclc.org/ncip/schemes/agencyid/institutionid.scm";

    /**
     * This instance establishes this Scheme URI as one that allows any values, i.e.&nbsp;the Toolkit does not validate the values,
     * and calls to {@link SchemeValuePair#find} will always succeed (returning either the existing instance or a new instance).
     */
    public static final OCLCAgencyIdScheme INSTITUION_ID_ANY_VALUES = new OCLCAgencyIdScheme(INSTITUTION_ID_SCHEME_URI, SchemeValueBehavior.ANY_VALUES_FLAG);

    public OCLCAgencyIdScheme(final String scheme, final String value) {
        super(scheme, value);
    }

    public static void loadAll() {
        LOG.debug("Loading OCLCAgencyIdScheme."); // Merely invoking this method registers the instances defined above.
    }
}
