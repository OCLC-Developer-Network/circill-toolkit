/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples.ncip;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.CancelRequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.CancelRequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestId;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.Version1RequestScopeType;
import org.oclc.circill.toolkit.service.ncip.Version1RequestType;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

/**
 * This class provides a simple NCIP Initiator that sends an item barcode to
 * an NCIP Responder at a target URL and displays the results.
 */
public final class SimpleCancelRequestItemClient extends SimpleNCIPClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleCancelRequestItemClient.class);

    /**
     * Construct an instance of this class and call {@link SimpleNCIPClient#execute(String[])}.
     * @param args command-line arguments
     * @throws IllegalAccessException -
     * @throws InvocationTargetException -
     * @throws InstantiationException -
     * @throws ToolkitException -
     * @throws NoSuchMethodException -
     * @throws ClassNotFoundException -
     */
    public static void main(final String[] args)
        throws IllegalAccessException, InvocationTargetException, InstantiationException, ToolkitException, NoSuchMethodException, ClassNotFoundException {
        final SimpleNCIPClient instance = new SimpleCancelRequestItemClient();
        instance.execute(args);
    }

    @Override
    public NCIPInitiationData buildInitiationData(final String[] params) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {
        final CancelRequestItemInitiationData cancelRequestItemData = new CancelRequestItemInitiationData();
        final RequestId requestId = new RequestId();
        requestId.setRequestIdentifierValue(params[0]);
        cancelRequestItemData.setRequestId(requestId);
        final UserId userId = new UserId();
        userId.setUserIdentifierValue(params[1]);
        cancelRequestItemData.setUserId(userId);
        cancelRequestItemData.setRequestType(Version1RequestType.LOAN);
        cancelRequestItemData.setRequestScopeType(Version1RequestScopeType.ITEM);
        return cancelRequestItemData;
    }

    @Override
    protected void reportSuccess(final NCIPResponseData responseData) {
        final CancelRequestItemResponseData cancelRequestItemResponseData = (CancelRequestItemResponseData) responseData;
        LOG.info("Cancel Request Item succeeded: " + cancelRequestItemResponseData);
        LOG.info("The request id is: " + cancelRequestItemResponseData.getRequestId().getRequestIdentifierValue());
    }
}
