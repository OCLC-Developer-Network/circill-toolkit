/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.ElectronicAddressType;

import org.apache.log4j.Logger;

/**
 * Codes for {@link ElectronicAddressType} defined in ISO 18626-2017 p. 19.
 */
public class Version2017ElectronicAddressType extends ElectronicAddressType {

    private static final Logger LOG = Logger.getLogger(Version2017ElectronicAddressType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/ElectronicAddressType-V1.0";

    // Chat
    public static final Version2017ElectronicAddressType CHAT = new Version2017ElectronicAddressType(SCHEME, "Chat");

    // Email
    public static final Version2017ElectronicAddressType EMAIL = new Version2017ElectronicAddressType(SCHEME, "Email");

    // File Transfer Protocol
    public static final Version2017ElectronicAddressType FTP = new Version2017ElectronicAddressType(SCHEME, "FTP");

    // Skype
    public static final Version2017ElectronicAddressType SKYPE = new Version2017ElectronicAddressType(SCHEME, "Skype");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017ElectronicAddressType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017ElectronicAddressType(final String scheme, final String value) {
        super(scheme, value);
    }

}
