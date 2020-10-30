/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.ncip.ItemIdentifierType;
import org.oclc.circill.toolkit.service.ncip.RequestIdentifierType;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for CircILLRequestIdentifierType.
 */
public class TestCircILLRequestIdentifierType {

    @Test
    public void testLoadAllMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        final Method m = CircILLRequestIdentifierType.class.getMethod("loadAll");
        m.invoke(null);
    }

    @Test
    public void testIdentity() throws Exception {

        final RequestIdentifierType assignedValue1 = CircILLRequestIdentifierType.ILL_REQUEST_ID;
        final RequestIdentifierType foundValue1 = CircILLRequestIdentifierType
            .find(CircILLRequestIdentifierType.ILL_REQUEST_ID.getScheme(), CircILLRequestIdentifierType.ILL_REQUEST_ID.getValue());
        assertSame("RequestIdentifierType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final RequestIdentifierType secondAssignedValue1 = CircILLRequestIdentifierType.ILL_REQUEST_ID;
        assertSame("Two instances assigned the same RequestIdentifierType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final RequestIdentifierType secondFoundValue1 = RequestIdentifierType
            .find(CircILLRequestIdentifierType.ILL_REQUEST_ID.getScheme(), CircILLRequestIdentifierType.ILL_REQUEST_ID.getValue());
        assertSame("Two instances returned by RequestIdentifierType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        // Remaining assertions omitted as CircILLRequestIdentifierType has only one value.

    }

    @Test
    public void testMatchesForCircILLItemIdentifierType() {
        final ItemIdentifierType itemIdentifierType = CircILLItemIdentifierType.ILL_REQUEST_ID;
        final RequestIdentifierType requestIdentifierType = CircILLRequestIdentifierType.ILL_REQUEST_ID;
        // Test the reflexivity of the matching. While the unit under test is CircILLRequestIdentifierType, we test both "sides" of the reflexivity here
        // to ensure it's tested without requiring looking at CircILLItemIdentifierType to establish that.
        assertTrue(itemIdentifierType.matches(requestIdentifierType));
        assertTrue(requestIdentifierType.matches(itemIdentifierType));
    }
}
