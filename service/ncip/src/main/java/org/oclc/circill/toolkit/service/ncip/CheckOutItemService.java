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
 * Defines the interface for the NCIP Check Out Item service.
 */
public interface CheckOutItemService extends NCIPService<CheckOutItemInitiationData, CheckOutItemResponseData> {

    @Override
    CheckOutItemResponseData performService(CheckOutItemInitiationData initData,
        ServiceContext<NCIPMessage<CheckOutItemInitiationData, CheckOutItemResponseData>, CheckOutItemInitiationData, CheckOutItemResponseData> serviceContext,
        RemoteServiceManager serviceManager) throws ServiceException, ValidationException;

}
