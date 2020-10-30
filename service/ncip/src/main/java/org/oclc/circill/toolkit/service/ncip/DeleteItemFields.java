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
 * Carries data elements describing the DeleteItemFields.
 */
public class DeleteItemFields {

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
     * @param itemUseRestrictionTypes the list of {@link ItemUseRestrictionType}s
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
     * @param locations the list of {@link Location}s
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
     * @param sensitizationFlag whether the sensitization flag is set
     */
    public void setSensitizationFlag(final Boolean sensitizationFlag) {

        this.sensitizationFlag = sensitizationFlag;

    }

    /**
     * Get SensitizationFlag.
     *
     * @return whether the sensitization flag is set
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
        final DeleteItemFields rhs = (DeleteItemFields) obj;
        return new EqualsBuilder().append(bibliographicDescription, rhs.bibliographicDescription).append(itemUseRestrictionTypes, rhs.itemUseRestrictionTypes)
            .append(itemDescription, rhs.itemDescription).append(locations, rhs.locations).append(physicalCondition, rhs.physicalCondition)
            .append(securityMarker, rhs.securityMarker).append(sensitizationFlag, rhs.sensitizationFlag).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(144811125, 1788434775).append(bibliographicDescription).append(itemUseRestrictionTypes).append(itemDescription).append(locations)
            .append(physicalCondition).append(securityMarker).append(sensitizationFlag).toHashCode();
        return result;
    }
}
