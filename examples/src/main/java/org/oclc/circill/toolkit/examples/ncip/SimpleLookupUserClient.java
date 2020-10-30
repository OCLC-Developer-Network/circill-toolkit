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
import org.oclc.circill.toolkit.service.ncip.LookupUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupUserResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

/**
 * This class provides a simple NCIP Initiator that sends an user id to
 * an NCIP Responder at a target URL and displays the results.
 */
public final class SimpleLookupUserClient extends SimpleNCIPClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleLookupUserClient.class);

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
        final SimpleNCIPClient instance = new SimpleLookupUserClient();
        instance.execute(args);
    }

    @Override
    public NCIPInitiationData buildInitiationData(final String[] params) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {
        final LookupUserInitiationData lookupUserData = new LookupUserInitiationData();
        final InitiationHeader initHeader = new InitiationHeader();
        lookupUserData.setInitiationHeader(initHeader);
        final AgencyId agencyId;
        if (params.length > 1) {
            agencyId = new AgencyId(params[1]);
        } else {
            agencyId = new AgencyId("1");
        }
        final ToAgencyId toAgencyId = new ToAgencyId();
        toAgencyId.setAgencyId(agencyId);
        initHeader.setToAgencyId(toAgencyId);
        final FromAgencyId fromAgencyId = new FromAgencyId();
        fromAgencyId.setAgencyId(agencyId);
        initHeader.setFromAgencyId(fromAgencyId);

        final UserId userId = new UserId(); //the server side UserId class
        userId.setUserIdentifierValue(params[0]);
        userId.setAgencyId(agencyId);
        lookupUserData.setUserId(userId);

        lookupUserData.setLoanedItemsDesired(true);
        lookupUserData.setRequestedItemsDesired(true);
        lookupUserData.setUserFiscalAccountDesired(true);
        return lookupUserData;
    }

    @Override
    protected void reportSuccess(final NCIPResponseData responseData) {
        final LookupUserResponseData lookupUserResponseData = (LookupUserResponseData) responseData;
        LOG.info("Lookup User succeeded: " + lookupUserResponseData);
        LOG.info("The User id is: " + lookupUserResponseData.getUserId().getUserIdentifierValue());
    }
}
