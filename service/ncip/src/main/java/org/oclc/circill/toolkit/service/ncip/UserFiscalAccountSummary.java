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
 * Summarizes a usres's fiscal account
 */
public class UserFiscalAccountSummary {

    protected BigDecimal chargesCount;
    protected AccountBalance accountBalance;

    public BigDecimal getChargesCount() {
        return chargesCount;
    }

    public void setChargesCount(final BigDecimal chargesCount) {
        this.chargesCount = chargesCount;
    }

    public AccountBalance getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(final AccountBalance accountBalance) {
        this.accountBalance = accountBalance;
    }

    /*
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
        final UserFiscalAccountSummary rhs = (UserFiscalAccountSummary) obj;
        return new EqualsBuilder().append(chargesCount, rhs.chargesCount).append(accountBalance, rhs.accountBalance).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(168935595, 2088705619).append(chargesCount).append(accountBalance).toHashCode();
        return result;
    }

}
