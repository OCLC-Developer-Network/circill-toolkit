/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.log4j.Logger;

/**
 * Note: This is in fact inherited from the NCIP version 1 VisibleUserIdentifierType, but
 * as the VisibleUserIdentifier element was merged with UserIdentifier with version 2,
 * that is the name used for this scheme.
 */
public class Version1UserIdentifierType extends UserIdentifierType {

    /** The logger */
    private static final Logger LOG = Logger.getLogger(Version1UserIdentifierType.class);

    /** The Scheme URI */
    public static final String VERSION_1_USER_IDENTIFIER_TYPE = "http://www.niso.org/ncip/v1_0/imp1/schemes/visibleuseridentifiertype/visibleuseridentifiertype.scm";

    /** User barcode */
    public static final Version1UserIdentifierType BARCODE = new Version1UserIdentifierType(VERSION_1_USER_IDENTIFIER_TYPE, "Barcode");

    /** Institution id */
    public static final Version1UserIdentifierType INSTITUTION_ID_NUMBER = new Version1UserIdentifierType(VERSION_1_USER_IDENTIFIER_TYPE, "Institution Id Number");

    /** Load all values */
    public static void loadAll() {
        LOG.debug("Loading Version1UserIdentifierType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     *  Construct a new instance.
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     */
    public Version1UserIdentifierType(final String scheme, final String value) {
        super(scheme, value);
    }

}
