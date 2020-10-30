/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ValidationException;

/**
 * An ISO 18626 message.
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public interface ISO18626Service<ID extends ISO18626RequestData, RD extends ISO18626ConfirmationData> extends Service<ISO18626Message<ID, RD>, ID, RD> {

    /**
     * Process an NCIP Request to formulate an NCIP Response.
     *
     * @param initiationData the {@link }NCIPInitiationData} for this invocation
     * @param serviceContext the {@link ServiceContext} for this invocation
     * @param serviceManager provides access to remote services
     * @return the NCIPResponseData
     * @throws ValidationException if the initiationData is invalid
     * @throws ServiceException if the service fails
     */
    RD performService(ID initiationData, ServiceContext<ISO18626Message<ID, RD>, ID, RD> serviceContext, RemoteServiceManager serviceManager)
        throws ServiceException, ValidationException;
}
