/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy.web;

import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.ncip.NCIPServiceContext;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceImpl;
import org.oclc.circill.toolkit.initiator.client.HttpClientImpl;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManagerImpl;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

import java.io.IOException;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Base for tests of the NCIP responder.
 */
public class NCIPClientTestBase {

    private static final Logger LOG = Logger.getLogger(NCIPClientTestBase.class);

    protected HttpClientImpl client;
    protected HttpInitiatorServiceImpl<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> service;
    protected NCIPServiceContext  serviceContext;

    protected NCIPClientTestBase() {
        final ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("circill-ncip-toolkit-client.xml");
        try {
            client = (HttpClientImpl) appContext.getBean("ncipClient");
            service = (HttpInitiatorServiceImpl<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData>) appContext.getBean("ncipInitiatorService");
            final ServiceContextFactory serviceContextFactory = (ServiceContextFactory) appContext.getBean("ncipServiceContextFactory");
            serviceContext = (NCIPServiceContext) serviceContextFactory.getInitialServiceContext();
        } catch (ConfigurationException e) {
            LOG.error(e);
            fail("Configuration problem.");
        } finally {
            appContext.destroy();
        }
    }

    protected NCIPResponseData sendMessage(final NCIPInitiationData initData) throws ToolkitException, IOException {
        LOG.debug("Entered BaseDummyResponderNCIPTest.sendMessage");

        final HttpInitiatorServiceManagerImpl serviceManager = new HttpInitiatorServiceManagerImpl(client, "http://localhost:8080/dummy/ncip/responder");
        final NCIPResponseData responseMessage = service.performService(initData, serviceContext, serviceManager);

        LOG.debug("Leaving BaseDummyResponderNCIPTest.sendMessage");

        return responseMessage;
    }
}
