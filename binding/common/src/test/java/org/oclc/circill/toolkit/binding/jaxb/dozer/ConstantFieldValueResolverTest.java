/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.dozer.MappingException;
import org.junit.Before;
import org.junit.Test;

public class ConstantFieldValueResolverTest {

    private ConstantFieldValueResolver<BigDecimal> testSubject;

    @Before
    public void setup() {
        this.testSubject = new ConstantFieldValueResolver<>(BigDecimal.class);
    }

    @Test
    public void returnsTheConstantFieldValue_ForAKnownConstant() {
        final BigDecimal constantValue = testSubject.resolve("java.math.BigDecimal.ONE");
        assertEquals("Expecting BigDecimal.ONE to be returned from the resolver", BigDecimal.ONE, constantValue);
    }

    @Test
    public void throwsMappingException_WhenParameterDoesNotReferenceAKnownClass() {
        try {
            testSubject.resolve("org.made.up.class.CONSTANT_FIELD");
            fail("Expecting exception to be thrown");
        } catch (MappingException e) {
            assertEquals("", "Unable to find the class 'org.made.up.class'", e.getMessage());
        }
    }

    @Test
    public void throwsMappingException_WhenParameterDoesNotReferenceAKnownConstantField() {
        try {
            testSubject.resolve("java.math.BigDecimal.ONE_THOUSAND");
            fail("Expecting exception to be thrown");
        } catch (MappingException e) {
            assertEquals("", "Unable to find the constant field. Constant field 'ONE_THOUSAND' on class 'java.math.BigDecimal'", e.getMessage());
        }
    }

    @Test
    public void throwsMappingException_WhenParameterDoesNotReferenceASchemeValuePairField() {
        try {
            testSubject.resolve("java.lang.Integer.MAX_VALUE");
            fail("Expecting exception to be thrown");
        } catch (MappingException e) {
            assertEquals("", "Provided constant field is not of type BigDecimal. Constant field 'MAX_VALUE' on class 'java.lang.Integer'", e.getMessage());
        }
    }
}
