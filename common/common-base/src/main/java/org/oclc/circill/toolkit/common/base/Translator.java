/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * This class converts between Streams and {@link ServiceInitiationData} or {@link ServiceResponseData} objects.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public interface Translator<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> extends ToolkitComponent {

    /**
     * Get the {@link ToolkitComponent} name.
     * @return the name
     */
    @Override
    default String getComponentName() {
        return ToolkitComponent.TRANSLATOR_COMPONENT_NAME;
    }


    /**
     * Create a {@link ServiceMessage} object from an {@link InputStream}.
     * This method <em>must</em> call {@link ServiceContext#validateAfterUnmarshalling}.
     * Always pass the same instance of ServiceContext to the {@link Translator} for a given invocation of a service.
     * @param serviceContext the {@link ServiceContext} for this message
     * @param inputStream the {@link InputStream} to read
     * @return a subclass of {@link ServiceMessage} appropriate to the service implementation
     * @throws ConfigurationException if the Toolkit has not been configured correctly
     * @throws ServiceException if a runtime exception occurs
     * @throws ToolkitInternalException if there is an unexpected condition
     * @throws ValidationException if the serviceMessage is invalid
     */
    SM createMessage(ServiceContext<SM, ID, RD> serviceContext, InputStream inputStream)
        throws ConfigurationException, ServiceException, ToolkitInternalException, ValidationException;

    /**
     * Create an {@link ServiceInitiationData} object from an {@link InputStream}.
     * This method <em>must</em> call {@link ServiceContext#validateAfterUnmarshalling}.
     * Always pass the same instance of ServiceContext to the {@link Translator} for a given invocation of a service.
     * @param serviceContext the {@link ServiceContext} for this message
     * @param inputStream the {@link InputStream} to read
     * @return a subclass of {@link ServiceInitiationData} appropriate to the service implementation
     * @throws ConfigurationException if the Toolkit has not been configured correctly
     * @throws ServiceException if a runtime exception occurs
     * @throws ToolkitInternalException if there is an unexpected condition
     * @throws ValidationException if the initiationData is invalid
     */
    ID createInitiationData(ServiceContext<SM, ID, RD> serviceContext, InputStream inputStream)
        throws ConfigurationException, ServiceException, ToolkitInternalException, ValidationException;

    /**
     * Create an {@link ServiceInitiationData} object from an {@link InputStream}.
     * This method <em>must</em> call {@link ServiceContext#validateAfterUnmarshalling}.
     * Always pass the same instance of ServiceContext to the {@link Translator} for a given invocation of a service.
     * @param serviceContext the {@link ServiceContext} for this message
     * @param inputStream the {@link InputStream} to read
     * @return a subclass of {@link ServiceResponseData} appropriate to the service implementation
     * @throws ConfigurationException if the Toolkit has not been configured correctly
     * @throws ServiceException if a runtime exception occurs
     * @throws ToolkitInternalException if there is an unexpected condition
     * @throws ValidationException if the responseData is invalid
     */
    RD createResponseData(ServiceContext<SM, ID, RD> serviceContext, InputStream inputStream)
        throws ConfigurationException, ServiceException, ToolkitInternalException, ValidationException;

    /**
     * This method must call {@link ServiceContext#validateBeforeMarshalling}.
     * Always pass the same instance of ServiceContext to the {@link Translator} for a given invocation of a service.
     * @param serviceContext the {@link ServiceContext} to use while creating the stream
     * @param serviceMessage the {@link ServiceMessage} object to create the stream from
     * @return a {@link ByteArrayInputStream}
     * @throws ConfigurationException if the Toolkit has not been configured correctly
     * @throws ServiceException if a runtime exception occurs
     * @throws ToolkitInternalException if there is an unexpected condition
     * @throws ValidationException if the serviceMessage is invalid
     */
    ByteArrayInputStream createMessageStream(ServiceContext<SM, ID, RD> serviceContext, SM serviceMessage)
        throws ConfigurationException, ServiceException, ToolkitInternalException, ValidationException;

    /**
     * This method must call {@link ServiceContext#validateBeforeMarshalling}.
     * Always pass the same instance of ServiceContext to the {@link Translator} for a given invocation of a service.
     * @param serviceContext the {@link ServiceContext} to use while creating the stream
     * @param initiationData the {@link ServiceInitiationData} object to create the stream from
     * @return a {@link ByteArrayInputStream}
     * @throws ConfigurationException if the Toolkit has not been configured correctly
     * @throws ServiceException if a runtime exception occurs
     * @throws ToolkitInternalException if there is an unexpected condition
     * @throws ValidationException if the initiationData is invalid
     */
    ByteArrayInputStream createInitiationMessageStream(ServiceContext<SM, ID, RD> serviceContext, ID initiationData)
        throws ConfigurationException, ServiceException, ToolkitInternalException, ValidationException;

    /**
     * This method must call {@link ServiceContext#validateBeforeMarshalling}.
     * Always pass the same instance of ServiceContext to the {@link Translator} for a given invocation of a service.
     * @param serviceContext the {@link ServiceContext} to use while creating the stream
     * @param responseData the {@link ServiceResponseData} object to create the stream from
     * @return a {@link ByteArrayInputStream}
     * @throws ConfigurationException if the Toolkit has not been configured correctly
     * @throws ServiceException if a runtime exception occurs
     * @throws ToolkitInternalException if there is an unexpected condition
     * @throws ValidationException if the responseData is invalid
     */
    ByteArrayInputStream createResponseMessageStream(ServiceContext<SM, ID, RD> serviceContext, RD responseData)
        throws ConfigurationException, ServiceException, ToolkitInternalException, ValidationException;

}
