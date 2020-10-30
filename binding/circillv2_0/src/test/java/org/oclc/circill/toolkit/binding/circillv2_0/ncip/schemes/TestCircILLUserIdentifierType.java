/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.ncip.UserIdentifierType;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Unit tests for CircILLUserIdentifierType.
 */
public class TestCircILLUserIdentifierType {

    @Test
    public void testLoadAllMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        final Method m = CircILLUserIdentifierType.class.getMethod("loadAll");
        m.invoke(null);
    }

    static class ExtensionCircILLUserIdentifierType extends CircILLUserIdentifierType {
        ExtensionCircILLUserIdentifierType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ExtensionCircILLUserIdentifierType EXTENSION = new ExtensionCircILLUserIdentifierType("scheme", "value");
    }

    @Test
    public void testIdentity() throws Exception {

        final UserIdentifierType assignedValue1 = CircILLUserIdentifierType.OCLC_INSTITUTION_SYMBOL;
        final UserIdentifierType foundValue1 = UserIdentifierType
            .find(CircILLUserIdentifierType.OCLC_INSTITUTION_SYMBOL.getScheme(), CircILLUserIdentifierType.OCLC_INSTITUTION_SYMBOL.getValue());
        assertSame("UserIdentifierType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final UserIdentifierType secondAssignedValue1 = CircILLUserIdentifierType.OCLC_INSTITUTION_SYMBOL;
        assertSame("Two instances assigned the same UserIdentifierType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final UserIdentifierType secondFoundValue1 = UserIdentifierType
            .find(CircILLUserIdentifierType.OCLC_INSTITUTION_SYMBOL.getScheme(), CircILLUserIdentifierType.OCLC_INSTITUTION_SYMBOL.getValue());
        assertSame("Two instances returned by UserIdentifierType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final UserIdentifierType foundValue2 = UserIdentifierType
            .find(ExtensionCircILLUserIdentifierType.EXTENSION.getScheme(), ExtensionCircILLUserIdentifierType.EXTENSION.getValue());
        assertNotSame("UserIdentifierType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final UserIdentifierType assignedValue2 = ExtensionCircILLUserIdentifierType.EXTENSION;
        assertNotSame("Two instances assigned different UserIdentifierType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by UserIdentifierType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }
}
