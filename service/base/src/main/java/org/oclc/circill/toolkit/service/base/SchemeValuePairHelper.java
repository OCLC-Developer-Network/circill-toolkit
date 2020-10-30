/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Utility methods for {@link SchemeValuePair}.
 */
public final class SchemeValuePairHelper {

    private static final Logger LOG = Logger.getLogger(SchemeValuePairHelper.class);

    private static final String EXCEPTION_MESSAGE_FORMAT = "Exception finding Scheme/Value combination of '%s/%s' for class '%s'.";

    private static final Map<Class<? extends SchemeValuePair>, Method> FIND_METHODS_BY_CLASS = new HashMap<>();

    /**
     * This utility class does not allow instances.
     */
    private SchemeValuePairHelper() {
    }

    /**
     * Find the {@link SchemeValuePair} object with the supplied Scheme URI and value.
     * @param svcSVPClass the {@link SchemeValuePair} subclass to which the Scheme belongs
     * @param scheme the NCIP Scheme URI within which the value is defined
     * @param value the value
     * @return the {@link SchemeValuePair} instance
     * @throws ConfigurationException if the Scheme or the Value within the Scheme cannot be found
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static SchemeValuePair findSchemeValuePair(final Class<? extends SchemeValuePair> svcSVPClass, final String scheme, final String value)
        throws ConfigurationException, ToolkitInternalException {

        final SchemeValuePair result;
        try {
            final Method findMethod = getFindMethod(svcSVPClass);
            LOG.trace("Trying to find scheme '" + scheme + "', value '" + value + "'.");
            result = (SchemeValuePair) findMethod.invoke(null, scheme, value);
            LOG.trace("Found scheme '" + scheme + "', value '" + value + "'.");
        } catch (IllegalAccessException e) {
            throw new ToolkitInternalException(String.format(EXCEPTION_MESSAGE_FORMAT, scheme, value, svcSVPClass.getSimpleName()), e);
        } catch (InvocationTargetException e) {
            if (e.getTargetException() instanceof ConfigurationException) {
                throw new ConfigurationException(String.format(EXCEPTION_MESSAGE_FORMAT, scheme, value, svcSVPClass.getSimpleName()), e);
            } else {
                throw new ToolkitInternalException(String.format(EXCEPTION_MESSAGE_FORMAT, scheme, value, svcSVPClass.getSimpleName()), e);
            }
        }

        return result;

    }

    /**
     * Get the {@code public static find(String scheme, String value)} method of the SVPClass.
     * @param svpClass the {@link SchemeValuePair} subclass for the {@code find} method
     * @return the method
     * @throws ToolkitInternalException if the SchemeValuePair subclass does not have a {@code public static find(String scheme, String value)} method.
     */
    public static Method getFindMethod(final Class<? extends SchemeValuePair> svpClass) throws ToolkitInternalException {
        Method findMethod = FIND_METHODS_BY_CLASS.get(svpClass);
        if (findMethod == null) {
            try {
                findMethod = svpClass.getMethod("find", String.class, String.class);
                FIND_METHODS_BY_CLASS.put(svpClass, findMethod);
            } catch (NoSuchMethodException e) {
                throw new ToolkitInternalException("Exception finding SchemeValuePair.find method of '" + svpClass.getName() + "' class.", e);
            }
        }
        return findMethod;
    }

}
