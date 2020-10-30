/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RelatedFiscalTransactionReferenceId {
    /**
     * Agency Id
     */
    protected AgencyId agencyId;
    /**
     * Fiscal Transaction Identifier Value
     */
    protected String fiscalTransactionIdentifierValue;

    public AgencyId getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(final AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public String getFiscalTransactionIdentifierValue() {
        return fiscalTransactionIdentifierValue;
    }

    public void setFiscalTransactionIdentifierValue(final String fiscalTransactionIdentifierValue) {
        this.fiscalTransactionIdentifierValue = fiscalTransactionIdentifierValue;
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
        final RelatedFiscalTransactionReferenceId rhs = (RelatedFiscalTransactionReferenceId) obj;
        return new EqualsBuilder().append(agencyId, rhs.agencyId).append(fiscalTransactionIdentifierValue, rhs.fiscalTransactionIdentifierValue).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2018579879, 1014338547).append(agencyId).append(fiscalTransactionIdentifierValue).toHashCode();
        return result;
    }

}
