/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ProtocolHelper;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 */
public class TestMappedMessageHandler {

    private static final Logger LOG = Logger.getLogger(TestMappedMessageHandler.class);
    private static final String SERVICE_NAME_1 = "ServiceName1";
    private static final String SERVICE_NAME_2 = "ServiceName2";

    private final ProtocolHelper mockProtocolHelper = mock(ProtocolHelper.class);
    private final Service<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> mockServiceOne = mock(Service.class);
    private final Service<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> mockServiceTwo = mock(Service.class);
    private final FakeInitiationData mockInitiationData = mock(FakeInitiationData.class);
    private final FakeResponseData mockResponseData = mock(FakeResponseData.class);
    private final FakeResponseData mockUnsupportedServiceResponseData = mock(FakeResponseData.class);
    private final ServiceContext mockServiceContext = mock(ServiceContext.class);
    private final RemoteServiceManager mockServiceManager = mock(RemoteServiceManager.class);

    @Before
    public void beforeTest() throws ToolkitException {
        when(mockServiceOne.getServiceName()).thenReturn(SERVICE_NAME_1);
        when(mockServiceTwo.getServiceName()).thenReturn(SERVICE_NAME_2);
        when(mockServiceOne.performService(mockInitiationData, mockServiceContext, mockServiceManager)).thenReturn(mockResponseData);
        when(mockProtocolHelper.createProblemResponse(MappedMessageHandler.UNSUPPORTED_SERVICE_MESSAGE, mockInitiationData)).thenReturn(mockUnsupportedServiceResponseData);
    }

    @Test
    public void testEmptySupportedServicesNames() throws ToolkitException {
        final MappedMessageHandler messageHandler = createMappedMessageHandler(Collections.emptyMap());
        final List<String> names = messageHandler.getSupportedServicesNames();

        Assert.assertEquals(0, messageHandler.getSupportedServices().size());
        Assert.assertEquals(0, names.size());
    }

    @Test
    public void testOneSupportedServicesName() throws ToolkitException {
        final MappedMessageHandler messageHandler = createMappedMessageHandler(Collections.singletonMap((new FakeInitiationData() {
        }).getClass(), mockServiceOne));

        final List<String> names = messageHandler.getSupportedServicesNames();

        Assert.assertEquals(1, messageHandler.getSupportedServices().size());
        Assert.assertEquals(1, names.size());
        Assert.assertEquals(SERVICE_NAME_1, names.get(0));
    }

    @Test
    public void testTwoSupportedServicesName() throws ToolkitException {
        final Map<String, Service> services = new HashMap<>();
        services.put((new FakeInitiationData() {
        }).getClass().getName(), mockServiceOne);
        services.put((new FakeInitiationData() {
        }).getClass().getName(), mockServiceTwo);
        final MappedMessageHandler messageHandler = createMappedMessageHandler(services);

        final List<String> names = messageHandler.getSupportedServicesNames();

        Assert.assertEquals(2, messageHandler.getSupportedServices().size());
        Assert.assertEquals(2, names.size());
        Assert.assertTrue(names.contains(SERVICE_NAME_1));
        Assert.assertTrue(names.contains(SERVICE_NAME_2));

    }

    @Test
    public void testPerformService() throws ToolkitException {
        final MappedMessageHandler messageHandler = createMappedMessageHandler(Collections.singletonMap(mockInitiationData.getClass().getName(), mockServiceOne));

        final ServiceResponseData response = messageHandler.performService(mockInitiationData, mockServiceContext);

        Assert.assertSame(mockResponseData, response);
    }

    @Test
    public void testUnsupportedService() throws ToolkitException {
        final MappedMessageHandler messageHandler = createMappedMessageHandler(Collections.emptyMap());

        final ServiceResponseData response = messageHandler.performService(mockInitiationData, mockServiceContext);

        Assert.assertSame(mockUnsupportedServiceResponseData, response);
    }

    private MappedMessageHandler createMappedMessageHandler(final Map supportedServices) throws ToolkitException {
        final MappedMessageHandler mappedMessageHandler = new MappedMessageHandler(supportedServices, mockServiceManager, mockProtocolHelper);
        return mappedMessageHandler;
    }
}
