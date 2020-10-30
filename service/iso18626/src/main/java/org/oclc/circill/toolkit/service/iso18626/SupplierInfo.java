/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 * Modified by smithde on 2018-02-14
 */
public class SupplierInfo {

    protected Integer sortOrder;
    protected AgencyId supplierCode;
    protected String supplierDescription;
    protected BibliographicRecordId bibliographicRecordId;
    protected String callNumber;
    protected String summaryHoldings;
    protected String availabilityNote;

    public void setSortOrder(final Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getSortOrder() {
        return this.sortOrder;
    }

    public void setSupplierCode(final AgencyId supplierCode) {
        this.supplierCode = supplierCode;
    }

    public AgencyId getSupplierCode() {
        return this.supplierCode;
    }

    public void setSupplierDescription(final String supplierDescription) {
        this.supplierDescription = supplierDescription;
    }

    public String getSupplierDescription() {
        return supplierDescription;
    }

    public void setCallNumber(final String callNumber) {
        this.callNumber = callNumber;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setSummaryHoldings(final String summaryHoldings) {
        this.summaryHoldings = summaryHoldings;
    }

    public String getSummaryHoldings() {
        return summaryHoldings;
    }

    public void setAvailabilityNote(final String availabilityNote) {
        this.availabilityNote = availabilityNote;
    }

    public String getAvailabilityNote() {
        return availabilityNote;
    }

    public void setBibliographicRecordId(final BibliographicRecordId bibliographicRecordId) {
        this.bibliographicRecordId = bibliographicRecordId;
    }

    public BibliographicRecordId getBibliographicRecordId() {
        return bibliographicRecordId;
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
        final SupplierInfo rhs = (SupplierInfo) obj;
        final boolean result = new EqualsBuilder().append(sortOrder, rhs.sortOrder).append(supplierCode, rhs.supplierCode).append(supplierDescription, rhs.supplierDescription)
            .append(callNumber, rhs.callNumber).append(summaryHoldings, rhs.summaryHoldings).append(availabilityNote, rhs.availabilityNote)
            .append(bibliographicRecordId, rhs.bibliographicRecordId).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1050536563, 1361386271).append(sortOrder).append(supplierCode).append(supplierDescription).append(callNumber).append(summaryHoldings)
            .append(availabilityNote).append(bibliographicRecordId).toHashCode();
        return result;
    }

}
