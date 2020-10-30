/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ReturnOfThis")
public final class RequestDataBuilder {

    private Header header;
    private BibliographicInfo bibliographicInfo;
    private PublicationInfo publicationInfo;
    private ServiceInfo serviceInfo;
    private List<SupplierInfo> supplierInfos = new ArrayList<>();
    private List<RequestedDeliveryInfo> requestedDeliveryInfos = new ArrayList<>();
    private RequestingAgencyInfo requestingAgencyInfo;
    private PatronInfo patronInfo;
    private BillingInfo billingInfo;

    /**
     * This utility class does not allow instances.
     */
    private RequestDataBuilder() {
    }

    /**
     * -
     * @return a builder for {@link RequestData}
     */
    public static RequestDataBuilder aRequestData() {
        final RequestDataBuilder builder = new RequestDataBuilder();
        return builder;
    }

    public RequestDataBuilder withHeader(final Header header) {
        this.header = header;
        return this;
    }

    public RequestDataBuilder withBibliographicInfo(final BibliographicInfo bibliographicInfo) {
        this.bibliographicInfo = bibliographicInfo;
        return this;
    }

    public RequestDataBuilder withPublicationInfo(final PublicationInfo publicationInfo) {
        this.publicationInfo = publicationInfo;
        return this;
    }

    public RequestDataBuilder withServiceInfo(final ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
        return this;
    }

    public RequestDataBuilder withSupplierInfos(final List<SupplierInfo> supplierInfos) {
        this.supplierInfos = supplierInfos;
        return this;
    }

    public RequestDataBuilder withRequestedDeliveryInfos(final List<RequestedDeliveryInfo> requestedDeliveryInfos) {
        this.requestedDeliveryInfos = requestedDeliveryInfos;
        return this;
    }

    public RequestDataBuilder withRequestingAgencyInfo(final RequestingAgencyInfo requestingAgencyInfo) {
        this.requestingAgencyInfo = requestingAgencyInfo;
        return this;
    }

    public RequestDataBuilder withPatronInfo(final PatronInfo patronInfo) {
        this.patronInfo = patronInfo;
        return this;
    }

    public RequestDataBuilder withBillingInfo(final BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
        return this;
    }

    public RequestData build() {
        final RequestData requestData = new RequestData();
        requestData.setHeader(header);
        requestData.setBibliographicInfo(bibliographicInfo);
        requestData.setPublicationInfo(publicationInfo);
        requestData.setServiceInfo(serviceInfo);
        requestData.setSupplierInfos(supplierInfos);
        requestData.setRequestedDeliveryInfos(requestedDeliveryInfos);
        requestData.setRequestingAgencyInfo(requestingAgencyInfo);
        requestData.setPatronInfo(patronInfo);
        requestData.setBillingInfo(billingInfo);
        return requestData;
    }

}

