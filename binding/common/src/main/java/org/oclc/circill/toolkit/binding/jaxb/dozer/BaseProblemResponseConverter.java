/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import org.oclc.circill.toolkit.service.ncip.Problem;
import org.oclc.circill.toolkit.service.ncip.ProblemResponseData;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

// TODO: Step 12:Refactor this to map from a List to an object containing a list (thus removing the NCIP-specifics).
// TODO: Why isn't this used in ncip binding packages, nor in WCL v1.0, but *is* used in ILDSI and WCL v1.1?

/**
 * This class handles the mapping from the NCIPMessage/Problem element (which is repeatable) to the NCIPMessage's problemResponse property, within which
 * is the list of Problems.
 * @param <JAXBProblem> the JAXB-generated class for the Problem element
 */
public class BaseProblemResponseConverter<JAXBProblem> extends DozerConverter<List<JAXBProblem>, ProblemResponseData> implements MapperAware {

    /** The Dozer mapper. */
    protected Mapper mapper;
    /** The JAXB-generated class for {@link Problem}s. */
    protected final Class<JAXBProblem> jaxbProblemClass;

    /**
     * Construct an instance of the converter.
     * @param jaxbProblemListClass the {@link Class} used for a list of JAXB-generated Problem objects
     * @param jaxbProblemClass the JAXB-generated class for {@link Problem}s
     */
    public BaseProblemResponseConverter(final Class<List<JAXBProblem>> jaxbProblemListClass, final Class<JAXBProblem> jaxbProblemClass) {
        super(jaxbProblemListClass, ProblemResponseData.class);
        this.jaxbProblemClass = jaxbProblemClass;
    }

    @Override
    public ProblemResponseData convertTo(final List jaxbProblemList, final ProblemResponseData responseData) {
        ProblemResponseData result = null;
        if (jaxbProblemList != null && jaxbProblemList.size() > 0) {
            result = new ProblemResponseData();
            final List<Problem> svcProblemsList = new ArrayList<>();
            for (final Object obj : jaxbProblemList) {
                final JAXBProblem jaxbProblem = (JAXBProblem) obj;
                final Problem svcProblem = mapper.map(jaxbProblem, Problem.class);
                svcProblemsList.add(svcProblem);
            }
            result.setProblems(svcProblemsList);
        } // else do nothing - input object is null
        return result;
    }

    @Override
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:ParameterAssignment"}) // Dozer converters assume the target object is modified
    public List<JAXBProblem> convertFrom(final ProblemResponseData responseData, List<JAXBProblem> jaxbProblemList) {
        if (responseData.getProblems() != null && responseData.getProblems().size() > 0) {
            if (jaxbProblemList == null) {
                jaxbProblemList = new ArrayList<>();
            }
            for (final Problem svcProblem : responseData.getProblems()) {
                final JAXBProblem jaxbProblem = mapper.map(svcProblem, jaxbProblemClass);
                jaxbProblemList.add(jaxbProblem);
            }
        }
        return jaxbProblemList;
    }

    @Override
    public void setMapper(final Mapper mapper) {
        this.mapper = mapper;
    }
}
