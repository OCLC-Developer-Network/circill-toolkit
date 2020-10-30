/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * There are two 'kinds' of ToolkitException: Those with one or more ExceptionDescription and those with a message. Either 'kind' may have an associated cause (another Exception).
 */
public class ToolkitException extends Exception {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    protected final List<ExceptionDescription> exceptionDescriptions;

    /**
     * Construct a new ToolkitExcepiton with a message.
     * @param message the message
     */
    protected ToolkitException(final String message) {
        super(message);
        this.exceptionDescriptions = Collections.emptyList();
    }

    /**
     * Construct a new ToolkitException with a message.
     * @param message the message
     * @param cause the cause
     */
    protected ToolkitException(final String message, final Throwable cause) {
        super(message, cause);
        this.exceptionDescriptions = Collections.emptyList();
    }

    /**
     * Construct a new ToolkitException with the supplied description.
     * @param exceptionDetail the detailed message
     * @param exceptionCodeScheme the exception code Scheme URI
     * @param exceptionCodeValue the exception code value
     * @param exceptionLocation the location (in the message) associated with the exception, e.g. the element having an invalid value
     * @param exceptionValue the value associated with the exception, e.g. the invalid value
     */
    protected ToolkitException(final String exceptionDetail, final String exceptionCodeScheme, final String exceptionCodeValue, final String exceptionLocation,
        final String exceptionValue) {
        final List<ExceptionDescription> tmpList = new ArrayList<>(1);
        tmpList.add(new ExceptionDescription(exceptionDetail, exceptionCodeScheme, exceptionCodeValue, exceptionLocation, exceptionValue));
        exceptionDescriptions = Collections.unmodifiableList(tmpList);
    }

    /**
     * Construct a new ToolkitException with the supplied description and cause.
     * @param exceptionDetail the detailed message
     * @param exceptionCodeScheme the exception code Scheme URI
     * @param exceptionCodeValue the exception code value
     * @param exceptionLocation the location (in the message) associated with the exception, e.g. the element having an invalid value
     * @param exceptionValue the value associated with the exception, e.g. the invalid value
     * @param cause the cause
     */
    protected ToolkitException(final String exceptionDetail, final String exceptionCodeScheme, final String exceptionCodeValue, final String exceptionLocation,
        final String exceptionValue, final Exception cause) {
        super(cause);
        final List<ExceptionDescription> tmpList = new ArrayList<>(1);
        tmpList.add(new ExceptionDescription(exceptionDetail, exceptionCodeScheme, exceptionCodeValue, exceptionLocation, exceptionValue));
        exceptionDescriptions = Collections.unmodifiableList(tmpList);
    }

    /**
     * Construct a ToolkitException with a list of {@link ExceptionDescription}s.
     * @param exceptionDescriptions a list of {@link ExceptionDescription}s
     */
    protected ToolkitException(final List<ExceptionDescription> exceptionDescriptions) {
        super();
        this.exceptionDescriptions = Collections.unmodifiableList(exceptionDescriptions);
    }

    /**
     * Construct a ToolkitException with a list of {@link ExceptionDescription}s and a cause.
     * @param exceptionDescriptions a list of {@link ExceptionDescription}s
     * @param cause the cause
     */
    protected ToolkitException(final List<ExceptionDescription> exceptionDescriptions, final Exception cause) {
        super(cause);
        this.exceptionDescriptions = Collections.unmodifiableList(exceptionDescriptions);
    }

    /**
     * Get the {@link ExceptionDescription}s.
     * @return unmodifiable {@link List}
     */
    public List<ExceptionDescription> getExceptionDescriptions() {
        return exceptionDescriptions;
    }

    /**
     * Represent the exception as a String (for logging, etc.).
     *
     * @return the String representation
     */
    @Override
    public String getLocalizedMessage() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getMessage());
        if (exceptionDescriptions != null) {
            for (final ExceptionDescription ed : exceptionDescriptions) {
                sb.append(ed.toString()).append(LINE_SEPARATOR);
            }
        }
        return sb.toString();
    }
}
