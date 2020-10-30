/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class SupplierInfoBuilder {

    private Integer sortOrder;
    private AgencyId supplierCode;
    private String supplierDescription;
    private BibliographicRecordId bibliographicRecordId;
    private String callNumber;
    private String summaryHoldings;
    private String availabilityNote;

    /**
     * This utility class does not allow instances.
     */
    private SupplierInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link SupplierInfo}
     */
    public static SupplierInfoBuilder aSupplierInfo() {
        final SupplierInfoBuilder builder = new SupplierInfoBuilder();
        return builder;
    }

    public SupplierInfoBuilder withSortOrder(final Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public SupplierInfoBuilder withSupplierCode(final AgencyId supplierCode) {
        this.supplierCode = supplierCode;
        return this;
    }

    public SupplierInfoBuilder withSupplierDescription(final String supplierDescription) {
        this.supplierDescription = supplierDescription;
        return this;
    }

    public SupplierInfoBuilder withBibliographicRecordId(final BibliographicRecordId bibliographicRecordId) {
        this.bibliographicRecordId = bibliographicRecordId;
        return this;
    }

    public SupplierInfoBuilder withCallNumber(final String callNumber) {
        this.callNumber = callNumber;
        return this;
    }

    public SupplierInfoBuilder withSummaryHoldings(final String summaryHoldings) {
        this.summaryHoldings = summaryHoldings;
        return this;
    }

    public SupplierInfoBuilder withAvailabilityNote(final String availabilityNote) {
        this.availabilityNote = availabilityNote;
        return this;
    }

    public SupplierInfo build() {
        final SupplierInfo supplierInfo = new SupplierInfo();
        supplierInfo.setSortOrder(sortOrder);
        supplierInfo.setSupplierCode(supplierCode);
        supplierInfo.setSupplierDescription(supplierDescription);
        supplierInfo.setBibliographicRecordId(bibliographicRecordId);
        supplierInfo.setCallNumber(callNumber);
        supplierInfo.setSummaryHoldings(summaryHoldings);
        supplierInfo.setAvailabilityNote(availabilityNote);
        return supplierInfo;
    }

}

