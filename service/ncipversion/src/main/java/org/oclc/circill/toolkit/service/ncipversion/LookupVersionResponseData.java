/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncipversion;

import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the LookupAgencyResponse.
 */
public class LookupVersionResponseData implements ServiceResponseData, NCIPLookupVersionData {

    /**
     * ResponseHeader
     */
    protected ResponseHeader responseHeader;

    /**
     * Set ResponseHeader.
     * @param responseHeader the {@link ResponseHeader}
     */
    public void setResponseHeader(final ResponseHeader responseHeader) {

        this.responseHeader = responseHeader;

    }

    /**
     * Get ResponseHeader.
     * @return the {@link ResponseHeader}
     */
    public ResponseHeader getResponseHeader() {

        return responseHeader;

    }

    protected List<String> versionSupporteds;

    /**
     * Set VersionSupporteds.
     * @param versionSupporteds the list of supported versions
     */
    public void setVersionSupporteds(final List<String> versionSupporteds) {

        this.versionSupporteds = versionSupporteds;

    }

    /**
     * Get VersionSupporteds.
     * @return the list of supported verions
     */
    public List<String> getVersionSupporteds() {

        return versionSupporteds;

    }

    protected List<String> serviceSupporteds;

    /**
     * Set ServiceSupporteds.
     * @param serviceSupporteds the list of supported services
     */
    public void setServiceSupporteds(final List<String> serviceSupporteds) {

        this.serviceSupporteds = serviceSupporteds;

    }

    /**
     * Get ServiceSupporteds.
     * @return the list of supported services
     */
    public List<String> getServiceSupporteds() {

        return serviceSupporteds;

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
        final LookupVersionResponseData rhs = (LookupVersionResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(versionSupporteds, rhs.versionSupporteds)
            .append(serviceSupporteds, rhs.serviceSupporteds).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(607878689, 399114309).append(responseHeader).append(versionSupporteds).append(serviceSupporteds).toHashCode();
        return result;
    }
}
