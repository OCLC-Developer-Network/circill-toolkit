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
 * A entry in a hierarchically-ordered list of Location Name Instances
 * which together describe the location of an item.
 */
public class LocationNameInstance {
    public BigDecimal getLocationNameLevel() {
        return locationNameLevel;
    }

    public void setLocationNameLevel(final BigDecimal locationNameLevel) {
        this.locationNameLevel = locationNameLevel;
    }

    public String getLocationNameValue() {
        return locationNameValue;
    }

    public void setLocationNameValue(final String locationNameValue) {
        this.locationNameValue = locationNameValue;
    }

    /**
     * The level of the Location Name Instance in a sequence within Location Name
     */
    protected BigDecimal locationNameLevel;
    /**
     * The name of an Agency-specific location or sub-location where an Item is housed at a particular point in time
     */
    protected String locationNameValue;

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
        final LocationNameInstance rhs = (LocationNameInstance) obj;
        return new EqualsBuilder().append(locationNameLevel, rhs.locationNameLevel).append(locationNameValue, rhs.locationNameValue).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1361049211, 1681433403).append(locationNameLevel).append(locationNameValue).toHashCode();
        return result;
    }

}
