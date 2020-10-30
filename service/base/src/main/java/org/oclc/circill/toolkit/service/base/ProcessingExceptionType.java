/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Identifies a processing exception type.
 */
public class ProcessingExceptionType {

    private final String name;

    public static final ProcessingExceptionType LOGIC_ERROR = new ProcessingExceptionType("Logic error");
    public static final ProcessingExceptionType DATA_ERROR = new ProcessingExceptionType("Data error");
    public static final ProcessingExceptionType CONFIGURATION_ERROR = new ProcessingExceptionType("Configuration error");

    /**
     * Construct a ProcessingExceptionType.
     * @param name the name of the type
     */
    public ProcessingExceptionType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
