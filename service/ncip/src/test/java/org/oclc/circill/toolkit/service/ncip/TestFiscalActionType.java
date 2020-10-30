/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.junit.Assert;
import org.junit.Test;

public class TestFiscalActionType {
    final String TEST_SCHEME = "Test scheme";
    final String TEST_VALUE = "Test value";

    @Test
    public void testConstructor() {
        final FiscalActionType fat = new FiscalActionType(TEST_SCHEME, TEST_VALUE);
        Assert.assertSame("FiscalActionType's 'scheme' passed to constructor should be the same object as is returned by getter.", TEST_SCHEME, fat.getScheme());
        Assert.assertSame("FiscalActionType's 'value' passed to constructor should be the same object as is returned by getter.", TEST_VALUE, fat.getValue());
    }
}
