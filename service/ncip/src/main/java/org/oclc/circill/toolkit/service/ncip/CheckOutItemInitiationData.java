/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ServiceHelper;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the CheckOutItem service.
 */
public class CheckOutItemInitiationData implements NCIPInitiationData {

    /**
     * Initiation Header
     */
    protected InitiationHeader initiationHeader;
    /**
     * Mandated Action
     */
    protected MandatedAction mandatedAction;
    /**
     * User Id
     */
    protected UserId userId;
    /**
     * Authentication Input
     */
    protected List<AuthenticationInput> authenticationInputs = new ArrayList<>();
    /**
     * ItemID
     */
    protected ItemId itemId;
    /**
     * RequestID
     */
    protected RequestId requestId;
    /**
     * Acknowledged Fee Amount
     */
    protected AcknowledgedFeeAmount acknowledgedFeeAmount;
    /**
     * Paid Fee Amount
     */
    protected PaidFeeAmount paidFeeAmount;
    /**
     * Item Use Restriction Types
     */
    protected List<ItemUseRestrictionType> acknowledgedItemUseRestrictionTypes = new ArrayList<>();
    /**
     * Shipping Information
     */
    protected ShippingInformation shippingInformation;
    /**
     * Whether the (electronic) resource should be returned in the response message.
     */
    protected Boolean resourceDesired;
    /**
     * Date Due
     */
    protected GregorianCalendar desiredDateDue;

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

    /**
     * Get the mandated action
     *
     * @return the mandated action
     */
    public MandatedAction getMandatedAction() {
        return mandatedAction;
    }

    /**
     * Set the MandatedAction.
     *
     * @param mandatedAction the MandatedAction.
     */
    public void setMandatedAction(final MandatedAction mandatedAction) {
        this.mandatedAction = mandatedAction;
    }

    /**
     * Get the user id
     *
     * @return the user id
     */
    public UserId getUserId() {
        return userId;
    }

    /**
     * Set the UserId.
     *
     * @param userId the UserId.
     */
    public void setUserId(final UserId userId) {
        this.userId = userId;
    }

    /**
     * Get the  authentication inputs
     *
     * @return the  authentication inputs
     */
    public List<AuthenticationInput> getAuthenticationInputs() {
        return authenticationInputs;
    }

    public AuthenticationInput getAuthenticationInput() {
        return authenticationInputs != null ? (authenticationInputs.size() > 0 ? authenticationInputs.get(authenticationInputs.size() - 1) : null) : null;
    }

    /**
     * Get the authentication input at the provided index
     *
     * @param index the index
     * @return the authentication input at the provided index
     */
    public AuthenticationInput getAuthenticationInput(final int index) {
        return authenticationInputs != null ? (authenticationInputs.size() > 0 ? authenticationInputs.get(index) : null) : null;
    }

    /**
     * Set the AuthenticationInputs.
     *
     * @param authenticationInputs the list of {@link AuthenticationInput}s
     */
    public void setAuthenticationInputs(final List<AuthenticationInput> authenticationInputs) {
        this.authenticationInputs = authenticationInputs;
    }

    public void setAuthenticationInput(final AuthenticationInput authenticationInput) {
        this.authenticationInputs = ServiceHelper.setList(authenticationInputs, authenticationInput);
    }

    public void setAuthenticationInput(final int index, final AuthenticationInput authenticationInput) {
        authenticationInputs.set(index, authenticationInput);
    }

    /**
     * Get the acknowledged fee amount
     *
     * @return the acknowledged fee amount
     */
    public AcknowledgedFeeAmount getAcknowledgedFeeAmount() {
        return acknowledgedFeeAmount;
    }

    /**
     * Set the AcknowledgedFeeAmount.
     *
     * @param acknowledgedFeeAmount the AcknowledgedFeeAmount.
     */
    public void setAcknowledgedFeeAmount(final AcknowledgedFeeAmount acknowledgedFeeAmount) {
        this.acknowledgedFeeAmount = acknowledgedFeeAmount;
    }

    /**
     * Get the paid fee amount
     *
     * @return the paid fee amount
     */
    public PaidFeeAmount getPaidFeeAmount() {
        return paidFeeAmount;
    }

    /**
     * Set the PaidFeeAmount.
     *
     * @param paidFeeAmount the PaidFeeAmount.
     */
    public void setPaidFeeAmount(final PaidFeeAmount paidFeeAmount) {
        this.paidFeeAmount = paidFeeAmount;
    }

    /**
     * Get the acknowledged item use restriction types
     *
     * @return the acknowledged item use restriction types
     */
    public List<ItemUseRestrictionType> getAcknowledgedItemUseRestrictionTypes() {
        return acknowledgedItemUseRestrictionTypes;
    }

    public ItemUseRestrictionType getAcknowledgedItemUseRestrictionType() {
        return acknowledgedItemUseRestrictionTypes != null ? (acknowledgedItemUseRestrictionTypes.size() > 0 ? acknowledgedItemUseRestrictionTypes
            .get(acknowledgedItemUseRestrictionTypes.size() - 1) : null) : null;
    }

