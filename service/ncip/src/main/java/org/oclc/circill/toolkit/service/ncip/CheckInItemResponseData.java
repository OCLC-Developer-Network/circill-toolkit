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

public class CheckInItemResponseData implements NCIPResponseData {

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(final ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    @Override
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

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(final UserId userId) {
        this.userId = userId;
    }

    public RoutingInformation getRoutingInformation() {
        return routingInformation;
    }

    public void setRoutingInformation(final RoutingInformation routingInformation) {
        this.routingInformation = routingInformation;
    }

    public FiscalTransactionInformation getFiscalTransactionInformation() {
        return fiscalTransactionInformation;
    }

    public void setFiscalTransactionInformation(final FiscalTransactionInformation fiscalTransactionInformation) {
        this.fiscalTransactionInformation = fiscalTransactionInformation;
    }

    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public UserOptionalFields getUserOptionalFields() {
        return userOptionalFields;
    }

    public void setUserOptionalFields(final UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

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
     * User Id
     */
    protected UserId userId;
    /**
     * Routing Information
     */
    protected RoutingInformation routingInformation;
    /**
     * Fiscal Transaction Information
     */
    protected FiscalTransactionInformation fiscalTransactionInformation;
    /**
     * Item Optional Fields
     */
    protected ItemOptionalFields itemOptionalFields;
    /**
     * User Optional Fields
     */
    protected UserOptionalFields userOptionalFields;

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
        final CheckInItemResponseData rhs = (CheckInItemResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems).append(itemId, rhs.itemId)
            .append(userId, rhs.userId).append(routingInformation, rhs.routingInformation).append(fiscalTransactionInformation, rhs.fiscalTransactionInformation)
            .append(itemOptionalFields, rhs.itemOptionalFields).append(userOptionalFields, rhs.userOptionalFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(539979803, 1636084381).append(responseHeader).append(problems).append(itemId).append(userId).append(routingInformation)
            .append(fiscalTransactionInformation).append(itemOptionalFields).append(userOptionalFields).toHashCode();
        return result;
    }
}
