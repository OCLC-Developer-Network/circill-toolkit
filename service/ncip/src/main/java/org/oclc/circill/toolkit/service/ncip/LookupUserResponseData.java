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
public class LookupUserResponseData implements NCIPResponseData {

    /**
     * Response Header
     */
    protected ResponseHeader responseHeader;
    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();
    /**
     * UserID
     */
    protected UserId userId;
    /**
     * UserFiscalAccounts
     */
    protected List<UserFiscalAccount> userFiscalAccounts = new ArrayList<>();
    /**
     * LoanedItemsCounts
     */
    protected List<LoanedItemsCount> loanedItemsCounts = new ArrayList<>();
    /**
     * LoanedItems
     */
    protected List<LoanedItem> loanedItems = new ArrayList<>();
    /**
     * RequestedItemsCounts
     */
    protected List<RequestedItemsCount> requestedItemsCounts = new ArrayList<>();
    /**
     * RequestedItems
     */
    protected List<RequestedItem> requestedItems = new ArrayList<>();
    /**
     * User Optional Fields
     */
    protected UserOptionalFields userOptionalFields;

    protected UserFiscalAccountSummary userFiscalAccountSummary;

    protected List<SubsequentElementControl> subsequentElementControls = new ArrayList<>();

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
     * Retrieve the user id
     *
     * @return the userId
     */
    public UserId getUserId() {
        return userId;
    }

    /**
     * Set the user id
     *
     * @param userId the userId to set
     */
    public void setUserId(final UserId userId) {
        this.userId = userId;
    }

    /**
     * Retrieve the list of {@link UserFiscalAccount}s.
     *
     * @return the list of userFiscalAccounts
     */
    public List<UserFiscalAccount> getUserFiscalAccounts() {
        return userFiscalAccounts;
    }

    public UserFiscalAccount getUserFiscalAccount(final int index) {
        return userFiscalAccounts != null ? (userFiscalAccounts.size() > 0 ? userFiscalAccounts.get(index) : null) : null;
    }

    /**
     * Set the list of {@link UserFiscalAccount}s.
     *
     * @param userFiscalAccounts the list of {@link UserFiscalAccount}s
     */
    public void setUserFiscalAccounts(final List<UserFiscalAccount> userFiscalAccounts) {
        this.userFiscalAccounts = userFiscalAccounts;
    }

    public void setUserFiscalAccount(final int index, final UserFiscalAccount userFiscalAccount) {
        userFiscalAccounts.set(index, userFiscalAccount);
    }

    /**
     * Retrieve the list of {@link LoanedItemsCount}s.
     *
     * @return the list of loanedItemsCounts
     */
    public List<LoanedItemsCount> getLoanedItemsCounts() {
        return loanedItemsCounts;
    }

    public LoanedItemsCount getLoanedItemsCount(final int index) {
        return loanedItemsCounts != null ? (loanedItemsCounts.size() > 0 ? loanedItemsCounts.get(index) : null) : null;
    }

    /**
     * Set the list of {@link LoanedItemsCount}s.
     *
     * @param loanedItemsCounts the list of {@link LoanedItemsCount}s
     */
    public void setLoanedItemsCounts(final List<LoanedItemsCount> loanedItemsCounts) {
        this.loanedItemsCounts = loanedItemsCounts;
    }

    public void setLoanedItemsCount(final int index, final LoanedItemsCount loanedItemsCount) {
        loanedItemsCounts.set(index, loanedItemsCount);
    }

    /**
     * Retrieve the list of {@link LoanedItem}s.
     *
     * @return the list of loanedItems
     */
    public List<LoanedItem> getLoanedItems() {
        return loanedItems;
    }

    public LoanedItem getLoanedItem(final int index) {
        return loanedItems != null ? (loanedItems.size() > 0 ? loanedItems.get(index) : null) : null;
    }

    /**
     * Set the list of {@link LoanedItem}s.
     *
     * @param loanedItems the list of {@link LoanedItem}s
     */
    public void setLoanedItems(final List<LoanedItem> loanedItems) {
        this.loanedItems = loanedItems;
    }

