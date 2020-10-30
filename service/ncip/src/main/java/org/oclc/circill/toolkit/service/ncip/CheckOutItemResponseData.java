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
 * CheckOutItemResponseData contains the data that is in a NCIP CheckOut Item Response message.
 */
public class CheckOutItemResponseData implements NCIPResponseData {

    /**
     * Response Header
     */
    protected ResponseHeader responseHeader;
    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();
    /**
     * Required Fee Amount
     */
    protected RequiredFeeAmount requiredFeeAmount;
    /**
     * Required Item Use Restriction Type
     */
    protected List<ItemUseRestrictionType> requiredItemUseRestrictionTypes = new ArrayList<>();
    /**
     * ItemID
     */
    protected ItemId itemId;
    /**
     * User Id
     */
    protected UserId userId;
    /**
     * Date Due
     */
    protected GregorianCalendar dateDue;
    /**
     * Indeterminate Loan Period Flag
     */
    protected Boolean indeterminateLoanPeriodFlag;
    /**
     * Non-Returnable Flag
     */
    protected Boolean nonReturnableFlag;
    /**
     * Renewal Count
     */
    protected BigDecimal renewalCount;
    /**
     * Electronic Resource
     */
    protected ElectronicResource electronicResource;
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
     * Retrieve the response header.
     *
     * @return the response header
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Set the response header
     *
     * @param responseHeader the {@link ResponseHeader}
     */
    public void setResponseHeader(final ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    /**
     * Retrieve the list of {@link Problem}s.
     *
     * @return the list of problems
     */
    @Override
    public List<Problem> getProblems() {
        return problems;
    }

    public Problem getProblem(final int index) {
        return problems != null ? (problems.size() > 0 ? problems.get(index) : null) : null;
    }

    /**
     * Set the list of {@link Problem}s.
     *
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    public void setProblems(final List<Problem> problems) {
        this.problems = problems;
    }

    public void setProblem(final int index, final Problem problem) {
        problems.set(index, problem);
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
     * Retrieve the descriptive information about the item
     *
     * @return the itemOptionalFields
     */
    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    /**
     * Set the descriptive information about the item
     *
     * @param itemOptionalFields the itemDescription to set
     */
    public void setItemOptionalFields(final ItemOptionalFields itemOptionalFields) {
        this.itemOptionalFields = itemOptionalFields;
    }

    public RequiredFeeAmount getRequiredFeeAmount() {
        return requiredFeeAmount;
    }

    public void setRequiredFeeAmount(final RequiredFeeAmount requiredFeeAmount) {
        this.requiredFeeAmount = requiredFeeAmount;
    }

    public List<ItemUseRestrictionType> getRequiredItemUseRestrictionTypes() {
        return requiredItemUseRestrictionTypes;
    }

    public ItemUseRestrictionType getRequiredItemUseRestrictionType() {
        return requiredItemUseRestrictionTypes != null ? (requiredItemUseRestrictionTypes.size() > 0 ? requiredItemUseRestrictionTypes
            .get(requiredItemUseRestrictionTypes.size() - 1) : null) : null;
    }

    public ItemUseRestrictionType getRequiredItemUseRestrictionType(final int index) {
        return requiredItemUseRestrictionTypes != null ? (requiredItemUseRestrictionTypes.size() > 0 ? requiredItemUseRestrictionTypes.get(index) : null) : null;
    }

    public void setRequiredItemUseRestrictionTypes(final List<ItemUseRestrictionType> requiredItemUseRestrictionTypes) {
        this.requiredItemUseRestrictionTypes = requiredItemUseRestrictionTypes;
    }

    public void setRequiredItemUseRestrictionType(final ItemUseRestrictionType requiredItemUseRestrictionType) {
        if (this.requiredItemUseRestrictionTypes != null) {
            this.requiredItemUseRestrictionTypes.clear();
        }
        if (requiredItemUseRestrictionType != null) {
            if (this.requiredItemUseRestrictionTypes == null) {
                this.requiredItemUseRestrictionTypes = new ArrayList<>();
            }
            this.requiredItemUseRestrictionTypes.add(requiredItemUseRestrictionType);
        } else {
            this.requiredItemUseRestrictionTypes = null;
        }
    }

    public void setRequiredItemUseRestrictionType(final int index, final ItemUseRestrictionType requiredItemUseRestrictionType) {
        requiredItemUseRestrictionTypes.set(index, requiredItemUseRestrictionType);
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(final UserId userId) {
        this.userId = userId;
    }

    public GregorianCalendar getDateDue() {
        return dateDue;
    }

    public void setDateDue(final GregorianCalendar dateDue) {
        this.dateDue = dateDue;
    }

    public Boolean getIndeterminateLoanPeriodFlag() {
        return indeterminateLoanPeriodFlag;
    }

    public void setIndeterminateLoanPeriodFlag(final Boolean indeterminateLoanPeriodFlag) {
        this.indeterminateLoanPeriodFlag = indeterminateLoanPeriodFlag;
    }

    public Boolean getNonReturnableFlag() {
        return nonReturnableFlag;
    }

    public void setNonReturnableFlag(final Boolean nonReturnableFlag) {
        this.nonReturnableFlag = nonReturnableFlag;
    }

    public BigDecimal getRenewalCount() {
        return renewalCount;
    }

    public void setRenewalCount(final BigDecimal renewalCount) {
        this.renewalCount = renewalCount;
    }

    public ElectronicResource getElectronicResource() {
        return electronicResource;
    }

    public void setElectronicResource(final ElectronicResource electronicResource) {
        this.electronicResource = electronicResource;
    }

    public FiscalTransactionInformation getFiscalTransactionInformation() {
        return fiscalTransactionInformation;
    }

    public void setFiscalTransactionInformation(final FiscalTransactionInformation fiscalTransactionInformation) {
        this.fiscalTransactionInformation = fiscalTransactionInformation;
    }

    public UserOptionalFields getUserOptionalFields() {
        return userOptionalFields;
    }

    public void setUserOptionalFields(final UserOptionalFields userOptionalFields) {
        this.userOptionalFields = userOptionalFields;
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
        final CheckOutItemResponseData rhs = (CheckOutItemResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems)
            .append(requiredFeeAmount, rhs.requiredFeeAmount).append(requiredItemUseRestrictionTypes, rhs.requiredItemUseRestrictionTypes).append(itemId, rhs.itemId)
            .append(userId, rhs.userId).append(dateDue, rhs.dateDue).append(indeterminateLoanPeriodFlag, rhs.indeterminateLoanPeriodFlag)
            .append(nonReturnableFlag, rhs.nonReturnableFlag).append(renewalCount, rhs.renewalCount).append(electronicResource, rhs.electronicResource)
            .append(fiscalTransactionInformation, rhs.fiscalTransactionInformation).append(itemOptionalFields, rhs.itemOptionalFields)
            .append(userOptionalFields, rhs.userOptionalFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(391297093, 1175582677).append(responseHeader).append(problems).append(requiredFeeAmount)
            .append(requiredItemUseRestrictionTypes).append(itemId).append(userId).append(dateDue).append(indeterminateLoanPeriodFlag).append(nonReturnableFlag)
            .append(renewalCount).append(electronicResource).append(fiscalTransactionInformation).append(itemOptionalFields).append(userOptionalFields).toHashCode();
        return result;
    }
}
