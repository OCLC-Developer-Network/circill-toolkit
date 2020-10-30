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
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.Version1RequestScopeType;
import org.oclc.circill.toolkit.service.ncip.Version1RequestType;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * This class provides a simple NCIP Initiator that sends an item barcode to
 * an NCIP Responder at a target URL (e.g. http://localhost:8080/ncip/responder) and displays the results.
 */
public final class SimpleRequestItemClient extends SimpleNCIPClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleRequestItemClient.class);

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
        final SimpleNCIPClient instance = new SimpleRequestItemClient();
        instance.execute(args);
    }

    @Override
    public NCIPInitiationData buildInitiationData(final String[] params) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {

        final RequestItemInitiationData requestItemData = new RequestItemInitiationData();
        final AgencyId agencyId = new AgencyId("scheme", "2445");
        final InitiationHeader initHdr = new InitiationHeader();
        final ToAgencyId toAgencyId = new ToAgencyId();
        toAgencyId.setAgencyId(agencyId);
        initHdr.setToAgencyId(toAgencyId);
        final FromAgencyId fromAgencyId = new FromAgencyId();
        fromAgencyId.setAgencyId(agencyId);
        initHdr.setFromAgencyId(fromAgencyId);
        requestItemData.setInitiationHeader(initHdr);
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue(params[0]);
        final List<ItemId> itemIdList = new ArrayList<>();
        itemIdList.add(itemId);
        requestItemData.setItemIds(itemIdList);
        final UserId userId = new UserId();
        userId.setUserIdentifierValue(params[1]);
        requestItemData.setUserId(userId);
        requestItemData.setRequestType(Version1RequestType.LOAN);
        requestItemData.setRequestScopeType(Version1RequestScopeType.ITEM);
        return requestItemData;
    }

    @Override
    protected void reportSuccess(final NCIPResponseData responseData) {
        final RequestItemResponseData requestItemResponseData = (RequestItemResponseData) responseData;
        LOG.info("Request Item succeeded: " + requestItemResponseData);
        LOG.info("The request id is: " + requestItemResponseData.getRequestId().getRequestIdentifierValue());
    }
}
