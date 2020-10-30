/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.dozer.MappingException;
import org.junit.Test;

/**
 * Tests of the {@link ClassConstantReader}.
 */
public class ClassConstantReaderTest {

    private static final String TEST_CLASS_NAME = TestClass.class.getName();
    private static final String TEST_STRING_FIELD_NAME = "STRING_CONSTANT";
    private static final String TEST_PRIVATE_STRING_FIELD_NAME = "PRIVATE_STRING_CONSTANT";
    private static final String TEST_OBJECT_FIELD_NAME = "OBJECT_CONSTANT";

    @Test
    public void testValueOf_givenConstantOfTypeString_expectHappyPath() throws Exception {
        final String classAndField = String.format("%s.%s", TEST_CLASS_NAME, TEST_STRING_FIELD_NAME);

        final String result = ClassConstantReader.valueOf(classAndField);

        assertEquals(TestClass.STRING_CONSTANT, result);
    }

    @Test
    public void testValueOf_givenConstantOfTypeObject_expectHappyPath() throws Exception {
        final String classAndField = String.format("%s.%s", TEST_CLASS_NAME, TEST_OBJECT_FIELD_NAME);

        final String result = ClassConstantReader.valueOf(classAndField);

        assertEquals(TestClass.OBJECT_CONSTANT.toString(), result);
    }

    @Test(expected = MappingException.class)
    public void testValueOf_givenPrivateConstant_expectException() throws Exception {
        // make sure the constant exists before starting the test.
        assertConstantExists(TEST_CLASS_NAME, TEST_PRIVATE_STRING_FIELD_NAME);

        final String classAndField = String.format("%s.%s", TEST_CLASS_NAME, TEST_PRIVATE_STRING_FIELD_NAME);
        ClassConstantReader.valueOf(classAndField);
    }

    @Test(expected = MappingException.class)
    public void testValueOf_givenNonExistentConstant_ExpectException() throws Exception {
        final String classAndField = String.format("%s.%s", TEST_CLASS_NAME, "nonExistentField");
        ClassConstantReader.valueOf(classAndField);
    }

    @Test(expected = MappingException.class)
    public void testValueOf_givenNonExistentClass_ExpectException() throws Exception {
        final String classAndField = String.format("%s.%s", "nonExistentClass", TEST_STRING_FIELD_NAME);
        ClassConstantReader.valueOf(classAndField);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOf_givenClassNameAndConstantNameLacksDot_ExpectException() throws Exception {
        ClassConstantReader.valueOf("noDot");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOf_givenNullClassNameAndConstantName_ExpectException() throws Exception {
        ClassConstantReader.valueOf(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOf_givenEmptyClassNameAndConstantName_ExpectException() throws Exception {
        ClassConstantReader.valueOf("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOf_givenBlankClassNameAndConstantName_ExpectException() throws Exception {
        ClassConstantReader.valueOf(" ");
    }

    /**
     * Asserts the class contains the expected constant.
     * @param className -
     * @param fieldName -
     */
    private static void assertConstantExists(final String className, final String fieldName) {
        try {
            Class.forName(className).getDeclaredField(fieldName);
        } catch (final Exception e) {
            fail(String.format("Problem with unit test: %s.%s doesn't exist", className, fieldName));
        }
    }

    private static final class TestClass {
        public static final String STRING_CONSTANT = "test String field";
        private static final String PRIVATE_STRING_CONSTANT = "test private String field";
        public static final Object OBJECT_CONSTANT = new Object();
    }
}
