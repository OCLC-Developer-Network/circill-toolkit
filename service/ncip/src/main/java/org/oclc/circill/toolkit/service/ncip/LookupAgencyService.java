/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ValidationException;

/**
 * Defines the interface for the NCIP Lookup Agency service.
 */
public interface LookupAgencyService extends NCIPService<LookupAgencyInitiationData, LookupAgencyResponseData> {

    @Override
    LookupAgencyResponseData performService(LookupAgencyInitiationData initData,
        ServiceContext<NCIPMessage<LookupAgencyInitiationData, LookupAgencyResponseData>, LookupAgencyInitiationData, LookupAgencyResponseData> serviceContext,
        RemoteServiceManager serviceManager) throws ServiceException, ValidationException;

}
