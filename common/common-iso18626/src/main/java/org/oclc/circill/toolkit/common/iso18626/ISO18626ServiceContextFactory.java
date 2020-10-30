/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.iso18626;

import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by bodfishj on 2/21/18.
 */
public class ISO18626ServiceContextFactory
    implements ServiceContextFactory<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>, ApplicationContextAware {

    /** The {@link ApplicationContext} from which to get the {@link ServiceContext} bean. */
    protected ApplicationContext applicationContext;
    /** The {@link ServiceContext} bean's name. */
    protected final String serviceContextBeanName;

    /**
     * Construct an instance with the provided service context bean name.
     * @param serviceContextBeanName the name of the {@link ServiceContext} bean
     */
    public ISO18626ServiceContextFactory(final String serviceContextBeanName) {
        this.serviceContextBeanName = serviceContextBeanName;
    }

    @Override
    public ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> getInitialServiceContext()
        throws ConfigurationException {
        final ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> result
            = (ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>) applicationContext
            .getBean(serviceContextBeanName);
        return result;
    }

    public String getServiceContextBeanName() {
        return serviceContextBeanName;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
