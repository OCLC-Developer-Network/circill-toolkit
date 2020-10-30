/*
 * Copyright (c) 2015 eXtensible Catalog Organization.
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
 * Describes a UserLimit, e.g. maximum # of loaned items.
 */
public class UserLimit {

    protected LimitType limitType;
    protected BigDecimal limitValue;

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(final LimitType limitType) {
        this.limitType = limitType;
    }

    public BigDecimal getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(final BigDecimal limitValue) {
        this.limitValue = limitValue;
    }

    /*
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
        final UserLimit rhs = (UserLimit) obj;
        return new EqualsBuilder().append(limitType, rhs.limitType).append(limitValue, rhs.limitValue).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(114870505, 71508505).append(limitType).append(limitValue).toHashCode();
        return result;
    }
}
