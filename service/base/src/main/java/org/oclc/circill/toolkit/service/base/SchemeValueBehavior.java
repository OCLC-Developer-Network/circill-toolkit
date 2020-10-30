/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import org.apache.log4j.Logger;

/**
 * Defines named behaviors that can be set via configuration for a Scheme.
 * See {@link SchemeValuePair} for definitions of some concepts used here.
 */
public abstract class SchemeValueBehavior {

    private static final Logger LOG = Logger.getLogger(SchemeValueBehavior.class);

    public static final String ANY_VALUES_FLAG = "*";

    /**
     * Calls to {@link SchemeValuePair#find(String, String, Class)} which do not find a registered instance will fail with a
     * {@link ServiceError} of {@link ServiceError#INVALID_SCHEME_VALUE} and an exception message indicating that this
     * behavior was unset, i.e. not explicitly configured.
     * <p>This is the default behavior for all elements, unless overridden by configuration.</p>
     */
    public static final SchemeValueBehavior UNSET = new SchemeValueBehavior() {
        @Override
        SchemeValuePair applyBehavior(final String scheme, final String value, final Class<? extends SchemeValuePair> svpClass) throws ConfigurationException {

            if (LOG.isTraceEnabled()) {
                SchemeValuePair.dumpConfiguration(LOG);
            }
            throw new ConfigurationException("No match found for scheme '" + scheme + "', value '" + value + "' in " + svpClass.getName()
                + "; configuration option for defining values for this class is unset.");

        }

        @Override
        public String toString() {
            return "UNSET";
        }
    };

    /**
     * Calls to {@link SchemeValuePair#find(String, String, Class)} which do not find a registered instance will fail with a
     * {@link ServiceException} of {@link ServiceError#INVALID_SCHEME_VALUE} and an exception message indicating that this
     * behavior was "DEFINED_ONLY", i.e. intentional.
     */
    public static final SchemeValueBehavior DEFINED_ONLY = new SchemeValueBehavior() {

        @Override
        SchemeValuePair applyBehavior(final String scheme, final String value, final Class<? extends SchemeValuePair> svpClass) throws ConfigurationException {

            if (LOG.isTraceEnabled()) {
                SchemeValuePair.dumpConfiguration(LOG);
            }
            throw new ConfigurationException("No match found for scheme '" + scheme + "', value '" + value + "' in " + svpClass.getName()
                + "; configuration option for defining values for this class is 'DEFINED_ONLY'.");

        }

        @Override
        public String toString() {
            return "DEFINED_ONLY";
        }
    };

    /**
     * Calls to {@link SchemeValuePair#find(String, String, Class)} will return a match if found, otherwise if there is an instance of SchemeValuePair
     * in the registry with the provided scheme and a value of {@link #ANY_VALUES_FLAG}, a new instance will be created
     * (via {@link SchemeValuePair#SchemeValuePair(String, String)}.
     * This would be suitable for use with an open-ended scheme where the Toolkit should not validate the values, e.g. an {@code AgencyId}.
     * If a matching scheme is not found, this will behave as if the scheme is configured with {@link #DEFINED_ONLY}.
     */
    public static final SchemeValueBehavior ALLOW_ANY_VALUE_IN_KNOWN_SCHEMES = new SchemeValueBehavior() {

        @Override
        SchemeValuePair applyBehavior(final String scheme, final String value, final Class<? extends SchemeValuePair> svpClass)
            throws ConfigurationException, ToolkitInternalException {

            final SchemeValuePair result;

            // Does this Scheme have a Value that matches the ANY_VALUES_FLAG, i.e. does it allow *any* value that is encountered?
            if (SchemeValuePair.search(scheme, ANY_VALUES_FLAG, svpClass) != null) {
                result = ALLOW_ANY.applyBehavior(scheme, value, svpClass);
            } else {
                result = DEFINED_ONLY.applyBehavior(scheme, value, svpClass);
            }
            return result;
        }

        @Override
        public String toString() {
            return "ALLOW_ANY_VALUE_IN_KNOWN_SCHEMES";
        }
    };

    /**
     * Calls to {@link SchemeValuePair#find(String, String, Class)} will return a match if found, otherwise
     * a new instance will be created (via {@link SchemeValuePair#SchemeValuePair(String, String)}.
     */
    public static final SchemeValueBehavior ALLOW_ANY = new SchemeValueBehavior() {

        @Override
        SchemeValuePair applyBehavior(final String scheme, final String value, final Class<? extends SchemeValuePair> svpClass) throws ToolkitInternalException {
            return SchemeValuePair.addIfAbsent(scheme, value, svpClass);
        }

        @Override
        public String toString() {
            return "ALLOW_ANY";
        }
    };

    /**
     * Apply the configured behavior for the supplied Scheme URI, value and {@link SchemeValuePair} sub-class when trying to find or create the Java object
     * representing those parameters.
     * @param scheme the Scheme URI
     * @param value the value
     * @param svpClass the {@link SchemeValuePair} sub-class
     * @return the resulting {@link SchemeValuePair} instance
     * @throws ConfigurationException if the configured behavior is to forbid creating the instance
     * @throws ToolkitInternalException if reflection fails
     */
    abstract SchemeValuePair applyBehavior(String scheme, String value, Class<? extends SchemeValuePair> svpClass) throws ConfigurationException, ToolkitInternalException;

}
