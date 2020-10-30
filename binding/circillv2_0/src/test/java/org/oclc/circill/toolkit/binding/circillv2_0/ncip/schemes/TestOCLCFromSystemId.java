/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.ncip.common.FromSystemId;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for OCLCFromSystemId.
 */
public class TestOCLCFromSystemId {

    @Test
    public void testLoadAllMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        final Method m = OCLCFromSystemId.class.getMethod("loadAll");
        m.invoke(null);
    }

    @Test
    public void testIdentity() throws Exception {

        final FromSystemId assignedValue1 = OCLCFromSystemId.WMS_CIRC;
        final FromSystemId foundValue1 = FromSystemId.find(OCLCFromSystemId.WMS_CIRC.getScheme(), OCLCFromSystemId.WMS_CIRC.getValue());
        assertSame("FromSystemId.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final FromSystemId secondAssignedValue1 = OCLCFromSystemId.WMS_CIRC;
        assertSame("Two instances assigned the same FromSystemId constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final FromSystemId secondFoundValue1 = FromSystemId.find(OCLCFromSystemId.WMS_CIRC.getScheme(), OCLCFromSystemId.WMS_CIRC.getValue());
        assertSame("Two instances returned by FromSystemId.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final FromSystemId foundValue2 = FromSystemId.find(OCLCFromSystemId.WSILL.getScheme(), OCLCFromSystemId.WSILL.getValue());
        assertNotSame("FromSystemId.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final FromSystemId assignedValue2 = OCLCFromSystemId.WSILL;
        assertNotSame("Two instances assigned different FromSystemId constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by FromSystemId.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    @Test
    public void testMatchesForOCLCToSystemIdForWMSCirc() {
        final OCLCToSystemId toSystemIdWmsCirc = OCLCToSystemId.WMS_CIRC;
        final OCLCFromSystemId fromSystemIdWmsCirc = OCLCFromSystemId.WMS_CIRC;
        assertTrue(toSystemIdWmsCirc.matches(fromSystemIdWmsCirc));
        assertTrue(fromSystemIdWmsCirc.matches(toSystemIdWmsCirc));
    }

    @Test
    public void testMatchesForOCLCToSystemIdForWSILL() {
        final OCLCToSystemId toSystemIdWSILL = OCLCToSystemId.WSILL;
        final OCLCFromSystemId fromSystemIdWSILL = OCLCFromSystemId.WSILL;
        assertTrue(toSystemIdWSILL.matches(fromSystemIdWSILL));
        assertTrue(fromSystemIdWSILL.matches(toSystemIdWSILL));
    }
}
