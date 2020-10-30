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

public class HoldingsSet {

    /**
     * Holdings Set Id
     */
    protected String holdingsSetId;
    /**
     * Bibliographic Description
     */
    protected BibliographicDescription bibliographicDescription;
    /**
     * Location
     */
    protected Location location;
    /**
     * Call Number
     */
    protected String callNumber;
    /**
     * Summary Holdings Information
     */
    protected SummaryHoldingsInformation summaryHoldingsInformation;
    /**
     * Electronic Resource
     */
    protected ElectronicResource electronicResource;
    /**
     * Item Information
     */
    protected List<ItemInformation> itemInformations = new ArrayList<>();
    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();

    public String getHoldingsSetId() {
        return holdingsSetId;
    }

    public void setHoldingsSetId(final String holdingsSetId) {
        this.holdingsSetId = holdingsSetId;
    }

    public BibliographicDescription getBibliographicDescription() {
        return bibliographicDescription;
    }

    public void setBibliographicDescription(final BibliographicDescription bibliographicDescription) {
        this.bibliographicDescription = bibliographicDescription;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(final String callNumber) {
        this.callNumber = callNumber;
    }

    public SummaryHoldingsInformation getSummaryHoldingsInformation() {
        return summaryHoldingsInformation;
    }

    public void setSummaryHoldingsInformation(final SummaryHoldingsInformation summaryHoldingsInformation) {
        this.summaryHoldingsInformation = summaryHoldingsInformation;
    }

    public ElectronicResource getElectronicResource() {
        return electronicResource;
    }

    public void setElectronicResource(final ElectronicResource electronicResource) {
        this.electronicResource = electronicResource;
    }

    public List<ItemInformation> getItemInformations() {
        return itemInformations;
    }

    public ItemInformation getItemInformation(final int index) {
        return itemInformations != null ? (itemInformations.size() > 0 ? itemInformations.get(index) : null) : null;
    }

    public void setItemInformations(final List<ItemInformation> itemInformations) {
        this.itemInformations = itemInformations;
    }

    public void setItemInformation(final int index, final ItemInformation itemInformation) {
        itemInformations.set(index, itemInformation);
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
        final HoldingsSet rhs = (HoldingsSet) obj;
        return new EqualsBuilder().append(holdingsSetId, rhs.holdingsSetId).append(bibliographicDescription, rhs.bibliographicDescription).append(location, rhs.location)
            .append(callNumber, rhs.callNumber).append(summaryHoldingsInformation, rhs.summaryHoldingsInformation).append(electronicResource, rhs.electronicResource)
            .append(itemInformations, rhs.itemInformations).append(problems, rhs.problems).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(817955299, 1320306035).append(holdingsSetId).append(bibliographicDescription).append(location).append(callNumber)
            .append(summaryHoldingsInformation).append(electronicResource).append(itemInformations).append(problems).toHashCode();
        return result;
    }
}
