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
import org.oclc.circill.toolkit.service.ncip.LookupUserInitiationData
import org.oclc.circill.toolkit.service.ncip.LookupUserResponseData
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader
import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader

class NCIPLookupUserService implements ConfigurableServiceHandler {
    boolean canHandle(ServiceInitiationData initiationData) {
        return initiationData instanceof LookupUserInitiationData
    }
    ServiceResponseData handle(ServiceInitiationData initiationData) {
        LookupUserInitiationData lookupUserInitiationData = (LookupUserInitiationData) initiationData
        InitiationHeader initiationHeader = lookupUserInitiationData.getInitiationHeader()
        LookupUserResponseData response = new LookupUserResponseData()
        ResponseHeader responseHeader = new ResponseHeader()
        responseHeader.setFromAgencyId(initiationHeader.getFromAgencyId())
        responseHeader.setToAgencyId(initiationHeader.getToAgencyId())
        response.setResponseHeader(responseHeader)
        response.setUserId(lookupUserInitiationData.getUserId())
        return response
    }
}
