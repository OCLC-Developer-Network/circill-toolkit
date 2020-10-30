/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncipversion;

import org.oclc.circill.toolkit.common.base.BaseChainingMessageHandlerAwareServiceContext;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.base.XMLServiceContext;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionInitiationData;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionResponseData;
import org.oclc.circill.toolkit.service.ncipversion.NCIPVersionMessage;

import java.util.List;
import java.util.Map;

/**
 * This validates NCIP LookupVersion messages.
 * Note: Presently there is no validation performed.
 */
public class NCIPVersionServiceContext extends
    BaseChainingMessageHandlerAwareServiceContext<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData,
        LookupVersionResponseData>
    implements XMLServiceContext<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> {

    private static final String VERSION_ATTRIBUTE = "http://www.niso.org/ncip/v1_0/imp1/xsd/ncip_version.xsd";
    protected String[] namespaceURIs;

    protected String defaultNamespace;

    protected boolean addDefaultNamespace = false;

    protected List<String> schemaURLs;
    protected boolean validateMessagesAgainstSchema = true;

    protected Map<String, Boolean> parserFeatures;

    /**
     * Construct an instance with default values.
     */
    public NCIPVersionServiceContext() {
        // Configure via dependency injection
    }

    /**
     * Set the addDefaultNamespace flag.
     * @param addDefaultNamespace whether to add the default namespace to messages when marshalling them
     */
    public void setAddDefaultNamespace(final boolean addDefaultNamespace) {
        this.addDefaultNamespace = addDefaultNamespace;
    }

    @Override
    public boolean addDefaultNamespace() {
        return addDefaultNamespace;
    }

    public void setParserFeatures(final Map<String, Boolean> parserFeatures) {
        this.parserFeatures = parserFeatures;
    }

    @Override
    public Map<String, Boolean> getParserFeatures() {
        return parserFeatures;
    }

    @Override
    public void validateBeforeMarshalling(final NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> message) throws ValidationException {
        if ((message.getVersion() == null || message.getVersion().isEmpty())) {
            message.setVersion(VERSION_ATTRIBUTE);
        }
        super.validateBeforeMarshalling(message);
    }

    @Override
    public void validateAfterUnmarshalling(final NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData> message) throws ValidationException {
        if ((message.getVersion() == null || message.getVersion().isEmpty())) {
            message.setVersion(VERSION_ATTRIBUTE);
        }
        super.validateAfterUnmarshalling(message);
    }

    /** Set the array of XML namespace URIs for this service invocation.
     * @param namespaceURIs an array of namespace URIs
     */
    public void setNamespaceURIs(final String[] namespaceURIs) {
        this.namespaceURIs = namespaceURIs;
    }

    /** Get the array of XML namespace URIs for this service invocation.
     * @return an array of namespace URIs
     */
    @Override
    public String[] getNamespaceURIs() {
        return namespaceURIs;
    }

    /**
     * Set the default namespace, if any, for this service invocation.
     * @param defaultNamespace the default namespace or null
     */
    public void setDefaultNamespace(final String defaultNamespace) {
        this.defaultNamespace = defaultNamespace;
    }

    /**
     * The default namespace, if any, for this service invocation.
     * @return the default namespace or null
     */
    @Override
    public String getDefaultNamespace() {
        return defaultNamespace;
    }

    public void setSchemaURLs(final List<String> schemaURLs) {
        this.schemaURLs = schemaURLs;
    }

    @Override
    public List<String> getSchemaURLs() {
        return schemaURLs;
    }

    @Override
    public boolean validateMessagesAgainstSchema() {
        return validateMessagesAgainstSchema;
    }

    public void setValidateMessagesAgainstSchema(final boolean value) {
        this.validateMessagesAgainstSchema = value;
    }
}
