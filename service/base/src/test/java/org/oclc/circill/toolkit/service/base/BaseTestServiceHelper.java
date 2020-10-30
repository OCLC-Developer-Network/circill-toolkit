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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.apache.log4j.Logger;

/**
 * Unit tests for the ServiceHelper class.
 */
public class BaseTestServiceHelper {

    private static final Logger LOG = Logger.getLogger(BaseTestServiceHelper.class);

    /**
     * Perform the tests.
     * @param packageName the Java package to scan
     * @param propertyToClassNameAliases a map of property names that are not the same as their class names, e.g. relyingPartyId -&gt; AgencyId
     * @param pluralizedPropertyNameAliases a map of plural property names (i.e. for collection properties) that have non-standard pluralization, e.g. Addresses -&gt; Address
     * @throws IllegalAccessException -
     * @throws InstantiationException -
     * @throws InvocationTargetException -
     * @throws ClassNotFoundException -
     * @throws ToolkitException -
     * @throws IOException -
     * @throws IntrospectionException -
     * @throws NoSuchMethodException -
     */
    protected void doTests(final String packageName, final Map<String, String> propertyToClassNameAliases, final Map<String, String> pluralizedPropertyNameAliases)
        throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, ToolkitException, IOException, IntrospectionException,
        NoSuchMethodException {

        final List<Class<Object>> classes = ReflectionHelper.findClassesInPackage(packageName, ALL_CLASSES_NAME_PATTERN, ".*\\.Test[a-zA-Z0-9$]*$");
        for (final Class<?> clazz : classes) {
            for (final PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(clazz).getPropertyDescriptors()) {
                final Method collectionSetter = ReflectionHelper.findCollectionSetter(clazz, propertyDescriptor.getName());
                final Method collectionGetter = ReflectionHelper.findCollectionGetter(clazz, propertyDescriptor.getName());
                final Method instanceSetter = ReflectionHelper.findSimpleSetter(clazz, propertyDescriptor.getName());
                final Class<?> propertyClass = ReflectionHelper
                    .findClassForProperty(packageName, propertyDescriptor.getName(), propertyToClassNameAliases, pluralizedPropertyNameAliases);
                if (collectionGetter != null && collectionSetter != null && instanceSetter != null) {
                    nullList_AddNull_ExpectListToRemainNull(clazz, collectionSetter, collectionGetter, instanceSetter);
                    nullList_AddInstance_ExpectNewListWithThatInstance(clazz, collectionSetter, collectionGetter, instanceSetter, propertyClass);
                    emptyList_AddNull_ExpectListToBecomeNull(clazz, collectionSetter, collectionGetter, instanceSetter, propertyClass);
                    emptyList_AddInstance_ExpectListToHaveOnlyThatInstance(clazz, collectionSetter, collectionGetter, instanceSetter, propertyClass);
                    populatedList_AddNull_ExpectListToBecomeNull(clazz, collectionSetter, collectionGetter, instanceSetter, propertyClass);
                    populatedList_AddInstance_ExpectListToHaveOnlyThatInstance(clazz, collectionSetter, collectionGetter, instanceSetter, propertyClass);
                }
            }
        }
    }

    public void nullList_AddNull_ExpectListToRemainNull(final Class<?> ncipBeanClass, final Method collectionSetter, final Method collectionGetter, final Method instanceSetter)
        throws InvocationTargetException, IllegalAccessException, InstantiationException {
        final Object testSubject = ncipBeanClass.newInstance();
        instanceSetter.invoke(testSubject, new Object[] { null });
        assertNull("Precondition: the List should be null before the test action.", collectionGetter.invoke(testSubject));

        instanceSetter.invoke(testSubject, new Object[] { null });

        assertNull("List should still be null.", collectionGetter.invoke(testSubject));
    }

    public void nullList_AddInstance_ExpectNewListWithThatInstance(final Class<?> ncipBeanClass, final Method collectionSetter, final Method collectionGetter,
        final Method instanceSetter, final Class<?> propertyClass)
        throws InvocationTargetException, IllegalAccessException, InstantiationException, ToolkitException, NoSuchMethodException {

        final Object testSubject = ncipBeanClass.newInstance();
        collectionSetter.invoke(testSubject, new Object[] { null });
        assertNull("Precondition: the List should be null before the test action.", collectionGetter.invoke(testSubject));

        final Object newEntry = getNewInstance(propertyClass);
        LOG.info("Invoking " + instanceSetter.getName() + " on " + newEntry);
        instanceSetter.invoke(testSubject, newEntry);

        assertNotNull("List should not be null.", collectionGetter.invoke(testSubject));
        assertEquals("List should have a single entry.", 1, ((List) collectionGetter.invoke(testSubject)).size());
        assertSame("List entry should be same as new entry.", newEntry, ((List) collectionGetter.invoke(testSubject)).get(0));
    }

    public void emptyList_AddNull_ExpectListToBecomeNull(final Class<?> ncipBeanClass, final Method collectionSetter, final Method collectionGetter, final Method instanceSetter,
        final Class<?> propertyClass) throws InvocationTargetException, IllegalAccessException, InstantiationException, ToolkitException {

        final Object testSubject = ncipBeanClass.newInstance();
        final ArrayList<Object> newList = new ArrayList<>();
        collectionSetter.invoke(testSubject, newList);

        assertNotNull("Precondition: the List should be non-null before the test action.", collectionGetter.invoke(testSubject));
        assertEquals("Precondition: the List should be empty before the test action.", 0, ((List) collectionGetter.invoke(testSubject)).size());
        assertSame("Precondition: the List should be the same as the new list it was initialized with.", newList, collectionGetter.invoke(testSubject));

        instanceSetter.invoke(testSubject, new Object[] { null });

        assertNull("List should be null.", collectionGetter.invoke(testSubject));
    }

