/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings("ReturnOfThis")
public final class ServiceInfoBuilder {

    private RequestType requestType;
    private List<RequestSubType> requestSubTypes = new ArrayList<>();
    private String requestingAgencyPreviousRequestId;
    private ServiceType serviceType;
    private ServiceLevelType serviceLevel;
    private PreferredFormatType preferredFormat;
    private Calendar needBeforeDate;
    private CopyrightComplianceType copyrightCompliance;
    private YesNoType anyEdition;
    private Calendar startDate;
    private Calendar endDate;
    private String note;

    /**
     * This utility class does not allow instances.
     */
    private ServiceInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link ServiceInfo}
     */
    public static ServiceInfoBuilder aServiceInfo() {
        final ServiceInfoBuilder builder = new ServiceInfoBuilder();
        return builder;
    }

    public ServiceInfoBuilder withRequestType(final RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    public ServiceInfoBuilder withRequestSubTypes(final List<RequestSubType> requestSubTypes) {
        this.requestSubTypes = requestSubTypes;
        return this;
    }

    public ServiceInfoBuilder withRequestingAgencyPreviousRequestId(final String requestingAgencyPreviousRequestId) {
        this.requestingAgencyPreviousRequestId = requestingAgencyPreviousRequestId;
        return this;
    }

    public ServiceInfoBuilder withServiceType(final ServiceType serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public ServiceInfoBuilder withServiceLevel(final ServiceLevelType serviceLevel) {
        this.serviceLevel = serviceLevel;
        return this;
    }

    public ServiceInfoBuilder withPreferredFormat(final PreferredFormatType preferredFormat) {
        this.preferredFormat = preferredFormat;
        return this;
    }

    public ServiceInfoBuilder withNeedBeforeDate(final Calendar needBeforeDate) {
        this.needBeforeDate = needBeforeDate;
        return this;
    }

    public ServiceInfoBuilder withCopyrightCompliance(final CopyrightComplianceType copyrightCompliance) {
        this.copyrightCompliance = copyrightCompliance;
        return this;
    }

    public ServiceInfoBuilder withAnyEdition(final YesNoType anyEdition) {
        this.anyEdition = anyEdition;
        return this;
    }

    public ServiceInfoBuilder withStartDate(final Calendar startDate) {
        this.startDate = startDate;
        return this;
    }

    public ServiceInfoBuilder withEndDate(final Calendar endDate) {
        this.endDate = endDate;
        return this;
    }

    public ServiceInfoBuilder withNote(final String note) {
        this.note = note;
        return this;
    }

    public ServiceInfo build() {
        final ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.setRequestType(requestType);
        serviceInfo.setRequestSubTypes(requestSubTypes);
        serviceInfo.setRequestingAgencyPreviousRequestId(requestingAgencyPreviousRequestId);
        serviceInfo.setServiceType(serviceType);
        serviceInfo.setServiceLevel(serviceLevel);
        serviceInfo.setPreferredFormat(preferredFormat);
        serviceInfo.setNeedBeforeDate(needBeforeDate);
        serviceInfo.setCopyrightCompliance(copyrightCompliance);
        serviceInfo.setAnyEdition(anyEdition);
        serviceInfo.setStartDate(startDate);
        serviceInfo.setEndDate(endDate);
        serviceInfo.setNote(note);
        return serviceInfo;
    }

}

