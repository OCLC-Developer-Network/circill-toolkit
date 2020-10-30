/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.UserIdentifierType;

import org.apache.log4j.Logger;

public class WCLv1_0UserIdentifierType extends UserIdentifierType {

    private static final Logger LOG = Logger.getLogger(WCLv1_0UserIdentifierType.class);

    public WCLv1_0UserIdentifierType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the WCLv1_0UserIdentifierType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an WCLv1_0UserIdentifierType that matches, or null if none is found to match.
     * @throws ConfigurationException if the scheme/value combination is not valid (i.e. can't be 'found')
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static WCLv1_0UserIdentifierType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (WCLv1_0UserIdentifierType) find(scheme, value, WCLv1_0UserIdentifierType.class);
    }

    public static final String VERSION_1_WCL_USER_IDENTIFIER_TYPE = "http://worldcat.org/ncip/schemes/v2/extensions/useridentifiertype.scm";

    /**
     * The UserIdentifier is an identifier from OCLC’s Enterprise IDentity Management (EIDM) system; the InitiationHeader
     * of the containing message must include the RelyingPartyId extension containing the Principal ID NameSpace.
     */
    public static final WCLv1_0UserIdentifierType EIDM = new WCLv1_0UserIdentifierType(VERSION_1_WCL_USER_IDENTIFIER_TYPE, "EIDM");

    /**
     * The UserIdentifier is an identifier from OCLC’s Enterprise Identity Management (EIDM) system; this is the
     * value of the identifier in the internal OCLC namespace.
     */
    public static final WCLv1_0UserIdentifierType PPID = new WCLv1_0UserIdentifierType(VERSION_1_WCL_USER_IDENTIFIER_TYPE, "PPID");

    public static void loadAll() {
        LOG.debug("Loading WCLv1_0UserIdentifierType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

}
