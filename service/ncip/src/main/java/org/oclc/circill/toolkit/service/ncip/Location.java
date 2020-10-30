/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Describes the physical location of an item.
 */
public class Location {
    protected LocationName locationName;
    /**
     * Identifies the nature of the location where an Item is at a particular point in time
     */
    protected LocationType locationType;
    protected GregorianCalendar validFromDate;
    protected GregorianCalendar validToDate;

    public LocationName getLocationName() {
        return locationName;
    }

    public void setLocationName(final LocationName locationName) {
        this.locationName = locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(final LocationType locationType) {
        this.locationType = locationType;
    }

    public GregorianCalendar getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(final GregorianCalendar validFromDate) {
        this.validFromDate = validFromDate;
    }

    public GregorianCalendar getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(final GregorianCalendar validToDate) {
        this.validToDate = validToDate;
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
        final Location rhs = (Location) obj;
        return new EqualsBuilder().append(locationName, rhs.locationName).append(locationType, rhs.locationType).append(validFromDate, rhs.validFromDate)
            .append(validToDate, rhs.validToDate).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(714266185, 1808718639).append(locationName).append(locationType).append(validFromDate).append(validToDate).toHashCode();
        return result;
    }
}
