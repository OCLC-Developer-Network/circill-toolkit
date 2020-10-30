/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the Item Object.
 */
public class ItemOptionalFields {
    protected ItemDescription itemDescription;
    protected BibliographicDescription bibliographicDescription;
    protected CirculationStatus circulationStatus;
    protected ElectronicResource electronicResource;
    protected BigDecimal holdQueueLength;
    protected List<ItemUseRestrictionType> itemUseRestrictionTypes = new ArrayList<>();
    protected List<Location> locations = new ArrayList<>();
    protected PhysicalCondition physicalCondition;
    protected SecurityMarker securityMarker;
    protected Boolean sensitizationFlag = false;

    public ItemDescription getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(final ItemDescription itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BibliographicDescription getBibliographicDescription() {
        return bibliographicDescription;
    }

    public void setBibliographicDescription(final BibliographicDescription bibliographicDescription) {
        this.bibliographicDescription = bibliographicDescription;
    }

    public CirculationStatus getCirculationStatus() {
        return circulationStatus;
    }

    public void setCirculationStatus(final CirculationStatus circulationStatus) {
        this.circulationStatus = circulationStatus;
    }

    public ElectronicResource getElectronicResource() {
        return electronicResource;
    }

    public void setElectronicResource(final ElectronicResource electronicResource) {
        this.electronicResource = electronicResource;
    }

    public BigDecimal getHoldQueueLength() {
        return holdQueueLength;
    }

    public void setHoldQueueLength(final BigDecimal holdQueueLength) {
        this.holdQueueLength = holdQueueLength;
    }

    public List<ItemUseRestrictionType> getItemUseRestrictionTypes() {
        return itemUseRestrictionTypes;
    }

    public ItemUseRestrictionType getItemUseRestrictionType(final int index) {
        return itemUseRestrictionTypes != null ? (itemUseRestrictionTypes.size() > 0 ? itemUseRestrictionTypes.get(index) : null) : null;
    }

    public void setItemUseRestrictionTypes(final List<ItemUseRestrictionType> itemUseRestrictionTypes) {
        this.itemUseRestrictionTypes = itemUseRestrictionTypes;
    }

    public void setItemUseRestrictionType(final int index, final ItemUseRestrictionType itemUseRestrictionType) {
        itemUseRestrictionTypes.set(index, itemUseRestrictionType);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location getLocation(final int index) {
        return locations != null ? (locations.size() > 0 ? locations.get(index) : null) : null;
    }

    public void setLocations(final List<Location> locations) {
        this.locations = locations;
    }

    public void setLocation(final int index, final Location location) {
        locations.set(index, location);
    }

    public PhysicalCondition getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(final PhysicalCondition physicalCondition) {
        this.physicalCondition = physicalCondition;
    }

    public SecurityMarker getSecurityMarker() {
        return securityMarker;
    }

    public void setSecurityMarker(final SecurityMarker securityMarker) {
        this.securityMarker = securityMarker;
    }

    public boolean getSensitizationFlag() {
        return sensitizationFlag;
    }

    public void setSensitizationFlag(final boolean sensitizationFlag) {
        this.sensitizationFlag = sensitizationFlag;
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
        final ItemOptionalFields rhs = (ItemOptionalFields) obj;
        return new EqualsBuilder().append(itemDescription, rhs.itemDescription).append(bibliographicDescription, rhs.bibliographicDescription)
            .append(circulationStatus, rhs.circulationStatus).append(electronicResource, rhs.electronicResource).append(holdQueueLength, rhs.holdQueueLength)
            .append(itemUseRestrictionTypes, rhs.itemUseRestrictionTypes).append(locations, rhs.locations).append(physicalCondition, rhs.physicalCondition)
            .append(securityMarker, rhs.securityMarker).append(sensitizationFlag, rhs.sensitizationFlag).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1872074689, 721326467).append(itemDescription).append(bibliographicDescription).append(circulationStatus).append(electronicResource)
            .append(holdQueueLength).append(itemUseRestrictionTypes).append(locations).append(physicalCondition).append(securityMarker).append(sensitizationFlag).toHashCode();
        return result;
    }
}
