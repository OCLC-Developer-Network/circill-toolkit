/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip.common;

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
        final String[] excludedClassNames = { "AgencyId", "FromSystemId", "ToSystemId" };
        TestHelper.verifySVPSubclassesRequireSchemes(packageName, Arrays.asList(excludedClassNames));
    }

    public static class TestAgencyId extends AgencyId {
        public TestAgencyId(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AgencyId VALUE1 = new TestAgencyId("Scheme", "Value One");
        public static final AgencyId VALUE2 = new TestAgencyId("Scheme", "Value Two");
    }

    @Test
    public void testAgencyId() throws Exception {

        final AgencyId assignedValue1 = TestAgencyId.VALUE1;
        final AgencyId foundValue1 = TestAgencyId.find(TestAgencyId.VALUE1.getScheme(), TestAgencyId.VALUE1.getValue());
        assertSame("AgencyId.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AgencyId secondAssignedValue1 = TestAgencyId.VALUE1;
        assertSame("Two instances assigned the same AgencyId constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AgencyId secondFoundValue1 = TestAgencyId.find(TestAgencyId.VALUE1.getScheme(), TestAgencyId.VALUE1.getValue());
        assertSame("Two instances returned by AgencyId.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AgencyId foundValue2 = TestAgencyId.find(TestAgencyId.VALUE2.getScheme(), TestAgencyId.VALUE2.getValue());
        assertNotSame("AgencyId.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AgencyId assignedValue2 = TestAgencyId.VALUE2;
        assertNotSame("Two instances assigned different AgencyId constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AgencyId.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestApplicationProfileSupportedType extends ApplicationProfileSupportedType {
        public TestApplicationProfileSupportedType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ApplicationProfileSupportedType VALUE1 = new TestApplicationProfileSupportedType("Scheme", "Value One");
        public static final ApplicationProfileSupportedType VALUE2 = new TestApplicationProfileSupportedType("Scheme", "Value Two");
    }

    @Test
    public void testApplicationProfileSupportedType() throws Exception {

        final ApplicationProfileSupportedType assignedValue1 = TestApplicationProfileSupportedType.VALUE1;
        final ApplicationProfileSupportedType foundValue1 = TestApplicationProfileSupportedType
            .find(TestApplicationProfileSupportedType.VALUE1.getScheme(), TestApplicationProfileSupportedType.VALUE1.getValue());
        assertSame("ApplicationProfileSupportedType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ApplicationProfileSupportedType secondAssignedValue1 = TestApplicationProfileSupportedType.VALUE1;
        assertSame("Two instances assigned the same ApplicationProfileSupportedType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ApplicationProfileSupportedType secondFoundValue1 = TestApplicationProfileSupportedType
            .find(TestApplicationProfileSupportedType.VALUE1.getScheme(), TestApplicationProfileSupportedType.VALUE1.getValue());
        assertSame("Two instances returned by ApplicationProfileSupportedType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ApplicationProfileSupportedType foundValue2 = TestApplicationProfileSupportedType
            .find(TestApplicationProfileSupportedType.VALUE2.getScheme(), TestApplicationProfileSupportedType.VALUE2.getValue());
        assertNotSame("ApplicationProfileSupportedType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ApplicationProfileSupportedType assignedValue2 = TestApplicationProfileSupportedType.VALUE2;
        assertNotSame("Two instances assigned different ApplicationProfileSupportedType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ApplicationProfileSupportedType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestApplicationProfileType extends ApplicationProfileType {
        public TestApplicationProfileType(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ApplicationProfileType VALUE1 = new TestApplicationProfileType("Scheme", "Value One");
        public static final ApplicationProfileType VALUE2 = new TestApplicationProfileType("Scheme", "Value Two");
    }

    @Test
    public void testApplicationProfileType() throws Exception {

        final ApplicationProfileType assignedValue1 = TestApplicationProfileType.VALUE1;
        final ApplicationProfileType foundValue1 = TestApplicationProfileType.find(TestApplicationProfileType.VALUE1.getScheme(), TestApplicationProfileType.VALUE1.getValue());
        assertSame("ApplicationProfileType.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ApplicationProfileType secondAssignedValue1 = TestApplicationProfileType.VALUE1;
        assertSame("Two instances assigned the same ApplicationProfileType constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ApplicationProfileType secondFoundValue1 = TestApplicationProfileType
            .find(TestApplicationProfileType.VALUE1.getScheme(), TestApplicationProfileType.VALUE1.getValue());
        assertSame("Two instances returned by ApplicationProfileType.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ApplicationProfileType foundValue2 = TestApplicationProfileType.find(TestApplicationProfileType.VALUE2.getScheme(), TestApplicationProfileType.VALUE2.getValue());
        assertNotSame("ApplicationProfileType.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ApplicationProfileType assignedValue2 = TestApplicationProfileType.VALUE2;
        assertNotSame("Two instances assigned different ApplicationProfileType constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ApplicationProfileType.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestFromSystemId extends FromSystemId {
        public TestFromSystemId(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final FromSystemId VALUE1 = new TestFromSystemId("Scheme", "Value One");
        public static final FromSystemId VALUE2 = new TestFromSystemId("Scheme", "Value Two");
    }

    @Test
    public void testFromSystemId() throws Exception {

        final FromSystemId assignedValue1 = TestFromSystemId.VALUE1;
        final FromSystemId foundValue1 = TestFromSystemId.find(TestFromSystemId.VALUE1.getScheme(), TestFromSystemId.VALUE1.getValue());
        assertSame("FromSystemId.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final FromSystemId secondAssignedValue1 = TestFromSystemId.VALUE1;
        assertSame("Two instances assigned the same FromSystemId constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final FromSystemId secondFoundValue1 = TestFromSystemId.find(TestFromSystemId.VALUE1.getScheme(), TestFromSystemId.VALUE1.getValue());
        assertSame("Two instances returned by FromSystemId.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final FromSystemId foundValue2 = TestFromSystemId.find(TestFromSystemId.VALUE2.getScheme(), TestFromSystemId.VALUE2.getValue());
        assertNotSame("FromSystemId.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final FromSystemId assignedValue2 = TestFromSystemId.VALUE2;
        assertNotSame("Two instances assigned different FromSystemId constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by FromSystemId.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    public static class TestToSystemId extends ToSystemId {
        public TestToSystemId(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final ToSystemId VALUE1 = new TestToSystemId("Scheme", "Value One");
        public static final ToSystemId VALUE2 = new TestToSystemId("Scheme", "Value Two");
    }

    @Test
    public void testToSystemId() throws Exception {

        final ToSystemId assignedValue1 = TestToSystemId.VALUE1;
        final ToSystemId foundValue1 = TestToSystemId.find(TestToSystemId.VALUE1.getScheme(), TestToSystemId.VALUE1.getValue());
        assertSame("ToSystemId.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final ToSystemId secondAssignedValue1 = TestToSystemId.VALUE1;
        assertSame("Two instances assigned the same ToSystemId constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final ToSystemId secondFoundValue1 = TestToSystemId.find(TestToSystemId.VALUE1.getScheme(), TestToSystemId.VALUE1.getValue());
        assertSame("Two instances returned by ToSystemId.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final ToSystemId foundValue2 = TestToSystemId.find(TestToSystemId.VALUE2.getScheme(), TestToSystemId.VALUE2.getValue());
        assertNotSame("ToSystemId.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final ToSystemId assignedValue2 = TestToSystemId.VALUE2;
        assertNotSame("Two instances assigned different ToSystemId constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by ToSystemId.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

}
