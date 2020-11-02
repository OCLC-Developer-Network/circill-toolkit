/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ncipv2_01.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.oclc.circill.toolkit.binding.ncipv2_01.jaxb.elements.SchemeValuePair;
import org.oclc.circill.toolkit.service.ncip.FiscalTransactionType;

public class FiscalTransactionTypeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<FiscalTransactionType> {

    public FiscalTransactionTypeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, FiscalTransactionType.class);
    }

}