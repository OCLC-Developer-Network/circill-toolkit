/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BaseVerifyCurrencyCodes;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

/**
 * Verify {@link Version2017CurrencyCode}.
 * {@inheritDoc}
 */
public class VerifyVersion2017CurrencyCodes extends BaseVerifyCurrencyCodes {
    public static void main(final String[] args) throws ToolkitInternalException {
        validateServiceClassCodesAreInJava(Version2017CurrencyCode.class);
        validateJavaCodesAreInServiceClass(Version2017CurrencyCode.class, Version2017CurrencyCode.VERSION_2017_CURRENCY_CODE_SCHEME_URI);
    }
}
