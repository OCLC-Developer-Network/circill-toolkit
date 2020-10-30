/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Utility methods used throughout the Toolkit.
 */
public final class ToolkitHelper {

    private static final Logger LOG = Logger.getLogger(ToolkitHelper.class);

    /* Size of byte array used when copying input stream to a byte array. */
    private static final int ARRAY_SIZE = 1024;

    /* Size of char array used when copying input stream to a String. */
    private static final int BUFFER_SIZE = 1024;

    public static final String TOOLKIT_SERVICE_PACKAGE_PATTERN = "^org\\.oclc\\.circill\\.toolkit\\.service\\..*";

    /**
     * This utility class does not allow instances.
     */
    private ToolkitHelper() {
    }

    /**
     * Convert an InputStream to a String.
     * @param inStream the {@link InputStream}
     * @return a String
     * @throws ServiceException -
     */
    public static String convertStreamToString(final InputStream inStream) throws ServiceException {
        final Writer writer = new StringWriter();
        try {
            final char[] buffer = new char[BUFFER_SIZE];
            final Reader reader = new BufferedReader(new InputStreamReader(inStream, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            throw new ServiceException("UnsupportedEncodingException: ", e);
        } catch (IOException e) {
            throw new ServiceException("IOException: .", e);
        } finally {
            try {
                inStream.close();
            } catch (IOException e) {
                LOG.warn("IOException:", e);
            }
        }

        return writer.toString();

    }

    /**
     * Render the XML in the responseStream to a {@link Writer} in pretty-printed format.
     * Note: This closes the msgStream when it is finished reading from it and the outWriter when it is finished
     * writing to it.
     * @param msgStream the {@link InputStream} holding the XML document
     * @param outWriter the {@link Writer} to write the pretty-printed XML to
     * @throws ServiceException if an error occurs
     */
    public static void prettyPrintXML(final InputStream msgStream, final Writer outWriter) throws ServiceException {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        final Document document;

        try {
            final DocumentBuilder db = dbf.newDocumentBuilder();
            final InputSource is = new InputSource(msgStream);
            document = db.parse(is);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ServiceException("Exception parsing message for printing.", e);
        }

        try {
            msgStream.close();
        } catch (IOException e) {
            throw new ServiceException("Exception closing message stream after parsing for printing.", e);
        }

        try {
            // Code taken from https://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java/7714473#7714473
            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();
            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
            final LSOutput output = impl.createLSOutput();
            output.setCharacterStream(outWriter);
            writer.write(document, output);
        } catch (final ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServiceException("Exception writing message stream", e);
        }

        try {
            outWriter.close();
        } catch (IOException e) {
            LOG.warn("Error closing outWriter", e);
        }

    }

    /**
     * A convenience method to create an {@link InputStream} for the supplied resource or file name.
     * @param resourceOrFileName the resource's, or file's, name
     * @return the {@link InputStream}
     */
    public static InputStream getResourceOrFile(final String resourceOrFileName) {
        return getResourceOrFile(resourceOrFileName, true);
    }

    /**
     * Load a resource (via {@link ClassLoader#getResourceAsStream(String)}) and if that fails as a file (via
     * {@link FileInputStream}.
     * @param resourceOrFileName the name of the resource
     * @param logExceptionStackTrace  true if the stack trace of the exception should be logged.
     * @return the {@link InputStream}
     */
    public static InputStream getResourceOrFile(final String resourceOrFileName, final boolean logExceptionStackTrace) {
        InputStream inputStream = ToolkitHelper.class.getClassLoader().getResourceAsStream(resourceOrFileName);
        if (inputStream == null) {
            try {
                LOG.debug("Resource '" + resourceOrFileName + "' not found; trying as file.");
                inputStream = new FileInputStream(resourceOrFileName);
            } catch (FileNotFoundException e) {
                if (logExceptionStackTrace) {
                    LOG.debug("FileNotFoundException loading file '" + resourceOrFileName + "'; returning null.", e);
                } else {
                    LOG.debug("FileNotFoundException loading file '" + resourceOrFileName + "'; returning null.");
                }
            }
        }
        return inputStream;
    }

    /**
     * Concatenate the Strings in the List, putting the separator between each but not after the last.
     * @param strings the strings to concatenate
     * @param separator the separator
     * @return the concatenated string
     */
    public static String concatenateStrings(final List<String> strings, final String separator) {
        String result = "";
        if (strings != null && !strings.isEmpty()) {
            final StringBuilder sb = new StringBuilder();
            for (final String s : strings) {
                sb.append(s).append(separator);
            }
            result = sb.toString();
            result = result.substring(0, result.length() - separator.length());
        }
        return result;
    }

    /**
     * Converts the exception, including the stack trace, to a string.
     * @param e the Exception to render as a string
     * @return the String rendering of the Exception
     */
    public static String convertExceptionToString(final Throwable e) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    /**
     * Convert the exception messages in the supplied {@link Throwable} to a string.
     * @param msg the to include at the beginning of the returned string
     * @param t the {@link Throwable}
     * @return the string
     */
    public static String convertExceptionMessagesToString(final String msg, final Throwable t) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        Throwable ultimateCause = t;
        Throwable cause = ultimateCause.getCause();
        while (cause != null) {
            ultimateCause = cause;
            cause = cause.getCause();
        }
        if (ultimateCause instanceof SAXParseException) {
            final String rawMessage = ultimateCause.toString();
            pw.print(msg + System.lineSeparator() + rawMessage.replaceFirst("org.xml.sax.SAXParseException;", "Invalid message format:"));
        } else {
            pw.print(msg + System.lineSeparator() + ultimateCause);
        }
        return sw.getBuffer().toString();
    }

    /**
     * Read the inputStream into a byte array and return that.
     * @param inputStream the {@link InputStream}
     * @return a byte array
     * @throws ServiceException if there is an IOException from reading the inputStream
     */
    public static byte[] toByteArray(final InputStream inputStream) throws ServiceException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            final byte[] data = new byte[ARRAY_SIZE];
            while (true) {
                final int chunk = inputStream.read(data);
                if (chunk == -1 ) {
                    break;
                }
                byteArrayOutputStream.write(data, 0, chunk);
            }
        } catch (IOException e) {
            throw new ServiceException("Exception converting input stream:", e);
        }
        return byteArrayOutputStream.toByteArray();
    }}
