/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ilsdiv1_0.jaxb.dozer;

import org.oclc.circill.toolkit.binding.ilsdiv1_0.jaxb.elements.Problem;
import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseProblemResponseConverter;
import org.oclc.circill.toolkit.service.ncip.ProblemResponseData;

import java.util.ArrayList;

/**
 * Convert {@link ProblemResponseData} objects.
 */
@SuppressWarnings("java:S3740")
public class ILSDIv1_0ProblemResponseConverter extends BaseProblemResponseConverter {
    /**
     * Construct an instance.
     */
    public ILSDIv1_0ProblemResponseConverter() {
        super(ArrayList.class, Problem.class);
    }
}
