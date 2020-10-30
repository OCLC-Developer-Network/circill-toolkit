/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.common.base.BaseChainingMessageHandlerAwareServiceContext;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.base.XMLServiceContext;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.common.ApplicationProfileType;

import java.util.List;
import java.util.Map;

/**
 * An extension of {@link BaseChainingMessageHandlerAwareServiceContext} for NCIP messages.
 */
public class NCIPServiceContext
    extends BaseChainingMessageHandlerAwareServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData>
    implements XMLServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> {

    protected DefaultNCIPVersion version;

    protected List<ApplicationProfileType> applicationProfileTypes;
    protected boolean requireApplicationProfileType = false;

    protected String[] namespaceURIs;

    protected String defaultNamespace;

    protected boolean addDefaultNamespace = false;

    protected List<String> schemaURLs;
    protected boolean validateMessagesAgainstSchema = true;

    protected Map<String, Boolean> parserFeatures;

    /**
     * Does this context require an application profile type element?
     * @return true if the context does
     */
    public boolean requiresApplicationProfileType() {

        return requireApplicationProfileType;

    }

    public void setRequireApplicationProfileType(final boolean requireApplicationProfileType) {
        this.requireApplicationProfileType = requireApplicationProfileType;
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

    public List<ApplicationProfileType> getApplicationProfileTypes() {

        return applicationProfileTypes;

    }

    public void setParserFeatures(final Map<String, Boolean> parserFeatures) {
        this.parserFeatures = parserFeatures;
    }

    @Override
    public Map<String, Boolean> getParserFeatures() {

        return parserFeatures;

    }

    public DefaultNCIPVersion getVersion() {
        return version;
    }

    public void setVersion(final DefaultNCIPVersion version) {
        this.version = version;
    }

    @Override
    public void validateBeforeMarshalling(final NCIPMessage<NCIPInitiationData, NCIPResponseData> message) throws ValidationException {
        validate(message);
        if ((message.getVersion() == null || message.getVersion().isEmpty()) && version != null) {
            message.setVersion(version.getVersionAttribute());
        }
        super.validateBeforeMarshalling(message);
    }

    @Override
    public void validateAfterUnmarshalling(final NCIPMessage<NCIPInitiationData, NCIPResponseData> message) throws ValidationException {
        validate(message);
        if ((message.getVersion() == null || message.getVersion().isEmpty()) && version != null) {
            message.setVersion(version.getVersionAttribute());
        }
        super.validateAfterUnmarshalling(message);
    }

    private void validate(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ValidationException {
        try {
            if (ncipMessage.isInitiationMessage()) {
                if (ncipMessage.getInitiationData() == null) {
                    throw new ValidationException("NCIPMessage isInitiationMessage() returned true but getInitiationData() returned null.",
                        Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(), Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null,
                        null);
                }
            } else if (ncipMessage.isResponseMessage()) {
                if (ncipMessage.getResponseData() == null) {
                    throw new ValidationException("NCIPMessage isResponseMessage() returned true but getResponseData() returned null.",
                        Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(), Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null,
                        null);
                }
            } else {
                throw new ValidationException("NCIPMessage isInitiationMessage() and isResponseMessage() both returned false.",
                    Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(), Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null, null);
            }
        } catch (Exception e) {
            throw new ValidationException("Exception validating the message.", Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(),
                Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null, null, e);

        }

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