    public void setLoanedItem(final int index, final LoanedItem loanedItem) {
        loanedItems.set(index, loanedItem);
    }

    /**
     * Retrieve the list of {@link RequestedItemsCount}s.
     *
     * @return the list of requestedItemsCounts
     */
    public List<RequestedItemsCount> getRequestedItemsCounts() {
        return requestedItemsCounts;
    }

    public RequestedItemsCount getRequestedItemsCount(final int index) {
        return requestedItemsCounts != null ? (requestedItemsCounts.size() > 0 ? requestedItemsCounts.get(index) : null) : null;
    }

    /**
     * Set the list of {@link RequestedItemsCount}s.
     *
     * @param requestedItemsCounts the list of {@link RequestedItemsCount}s
     */
    public void setRequestedItemsCounts(final List<RequestedItemsCount> requestedItemsCounts) {
        this.requestedItemsCounts = requestedItemsCounts;
    }

    public void setRequestedItemsCount(final int index, final RequestedItemsCount requestedItemsCount) {
        requestedItemsCounts.set(index, requestedItemsCount);
    }

    /**
     * Retrieve the list of {@link RequestedItem}s.
     *
     * @return the list of requestedItems
     */
    public List<RequestedItem> getRequestedItems() {
        return requestedItems;
    }

    public RequestedItem getRequestedItem(final int index) {
        return requestedItems != null ? (requestedItems.size() > 0 ? requestedItems.get(index) : null) : null;
    }

    /**
     * Set the list of {@link RequestedItem}s.
     *
     * @param requestedItems the list of {@link RequestedItem}s
     */
    public void setRequestedItems(final List<RequestedItem> requestedItems) {
        this.requestedItems = requestedItems;
    }

    public void setRequestedItem(final int index, final RequestedItem requestedItem) {
        requestedItems.set(index, requestedItem);
    }

    /**
     * Retrieve the descriptive information about the user
     *
     * @return the userOptionalFields
     */
    public UserOptionalFields getUserOptionalFields() {
        return userOptionalFields;
    }

    /**
     * Set the UserOptionalFields.
     *
     * @param userOptionalFields the {@link UserOptionalFields}
     */
    public void setUserOptionalFields(final UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

    public UserFiscalAccountSummary getUserFiscalAccountSummary() {
        return userFiscalAccountSummary;
    }

    public void setUserFiscalAccountSummary(final UserFiscalAccountSummary userFiscalAccountSummary) {
        this.userFiscalAccountSummary = userFiscalAccountSummary;
    }

    public List<SubsequentElementControl> getSubsequentElementControls() {
        return subsequentElementControls;
    }

    public SubsequentElementControl getSubsequentElementControl(final int index) {
        return subsequentElementControls != null ? (subsequentElementControls.size() > 0 ? subsequentElementControls.get(index) : null) : null;
    }

    public void setSubsequentElementControls(final List<SubsequentElementControl> subsequentElementControls) {
        this.subsequentElementControls = subsequentElementControls;
    }

    public void setSubsequentElementControl(final int index, final SubsequentElementControl subsequentElementControl) {
        subsequentElementControls.set(index, subsequentElementControl);
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
        final LookupUserResponseData rhs = (LookupUserResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems).append(userId, rhs.userId)
            .append(userFiscalAccounts, rhs.userFiscalAccounts).append(loanedItemsCounts, rhs.loanedItemsCounts).append(loanedItems, rhs.loanedItems)
            .append(requestedItemsCounts, rhs.requestedItemsCounts).append(requestedItems, rhs.requestedItems).append(userOptionalFields, rhs.userOptionalFields)
            .append(userFiscalAccountSummary, rhs.userFiscalAccountSummary).append(subsequentElementControls, rhs.subsequentElementControls).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(607878689, 399114309).append(responseHeader).append(problems).append(userId).append(userFiscalAccounts)
            .append(loanedItemsCounts).append(loanedItems).append(requestedItemsCounts).append(requestedItems).append(userOptionalFields).append(userFiscalAccountSummary)
            .append(subsequentElementControls).toHashCode();
        return result;
    }
}
