/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples.ncip;

import org.oclc.circill.toolkit.common.base.ConfigurationHelper;
import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.ToolkitComponent;
import org.oclc.circill.toolkit.common.base.Translator;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import junit.framework.Assert;
import org.junit.Test;

public class TestExampleItemIdentifierTypePass {

    protected static final String TEST_FILE = "src/test/data/LookupItemWithExampleItemIdentifierType.xml";

    @Test
    public void testExampleItemIdentifierType() throws FileNotFoundException, ToolkitException {

        final Properties properties = new Properties();
        properties.setProperty(ConfigurationHelper.CORE_CONFIG_FILE_NAME_KEY, "circill-toolkit-TestExampleItemIdentifierType-success.xml");
        final Translator<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> translator = ConfigurationHelper
            .getComponent(ToolkitComponent.TRANSLATOR_COMPONENT_NAME, properties);

        final String testFile = System.getProperty("testFile", TEST_FILE);

        final InputStream inStream = new FileInputStream(new File(testFile));

        final ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContextFactory = ConfigurationHelper
            .getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME, properties);
        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext = serviceContextFactory.getInitialServiceContext();

        final NCIPInitiationData initiationData = translator.createInitiationData(serviceContext, inStream);

        Assert.assertNotNull(initiationData);

    }

}
