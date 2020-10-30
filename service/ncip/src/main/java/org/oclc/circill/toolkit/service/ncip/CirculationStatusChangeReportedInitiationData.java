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
 * Data to initiate the CirculationStatusChangeReported service.
 */
public class CirculationStatusChangeReportedInitiationData implements NCIPInitiationData {

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
     * UserId
     */
    protected UserId userId;

    /**
     * Set UserId.
     * @param userId the {@link UserId}
     */
    public void setUserId(final UserId userId) {

        this.userId = userId;

    }

    /**
     * Get UserId.
     *
     * @return the {@link UserId}
     */
    public UserId getUserId() {

        return userId;

    }

    /**
     * ItemReportedReturned
     */
    protected ItemReportedReturned itemReportedReturned;

    /**
     * Set ItemReportedReturned.
     *
     * @param itemReportedReturned the {@link ItemReportedReturned}
     */
    public void setItemReportedReturned(final ItemReportedReturned itemReportedReturned) {

        this.itemReportedReturned = itemReportedReturned;

    }

    /**
     * Get ItemReportedReturned.
     *
     * @return the {@link ItemReportedReturned}
     */
    public ItemReportedReturned getItemReportedReturned() {

        return itemReportedReturned;

    }

    /**
     * ItemReportedNeverBorrowed
     */
    protected Boolean itemReportedNeverBorrowed;

    /**
     * Set ItemReportedNeverBorrowed.
     *
     * @param itemReportedNeverBorrowed whether the item was reported as never-borrowed
     */
    public void setItemReportedNeverBorrowed(final Boolean itemReportedNeverBorrowed) {

        this.itemReportedNeverBorrowed = itemReportedNeverBorrowed;

    }

    /**
     * Get ItemReportedNeverBorrowed.
     *
     * @return whether the item was reported as never borrowed
     */
    public Boolean getItemReportedNeverBorrowed() {

        return itemReportedNeverBorrowed;

    }

    /**
     * ItemReportedLost
     */
    protected Boolean itemReportedLost;

    /**
     * Set ItemReportedLost.
     *
     * @param itemReportedLost whether the item was reported lost
     */
    public void setItemReportedLost(final Boolean itemReportedLost) {

        this.itemReportedLost = itemReportedLost;

    }

    /**
     * Get ItemReportedLost.
     *
     * @return whether the item was reported lost
     */
    public Boolean getItemReportedLost() {

        return itemReportedLost;

    }

    /**
     * ItemReportedMissing
     */
    protected Boolean itemReportedMissing;

    /**
     * Set ItemReportedMissing.
     *
     * @param itemReportedMissing whether the item was reported missing
     */
    public void setItemReportedMissing(final Boolean itemReportedMissing) {

        this.itemReportedMissing = itemReportedMissing;

    }

    /**
     * Get ItemReportedMissing.
     *
     * @return whether the item was reported missing
     */
    public Boolean getItemReportedMissing() {

        return itemReportedMissing;

    }

    /**
     * ItemOptionalFields
     */
    protected ItemOptionalFields itemOptionalFields;

    /**
     * Set ItemOptionalFields.
     *
     * @param itemOptionalFields the {@link ItemOptionalFields}
     */
    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {

        this.itemOptionalFields = itemOptionalFields;

    }

    /**
     * Get ItemOptionalFields.
     *
     * @return the {@link ItemOptionalFields}
     */
    public ItemOptionalFields getItemOptionalFields() {

        return itemOptionalFields;

    }

    /**
     * UserOptionalFields
     */
    protected UserOptionalFields userOptionalFields;

    /**
     * Set the UserOptionalFields.
     *
     * @param userOptionalFields the {@link UserOptionalFields}
     */
    public void setUserOptionalFields(final UserOptionalFields userOptionalFields) {

        this.userOptionalFields = userOptionalFields;

    }

    /**
     * Get UserOptionalFields.
     *
     * @return the {@link UserOptionalFields}
     */
    public UserOptionalFields getUserOptionalFields() {

        return userOptionalFields;

    }

    /**
     * FiscalTransactionInformation
     */
    protected FiscalTransactionInformation fiscalTransactionInformation;

    /**
     * Set FiscalTransactionInformation.
     *
     * @param fiscalTransactionInformation the {@link FiscalTransactionInformation}
     */
    public void setFiscalTransactionInformation(final FiscalTransactionInformation fiscalTransactionInformation) {

        this.fiscalTransactionInformation = fiscalTransactionInformation;

    }

    /**
     * Get FiscalTransactionInformation.
     *
     * @return the {@link FiscalTransactionInformation}
     */
    public FiscalTransactionInformation getFiscalTransactionInformation() {

        return fiscalTransactionInformation;

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
        final CirculationStatusChangeReportedInitiationData rhs = (CirculationStatusChangeReportedInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId).append(itemId, rhs.itemId)
            .append(userId, rhs.userId).append(itemReportedReturned, rhs.itemReportedReturned).append(itemReportedNeverBorrowed, rhs.itemReportedNeverBorrowed)
            .append(itemReportedLost, rhs.itemReportedLost).append(itemReportedMissing, rhs.itemReportedMissing).append(itemOptionalFields, rhs.itemOptionalFields)
            .append(userOptionalFields, rhs.userOptionalFields).append(fiscalTransactionInformation, rhs.fiscalTransactionInformation).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(391297093, 1175582677).append(initiationHeader).append(relyingPartyId).append(itemId).append(userId)
            .append(itemReportedReturned).append(itemReportedNeverBorrowed).append(itemReportedLost).append(itemReportedMissing).append(itemOptionalFields)
            .append(userOptionalFields).append(fiscalTransactionInformation).toHashCode();
        return result;
    }
}
