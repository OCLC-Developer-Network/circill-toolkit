/*
 * Copyright (c) 2013 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncipversion;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ValidationException;

/**
 * Defines the interface for the NCIP Lookup Agency service.
 */
public interface LookupVersionService
    extends Service<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> {

    /**
     * Process an NCIP Request to formulate an NCIP Response.
     *
     * @param initiationData the {@link LookupVersionInitiationData} for this invocation
     * @param serviceContext the {@link ServiceContext} for this invocation
     * @param serviceManager provides access to remote services
     * @return the LookupVersionResponseData
     * @throws ServiceException if the service fails
     */
    @Override
    LookupVersionResponseData performService(LookupVersionInitiationData initiationData,
        ServiceContext<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> serviceContext,
        RemoteServiceManager serviceManager) throws ServiceException, ValidationException;

}
