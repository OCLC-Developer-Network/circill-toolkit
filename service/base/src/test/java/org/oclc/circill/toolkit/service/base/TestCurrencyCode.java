/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import org.junit.Assert;
import org.junit.Test;

public class TestCurrencyCode {

    static final String TEST_CODE = "FAKE";
    static final int MINOR_UNIT = 4;

    @Test
    public void testSchemelessInstance() {

        final CurrencyCode cc = new CurrencyCode(TEST_CODE, MINOR_UNIT);
        Assert.assertSame("Currency code string passed to constructor is  not the same object as is returned by getter.", TEST_CODE, cc.getValue());
        Assert.assertNull("Scheme should be null (since no Scheme was passed to constructor).", cc.getScheme());
        Assert.assertEquals("Minor units should equal that passed to constructor.", MINOR_UNIT, cc.getMinorUnit());
    }
}
