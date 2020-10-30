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

public class SummaryHoldingsInformation {

    protected List<StructuredHoldingsData> structuredHoldingsDatas = new ArrayList<>();

    protected String unstructuredHoldingsData;

    public List<StructuredHoldingsData> getStructuredHoldingsDatas() {
        return structuredHoldingsDatas;
    }

    public StructuredHoldingsData getStructuredHoldingsData() {
        return structuredHoldingsDatas != null ? (structuredHoldingsDatas.size() > 0 ? structuredHoldingsDatas.get(structuredHoldingsDatas.size() - 1) : null) : null;
    }
    public StructuredHoldingsData getStructuredHoldingsData(final int index) {
        return structuredHoldingsDatas != null ? (structuredHoldingsDatas.size() > 0 ? structuredHoldingsDatas.get(index) : null) : null;
    }

    public void setStructuredHoldingsDatas(final List<StructuredHoldingsData> structuredHoldingsDatas) {
        this.structuredHoldingsDatas = structuredHoldingsDatas;
    }

    public void setStructuredHoldingsData(final int index, final StructuredHoldingsData structuredHoldingsDatas) {
        this.structuredHoldingsDatas.set(index, structuredHoldingsDatas);
    }

    /**
     * Set the list of {@link StructuredHoldingsData}s to this structuredHoldingsDatas.
     *
     * @param structuredHoldingsDatas the {@link StructuredHoldingsData}
     */
    public void setStructuredHoldingsData(final StructuredHoldingsData structuredHoldingsDatas) {
        if (this.structuredHoldingsDatas != null) {
            this.structuredHoldingsDatas.clear();
        }
        if (structuredHoldingsDatas != null) {
            if (this.structuredHoldingsDatas == null) {
                this.structuredHoldingsDatas = new ArrayList<>();
            }
            this.structuredHoldingsDatas.add(structuredHoldingsDatas);
        } else {
            this.structuredHoldingsDatas = null;
        }
    }

    public String getUnstructuredHoldingsData() {
        return unstructuredHoldingsData;
    }

    public void setUnstructuredHoldingsData(final String unstructuredHoldingsData) {
        this.unstructuredHoldingsData = unstructuredHoldingsData;
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
        final SummaryHoldingsInformation rhs = (SummaryHoldingsInformation) obj;
        return new EqualsBuilder().append(structuredHoldingsDatas, rhs.structuredHoldingsDatas).append(unstructuredHoldingsData, rhs.unstructuredHoldingsData).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(113904473, 1544410473).append(structuredHoldingsDatas).append(unstructuredHoldingsData).toHashCode();
        return result;
    }
}
