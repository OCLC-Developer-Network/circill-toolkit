/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.servicemanager;

import org.oclc.circill.toolkit.service.iso18626.Header;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;
import org.oclc.circill.toolkit.service.iso18626.RequestData;
import org.oclc.circill.toolkit.service.iso18626.RequestingAgencyMessageData;

import java.util.HashMap;
import java.util.Map;

/**
 * Generator a configurable HTTP header with a value based on the agency ids of the sender &amp; receiver of the message. For Request and RequestingAgencyMessage
 * the sender is the requesting agency; for SupplyingAgencyMessage it is the supplying agency.
 */
public class Iso18626AgencyRelationshipHeaderGenerator implements HeaderGenerator<ISO18626RequestData> {

    /** The default header name. */
    public static final String DEFAULT_HEADER_NAME = "Authentication";
    /** The header name. */
    private String headerName = DEFAULT_HEADER_NAME;

    /**
     * A two-dimensional table associating the agency sending the message and the agency receiving the message.
     * <table border="1" summary="Example of the valueMap">
     *     <tr><td>&nbsp;</td><td>Agency A</td><td>Agency B</td><td>Agency C</td></tr>
     *     <tr><td>Agency A sends to:</td><td style="text-align:center">Key AA</td><td style="text-align:center">Key AB</td><td style="text-align:center">Key AC</td></tr>
     *     <tr><td>Agency B sends to:</td><td style="text-align:center">Key BA</td><td style="text-align:center">Key BB</td><td style="text-align:center">Key BC</td></tr>
     *     <tr><td>Agency C sends to:</td><td style="text-align:center">Key CA</td><td style="text-align:center">Key CB</td><td style="text-align:center">Key CC</td></tr>
     * </table>
     * So for example a Request message with RequestAgencyId of A and SupplyingAgencyId of B would have a header value of "Key AB"
     * and a SupplyingAgencyMessage with RequestAgencyId for A and SupplyingAgencyId of B would have a header value of "Key BA".
     */
    private Map<String, Map<String, String>> valueMap;

    /**
     * Construct an instance with the provided value map.
     * @param valueMap the {@link #valueMap}
     */
    public Iso18626AgencyRelationshipHeaderGenerator(final Map<String, Map<String, String>> valueMap) {
        this.valueMap = new HashMap<>(valueMap);
    }

    /**
     * Looks up the header value in the {@link #valueMap} - see comment there for the lookup logic.
     * If an entry is absent, a header will not be generated.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> generateHeaders(final ISO18626RequestData initiationData) {
        final Map<String, String> headerMap = new HashMap<>();
        final Header header = initiationData.getHeader();
        if (header != null) {
            final String requestingAgencyId = header.getRequestingAgencyId() != null ? header.getRequestingAgencyId().getAgencyIdValue() : null;
            final String supplyingAgencyId = header.getSupplyingAgencyId() != null ? header.getSupplyingAgencyId().getAgencyIdValue() : null;
            String headerValue = null;
            if (initiationData instanceof RequestData || initiationData instanceof RequestingAgencyMessageData) {
                headerValue = valueMap.get(requestingAgencyId) != null ? valueMap.get(requestingAgencyId).get(supplyingAgencyId) : null;
            } else {
                headerValue = valueMap.get(supplyingAgencyId) != null ? valueMap.get(supplyingAgencyId).get(requestingAgencyId) : null;
            }
            if (headerValue != null) {
                headerMap.put(headerName, headerValue);
            }
        }
        return headerMap;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(final String headerName) {
        this.headerName = headerName;
    }

    public Map<String, Map<String, String>> getValueMap() {
        return new HashMap<>(valueMap);
    }

    public void setValueMap(final Map<String, Map<String, String>> valueMap) {
        this.valueMap = new HashMap<>(valueMap);
    }

}
