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

public class NameInformation {

    /**
     * Personal Name Information
     */
    protected PersonalNameInformation personalNameInformation;
    /**
     * Organization Name Informations
     */
    protected List<OrganizationNameInformation> organizationNameInformations = new ArrayList<>();

    public PersonalNameInformation getPersonalNameInformation() {
        return personalNameInformation;
    }

    public void setPersonalNameInformation(final PersonalNameInformation personalNameInformation) {
        this.personalNameInformation = personalNameInformation;
    }

    public List<OrganizationNameInformation> getOrganizationNameInformations() {
        return organizationNameInformations;
    }

    public OrganizationNameInformation getOrganizationNameInformation(final int index) {
        return organizationNameInformations != null ? (organizationNameInformations.size() > 0 ? organizationNameInformations.get(index) : null) : null;
    }

    public void setOrganizationNameInformations(final List<OrganizationNameInformation> organizationNameInformations) {
        this.organizationNameInformations = organizationNameInformations;
    }

    public void setOrganizationNameInformation(final int index, final OrganizationNameInformation organizationNameInformation) {
        organizationNameInformations.set(index, organizationNameInformation);
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
        final NameInformation rhs = (NameInformation) obj;
        return new EqualsBuilder().append(personalNameInformation, rhs.personalNameInformation).append(organizationNameInformations, rhs.organizationNameInformations).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(623161055, 388071157).append(personalNameInformation).append(organizationNameInformations).toHashCode();
        return result;
    }
}
