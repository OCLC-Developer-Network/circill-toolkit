/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.base;

import java.util.List;

/**
 * ServiceException represents errors during the performance of a service.
 */
public class ServiceException extends ToolkitException {

    /**
     * Construct a ServiceException.
     * @param message a message describing the exception's cause
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Construct a ServiceException with a cause.
     * @param message a message describing the exception's cause
     * @param cause the cause
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Construct a ServiceException.
     * @param exceptionDetail the detailed message
     * @param exceptionCodeScheme the exception code Scheme URI
     * @param exceptionCodeValue the exception code value
     * @param exceptionLocation the location (in the message) associated with the exception, e.g. the element having an invalid value
     * @param exceptionValue the value associated with the exception, e.g. the invalid value
     */
    public ServiceException(final String exceptionDetail, final String exceptionCodeScheme, final String exceptionCodeValue, final String exceptionLocation,
        final String exceptionValue) {
        super(exceptionDetail, exceptionCodeScheme, exceptionCodeValue, exceptionLocation, exceptionValue);
    }

    /**
     * Construct a ServiceException.
     * @param exceptionDetail the detailed message
     * @param exceptionCodeScheme the exception code Scheme URI
     * @param exceptionCodeValue the exception code value
     * @param exceptionLocation the location (in the message) associated with the exception, e.g. the element having an invalid value
     * @param exceptionValue the value associated with the exception, e.g. the invalid value
     * @param cause the cause
     */
    public ServiceException(final String exceptionDetail, final String exceptionCodeScheme, final String exceptionCodeValue, final String exceptionLocation,
        final String exceptionValue, final Exception cause) {
        super(exceptionDetail, exceptionCodeScheme, exceptionCodeValue, exceptionLocation, exceptionValue, cause);
    }

    /**
     * Construct a ServiceException with a list of {@link ExceptionDescription}s.
     * @param exceptionDescriptions a list of {@link ExceptionDescription}s
     */
    public ServiceException(final List<ExceptionDescription> exceptionDescriptions) {
        super(exceptionDescriptions);
    }

    /**
     * Construct a ServiceException with a list of {@link ExceptionDescription}s and a cause.
     * @param exceptionDescriptions a list of {@link ExceptionDescription}s
     * @param cause the cause
     */
    public ServiceException(final List<ExceptionDescription> exceptionDescriptions, final Exception cause) {
        super(exceptionDescriptions, cause);
    }
}
