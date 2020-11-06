/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * {@link ServiceContextFactory} for NCIP.
 */
public class NCIPServiceContextFactory
    implements ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData>, ApplicationContextAware {

    /** The {@link ApplicationContext} from which to get the {@link ServiceContext} bean. */
    protected ApplicationContext applicationContext;
    /** The {@link ServiceContext} bean's name. */
    protected final String serviceContextBeanName;

    /**
     * Construct an instance with the provided service context bean name.
     * @param serviceContextBeanName the name of the {@link ServiceContext} bean
     */
    public NCIPServiceContextFactory(final String serviceContextBeanName) {
        this.serviceContextBeanName = serviceContextBeanName;
    }

    @Override
    public ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> getInitialServiceContext() throws ConfigurationException {
        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> result
            = (ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData>) applicationContext.getBean(serviceContextBeanName);
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
