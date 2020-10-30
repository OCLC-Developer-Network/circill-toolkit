/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_1.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseProblemResponseConverter;
import org.oclc.circill.toolkit.binding.wclv1_1.jaxb.elements.Problem;

import java.util.ArrayList;

public class WCLv1_1ProblemResponseConverter extends BaseProblemResponseConverter {

    public WCLv1_1ProblemResponseConverter() {

        super(ArrayList.class, Problem.class);

    }
}
