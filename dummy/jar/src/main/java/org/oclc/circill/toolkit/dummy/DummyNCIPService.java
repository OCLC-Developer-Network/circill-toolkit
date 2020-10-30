/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;

import java.lang.reflect.InvocationTargetException;

/**
 * And NCIP service that responds without problems to any NCIP service.
 */
public class DummyNCIPService  implements Service<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> {

    @Override
    public NCIPResponseData performService(final NCIPInitiationData initiationData,
        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext, final RemoteServiceManager serviceManager)
        throws ServiceException, ValidationException {

        final String serviceName = initiationData.getServiceName();
        final String responseDataClassName = NCIPResponseData.class.getPackage().getName() + "." + serviceName + "ResponseData";
        try {
            final Class<NCIPResponseData> responseDataClass = (Class<NCIPResponseData>) Class.forName(responseDataClassName);
            final NCIPResponseData responseData = responseDataClass.getConstructor().newInstance();
            final ResponseHeader responseHeader = new ResponseHeader();
            responseHeader.setFromAgencyId(initiationData.getInitiationHeader().getFromAgencyId());
            responseHeader.setToAgencyId(initiationData.getInitiationHeader().getToAgencyId());
            ReflectionHelper.setField(responseData, responseHeader, "ResponseHeader");

            // The logic below is not known to work for *all* NCIP initiation/response pairs.
            setFieldIfPresent(initiationData, responseData, "RequestId");
            setFieldIfPresent(initiationData, responseData, "ItemId");
            setFieldIfPresent(initiationData, responseData, "UserId");
            setFieldIfPresent(initiationData, responseData, "RequestType");
            setFieldIfPresent(initiationData, responseData, "RequestScopeType");
            return responseData;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | ToolkitInternalException e) {
            throw new ServiceException("Could not construct a response object for class name '" + responseDataClassName + "'.", e);
        }
    }

    /**
     * If the named field is present in the initiation data, copy it to the response data.
     * @param initiationData an {@link NCIPInitiationData} object
     * @param responseData an {@link NCIPResponseData} object
     * @param fieldName the name of the field
     * @throws ToolkitInternalException if an unexpected error occurs
     */
    private void setFieldIfPresent(final NCIPInitiationData initiationData, final NCIPResponseData responseData, final String fieldName) throws ToolkitInternalException {
        final Object value = ReflectionHelper.getSimpleField(initiationData, fieldName);
        if (value != null) {
            ReflectionHelper.setField(responseData, value, fieldName);
        }

    }
}
