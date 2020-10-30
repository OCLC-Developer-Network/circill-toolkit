/*
 * Copyright (c) 2014 eXtensible Catalog Organization.
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

public interface ItemUpdatedService extends NCIPService<ItemUpdatedInitiationData, ItemUpdatedResponseData> {

    @Override
    ItemUpdatedResponseData performService(ItemUpdatedInitiationData initData,
        ServiceContext<NCIPMessage<ItemUpdatedInitiationData, ItemUpdatedResponseData>, ItemUpdatedInitiationData, ItemUpdatedResponseData> serviceContext,
        RemoteServiceManager serviceManager) throws ServiceException, ValidationException;

}
