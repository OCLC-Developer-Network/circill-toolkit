/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestReflectionHelper {

    private static final Float SOME_FLOAT_VALUE = 1.3f;

    private static class TestClass {
        protected String simpleFieldWithNoSetter;
        protected String simpleField;

        public String getSimpleField() {
            return simpleField;
        }

        public void setSimpleField(final String simpleField) {
            this.simpleField = simpleField;
        }

        protected List<Float> floats;

        public void setFloats(final List<Float> floats) {
            this.floats = floats;
        }

        public List<Float> getFloats() {
            return floats;
        }

        protected final List<URL> urls = new ArrayList<>();

        public void setURL(final int index, final URL url) {
            this.urls.add(index, url);
        }

        public URL getURL(final int index) {
            return urls.get(index);
        }

        public void methodWithVaryingParameter(final String x, final int y) {
            return;
        }

        public void methodWithVaryingParameter(final Double d) {
            return;
        }

        public void collectionMethodWithVaryingParameters(final String x, final int y) {
            return;
        }

        public void collectionMethodWithVaryingParameters(final Double d) {
            return;
        }
    }

    @Test
    public void testIsValidUtilityClass() throws ReflectiveOperationException {
        TestHelper.assertUtilityClassWellDefined(ReflectionHelper.class);
    }

    @Test
    public void testFindField() {

        assertNotNull("ReflectionHelper.findField(Class, String) did not find expected 'simpleField' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findField(TestClass.class, "simpleField"));

        assertNull("ReflectionHelper.findField(Class, String) found non-existent 'nonExistentField' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findField(TestClass.class, "nonExistentField"));

    }

    @Test
    public void testParameterMatchingInFindMethod() {

        assertNotNull(
            "ReflectionHelper.findMethod(Class, String, String, int) did not find expected " + "'methodWithVaryingParameter(String, int)' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findMethod(TestClass.class, "methodWithVaryingParameter", String.class, int.class));

        assertNull("ReflectionHelper.findMethod(Class, String, int) found non-existent " + "'methodWithVaryingParameter(int)' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findMethod(TestClass.class, "methodWithVaryingParameter", int.class));

        assertNotNull(
            "ReflectionHelper.findMethod(Class, String, String, int) did not find expected " + "'collectionMethodWithVaryingParameters(String, int)' on " + TestClass.class
                .getName() + ".", ReflectionHelper.findMethod(TestClass.class, "collectionMethodWithVaryingParameter", String.class, int.class));

        assertNull("ReflectionHelper.findMethod(Class, String, int) found non-existent " + "'collectionMethodWithVaryingParameters(int)' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findMethod(TestClass.class, "collectionMethodWithVaryingParameter", int.class));

    }

    @Test
    public void testFindSimpleGetter() {

        assertNull("ReflectionHelper.findSimpleGetter(Class, String) found non-existent " + "'getNonExistentField()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findSimpleGetter(TestClass.class, "nonExistentField"));
        assertNotNull("ReflectionHelper.findSimpleGetter(Class, String) did not find " + "'getSimpleField()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findSimpleGetter(TestClass.class, "simpleField"));

    }

    @Test
    public void testFindCollectionGetter() {

        assertNull("ReflectionHelper.findCollectionGetter(Class, String) found non-existent " + "'getNonExistentCollectionField()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findCollectionGetter(TestClass.class, "nonExistentCollectionField"));
        assertNotNull("ReflectionHelper.findCollectionGetter(Class, String) did not find " + "'getFloats()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findCollectionGetter(TestClass.class, "float"));

    }

    @Test
    public void testFindIndexedCollectionGetter() {

        assertNull("ReflectionHelper.findIndexedCollectionGetter(Class, String) found non-existent " + "'getNonExistentCollectionField()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findIndexedCollectionGetter(TestClass.class, "nonExistentCollectionField"));
        assertNotNull("ReflectionHelper.findIndexedCollectionGetter(Class, String) did not find " + "'getURL(1, )' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findIndexedCollectionGetter(TestClass.class, "url"));

    }

    @Test
    public void testFindSimpleSetter() {

        assertNull("ReflectionHelper.findSimpleSetter(Class, String) found non-existent " + "'setNonExistentSimpleField()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findSimpleSetter(TestClass.class, "nonExistentSimpleField"));
        assertNotNull("ReflectionHelper.findSimpleSetter(Class, String) did not find " + "'setSimpleField()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findSimpleSetter(TestClass.class, "simpleField"));

    }

    @Test
    public void testFindCollectionSetter() {

        assertNull("ReflectionHelper.findCollectionSetter(Class, String) found non-existent " + "'setNonExistentCollectionField()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findCollectionSetter(TestClass.class, "nonExistentCollectionField"));
        assertNotNull("ReflectionHelper.findCollectionSetter(Class, String) did not find " + "'setFloats()' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findCollectionSetter(TestClass.class, "float"));

    }

    @Test
    public void testFindIndexedCollectionSetter() {

        assertNull(
            "ReflectionHelper.findIndexedCollectionSetter(Class, String) found non-existent " + "'setNonExistentCollectionField(int, )' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findIndexedCollectionSetter(TestClass.class, "nonExistentCollectionField"));
        assertNotNull("ReflectionHelper.findIndexedCollectionSetter(Class, String) did not find " + "'setURL(int, )' on " + TestClass.class.getName() + ".",
            ReflectionHelper.findIndexedCollectionSetter(TestClass.class, "url"));

    }

    @Test
    public void testIsFieldACollection() {

        assertFalse("ReflectionHelper.isFieldACollection(Class, String) incorrectly identified a simple field as a collection.",
            ReflectionHelper.isFieldACollection(TestClass.class, "simpleField"));
        assertTrue("ReflectionHelper.isFieldACollection(Class, String) failed to identify a collection field as a collection.",
            ReflectionHelper.isFieldACollection(TestClass.class, "floats"));

    }

    @Test
    public void testIsCollectionOrMap() {

        assertFalse("ReflectionHelper.isCollectionOrMap(Class) incorrectly identified String as a collection or map.", ReflectionHelper.isCollectionOrMap(String.class));
        assertTrue("ReflectionHelper.isCollectionOrMap(Class) did not identify ArrayList as a collection or map.", ReflectionHelper.isCollectionOrMap(ArrayList.class));
        assertTrue("ReflectionHelper.isCollectionOrMap(Class) did not identify HashMap as a collection or map.", ReflectionHelper.isCollectionOrMap(HashMap.class));

    }

    public class TestMessage implements ServiceMessage<ServiceInitiationData, ServiceResponseData> {
        private ServiceInitiationData serviceInitiationData;
        private ServiceResponseData serviceResponseData;
        public void setServiceInitiationData(final ServiceInitiationData serviceInitiationData) {
            this.serviceInitiationData = serviceInitiationData;
        }
        public ServiceInitiationData getServiceInitiationData() {
            return serviceInitiationData;
        }
        public void setServiceResponseData(final ServiceResponseData serviceResponseData) {
            this.serviceResponseData = serviceResponseData;
        }
        public ServiceResponseData getServiceResponseData() {
            return serviceResponseData;
        }
    }
    public class TestServiceInitiationData implements ServiceInitiationData, ServiceData {};
    public class TestServiceResponseData implements ServiceResponseData, ServiceData {};

    @Test
    public void testUnwrapFirstNonNullServiceInitiationDataFieldViaGetter() throws ToolkitInternalException {
        final TestServiceInitiationData testServiceInitData = new TestServiceInitiationData();
        final TestMessage testMessage = new TestMessage();
        testMessage.setServiceInitiationData(testServiceInitData);
        assertSame("ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(ServiceMessage)" + " didn't return the expected initiation object.",
            testServiceInitData, ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(testMessage));
    }

    @Test
    public void testUnwrapFirstNonNullServiceResponseDataFieldViaGetter() throws ToolkitInternalException {
        final TestServiceResponseData testServiceRespData = new TestServiceResponseData();
        final TestMessage testMessage = new TestMessage();
        testMessage.setServiceResponseData(testServiceRespData);
        assertSame("ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(ServiceMessage)" + " didn't return the expected response object.",
            testServiceRespData, ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(testMessage));
    }
    @Test
    public void testUnwrapFirstNonNullServiceDataFieldViaGetter_ForNullMessage() throws ToolkitInternalException {

        assertNull("ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(ServiceMessage)" + " doesn't return null when passed a null object.",
            ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(null));

    }

    @Test
    public void testSetField() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        final String testValue = "Don't care value";
        final TestClass testInstance = new TestClass();
        ReflectionHelper.setField(testInstance, testValue, "simpleField");
        assertSame(testInstance.getSimpleField(), testValue);

    }

    @Test(expected = ToolkitException.class)
    public void testSetField_ExpectExceptionForNoField() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        ReflectionHelper.setField(new TestClass(), "fake value", "simpleFieldWithNoSetter");

    }

    @Test
    public void testSetFieldNull() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        final TestClass testInstance = new TestClass();
        ReflectionHelper.setFieldNull(testInstance, String.class, "simpleField");
        assertNull(testInstance.getSimpleField());

    }

    @Test(expected = ToolkitException.class)
    public void testSetFieldNull_ExpectExceptionForNoSetter() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        ReflectionHelper.setFieldNull(new TestClass(), String.class, "simpleFieldWithNoSetter");

    }

    @Test
    public void testGetSimpleField() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        final TestClass testClass = new TestClass();
        testClass.setSimpleField("test value");
        assertEquals("ReflectionHelper.getSimpleField(...) did not return the expected value.", "test value", ReflectionHelper.getSimpleField(testClass, "simpleField"));

    }

    @Test(expected = ToolkitException.class)
    public void testGetSimpleField_ExpectedExceptionForNonExistentField() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        ReflectionHelper.getSimpleField(new TestClass(), "nonexistentSimpleField");

    }

    @Test
    public void testGetCollectionField() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        final List<Float> floatList = new ArrayList<>();
        floatList.add(new Float(SOME_FLOAT_VALUE));
        final TestClass testClass = new TestClass();
        testClass.setFloats(floatList);
        assertSame("ReflectionHelper.getCollectionField(Class) did return the expected collection.", floatList, ReflectionHelper.getCollectionField(testClass, "float"));

    }

    @Test(expected = ToolkitException.class)
    public void testGetCollectionFieldException() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        ReflectionHelper.getCollectionField(new TestClass(), "nonexistentCollectionField");

    }

    @Test
    public void testGetIndexedField() throws IllegalAccessException, ToolkitException, InvocationTargetException, MalformedURLException {

        final URL url0 = new URL("http://localhost");
        final URL url1 = new URL("http://google.com");
        final TestClass testClass = new TestClass();
        testClass.setURL(0, url0);
        testClass.setURL(1, url1);
        final URL actualValue = (URL) ReflectionHelper.getIndexedField(testClass, "url", 1);
        assertEquals(url1, actualValue);

    }

    @Test(expected = ToolkitInternalException.class)
    public void testGetIndexedField_ExpectException() throws IllegalAccessException, ToolkitException, InvocationTargetException, MalformedURLException {

        final TestClass testClass = new TestClass();
        testClass.setURL(0, new URL("http://localhost"));
        ReflectionHelper.getIndexedField(testClass, "url", 1);

    }

    @Test(expected = ToolkitException.class)
    public void testGetIndexedField_ExpectExceptionForNonExistentField() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        ReflectionHelper.getIndexedField(new TestClass(), "nonexistentCollectionField", 2);

    }

    @Test
    public void testSetIndexedField() throws IllegalAccessException, ToolkitException, InvocationTargetException, MalformedURLException {

        final URL url0 = new URL("http://localhost");
        final URL urlNewZero = new URL("http://google.com");
        final TestClass testClass = new TestClass();
        testClass.setURL(0, url0);
        ReflectionHelper.setIndexedField(testClass, "url", 0, urlNewZero);
        final URL actualValue = (URL) ReflectionHelper.getIndexedField(testClass, "url", 0);
        assertEquals(urlNewZero, actualValue);

    }

    @Test(expected = ToolkitInternalException.class)
    public void testSetIndexedFieldException() throws IllegalAccessException, ToolkitException, InvocationTargetException, MalformedURLException {

        final TestClass testClass = new TestClass();
        ReflectionHelper.setIndexedField(testClass, "url", 1, new URL("http://google.com"));

    }

    @Test(expected = ToolkitException.class)
    public void testSetIndexedFieldNonexistentField() throws IllegalAccessException, ToolkitException, InvocationTargetException {

        ReflectionHelper.setIndexedField(new TestClass(), "nonexistentCollectionField", 2, new Float(SOME_FLOAT_VALUE));

    }

    @Test
    public void testFindClassesInPackage_EmptyResult() throws ToolkitInternalException {

        final List<Class<Object>> classes = ReflectionHelper.findClassesInPackage("org.oclc.circill.toolkit.service.base", "Unfound resource");
        assertTrue(classes.isEmpty());

    }

    @Test
    public void testFindClassesInPackage_ClassNotFoundException() throws ToolkitInternalException {

        final List<Class<Object>> classes = ReflectionHelper.findClassesInPackage("org.oclc.circill.toolkit.service.base", "NoSuchResource.txt");
        assertTrue(classes.isEmpty());

    }

    @Test
    public void testFindClassesInPackage_NonEmptyResult() throws ToolkitInternalException {

        final List<Class<Object>> classes = ReflectionHelper.findClassesInPackage(this.getClass().getPackage().getName(), ".*\\." + this.getClass().getSimpleName() + "$");
        assertTrue(classes.size() == 1);
        assertTrue((classes.get(0).equals(TestReflectionHelper.class)));

    }

    @Test
    public void testFindClassesInPackage_BadPackageName() throws ToolkitInternalException {

        final List<Class<Object>> classes = ReflectionHelper.findClassesInPackage("noprotocol://nodrive/nosuchpackage-nowhere", ".*FakeClass$");
        assertTrue(classes.isEmpty());

    }

    @Test
    public void testfindAllSVPInstances() throws InvocationTargetException, IllegalAccessException {

        final List<SchemeValuePair> result = ReflectionHelper.findAllSVPInstances(null);
        assertTrue(result.isEmpty());

    }
}
