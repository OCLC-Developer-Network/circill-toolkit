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

public interface ItemRequestUpdatedService extends NCIPService<ItemRequestUpdatedInitiationData, ItemRequestUpdatedResponseData> {

    @Override
    ItemRequestUpdatedResponseData performService(ItemRequestUpdatedInitiationData initData,
        ServiceContext<NCIPMessage<ItemRequestUpdatedInitiationData, ItemRequestUpdatedResponseData>,
            ItemRequestUpdatedInitiationData, ItemRequestUpdatedResponseData> serviceContext,
        RemoteServiceManager serviceManager) throws ServiceException, ValidationException;

}
