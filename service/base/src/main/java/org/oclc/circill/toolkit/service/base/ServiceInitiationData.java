/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * The data which is passed to a {@link Service}.
 */
public interface ServiceInitiationData {
    default String getMessageName() {
        return getClass().getSimpleName().replace("InitiationData", "").replace("Data", "");
    }

    default String getServiceName() {
        return getClass().getSimpleName().replace("InitiationData", "").replace("Data", "");
    }
}
