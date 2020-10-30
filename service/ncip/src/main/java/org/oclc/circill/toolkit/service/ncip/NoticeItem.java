/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the NoticeItem.
 */
public class NoticeItem {

    /**
     * ItemDetails
     */
    protected ItemDetails itemDetails;

    /**
     * Set ItemDetails.
     *
     * @param itemDetails the {@link ItemDetails}
     */
    public void setItemDetails(final ItemDetails itemDetails) {

        this.itemDetails = itemDetails;

    }

    /**
     * Get ItemDetails.
     *
     * @return the {@link ItemDetails}
     */
    public ItemDetails getItemDetails() {

        return itemDetails;

    }

    /**
     * Amount
     */
    protected Amount amount;

    /**
     * Set Amount.
     *
     * @param amount the {@link Amount}
     */
    public void setAmount(final Amount amount) {

        this.amount = amount;

    }

    /**
     * Get Amount.
     *
     * @return the {@link Amount}
     */
    public Amount getAmount() {

        return amount;

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
        final NoticeItem rhs = (NoticeItem) obj;
        return new EqualsBuilder().append(itemDetails, rhs.itemDetails).append(amount, rhs.amount).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(623161055, 388071157).append(itemDetails).append(amount).toHashCode();
        return result;
    }
}
