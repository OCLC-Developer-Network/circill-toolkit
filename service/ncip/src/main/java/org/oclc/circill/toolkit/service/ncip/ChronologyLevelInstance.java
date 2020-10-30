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
 * held by an Agency to a whole Item, expressed in chronological terms.
 */
public class ChronologyLevelInstance {
    protected String chronologyCaption;
    protected BigDecimal chronologyLevel;
    protected String chronologyValue;

    public String getChronologyCaption() {
        return chronologyCaption;
    }

    public void setChronologyCaption(final String chronologyCaption) {
        this.chronologyCaption = chronologyCaption;
    }

    public BigDecimal getChronologyLevel() {
        return chronologyLevel;
    }

    public void setChronologyLevel(final BigDecimal chronologyLevel) {
        this.chronologyLevel = chronologyLevel;
    }

    public String getChronologyValue() {
        return chronologyValue;
    }

    public void setChronologyValue(final String chronologyValue) {
        this.chronologyValue = chronologyValue;
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
        final ChronologyLevelInstance rhs = (ChronologyLevelInstance) obj;
        return new EqualsBuilder().append(chronologyCaption, rhs.chronologyCaption).append(chronologyLevel, rhs.chronologyLevel).append(chronologyValue, rhs.chronologyValue)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(391297093, 1175582677).append(chronologyCaption).append(chronologyLevel).append(chronologyValue).toHashCode();
        return result;
    }
}
