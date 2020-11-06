/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Authentication in supplying library system of the requesting library.
 */
public class RequestingAgencyAuthentication {
    protected String accountId;
    protected String securityCode;

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(final String securityCode) {
        this.securityCode = securityCode;
    }

    public String getAccountId() {

        return accountId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
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
        final RequestingAgencyAuthentication rhs = (RequestingAgencyAuthentication) obj;
        final boolean result = new EqualsBuilder().append(accountId, rhs.accountId).append(securityCode, rhs.securityCode).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(771537697, 957095105).append(accountId).append(securityCode).toHashCode();
        return result;
    }
}
