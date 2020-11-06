/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Information about the requested service.
 */
public class ServiceInfo {

    protected RequestType requestType;
    protected List<RequestSubType> requestSubTypes = new ArrayList<>();
    protected String requestingAgencyPreviousRequestId;
    protected ServiceType serviceType;
    protected ServiceLevelType serviceLevel;
    protected PreferredFormatType preferredFormat;
    protected Calendar needBeforeDate;
    protected CopyrightComplianceType copyrightCompliance;
    protected YesNoType anyEdition;
    protected Calendar startDate;
    protected Calendar endDate;
    protected String note;

    private static final int REQUESTSUBTYPE_MAX_OCCURS = 3;

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(final Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(final Calendar endDate) {
        this.endDate = endDate;
    }

    public List<RequestSubType> getRequestSubTypes() {
        return requestSubTypes;
    }

    public RequestSubType getRequestSubType() {
        return requestSubTypes != null ? (requestSubTypes.size() > 0 ? requestSubTypes.get(requestSubTypes.size() - 1) : null) : null;
    }

    public RequestSubType getRequestSubType(final int index) {
        final int indexToUse;
        if (index > (REQUESTSUBTYPE_MAX_OCCURS - 1)) { // TODO verify that truncating to last legal index of list is preferred behavior
            indexToUse = REQUESTSUBTYPE_MAX_OCCURS - 1;
        } else {
            indexToUse = index;
        }
        return requestSubTypes != null ? (requestSubTypes.size() > 0 ? requestSubTypes.get(indexToUse) : null) : null;
    }

    public void setRequestSubTypes(final List<RequestSubType> requestSubTypes) {
        if (requestSubTypes != null && requestSubTypes.size() > REQUESTSUBTYPE_MAX_OCCURS) {
            this.requestSubTypes = requestSubTypes.subList(0, REQUESTSUBTYPE_MAX_OCCURS);
        } else {
            this.requestSubTypes = requestSubTypes;
        }
    }

    public void setRequestSubType(final int index, final RequestSubType requestSubType) {
        final int indexToUse;
        if (index > (REQUESTSUBTYPE_MAX_OCCURS - 1)) { // TODO verify that truncating to last legal index of list is preferred behavior
            indexToUse = REQUESTSUBTYPE_MAX_OCCURS - 1;
        } else {
            indexToUse = index;
        }
        requestSubTypes.set(indexToUse, requestSubType);
    }

    public void setRequestSubType(final RequestSubType requestSubType) {
        if (this.requestSubTypes != null) {
            this.requestSubTypes.clear();
        }
        if (requestSubType != null) {
            if (this.requestSubTypes == null) {
                this.requestSubTypes = new ArrayList<>();
            }
            this.requestSubTypes.add(requestSubType);
        } else {
            this.requestSubTypes = null;
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public YesNoType getAnyEdition() {

        return anyEdition;
    }

    public void setAnyEdition(final YesNoType anyEdition) {
        this.anyEdition = anyEdition;
    }

    public CopyrightComplianceType getCopyrightCompliance() {

        return copyrightCompliance;
    }

    public void setCopyrightCompliance(final CopyrightComplianceType copyrightCompliance) {
        this.copyrightCompliance = copyrightCompliance;
    }

    public Calendar getNeedBeforeDate() {

        return needBeforeDate;
    }

    public void setNeedBeforeDate(final Calendar needBeforeDate) {
        this.needBeforeDate = needBeforeDate;
    }

    public PreferredFormatType getPreferredFormat() {

        return preferredFormat;
    }

    public void setPreferredFormat(final PreferredFormatType preferredFormat) {
        this.preferredFormat = preferredFormat;
    }

    public ServiceLevelType getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(final ServiceLevelType serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(final RequestType requestType) {
        this.requestType = requestType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(final ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getRequestingAgencyPreviousRequestId() {

        return requestingAgencyPreviousRequestId;
    }

    public void setRequestingAgencyPreviousRequestId(final String requestingAgencyPreviousRequestId) {
        this.requestingAgencyPreviousRequestId = requestingAgencyPreviousRequestId;
    }

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
        final ServiceInfo rhs = (ServiceInfo) obj;
        final boolean result = new EqualsBuilder().append(requestType, rhs.requestType).append(requestSubTypes, rhs.requestSubTypes)
            .append(requestingAgencyPreviousRequestId, rhs.requestingAgencyPreviousRequestId).append(serviceType, rhs.serviceType).append(serviceLevel, rhs.serviceLevel)
            .append(preferredFormat, rhs.preferredFormat).append(needBeforeDate, rhs.needBeforeDate).append(copyrightCompliance, rhs.copyrightCompliance)
            .append(anyEdition, rhs.anyEdition).append(startDate, rhs.startDate).append(endDate, rhs.endDate).append(note, rhs.note).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1419050481, 1919135583).append(requestType).append(requestSubTypes).append(requestingAgencyPreviousRequestId).append(serviceType)
            .append(serviceLevel).append(preferredFormat).append(needBeforeDate).append(copyrightCompliance).append(anyEdition).append(startDate).append(endDate).append(note)
            .toHashCode();
        return result;
    }
}
