/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * This class provides constant definitions of the NCIP Scheme URIs for OCLC's RegistryId, InstitutionId, and Symbol identifiers.
 */
public final class OCLCAgencyIdSchemes {

    public static final String REGISTRY_ID_SCHEME_URI = "http://oclc.org/ncip/schemes/agencyid/registryid.scm";
    public static final String INSTITUTION_ID_SCHEME_URI = "http://oclc.org/ncip/schemes/agencyid/institutionid.scm";
    public static final String SYMBOL_SCHEME_URI = "http://oclc.org/ncip/schemes/agencyid/symbol.scm";

    private OCLCAgencyIdSchemes() {
        // Forbid construction
    }
}
