/*
 * Copyright (c) 2019 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * A service which is performed in response to a message.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
@FunctionalInterface
public interface Service<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> {

    default String getServiceName() {
        return getClass().getSimpleName().replace("Service", "");
    }

    /**
     * Process a request, returning the response.
     *
     * @param initiationData the {@link }ServiceInitiationData} for this invocation
     * @param serviceContext the {@link ServiceContext} for this invocation
     * @param serviceManager provides access to remote services
     * @return the ServiceResponseData
     * @throws ServiceException if the service fails
     * @throws ValidationException if the initiationData or the responseData is invalid
     */
    RD performService(ID initiationData, ServiceContext<SM, ID, RD> serviceContext, RemoteServiceManager serviceManager)
        throws ServiceException, ValidationException;

}
