/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import static org.oclc.circill.toolkit.service.base.ReflectionHelper.ALL_CLASSES_NAME_PATTERN;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

/**
 * Base class for tests that verify all subclasses of {@link Service} conform to API design rules, which are:
 * 1) Exceptions thrown by public methods must be subclasses of {@link ToolkitException}.
 * 2) Subclasses of {@link Service} must specify that they can throw {@link ServiceException} and {@link ValidationException}, but no others.
 * Subclasses (for particular protocols) may add other "allowed" exceptions to the above rules (see e.g. the ISO 18626 package's subclass).
 */
public abstract class BaseTestServiceAPIRules {

    private static final Logger LOG = Logger.getLogger(BaseTestServiceAPIRules.class);

    private static final String EXCLUDED_METHODS = "^(wait)$";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    protected void testAll(final String packageName) throws IOException, ClassNotFoundException, NoSuchMethodException, ToolkitInternalException {
        testAll(packageName, Collections.emptyMap());
    }

    protected void testAll(final String packageName, final Map<String /* Class name*/, Map<String /* Method name */, Set<Class<? extends Throwable>>>> otherAllowedExceptions)
        throws IOException, ClassNotFoundException, NoSuchMethodException, ToolkitInternalException {
        testExceptionsThrownByPublicMethods(packageName, otherAllowedExceptions);
        testExceptionsThrownByServices(packageName);
    }

    /**
     * Check that all classes in the package with names ending in "Service":
     * 1) Implement {@link Service} interface.
     * 2) The performService method has a throw statement for both ServiceException and ValidationException, and no others.
     * @param packageName the package to test members of
     * @throws IOException -
     * @throws ClassNotFoundException -
     * @throws NoSuchMethodException -
     * @throws ToolkitInternalException -
     */
    public void testExceptionsThrownByServices(final String packageName) throws IOException, ClassNotFoundException, NoSuchMethodException, ToolkitInternalException {
        final List<Class<Service>> classes = ReflectionHelper.findClassesInPackage(packageName, "^.*Service$", null, Service.class);
        int classCount = 0;
        for (final Class<?> clazz : classes) {
            if (clazz.getName().matches(".*\\.Test[a-zA-Z0-9$]*$")) {
                continue;
            }
            final Method[] declaredMethods = clazz.getDeclaredMethods();
            Method performServiceMethod = null;
            for (final Method m : declaredMethods) {
                if ("performService".equals(m.getName())) {
                    performServiceMethod = m;
                    break;
                }
            }
            if (performServiceMethod != null) {
                final Class<?>[] exceptionTypes = performServiceMethod.getExceptionTypes();
                boolean hasServiceException = false;
                boolean hasValidationException = false;
                final List<Class<?>> otherExceptions = new ArrayList<>();
                for (final Class<?> exception : exceptionTypes) {
                    if (ServiceException.class.equals(exception)) {
                        hasServiceException = true;
                    } else if (ValidationException.class.equals(exception)) {
                        hasValidationException = true;
                    } else {
                        otherExceptions.add(exception);
                    }
                }
                collector.checkThat(clazz.getName() + " doesn't have ServiceException", hasServiceException, is(true));
                collector.checkThat(clazz.getName() + " doesn't have ValidationException", hasValidationException, is(true));
                collector.checkThat(clazz.getName() + " has other exceptions", otherExceptions, equalTo(Collections.emptyList()));
            } else {
                collector.checkThat(clazz.getName() + " does not have a performService method.", anything());
            }
            classCount++;
        }
        LOG.info("Tested exception behavior for " + classCount + " Service implementations classes.");
    }

    protected void testExceptionsThrownByPublicMethods(final String packageName) throws ToolkitInternalException {
        testExceptionsThrownByPublicMethods(packageName, Collections.emptyMap());
    }

