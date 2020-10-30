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
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * LookupItemResponseData contains the data that is in a NCIP Lookup Item Response message.
 */
public class LookupItemResponseData implements NCIPResponseData {

    /**
     * Response Header
     */
    protected ResponseHeader responseHeader;
    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();
    /**
     * ItemID
     */
    protected ItemId itemId;

    /**
     * RequestID
     */
    protected RequestId requestId;

    /**
     * Item Optional Fields
     */
    protected ItemOptionalFields itemOptionalFields;

    /**
     * Hold PickupDate
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
     * Generic toString() implementation.
     *
     * @return String
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

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

    /**
     * Retrieves the hold pickup date
     *
     * @return the holdPickupDate
     */
    public GregorianCalendar getHoldPickupDate() {
        return holdPickupDate;
    }

    /**
     * Retrieve the item id
     *
     * @return the itemId
     */
    public ItemId getItemId() {
        return itemId;
    }

    /**
     * Retrieve the request id
     *
     * @return the requestId
     */
    public RequestId getRequestId() {
        return requestId;
    }

    /**
     * Set the item id
     *
     * @param itemId the {@link ItemId}
     */
    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    /**
     * Set the request id
     *
     * @param requestId the requestId to set
     */
    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    /**
     * Set the hold pickup date
     *
     * @param holdPickupDate the holdPickupDate to set
     */
    public void setHoldPickupDate(final GregorianCalendar holdPickupDate) {
        this.holdPickupDate = holdPickupDate;
    }

    /**
     * Retrieve the descriptive information about the item
     *
     * @return the itemOptionalFields
     */
    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    /**
     * Set the descriptive information about the item
     *
     * @param itemOptionalFields the itemDescription to set
     */
    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    /**
     * Retrieve the date recalled for the item
     *
     * @return the dateRecalled
     */
    public GregorianCalendar getDateRecalled() {
        return dateRecalled;
    }

    /**
     * Set the date recalled for the item
     *
     * @param dateRecalled the dateRecalled to set
     */
    public void setDateRecalled(final GregorianCalendar dateRecalled) {
        this.dateRecalled = dateRecalled;
    }

    public void setItemTransaction(final ItemTransaction itemTransaction) {
        this.itemTransaction = itemTransaction;
    }

    public ItemTransaction getItemTransaction() {
        return this.itemTransaction;
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
        final LookupItemResponseData rhs = (LookupItemResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems).append(itemId, rhs.itemId)
            .append(requestId, rhs.requestId).append(itemOptionalFields, rhs.itemOptionalFields).append(holdPickupDate, rhs.holdPickupDate).append(dateRecalled, rhs.dateRecalled)
            .append(itemTransaction, rhs.itemTransaction).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(151918227, 804567847).append(responseHeader).append(problems).append(itemId).append(requestId).append(itemOptionalFields)
            .append(holdPickupDate).append(dateRecalled).append(itemTransaction).toHashCode();
        return result;
    }
}
