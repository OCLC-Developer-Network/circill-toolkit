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

public class OrganizationNameInformation {
    /**
     * Organization Name Type
     */
    protected OrganizationNameType organizationNameType;
    /**
     * Organization Name
     */
    protected String organizationName;

    public OrganizationNameType getOrganizationNameType() {
        return organizationNameType;
    }

    public void setOrganizationNameType(final OrganizationNameType organizationNameType) {
        this.organizationNameType = organizationNameType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(final String organizationName) {
        this.organizationName = organizationName;
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
        final OrganizationNameInformation rhs = (OrganizationNameInformation) obj;
        return new EqualsBuilder().append(organizationNameType, rhs.organizationNameType).append(organizationName, rhs.organizationName).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1600117641, 1254374771).append(organizationNameType).append(organizationName).toHashCode();
        return result;
    }

}
