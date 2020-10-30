/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
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

public class SubsequentElementControl {

    protected ElementType elementType;

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(final ElementType elementType) {
        this.elementType = elementType;
    }

    public BigDecimal getNextElement() {
        return nextElement;
    }

    public void setNextElement(final BigDecimal nextElement) {
        this.nextElement = nextElement;
    }

    protected BigDecimal nextElement;

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
        final SubsequentElementControl rhs = (SubsequentElementControl) obj;
        return new EqualsBuilder().append(elementType, rhs.elementType).append(nextElement, rhs.nextElement).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(954256967, 1189551691).append(elementType).append(nextElement).toHashCode();
        return result;
    }
}
