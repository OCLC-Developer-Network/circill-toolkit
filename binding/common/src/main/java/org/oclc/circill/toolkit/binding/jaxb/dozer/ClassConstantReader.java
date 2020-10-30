/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.dozer.MappingException;

/**
 * Utilities for reading constant fields of classes.
 */
public final class ClassConstantReader {

    /**
     * This utility class does not allow instances.
     */
    private ClassConstantReader() {
    }

    /**
     * Returns a class constant's string value.
     * @param classNameAndConstantName String with a format of className.constantName.
     * example: org.oclc.ncip.v2.binding.circillv2_0.ncip.schemes.OCLCPickupLocationScheme.BRANCH_ID_SCHEME_URI
     * @return the constant's string value
     * @throws MappingException -
     */
    public static String valueOf(final String classNameAndConstantName) throws MappingException {
        if (StringUtils.isBlank(classNameAndConstantName)) {
            throw new IllegalArgumentException("classNameAndConstantName cannot not be null or blank");
        }
        final int lastDotIndex = classNameAndConstantName.lastIndexOf('.');
        if (lastDotIndex < 0) {
            throw new IllegalArgumentException("classNameAndConstantName must contain at least one dot");
        }

        try {
            final String className = classNameAndConstantName.substring(0, lastDotIndex);
            final String fieldName = classNameAndConstantName.substring(lastDotIndex + 1);
            final Class<?> clazz = Class.forName(className);
            final Field field = clazz.getField(fieldName);
            final Object fieldValue = field.get(null);
            return fieldValue == null ? null : fieldValue.toString();
        } catch (final ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            throw new MappingException(String.format("Exception occurred while processing '%s' parameter.", classNameAndConstantName), e);
        }
    }
}
