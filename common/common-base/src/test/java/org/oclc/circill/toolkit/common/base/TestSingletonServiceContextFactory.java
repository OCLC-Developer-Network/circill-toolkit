/*
 * Copyright (c) 2017 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ValidationException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test the {@link SingletonServiceContextFactory}.
 */
public class TestSingletonServiceContextFactory {

    private static final ServiceContext<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> testServiceContext
        = new ServiceContext<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData>() {
        @Override
        public void validateBeforeMarshalling(final FakeMessage<FakeInitiationData, FakeResponseData> message) throws ValidationException {
            // Do nothing
        }
        @Override
        public void validateAfterUnmarshalling(final FakeMessage<FakeInitiationData, FakeResponseData> message) throws ValidationException {
            // Do nothing
        }
    };

    @Test
    public void test_happyPath() throws Exception {
        final SingletonServiceContextFactory<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> testSubject
            = new SingletonServiceContextFactory<>();
        testSubject.setServiceContext(testServiceContext);

        final ServiceContext<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> sc = testSubject.getInitialServiceContext();

        assertNotNull(sc);
        assertSame(testServiceContext, sc);
    }

    @Test
    public void test_serviceContextNotInitialized() throws Exception {
        final SingletonServiceContextFactory<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> testSubject
            = new SingletonServiceContextFactory<>();

        try {
            testSubject.getInitialServiceContext();
            fail("Exception not thrown when ServiceContext is uninitialized.");
        } catch (ToolkitException e) {
            // Good
        }
    }

    @Test
    public void test_classCannotBeNull() throws Exception {
        final SingletonServiceContextFactory<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> testSubject
            = new SingletonServiceContextFactory<>();

        try {
            testSubject.setServiceContext(null);
            fail("Exception not thrown when ServiceContext is set to null.");
        } catch (ToolkitException e) {
            // Good
        }
    }

    @Test
    public void test_sameInstanceReturned() throws ToolkitException {
        final SingletonServiceContextFactory<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> testSubject
            = new SingletonServiceContextFactory<>();
        testSubject.setServiceContext(testServiceContext);

        final ServiceContext<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> sc1 = testSubject.getInitialServiceContext();
        final ServiceContext<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> sc2 = testSubject.getInitialServiceContext();

        assertNotNull(sc1);
        assertNotNull(sc2);
        assertSame(sc1, sc2);
    }

}
