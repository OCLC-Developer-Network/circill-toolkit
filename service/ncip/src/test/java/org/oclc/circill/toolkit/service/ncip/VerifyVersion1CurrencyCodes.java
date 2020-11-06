/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.BaseVerifyCurrencyCodes;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

/**
 * Verify {@link Version1CurrencyCode}.
 * {@inheritDoc}
 */
public class VerifyVersion1CurrencyCodes extends BaseVerifyCurrencyCodes {
    public static void main(final String[] args) throws ToolkitInternalException {
        validateServiceClassCodesAreInJava(Version1CurrencyCode.class);
        validateJavaCodesAreInServiceClass(Version1CurrencyCode.class, Version1CurrencyCode.VERSION_1_CURRENCY_CODE);
    }
}
