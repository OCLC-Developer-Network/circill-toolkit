/*
 * Copyright (c) 2015 eXtensible Catalog Organization.
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
 * Identifies the type of action a user is permitted to take. This is intended to be used as an element
 * within an object on which the action might be taken, e.g. a 'Cancel' action might be taken on a RequestedItem,
 * or a 'Renew' action might be taken on a LoanedItem.
 */
public class PermittedUserAction extends SchemeValuePair {

    public PermittedUserAction(final String scheme, final String value) {
        super(scheme, value);
    }

    public PermittedUserAction(final String value) {
        super(value);
    }

    /**
     * Find the PermittedUserAction that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an PermittedUserAction that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static PermittedUserAction find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (PermittedUserAction) find(scheme, value, PermittedUserAction.class);
    }

}
