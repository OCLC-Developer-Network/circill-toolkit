/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit tests for OCLCAgencyIdScheme.
 */
public class TestOCLCAgencyIdScheme {

    private static final String TEST_VALUE_1 = "Test value 1 - don't care.";
    private static final String TEST_VALUE_2 = "Test value 2 - don't care.";
    private static final String TEST_SCHEME_URI_1 = "Scheme 1";

    static {
        new ClassPathXmlApplicationContext("circill-toolkit.xml");
    }

    @Test
    public void testLoadAllMethod() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        final Method m = OCLCAgencyIdScheme.class.getMethod("loadAll");
        m.invoke(null);
    }

    public static class TestOCLCAgencyId extends AgencyId {
        public TestOCLCAgencyId(final String scheme, final String value) {
            super(scheme, value);
        }

        public static final AgencyId VALUE1 = new AgencyId(TEST_SCHEME_URI_1, TEST_VALUE_1);
        public static final AgencyId VALUE2 = new AgencyId(TEST_SCHEME_URI_1, TEST_VALUE_2);
    }

    @Test
    public void testIdentity() throws Exception {

        final AgencyId assignedValue1 = TestOCLCAgencyId.VALUE1;
        final AgencyId foundValue1 = AgencyId.find(TestOCLCAgencyId.VALUE1.getScheme(), TestOCLCAgencyId.VALUE1.getValue());
        assertSame("AgencyId.find method doesn't return the same object as its Scheme & Value parameters were taken from.", assignedValue1, foundValue1);

        final AgencyId secondAssignedValue1 = TestOCLCAgencyId.VALUE1;
        assertSame("Two instances assigned the same AgencyId constant aren't the same object.", assignedValue1, secondAssignedValue1);

        final AgencyId secondFoundValue1 = AgencyId.find(TestOCLCAgencyId.VALUE1.getScheme(), TestOCLCAgencyId.VALUE1.getValue());
        assertSame("Two instances returned by AgencyId.find method with same parameters aren't the same object.", foundValue1, secondFoundValue1);

        final AgencyId foundValue2 = AgencyId.find(TestOCLCAgencyId.VALUE2.getScheme(), TestOCLCAgencyId.VALUE2.getValue());
        assertNotSame("AgencyId.find method doesn't return a different value when called with different parameters.", foundValue1, foundValue2);

        final AgencyId assignedValue2 = TestOCLCAgencyId.VALUE2;
        assertNotSame("Two instances assigned different AgencyId constants are not different objects.", assignedValue1, assignedValue2);

        assertNotSame("Two instances returned by AgencyId.find method with different parameters aren't different objects.", foundValue1, foundValue2);

    }

    @Test
    public void testInstIdSchemeAllowsAnyValueInKnownScheme() throws Exception {
        final AgencyId agencyId = AgencyId.find(OCLCAgencyIdScheme.INSTITUTION_ID_SCHEME_URI, TEST_VALUE_1);
        assertNotNull(agencyId);
    }

    @Test
    public void testInstIdSchemeDoesntAllowAnyValueInUnknownScheme() throws ToolkitInternalException {
        try {
            AgencyId.find(OCLCAgencyIdScheme.INSTITUTION_ID_SCHEME_URI + "random-string-" + UUID.randomUUID().toString(), TEST_VALUE_1);
            fail("OCLCAgencyIdScheme should throw an exception for an unknown scheme for institution ids.");
        } catch (ConfigurationException e) {
            // TODO: SchemeValueBehavior should not forward handling of ALLOW_ANY_VALUE_IN_KNOWN_SCHEMES to DEFINED_ONLY; it causes a misleading message about 'DEFINED_ONLY'
            // When that is fixed, correct this to match.
            assertTrue("Incorrect exception thrown.",
                ToolkitHelper.convertExceptionMessagesToString("", e).matches("(?is).*configuration option for defining values for this class is 'DEFINED_ONLY'.*"));
        }
    }

    @Test
    public void testSymbolSchemeAllowsAnyValueInKnownScheme() throws Exception {
        final AgencyId agencyId = AgencyId.find(OCLCAgencyIdScheme.SYMBOL_SCHEME_URI, TEST_VALUE_1);
        assertNotNull(agencyId);
    }

    @Test
    public void testSymbolSchemeDoesntAllowAnyValueInUnknownScheme() throws ToolkitInternalException {
        try {
            AgencyId.find(OCLCAgencyIdScheme.SYMBOL_SCHEME_URI + "random-string-" + UUID.randomUUID().toString(), TEST_VALUE_1);
            fail("OCLCAgencyIdScheme should throw an exception for an unknown scheme for institution symbols.");
        } catch (ConfigurationException e) {
            // TODO: SchemeValueBehavior should not forward handling of ALLOW_ANY_VALUE_IN_KNOWN_SCHEMES to DEFINED_ONLY; it causes a misleading message about 'DEFINED_ONLY'
            // When that is fixed, correct this to match.
            assertTrue("Incorrect exception thrown.",
                ToolkitHelper.convertExceptionMessagesToString("", e).matches("(?is).*configuration option for defining values for this class is 'DEFINED_ONLY'.*"));
        }
    }

}
