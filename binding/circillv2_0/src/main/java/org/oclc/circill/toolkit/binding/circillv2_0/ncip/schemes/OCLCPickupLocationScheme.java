/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.base.SchemeValueBehavior;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.ncip.PickupLocation;

import org.apache.log4j.Logger;

/**
 * The OCLC Pickup Location Scheme.
 */
public class OCLCPickupLocationScheme extends PickupLocation {

    private static final Logger LOG = Logger.getLogger(OCLCPickupLocationScheme.class);

    /*
       The values for this Scheme are the OCLC-issued Institution Symbols,
       e.g.&nbsp;"EQO” for the University of Oxford, England, and “OSU” for the Ohio State University, United States.
     */
    public static final String SYMBOL_SCHEME_URI = "http://oclc.org/ncip/schemes/pickuplocation/symbol.scm";

    /**
     * This instance establishes this Scheme URI as one that allows any values, i.e.&nbsp;the Toolkit does not validate the values,
     * and calls to {@link SchemeValuePair#find} will always succeed (returning either the existing instance or a new instance).
     */
    public static final OCLCPickupLocationScheme SYMBOL_ANY_VALUES = new OCLCPickupLocationScheme(SYMBOL_SCHEME_URI, SchemeValueBehavior.ANY_VALUES_FLAG);

    /*
       The values for this Scheme are the OCLC-issued Institution Registry Ids,
       e.g.&nbsp;"46516” for the University of Oxford, England, and “2315” for the Ohio State University, United States.
     */
    public static final String INSTITUTION_ID_SCHEME_URI = "http://oclc.org/ncip/schemes/pickuplocation/institutionid.scm";

    /**
     * This instance establishes this Scheme URI as one that allows any values, i.e.&nbsp;the Toolkit does not validate the values,
     * and calls to {@link SchemeValuePair#find} will always succeed (returning either the existing instance or a new instance).
     */
    public static final OCLCPickupLocationScheme INSTITUTION_ID_ANY_VALUES = new OCLCPickupLocationScheme(INSTITUTION_ID_SCHEME_URI, SchemeValueBehavior.ANY_VALUES_FLAG);

    /*
       The values for this Scheme are the OCLC-issued Institution Registry Ids,
       The use of this Scheme indicates that the Institution Registry Id represents a Branch location, as distinct from Ids which represent the entire institution.
       e.g.&nbsp;"32542” for the University of Oxford, Physical and Theoretical Chemistry Laboratory, and “2312” for the Ohio State University - Lima Campus
     */
    public static final String BRANCH_ID_SCHEME_URI = "http://oclc.org/ncip/schemes/pickuplocation/branchid.scm";

    /**
     * This instance establishes this Scheme URI as one that allows any values, i.e.&nbsp;the Toolkit does not validate the values,
     * and calls to {@link SchemeValuePair#find} will always succeed (returning either the existing instance or a new instance).
     */
    public static final OCLCPickupLocationScheme BRANCH_ID_ANY_VALUES = new OCLCPickupLocationScheme(BRANCH_ID_SCHEME_URI, SchemeValueBehavior.ANY_VALUES_FLAG);

    public OCLCPickupLocationScheme(final String scheme, final String value) {
        super(scheme, value);
    }

    public static void loadAll() {
        LOG.debug("Loading OCLCPickupLocationScheme."); // Merely invoking this method registers the instances defined above.
    }
}

