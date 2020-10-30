/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.common.base.MessageHandler;
import org.oclc.circill.toolkit.common.base.MessageHandlerAware;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

import org.apache.log4j.Logger;

/**
 * Factory for NCIP {@link ServiceContext}s.
 * Note: Spring is responsible for constructing a new ServiceContext object each time the getInitiatlServiceContext
 * method is called (i.e. the serviceContext bean must have prototype scope).
 */
public class DefaultNCIPServiceContextFactory extends NCIPServiceContextFactory
    implements MessageHandlerAware<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> {

    private static final Logger LOG = Logger.getLogger(DefaultNCIPServiceContextFactory.class);

    protected MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> messageHandler;

    /**
     * Construct an instance with the provided service context bean name and message handler.
     * @param serviceContextBeanName - the name of the {@link ServiceContext} bean
     * @param messageHandler the {@link MessageHandler}
     */
    public DefaultNCIPServiceContextFactory(final String serviceContextBeanName,
        final MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> messageHandler) {
        super(serviceContextBeanName);
        this.messageHandler = messageHandler;
    }

    @Override
    public ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> getInitialServiceContext() throws ConfigurationException {
        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> result = super.getInitialServiceContext();

        if (result instanceof MessageHandlerAware) {
            LOG.debug("Setting message handler in service context.");
            ((MessageHandlerAware) result).setMessageHandler(messageHandler);
        }

        return result;

    }

    @Override
    public MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> getMessageHandler() {
        return messageHandler;
    }

    @Override
    public void setMessageHandler(final MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> messageHandler) {
        this.messageHandler = messageHandler;
    }

}
