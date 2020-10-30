/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.PaymentMethodType;

import org.apache.log4j.Logger;

/**
 * Codes for {@link PaymentMethodType} defined in ISO 18626-2017 p. 21.
 */
public class Version2017PaymentMethodType extends PaymentMethodType {

    private static final Logger LOG = Logger.getLogger(Version2017PaymentMethodType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/PaymentMethodList-V1.0";

    // Bank Transfer
    public static final Version2017PaymentMethodType BANK_TRANSFER = new Version2017PaymentMethodType(SCHEME, "BankTransfer");

    // Credit Card
    public static final Version2017PaymentMethodType CREDIT_CARD = new Version2017PaymentMethodType(SCHEME, "CreditCard");

    // Debit Card
    public static final Version2017PaymentMethodType DEBIT_CARD = new Version2017PaymentMethodType(SCHEME, "DebitCard");

    // Electronic Fund Transfer System
    public static final Version2017PaymentMethodType EFTS = new Version2017PaymentMethodType(SCHEME, "EFTS"); 

    // Interloan Billing System (New Zealand)
    public static final Version2017PaymentMethodType IBS = new Version2017PaymentMethodType(SCHEME, "IBS"); 

    // International Interloan Billing System (New Zealand)
    public static final Version2017PaymentMethodType IIBS = new Version2017PaymentMethodType(SCHEME, "IIBS"); 

    // IFLA Voucher
    public static final Version2017PaymentMethodType IFLA_VOUCHER = new Version2017PaymentMethodType(SCHEME, "IFLAVoucher");

    // OCLC Fee management system
    public static final Version2017PaymentMethodType IFM = new Version2017PaymentMethodType(SCHEME, "IFM"); 

    // Libraries Australia Payment Service
    public static final Version2017PaymentMethodType LAPS = new Version2017PaymentMethodType(SCHEME, "LAPS"); 

    // Paypal
    public static final Version2017PaymentMethodType PAYPAL = new Version2017PaymentMethodType(SCHEME, "Paypal");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017PaymentMethodType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017PaymentMethodType(final String scheme, final String value) {
        super(scheme, value);
    }

}
