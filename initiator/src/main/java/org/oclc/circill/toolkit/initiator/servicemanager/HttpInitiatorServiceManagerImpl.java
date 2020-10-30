/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.servicemanager;

import org.oclc.circill.toolkit.initiator.client.HttpClient;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceException;

import java.io.InputStream;
import java.util.Map;

/**
 * An implementation of {@link HttpInitiatorServiceManager}.
 *
 */
public class HttpInitiatorServiceManagerImpl implements HttpInitiatorServiceManager {

    protected final HttpClient client;

    protected final String targetURL;

    /**
     * Construct an instance.
     * @param client the {@link HttpClient}
     * @param targetURL the URL of the target service
     */
    public HttpInitiatorServiceManagerImpl(final HttpClient client, final String targetURL) {
        this.client = client;
        this.targetURL = targetURL;
    }

    /**
     * Send a message (as represented by the byte array) to the current NCIP responder (i.e. the target address),
     * returning an {@link InputStream} from which clients can read the bytes of the response message.
     *
     * @param initiationMsgBytes the bytes representing the initiation message
     * @param headers the map of HTTP headers to send with the message
     * @return an array of bytes representing the response message
     * @throws ConfigurationException if the Toolkit has not been configured correctly
     * @throws ServiceException if the NCIP service fails without the responder returning an NCIPMessage
     */
    @Override
    public synchronized InputStream sendMessage(final byte[] initiationMsgBytes, final Map<String, String> headers) throws ConfigurationException, ServiceException {

        final InputStream inputStream = client.sendMessage(initiationMsgBytes, headers, targetURL);
        return inputStream;

    }

}
