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
 * The physical condition of an item.
 */
public class PhysicalCondition {
    /**
     * Details of the physical condition of an item, identified by Physical Condition Type
     */
    protected String physicalConditionDetails;
    /**
     * Specific details of any unusual physical conditions of an Item
     */
    protected PhysicalConditionType physicalConditionType;

    public String getPhysicalConditionDetails() {
        return physicalConditionDetails;
    }

    public void setPhysicalConditionDetails(final String physicalConditionDetails) {
        this.physicalConditionDetails = physicalConditionDetails;
    }

    public PhysicalConditionType getPhysicalConditionType() {
        return physicalConditionType;
    }

    public void setPhysicalConditionType(final PhysicalConditionType physicalConditionType) {
        this.physicalConditionType = physicalConditionType;
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
        final PhysicalCondition rhs = (PhysicalCondition) obj;
        return new EqualsBuilder().append(physicalConditionDetails, rhs.physicalConditionDetails).append(physicalConditionType, rhs.physicalConditionType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2049821665, 853076803).append(physicalConditionDetails).append(physicalConditionType).toHashCode();
        return result;
    }

}
