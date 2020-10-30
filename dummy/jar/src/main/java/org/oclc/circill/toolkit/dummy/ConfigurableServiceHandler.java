/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;

/**
 * Defines methods which scripts used by the {@link ConfigurableService} must implement.
 */
public interface ConfigurableServiceHandler {
    /**
     * Whether this handler can handle this initiation data.
     * @param initiationData the initiation data
     * @return true if the handler can handle the initiationData; otherwise fales
     */
    boolean canHandle(ServiceInitiationData initiationData);

    /**
     * Handle the initiationData.
     * @param initiationData the {@link ServiceInitiationData}
     * @return the {@link ServiceResponseData} returned by the handler
     */
    ServiceResponseData handle(ServiceInitiationData initiationData);
}
