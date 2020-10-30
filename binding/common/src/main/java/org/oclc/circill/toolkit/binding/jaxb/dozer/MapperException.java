/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

/**
 * Represents exceptions thrown by the Mapper package; typically just wraps the underlying exception.
 */
public class MapperException extends Exception {
    public MapperException(final Exception cause) {
        super(cause);
    }

    public MapperException(final String explanation) {
        super(explanation);
    }
}
