/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.util.List;
import java.util.Map;

/**
 * A {@link ServiceContext} for services which are represented in XML.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public interface XMLServiceContext<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> extends ServiceContext<SM, ID, RD> {
    /**
     * Get the URLs of the XML Schema documents for this service.
     * @return a list of URLs as Strings
     */
    List<String> getSchemaURLs();

    /**
     * Whether to validate messages against the XML Schemas.
     * @return true if validation should be performed
     */
    boolean validateMessagesAgainstSchema();

    /**
     * Get the XML namespace URIs for this service's XML schema.
     * @return the URIs as Strings
     */
    String[] getNamespaceURIs();

    /**
     * Get the default XML namespace URI for this service.
     * @return the URI as a String
     */
    String getDefaultNamespace();

    /**
     * Whether to add the default XML namespace to outgoing messages.
     * @return true if the namespace should be added
     */
    boolean addDefaultNamespace();

    /**
     * Get the map of parser features.
     * The values are parser-dependent.
     * @return the features
     */
    Map<String, Boolean> getParserFeatures();
}