    /**
     * Get the acknowledged item use restriction type at the provided index
     *
     * @param index the index
     * @return the acknowledged item use restriction type at the provided index
     */
    public ItemUseRestrictionType getAcknowledgedItemUseRestrictionType(final int index) {
        return acknowledgedItemUseRestrictionTypes != null ? (acknowledgedItemUseRestrictionTypes.size() > 0 ? acknowledgedItemUseRestrictionTypes.get(index) : null) : null;
    }

    /**
     * Set the AcknowledgedItemUseRestrictionTypes.
     *
     * @param acknowledgedItemUseRestrictionTypes
     *         list of acknowledged item use restriction types
     */
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

    /**
     * Get the shipping information
     *
     * @return the shipping information
     */
    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    /**
     * Set the ShippingInformation.
     *
     * @param shippingInformation the ShippingInformation.
     */
    public void setShippingInformation(final ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    /**
     * Get whether the (electronic) resource should be returned in the response.
     *
     * @return whether the (electronic) resource should be returned in the response
     */
    public Boolean getResourceDesired() {
        return resourceDesired;
    }

    /**
     * Set the ResourceDesired.
     *
     * @param resourceDesired the ResourceDesired.
     */
    public void setResourceDesired(final Boolean resourceDesired) {
        this.resourceDesired = resourceDesired;
    }

    /**
     * Get the desired due date
     *
     * @return the desired due date
     */
    public GregorianCalendar getDesiredDateDue() {
        return desiredDateDue;
    }

    /**
     * Set the DesiredDateDue.
     *
     * @param desiredDateDue the DesiredDateDue.
     */
    public void setDesiredDateDue(final GregorianCalendar desiredDateDue) {
        this.desiredDateDue = desiredDateDue;
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
        final CheckOutItemInitiationData rhs = (CheckOutItemInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(mandatedAction, rhs.mandatedAction).append(userId, rhs.userId)
            .append(authenticationInputs, rhs.authenticationInputs).append(itemId, rhs.itemId).append(requestId, rhs.requestId)
            .append(acknowledgedFeeAmount, rhs.acknowledgedFeeAmount).append(paidFeeAmount, rhs.paidFeeAmount)
            .append(acknowledgedItemUseRestrictionTypes, rhs.acknowledgedItemUseRestrictionTypes).append(shippingInformation, rhs.shippingInformation)
            .append(resourceDesired, rhs.resourceDesired).append(desiredDateDue, rhs.desiredDateDue).append(relyingPartyId, rhs.relyingPartyId)
            .append(bibliographicDescriptionDesired, rhs.bibliographicDescriptionDesired).append(circulationStatusDesired, rhs.circulationStatusDesired)
            .append(electronicResourceDesired, rhs.electronicResourceDesired).append(holdQueueLengthDesired, rhs.holdQueueLengthDesired)
            .append(itemDescriptionDesired, rhs.itemDescriptionDesired).append(itemUseRestrictionTypeDesired, rhs.itemUseRestrictionTypeDesired)
            .append(locationDesired, rhs.locationDesired).append(physicalConditionDesired, rhs.physicalConditionDesired).append(securityMarkerDesired, rhs.securityMarkerDesired)
            .append(sensitizationFlagDesired, rhs.sensitizationFlagDesired).append(authenticationInputDesired, rhs.authenticationInputDesired)
            .append(blockOrTrapDesired, rhs.blockOrTrapDesired).append(dateOfBirthDesired, rhs.dateOfBirthDesired).append(nameInformationDesired, rhs.nameInformationDesired)
            .append(userAddressInformationDesired, rhs.userAddressInformationDesired).append(userLanguageDesired, rhs.userLanguageDesired)
            .append(userPrivilegeDesired, rhs.userPrivilegeDesired).append(userIdDesired, rhs.userIdDesired).append(previousUserIdDesired, rhs.previousUserIdDesired).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(539979803, 1636084381).append(initiationHeader).append(mandatedAction).append(userId).append(authenticationInputs)
            .append(itemId).append(requestId).append(acknowledgedFeeAmount).append(paidFeeAmount).append(acknowledgedItemUseRestrictionTypes).append(shippingInformation)
            .append(resourceDesired).append(desiredDateDue).append(relyingPartyId).append(bibliographicDescriptionDesired).append(circulationStatusDesired)
            .append(electronicResourceDesired).append(holdQueueLengthDesired).append(itemDescriptionDesired).append(itemUseRestrictionTypeDesired).append(locationDesired)
            .append(physicalConditionDesired).append(securityMarkerDesired).append(sensitizationFlagDesired).append(authenticationInputDesired).append(blockOrTrapDesired)
            .append(dateOfBirthDesired).append(nameInformationDesired).append(userAddressInformationDesired).append(userLanguageDesired).append(userPrivilegeDesired)
            .append(userIdDesired).append(previousUserIdDesired).toHashCode();
        return result;
    }
}
