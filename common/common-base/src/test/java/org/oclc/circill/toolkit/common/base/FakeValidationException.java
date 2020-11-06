/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ValidationException;

/**
 * Subclass of {@link ValidationException} for tests.
 */
public class FakeValidationException extends ValidationException {
    /**
     * Construct a new ValidationException with the supplied message.
     * @param message A message describing the exception
     */
    public FakeValidationException(final String message) {
        super(message);
    }
}
