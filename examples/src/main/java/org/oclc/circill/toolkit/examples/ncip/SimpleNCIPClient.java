/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples.ncip;

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
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.Problem;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This abstract class provides the base class for simple NCIP Initiators that perform a single NCIP service
 * on an NCIP Responder at a target URL (e.g. http://localhost:8080/ncip/responder) and displays the results.
 */
public abstract class SimpleNCIPClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleNCIPClient.class);
    /** The Spring application context. */
    private final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("circill-ncip-toolkit-client.xml");
    /** The {@link StatisticsBean} to capture performance statistics. */
    private final StatisticsBean statisticsBean = (StatisticsBean) applicationContext.getBean("ncipStatisticsBean");

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
        final NCIPInitiationData initiationData = buildInitiationData(params);
        final NCIPResponseData responseData = sendMessage(targetURL, initiationData);
        final List<Problem> problems = responseData.getProblems();
        if (CollectionUtils.isEmpty(problems)) {
            reportSuccess(responseData);
        } else {
            reportProblems(problems);
        }

        final String statsReport = statisticsBean.createCSVReport();
        LOG.info(statsReport);

    }

    /**
     * Perform the NCIP service for the initiationData on the NCIP responder at the target URL.
     *
     * @param targetURL the URL of the target NCIP responder, e.g. http://mylibrary.mycollege.edu:9020/ncip.
     * @param initiationData the {@link NCIPInitiationData}
     * @throws ToolkitException if an exception occurs in the Toolkit processing
     */
    private NCIPResponseData sendMessage(final String targetURL, final NCIPInitiationData initiationData)
        throws ConfigurationException, ServiceException, ValidationException {
        final ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContextFactory
            = (ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData>) applicationContext
            .getBean("ncipServiceContextFactory");
        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext = serviceContextFactory
            .getInitialServiceContext();
        final HttpClient client = new HttpClientImpl(statisticsBean);
        final HttpInitiatorServiceManager serviceManager = new HttpInitiatorServiceManagerImpl(client, targetURL);
        final Translator<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> translator
            = (Translator<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData>) applicationContext.getBean("ncipTranslator");
        final Service<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> service = new HttpInitiatorServiceImpl<>(translator);

        final NCIPResponseData responseData = service.performService(initiationData, serviceContext, serviceManager);
        return responseData;
    }

    /**
     * Build the {@link NCIPInitiationData} for the supplied parameters.
     *
     * @param params    array of Strings
     * @return {@link NCIPInitiationData}
     * @throws ToolkitException if an exception occurs in the Toolkit processing
     */
    public abstract NCIPInitiationData buildInitiationData(String[] params) throws ToolkitException;

    /**
     * Called to report successful responses.
     * @param responseData the response message
     */
    protected abstract void reportSuccess(NCIPResponseData responseData);

    /**
     * Print (to the console) the provided list of {@link Problem}s.
     * @param problems the problems
     */
    protected static void reportProblems(final List<Problem> problems) {
        final StringBuilder problemBuffer = new StringBuilder();
        for (final Problem problem : problems) {
            problemBuffer.append(problem.toString()).append(System.lineSeparator());
        }
        LOG.error("A problem was returned: " + problemBuffer.toString());
    }
}
