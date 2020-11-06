/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy.web;

import java.net.URL;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.codehaus.cargo.container.ContainerType;
import org.codehaus.cargo.container.InstalledLocalContainer;
import org.codehaus.cargo.container.configuration.ConfigurationType;
import org.codehaus.cargo.container.configuration.LocalConfiguration;
import org.codehaus.cargo.container.deployable.WAR;
import org.codehaus.cargo.container.installer.Installer;
import org.codehaus.cargo.container.installer.ZipURLInstaller;
import org.codehaus.cargo.generic.DefaultContainerFactory;
import org.codehaus.cargo.generic.configuration.DefaultConfigurationFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for integration tests of the client/initiator & server/responder.
 */
@RunWith(Suite.class)
@SuiteClasses({ ISO18626RequestClientTest.class, NCIPLookupItemClientTest.class })
public class IntegrationTestSuite {

    private static final Logger LOG = Logger.getLogger(IntegrationTestSuite.class);

    static InstalledLocalContainer container;

    @BeforeClass
    public static void beforeClass() throws Exception {
        try {
            LOG.info("***** Installing container.");
            final Installer installer = new ZipURLInstaller(new URL("file:./src/test/resources/tomcat-7.0.68.zip"));
            installer.install();

            final LocalConfiguration configuration = (LocalConfiguration) new DefaultConfigurationFactory()
                .createConfiguration("tomcat7x", ContainerType.INSTALLED, ConfigurationType.STANDALONE);
            container = (InstalledLocalContainer) new DefaultContainerFactory().createContainer("tomcat7x", ContainerType.INSTALLED, configuration);
            container.setHome(installer.getHome());

            final String projectVersion = System.getProperty("projectVersion");
            final String warFilePath = "./target/dummy-webapp-" + projectVersion + ".war";
            LOG.info("war file path = '" + warFilePath);
            final WAR myWar = new WAR(warFilePath);
            myWar.setContext("/dummy");
            configuration.addDeployable(myWar);

            container.start();
            LOG.info("***** Started container.");
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    @Test
    public void dummyTest() {
        // Test does nothing, but forces SureFire to run this class.
        assertTrue(true);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        try {
            container.stop();
            LOG.info("***** Stopped container.");
        } catch (Exception e) {
            LOG.error(e);
        }
    }

}
