/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.dozer;

import org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.SchemeValuePair;
import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.oclc.circill.toolkit.service.base.CurrencyCode;

public class CurrencyCodeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<CurrencyCode> {

    public CurrencyCodeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, CurrencyCode.class);
    }

}
