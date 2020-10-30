/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.xml.sax.SAXParseException;

/**
 * Test methods for {@link ToolkitHelper}.
 */
public class TestToolkitHelper {
    private static final String EXCEPTION_MESSAGE = "An Exception Arose";
    private static final String EXCEPTION_2_MESSAGE = "Another exceptional event";
    private static final String MESSAGE_PREFACE = "This is the message";
    private static final String CAUSE_MESSAGE = "Something is nothing";

    @Test
    public void testConvertExceptionMessageToString() {
        final Throwable cause = new SAXParseException(CAUSE_MESSAGE, "", "", 0, 0);
        final Throwable exception = new IllegalArgumentException(EXCEPTION_MESSAGE, cause);
        final String stringResult = ToolkitHelper.convertExceptionMessagesToString(MESSAGE_PREFACE, exception);
        final String pattern = MESSAGE_PREFACE + System.lineSeparator() + cause.getClass().getName() + ".*" + CAUSE_MESSAGE;
        assertTrue(stringResult.matches(pattern));
        final Throwable exception2 = new NullPointerException(EXCEPTION_2_MESSAGE);
        final String stringResult2 = ToolkitHelper.convertExceptionMessagesToString(MESSAGE_PREFACE, exception2);
        final String pattern2 = MESSAGE_PREFACE + System.lineSeparator() + exception2.getClass().getName() + ".*" + EXCEPTION_2_MESSAGE;
        assertTrue(stringResult2.matches(pattern2));
    }
}
