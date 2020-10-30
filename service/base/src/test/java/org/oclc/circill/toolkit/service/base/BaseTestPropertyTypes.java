/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import static org.oclc.circill.toolkit.service.base.ReflectionHelper.ALL_CLASSES_NAME_PATTERN;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;

/**
 * Ensure that all messages have property names that match the property type (with allowances for known aliases and unusual cases).
 * This is intended to prevent obscure failures in the BaseContentConverter which assumes this correlation.
 * Note: Collection properties (e.g. those represented by lists) are expected to have 3 getters and 3 setters:
 * <pre>{@code
 *     public List<BibliographicItemId> getBibliographicItemIds();
 *     public BibliographicItemId getBibliographicItemId();
 *     public BibliographicItemId getBibliographicItemId(int index);
 *     public void setBibliographicItemIds(List<BibliographicItemId> bibliographicItemIds);
 *     public void setBibliographicItemId(int index, BibliographicItemId bibliographicItemId);
 *     public void setBibliographicItemId(BibliographicItemId bibliographicItemId;
 * }</pre>
 * The ones <em>without</em> the index parameter are required by the logic of the BaseContentConverter and this unit test verifies that.
 */
public abstract class BaseTestPropertyTypes {

    protected static final Pattern SIMPLIFY_RAW_TYPE_NAME_PATTERN = Pattern.compile("^.*\\.([^.<>]*)$");
    protected static final Pattern SIMPLIFY_GENERIC_TYPE_NAME_PATTERN = Pattern.compile("^.*\\.([^.]*)>$");

    private static final Set<String> EXCLUDED_PROPERTIES;

    static {
        final Set<String> tempSet = new HashSet<>();
        tempSet.add("class");
        tempSet.add("stackTrace");
        EXCLUDED_PROPERTIES = Collections.unmodifiableSet(tempSet);
    }

    /**
     * The set of primitive types. These are exceptions because the property name has no correlation to the data type
     * and BaseContentConverter does not rely on the property-name-to-type assumption.
     */
    private static final Set<String> PRIMITIVE_TYPES;

    static {
        final Set<String> tempSet = new HashSet<>();
        tempSet.add("String");
        tempSet.add("BigDecimal");
        tempSet.add("Boolean");
        tempSet.add("boolean");
        tempSet.add("GregorianCalendar");
        tempSet.add("Integer");
        PRIMITIVE_TYPES = Collections.unmodifiableSet(tempSet);
    }

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    /**
     * Test that property names match the types of the getters and setters.
     * @param packageName Java package name
     * @param aliases A map of (non-primitive) property names with type names that do not (allowing for pluralization) match the simple name of the class used to represent it
     * in the Toolkit.
     * @param skippableClasses A {@link Predicate} which returns true for classes to skip (e.g. they are immutable and therefore lack setters)
     * @param skippableProperties Classes A {@link BiPredicate} which returns true for class, property name combinations to skip
     * @throws ToolkitInternalException if a reflection operation or class loading fails
     */
    protected void testPropertyNamesMatchGetterAndSetterTypes(final String packageName, final Map<String /*Property Name*/, String /*Type Name*/> aliases,
        final Predicate<Class<?>> skippableClasses, final BiPredicate<Class<?>, String> skippableProperties) throws ToolkitInternalException {

        final List<Class<Object>> classes = ReflectionHelper.findClassesInPackage(packageName, ALL_CLASSES_NAME_PATTERN);
        for (final Class<?> clazz : classes) {
            testClass(clazz, aliases, skippableClasses, skippableProperties);
        }
    }

    /**
     * Test a class.
     * @param clazz class to test
     * @param aliases map of property-to-type name aliases
     * @param skippableClasses classes that should not be tested
     * @param skippableProperties property names that should not be tested
     * @throws ToolkitInternalException if introspection fails
     */
    protected void testClass(final Class<?> clazz, final Map<String /*Property Name*/, String /*Type Name*/> aliases, final Predicate<Class<?>> skippableClasses,
        final BiPredicate<Class<?>, String> skippableProperties) throws ToolkitInternalException {
        if (classIsNotCoveredByTheseRules(clazz, skippableClasses)) {
            return;
        }
        try {
            for (final PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(clazz).getPropertyDescriptors()) {
                testProperty(clazz, propertyDescriptor, aliases, skippableProperties);
            }
        } catch (IntrospectionException e) {
            throw new ToolkitInternalException("Introspection failed:", e);
        }
    }

