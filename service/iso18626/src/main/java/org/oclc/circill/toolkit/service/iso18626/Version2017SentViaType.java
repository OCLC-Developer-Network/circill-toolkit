/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.log4j.Logger;

/**
 * Codes for {@link SentViaType} defined in ISO 18626-2017 p. 22.
 */
public class Version2017SentViaType extends SentViaType {

    private static final Logger LOG = Logger.getLogger(Version2017SentViaType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/SentViaList-V1.0";

    // Article Exchange
    public static final Version2017SentViaType ARTICLE_EXCHANGE = new Version2017SentViaType(SCHEME, "ArticleExchange");
    // Ariel
    public static final Version2017SentViaType ARIEL = new Version2017SentViaType(SCHEME, "Ariel");
    // Email
    public static final Version2017SentViaType EMAIL = new Version2017SentViaType(SCHEME, "Email");
    // Mail
    public static final Version2017SentViaType MAIL = new Version2017SentViaType(SCHEME, "Mail");
    // Odyssey
    public static final Version2017SentViaType ODYSSEY = new Version2017SentViaType(SCHEME, "Odyssey");
    // Website to download from
    public static final Version2017SentViaType URL = new Version2017SentViaType(SCHEME, "URL");
    // FTP – File Transfer Protocol
    public static final Version2017SentViaType FTP = new Version2017SentViaType(SCHEME, "FTP");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017SentViaType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017SentViaType(final String scheme, final String value) {
        super(scheme, value);
    }

}
