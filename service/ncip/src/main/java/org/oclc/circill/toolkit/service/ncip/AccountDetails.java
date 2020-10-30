/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Describes a AccountDetails result from an NCIP response
 */
public class AccountDetails {

    protected GregorianCalendar accrualDate;

    protected FiscalTransactionInformation fiscalTransactionInformation;

    /**
     * Retrieves the accrual date
     *
     * @return the accrualDate
     */
    public GregorianCalendar getAccrualDate() {
        return accrualDate;
    }

    /**
     * Set the accrual date
     *
     * @param accrualDate the accrual date to set
     */
    public void setAccrualDate(final GregorianCalendar accrualDate) {
        this.accrualDate = accrualDate;
    }

    /**
     * Retrieves the FiscalTransactionInformation
     *
     * @return FiscalTransactionInformation
     */
    public FiscalTransactionInformation getFiscalTransactionInformation() {
        return fiscalTransactionInformation;
    }

    /**
     * Set the Fiscal Transaction Information
     *
     * @param fiscalTransactionInformation the information to set
     */
    public void setFiscalTransactionInformation(final FiscalTransactionInformation fiscalTransactionInformation) {
        this.fiscalTransactionInformation = fiscalTransactionInformation;
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
        final AccountDetails rhs = (AccountDetails) obj;
        return new EqualsBuilder().append(accrualDate, rhs.accrualDate).append(fiscalTransactionInformation, rhs.fiscalTransactionInformation).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1687339833, 895637503).append(accrualDate).append(fiscalTransactionInformation).toHashCode();
        return result;
    }
}
