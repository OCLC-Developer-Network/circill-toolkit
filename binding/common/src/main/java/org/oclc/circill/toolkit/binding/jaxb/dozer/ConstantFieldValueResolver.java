/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import java.lang.reflect.Field;

import org.dozer.MappingException;

/**
 * Class for resolving public constant field values based on a fully-qualified string.
 *
 * A constant field is defined as a variable with the prefix "public static final"
 * A fully-qualified string is defined as a string containing the package, class, and constant field's name,
 *  for example, java.lang.Long.MAX_VALUE for the MAX_VALUE constant field within java.lang.Long
 *
 * <em>Note: This does not work for primitive values at the current time</em>
 *
 * @param <T> the type of constants fields resolved by this class
 */
public class ConstantFieldValueResolver<T> {

    /** Mapping Exception message format */
    private static final String EXCEPTION_MESSAGE_FORMAT = "%s. Constant field '%s' on class '%s'";

    private final Class<T> constantFieldClass;

    /**
     * Create a new constant field resolver for the provided class type
     * @param constantFieldClass class of the constant field values
     */
    public ConstantFieldValueResolver(final Class<T> constantFieldClass) {
        this.constantFieldClass = constantFieldClass;
    }

    /**
     * Resolves a public constant field's value, based on the fully-qualified name of the constant field.
     * The field name must be of type {@link T} otherwise a {@link MappingException} will be thrown
     *
     * @param qualifiedConstantFieldName fully qualified name of the class (e.g. java.lang.Long.MAX_VALUE)
     * @return value of the public constant field
     */
    public T resolve(final String qualifiedConstantFieldName) {
        final int constantQualifierIndex = qualifiedConstantFieldName.lastIndexOf('.');
        final String qualifiedClass = qualifiedConstantFieldName.substring(0, constantQualifierIndex);
        final String constantFieldName = qualifiedConstantFieldName.substring(constantQualifierIndex + 1);

        return getConstantValue(qualifiedClass, constantFieldName);
    }

    /**
     * Resolves a public constant field's value, based on the class name and field name.
     * The field name must be of type {@link T} otherwise a {@link MappingException} will be thrown
     *
     * @param className fully qualified name of the class (e.g. java.lang.Long)
     * @param constantFieldName name of the constant field (e.g. MAX_VALUE)
     * @return value of the public constant field
     */
    @SuppressWarnings("unchecked")
    private T getConstantValue(final String className, final String constantFieldName) {
        final Field constantField = getConstantField(className, constantFieldName);

        if (!this.constantFieldClass.isAssignableFrom(constantField.getType())) {
            throw new MappingException(
                String.format(EXCEPTION_MESSAGE_FORMAT, "Provided constant field is not of type " + constantFieldClass.getSimpleName(), constantFieldName, className));
        }

        try {
            return (T) constantField.get(null);
        } catch (IllegalAccessException e) {
            throw new MappingException(String.format(EXCEPTION_MESSAGE_FORMAT, "Provided constant field is not accessible", constantFieldName, className), e);
        }
    }

    /**
     * Gets a public constant field, based on the class name and field name, as a {@link Field}
     *
     * @param className fully qualified name of the class (e.g. java.lang.Long)
     * @param constantFieldName name of the constant field (e.g. MAX_VALUE)
     * @return field representing the specified public constant field
     * @throws MappingException if the class or field cannot be found
     */
    private Field getConstantField(final String className, final String constantFieldName) {
        try {
            final Class clazz = Class.forName(className);
            return clazz.getField(constantFieldName);
        } catch (ClassNotFoundException e) {
            throw new MappingException("Unable to find the class '" + className + "'", e);
        } catch (NoSuchFieldException e) {
            throw new MappingException(String.format(EXCEPTION_MESSAGE_FORMAT, "Unable to find the constant field", constantFieldName, className), e);
        }
    }
}
