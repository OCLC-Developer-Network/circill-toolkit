/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Matcher;

import org.junit.Test;

/**
 * {@inheritDoc}
 */
public class TestPropertyTypes extends BaseTestPropertyTypes {
    /**
     * These are the known cases where a property's type is not a primitive type and
     * does not (allowing for pluralization) match the simple name of the class used
     * to represent it in the Toolkit.
     * This list should have a matching list (with the exception that keys begin with upper case letters) in BaseContentConverter.
     */
    private static final Map<String /*Property Name*/, String /*Type Name*/> ALIASES = Collections.emptyMap();

    /**
     * The classes have no testable properties.
     * These classes are immutable, therefore lack setters and can not be tested.
     */
    private static final Predicate<Class<?>> SKIPPABLE_CLASSES = (c) -> c.getSimpleName().matches("^(ExceptionDescription|ProcessingExceptionType)");

    /**
     * The properties which can be skipped.
     * CurrencyCode is a SchemeValuePair with an additional property, minorUnit, which is expected to have only a read method.
     */
    private static final BiPredicate<Class<?>, String> SKIPPABLE_PROPERTIES = (c, s) -> CurrencyCode.class.isAssignableFrom(c) && "minorUnit".equals(s);

    @Test
    public void testPropertyNamesMatchGetterAndSetterTypes() throws ReflectiveOperationException, ToolkitException, ServiceException, IOException, IntrospectionException {
        final String packageName = TestPropertyTypes.class.getPackage().getName();
        super.testPropertyNamesMatchGetterAndSetterTypes(packageName, ALIASES, SKIPPABLE_CLASSES, SKIPPABLE_PROPERTIES);
    }

    @Override
    protected String getSimplifiedTypeName(final String input) {
        final String simpleTypeName;
        final Matcher rawTypeMatcher = SIMPLIFY_RAW_TYPE_NAME_PATTERN.matcher(input);
        if (rawTypeMatcher.matches()) {
            simpleTypeName = rawTypeMatcher.group(1);
        } else {
            final Matcher genericTypeMatcher = SIMPLIFY_GENERIC_TYPE_NAME_PATTERN.matcher(input);
            if (genericTypeMatcher.matches()) {
                if (input.matches("java.util.List<.*>$")) {
                    if (input.matches(".*\\.Address>$")) {
                        simpleTypeName = genericTypeMatcher.group(1) + "es";
                    } else {
                        simpleTypeName = genericTypeMatcher.group(1) + "s";
                    }
                } else {
                    simpleTypeName = genericTypeMatcher.group(1);
                }
            } else {
                simpleTypeName = input;
            }
        }
        return simpleTypeName;
    }
}
