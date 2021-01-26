/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.servicemanager;

import org.oclc.circill.toolkit.common.base.ToolkitComponent;
import org.oclc.circill.toolkit.common.base.Translator;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;

import static java.util.Collections.emptyMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * A {@link Service} implementation for initiators/clients of external services using HTTP/HTTPS transport.
 * @param <SM> a subclass of {@link ServiceMessage}
 * @param <ID> a subclass of {@link ServiceInitiationData}
 * @param <RD> a subclass of {@link ServiceResponseData}
 */
public class HttpInitiatorServiceImpl<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData>
    implements Service<SM, ID, RD>, ToolkitComponent {

    private static final Logger LOG = Logger.getLogger(HttpInitiatorServiceImpl.class);

    /**
     * For translating objects defined in the service package into XML binding-generated objects.
     */
    protected final Translator<SM, ID, RD> translator;

    /**
     * Construct and instance with the provided {@link Translator}.
     * @param translator the translator
     */
    public HttpInitiatorServiceImpl(final Translator<SM, ID, RD> translator) {
        this.translator = translator;
    }

    /**
     * Get the {@link ToolkitComponent} name.
     * @return the name
     */
    @Override
    public String getComponentName() {
        return ToolkitComponent.INITIATOR_COMPONENT_NAME;
    }

    /** Set of {@link HeaderGenerator}s to call to generate headers. */
    protected List<HeaderGenerator<ID>> headerGenerators = new ArrayList<>();

    @Override
    public RD performService(final ID initiationData, final ServiceContext<SM, ID, RD> serviceContext, final RemoteServiceManager serviceManager)
        throws ServiceException, ValidationException {

        LOG.debug("Entered performService for " + initiationData);
        final HttpInitiatorServiceManager svcMgr = (HttpInitiatorServiceManager) serviceManager;
        Map<String, String> headers = emptyMap();
        try {
            final InputStream inputStream = translator.createInitiationMessageStream(serviceContext, initiationData);
            final int bytesAvailable = inputStream.available();
            final byte[] initiationBytes = new byte[bytesAvailable];
            final int bytesRead = inputStream.read(initiationBytes, 0, bytesAvailable);
            if (bytesRead < bytesAvailable) {
                throw new ServiceException("Read fewer bytes (" + bytesRead + ") from the inputStream than were available (" + bytesAvailable + ").");
            }
            headers = generateHeaders(initiationData);
            final InputStream responseMsgInputStream = svcMgr.sendMessage(initiationBytes, headers);
            final RD responseData = translator.createResponseData(serviceContext, responseMsgInputStream);
            return responseData;
        } catch (IOException | ConfigurationException | ToolkitInternalException e) {
            logException(e, headers);
            throw new ServiceException("IOException reading bytes from the initiation message's InputStream.", e);
        } catch (final Exception e) {
            logException(e, headers);
            throw e;
        }
    }

    /**
     * Generate HTTP headers.
     * @param initiationData  the {@link ServiceInitiationData} object for which to generate headers
     * @return possibly-empty map of headers.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ServiceException if the headers cannot be generated
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public Map<String, String> generateHeaders(final ID initiationData) throws ConfigurationException, ServiceException, ToolkitInternalException {
        final Map<String, String> headers = new HashMap<>();
        for (final HeaderGenerator<ID> headerGenerator : headerGenerators) {
            headers.putAll(headerGenerator.generateHeaders(initiationData));
        }
        return headers;
    }

    /**
     * Logs the exception and HTTP headers.
     * @param exception exception that occurred.
     * @param headers HTTP headers to log.
     */
    private static void logException(final Exception exception, final Map<String, String> headers) {
        final StringBuilder sb = new StringBuilder();
        final String msg = String.format("Exception occurred.%n  Exception:[%s]%n  HTTP Headers:", exception.toString());
        sb.append(msg);
        for (final Map.Entry<String, String> header : headers.entrySet()) {
            final String line = String.format("%n    name:[%s], value:[%s]", header.getKey(), header.getValue());
            sb.append(line);
        }

        LOG.info(sb.toString());
    }

    public void setHeaderGenerators(final List<HeaderGenerator<ID>> headerGenerators) {
        this.headerGenerators = headerGenerators;
    }

}
