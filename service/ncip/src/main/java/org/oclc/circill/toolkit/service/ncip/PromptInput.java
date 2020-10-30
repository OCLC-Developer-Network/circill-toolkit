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
 * Carries data elements describing the PromptInput.
 */
public class PromptInput {

    /**
     * AuthenticationInputType
     */
    protected AuthenticationInputType authenticationInputType;

    /**
     * Set AuthenticationInputType.
     *
     * @param authenticationInputType the {@link AuthenticationInputType}
     */
    public void setAuthenticationInputType(final AuthenticationInputType authenticationInputType) {

        this.authenticationInputType = authenticationInputType;

    }

    /**
     * Get AuthenticationInputType.
     *
     * @return the {@link AuthenticationInputType}
     */
    public AuthenticationInputType getAuthenticationInputType() {

        return authenticationInputType;

    }

    /**
     * AuthenticationDataFormatType
     */
    protected AuthenticationDataFormatType authenticationDataFormatType;

    /**
     * Set AuthenticationDataFormatType.
     *
     * @param authenticationDataFormatType the {@link AuthenticationDataFormatType}
     */
    public void setAuthenticationDataFormatType(final AuthenticationDataFormatType authenticationDataFormatType) {

        this.authenticationDataFormatType = authenticationDataFormatType;

    }

    /**
     * Get AuthenticationDataFormatType.
     *
     * @return the {@link AuthenticationDataFormatType}
     */
    public AuthenticationDataFormatType getAuthenticationDataFormatType() {

        return authenticationDataFormatType;

    }

    /**
     * SensitiveDataFlag
     */
    protected Boolean sensitiveDataFlag;

    /**
     * Set SensitiveDataFlag.
     *
     * @param sensitiveDataFlag whether or not the data is sensitive
     */
    public void setSensitiveDataFlag(final Boolean sensitiveDataFlag) {

        this.sensitiveDataFlag = sensitiveDataFlag;

    }

    /**
     * Get SensitiveDataFlag.
     *
     * @return whether the input may contain sensitive data
     */
    public Boolean getSensitiveDataFlag() {

        return sensitiveDataFlag;

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
        final PromptInput rhs = (PromptInput) obj;
        return new EqualsBuilder().append(authenticationInputType, rhs.authenticationInputType).append(authenticationDataFormatType, rhs.authenticationDataFormatType)
            .append(sensitiveDataFlag, rhs.sensitiveDataFlag).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(63272789, 904488203).append(authenticationInputType).append(authenticationDataFormatType).append(sensitiveDataFlag).toHashCode();
        return result;
    }
}
