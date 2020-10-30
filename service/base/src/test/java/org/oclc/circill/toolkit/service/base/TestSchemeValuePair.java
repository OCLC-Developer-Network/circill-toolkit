/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Note: Care must be taken when adding tests not to make use of a Scheme for an element that is used otherwise in other tests,
 * as the {@link SchemeValuePair} class maintains a static registry of Schemes thus one test might update the registry in a way
 * that would break another test, and the failure might be dependent on the order in which the tests are executed.
 * An "element" here refers to the NCIP XML element that is of type SchemeValuePair; in the NCIP 2 Toolkit this is represented
 * as an (immediate) subclass of {@link SchemeValuePair}.
 */
public class TestSchemeValuePair {

    private static final Logger LOG = Logger.getLogger(TestSchemeValuePair.class);

    private static final String EXCLUDE_TEST_SVPS_PATTERN = ".*" + TestSchemeValuePair.class.getName() + "\\$.*";

    private static final String TEST_SCHEME = "Test Scheme"; // Only need an identifiable, distinct string
    private static final String TEST_VALUE_1 = "Test Value 1"; // Only need an identifiable, distinct string
    private static final String TEST_VALUE_2 = "Test Value 2"; // Only need an identifiable, distinct string
    private static final String TEST_VALUE_3 = "Test Value 3"; // Only need an identifiable, distinct string

    //
    // Test classes
    //
    // To avoid interaction between tests, tests that rely on configuration use classes that directly extend SchemeValuePair and
    // are "purpose-built" for each configurable behavior. This creates a unique "element" for each test which prevents the class-under-test's behavior
    // from being affected by other tests.
    static class SVPAllowingNullScheme extends SchemeValuePair {
        public static final SVPAllowingNullScheme DEFINED_VALUE_WITH_NULL_SCHEME = new SVPAllowingNullScheme(null, "SVPAllowingNullScheme, Defined Value");

        SVPAllowingNullScheme(final String scheme, final String value) {
            super(scheme, value);
        }

