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

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the RequestItem service.
 */
public class RequestItemInitiationData implements NCIPInitiationData {

    /**
     * Initiation Header
     */
    protected InitiationHeader initiationHeader;
    /**
     * Authentication input
     */
    protected List<AuthenticationInput> authenticationInputs = new ArrayList<>();
    /**
     * UserID
     */
    protected List<UserId> userIds = new ArrayList<>();
    /**
     * Request scope type
     */
    protected RequestScopeType requestScopeType;
    /**
     * Request type
     */
    protected RequestType requestType;
    /**
     * Bibliographic id
     */
    protected List<BibliographicId> bibliographicIds = new ArrayList<>();
    /**
     * Item id
     */
    protected List<ItemId> itemIds = new ArrayList<>();
    /**
     * Bibliographic Description
     */
    protected BibliographicDescription bibliographicDescription;
    /**
     * Acknowledged Fee Amount
     */
    protected AcknowledgedFeeAmount acknowledgedFeeAmount;
    /**
     * Acknowledged Item Use Restriction Type
     */
    protected List<ItemUseRestrictionType> acknowledgedItemUseRestrictionTypes = new ArrayList<>();
    /**
     * Earliest Date Needed
     */
    protected GregorianCalendar earliestDateNeeded;
    /**
     * Item Optional Fields
     */
    protected ItemOptionalFields itemOptionalFields;
    /**
     * Mandated Action
     */
    protected MandatedAction mandatedAction;
    /**
     * Need Before Date
     */
    protected GregorianCalendar needBeforeDate;
    /**
     * Pickup Expiry Date
     */
    protected GregorianCalendar pickupExpiryDate;
    /**
     * Pickup Location
     */
    protected PickupLocation pickupLocation;
    /**
     * Paid Fee Amount
     */
    protected PaidFeeAmount paidFeeAmount;
    /**
     * Shipping Information
     */
    protected ShippingInformation shippingInformation;
    /**
     * Request Id
     */
    protected RequestId requestId;

    protected GregorianCalendar pickupDate;

    protected GregorianCalendar suspensionStartDate;

    protected GregorianCalendar suspensionEndDate;

    protected UserOptionalFields userOptionalFields;

    protected String userNote;

    /** The maximum fee that the patron is willing to pay for the requested item. */
    protected MaxFeeAmount maxFeeAmount;

    protected EditionSubstitutionType editionSubstitutionType;

    protected String desiredEdition;

    /** ItemElementTypes */
    protected List<ItemElementType> itemElementTypes;

    /** UserElementTypes */
    protected List<UserElementType> userElementTypes;

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

    public List<AuthenticationInput> getAuthenticationInputs() {
        return authenticationInputs;
    }

    public AuthenticationInput getAuthenticationInput() {
        return authenticationInputs != null ? (authenticationInputs.size() > 0 ? authenticationInputs.get(authenticationInputs.size() - 1) : null) : null;
    }

    public AuthenticationInput getAuthenticationInput(final int index) {
        return authenticationInputs != null ? (authenticationInputs.size() > 0 ? authenticationInputs.get(index) : null) : null;
    }

    public void setAuthenticationInputs(final List<AuthenticationInput> authenticationInputs) {
        this.authenticationInputs = authenticationInputs;
    }

    public void setAuthenticationInput(final AuthenticationInput authenticationInput) {
        if (this.authenticationInputs != null) {
            this.authenticationInputs.clear();
        }
        if (authenticationInput != null) {
            if (this.authenticationInputs == null) {
                this.authenticationInputs = new ArrayList<>();
            }
            this.authenticationInputs.add(authenticationInput);
        } else {
            this.authenticationInputs = null;
        }
    }

    public void setAuthenticationInput(final int index, final AuthenticationInput authenticationInput) {
        authenticationInputs.set(index, authenticationInput);
    }

