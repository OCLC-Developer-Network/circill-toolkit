/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Describes an exceptional condition which occured in performance of a {@link Service} in an implementation-agnostic form.
 */
public class ExceptionDescription {
    protected final String exceptionDetail;
    protected final String exceptionCodeScheme;
    protected final String exceptionCodeValue;
    protected final String exceptionLocation;
    protected final String exceptionValue;

    /**
     * Construct an ExceptionDescription.
     * @param exceptionDetail the detailed message
     * @param exceptionCodeScheme the exception code Scheme URI
     * @param exceptionCodeValue the exception code value
     * @param exceptionLocation the location (in the message) associated with the exception, e.g. the element having an invalid value
     * @param exceptionValue the value associated with the exception, e.g. the invalid value
     */
    public ExceptionDescription(final String exceptionDetail, final String exceptionCodeScheme, final String exceptionCodeValue, final String exceptionLocation,
        final String exceptionValue) {
        this.exceptionDetail = exceptionDetail;
        this.exceptionCodeScheme = exceptionCodeScheme;
        this.exceptionCodeValue = exceptionCodeValue;
        this.exceptionLocation = exceptionLocation;
        this.exceptionValue = exceptionValue;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public String getExceptionCodeScheme() {
        return exceptionCodeScheme;
    }

    public String getExceptionCodeValue() {
        return exceptionCodeValue;
    }

    public String getExceptionLocation() {
        return exceptionLocation;
    }

    public String getExceptionValue() {
        return exceptionValue;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Exception detail: \"").append(exceptionDetail).append("\"; Exception Code Scheme: \"").append(exceptionCodeScheme).append("\"; Exception Code Value: \"")
            .append(exceptionCodeValue).append("\"; Exception Location: \"").append(exceptionLocation).append("\"; Exception Value: \"").append(exceptionValue);
        return builder.toString();
    }
}
