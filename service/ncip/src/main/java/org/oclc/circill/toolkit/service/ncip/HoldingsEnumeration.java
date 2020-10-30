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
 * A sequence of Enumeration Level Instances, which together express a numeric or
 * alphabetic designation of a specific part of a bibliographic
 * item and show the relationship of that Item to the whole bibliographic item.
 */
public class HoldingsEnumeration {
    protected List<EnumerationLevelInstance> enumerationLevelInstances = new ArrayList<>();

    public List<EnumerationLevelInstance> getEnumerationLevelInstances() {
        return enumerationLevelInstances;
    }

    public EnumerationLevelInstance getEnumerationLevelInstance(final int index) {
        return enumerationLevelInstances != null ? (enumerationLevelInstances.size() > 0 ? enumerationLevelInstances.get(index) : null) : null;
    }

    public void setEnumerationLevelInstances(final List<EnumerationLevelInstance> enumerationLevelInstances) {
        this.enumerationLevelInstances = enumerationLevelInstances;
    }

    public void setEnumerationLevelInstance(final int index, final EnumerationLevelInstance enumerationLevelInstance) {
        enumerationLevelInstances.set(index, enumerationLevelInstance);
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
        final HoldingsEnumeration rhs = (HoldingsEnumeration) obj;
        return new EqualsBuilder().append(enumerationLevelInstances, rhs.enumerationLevelInstances).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(817955299, 1320306035).append(enumerationLevelInstances).toHashCode();
        return result;
    }
}
