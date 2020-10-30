/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding;

import org.oclc.circill.toolkit.common.base.ToolkitComponent;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import java.util.List;

/**
 * A factory to create {@link Marshaller}s and {@link Unmarshaller}s.
 */
public interface MarshallerFactory extends ToolkitComponent {
    /**
     * Get the {@link ToolkitComponent} name.
     * @return the name
     */
    @Override
    default String getComponentName() {
        return ToolkitComponent.MARSHALLER_FACTORY_COMPONENT_NAME;
    }

    Marshaller getMarshaller(ServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> serviceContext)
        throws ConfigurationException;

    Unmarshaller getUnmarshaller(ServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> serviceContext)
        throws ConfigurationException;

    Schema getSchema(List<String> schemaURLs);
}
