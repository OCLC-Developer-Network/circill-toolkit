/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.client;

import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApacheHttpClientNcipClientTest {

    private ApacheHttpClientClient apacheHttpClientNcipClient;
    @Mock
    private Executor executor;
    @Mock
    private Request request;
    @Mock
    private Content content;
    @Mock
    private Response response;
    @Mock
    private InputStream expectedInputStream;
    private static final String TARGET_ADDRESS = "http://mytarget/address";
    private static final int READ_TIMEOUT = 1000;
    private static final int CONNECT_TIMEOUT = 1000;
    private final byte[] messageBytes = new byte[1];
    private Map<String, String> expectedHeaders;

    @Before
    public void setUp() throws Exception {
        apacheHttpClientNcipClient = new ApacheHttpClientClient();
        apacheHttpClientNcipClient.setReadTimeoutInMillis(READ_TIMEOUT);
        apacheHttpClientNcipClient.setConnectTimeoutInMillis(CONNECT_TIMEOUT);
        apacheHttpClientNcipClient.setExecutor(executor);
        expectedHeaders = new HashMap<>();
        expectedHeaders.put("Yoyoma", "Rules");
        when(executor.execute(any(Request.class))).thenReturn(response);
        when(response.returnContent()).thenReturn(content);
        when(content.asStream()).thenReturn(expectedInputStream);
    }

    @Test
    public void testSendMessage() throws Exception {
        assertEquals(apacheHttpClientNcipClient.sendMessage(messageBytes, expectedHeaders, TARGET_ADDRESS), expectedInputStream);
    }

    @Test(expected = ToolkitException.class)
    public void testSendMessageIOException() throws Exception {
        when(executor.execute(any(Request.class))).thenThrow(new IOException("boom"));
        
        apacheHttpClientNcipClient.sendMessage(messageBytes, expectedHeaders, TARGET_ADDRESS);
    }

    @Test(expected = ToolkitException.class)
    public void testSendMessageClientProtocolException() throws Exception {
        when(executor.execute(any(Request.class))).thenThrow(new ClientProtocolException("boom"));
        
        apacheHttpClientNcipClient.sendMessage(messageBytes, expectedHeaders, TARGET_ADDRESS);
    }

    @Test
    public void testBuildHeaders() throws Exception {
        final Map<String, String> headers = new HashMap<>(2);
        headers.put("name1", "name1-header");
        headers.put("name2", "name2-header");

        final Header[] headerArray = apacheHttpClientNcipClient.getHeaderArray(headers);

        assertThat(headerArray.length, is(2));
    }

}
