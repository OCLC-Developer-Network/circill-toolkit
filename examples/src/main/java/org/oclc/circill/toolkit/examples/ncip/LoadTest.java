/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples.ncip;

import org.oclc.circill.toolkit.common.base.ConfigurationHelper;
import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.StatisticsBean;
import org.oclc.circill.toolkit.common.base.ToolkitComponent;
import org.oclc.circill.toolkit.common.base.Translator;
import org.oclc.circill.toolkit.common.ncip.NCIPProtocolHelper;
import org.oclc.circill.toolkit.initiator.servicemanager.SocketInitiatorServiceImpl;
import org.oclc.circill.toolkit.initiator.client.HttpClient;
import org.oclc.circill.toolkit.initiator.client.HttpClientImpl;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManager;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManagerImpl;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.BibliographicId;
import org.oclc.circill.toolkit.service.ncip.BibliographicRecordId;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.LookupItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupItemSetInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.Problem;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;

import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.log4j.Logger;

/**
 * Use this class to perform load-tests on an NCIPResponder.
 * Its input is given on the command-line and consists of the following parameters:<p>
 *&nbsp;<code>service file delimiter keyField threads messages targetURL</code><p>
 * Example 'service' values are LookupItem, LookupItemSet, LookupUser, etc.
 * Note: Only 'LookupItemSet' is supported presently.
 * The 'file' parameter should be the full path and name of a text file containing the keys to be used in the Lookup messages.  No default; this parameter is required.
 * The 'delimiter' is a character or string of characters that delimits fields in the text file.  No default; this parameter is required.
 * The 'keyField' is the ordinal number of the key in the text file. No default; this parameter is required.
 * The 'threads' is the number of simultaneous threads to use to perform the tests. Default is 1.
 * The 'messages' is the number of messages. Default is 1.
 * The 'targetURL' is the host to send the messages to. Default is http://localhost:8080/ncipv2/NCIPResponder.
 * For example, if the text file is named "LoadTestRecords.csv" and is a comma-separated file with the key of a
 * bibliographic record id in the first column, using 4 threads each sending 20 messages, your parameters would be:
 *    LookupItemSet LoadTestRecords.csv "," 1 4 20
 * The messages sent will be randomly chosen from the list of keys in the input file.
 * Note: To speed the sending of messages once the test has started, this program creates the initiation messages
 * for every input record <i>before</i> sending any, so there may be a long start-up time, and it may require a large
 * amount of memory to run this program if the input file is large.
 *
 */
public class LoadTest implements Runnable {

    private static final Logger LOG = Logger.getLogger(LoadTest.class);
    private static final int SERVICE_NAME_ARG = 0;
    private static final int FILE_NAME_ARG = 1;
    private static final int DELIMITER_ARG = 2;
    private static final int KEY_FIELD_ARG = 3;
    private static final int NUMBER_OF_THREADS_ARG = 4;
    private static final int NUMBER_OF_MESSAGES_ARG = 5;
    private static final int TARGET_URL_ARG = 6;
    private static final int AGENCY_ID_ARG = 7;
    private static final Random RANDOM_GENERATOR = new Random();
    private static final Map<String, BiFunction<String, AgencyId, NCIPInitiationData>> INIT_MESSAGE_CREATION_METHODS;
    static {
        final Map<String, BiFunction<String, AgencyId, NCIPInitiationData>> tempMap = new HashMap<>();
        tempMap.put("LookupItemSet", LoadTest::createLookupItemSetMessage);
        tempMap.put("LookupItem", LoadTest::createLookupItemMessage);
        INIT_MESSAGE_CREATION_METHODS = Collections.unmodifiableMap(tempMap);
    }
    protected static final String DEFAULT_TARGET_URL = "http://localhost:8080/ncipv2/NCIPResponder";
    protected static final StatisticsBean STATISTICS_BEAN;

    static {
        try {
            STATISTICS_BEAN = ConfigurationHelper.getComponent(ToolkitComponent.STATISTICS_BEAN_COMPONENT_NAME);
        } catch (ConfigurationException e) {
            LOG.error(e);
            throw new ExceptionInInitializerError(e);
        }
    }

    protected final Translator<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> translator;
    protected final ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContextFactory;
    protected static NCIPProtocolHelper protocolHelper = new NCIPProtocolHelper();

    protected NCIPInitiationData[] initiationData;
    protected int numberOfMessages;
    protected String targetURL;
    protected Service<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> service;
    protected HttpInitiatorServiceManager serviceManager;

    /**
     * Run the load test.
     * @param args command-line arguments
     * @throws IOException -
     * @throws ConfigurationException -
     * @throws InterruptedException -
     */
    public static void main(final String[] args) throws IOException, ConfigurationException, InterruptedException {

        final String serviceName = args[SERVICE_NAME_ARG];
        final String fileName = args[FILE_NAME_ARG];
        final String delimiter = args[DELIMITER_ARG];
        final int keyField = Integer.parseInt(args[KEY_FIELD_ARG]);
        int numberOfThreads = 1;
        if (args.length > NUMBER_OF_THREADS_ARG && args[NUMBER_OF_THREADS_ARG] != null) {
            numberOfThreads = Integer.parseInt(args[NUMBER_OF_THREADS_ARG]);
        }

        int numberOfMessages = 1;
        if (args.length > NUMBER_OF_MESSAGES_ARG && args[NUMBER_OF_MESSAGES_ARG] != null) {
            numberOfMessages = Integer.parseInt(args[NUMBER_OF_MESSAGES_ARG]);
        }

        String targetURL = DEFAULT_TARGET_URL;
        if (args.length > TARGET_URL_ARG && args[TARGET_URL_ARG] != null) {
            targetURL = args[TARGET_URL_ARG];
        }

        String agencyIdString = "nowhere";
        if (args.length > AGENCY_ID_ARG && args[AGENCY_ID_ARG] != null) {
            agencyIdString = args[AGENCY_ID_ARG];
        }
        final AgencyId agencyId = new AgencyId(agencyIdString);

        final List<NCIPInitiationData> initiationDataList = new ArrayList<>();
        createMessages(fileName, delimiter, keyField, serviceName, agencyId, initiationDataList);

        final Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < threads.length; ++i) {
            threads[i] = new Thread(new LoadTest(initiationDataList.toArray(new NCIPInitiationData[initiationDataList.size()]), numberOfMessages, targetURL));
        }

