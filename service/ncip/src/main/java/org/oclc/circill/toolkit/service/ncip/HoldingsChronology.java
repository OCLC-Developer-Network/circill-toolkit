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
 * A sequence of Chronology Level Instances, which together express a time period
 * covered by the Item as a specific part of a bibliographic item and shows the relationship
 * of that Item to the entire bibliographic item.
 */
public class HoldingsChronology {
    protected List<ChronologyLevelInstance> chronologyLevelInstances = new ArrayList<>();

    public List<ChronologyLevelInstance> getChronologyLevelInstances() {
        return chronologyLevelInstances;
    }

    public ChronologyLevelInstance getChronologyLevelInstance(final int index) {
        return chronologyLevelInstances != null ? (chronologyLevelInstances.size() > 0 ? chronologyLevelInstances.get(index) : null) : null;
    }

    public void setChronologyLevelInstances(final List<ChronologyLevelInstance> chronologyLevelInstances) {
        this.chronologyLevelInstances = chronologyLevelInstances;
    }

    public void setChronologyLevelInstance(final int index, final ChronologyLevelInstance chronologyLevelInstance) {
        chronologyLevelInstances.set(index, chronologyLevelInstance);
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
        final HoldingsChronology rhs = (HoldingsChronology) obj;
        return new EqualsBuilder().append(chronologyLevelInstances, rhs.chronologyLevelInstances).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(817955299, 1320306035).append(chronologyLevelInstances).toHashCode();
        return result;
    }
}
