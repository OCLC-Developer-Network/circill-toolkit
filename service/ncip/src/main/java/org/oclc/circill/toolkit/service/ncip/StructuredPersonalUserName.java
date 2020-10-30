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

public class StructuredPersonalUserName {
    /**
     * Prefix
     */
    protected String prefix;
    /**
     * Given name
     */
    protected String givenName;
    /**
     * Initials
     */
    protected String initials;
    /**
     * Surname
     */
    protected String surname;
    /**
     * Suffix
     */
    protected String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(final String givenName) {
        this.givenName = givenName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(final String initials) {
        this.initials = initials;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(final String suffix) {
        this.suffix = suffix;
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
        final StructuredPersonalUserName rhs = (StructuredPersonalUserName) obj;
        return new EqualsBuilder().append(prefix, rhs.prefix).append(givenName, rhs.givenName).append(initials, rhs.initials).append(surname, rhs.surname)
            .append(suffix, rhs.suffix).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(113904473, 1544410473).append(prefix).append(givenName).append(initials).append(surname).append(suffix).toHashCode();
        return result;
    }
}
