/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip.common;

import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The header in a {@link ServiceMessage} containing a {@link ServiceInitiationData}.
 */
public class InitiationHeader {
    /**
     * Application Profile Type
     */
    protected ApplicationProfileType applicationProfileType;
    /**
     * To System Id
     */
    protected ToSystemId toSystemId;

    public ApplicationProfileType getApplicationProfileType() {
        return applicationProfileType;
    }

    public void setApplicationProfileType(final ApplicationProfileType applicationProfileType) {
        this.applicationProfileType = applicationProfileType;
    }

    public ToSystemId getToSystemId() {
        return toSystemId;
    }

    public void setToSystemId(final ToSystemId toSystemId) {
        this.toSystemId = toSystemId;
    }

    public String getFromSystemAuthentication() {
        return fromSystemAuthentication;
    }

    public void setFromSystemAuthentication(final String fromSystemAuthentication) {
        this.fromSystemAuthentication = fromSystemAuthentication;
    }

    public FromSystemId getFromSystemId() {
        return fromSystemId;
    }

    public void setFromSystemId(final FromSystemId fromSystemId) {
        this.fromSystemId = fromSystemId;
    }

    public String getFromAgencyAuthentication() {
        return fromAgencyAuthentication;
    }

    public void setFromAgencyAuthentication(final String fromAgencyAuthentication) {
        this.fromAgencyAuthentication = fromAgencyAuthentication;
    }

    public OnBehalfOfAgency getOnBehalfOfAgency() {
        return onBehalfOfAgency;
    }

    public void setOnBehalfOfAgency(final OnBehalfOfAgency onBehalfOfAgency) {
        this.onBehalfOfAgency = onBehalfOfAgency;
    }

    /**
     * To Agency Id
     */

    protected ToAgencyId toAgencyId;
    /**
     * From System Authentication
     */
    protected String fromSystemAuthentication;
    /**
     * From System Id
     */
    protected FromSystemId fromSystemId;
    /**
     * From Agency Authentication
     */
    protected String fromAgencyAuthentication;
    /**
     * From Agency Id
     */
    protected FromAgencyId fromAgencyId;
    /**
     * On-behalf-of Agency Id
     */
    protected OnBehalfOfAgency onBehalfOfAgency;

    /**
     * Retrieve the to agency id
     *
     * @return the to agency id
     */
    public ToAgencyId getToAgencyId() {
        return toAgencyId;
    }

    /**
     * Set the id of the agency that this data should be sent to
     *
     * @param toAgencyId the "to" agency id
     */
    public void setToAgencyId(final ToAgencyId toAgencyId) {
        this.toAgencyId = toAgencyId;
    }

    /**
     * Retrieve the from agency id
     *
     * @return the "from" agency id
     */
    public FromAgencyId getFromAgencyId() {
        return fromAgencyId;
    }

    /**
     * Set the id of the agency that this data is coming from
     *
     * @param fromAgencyId the "from" agency id
     */
    public void setFromAgencyId(final FromAgencyId fromAgencyId) {
        this.fromAgencyId = fromAgencyId;
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
        final InitiationHeader rhs = (InitiationHeader) obj;
        return new EqualsBuilder().append(applicationProfileType, rhs.applicationProfileType).append(toSystemId, rhs.toSystemId).append(toAgencyId, rhs.toAgencyId)
            .append(fromSystemAuthentication, rhs.fromSystemAuthentication).append(fromSystemId, rhs.fromSystemId).append(fromAgencyAuthentication, rhs.fromAgencyAuthentication)
            .append(fromAgencyId, rhs.fromAgencyId).append(onBehalfOfAgency, rhs.onBehalfOfAgency).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2142045089, 1984605911).append(applicationProfileType).append(toSystemId).append(toAgencyId).append(fromSystemAuthentication)
            .append(fromSystemId).append(fromAgencyAuthentication).append(fromAgencyId).append(onBehalfOfAgency).toHashCode();
        return result;
    }
}
