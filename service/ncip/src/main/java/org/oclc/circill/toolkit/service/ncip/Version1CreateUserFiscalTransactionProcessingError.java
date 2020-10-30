/*
 * Copyright (c) 2018 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.log4j.Logger;

/**
 * The NCIP Create User Fiscal Transaction Processing Error Scheme.
 */
public class Version1CreateUserFiscalTransactionProcessingError extends ProblemType {

    private static final Logger LOG = Logger.getLogger(Version1CreateUserFiscalTransactionProcessingError.class);

    public static final String VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR
        = "http://www.niso.org/ncip/v1_0/schemes/processingerrortype/createuserfiscaltransactionprocessingerror.scm";

    public static final Version1CreateUserFiscalTransactionProcessingError ACCOUNT_ACCESS_DENIED = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "Account Access Denied");

    public static final Version1CreateUserFiscalTransactionProcessingError DUPLICATE_FISCAL_TRANSACTION = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "Duplicate Fiscal Transaction");

    public static final Version1CreateUserFiscalTransactionProcessingError ELEMENT_RULE_VIOLATED = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "Element Rule Violated");

    public static final Version1CreateUserFiscalTransactionProcessingError UNABLE_TO_ADD_ELEMENT = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "Unable To Add Element");

    public static final Version1CreateUserFiscalTransactionProcessingError UNKNOWN_ITEM = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "Unknown Item");

    public static final Version1CreateUserFiscalTransactionProcessingError UNKNOWN_REQUEST = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "Unknown Request");

    public static final Version1CreateUserFiscalTransactionProcessingError UNKNOWN_USER = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "Unknown User");

    public static final Version1CreateUserFiscalTransactionProcessingError USER_ACCESS_DENIED = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "User Access Denied");

    public static final Version1CreateUserFiscalTransactionProcessingError USER_AUTHENTICATION_FAILED = new Version1CreateUserFiscalTransactionProcessingError(
        VERSION_1_CREATE_USER_FISCAL_TRANSACTION_PROCESSING_ERROR, "User Authentication Failed");

    public static void loadAll() {
        LOG.debug("Loading Version1CreateUserFiscalTransactionProcessingError.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    public Version1CreateUserFiscalTransactionProcessingError(final String scheme, final String value) {
        super(scheme, value);
    }
}

