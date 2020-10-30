/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Processes a message by determining the appropriate Service implementation and
 * calling the performService method on that.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public class MappedMessageHandler<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> implements MessageHandler<SM, ID, RD> {

    private static final Logger LOG = Logger.getLogger(MappedMessageHandler.class);

    public static final String UNSUPPORTED_SERVICE_MESSAGE = "Unsupported service";
    public static final String TRANSLATOR_RETURNED_NULL_MESSAGE = "Translation of initiation message failed (ServiceInitiationData is null)";
    /**
     * Map of supported Services
     */
    protected Map<String, Service<SM, ID, RD>> supportedServices = Collections.emptyMap();

    /**
     * Provides access to services
     */
    protected RemoteServiceManager remoteServiceManager;

    /** Helper for protocol-specific behavior. */
    protected ProtocolHelper<SM, ID, RD> protocolHelper;

    /**
     * Construct an instance with the provider supportedServices map, service manager and protocol helper.
     * @param supportedServices the map of supported services
     * @param remoteServiceManager the {@link RemoteServiceManager}
     * @param protocolHelper the {@link ProtocolHelper}
     */
    public MappedMessageHandler(final Map<String, Service<SM, ID, RD>> supportedServices, final RemoteServiceManager remoteServiceManager,
        final ProtocolHelper<SM, ID, RD> protocolHelper) {
        this.supportedServices = new HashMap<>(supportedServices);
        this.remoteServiceManager = remoteServiceManager;
        this.protocolHelper = protocolHelper;
    }

    public RemoteServiceManager getRemoteServiceManager() {
        return this.remoteServiceManager;
    }

    public Map<String, Service<SM, ID, RD>> getSupportedServices() {
        return Collections.unmodifiableMap(this.supportedServices);
    }

    @Override
    public RD performService(final ID initiationData, final ServiceContext<SM, ID, RD> serviceContext)
        throws ServiceException, ValidationException, ToolkitInternalException, ConfigurationException {

        RD responseData;

        if (initiationData != null) {
            Service<SM, ID, RD> service = null;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Looking in supported services map (" + this + ") for service to handle " + initiationData.getClass().getName());
                for (final Map.Entry<String, Service<SM, ID, RD>> entry : supportedServices.entrySet()) {
                    LOG.debug(entry.getKey() + "=" + entry.getValue());
                }
            }

            if (supportedServices != null) {
                service = supportedServices.get(initiationData.getClass().getName());
                LOG.debug("service is " + service);
            } else {
                LOG.debug("supportedServices is null.");
            }

            if (service != null) {
                LOG.debug("service is " + service + ", calling performService method.");
                try {
                    responseData = service.performService(initiationData, serviceContext, remoteServiceManager);
                    LOG.debug("Result from performService call is " + responseData);
                } catch (ServiceException | ValidationException e) {
                    responseData = protocolHelper.convertExceptionToResponse(e);
                }
            } else {
                LOG.debug("service is null, returning Unsupported Service response.");
                responseData = protocolHelper.createProblemResponse(UNSUPPORTED_SERVICE_MESSAGE, initiationData);
            }
        } else {
            // If this happens, there is a bug in the code that calls this; you need to find and fix that bug.
            LOG.debug("initiationData is null, returning Temporary Processing Failure response.");
            responseData = protocolHelper.createProblemResponse(TRANSLATOR_RETURNED_NULL_MESSAGE, null);
        }

        return responseData;
    }

    @Override
    public List<String> getSupportedServicesNames() {
        final List<String> list = new ArrayList<>();
        for (final Map.Entry<String, Service<SM, ID, RD>> entry : supportedServices.entrySet()) {
            list.add((entry.getValue()).getServiceName());
        }
        return list;
    }

    public ProtocolHelper<SM, ID, RD> getProtocolHelper() {
        return protocolHelper;
    }
}
