/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Description of a specific physical or electronic Item belonging to an Agency's collection(s).
 */
public class ItemDescription {

    /**
     * Permanent relative physical location assigned to a bibliographic item
     */
    protected String callNumber;
    /**
     * The copy number of an Item held by an Agency
     */
    protected String copyNumber;
    /**
     * Holdings Information
     */
    protected HoldingsInformation holdingsInformation;
    /**
     * The level at which the Item is described
     */
    protected ItemDescriptionLevel itemDescriptionLevel;
    /**
     * the number of pieces that comprise this item
     */
    protected BigDecimal numberOfPieces;

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(final String callNumber) {
        this.callNumber = callNumber;
    }

    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(final String copyNumber) {
        this.copyNumber = copyNumber;
    }

    public HoldingsInformation getHoldingsInformation() {
        return holdingsInformation;
    }

    public void setHoldingsInformation(final HoldingsInformation holdingsInformation) {
        this.holdingsInformation = holdingsInformation;
    }

    public ItemDescriptionLevel getItemDescriptionLevel() {
        return itemDescriptionLevel;
    }

    public void setItemDescriptionLevel(final ItemDescriptionLevel itemDescriptionLevel) {
        this.itemDescriptionLevel = itemDescriptionLevel;
    }

    public BigDecimal getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(final BigDecimal numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
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
        final ItemDescription rhs = (ItemDescription) obj;
        return new EqualsBuilder().append(callNumber, rhs.callNumber).append(copyNumber, rhs.copyNumber).append(holdingsInformation, rhs.holdingsInformation)
            .append(itemDescriptionLevel, rhs.itemDescriptionLevel).append(numberOfPieces, rhs.numberOfPieces).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1895508875, 652749153).append(callNumber).append(copyNumber).append(holdingsInformation).append(itemDescriptionLevel)
            .append(numberOfPieces).toHashCode();
        return result;
    }
}
