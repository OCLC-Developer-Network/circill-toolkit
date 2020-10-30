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
 * Provides structured information that describes the hierarchical relationship of the specific part
 * held by an Agency to an entire bibliographic item, expressed in numerative terms.
 */
public class EnumerationLevelInstance {
    protected String enumerationCaption;
    protected BigDecimal enumerationLevel;
    protected String enumerationValue;

    public String getEnumerationCaption() {
        return enumerationCaption;
    }

    public void setEnumerationCaption(final String enumerationCaption) {
        this.enumerationCaption = enumerationCaption;
    }

    public BigDecimal getEnumerationLevel() {
        return enumerationLevel;
    }

    public void setEnumerationLevel(final BigDecimal enumerationLevel) {
        this.enumerationLevel = enumerationLevel;
    }

    public String getEnumerationValue() {
        return enumerationValue;
    }

    public void setEnumerationValue(final String enumerationValue) {
        this.enumerationValue = enumerationValue;
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
        final EnumerationLevelInstance rhs = (EnumerationLevelInstance) obj;
        return new EqualsBuilder().append(enumerationCaption, rhs.enumerationCaption).append(enumerationLevel, rhs.enumerationLevel).append(enumerationValue, rhs.enumerationValue)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1255745517, 1994663559).append(enumerationCaption).append(enumerationLevel).append(enumerationValue).toHashCode();
        return result;
    }
}
