/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TestSchemeValueBehavior {

    private static final Logger LOG = Logger.getLogger(TestSchemeValueBehavior.class);

    static class NullBehaviorSVP extends SchemeValuePair {
        NullBehaviorSVP(final String s, final String v) {
            super(s, v);
        }

        public static NullBehaviorSVP find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (NullBehaviorSVP) find(scheme, value, NullBehaviorSVP.class);
        }
    }

    @Test
    public void nullBehavior() {

        final String nullBehaviorScheme = "Scheme without any behavior mapping";
        final String nullBehaviorValue = "value";
        try {
            final NullBehaviorSVP o = NullBehaviorSVP.find(nullBehaviorScheme, nullBehaviorValue);
            Assert.fail("NullBehaviorSVP.find(\"" + nullBehaviorScheme + ", \"" + nullBehaviorValue + "\") succeeded when it should fail as there's no such Scheme URI.");
        } catch (ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            Assert.assertThat(e.getLocalizedMessage(), matchesPattern("(?is).*no match found for scheme .*UNSET.*"));
        } catch (Exception e) {
            LOG.error("Unexpected exception thrown.", e);
            Assert.fail("Unexpected exception thrown: " + e.getMessage());
        }

    }

    static class UnsetBehaviorSVP extends SchemeValuePair {
        UnsetBehaviorSVP(final String s, final String v) {
            super(s, v);
        }

        public static UnsetBehaviorSVP find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (UnsetBehaviorSVP) find(scheme, value, UnsetBehaviorSVP.class);
        }
    }

    @Test
    public void testUnset() {

        SchemeValuePair.mapBehavior(UnsetBehaviorSVP.class.getName(), SchemeValueBehavior.UNSET);
        final String badScheme = "Fake scheme";
        final String badValue = "Fake value";
        try {
            final UnsetBehaviorSVP testSVP = UnsetBehaviorSVP.find(badScheme, badValue);
            Assert.fail("UnsetBehaviorSVP.find(\"" + badScheme + ", \"" + badValue + "\") succeeded when it should fail as there's no such Scheme URI.");
        } catch (ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            Assert.assertThat(e.getLocalizedMessage(), matchesPattern("(?is).*no match found for scheme .*UNSET.*"));
        } catch (Exception e) {
            LOG.error("Unexpected exception thrown.", e);
            Assert.fail("Unexpected exception thrown: " + e.getMessage());
        }

    }

    static class DefinedOnlyBehaviorSVP extends SchemeValuePair {
        DefinedOnlyBehaviorSVP(final String s, final String v) {
            super(s, v);
        }

        public static DefinedOnlyBehaviorSVP find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (DefinedOnlyBehaviorSVP) find(scheme, value, DefinedOnlyBehaviorSVP.class);
        }
    }

    @Test
    public void testDefinedOnly() {

        SchemeValuePair.mapBehavior(DefinedOnlyBehaviorSVP.class.getName(), SchemeValueBehavior.DEFINED_ONLY);
        final String badScheme = "Fake scheme";
        final String badValue = "Fake value";
        try {
            final DefinedOnlyBehaviorSVP definedOnlyBehaviorSVP = DefinedOnlyBehaviorSVP.find(badScheme, badValue);
            Assert.fail("DefinedOnlyBehaviorSVP.find(\"" + badScheme + ", \"" + badValue + "\") succeeded when it should fail as there's no such Scheme URI.");
        } catch (ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            Assert.assertThat(e.getLocalizedMessage(), matchesPattern("(?is).*no match found for scheme .*DEFINED_ONLY.*"));
        } catch (Exception e) {
            LOG.error("Unexpected exception thrown.", e);
            Assert.fail("Unexpected exception thrown: " + e.getMessage());
        }

    }

    static class AllowAnyBehaviorSVP extends SchemeValuePair {
        @SuppressWarnings("checkstyle:RedundantModifier") // This must be public so that SchemeValuePair can use reflection to construct an instance.
        public AllowAnyBehaviorSVP(final String s, final String v) {
            super(s, v);
        }

        public static AllowAnyBehaviorSVP find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
            return (AllowAnyBehaviorSVP) find(scheme, value, AllowAnyBehaviorSVP.class);
        }
    }

    @Test
    public void testAllowAny() {

        SchemeValuePair.mapBehavior(AllowAnyBehaviorSVP.class.getName(), SchemeValueBehavior.ALLOW_ANY);
        final String badScheme = "Fake scheme";
        final String badValue = "Fake value";
        try {
            final AllowAnyBehaviorSVP noInstance = (AllowAnyBehaviorSVP) AllowAnyBehaviorSVP.search(badScheme, badValue, AllowAnyBehaviorSVP.class);
            Assert.assertNull(noInstance);

            final AllowAnyBehaviorSVP svpInstance = AllowAnyBehaviorSVP.find(badScheme, badValue);
            Assert.assertNotNull(svpInstance);
            Assert.assertEquals(svpInstance.getScheme(), badScheme);
            Assert.assertEquals(svpInstance.getValue(), badValue);

            final AllowAnyBehaviorSVP foundInstance = (AllowAnyBehaviorSVP) AllowAnyBehaviorSVP.search(badScheme, badValue, AllowAnyBehaviorSVP.class);
            Assert.assertNotNull(foundInstance);
            Assert.assertEquals(foundInstance.getScheme(), badScheme);
            Assert.assertEquals(foundInstance.getValue(), badValue);
        } catch (ConfigurationException e) {
            LOG.debug("Exception thrown:", e);
            Assert.fail("AllowAnyBehaviorSVP.find(\"" + badScheme + ", \"" + badValue + "\") failed when it should succeed as the behavior is set to 'allow any'.");
        } catch (Exception e) {
            LOG.error("Unexpected exception thrown.", e);
            Assert.fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}
