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
 * Carries data elements describing the PromptOutput.
 */
public class PromptOutput {

    /**
     * AuthenticationPromptData
     */
    protected String authenticationPromptData;

    /**
     * Set AuthenticationPromptData.
     *
     * @param authenticationPromptData the authentication prompt
     */
    public void setAuthenticationPromptData(final String authenticationPromptData) {

        this.authenticationPromptData = authenticationPromptData;

    }

    /**
     * Get AuthenticationPromptData.
     *
     * @return the {@link String}
     */
    public String getAuthenticationPromptData() {

        return authenticationPromptData;

    }

    /**
     * AuthenticationPromptType
     */
    protected AuthenticationPromptType authenticationPromptType;

    /**
     * Set AuthenticationPromptType.
     *
     * @param authenticationPromptType the {@link AuthenticationPromptType}
     */
    public void setAuthenticationPromptType(final AuthenticationPromptType authenticationPromptType) {

        this.authenticationPromptType = authenticationPromptType;

    }

    /**
     * Get AuthenticationPromptType.
     *
     * @return the {@link AuthenticationPromptType}
     */
    public AuthenticationPromptType getAuthenticationPromptType() {

        return authenticationPromptType;

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
        final PromptOutput rhs = (PromptOutput) obj;
        return new EqualsBuilder().append(authenticationPromptData, rhs.authenticationPromptData).append(authenticationPromptType, rhs.authenticationPromptType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(63272789, 904488203).append(authenticationPromptData).append(authenticationPromptType).toHashCode();
        return result;
    }
}
