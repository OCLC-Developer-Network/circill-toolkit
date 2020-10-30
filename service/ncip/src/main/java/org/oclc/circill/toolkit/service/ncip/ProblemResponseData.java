/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents the contents of an NCIP response message that indicates one or more {@link Problem}s.
 */
public class ProblemResponseData implements NCIPResponseData {

    /**
     * The list of {@link Problem} elements.
     */
    protected List<Problem> problems = new ArrayList<>();

    /**
     * Set the list of {@link Problem}s for this response message.
     *
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    public void setProblems(final List<Problem> problems) {
        this.problems = problems;
    }

    public void setProblem(final int index, final Problem problem) {
        problems.set(index, problem);
    }

    /**
     * Get the list of {@link Problem}s in this response message.
     *
     * @return the list of Problems.
     */
    @Override
    public List<Problem> getProblems() {
        return problems;
    }

    public Problem getProblem(final int index) {
        return problems != null ? (problems.size() > 0 ? problems.get(index) : null) : null;
    }

    /**
     * Generic toString() implementation.
     *
     * @return String
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final ProblemResponseData rhs = (ProblemResponseData) obj;
        return new EqualsBuilder().append(problems, rhs.problems).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(4086363, 277314857).append(problems).toHashCode();
        return result;
    }
}
