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

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the ItemCheckedOut service.
 */
public class ItemCheckedOutInitiationData implements NCIPInitiationData {

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
     * DateDue
     */
    protected GregorianCalendar dateDue;

    /**
     * Set DateDue.
     *
     * @param dateDue the date due
     */
    public void setDateDue(final GregorianCalendar dateDue) {

        this.dateDue = dateDue;

    }

    /**
     * Get DateDue.
     *
     * @return the date due
     */
    public GregorianCalendar getDateDue() {

        return dateDue;

    }

    /**
     * IndeterminateLoanPeriodFlag
     */
    protected Boolean indeterminateLoanPeriodFlag;

    /**
     * Set IndeterminateLoanPeriodFlag.
     *
     * @param indeterminateLoanPeriodFlag whether the loan period is indeterminate
     */
    public void setIndeterminateLoanPeriodFlag(final Boolean indeterminateLoanPeriodFlag) {

        this.indeterminateLoanPeriodFlag = indeterminateLoanPeriodFlag;

    }

    /**
     * Get IndeterminateLoanPeriodFlag.
     *
     * @return whether the loan period is indeterminate
     */
    public Boolean getIndeterminateLoanPeriodFlag() {

        return indeterminateLoanPeriodFlag;

    }

    /**
     * NonReturnableFlag
     */
    protected Boolean nonReturnableFlag;

    /**
     * Set NonReturnableFlag.
     *
     * @param nonReturnableFlag whether the item is non-returnable
     */
    public void setNonReturnableFlag(final Boolean nonReturnableFlag) {

        this.nonReturnableFlag = nonReturnableFlag;

    }

    /**
     * Get NonReturnableFlag.
     *
     * @return whether the item is non-returnable
     */
    public Boolean getNonReturnableFlag() {

        return nonReturnableFlag;

    }

    /**
     * ElectronicResourceProvidedFlag
     */
    protected Boolean electronicResourceProvidedFlag;

    /**
     * Set ElectronicResourceProvidedFlag.
     *
     * @param electronicResourceProvidedFlag whether the electronic resource has been provided
     */
    public void setElectronicResourceProvidedFlag(final Boolean electronicResourceProvidedFlag) {

        this.electronicResourceProvidedFlag = electronicResourceProvidedFlag;

    }

    /**
     * Get ElectronicResourceProvidedFlag.
     *
     * @return whether the electronic resource is provided
     */
    public Boolean getElectronicResourceProvidedFlag() {

        return electronicResourceProvidedFlag;

    }

    /**
     * RenewalCount
     */
    protected BigDecimal renewalCount;

    /**
     * Set RenewalCount.
     *
     * @param renewalCount the count of renewals
     */
    public void setRenewalCount(final BigDecimal renewalCount) {

        this.renewalCount = renewalCount;

    }

    /**
     * Get RenewalCount.
     *
     * @return the count of renewals
     */
    public BigDecimal getRenewalCount() {

        return renewalCount;

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
     * ShippingInformation
     */
    protected ShippingInformation shippingInformation;

    /**
     * Set ShippingInformation.
     *
     * @param shippingInformation the {@link ShippingInformation}
     */
    public void setShippingInformation(final ShippingInformation shippingInformation) {

        this.shippingInformation = shippingInformation;

    }

    /**
     * Get ShippingInformation.
     *
     * @return the {@link ShippingInformation}
     */
    public ShippingInformation getShippingInformation() {

        return shippingInformation;

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
        final ItemCheckedOutInitiationData rhs = (ItemCheckedOutInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId).append(userId, rhs.userId)
            .append(itemId, rhs.itemId).append(requestId, rhs.requestId).append(dateDue, rhs.dateDue).append(indeterminateLoanPeriodFlag, rhs.indeterminateLoanPeriodFlag)
            .append(nonReturnableFlag, rhs.nonReturnableFlag).append(electronicResourceProvidedFlag, rhs.electronicResourceProvidedFlag).append(renewalCount, rhs.renewalCount)
            .append(fiscalTransactionInformation, rhs.fiscalTransactionInformation).append(shippingInformation, rhs.shippingInformation)
            .append(itemOptionalFields, rhs.itemOptionalFields).append(userOptionalFields, rhs.userOptionalFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2054682227, 2082387183).append(initiationHeader).append(relyingPartyId).append(userId).append(itemId).append(requestId)
            .append(dateDue).append(indeterminateLoanPeriodFlag).append(nonReturnableFlag).append(electronicResourceProvidedFlag).append(renewalCount)
            .append(fiscalTransactionInformation).append(shippingInformation).append(itemOptionalFields).append(userOptionalFields).toHashCode();
        return result;
    }
}
