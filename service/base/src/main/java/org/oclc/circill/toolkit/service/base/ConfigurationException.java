/*
 * Copyright (c) 2019 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.base;

/**
 * ConfigurationException represents errors with the configuration of a service or Toolkit component.
 * Note: There are no constructors for cases related to XML schema elements (e.g. value and location) as this type of exception should never be related
 * to the data of a message.
 */
public class ConfigurationException extends ToolkitException {

    /**
     * Construct a ConfigurationException.
     * @param message the message
     */
    public ConfigurationException(final String message) {
        super(message);
    }

    /**
     * Construct a ConfigurationException with a cause.
     * @param message the message
     * @param cause the cause
     */
    public ConfigurationException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
