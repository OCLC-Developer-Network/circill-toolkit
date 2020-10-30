/*
 * Copyright (c) 2020 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.servicemanager;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ServiceException;

import java.io.InputStream;
import java.util.Map;

/**
 * A {@link RemoteServiceManager} for initiators/clients using HTTP transport.
 */
public interface HttpInitiatorServiceManager extends RemoteServiceManager {
    /**
     * Send the initiationMsgBytes to the associated remote service.
     * @param initiationMsgBytes the bytes representing the message to send
     * @param headers the HTTP headers for the message
     * @return an {@link InputStream} representing the response message
     * @throws ServiceException if the service fails
     * @throws ConfigurationException if there is a configuration problem
     */
    InputStream sendMessage(byte[] initiationMsgBytes, Map<String, String> headers) throws ServiceException, ConfigurationException;
}
