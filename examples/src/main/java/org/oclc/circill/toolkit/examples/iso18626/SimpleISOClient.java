/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples.iso18626;

import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.StatisticsBean;
import org.oclc.circill.toolkit.common.base.Translator;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceImpl;
import org.oclc.circill.toolkit.initiator.client.HttpClient;
import org.oclc.circill.toolkit.initiator.client.HttpClientImpl;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManager;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManagerImpl;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.iso18626.ErrorData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This abstract class provides the base class for simple clients that send a single message
 * to an ISO 18626 service at a target URL (e.g. http://localhost:8080/iso18626/responder) and displays the results.
 */
public abstract class SimpleISOClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleISOClient.class);
    /** The Spring application context. */
    private final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("circill-iso18626-toolkit-client.xml");
    /** The {@link StatisticsBean} to capture performance statistics. */
    private final StatisticsBean statisticsBean = (StatisticsBean) applicationContext.getBean("v2017StatisticsBean");

    /**
     * Execute the client using the provided command-line parameters.
     *
     * @param args parameters from the command-line: arg[0] is targetURL, the remainder are specific to the subclass.
     * @throws ToolkitException if an exception occurs in the Toolkit processing
     * @throws ClassNotFoundException if a dependency is missing or a class name provided via Toolkit configuration is wrong
     * @throws IllegalAccessException if a class name provided via Toolkit configuration is wrong
     * @throws InstantiationException if a class name provided via Toolkit configuration is wrong
     * @throws NoSuchMethodException if there's no default constructor for the client class (arg[0])
     * @throws InvocationTargetException if the client class (arg[0]) can't be constructed
     */
    public void execute(final String[] args)
        throws ToolkitException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        final String targetURL = args[0];
        final String[] params = Arrays.copyOfRange(args, 1, args.length);
        final ISO18626RequestData initiationData = buildISO18626RequestData(params);
        final ISO18626ConfirmationData responseData = sendMessage(targetURL, initiationData);
        if (responseData.getErrorData() == null) {
            reportSuccess(responseData);
        } else {
            reportError(responseData.getErrorData());
        }

        final String statsReport = statisticsBean.createCSVReport();
        LOG.info(statsReport);

    }

    /**
     * Send the iso18626RequestData to the ISO 18626 service at the target URL.
     *
     * @param targetURL the URL of the target ISO 18626 service.
     * @param iso18626RequestData the {@link ISO18626RequestData}
     * @throws ToolkitException if an exception occurs in the Toolkit processing
     */
    private ISO18626ConfirmationData sendMessage(final String targetURL, final ISO18626RequestData iso18626RequestData)
        throws ConfigurationException, ServiceException, ValidationException {
        final ServiceContextFactory<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> serviceContextFactory
            = (ServiceContextFactory<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>) applicationContext
            .getBean("v2017ServiceContextFactory");
        final ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> serviceContext = serviceContextFactory
            .getInitialServiceContext();
        final HttpClient client = new HttpClientImpl(statisticsBean);
        final HttpInitiatorServiceManager serviceManager = new HttpInitiatorServiceManagerImpl(client, targetURL);
        final Translator<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> translator
            = (Translator<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>) applicationContext
            .getBean("v2017Translator");
        final Service<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> service = new HttpInitiatorServiceImpl<>(
            translator);

        final ISO18626ConfirmationData responseData = service.performService(iso18626RequestData, serviceContext, serviceManager);
        return responseData;
    }

    /**
     * Build the {@link ISO18626RequestData} for the supplied parameters.
     *
     * @param params    array of Strings
     * @return {@link ISO18626RequestData}
     * @throws ToolkitException if an exception occurs in the Toolkit processing
     */
    public abstract ISO18626RequestData buildISO18626RequestData(String[] params) throws ToolkitException;

    /**
     * Called to report successful responses.
     * @param responseData the response message
     */
    protected abstract void reportSuccess(ISO18626ConfirmationData responseData);

    /**
     * Print (to the console) the provided {@link ErrorData}s.
     * @param errorData the problems
     */
    protected static void reportError(final ErrorData errorData) {
        final StringBuilder errorDataBuilder = new StringBuilder();
        errorDataBuilder.append(errorData.getErrorType().name()).append(": ").append(errorData.getErrorValue()).append(System.lineSeparator());
        LOG.error("An error was returned: " + errorDataBuilder.toString());
    }
}
