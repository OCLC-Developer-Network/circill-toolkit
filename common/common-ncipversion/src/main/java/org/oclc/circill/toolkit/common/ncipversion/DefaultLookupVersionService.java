/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncipversion;

import org.oclc.circill.toolkit.common.base.MessageHandler;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionInitiationData;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionResponseData;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionService;
import org.oclc.circill.toolkit.service.ncipversion.NCIPVersionMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a default implementation of the LookupVersion service which returns the version attribute
 * that the {@link ServiceContext} is configured for (along with the canonical version attribute if that differs).
 */
public class DefaultLookupVersionService implements LookupVersionService {

    @Override
    public LookupVersionResponseData performService(final LookupVersionInitiationData initData,
        final ServiceContext<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> serviceContext,
        final RemoteServiceManager serviceManager) throws ServiceException, ValidationException {

        final LookupVersionResponseData responseData = new LookupVersionResponseData();
        final ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setFromAgencyId(initData.getInitiationHeader().getFromAgencyId());
        responseHeader.setToAgencyId(initData.getInitiationHeader().getToAgencyId());
        responseData.setResponseHeader(responseHeader);

        final List<String> versionsSupported = new ArrayList<>();
        final NCIPVersionServiceContext ncipServiceContext = ((NCIPVersionServiceContext) serviceContext);

        responseData.setVersionSupporteds(versionsSupported);

        final MessageHandler<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> messageHandler
            = ncipServiceContext.getMessageHandler();
        if (messageHandler != null) {
            final List<String> servicesSupported = messageHandler.getSupportedServicesNames();
            responseData.setServiceSupporteds(servicesSupported);
        }

        return responseData;

    }
}
