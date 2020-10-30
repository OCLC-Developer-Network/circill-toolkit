package org.oclc.circill.toolkit.dummy.web;

import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.iso18626.ISO18626ServiceContext;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceImpl;
import org.oclc.circill.toolkit.initiator.client.HttpClientImpl;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManagerImpl;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;

import java.io.IOException;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Base for tests of the ISO 18626 responder.
 */
public class ISO18626ClientTestBase {

    private static final Logger LOG = Logger.getLogger(ISO18626ClientTestBase.class);

    protected HttpClientImpl client;
    protected HttpInitiatorServiceImpl<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> service;
    protected ISO18626ServiceContext serviceContext;

    protected ISO18626ClientTestBase() {
        final ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("circill-iso18626-toolkit-client.xml");
        try {
            client = (HttpClientImpl) appContext.getBean("v2017Client");
            service = (HttpInitiatorServiceImpl<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>) appContext
                .getBean("v2017InitiatorService");
            final ServiceContextFactory serviceContextFactory = (ServiceContextFactory) appContext.getBean("v2017ServiceContextFactory");
            serviceContext = (ISO18626ServiceContext) serviceContextFactory.getInitialServiceContext();
        } catch (ConfigurationException e) {
            LOG.error(e);
            fail("Configuration problem.");
        } finally {
            appContext.destroy();
        }
    }

    protected ISO18626ConfirmationData sendMessage(final ISO18626RequestData initData) throws ToolkitException, IOException {
        LOG.debug("Entered BaseDummyResponderISO18626Test.sendMessage");

        final HttpInitiatorServiceManagerImpl serviceManager = new HttpInitiatorServiceManagerImpl(client, "http://localhost:8080/dummy/iso18626/responder");
        final ISO18626ConfirmationData confirmationMessage = service.performService(initData, serviceContext, serviceManager);

        LOG.debug("Leaving BaseDummyResponderISO18626Test.sendMessage");

        return confirmationMessage;
    }

}
