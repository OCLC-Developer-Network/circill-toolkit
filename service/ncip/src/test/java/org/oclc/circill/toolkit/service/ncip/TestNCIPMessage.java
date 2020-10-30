/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

/**
 */
public class TestNCIPMessage {

    static {
        final NCIPMessage x = new NCIPMessage();
    }

    public static class BadNCIPMessage extends NCIPMessage {
        public LookupUserInitiationData lookupUser;
        public LookupUserResponseData lookupUserResponse;

        @Override
        public void setLookupUser(final LookupUserInitiationData lookupUserInitiationData) {
            this.lookupUser = lookupUserInitiationData;
            // Intentionally not setting the message type
        }

        @Override
        public LookupUserInitiationData getLookupUser() {
            return lookupUser;
        }

        @Override
        public void setLookupUserResponse(final LookupUserResponseData lookupUserResponseData) {
            this.lookupUserResponse = lookupUserResponseData;
            // Intentionally not setting the message type
        }

        @Override
        public LookupUserResponseData getLookupUserResponse() {
            return lookupUserResponse;
        }
    }

    /**
     * Loading of classes derived from http://www.javaworld.com/article/2077477/learn-java/java-tip-113--identify-subclasses-at-runtime.html.
     */
    @Test
    public void testIsInitiationMessage() throws ReflectiveOperationException, ToolkitException, ServiceException, IOException {

        final String rawPackageName = NCIPMessage.class.getPackage().getName();
        final List<Class<ServiceInitiationData>> classes = ReflectionHelper.findClassesInPackage(rawPackageName, "^.*InitiationData$", null, ServiceInitiationData.class);
        for (final Class clazz : classes) {

            if (NCIPInitiationData.class.isAssignableFrom(clazz) && !clazz.isInterface()) {
                final NCIPInitiationData initiationData = (NCIPInitiationData) clazz.newInstance();
                final String msgName = initiationData.getMessageName();
                final NCIPMessage ncipMsg = new NCIPMessage();
                ReflectionHelper.setField(ncipMsg, initiationData, msgName);
                Assert.assertTrue("This is not a initiation message: " + ncipMsg.getInitiationData().getMessageName(), ncipMsg.isInitiationMessage());
                Assert.assertSame("Initiation object isn't the same for " + ncipMsg.getInitiationData().getMessageName(), initiationData, ncipMsg.getInitiationData());
            }
        }

    }

    @Test
    public void testIsResponseMessage() throws ReflectiveOperationException, ToolkitException, ServiceException, IOException {

        final String rawPackageName = NCIPMessage.class.getPackage().getName();
        final List<Class<ServiceResponseData>> classes = ReflectionHelper.findClassesInPackage(rawPackageName, "^.*ResponseData$", null, ServiceResponseData.class);
        for (final Class<ServiceResponseData> clazz : classes) {

            if (NCIPResponseData.class.isAssignableFrom(clazz) && !clazz.isInterface()) {
                final NCIPResponseData responseData = (NCIPResponseData) clazz.newInstance();
                final String msgName = responseData.getMessageName();
                final NCIPMessage ncipMsg = new NCIPMessage();
                ReflectionHelper.setField(ncipMsg, responseData, msgName);
                Assert.assertTrue("This is not a response message: " + ncipMsg.getResponseData().getMessageName(), ncipMsg.isResponseMessage());
                Assert.assertSame("Response object isn't the same for " + ncipMsg.getResponseData().getMessageName(), responseData, ncipMsg.getResponseData());
            }
        }

    }

    @Test
    public void testInvalidHandlingOfInitData() throws InvocationTargetException, ToolkitException, IllegalAccessException, ServiceException {
        final NCIPInitiationData initiationData = new LookupUserInitiationData();
        final String msgName = initiationData.getMessageName();
        final BadNCIPMessage ncipMsg = new BadNCIPMessage();
        ReflectionHelper.setField(ncipMsg, initiationData, msgName);
        Assert.assertFalse("The isInitiationMessage method should not return 'true' for this: " + ncipMsg.getInitiationData().getMessageName(), ncipMsg.isInitiationMessage());

    }

    @Test
    public void testInvalidHandlingOfRespData() throws InvocationTargetException, ToolkitException, IllegalAccessException, ServiceException {
        final NCIPResponseData responseData = new LookupUserResponseData();
        final String msgName = responseData.getMessageName();
        final NCIPMessage ncipMsg = new BadNCIPMessage();
        ReflectionHelper.setField(ncipMsg, responseData, msgName);
        Assert.assertFalse("The isResponseMessage method should not return 'true' for this: " + ncipMsg.getResponseData().getMessageName(), ncipMsg.isResponseMessage());
    }

    @Test
    public void testNullInitData() throws InvocationTargetException, ToolkitException, IllegalAccessException, ServiceException {
        final NCIPMessage ncipMsg = new NCIPMessage();
        assertNull(ncipMsg.getInitiationData());
    }

    @Test
    public void testNullRespData() throws InvocationTargetException, ToolkitException, IllegalAccessException, ServiceException {
        final NCIPMessage ncipMsg = new NCIPMessage();
        assertNull(ncipMsg.getResponseData());
    }

    @Test(expected = ToolkitException.class)
    public void testNonInitDataAttribute() throws InvocationTargetException, ToolkitException, IllegalAccessException, ServiceException {
        final BadNCIPMessage ncipMsg = new BadNCIPMessage();
        ncipMsg.setLookupUserResponse(new LookupUserResponseData());
        ncipMsg.getInitiationData();
    }

    @Test(expected = ToolkitException.class)
    public void testNonRespDataAttribute() throws InvocationTargetException, ToolkitException, IllegalAccessException, ServiceException {
        final BadNCIPMessage ncipMsg = new BadNCIPMessage();
        ncipMsg.setLookupUser(new LookupUserInitiationData());
        ncipMsg.getResponseData();
    }

}

