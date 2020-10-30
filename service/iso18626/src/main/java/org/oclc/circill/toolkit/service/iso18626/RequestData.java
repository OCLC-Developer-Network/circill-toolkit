/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 */
public class RequestData implements ISO18626RequestData {
    /**
     * Header
     */
    protected Header header;
    /**
     * BibliographicInfo
     */
    protected BibliographicInfo bibliographicInfo;
    /**
     * PublicationInfo
     */
    protected PublicationInfo publicationInfo;
    /**
     * ServiceInfo
     */
    protected ServiceInfo serviceInfo;
    /**
     * SupplierInfo
     */
    protected List<SupplierInfo> supplierInfos = new ArrayList<>();
    /**
     * RequestedDeliveryInfo
     */
    protected List<RequestedDeliveryInfo> requestedDeliveryInfos = new ArrayList<>();
    /**
     * RequestingAgencyInfo
     */
    protected RequestingAgencyInfo requestingAgencyInfo;
    /**
     * PatronInfo
     */
    protected PatronInfo patronInfo;
    /**
     * BillingInfo
     */
    protected BillingInfo billingInfo;

    /**
     * Get the header.
     *
     * @return the header
     */
    @Override
    public Header getHeader() {
        return header;
    }

    /**
     * Set the header.
     *
     * @param header the header
     */
    @Override
    public void setHeader(final Header header) {
        this.header = header;
    }

    /**
     * Get the BibliographicInfo.
     *
     * @return the bibliographicInfo
     */
    public BibliographicInfo getBibliographicInfo() {
        return bibliographicInfo;
    }

    /**
     * Set the BibliographicInfo.
     *
     * @param bibliographicInfo the bibliographicInfo
     */
    public void setBibliographicInfo(final BibliographicInfo bibliographicInfo) {
        this.bibliographicInfo = bibliographicInfo;
    }

    /**
     * Get the PublicationInfo.
     *
     * @return the publicationInfo
     */
    public PublicationInfo getPublicationInfo() {
        return publicationInfo;
    }

    /**
     * Set the PublicationInfo.
     *
     * @param publicationInfo the publicationInfo
     */
    public void setPublicationInfo(final PublicationInfo publicationInfo) {
        this.publicationInfo = publicationInfo;
    }

