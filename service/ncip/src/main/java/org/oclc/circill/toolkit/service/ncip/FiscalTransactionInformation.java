/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.PaymentMethodType;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class FiscalTransactionInformation {
    /**
     * FiscalActionType
     */
    protected FiscalActionType fiscalActionType;
    /**
     * FiscalTransactionReferenceId
     */
    protected FiscalTransactionReferenceId fiscalTransactionReferenceId;
    /**
     * RelatedFiscalTransactionReferenceId
     */
    protected List<RelatedFiscalTransactionReferenceId> relatedFiscalTransactionReferenceIds = new ArrayList<>();
    /**
     * FiscalTransactionType
     */
    protected FiscalTransactionType fiscalTransactionType;
    /**
     * ValidFromDate
     */
    protected GregorianCalendar validFromDate;
    /**
     * ValidToDate
     */
    protected GregorianCalendar validToDate;
    /**
     * Amount
     */
    protected Amount amount;
    /**
     * PaymentMethodType
     */
    protected PaymentMethodType paymentMethodType;
    /**
     * FiscalTransactionDescription
     */
    protected String fiscalTransactionDescription;
    /**
     * Request Id
     */
    protected RequestId requestId;
    /**
     * Item Details
     */
    protected ItemDetails itemDetails;

    public FiscalActionType getFiscalActionType() {
        return fiscalActionType;
    }

    public void setFiscalActionType(final FiscalActionType fiscalActionType) {
        this.fiscalActionType = fiscalActionType;
    }

    public FiscalTransactionReferenceId getFiscalTransactionReferenceId() {
        return fiscalTransactionReferenceId;
    }

    public void setFiscalTransactionReferenceId(final FiscalTransactionReferenceId fiscalTransactionReferenceId) {
        this.fiscalTransactionReferenceId = fiscalTransactionReferenceId;
    }

    public List<RelatedFiscalTransactionReferenceId> getRelatedFiscalTransactionReferenceIds() {
        return relatedFiscalTransactionReferenceIds;
    }

    public RelatedFiscalTransactionReferenceId getRelatedFiscalTransactionReferenceId() {
        return relatedFiscalTransactionReferenceIds != null ? (relatedFiscalTransactionReferenceIds.size() > 0 ? relatedFiscalTransactionReferenceIds
            .get(relatedFiscalTransactionReferenceIds.size() - 1) : null) : null;
    }

    public RelatedFiscalTransactionReferenceId getRelatedFiscalTransactionReferenceId(final int index) {
        return relatedFiscalTransactionReferenceIds != null ? (relatedFiscalTransactionReferenceIds.size() > 0 ? relatedFiscalTransactionReferenceIds.get(index) : null) : null;
    }

    public void setRelatedFiscalTransactionReferenceIds(final List<RelatedFiscalTransactionReferenceId> relatedFiscalTransactionReferenceIds) {
        this.relatedFiscalTransactionReferenceIds = relatedFiscalTransactionReferenceIds;
    }

    public void setRelatedFiscalTransactionReferenceId(final RelatedFiscalTransactionReferenceId relatedFiscalTransactionReferenceId) {
        if (this.relatedFiscalTransactionReferenceIds != null) {
            this.relatedFiscalTransactionReferenceIds.clear();
        }
        if (relatedFiscalTransactionReferenceId != null) {
            if (this.relatedFiscalTransactionReferenceIds == null) {
                this.relatedFiscalTransactionReferenceIds = new ArrayList<>();
            }
            this.relatedFiscalTransactionReferenceIds.add(relatedFiscalTransactionReferenceId);
        } else {
            this.relatedFiscalTransactionReferenceIds = null;
        }
    }

    public void setRelatedFiscalTransactionReferenceId(final int index, final RelatedFiscalTransactionReferenceId relatedFiscalTransactionReferenceId) {
        relatedFiscalTransactionReferenceIds.set(index, relatedFiscalTransactionReferenceId);
    }

    public FiscalTransactionType getFiscalTransactionType() {
        return fiscalTransactionType;
    }

    public void setFiscalTransactionType(final FiscalTransactionType fiscalTransactionType) {
        this.fiscalTransactionType = fiscalTransactionType;
    }

    public GregorianCalendar getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(final GregorianCalendar validFromDate) {
        this.validFromDate = validFromDate;
    }

    public GregorianCalendar getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(final GregorianCalendar validToDate) {
        this.validToDate = validToDate;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(final Amount amount) {
        this.amount = amount;
    }

    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(final PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getFiscalTransactionDescription() {
        return fiscalTransactionDescription;
    }

    public void setFiscalTransactionDescription(final String fiscalTransactionDescription) {
        this.fiscalTransactionDescription = fiscalTransactionDescription;
    }

    public RequestId getRequestId() {
        return requestId;
    }

    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    public ItemDetails getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(final ItemDetails itemDetails) {
        this.itemDetails = itemDetails;
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
        final FiscalTransactionInformation rhs = (FiscalTransactionInformation) obj;
        return new EqualsBuilder().append(fiscalActionType, rhs.fiscalActionType).append(fiscalTransactionReferenceId, rhs.fiscalTransactionReferenceId)
            .append(relatedFiscalTransactionReferenceIds, rhs.relatedFiscalTransactionReferenceIds).append(fiscalTransactionType, rhs.fiscalTransactionType)
            .append(validFromDate, rhs.validFromDate).append(validToDate, rhs.validToDate).append(amount, rhs.amount).append(paymentMethodType, rhs.paymentMethodType)
            .append(fiscalTransactionDescription, rhs.fiscalTransactionDescription).append(requestId, rhs.requestId).append(itemDetails, rhs.itemDetails).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1255745517, 1994663559).append(fiscalActionType).append(fiscalTransactionReferenceId).append(relatedFiscalTransactionReferenceIds)
            .append(fiscalTransactionType).append(validFromDate).append(validToDate).append(amount).append(paymentMethodType).append(fiscalTransactionDescription).append(requestId)
            .append(itemDetails).toHashCode();
        return result;
    }
}
