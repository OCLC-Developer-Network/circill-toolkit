/*
 * Copyright (c) 2020 OCLC, Inc.
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

import javax.servlet.ServletRequest;

/**
 * An extension of the {@link BaseChainingMessageHandlerAwareServiceContext} that implements {@link ServletRequestAware}.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public class BaseChainingMessageHandlerAndServletRequestAwareServiceContext<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData>
    extends BaseChainingMessageHandlerAwareServiceContext<SM, ID, RD> implements ServletRequestAware {

    protected ServletRequest servletRequest;

    @Override
    public ServletRequest getServletRequest() {
        return servletRequest;
    }

    @Override
    public void setServletRequest(final ServletRequest servletRequest) {
        this.servletRequest = servletRequest;
        for (final ServiceContext<SM, ID, RD> serviceContext : serviceContexts) {
            if (serviceContext instanceof ServletRequestAware) {
                ((ServletRequestAware) serviceContext).setServletRequest(servletRequest);
            }
        }
    }
}
