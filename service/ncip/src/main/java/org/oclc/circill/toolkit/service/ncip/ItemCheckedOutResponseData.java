/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the ItemCheckedOutResponse.
 */
public class ItemCheckedOutResponseData implements NCIPResponseData {

    /**
     * ResponseHeader
     */
    protected ResponseHeader responseHeader;

    /**
     * Set ResponseHeader.
     * @param responseHeader the {@link ResponseHeader}
     */
    public void setResponseHeader(final ResponseHeader responseHeader) {

        this.responseHeader = responseHeader;

    }

    /**
     * Get ResponseHeader.
     *
     * @return the {@link ResponseHeader}
     */
    public ResponseHeader getResponseHeader() {

        return responseHeader;

    }

    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();

    /**
     * Set Problems.
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    public void setProblems(final List<Problem> problems) {

        this.problems = problems;

    }

    /**
     * Get Problems.
     */
    @Override
    public List<Problem> getProblems() {

        return problems;

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
        final ItemCheckedOutResponseData rhs = (ItemCheckedOutResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2054682227, 2082387183).append(responseHeader).append(problems).toHashCode();
        return result;
    }
}
