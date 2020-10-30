/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import static org.oclc.circill.toolkit.service.base.ToolkitHelper.toByteArray;

import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Utility methods for logging {@link InputStream} contents.
 */
public final class LoggingHelper {

    /**
     * This utility class does not allow instances.
     */
    private LoggingHelper() {
    }

    /**
     * If logging is enabled for level, copy the bytes from the inputStream and write them to the log, returning
     * a new InputStream made from the copied bytes; if logging is not enabled then simply return the inputStream.
     *
     * @param <S> a subclass of {@link InputStream}
     * @param log a {@link Logger}
     * @param level a {@link Level}
     * @param prettyPrintXML whether to pretty-print the XML
     * @param inputStream an {@link InputStream}
     * @return a copy of the inputStream}
     * @throws ServiceException if the input stream can't be copied
     */
    public static <S extends InputStream> S copyAndLogStream(final Logger log, final Level level, final boolean prettyPrintXML, final S inputStream) throws ServiceException {
        final boolean isEnabled = log.isEnabledFor(level);
        if (isEnabled) {
            final byte[] byteArray = toByteArray(inputStream);
            final InputStream loggingCopy = new ByteArrayInputStream(byteArray);
            if (prettyPrintXML) {
                final StringWriter strWriter = new StringWriter();
                ToolkitHelper.prettyPrintXML(loggingCopy, strWriter);
                log.log(level, strWriter.toString());
            } else {
                log.log(level, ToolkitHelper.convertStreamToString(loggingCopy));
            }
            return (S) (new ByteArrayInputStream(byteArray));
        } else {
            return inputStream;
        }
    }
}
