/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the AgencyUpdated service.
 */
public class AgencyUpdatedInitiationData implements NCIPInitiationData {

    /**
     * InitiationHeader
     */
    protected InitiationHeader initiationHeader;

    /**
     * Set InitiationHeader.
     */
    @Override
    public void setInitiationHeader(final InitiationHeader initiationHeader) {

        this.initiationHeader = initiationHeader;

    }

    /**
     * Get InitiationHeader.
     */
    @Override
    public InitiationHeader getInitiationHeader() {

        return initiationHeader;

    }

    /**
     * Relying Party Id
     */
    protected AgencyId relyingPartyId;

    /**
     * Get the RelyingPartyId.
     *
     * @return the RelyingPartyId
     */
    @Override
    public AgencyId getRelyingPartyId() {
        return relyingPartyId;
    }

    /**
     * Set the RelyingPartyId.
     *
     * @param relyingPartyId the RelyingPartyId
     */
    @Override
    public void setRelyingPartyId(final AgencyId relyingPartyId) {
        this.relyingPartyId = relyingPartyId;
    }

    /**
     * AgencyId
     */
    protected AgencyId agencyId;

    /**
     * Set AgencyId.
     *
     * @param agencyId the {@link AgencyId}
     */
    public void setAgencyId(final AgencyId agencyId) {

        this.agencyId = agencyId;

    }

    /**
     * Get AgencyId.
     *
     * @return the {@link AgencyId}
     */
    public AgencyId getAgencyId() {

        return agencyId;

    }

    /**
     * DeleteAgencyFields
     */
    protected DeleteAgencyFields deleteAgencyFields;

    /**
     * Set DeleteAgencyFields.
     *
     * @param deleteAgencyFields the {@link DeleteAgencyFields}
     */
    public void setDeleteAgencyFields(final DeleteAgencyFields deleteAgencyFields) {

        this.deleteAgencyFields = deleteAgencyFields;

    }

    /**
     * Get DeleteAgencyFields.
     *
     * @return the {@link DeleteAgencyFields}
     */
    public DeleteAgencyFields getDeleteAgencyFields() {

        return deleteAgencyFields;

    }

    /**
     * AddAgencyFields
     */
    protected AddAgencyFields addAgencyFields;

    /**
     * Set AddAgencyFields.
     *
     * @param addAgencyFields the {@link AddAgencyFields}
     */
    public void setAddAgencyFields(final AddAgencyFields addAgencyFields) {

        this.addAgencyFields = addAgencyFields;

    }

    /**
     * Get AddAgencyFields.
     *
     * @return the {@link AddAgencyFields}
     */
    public AddAgencyFields getAddAgencyFields() {

        return addAgencyFields;

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
        final AgencyUpdatedInitiationData rhs = (AgencyUpdatedInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId)
            .append(agencyId, rhs.agencyId).append(deleteAgencyFields, rhs.deleteAgencyFields).append(addAgencyFields, rhs.addAgencyFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2133176635, 1738001861).append(initiationHeader).append(relyingPartyId).append(agencyId).append(deleteAgencyFields)
            .append(addAgencyFields).toHashCode();
        return result;
    }
}
