/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.responder.implprof1;

import org.oclc.circill.toolkit.common.base.ChainingServiceContext;
import org.oclc.circill.toolkit.common.base.MessageHandler;
import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.StatisticsBean;
import org.oclc.circill.toolkit.common.base.Translator;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ProtocolHelper;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.ProblemResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RequestItemResponseData;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.jcabi.matchers.RegexMatchers.matchesPattern;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Test NCIP Responder service.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestServiceResponder {

    private final String SUCCESS_RESULT_STRING = "Arbitrary string for success";
    private final byte[] SUCCESS_RESULT_BYTES = SUCCESS_RESULT_STRING.getBytes();
    private final String VALIDATION_EXCEPTION_RESPONSE_STRING = "Arbitrary string for validation exception";
    private final String TEST_RESPONSE_MESSAGE = "Test response message";

    // The following patterns are tightly-coupled to how NCIPResponder builds its responses.
    private final String NO_EXCEPTION_MESSAGES_IN_PROBLEM_PATTERN = "(?s)(?i).*ProblemDetail>[^<]*Exception occurred during processing</.*";
    private final String VALIDATION_MESSAGE = "This is a mock validation error";
    private final String SERVICE_FAILURE_WITH_SERVICE_EXCEPTION_PATTERN = "(?s)(?i).*ProblemDetail>[^<]*Exception creating the NCIPInitiationData object from the servlet.*</.*";

    private final RequestItemInitiationData REQUEST_ITEM = new RequestItemInitiationData();
    private final RequestItemResponseData REQUEST_ITEM_RESPONSE = new RequestItemResponseData();
    private static final String DUMMY_SERVICE_EXCEPTION_MESSAGE = "Dummy service exception.";
    private static final ServiceException DUMMY_SERVICE_EXCEPTION = new ServiceException(DUMMY_SERVICE_EXCEPTION_MESSAGE);
    private static final ValidationException DUMMY_VALIDATION_EXCEPTION = new ValidationException(DUMMY_SERVICE_EXCEPTION_MESSAGE);

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private Translator<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> translator;

    @Mock
    private MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> messageHandler;

    @Mock
    private StatisticsBean statisticsBean;

    @Mock
    private ServiceContextFactory serviceContextFactory;

    @Mock
    private ServletInputStream inputStream;

    @Mock
    private ProtocolHelper protocolHelper;

    @Mock
    private ChainingServiceContext serviceContext;

    private ServiceResponder<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> responder;

    @Before
    public void setup() throws ToolkitException {
        responder = new ServiceResponder<>();
        responder.setMessageHandler(messageHandler);
        responder.setServiceContextFactory(serviceContextFactory);
        responder.setStatisticsBean(statisticsBean);
        responder.setTranslator(translator);
        responder.setProtocolHelper(protocolHelper);
    }

    @Test
    public void testPerformNCIPServiceWithNullInputStream() throws IOException, ServletException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(null);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(any(ServiceContext.class), isNull())).thenThrow(ServiceException.class);
        when(protocolHelper.returnException(any(String.class), any(ServiceException.class), any(ServiceContext.class), any(Boolean.class), any(Boolean.class)))
            .thenReturn(TEST_RESPONSE_MESSAGE);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }

    @Test
    public void testPerformNCIPServiceWithNoRequestType() throws IOException, ServletException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(serviceContext, inputStream)).thenReturn(REQUEST_ITEM);
        when(messageHandler.performService(REQUEST_ITEM, serviceContext)).thenReturn(REQUEST_ITEM_RESPONSE);
        final ByteArrayInputStream responseInputStream = new ByteArrayInputStream(SUCCESS_RESULT_BYTES);
        when(translator.createResponseMessageStream(serviceContext, REQUEST_ITEM_RESPONSE)).thenReturn(responseInputStream);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain request id.", result, matchesPattern(SUCCESS_RESULT_STRING));

    }

    @Test
    public void testPerformNCIPServiceWithServiceContextException() throws IOException, ServletException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenThrow(ConfigurationException.class);
        when(protocolHelper.returnException(any(String.class), any(ConfigurationException.class), isNull(), any(Boolean.class), any(Boolean.class)))
            .thenReturn(TEST_RESPONSE_MESSAGE);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }

    @Test
    public void testPerformNCIPServiceWithServletInputStreamException() throws IOException, ServletException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenThrow(IOException.class);
        when(protocolHelper.returnException(any(String.class), any(IOException.class), isNull(), any(Boolean.class), any(Boolean.class))).thenReturn(TEST_RESPONSE_MESSAGE);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }

    @Test
    public void testPerformNCIPServiceWithNCIPInitiationDataTranslationException() throws IOException, ServletException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(serviceContext, inputStream)).thenThrow(ValidationException.class);
        when(protocolHelper.returnException(any(String.class), any(ValidationException.class), any(ServiceContext.class), any(Boolean.class), any(Boolean.class)))
            .thenReturn(TEST_RESPONSE_MESSAGE);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }

    @Test
    public void testPerformNCIPServiceWithNCIPInitiationDataTranslationExceptionWithoutExceptionMessageIncluded()
        throws IOException, ServletException, ServiceException, ValidationException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(serviceContext, inputStream)).thenThrow(ServiceException.class);
        when(protocolHelper.returnException(any(String.class), any(ServiceException.class), any(ServiceContext.class), any(Boolean.class), any(Boolean.class)))
            .thenReturn(TEST_RESPONSE_MESSAGE);
        responder.setIncludeExceptionMessagesInProblemResponse(false);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }

    @Test
    public void testPerformNCIPServiceWithNCIPInitiationDataTranslationExceptionWithStackTracesIncluded()
        throws IOException, ServletException, ServiceException, ValidationException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(serviceContext, inputStream)).thenThrow(DUMMY_SERVICE_EXCEPTION);
        when(protocolHelper.returnException(any(String.class), any(ServiceException.class), any(ServiceContext.class), any(Boolean.class), any(Boolean.class)))
            .thenReturn(TEST_RESPONSE_MESSAGE);
        responder.setIncludeStackTracesInProblemResponse(true);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }

    @Test
    public void testPerformNCIPServiceWithValidationException() throws IOException, ServletException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(serviceContext, inputStream)).thenThrow(DUMMY_VALIDATION_EXCEPTION);
        when(protocolHelper.returnException(any(String.class), eq(DUMMY_VALIDATION_EXCEPTION), any(ServiceContext.class), any(Boolean.class), any(Boolean.class)))
            .thenReturn(TEST_RESPONSE_MESSAGE);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }

    @Test
    public void testPerformNCIPServiceWithServiceThrowsServiceException() throws IOException, ServletException, ServiceException, ValidationException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(serviceContext, inputStream)).thenReturn(REQUEST_ITEM);
        when(messageHandler.performService(REQUEST_ITEM, serviceContext)).thenThrow(ServiceException.class);
        when(protocolHelper.returnException(any(String.class), any(ServiceException.class), any(ServiceContext.class), any(Boolean.class), any(Boolean.class)))
            .thenReturn(TEST_RESPONSE_MESSAGE);
        responder.setIncludeExceptionMessagesInProblemResponse(true);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }

    @Test
    public void testPerformNCIPServiceWithServiceThrowsValidationException() throws IOException, ServletException, ServiceException, ValidationException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(serviceContext, inputStream)).thenReturn(REQUEST_ITEM);
        final ProblemResponseData problemResponseData = new ProblemResponseData();
        when(messageHandler.performService(REQUEST_ITEM, serviceContext)).thenReturn(problemResponseData);
        final ByteArrayInputStream responseInputStream = new ByteArrayInputStream(VALIDATION_EXCEPTION_RESPONSE_STRING.getBytes());
        when(translator.createResponseMessageStream(serviceContext, problemResponseData)).thenReturn(responseInputStream);
        responder.setIncludeExceptionMessagesInProblemResponse(true);

        final String result = responder.performService(httpServletRequest);

        assertEquals("Result string is not what is expected", result, VALIDATION_EXCEPTION_RESPONSE_STRING);

    }

    @Test
    public void testPerformNCIPServiceWithServiceThrowsException() throws IOException, ServletException, ToolkitException {

        when(httpServletRequest.getInputStream()).thenReturn(inputStream);
        when(serviceContextFactory.getInitialServiceContext()).thenReturn(serviceContext);
        when(translator.createInitiationData(serviceContext, inputStream)).thenReturn(REQUEST_ITEM);
        when(messageHandler.performService(REQUEST_ITEM, serviceContext)).thenThrow(ServiceException.class);
        when(protocolHelper.returnException(any(String.class), any(ServiceException.class), any(ServiceContext.class), any(Boolean.class), any(Boolean.class)))
            .thenReturn(TEST_RESPONSE_MESSAGE);

        final String result = responder.performService(httpServletRequest);

        assertThat("Result does not contain text from call to ProtocolHelper.returnException.", result, is(TEST_RESPONSE_MESSAGE));

    }
}
