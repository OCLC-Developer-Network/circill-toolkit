/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BaseTestCurrencyCode;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import org.junit.Test;

/**
 * Unit Test for Version1CurrencyCode.
 */
public class TestVersion2017CurrencyCode extends BaseTestCurrencyCode {

    @Test
    public void test_ServiceClassCodesAreInJava() throws IllegalAccessException {
        validateServiceClassCodesAreInJava(Version2017CurrencyCode.class);
    }

    @Test
    public void test_JavaCodesAreInServiceClass() throws ToolkitInternalException {
        validateJavaCodesAreInServiceClass(Version2017CurrencyCode.class, Version2017CurrencyCode.VERSION_2017_CURRENCY_CODE_SCHEME_URI);
    }

}
