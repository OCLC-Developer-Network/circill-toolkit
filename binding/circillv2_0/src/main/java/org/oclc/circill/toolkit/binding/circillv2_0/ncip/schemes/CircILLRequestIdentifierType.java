/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.ncip.RequestIdentifierType;

import org.apache.log4j.Logger;

/**
 * The Circ/ILL NCIP Application Profile's Request Identifier Type Scheme, when used in the RequestIdentifierType element.
 * <p>
 * Note: This is the same Scheme as represented by {@link CircILLItemIdentifierType}, but because the NCIP 2 Toolkit associates these
 * classes with one and only one underlying element (the one it extends, e.g. RequestIdentifierType), the Toolkit requires a class for each element.
 * Objects of this class will <em>not</em> be equal to objects of the {@link CircILLItemIdentifierType},
 * but they will <em>match</em> them (i.e. {@link SchemeValuePair#matches(String, String)} will return true).
 * </p>
 */
public class CircILLRequestIdentifierType extends RequestIdentifierType {

    private static final Logger LOG = Logger.getLogger(CircILLRequestIdentifierType.class);

    public static final String URI = "http://oclc.org/ncip/schemes/requestidentifiertype/circillrequestidentifiertype.scm";

    /**
     * ILL Request Id - the associated RequestIdentifierValue is an identifier of the ILL request.
     */
    public static final CircILLRequestIdentifierType ILL_REQUEST_ID = new CircILLRequestIdentifierType(URI, "ILL Request Id");

    public CircILLRequestIdentifierType(final String scheme, final String value) {
        super(scheme, value);
    }

    public static void loadAll() {
        LOG.debug("Loading CircILLRequestIdentifierType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }
}
