/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Information about a delivery.
 */
public class DeliveryInfo {

    protected Calendar dateSent;
    protected String itemId;
    protected SentViaType sentVia;
    protected Boolean sentToPatron;
    protected LoanConditionType loanCondition;
    protected DeliveredFormatType deliveredFormat;
    protected Costs deliveryCosts;

    /**
     * Gets the value of the dateSent property.
     *
     * @return
     *     possible object is
     *     {@link Calendar }
     *
     */
    public Calendar getDateSent() {
        return dateSent;
    }

    /**
     * Sets the value of the dateSent property.
     *
     * @param dateSent
     *     allowed object is
     *     {@link Calendar }
     *
     */
    public void setDateSent(final Calendar dateSent) {
        this.dateSent = dateSent;
    }

    /**
     * Gets the value of the itemId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     *
     * @param itemId the item identifier
     *
     */
    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    /**
     * Gets the value of the sentVia property.
     *
     * @return
     *     possible object is
     *     {@link SentViaType }
     *
     */
    public SentViaType getSentVia() {
        return sentVia;
    }

    /**
     * Sets the value of the sentVia property.
     *
     * @param sentVia
     *     allowed object is
     *     {@link SentViaType }
     *
     */
    public void setSentVia(final SentViaType sentVia) {
        this.sentVia = sentVia;
    }

    /**
     * Gets the value of the sentToPatron property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean getSentToPatron() {
        return sentToPatron;
    }

    /**
     * Sets the value of the sentToPatron property.
     *
     * @param sentToPatron
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSentToPatron(final Boolean sentToPatron) {
        this.sentToPatron = sentToPatron;
    }

    /**
     * Gets the value of the loanCondition property.
     *
     * @return
     *     possible object is
     *     {@link LoanConditionType }
     *
     */
    public LoanConditionType getLoanCondition() {
        return loanCondition;
    }

    /**
     * Sets the value of the loanCondition property.
     *
     * @param loadCondition
     *     allowed object is
     *     {@link LoanConditionType }
     *
     */
    public void setLoanCondition(final LoanConditionType loadCondition) {
        this.loanCondition = loadCondition;
    }

    /**
     * Gets the value of the deliveredFormat property.
     *
     * @return
     *     possible object is
     *     {@link DeliveredFormatType }
     *
     */
    public DeliveredFormatType getDeliveredFormat() {
        return deliveredFormat;
    }

    /**
     * Sets the value of the deliveredFormat property.
     *
     * @param deliveredFormat
     *     allowed object is
     *     {@link DeliveredFormatType }
     *
     */
    public void setDeliveredFormat(final DeliveredFormatType deliveredFormat) {
        this.deliveredFormat = deliveredFormat;
    }

    /**
     * Gets the value of the deliveryCosts property.
     *
     * @return
     *     possible object is
     *     {@link Costs }
     *
     */
    public Costs getDeliveryCosts() {
        return deliveryCosts;
    }

    /**
     * Sets the value of the deliveryCosts property.
     *
     * @param deliveryCosts
     *     allowed object is
     *     {@link Costs }
     *
     */
    public void setDeliveryCosts(final Costs deliveryCosts) {
        this.deliveryCosts = deliveryCosts;
    }

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
        final DeliveryInfo rhs = (DeliveryInfo) obj;
        final boolean result = new EqualsBuilder().append(dateSent, rhs.dateSent).append(itemId, rhs.itemId).append(sentVia, rhs.sentVia).append(sentToPatron, rhs.sentToPatron)
            .append(loanCondition, rhs.loanCondition).append(deliveredFormat, rhs.deliveredFormat).append(deliveryCosts, rhs.deliveryCosts).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1063443691, 839300651).append(dateSent).append(itemId).append(sentVia).append(sentToPatron).append(loanCondition)
            .append(deliveredFormat).append(deliveryCosts).toHashCode();
        return result;
    }
}
