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

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the AcceptItem service.
 */
public class AcceptItemInitiationData implements NCIPInitiationData {

    /**
     * Initiation Header
     */
    protected InitiationHeader initiationHeader;

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
     * Mandated Action
     */
    protected MandatedAction mandatedAction;
    /**
     * ItemID
     */
    protected ItemId itemId;
    /**
     * Request Id
     */
    protected RequestId requestId;
    /**
     * Requested Action Type
     */
    protected RequestedActionType requestedActionType;

    /**
     * Get the InitiationHeader.
     *
     * @return the InitiationHeader
     */
    @Override
    public InitiationHeader getInitiationHeader() {
        return initiationHeader;
    }

    /**
     * Set the InitiationHeader.
     *
     * @param initiationHeader the InitiationHeader
     */
    @Override
    public void setInitiationHeader(final InitiationHeader initiationHeader) {
        this.initiationHeader = initiationHeader;
    }

    /**
     * Get the MandatedAction.
     *
     * @return the MandatedAction
     */
    public MandatedAction getMandatedAction() {
        return mandatedAction;
    }

    /**
     * Set the MandatedAction.
     *
     * @param mandatedAction the MandatedAction
     */
    public void setMandatedAction(final MandatedAction mandatedAction) {
        this.mandatedAction = mandatedAction;
    }

    /**
     * Get the ItemId.
     *
     * @return the ItemId
     */
    public ItemId getItemId() {
        return itemId;
    }

    /**
     * Set the ItemId.
     *
     * @param itemId the {@link ItemId}
     */
    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    /**
     * Get the RequestId.
     *
     * @return the RequestId
     */
    public RequestId getRequestId() {
        return requestId;
    }

    /**
     * Set the RequestId.
     *
     * @param requestId the RequestId
     */
    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    /**
     * Get the RequestedActionType.
     *
     * @return the RequestedActionType
     */
    public RequestedActionType getRequestedActionType() {
        return requestedActionType;
    }

    /**
     * Set the RequestedActionType.
     *
     * @param requestedActionType the RequestedActionType
     */
    public void setRequestedActionType(final RequestedActionType requestedActionType) {
        this.requestedActionType = requestedActionType;
    }

    /**
     * Get the UserId.
     *
     * @return the UserId
     */
    public UserId getUserId() {
        return userId;
    }

    /**
     * Set the UserId.
     *
     * @param userId the UserId
     */
    public void setUserId(final UserId userId) {
        this.userId = userId;
    }

    /**
     * Get the GregorianCalendar.
     *
     * @return the GregorianCalendar
     */
    public GregorianCalendar getDateForReturn() {
        return dateForReturn;
    }

    /**
     * Set the DateForReturn.
     *
     * @param dateForReturn the DateForReturn
     */
    public void setDateForReturn(final GregorianCalendar dateForReturn) {
        this.dateForReturn = dateForReturn;
    }

    /**
     * Get the Boolean.
     *
     * @return the Boolean
     */
    public Boolean getIndeterminateLoanPeriodFlag() {
        return indeterminateLoanPeriodFlag;
    }

    /**
     * Set the IndeterminateLoanPeriodFlag.
     *
     * @param indeterminateLoanPeriodFlag the IndeterminateLoanPeriodFlag
     */
    public void setIndeterminateLoanPeriodFlag(final Boolean indeterminateLoanPeriodFlag) {
        this.indeterminateLoanPeriodFlag = indeterminateLoanPeriodFlag;
    }

    /**
     * Get the Boolean.
     *
     * @return the Boolean
     */
    public Boolean getNonReturnableFlag() {
        return nonReturnableFlag;
    }

    /**
     * Set the NonReturnableFlag.
     *
     * @param nonReturnableFlag the NonReturnableFlag
     */
    public void setNonReturnableFlag(final Boolean nonReturnableFlag) {
        this.nonReturnableFlag = nonReturnableFlag;
    }

    /**
     * Get the Boolean.
     *
     * @return the Boolean
     */
    public Boolean getRenewalNotPermitted() {
        return renewalNotPermitted;
    }

    /**
     * Set the RenewalNotPermitted.
     *
     * @param renewalNotPermitted the RenewalNotPermitted
     */
    public void setRenewalNotPermitted(final Boolean renewalNotPermitted) {
        this.renewalNotPermitted = renewalNotPermitted;
    }

