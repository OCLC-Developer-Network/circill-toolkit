/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Contains field defining how a responder should organize the response data.
 */
public class ResponseElementControl {

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(final ElementType elementType) {
        this.elementType = elementType;
    }

    public BigDecimal getStartElement() {
        return startElement;
    }

    public void setStartElement(final BigDecimal startElement) {
        this.startElement = startElement;
    }

    public BigDecimal getMaximumCount() {
        return maximumCount;
    }

    public void setMaximumCount(final BigDecimal maximumCount) {
        this.maximumCount = maximumCount;
    }

    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(final SortField sortField) {
        this.sortField = sortField;
    }

    public SortOrderType getSortOrderType() {
        return sortOrderType;
    }

    public void setSortOrderType(final SortOrderType sortOrderType) {
        this.sortOrderType = sortOrderType;
    }

    protected ElementType elementType;

    protected BigDecimal startElement;

    protected BigDecimal maximumCount;

    protected SortField sortField;

    protected SortOrderType sortOrderType;

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
        final ResponseElementControl rhs = (ResponseElementControl) obj;
        return new EqualsBuilder().append(elementType, rhs.elementType).append(startElement, rhs.startElement).append(maximumCount, rhs.maximumCount)
            .append(sortField, rhs.sortField).append(sortOrderType, rhs.sortOrderType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1021714959, 393090629).append(elementType).append(startElement).append(maximumCount).append(sortField).append(sortOrderType)
            .toHashCode();
        return result;
    }
}
