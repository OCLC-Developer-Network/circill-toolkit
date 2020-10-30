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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the LookupItem service.
 */
public class LookupItemInitiationData implements NCIPInitiationData {

    /**
     * Initiation Header
     */
    protected InitiationHeader initiationHeader;
    /**
     * ItemID
     */
    protected ItemId itemId;
    /**
     * RequestID
     */
    protected RequestId requestId;
    /**
     * Flag indicating whether the current borrower's information is desired.
     */
    protected boolean currentBorrowerDesired;
    /**
     * Flag indicating whether the current requesters' information is desired.
     */
    protected boolean currentRequestersDesired;

    /**
     * Retrieve the initiation header.
     *
     * @return the initiation header
     */
    @Override
    public InitiationHeader getInitiationHeader() {
        return initiationHeader;
    }

    /**
     * Set the initiation header
     *
     * @param initiationHeader the InitiationHeader
     */
    @Override
    public void setInitiationHeader(final InitiationHeader initiationHeader) {
        this.initiationHeader = initiationHeader;
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
     * Retrieve the item id
     *
     * @return the itemId
     */
    public ItemId getItemId() {
        return itemId;
    }

    /**
     * Set the item id
     *
     * @param itemId the {@link ItemId}
     */
    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    /**
     * Retrieve the request id
     *
     * @return the requestId
     */
    public RequestId getRequestId() {
        return requestId;
    }

    /**
     * Set the request id
     *
     * @param requestId the requestId
     */
    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    public boolean getCurrentBorrowerDesired() {
        return currentBorrowerDesired;
    }

    public void setCurrentBorrowerDesired(final boolean currentBorrowerDesired) {
        this.currentBorrowerDesired = currentBorrowerDesired;
    }

    public boolean getCurrentRequestersDesired() {
        return currentRequestersDesired;
    }

    public void setCurrentRequestersDesired(final boolean currentRequestersDesired) {
        this.currentRequestersDesired = currentRequestersDesired;
    }

    /**
     * Whether the bibliographicDescription is desired in the response.
     */
    protected boolean bibliographicDescriptionDesired;
    /**
     * Whether the circulationStatus is desired in the response.
     */
    protected boolean circulationStatusDesired;
    /**
     * Whether the electronicResource is desired in the response.
     */
    protected boolean electronicResourceDesired;
    /**
     * Whether the holdQueueLength is desired in the response.
     */
    protected boolean holdQueueLengthDesired;
    /**
     * Whether the itemDescription is desired in the response.
     */
    protected boolean itemDescriptionDesired;
    /**
     * Whether the itemUseRestrictionType is desired in the response.
     */
    protected boolean itemUseRestrictionTypeDesired;
    /**
     * Whether the location is desired in the response.
     */
    protected boolean locationDesired;
    /**
     * Whether the physicalCondition is desired in the response.
     */
    protected boolean physicalConditionDesired;
    /**
     * Whether the securityMarker is desired in the response.
     */
    protected boolean securityMarkerDesired;
    /**
     * Whether the sensitizationFlag is desired in the response.
     */
    protected boolean sensitizationFlagDesired;

    /**
     * Whether the BibliographicDescription is desired in the response.
     *
     * @return the BibliographicDescriptionDesired
     */
    public boolean getBibliographicDescriptionDesired() {
        return bibliographicDescriptionDesired;
    }

    /**
     * Set whether the BibliographicDescription is desired in the response.
     *
     * @param bibliographicDescriptionDesired
     *         the BibliographicDescriptionDesired
     */
    public void setBibliographicDescriptionDesired(final boolean bibliographicDescriptionDesired) {
        this.bibliographicDescriptionDesired = bibliographicDescriptionDesired;
    }

    /**
     * Whether the CirculationStatus is desired in the response.
     *
     * @return the CirculationStatusDesired
     */
    public boolean getCirculationStatusDesired() {
        return circulationStatusDesired;
    }

    /**
     * Set whether the CirculationStatus is desired in the response.
     *
     * @param circulationStatusDesired the CirculationStatusDesired
     */
    public void setCirculationStatusDesired(final boolean circulationStatusDesired) {
        this.circulationStatusDesired = circulationStatusDesired;
    }

    /**
     * Whether the ElectronicResource is desired in the response.
     *
     * @return the ElectronicResourceDesired
     */
    public boolean getElectronicResourceDesired() {
        return electronicResourceDesired;
    }

    /**
     * Set whether the ElectronicResource is desired in the response.
     *
     * @param electronicResourceDesired the ElectronicResourceDesired
     */
    public void setElectronicResourceDesired(final boolean electronicResourceDesired) {
        this.electronicResourceDesired = electronicResourceDesired;
    }

    /**
     * Whether the HoldQueueLength is desired in the response.
     *
     * @return the HoldQueueLengthDesired
     */
    public boolean getHoldQueueLengthDesired() {
        return holdQueueLengthDesired;
    }

    /**
     * Set whether the HoldQueueLength is desired in the response.
     *
     * @param holdQueueLengthDesired the HoldQueueLengthDesired
     */
    public void setHoldQueueLengthDesired(final boolean holdQueueLengthDesired) {
        this.holdQueueLengthDesired = holdQueueLengthDesired;
    }

    /**
     * Whether the ItemDescription is desired in the response.
     *
     * @return the ItemDescriptionDesired
     */
    public boolean getItemDescriptionDesired() {
        return itemDescriptionDesired;
    }

    /**
     * Set whether the ItemDescription is desired in the response.
     *
     * @param itemDescriptionDesired the ItemDescriptionDesired
     */
    public void setItemDescriptionDesired(final boolean itemDescriptionDesired) {
        this.itemDescriptionDesired = itemDescriptionDesired;
    }

    /**
     * Whether the ItemUseRestrictionType is desired in the response.
     *
     * @return the ItemUseRestrictionTypeDesired
     */
    public boolean getItemUseRestrictionTypeDesired() {
        return itemUseRestrictionTypeDesired;
    }

    /**
     * Set whether the ItemUseRestrictionType is desired in the response.
     *
     * @param itemUseRestrictionTypeDesired the ItemUseRestrictionTypeDesired
     */
    public void setItemUseRestrictionTypeDesired(final boolean itemUseRestrictionTypeDesired) {
        this.itemUseRestrictionTypeDesired = itemUseRestrictionTypeDesired;
    }

    /**
     * Whether the Location is desired in the response.
     *
     * @return the LocationDesired
     */
    public boolean getLocationDesired() {
        return locationDesired;
    }

    /**
     * Set whether the Location is desired in the response.
     *
     * @param locationDesired the LocationDesired
     */
    public void setLocationDesired(final boolean locationDesired) {
        this.locationDesired = locationDesired;
    }

    /**
     * Whether the PhysicalCondition is desired in the response.
     *
     * @return the PhysicalConditionDesired
     */
    public boolean getPhysicalConditionDesired() {
        return physicalConditionDesired;
    }

    /**
     * Set whether the PhysicalCondition is desired in the response.
     *
     * @param physicalConditionDesired the PhysicalConditionDesired
     */
    public void setPhysicalConditionDesired(final boolean physicalConditionDesired) {
        this.physicalConditionDesired = physicalConditionDesired;
    }

    /**
     * Whether the SecurityMarker is desired in the response.
     *
     * @return the SecurityMarkerDesired
     */
    public boolean getSecurityMarkerDesired() {
        return securityMarkerDesired;
    }

    /**
     * Set whether the SecurityMarker is desired in the response.
     *
     * @param securityMarkerDesired the SecurityMarkerDesired
     */
    public void setSecurityMarkerDesired(final boolean securityMarkerDesired) {
        this.securityMarkerDesired = securityMarkerDesired;
    }

    /**
     * Whether the SensitizationFlag is desired in the response.
     *
     * @return the SensitizationFlagDesired
     */
    public boolean getSensitizationFlagDesired() {
        return sensitizationFlagDesired;
    }

    /**
     * Set whether the SensitizationFlag is desired in the response.
     *
     * @param sensitizationFlagDesired the SensitizationFlagDesired
     */
    public void setSensitizationFlagDesired(final boolean sensitizationFlagDesired) {
        this.sensitizationFlagDesired = sensitizationFlagDesired;
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
        final LookupItemInitiationData rhs = (LookupItemInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(itemId, rhs.itemId).append(requestId, rhs.requestId)
            .append(currentBorrowerDesired, rhs.currentBorrowerDesired).append(currentRequestersDesired, rhs.currentRequestersDesired).append(relyingPartyId, rhs.relyingPartyId)
            .append(bibliographicDescriptionDesired, rhs.bibliographicDescriptionDesired).append(circulationStatusDesired, rhs.circulationStatusDesired)
            .append(electronicResourceDesired, rhs.electronicResourceDesired).append(holdQueueLengthDesired, rhs.holdQueueLengthDesired)
            .append(itemDescriptionDesired, rhs.itemDescriptionDesired).append(itemUseRestrictionTypeDesired, rhs.itemUseRestrictionTypeDesired)
            .append(locationDesired, rhs.locationDesired).append(physicalConditionDesired, rhs.physicalConditionDesired).append(securityMarkerDesired, rhs.securityMarkerDesired)
            .append(sensitizationFlagDesired, rhs.sensitizationFlagDesired).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(151918227, 804567847).append(initiationHeader).append(itemId).append(requestId).append(currentBorrowerDesired)
            .append(currentRequestersDesired).append(relyingPartyId).append(bibliographicDescriptionDesired).append(circulationStatusDesired).append(electronicResourceDesired)
            .append(holdQueueLengthDesired).append(itemDescriptionDesired).append(itemUseRestrictionTypeDesired).append(locationDesired).append(physicalConditionDesired)
            .append(securityMarkerDesired).append(sensitizationFlagDesired).toHashCode();
        return result;
    }
}
