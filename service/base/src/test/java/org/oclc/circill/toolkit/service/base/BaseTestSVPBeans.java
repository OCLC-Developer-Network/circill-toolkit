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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;

/**
 * Subclasses of {@link SchemeValuePair} are verified per the following rules:
 * 1) Have static loadAll methods to ensure the instances defined in the subclass are loaded during Toolkit initialization.
 * 2) Do not have a constructor accepting only a single string parameter except as explicitly indicated in the subclass of this class.
 * 3) The find method returns correct instances.
 */
public abstract class BaseTestSVPBeans {

    private static final Logger LOG = Logger.getLogger(BaseTestSVPBeans.class);

    /**
     * Verify that all SchemeValuePair subclasses in a package have loadAll methods that do not fail, and that at least one static SchemeValuePair field can be accessed.
     * @param packageName the package
     * @throws ToolkitInternalException -
     * @throws InvocationTargetException -
     * @throws IllegalAccessException -
     * @throws ConfigurationException -
     */
    protected static void verifyLoadAllMethods(final String packageName)
        throws ToolkitInternalException, InvocationTargetException, IllegalAccessException, ConfigurationException {
        final List<Class<SchemeValuePair>> classes = ReflectionHelper.findClassesInPackage(packageName, ".*", ".*\\.Test.*", SchemeValuePair.class);
        for (final Class<SchemeValuePair> clazz : classes) {
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
                        final Method m = clazz.getMethod("loadAll");
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

    protected static void verifySVPSubclassesRequireSchemes(final String packageName) throws ToolkitInternalException {
        verifySVPSubclassesRequireSchemes(packageName, Collections.emptyList());
    }

    /**
     * Verify that all {@link SchemeValuePair} sub-classes (excepting those in the expectedClassesThatDontRequireScheme list) do not have a value-only constructor.
     * A value-only constructor is a constructor accepting only a single string (presumably the value).
     * @param packageName the package to scan for {@link SchemeValuePair} sub-classes
     * @param expectedClassesThatDontRequireScheme the possibly-empty list of {@link SchemeValuePair} sub-classes that are known not to have Scheme URIs.
     * @throws ToolkitInternalException -
     */
    protected static void verifySVPSubclassesRequireSchemes(final String packageName, final List<String> expectedClassesThatDontRequireScheme) throws ToolkitInternalException {
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
            if (classesThatDoNotRequireScheme.size() != 0) {
                final String listOfClasses = classesThatDoNotRequireScheme.stream().collect(Collectors.joining(", "));
                fail("The following classes do not require Scheme URIs: " + listOfClasses);
            }
        }
    }

    /**
     * Verify that a package's {@link SchemeValuePair} subclasses find methods work as expected.
     * @param packageName the {@link SchemeValuePair} subclass
     * @throws Exception if an error occurs
     */
    protected static void verifySVPSubclassFindMethods(final String packageName) throws Exception {
        int count = 0;
        final List<Class<SchemeValuePair>> classes = ReflectionHelper.findClassesInPackage(packageName, ".*", ".*\\.Test.*", SchemeValuePair.class);
        for (final Class<?> clazz : classes) {
            final String clazzSimpleName = clazz.getSimpleName();
            if (clazz.getSuperclass().equals(SchemeValuePair.class)) {
                count++;
                LOG.debug("Testing find method of " + clazzSimpleName);
                final SchemeValuePair value1;
                final SchemeValuePair value2;
                if (clazz == CurrencyCode.class) {
                    final Constructor<? extends SchemeValuePair> constructor = (Constructor<? extends SchemeValuePair>) clazz
                        .getDeclaredConstructor(String.class, String.class, int.class);
                    value1 = constructor.newInstance("scheme 1", "value 1", 2);
                    value2 = constructor.newInstance("scheme 2", "value 2", 3);
                } else {
                    final Constructor<? extends SchemeValuePair> constructor = (Constructor<? extends SchemeValuePair>) clazz.getDeclaredConstructor(String.class, String.class);
                    value1 = constructor.newInstance("scheme 1", "value 1");
                    value2 = constructor.newInstance("scheme 2", "value 2");
                }
                final Method findMethod = clazz.getDeclaredMethod("find", String.class, String.class);

                final SchemeValuePair assignedValue1 = value1;
                final SchemeValuePair foundValue1 = (SchemeValuePair) findMethod.invoke(null, value1.getScheme(), value1.getValue());
                assertSame(clazzSimpleName + ".find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

                final SchemeValuePair secondAssignedValue1 = value1;
                assertSame("Two instances assigned the same " + clazzSimpleName + " constant aren't the same object.", assignedValue1, secondAssignedValue1);

                final SchemeValuePair secondFoundValue1 = (SchemeValuePair) findMethod.invoke(null, value1.getScheme(), value1.getValue());
                assertSame("Two instances returned by " + clazzSimpleName + ".find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

                final SchemeValuePair foundValue2 = (SchemeValuePair) findMethod.invoke(null, value2.getScheme(), value2.getValue());
                assertNotSame(clazzSimpleName + ".find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

                final SchemeValuePair assignedValue2 = value2;
                assertNotSame("Two instances assigned different " + clazzSimpleName + " constants are not different objects.", assignedValue1, assignedValue2);

                assertNotSame("Two instances returned by " + clazzSimpleName + ".find method with different parameters aren't different objects.", foundValue1, foundValue2);
            } else {
                LOG.debug("Skipping " + clazz.getSimpleName() + " as not an immediate subclass of SchemeValuePair.");
            }
        }
        LOG.debug(count + " classes tested.");
    }
}
