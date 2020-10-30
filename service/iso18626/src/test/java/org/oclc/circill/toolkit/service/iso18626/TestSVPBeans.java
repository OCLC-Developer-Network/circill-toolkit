/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.TestHelper;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by bodfishj on 3/13/18.
 */
public class TestSVPBeans {

    private static final Logger LOG = Logger.getLogger(TestSVPBeans.class);

    @Test
    public void testLoadAllMethods()
        throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException, ToolkitInternalException,
        ConfigurationException {
        final String packageName = this.getClass().getPackage().getName();
        TestHelper.verifyLoadAllMethods(packageName);
    }

    @Test
    public void testSVPClassesWithoutScheme()
        throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException, ToolkitInternalException {
        final String packageName = this.getClass().getPackage().getName();
        final String[] excludedClassNames = {};
        TestHelper.verifySVPSubclassesRequireSchemes(packageName, Arrays.asList(excludedClassNames));
    }

    public static class TestAgencyIdType extends AgencyIdType {
        public TestAgencyIdType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AgencyIdType VALUE1 = new TestAgencyIdType("Scheme", "Value One");
        public static final AgencyIdType VALUE2 = new TestAgencyIdType("Scheme", "Value Two");
    }

    @Test
    public void testAgencyIdType() throws Exception {

        final AgencyIdType assignedValue1 = TestAgencyIdType.VALUE1;
        final AgencyIdType foundValue1 = TestAgencyIdType.find(TestAgencyIdType.VALUE1.getScheme(), TestAgencyIdType.VALUE1.getValue());
        assertSame("AgencyIdType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AgencyIdType secondAssignedValue1 = TestAgencyIdType.VALUE1;
        assertSame("Two instances assigned the same AgencyIdType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AgencyIdType secondFoundValue1 = TestAgencyIdType.find(TestAgencyIdType.VALUE1.getScheme(), TestAgencyIdType.VALUE1.getValue());
        assertSame("Two instances returned by AgencyIdType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AgencyIdType foundValue2 = TestAgencyIdType.find(TestAgencyIdType.VALUE2.getScheme(), TestAgencyIdType.VALUE2.getValue());
        assertNotSame("AgencyIdType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AgencyIdType assignedValue2 = TestAgencyIdType.VALUE2;
        assertNotSame("Two instances assigned different AgencyIdType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AgencyIdType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestBillingMethodType extends BillingMethodType {
        public TestBillingMethodType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final BillingMethodType VALUE1 = new TestBillingMethodType("Scheme", "Value One");
        public static final BillingMethodType VALUE2 = new TestBillingMethodType("Scheme", "Value Two");
    }

    @Test
    public void testBillingMethodType() throws Exception {

        final BillingMethodType assignedValue1 = TestBillingMethodType.VALUE1;
        final BillingMethodType foundValue1 = TestBillingMethodType.find(TestBillingMethodType.VALUE1.getScheme(), TestBillingMethodType.VALUE1.getValue());
        assertSame("BillingMethodType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final BillingMethodType secondAssignedValue1 = TestBillingMethodType.VALUE1;
        assertSame("Two instances assigned the same BillingMethodType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final BillingMethodType secondFoundValue1 = TestBillingMethodType.find(TestBillingMethodType.VALUE1.getScheme(), TestBillingMethodType.VALUE1.getValue());
        assertSame("Two instances returned by BillingMethodType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final BillingMethodType foundValue2 = TestBillingMethodType.find(TestBillingMethodType.VALUE2.getScheme(), TestBillingMethodType.VALUE2.getValue());
        assertNotSame("BillingMethodType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final BillingMethodType assignedValue2 = TestBillingMethodType.VALUE2;
        assertNotSame("Two instances assigned different BillingMethodType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by BillingMethodType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestCopyrightComplianceType extends CopyrightComplianceType {
        public TestCopyrightComplianceType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final CopyrightComplianceType VALUE1 = new TestCopyrightComplianceType("Scheme", "Value One");
        public static final CopyrightComplianceType VALUE2 = new TestCopyrightComplianceType("Scheme", "Value Two");
    }

    @Test
    public void testCopyrightComplianceType() throws Exception {

        final CopyrightComplianceType assignedValue1 = TestCopyrightComplianceType.VALUE1;
        final CopyrightComplianceType foundValue1 = TestCopyrightComplianceType.find(TestCopyrightComplianceType.VALUE1.getScheme(), TestCopyrightComplianceType.VALUE1.getValue());
        assertSame("CopyrightComplianceType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final CopyrightComplianceType secondAssignedValue1 = TestCopyrightComplianceType.VALUE1;
        assertSame("Two instances assigned the same CopyrightComplianceType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final CopyrightComplianceType secondFoundValue1 = TestCopyrightComplianceType
            .find(TestCopyrightComplianceType.VALUE1.getScheme(), TestCopyrightComplianceType.VALUE1.getValue());
        assertSame("Two instances returned by CopyrightComplianceType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final CopyrightComplianceType foundValue2 = TestCopyrightComplianceType.find(TestCopyrightComplianceType.VALUE2.getScheme(), TestCopyrightComplianceType.VALUE2.getValue());
        assertNotSame("CopyrightComplianceType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final CopyrightComplianceType assignedValue2 = TestCopyrightComplianceType.VALUE2;
        assertNotSame("Two instances assigned different CopyrightComplianceType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by CopyrightComplianceType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestCountryType extends CountryType {
        public TestCountryType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final CountryType VALUE1 = new TestCountryType("Scheme", "Value One");
        public static final CountryType VALUE2 = new TestCountryType("Scheme", "Value Two");
    }

    @Test
    public void testCountryType() throws Exception {

        final CountryType assignedValue1 = TestCountryType.VALUE1;
        final CountryType foundValue1 = TestCountryType.find(TestCountryType.VALUE1.getScheme(), TestCountryType.VALUE1.getValue());
        assertSame("CountryType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final CountryType secondAssignedValue1 = TestCountryType.VALUE1;
        assertSame("Two instances assigned the same CountryType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final CountryType secondFoundValue1 = TestCountryType.find(TestCountryType.VALUE1.getScheme(), TestCountryType.VALUE1.getValue());
        assertSame("Two instances returned by CountryType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final CountryType foundValue2 = TestCountryType.find(TestCountryType.VALUE2.getScheme(), TestCountryType.VALUE2.getValue());
        assertNotSame("CountryType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final CountryType assignedValue2 = TestCountryType.VALUE2;
        assertNotSame("Two instances assigned different CountryType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by CountryType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestDeliveredFormatType extends DeliveredFormatType {
        public TestDeliveredFormatType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final DeliveredFormatType VALUE1 = new TestDeliveredFormatType("Scheme", "Value One");
        public static final DeliveredFormatType VALUE2 = new TestDeliveredFormatType("Scheme", "Value Two");
    }

    @Test
    public void testDeliveredFormatType() throws Exception {

        final DeliveredFormatType assignedValue1 = TestDeliveredFormatType.VALUE1;
        final DeliveredFormatType foundValue1 = TestDeliveredFormatType.find(TestDeliveredFormatType.VALUE1.getScheme(), TestDeliveredFormatType.VALUE1.getValue());
        assertSame("DeliveredFormatType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final DeliveredFormatType secondAssignedValue1 = TestDeliveredFormatType.VALUE1;
        assertSame("Two instances assigned the same DeliveredFormatType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final DeliveredFormatType secondFoundValue1 = TestDeliveredFormatType.find(TestDeliveredFormatType.VALUE1.getScheme(), TestDeliveredFormatType.VALUE1.getValue());
        assertSame("Two instances returned by DeliveredFormatType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final DeliveredFormatType foundValue2 = TestDeliveredFormatType.find(TestDeliveredFormatType.VALUE2.getScheme(), TestDeliveredFormatType.VALUE2.getValue());
        assertNotSame("DeliveredFormatType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final DeliveredFormatType assignedValue2 = TestDeliveredFormatType.VALUE2;
        assertNotSame("Two instances assigned different DeliveredFormatType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by DeliveredFormatType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestLoanConditionType extends LoanConditionType {
        public TestLoanConditionType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final LoanConditionType VALUE1 = new TestLoanConditionType("Scheme", "Value One");
        public static final LoanConditionType VALUE2 = new TestLoanConditionType("Scheme", "Value Two");
    }

    @Test
    public void testLoanConditionType() throws Exception {

        final LoanConditionType assignedValue1 = TestLoanConditionType.VALUE1;
        final LoanConditionType foundValue1 = TestLoanConditionType.find(TestLoanConditionType.VALUE1.getScheme(), TestLoanConditionType.VALUE1.getValue());
        assertSame("LoanConditionType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final LoanConditionType secondAssignedValue1 = TestLoanConditionType.VALUE1;
        assertSame("Two instances assigned the same LoanConditionType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final LoanConditionType secondFoundValue1 = TestLoanConditionType.find(TestLoanConditionType.VALUE1.getScheme(), TestLoanConditionType.VALUE1.getValue());
        assertSame("Two instances returned by LoanConditionType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final LoanConditionType foundValue2 = TestLoanConditionType.find(TestLoanConditionType.VALUE2.getScheme(), TestLoanConditionType.VALUE2.getValue());
        assertNotSame("LoanConditionType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final LoanConditionType assignedValue2 = TestLoanConditionType.VALUE2;
        assertNotSame("Two instances assigned different LoanConditionType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by LoanConditionType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestPatronType extends PatronType {
        public TestPatronType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PatronType VALUE1 = new TestPatronType("Scheme", "Value One");
        public static final PatronType VALUE2 = new TestPatronType("Scheme", "Value Two");
    }

    @Test
    public void testPatronType() throws Exception {

        final PatronType assignedValue1 = TestPatronType.VALUE1;
        final PatronType foundValue1 = TestPatronType.find(TestPatronType.VALUE1.getScheme(), TestPatronType.VALUE1.getValue());
        assertSame("PatronType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PatronType secondAssignedValue1 = TestPatronType.VALUE1;
        assertSame("Two instances assigned the same PatronType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PatronType secondFoundValue1 = TestPatronType.find(TestPatronType.VALUE1.getScheme(), TestPatronType.VALUE1.getValue());
        assertSame("Two instances returned by PatronType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PatronType foundValue2 = TestPatronType.find(TestPatronType.VALUE2.getScheme(), TestPatronType.VALUE2.getValue());
        assertNotSame("PatronType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PatronType assignedValue2 = TestPatronType.VALUE2;
        assertNotSame("Two instances assigned different PatronType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PatronType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestPreferredFormatType extends PreferredFormatType {
        public TestPreferredFormatType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PreferredFormatType VALUE1 = new TestPreferredFormatType("Scheme", "Value One");
        public static final PreferredFormatType VALUE2 = new TestPreferredFormatType("Scheme", "Value Two");
    }

    @Test
    public void testPreferredFormatType() throws Exception {

        final PreferredFormatType assignedValue1 = TestPreferredFormatType.VALUE1;
        final PreferredFormatType foundValue1 = TestPreferredFormatType.find(TestPreferredFormatType.VALUE1.getScheme(), TestPreferredFormatType.VALUE1.getValue());
        assertSame("PreferredFormatType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PreferredFormatType secondAssignedValue1 = TestPreferredFormatType.VALUE1;
        assertSame("Two instances assigned the same PreferredFormatType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PreferredFormatType secondFoundValue1 = TestPreferredFormatType.find(TestPreferredFormatType.VALUE1.getScheme(), TestPreferredFormatType.VALUE1.getValue());
        assertSame("Two instances returned by PreferredFormatType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PreferredFormatType foundValue2 = TestPreferredFormatType.find(TestPreferredFormatType.VALUE2.getScheme(), TestPreferredFormatType.VALUE2.getValue());
        assertNotSame("PreferredFormatType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PreferredFormatType assignedValue2 = TestPreferredFormatType.VALUE2;
        assertNotSame("Two instances assigned different PreferredFormatType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PreferredFormatType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestPublicationType extends PublicationType {
        public TestPublicationType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PublicationType VALUE1 = new TestPublicationType("Scheme", "Value One");
        public static final PublicationType VALUE2 = new TestPublicationType("Scheme", "Value Two");
    }

    @Test
    public void testPublicationType() throws Exception {

        final PublicationType assignedValue1 = TestPublicationType.VALUE1;
        final PublicationType foundValue1 = TestPublicationType.find(TestPublicationType.VALUE1.getScheme(), TestPublicationType.VALUE1.getValue());
        assertSame("PublicationType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PublicationType secondAssignedValue1 = TestPublicationType.VALUE1;
        assertSame("Two instances assigned the same PublicationType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PublicationType secondFoundValue1 = TestPublicationType.find(TestPublicationType.VALUE1.getScheme(), TestPublicationType.VALUE1.getValue());
        assertSame("Two instances returned by PublicationType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PublicationType foundValue2 = TestPublicationType.find(TestPublicationType.VALUE2.getScheme(), TestPublicationType.VALUE2.getValue());
        assertNotSame("PublicationType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PublicationType assignedValue2 = TestPublicationType.VALUE2;
        assertNotSame("Two instances assigned different PublicationType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PublicationType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestReasonRetryType extends ReasonRetryType {
        public TestReasonRetryType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ReasonRetryType VALUE1 = new TestReasonRetryType("Scheme", "Value One");
        public static final ReasonRetryType VALUE2 = new TestReasonRetryType("Scheme", "Value Two");
    }

    @Test
    public void testReasonRetryType() throws Exception {

        final ReasonRetryType assignedValue1 = TestReasonRetryType.VALUE1;
        final ReasonRetryType foundValue1 = TestReasonRetryType.find(TestReasonRetryType.VALUE1.getScheme(), TestReasonRetryType.VALUE1.getValue());
        assertSame("ReasonRetryType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ReasonRetryType secondAssignedValue1 = TestReasonRetryType.VALUE1;
        assertSame("Two instances assigned the same ReasonRetryType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ReasonRetryType secondFoundValue1 = TestReasonRetryType.find(TestReasonRetryType.VALUE1.getScheme(), TestReasonRetryType.VALUE1.getValue());
        assertSame("Two instances returned by ReasonRetryType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ReasonRetryType foundValue2 = TestReasonRetryType.find(TestReasonRetryType.VALUE2.getScheme(), TestReasonRetryType.VALUE2.getValue());
        assertNotSame("ReasonRetryType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ReasonRetryType assignedValue2 = TestReasonRetryType.VALUE2;
        assertNotSame("Two instances assigned different ReasonRetryType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ReasonRetryType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestReasonUnfilledType extends ReasonUnfilledType {
        public TestReasonUnfilledType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ReasonUnfilledType VALUE1 = new TestReasonUnfilledType("Scheme", "Value One");
        public static final ReasonUnfilledType VALUE2 = new TestReasonUnfilledType("Scheme", "Value Two");
    }

    @Test
    public void testReasonUnfilledType() throws Exception {

        final ReasonUnfilledType assignedValue1 = TestReasonUnfilledType.VALUE1;
        final ReasonUnfilledType foundValue1 = TestReasonUnfilledType.find(TestReasonUnfilledType.VALUE1.getScheme(), TestReasonUnfilledType.VALUE1.getValue());
        assertSame("ReasonUnfilledType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ReasonUnfilledType secondAssignedValue1 = TestReasonUnfilledType.VALUE1;
        assertSame("Two instances assigned the same ReasonUnfilledType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ReasonUnfilledType secondFoundValue1 = TestReasonUnfilledType.find(TestReasonUnfilledType.VALUE1.getScheme(), TestReasonUnfilledType.VALUE1.getValue());
        assertSame("Two instances returned by ReasonUnfilledType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ReasonUnfilledType foundValue2 = TestReasonUnfilledType.find(TestReasonUnfilledType.VALUE2.getScheme(), TestReasonUnfilledType.VALUE2.getValue());
        assertNotSame("ReasonUnfilledType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ReasonUnfilledType assignedValue2 = TestReasonUnfilledType.VALUE2;
        assertNotSame("Two instances assigned different ReasonUnfilledType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ReasonUnfilledType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestRegionType extends RegionType {
        public TestRegionType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final RegionType VALUE1 = new TestRegionType("Scheme", "Value One");
        public static final RegionType VALUE2 = new TestRegionType("Scheme", "Value Two");
    }

    @Test
    public void testRegionType() throws Exception {

        final RegionType assignedValue1 = TestRegionType.VALUE1;
        final RegionType foundValue1 = TestRegionType.find(TestRegionType.VALUE1.getScheme(), TestRegionType.VALUE1.getValue());
        assertSame("RegionType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final RegionType secondAssignedValue1 = TestRegionType.VALUE1;
        assertSame("Two instances assigned the same RegionType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final RegionType secondFoundValue1 = TestRegionType.find(TestRegionType.VALUE1.getScheme(), TestRegionType.VALUE1.getValue());
        assertSame("Two instances returned by RegionType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final RegionType foundValue2 = TestRegionType.find(TestRegionType.VALUE2.getScheme(), TestRegionType.VALUE2.getValue());
        assertNotSame("RegionType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final RegionType assignedValue2 = TestRegionType.VALUE2;
        assertNotSame("Two instances assigned different RegionType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by RegionType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestSentViaType extends SentViaType {
        public TestSentViaType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final SentViaType VALUE1 = new TestSentViaType("Scheme", "Value One");
        public static final SentViaType VALUE2 = new TestSentViaType("Scheme", "Value Two");
    }

    @Test
    public void testSentViaType() throws Exception {

        final SentViaType assignedValue1 = TestSentViaType.VALUE1;
        final SentViaType foundValue1 = TestSentViaType.find(TestSentViaType.VALUE1.getScheme(), TestSentViaType.VALUE1.getValue());
        assertSame("SentViaType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final SentViaType secondAssignedValue1 = TestSentViaType.VALUE1;
        assertSame("Two instances assigned the same SentViaType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final SentViaType secondFoundValue1 = TestSentViaType.find(TestSentViaType.VALUE1.getScheme(), TestSentViaType.VALUE1.getValue());
        assertSame("Two instances returned by SentViaType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final SentViaType foundValue2 = TestSentViaType.find(TestSentViaType.VALUE2.getScheme(), TestSentViaType.VALUE2.getValue());
        assertNotSame("SentViaType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final SentViaType assignedValue2 = TestSentViaType.VALUE2;
        assertNotSame("Two instances assigned different SentViaType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by SentViaType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestServiceLevelType extends ServiceLevelType {
        public TestServiceLevelType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ServiceLevelType VALUE1 = new TestServiceLevelType("Scheme", "Value One");
        public static final ServiceLevelType VALUE2 = new TestServiceLevelType("Scheme", "Value Two");
    }

    @Test
    public void testServiceLevelType() throws Exception {

        final ServiceLevelType assignedValue1 = TestServiceLevelType.VALUE1;
        final ServiceLevelType foundValue1 = TestServiceLevelType.find(TestServiceLevelType.VALUE1.getScheme(), TestServiceLevelType.VALUE1.getValue());
        assertSame("ServiceLevelType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ServiceLevelType secondAssignedValue1 = TestServiceLevelType.VALUE1;
        assertSame("Two instances assigned the same ServiceLevelType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ServiceLevelType secondFoundValue1 = TestServiceLevelType.find(TestServiceLevelType.VALUE1.getScheme(), TestServiceLevelType.VALUE1.getValue());
        assertSame("Two instances returned by ServiceLevelType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ServiceLevelType foundValue2 = TestServiceLevelType.find(TestServiceLevelType.VALUE2.getScheme(), TestServiceLevelType.VALUE2.getValue());
        assertNotSame("ServiceLevelType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ServiceLevelType assignedValue2 = TestServiceLevelType.VALUE2;
        assertNotSame("Two instances assigned different ServiceLevelType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ServiceLevelType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

}