    public UserId getUserId() {
        final UserId result;
        if (userIds != null) {
            if (userIds.size() > 0) {
                final int index = userIds.size() - 1;
                result = userIds.get(index);
            } else {
                result = null;
            }
        } else {
            result = null;
        }
        return result;
    }

    public UserId getUserId(final int index) {
        return userIds != null ? (userIds.size() > 0 ? userIds.get(index) : null) : null;
    }

    /**
     * Get the list of UserIds
     * @return the list of UserIds
     */
    public List<UserId> getUserIds() {

        return userIds;

    }

    public void setUserId(final UserId userId) {
        if (this.userIds != null) {
            this.userIds.clear();
        }
        if (userId != null) {
            if (this.userIds == null) {
                this.userIds = new ArrayList<>();
            }
            this.userIds.add(userId);
        } else {
            this.userIds = null;
        }
    }

    /**
     * Set the list of UserIds.
     * @param userIds the list of UserIds
     */
    public void setUserIds(final List<UserId> userIds) {
        this.userIds = userIds;
    }

    public void setUserId(final int index, final UserId userId) {
        userIds.set(index, userId);
    }

    public RequestScopeType getRequestScopeType() {
        return requestScopeType;
    }

    public void setRequestScopeType(final RequestScopeType requestScopeType) {
        this.requestScopeType = requestScopeType;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(final RequestType requestType) {
        this.requestType = requestType;
    }

    public BibliographicId getBibliographicId() {
        return bibliographicIds != null ? (bibliographicIds.size() > 0 ? bibliographicIds.get(bibliographicIds.size() - 1) : null) : null;
    }

    public List<BibliographicId> getBibliographicIds() {
        return bibliographicIds;
    }

    public BibliographicId getBibliographicId(final int index) {
        return bibliographicIds != null ? (bibliographicIds.size() > 0 ? bibliographicIds.get(index) : null) : null;
    }

    public void setBibliographicIds(final List<BibliographicId> bibliographicIds) {
        this.bibliographicIds = bibliographicIds;
    }

    public void setBibliographicId(final BibliographicId bibliographicId) {
        if (this.bibliographicIds != null) {
            this.bibliographicIds.clear();
        }
        if (bibliographicId != null) {
            if (this.bibliographicIds == null) {
                this.bibliographicIds = new ArrayList<>();
            }
            this.bibliographicIds.add(bibliographicId);
        } else {
            this.bibliographicIds = null;
        }
    }

    public void setBibliographicId(final int index, final BibliographicId bibliographicId) {
        bibliographicIds.set(index, bibliographicId);
    }

    public List<ItemId> getItemIds() {
        return itemIds;
    }

    public ItemId getItemId() {
        return itemIds != null ? (itemIds.size() > 0 ? itemIds.get(itemIds.size() - 1) : null) : null;
    }

    public ItemId getItemId(final int index) {
        return itemIds != null ? (itemIds.size() > 0 ? itemIds.get(index) : null) : null;
    }

    public void setItemIds(final List<ItemId> itemIds) {
        this.itemIds = itemIds;
    }

    public void setItemId(final ItemId itemId) {
        if (this.itemIds != null) {
            this.itemIds.clear();
        }
        if (itemId != null) {
            if (this.itemIds == null) {
                this.itemIds = new ArrayList<>();
            }
            this.itemIds.add(itemId);
        } else {
            this.itemIds = null;
        }
    }

    public void setItemId(final int index, final ItemId itemId) {
        itemIds.set(index, itemId);
    }

    public BibliographicDescription getBibliographicDescription() {
        return bibliographicDescription;
    }

    public void setBibliographicDescription(final BibliographicDescription bibliographicDescription) {
        this.bibliographicDescription = bibliographicDescription;
    }

    public AcknowledgedFeeAmount getAcknowledgedFeeAmount() {
        return acknowledgedFeeAmount;
    }

    public void setAcknowledgedFeeAmount(final AcknowledgedFeeAmount acknowledgedFeeAmount) {
        this.acknowledgedFeeAmount = acknowledgedFeeAmount;
    }

    public List<ItemUseRestrictionType> getAcknowledgedItemUseRestrictionTypes() {
        return acknowledgedItemUseRestrictionTypes;
    }

    public ItemUseRestrictionType getAcknowledgedItemUseRestrictionType() {
        return acknowledgedItemUseRestrictionTypes != null ? (acknowledgedItemUseRestrictionTypes.size() > 0 ? acknowledgedItemUseRestrictionTypes
            .get(acknowledgedItemUseRestrictionTypes.size() - 1) : null) : null;
    }

    public ItemUseRestrictionType getAcknowledgedItemUseRestrictionType(final int index) {
        return acknowledgedItemUseRestrictionTypes != null ? (acknowledgedItemUseRestrictionTypes.size() > 0 ? acknowledgedItemUseRestrictionTypes.get(index) : null) : null;
    }

    public void setAcknowledgedItemUseRestrictionTypes(final List<ItemUseRestrictionType> acknowledgedItemUseRestrictionTypes) {
        this.acknowledgedItemUseRestrictionTypes = acknowledgedItemUseRestrictionTypes;
    }

    public void setAcknowledgedItemUseRestrictionType(final ItemUseRestrictionType acknowledgedItemUseRestrictionType) {
        if (this.acknowledgedItemUseRestrictionTypes != null) {
            this.acknowledgedItemUseRestrictionTypes.clear();
        }
        if (acknowledgedItemUseRestrictionType != null) {
            if (this.acknowledgedItemUseRestrictionTypes == null) {
                this.acknowledgedItemUseRestrictionTypes = new ArrayList<>();
            }
            this.acknowledgedItemUseRestrictionTypes.add(acknowledgedItemUseRestrictionType);
        } else {
            this.acknowledgedItemUseRestrictionTypes = null;
        }
    }

    public void setAcknowledgedItemUseRestrictionType(final int index, final ItemUseRestrictionType acknowledgedItemUseRestrictionType) {
        acknowledgedItemUseRestrictionTypes.set(index, acknowledgedItemUseRestrictionType);
    }

    public GregorianCalendar getEarliestDateNeeded() {
        return earliestDateNeeded;
    }

    public void setEarliestDateNeeded(final GregorianCalendar earliestDateNeeded) {
        this.earliestDateNeeded = earliestDateNeeded;
    }

    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public MandatedAction getMandatedAction() {
        return mandatedAction;
    }

    public void setMandatedAction(final MandatedAction mandatedAction) {
        this.mandatedAction = mandatedAction;
    }

    public GregorianCalendar getNeedBeforeDate() {
        return needBeforeDate;
    }

    public void setNeedBeforeDate(final GregorianCalendar needBeforeDate) {
        this.needBeforeDate = needBeforeDate;
    }

    public GregorianCalendar getPickupExpiryDate() {
        return pickupExpiryDate;
    }

    public void setPickupExpiryDate(final GregorianCalendar pickupExpiryDate) {
        this.pickupExpiryDate = pickupExpiryDate;
    }

    public PickupLocation getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(final PickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public PaidFeeAmount getPaidFeeAmount() {
        return paidFeeAmount;
    }

    public void setPaidFeeAmount(final PaidFeeAmount paidFeeAmount) {
        this.paidFeeAmount = paidFeeAmount;
    }

    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(final ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public RequestId getRequestId() {
        return requestId;
    }

    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    public GregorianCalendar getSuspensionStartDate() {
        return suspensionStartDate;
    }

    public void setSuspensionStartDate(final GregorianCalendar suspensionStartDate) {
        this.suspensionStartDate = suspensionStartDate;
    }

    public GregorianCalendar getSuspensionEndDate() {
        return suspensionEndDate;
    }

    public void setSuspensionEndDate(final GregorianCalendar suspensionEndDate) {
        this.suspensionEndDate = suspensionEndDate;
    }

    public GregorianCalendar getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(final GregorianCalendar pickupDate) {
        this.pickupDate = pickupDate;
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
     * Whether the authenticationInput is desired in the response.
     */
    protected boolean authenticationInputDesired;
    /**
     * Whether the blockOrTrap is desired in the response.
     */
    protected boolean blockOrTrapDesired;
    /**
     * Whether the dateOfBirth is desired in the response.
     */
    protected boolean dateOfBirthDesired;
    /**
     * Whether the nameInformation is desired in the response.
     */
    protected boolean nameInformationDesired;
    /**
     * Whether the userAddressInformation is desired in the response.
     */
    protected boolean userAddressInformationDesired;
    /**
     * Whether the userLanguage is desired in the response.
     */
    protected boolean userLanguageDesired;
    /**
     * Whether the userPrivilege is desired in the response.
     */
    protected boolean userPrivilegeDesired;
    /**
     * Whether the userId is desired in the response.
     */
    protected boolean userIdDesired;
    /**
     * Whether the previousUserId is desired in the response.
     */
    protected boolean previousUserIdDesired;

    /**
     * Get the AuthenticationInput is desired in the response.
     *
     * @return the AuthenticationInputDesired
     */
    public boolean getAuthenticationInputDesired() {
        return authenticationInputDesired;
    }

    /**
     * Set whether the AuthenticationInput is desired in the response.
     *
     * @param authenticationInputDesired the AuthenticationInputDesired
     */
    public void setAuthenticationInputDesired(final boolean authenticationInputDesired) {
        this.authenticationInputDesired = authenticationInputDesired;
    }

    /**
     * Get the BlockOrTrap is desired in the response.
     *
     * @return the BlockOrTrapDesired
     */
    public boolean getBlockOrTrapDesired() {
        return blockOrTrapDesired;
    }

    /**
     * Set whether the BlockOrTrap is desired in the response.
     *
     * @param blockOrTrapDesired the BlockOrTrapDesired
     */
    public void setBlockOrTrapDesired(final boolean blockOrTrapDesired) {
        this.blockOrTrapDesired = blockOrTrapDesired;
    }

    /**
     * Get the DateOfBirth is desired in the response.
     *
     * @return the DateOfBirthDesired
     */
    public boolean getDateOfBirthDesired() {
        return dateOfBirthDesired;
    }

    /**
     * Set whether the DateOfBirth is desired in the response.
     *
     * @param dateOfBirthDesired the DateOfBirthDesired
     */
    public void setDateOfBirthDesired(final boolean dateOfBirthDesired) {
        this.dateOfBirthDesired = dateOfBirthDesired;
    }

    /**
     * Get the NameInformation is desired in the response.
     *
     * @return the NameInformationDesired
     */
    public boolean getNameInformationDesired() {
        return nameInformationDesired;
    }

    /**
     * Set whether the NameInformation is desired in the response.
     *
     * @param nameInformationDesired the NameInformationDesired
     */
    public void setNameInformationDesired(final boolean nameInformationDesired) {
        this.nameInformationDesired = nameInformationDesired;
    }

    /**
     * Get the UserAddressInformation is desired in the response.
     *
     * @return the UserAddressInformationDesired
     */
    public boolean getUserAddressInformationDesired() {
        return userAddressInformationDesired;
    }

    /**
     * Set whether the UserAddressInformation is desired in the response.
     *
     * @param userAddressInformationDesired the UserAddressInformationDesired
     */
    public void setUserAddressInformationDesired(final boolean userAddressInformationDesired) {
        this.userAddressInformationDesired = userAddressInformationDesired;
    }

    /**
     * Get the UserLanguage is desired in the response.
     *
     * @return the UserLanguageDesired
     */
    public boolean getUserLanguageDesired() {
        return userLanguageDesired;
    }

    /**
     * Set whether the UserLanguage is desired in the response.
     *
     * @param userLanguageDesired the UserLanguageDesired
     */
    public void setUserLanguageDesired(final boolean userLanguageDesired) {
        this.userLanguageDesired = userLanguageDesired;
    }

    /**
     * Get the UserPrivilege is desired in the response.
     *
     * @return the UserPrivilegeDesired
     */
    public boolean getUserPrivilegeDesired() {
        return userPrivilegeDesired;
    }

    /**
     * Set whether the UserPrivilege is desired in the response.
     *
     * @param userPrivilegeDesired the UserPrivilegeDesired
     */
    public void setUserPrivilegeDesired(final boolean userPrivilegeDesired) {
        this.userPrivilegeDesired = userPrivilegeDesired;
    }

    /**
     * Get the UserId is desired in the response.
     *
     * @return the UserIdDesired
     */
    public boolean getUserIdDesired() {
        return userIdDesired;
    }

    /**
     * Set whether the UserId is desired in the response.
     *
     * @param userIdDesired the UserIdDesired
     */
    public void setUserIdDesired(final boolean userIdDesired) {
        this.userIdDesired = userIdDesired;
    }

    /**
     * Get the PreviousUserId is desired in the response.
     *
     * @return the PreviousUserIdDesired
     */
    public boolean getPreviousUserIdDesired() {
        return previousUserIdDesired;
    }

    /**
     * Set whether the PreviousUserId is desired in the response.
     *
     * @param previousUserIdDesired the PreviousUserIdDesired
     */
    public void setPreviousUserIdDesired(final boolean previousUserIdDesired) {
        this.previousUserIdDesired = previousUserIdDesired;
    }

    public UserOptionalFields getUserOptionalFields() {
        return userOptionalFields;
    }

    public void setUserOptionalFields(final UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(final String userNote) {
        this.userNote = userNote;
    }

    public MaxFeeAmount getMaxFeeAmount() {
        return maxFeeAmount;
    }

    public void setMaxFeeAmount(final MaxFeeAmount maxFeeAmount) {
        this.maxFeeAmount = maxFeeAmount;
    }

    public EditionSubstitutionType getEditionSubstitutionType() {
        return editionSubstitutionType;
    }

    public void setEditionSubstitutionType(final EditionSubstitutionType editionSubstitutionType) {
        this.editionSubstitutionType = editionSubstitutionType;
    }

    public String getDesiredEdition() {
        return desiredEdition;
    }

    public void setDesiredEdition(final String desiredEdition) {
        this.desiredEdition = desiredEdition;
    }

    /**
     * Set ItemElementTypes.
     *
      * @param itemElementTypes the list of {@link ItemElementType}s
     */
    public void setItemElementTypes(final List<ItemElementType> itemElementTypes) {
        this.itemElementTypes = itemElementTypes;
    }

    /**
     * Get ItemElementTypes.
     *
     * @return the list of {@link ItemElementType}s
     */
    public List<ItemElementType> getItemElementTypes() {
        return itemElementTypes;
    }

    /**
     * Set UserElementTypes.
     *
     * @param userElementTypes the list of {@link ItemElementType}s
     */
    public void setUserElementTypes(final List<UserElementType> userElementTypes) {
        this.userElementTypes = userElementTypes;
    }

    /** Get UserElementTypes.
     *
     * @return the list of {@link UserElementType}s
     */
    public List<UserElementType> getUserElementTypes() {
        return userElementTypes;
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
        final RequestItemInitiationData rhs = (RequestItemInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(authenticationInputs, rhs.authenticationInputs)
            .append(userIds, rhs.userIds).append(requestScopeType, rhs.requestScopeType).append(requestType, rhs.requestType).append(bibliographicIds, rhs.bibliographicIds)
            .append(itemIds, rhs.itemIds).append(bibliographicDescription, rhs.bibliographicDescription).append(acknowledgedFeeAmount, rhs.acknowledgedFeeAmount)
            .append(acknowledgedItemUseRestrictionTypes, rhs.acknowledgedItemUseRestrictionTypes).append(earliestDateNeeded, rhs.earliestDateNeeded)
            .append(itemOptionalFields, rhs.itemOptionalFields).append(mandatedAction, rhs.mandatedAction).append(needBeforeDate, rhs.needBeforeDate)
            .append(pickupExpiryDate, rhs.pickupExpiryDate).append(pickupLocation, rhs.pickupLocation).append(paidFeeAmount, rhs.paidFeeAmount)
            .append(shippingInformation, rhs.shippingInformation).append(requestId, rhs.requestId).append(pickupDate, rhs.pickupDate)
            .append(suspensionStartDate, rhs.suspensionStartDate).append(suspensionEndDate, rhs.suspensionEndDate).append(userOptionalFields, rhs.userOptionalFields)
            .append(userNote, rhs.userNote).append(maxFeeAmount, rhs.maxFeeAmount).append(editionSubstitutionType, rhs.editionSubstitutionType)
            .append(desiredEdition, rhs.desiredEdition).append(relyingPartyId, rhs.relyingPartyId).append(bibliographicDescriptionDesired, rhs.bibliographicDescriptionDesired)
            .append(circulationStatusDesired, rhs.circulationStatusDesired).append(electronicResourceDesired, rhs.electronicResourceDesired)
            .append(holdQueueLengthDesired, rhs.holdQueueLengthDesired).append(itemDescriptionDesired, rhs.itemDescriptionDesired)
            .append(itemUseRestrictionTypeDesired, rhs.itemUseRestrictionTypeDesired).append(locationDesired, rhs.locationDesired)
            .append(physicalConditionDesired, rhs.physicalConditionDesired).append(securityMarkerDesired, rhs.securityMarkerDesired)
            .append(sensitizationFlagDesired, rhs.sensitizationFlagDesired).append(authenticationInputDesired, rhs.authenticationInputDesired)
            .append(blockOrTrapDesired, rhs.blockOrTrapDesired).append(dateOfBirthDesired, rhs.dateOfBirthDesired).append(nameInformationDesired, rhs.nameInformationDesired)
            .append(userAddressInformationDesired, rhs.userAddressInformationDesired).append(userLanguageDesired, rhs.userLanguageDesired)
            .append(userPrivilegeDesired, rhs.userPrivilegeDesired).append(userIdDesired, rhs.userIdDesired).append(previousUserIdDesired, rhs.previousUserIdDesired)
            .append(itemElementTypes, rhs.itemElementTypes).append(userElementTypes, rhs.userElementTypes).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(21246821, 1156381965).append(initiationHeader).append(authenticationInputs).append(userIds).append(requestScopeType)
            .append(requestType).append(bibliographicIds).append(itemIds).append(bibliographicDescription).append(acknowledgedFeeAmount).append(acknowledgedItemUseRestrictionTypes)
            .append(earliestDateNeeded).append(itemOptionalFields).append(mandatedAction).append(needBeforeDate).append(pickupExpiryDate).append(pickupLocation)
            .append(paidFeeAmount).append(shippingInformation).append(requestId).append(pickupDate).append(suspensionStartDate).append(suspensionEndDate).append(userOptionalFields)
            .append(userNote).append(maxFeeAmount).append(editionSubstitutionType).append(desiredEdition).append(relyingPartyId).append(bibliographicDescriptionDesired)
            .append(circulationStatusDesired).append(electronicResourceDesired).append(holdQueueLengthDesired).append(itemDescriptionDesired).append(itemUseRestrictionTypeDesired)
            .append(locationDesired).append(physicalConditionDesired).append(securityMarkerDesired).append(sensitizationFlagDesired).append(authenticationInputDesired)
            .append(blockOrTrapDesired).append(dateOfBirthDesired).append(nameInformationDesired).append(userAddressInformationDesired).append(userLanguageDesired)
            .append(userPrivilegeDesired).append(userIdDesired).append(previousUserIdDesired).append(itemElementTypes).append(userElementTypes).toHashCode();
        return result;
    }
}
