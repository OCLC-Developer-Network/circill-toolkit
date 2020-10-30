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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Unit tests for CircILLItemIdentifierType.
 */
public class TestCircILLItemIdentifierType {

    @Test
    public void testLoadAllMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        final Method m = CircILLItemIdentifierType.class.getMethod("loadAll");
        m.invoke(null);
    }

    @Test
    public void testIdentity() throws Exception {

        final ItemIdentifierType assignedValue1 = CircILLItemIdentifierType.ILL_REQUEST_ID;
        final ItemIdentifierType foundValue1 = CircILLItemIdentifierType
            .find(CircILLItemIdentifierType.ILL_REQUEST_ID.getScheme(), CircILLItemIdentifierType.ILL_REQUEST_ID.getValue());
        assertThat("ItemIdentifierType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, is(foundValue1));

        final ItemIdentifierType secondAssignedValue1 = CircILLItemIdentifierType.ILL_REQUEST_ID;
        assertThat("Two instances assigned the same ItemIdentifierType constant aren't the same object.", assignedValue1, is(secondAssignedValue1));

        final ItemIdentifierType secondFoundValue1 = ItemIdentifierType
            .find(CircILLItemIdentifierType.ILL_REQUEST_ID.getScheme(), CircILLItemIdentifierType.ILL_REQUEST_ID.getValue());
        assertThat("Two instances returned by ItemIdentifierType.find method with same parameters aren't the same object.", foundValue1, is(secondFoundValue1));

        // Remaining assertions omitted as CircILLItemIdentifierType has only one value.

    }

    @Test
    public void testMatchesForCircILLItemIdentifierType() {
        final RequestIdentifierType requestIdentifierType = CircILLRequestIdentifierType.ILL_REQUEST_ID;
        final ItemIdentifierType itemIdentifierType = CircILLItemIdentifierType.ILL_REQUEST_ID;
        // Test the reflexivity of the matching. While the unit under test is CircILLItemIdentifierType, we test both "sides" of the reflexivity here
        // to ensure it's tested without requiring looking at CircILLRequestIdentifierType to establish that.
        assertThat(requestIdentifierType.matches(itemIdentifierType), is(true));
        assertThat(itemIdentifierType.matches(requestIdentifierType), is(true));
    }
}
