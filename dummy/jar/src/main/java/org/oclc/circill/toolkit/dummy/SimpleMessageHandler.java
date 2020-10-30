/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.common.base.MessageHandler;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ProtocolHelper;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * A {@link MessageHandler} that passes all messages to a single service.
 */
public class SimpleMessageHandler implements MessageHandler<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> {

    private static final Logger LOG = Logger.getLogger(SimpleMessageHandler.class);

    private Service<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> service;

    private RemoteServiceManager remoteServiceManager;

    private ProtocolHelper<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> protocolHelper;

    /**
     * Construct an instance with the provided service, remove service manager and protocol helper.
     * @param service the {@link Service}
     * @param remoteServiceManager the {@link RemoteServiceManager}
     * @param protocolHelper the {@link ProtocolHelper}
     */
    public SimpleMessageHandler(final Service<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> service,
        final RemoteServiceManager remoteServiceManager,
        final ProtocolHelper<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> protocolHelper) {
        this.service = service;
        this.remoteServiceManager = remoteServiceManager;
        this.protocolHelper = protocolHelper;
    }

    @Override
    public ServiceResponseData performService(final ServiceInitiationData initiationData,
        final ServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> serviceContext)
        throws ServiceException, ValidationException, ToolkitInternalException, ConfigurationException {

        ServiceResponseData responseData;
        LOG.debug("Calling performService method.");
        try {
            responseData = service.performService(initiationData, serviceContext, remoteServiceManager);
            LOG.debug("Result from performService call is " + responseData);
        } catch (ServiceException | ValidationException e) {
            responseData = protocolHelper.convertExceptionToResponse(e);
        }

        return responseData;
    }

    @Override
    public List<String> getSupportedServicesNames() {
        return Collections.singletonList("All");
    }

    public Service<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> getService() {
        return service;
    }

    public void setService(final Service<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> service) {
        this.service = service;
    }

    public RemoteServiceManager getRemoteServiceManager() {
        return remoteServiceManager;
    }

    public void setRemoteServiceManager(final RemoteServiceManager remoteServiceManager) {
        this.remoteServiceManager = remoteServiceManager;
    }

    public ProtocolHelper<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> getProtocolHelper() {
        return protocolHelper;
    }

    public void setProtocolHelper(final ProtocolHelper<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> protocolHelper) {
        this.protocolHelper = protocolHelper;
    }

}
