/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.BaseTestServiceHelper;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Unit tests for the ServiceHelper.
 */
public class TestServiceHelper extends BaseTestServiceHelper {

    /**
     * These are the known cases where a property's type is not a primitive type and
     * does not (allowing for pluralization) match the simple name of the class used
     * to represent it in the Toolkit.
     * This list should have a matching list (with the exception that keys begin with upper case letters) in BaseContentConverter.
     */
    private static final Map<String /*Property Name*/, String /*Type Name*/> PROPERTY_NAME_TO_CLASS_NAME_ALIASES;

    static {
        final Map<String, String> tempMap = new HashMap<>();
        tempMap.put("relyingPartyId", "AgencyId");
        tempMap.put("acknowledgedItemUseRestrictionType", "ItemUseRestrictionType");
        tempMap.put("acknowledgedItemUseRestrictionTypes", "ItemUseRestrictionTypes");
        tempMap.put("accountDetail", "AccountDetails");
        tempMap.put("requiredItemUseRestrictionType", "ItemUseRestrictionType");
        tempMap.put("requiredItemUseRestrictionTypes", "ItemUseRestrictionTypes");
        tempMap.put("holdingsSetIds", "Strings");
        tempMap.put("dateReneweds", "GregorianCalendars");
        PROPERTY_NAME_TO_CLASS_NAME_ALIASES = Collections.unmodifiableMap(tempMap);
    }

    private static final Map<String, String> SINGULAR_PROPERTY_NAME_OVERRIDES;

    // These are cases where the default logic for pluralized-to-singular property names won't work.
    static {
        final Map<String, String> tempMap = new HashMap<>();
        tempMap.put("Addresses", "Address");
        tempMap.put("AccountDetail", "AccountDetails");
        SINGULAR_PROPERTY_NAME_OVERRIDES = Collections.unmodifiableMap(tempMap);
    }

    @Test
    public void testAllBeans()
        throws IOException, ClassNotFoundException, IntrospectionException, IllegalAccessException, InvocationTargetException, InstantiationException, ToolkitException,
        NoSuchMethodException {
        doTests(this.getClass().getPackage().getName(), PROPERTY_NAME_TO_CLASS_NAME_ALIASES, SINGULAR_PROPERTY_NAME_OVERRIDES);
    }
}
