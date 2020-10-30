/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb;

import org.oclc.circill.toolkit.binding.MarshallerFactory;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;
import org.oclc.circill.toolkit.service.base.XMLServiceContext;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * A factory to create {@link Marshaller}s and {@link Unmarshaller}s.
 */
public class JAXBMarshallerFactory implements MarshallerFactory {

    private static final Logger LOG = Logger.getLogger(JAXBMarshallerFactory.class);

    protected final Map<String /* CanonicalSchemaURLsCSVList */, Schema> schemasByCanonicalURLsCSVList = new HashMap<>();

    protected Map<String /* Known Alias */, String /* Canonical URL */> canonicalSchemaURLMap = new HashMap<>();

    protected final Map<String /* Canonical Schema URL */, String /* JAXB Package name */> schemaURLsToPackageMap;

    /**
     * Construct an instance with the provider schemaURLsToPackageMap.
     * @param schemaURLsToPackageMap a map with keys of XML Schema URLs and values of JAXB packages generated from that schema.
     */
    public JAXBMarshallerFactory(final Map<String, String> schemaURLsToPackageMap) {
        this.schemaURLsToPackageMap = schemaURLsToPackageMap;
    }

    public void setCanonicalSchemaURLMap(final Map<String, String> canonicalSchemaURLMap) {
        this.canonicalSchemaURLMap = new HashMap<>(canonicalSchemaURLMap);
    }

    /**
     * Get a JAXBContext for the provided schemas.
     * @param schemaURLsList {@link List} of XML schema URLs for the JAXBContext. This method calls
     * {@link #canonicalizeSchemaURL(String)} on supportedSchemaURLs and looks in its map of SchemaURLsToPackageNames
     * for the package names that are to be used to marshall/unmarshall
     * documents using those URLs, and then gets a {@link JAXBContext} for those packages.
     *
     * @return the JAXBContext
     */
    protected JAXBContext getJAXBContext(final List<String> schemaURLsList) {
        final JAXBContext jaxbContext;
        final List<String> packageNameList = new ArrayList<>();
        if (schemaURLsList != null && !schemaURLsList.isEmpty()) {
            for (final String schemaURL : schemaURLsList) {
                final String packageName = getPackageNameForSchemaURL(schemaURL);
                if (packageName != null && !packageName.isEmpty() && !packageNameList.contains(packageName)) {
                    packageNameList.add(packageName);
                }
            }
        }

        final String colonSeparatedPackageNames = ToolkitHelper.concatenateStrings(packageNameList, ":");
        try {
            jaxbContext = JAXBContextFactory.getJAXBContext(colonSeparatedPackageNames);
        } catch (ToolkitException e) {
            LOG.error("Exception getting JAXBContext:", e);
            throw new ExceptionInInitializerError(e);
        }

        return jaxbContext;
    }

