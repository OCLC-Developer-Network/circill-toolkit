/*
 * Copyright (c) 2017 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.responder.implprof1;

import org.oclc.circill.toolkit.common.base.ChainingServiceContext;
import org.oclc.circill.toolkit.common.base.MessageHandler;
import org.oclc.circill.toolkit.common.base.MessageHandlerAware;
import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.ServletRequestAware;
import org.oclc.circill.toolkit.common.base.StatisticsBean;
import org.oclc.circill.toolkit.common.base.Translator;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ProtocolHelper;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Implements a responder for HTTP and HTTPS transport. For use as a Spring bean with a dispatcher.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public class ServiceResponder<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> {

    private static final Logger LOG = Logger.getLogger(ServiceResponder.class);

    /** The {@link ProtocolHelper}. */
    protected ProtocolHelper<SM, ID, RD> protocolHelper;

    /**
     * Whether to include stack traces in problem responses.
     */
    protected boolean includeStackTracesInProblemResponse = false;

    /**
     * Whether to include exception messages in problem responses.
     */
    protected boolean includeExceptionMessagesInProblemResponse = false;

    /**
     * The {@link Translator} instance used to translate network octets to instances of {@link ServiceInitiationData}
     * or {@link ServiceResponseData} for passing to the {@link ServiceResponder}.
     */
    protected Translator<SM, ID, RD> translator;

    /**
     * The {@link ServiceContextFactory} instance used to create {@link ServiceContext}s.
     * This <strong>must</strong> return instances of {@link ChainingServiceContext} from the {@link ServiceContextFactory#getInitialServiceContext()} method.
     */
    protected ServiceContextFactory<SM, ID, RD> serviceContextFactory;

    /**
     * These ServiceContext factories are part of the responder's configuration, and are added to those that are part of the Toolkit's configuration.
     * <p>
     * Note: The setter copies the input to an unmodifiable list, and the getter returns the unmodifiable copy.
     * </p>
     */
    protected List<ServiceContextFactory<SM, ID, RD>> addedServiceContextFactories = Collections.emptyList();

    /**
     * The {@link MessageHandler} instance used to handle {@link ServiceInitiationData} objects representing incoming messages.
     */
    protected MessageHandler<SM, ID, RD> messageHandler;

    /**
     * The {@link StatisticsBean} instance used to report performance data.
     */
    protected StatisticsBean statisticsBean;

    /**
     * Construct a new instance of this bean with no dependencies set; these must be injected before any messages are received.
     */
    public ServiceResponder() {
        // Do nothing - expect dependencies to be set before use
    }

    /**
     * Set the {@link MessageHandler} for this responder instance
     *
     * @param messageHandler the message handler
     */
    public void setMessageHandler(final MessageHandler<SM, ID, RD> messageHandler) {
        this.messageHandler = messageHandler;
    }

    /**
     * Set the {@link Translator} for this responder instance
     *
     * @param translator the translator
     */
    public void setTranslator(final Translator<SM, ID, RD> translator) {
        this.translator = translator;
    }

    public void setServiceContextFactory(final ServiceContextFactory<SM, ID, RD> serviceContextFactory) {
        this.serviceContextFactory = serviceContextFactory;
    }

    /**
     * Set the {@link StatisticsBean} for this responder instance
     *
     * @param statisticsBean the statistics bean
     */
    public void setStatisticsBean(final StatisticsBean statisticsBean) {
        this.statisticsBean = statisticsBean;
    }

    /**
     * Set the includeStackTracesInProblemResponse flag.
     *
     * @param includeStackTracesInProblemResponse the value of this flag
     */
    public void setIncludeStackTracesInProblemResponse(final boolean includeStackTracesInProblemResponse) {
        this.includeStackTracesInProblemResponse = includeStackTracesInProblemResponse;
    }

    /**
     * Set the includeExceptionMessagesInProblemResponse flag.
     *
     * @param includeExceptionMessagesInProblemResponse the value of this flag
     */
    public void setIncludeExceptionMessagesInProblemResponse(final boolean includeExceptionMessagesInProblemResponse) {
        this.includeExceptionMessagesInProblemResponse = includeExceptionMessagesInProblemResponse;
    }

    public void setAddedServiceContextFactories(final List<ServiceContextFactory<SM, ID, RD>> addedServiceContextFactories) {
        this.addedServiceContextFactories = Collections.unmodifiableList(new ArrayList<>(addedServiceContextFactories));
    }

    public List<ServiceContextFactory<SM, ID, RD>> getAddedServiceContextFactories() {
        return addedServiceContextFactories;
    }

    /**
     * Append the provided service context to the existing list of service context.
     * @param serviceContext the {@link ServiceContext}
     * @throws ConfigurationException if the Toolkit is not configured for this
     */
    protected void appendServiceContexts(final ChainingServiceContext<SM, ID, RD> serviceContext) throws ConfigurationException {
        for (final ServiceContextFactory<SM, ID, RD> sv : addedServiceContextFactories) {
            serviceContext.appendServiceContext(sv.getInitialServiceContext());
        }
    }

    /**
     * Perform the service represented by the message in the {@link HttpServletRequest}.
     * @param httpRequest the request
     * @return the response
     * @throws ServletException if an exception occurs
     */
    @PostMapping(produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public String performService(final HttpServletRequest httpRequest) throws ServletException {
        final long respTotalStartTime = System.currentTimeMillis();
        String serviceName = "Unknown";
        String responseString;
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Note: Statements that might throw exceptions are wrapped in individual try/catch blocks, allowing us to provide very specific error messages.
        try {
            final ServletInputStream inputStream = httpRequest.getInputStream();
            final ServiceContext<SM, ID, RD> serviceContext = prepareServiceContext(httpRequest);
            try {
                final ID initiationData = translator.createInitiationData(serviceContext, inputStream);
                serviceName = initiationData.getServiceName();
                final long initPerfSvcStartTime = System.currentTimeMillis();
                final RD responseData = messageHandler.performService(initiationData, serviceContext);
                final long initPerfSvcEndTime = System.currentTimeMillis();
                statisticsBean.record(StatisticsBean.Step.PERFORM_SERVICE, initPerfSvcStartTime, initPerfSvcEndTime, serviceName);
                responseString = convertResponseData(serviceContext, responseData, outputStream);
            } catch (ToolkitException e) {
                responseString = protocolHelper
                    .returnException("Exception creating the ServiceInitiationData object from the servlet's input stream.", e, serviceContext, includeStackTracesInProblemResponse,
                        includeExceptionMessagesInProblemResponse);
            }
        } catch (ToolkitException e) {
            responseString = protocolHelper
                .returnException("Exception creating initial service context.", e, null, includeStackTracesInProblemResponse, includeExceptionMessagesInProblemResponse);
        } catch (IOException e) {
            responseString = protocolHelper.returnException("Exception getting ServletInputStream from the HttpServletRequest.", e, null, includeStackTracesInProblemResponse,
                includeExceptionMessagesInProblemResponse);
        }
        final long respTotalEndTime = System.currentTimeMillis();
        statisticsBean.record(StatisticsBean.Step.TOTAL, respTotalStartTime, respTotalEndTime, serviceName);
        LOG.trace("Leaving ServiceResponder.performService after " + (respTotalEndTime - respTotalStartTime) + " milliseconds.");
        return responseString;
    }

    /**
     * Prepare the {@link ServiceContext} for this request; assembling all service contexts and injecting the {@link #messageHandler} in those that are {@link MessageHandlerAware}
     * and injecting the {@link HttpServletRequest} in those that are {@link ServletRequestAware}.
     * @param httpRequest the {@link HttpServletRequest}
     * @return the {@link ServiceContext}
     * @throws ConfigurationException if the Toolkit is not properly configured
     */
    private ServiceContext<SM, ID, RD> prepareServiceContext(final HttpServletRequest httpRequest) throws ConfigurationException {
        final ServiceContext<SM, ID, RD> serviceContext = serviceContextFactory.getInitialServiceContext();
        appendServiceContexts((ChainingServiceContext<SM, ID, RD>) serviceContext);
        if (serviceContext instanceof MessageHandlerAware) {
            LOG.debug("Setting message handler in service context.");
            ((MessageHandlerAware) serviceContext).setMessageHandler(messageHandler);
        }
        if (serviceContext instanceof ServletRequestAware) {
            LOG.debug("Setting servletRequest in service context.");
            ((ServletRequestAware) serviceContext).setServletRequest(httpRequest);
        }
        return serviceContext;
    }

    /**
     * Convert the resopnse data to a string.
     * @param serviceContext the {@link ServiceContext}
     * @param responseData the {@link ServiceResponseData}
     * @param outputStream the output stream
     * @return the string
     */
    protected String convertResponseData(final ServiceContext<SM, ID, RD> serviceContext, final RD responseData, final ByteArrayOutputStream outputStream) {
        String responseString;
        try {
            final InputStream responseMsgInputStream = translator.createResponseMessageStream(serviceContext, responseData);
            if (responseMsgInputStream != null) {
                try {
                    final int bytesAvailable = responseMsgInputStream.available();
                    if (bytesAvailable != 0) {
                        final byte[] responseMsgBytes = new byte[bytesAvailable];
                        try {
                            final int bytesRead = responseMsgInputStream.read(responseMsgBytes, 0, bytesAvailable);
                            if (bytesRead == bytesAvailable) {
                                responseString = writeBytesToString(outputStream, responseMsgBytes, serviceContext);
                            } else {
                                responseString = protocolHelper.returnProblem(
                                    "Bytes read from the response message's InputStream (" + bytesRead + ") are not the same as the number available (" + bytesAvailable + ").",
                                    serviceContext);
                            }
                        } catch (IOException e) {
                            responseString = protocolHelper
                                .returnException("Exception reading bytes from the response message's InputStream.", e, serviceContext, includeStackTracesInProblemResponse,
                                    includeExceptionMessagesInProblemResponse);
                        }
                    } else {
                        responseString = protocolHelper.returnProblem("No bytes are available from the response message's InputStream.", serviceContext);
                    }
                } catch (IOException e) {
                    responseString = protocolHelper.returnException("Exception getting the count of available bytes from the response message's InputStream.", e, serviceContext,
                        includeStackTracesInProblemResponse, includeExceptionMessagesInProblemResponse);
                }
            } else {
                responseString = protocolHelper.returnProblem("Response message's InputStream is null.", serviceContext);
            }
        } catch (ToolkitException e) {
            responseString = protocolHelper
                .returnException("Exception creating the InputStream from the ServiceResponseData object.", e, serviceContext, includeStackTracesInProblemResponse,
                    includeExceptionMessagesInProblemResponse);
        }
        return responseString;
    }

    /**
     * Write the bytes to the output stream and convert the output stream to a string.
     * @param outputStream the output stream
     * @param responseMsgBytes the bytes
     * @param serviceContext the {@link ServiceContext}
     * @return the resulting string
     */
    protected String writeBytesToString(final ByteArrayOutputStream outputStream, final byte[] responseMsgBytes, final ServiceContext<SM, ID, RD> serviceContext) {
        String responseString;
        try {
            outputStream.write(responseMsgBytes);
            try {
                responseString = outputStream.toString("UTF-8");
            } catch (IOException e) {
                responseString = protocolHelper
                    .returnException("Exception flushing the HttpServletResponse's OutputStream.", e, serviceContext, includeStackTracesInProblemResponse,
                        includeExceptionMessagesInProblemResponse);
            }
        } catch (IOException e) {
            responseString = protocolHelper
                .returnException("Exception writing the response message to the HttpServletResponse's OutputStream.", e, serviceContext, includeStackTracesInProblemResponse,
                    includeExceptionMessagesInProblemResponse);
        }
        return responseString;
    }

    public ProtocolHelper<SM, ID, RD> getProtocolHelper() {
        return protocolHelper;
    }

    public void setProtocolHelper(final ProtocolHelper<SM, ID, RD> protocolHelper) {
        this.protocolHelper = protocolHelper;
    }
}
