/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;

/**
 * An extension of {@link BaseChainingServiceContext} that implements {@link MessageHandlerAware}.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public class BaseChainingMessageHandlerAwareServiceContext<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData>
    extends BaseChainingServiceContext<SM, ID, RD> implements MessageHandlerAware<SM, ID, RD> {

    protected MessageHandler<SM, ID, RD> messageHandler;

    @Override
    public MessageHandler<SM, ID, RD> getMessageHandler() {
        return messageHandler;
    }

    @Override
    public void setMessageHandler(final MessageHandler<SM, ID, RD> messageHandler) {
        this.messageHandler = messageHandler;
    }

}
