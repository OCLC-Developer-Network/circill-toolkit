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
 * AcceptItemResponseData contains the data that is in a NCIP Accept Item Response message.
 */
public class AcceptItemResponseData implements NCIPResponseData {

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

    public RequestId getRequestId() {
        return requestId;
    }

    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
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
     * Request Id
     */
    protected RequestId requestId;
    /**
     * ItemID
     */
    protected ItemId itemId;

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
        final AcceptItemResponseData rhs = (AcceptItemResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems).append(requestId, rhs.requestId)
            .append(itemId, rhs.itemId).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1687339833, 895637503).append(responseHeader).append(problems).append(requestId).append(itemId).toHashCode();
        return result;
    }
}
