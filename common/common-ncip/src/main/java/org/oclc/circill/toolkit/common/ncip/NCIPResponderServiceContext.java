/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.common.base.ServletRequestAware;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

import javax.servlet.ServletRequest;

/**
 * An extension of {@link NCIPServiceContext} for responders, adding {@link ServletRequestAware}.
 */
public class NCIPResponderServiceContext extends NCIPServiceContext implements ServletRequestAware {

    protected ServletRequest servletRequest;

    @Override
    public ServletRequest getServletRequest() {
        return servletRequest;
    }

    @Override
    public void setServletRequest(final ServletRequest servletRequest) {
        this.servletRequest = servletRequest;
        for (final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext : serviceContexts) {
            if (serviceContext instanceof ServletRequestAware) {
                ((ServletRequestAware) serviceContext).setServletRequest(servletRequest);
            }
        }
    }
}