    @Override
    public Marshaller getMarshaller(final ServiceContext serviceContext) throws ConfigurationException {
        final Marshaller marshaller;
        if (serviceContext instanceof XMLServiceContext) {
            final XMLServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> xmlServiceContext
                = (XMLServiceContext) serviceContext;
            try {
                final List<String> schemaURLsList = xmlServiceContext.getSchemaURLs();
                marshaller = getJAXBContext(schemaURLsList).createMarshaller();
                if (xmlServiceContext.validateMessagesAgainstSchema()) {
                    final Schema schema = getSchema(xmlServiceContext.getSchemaURLs());
                    if (schema != null) {
                        marshaller.setSchema(schema);
                    }
                }
                final PreferredMapper mapper = new PreferredMapper(xmlServiceContext);
                marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);
            } catch (JAXBException e) {
                throw new ConfigurationException("JAXBException creating Marshaller.", e);
            }
        } else {
            throw new ConfigurationException("ServiceContext of '" + serviceContext.getClass().getName() + "' not supported; must be an instance of XMLServiceContext.");
        }
        return marshaller;
    }

    public Unmarshaller getUnmarshaller(final ServiceContext serviceContext) throws ConfigurationException {
        final Unmarshaller unmarshaller;
        if (serviceContext instanceof XMLServiceContext) {
            try {
                final XMLServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> xmlServiceContext
                    = (XMLServiceContext) serviceContext;
                unmarshaller = getJAXBContext(xmlServiceContext.getSchemaURLs()).createUnmarshaller();
                if (xmlServiceContext.validateMessagesAgainstSchema()) {
                    final Schema schema = getSchema(xmlServiceContext.getSchemaURLs());
                    if (schema != null) {
                        unmarshaller.setSchema(schema);
                    }
                }
            } catch (JAXBException e) {
                throw new ConfigurationException("JAXBException creating Unmarshaller.", e);
            }
        } else {
            throw new ConfigurationException("ServiceContext of '" + serviceContext.getClass().getName() + "' not supported; must be an instance of XMLServiceContext.");
        }
        return unmarshaller;
    }

    public Schema getSchema(final List<String> schemaURLs) {
        Schema schema = null;
        if (schemaURLs != null && !schemaURLs.isEmpty()) {
            final List<String> canonicalSchemaURLsList = new ArrayList<>(schemaURLs.size());
            for (final String schemaURL : schemaURLs) {
                canonicalSchemaURLsList.add(canonicalizeSchemaURL(schemaURL));
            }
            Collections.sort(canonicalSchemaURLsList);
            final String schemaURLsCSV = ToolkitHelper.concatenateStrings(canonicalSchemaURLsList, ",");
            if (schemasByCanonicalURLsCSVList.containsKey(schemaURLsCSV)) {
                schema = schemasByCanonicalURLsCSVList.get(schemaURLsCSV);
            } else {
                schema = loadSchema(schemaURLs);
                schemasByCanonicalURLsCSVList.put(schemaURLsCSV, schema);
            }
            LOG.debug("Schema for '" + schemaURLsCSV + "' is " + schema);
        }
        return schema;
    }

    /**
     * Return the 'canonical' schema URL for the provided URL.
     * See {@link SchemeValuePair#setSchemeURIAlias(String, String)} for definition of 'canonical'.
     * @param inSchemaURL a URL as a string
     * @return the 'canonical' URL for the inSchemaURL, or the inSchemaURL if it is not recognized as having an alias
     */
    protected String canonicalizeSchemaURL(final String inSchemaURL) {
        String canonicalSchemaURL = inSchemaURL;
        if (canonicalSchemaURLMap.containsKey(inSchemaURL)) {
            canonicalSchemaURL = canonicalSchemaURLMap.get(inSchemaURL);
        }
        return canonicalSchemaURL;
    }

    /**
     * Get the JAXB package name associated with a XML schema URL.
     * @param schemaURL the XML schema URL
     * @return the package name
     */
    protected String getPackageNameForSchemaURL(final String schemaURL) {
        final String canonicalSchemaURL = canonicalizeSchemaURL(schemaURL);
        return schemaURLsToPackageMap.get(canonicalSchemaURL);
    }

    /**
     * Load the XML Schemas associated with the provider list of URLs.
     * @param schemaURLs the list of XML Schema URLs or resources
     * @return the {@link Schema} that represents the XML schemas
     */
    protected static Schema loadSchema(final List<String> schemaURLs) {
        Schema schema = null;
        if (schemaURLs != null && schemaURLs.size() > 0) {
            final int schemaCount = schemaURLs.size();
            LOG.debug(schemaCount + " schema URLs were found for validating messages.");
            final StreamSource[] schemaSources = new StreamSource[schemaCount];
            try {
                int schemaIndex = 0;
                for (final String schemaURL : schemaURLs) {
                    final StreamSource streamSource;
                    final String systemId;
                    if (schemaURL.startsWith("http")) {
                        LOG.info("Loading schema '" + schemaURL + "' as a network resource.");
                        final URL url = new URL(schemaURL);
                        streamSource = new StreamSource(url.openStream());
                        systemId = url.toURI().toString();
                    } else {
                        LOG.info("Loading schema '" + schemaURL + "' as a resource via ClassLoader or as a file.");
                        streamSource = new StreamSource(ToolkitHelper.getResourceOrFile(schemaURL));
                        systemId = schemaURL;
                    }
                    LOG.info("Setting system id to '" + systemId + "'.");
                    streamSource.setSystemId(systemId);
                    schemaSources[schemaIndex++] = streamSource;
                    LOG.info("Loaded schema '" + schemaURL + "'.");
                }
                final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
                schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                LOG.info("Setting schema sources.");
                schema = schemaFactory.newSchema(schemaSources);
            } catch (SAXException e) {
                LOG.warn("SAXException creating the Schema object for marshaling.", e);
            } catch (MalformedURLException e) {
                LOG.warn("MalformedURLException creating the Schema object for marshaling.", e);
            } catch (URISyntaxException e) {
                LOG.warn("URISyntaxException creating the Schema object for marshaling.", e);
            } catch (IOException e) {
                LOG.warn("IOException creating the Schema object for marshaling.", e);
            }

            if (schema == null) {
                LOG.warn("Schema is null; messages will not be validated against the schema.");
            }
        } else {
            LOG.warn("supportedSchemaURLs is null or the list is empty; messages can not be validated against the schema.");
        }
        return schema;
    }

    /**
     * A namespace prefix mapper that omits the prefix for the target namespace.
     */
    @SuppressWarnings("squid:S1191") // There is no equivalent class in a java or javax package.
    public static class PreferredMapper extends com.sun.xml.bind.marshaller.NamespacePrefixMapper {
        protected final String[] namespaceURIs;
        protected final String defaultNamespace;

        /**
         * Construct an instance of {@link PreferredMapper}.
         * @param serviceContext the {@link XMLServiceContext} for which this mapper is to be used
         */
        @SuppressWarnings("PMD.UselessOperationOnImmutable")
        public PreferredMapper(final XMLServiceContext<ServiceMessage<ServiceInitiationData, ServiceResponseData>, ServiceInitiationData, ServiceResponseData> serviceContext) {
            this.namespaceURIs = serviceContext.getNamespaceURIs();
            for (final String uri : this.namespaceURIs) {
                uri.intern(); // Ignoring the return value is ok - this is done to speed parsing.
            }
            this.defaultNamespace = serviceContext.getDefaultNamespace();
            this.defaultNamespace.intern(); // Ignoring the return value is ok - this is done to speed parsing.
        }

        @Override
        public String getPreferredPrefix(final String namespaceUri, final String suggestion, final boolean requirePrefix) {
            // This approach per https://stackoverflow.com/a/16590616
            if (defaultNamespace != null && defaultNamespace.equals(namespaceUri) && !requirePrefix) {
                return ""; // Omit the prefix for the default namespace.
            }
            // Let JAXB pick a prefix.
            return null;
        }

        @Override
        public String[] getPreDeclaredNamespaceUris() {
            return namespaceURIs.clone();
        }
    }
}
