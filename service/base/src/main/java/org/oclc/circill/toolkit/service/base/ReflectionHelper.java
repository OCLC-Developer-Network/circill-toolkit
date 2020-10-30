/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Utility methods for inspection and manipulation of objects via Reflection API.
 */
public final class ReflectionHelper {

    private static final Logger LOG = Logger.getLogger(ReflectionHelper.class);
    private static final char DOT = '.';
    private static final char SLASH = '/';
    private static final String CLASS_SUFFIX = ".class";
    private static final String SERVICE_BASE_PACKAGE_NAME = ReflectionHelper.class.getPackage().getName();
    private static final List<String> NON_SERVICE_DATA_FIELD_NAMES = Collections.singletonList("messageType");
    public static final String ALL_CLASSES_NAME_PATTERN = "^.*";

    private ReflectionHelper() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Handles case-insensitive lookups
     * Note: Tests for plural form of fieldName, e.g. when the field is a collection
     *
     * @param objClass the class to which the field belongs
     * @param fieldName the field name
     * @return the {@link Field}
     */
    public static Field findField(final Class<?> objClass, final String fieldName) {
        return findField(objClass, fieldName, false);
    }

    /**
     * Handles case-insensitive lookups
     * Note: Tests for plural form of fieldName, e.g. when the field is a collection
     *
     * @param objClass the class to which the field belongs
     * @param fieldName the field name
     * @param alreadyPluralized true if the field name is already in plural form
     * @return the {@link Field}
     */
    public static Field findField(final Class<?> objClass, final String fieldName, final boolean alreadyPluralized) {
        LOG.trace("Looking for field " + fieldName + " in " + objClass.getName());
        Field result = null;
        Field[] fields = objClass.getDeclaredFields();
        for (final Field f : fields) {
            if (f.getName().compareToIgnoreCase(fieldName) == 0) {
                result = f;
                break;
            }
        }

        // Handle collections
        if (result == null && !alreadyPluralized) {
            fields = objClass.getDeclaredFields();
            for (final Field f : fields) {
                if (f.getName().compareToIgnoreCase(fieldName + "s") == 0) {
                    result = f;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Return the Method object for the given methodName and parameterTypes on the given objClass, trying
     * to find methods for collections (e.g. appending 's') if there's no match on the simple name.
     *
     * @param objClass the class to which the field belongs
     * @param methodName the method name
     * @param parameterTypes the parameter types of the method
     * @return the {@link Method}
     */
    public static Method findMethod(final Class<?> objClass, final String methodName, final Class<?>... parameterTypes) {
        LOG.trace("Looking for method " + methodName + "(" + formatClassNames(parameterTypes) + ") on " + objClass.getName() + ".");
        Method result = null;
        Method[] methods = objClass.getDeclaredMethods();
        for (final Method m : methods) {
            if (m.getName().compareToIgnoreCase(methodName) == 0) {
                final Class<?>[] methodParameterTypes = m.getParameterTypes();
                if (parametersMatch(methodParameterTypes, parameterTypes)) {
                    result = m;
                    break;
                }
            }
        }

        // Handle collections
        if (result == null) {
            methods = objClass.getDeclaredMethods();
            for (final Method m : methods) {
                if (m.getName().compareToIgnoreCase(methodName + "s") == 0) {
                    final Class<?>[] methodParameterTypes = m.getParameterTypes();
                    if (parametersMatch(methodParameterTypes, parameterTypes)) {
                        result = m;
                        break;
                    }
                }
            }
        }

        if (result == null) {
            LOG.debug("Method " + methodName + "(" + formatClassNames(parameterTypes) + ") on " + objClass.getName() + " not found.");
        }
        return result;
    }

    /**
     * Return the Method object for the getter of the given fieldName on the given objClass.
     *
     * @param objClass class to which the field belongs
     * @param fieldName name of the field
     * @return the getter {@link Method}
     */
    public static Method findSimpleGetter(final Class<?> objClass, final String fieldName) {
        final Method result = findMethod(fieldName, objClass, false, false);
        return result;
    }

    /**
     * Return the Method object for the setter of the given fieldName on the given objClass.
     *
     * @param objClass class to which the field belongs
     * @param fieldName name of the field
     * @return the getter {@link Method}
     */
    public static Method findSimpleSetter(final Class<?> objClass, final String fieldName) {
        final Method result = findMethod(fieldName, objClass, false, true);
        return result;
    }

    private static String buildMethodName(final String fieldName, final boolean isCollection, final boolean wantSetter) {
        final String methodName = (wantSetter ? "set" : "get") + upperCaseFirstLetter(fieldName) + (isCollection ? "s" : "");
        return methodName;
    }

    private static Method findMethod(final String fieldName, final Class<?> objClass, final boolean isCollection, final boolean wantSetter) {
        LOG.trace(
            "Looking for indexed " + (wantSetter ? "setter" : "getter") + " for " + (isCollection ? "collection" : "") + " property " + fieldName + " of " + objClass.getName()
                + ".");
        final String methodName = buildMethodName(fieldName, isCollection, wantSetter);
        final Method[] methods = objClass.getDeclaredMethods();
        Method result = null;
        for (final Method m : methods) {
            if (m.getName().compareToIgnoreCase(methodName) == 0) {
                final Class<?>[] methodParameterTypes = m.getParameterTypes();
                if (methodParameterTypes.length == (wantSetter ? 1 : 0)) {
                    result = m;
                    break;
                }
            }
        }
        if (result == null) {
            LOG.debug("Method " + methodName + "() of " + objClass.getName() + " not found.");
        }
        return result;
    }

    private static Method findIndexedMethod(final String fieldName, final Class<?> objClass, final boolean wantSetter) {
        LOG.trace("Looking for indexed " + (wantSetter ? "setter" : "getter") + " for collection property " + fieldName + " of " + objClass.getName() + ".");
        final String methodName = buildMethodName(fieldName, false, wantSetter);
        final Method[] methods = objClass.getDeclaredMethods();
        Method result = null;
        for (final Method m : methods) {
            if (m.getName().compareToIgnoreCase(methodName) == 0) {
                final Class<?>[] methodParameterTypes = m.getParameterTypes();
                if ((methodParameterTypes.length == (1 + (wantSetter ? 1 : 0)) && methodParameterTypes[0].isAssignableFrom(int.class))) {
                    result = m;
                    break;
                }
            }
        }
        if (result == null) {
            LOG.debug("Method " + methodName + "(int index) of " + objClass.getName() + " not found.");
        }
        return result;
    }

    /**
     * Return the Method object for the getter of the given fieldName on the given objClass.
     *
     * @param objClass class to which the field belongs
     * @param fieldName name of the field
     * @return the getter {@link Method}
     */
    public static Method findCollectionGetter(final Class<?> objClass, final String fieldName) {
        final Method result = findMethod(fieldName, objClass, true, false);
        return result;
    }

    /**
     * Return the Method object for the setter of the given fieldName on the given objClass.
     *
     * @param objClass class to which the field belongs
     * @param fieldName name of the field
     * @return the setter {@link Method} or null if none found
     */
    public static Method findCollectionSetter(final Class<?> objClass, final String fieldName) {
        final Method result = findMethod(fieldName, objClass, true, true);
        return result;
    }

    /**
     * Return the Method object for the indexed getter (e.g. 'getXYZ(1)') of the given fieldName on the given objClass.
     *
     * @param objClass class to which the field belongs
     * @param fieldName name of the field
     * @return the getter {@link Method}
     */
    public static Method findIndexedCollectionGetter(final Class<?> objClass, final String fieldName) {
        final Method result = findIndexedMethod(fieldName, objClass, false);
        return result;
    }

    /**
     * Return the Method object for the indexed setter (e.g. 'setXYZ(1)') of the given fieldName on the given objClass.
     *
     * @param objClass class to which the field belongs
     * @param fieldName name of the field
     * @return the setter {@link Method}
     */
    public static Method findIndexedCollectionSetter(final Class<?> objClass, final String fieldName) {
        final Method result = findIndexedMethod(fieldName, objClass, true);
        return result;
    }

    /**
     * Format class names for printing.
     *
     * @param classes the class names to be formatted
     * @return a string with the class names in format
     */
    public static String formatClassNames(final Class<?>... classes) {
        String result = "";
        if (classes != null && classes.length > 0) {
            final StringBuilder sb = new StringBuilder();
            for (final Class<?> c : classes) {
                sb.append(c.getName()).append(", ");
            }
            result = sb.toString();
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }

    /**
     * Compare two arrays of parameters (classes) and return true if they are identical.
     * @param parametersA one set of parameters
     * @param parametersB the other set of parameters
     * @return true if the parameters match
     */
    public static boolean parametersMatch(final Class<?>[] parametersA, final Class<?>[] parametersB) {
        boolean parameterTypesMatch;
        if (parametersA.length == 0 && (parametersB == null || parametersB.length == 0)) {
            parameterTypesMatch = true;
        } else if (parametersB != null && parametersB.length == parametersA.length) {
            parameterTypesMatch = true;
            for (int i = 0; i < parametersB.length; i++) {
                if (!parametersA[i].isAssignableFrom(parametersB[i])) {
                    parameterTypesMatch = false;
                    break;
                }
            }
        } else {
            parameterTypesMatch = false;
        }
        return parameterTypesMatch;
    }

    /**
     * Tests whether the field is a collection type.
     * Note: Does test for plural form of fieldName, e.g. when the field is a collection
     *
     * @param objClass  the class to which the field belongs
     * @param fieldName the field name
     * @return true if the field is a collection type
     */
    public static boolean isFieldACollection(final Class<?> objClass, final String fieldName) {
        return isFieldACollection(objClass, fieldName, false);
    }

    /**
     * Tests whether the field is a collection type.
     * @param objClass  the class to which the field belongs
     * @param fieldName the field name
     * @param alreadyPluralized if the field name is already in plural form
     * @return true if the field is a collection type
     */
    public static boolean isFieldACollection(final Class<?> objClass, final String fieldName, final boolean alreadyPluralized) {
        boolean isCollection = false;
        final Class<?> fieldClass;
        final Field field = ReflectionHelper.findField(objClass, fieldName, alreadyPluralized);
        if (field != null) {
            fieldClass = field.getType();
            if (isCollection(fieldClass)) {
                isCollection = true;
            }
        }
        return isCollection;
    }

    /**
     * Convenience method for {@link Class#isAssignableFrom(Class)} on the {@link Collection} class.
     *
     * @param clazz the {@link Class} to test
     * @return true if the method is a collection
     */
    public static boolean isCollection(final Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }

    /**
     * Convenience method for {@link Class#isAssignableFrom(Class)} on the {@link Collection} class OR on the {@link Map} class.
     *
     * @param clazz the {@link Class} to test
     * @return true if the method is a collection or map
     */
    public static boolean isCollectionOrMap(final Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz);
    }

    /**
     * Iterate over the fields, find the first {@link ServiceData} field with a getter with a non-null result
     * and return it.
     *
     * @param message the message in which to locate an instance of {@link ServiceData}
     * @return the {@link ServiceData} instance or null if there is none
     * @throws ToolkitInternalException if reflection fails
     */
    public static ServiceData unwrapFirstNonNullServiceDataFieldViaGetter(final ServiceMessage<?, ?> message) throws ToolkitInternalException {
        ServiceData result = null;
        if (message != null) {
            final Class<?> objClass = message.getClass();
            final Field[] fields = objClass.getDeclaredFields();
            for (final Field f : fields) {
                if (!NON_SERVICE_DATA_FIELD_NAMES.contains(f.getName())) {
                    final Method m = findMethod(objClass, "get" + f.getName());
                    if (m != null) {
                        final Object obj = invokeMethod(m, message);
                        if (obj != null && ServiceData.class.isAssignableFrom(obj.getClass())) {
                            result = (ServiceData) obj;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Inovke the method on the target.
     * @param method the method to invoke
     * @param target the object on which to invoke the method
     * @param parameters the method parameters, if any
     * @return the result, if any
     * @throws ToolkitInternalException if reflection fails
     */
    private static Object invokeMethod(final Method method, final Object target, final Object ... parameters) throws ToolkitInternalException {
        try {
            return method.invoke(target, parameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ToolkitInternalException("Exception invoking method:", e);
        }
    }

    /**
     * Upper-case the first letter of the string.
     * @param s the string
     * @return the same string but with the first letter in uppercase
     */
    public static String upperCaseFirstLetter(final String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * Set the field to null.
     * @param obj the object containing the field
     * @param fieldClass the class of the field
     * @param fieldName the name of the field
     * @throws InvocationTargetException -
     * @throws IllegalAccessException -
     * @throws ToolkitInternalException -
     */
    @SuppressWarnings("squid:S3878") // Have to create an array for a null vararg
    public static void setFieldNull(final Object obj, final Class<?> fieldClass, final String fieldName)
        throws InvocationTargetException, IllegalAccessException, ToolkitInternalException {
        final Class<?> objClass = obj.getClass();
        final String methodName = buildMethodName(fieldName, false, true);
        final Method setterMethod = findMethod(objClass, methodName, fieldClass);
        if (setterMethod != null) {
            invokeMethod(setterMethod, obj, new Object[] { null });
        } else {
            throw new ToolkitInternalException("Set method '" + methodName + "' for field '" + fieldName + "' not found in " + objClass.getName());
        }
    }

    // TODO NOW: ReflectionHelper methods should only throw subclasses of ToolkitException. This ripples up to other classes, e.g. ISO18626Message.

    /**
     * Set the field to the supplied value.
     * Note: You can't pass null as the fieldValue, because this method requires knowing the class of the field to set,
     * which it derives from the fieldValue.
     * @param obj the object to which the field belongs
     * @param fieldValue the value to set the field to
     * @param fieldName the name of the field
     * @throws ToolkitInternalException -
     */
    public static void setField(final Object obj, final Object fieldValue, final String fieldName) throws ToolkitInternalException {
        if (fieldValue != null) {
            final Class<?> objClass = obj.getClass();
            final String methodName = buildMethodName(fieldName, false, true);
            final Method setterMethod = findMethod(objClass, methodName, fieldValue.getClass());
            if (setterMethod != null) {
                invokeMethod(setterMethod, obj, fieldValue);
            } else {
                throw new ToolkitInternalException("Set method '" + methodName + "' for field '" + fieldName + "' not found in " + objClass.getName());
            }
        }

    }

    public static Object getSimpleField(final Object obj, final String fieldName) throws ToolkitInternalException {
        final Object result;
        final Class<?> objClass = obj.getClass();
        final Method getterMethod = findSimpleGetter(objClass, fieldName);
        if (getterMethod != null) {
            result = invokeMethod(getterMethod, obj);
        } else {
            throw new ToolkitInternalException("Get method for simple field '" + fieldName + "' not found in " + objClass.getName());
        }
        return result;
    }

    /**
     * Return the {@link List} field.
     * @param obj the {@link }object} to which the field belongs
     * @param fieldName the field name
     * @return the {@link List} that is the value of the field
     * @throws ToolkitInternalException if reflection fails
     */
    public static List<Object> getCollectionField(final Object obj, final String fieldName) throws ToolkitInternalException {
        final List<Object> result;
        final Class<?> objClass = obj.getClass();
        final Method getterMethod = findCollectionGetter(objClass, fieldName);
        if (getterMethod != null) {
            result = (List<Object>) invokeMethod(getterMethod, obj);
        } else {
            throw new ToolkitInternalException("Get method for collection field '" + fieldName + "' not found in " + objClass.getName());
        }
        return result;
    }

    public static Object getIndexedField(final Object obj, final String fieldName, final int index) throws ToolkitInternalException {
        final Object result;
        final Class<?> objClass = obj.getClass();
        final Method getterMethod = findIndexedCollectionGetter(objClass, fieldName);
        if (getterMethod != null) {
            result = invokeMethod(getterMethod, obj, index);
        } else {
            throw new ToolkitInternalException("Indexed getter method for collection field '" + fieldName + "' not found in " + objClass.getName());
        }
        return result;

    }

    public static void setIndexedField(final Object obj, final String fieldName, final int index, final Object value)
        throws ToolkitInternalException {
        final Class<?> objClass = obj.getClass();
        final Method setterMethod = findIndexedCollectionSetter(objClass, fieldName);
        if (setterMethod != null) {
            invokeMethod(setterMethod, obj, index, value);
        } else {
            throw new ToolkitInternalException("Indexed setter method for collection field '" + fieldName + "' not found in " + objClass.getName());
        }
    }

    /**
     * Convenience method to {@link #findClassesInPackage(String, String, String, Class)} that passes a null skipClassNamePattern and null parentClass.
     * @param packageName the package name
     * @param classNamePattern a regex pattern identifying the classes to find
     * @return a possibly-empty list of classes
     * @throws ToolkitInternalException - if reflection or class loading fails
     */
    public static List<Class<Object>> findClassesInPackage(final String packageName, final String classNamePattern) throws ToolkitInternalException {
        return findClassesInPackage(packageName, classNamePattern, null, null);
    }

    /**
     * Convenience method to {@link #findClassesInPackage(String, String, String, Class)} that passes a null parentClass.
     * @param packageName the package name
     * @param classNamePattern a regex pattern identifying the classes to find
     * @param skipClassNamePattern a regex pattern identifying the classes to omit
     * @return a possibly-empty list of classes found
     * @throws ToolkitInternalException - if reflection or class loading fails
     */
    public static List<Class<Object>> findClassesInPackage(final String packageName, final String classNamePattern, final String skipClassNamePattern)
        throws ToolkitInternalException {
        return findClassesInPackage(packageName, classNamePattern, skipClassNamePattern, null);
    }

    /**
     * Find all classes in the package matching the class name pattern and are subclasses of parentClass.
     * Note: adapted from http://stackoverflow.com/questions/15519626/how-to-get-all-classes-names-in-a-package.
     * @param <C> the class or superclass of the classes to be found; may be null
     * @param packageName the package name
     * @param classNamePattern a regex pattern identifying the classes to find
     * @param skipClassNamePattern a regex pattern identifying the classes to omit
     * @param parentClass if non-null, a {@link Class} that the classes must inherit from
     * @return a possibly-empty list of classes found
     * @throws ToolkitInternalException - if reflection or class loading fails
     */
    public static <C> List<Class<C>> findClassesInPackage(final String packageName, final String classNamePattern, final String skipClassNamePattern, final Class<C> parentClass)
        throws ToolkitInternalException {
        try {
            final List<Class<C>> classes = new LinkedList<>();
            final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            final String scannedPath = packageName.replace(DOT, SLASH);
            final Enumeration<URL> resources = classLoader.getResources(scannedPath);
            while (resources.hasMoreElements()) {
                final File file = new File(resources.nextElement().getFile());
                classes.addAll(findClasses(file, packageName, classNamePattern, skipClassNamePattern, parentClass));
            }
            return classes;
        } catch (IOException | ClassNotFoundException e) {
            throw new ToolkitInternalException("Exception thrown finding classes in package:", e);
        }
    }

    private static <C> List<Class<C>> findClasses(final File file, final String scannedPackage, final String classNamePattern, final String skipClassNamePattern,
        final Class<C> parentClass)
        throws ClassNotFoundException {
        if (file.isDirectory()) {
            return findClassesInDirectory(file, scannedPackage, classNamePattern, skipClassNamePattern, parentClass);
        } else {
            return findClassInFile(file, scannedPackage, classNamePattern, skipClassNamePattern, parentClass);
        }
    }

    private static <C> List<Class<C>> findClassesInDirectory(final File directory, final String scannedPackage, final String classNamePattern, final String skipClassNamePattern,
        final Class<C> parentClass)
        throws ClassNotFoundException {
        final List<Class<C>> classes = new LinkedList<>();
        for (final File nestedFile : directory.listFiles()) {
            classes.addAll(findClasses(nestedFile, scannedPackage, classNamePattern, skipClassNamePattern, parentClass));
        }
        return classes;
    }

    private static <C> List<Class<C>> findClassInFile(final File file, final String scannedPackage, final String classNamePattern, final String skipClassNamePattern,
        final Class<C> parentClass)
        throws ClassNotFoundException {
        final List<Class<C>> classes = new LinkedList<>();
        final String resource = scannedPackage + DOT + file.getName();
        final int endIndex = resource.length() - CLASS_SUFFIX.length();
        final String className = resource.substring(0, endIndex);
        LOG.trace("Class name: '" + className + "'.");
        if (className.matches(classNamePattern) && (skipClassNamePattern == null || !className.matches(skipClassNamePattern))) {
            try {
                final Class<C> clazz = (Class<C>) Class.forName(className);
                if (parentClass == null || parentClass.isAssignableFrom(clazz)) {
                    classes.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                LOG.trace("Class " + className + " not found - skipped.");
            }
        } else {
            LOG.trace("Skipping " + className + " doesn't match classNamePattern, or matches skipClassNamePattern");
        }
        return classes;
    }

    /**
     * Find all static instance fields that extend {@link SchemeValuePair}
     *
     * @param svpClass a class that extends {@link SchemeValuePair}
     * @return the list
     * @throws IllegalAccessException -
     * @throws InvocationTargetException -
     */
    public static List<SchemeValuePair> findAllSVPInstances(final Class<? extends SchemeValuePair> svpClass) throws IllegalAccessException, InvocationTargetException {

        final List<SchemeValuePair> result = new ArrayList<>();

        if (svpClass != null) {

            final Field[] fields = svpClass.getDeclaredFields();
            for (final Field f : fields) {

                if (Modifier.isStatic(f.getModifiers())) {

                    final Class<?> fieldClass = f.getType();
                    if (SchemeValuePair.class.isAssignableFrom(fieldClass)) {

                        result.add((SchemeValuePair) f.get(null));

                    }

                }

            }

        }

        return result;

    }

    /**
     * Find a class in a list of packages.
     * @param className the class name
     * @param packageNames the list of package names
     * @return the class
     * @throws ToolkitInternalException if the class is not found
     */
    public static Class<?> findClass(final String className, final String[] packageNames) throws ToolkitInternalException {
        Class<? extends SchemeValuePair> svpClass = null;
        for (final String packageName : packageNames) {
            svpClass = findClass(className, packageName);
            if (svpClass != null) {
                break;
            }
        }
        if (svpClass == null) {
            throw new ToolkitInternalException("No class found for " + className + " in these packages: " + ToolkitHelper.concatenateStrings(Arrays.asList(packageNames), ", "));
        }
        return svpClass;
    }

    /**
     * Find a subclass of {@link SchemeValuePair} by class- and package-name.
     * @param svpName the {@link SchemeValuePair} subclass' name
     * @param packageName the package name
     * @return the class, or null if not found
     */
    private static Class<? extends SchemeValuePair> findClass(final String svpName, final String packageName) {
        Class<? extends SchemeValuePair> svpClass = null;
        try {
            svpClass = Class.forName(packageName + "." + svpName).asSubclass(SchemeValuePair.class);
        } catch (ClassNotFoundException e) {
            // Return null
        }
        return svpClass;
    }

    /**
     * Find the Class for the property.
     * @param packageName the package from which to find the class
     * @param propertyName the property name
     * @param propertyToClassNameAliases a map of property names that are not the same as their class names, e.g. relyingPartyId -&gt; AgencyId
     * @param pluralizedPropertyNameAliases a map of plural property names (i.e. for collection properties) that have non-standard pluralization, e.g. Addresses -&gt; Address
     * @return the class, or null if not found
     */
    public static Class<?> findClassForProperty(final String packageName, final String propertyName, final Map<String, String> propertyToClassNameAliases,
        final Map<String, String> pluralizedPropertyNameAliases) {
        Class<?> propertyClass = null;
        final String propertyClassNameToUse = propertyToClassNameAliases.getOrDefault(propertyName, propertyName);
        final String propertyClassName = upperCaseFirstLetter(propertyClassNameToUse);
        propertyClass = loadClass(packageName + "." + propertyClassName);
        if (propertyClass == null) {
            propertyClass = loadClass(SERVICE_BASE_PACKAGE_NAME + "." + propertyClassName);
        }
        if (propertyClass == null && propertyClassName.endsWith("s")) {
            final String singularFormOfPropertyName = pluralizedPropertyNameAliases.getOrDefault(propertyName, propertyName);
            final String singularFormOfPropertyClassName = upperCaseFirstLetter(singularFormOfPropertyName);
            propertyClass = loadClass(packageName + "." + singularFormOfPropertyClassName);
            if (propertyClass == null) {
                propertyClass = loadClass(SERVICE_BASE_PACKAGE_NAME + "." + singularFormOfPropertyClassName);
            }
        }
        return propertyClass;
    }

    /**
     * Load a class.
     * @param className the clas name
     * @return the {@link Class} instance
     */
    private static Class<?> loadClass(final String className) {
        Class<?> propertyClass = null;
        try {
            propertyClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            // Continue
        }
        return propertyClass;
    }
}
