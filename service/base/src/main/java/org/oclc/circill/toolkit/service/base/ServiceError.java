/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.base;

/**
 * ServiceError enumerates the reasons for failure within the service API.
 */
public enum ServiceError {

    /**
     * Error occurred sending message
     */
    SERVICE_UNAVAILABLE,

    /**
     * The message was invalid
     */
    INVALID_MESSAGE_FORMAT,

    /**
     * Not supported action
     */
    UNSUPPORTED_REQUEST,

    /**
     * Runtime error
     */
    RUNTIME_ERROR,

    /**
     * Invalid Scheme/Value combination
     */
    INVALID_SCHEME_VALUE,

    /**
     * Configuration error
     */
    CONFIGURATION_ERROR}
