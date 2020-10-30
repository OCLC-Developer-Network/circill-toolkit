/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the RenewItemResponse.
 */
public class RenewItemResponseData implements NCIPResponseData {

    /**
     * ResponseHeader
     */
    protected ResponseHeader responseHeader;

    /**
     * Set ResponseHeader.
     * @param responseHeader the {@link ResponseHeader}
     */
    public void setResponseHeader(final ResponseHeader responseHeader) {

        this.responseHeader = responseHeader;

    }

    /**
     * Get ResponseHeader.
     *
     * @return the {@link ResponseHeader}
     */
    public ResponseHeader getResponseHeader() {

        return responseHeader;

    }

    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();

    /**
     * Set Problems.
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    public void setProblems(final List<Problem> problems) {

        this.problems = problems;

    }

    /**
     * Get Problems.
     */
    @Override
    public List<Problem> getProblems() {

        return problems;

    }

    /**
     * RequiredFeeAmount
     */
    protected RequiredFeeAmount requiredFeeAmount;

    /**
     * Set RequiredFeeAmount.
     *
     * @param requiredFeeAmount the {@link RequiredFeeAmount}
     */
    public void setRequiredFeeAmount(final RequiredFeeAmount requiredFeeAmount) {

        this.requiredFeeAmount = requiredFeeAmount;

    }

    /**
     * Get RequiredFeeAmount.
     *
     * @return the {@link RequiredFeeAmount}
     */
    public RequiredFeeAmount getRequiredFeeAmount() {

        return requiredFeeAmount;

    }

    /**
     * RequiredItemUseRestrictionTypes
     */
    protected List<ItemUseRestrictionType> requiredItemUseRestrictionTypes;

    /**
     * Set RequiredItemUseRestrictionTypes.
     *
     * @param requiredItemUseRestrictionTypes the list of required {@link ItemUseRestrictionType}s
     */
    public void setRequiredItemUseRestrictionTypes(final List<ItemUseRestrictionType> requiredItemUseRestrictionTypes) {

        this.requiredItemUseRestrictionTypes = requiredItemUseRestrictionTypes;

    }

    /**
     * Get RequiredItemUseRestrictionTypes.
     *
     * @return a list of {@link ItemUseRestrictionType}s
     */
    public List<ItemUseRestrictionType> getRequiredItemUseRestrictionTypes() {

        return requiredItemUseRestrictionTypes;

    }

    /**
     * Pending
     */
    protected Pending pending;

    /**
     * Set Pending.
     *
     * @param pending the {@link Pending}
     */
    public void setPending(final Pending pending) {

        this.pending = pending;

    }

    /**
     * Get Pending.
     *
     * @return the {@link Pending}
     */
    public Pending getPending() {

        return pending;

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
     * DateDue
     */
    protected GregorianCalendar dateDue;

    /**
     * Set DateDue.
     *
     * @param dateDue the date on which the loan is scheduled to end
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
     * DateForReturn
     */
    protected GregorianCalendar dateForReturn;

    /**
     * Set DateForReturn.
     *
     * @param dateForReturn the date for return of the item
     */
    public void setDateForReturn(final GregorianCalendar dateForReturn) {

        this.dateForReturn = dateForReturn;

    }

    /**
     * Get DateForReturn.
     *
     * @return the date for return
     */
    public GregorianCalendar getDateForReturn() {

        return dateForReturn;

    }

    /**
     * RenewalCount
     */
    protected BigDecimal renewalCount;

    /**
     * Set RenewalCount.
     *
     * @param renewalCount the number of times the item has been renewed
     */
    public void setRenewalCount(final BigDecimal renewalCount) {

        this.renewalCount = renewalCount;

    }

    /**
     * Get RenewalCount.
     *
     * @return the renewal count
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
        final RenewItemResponseData rhs = (RenewItemResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems)
            .append(requiredFeeAmount, rhs.requiredFeeAmount).append(requiredItemUseRestrictionTypes, rhs.requiredItemUseRestrictionTypes).append(pending, rhs.pending)
            .append(itemId, rhs.itemId).append(userId, rhs.userId).append(dateDue, rhs.dateDue).append(dateForReturn, rhs.dateForReturn).append(renewalCount, rhs.renewalCount)
            .append(fiscalTransactionInformation, rhs.fiscalTransactionInformation).append(itemOptionalFields, rhs.itemOptionalFields)
            .append(userOptionalFields, rhs.userOptionalFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(973434945, 211125939).append(responseHeader).append(problems).append(requiredFeeAmount)
            .append(requiredItemUseRestrictionTypes).append(pending).append(itemId).append(userId).append(dateDue).append(dateForReturn).append(renewalCount)
            .append(fiscalTransactionInformation).append(itemOptionalFields).append(userOptionalFields).toHashCode();
        return result;
    }
}
