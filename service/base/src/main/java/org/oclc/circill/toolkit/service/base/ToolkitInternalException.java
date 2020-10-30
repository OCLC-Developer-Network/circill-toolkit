/*
 * Copyright (c) 2019 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Represents an error in the logic of the Toolkit software such that the Toolkit code can not recover, e.g. required methods not found via reflection,
 * nulls passed to internal methods which should not be, etc.
 * Note: There are no constructors for cases related to XML schema elements (e.g. value and location) as this type of exception should never be related
 * to the data of a message.
 */
public class ToolkitInternalException extends ToolkitException {

    /**
     * Construct a ToolkitInternalException.
     * @param message a message describing the exception's cause
     */
    public ToolkitInternalException(final String message) {
        super(message);
    }

    /**
     * Construct a ToolkitInternalException with a cause.
     * @param message a message describing the exception's cause
     * @param cause the cause
     */
    public ToolkitInternalException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
