/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import static org.oclc.circill.toolkit.service.base.ToolkitHelper.getResourceOrFile;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import groovy.lang.GroovyClassLoader;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

/**
 * A {@link Service} that can be configured with Groovy scripts (classes implementing {@link ConfigurableServiceHandler})
 * that are used to process input messages and return response messages.
 */
public class ConfigurableService implements Service<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> {

    private static final Logger LOG = Logger.getLogger(ConfigurableService.class);

    /** The cache of handlers. */
    static final Map<Class<? extends ConfigurableServiceHandler>, ConfigurableServiceHandler> HANDLERS = new ListOrderedMap<>();

    @Override
    public ServiceResponseData performService(final ServiceInitiationData initiationData,
        final ServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> serviceContext,
        final RemoteServiceManager serviceManager) throws ServiceException, ValidationException {

        // TODO: Use injected ProtocolHandler to build an error to return for the "no handler found case.
        ServiceResponseData responseData = null;
        for (final ConfigurableServiceHandler handlerInstance : HANDLERS.values()) {
            if (handlerInstance.canHandle(initiationData)) {
                responseData = handlerInstance.handle(initiationData);
                break;
            }
        }
        return responseData;
    }

    /**
     * Load handlers from resources and/or files.
     * @param handlerFileNames the file names for the handlers
     */
    public void loadHandlers(final String ... handlerFileNames) {
        for (final String handlerFileName : handlerFileNames) {
            try (InputStream inputStream = getResourceOrFile(handlerFileName)) {
                if (inputStream != null) {
                    final String handlerSource = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
                    addHandler(handlerSource);
                } else {
                    LOG.error("Could not load " + handlerFileName + "; getResourceOrFile returned null.");
                }
            } catch (IOException e) {
                LOG.error("Exception loading " + handlerFileName + ".", e);
            } catch (ServiceException e) {
                LOG.error("Exception instantiating instance of script " + handlerFileName + "." , e);
            }
        }
    }

    /**
     * Add the handler.
     * @param handlerSource the handler source code
     * @throws ServiceException if failed to add the handler
     */
    @SuppressWarnings("squid:S1872")
    public void addHandler(final String handlerSource) throws ServiceException {
        try (GroovyClassLoader gcl = new GroovyClassLoader()) {
            final Class<? extends ConfigurableServiceHandler> handlerClass = gcl.parseClass(handlerSource);
            if (HANDLERS.keySet().stream().anyMatch(e -> e.getSimpleName().equals(handlerClass.getSimpleName()))) {
                LOG.debug("Handler " + handlerClass.getName() + " already exits.");
                throw new ServiceException("Handler " + handlerClass.getName() + " already exists.");
            } else {
                final ConfigurableServiceHandler handlerInstance = handlerClass.getDeclaredConstructor().newInstance();
                ((ListOrderedMap<Class<? extends ConfigurableServiceHandler>, ConfigurableServiceHandler>) HANDLERS).put(0, handlerClass, handlerInstance);
            }
        } catch (InstantiationException | IllegalAccessException | IOException | NoSuchMethodException | InvocationTargetException e) {
            LOG.debug("Exception adding the handler", e);
            throw new ServiceException("Exception instantiating instance of script.", e);
        }
    }

    /**
     * Remove the handler
     * @param handlerName the handler
     * @return true if the handler was removed, otherwise false
     */
    public boolean removeHandler(final String handlerName) {
        boolean removed = false;
        final Iterator<Class<? extends ConfigurableServiceHandler>> iterator = HANDLERS.keySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getSimpleName().equals(handlerName)) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Return a list of handler class names.
     * @return the list of handler names
     */
    public List<String> getHandlerNames() {
        return HANDLERS.keySet().stream().map(Class::getSimpleName).collect(Collectors.toList());
    }

    /**
     * Get the named handler
     * @param handlerName name of the handler
     * @return the handler instance
     * @throws ServiceException if handler is not found
     */
    public ConfigurableServiceHandler getHandler(final String handlerName) throws ServiceException {
        ConfigurableServiceHandler handler = null;
        for (final Map.Entry<Class<? extends ConfigurableServiceHandler>, ConfigurableServiceHandler> entry: HANDLERS.entrySet()) {
            if (entry.getKey().getSimpleName().equalsIgnoreCase(handlerName)) {
                handler = entry.getValue();
                break;
            }
        }
        if (handler == null) {
            throw new ServiceException("Handler doesn't exist");
        }
        return handler;
    }

    /**
     * Reorder the handlers to match the input list of names; handlers not in the list will be removed.
     * @param orderedHandlerNames handler names in the desired order
     * @return an empty list on success; otherwise a list of handlernames that were not found
     */
    public List<String> reorderHandlers(final List<String> orderedHandlerNames) {
        final Map<Class<? extends ConfigurableServiceHandler>, ConfigurableServiceHandler> newHandlerList = new ListOrderedMap<>();
        final Iterator<String> orderedHandlerNamesIterator = orderedHandlerNames.iterator();
        while (orderedHandlerNamesIterator.hasNext()) {
            final String orderedHandlerName = orderedHandlerNamesIterator.next();
            for (final Map.Entry<Class<? extends ConfigurableServiceHandler>, ConfigurableServiceHandler> entry : HANDLERS.entrySet()) {
                final Class<? extends ConfigurableServiceHandler> handlerClass = entry.getKey();
                final ConfigurableServiceHandler handlerInstance = entry.getValue();
                if (handlerClass.getSimpleName().equalsIgnoreCase(orderedHandlerName)) {
                    orderedHandlerNamesIterator.remove();
                    newHandlerList.put(handlerClass, handlerInstance);
                    break;
                }
            }
        }
        final List<String> unfoundHandlers;
        if (CollectionUtils.isEmpty(orderedHandlerNames)) {
            HANDLERS.clear();
            HANDLERS.putAll(newHandlerList);
            unfoundHandlers = Collections.emptyList();
        } else {
            unfoundHandlers = orderedHandlerNames;
        }
        return unfoundHandlers;
    }
}
