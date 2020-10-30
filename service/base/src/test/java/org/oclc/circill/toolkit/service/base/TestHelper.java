/*
 * Copyright (c) 2014 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;

/**
 * Utility methods for tests.
 */
public final class TestHelper {

    private static final Logger LOG = Logger.getLogger(TestHelper.class);

    /**
     * This utility class does not allow instances.
     */
    private TestHelper() {
    }

    /**
     * Verifies that a utility class is well defined.
     * From http://stackoverflow.com/questions/4520216/how-to-add-test-coverage-to-a-private-constructor.
     * Github source: https://github.com/trajano/maven-jee6/tree/master/maven-jee6-test
     *
     * @param clazz utility class to verify.
     * @throws ReflectiveOperationException problem accessing the class or its elements using reflection.
     */
    public static void assertUtilityClassWellDefined(final Class<?> clazz) throws ReflectiveOperationException {
        assertTrue(clazz.getName() + " is not final.", Modifier.isFinal(clazz.getModifiers()));
        assertTrue(clazz.getName() + " does not have one and only one constructor.", clazz.getDeclaredConstructors().length == 1);
        final Constructor<?> constructor = clazz.getDeclaredConstructor();
        assertFalse(clazz.getName() + " constructor should not be accessible.", constructor.isAccessible());
        assertTrue(clazz.getName() + " constructor should be private.", Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
        constructor.setAccessible(false);
        for (final Method method : clazz.getMethods()) {
            assertTrue(clazz.getName() + "." + method.getName() + "(" + ReflectionHelper.formatClassNames(method.getParameterTypes()) + ") should be static.",
                Modifier.isStatic(method.getModifiers()) || !method.getDeclaringClass().equals(clazz));
        }
    }

    /**
     * Verify that all SchemeValuePair subclasses in a package have loadAll methods that do not fail, and that at least one static SchemeValuePair field can be accessed.
     * @param packageName the package
     * @throws ToolkitInternalException -
     * @throws InvocationTargetException -
     * @throws IllegalAccessException -
     * @throws ConfigurationException -
     */
    public static void verifyLoadAllMethods(final String packageName) throws ToolkitInternalException, InvocationTargetException, IllegalAccessException, ConfigurationException {
        final List<Class<SchemeValuePair>> classes = ReflectionHelper.findClassesInPackage(packageName, ".*", ".*\\.Test.*", SchemeValuePair.class);
        for (final Class clazz : classes) {
            if (SchemeValuePair.class.isAssignableFrom(clazz) && !clazz.isInterface()) {
                boolean hasStaticInstancesOfSVPType = false;
                Field sampleSVPField = null;
                final Field[] fields = clazz.getFields();
                for (final Field field : fields) {
                    if (SchemeValuePair.class.isAssignableFrom(field.getType())) {
                        sampleSVPField = field;
                        hasStaticInstancesOfSVPType = true;
                        break;
                    }
                }
                if (hasStaticInstancesOfSVPType) {
                    try {
                        final Method m = ((Class<? extends SchemeValuePair>) clazz).getMethod("loadAll");
                        m.invoke(null);
                        final SchemeValuePair svpInstanceFromField = (SchemeValuePair) sampleSVPField.get(null);
                        final SchemeValuePair svpInstanceFromFind = SchemeValuePairHelper
                            .findSchemeValuePair(clazz, svpInstanceFromField.getScheme(), svpInstanceFromField.getValue());
                        assertSame(svpInstanceFromField, svpInstanceFromFind);
                        LOG.debug(clazz.getName() + " passed.");
                    } catch (NoSuchMethodException e) {
                        fail("Class " + clazz.getName() + " is a subclass of SchemeValuePair and has static instances of itself but does not implement the loadAll method.");
                    } catch (InvocationTargetException e) {
                        fail("Class " + clazz.getName() + " is a subclass of SchemeValuePair and has static instances of itself but calling the loadAll method failed.");
                    }
                } else {
                    LOG.debug(clazz.getName() + " not tested.");
                }
            }
        }
    }

    /**
     * Verify that all {@link SchemeValuePair} sub-classes require Scheme URIs (excepting those in the expectedClassesThatDontRequireScheme list).
     * @param packageName the package to scan for {@link SchemeValuePair} sub-classes
     * @param expectedClassesThatDontRequireScheme the possibly-empty list of {@link SchemeValuePair} sub-classes that are known not to have Scheme URIs.
     * @throws ToolkitInternalException -
     */
    public static void verifySVPSubclassesRequireSchemes(final String packageName, final List<String> expectedClassesThatDontRequireScheme) throws ToolkitInternalException {
        final List<Class<SchemeValuePair>> classes = ReflectionHelper.findClassesInPackage(packageName, ".*", ".*\\.Test.*", SchemeValuePair.class);
        final List<String> classesThatDoNotRequireScheme = new ArrayList<>();
        for (final Class<?> clazz : classes) {
            if (SchemeValuePair.class.isAssignableFrom(clazz) && !clazz.isInterface()) {
                try {
                    clazz.getConstructor(String.class);
                    classesThatDoNotRequireScheme.add(clazz.getSimpleName());
                } catch (NoSuchMethodException e) {
                    // the normal case
                }
            }
        }
        if (expectedClassesThatDontRequireScheme == null || expectedClassesThatDontRequireScheme.size() > 0) {
            assertThat(classesThatDoNotRequireScheme, containsInAnyOrder(expectedClassesThatDontRequireScheme.toArray(new String[classesThatDoNotRequireScheme.size()])));
        } else {
            assertEquals(0, classesThatDoNotRequireScheme.size());
        }
    }
}