        runThreads(threads);

        reportStatistics();
    }

    private static void reportStatistics() {
        final String statsReport = STATISTICS_BEAN.createCSVReport();
        LOG.info(statsReport);
    }

    private static void runThreads(final Thread[] threads) throws InterruptedException {
        for (final Thread thread : threads) {
            thread.start();
        }

        for (final Thread thread : threads) {
            thread.join();
        }
    }

    private static void createMessages(final String fileName, final String delimiter, final int keyField, final String serviceName, final AgencyId agencyId,
        final List<NCIPInitiationData> initiationDataList) throws IOException {
        LOG.info("Beginning to create initiation messages.");
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            final MutableInt messageCount = new MutableInt(0);
            String strLine;
            while ((strLine = br.readLine()) != null) {

                final String[] fields = strLine.split(delimiter);
                final String key = fields[keyField - 1];
                createMessage(serviceName, key, agencyId, initiationDataList, messageCount);
            }
            LOG.info("Created " + messageCount + " messages.");
        }
    }

    private static void createMessage(final String serviceName, final String key, final AgencyId agencyId, final List<NCIPInitiationData> initiationDataList,
        final MutableInt messageCount) {
        final BiFunction<String, AgencyId, NCIPInitiationData> createMethod = INIT_MESSAGE_CREATION_METHODS.get(serviceName);
        if (createMethod != null) {
            final NCIPInitiationData initData = createMethod.apply(key, agencyId);
            initiationDataList.add(initData);
            messageCount.increment();
            if (messageCount.getValue() % 10 == 0) {
                LOG.info("Created " + messageCount + " messages.");
            }
        } else {
            LOG.error("Unknown service name '" + serviceName + "'.");
        }
    }

    private static LookupItemInitiationData createLookupItemMessage(final String key, final AgencyId agencyId) {
        final LookupItemInitiationData initData = new LookupItemInitiationData();
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue(key);
        itemId.setAgencyId(agencyId);
        initData.setItemId(itemId);
        initData.setBibliographicDescriptionDesired(true);
        initData.setCirculationStatusDesired(true);
        initData.setItemDescriptionDesired(true);
        initData.setLocationDesired(true);
        return initData;
    }

    private static LookupItemSetInitiationData createLookupItemSetMessage(final String key, final AgencyId agencyId) {
        final LookupItemSetInitiationData initData = new LookupItemSetInitiationData();
        final BibliographicRecordId bibRecId = new BibliographicRecordId();
        bibRecId.setBibliographicRecordIdentifier(key);
        bibRecId.setAgencyId(agencyId);
        final BibliographicId bibId = new BibliographicId();
        bibId.setBibliographicRecordId(bibRecId);
        final List<BibliographicId> bibIds = new ArrayList<>();
        bibIds.add(bibId);
        initData.setBibliographicIds(bibIds);
        initData.setBibliographicDescriptionDesired(true);
        initData.setCirculationStatusDesired(true);
        initData.setItemDescriptionDesired(true);
        initData.setLocationDesired(true);
        return initData;
    }

    /**
     * Construct a load test.
     * @param initiationData an array of NCIPInitiationData objects to use for the test
     * @param numberOfMessages the number of messages to send
     * @param targetURL the target URL of the NCIP responder
     * @throws ConfigurationException -
     */
    public LoadTest(final NCIPInitiationData[] initiationData, final int numberOfMessages, final String targetURL) throws ConfigurationException {
        this.initiationData = initiationData;
        this.numberOfMessages = numberOfMessages;
        this.targetURL = targetURL;
        final HttpClient client = new HttpClientImpl(STATISTICS_BEAN);
        serviceManager = new HttpInitiatorServiceManagerImpl(client, targetURL);
        translator = ConfigurationHelper.getComponent(ToolkitComponent.TRANSLATOR_COMPONENT_NAME);
        service = new SocketInitiatorServiceImpl<>(translator);
        serviceContextFactory = ConfigurationHelper.getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
    }

    @Override
    public void run() {
        try {
            LOG.info("Beginning " + numberOfMessages + " message(s).");
            for (int i = 0; i < numberOfMessages; ++i) {

                final int randomIndex = RANDOM_GENERATOR.nextInt(initiationData.length);
                final NCIPInitiationData initiationMessage = initiationData[randomIndex];

                final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext = serviceContextFactory
                    .getInitialServiceContext();

                final NCIPResponseData responseData;
                LOG.debug("Sending message.");
                responseData = service.performService(initiationMessage, serviceContext, serviceManager);

                LOG.debug("Received response.");
                final List<Problem> problems = responseData.getProblems();
                if (problems != null && problems.size() > 0) {
                    LOG.error("Problems found:");
                    LOG.error(responseData);
                } else {
                    LOG.debug("Received successful response.");
                    LOG.debug(responseData);
                }
            }
        } catch (ToolkitException e) {
            LOG.error(e);
        }
    }
}
