/*
 * Copyright (c) 2017 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;

/**
 * A {@link ServiceContextFactory} that can be configured with an instance of a {@link ServiceContext}
 * and will return that instance.
 * Note: Do <em>not</em> use this validator with ServiceContexts that have request-specific state, e.g.
 * ones that implement {@link ServletRequestAware}, as this will cause failures due to multi-threaded request handling.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public class SingletonServiceContextFactory<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData>
    implements ServiceContextFactory<SM, ID, RD> {

    private ServiceContext<SM, ID, RD> serviceContext;

    public void setServiceContext(final ServiceContext<SM, ID, RD> serviceContext) throws ConfigurationException {
        if (serviceContext == null) {
            throw new ConfigurationException("ServiceContext must not be null.");
        }
        if (serviceContext instanceof ServletRequestAware) {
            throw new ConfigurationException("ServiceContext must not implement ServletRequestAware due to threading issues - see Javadoc on this class.");
        }
        this.serviceContext = serviceContext;
    }

    @Override
    public ServiceContext<SM, ID, RD> getInitialServiceContext() throws ConfigurationException {
        if (serviceContext == null) {
            throw new ConfigurationException("ServiceContext not set.");
        }
        return serviceContext;
    }

}
