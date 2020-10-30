/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the CreateItem service.
 */
public class CreateItemInitiationData implements NCIPInitiationData {

    /**
     * InitiationHeader
     */
    protected InitiationHeader initiationHeader;

    /**
     * Set InitiationHeader.
     */
    @Override
    public void setInitiationHeader(final InitiationHeader initiationHeader) {

        this.initiationHeader = initiationHeader;

    }

    /**
     * Get InitiationHeader.
     */
    @Override
    public InitiationHeader getInitiationHeader() {

        return initiationHeader;

    }

    /**
     * Relying Party Id
     */
    protected AgencyId relyingPartyId;

    /**
     * Get the RelyingPartyId.
     *
     * @return the RelyingPartyId
     */
    @Override
    public AgencyId getRelyingPartyId() {
        return relyingPartyId;
    }

    /**
     * Set the RelyingPartyId.
     *
     * @param relyingPartyId the RelyingPartyId
     */
    @Override
    public void setRelyingPartyId(final AgencyId relyingPartyId) {
        this.relyingPartyId = relyingPartyId;
    }

    /**
     * MandatedAction
     */
    protected MandatedAction mandatedAction;

    /**
     * Set MandatedAction.
     *
     * @param mandatedAction the {@link MandatedAction}
     */
    public void setMandatedAction(final MandatedAction mandatedAction) {

        this.mandatedAction = mandatedAction;

    }

    /**
     * Get MandatedAction.
     *
     * @return the {@link MandatedAction}
     */
    public MandatedAction getMandatedAction() {

        return mandatedAction;

    }

    /**
     * ItemId
     */
    protected ItemId itemId;

    /**
     * Set ItemId.
     * @param itemId the {@link ItemId}
     */
    public void setItemId(final ItemId itemId) {

        this.itemId = itemId;

    }

    /**
     * Get ItemId.
     *
     * @return the {@link ItemId}
     */
    public ItemId getItemId() {

        return itemId;

    }

    /**
     * RequestId
     */
    protected RequestId requestId;

    /**
     * Set RequestId.
     *
     * @param requestId the {@link RequestId}
     */
    public void setRequestId(final RequestId requestId) {

        this.requestId = requestId;

    }

    /**
     * Get RequestId.
     *
     * @return the {@link RequestId}
     */
    public RequestId getRequestId() {

        return requestId;

    }

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
     * CirculationStatus
     */
    protected CirculationStatus circulationStatus;

    /**
     * Set CirculationStatus.
     *
     * @param circulationStatus the {@link CirculationStatus}
     */
    public void setCirculationStatus(final CirculationStatus circulationStatus) {

        this.circulationStatus = circulationStatus;

    }

    /**
     * Get CirculationStatus.
     *
     * @return the {@link CirculationStatus}
     */
    public CirculationStatus getCirculationStatus() {

        return circulationStatus;

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
     * @return the item's sensitization flag
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
        final CreateItemInitiationData rhs = (CreateItemInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId)
            .append(mandatedAction, rhs.mandatedAction).append(itemId, rhs.itemId).append(requestId, rhs.requestId).append(bibliographicDescription, rhs.bibliographicDescription)
            .append(itemUseRestrictionTypes, rhs.itemUseRestrictionTypes).append(circulationStatus, rhs.circulationStatus).append(itemDescription, rhs.itemDescription)
            .append(locations, rhs.locations).append(physicalCondition, rhs.physicalCondition).append(securityMarker, rhs.securityMarker)
            .append(sensitizationFlag, rhs.sensitizationFlag).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(916459791, 642272759).append(initiationHeader).append(relyingPartyId).append(mandatedAction).append(itemId)
            .append(requestId).append(bibliographicDescription).append(itemUseRestrictionTypes).append(circulationStatus).append(itemDescription).append(locations)
            .append(physicalCondition).append(securityMarker).append(sensitizationFlag).toHashCode();
        return result;
    }
}
