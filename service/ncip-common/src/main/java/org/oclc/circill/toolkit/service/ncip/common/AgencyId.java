/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip.common;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

/**
 * An NCIP Agnecy Id.
 */
public class AgencyId extends SchemeValuePair {

    /**
     * Construct an AgencyId from the supplied scheme and value.
     * @param scheme the NCIP Scheme URI
     * @param value the value within the Scheme
     */
    public AgencyId(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Construct an AgencyId from the supplied value; the NCIP Scheme URI is implicitly understood between the initiator and the responder.
     * @param value the value
     */
    public AgencyId(final String value) {
        super(value);
    }

    /**
     * Find the AgencyId that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return a AgencyId that matches, or null if none is found to match.
     * @throws ConfigurationException if the Scheme and value are not valid in the current Toolkit configuration
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static AgencyId find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (AgencyId) find(scheme, value, AgencyId.class);
    }

}
