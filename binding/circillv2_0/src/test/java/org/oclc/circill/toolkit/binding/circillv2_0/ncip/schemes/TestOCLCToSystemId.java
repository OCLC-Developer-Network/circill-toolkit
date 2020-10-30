/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.ncip.common.ToSystemId;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for OCLCToSystemId.
 */
public class TestOCLCToSystemId {

    @Test
    public void testLoadAllMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        final Method m = OCLCToSystemId.class.getMethod("loadAll");
        m.invoke(null);
    }

    @Test
    public void testIdentity() throws Exception {

        final ToSystemId assignedValue1 = OCLCToSystemId.WMS_CIRC;
        final ToSystemId foundValue1 = ToSystemId.find(OCLCToSystemId.WMS_CIRC.getScheme(), OCLCToSystemId.WMS_CIRC.getValue());
        assertSame("ToSystemId.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ToSystemId secondAssignedValue1 = OCLCToSystemId.WMS_CIRC;
        assertSame("Two instances assigned the same ToSystemId constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ToSystemId secondFoundValue1 = ToSystemId.find(OCLCToSystemId.WMS_CIRC.getScheme(), OCLCToSystemId.WMS_CIRC.getValue());
        assertSame("Two instances returned by ToSystemId.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ToSystemId foundValue2 = ToSystemId.find(OCLCToSystemId.WSILL.getScheme(), OCLCToSystemId.WSILL.getValue());
        assertNotSame("ToSystemId.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ToSystemId assignedValue2 = OCLCToSystemId.WSILL;
        assertNotSame("Two instances assigned different ToSystemId constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ToSystemId.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    @Test
    public void testMatchesForOCLCFromSystemIdForWMSCirc() {
        final OCLCFromSystemId fromSystemIdWmsCirc = OCLCFromSystemId.WMS_CIRC;
        final OCLCToSystemId toSystemIdWmsCirc = OCLCToSystemId.WMS_CIRC;
        assertTrue(fromSystemIdWmsCirc.matches(toSystemIdWmsCirc));
        assertTrue(toSystemIdWmsCirc.matches(fromSystemIdWmsCirc));
    }

    @Test
    public void testMatchesForOCLCFromSystemIdForWSILL() {
        final OCLCFromSystemId fromSystemIdWSILL = OCLCFromSystemId.WSILL;
        final OCLCToSystemId toSystemIdWSILL = OCLCToSystemId.WSILL;
        assertTrue(fromSystemIdWSILL.matches(toSystemIdWSILL));
        assertTrue(toSystemIdWSILL.matches(fromSystemIdWSILL));
    }
}