    /**
     * Get the ServiceInfo.
     *
     * @return the serviceInfo
     */
    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    /**
     * Set the ServiceInfo.
     *
     * @param serviceInfo the serviceInfo
     */
    public void setServiceInfo(final ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    /**
     * Get the list of SupplierInfos.
     *
     * @return the supplierInfos
     */
    public List<SupplierInfo> getSupplierInfos() {
        return supplierInfos;
    }

    /**
     * Get the most-recently added SupplierInfo.
     *
     * @return the supplierInfo
     */
    public SupplierInfo getSupplierInfo() {
        return supplierInfos != null ? (!supplierInfos.isEmpty() ? supplierInfos.get(supplierInfos.size() - 1) : null) : null;
    }

    /**
     * Get the SupplierInfo at the supplied index.
     * @param index the index
     * @return the supplierInfo
     */
    public SupplierInfo getSupplierInfo(final int index) {
        return supplierInfos != null ? (!supplierInfos.isEmpty() ? supplierInfos.get(index) : null) : null;
    }

    /**
     * Set the SupplierInfos.
     *
     * @param supplierInfos the list of supplierInfos
     */
    public void setSupplierInfos(final List<SupplierInfo> supplierInfos) {
        this.supplierInfos = supplierInfos;
    }

    /**
     * Add a SupplierInfo.
     *
     * @param index position in the list to add the info
     * @param supplierInfo the supplierInfo
     */
    public void setSupplierInfo(final int index, final SupplierInfo supplierInfo) {
        supplierInfos.set(index, supplierInfo);
    }

    /**
     * Add a SupplierInfo.
     *
     * @param supplierInfo the supplierInfo
     */
    public void setSupplierInfo(final SupplierInfo supplierInfo) {
        if (this.supplierInfos != null) {
            this.supplierInfos.clear();
        }
        if (supplierInfo != null) {
            if (this.supplierInfos == null) {
                this.supplierInfos = new ArrayList<>();
            }
            this.supplierInfos.add(supplierInfo);
        } else {
            this.supplierInfos = null;
        }
    }

    /**
     * Get the list of RequestedDeliveryInfos.
     *
     * @return the requestedDeliveryInfos
     */
    public List<RequestedDeliveryInfo> getRequestedDeliveryInfos() {
        return requestedDeliveryInfos;
    }

    /**
     * Get the most-recently added RequestedDeliveryInfo.
     *
     * @return the requestedDeliveryInfo
     */
    public RequestedDeliveryInfo getRequestedDeliveryInfo() {
        return requestedDeliveryInfos != null ? (!requestedDeliveryInfos.isEmpty() ? requestedDeliveryInfos.get(requestedDeliveryInfos.size() - 1) : null) : null;
    }

    /**
     * Get the RequestedDeliveryInfo at the supplied index.
     * @param index the index
     * @return the requestedDeliveryInfo
     */
    public RequestedDeliveryInfo getRequestedDeliveryInfo(final int index) {
        return requestedDeliveryInfos != null ? (!requestedDeliveryInfos.isEmpty() ? requestedDeliveryInfos.get(index) : null) : null;
    }

    /**
     * Set the RequestedDeliveryInfos.
     *
     * @param requestedDeliveryInfos the list of requestedDeliveryInfos
     */
    public void setRequestedDeliveryInfos(final List<RequestedDeliveryInfo> requestedDeliveryInfos) {
        this.requestedDeliveryInfos = requestedDeliveryInfos;
    }

    /**
     * Add a RequestedDeliveryInfo.
     *
     * @param index the poisition in the list to add the info
     * @param requestedDeliveryInfo the requestedDeliveryInfo
     */
    public void setRequestedDeliveryInfo(final int index, final RequestedDeliveryInfo requestedDeliveryInfo) {
        requestedDeliveryInfos.set(index, requestedDeliveryInfo);
    }

    /**
     * Add a RequestedDeliveryInfo.
     *
     * @param requestedDeliveryInfo the requestedDeliveryInfo
     */
    public void setRequestedDeliveryInfo(final RequestedDeliveryInfo requestedDeliveryInfo) {
        if (this.requestedDeliveryInfos != null) {
            this.requestedDeliveryInfos.clear();
        }
        if (requestedDeliveryInfo != null) {
            if (this.requestedDeliveryInfos == null) {
                this.requestedDeliveryInfos = new ArrayList<>();
            }
            this.requestedDeliveryInfos.add(requestedDeliveryInfo);
        } else {
            this.requestedDeliveryInfos = null;
        }
    }

    /**
     * Get the RequestingAgencyInfo.
     *
     * @return the requestingAgencyInfo
     */
    public RequestingAgencyInfo getRequestingAgencyInfo() {
        return requestingAgencyInfo;
    }

    /**
     * Set the RequestingAgencyInfo.
     *
     * @param requestingAgencyInfo the requestingAgencyInfo
     */
    public void setRequestingAgencyInfo(final RequestingAgencyInfo requestingAgencyInfo) {
        this.requestingAgencyInfo = requestingAgencyInfo;
    }

    /**
     * Get the PatronInfo.
     *
     * @return the patronInfo
     */
    public PatronInfo getPatronInfo() {
        return patronInfo;
    }

    /**
     * Set the PatronInfo.
     *
     * @param patronInfo the patronInfo
     */
    public void setPatronInfo(final PatronInfo patronInfo) {
        this.patronInfo = patronInfo;
    }

    /**
     * Get the BillingInfo.
     *
     * @return the billingInfo
     */
    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    /**
     * Set the BillingInfo.
     *
     * @param billingInfo the billingInfo
     */
    public void setBillingInfo(final BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
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
        final RequestData rhs = (RequestData) obj;
        return new EqualsBuilder().append(header, rhs.header).append(bibliographicInfo, rhs.bibliographicInfo)
            .append(publicationInfo, rhs.publicationInfo).append(serviceInfo, rhs.serviceInfo).append(supplierInfos, rhs.supplierInfos)
            .append(requestedDeliveryInfos, rhs.requestedDeliveryInfos).append(requestingAgencyInfo, rhs.requestingAgencyInfo).append(patronInfo, rhs.patronInfo)
            .append(billingInfo, rhs.billingInfo).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1129176801, 1289621735).append(header).append(bibliographicInfo).append(publicationInfo).append(serviceInfo)
            .append(supplierInfos).append(requestedDeliveryInfos).append(requestingAgencyInfo).append(patronInfo).append(billingInfo).toHashCode();
        return result;
    }
}