    public void emptyList_AddInstance_ExpectListToHaveOnlyThatInstance(final Class<?> ncipBeanClass, final Method collectionSetter, final Method collectionGetter,
        final Method instanceSetter, final Class<?> propertyClass)
        throws InvocationTargetException, IllegalAccessException, InstantiationException, ToolkitException, NoSuchMethodException {

        final Object testSubject = ncipBeanClass.newInstance();
        final ArrayList<Object> newList = new ArrayList<>();
        collectionSetter.invoke(testSubject, newList);

        assertNotNull("Precondition: the List should be non-null before the test action.", collectionGetter.invoke(testSubject));
        assertEquals("Precondition: the List should be empty before the test action.", 0, ((List) collectionGetter.invoke(testSubject)).size());
        assertSame("Precondition: the List should be the same as the new list it was initialized with.", newList, collectionGetter.invoke(testSubject));

        final Object newEntry = getNewInstance(propertyClass);
        instanceSetter.invoke(testSubject, newEntry);

        assertNotNull("List should not be null.", collectionGetter.invoke(testSubject));
        assertSame("List should be the same as the new list it was initialized with.", newList, collectionGetter.invoke(testSubject));
        assertEquals("List should have a single entry.", 1, ((List) collectionGetter.invoke(testSubject)).size());
        assertSame("List entry should be same as new entry.", newEntry, ((List) collectionGetter.invoke(testSubject)).get(0));
    }

    public void populatedList_AddNull_ExpectListToBecomeNull(final Class<?> ncipBeanClass, final Method collectionSetter, final Method collectionGetter,
        final Method instanceSetter, final Class<?> propertyClass)
        throws InvocationTargetException, IllegalAccessException, InstantiationException, ToolkitException, NoSuchMethodException {
        final Object testSubject = ncipBeanClass.newInstance();
        final ArrayList<Object> newList = new ArrayList<>();
        final Object newEntry1 = getNewInstance(propertyClass);
        final Object newEntry2 = getNewInstance(propertyClass);
        newList.add(newEntry1);
        newList.add(newEntry2);
        collectionSetter.invoke(testSubject, newList);

        assertNotNull("Precondition: the List should be non-null before the test action.", collectionGetter.invoke(testSubject));
        assertEquals("Precondition: the List should have 2 entries before the test action.", 2, ((List) collectionGetter.invoke(testSubject)).size());
        assertSame("Precondition: the List should be the same as the new list it was initialized with.", newList, collectionGetter.invoke(testSubject));

        instanceSetter.invoke(testSubject, new Object[] { null });

        assertNull("List should be null.", collectionGetter.invoke(testSubject));
    }

    public void populatedList_AddInstance_ExpectListToHaveOnlyThatInstance(final Class<?> ncipBeanClass, final Method collectionSetter, final Method collectionGetter,
        final Method instanceSetter, final Class<?> propertyClass)
        throws InvocationTargetException, IllegalAccessException, InstantiationException, ToolkitException, NoSuchMethodException {
        final Object testSubject = ncipBeanClass.newInstance();
        final ArrayList<Object> newList = new ArrayList<>();
        final Object newEntry1 = getNewInstance(propertyClass);
        final Object newEntry2 = getNewInstance(propertyClass);
        newList.add(newEntry1);
        newList.add(newEntry2);
        collectionSetter.invoke(testSubject, newList);

        assertNotNull("Precondition: the List should be non-null before the test action.", collectionGetter.invoke(testSubject));
        assertEquals("Precondition: the List should have 2 entries before the test action.", 2, ((List) collectionGetter.invoke(testSubject)).size());
        assertSame("Precondition: the List should be the same as the new list it was initialized with.", newList, collectionGetter.invoke(testSubject));

        final Object newEntry3 = getNewInstance(propertyClass);
        instanceSetter.invoke(testSubject, newEntry3);

        assertNotNull("List should not be null.", collectionGetter.invoke(testSubject));
        assertSame("List should be the same as the new list it was initialized with.", newList, collectionGetter.invoke(testSubject));
        assertEquals("List should have a single entry.", 1, ((List) collectionGetter.invoke(testSubject)).size());
        assertSame("List entry should be same as new entry.", newEntry3, ((List) collectionGetter.invoke(testSubject)).get(0));
    }

    private static Object getNewInstance(final Class<?> propertyClass)
        throws IllegalAccessException, InstantiationException, ToolkitException, NoSuchMethodException, InvocationTargetException {
        final Object newInstance;
        if (SchemeValuePair.class.isAssignableFrom(propertyClass)) {
            SchemeValuePair.mapBehavior(propertyClass.getName(), SchemeValueBehavior.ALLOW_ANY);
            newInstance = SchemeValuePairHelper.findSchemeValuePair((Class<? extends SchemeValuePair>) propertyClass, "http://somescheme.org", UUID.randomUUID().toString());
        } else if (propertyClass.isEnum()) {
            final Class<Enum> enumPropertyClass = (Class<Enum>) propertyClass;
            newInstance = ((Enum[]) enumPropertyClass.getDeclaredMethod("values").invoke(null))[0];
        } else {
            newInstance = propertyClass.newInstance();
        }
        return newInstance;
    }
}
