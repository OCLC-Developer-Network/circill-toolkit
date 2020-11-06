/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ValidationException;

/**
 * The Request service.
 */
public interface RequestService extends ISO18626Service<RequestData, RequestConfirmationData> {
    @Override
    RequestConfirmationData performService(RequestData initiationData,
        ServiceContext<ISO18626Message<RequestData, RequestConfirmationData>, RequestData, RequestConfirmationData> serviceContext, RemoteServiceManager serviceManager)
        throws ServiceException, ValidationException;
}
