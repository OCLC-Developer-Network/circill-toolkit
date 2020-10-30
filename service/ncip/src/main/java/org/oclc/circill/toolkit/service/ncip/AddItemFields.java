/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the AddItemFields.
 */
public class AddItemFields {

    /**
     * BibliographicDescription
     */
    protected BibliographicDescription bibliographicDescription;

    /**
     * Set BibliographicDescription.
     *
     * @param bibliographicDescription the {@link BibliographicDescription}
     */
    public void setBibliographicDescription(final BibliographicDescription bibliographicDescription) {

        this.bibliographicDescription = bibliographicDescription;

    }

    /**
     * Get BibliographicDescription.
     *
     * @return the {@link BibliographicDescription}
     */
    public BibliographicDescription getBibliographicDescription() {

        return bibliographicDescription;

    }

    /**
     * ItemUseRestrictionTypes
     */
    protected List<ItemUseRestrictionType> itemUseRestrictionTypes;

    /**
     * Set ItemUseRestrictionTypes.
     *
     * @param itemUseRestrictionTypes the list of {@link ItemUseRestrictionType}
     */
    public void setItemUseRestrictionTypes(final List<ItemUseRestrictionType> itemUseRestrictionTypes) {

        this.itemUseRestrictionTypes = itemUseRestrictionTypes;

    }

    /**
     * Get ItemUseRestrictionTypes.
     *
     * @return a list of {@link ItemUseRestrictionType}s
     */
    public List<ItemUseRestrictionType> getItemUseRestrictionTypes() {

        return itemUseRestrictionTypes;

    }

    /**
     * ItemDescription
     */
    protected ItemDescription itemDescription;

    /**
     * Set ItemDescription.
     *
     * @param itemDescription the {@link ItemDescription}
     */
    public void setItemDescription(final ItemDescription itemDescription) {

        this.itemDescription = itemDescription;

    }

    /**
     * Get ItemDescription.
     *
     * @return the {@link ItemDescription}
     */
    public ItemDescription getItemDescription() {

        return itemDescription;

    }

    /**
     * Locations
     */
    protected List<Location> locations;

    /**
     * Set Locations.
     *
     * @param locations the list of {@link Location}
     */
    public void setLocations(final List<Location> locations) {

        this.locations = locations;

    }

    /**
     * Get Locations.
     *
     * @return a list of {@link Location}s
     */
    public List<Location> getLocations() {

        return locations;

    }

    /**
     * PhysicalCondition
     */
    protected PhysicalCondition physicalCondition;

    /**
     * Set PhysicalCondition.
     *
     * @param physicalCondition the {@link PhysicalCondition}
     */
    public void setPhysicalCondition(final PhysicalCondition physicalCondition) {

        this.physicalCondition = physicalCondition;

    }

    /**
     * Get PhysicalCondition.
     *
     * @return the {@link PhysicalCondition}
     */
    public PhysicalCondition getPhysicalCondition() {

        return physicalCondition;

    }

    /**
     * SecurityMarker
     */
    protected SecurityMarker securityMarker;

    /**
     * Set SecurityMarker.
     *
     * @param securityMarker the {@link SecurityMarker}
     */
    public void setSecurityMarker(final SecurityMarker securityMarker) {

        this.securityMarker = securityMarker;

    }

    /**
     * Get SecurityMarker.
     *
     * @return the {@link SecurityMarker}
     */
    public SecurityMarker getSecurityMarker() {

        return securityMarker;

    }

    /**
     * SensitizationFlag
     */
    protected Boolean sensitizationFlag;

    /**
     * Set SensitizationFlag.
     *
     * @param sensitizationFlag the sensitization flag
     */
    public void setSensitizationFlag(final Boolean sensitizationFlag) {

        this.sensitizationFlag = sensitizationFlag;

    }

    /**
     * Get SensitizationFlag.
     *
     * @return the {@link Boolean}
     */
    public Boolean getSensitizationFlag() {

        return sensitizationFlag;

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
        final AddItemFields rhs = (AddItemFields) obj;
        return new EqualsBuilder().append(bibliographicDescription, rhs.bibliographicDescription).append(itemUseRestrictionTypes, rhs.itemUseRestrictionTypes)
            .append(itemDescription, rhs.itemDescription).append(locations, rhs.locations).append(physicalCondition, rhs.physicalCondition)
            .append(securityMarker, rhs.securityMarker).append(sensitizationFlag, rhs.sensitizationFlag).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(2096828627, 1766099961).append(bibliographicDescription).append(itemUseRestrictionTypes).append(itemDescription).append(locations)
            .append(physicalCondition).append(securityMarker).append(sensitizationFlag).toHashCode();
    }
}

