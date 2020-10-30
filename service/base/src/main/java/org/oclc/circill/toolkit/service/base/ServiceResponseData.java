/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * The data which is returned by  {@link Service}.
 */
public interface ServiceResponseData {
    default String getMessageName() {
        return getClass().getSimpleName().replace("Data", "");
    }

    default String getServiceName() {
        return getClass().getSimpleName().replace("ResponseData", "").replace("ConfirmationData", "");
    }
}