        public static SVPAllowingNullScheme find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (SVPAllowingNullScheme) find(scheme, value, SVPAllowingNullScheme.class);
        }
    }

    static class SVPAllowingAnySchemeAndAnyValue extends SchemeValuePair {
        @SuppressWarnings("checkstyle:RedundantModifier") // This must be public so that SchemeValuePair can use reflection to construct an instance.
        public SVPAllowingAnySchemeAndAnyValue(final String scheme, final String value) {
            super(scheme, value);
        }

        public static SVPAllowingAnySchemeAndAnyValue find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (SVPAllowingAnySchemeAndAnyValue) find(scheme, value, SVPAllowingAnySchemeAndAnyValue.class);
        }
    }

    static class SVPForAddIfAbsent extends SchemeValuePair {
        @SuppressWarnings("checkstyle:RedundantModifier") // This must be public so that SchemeValuePair can use reflection to construct an instance.
        public SVPForAddIfAbsent(final String scheme, final String value) {
            super(scheme, value);
        }

        public static SVPForAddIfAbsent find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (SVPForAddIfAbsent) find(scheme, value, SVPForAddIfAbsent.class);
        }
    }

    static class SVPWithAllowAnyValueInKnownSchemesBehavior extends SchemeValuePair {
        SVPWithAllowAnyValueInKnownSchemesBehavior(final String scheme, final String value) {
            super(scheme, value);
        }

        public static SVPWithAllowAnyValueInKnownSchemesBehavior find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (SVPWithAllowAnyValueInKnownSchemesBehavior) find(scheme, value, SVPWithAllowAnyValueInKnownSchemesBehavior.class);
        }
    }

    static class SVPWithDefinedOnlyBehavior extends SchemeValuePair {
        SVPWithDefinedOnlyBehavior(final String scheme, final String value) {
            super(scheme, value);
        }

        public static SVPWithDefinedOnlyBehavior find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (SVPWithDefinedOnlyBehavior) find(scheme, value, SVPWithDefinedOnlyBehavior.class);
        }
    }

    static class SVPThatDoesntAllowNullScheme extends SchemeValuePair {
        SVPThatDoesntAllowNullScheme(final String scheme, final String value) {
            super(scheme, value);
        }

        public static SVPThatDoesntAllowNullScheme find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (SVPThatDoesntAllowNullScheme) find(scheme, value, SVPThatDoesntAllowNullScheme.class);
        }
    }

    static class SVPWithUnsetBehavior extends SchemeValuePair {
        SVPWithUnsetBehavior(final String scheme, final String value) {
            super(scheme, value);
        }

        public static SVPWithUnsetBehavior find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (SVPWithUnsetBehavior) find(scheme, value, SVPWithUnsetBehavior.class);
        }
    }

    static class TestSVPElement extends SchemeValuePair {
        @SuppressWarnings("checkstyle:RedundantModifier") // This must be public so that SchemeValuePair can use reflection to construct an instance.
        public TestSVPElement(final String scheme, final String value) {
            super(scheme, value);
        }

        @SuppressWarnings("checkstyle:RedundantModifier") // This must be public so that SchemeValuePair can use reflection to construct an instance.
        public TestSVPElement(final String value) {
            super(value);
        }

        public static TestSVPElement find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (TestSVPElement) find(scheme, value, TestSVPElement.class);
        }
    }

    static class TestSVPOne extends TestSVPElement {
        public static final String TEST_SVP_ONE = "http://test.com/testone.scm";
        public static final TestSVPOne DEFINED_VALUE_1 = new TestSVPOne(TEST_SVP_ONE, "Test SVP One, Defined Value 1");
        public static final TestSVPOne DEFINED_VALUE_2 = new TestSVPOne(TEST_SVP_ONE, "Test SVP One, Defined Value 2");

        public static void loadAll() {
            // Do nothing - merely invoking this method forces the creation of the instances defined above.
        }

        @SuppressWarnings("checkstyle:RedundantModifier") // This must be public so that SchemeValuePair can use reflection to construct an instance.
        public TestSVPOne(final String scheme, final String value) {
            super(scheme, value);
        }

        // Permit construction without Scheme URI
        @SuppressWarnings("checkstyle:RedundantModifier") // This must be public so that SchemeValuePair can use reflection to construct an instance.
        public TestSVPOne(final String value) {
            super(null, value);
        }
    }

    static class TestSVPTwo extends TestSVPElement {
        public static final String TEST_SVP_TWO = "http://test.com/testtwo.scm";
        public static final TestSVPTwo DEFINED_VALUE_1 = new TestSVPTwo(TEST_SVP_TWO, "Test SVP Two, Defined Value 1");

        public static void loadAll() {
            // Do nothing - merely invoking this method forces the creation of the instances defined above.
        }

        TestSVPTwo(final String scheme, final String value) {
            super(scheme, value);
        }
    }

    static class NotTrulyAnSVP extends SchemeValuePair {
        // Note: No constructor taking two strings.
        NotTrulyAnSVP() {
            super("", "");
        }
    }

    static class SVPForLoadSchemeValueClasses extends SchemeValuePair {
        public static final SVPForLoadSchemeValueClasses DEFINED_VALUE_1 = new SVPForLoadSchemeValueClasses("TEST_SVP_ONE", "Test Load SVP, Defined Value 1");
        SVPForLoadSchemeValueClasses(final String scheme, final String value) {
            super(scheme, value);
        }
        public static void loadAll() {
            // Do nothing - merely invoking this method forces the creation of the instances defined above.
        }
    }

    static class SVPWithoutLoadAllMethod extends SchemeValuePair {
        public static final SVPWithoutLoadAllMethod DEFINED_VALUE_1 = new SVPWithoutLoadAllMethod("TEST_SVP_ONE", "Test Load SVP, Defined Value 1");
        SVPWithoutLoadAllMethod(final String scheme, final String value) {
            super(scheme, value);
        }
    }

    static class SVPForSchemeURIAliases extends SchemeValuePair {
        public static final String SCHEME_1 = "Test Scheme 1";
        public static final String VALUE_1 = "Test Value 1";
        public static final SVPForSchemeURIAliases DEFINED_VALUE_1 = new SVPForSchemeURIAliases(SCHEME_1, VALUE_1);
        SVPForSchemeURIAliases(final String scheme, final String value) {
            super(scheme, value);
        }
        public static void loadAll() {
            // Do nothing - merely invoking this method forces the creation of the instances defined above.
        }
    }

    static class SVPForGetIterator extends SchemeValuePair {
        public static final String SCHEME_1 = "Test Scheme 1";
        public static final String VALUE_1 = "Test Value 1";
        public static final SVPForGetIterator DEFINED_VALUE_1 = new SVPForGetIterator(SCHEME_1, VALUE_1);
        SVPForGetIterator(final String scheme, final String value) {
            super(scheme, value);
        }
        public static void loadAll() {
            // Do nothing - merely invoking this method forces the creation of the instances defined above.
        }
    }

    static class SVPWithNoRegisteredInstances extends SchemeValuePair {

        public SVPWithNoRegisteredInstances(String scheme, String value) {
            super(scheme, value);
        }
    }

    static class SVPForTestAllowAnyValue extends SchemeValuePair {
        public SVPForTestAllowAnyValue(String scheme, String value) {
            super(scheme, value);
        }

    }

    static class SVPForTestClearBehaviors extends SchemeValuePair {
        public SVPForTestClearBehaviors(String scheme, String value) {
            super(scheme, value);
        }

    }

    static class SVPForTestAllowAnyValueInKnownSchemes extends SchemeValuePair {
        public static final String scheme1 = "TEST_SVP_1";
        public static final SVPForTestAllowAnyValueInKnownSchemes DEFINED_VALUE_1 = new SVPForTestAllowAnyValueInKnownSchemes(scheme1, SchemeValueBehavior.ANY_VALUES_FLAG);

        public SVPForTestAllowAnyValueInKnownSchemes(String scheme, String value) {
            super(scheme, value);
        }

    }

    static class SVPForEqualsAndHashCode extends SchemeValuePair {
        public SVPForEqualsAndHashCode(String scheme, String value) { super(scheme, value); }
    }

    //
    // Tests of toString method
    //
    @Test
    public void testToString() {
        final SchemeValuePair testSVP = new SchemeValuePair(TEST_SCHEME, TEST_VALUE_1) {
        };
        final String svpAsString = testSVP.toString();
        assertNotNull("SchemeValuePair.toString() should not return null.", svpAsString);
        assertTrue("SchemeValuePair.toString() does not contain \"" + TEST_SCHEME + "\".", svpAsString.contains(TEST_SCHEME));
        assertTrue("SchemeValuePair.toString() does not contain \"" + TEST_VALUE_1 + "\".", svpAsString.contains(TEST_VALUE_1));
    }

    //
    // Tests of addIfAbsent method
    //
    @Test(expected = ToolkitInternalException.class)
    public void testReflectionExceptionIfNotSVP() throws Exception {
        SchemeValuePair.addIfAbsent("Not Truly An SVP Scheme", "Not Truly An SVP Value", NotTrulyAnSVP.class);
    }

    @Test
    public void testAddIfAbsentWithNonNullMatch() throws Exception {
        final SVPForAddIfAbsent firstInstance = (SVPForAddIfAbsent) SchemeValuePair.addIfAbsent(TEST_SCHEME, TEST_VALUE_1, SVPForAddIfAbsent.class);
        final SVPForAddIfAbsent secondInstance = (SVPForAddIfAbsent) SchemeValuePair.addIfAbsent(TEST_SCHEME, TEST_VALUE_1, SVPForAddIfAbsent.class);
        assertSame(firstInstance, secondInstance);
    }

    //
    // Tests of find methods.
    //
    @Test
    public void testFindForEverySVP() throws Exception {
        final String rawPackageName = this.getClass().getPackage().getName();
        final List<Class<SchemeValuePair>> classes = ReflectionHelper.findClassesInPackage(rawPackageName, ".*", null, SchemeValuePair.class);
        for (final Class clazz : classes) {
            if (SchemeValuePair.class.isAssignableFrom(clazz) && !clazz.isInterface() && !clazz.getName().matches(EXCLUDE_TEST_SVPS_PATTERN)) {
                if (clazz.getSuperclass().equals(SchemeValuePair.class)) { // If this is an 'element' class, it should have the find method but no instances.
                    final List<SchemeValuePair> expectedSVPList = ReflectionHelper.findAllSVPInstances(clazz);
                    assertTrue("Class " + clazz.getName() + " is an element class so should not have instances.", expectedSVPList.size() == 0);
                    final Method findMethod = clazz.getMethod("find", String.class, String.class);
                    assertNotNull("Class " + clazz.getName() + " does not have a find(String, String) method.", findMethod);
                } else { // If this is a "Scheme" class, i.e. a subclass of an element class, it should not have the find method and *may* have instances.
                    final List<SchemeValuePair> expectedSVPList = ReflectionHelper.findAllSVPInstances(clazz);
                    if (expectedSVPList.size() > 0) {
                        final SchemeValuePair expectedSVP = expectedSVPList.get(0);
                        final Class<? extends SchemeValuePair> superClass = clazz.getSuperclass();
                        try {
                            final Method m = superClass.getMethod("find", String.class, String.class);
                            final SchemeValuePair foundSVP = (SchemeValuePair) m.invoke(null, expectedSVP.getScheme(), expectedSVP.getValue());
                            assertSame("find method did not return expected instance.", expectedSVP, foundSVP);
                        } catch (NoSuchMethodException e) {
                            fail(
                                e.getClass().getSimpleName() + " for find method on " + clazz.getName() + " with scheme '" + expectedSVP.getScheme() + ", value '" + expectedSVP
                                    .getValue() + "'.");
                        }
                    } else {
                        // This is ok - a SchemeValuePair-derived class is not required to have static instances if, for example it's the class representing the element (e.g.
                        // ProblemType) and not a class representing a specific scheme (e.g. Version1GeneralProcessingError).
                        LOG.debug("Note: class '" + clazz.getSimpleName() + "' does not have a static instance.");
                    }
                }
            }
        }
    }

    @Test(expected = ConfigurationException.class)
    public void testNullValueWithUnsetBehavior() throws ConfigurationException, ToolkitInternalException {
        SchemeValuePair.mapBehavior(SVPWithUnsetBehavior.class.getName(), SchemeValueBehavior.UNSET);
        SVPWithUnsetBehavior.find(null, null);
    }

    @Test(expected = ConfigurationException.class)
    public void testEmptyValueWithUnsetBehavior() throws ConfigurationException, ToolkitInternalException {
        SchemeValuePair.mapBehavior(SVPWithUnsetBehavior.class.getName(), SchemeValueBehavior.UNSET);
        SVPWithUnsetBehavior.find(null, "");
    }

    @Test
    public void testNullValueWithAllowAnyBehavior() throws ConfigurationException, ToolkitInternalException {
        SchemeValuePair.mapBehavior(SVPAllowingAnySchemeAndAnyValue.class.getName(), SchemeValueBehavior.ALLOW_ANY);
        final SVPAllowingAnySchemeAndAnyValue foundSVP = SVPAllowingAnySchemeAndAnyValue.find(null, null);
        assertNull(foundSVP.getValue());
    }

    @Test
    public void testEmptyValueWithAllowAnyBehavior() throws ConfigurationException, ToolkitInternalException {
        SchemeValuePair.mapBehavior(SVPAllowingAnySchemeAndAnyValue.class.getName(), SchemeValueBehavior.ALLOW_ANY);
        final SVPAllowingAnySchemeAndAnyValue foundSVP = SVPAllowingAnySchemeAndAnyValue.find(null, "");
        assertEquals("", foundSVP.getValue());
    }

    @Test
    public void testFindForSchemeAllowingNull() throws ConfigurationException, ToolkitInternalException {
        SchemeValuePair.allowNullScheme(SVPAllowingNullScheme.class.getName());
        assertNotNull("For scheme that allows null, find(null, ...) doesn't work.",
            SVPAllowingNullScheme.find(null, SVPAllowingNullScheme.DEFINED_VALUE_WITH_NULL_SCHEME.getValue()));
    }

    @Test
    public void testFindFailsOnUndefinedScheme() throws Exception {
        SchemeValuePair.mapBehavior(SVPWithDefinedOnlyBehavior.class.getName(), SchemeValueBehavior.DEFINED_ONLY);
        try {
            SVPWithDefinedOnlyBehavior.find("undefined scheme", "eng");
        } catch (ConfigurationException e) {
            LOG.debug("ConfigurationException thrown:", e);
            assertThat(e.getLocalizedMessage(), matchesPattern("(?is).*no match found for scheme .*DEFINED_ONLY.*"));
        }
    }

    //
    // Tests of matches method
    //
    @Test
    public void testMatches() {
        SchemeValuePair.mapBehavior(TestSVPOne.class.getName(), SchemeValueBehavior.ALLOW_ANY);
        assertFalse("An instance of TestSVPOne should not match an instance of TestSVPTwo as they represent different elements.",
            TestSVPOne.DEFINED_VALUE_1.matches(TestSVPTwo.DEFINED_VALUE_1));
    }

    @Test
    public void testMatchesForSchemeAllowingNull() {
        final SVPAllowingNullScheme firstDefinedValueWithNonNullScheme = new SVPAllowingNullScheme(TEST_SCHEME, SVPAllowingNullScheme.DEFINED_VALUE_WITH_NULL_SCHEME.getValue());
        final SVPAllowingNullScheme secondDefinedValueWithNullScheme = new SVPAllowingNullScheme(null, SVPAllowingNullScheme.DEFINED_VALUE_WITH_NULL_SCHEME.getValue());

        SchemeValuePair.allowNullScheme(SVPAllowingNullScheme.class.getName());
        // Test matches with null scheme
        assertTrue("For SVP that allows null, matches on instances with non-null scheme doesn't work when other instance's scheme is null.",
            SVPAllowingNullScheme.DEFINED_VALUE_WITH_NULL_SCHEME.matches(firstDefinedValueWithNonNullScheme));
        assertTrue("For SVP that allows null, matches on instances with null scheme doesn't work when other instance's scheme is not null.",
            SVPAllowingNullScheme.DEFINED_VALUE_WITH_NULL_SCHEME.matches(firstDefinedValueWithNonNullScheme));
        assertTrue("For SVP that allows null, matches on instances with null scheme doesn't work when other instance's scheme is null.",
            secondDefinedValueWithNullScheme.matches(SVPAllowingNullScheme.DEFINED_VALUE_WITH_NULL_SCHEME));
    }

    //
    // Tests of equals methhod
    //
    @Test
    public void testEquals() throws InvocationTargetException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException {

        final SchemeValuePair actualValue = TestSVPOne.DEFINED_VALUE_1;
        assertEquals(TestSVPOne.DEFINED_VALUE_1, actualValue);
        assertNotSame(TestSVPOne.DEFINED_VALUE_2, actualValue);

        // Test constructors of a sub-class that is configured to allow any values
        // Note: The two TestSVPOne objects created via constructors will be equal but not the same;
        // note how this differs from the result when using the find method instead of the constructor.
        final TestSVPOne testSVPOneViaCtor = new TestSVPOne(null, TEST_VALUE_1);
        final TestSVPOne testSVPOtherOneViaCtor = new TestSVPOne(null, TEST_VALUE_1);
        assertEquals(testSVPOneViaCtor, testSVPOtherOneViaCtor);
        assertNotSame(testSVPOneViaCtor, testSVPOtherOneViaCtor);

        final TestSVPOne testSVPOneWithSchemeViaCtor = new TestSVPOne(TEST_SCHEME, TEST_VALUE_1);
        final TestSVPOne testSVPOtherOneWithSchemeViaCtor = new TestSVPOne(TEST_SCHEME, TEST_VALUE_1);
        assertEquals(testSVPOneWithSchemeViaCtor, testSVPOtherOneWithSchemeViaCtor);
        assertNotSame(testSVPOneWithSchemeViaCtor, testSVPOtherOneWithSchemeViaCtor);

        // Test that two TestSVPOne instances don't match if the second one's value is null
        final TestSVPOne testSVPWithSchemeAndValue = new TestSVPOne(TEST_SCHEME, "Test value");
        final TestSVPOne testSVPWithSchemeButNoValue = new TestSVPOne(TEST_SCHEME, null);
        assertFalse("TestSVPs shouldn't match if the first one has a value but the second one's is null," + " even if schemes are the same.",
            testSVPWithSchemeAndValue.equals(testSVPWithSchemeButNoValue));

        // Test that two TestSVPs don't match if the first one's value is null
        assertFalse("TestSVPs shouldn't match if the second one has a value but the first one's is null," + " even if schemes are the same.",
            testSVPWithSchemeButNoValue.equals(testSVPWithSchemeAndValue));

        // Test that two TestSVPs  match if both have the same scheme even if both have null values
        final TestSVPOne testSVPOtherOneWithSchemeButNoValue = new TestSVPOne(TEST_SCHEME, null);
        assertTrue("TestSVPs should match if both have the same scheme and both have null values.", testSVPWithSchemeButNoValue.equals(testSVPOtherOneWithSchemeButNoValue));

        // Test that an object that isn't an instance of SchemeValuePair is not equal to a SchemeValuePair
        assertFalse("TestSVPOne.DEFINED_VALUE_WITH_NULL_SCHEME should not be equal to a String.", TestSVPOne.DEFINED_VALUE_1.equals("asdf"));
        assertFalse("A String should not be equal to TestSVPOne.DEFINED_VALUE_WITH_NULL_SCHEME.", "asdf".equals(TestSVPOne.DEFINED_VALUE_1));

        // Test that we can construct a SchemeValuePair with only a value
        assertNotNull("It should be possible to construct an TestSVPOne with only a value parameter.", new TestSVPOne("value only"));

        // Test two objects that are instances of an immediate-subclass of SchemeValuePair and a subclass of that class.
        class TestTestSVPAlpha extends TestSVPOne {
            TestTestSVPAlpha(final String scheme, final String value) {
                super(scheme, value);
            }
        }

        final TestTestSVPAlpha testSVPAlpha = new TestTestSVPAlpha("x", "y");
        final TestSVPOne testSVPNonAlpha = new TestSVPOne("x", "y");

        assertThat("Two objects of the same immediate sub-classes of SchemeValuePair should be equal if" + " their Scheme and Value fields are identical.", testSVPAlpha,
            equalTo(testSVPNonAlpha));

        // Test two objects that are not instances of same immediate-subclass of SchemeValuePair.
        // This is meant to catch the admittedly obscure case where the same Scheme and Value are used to have two different meanings,
        // e.g. something like if the same list of codes were used for both UserLanguage and BibliographicDescription/Language.
        // To test this, we need to create a sub-class of SchemeValuePair that isn't a sub-class of TestSVPOne, with the same
        // Scheme URI and Value.
        class LocalTestSVPOne extends SchemeValuePair {
            LocalTestSVPOne(final String scheme, final String value) {
                super(scheme, value);
            }
        }
        final LocalTestSVPOne localTestSVPOneUSEnglish = new LocalTestSVPOne(TestSVPOne.DEFINED_VALUE_1.getScheme(), TestSVPOne.DEFINED_VALUE_1.getValue());

        assertFalse("Two objects of different immediate sub-classes of SchemeValuePair should not be equal even if" + " their Scheme and Value fields are identical.",
            localTestSVPOneUSEnglish.equals(TestSVPOne.DEFINED_VALUE_1));

    }

    //
    // Tests of hasHCode method
    //
    @Test
    public void testHashCode() {

        assertEquals(TestSVPOne.DEFINED_VALUE_1.hashCode(), TestSVPOne.DEFINED_VALUE_1.hashCode());
        assertNotSame(TestSVPOne.DEFINED_VALUE_1.hashCode(), TestSVPOne.DEFINED_VALUE_2.hashCode());

        // Test constructors of a sub-class that is configured to allow any values
        // Note: The two TestSVP objects created via constructors will be equal but not the same;
        // note how this differs from the result when using the find method instead of the constructor.
        final TestSVPOne testSVPOneViaCtor = new TestSVPOne(null, TEST_VALUE_1);
        final TestSVPOne testSVPOtherOneViaCtor = new TestSVPOne(null, TEST_VALUE_1);
        assertEquals(testSVPOneViaCtor.hashCode(), testSVPOtherOneViaCtor.hashCode());

        final TestSVPOne testSVPOneWithSchemeViaCtor = new TestSVPOne(TEST_SCHEME, TEST_VALUE_1);
        final TestSVPOne testSVPOtherOneWithSchemeViaCtor = new TestSVPOne(TEST_SCHEME, TEST_VALUE_1);
        assertEquals(testSVPOneWithSchemeViaCtor.hashCode(), testSVPOtherOneWithSchemeViaCtor.hashCode());

        // Test that two TestSVPs don't have same hashCode if the second one's value is null
        final TestSVPOne testSVPWithSchemeAndValue = new TestSVPOne(TEST_SCHEME, "Test value");
        final TestSVPOne testSVPWithSchemeButNoValue = new TestSVPOne(TEST_SCHEME, null);
        assertThat("TestSVPs shouldn't match if the first one has a value but the second one's is null, even if schemes are the same.", testSVPWithSchemeAndValue.hashCode(),
            not(equalTo(testSVPWithSchemeButNoValue.hashCode())));

        // Test that two TestSVPs don't have same hashCode if the first one's value is null
        assertThat("TestSVPs shouldn't match if the second one has a value but the first one's is null, even if schemes are the same.", testSVPWithSchemeButNoValue.hashCode(),
            not(equalTo(testSVPWithSchemeAndValue.hashCode())));

        // Test that two TestSVPs have same hashCode if both have the same scheme even if both have null values
        final TestSVPOne testSVPOtherOneWithSchemeButNoValue = new TestSVPOne(TEST_SCHEME, null);
        assertThat("TestSVPs should match if both have the same scheme and both have null values.", testSVPWithSchemeButNoValue.hashCode(),
            equalTo(testSVPOtherOneWithSchemeButNoValue.hashCode()));

    }

    @Test
    public void testEqualsAndHashCode() {


        final SVPForEqualsAndHashCode pair1 = new SVPForEqualsAndHashCode("scheme", "value");
        final SVPForEqualsAndHashCode pair2 = new SVPForEqualsAndHashCode("scheme", "VALUE");
        assertEquals(pair1, pair2);

        final Map<SVPForEqualsAndHashCode, String> hashMap = new HashMap<>();
        hashMap.put(pair1, "pair");

        // The methods below use hashcode and equals for equality
        assertTrue(hashMap.containsKey(pair1));
        assertTrue(hashMap.containsKey(pair2));
        assertEquals("pair", hashMap.get(pair1));
        assertEquals("pair", hashMap.get(pair2));

        final Map<SVPForEqualsAndHashCode, String> singletonMap = Collections.singletonMap(pair1, "pair");

        // The methods below just use equals for equality
        assertTrue(singletonMap.containsKey(pair1));
        assertTrue(singletonMap.containsKey(pair2));
        assertEquals("pair", singletonMap.get(pair1));
        assertEquals("pair", singletonMap.get(pair2));

    }

    //
    // Tests of canonicalizeSchemeURI method
    //
    @Test
    public void testCanonicalizationOfNullSchemeURI() {

        final String canonicalSchemeURI = SchemeValuePair.canonicalizeSchemeURI(null);
        assertNull(canonicalSchemeURI);

    }

    //
    // Tests of constructor methods
    //
    @Test
    public void testNoSchemeConstructors() throws ToolkitInternalException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final String testValue = "Don't care value";
        final String rawPackageName = this.getClass().getPackage().getName();
        final List<Class<SchemeValuePair>> classes = ReflectionHelper.findClassesInPackage(rawPackageName, ".*", null, SchemeValuePair.class);
        for (final Class clazz : classes) {
            if (SchemeValuePair.class.isAssignableFrom(clazz) && !clazz.isInterface() && !SchemeValuePair.class.getName().equals(clazz.getName())) {
                try {
                    LOG.debug("Testing " + clazz.getSimpleName());
                    final Constructor<? extends SchemeValuePair> ctor = ((Class<? extends SchemeValuePair>) clazz).getConstructor(String.class);
                    final SchemeValuePair svpResult = ctor.newInstance(testValue);
                    assertEquals(testValue, svpResult.getValue());
                } catch (NoSuchMethodException e) {
                    // Do nothing - SVP-derived classes aren't required to support this.
                    LOG.debug("SVP-derived class without Value-only constructor: " + clazz.getSimpleName());
                }
            }
        }
    }

    @Test
    public void testConstructorRegistersSVP() throws Exception {
        final TestSVPOne constructedInstance = new TestSVPOne("Test Scheme", "Test Value");
        SchemeValuePair.mapBehavior(TestSVPOne.class.getName(), SchemeValueBehavior.ALLOW_ANY);
        final TestSVPElement foundInstance = TestSVPOne.find("Test Scheme", "Test Value");
        assertSame("Constructed TestSVPOne instance was not returned by find.", constructedInstance, foundInstance);
    }

    // TODO Step 11: Reorder if they're worth keeping
    @Test
    public void testFind() {

        SchemeValuePair.mapBehavior(TestSVPElement.class.getName(), SchemeValueBehavior.ALLOW_ANY);
        SchemeValuePair.mapBehavior(TestSVPOne.class.getName(), SchemeValueBehavior.ALLOW_ANY);

        // Test find method of a sub-class that is configured to allow any values
        // Note: The two TestSVPOne objects created via the find method will be equal *and* the same;
        TestSVPElement testSVPOneViaFind = null;
        try {
            testSVPOneViaFind = TestSVPOne.find(null, TEST_VALUE_2);
        } catch (Exception e) {
            LOG.debug("Exception thrown:", e);
            fail("TestSVPOne.find() method threw exception for scheme 'null' and value '" + TEST_VALUE_2 + "' - was TestSVPOne set to allow any in configuration?");
        }
        TestSVPElement testSVPOtherOneViaFind = null;
        try {
            testSVPOtherOneViaFind = TestSVPOne.find(null, TEST_VALUE_2);
        } catch (Exception e) {
            LOG.debug("Exception thrown:", e);
            fail("TestSVPOne.find() method threw exception for scheme 'null' and value '" + TEST_VALUE_2 + "' - was TestSVPOne set to allow any in configuration?");
        }
        assertEquals(testSVPOneViaFind, testSVPOtherOneViaFind);
        assertSame(testSVPOneViaFind, testSVPOtherOneViaFind);

        TestSVPElement testSVPOneWithSchemeViaFind = null;
        try {
            testSVPOneWithSchemeViaFind = TestSVPOne.find(TEST_SCHEME, TEST_VALUE_1);
        } catch (Exception e) {
            LOG.debug("Exception thrown:", e);
            fail(
                "TestSVPOne.find() method threw exception for scheme '" + TEST_SCHEME + "' and value '" + TEST_VALUE_1 + "' - was TestSVPOne set to allow any in configuration?");
        }
        TestSVPElement testSVPOtherOneWithSchemeViaFind = null;
        try {
            testSVPOtherOneWithSchemeViaFind = TestSVPOne.find(TEST_SCHEME, TEST_VALUE_1);
        } catch (Exception e) {
            LOG.debug("Exception thrown:", e);
            fail(
                "TestSVPOne.find() method threw exception for scheme '" + TEST_SCHEME + "' and value '" + TEST_VALUE_1 + "' - was TestSVPOne set to allow any in configuration?");
        }
        assertEquals(testSVPOneWithSchemeViaFind, testSVPOtherOneWithSchemeViaFind);
        assertSame(testSVPOneWithSchemeViaFind, testSVPOtherOneWithSchemeViaFind);
    }

    @Test
    public void testFindSVPCreatedViaCtor() {

        SchemeValuePair.mapBehavior(TestSVPElement.class.getName(), SchemeValueBehavior.DEFINED_ONLY);
        SchemeValuePair.mapBehavior(TestSVPOne.class.getName(), SchemeValueBehavior.ALLOW_ANY);

        // Confirm that when you create a SchemeValuePair object via the ctor, it's found via find.
        final TestSVPElement testSVPThreeViaCtor = new TestSVPOne(null, TEST_VALUE_3);
        TestSVPElement testSVPThreeViaFind = null;
        try {
            testSVPThreeViaFind = TestSVPOne.find(null, TEST_VALUE_3);
        } catch (Exception e) {
            LOG.debug("Exception thrown:", e);
            fail("TestSVPOne.find() method threw exception for scheme 'null' and value '" + TEST_VALUE_3 + "' - was TestSVPOne set to allow any in configuration?");
        }
        assertEquals(testSVPThreeViaCtor, testSVPThreeViaFind);
        assertSame(testSVPThreeViaCtor, testSVPThreeViaFind);

        final String aliasScheme = "http://testalias.com/testonealias.scm";
        SchemeValuePair.setSchemeURIAlias(TestSVPOne.TEST_SVP_ONE, aliasScheme);
        TestSVPElement testSVPElementWithAlias = null;
        try {
            testSVPElementWithAlias = TestSVPElement.find(aliasScheme, TestSVPOne.DEFINED_VALUE_1.getValue());
        } catch (Exception e) {
            LOG.debug("Exception thrown:", e);
            fail("TestSVPOne.find() method threw exception for scheme '" + aliasScheme + "' and value '" + TestSVPOne.DEFINED_VALUE_1 + "' - is " + aliasScheme
                + " set as an alias for " + TestSVPOne.DEFINED_VALUE_1 + "?");
        }
        assertEquals(TestSVPOne.DEFINED_VALUE_1, testSVPElementWithAlias);
        assertSame(TestSVPOne.DEFINED_VALUE_1, testSVPElementWithAlias);

        final TestSVPElement testSVPElementCopy = new TestSVPElement(TestSVPOne.DEFINED_VALUE_1.getScheme(), TestSVPOne.DEFINED_VALUE_1.getValue());
        assertEquals(TestSVPOne.DEFINED_VALUE_1, testSVPElementCopy);
        final TestSVPElement foundSVPElement;
        try {
            foundSVPElement = TestSVPElement.find(TestSVPOne.DEFINED_VALUE_1.getScheme(), TestSVPOne.DEFINED_VALUE_1.getValue());
            assertEquals(TestSVPOne.DEFINED_VALUE_1, foundSVPElement);
        } catch (Exception e) {
            LOG.debug("Exception thrown:", e);
            fail("TestSVPOne.DEFINED_VALUE_WITH_NULL_SCHEME not found via call to TestSVPElement.find() method " + " - was TestSVPOne loaded?");
        }
        final String badScheme = "Fake scheme";
        final String badValue = "Fake value";
        // use TestSVPTwo to avoid "pollution" of the VALUES_LIST from other tests using TestSVPOne.
        final String goodScheme = TestSVPTwo.DEFINED_VALUE_1.getScheme();
        final String goodValue = TestSVPTwo.DEFINED_VALUE_1.getValue();
        try {
            final TestSVPElement unfoundSVPScheme = TestSVPElement.find(badScheme, goodValue);
            fail("TestSVPElement.find(\"" + badScheme + "\", \"" + goodValue + "\") succeeded when it should fail as there's no such Scheme URI.");
        } catch (ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            assertThat(e.getLocalizedMessage(), matchesPattern("(?is).*no match found for scheme .*"));
        } catch (Exception e) {
            LOG.error("Unexpected exception thrown.", e);
            fail("Unexpected exception thrown: " + e.getMessage());
        }
        try {
            final TestSVPElement unfoundSVPValue = TestSVPElement.find(goodScheme, badValue);
            fail("TestSVPElement.find(\"" + goodScheme + "\"), \"" + badValue + "\") "
                + " succeeded when it should fail as there's no such value in the TestSVPElement Scheme(s).");
        } catch (ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            assertThat(e.getLocalizedMessage(), matchesPattern("(?is).*no match found for scheme .*"));
        } catch (Exception e) {
            LOG.error("Unexpected exception thrown.", e);
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testLoadSchemeValueClasses() throws ClassNotFoundException, ToolkitInternalException, ConfigurationException {
        final String svpClass1 = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPForLoadSchemeValueClasses";
        final String scheme1 = "TEST_SVP_ONE";
        final String value1 = "Test Load SVP, Defined Value 1";
        SchemeValuePair.loadSchemeValueClasses(svpClass1);
        assertNotNull(SchemeValuePair.search(scheme1, value1, (Class<SchemeValuePair>) Class.forName(svpClass1)));
    }

    @Test
    public void testLoadSchemeValueClasses_forNonExistentClass() {
        final String svpClass1 = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPNonExistent";
        try {
            SchemeValuePair.loadSchemeValueClasses(svpClass1);
        } catch(ToolkitInternalException | ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            assertThat(e.getLocalizedMessage(), matchesPattern("(?i).*exception.*loading.*"));
        }
    }

    @Test
    public void testLoadSchemeValueClasses_forNonExistentLoadAllMethod() {
        final String svpClass1 = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPWithoutLoadAllMethod";
        try {
            SchemeValuePair.loadSchemeValueClasses(svpClass1);
        } catch(ToolkitInternalException | ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            assertThat(e.getLocalizedMessage(), matchesPattern("(?i).*exception.*loading.*"));
        }
    }

    @Test
    public  void testGetIterator() throws ClassNotFoundException {
        final String svpClass = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPForGetIterator";
        assertNotNull(SchemeValuePair.getIterator((Class<SchemeValuePair>) Class.forName(svpClass)));
        final Iterator<SchemeValuePair> iterator = SchemeValuePair.getIterator((Class<SchemeValuePair>) Class.forName(svpClass));
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testGetIterator_forNoRegisteredSVPInstances() throws ClassNotFoundException {
        final String svpClass = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPWithNoRegisteredInstances";
        final Iterator<SchemeValuePair> iterator = SchemeValuePair.getIterator((Class<SchemeValuePair>) Class.forName(svpClass));
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testSetSchemeURIAliases() throws ClassNotFoundException {
        final String alias1 = "Test Scheme 1 Alias 1";
        Map<String, String> aliasMap =  new HashMap<String, String>();
        aliasMap.put(SVPForSchemeURIAliases.SCHEME_1, alias1);
        SchemeValuePair.setSchemeURIAliases(aliasMap);
        assertNotNull(SchemeValuePair.search(alias1, SVPForSchemeURIAliases.VALUE_1, (Class<SchemeValuePair>) Class.forName(SVPForSchemeURIAliases.class.getName())));
    }

    @Test
    public void testSetSchemeURIAliasFromField() throws ClassNotFoundException, ToolkitInternalException, ConfigurationException {
        final String svpClass = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPForSchemeURIAliases";
        final String value1 = SVPForSchemeURIAliases.VALUE_1;
        final String classAndField1 = svpClass + "." + "SCHEME_1";
        final String alias1 = "Test Scheme 1 Alias 1";
        SchemeValuePair.setSchemeURIAliasFromField(classAndField1, alias1);
        assertNotNull(SchemeValuePair.search(alias1, value1, (Class<SchemeValuePair>) Class.forName(svpClass)));
    }

    @Test
    public void testSetSchemeURIAliasesFromFields() throws ClassNotFoundException, ToolkitInternalException, ConfigurationException {
        final String svpClass = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPForSchemeURIAliases";
        final String value1 = SVPForSchemeURIAliases.VALUE_1;
        final String classAndField1 = svpClass + "." + "SCHEME_1";
        final String alias1 = "Test Scheme 1 Alias 1";
        final Map<String, String> aliasMap = new HashMap<String, String>();
        aliasMap.put(classAndField1, alias1);
        SchemeValuePair.setSchemeURIAliasesFromFields(aliasMap);
        assertNotNull(SchemeValuePair.search(alias1, value1, (Class<SchemeValuePair>) Class.forName(svpClass)));
    }

    @Test
    public void testAllowAnyValue() throws ToolkitInternalException, ConfigurationException, ClassNotFoundException {
        final String svpClass = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPForTestAllowAnyValue";
        final String scheme = "Random Scheme";
        final String value = "Random Value";
        SchemeValuePair.allowAnyValue(svpClass);
        assertNotNull(SchemeValuePair.find(scheme, value, (Class<SchemeValuePair>) Class.forName(svpClass)));
    }

    @Test
    public void testAllowAnyValueInKnownSchemes() throws ToolkitInternalException, ConfigurationException, ClassNotFoundException {
        final String svpClass = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPForTestAllowAnyValueInKnownSchemes";
        final String scheme = SVPForTestAllowAnyValueInKnownSchemes.scheme1;
        final String value = "Some Random Value";
        SchemeValuePair.allowAnyValueInKnownSchemes(svpClass);
        assertNotNull(SchemeValuePair.find(scheme, value, (Class<SchemeValuePair>) Class.forName(svpClass)));
    }

    @Test
    public void testClearBehaviors() throws ToolkitInternalException, ConfigurationException, ClassNotFoundException {
        final String svpClass = "org.oclc.circill.toolkit.service.base.TestSchemeValuePair$SVPForTestClearBehaviors";
        final String scheme1 = "Random Scheme 1";
        final String value1 = "Random Value 1";
        final String scheme2 = "Random Scheme 2";
        final String value2 = "Random Value 2";
        SchemeValuePair.allowAnyValue(svpClass);
        assertNotNull(SchemeValuePair.find(scheme1, value1, (Class<SchemeValuePair>) Class.forName(svpClass)));
        SchemeValuePair.clearBehaviors();
        try {
            SchemeValuePair.find(scheme2, value2, (Class<SchemeValuePair>) Class.forName(svpClass));
        } catch(ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            assertThat(e.getLocalizedMessage(), matchesPattern(".*configuration.*unset.*"));
        }
    }

}