    /**
     * Test a property.
     * @param clazz class to test
     * @param propertyDescriptor property descriptor of the property to test
     * @param aliases map of property-to-type name aliases
     * @param skippableProperties property names that should not be tested
     */
    protected void testProperty(final Class<?> clazz, final PropertyDescriptor propertyDescriptor, final Map<String /*Property Name*/, String /*Type Name*/> aliases,
         final BiPredicate<Class<?>, String> skippableProperties) {
        final String propertyName = propertyDescriptor.getName();
        if (propertyIsNotCoveredByTheseRules(propertyName)) {
            return;
        }
        final Method writeMethod = propertyDescriptor.getWriteMethod();
        final Method readMethod = propertyDescriptor.getReadMethod();
        if (writeMethod != null && readMethod != null) {
            testStandardProperty(clazz, propertyName, writeMethod, readMethod, aliases);
        } else {
            testNonStandardProperty(clazz, propertyName, writeMethod, readMethod, skippableProperties);
        }
    }

    /**
     * Test a 'standard' property, i.e. one with both read and write methods.
     * @param clazz class to test
     * @param propertyName property name to test
     * @param writeMethod the property's write method
     * @param readMethod the property's read method
     * @param aliases map of property-to-type name aliases
     */
    protected void testStandardProperty(final Class<?> clazz, final String propertyName, final Method writeMethod, final Method readMethod,
        final Map<String /*Property Name*/, String /*Type Name*/> aliases) {
        final String writeMethodParameterTypeName = getSimplifiedTypeName(writeMethod.getGenericParameterTypes()[0].getTypeName());
        final String readMethodParameterTypeName = getSimplifiedTypeName(readMethod.getGenericReturnType().getTypeName());

        if (bothMethodsParameterTypesArePrimitive(writeMethodParameterTypeName, readMethodParameterTypeName)) {
            return;
        }

        final String expectedTypeName = aliases.getOrDefault(propertyName, propertyName);

        collector.checkThat("Property name for " + clazz.getSimpleName() + " doesn't match write method's parameter type.", writeMethodParameterTypeName,
            equalToIgnoringCase(expectedTypeName));
        collector.checkThat("Property name for " + clazz.getSimpleName() + " doesn't match read method's return type.", readMethodParameterTypeName,
            equalToIgnoringCase(expectedTypeName));

    }

    /**
     * Test a 'non-standard' property, i.e. one that lacks either a read or a write method.
     * @param clazz class to test
     * @param propertyName property name to test
     * @param writeMethod the property's write method
     * @param readMethod the property's read method
     * @param skippableProperties property names that should not be tested
     */
    @SuppressWarnings("checkstyle:returncount")
    protected void testNonStandardProperty(final Class<?> clazz, final String propertyName, final Method writeMethod, final Method readMethod,
        final BiPredicate<Class<?>, String> skippableProperties) {
        if (!hasPluralReadAndWriteMethod(clazz, propertyName) || readMethod != null || writeMethod != null) {
            if (SchemeValuePair.class.isAssignableFrom(clazz)) {
                if ("scheme".equals(propertyName) || "value".equals(propertyName)) {
                    if (readMethod != null) {
                        return; // SchemeValuePair classes are expected to have only read methods for these properties.
                    }
                } else if (skippableProperties.test(clazz, propertyName)) {
                    return;
                }
            }
            collector.checkThat("Write method is null for " + clazz.getSimpleName() + ", " + propertyName, writeMethod, notNullValue());
            collector.checkThat("Read method is null for " + clazz.getSimpleName() + ", " + propertyName, readMethod, notNullValue());
        } // No need to test, as BaseContentConverter relies only on the pluralized (collection) read and write methods.
    }

    private boolean classIsNotCoveredByTheseRules(final Class<?> clazz, final Predicate<Class<?>> skippableClasses) {
        return (clazz.isInterface() || clazz.isEnum() || Exception.class.isAssignableFrom(clazz) || clazz.getName().matches(".*\\.Test.*") || skippableClasses.test(clazz));
    }

    private boolean propertyIsNotCoveredByTheseRules(final String propertyName) {
        return EXCLUDED_PROPERTIES.contains(propertyName);
    }

    private boolean bothMethodsParameterTypesArePrimitive(final String writeMethodParameterTypeName, final String readMethodParameterTypeName) {
        return PRIMITIVE_TYPES.contains(writeMethodParameterTypeName) && PRIMITIVE_TYPES.contains(readMethodParameterTypeName);
    }

    private boolean hasPluralReadAndWriteMethod(final Class<?> clazz, final String propertyName) {
        final String upperCasedPropertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        boolean hasPluralReadMethod;
        try {
            clazz.getDeclaredMethod("get" + upperCasedPropertyName + "s");
            hasPluralReadMethod = true;
        } catch (NoSuchMethodException e) {
            hasPluralReadMethod = false;
        }

        boolean hasPluralWriteMethod;
        try {
            clazz.getDeclaredMethod("set" + upperCasedPropertyName + "s", List.class);
            hasPluralWriteMethod = true;
        } catch (NoSuchMethodException e) {
            hasPluralWriteMethod = false;
        }

        return hasPluralReadMethod && hasPluralWriteMethod;
    }

    protected abstract String getSimplifiedTypeName(String input);
}
