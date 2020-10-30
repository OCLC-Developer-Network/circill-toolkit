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

/**
 * Contains a Current Borrower, and/or one or more Current Requesters.
 */
public class ItemTransaction {
    protected CurrentBorrower currentBorrower;

    protected List<CurrentRequester> currentRequesters = new ArrayList<>();

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
        final ItemTransaction rhs = (ItemTransaction) obj;
        return new EqualsBuilder().append(currentBorrower, rhs.currentBorrower).append(currentRequesters, rhs.currentRequesters).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(803690305, 1066030279).append(currentBorrower).append(currentRequesters).toHashCode();
        return result;
    }
}
