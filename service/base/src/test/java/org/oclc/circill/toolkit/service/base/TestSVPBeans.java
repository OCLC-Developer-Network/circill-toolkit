/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Unit tests of SchemeValuePair subclasses
 */
public class TestSVPBeans {
    private static final Logger LOG = Logger.getLogger(TestSVPBeans.class);

    @Test
    public void testLoadAllMethods() throws ToolkitInternalException, InvocationTargetException, IllegalAccessException, ConfigurationException {
        final String packageName = this.getClass().getPackage().getName();
        TestHelper.verifyLoadAllMethods(packageName);
    }

    @Test
    public void testSVPClassesWithoutScheme()
        throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException, ToolkitInternalException {
        final String packageName = this.getClass().getPackage().getName();
        final String[] excludedClassNames = { "ElectronicAddressType" };
        TestHelper.verifySVPSubclassesRequireSchemes(packageName, Arrays.asList(excludedClassNames));
    }

    public static class TestElectronicAddressType extends ElectronicAddressType {
        public TestElectronicAddressType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ElectronicAddressType VALUE1 = new TestElectronicAddressType("Scheme", "Value One");
        public static final ElectronicAddressType VALUE2 = new TestElectronicAddressType("Scheme", "Value Two");
    }

    @Test
    public void testElectronicAddressType() throws Exception {

        final ElectronicAddressType assignedValue1 = TestElectronicAddressType.VALUE1;
        final ElectronicAddressType foundValue1 = TestElectronicAddressType.find(TestElectronicAddressType.VALUE1.getScheme(), TestElectronicAddressType.VALUE1.getValue());
        assertSame("ElectronicAddressType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ElectronicAddressType secondAssignedValue1 = TestElectronicAddressType.VALUE1;
        assertSame("Two instances assigned the same ElectronicAddressType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ElectronicAddressType secondFoundValue1 = TestElectronicAddressType.find(TestElectronicAddressType.VALUE1.getScheme(), TestElectronicAddressType.VALUE1.getValue());
        assertSame("Two instances returned by ElectronicAddressType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ElectronicAddressType foundValue2 = TestElectronicAddressType.find(TestElectronicAddressType.VALUE2.getScheme(), TestElectronicAddressType.VALUE2.getValue());
        assertNotSame("ElectronicAddressType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ElectronicAddressType assignedValue2 = TestElectronicAddressType.VALUE2;
        assertNotSame("Two instances assigned different ElectronicAddressType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ElectronicAddressType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestPaymentMethodType extends PaymentMethodType {
        public TestPaymentMethodType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PaymentMethodType VALUE1 = new TestPaymentMethodType("Scheme", "Value One");
        public static final PaymentMethodType VALUE2 = new TestPaymentMethodType("Scheme", "Value Two");
    }

    @Test
    public void testPaymentMethodType() throws Exception {

        final PaymentMethodType assignedValue1 = TestPaymentMethodType.VALUE1;
        final PaymentMethodType foundValue1 = TestPaymentMethodType.find(TestPaymentMethodType.VALUE1.getScheme(), TestPaymentMethodType.VALUE1.getValue());
        assertSame("PaymentMethodType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PaymentMethodType secondAssignedValue1 = TestPaymentMethodType.VALUE1;
        assertSame("Two instances assigned the same PaymentMethodType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PaymentMethodType secondFoundValue1 = TestPaymentMethodType.find(TestPaymentMethodType.VALUE1.getScheme(), TestPaymentMethodType.VALUE1.getValue());
        assertSame("Two instances returned by PaymentMethodType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PaymentMethodType foundValue2 = TestPaymentMethodType.find(TestPaymentMethodType.VALUE2.getScheme(), TestPaymentMethodType.VALUE2.getValue());
        assertNotSame("PaymentMethodType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PaymentMethodType assignedValue2 = TestPaymentMethodType.VALUE2;
        assertNotSame("Two instances assigned different PaymentMethodType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PaymentMethodType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestBibliographicRecordIdentifierCode extends BibliographicRecordIdentifierCode {
        public TestBibliographicRecordIdentifierCode(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final BibliographicRecordIdentifierCode VALUE1 = new TestBibliographicRecordIdentifierCode("Scheme", "Value One");
        public static final BibliographicRecordIdentifierCode VALUE2 = new TestBibliographicRecordIdentifierCode("Scheme", "Value Two");
    }

    @Test
    public void testBibliographicRecordIdentifierCode() throws Exception {

        final BibliographicRecordIdentifierCode assignedValue1 = TestBibliographicRecordIdentifierCode.VALUE1;
        final BibliographicRecordIdentifierCode foundValue1 = TestBibliographicRecordIdentifierCode
            .find(TestBibliographicRecordIdentifierCode.VALUE1.getScheme(), TestBibliographicRecordIdentifierCode.VALUE1.getValue());
        assertSame("BibliographicRecordIdentifierCode.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final BibliographicRecordIdentifierCode secondAssignedValue1 = TestBibliographicRecordIdentifierCode.VALUE1;
        assertSame("Two instances assigned the same BibliographicRecordIdentifierCode constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final BibliographicRecordIdentifierCode secondFoundValue1 = TestBibliographicRecordIdentifierCode
            .find(TestBibliographicRecordIdentifierCode.VALUE1.getScheme(), TestBibliographicRecordIdentifierCode.VALUE1.getValue());
        assertSame("Two instances returned by BibliographicRecordIdentifierCode.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final BibliographicRecordIdentifierCode foundValue2 = TestBibliographicRecordIdentifierCode
            .find(TestBibliographicRecordIdentifierCode.VALUE2.getScheme(), TestBibliographicRecordIdentifierCode.VALUE2.getValue());
        assertNotSame("BibliographicRecordIdentifierCode.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final BibliographicRecordIdentifierCode assignedValue2 = TestBibliographicRecordIdentifierCode.VALUE2;
        assertNotSame("Two instances assigned different BibliographicRecordIdentifierCode constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by BibliographicRecordIdentifierCode.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestBibliographicItemIdentifierCode extends BibliographicItemIdentifierCode {
        public TestBibliographicItemIdentifierCode(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final BibliographicItemIdentifierCode VALUE1 = new TestBibliographicItemIdentifierCode("Scheme", "Value One");
        public static final BibliographicItemIdentifierCode VALUE2 = new TestBibliographicItemIdentifierCode("Scheme", "Value Two");
    }

    @Test
    public void testBibliographicItemIdentifierCode() throws Exception {

        final BibliographicItemIdentifierCode assignedValue1 = TestBibliographicItemIdentifierCode.VALUE1;
        final BibliographicItemIdentifierCode foundValue1 = TestBibliographicItemIdentifierCode
            .find(TestBibliographicItemIdentifierCode.VALUE1.getScheme(), TestBibliographicItemIdentifierCode.VALUE1.getValue());
        assertSame("BibliographicItemIdentifierCode.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final BibliographicItemIdentifierCode secondAssignedValue1 = TestBibliographicItemIdentifierCode.VALUE1;
        assertSame("Two instances assigned the same BibliographicItemIdentifierCode constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final BibliographicItemIdentifierCode secondFoundValue1 = TestBibliographicItemIdentifierCode
            .find(TestBibliographicItemIdentifierCode.VALUE1.getScheme(), TestBibliographicItemIdentifierCode.VALUE1.getValue());
        assertSame("Two instances returned by BibliographicItemIdentifierCode.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final BibliographicItemIdentifierCode foundValue2 = TestBibliographicItemIdentifierCode
            .find(TestBibliographicItemIdentifierCode.VALUE2.getScheme(), TestBibliographicItemIdentifierCode.VALUE2.getValue());
        assertNotSame("BibliographicItemIdentifierCode.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final BibliographicItemIdentifierCode assignedValue2 = TestBibliographicItemIdentifierCode.VALUE2;
        assertNotSame("Two instances assigned different BibliographicItemIdentifierCode constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by BibliographicItemIdentifierCode.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestCurrencyCode extends CurrencyCode {
        public TestCurrencyCode(final String scheme, final String value, final int minorUnit) {
            super(scheme, value, minorUnit);
        }

        public static final CurrencyCode VALUE1 = new TestCurrencyCode("Scheme", "Value One", 1);
        public static final CurrencyCode VALUE2 = new TestCurrencyCode("Scheme", "Value Two", 2);
    }

    @Test
    public void testCurrencyCode() throws Exception {

        final CurrencyCode assignedValue1 = TestCurrencyCode.VALUE1;
        final CurrencyCode foundValue1 = TestCurrencyCode.find(TestCurrencyCode.VALUE1.getScheme(), TestCurrencyCode.VALUE1.getValue());
        assertSame("CurrencyCode.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final CurrencyCode secondAssignedValue1 = TestCurrencyCode.VALUE1;
        assertSame("Two instances assigned the same CurrencyCode constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final CurrencyCode secondFoundValue1 = TestCurrencyCode.find(TestCurrencyCode.VALUE1.getScheme(), TestCurrencyCode.VALUE1.getValue());
        assertSame("Two instances returned by CurrencyCode.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final CurrencyCode foundValue2 = TestCurrencyCode.find(TestCurrencyCode.VALUE2.getScheme(), TestCurrencyCode.VALUE2.getValue());
        assertNotSame("CurrencyCode.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final CurrencyCode assignedValue2 = TestCurrencyCode.VALUE2;
        assertNotSame("Two instances assigned different CurrencyCode constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by CurrencyCode.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }
}
