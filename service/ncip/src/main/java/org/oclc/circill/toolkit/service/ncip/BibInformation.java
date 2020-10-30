/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BibInformation {

    protected BibliographicId bibliographicId;
    protected BibliographicDescription bibliographicDescription;
    protected BigDecimal titleHoldQueueLength;
    protected List<CurrentRequester> currentRequesters = new ArrayList<>();
    protected List<HoldingsSet> holdingsSets = new ArrayList<>();
    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();

    public BibliographicId getBibliographicId() {
        return bibliographicId;
    }

    public void setBibliographicId(final BibliographicId bibliographicId) {
        this.bibliographicId = bibliographicId;
    }

    public BibliographicDescription getBibliographicDescription() {
        return bibliographicDescription;
    }

    public void setBibliographicDescription(final BibliographicDescription bibliographicDescription) {
        this.bibliographicDescription = bibliographicDescription;
    }

    public BigDecimal getTitleHoldQueueLength() {
        return titleHoldQueueLength;
    }

    public void setTitleHoldQueueLength(final BigDecimal titleHoldQueueLength) {
        this.titleHoldQueueLength = titleHoldQueueLength;
    }

    public List<CurrentRequester> getCurrentRequesters() {
        return currentRequesters;
    }

    public CurrentRequester getCurrentRequester() {
        return currentRequesters != null ? (currentRequesters.size() > 0 ? currentRequesters.get(currentRequesters.size() - 1) : null) : null;
    }

    public CurrentRequester getCurrentRequester(final int index) {
        return currentRequesters != null ? (currentRequesters.size() > 0 ? currentRequesters.get(index) : null) : null;
    }

    public void setCurrentRequesters(final List<CurrentRequester> currentRequesters) {
        this.currentRequesters = currentRequesters;
    }

    public void setCurrentRequester(final int index, final CurrentRequester currentRequester) {
        currentRequesters.set(index, currentRequester);
    }

    /**
     * Set the list of {@link CurrentRequester}s to this currentRequester.
     *
     * @param currentRequester the {@link CurrentRequester}
     */
    public void setCurrentRequester(final CurrentRequester currentRequester) {
        if (this.currentRequesters != null) {
            this.currentRequesters.clear();
        }
        if (currentRequester != null) {
            if (this.currentRequesters == null) {
                this.currentRequesters = new ArrayList<>();
            }
            this.currentRequesters.add(currentRequester);
        } else {
            this.currentRequesters = null;
        }
    }

    public List<HoldingsSet> getHoldingsSets() {
        return holdingsSets;
    }

    public HoldingsSet getHoldingsSet() {
        return holdingsSets != null ? (holdingsSets.size() > 0 ? holdingsSets.get(holdingsSets.size() - 1) : null) : null;
    }

    public HoldingsSet getHoldingsSet(final int index) {
        return holdingsSets != null ? (holdingsSets.size() > 0 ? holdingsSets.get(index) : null) : null;
    }

    public void setHoldingsSets(final List<HoldingsSet> holdingsSets) {
        this.holdingsSets = holdingsSets;
    }

    public void setHoldingsSet(final int index, final HoldingsSet holdingsSet) {
        holdingsSets.set(index, holdingsSet);
    }

    /**
     * Set the list of {@link HoldingsSet}s to this holdingsSet.
     *
     * @param holdingsSet the {@link HoldingsSet}
     */
    public void setHoldingsSet(final HoldingsSet holdingsSet) {
        if (this.holdingsSets != null) {
            this.holdingsSets.clear();
        }
        if (holdingsSet != null) {
            if (this.holdingsSets == null) {
                this.holdingsSets = new ArrayList<>();
            }
            this.holdingsSets.add(holdingsSet);
        } else {
            this.holdingsSets = null;
        }
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public Problem getProblem(final int index) {
        return problems != null ? (problems.size() > 0 ? problems.get(index) : null) : null;
    }

    public void setProblems(final List<Problem> problems) {
        this.problems = problems;
    }

    public void setProblem(final int index, final Problem problem) {
        problems.set(index, problem);
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
        final BibInformation rhs = (BibInformation) obj;
        return new EqualsBuilder().append(bibliographicId, rhs.bibliographicId).append(bibliographicDescription, rhs.bibliographicDescription)
            .append(titleHoldQueueLength, rhs.titleHoldQueueLength).append(currentRequesters, rhs.currentRequesters).append(holdingsSets, rhs.holdingsSets)
            .append(problems, rhs.problems).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2113721943, 1616817019).append(bibliographicId).append(bibliographicDescription).append(titleHoldQueueLength)
            .append(currentRequesters).append(holdingsSets).append(problems).toHashCode();
        return result;
    }
}
