/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ItemDetails {
    /**
     * Item Id
     */
    protected ItemId itemId;
    /**
     * Bibliographic Description
     */
    protected BibliographicDescription bibliographicDescription;
    /**
     * Date Checked Out
     */
    protected GregorianCalendar dateCheckedOut;
    /**
     * Date Renewed
     */
    protected List<GregorianCalendar> dateReneweds = new ArrayList<>();
    /**
     * Date Due
     */
    protected GregorianCalendar dateDue;
    /**
     * Indeterminate Loan Period Flag
     */
    protected Boolean indeterminateLoanPeriodFlag;
    /**
     * NonReturnable Flag
     */
    protected Boolean nonReturnableFlag;
    /**
     * Date Returned
     */
    protected GregorianCalendar dateReturned;

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    public BibliographicDescription getBibliographicDescription() {
        return bibliographicDescription;
    }

    public void setBibliographicDescription(final BibliographicDescription bibliographicDescription) {
        this.bibliographicDescription = bibliographicDescription;
    }

    public GregorianCalendar getDateCheckedOut() {
        return dateCheckedOut;
    }

    public void setDateCheckedOut(final GregorianCalendar dateCheckedOut) {
        this.dateCheckedOut = dateCheckedOut;
    }

    public List<GregorianCalendar> getDateReneweds() {
        return dateReneweds;
    }

    public GregorianCalendar getDateRenewed(final int index) {
        return dateReneweds != null ? (dateReneweds.size() > 0 ? dateReneweds.get(index) : null) : null;
    }

    public void setDateReneweds(final List<GregorianCalendar> dateReneweds) {
        this.dateReneweds = dateReneweds;
    }

    public void setDateRenewed(final int index, final GregorianCalendar dateRenewed) {
        dateReneweds.set(index, dateRenewed);
    }

    public GregorianCalendar getDateDue() {
        return dateDue;
    }

    public void setDateDue(final GregorianCalendar dateDue) {
        this.dateDue = dateDue;
    }

    public Boolean getIndeterminateLoanPeriodFlag() {
        return indeterminateLoanPeriodFlag;
    }

    public void setIndeterminateLoanPeriodFlag(final Boolean indeterminateLoanPeriodFlag) {
        this.indeterminateLoanPeriodFlag = indeterminateLoanPeriodFlag;
    }

    public Boolean getNonReturnableFlag() {
        return nonReturnableFlag;
    }

    public void setNonReturnableFlag(final Boolean nonReturnableFlag) {
        this.nonReturnableFlag = nonReturnableFlag;
    }

    public GregorianCalendar getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(final GregorianCalendar dateReturned) {
        this.dateReturned = dateReturned;
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
        final ItemDetails rhs = (ItemDetails) obj;
        return new EqualsBuilder().append(itemId, rhs.itemId).append(bibliographicDescription, rhs.bibliographicDescription).append(dateCheckedOut, rhs.dateCheckedOut)
            .append(dateReneweds, rhs.dateReneweds).append(dateDue, rhs.dateDue).append(indeterminateLoanPeriodFlag, rhs.indeterminateLoanPeriodFlag)
            .append(nonReturnableFlag, rhs.nonReturnableFlag).append(dateReturned, rhs.dateReturned).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1895508875, 652749153).append(itemId).append(bibliographicDescription).append(dateCheckedOut).append(dateReneweds).append(dateDue)
            .append(indeterminateLoanPeriodFlag).append(nonReturnableFlag).append(dateReturned).toHashCode();
        return result;
    }
}
