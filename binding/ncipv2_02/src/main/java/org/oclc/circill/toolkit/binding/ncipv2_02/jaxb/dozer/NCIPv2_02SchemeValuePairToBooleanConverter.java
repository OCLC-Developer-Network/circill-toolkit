/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ncipv2_02.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseSchemeValuePairToBooleanConverter;
import org.oclc.circill.toolkit.binding.ncipv2_02.jaxb.elements.SchemeValuePair;

import java.util.ArrayList;

public class NCIPv2_02SchemeValuePairToBooleanConverter extends BaseSchemeValuePairToBooleanConverter {

    public NCIPv2_02SchemeValuePairToBooleanConverter() {

        super(ArrayList.class, SchemeValuePair.class);

    }
}
