/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import org.oclc.circill.toolkit.service.base.SchemeValuePair;

import org.dozer.ConfigurableCustomConverter;
import org.dozer.MappingException;

/**
 * Class for converting between Scheme-value pairs and Booleans using Dozer
 *
 * The class is provided with a scheme-value pair that reflects a "true" value, and conversions are performed based on the
 * presence of the scheme-value pair.
 *
 */
public class SVPBooleanConverter implements ConfigurableCustomConverter {

    private final ConstantFieldValueResolver<SchemeValuePair> schemeValuePairConstantFieldValueResolver = new ConstantFieldValueResolver<>(SchemeValuePair.class);

    /** Scheme-value pair to use for a "true" Boolean value */
    private SchemeValuePair parameter;

    @Override
    public Object convert(final Object destination, final Object source, final Class<?> destinationClass, final Class<?> sourceClass) {
        final boolean isBooleanToSvp = SchemeValuePair.class.isAssignableFrom(destinationClass) && Boolean.class.isAssignableFrom(sourceClass);
        final boolean isSvpToBoolean = Boolean.class.isAssignableFrom(destinationClass) && SchemeValuePair.class.isAssignableFrom(sourceClass);
        final boolean isStringBooleanToSvp = SchemeValuePair.class.isAssignableFrom(destinationClass) && String.class.isAssignableFrom(sourceClass);
        final boolean isSvpToStringBoolean = SchemeValuePair.class.isAssignableFrom(sourceClass);

        final Object convertedObject;
        if (isBooleanToSvp) {
            convertedObject = convertToSchemeValuePair((Boolean) source);
        } else if (isSvpToBoolean) {
            convertedObject = convertToBoolean((SchemeValuePair) source);
        } else if (isStringBooleanToSvp) {
            convertedObject = convertToSchemeValuePair((String) source);
        } else if (isSvpToStringBoolean) {
            convertedObject = convertToString((SchemeValuePair) source);
        } else {
            throw new MappingException("Unable to convert object of type '" + sourceClass.getName() + "' to '" + destinationClass.getName() + "'."
                + " Only Boolean <-> SchemeValuePair transformations are permitted");
        }

        return convertedObject;
    }

    /**
     * Convert a scheme-value pair to a boolean value
     *
     * If the provided scheme-value pair does match the {@link #parameter}, then it is converted to a 'true' boolean value.
     * If the {@link #parameter} is not equal, or a null scheme-value pair is provided, then it is converted to a 'false' boolean value
     *
     * @param schemeValuePair scheme-value pair to convert into a boolean value
     * @return true if the scheme-value pair matches the parameter value, false otherwise
     */
    private boolean convertToBoolean(final SchemeValuePair schemeValuePair) {
        return getParameter().equals(schemeValuePair);
    }

    /**
     * Convert a scheme-value pair to a string value
     *
     * If the provided scheme-value pair does match the {@link #parameter}, then it is converted to a 'true' string value.
     * If the {@link #parameter} is not equal, or a null scheme-value pair is provided, then it is converted to a 'false' string value
     *
     * @param schemeValuePair scheme-value pair to convert into a boolean value
     * @return boolean string, "true" if the scheme-value pair matches the parameter value, false otherwise
     */
    private String convertToString(final SchemeValuePair schemeValuePair) {
        return String.valueOf(getParameter().equals(schemeValuePair));
    }

    /**
     * Convert a boolean to a scheme-value pair
     *
     * If the provided Boolean value is true then the {@link #parameter} value is returned,
     * If the provided Boolean value is false or null, then a null scheme-value pair is returned
     *
     * @param bool boolean value to convert into a scheme-value pair
     * @return the {@link #parameter} value if the boolean is true, null otherwise
     */
    private SchemeValuePair convertToSchemeValuePair(final Boolean bool) {
        return bool != null && bool ? getParameter() : null;
    }

    /**
     * Convert a boolean string to a scheme-value pair
     *
     * If the provided String value is "true" then the {@link #parameter} value is returned,
     * If the provided String value is anything else, then a null scheme-value pair is returned
     *
     * @param string boolean string value to convert into a scheme-value pair
     * @return the {@link #parameter} value if the boolean is true, null otherwise
     */
    private SchemeValuePair convertToSchemeValuePair(final String string) {
        return Boolean.valueOf(string) ? getParameter() : null;
    }

    /**
     * Get the {@link #parameter} scheme-value pair value.
     *
     * Throws an {@link IllegalStateException} if the parameter has not been set
     *
     * @return {@link #parameter} value
     */
    private SchemeValuePair getParameter() {
        if (parameter == null) {
            throw new IllegalStateException("Custom parameter has not been set for this class");
        }
        return this.parameter;
    }

    /**
     * Derives a scheme-value pair from a qualified string representation of a scheme-value pair constant field
     * The derived scheme-value pair is then set as the class's {@link #parameter}
     *
     * @param parameterString qualified string representation of a public constant field, e.g.
     *                        org.oclc.SchemeValueClass.CONSTANT_FIELD
     * @throws MappingException if an error occurs whilst obtaining the constant fields value
     */
    @Override
    public void setParameter(final String parameterString) {
        this.parameter = schemeValuePairConstantFieldValueResolver.resolve(parameterString);
    }

}
