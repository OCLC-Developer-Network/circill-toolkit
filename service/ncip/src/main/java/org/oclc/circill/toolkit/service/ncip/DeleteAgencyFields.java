/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.ApplicationProfileSupportedType;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the DeleteAgencyFields.
 */
public class DeleteAgencyFields {

    /**
     * OrganizationNameInformations
     */
    protected List<OrganizationNameInformation> organizationNameInformations;

    /**
     * Set OrganizationNameInformations.
     *
     * @param organizationNameInformations the list of {@link OrganizationNameInformation}s
     */
    public void setOrganizationNameInformations(final List<OrganizationNameInformation> organizationNameInformations) {

        this.organizationNameInformations = organizationNameInformations;

    }

    /**
     * Get OrganizationNameInformations.
     *
     * @return a list of {@link OrganizationNameInformation}s
     */
    public List<OrganizationNameInformation> getOrganizationNameInformations() {

        return organizationNameInformations;

    }

    /**
     * AgencyAddressInformations
     */
    protected List<AgencyAddressInformation> agencyAddressInformations;

    /**
     * Set AgencyAddressInformations.
     *
     * @param agencyAddressInformations the list of {@link AgencyAddressInformation}s
     */
    public void setAgencyAddressInformations(final List<AgencyAddressInformation> agencyAddressInformations) {

        this.agencyAddressInformations = agencyAddressInformations;

    }

    /**
     * Get AgencyAddressInformations.
     *
     * @return a list of {@link AgencyAddressInformation}s
     */
    public List<AgencyAddressInformation> getAgencyAddressInformations() {

        return agencyAddressInformations;

    }

    /**
     * AuthenticationPrompts
     */
    protected List<AuthenticationPrompt> authenticationPrompts;

    /**
     * Set AuthenticationPrompts.
     *
     * @param authenticationPrompts the list of {@link AuthenticationPrompt}s
     */
    public void setAuthenticationPrompts(final List<AuthenticationPrompt> authenticationPrompts) {

        this.authenticationPrompts = authenticationPrompts;

    }

    /**
     * Get AuthenticationPrompts.
     *
     * @return a list of {@link AuthenticationPrompt}s
     */
    public List<AuthenticationPrompt> getAuthenticationPrompts() {

        return authenticationPrompts;

    }

    /**
     * ApplicationProfileSupportedTypes
     */
    protected List<ApplicationProfileSupportedType> applicationProfileSupportedTypes;

    /**
     * Set ApplicationProfileSupportedTypes.
     *
     * @param applicationProfileSupportedTypes the list of {@link ApplicationProfileSupportedType}s
     */
    public void setApplicationProfileSupportedTypes(final List<ApplicationProfileSupportedType> applicationProfileSupportedTypes) {

        this.applicationProfileSupportedTypes = applicationProfileSupportedTypes;

    }

    /**
     * Get ApplicationProfileSupportedTypes.
     *
     * @return a list of {@link ApplicationProfileSupportedType}s
     */
    public List<ApplicationProfileSupportedType> getApplicationProfileSupportedTypes() {

        return applicationProfileSupportedTypes;

    }

    /**
     * ConsortiumAgreements
     */
    protected List<ConsortiumAgreement> consortiumAgreements;

    /**
     * Set ConsortiumAgreements.
     *
     * @param consortiumAgreements the list of {@link ConsortiumAgreement}s
     */
    public void setConsortiumAgreements(final List<ConsortiumAgreement> consortiumAgreements) {

        this.consortiumAgreements = consortiumAgreements;

    }

    /**
     * Get ConsortiumAgreements.
     *
     * @return a list of {@link ConsortiumAgreement}s
     */
    public List<ConsortiumAgreement> getConsortiumAgreements() {

        return consortiumAgreements;

    }

    /**
     * AgencyUserPrivilegeTypes
     */
    protected List<AgencyUserPrivilegeType> agencyUserPrivilegeTypes;

    /**
     * Set AgencyUserPrivilegeTypes.
     *
     * @param agencyUserPrivilegeTypes the list of {@link AgencyUserPrivilegeType}s
     */
    public void setAgencyUserPrivilegeTypes(final List<AgencyUserPrivilegeType> agencyUserPrivilegeTypes) {

        this.agencyUserPrivilegeTypes = agencyUserPrivilegeTypes;

    }

    /**
     * Get AgencyUserPrivilegeTypes.
     *
     * @return a list of {@link AgencyUserPrivilegeType}s
     */
    public List<AgencyUserPrivilegeType> getAgencyUserPrivilegeTypes() {

        return agencyUserPrivilegeTypes;

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
        final DeleteAgencyFields rhs = (DeleteAgencyFields) obj;
        return new EqualsBuilder().append(organizationNameInformations, rhs.organizationNameInformations).append(agencyAddressInformations, rhs.agencyAddressInformations)
            .append(authenticationPrompts, rhs.authenticationPrompts).append(applicationProfileSupportedTypes, rhs.applicationProfileSupportedTypes)
            .append(consortiumAgreements, rhs.consortiumAgreements).append(agencyUserPrivilegeTypes, rhs.agencyUserPrivilegeTypes).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(144811125, 1788434775).append(organizationNameInformations).append(agencyAddressInformations).append(authenticationPrompts)
            .append(applicationProfileSupportedTypes).append(consortiumAgreements).append(agencyUserPrivilegeTypes).toHashCode();
        return result;
    }
}
