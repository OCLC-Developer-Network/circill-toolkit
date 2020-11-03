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
 * Created by bodfishj on 10/18/17.
 */
@RunWith(Suite.class)
@SuiteClasses({ ISO18626RequestClientTest.class, NCIPLookupItemClientTest.class })
public class ClientTestSuite {

    private static final Logger LOG = Logger.getLogger(ClientTestSuite.class);

    static InstalledLocalContainer container;

    @BeforeClass
    public static void beforeClass() throws Exception {
        LOG.debug("Entered DummyResponderTestSuite.beforeClass");
        try {
            LOG.info("***** Installing container.");
            final Installer installer = new ZipURLInstaller(new URL("file:./tomcat-7.0.68.zip"));
            installer.install();

            final LocalConfiguration configuration = (LocalConfiguration) new DefaultConfigurationFactory()
                .createConfiguration("tomcat7x", ContainerType.INSTALLED, ConfigurationType.STANDALONE);
            container = (InstalledLocalContainer) new DefaultContainerFactory().createContainer("tomcat7x", ContainerType.INSTALLED, configuration);
            container.setHome(installer.getHome());

            // TODO: Need to be able to automatically select the current war.
            final WAR myWar = new WAR("./target/dummy-webapp-1.0.0-SNAPSHOT.war");
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
        LOG.debug("Entered DummyResponderTestSuite.afterClass");
        try {
            container.stop();
            LOG.info("***** Stopped container.");
        } catch (Exception e) {
            LOG.error(e);
        }
    }

}
