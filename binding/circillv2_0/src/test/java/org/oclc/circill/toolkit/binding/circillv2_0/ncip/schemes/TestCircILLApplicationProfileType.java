/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.ncip.common.ApplicationProfileType;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Unit tests for CircILLApplicationProfileType.
 */
public class TestCircILLApplicationProfileType {

    @Test
    public void testLoadAllMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        final Method m = CircILLApplicationProfileType.class.getMethod("loadAll");
        m.invoke(null);
    }

    @Test
    public void testIdentity() throws Exception {

        final ApplicationProfileType assignedValue1 = CircILLApplicationProfileType.VERSION_1_0;
        final ApplicationProfileType foundValue1 = ApplicationProfileType
            .find(CircILLApplicationProfileType.VERSION_1_0.getScheme(), CircILLApplicationProfileType.VERSION_1_0.getValue());
        assertSame("ApplicationProfileType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ApplicationProfileType secondAssignedValue1 = CircILLApplicationProfileType.VERSION_1_0;
        assertSame("Two instances assigned the same ApplicationProfileType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ApplicationProfileType secondFoundValue1 = ApplicationProfileType
            .find(CircILLApplicationProfileType.VERSION_1_0.getScheme(), CircILLApplicationProfileType.VERSION_1_0.getValue());
        assertSame("Two instances returned by ApplicationProfileType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ApplicationProfileType foundValue2 = ApplicationProfileType
            .find(CircILLApplicationProfileType.VERSION_2_0.getScheme(), CircILLApplicationProfileType.VERSION_2_0.getValue());
        assertNotSame("ApplicationProfileType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ApplicationProfileType assignedValue2 = CircILLApplicationProfileType.VERSION_2_0;
        assertNotSame("Two instances assigned different ApplicationProfileType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ApplicationProfileType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }
}
