/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.PickupLocation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Unit tests for OCLCPickupLocationScheme.
 */
public class TestOCLCPickupLocationScheme {

    private static final String TEST_VALUE_1 = "Test value 1 - don't care.";
    private static final String TEST_VALUE_2 = "Test value 2 - don't care.";
    private static final String TEST_SCHEME_URI_1 = "Scheme 1";

    @Test
    public void testLoadAllMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        final Method m = OCLCPickupLocationScheme.class.getMethod("loadAll");
        m.invoke(null);
    }

    public static class TestOCLCPickupLocation extends PickupLocation {
        public TestOCLCPickupLocation(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PickupLocation VALUE1 = new PickupLocation(TEST_SCHEME_URI_1, TEST_VALUE_1);
        public static final PickupLocation VALUE2 = new PickupLocation(TEST_SCHEME_URI_1, TEST_VALUE_2);
    }

    @Test
    public void testIdentity() throws ToolkitInternalException, ConfigurationException {

        final PickupLocation assignedValue1 = TestOCLCPickupLocation.VALUE1;
        final PickupLocation foundValue1 = PickupLocation.find(TestOCLCPickupLocation.VALUE1.getScheme(), TestOCLCPickupLocation.VALUE1.getValue());
        assertSame("PickupLocation.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PickupLocation secondAssignedValue1 = TestOCLCPickupLocation.VALUE1;
        assertSame("Two instances assigned the same PickupLocation constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PickupLocation secondFoundValue1 = PickupLocation.find(TestOCLCPickupLocation.VALUE1.getScheme(), TestOCLCPickupLocation.VALUE1.getValue());
        assertSame("Two instances returned by PickupLocation.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PickupLocation foundValue2 = PickupLocation.find(TestOCLCPickupLocation.VALUE2.getScheme(), TestOCLCPickupLocation.VALUE2.getValue());
        assertNotSame("PickupLocation.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PickupLocation assignedValue2 = TestOCLCPickupLocation.VALUE2;
        assertNotSame("Two instances assigned different PickupLocation constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PickupLocation.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    @Test
    public void testInstIdSchemeAllowsAnyValueInKnownScheme() throws ToolkitInternalException, ConfigurationException {
        OCLCPickupLocationScheme.loadAll();
        final PickupLocation pickupLocation = PickupLocation.find(OCLCPickupLocationScheme.INSTITUTION_ID_SCHEME_URI, TEST_VALUE_1);
        assertNotNull(pickupLocation);
    }

    @Test
    public void testBranchIdSchemeAllowsAnyValueInKnownScheme() throws ToolkitInternalException, ConfigurationException {
        OCLCPickupLocationScheme.loadAll();
        final PickupLocation pickupLocation = PickupLocation.find(OCLCPickupLocationScheme.BRANCH_ID_SCHEME_URI, TEST_VALUE_1);
        assertNotNull(pickupLocation);
    }

    @Test
    public void testSymbolSchemeAllowsAnyValueInKnownScheme() throws ToolkitInternalException, ConfigurationException {
        OCLCPickupLocationScheme.loadAll();
        final PickupLocation pickupLocation = PickupLocation.find(OCLCPickupLocationScheme.SYMBOL_SCHEME_URI, TEST_VALUE_1);
        assertNotNull(pickupLocation);
    }
}
