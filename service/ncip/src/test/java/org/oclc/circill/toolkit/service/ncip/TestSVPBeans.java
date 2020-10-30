/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.BibliographicItemIdentifierCode;
import org.oclc.circill.toolkit.service.base.BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ElectronicAddressType;
import org.oclc.circill.toolkit.service.base.PaymentMethodType;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
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
 * Test this package's {@link SchemeValuePair} sub-classes.
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
        final String[] excludedClassNames = { "FiscalTransactionType", "LimitType", "NoticeType", "PermittedUserAction", "PickupLocation", "ProblemType", "RequestStatusType",
            "UserAddressRoleType", "UserIdentifierType" };
        TestHelper.verifySVPSubclassesRequireSchemes(packageName, Arrays.asList(excludedClassNames));
    }

    /*
        The following tests have to be explicitly coded as they require classes that extend each SchemeValuePair sub-class. This can be done by feeding the
        class names into this awk script:
             {
              print "    public static class Test" $1 " extends " $1 " {"
              print "        public Test" $1 "(final String scheme, final String value) {"
              print "            super(scheme, value);"
              print "        }"
              print ""
              print "        public static final " $1 " VALUE1 = new Test" $1 "(\"Scheme\", \"Value One\");"
              print "        public static final " $1 " VALUE2 = new Test" $1 "(\"Scheme\", \"Value Two\");"
              print "    }"
              print ""
              print "    @Test"
              print "    public void test" $1 "() throws Exception {"
              print ""
              print "        " $1 " assignedValue1 = Test" $1 ".VALUE1;"
              print "        " $1 " foundValue1 = Test" $1 ".find(Test" $1 ".VALUE1.getScheme(), Test" $1 ".VALUE1.getValue());"
              print "        assertSame(\"" $1 ".find method doesn't return the same object as its Scheme & Value parameters were taken from.\", assignedValue1, foundValue1);"
              print ""
              print "        " $1 " secondAssignedValue1 = Test" $1 ".VALUE1;"
              print "        assertSame(\"Two instances assigned the same " $1 " constant aren't the same object.\", assignedValue1, secondAssignedValue1);"
              print ""
              print "        " $1 " secondFoundValue1 = Test" $1 ".find(Test" $1 ".VALUE1.getScheme(), Test" $1 ".VALUE1.getValue());"
              print "        assertSame(\"Two instances returned by " $1 ".find method with same parameters aren't the same object.\", foundValue1, secondFoundValue1);"
              print ""
              print "        " $1 " foundValue2 = Test" $1 ".find(Test" $1 ".VALUE2.getScheme(), Test" $1 ".VALUE2.getValue());"
              print "        assertNotSame(\"" $1 ".find method doesn't return a different value when called with different parameters.\", foundValue1, foundValue2);"
              print ""
              print "        " $1 " assignedValue2 = Test" $1 ".VALUE2;"
              print "        assertNotSame(\"Two instances assigned different " $1 " constants are not different objects.\", assignedValue1, assignedValue2);"
              print ""
              print "        assertNotSame(\"Two instances returned by " $1 ".find method with different parameters aren't different objects.\", foundValue1, foundValue2);"
              print ""
              print "    }"
              print ""
            }
     */

    public static class TestAgencyAddressRoleType extends AgencyAddressRoleType {
        public TestAgencyAddressRoleType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AgencyAddressRoleType VALUE1 = new TestAgencyAddressRoleType("Scheme", "Value One");
        public static final AgencyAddressRoleType VALUE2 = new TestAgencyAddressRoleType("Scheme", "Value Two");
    }

    @Test
    public void testAgencyAddressRoleType() throws Exception {

        final AgencyAddressRoleType assignedValue1 = TestAgencyAddressRoleType.VALUE1;
        final AgencyAddressRoleType foundValue1 = TestAgencyAddressRoleType.find(TestAgencyAddressRoleType.VALUE1.getScheme(), TestAgencyAddressRoleType.VALUE1.getValue());
        assertSame("AgencyAddressRoleType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AgencyAddressRoleType secondAssignedValue1 = TestAgencyAddressRoleType.VALUE1;
        assertSame("Two instances assigned the same AgencyAddressRoleType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AgencyAddressRoleType secondFoundValue1 = TestAgencyAddressRoleType.find(TestAgencyAddressRoleType.VALUE1.getScheme(), TestAgencyAddressRoleType.VALUE1.getValue());
        assertSame("Two instances returned by AgencyAddressRoleType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AgencyAddressRoleType foundValue2 = TestAgencyAddressRoleType.find(TestAgencyAddressRoleType.VALUE2.getScheme(), TestAgencyAddressRoleType.VALUE2.getValue());
        assertNotSame("AgencyAddressRoleType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AgencyAddressRoleType assignedValue2 = TestAgencyAddressRoleType.VALUE2;
        assertNotSame("Two instances assigned different AgencyAddressRoleType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AgencyAddressRoleType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestAgencyElementType extends AgencyElementType {
        public TestAgencyElementType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AgencyElementType VALUE1 = new TestAgencyElementType("Scheme", "Value One");
        public static final AgencyElementType VALUE2 = new TestAgencyElementType("Scheme", "Value Two");
    }

    @Test
    public void testAgencyElementType() throws Exception {

        final AgencyElementType assignedValue1 = TestAgencyElementType.VALUE1;
        final AgencyElementType foundValue1 = TestAgencyElementType.find(TestAgencyElementType.VALUE1.getScheme(), TestAgencyElementType.VALUE1.getValue());
        assertSame("AgencyElementType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AgencyElementType secondAssignedValue1 = TestAgencyElementType.VALUE1;
        assertSame("Two instances assigned the same AgencyElementType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AgencyElementType secondFoundValue1 = TestAgencyElementType.find(TestAgencyElementType.VALUE1.getScheme(), TestAgencyElementType.VALUE1.getValue());
        assertSame("Two instances returned by AgencyElementType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AgencyElementType foundValue2 = TestAgencyElementType.find(TestAgencyElementType.VALUE2.getScheme(), TestAgencyElementType.VALUE2.getValue());
        assertNotSame("AgencyElementType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AgencyElementType assignedValue2 = TestAgencyElementType.VALUE2;
        assertNotSame("Two instances assigned different AgencyElementType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AgencyElementType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestAgencyUserPrivilegeType extends AgencyUserPrivilegeType {
        public TestAgencyUserPrivilegeType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AgencyUserPrivilegeType VALUE1 = new TestAgencyUserPrivilegeType("Scheme", "Value One");
        public static final AgencyUserPrivilegeType VALUE2 = new TestAgencyUserPrivilegeType("Scheme", "Value Two");
    }

    @Test
    public void testAgencyUserPrivilegeType() throws Exception {

        final AgencyUserPrivilegeType assignedValue1 = TestAgencyUserPrivilegeType.VALUE1;
        final AgencyUserPrivilegeType foundValue1 = TestAgencyUserPrivilegeType.find(TestAgencyUserPrivilegeType.VALUE1.getScheme(), TestAgencyUserPrivilegeType.VALUE1.getValue());
        assertSame("AgencyUserPrivilegeType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AgencyUserPrivilegeType secondAssignedValue1 = TestAgencyUserPrivilegeType.VALUE1;
        assertSame("Two instances assigned the same AgencyUserPrivilegeType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AgencyUserPrivilegeType secondFoundValue1 = TestAgencyUserPrivilegeType
            .find(TestAgencyUserPrivilegeType.VALUE1.getScheme(), TestAgencyUserPrivilegeType.VALUE1.getValue());
        assertSame("Two instances returned by AgencyUserPrivilegeType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AgencyUserPrivilegeType foundValue2 = TestAgencyUserPrivilegeType.find(TestAgencyUserPrivilegeType.VALUE2.getScheme(), TestAgencyUserPrivilegeType.VALUE2.getValue());
        assertNotSame("AgencyUserPrivilegeType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AgencyUserPrivilegeType assignedValue2 = TestAgencyUserPrivilegeType.VALUE2;
        assertNotSame("Two instances assigned different AgencyUserPrivilegeType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AgencyUserPrivilegeType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestAuthenticationDataFormatType extends AuthenticationDataFormatType {
        public TestAuthenticationDataFormatType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AuthenticationDataFormatType VALUE1 = new TestAuthenticationDataFormatType("Scheme", "Value One");
        public static final AuthenticationDataFormatType VALUE2 = new TestAuthenticationDataFormatType("Scheme", "Value Two");
    }

    @Test
    public void testAuthenticationDataFormatType() throws Exception {

        final AuthenticationDataFormatType assignedValue1 = TestAuthenticationDataFormatType.VALUE1;
        final AuthenticationDataFormatType foundValue1 = TestAuthenticationDataFormatType
            .find(TestAuthenticationDataFormatType.VALUE1.getScheme(), TestAuthenticationDataFormatType.VALUE1.getValue());
        assertSame("AuthenticationDataFormatType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AuthenticationDataFormatType secondAssignedValue1 = TestAuthenticationDataFormatType.VALUE1;
        assertSame("Two instances assigned the same AuthenticationDataFormatType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AuthenticationDataFormatType secondFoundValue1 = TestAuthenticationDataFormatType
            .find(TestAuthenticationDataFormatType.VALUE1.getScheme(), TestAuthenticationDataFormatType.VALUE1.getValue());
        assertSame("Two instances returned by AuthenticationDataFormatType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AuthenticationDataFormatType foundValue2 = TestAuthenticationDataFormatType
            .find(TestAuthenticationDataFormatType.VALUE2.getScheme(), TestAuthenticationDataFormatType.VALUE2.getValue());
        assertNotSame("AuthenticationDataFormatType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AuthenticationDataFormatType assignedValue2 = TestAuthenticationDataFormatType.VALUE2;
        assertNotSame("Two instances assigned different AuthenticationDataFormatType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AuthenticationDataFormatType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestAuthenticationInputType extends AuthenticationInputType {
        public TestAuthenticationInputType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AuthenticationInputType VALUE1 = new TestAuthenticationInputType("Scheme", "Value One");
        public static final AuthenticationInputType VALUE2 = new TestAuthenticationInputType("Scheme", "Value Two");
    }

    @Test
    public void testAuthenticationInputType() throws Exception {

        final AuthenticationInputType assignedValue1 = TestAuthenticationInputType.VALUE1;
        final AuthenticationInputType foundValue1 = TestAuthenticationInputType.find(TestAuthenticationInputType.VALUE1.getScheme(), TestAuthenticationInputType.VALUE1.getValue());
        assertSame("AuthenticationInputType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AuthenticationInputType secondAssignedValue1 = TestAuthenticationInputType.VALUE1;
        assertSame("Two instances assigned the same AuthenticationInputType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AuthenticationInputType secondFoundValue1 = TestAuthenticationInputType
            .find(TestAuthenticationInputType.VALUE1.getScheme(), TestAuthenticationInputType.VALUE1.getValue());
        assertSame("Two instances returned by AuthenticationInputType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AuthenticationInputType foundValue2 = TestAuthenticationInputType.find(TestAuthenticationInputType.VALUE2.getScheme(), TestAuthenticationInputType.VALUE2.getValue());
        assertNotSame("AuthenticationInputType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AuthenticationInputType assignedValue2 = TestAuthenticationInputType.VALUE2;
        assertNotSame("Two instances assigned different AuthenticationInputType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AuthenticationInputType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestAuthenticationPromptType extends AuthenticationPromptType {
        public TestAuthenticationPromptType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AuthenticationPromptType VALUE1 = new TestAuthenticationPromptType("Scheme", "Value One");
        public static final AuthenticationPromptType VALUE2 = new TestAuthenticationPromptType("Scheme", "Value Two");
    }

    @Test
    public void testAuthenticationPromptType() throws Exception {

        final AuthenticationPromptType assignedValue1 = TestAuthenticationPromptType.VALUE1;
        final AuthenticationPromptType foundValue1 = TestAuthenticationPromptType
            .find(TestAuthenticationPromptType.VALUE1.getScheme(), TestAuthenticationPromptType.VALUE1.getValue());
        assertSame("AuthenticationPromptType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AuthenticationPromptType secondAssignedValue1 = TestAuthenticationPromptType.VALUE1;
        assertSame("Two instances assigned the same AuthenticationPromptType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AuthenticationPromptType secondFoundValue1 = TestAuthenticationPromptType
            .find(TestAuthenticationPromptType.VALUE1.getScheme(), TestAuthenticationPromptType.VALUE1.getValue());
        assertSame("Two instances returned by AuthenticationPromptType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AuthenticationPromptType foundValue2 = TestAuthenticationPromptType
            .find(TestAuthenticationPromptType.VALUE2.getScheme(), TestAuthenticationPromptType.VALUE2.getValue());
        assertNotSame("AuthenticationPromptType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AuthenticationPromptType assignedValue2 = TestAuthenticationPromptType.VALUE2;
        assertNotSame("Two instances assigned different AuthenticationPromptType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AuthenticationPromptType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

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

    public static class TestBibliographicLevel extends BibliographicLevel {
        public TestBibliographicLevel(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final BibliographicLevel VALUE1 = new TestBibliographicLevel("Scheme", "Value One");
        public static final BibliographicLevel VALUE2 = new TestBibliographicLevel("Scheme", "Value Two");
    }

    @Test
    public void testBibliographicLevel() throws Exception {

        final BibliographicLevel assignedValue1 = TestBibliographicLevel.VALUE1;
        final BibliographicLevel foundValue1 = TestBibliographicLevel.find(TestBibliographicLevel.VALUE1.getScheme(), TestBibliographicLevel.VALUE1.getValue());
        assertSame("BibliographicLevel.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final BibliographicLevel secondAssignedValue1 = TestBibliographicLevel.VALUE1;
        assertSame("Two instances assigned the same BibliographicLevel constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final BibliographicLevel secondFoundValue1 = TestBibliographicLevel.find(TestBibliographicLevel.VALUE1.getScheme(), TestBibliographicLevel.VALUE1.getValue());
        assertSame("Two instances returned by BibliographicLevel.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final BibliographicLevel foundValue2 = TestBibliographicLevel.find(TestBibliographicLevel.VALUE2.getScheme(), TestBibliographicLevel.VALUE2.getValue());
        assertNotSame("BibliographicLevel.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final BibliographicLevel assignedValue2 = TestBibliographicLevel.VALUE2;
        assertNotSame("Two instances assigned different BibliographicLevel constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by BibliographicLevel.find method with different parameters aren't different objects.", foundValue1, foundValue2);

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

    public static class TestBlockOrTrapType extends BlockOrTrapType {
        public TestBlockOrTrapType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final BlockOrTrapType VALUE1 = new TestBlockOrTrapType("Scheme", "Value One");
        public static final BlockOrTrapType VALUE2 = new TestBlockOrTrapType("Scheme", "Value Two");
    }

    @Test
    public void testBlockOrTrapType() throws Exception {

        final BlockOrTrapType assignedValue1 = TestBlockOrTrapType.VALUE1;
        final BlockOrTrapType foundValue1 = TestBlockOrTrapType.find(TestBlockOrTrapType.VALUE1.getScheme(), TestBlockOrTrapType.VALUE1.getValue());
        assertSame("BlockOrTrapType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final BlockOrTrapType secondAssignedValue1 = TestBlockOrTrapType.VALUE1;
        assertSame("Two instances assigned the same BlockOrTrapType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final BlockOrTrapType secondFoundValue1 = TestBlockOrTrapType.find(TestBlockOrTrapType.VALUE1.getScheme(), TestBlockOrTrapType.VALUE1.getValue());
        assertSame("Two instances returned by BlockOrTrapType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final BlockOrTrapType foundValue2 = TestBlockOrTrapType.find(TestBlockOrTrapType.VALUE2.getScheme(), TestBlockOrTrapType.VALUE2.getValue());
        assertNotSame("BlockOrTrapType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final BlockOrTrapType assignedValue2 = TestBlockOrTrapType.VALUE2;
        assertNotSame("Two instances assigned different BlockOrTrapType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by BlockOrTrapType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestCirculationStatus extends CirculationStatus {
        public TestCirculationStatus(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final CirculationStatus VALUE1 = new TestCirculationStatus("Scheme", "Value One");
        public static final CirculationStatus VALUE2 = new TestCirculationStatus("Scheme", "Value Two");
    }

    @Test
    public void testCirculationStatus() throws Exception {

        final CirculationStatus assignedValue1 = TestCirculationStatus.VALUE1;
        final CirculationStatus foundValue1 = TestCirculationStatus.find(TestCirculationStatus.VALUE1.getScheme(), TestCirculationStatus.VALUE1.getValue());
        assertSame("CirculationStatus.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final CirculationStatus secondAssignedValue1 = TestCirculationStatus.VALUE1;
        assertSame("Two instances assigned the same CirculationStatus constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final CirculationStatus secondFoundValue1 = TestCirculationStatus.find(TestCirculationStatus.VALUE1.getScheme(), TestCirculationStatus.VALUE1.getValue());
        assertSame("Two instances returned by CirculationStatus.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final CirculationStatus foundValue2 = TestCirculationStatus.find(TestCirculationStatus.VALUE2.getScheme(), TestCirculationStatus.VALUE2.getValue());
        assertNotSame("CirculationStatus.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final CirculationStatus assignedValue2 = TestCirculationStatus.VALUE2;
        assertNotSame("Two instances assigned different CirculationStatus constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by CirculationStatus.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestCitationSourceType extends CitationSourceType {
        public TestCitationSourceType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final CitationSourceType VALUE1 = new TestCitationSourceType("Scheme", "Value One");
        public static final CitationSourceType VALUE2 = new TestCitationSourceType("Scheme", "Value Two");
    }

    @Test
    public void testCitationSourceType() throws Exception {

        final CitationSourceType assignedValue1 = TestCitationSourceType.VALUE1;
        final CitationSourceType foundValue1 = TestCitationSourceType.find(TestCitationSourceType.VALUE1.getScheme(), TestCitationSourceType.VALUE1.getValue());
        assertSame("CitationSourceType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final CitationSourceType secondAssignedValue1 = TestCitationSourceType.VALUE1;
        assertSame("Two instances assigned the same CitationSourceType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final CitationSourceType secondFoundValue1 = TestCitationSourceType.find(TestCitationSourceType.VALUE1.getScheme(), TestCitationSourceType.VALUE1.getValue());
        assertSame("Two instances returned by CitationSourceType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final CitationSourceType foundValue2 = TestCitationSourceType.find(TestCitationSourceType.VALUE2.getScheme(), TestCitationSourceType.VALUE2.getValue());
        assertNotSame("CitationSourceType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final CitationSourceType assignedValue2 = TestCitationSourceType.VALUE2;
        assertNotSame("Two instances assigned different CitationSourceType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by CitationSourceType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestComponentIdentifierType extends ComponentIdentifierType {
        public TestComponentIdentifierType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ComponentIdentifierType VALUE1 = new TestComponentIdentifierType("Scheme", "Value One");
        public static final ComponentIdentifierType VALUE2 = new TestComponentIdentifierType("Scheme", "Value Two");
    }

    @Test
    public void testComponentIdentifierType() throws Exception {

        final ComponentIdentifierType assignedValue1 = TestComponentIdentifierType.VALUE1;
        final ComponentIdentifierType foundValue1 = TestComponentIdentifierType.find(TestComponentIdentifierType.VALUE1.getScheme(), TestComponentIdentifierType.VALUE1.getValue());
        assertSame("ComponentIdentifierType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ComponentIdentifierType secondAssignedValue1 = TestComponentIdentifierType.VALUE1;
        assertSame("Two instances assigned the same ComponentIdentifierType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ComponentIdentifierType secondFoundValue1 = TestComponentIdentifierType
            .find(TestComponentIdentifierType.VALUE1.getScheme(), TestComponentIdentifierType.VALUE1.getValue());
        assertSame("Two instances returned by ComponentIdentifierType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ComponentIdentifierType foundValue2 = TestComponentIdentifierType.find(TestComponentIdentifierType.VALUE2.getScheme(), TestComponentIdentifierType.VALUE2.getValue());
        assertNotSame("ComponentIdentifierType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ComponentIdentifierType assignedValue2 = TestComponentIdentifierType.VALUE2;
        assertNotSame("Two instances assigned different ComponentIdentifierType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ComponentIdentifierType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestConsortiumAgreement extends ConsortiumAgreement {
        public TestConsortiumAgreement(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ConsortiumAgreement VALUE1 = new TestConsortiumAgreement("Scheme", "Value One");
        public static final ConsortiumAgreement VALUE2 = new TestConsortiumAgreement("Scheme", "Value Two");
    }

    @Test
    public void testConsortiumAgreement() throws Exception {

        final ConsortiumAgreement assignedValue1 = TestConsortiumAgreement.VALUE1;
        final ConsortiumAgreement foundValue1 = TestConsortiumAgreement.find(TestConsortiumAgreement.VALUE1.getScheme(), TestConsortiumAgreement.VALUE1.getValue());
        assertSame("ConsortiumAgreement.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ConsortiumAgreement secondAssignedValue1 = TestConsortiumAgreement.VALUE1;
        assertSame("Two instances assigned the same ConsortiumAgreement constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ConsortiumAgreement secondFoundValue1 = TestConsortiumAgreement.find(TestConsortiumAgreement.VALUE1.getScheme(), TestConsortiumAgreement.VALUE1.getValue());
        assertSame("Two instances returned by ConsortiumAgreement.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ConsortiumAgreement foundValue2 = TestConsortiumAgreement.find(TestConsortiumAgreement.VALUE2.getScheme(), TestConsortiumAgreement.VALUE2.getValue());
        assertNotSame("ConsortiumAgreement.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ConsortiumAgreement assignedValue2 = TestConsortiumAgreement.VALUE2;
        assertNotSame("Two instances assigned different ConsortiumAgreement constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ConsortiumAgreement.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestEditionSubstitutionType extends EditionSubstitutionType {
        public TestEditionSubstitutionType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final EditionSubstitutionType VALUE1 = new TestEditionSubstitutionType("Scheme", "Value One");
        public static final EditionSubstitutionType VALUE2 = new TestEditionSubstitutionType("Scheme", "Value Two");
    }

    @Test
    public void testEditionSubstitutionType() throws Exception {

        final EditionSubstitutionType assignedValue1 = TestEditionSubstitutionType.VALUE1;
        final EditionSubstitutionType foundValue1 = TestEditionSubstitutionType.find(TestEditionSubstitutionType.VALUE1.getScheme(), TestEditionSubstitutionType.VALUE1.getValue());
        assertSame("EditionSubstitutionType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final EditionSubstitutionType secondAssignedValue1 = TestEditionSubstitutionType.VALUE1;
        assertSame("Two instances assigned the same EditionSubstitutionType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final EditionSubstitutionType secondFoundValue1 = TestEditionSubstitutionType
            .find(TestEditionSubstitutionType.VALUE1.getScheme(), TestEditionSubstitutionType.VALUE1.getValue());
        assertSame("Two instances returned by EditionSubstitutionType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final EditionSubstitutionType foundValue2 = TestEditionSubstitutionType.find(TestEditionSubstitutionType.VALUE2.getScheme(), TestEditionSubstitutionType.VALUE2.getValue());
        assertNotSame("EditionSubstitutionType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final EditionSubstitutionType assignedValue2 = TestEditionSubstitutionType.VALUE2;
        assertNotSame("Two instances assigned different EditionSubstitutionType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by EditionSubstitutionType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

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

    public static class TestElectronicDataFormatType extends ElectronicDataFormatType {
        public TestElectronicDataFormatType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ElectronicDataFormatType VALUE1 = new TestElectronicDataFormatType("Scheme", "Value One");
        public static final ElectronicDataFormatType VALUE2 = new TestElectronicDataFormatType("Scheme", "Value Two");
    }

    @Test
    public void testElectronicDataFormatType() throws Exception {

        final ElectronicDataFormatType assignedValue1 = TestElectronicDataFormatType.VALUE1;
        final ElectronicDataFormatType foundValue1 = TestElectronicDataFormatType
            .find(TestElectronicDataFormatType.VALUE1.getScheme(), TestElectronicDataFormatType.VALUE1.getValue());
        assertSame("ElectronicDataFormatType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ElectronicDataFormatType secondAssignedValue1 = TestElectronicDataFormatType.VALUE1;
        assertSame("Two instances assigned the same ElectronicDataFormatType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ElectronicDataFormatType secondFoundValue1 = TestElectronicDataFormatType
            .find(TestElectronicDataFormatType.VALUE1.getScheme(), TestElectronicDataFormatType.VALUE1.getValue());
        assertSame("Two instances returned by ElectronicDataFormatType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ElectronicDataFormatType foundValue2 = TestElectronicDataFormatType
            .find(TestElectronicDataFormatType.VALUE2.getScheme(), TestElectronicDataFormatType.VALUE2.getValue());
        assertNotSame("ElectronicDataFormatType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ElectronicDataFormatType assignedValue2 = TestElectronicDataFormatType.VALUE2;
        assertNotSame("Two instances assigned different ElectronicDataFormatType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ElectronicDataFormatType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestElementType extends ElementType {
        public TestElementType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ElementType VALUE1 = new TestElementType("Scheme", "Value One");
        public static final ElementType VALUE2 = new TestElementType("Scheme", "Value Two");
    }

    @Test
    public void testElementType() throws Exception {

        final ElementType assignedValue1 = TestElementType.VALUE1;
        final ElementType foundValue1 = TestElementType.find(TestElementType.VALUE1.getScheme(), TestElementType.VALUE1.getValue());
        assertSame("ElementType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ElementType secondAssignedValue1 = TestElementType.VALUE1;
        assertSame("Two instances assigned the same ElementType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ElementType secondFoundValue1 = TestElementType.find(TestElementType.VALUE1.getScheme(), TestElementType.VALUE1.getValue());
        assertSame("Two instances returned by ElementType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ElementType foundValue2 = TestElementType.find(TestElementType.VALUE2.getScheme(), TestElementType.VALUE2.getValue());
        assertNotSame("ElementType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ElementType assignedValue2 = TestElementType.VALUE2;
        assertNotSame("Two instances assigned different ElementType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ElementType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestFiscalActionType extends FiscalActionType {
        public TestFiscalActionType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final FiscalActionType VALUE1 = new TestFiscalActionType("Scheme", "Value One");
        public static final FiscalActionType VALUE2 = new TestFiscalActionType("Scheme", "Value Two");
    }

    @Test
    public void testFiscalActionType() throws Exception {

        final FiscalActionType assignedValue1 = TestFiscalActionType.VALUE1;
        final FiscalActionType foundValue1 = TestFiscalActionType.find(TestFiscalActionType.VALUE1.getScheme(), TestFiscalActionType.VALUE1.getValue());
        assertSame("FiscalActionType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final FiscalActionType secondAssignedValue1 = TestFiscalActionType.VALUE1;
        assertSame("Two instances assigned the same FiscalActionType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final FiscalActionType secondFoundValue1 = TestFiscalActionType.find(TestFiscalActionType.VALUE1.getScheme(), TestFiscalActionType.VALUE1.getValue());
        assertSame("Two instances returned by FiscalActionType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final FiscalActionType foundValue2 = TestFiscalActionType.find(TestFiscalActionType.VALUE2.getScheme(), TestFiscalActionType.VALUE2.getValue());
        assertNotSame("FiscalActionType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final FiscalActionType assignedValue2 = TestFiscalActionType.VALUE2;
        assertNotSame("Two instances assigned different FiscalActionType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by FiscalActionType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestFiscalTransactionType extends FiscalTransactionType {
        public TestFiscalTransactionType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final FiscalTransactionType VALUE1 = new TestFiscalTransactionType("Scheme", "Value One");
        public static final FiscalTransactionType VALUE2 = new TestFiscalTransactionType("Scheme", "Value Two");
    }

    @Test
    public void testFiscalTransactionType() throws Exception {

        final FiscalTransactionType assignedValue1 = TestFiscalTransactionType.VALUE1;
        final FiscalTransactionType foundValue1 = TestFiscalTransactionType.find(TestFiscalTransactionType.VALUE1.getScheme(), TestFiscalTransactionType.VALUE1.getValue());
        assertSame("FiscalTransactionType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final FiscalTransactionType secondAssignedValue1 = TestFiscalTransactionType.VALUE1;
        assertSame("Two instances assigned the same FiscalTransactionType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final FiscalTransactionType secondFoundValue1 = TestFiscalTransactionType.find(TestFiscalTransactionType.VALUE1.getScheme(), TestFiscalTransactionType.VALUE1.getValue());
        assertSame("Two instances returned by FiscalTransactionType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final FiscalTransactionType foundValue2 = TestFiscalTransactionType.find(TestFiscalTransactionType.VALUE2.getScheme(), TestFiscalTransactionType.VALUE2.getValue());
        assertNotSame("FiscalTransactionType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final FiscalTransactionType assignedValue2 = TestFiscalTransactionType.VALUE2;
        assertNotSame("Two instances assigned different FiscalTransactionType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by FiscalTransactionType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestItemDescriptionLevel extends ItemDescriptionLevel {
        public TestItemDescriptionLevel(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ItemDescriptionLevel VALUE1 = new TestItemDescriptionLevel("Scheme", "Value One");
        public static final ItemDescriptionLevel VALUE2 = new TestItemDescriptionLevel("Scheme", "Value Two");
    }

    @Test
    public void testItemDescriptionLevel() throws Exception {

        final ItemDescriptionLevel assignedValue1 = TestItemDescriptionLevel.VALUE1;
        final ItemDescriptionLevel foundValue1 = TestItemDescriptionLevel.find(TestItemDescriptionLevel.VALUE1.getScheme(), TestItemDescriptionLevel.VALUE1.getValue());
        assertSame("ItemDescriptionLevel.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ItemDescriptionLevel secondAssignedValue1 = TestItemDescriptionLevel.VALUE1;
        assertSame("Two instances assigned the same ItemDescriptionLevel constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ItemDescriptionLevel secondFoundValue1 = TestItemDescriptionLevel.find(TestItemDescriptionLevel.VALUE1.getScheme(), TestItemDescriptionLevel.VALUE1.getValue());
        assertSame("Two instances returned by ItemDescriptionLevel.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ItemDescriptionLevel foundValue2 = TestItemDescriptionLevel.find(TestItemDescriptionLevel.VALUE2.getScheme(), TestItemDescriptionLevel.VALUE2.getValue());
        assertNotSame("ItemDescriptionLevel.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ItemDescriptionLevel assignedValue2 = TestItemDescriptionLevel.VALUE2;
        assertNotSame("Two instances assigned different ItemDescriptionLevel constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ItemDescriptionLevel.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestItemElementType extends ItemElementType {
        public TestItemElementType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ItemElementType VALUE1 = new TestItemElementType("Scheme", "Value One");
        public static final ItemElementType VALUE2 = new TestItemElementType("Scheme", "Value Two");
    }

    @Test
    public void testItemElementType() throws Exception {

        final ItemElementType assignedValue1 = TestItemElementType.VALUE1;
        final ItemElementType foundValue1 = TestItemElementType.find(TestItemElementType.VALUE1.getScheme(), TestItemElementType.VALUE1.getValue());
        assertSame("ItemElementType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ItemElementType secondAssignedValue1 = TestItemElementType.VALUE1;
        assertSame("Two instances assigned the same ItemElementType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ItemElementType secondFoundValue1 = TestItemElementType.find(TestItemElementType.VALUE1.getScheme(), TestItemElementType.VALUE1.getValue());
        assertSame("Two instances returned by ItemElementType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ItemElementType foundValue2 = TestItemElementType.find(TestItemElementType.VALUE2.getScheme(), TestItemElementType.VALUE2.getValue());
        assertNotSame("ItemElementType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ItemElementType assignedValue2 = TestItemElementType.VALUE2;
        assertNotSame("Two instances assigned different ItemElementType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ItemElementType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestItemIdentifierType extends ItemIdentifierType {
        public TestItemIdentifierType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ItemIdentifierType VALUE1 = new TestItemIdentifierType("Scheme", "Value One");
        public static final ItemIdentifierType VALUE2 = new TestItemIdentifierType("Scheme", "Value Two");
    }

    @Test
    public void testItemIdentifierType() throws Exception {

        final ItemIdentifierType assignedValue1 = TestItemIdentifierType.VALUE1;
        final ItemIdentifierType foundValue1 = TestItemIdentifierType.find(TestItemIdentifierType.VALUE1.getScheme(), TestItemIdentifierType.VALUE1.getValue());
        assertSame("ItemIdentifierType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ItemIdentifierType secondAssignedValue1 = TestItemIdentifierType.VALUE1;
        assertSame("Two instances assigned the same ItemIdentifierType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ItemIdentifierType secondFoundValue1 = TestItemIdentifierType.find(TestItemIdentifierType.VALUE1.getScheme(), TestItemIdentifierType.VALUE1.getValue());
        assertSame("Two instances returned by ItemIdentifierType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ItemIdentifierType foundValue2 = TestItemIdentifierType.find(TestItemIdentifierType.VALUE2.getScheme(), TestItemIdentifierType.VALUE2.getValue());
        assertNotSame("ItemIdentifierType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ItemIdentifierType assignedValue2 = TestItemIdentifierType.VALUE2;
        assertNotSame("Two instances assigned different ItemIdentifierType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ItemIdentifierType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestItemUseRestrictionType extends ItemUseRestrictionType {
        public TestItemUseRestrictionType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ItemUseRestrictionType VALUE1 = new TestItemUseRestrictionType("Scheme", "Value One");
        public static final ItemUseRestrictionType VALUE2 = new TestItemUseRestrictionType("Scheme", "Value Two");
    }

    @Test
    public void testItemUseRestrictionType() throws Exception {

        final ItemUseRestrictionType assignedValue1 = TestItemUseRestrictionType.VALUE1;
        final ItemUseRestrictionType foundValue1 = TestItemUseRestrictionType.find(TestItemUseRestrictionType.VALUE1.getScheme(), TestItemUseRestrictionType.VALUE1.getValue());
        assertSame("ItemUseRestrictionType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ItemUseRestrictionType secondAssignedValue1 = TestItemUseRestrictionType.VALUE1;
        assertSame("Two instances assigned the same ItemUseRestrictionType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ItemUseRestrictionType secondFoundValue1 = TestItemUseRestrictionType
            .find(TestItemUseRestrictionType.VALUE1.getScheme(), TestItemUseRestrictionType.VALUE1.getValue());
        assertSame("Two instances returned by ItemUseRestrictionType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ItemUseRestrictionType foundValue2 = TestItemUseRestrictionType.find(TestItemUseRestrictionType.VALUE2.getScheme(), TestItemUseRestrictionType.VALUE2.getValue());
        assertNotSame("ItemUseRestrictionType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ItemUseRestrictionType assignedValue2 = TestItemUseRestrictionType.VALUE2;
        assertNotSame("Two instances assigned different ItemUseRestrictionType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ItemUseRestrictionType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestLanguage extends Language {
        public TestLanguage(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final Language VALUE1 = new TestLanguage("Scheme", "Value One");
        public static final Language VALUE2 = new TestLanguage("Scheme", "Value Two");
    }

    @Test
    public void testLanguage() throws Exception {

        final Language assignedValue1 = TestLanguage.VALUE1;
        final Language foundValue1 = TestLanguage.find(TestLanguage.VALUE1.getScheme(), TestLanguage.VALUE1.getValue());
        assertSame("Language.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final Language secondAssignedValue1 = TestLanguage.VALUE1;
        assertSame("Two instances assigned the same Language constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final Language secondFoundValue1 = TestLanguage.find(TestLanguage.VALUE1.getScheme(), TestLanguage.VALUE1.getValue());
        assertSame("Two instances returned by Language.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final Language foundValue2 = TestLanguage.find(TestLanguage.VALUE2.getScheme(), TestLanguage.VALUE2.getValue());
        assertNotSame("Language.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final Language assignedValue2 = TestLanguage.VALUE2;
        assertNotSame("Two instances assigned different Language constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by Language.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestLimitType extends LimitType {
        public TestLimitType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final LimitType VALUE1 = new TestLimitType("Scheme", "Value One");
        public static final LimitType VALUE2 = new TestLimitType("Scheme", "Value Two");
    }

    @Test
    public void testLimitType() throws Exception {

        final LimitType assignedValue1 = TestLimitType.VALUE1;
        final LimitType foundValue1 = TestLimitType.find(TestLimitType.VALUE1.getScheme(), TestLimitType.VALUE1.getValue());
        assertSame("LimitType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final LimitType secondAssignedValue1 = TestLimitType.VALUE1;
        assertSame("Two instances assigned the same LimitType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final LimitType secondFoundValue1 = TestLimitType.find(TestLimitType.VALUE1.getScheme(), TestLimitType.VALUE1.getValue());
        assertSame("Two instances returned by LimitType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final LimitType foundValue2 = TestLimitType.find(TestLimitType.VALUE2.getScheme(), TestLimitType.VALUE2.getValue());
        assertNotSame("LimitType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final LimitType assignedValue2 = TestLimitType.VALUE2;
        assertNotSame("Two instances assigned different LimitType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by LimitType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestLocationType extends LocationType {
        public TestLocationType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final LocationType VALUE1 = new TestLocationType("Scheme", "Value One");
        public static final LocationType VALUE2 = new TestLocationType("Scheme", "Value Two");
    }

    @Test
    public void testLocationType() throws Exception {

        final LocationType assignedValue1 = TestLocationType.VALUE1;
        final LocationType foundValue1 = TestLocationType.find(TestLocationType.VALUE1.getScheme(), TestLocationType.VALUE1.getValue());
        assertSame("LocationType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final LocationType secondAssignedValue1 = TestLocationType.VALUE1;
        assertSame("Two instances assigned the same LocationType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final LocationType secondFoundValue1 = TestLocationType.find(TestLocationType.VALUE1.getScheme(), TestLocationType.VALUE1.getValue());
        assertSame("Two instances returned by LocationType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final LocationType foundValue2 = TestLocationType.find(TestLocationType.VALUE2.getScheme(), TestLocationType.VALUE2.getValue());
        assertNotSame("LocationType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final LocationType assignedValue2 = TestLocationType.VALUE2;
        assertNotSame("Two instances assigned different LocationType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by LocationType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestMediumType extends MediumType {
        public TestMediumType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final MediumType VALUE1 = new TestMediumType("Scheme", "Value One");
        public static final MediumType VALUE2 = new TestMediumType("Scheme", "Value Two");
    }

    @Test
    public void testMediumType() throws Exception {

        final MediumType assignedValue1 = TestMediumType.VALUE1;
        final MediumType foundValue1 = TestMediumType.find(TestMediumType.VALUE1.getScheme(), TestMediumType.VALUE1.getValue());
        assertSame("MediumType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final MediumType secondAssignedValue1 = TestMediumType.VALUE1;
        assertSame("Two instances assigned the same MediumType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final MediumType secondFoundValue1 = TestMediumType.find(TestMediumType.VALUE1.getScheme(), TestMediumType.VALUE1.getValue());
        assertSame("Two instances returned by MediumType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final MediumType foundValue2 = TestMediumType.find(TestMediumType.VALUE2.getScheme(), TestMediumType.VALUE2.getValue());
        assertNotSame("MediumType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final MediumType assignedValue2 = TestMediumType.VALUE2;
        assertNotSame("Two instances assigned different MediumType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by MediumType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestNoticeIdentifierType extends NoticeIdentifierType {
        public TestNoticeIdentifierType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final NoticeIdentifierType VALUE1 = new TestNoticeIdentifierType("Scheme", "Value One");
        public static final NoticeIdentifierType VALUE2 = new TestNoticeIdentifierType("Scheme", "Value Two");
    }

    @Test
    public void testNoticeIdentifierType() throws Exception {

        final NoticeIdentifierType assignedValue1 = TestNoticeIdentifierType.VALUE1;
        final NoticeIdentifierType foundValue1 = TestNoticeIdentifierType.find(TestNoticeIdentifierType.VALUE1.getScheme(), TestNoticeIdentifierType.VALUE1.getValue());
        assertSame("NoticeIdentifierType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final NoticeIdentifierType secondAssignedValue1 = TestNoticeIdentifierType.VALUE1;
        assertSame("Two instances assigned the same NoticeIdentifierType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final NoticeIdentifierType secondFoundValue1 = TestNoticeIdentifierType.find(TestNoticeIdentifierType.VALUE1.getScheme(), TestNoticeIdentifierType.VALUE1.getValue());
        assertSame("Two instances returned by NoticeIdentifierType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final NoticeIdentifierType foundValue2 = TestNoticeIdentifierType.find(TestNoticeIdentifierType.VALUE2.getScheme(), TestNoticeIdentifierType.VALUE2.getValue());
        assertNotSame("NoticeIdentifierType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final NoticeIdentifierType assignedValue2 = TestNoticeIdentifierType.VALUE2;
        assertNotSame("Two instances assigned different NoticeIdentifierType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by NoticeIdentifierType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestNoticeType extends NoticeType {
        public TestNoticeType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final NoticeType VALUE1 = new TestNoticeType("Scheme", "Value One");
        public static final NoticeType VALUE2 = new TestNoticeType("Scheme", "Value Two");
    }

    @Test
    public void testNoticeType() throws Exception {

        final NoticeType assignedValue1 = TestNoticeType.VALUE1;
        final NoticeType foundValue1 = TestNoticeType.find(TestNoticeType.VALUE1.getScheme(), TestNoticeType.VALUE1.getValue());
        assertSame("NoticeType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final NoticeType secondAssignedValue1 = TestNoticeType.VALUE1;
        assertSame("Two instances assigned the same NoticeType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final NoticeType secondFoundValue1 = TestNoticeType.find(TestNoticeType.VALUE1.getScheme(), TestNoticeType.VALUE1.getValue());
        assertSame("Two instances returned by NoticeType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final NoticeType foundValue2 = TestNoticeType.find(TestNoticeType.VALUE2.getScheme(), TestNoticeType.VALUE2.getValue());
        assertNotSame("NoticeType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final NoticeType assignedValue2 = TestNoticeType.VALUE2;
        assertNotSame("Two instances assigned different NoticeType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by NoticeType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestOrganizationNameType extends OrganizationNameType {
        public TestOrganizationNameType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final OrganizationNameType VALUE1 = new TestOrganizationNameType("Scheme", "Value One");
        public static final OrganizationNameType VALUE2 = new TestOrganizationNameType("Scheme", "Value Two");
    }

    @Test
    public void testOrganizationNameType() throws Exception {

        final OrganizationNameType assignedValue1 = TestOrganizationNameType.VALUE1;
        final OrganizationNameType foundValue1 = TestOrganizationNameType.find(TestOrganizationNameType.VALUE1.getScheme(), TestOrganizationNameType.VALUE1.getValue());
        assertSame("OrganizationNameType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final OrganizationNameType secondAssignedValue1 = TestOrganizationNameType.VALUE1;
        assertSame("Two instances assigned the same OrganizationNameType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final OrganizationNameType secondFoundValue1 = TestOrganizationNameType.find(TestOrganizationNameType.VALUE1.getScheme(), TestOrganizationNameType.VALUE1.getValue());
        assertSame("Two instances returned by OrganizationNameType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final OrganizationNameType foundValue2 = TestOrganizationNameType.find(TestOrganizationNameType.VALUE2.getScheme(), TestOrganizationNameType.VALUE2.getValue());
        assertNotSame("OrganizationNameType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final OrganizationNameType assignedValue2 = TestOrganizationNameType.VALUE2;
        assertNotSame("Two instances assigned different OrganizationNameType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by OrganizationNameType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

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

    public static class TestPermittedUserAction extends PermittedUserAction {
        public TestPermittedUserAction(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PermittedUserAction VALUE1 = new TestPermittedUserAction("Scheme", "Value One");
        public static final PermittedUserAction VALUE2 = new TestPermittedUserAction("Scheme", "Value Two");
    }

    @Test
    public void testPermittedUserAction() throws Exception {

        final PermittedUserAction assignedValue1 = TestPermittedUserAction.VALUE1;
        final PermittedUserAction foundValue1 = TestPermittedUserAction.find(TestPermittedUserAction.VALUE1.getScheme(), TestPermittedUserAction.VALUE1.getValue());
        assertSame("PermittedUserAction.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PermittedUserAction secondAssignedValue1 = TestPermittedUserAction.VALUE1;
        assertSame("Two instances assigned the same PermittedUserAction constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PermittedUserAction secondFoundValue1 = TestPermittedUserAction.find(TestPermittedUserAction.VALUE1.getScheme(), TestPermittedUserAction.VALUE1.getValue());
        assertSame("Two instances returned by PermittedUserAction.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PermittedUserAction foundValue2 = TestPermittedUserAction.find(TestPermittedUserAction.VALUE2.getScheme(), TestPermittedUserAction.VALUE2.getValue());
        assertNotSame("PermittedUserAction.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PermittedUserAction assignedValue2 = TestPermittedUserAction.VALUE2;
        assertNotSame("Two instances assigned different PermittedUserAction constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PermittedUserAction.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestPhysicalAddressType extends PhysicalAddressType {
        public TestPhysicalAddressType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PhysicalAddressType VALUE1 = new TestPhysicalAddressType("Scheme", "Value One");
        public static final PhysicalAddressType VALUE2 = new TestPhysicalAddressType("Scheme", "Value Two");
    }

    @Test
    public void testPhysicalAddressType() throws Exception {

        final PhysicalAddressType assignedValue1 = TestPhysicalAddressType.VALUE1;
        final PhysicalAddressType foundValue1 = TestPhysicalAddressType.find(TestPhysicalAddressType.VALUE1.getScheme(), TestPhysicalAddressType.VALUE1.getValue());
        assertSame("PhysicalAddressType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PhysicalAddressType secondAssignedValue1 = TestPhysicalAddressType.VALUE1;
        assertSame("Two instances assigned the same PhysicalAddressType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PhysicalAddressType secondFoundValue1 = TestPhysicalAddressType.find(TestPhysicalAddressType.VALUE1.getScheme(), TestPhysicalAddressType.VALUE1.getValue());
        assertSame("Two instances returned by PhysicalAddressType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PhysicalAddressType foundValue2 = TestPhysicalAddressType.find(TestPhysicalAddressType.VALUE2.getScheme(), TestPhysicalAddressType.VALUE2.getValue());
        assertNotSame("PhysicalAddressType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PhysicalAddressType assignedValue2 = TestPhysicalAddressType.VALUE2;
        assertNotSame("Two instances assigned different PhysicalAddressType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PhysicalAddressType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestPhysicalConditionType extends PhysicalConditionType {
        public TestPhysicalConditionType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PhysicalConditionType VALUE1 = new TestPhysicalConditionType("Scheme", "Value One");
        public static final PhysicalConditionType VALUE2 = new TestPhysicalConditionType("Scheme", "Value Two");
    }

    @Test
    public void testPhysicalConditionType() throws Exception {

        final PhysicalConditionType assignedValue1 = TestPhysicalConditionType.VALUE1;
        final PhysicalConditionType foundValue1 = TestPhysicalConditionType.find(TestPhysicalConditionType.VALUE1.getScheme(), TestPhysicalConditionType.VALUE1.getValue());
        assertSame("PhysicalConditionType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PhysicalConditionType secondAssignedValue1 = TestPhysicalConditionType.VALUE1;
        assertSame("Two instances assigned the same PhysicalConditionType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PhysicalConditionType secondFoundValue1 = TestPhysicalConditionType.find(TestPhysicalConditionType.VALUE1.getScheme(), TestPhysicalConditionType.VALUE1.getValue());
        assertSame("Two instances returned by PhysicalConditionType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PhysicalConditionType foundValue2 = TestPhysicalConditionType.find(TestPhysicalConditionType.VALUE2.getScheme(), TestPhysicalConditionType.VALUE2.getValue());
        assertNotSame("PhysicalConditionType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PhysicalConditionType assignedValue2 = TestPhysicalConditionType.VALUE2;
        assertNotSame("Two instances assigned different PhysicalConditionType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PhysicalConditionType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestPickupLocation extends PickupLocation {
        public TestPickupLocation(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final PickupLocation VALUE1 = new TestPickupLocation("Scheme", "Value One");
        public static final PickupLocation VALUE2 = new TestPickupLocation("Scheme", "Value Two");
    }

    @Test
    public void testPickupLocation() throws Exception {

        final PickupLocation assignedValue1 = TestPickupLocation.VALUE1;
        final PickupLocation foundValue1 = TestPickupLocation.find(TestPickupLocation.VALUE1.getScheme(), TestPickupLocation.VALUE1.getValue());
        assertSame("PickupLocation.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final PickupLocation secondAssignedValue1 = TestPickupLocation.VALUE1;
        assertSame("Two instances assigned the same PickupLocation constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final PickupLocation secondFoundValue1 = TestPickupLocation.find(TestPickupLocation.VALUE1.getScheme(), TestPickupLocation.VALUE1.getValue());
        assertSame("Two instances returned by PickupLocation.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final PickupLocation foundValue2 = TestPickupLocation.find(TestPickupLocation.VALUE2.getScheme(), TestPickupLocation.VALUE2.getValue());
        assertNotSame("PickupLocation.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final PickupLocation assignedValue2 = TestPickupLocation.VALUE2;
        assertNotSame("Two instances assigned different PickupLocation constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by PickupLocation.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestProblemType extends ProblemType {
        public TestProblemType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ProblemType VALUE1 = new TestProblemType("Scheme", "Value One");
        public static final ProblemType VALUE2 = new TestProblemType("Scheme", "Value Two");
    }

    @Test
    public void testProblemType() throws Exception {

        final ProblemType assignedValue1 = TestProblemType.VALUE1;
        final ProblemType foundValue1 = TestProblemType.find(TestProblemType.VALUE1.getScheme(), TestProblemType.VALUE1.getValue());
        assertSame("ProblemType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ProblemType secondAssignedValue1 = TestProblemType.VALUE1;
        assertSame("Two instances assigned the same ProblemType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ProblemType secondFoundValue1 = TestProblemType.find(TestProblemType.VALUE1.getScheme(), TestProblemType.VALUE1.getValue());
        assertSame("Two instances returned by ProblemType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ProblemType foundValue2 = TestProblemType.find(TestProblemType.VALUE2.getScheme(), TestProblemType.VALUE2.getValue());
        assertNotSame("ProblemType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ProblemType assignedValue2 = TestProblemType.VALUE2;
        assertNotSame("Two instances assigned different ProblemType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ProblemType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestRequestElementType extends RequestElementType {
        public TestRequestElementType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final RequestElementType VALUE1 = new TestRequestElementType("Scheme", "Value One");
        public static final RequestElementType VALUE2 = new TestRequestElementType("Scheme", "Value Two");
    }

    @Test
    public void testRequestElementType() throws Exception {

        final RequestElementType assignedValue1 = TestRequestElementType.VALUE1;
        final RequestElementType foundValue1 = TestRequestElementType.find(TestRequestElementType.VALUE1.getScheme(), TestRequestElementType.VALUE1.getValue());
        assertSame("RequestElementType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final RequestElementType secondAssignedValue1 = TestRequestElementType.VALUE1;
        assertSame("Two instances assigned the same RequestElementType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final RequestElementType secondFoundValue1 = TestRequestElementType.find(TestRequestElementType.VALUE1.getScheme(), TestRequestElementType.VALUE1.getValue());
        assertSame("Two instances returned by RequestElementType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final RequestElementType foundValue2 = TestRequestElementType.find(TestRequestElementType.VALUE2.getScheme(), TestRequestElementType.VALUE2.getValue());
        assertNotSame("RequestElementType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final RequestElementType assignedValue2 = TestRequestElementType.VALUE2;
        assertNotSame("Two instances assigned different RequestElementType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by RequestElementType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestRequestIdentifierType extends RequestIdentifierType {
        public TestRequestIdentifierType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final RequestIdentifierType VALUE1 = new TestRequestIdentifierType("Scheme", "Value One");
        public static final RequestIdentifierType VALUE2 = new TestRequestIdentifierType("Scheme", "Value Two");
    }

    @Test
    public void testRequestIdentifierType() throws Exception {

        final RequestIdentifierType assignedValue1 = TestRequestIdentifierType.VALUE1;
        final RequestIdentifierType foundValue1 = TestRequestIdentifierType.find(TestRequestIdentifierType.VALUE1.getScheme(), TestRequestIdentifierType.VALUE1.getValue());
        assertSame("RequestIdentifierType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final RequestIdentifierType secondAssignedValue1 = TestRequestIdentifierType.VALUE1;
        assertSame("Two instances assigned the same RequestIdentifierType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final RequestIdentifierType secondFoundValue1 = TestRequestIdentifierType.find(TestRequestIdentifierType.VALUE1.getScheme(), TestRequestIdentifierType.VALUE1.getValue());
        assertSame("Two instances returned by RequestIdentifierType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final RequestIdentifierType foundValue2 = TestRequestIdentifierType.find(TestRequestIdentifierType.VALUE2.getScheme(), TestRequestIdentifierType.VALUE2.getValue());
        assertNotSame("RequestIdentifierType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final RequestIdentifierType assignedValue2 = TestRequestIdentifierType.VALUE2;
        assertNotSame("Two instances assigned different RequestIdentifierType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by RequestIdentifierType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestRequestScopeType extends RequestScopeType {
        public TestRequestScopeType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final RequestScopeType VALUE1 = new TestRequestScopeType("Scheme", "Value One");
        public static final RequestScopeType VALUE2 = new TestRequestScopeType("Scheme", "Value Two");
    }

    @Test
    public void testRequestScopeType() throws Exception {

        final RequestScopeType assignedValue1 = TestRequestScopeType.VALUE1;
        final RequestScopeType foundValue1 = TestRequestScopeType.find(TestRequestScopeType.VALUE1.getScheme(), TestRequestScopeType.VALUE1.getValue());
        assertSame("RequestScopeType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final RequestScopeType secondAssignedValue1 = TestRequestScopeType.VALUE1;
        assertSame("Two instances assigned the same RequestScopeType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final RequestScopeType secondFoundValue1 = TestRequestScopeType.find(TestRequestScopeType.VALUE1.getScheme(), TestRequestScopeType.VALUE1.getValue());
        assertSame("Two instances returned by RequestScopeType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final RequestScopeType foundValue2 = TestRequestScopeType.find(TestRequestScopeType.VALUE2.getScheme(), TestRequestScopeType.VALUE2.getValue());
        assertNotSame("RequestScopeType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final RequestScopeType assignedValue2 = TestRequestScopeType.VALUE2;
        assertNotSame("Two instances assigned different RequestScopeType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by RequestScopeType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestRequestStatusType extends RequestStatusType {
        public TestRequestStatusType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final RequestStatusType VALUE1 = new TestRequestStatusType("Scheme", "Value One");
        public static final RequestStatusType VALUE2 = new TestRequestStatusType("Scheme", "Value Two");
    }

    @Test
    public void testRequestStatusType() throws Exception {

        final RequestStatusType assignedValue1 = TestRequestStatusType.VALUE1;
        final RequestStatusType foundValue1 = TestRequestStatusType.find(TestRequestStatusType.VALUE1.getScheme(), TestRequestStatusType.VALUE1.getValue());
        assertSame("RequestStatusType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final RequestStatusType secondAssignedValue1 = TestRequestStatusType.VALUE1;
        assertSame("Two instances assigned the same RequestStatusType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final RequestStatusType secondFoundValue1 = TestRequestStatusType.find(TestRequestStatusType.VALUE1.getScheme(), TestRequestStatusType.VALUE1.getValue());
        assertSame("Two instances returned by RequestStatusType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final RequestStatusType foundValue2 = TestRequestStatusType.find(TestRequestStatusType.VALUE2.getScheme(), TestRequestStatusType.VALUE2.getValue());
        assertNotSame("RequestStatusType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final RequestStatusType assignedValue2 = TestRequestStatusType.VALUE2;
        assertNotSame("Two instances assigned different RequestStatusType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by RequestStatusType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestRequestType extends RequestType {
        public TestRequestType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final RequestType VALUE1 = new TestRequestType("Scheme", "Value One");
        public static final RequestType VALUE2 = new TestRequestType("Scheme", "Value Two");
    }

    @Test
    public void testRequestType() throws Exception {

        final RequestType assignedValue1 = TestRequestType.VALUE1;
        final RequestType foundValue1 = TestRequestType.find(TestRequestType.VALUE1.getScheme(), TestRequestType.VALUE1.getValue());
        assertSame("RequestType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final RequestType secondAssignedValue1 = TestRequestType.VALUE1;
        assertSame("Two instances assigned the same RequestType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final RequestType secondFoundValue1 = TestRequestType.find(TestRequestType.VALUE1.getScheme(), TestRequestType.VALUE1.getValue());
        assertSame("Two instances returned by RequestType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final RequestType foundValue2 = TestRequestType.find(TestRequestType.VALUE2.getScheme(), TestRequestType.VALUE2.getValue());
        assertNotSame("RequestType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final RequestType assignedValue2 = TestRequestType.VALUE2;
        assertNotSame("Two instances assigned different RequestType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by RequestType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestRequestedActionType extends RequestedActionType {
        public TestRequestedActionType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final RequestedActionType VALUE1 = new TestRequestedActionType("Scheme", "Value One");
        public static final RequestedActionType VALUE2 = new TestRequestedActionType("Scheme", "Value Two");
    }

    @Test
    public void testRequestedActionType() throws Exception {

        final RequestedActionType assignedValue1 = TestRequestedActionType.VALUE1;
        final RequestedActionType foundValue1 = TestRequestedActionType.find(TestRequestedActionType.VALUE1.getScheme(), TestRequestedActionType.VALUE1.getValue());
        assertSame("RequestedActionType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final RequestedActionType secondAssignedValue1 = TestRequestedActionType.VALUE1;
        assertSame("Two instances assigned the same RequestedActionType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final RequestedActionType secondFoundValue1 = TestRequestedActionType.find(TestRequestedActionType.VALUE1.getScheme(), TestRequestedActionType.VALUE1.getValue());
        assertSame("Two instances returned by RequestedActionType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final RequestedActionType foundValue2 = TestRequestedActionType.find(TestRequestedActionType.VALUE2.getScheme(), TestRequestedActionType.VALUE2.getValue());
        assertNotSame("RequestedActionType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final RequestedActionType assignedValue2 = TestRequestedActionType.VALUE2;
        assertNotSame("Two instances assigned different RequestedActionType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by RequestedActionType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestSecurityMarker extends SecurityMarker {
        public TestSecurityMarker(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final SecurityMarker VALUE1 = new TestSecurityMarker("Scheme", "Value One");
        public static final SecurityMarker VALUE2 = new TestSecurityMarker("Scheme", "Value Two");
    }

    @Test
    public void testSecurityMarker() throws Exception {

        final SecurityMarker assignedValue1 = TestSecurityMarker.VALUE1;
        final SecurityMarker foundValue1 = TestSecurityMarker.find(TestSecurityMarker.VALUE1.getScheme(), TestSecurityMarker.VALUE1.getValue());
        assertSame("SecurityMarker.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final SecurityMarker secondAssignedValue1 = TestSecurityMarker.VALUE1;
        assertSame("Two instances assigned the same SecurityMarker constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final SecurityMarker secondFoundValue1 = TestSecurityMarker.find(TestSecurityMarker.VALUE1.getScheme(), TestSecurityMarker.VALUE1.getValue());
        assertSame("Two instances returned by SecurityMarker.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final SecurityMarker foundValue2 = TestSecurityMarker.find(TestSecurityMarker.VALUE2.getScheme(), TestSecurityMarker.VALUE2.getValue());
        assertNotSame("SecurityMarker.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final SecurityMarker assignedValue2 = TestSecurityMarker.VALUE2;
        assertNotSame("Two instances assigned different SecurityMarker constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by SecurityMarker.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestSortField extends SortField {
        public TestSortField(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final SortField VALUE1 = new TestSortField("Scheme", "Value One");
        public static final SortField VALUE2 = new TestSortField("Scheme", "Value Two");
    }

    @Test
    public void testSortField() throws Exception {

        final SortField assignedValue1 = TestSortField.VALUE1;
        final SortField foundValue1 = TestSortField.find(TestSortField.VALUE1.getScheme(), TestSortField.VALUE1.getValue());
        assertSame("SortField.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final SortField secondAssignedValue1 = TestSortField.VALUE1;
        assertSame("Two instances assigned the same SortField constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final SortField secondFoundValue1 = TestSortField.find(TestSortField.VALUE1.getScheme(), TestSortField.VALUE1.getValue());
        assertSame("Two instances returned by SortField.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final SortField foundValue2 = TestSortField.find(TestSortField.VALUE2.getScheme(), TestSortField.VALUE2.getValue());
        assertNotSame("SortField.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final SortField assignedValue2 = TestSortField.VALUE2;
        assertNotSame("Two instances assigned different SortField constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by SortField.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestSortOrderType extends SortOrderType {
        public TestSortOrderType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final SortOrderType VALUE1 = new TestSortOrderType("Scheme", "Value One");
        public static final SortOrderType VALUE2 = new TestSortOrderType("Scheme", "Value Two");
    }

    @Test
    public void testSortOrderType() throws Exception {

        final SortOrderType assignedValue1 = TestSortOrderType.VALUE1;
        final SortOrderType foundValue1 = TestSortOrderType.find(TestSortOrderType.VALUE1.getScheme(), TestSortOrderType.VALUE1.getValue());
        assertSame("SortOrderType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final SortOrderType secondAssignedValue1 = TestSortOrderType.VALUE1;
        assertSame("Two instances assigned the same SortOrderType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final SortOrderType secondFoundValue1 = TestSortOrderType.find(TestSortOrderType.VALUE1.getScheme(), TestSortOrderType.VALUE1.getValue());
        assertSame("Two instances returned by SortOrderType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final SortOrderType foundValue2 = TestSortOrderType.find(TestSortOrderType.VALUE2.getScheme(), TestSortOrderType.VALUE2.getValue());
        assertNotSame("SortOrderType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final SortOrderType assignedValue2 = TestSortOrderType.VALUE2;
        assertNotSame("Two instances assigned different SortOrderType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by SortOrderType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestUnstructuredAddressType extends UnstructuredAddressType {
        public TestUnstructuredAddressType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final UnstructuredAddressType VALUE1 = new TestUnstructuredAddressType("Scheme", "Value One");
        public static final UnstructuredAddressType VALUE2 = new TestUnstructuredAddressType("Scheme", "Value Two");
    }

    @Test
    public void testUnstructuredAddressType() throws Exception {

        final UnstructuredAddressType assignedValue1 = TestUnstructuredAddressType.VALUE1;
        final UnstructuredAddressType foundValue1 = TestUnstructuredAddressType.find(TestUnstructuredAddressType.VALUE1.getScheme(), TestUnstructuredAddressType.VALUE1.getValue());
        assertSame("UnstructuredAddressType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final UnstructuredAddressType secondAssignedValue1 = TestUnstructuredAddressType.VALUE1;
        assertSame("Two instances assigned the same UnstructuredAddressType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final UnstructuredAddressType secondFoundValue1 = TestUnstructuredAddressType
            .find(TestUnstructuredAddressType.VALUE1.getScheme(), TestUnstructuredAddressType.VALUE1.getValue());
        assertSame("Two instances returned by UnstructuredAddressType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final UnstructuredAddressType foundValue2 = TestUnstructuredAddressType.find(TestUnstructuredAddressType.VALUE2.getScheme(), TestUnstructuredAddressType.VALUE2.getValue());
        assertNotSame("UnstructuredAddressType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final UnstructuredAddressType assignedValue2 = TestUnstructuredAddressType.VALUE2;
        assertNotSame("Two instances assigned different UnstructuredAddressType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by UnstructuredAddressType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestUserAddressRoleType extends UserAddressRoleType {
        public TestUserAddressRoleType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final UserAddressRoleType VALUE1 = new TestUserAddressRoleType("Scheme", "Value One");
        public static final UserAddressRoleType VALUE2 = new TestUserAddressRoleType("Scheme", "Value Two");
    }

    @Test
    public void testUserAddressRoleType() throws Exception {

        final UserAddressRoleType assignedValue1 = TestUserAddressRoleType.VALUE1;
        final UserAddressRoleType foundValue1 = TestUserAddressRoleType.find(TestUserAddressRoleType.VALUE1.getScheme(), TestUserAddressRoleType.VALUE1.getValue());
        assertSame("UserAddressRoleType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final UserAddressRoleType secondAssignedValue1 = TestUserAddressRoleType.VALUE1;
        assertSame("Two instances assigned the same UserAddressRoleType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final UserAddressRoleType secondFoundValue1 = TestUserAddressRoleType.find(TestUserAddressRoleType.VALUE1.getScheme(), TestUserAddressRoleType.VALUE1.getValue());
        assertSame("Two instances returned by UserAddressRoleType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final UserAddressRoleType foundValue2 = TestUserAddressRoleType.find(TestUserAddressRoleType.VALUE2.getScheme(), TestUserAddressRoleType.VALUE2.getValue());
        assertNotSame("UserAddressRoleType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final UserAddressRoleType assignedValue2 = TestUserAddressRoleType.VALUE2;
        assertNotSame("Two instances assigned different UserAddressRoleType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by UserAddressRoleType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestUserElementType extends UserElementType {
        public TestUserElementType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final UserElementType VALUE1 = new TestUserElementType("Scheme", "Value One");
        public static final UserElementType VALUE2 = new TestUserElementType("Scheme", "Value Two");
    }

    @Test
    public void testUserElementType() throws Exception {

        final UserElementType assignedValue1 = TestUserElementType.VALUE1;
        final UserElementType foundValue1 = TestUserElementType.find(TestUserElementType.VALUE1.getScheme(), TestUserElementType.VALUE1.getValue());
        assertSame("UserElementType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final UserElementType secondAssignedValue1 = TestUserElementType.VALUE1;
        assertSame("Two instances assigned the same UserElementType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final UserElementType secondFoundValue1 = TestUserElementType.find(TestUserElementType.VALUE1.getScheme(), TestUserElementType.VALUE1.getValue());
        assertSame("Two instances returned by UserElementType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final UserElementType foundValue2 = TestUserElementType.find(TestUserElementType.VALUE2.getScheme(), TestUserElementType.VALUE2.getValue());
        assertNotSame("UserElementType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final UserElementType assignedValue2 = TestUserElementType.VALUE2;
        assertNotSame("Two instances assigned different UserElementType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by UserElementType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestUserIdentifierType extends UserIdentifierType {
        public TestUserIdentifierType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final UserIdentifierType VALUE1 = new TestUserIdentifierType("Scheme", "Value One");
        public static final UserIdentifierType VALUE2 = new TestUserIdentifierType("Scheme", "Value Two");
    }

    @Test
    public void testUserIdentifierType() throws Exception {

        final UserIdentifierType assignedValue1 = TestUserIdentifierType.VALUE1;
        final UserIdentifierType foundValue1 = TestUserIdentifierType.find(TestUserIdentifierType.VALUE1.getScheme(), TestUserIdentifierType.VALUE1.getValue());
        assertSame("UserIdentifierType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final UserIdentifierType secondAssignedValue1 = TestUserIdentifierType.VALUE1;
        assertSame("Two instances assigned the same UserIdentifierType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final UserIdentifierType secondFoundValue1 = TestUserIdentifierType.find(TestUserIdentifierType.VALUE1.getScheme(), TestUserIdentifierType.VALUE1.getValue());
        assertSame("Two instances returned by UserIdentifierType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final UserIdentifierType foundValue2 = TestUserIdentifierType.find(TestUserIdentifierType.VALUE2.getScheme(), TestUserIdentifierType.VALUE2.getValue());
        assertNotSame("UserIdentifierType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final UserIdentifierType assignedValue2 = TestUserIdentifierType.VALUE2;
        assertNotSame("Two instances assigned different UserIdentifierType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by UserIdentifierType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestUserLanguage extends UserLanguage {
        public TestUserLanguage(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final UserLanguage VALUE1 = new TestUserLanguage("Scheme", "Value One");
        public static final UserLanguage VALUE2 = new TestUserLanguage("Scheme", "Value Two");
    }

    @Test
    public void testUserLanguage() throws Exception {

        final UserLanguage assignedValue1 = TestUserLanguage.VALUE1;
        final UserLanguage foundValue1 = TestUserLanguage.find(TestUserLanguage.VALUE1.getScheme(), TestUserLanguage.VALUE1.getValue());
        assertSame("UserLanguage.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final UserLanguage secondAssignedValue1 = TestUserLanguage.VALUE1;
        assertSame("Two instances assigned the same UserLanguage constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final UserLanguage secondFoundValue1 = TestUserLanguage.find(TestUserLanguage.VALUE1.getScheme(), TestUserLanguage.VALUE1.getValue());
        assertSame("Two instances returned by UserLanguage.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final UserLanguage foundValue2 = TestUserLanguage.find(TestUserLanguage.VALUE2.getScheme(), TestUserLanguage.VALUE2.getValue());
        assertNotSame("UserLanguage.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final UserLanguage assignedValue2 = TestUserLanguage.VALUE2;
        assertNotSame("Two instances assigned different UserLanguage constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by UserLanguage.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestUserPrivilegeStatusType extends UserPrivilegeStatusType {
        public TestUserPrivilegeStatusType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final UserPrivilegeStatusType VALUE1 = new TestUserPrivilegeStatusType("Scheme", "Value One");
        public static final UserPrivilegeStatusType VALUE2 = new TestUserPrivilegeStatusType("Scheme", "Value Two");
    }

    @Test
    public void testUserPrivilegeStatusType() throws Exception {

        final UserPrivilegeStatusType assignedValue1 = TestUserPrivilegeStatusType.VALUE1;
        final UserPrivilegeStatusType foundValue1 = TestUserPrivilegeStatusType.find(TestUserPrivilegeStatusType.VALUE1.getScheme(), TestUserPrivilegeStatusType.VALUE1.getValue());
        assertSame("UserPrivilegeStatusType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final UserPrivilegeStatusType secondAssignedValue1 = TestUserPrivilegeStatusType.VALUE1;
        assertSame("Two instances assigned the same UserPrivilegeStatusType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final UserPrivilegeStatusType secondFoundValue1 = TestUserPrivilegeStatusType
            .find(TestUserPrivilegeStatusType.VALUE1.getScheme(), TestUserPrivilegeStatusType.VALUE1.getValue());
        assertSame("Two instances returned by UserPrivilegeStatusType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final UserPrivilegeStatusType foundValue2 = TestUserPrivilegeStatusType.find(TestUserPrivilegeStatusType.VALUE2.getScheme(), TestUserPrivilegeStatusType.VALUE2.getValue());
        assertNotSame("UserPrivilegeStatusType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final UserPrivilegeStatusType assignedValue2 = TestUserPrivilegeStatusType.VALUE2;
        assertNotSame("Two instances assigned different UserPrivilegeStatusType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by UserPrivilegeStatusType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

}
