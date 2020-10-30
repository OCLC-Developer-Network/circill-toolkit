/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb;

import org.oclc.circill.toolkit.service.base.ConfigurationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public final class JAXBContextFactory {

    private static final Logger LOG = Logger.getLogger(JAXBContextFactory.class);

    /**
     * This utility class does not allow instances.
     */
    private JAXBContextFactory() {
    }

    /**
     * This holds the instance of JAXBContext returned to all callers of getJAXBContext(packageName) for a given
     * package name. If you want multiple JAXBContexts for the same package name you will need to call
     * {@link #getUniqueJAXBContext(String)}.
     */
    protected static final Map<String /* package name */, JAXBContext> sharedJAXBContextInstances = new ConcurrentHashMap<>();

    /**
     * Get the shared JAXBContext object for this colon-separated list of package names. 
     * If this is not already set (e.g. by Spring) or a prior
     * call to this method, this calls {@link #getUniqueJAXBContext(String)} to construct it.
     * @param packageNames a colon-separated list of package names
     * @return the {@link JAXBContext} object
     * @throws ConfigurationException if the Toolkit is not configured properly
     */
    public static synchronized JAXBContext getJAXBContext(final String packageNames) throws ConfigurationException {

        JAXBContext jaxbContext;

        jaxbContext = sharedJAXBContextInstances.get(packageNames);

        if (jaxbContext == null) {

            jaxbContext = getUniqueJAXBContext(packageNames);
            sharedJAXBContextInstances.put(packageNames, jaxbContext);

        }

        return jaxbContext;

    }

    /**
     * Construct a JAXBContext for the provided packageName.
     *
     * @param packageNames the colon-separated list of package names of the Java package(s) for the JAXBContext
     * @return the new JAXBContext object
     * @throws ConfigurationException if there is an error in the Toolkit configuration
     */
    public static JAXBContext getUniqueJAXBContext(final String packageNames) throws ConfigurationException {

        final JAXBContext jaxbContext;

        try {

            LOG.debug("Creating a JAXBContext for " + packageNames);
            jaxbContext = JAXBContext.newInstance(packageNames);

        } catch (JAXBException e) {

            throw new ConfigurationException("Exception constructing a JAXBContext for package name(s) " + packageNames + ".", e);
        }

        return jaxbContext;

    }

}
