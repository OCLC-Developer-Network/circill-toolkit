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
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Describes a LoanedItem result from an NCIP response
 */
public class LoanedItem {

    protected ItemId itemId;
    protected List<BibliographicId> bibliographicIds = new ArrayList<>();
    protected BigDecimal reminderLevel;
    protected GregorianCalendar dateDue;
    protected Boolean indeterminateLoanPeriodFlag;
    protected Amount amount;
    protected String title;
    protected MediumType mediumType;
    protected BigDecimal renewalCount;
    protected GregorianCalendar dateCheckedOut;
    protected BibliographicDescription bibliographicDescription;
    protected List<RelatedSystemRequestId> relatedSystemRequestIds = new ArrayList<>();

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    public List<BibliographicId> getBibliographicIds() {
        return bibliographicIds;
    }

    public BibliographicId getBibliographicId(final int index) {
        return bibliographicIds != null ? (bibliographicIds.size() > 0 ? bibliographicIds.get(index) : null) : null;
    }

    public void setBibliographicIds(final List<BibliographicId> bibliographicIds) {
        this.bibliographicIds = bibliographicIds;
    }

    public void setBibliographicId(final int index, final BibliographicId bibliographicId) {
        bibliographicIds.set(index, bibliographicId);
    }

    public BigDecimal getReminderLevel() {
        return reminderLevel;
    }

    public void setReminderLevel(final BigDecimal reminderLevel) {
        this.reminderLevel = reminderLevel;
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

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(final Amount amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public MediumType getMediumType() {
        return mediumType;
    }

    public void setMediumType(final MediumType mediumType) {
        this.mediumType = mediumType;
    }

    public BigDecimal getRenewalCount() {
        return renewalCount;
    }

    public void setRenewalCount(final BigDecimal renewalCount) {
        this.renewalCount = renewalCount;
    }

    public GregorianCalendar getDateCheckedOut() {
        return dateCheckedOut;
    }

    public void setDateCheckedOut(final GregorianCalendar dateCheckedOut) {
        this.dateCheckedOut = dateCheckedOut;
    }

    public BibliographicDescription getBibliographicDescription() {
        return bibliographicDescription;
    }

    public void setBibliographicDescription(final BibliographicDescription bibliographicDescription) {
        this.bibliographicDescription = bibliographicDescription;
    }

    public List<RelatedSystemRequestId> getRelatedSystemRequestIds() {
        return relatedSystemRequestIds;
    }

    public RelatedSystemRequestId getRelatedSystemRequestId(final int index) {
        return relatedSystemRequestIds != null ? (relatedSystemRequestIds.size() > 0 ? relatedSystemRequestIds.get(index) : null) : null;
    }

    public void setRelatedSystemRequestIds(final List<RelatedSystemRequestId> relatedSystemRequestIds) {
        this.relatedSystemRequestIds = relatedSystemRequestIds;
    }

    public void setRelatedSystemRequestId(final int index, final RelatedSystemRequestId relatedSystemRequestId) {
        relatedSystemRequestIds.set(index, relatedSystemRequestId);
    }

    /*
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
        final LoanedItem rhs = (LoanedItem) obj;
        return new EqualsBuilder().append(itemId, rhs.itemId).append(bibliographicIds, rhs.bibliographicIds).append(reminderLevel, rhs.reminderLevel).append(dateDue, rhs.dateDue)
            .append(indeterminateLoanPeriodFlag, rhs.indeterminateLoanPeriodFlag).append(amount, rhs.amount).append(title, rhs.title).append(mediumType, rhs.mediumType)
            .append(renewalCount, rhs.renewalCount).append(dateCheckedOut, rhs.dateCheckedOut).append(bibliographicDescription, rhs.bibliographicDescription)
            .append(relatedSystemRequestIds, rhs.relatedSystemRequestIds).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(714266185, 1808718639).append(itemId).append(bibliographicIds).append(reminderLevel).append(dateDue)
            .append(indeterminateLoanPeriodFlag).append(amount).append(title).append(mediumType).append(renewalCount).append(dateCheckedOut).append(bibliographicDescription)
            .append(relatedSystemRequestIds).toHashCode();
        return result;
    }
}
