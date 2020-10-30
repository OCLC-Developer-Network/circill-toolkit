/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import java.util.Collections;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests for {@link BaseNullIfEmptyConverter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class BaseNullIfEmptyConverterTest {

    /**
     * A class that can serve as a nullable property.
     */
    public static class ComplexProperty {
    }

    /**
     * A class with a nullable property.
     */
    public static class TestClass {
        private ComplexProperty complexProperty;

        public TestClass() {
            // Do nothing
        }

        public TestClass(final ComplexProperty complexProperty) {
            this.complexProperty = complexProperty;
        }

        public ComplexProperty getComplexProperty() {
            return complexProperty;
        }

        public void setComplexProperty(final ComplexProperty complexProperty) {
            this.complexProperty = complexProperty;
        }
    }

    /**
     * An object that is the source of the conversion.
     */
    static final TestClass SOURCE_INSTANCE_WITHOUT_PRIMITIVES = new TestClass();

    /**
     * A class that has matching properties to {@link TestClass}.
     */
    public static class OtherTestClass extends TestClass {
        public OtherTestClass() {
            super();
        }

        public OtherTestClass(final ComplexProperty complexProperty) {
            super(complexProperty);
        }
    }

    /**
     * An object that is the destination of the conversion, and is empty.
     */
    static final OtherTestClass EMPTY_DESTINATION_WITHOUT_PRIMITIVES = new OtherTestClass();
    /**
     * An object that is the destination of the conversion, and is not empty.
     */
    static final OtherTestClass FULL_DESTINATION_WITHOUT_PRIMITIVES = new OtherTestClass(new ComplexProperty());

    /**
     * A class with a nullable property and a primitive (i.e. non-nullable) property.
     */
    public static class TestClassWithPrimitive extends TestClass {
        public TestClassWithPrimitive() {
            super();
        }

        public TestClassWithPrimitive(final ComplexProperty complexProperty) {
            super(complexProperty);
        }

        private int primitiveValue;

        public int getPrimitiveValue() {
            return primitiveValue;
        }

        public void setPrimitiveValue(final int primitiveValue) {
            this.primitiveValue = primitiveValue;
        }
    }

    static final TestClassWithPrimitive SOURCE_INSTANCE_WITH_PRIMITIVES = new TestClassWithPrimitive();

    /**
     * A class that has matching properties to {@link TestClassWithPrimitive}.
     */
    static class OtherTestClassWithPrimitive extends TestClassWithPrimitive {
        OtherTestClassWithPrimitive() {
            super();
        }

        OtherTestClassWithPrimitive(final ComplexProperty complexProperty) {
            super(complexProperty);
        }
    }

    static final OtherTestClassWithPrimitive EMPTY_DESTINATION_WITH_PRIMITIVES = new OtherTestClassWithPrimitive();
    static final OtherTestClassWithPrimitive FULL_DESTINATION_WITH_PRIMITIVES = new OtherTestClassWithPrimitive(new ComplexProperty());

    /**
     * A DozerMapper for the converters to use to map properties of objects passed to them.
     */
    @Mock
    private static DozerBeanMapper mapper;

    // Note on the following "test subjects":
    // Testing various combinations of classes requires a converter for each combination (Class with & without primtiives; with & without ignored fields).
    // Testing both the convertTo and convertFrom methods require a second converter of each case (or else more complicated test methods).

    /**
     * A concrete ({@link BaseNullIfEmptyConverter}) for testing the convertTo method of a class without primitives.
     */
    private static class BaseNullIfEmptyConverterForClassWithoutPrimitives extends BaseNullIfEmptyConverter<TestClass, OtherTestClass> {
        BaseNullIfEmptyConverterForClassWithoutPrimitives() {
            super(TestClass.class, OtherTestClass.class);
        }
    }

    /**
     * A concrete ({@link BaseNullIfEmptyConverter}) for testing the convertFrom method of a class without primitives.
     */
    private static class BaseNullIfEmptyConverterForClassWithoutPrimitivesForConvertFrom extends BaseNullIfEmptyConverter<OtherTestClass, TestClass> {
        BaseNullIfEmptyConverterForClassWithoutPrimitivesForConvertFrom() {
            super(OtherTestClass.class, TestClass.class);
        }
    }

    /**
     * A concrete ({@link BaseNullIfEmptyConverter}) for testing the convertTo method of a class with primitives.
     */
    private static class BaseNullIfEmptyConverterForClassWithPrimitives extends BaseNullIfEmptyConverter<TestClassWithPrimitive, OtherTestClassWithPrimitive> {
        BaseNullIfEmptyConverterForClassWithPrimitives() {
            super(TestClassWithPrimitive.class, OtherTestClassWithPrimitive.class);
        }
    }

    /**
     * A concrete ({@link BaseNullIfEmptyConverter}) for testing the convertFrom method of a class with primitives.
     */
    private static class BaseNullIfEmptyConverterForClassWithPrimitivesForConvertFrom extends BaseNullIfEmptyConverter<OtherTestClassWithPrimitive, TestClassWithPrimitive> {
        BaseNullIfEmptyConverterForClassWithPrimitivesForConvertFrom() {
            super(OtherTestClassWithPrimitive.class, TestClassWithPrimitive.class);
        }
    }

    /**
     * A concrete ({@link BaseNullIfEmptyConverter}) for testing the convertTo method of a class with a primitive field that ignores the primitive field.
     */
    private static class BaseNullIfEmptyConverterForClassWithIgnoredPrimitive extends BaseNullIfEmptyConverter<TestClassWithPrimitive, OtherTestClassWithPrimitive> {
        BaseNullIfEmptyConverterForClassWithIgnoredPrimitive() {
            super(TestClassWithPrimitive.class, OtherTestClassWithPrimitive.class, Collections.singleton("primitiveValue"));
        }
    }

    /**
     * A concrete ({@link BaseNullIfEmptyConverter}) for testing the convertFrom method of a class with a primitive field that ignores the primitive field.
     */
    private static class BaseNullIfEmptyConverterForClassWithIgnoredPrimitiveForConvertFrom extends BaseNullIfEmptyConverter<OtherTestClassWithPrimitive, TestClassWithPrimitive> {
        BaseNullIfEmptyConverterForClassWithIgnoredPrimitiveForConvertFrom() {
            super(OtherTestClassWithPrimitive.class, TestClassWithPrimitive.class, Collections.singleton("primitiveValue"));
        }
    }

    /**
     * The test subject for the convertTo method for a class without primtiives.
     */
    private final BaseNullIfEmptyConverterForClassWithoutPrimitives convertToConverterForClassWithoutPrimitives = new BaseNullIfEmptyConverterForClassWithoutPrimitives();
    /**
     * The test subject for the convertFrom method for a class without primtiives.
     */
    private final BaseNullIfEmptyConverterForClassWithoutPrimitivesForConvertFrom convertFromConverterForClassWithoutPrimitives
        = new BaseNullIfEmptyConverterForClassWithoutPrimitivesForConvertFrom();
    /**
     * The test subject for the convertTo method for  a class with primitives.
     */
    private final BaseNullIfEmptyConverterForClassWithPrimitives convertToConverterForClassWithPrimitives = new BaseNullIfEmptyConverterForClassWithPrimitives();
    /**
     * The test subject for the convertFrom method for  a class with primitives.
     */
    private final BaseNullIfEmptyConverterForClassWithPrimitivesForConvertFrom convertFromConverterForClassWithPrimitives
        = new BaseNullIfEmptyConverterForClassWithPrimitivesForConvertFrom();
    /**
     * The test subject for the convertTo method for  a class with a primitive field that is ignored.
     */
    private final BaseNullIfEmptyConverterForClassWithIgnoredPrimitive convertToConverterForClassWithIgnoredPrimitive = new BaseNullIfEmptyConverterForClassWithIgnoredPrimitive();
    /**
     * The test subject for the convertFrom method for  a class with a primitive field that is ignored.
     */
    private final BaseNullIfEmptyConverterForClassWithIgnoredPrimitiveForConvertFrom convertFromConverterForClassWithIgnoredPrimitive
        = new BaseNullIfEmptyConverterForClassWithIgnoredPrimitiveForConvertFrom();

    @Before
    public void before() {
        convertToConverterForClassWithoutPrimitives.setMapper(mapper);
        convertFromConverterForClassWithoutPrimitives.setMapper(mapper);
        convertToConverterForClassWithPrimitives.setMapper(mapper);
        convertFromConverterForClassWithPrimitives.setMapper(mapper);
        convertToConverterForClassWithIgnoredPrimitive.setMapper(mapper);
        convertFromConverterForClassWithIgnoredPrimitive.setMapper(mapper);
    }

    @Test
    public void test_NullInput() {
        // This test can be performed on any of the converter instances
        assertNull(convertToConverterForClassWithoutPrimitives.convertTo(null, null));
        assertNull(convertToConverterForClassWithoutPrimitives.convertFrom(null, null));
    }

    @Test
    public void test_FullObjectWithoutPrimitives_IsConvertedToFullObject() {
        testConversionExpectMatch(SOURCE_INSTANCE_WITHOUT_PRIMITIVES, OtherTestClass.class, FULL_DESTINATION_WITHOUT_PRIMITIVES, convertToConverterForClassWithoutPrimitives,
            convertFromConverterForClassWithoutPrimitives);
    }

    @Test
    public void test_EmptyObjectWithoutPrimitives_IsConvertedToNull() {
        testConversionExpectNull(SOURCE_INSTANCE_WITHOUT_PRIMITIVES, OtherTestClass.class, EMPTY_DESTINATION_WITHOUT_PRIMITIVES, convertToConverterForClassWithoutPrimitives,
            convertFromConverterForClassWithoutPrimitives);
    }

    @Test
    public void test_FullObjectWithPrimitives_IsConvertedToFullObject() {
        testConversionExpectMatch(SOURCE_INSTANCE_WITH_PRIMITIVES, OtherTestClassWithPrimitive.class, FULL_DESTINATION_WITH_PRIMITIVES, convertToConverterForClassWithPrimitives,
            convertFromConverterForClassWithPrimitives);
    }

    @Test
    public void test_EmptyObjectWithPrimitives_IsConvertedToFullObject() {
        testConversionExpectMatch(SOURCE_INSTANCE_WITH_PRIMITIVES, OtherTestClassWithPrimitive.class, EMPTY_DESTINATION_WITH_PRIMITIVES, convertToConverterForClassWithPrimitives,
            convertFromConverterForClassWithPrimitives);
    }

    @Test
    public void test_FullObjectWithIgnoredPrimitive_IsConvertedToFullObject() {
        testConversionExpectMatch(SOURCE_INSTANCE_WITH_PRIMITIVES, OtherTestClassWithPrimitive.class, FULL_DESTINATION_WITH_PRIMITIVES,
            convertToConverterForClassWithIgnoredPrimitive, convertFromConverterForClassWithIgnoredPrimitive);

    }

    @Test
    public void test_EmptyObjectWithIgnoredPrimitive_IsConvertedToNull() {
        testConversionExpectNull(SOURCE_INSTANCE_WITH_PRIMITIVES, OtherTestClassWithPrimitive.class, EMPTY_DESTINATION_WITH_PRIMITIVES,
            convertToConverterForClassWithIgnoredPrimitive, convertFromConverterForClassWithIgnoredPrimitive);
    }

    private static void testConversionExpectMatch(final Object source, final Class destClass, final Object convertedDest, final BaseNullIfEmptyConverter convertToConverter,
        final BaseNullIfEmptyConverter convertFromConverter) {
        when(mapper.map(source, destClass)).thenReturn(convertedDest);

        // For simplicity's sake we perform two actions in this one test rather than multiply test methods.
        final Object convertToOutput = convertToConverter.convertTo(source, null);
        final Object convertFromOutput = convertFromConverter.convertFrom(source, null);

        assertSame(convertedDest, convertToOutput);
        assertSame(convertedDest, convertFromOutput);
        verify(mapper, times(2)).map(any(), any());
    }

    private static void testConversionExpectNull(final Object source, final Class destClass, final Object convertedDest, final BaseNullIfEmptyConverter convertToConverter,
        final BaseNullIfEmptyConverter convertFromConverter) {
        when(mapper.map(source, destClass)).thenReturn(convertedDest);

        // For simplicity's sake we perform two actions in this one test rather than multiply test methods.
        final Object convertToOutput = convertToConverter.convertTo(source, null);
        final Object convertFromOutput = convertFromConverter.convertFrom(source, null);

        assertNull(convertToOutput);
        assertNull(convertFromOutput);
        verify(mapper, times(2)).map(any(), any());
    }

}
