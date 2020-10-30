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

public class ItemInformation {

    /**
     * Item Id
     */
    protected ItemId itemId;
    /**
     * Request Ids
     */
    protected List<RequestId> requestIds = new ArrayList<>();
    /**
     * Current Borrower
     */
    protected CurrentBorrower currentBorrower;
    /**
     * Current Requesters
     */
    protected List<CurrentRequester> currentRequesters = new ArrayList<>();
    /**
     * Date Due
     */
    protected GregorianCalendar dateDue;
    /**
     * Hold Pickup Date
     */
    protected GregorianCalendar holdPickupDate;
    /**
     * Date Recalled
     */
    protected GregorianCalendar dateRecalled;
    /**
     * Item Transaction
     */
    protected ItemTransaction itemTransaction;
    /**
     * Item Optional Fields
     */
    protected ItemOptionalFields itemOptionalFields;

    /**
     * Item Note
     */
    protected String itemNote;
    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    public List<RequestId> getRequestIds() {
        return requestIds;
    }

    public RequestId getRequestId(final int index) {
        return requestIds != null ? (requestIds.size() > 0 ? requestIds.get(index) : null) : null;
    }

    public void setRequestIds(final List<RequestId> requestIds) {
        this.requestIds = requestIds;
    }

    public void setRequestId(final int index, final RequestId requestId) {
        requestIds.set(index, requestId);
    }

    public CurrentBorrower getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(final CurrentBorrower currentBorrower) {
        this.currentBorrower = currentBorrower;
    }

    public List<CurrentRequester> getCurrentRequesters() {
        return currentRequesters;
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

    public GregorianCalendar getDateDue() {
        return dateDue;
    }

    public void setDateDue(final GregorianCalendar dateDue) {
        this.dateDue = dateDue;
    }

    public GregorianCalendar getHoldPickupDate() {
        return holdPickupDate;
    }

    public void setHoldPickupDate(final GregorianCalendar holdPickupDate) {
        this.holdPickupDate = holdPickupDate;
    }

    public GregorianCalendar getDateRecalled() {
        return dateRecalled;
    }

    public void setDateRecalled(final GregorianCalendar dateRecalled) {
        this.dateRecalled = dateRecalled;
    }

    public ItemTransaction getItemTransaction() {
        return itemTransaction;
    }

    public void setItemTransaction(final ItemTransaction itemTransaction) {
        this.itemTransaction = itemTransaction;
    }

    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(final String itemNote) {
        this.itemNote = itemNote;
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
        final ItemInformation rhs = (ItemInformation) obj;
        return new EqualsBuilder().append(itemId, rhs.itemId).append(requestIds, rhs.requestIds).append(currentBorrower, rhs.currentBorrower)
            .append(currentRequesters, rhs.currentRequesters).append(dateDue, rhs.dateDue).append(holdPickupDate, rhs.holdPickupDate).append(dateRecalled, rhs.dateRecalled)
            .append(itemTransaction, rhs.itemTransaction).append(itemOptionalFields, rhs.itemOptionalFields).append(itemNote, rhs.itemNote).append(problems, rhs.problems)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1895508875, 652749153).append(itemId).append(requestIds).append(currentBorrower).append(currentRequesters).append(dateDue)
            .append(holdPickupDate).append(dateRecalled).append(itemTransaction).append(itemOptionalFields).append(itemNote).append(problems).toHashCode();
        return result;
    }
}
