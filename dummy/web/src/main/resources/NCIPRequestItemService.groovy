/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

import org.oclc.circill.toolkit.dummy.ConfigurableServiceHandler
import org.oclc.circill.toolkit.service.base.ServiceInitiationData
import org.oclc.circill.toolkit.service.base.ServiceResponseData
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData
import org.oclc.circill.toolkit.service.ncip.RequestItemResponseData
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader
import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader

class NCIPRequestItemService implements ConfigurableServiceHandler {
    boolean canHandle(ServiceInitiationData initiationData) {
        return initiationData instanceof RequestItemInitiationData
    }
    ServiceResponseData handle(ServiceInitiationData initiationData) {
        RequestItemInitiationData requestItemInitiationData = (RequestItemInitiationData) initiationData
        InitiationHeader initiationHeader = requestItemInitiationData.getInitiationHeader()
        RequestItemResponseData response = new RequestItemResponseData()
        ResponseHeader responseHeader = new ResponseHeader()
        responseHeader.setFromAgencyId(initiationHeader.getFromAgencyId())
        responseHeader.setToAgencyId(initiationHeader.getToAgencyId())
        response.setResponseHeader(responseHeader)
        response.setItemId(requestItemInitiationData.getItemId())
        response.setUserId(requestItemInitiationData.getUserId())
        response.setRequestType(requestItemInitiationData.getRequestType())
        response.setRequestScopeType(requestItemInitiationData.getRequestScopeType())
        return response
    }
}
