/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.client;

import org.oclc.circill.toolkit.common.base.StatisticsBean;
import org.oclc.circill.toolkit.service.base.ServiceException;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/**
 * Base class for clients (a.k.a. 'initiators') using socket (a.k.a. TCP/IP) transport.
 */
public class SocketClientImpl extends BaseClient implements SocketClient {

    /**
     * Construct an instance with the provider {@link StatisticsBean}.
     * @param statisticsBean the {@link StatisticsBean}
     */
    protected SocketClientImpl(final StatisticsBean statisticsBean) {
        super(statisticsBean);
    }

    /**
     * Send the provided initiation message with no additional headers to the current target address.
     *
     * @param initiationMsgBytes the initiation message as an array of bytes (network octets)
     * @param targetURL the URL of the target responder
     * @return the {@link InputStream} from which the response message can be read
     * @throws ServiceException if the service fails
     */
    public InputStream sendMessage(final byte[] initiationMsgBytes, final String targetURL) throws ServiceException {
        return sendMessage(initiationMsgBytes, Collections.emptyMap(), targetURL);
    }

    /**
     * Send the provided initiation message (with supplied headers), represented as an array of bytes,
     * to the current target address using the current connect and read timeouts.
     *
     * @param initiationMsgBytes the initiation message as an array of bytes (network octets)
     * @param targetURL the URL of the target responder
     * @param headers a map of HTTP headers
     * @return the {@link InputStream} from which the response message can be read
     * @throws ServiceException if the exchange of messages with the responder fails
     */
    public InputStream sendMessage(final byte[] initiationMsgBytes, final Map<String, String> headers, final String targetURL) throws ServiceException {
        // TODO: Implement socket client behavior
        throw new UnsupportedOperationException("Socket client not yet implemented.");

    }
}
