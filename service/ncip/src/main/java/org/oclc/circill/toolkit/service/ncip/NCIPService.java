/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ValidationException;

/**
 * Defines the interface of any service which performs an NCIP service.
 * Through this interface applications can create instances of NCIPInitiationData and NCIPResponseData
 * appropriate to the service, and perform the service.
 *
 * @param <ID> the {@link ServiceInitiationData} type
 * @param <RD> the {@link ServiceResponseData} type
 */
@FunctionalInterface
public interface NCIPService<ID extends NCIPInitiationData, RD extends NCIPResponseData> extends Service<NCIPMessage<ID, RD>, ID, RD> {

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
    @Override
    RD performService(ID initiationData, ServiceContext<NCIPMessage<ID, RD>, ID, RD> serviceContext, RemoteServiceManager serviceManager)
        throws ServiceException, ValidationException;

}
