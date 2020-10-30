/*
 * Copyright (c) 2020 eXtensible Catalog Organization.
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
 * A factory for {@link }ServiceContext}s.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public interface ServiceContextFactory<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> extends ToolkitComponent {

    /**
     * Get the {@link ToolkitComponent} name.
     * @return the name
     */
    @Override
    default String getComponentName() {
        return ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME;
    }

    ServiceContext<SM, ID, RD> getInitialServiceContext() throws ConfigurationException;

}
