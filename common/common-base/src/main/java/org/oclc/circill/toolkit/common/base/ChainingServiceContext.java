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

import java.util.List;

/**
 * Objects supporting this interface can chain validation through multiple {@link ServiceContext}s.
 * Note: Because chained ServiceContexts might implement any number of interfaces, rather than directly
 * implementing this interface you should probably extend
 * {@link BaseChainingServiceContext}; because when an interface
 * appropriate to ServiceContexts is added to the Toolkit a default implementation of its methods
 * will be added to that base class and your class will at least get that implementation. (Otherwise
 * your class won't know to declare that interface and its methods won't be called on your chained service contexts.
 *
 * @param <SM> the {@link ServiceMessage} type
 * @param <ID> the {@link ServiceInitiationData} type
 * @param <RD> the {@link ServiceResponseData} type
 */
public interface ChainingServiceContext<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> extends ServiceContext<SM, ID, RD> {
    List<ServiceContext<SM, ID, RD>> getServiceContexts();

    void setServiceContexts(List<ServiceContext<SM, ID, RD>> serviceContexts);

    /**
     * Append the provided {@link ServiceContext} to this chain of service contexts.
     * @param serviceContext the {@link ServiceContext}
     */
    void appendServiceContext(ServiceContext<SM, ID, RD> serviceContext);
}
