/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.servicemanager;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import java.util.Map;

public interface HeaderGenerator<ID extends ServiceInitiationData> {
    /**
     * Generate the headers for this initiation message.
     * @param initiationData  the {@link ServiceInitiationData} object for which to generate headers
     * @return possibly-empty map of headers
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ServiceException if the headers cannot be generated
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    Map<String, String> generateHeaders(ID initiationData) throws ServiceException, ConfigurationException, ToolkitInternalException;
}
