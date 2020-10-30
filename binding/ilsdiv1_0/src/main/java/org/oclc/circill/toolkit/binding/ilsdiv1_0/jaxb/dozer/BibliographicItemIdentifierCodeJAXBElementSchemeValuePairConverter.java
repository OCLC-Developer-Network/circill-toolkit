/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ilsdiv1_0.jaxb.dozer;

import org.oclc.circill.toolkit.binding.ilsdiv1_0.jaxb.elements.SchemeValuePair;
import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.oclc.circill.toolkit.service.base.BibliographicItemIdentifierCode;

public class BibliographicItemIdentifierCodeJAXBElementSchemeValuePairConverter extends BaseJAXBElementSchemeValuePairConverter<BibliographicItemIdentifierCode> {

    public BibliographicItemIdentifierCodeJAXBElementSchemeValuePairConverter() {
        super(SchemeValuePair.class, BibliographicItemIdentifierCode.class);
    }

}
