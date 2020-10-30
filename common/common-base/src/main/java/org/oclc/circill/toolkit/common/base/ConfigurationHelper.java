/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceContext;

import static java.lang.String.format;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Helper for fetching Toolkit components from the Application Context.
 */
public final class ConfigurationHelper {

    private static final Logger LOG = Logger.getLogger(ConfigurationHelper.class);

    /** The default key for the property name of the Spring configuration file. */
    public static final String CORE_CONFIG_FILE_NAME_KEY = "circill-toolkit.config";
    /** The default value for the Spring configuration file name. */
    public static final String CORE_CONFIG_FILE_NAME_DEFAULT = "circill-toolkit.xml";

    /**
     * The application-wide Spring application context.
     */
    private static ApplicationContext globalAppContext;

    private ConfigurationHelper() {
        // Forbid construction of static helper class.
    }

    private static synchronized ApplicationContext getApplicationContext(final String componentConfigFilename) {
        AbstractApplicationContext appContext = null;
        if (componentConfigFilename != null && !componentConfigFilename.isEmpty()) {
            try {
                appContext = new ClassPathXmlApplicationContext(componentConfigFilename);
                LOG.debug("Loaded application context from '" + componentConfigFilename + "'.");
            } catch (RuntimeException e) {
                LOG.debug("No application context at '" + componentConfigFilename + "'. Runtime exception: ", e);
            }
        } else {
            LOG.debug("No default Spring configuration filename.");
        }
        return appContext;
    }

    /**
     * Returns the ApplicationContext if available, otherwise null.
     *
     * @return the {@link ApplicationContext}
     */
    private static synchronized ApplicationContext getGlobalApplicationContext() {
        if (globalAppContext == null) {
            globalAppContext = getApplicationContext(System.getProperty(CORE_CONFIG_FILE_NAME_KEY, CORE_CONFIG_FILE_NAME_DEFAULT));
        }
        return globalAppContext;
    }

    /**
     * Lower-cases the first letter of the componentName to make the bean name.
     *
     * @param componentName the name of the component (e.g. {@link ToolkitComponent#MESSAGE_HANDLER_COMPONENT_NAME}.
     * @return the name of the component's bean, e.g. "messageHandler".
     */
    private static String makeBeanName(final String componentName) {
        return componentName.substring(0, 1).toLowerCase() + componentName.substring(1);
    }

    /**
     * Get the named component from the Spring context using the value of the {@link #CORE_CONFIG_FILE_NAME_KEY} property, or {@link #CORE_CONFIG_FILE_NAME_DEFAULT} if
     * that property is not set.
     * @param componentName the name of a component, must be one from {@link ToolkitComponent#COMPONENT_NAMES}
     * @param <COMPONENT> the subclass of {@link ToolkitComponent}
     * @return the component
     * @throws ConfigurationException if the Toolkit has not been configured correctly or the component name is invalid
     */
    public static <COMPONENT extends ToolkitComponent> COMPONENT getComponent(final String componentName) throws ConfigurationException {
        final String coreSpringConfigFilename = System.getProperty(ConfigurationHelper.CORE_CONFIG_FILE_NAME_KEY, ConfigurationHelper.CORE_CONFIG_FILE_NAME_DEFAULT);
        return getComponent(componentName, coreSpringConfigFilename);
    }

    /**
     * Get the named component from the Spring context using the value of the {@link #CORE_CONFIG_FILE_NAME_KEY} property, or {@link #CORE_CONFIG_FILE_NAME_DEFAULT} if
     * that property is not set.
     * @param componentName the name of a component, must be one from {@link ToolkitComponent#COMPONENT_NAMES}
     * @param <COMPONENT> the subclass of {@link ToolkitComponent}
     * @param properties the {@link Properties} to look for the config file name in
     * @return the component
     * @throws ConfigurationException if the Toolkit has not been configured correctly or the component name is invalid
     */
    public static <COMPONENT extends ToolkitComponent> COMPONENT getComponent(final String componentName, final Properties properties) throws ConfigurationException {
        final String coreSpringConfigFilename;
        if (properties != null) {
            coreSpringConfigFilename = properties.getProperty(ConfigurationHelper.CORE_CONFIG_FILE_NAME_KEY, ConfigurationHelper.CORE_CONFIG_FILE_NAME_DEFAULT);
        } else {
            coreSpringConfigFilename = System.getProperty(ConfigurationHelper.CORE_CONFIG_FILE_NAME_KEY, ConfigurationHelper.CORE_CONFIG_FILE_NAME_DEFAULT);
        }
        return getComponent(componentName, coreSpringConfigFilename);
    }

