/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Describes a UserFiscalAccount result from an NCIP response
 */
public class UserFiscalAccount {

    /**
     * account balance
     */
    protected AccountBalance accountBalance;
    /**
     * account detail
     */
    protected List<AccountDetails> accountDetails = new ArrayList<>();

    /**
     * Set the account balance
     *
     * @param accountBalance the accountBalance to set
     */
    public void setAccountBalance(final AccountBalance accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * Retrieve the account balance
     *
     * @return the accountBalance
     */
    public AccountBalance getAccountBalance() {
        return accountBalance;
    }

    public List<AccountDetails> getAccountDetails() {
        return accountDetails;
    }

    public AccountDetails getAccountDetail() {
        return accountDetails != null ? (accountDetails.size() > 0 ? accountDetails.get(accountDetails.size() - 1) : null) : null;
    }

    public AccountDetails getAccountDetail(final int index) {
        return accountDetails != null ? (accountDetails.size() > 0 ? accountDetails.get(index) : null) : null;
    }

    public void setAccountDetails(final List<AccountDetails> accountDetails) {
        this.accountDetails = accountDetails;
    }

    public void setAccountDetail(final AccountDetails accountDetail) {
        if (this.accountDetails != null) {
            this.accountDetails.clear();
        }
        if (accountDetail != null) {
            if (this.accountDetails == null) {
                this.accountDetails = new ArrayList<>();
            }
            this.accountDetails.add(accountDetail);
        } else {
            this.accountDetails = null;
        }
    }

    public void setAccountDetail(final int index, final AccountDetails accountDetail) {
        accountDetails.set(index, accountDetail);
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
        final UserFiscalAccount rhs = (UserFiscalAccount) obj;
        return new EqualsBuilder().append(accountBalance, rhs.accountBalance).append(accountDetails, rhs.accountDetails).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(120999981, 324050179).append(accountBalance).append(accountDetails).toHashCode();
        return result;
    }
}
