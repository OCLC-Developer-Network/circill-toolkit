/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples;

import org.oclc.circill.toolkit.common.base.ConfigurationHelper;
import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.StatisticsBean;
import org.oclc.circill.toolkit.common.base.ToolkitComponent;
import org.oclc.circill.toolkit.common.base.Translator;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceImpl;
import org.oclc.circill.toolkit.initiator.client.HttpClientImpl;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManagerImpl;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.log4j.Logger;

/**
 * Read a file containing an initiation message, send it to a responder/server, and print the response.
 */
public class FileInitiator implements Runnable {

    private static final Logger LOG = Logger.getLogger(FileInitiator.class);

    public static final String DEFAULT_FILENAME_PATTERN = ".*LookupUser.*\\.xml";
    public static final String DEFAULT_FILE_DIRECTORY = "src/test/data";
    public static final String DEFAULT_TARGET_URL = "http://localhost:8080/ncipv2/NCIPResponder";
    protected final Translator<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> translator;

    protected final StatisticsBean statisticsBean;

    protected final boolean logDataObjects = Boolean.parseBoolean(System.getProperty(FileInitiator.class.getName() + ".logDataObjects", "false"));

    protected final String[] args;

    /**
     * Construct a FileInitiator with the supplied command-line arguments.
     * @param args the command-line arguments
     * @throws ConfigurationException -
     */
    public FileInitiator(final String[] args) throws ConfigurationException {
        this.args = args;
        translator = ConfigurationHelper.getComponent(ToolkitComponent.TRANSLATOR_COMPONENT_NAME);
        statisticsBean = ConfigurationHelper.getComponent(ToolkitComponent.STATISTICS_BEAN_COMPONENT_NAME);
    }

    /**
     * Run the FileInitiator.
     * @param args the command-line arguments.
     * @throws ConfigurationException -
     */
    public static void main(final String[] args) throws ConfigurationException {
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> {
            LOG.debug("Verifying hostname '" + hostname + "'.");
            return ("localhost".compareToIgnoreCase(hostname) == 0);
        });
        final FileInitiator fileInitiator = new FileInitiator(args);
        fileInitiator.run();
    }

    @Override
    public void run() {
        if (args.length > 0 && args[0].matches("(?i)--?h(elp)?")) {
            LOG.error("Usage: java " + FileInitiator.class.getName() + " [fileNamePattern [fileDirectory [targetURL]]]");
            LOG.error(
                "Where fileNamePattern defaults to '" + DEFAULT_FILENAME_PATTERN + "', fileDirectory defaults to '" + DEFAULT_FILE_DIRECTORY + "', and targetURL defaults to '"
                    + DEFAULT_TARGET_URL + "'.");
        } else {
            sendFile();
        }
    }

    private void sendFile() {
        String fileNamesPattern = DEFAULT_FILENAME_PATTERN;
        if (args.length > 0) {
            fileNamesPattern = args[0];
        }

        String sampleFilesDirectory = DEFAULT_FILE_DIRECTORY;
        if (args.length > 1) {
            sampleFilesDirectory = args[1];
        }

        String targetURL = DEFAULT_TARGET_URL;
        if (args.length > 2) {
            targetURL = args[2];
        }

        final File dir = new File(sampleFilesDirectory);
        final FileFilter fileFilter = File::isFile;
        final File[] files = dir.listFiles(fileFilter);
        final MutableInt filesProcessed = new MutableInt(0);

        if (files != null) {
            for (final File file : files) {
                try {
                    processFile(file, fileNamesPattern, targetURL, filesProcessed);
                } catch (IOException | ToolkitException e) {
                    LOG.error("Exception sending message:", e);
                }
            }
        }

        if (filesProcessed.getValue() == 0) {
            LOG.error(
                "No files matching the pattern '" + fileNamesPattern + "' were found in '" + sampleFilesDirectory + "'." + " Note: do not include a trailing slash in the path."
                    + " Working directory: " + System.getProperty("user.dir"));
        } else {
            final String statsReport = statisticsBean.createCSVReport();
            LOG.debug(statsReport);
        }
    }

    private void processFile(final File file, final String fileNamesPattern, final String targetURL, final MutableInt filesProcessed) throws IOException, ToolkitException {
        final String fileName = file.getName();
        if (fileNamesPattern == null || fileNamesPattern.length() == 0 || fileName.matches(fileNamesPattern)) {
            LOG.debug("Reading " + fileName);
            try (InputStream inStream = new FileInputStream(file)) {
                final ServiceContextFactory<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> serviceContextFactory
                    = ConfigurationHelper.getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
                final ServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> serviceContext = serviceContextFactory
                    .getInitialServiceContext();
                final ServiceInitiationData initiationData = getInitiationData(inStream, serviceContext);
                filesProcessed.increment();
                logServiceData("Successfully converted file to data object.", initiationData);

                LOG.debug("Sending " + fileName);
                final HttpInitiatorServiceManagerImpl serviceManager = new HttpInitiatorServiceManagerImpl(new HttpClientImpl(statisticsBean), targetURL);
                final HttpInitiatorServiceImpl<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> service
                    = new HttpInitiatorServiceImpl<>(translator);
                service.setHeaderGenerators(Collections
                    .singletonList(serviceInitiationData -> Collections.singletonMap("wskey", "bTp1nV2DaOYWQtYiAJiHUmxBc8WPrixjP1uZWCzson6XdMrTxqxN8eWMjAcFhQneLeMT9QOrfaldCBQF")));
                final ServiceResponseData responseData = service.performService(initiationData, serviceContext, serviceManager);

                if (responseData != null) {
                    logServiceData("Received response.", responseData);
                } else {
                    LOG.error("Response data is null.");
                }
            }
        }
    }

    private ServiceInitiationData getInitiationData(final InputStream inStream,
        final ServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> serviceContext) throws ToolkitException {
        final ServiceInitiationData initiationData = translator.createInitiationData(serviceContext, inStream);
        return initiationData;
    }

    private void logServiceData(final String logMessage, final Object serviceData) {
        LOG.info(logMessage);
        if (logDataObjects) {
            LOG.info(serviceData.toString());
        }
    }
}
