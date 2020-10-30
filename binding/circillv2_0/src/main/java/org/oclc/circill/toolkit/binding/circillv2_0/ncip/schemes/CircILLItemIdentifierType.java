/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.ncip.ItemIdentifierType;

import org.apache.log4j.Logger;

/**
 * The Circ/ILL NCIP Application Profile's Request Identifier Type Scheme, when used in the ItemIdentifierType element.
 * <p>
 * Note: This is the same Scheme as represented by {@link CircILLRequestIdentifierType}, but because the NCIP 2 Toolkit associates these
 * classes with one and only one underlying element (the one it extends, e.g. ItemIdentifierType), the Toolkit requires a class for each element.
 * Objects of this class will <em>not</em> be equal to objects of the {@link CircILLRequestIdentifierType},
 * but they will <em>match</em> them (i.e. {@link SchemeValuePair#matches(String, String)} will return true).
 * </p>
 */
public class CircILLItemIdentifierType extends ItemIdentifierType {

    private static final Logger LOG = Logger.getLogger(CircILLItemIdentifierType.class);

    /**
     * ILL Request Id - the associated ItemIdentifierValue is an identifier of the ILL request to which the item is associated.
     */
    public static final CircILLItemIdentifierType ILL_REQUEST_ID = new CircILLItemIdentifierType(CircILLRequestIdentifierType.URI, "ILL Request Id");

    public CircILLItemIdentifierType(final String scheme, final String value) {
        super(scheme, value);
    }

    public static void loadAll() {
        LOG.debug("Loading CircILLItemIdentifierType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }
}
