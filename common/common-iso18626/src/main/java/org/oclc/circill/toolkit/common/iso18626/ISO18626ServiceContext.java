/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.iso18626;

import org.oclc.circill.toolkit.common.base.ChainingServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.base.XMLServiceContext;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * An implementation of {@link XMLServiceContext} and {@link ChainingServiceContext} for ISO18626 messages.
 */
public class ISO18626ServiceContext implements XMLServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>,
    ChainingServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> {

    /**
     * The namespace URIs for the XML schema(s).
     */
    protected String[] namespaceURIs;

    /**
     * The default XML namespace.
     */
    protected String defaultNamespace;

    /**
     * Whether to add the default namespace.
     */
    protected boolean addDefaultNamespace = false;

    /**
     * The known XML schema URLs.
     */
    protected List<String> schemaURLs = Collections.singletonList("http://illtransactions.org/schemas/ISO-18626-v1_2.xsd");

    /**
     * Validate ISO 18626 messages against the ISO 18626 Schema.
     */
    protected boolean validateMessagesAgainstSchema = true;

    /**
     * The ISO 18626 version supported in this context.
     */
    protected String version;

    /**
     * The 'chained' service contexts.
     */
    protected List<ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>> serviceContexts = new ArrayList<>(
        0);

    /** Set the array of XML namespace URIs for this service invocation.
     * @param namespaceURIs an array of namespace URIs
     */
    public void setNamespaceURIs(final String[] namespaceURIs) {
        this.namespaceURIs = namespaceURIs.clone();
    }

    /** Get the array of XML namespace URIs for this service invocation.
     * @return an array of namespace URIs
     */
    @Override
    public String[] getNamespaceURIs() {

        return namespaceURIs.clone();

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
        this.schemaURLs = Collections.unmodifiableList(schemaURLs);
    }

    @Override
    public List<String> getSchemaURLs() {
        //noinspection AssignmentOrReturnOfFieldWithMutableType
        return schemaURLs;
    }

    @Override
    public boolean validateMessagesAgainstSchema() {
        return validateMessagesAgainstSchema;
    }

    public void setValidateMessagesAgainstSchema(final boolean value) {
        this.validateMessagesAgainstSchema = value;
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

    @Override
    public Map<String, Boolean> getParserFeatures() {
        return null;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    @Override
    public void validateBeforeMarshalling(final ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> message) throws ValidationException {
        if ((message.getVersion() == null || message.getVersion().isEmpty()) && getVersion() != null) {
            message.setVersion(getVersion());
        }
    }

    @Override
    public void validateAfterUnmarshalling(final ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> message) throws ValidationException {
        if ((message.getVersion() == null || message.getVersion().isEmpty()) && getVersion() != null) {
            message.setVersion(getVersion());
        }
    }

    @Override
    public List<ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>> getServiceContexts() {
        //noinspection AssignmentOrReturnOfFieldWithMutableType
        return serviceContexts;
    }

    @Override
    public void setServiceContexts(
        final List<ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>> serviceContexts) {
        this.serviceContexts = Collections.unmodifiableList(serviceContexts);
    }

    @Override
    public void appendServiceContext(
        final ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> serviceContext) {
        serviceContexts.add(serviceContext);
    }

}
