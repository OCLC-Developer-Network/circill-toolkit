/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;

import java.lang.reflect.Field;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;

import org.apache.commons.collections4.map.ListOrderedMap;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestConfigurableService {

    ConfigurableService service = new ConfigurableService();

    @Before
    public void setHandlersList() throws NoSuchFieldException, IllegalAccessException {
        final Field handlersField = service.getClass().getDeclaredField("HANDLERS");
        handlersField.setAccessible(true);
        final ListOrderedMap<Class<? extends ConfigurableServiceHandler>, ConfigurableServiceHandler> handlers = (ListOrderedMap<Class<? extends ConfigurableServiceHandler>,
            ConfigurableServiceHandler>) handlersField.get(service);
        handlers.clear();
        handlers.put(0, TestHandler1.class, new TestHandler1());
        handlers.put(1, TestHandler2.class, new TestHandler2());
    }

    @Test
    public void testGetHandlerNames() {
        assertEquals(service.getHandlerNames(), asList("TestHandler1", "TestHandler2"));
    }

    @Test
    public void testGetHandler() throws ServiceException {
        service.getHandler("TestHandler1");
        service.getHandler("TestHandler2");
    }

    @Test
    public void testRemoveHandler() {
        assertEquals(service.getHandlerNames(), asList("TestHandler1", "TestHandler2"));
        service.removeHandler("TestHandler1");
        assertEquals(service.getHandlerNames(), asList("TestHandler2"));
    }

    @Test
    public void testReorderHandlers() {
        assertEquals(service.getHandlerNames(), asList("TestHandler1", "TestHandler2"));
        final List<String> orderdHandlersNames = new ArrayList<>();
        orderdHandlersNames.add(0,"TestHandler2");
        orderdHandlersNames.add(1,"TestHandler1");
        service.reorderHandlers(orderdHandlersNames);
        assertEquals(service.getHandlerNames(), asList("TestHandler2", "TestHandler1"));
    }

    static class TestHandler1 implements ConfigurableServiceHandler {
        @Override
        public boolean canHandle(final ServiceInitiationData initiationData) {
            return false;
        }
        @Override
        public ServiceResponseData handle(final ServiceInitiationData initiationData) {
            return null;
        }
    }

    static class TestHandler2 implements ConfigurableServiceHandler {
        @Override
        public boolean canHandle(final ServiceInitiationData initiationData) {
            return false;
        }
        @Override
        public ServiceResponseData handle(final ServiceInitiationData initiationData) {
            return null;
        }
    }

}
