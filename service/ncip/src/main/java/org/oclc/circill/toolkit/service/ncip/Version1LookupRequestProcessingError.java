/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.log4j.Logger;

public class Version1LookupRequestProcessingError extends ProblemType {

    private static final Logger LOG = Logger.getLogger(Version1LookupRequestProcessingError.class);

    public static final String VERSION_1_LOOKUP_REQUEST_PROCESSING_ERROR = "http://www.niso.org/ncip/v1_0/schemes/processingerrortype/lookuprequestprocessingerror.scm";

    public static final Version1LookupRequestProcessingError NON_UNIQUE_REQUEST = new Version1LookupRequestProcessingError(VERSION_1_LOOKUP_REQUEST_PROCESSING_ERROR,
        "Non-Unique Request");

    public static final Version1LookupRequestProcessingError UNKNOWN_REQUEST = new Version1LookupRequestProcessingError(VERSION_1_LOOKUP_REQUEST_PROCESSING_ERROR,
        "Unknown Request");

    public static void loadAll() {
        LOG.debug("Loading Version1LookupRequestProcessingError.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    public Version1LookupRequestProcessingError(final String scheme, final String value) {
        super(scheme, value);
    }
}
