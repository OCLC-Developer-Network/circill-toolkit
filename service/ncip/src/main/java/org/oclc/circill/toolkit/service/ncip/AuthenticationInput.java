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

public class AuthenticationInput {
    /**
     * Authentication Data Format Type
     */
    protected AuthenticationDataFormatType authenticationDataFormatType;
    /**
     * Authentication Input Data
     */
    protected String authenticationInputData;
    /**
     * Authentication Input Type
     */
    protected AuthenticationInputType authenticationInputType;

    public AuthenticationDataFormatType getAuthenticationDataFormatType() {
        return authenticationDataFormatType;
    }

    public void setAuthenticationDataFormatType(final AuthenticationDataFormatType authenticationDataFormatType) {
        this.authenticationDataFormatType = authenticationDataFormatType;
    }

    public String getAuthenticationInputData() {
        return authenticationInputData;
    }

    public void setAuthenticationInputData(final String authenticationInputData) {
        this.authenticationInputData = authenticationInputData;
    }

    public AuthenticationInputType getAuthenticationInputType() {
        return authenticationInputType;
    }

    public void setAuthenticationInputType(final AuthenticationInputType authenticationInputType) {
        this.authenticationInputType = authenticationInputType;
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
        final AuthenticationInput rhs = (AuthenticationInput) obj;
        return new EqualsBuilder().append(authenticationDataFormatType, rhs.authenticationDataFormatType).append(authenticationInputData, rhs.authenticationInputData)
            .append(authenticationInputType, rhs.authenticationInputType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2113721943, 1616817019).append(authenticationDataFormatType).append(authenticationInputData).append(authenticationInputType)
            .toHashCode();
        return result;
    }
}