    /**
     * Get the FiscalTransactionInformation.
     *
     * @return the FiscalTransactionInformation
     */
    public FiscalTransactionInformation getFiscalTransactionInformation() {
        return fiscalTransactionInformation;
    }

    /**
     * Set the FiscalTransactionInformation.
     *
     * @param fiscalTransactionInformation the FiscalTransactionInformation
     */
    public void setFiscalTransactionInformation(final FiscalTransactionInformation fiscalTransactionInformation) {
        this.fiscalTransactionInformation = fiscalTransactionInformation;
    }

    /**
     * Get the ItemOptionalFields.
     *
     * @return the ItemOptionalFields
     */
    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    /**
     * Set the ItemOptionalFields.
     *
     * @param itemOptionalFields the ItemOptionalFields
     */
    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    /**
     * Get the UserOptionalFields.
     *
     * @return the UserOptionalFields
     */
    public UserOptionalFields getUserOptionalFields() {
        return userOptionalFields;
    }

    /**
     * Set the UserOptionalFields.
     *
     * @param userOptionalFields the {@link UserOptionalFields}
     */
    public void setUserOptionalFields(final UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
    }

    /**
     * Get the PickupLocation.
     *
     * @return the PickupLocation
     */
    public PickupLocation getPickupLocation() {
        return pickupLocation;
    }

    /**
     * Set the PickupLocation.
     *
     * @param pickupLocation the PickupLocation
     */
    public void setPickupLocation(final PickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    /**
     * Get the GregorianCalendar.
     *
     * @return the GregorianCalendar
     */
    public GregorianCalendar getPickupExpiryDate() {
        return pickupExpiryDate;
    }

    /**
     * Set the PickupExpiryDate.
     *
     * @param pickupExpiryDate the PickupExpiryDate
     */
    public void setPickupExpiryDate(final GregorianCalendar pickupExpiryDate) {
        this.pickupExpiryDate = pickupExpiryDate;
    }

    /**
     * User Id
     */
    protected UserId userId;
    /**
     * Date For Return
     */
    protected GregorianCalendar dateForReturn;
    /**
     * Indeterminate Loan Period Flag
     */
    protected Boolean indeterminateLoanPeriodFlag;
    /**
     * Non-returnable Flag
     */
    protected Boolean nonReturnableFlag;
    /**
     * Renewal Not Permitted
     */
    protected Boolean renewalNotPermitted;
    /**
     * Fiscal Transaction Information
     */
    protected FiscalTransactionInformation fiscalTransactionInformation;
    /**
     * Item Optional Fields
     */
    protected ItemOptionalFields itemOptionalFields;
    /**
     * User Optional Fields
     */
    protected UserOptionalFields userOptionalFields;
    /**
     * Pickup Location
     */
    protected PickupLocation pickupLocation;
    /**
     * Pickup Expiry Date
     */
    protected GregorianCalendar pickupExpiryDate;

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
        final AcceptItemInitiationData rhs = (AcceptItemInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId)
            .append(mandatedAction, rhs.mandatedAction).append(itemId, rhs.itemId).append(requestId, rhs.requestId).append(requestedActionType, rhs.requestedActionType)
            .append(userId, rhs.userId).append(dateForReturn, rhs.dateForReturn).append(indeterminateLoanPeriodFlag, rhs.indeterminateLoanPeriodFlag)
            .append(nonReturnableFlag, rhs.nonReturnableFlag).append(renewalNotPermitted, rhs.renewalNotPermitted)
            .append(fiscalTransactionInformation, rhs.fiscalTransactionInformation).append(itemOptionalFields, rhs.itemOptionalFields)
            .append(userOptionalFields, rhs.userOptionalFields).append(pickupLocation, rhs.pickupLocation).append(pickupExpiryDate, rhs.pickupExpiryDate).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1217627167, 1500963365).append(initiationHeader).append(relyingPartyId).append(mandatedAction).append(itemId)
            .append(requestId).append(requestedActionType).append(userId).append(dateForReturn).append(indeterminateLoanPeriodFlag).append(nonReturnableFlag)
            .append(renewalNotPermitted).append(fiscalTransactionInformation).append(itemOptionalFields).append(userOptionalFields).append(pickupLocation).append(pickupExpiryDate)
            .toHashCode();
        return result;
    }
}
