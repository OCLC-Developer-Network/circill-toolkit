/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Identifies a user that have requested the Item.
 */
public class CurrentRequester {
    protected UserId userId;

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(final UserId userId) {
        this.userId = userId;
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
        final CurrentRequester rhs = (CurrentRequester) obj;
        return new EqualsBuilder().append(userId, rhs.userId).isEquals();
    }

    public int hashCode() {
        final int result = new HashCodeBuilder(479723011, 552027395).append(userId).toHashCode();
        return result;
    }
}
