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
import org.oclc.circill.toolkit.service.ncip.AcceptItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.AcceptItemResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestId;
import org.oclc.circill.toolkit.service.ncip.Version1RequestedActionType;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

/**
 * This class provides a simple NCIP Initiator that sends an item barcode to
 * an NCIP Responder at a target URL and displays the results.
 */
public final class SimpleAcceptItemClient extends SimpleNCIPClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleAcceptItemClient.class);

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
        final SimpleNCIPClient instance = new SimpleAcceptItemClient();
        instance.execute(args);
    }

    @Override
    public NCIPInitiationData buildInitiationData(final String[] params) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {
        final AcceptItemInitiationData acceptItemData = new AcceptItemInitiationData();
        final InitiationHeader initHdr = new InitiationHeader();
        final AgencyId agencyId = new AgencyId("test agency", "test scheme");
        final ToAgencyId toAgencyId = new ToAgencyId();
        final FromAgencyId fromAgencyId = new FromAgencyId();
        toAgencyId.setAgencyId(agencyId);
        fromAgencyId.setAgencyId(agencyId);
        initHdr.setToAgencyId(toAgencyId);
        initHdr.setFromAgencyId(fromAgencyId);
        acceptItemData.setInitiationHeader(initHdr);
        final RequestId requestId = new RequestId();
        requestId.setAgencyId(agencyId);
        requestId.setRequestIdentifierValue(params[0]);
        acceptItemData.setRequestId(requestId);
        acceptItemData.setRequestedActionType(Version1RequestedActionType.CIRCULATE_AND_NOTIFY);
        return acceptItemData;
    }

    @Override
    protected void reportSuccess(final NCIPResponseData responseData) {
        final AcceptItemResponseData acceptItemResponseData = (AcceptItemResponseData) responseData;
        LOG.info("Accept Item succeeded: " + acceptItemResponseData);
    }
}