    /**
     * Check that all Service API classes:
     * 1) Have a performService method
     * 2) The performService method has a throw statement for ServiceException and ValidationException, and no others.
     * @param packageName the package to test members of
     * @param inputOtherAllowedExceptions optional map of class-name to a map of method-names-to-exception-classes of allowed deviations from this rule
     * @throws ToolkitInternalException -
     */
    protected void testExceptionsThrownByPublicMethods(final String packageName,
        final Map<String /* Class name*/, Map<String /* Method name */, Set<Class<? extends Throwable>>>> inputOtherAllowedExceptions) throws ToolkitInternalException {
        int classCount = 0;
        int methodCount = 0;
        final Map<String /* Class name*/, Map<String /* Method name */, Set<Class<? extends Throwable>>>> otherAllowedExceptions = copy(inputOtherAllowedExceptions);
        final List<Class<Object>> classes = ReflectionHelper
            .findClassesInPackage(packageName, ALL_CLASSES_NAME_PATTERN, ".*\\.((Base)?Test[a-zA-Z0-9$]*|[A-Z][a-zA-Z0-9$]*Test|ReflectionHelper)$");
        for (final Class<?> clazz : classes) {
            LOG.debug("Testing exceptions thrown by public methods " + clazz.getName());
            final Method[] publicMethods = clazz.getMethods();
            methodCount+= testMethods(clazz, publicMethods, otherAllowedExceptions);
            classCount++;
        }
        collector.checkThat("After testing, there are unnecessary entries in the inputOtherAllowedExceptions map:", otherAllowedExceptions, equalTo(Collections.emptyMap()));
        LOG.info("Tested exception behavior for " + classCount + " classes and " + methodCount + " methods.");
    }

    private int testMethods(final Class<?> clazz, final Method[] publicMethods, final Map<String /* Class name*/, Map<String /* Method name */, Set<Class<? extends Throwable>>>> otherAllowedExceptions) {
        int methodCount = 0;
        for (final Method method : publicMethods) {
            if (!method.getName().matches(EXCLUDED_METHODS)) {
                final Class<?>[] exceptionClasses = method.getExceptionTypes();
                final Map<String, Set<Class<? extends Throwable>>> otherAllowedExceptionForClazz = otherAllowedExceptions.getOrDefault(clazz.getName(), Collections.emptyMap());
                testExceptions(clazz, method, otherAllowedExceptions, otherAllowedExceptionForClazz, exceptionClasses);
                methodCount++;
            }
        }
        return methodCount;
    }

    private void testExceptions(final Class<?> clazz, final Method method, final Map<String /* Class name*/, Map<String /* Method name */, Set<Class<? extends Throwable>>>> otherAllowedExceptions,
        final Map<String, Set<Class<? extends Throwable>>> otherAllowedExceptionForClazz, final Class<?>[] exceptionClasses) {
        for (final Class<?> exceptionClass : exceptionClasses) {
            final Set<Class<? extends Throwable>> otherAllowedExceptionForMethod = otherAllowedExceptionForClazz.getOrDefault(method.getName(), Collections.emptySet());
            if (!otherAllowedExceptionForMethod.contains(exceptionClass)) {
                collector
                    .checkThat("Class " + clazz.getName() + ", method " + method.getName() + " throws exception of invalid type '" + exceptionClass.getName() + "'.",
                        ToolkitException.class.isAssignableFrom(exceptionClass), is(true));
            } else {
                assertTrue(
                    "Program logic error: exception '" + exceptionClass.getName() + "' not in otherAllowedExceptionForMethod" + " immediately after it was there.",
                    otherAllowedExceptionForMethod.remove(exceptionClass));
                if (otherAllowedExceptionForMethod.isEmpty()) {
                    assertNotNull("Program logic error: method '" + method.getName() + "' not in otherAllowedExceptionForClazz" + " immediately after it was there.",
                        otherAllowedExceptionForClazz.remove(method.getName()));
                    if (otherAllowedExceptionForClazz.isEmpty()) {
                        assertNotNull("Program logic error: class '" + clazz.getName() + "' not in otherAllowedExceptions" + " immediately after it was there.",
                            otherAllowedExceptions.remove(clazz.getName()));
                    }
                }
            }
        }
    }

    private static Map<String /* Class name*/, Map<String /* Method name */, Set<Class<? extends Throwable>>>> copy(
        final Map<String /* Class name*/, Map<String /* Method name */, Set<Class<? extends Throwable>>>> original) {
        final Map<String /* Class name*/, Map<String /* Method name */, Set<Class<? extends Throwable>>>> copiedMap = new HashMap<>(original.size());
        for (final Map.Entry<String, Map<String, Set<Class<? extends Throwable>>>> originalMethods : original.entrySet()) {
            final Map<String, Set<Class<? extends Throwable>>> copiedClassMap = new HashMap<>(originalMethods.getValue().size());
            copiedMap.put(originalMethods.getKey(), copiedClassMap);
            for (final Map.Entry<String, Set<Class<? extends Throwable>>> originalExceptions : originalMethods.getValue().entrySet()) {
                copiedClassMap.put(originalExceptions.getKey(), new HashSet<>(originalExceptions.getValue()));
            }
        }
        return copiedMap;
    }
}
