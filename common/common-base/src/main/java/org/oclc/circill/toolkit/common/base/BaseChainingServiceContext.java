/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ValidationException;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the {@link ChainingServiceContext}.
 * Note: When an interface is added to the Toolkit that is appropriate for a ServiceContext to implement, a default
 * implementation of its methods should be added to this class so that classes which extend this class
 * will gain this default implementation.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public class BaseChainingServiceContext<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData>
    implements ChainingServiceContext<SM, ID, RD> {

    protected List<ServiceContext<SM, ID, RD>> serviceContexts = new ArrayList<>(0);

    @Override
    public List<ServiceContext<SM, ID, RD>> getServiceContexts() {
        return serviceContexts;
    }

    @Override
    public void setServiceContexts(final List<ServiceContext<SM, ID, RD>> serviceContexts) {
        this.serviceContexts = serviceContexts;
    }

    @Override
    public void appendServiceContext(final ServiceContext<SM, ID, RD> serviceContext) {
        serviceContexts.add(serviceContext);
    }

    @Override
    public void validateBeforeMarshalling(final SM message) throws ValidationException {
        for (final ServiceContext<SM, ID, RD> serviceContext : serviceContexts) {
            serviceContext.validateBeforeMarshalling(message);
        }
    }

    @Override
    public void validateAfterUnmarshalling(final SM message) throws ValidationException {
        for (final ServiceContext<SM, ID, RD> serviceContext : serviceContexts) {
            serviceContext.validateAfterUnmarshalling(message);
        }
    }
}