    /**
     * Get the named component from the Spring context.
     * @param componentName the name of a component, must be one from {@link ToolkitComponent#COMPONENT_NAMES}
     * @param coreConfigFilename the Spring configuration file name
     * @param <COMPONENT> the subclass of {@link ToolkitComponent}
     * @return the component
     * @throws ConfigurationException if the Toolkit has not been configured correctly or the component name is invalid
     */
    @SuppressWarnings(value = { "unchecked" }) // Because ApplicationContext.getBean returns Object.
    public static <COMPONENT extends ToolkitComponent> COMPONENT getComponent(final String componentName, final String coreConfigFilename) throws ConfigurationException {

        COMPONENT component = null;
        if (!ToolkitComponent.COMPONENT_NAMES.contains(componentName)) {
            throw new ConfigurationException("Component name '" + componentName + "' is not one of the supported names (" + ToolkitComponent.COMPONENT_NAMES.toString() + ").");
        }
        final String beanName = makeBeanName(componentName);

        LOG.debug(format("Looking for bean with name '%s' in Spring Application context for componentName '%s', using coreConfigFilename of '%s'.", beanName, componentName,
            coreConfigFilename));
        final ApplicationContext theAppContext = getApplicationContext(coreConfigFilename);
        if (theAppContext != null) {
            if (theAppContext.containsBean(beanName)) {
                component = (COMPONENT) theAppContext.getBean(beanName);
                LOG.debug("Found " + component);
            } else {
                LOG.debug(format("Bean '%s' not found.", beanName));
            }
        } else {
            LOG.debug(format("Application Context for componentName '%s', using coreConfigFilename of '%s' not found.", componentName, coreConfigFilename));
        }

        if (component == null) {
            LOG.debug(format("Looking for bean with name '%s' in global Spring Application context.", beanName));
            final ApplicationContext globalAppContext = getGlobalApplicationContext();
            if (globalAppContext != null) {
                if (globalAppContext.containsBean(beanName)) {
                    component = (COMPONENT) globalAppContext.getBean(beanName);
                    LOG.debug("Found " + component);
                } else {
                    LOG.debug(format("Bean '%s' not found.", beanName));
                }
            } else {
                LOG.debug("No global Application Context.");
            }
        }
        return component;
    }

    /**
     * Get the named service context from the Spring context.
     * @param <SC> the {@link ServiceContext} type
     * @param beanName the name of the service context bean
     * @return the service context
     */
    public static <SC extends ServiceContext<?, ?, ?>> SC getServiceContext(final String beanName) {
        final String coreSpringConfigFilename = System.getProperty(ConfigurationHelper.CORE_CONFIG_FILE_NAME_KEY, ConfigurationHelper.CORE_CONFIG_FILE_NAME_DEFAULT);
        return getServiceContext(beanName, coreSpringConfigFilename);
    }

    /**
     * Get the named service context from the Spring context.
     * @param <SC> the {@link ServiceContext} type
     * @param beanName the name of the service context bean
     * @param properties the {@link Properties} to look for the config file name in
     * @return the service context
     */
    public static <SC extends ServiceContext<?, ?, ?>> SC getServiceContext(final String beanName, final Properties properties) {
        final String coreSpringConfigFilename;
        if (properties != null) {
            coreSpringConfigFilename = properties.getProperty(ConfigurationHelper.CORE_CONFIG_FILE_NAME_KEY, ConfigurationHelper.CORE_CONFIG_FILE_NAME_DEFAULT);
        } else {
            coreSpringConfigFilename = System.getProperty(ConfigurationHelper.CORE_CONFIG_FILE_NAME_KEY, ConfigurationHelper.CORE_CONFIG_FILE_NAME_DEFAULT);
        }
        return getServiceContext(beanName, coreSpringConfigFilename);
    }

    /**
     *
     * Get the named service context from the Spring context.
     * @param <SC> the {@link ServiceContext} type
     * @param beanName the name of the service context bean
     * @param coreConfigFilename the Spring configuration file name
     * @return the service context
     */
    @SuppressWarnings(value = { "unchecked" }) // Because ApplicationContext.getBean returns Object.
    public static <SC extends ServiceContext<?, ?, ?>> SC getServiceContext(final String beanName, final String coreConfigFilename) {
        LOG.debug(format("Looking for ServiceContext bean with name '%s' in Spring Application context, using coreConfigFilename of '%s'.", beanName, coreConfigFilename));
        SC serviceContext = null;
        final ApplicationContext theAppContext = getApplicationContext(coreConfigFilename);
        if (theAppContext != null) {
            if (theAppContext.containsBean(beanName)) {
                serviceContext = (SC) theAppContext.getBean(beanName);
                LOG.debug("Found " + serviceContext);
            } else {
                LOG.debug(format("Bean '%s' not found.", beanName));
            }
        } else {
            LOG.debug(format("Application Context for ServiceContext bean name '%s', using coreConfigFilename of '%s' not found.", beanName, coreConfigFilename));
        }

        if (serviceContext == null) {
            LOG.debug(format("Looking for bean with name '%s' in global Spring Application context.", beanName));
            final ApplicationContext globalAppContext = getGlobalApplicationContext();
            if (globalAppContext != null) {
                if (globalAppContext.containsBean(beanName)) {
                    serviceContext = (SC) globalAppContext.getBean(beanName);
                    LOG.debug("Found " + serviceContext);
                } else {
                    LOG.debug(format("Bean '%s' not found.", beanName));
                }
            } else {
                LOG.debug("No global Application Context.");
            }
        }
        return serviceContext;
    }
}
