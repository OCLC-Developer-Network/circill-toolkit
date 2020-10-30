/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;

import java.util.List;

/**
 * A handler for messages; accepts a {@link ServiceInitiationData} and {@link ServiceContext} and selects an appropriate {@link Service} implementation.
 * @param <SM> the {@link ServiceMessage} type
 * @param <ID> the {@link ServiceInitiationData} type
 * @param <RD> the {@link ServiceResponseData} type
 */
public interface MessageHandler<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> extends ToolkitComponent {

    /**
     * Get the {@link ToolkitComponent} name.
     * @return the name
     */
    @Override
    default String getComponentName() {
        return ToolkitComponent.MESSAGE_HANDLER_COMPONENT_NAME;
    }

    /**
     * Select and perform the appropriate {@link Service} for the provided {@link ServiceInitiationData} and {@link ServiceContext}.
     * @param initiationData the {@link ServiceInitiationData}
     * @param serviceContext the {@link ServiceContext}
     * @return the {@link ServiceResponseData}
     * @throws ServiceException if the service fails
     * @throws ValidationException if the initiation or response object is invalid
     * @throws ToolkitInternalException if an unexpected error occurs
     * @throws ConfigurationException if the Toolkit is not configured for this
     */
    RD performService(ID initiationData, ServiceContext<SM, ID, RD> serviceContext) throws ServiceException, ValidationException, ToolkitInternalException, ConfigurationException;

    /**
     * Return the list of service names which this handler supports.
     * @return the names
     */
    List<String> getSupportedServicesNames();
}
