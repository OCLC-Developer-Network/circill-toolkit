/*
 * Copyright (c) 2020 OCLC, Inc.
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

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

/**
 * This class implements the Service&lt;ServiceInitiationData, ServiceResponseData&gt; interface for an initiator/client.
 * As the functionality required does not vary by ServiceInitiationData/ServiceResponseData sub-class,
 * there does not need to be more than a single implementation of that interface for an initiator.
 * This class uses a Translator to convert the ServiceInitiationData object to an array of bytes, which it then
 * passes to the RemoteServiceManager to send to the resonder and return an array of bytes representing the
 * NCIP response message.
 * @param <SM> a subclass of {@link ServiceMessage}
 * @param <ID> a subclass of {@link ServiceInitiationData}
 * @param <RD> a subclass of {@link ServiceResponseData}
 */
public class SocketInitiatorServiceImpl<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData>
    implements Service<SM, ID, RD>, ToolkitComponent {

    private static final Logger LOG = Logger.getLogger(SocketInitiatorServiceImpl.class);

    /**
     * For translating objects defined in the service package into XML binding-generated objects.
     */
    protected final Translator<SM, ID, RD> translator;

    /**
     * Construct and instance with the provided {@link Translator}.
     * @param translator the translator
     */
    public SocketInitiatorServiceImpl(final Translator<SM, ID, RD> translator) {
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

    @Override
    public RD performService(final ID initiationData, final ServiceContext<SM, ID, RD> serviceContext, final RemoteServiceManager serviceManager)
        throws ServiceException, ValidationException {

        LOG.debug("Entered performService for " + initiationData);
        final SocketInitiatorServiceManagerImpl svcMgr = (SocketInitiatorServiceManagerImpl) serviceManager;
        try {
            final InputStream inputStream = translator.createInitiationMessageStream(serviceContext, initiationData);
            final int bytesAvailable = inputStream.available();
            final byte[] initiationBytes = new byte[bytesAvailable];
            final int bytesRead = inputStream.read(initiationBytes, 0, bytesAvailable);
            if (bytesRead < bytesAvailable) {
                throw new ServiceException("Read fewer bytes (" + bytesRead + ") from the inputStream than were available (" + bytesAvailable + ").");
            }
            final InputStream responseMsgInputStream = svcMgr.sendMessage(initiationBytes);
            final RD responseData = translator.createResponseData(serviceContext, responseMsgInputStream);
            return responseData;
        } catch (IOException | ConfigurationException | ToolkitInternalException e) {
            throw new ServiceException("IOException reading bytes from the initiation message's InputStream.", e);
        }
    }
}
