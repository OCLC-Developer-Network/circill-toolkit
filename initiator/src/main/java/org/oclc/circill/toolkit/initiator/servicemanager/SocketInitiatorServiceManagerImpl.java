/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.servicemanager;

import org.oclc.circill.toolkit.initiator.client.SocketClient;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceException;

import java.io.InputStream;

/**
 * An implementation of {@link SocketInitiatorServiceManager}.
 * This class is thread-safe.
 */
public class SocketInitiatorServiceManagerImpl implements SocketInitiatorServiceManager {

    protected final SocketClient client;

    protected final String targetURL;

    /**
     * Construct an instance with the provided client and for the targetURL.
     * @param client the {@link SocketClient}
     * @param targetURL the network address of the target service
     */
    public SocketInitiatorServiceManagerImpl(final SocketClient client, final String targetURL) {
        this.client = client;
        this.targetURL = targetURL;
    }

    /**
     * Send a message (as represented by the byte array) to the target address,
     * returning an {@link InputStream} from which clients can read the bytes of the response message.
     *
     * @param initiationMsgBytes the bytes representing the initiation message
     * @return an array of bytes representing the response message
     * @throws ServiceException if the NCIP service fails without the responder returning an NCIPMessage
     */
    @Override
    public synchronized InputStream sendMessage(final byte[] initiationMsgBytes) throws ServiceException, ConfigurationException {
        final InputStream inputStream = client.sendMessage(initiationMsgBytes, targetURL);
        return inputStream;
    }

}
