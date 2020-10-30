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

/**
 * This class represents a location's name. In NCIP a location name is a hierarchy of {@link LocationNameInstance}s.
 */
public class LocationName {
    /**
     * A sequence of Location Name Instances, which together express the location
     * where an Item is housed at a particular point in time
     */
    protected List<LocationNameInstance> locationNameInstances = new ArrayList<>();

    /**
     * Set the list of {@link LocationNameInstance}s for this location.
     *
     * @param locationNameInstances the list of LocationNameInstances
     */
    public void setLocationNameInstances(final List<LocationNameInstance> locationNameInstances) {
        this.locationNameInstances = locationNameInstances;
    }

    /**
     * Get the list of {@link LocationNameInstance}s for this location.
     *
     * @return the list of LocationNameInstances
     */
    public List<LocationNameInstance> getLocationNameInstances() {
        return locationNameInstances;
    }

    public LocationNameInstance getLocationNameInstance(final int index) {
        return locationNameInstances != null ? (locationNameInstances.size() > 0 ? locationNameInstances.get(index) : null) : null;
    }

    public void setLocationNameInstance(final int index, final LocationNameInstance locationNameInstance) {
        locationNameInstances.set(index, locationNameInstance);
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
        final LocationName rhs = (LocationName) obj;
        return new EqualsBuilder().append(locationNameInstances, rhs.locationNameInstances).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(714266185, 1808718639).append(locationNameInstances).toHashCode();
        return result;
    }
}
