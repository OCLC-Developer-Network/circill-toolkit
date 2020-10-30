/*
 * Copyright (c) 2012 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.client;

import org.oclc.circill.toolkit.service.base.ServiceException;

import java.io.InputStream;
import java.util.Map;

/**
 * An interface for communicating with a target via HTTP or HTTPS.
 */
public interface HttpClient {
    /**
     * Sends a message to the target, including headers (e.g. for authentication/authorization) and returns
     * an InputStream for the response message.
     *
     * @param initiationMsgBytes the initiation message as an array of bytes (network octets)
     * @param headers a map of the HTTP headers
     * @param targetURL the target service's URL
     * @return the response message
     * @throws ServiceException when a failure occurs
     */
    InputStream sendMessage(byte[] initiationMsgBytes, Map<String, String> headers, String targetURL) throws ServiceException;

}
