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
 * LookupItemResponseData contains the data that is in a NCIP Lookup Item Response message.
 */
public class LookupItemSetResponseData implements NCIPResponseData {

    /**
     * Response Header
     */
    protected ResponseHeader responseHeader;
    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();
    /**
     * Bib Information
     */
    protected List<BibInformation> bibInformations = new ArrayList<>();

    /**
     * Next Item Token
     */
    protected String nextItemToken;

    /**
     * Retrieve the response header.
     *
     * @return the response header
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Set the response header
     *
     * @param responseHeader the {@link ResponseHeader}
     */
    public void setResponseHeader(final ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    /**
     * Retrieve the list of {@link Problem}s.
     *
     * @return the list of problems
     */
    @Override
    public List<Problem> getProblems() {
        return problems;
    }

    public Problem getProblem(final int index) {
        return problems != null ? (problems.size() > 0 ? problems.get(index) : null) : null;
    }

    /**
     * Set the list of {@link Problem}s.
     *
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    public void setProblems(final List<Problem> problems) {
        this.problems = problems;
    }

    public void setProblem(final int index, final Problem problem) {
        problems.set(index, problem);
    }

    public List<BibInformation> getBibInformations() {
        return bibInformations;
    }

    public BibInformation getBibInformation(final int index) {
        return bibInformations != null ? (bibInformations.size() > 0 ? bibInformations.get(index) : null) : null;
    }

    public void setBibInformations(final List<BibInformation> bibInformations) {
        this.bibInformations = bibInformations;
    }

    public void setBibInformation(final int index, final BibInformation bibInformation) {
        bibInformations.set(index, bibInformation);
    }

    public String getNextItemToken() {
        return nextItemToken;
    }

    public void setNextItemToken(final String nextItemToken) {
        this.nextItemToken = nextItemToken;
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
        final LookupItemSetResponseData rhs = (LookupItemSetResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems)
            .append(bibInformations, rhs.bibInformations).append(nextItemToken, rhs.nextItemToken).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(736277271, 748768595).append(responseHeader).append(problems).append(bibInformations).append(nextItemToken).toHashCode();
        return result;
    }
}
