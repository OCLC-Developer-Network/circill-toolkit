/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import org.oclc.circill.toolkit.service.base.SchemeValuePair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.dozer.MappingException;
import org.junit.Before;
import org.junit.Test;

public class SVPBooleanConverterTest {

    /** Class name of the TestSchemeValuePair inner class within this test */
    private static final String TEST_SCHEME_VALUE_PAIR_CLASS_NAME = TestSchemeValuePair.class.getName();

    private SVPBooleanConverter testSubject;

    @Before
    public void setup() {
        testSubject = new SVPBooleanConverter();
    }

    // ---- (SVP <-> Boolean) Conversion
    @Test
    public void convertsATrueBooleanToTheProvidedSchemeValuePair() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, Boolean.TRUE, SchemeValuePair.class, Boolean.class);

        assertEquals("Expecting a true Boolean to produce the provided scheme-value pair", TestSchemeValuePair.TEST_SCHEME_VALUE_PAIR, result);
    }

    @Test
    public void convertsAFalseBooleanToANullSchemeValuePair() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, Boolean.FALSE, SchemeValuePair.class, Boolean.class);

        assertNull("Expecting a false Boolean to produce a null scheme-value pair", result);
    }

    @Test
    public void convertsANullBooleanToANullSchemeValuePair() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, null, SchemeValuePair.class, Boolean.class);

        assertNull("Expecting a null Boolean to produce a null scheme-value pair", result);
    }

    @Test
    public void convertsASchemeValuePairToATrueBoolean_IfTheSchemeValuePairMatchesTheParameter() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, TestSchemeValuePair.TEST_SCHEME_VALUE_PAIR, Boolean.class, SchemeValuePair.class);

        assertTrue("Expecting true result when scheme-value pair does match the expected value", (Boolean) result);
    }

    @Test
    public void convertsASchemeValuePairToAFalseBoolean_IfTheSchemeValuePairDoesNotMatchTheParameter() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, TestSchemeValuePair.OTHER_TEST_SCHEME_VALUE_PAIR, Boolean.class, SchemeValuePair.class);

        assertFalse("Expecting false result scheme-value pair does not match the expected value", (Boolean) result);
    }

    @Test
    public void convertsASchemeValuePairToAFalseBoolean_IfNoSchemeValuePairIsProvided() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, null, Boolean.class, SchemeValuePair.class);

        assertFalse("Expecting null schema to produce a false result", (Boolean) result);
    }

    // ---- (SVP <-> String) Conversion
    @Test
    public void convertsATrueBooleanStringToTheProvidedSchemeValuePair() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, "true", SchemeValuePair.class, String.class);

        assertEquals("Expecting a true Boolean String to produce the provided scheme-value pair", TestSchemeValuePair.TEST_SCHEME_VALUE_PAIR, result);
    }

    @Test
    public void convertsAFalseBooleanStringToANullSchemeValuePair() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, "false", SchemeValuePair.class, String.class);

        assertNull("Expecting a false Boolean String to produce a null scheme-value pair", result);
    }

    @Test
    public void convertsANonBooleanStringToANullSchemeValuePair() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, "other string", SchemeValuePair.class, String.class);

        assertNull("Expecting a non-Boolean String to produce a null scheme-value pair", result);
    }

    @Test
    public void convertsANullBooleanStringToANullSchemeValuePair() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, null, SchemeValuePair.class, String.class);

        assertNull("Expecting a null Boolean String to produce a null scheme-value pair", result);
    }

    @Test
    public void convertsASchemeValuePairToATrueBooleanString_IfTheSchemeValuePairMatchesTheParameter() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, TestSchemeValuePair.TEST_SCHEME_VALUE_PAIR, String.class, SchemeValuePair.class);

        assertEquals("Expecting 'true' result when scheme-value pair does match the expected value", "true", result);
    }

    @Test
    public void convertsASchemeValuePairToAFalseBooleanString_IfTheSchemeValuePairDoesNotMatchTheParameter() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, TestSchemeValuePair.OTHER_TEST_SCHEME_VALUE_PAIR, String.class, SchemeValuePair.class);

        assertEquals("Expecting 'false' result scheme-value pair does not match the expected value", "false", result);
    }

    @Test
    public void convertsASchemeValuePairToAFalseBooleanString_IfNoSchemeValuePairIsProvided() {
        setSchemeValuePairParameter();

        final Object result = testSubject.convert(null, null, String.class, SchemeValuePair.class);

        assertEquals("Expecting null schema to produce a 'false' result", "false", result);
    }

    @Test(expected = IllegalStateException.class)
    public void throwsException_WhenNoParameterProvided() {
        testSubject.convert(null, null, Boolean.class, SchemeValuePair.class);
    }

    @Test(expected = MappingException.class)
    public void throwsException_WhenInvalidSourceAndDestinationCombinationIsUsed() {
        setSchemeValuePairParameter();
        testSubject.convert(null, null, Integer.class, Boolean.class);
    }

    /**
     * Set the scheme-value pair parameter for the test subject
     * This is simply set to the {@link TestSchemeValuePair}s constant value
     */
    private void setSchemeValuePairParameter() {
        testSubject.setParameter(TEST_SCHEME_VALUE_PAIR_CLASS_NAME + ".TEST_SCHEME_VALUE_PAIR");
    }

    /**
     * Scheme-Value pair example implementation for this test
     */
    public static class TestSchemeValuePair extends SchemeValuePair {

        public static final TestSchemeValuePair TEST_SCHEME_VALUE_PAIR = new TestSchemeValuePair("scheme", "value");
        public static final TestSchemeValuePair OTHER_TEST_SCHEME_VALUE_PAIR = new TestSchemeValuePair("other-scheme", "other-value");

        private TestSchemeValuePair(final String scheme, final String value) {
            super(scheme, value);
        }

    }

}
