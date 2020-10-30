/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

/**
 * Identifies the type of UserPrivilegeStatusType.
 */
public class UserPrivilegeStatusType extends SchemeValuePair {

    public UserPrivilegeStatusType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the UserPrivilegeStatusType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an UserPrivilegeStatusType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static UserPrivilegeStatusType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (UserPrivilegeStatusType) find(scheme, value, UserPrivilegeStatusType.class);
    }

}
