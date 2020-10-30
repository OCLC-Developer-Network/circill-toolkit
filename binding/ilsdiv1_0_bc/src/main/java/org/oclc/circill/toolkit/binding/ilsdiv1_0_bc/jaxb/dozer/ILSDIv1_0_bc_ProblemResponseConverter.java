/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.dozer;

import org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.Problem;
import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseProblemResponseConverter;

import java.util.ArrayList;

/**
 * Created by bodfishj on 9/3/14.
 */
public class ILSDIv1_0_bc_ProblemResponseConverter extends BaseProblemResponseConverter {

    public ILSDIv1_0_bc_ProblemResponseConverter() {

        super(ArrayList.class, Problem.class);

    }

}
