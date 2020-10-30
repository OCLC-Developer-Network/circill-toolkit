/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples.iso18626;

import org.oclc.circill.toolkit.examples.ncip.SimpleNCIPClient;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.iso18626.AgencyId;
import org.oclc.circill.toolkit.service.iso18626.BibliographicInfo;
import org.oclc.circill.toolkit.service.iso18626.Header;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;
import org.oclc.circill.toolkit.service.iso18626.RequestConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.RequestData;
import org.oclc.circill.toolkit.service.iso18626.Version2017AgencyIdType;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * This class provides a simple client that sends a Request message
 * to an ISO 18626 service and displays the results.
 */
public class SimpleRequestClient extends SimpleISOClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleRequestClient.class);

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
        final SimpleISOClient instance = new SimpleRequestClient();
        instance.execute(args);
    }

    @Override
    public ISO18626RequestData buildISO18626RequestData(final String[] params) throws ToolkitException {
        final RequestData requestData = new RequestData();
        final Header header = new Header();
        header.setMultipleItemRequestId("");
        final AgencyId agencyId = new AgencyId();
        agencyId.setAgencyIdValue(params[0]);
        agencyId.setAgencyIdType(Version2017AgencyIdType.ISIL);
        header.setRequestingAgencyId(agencyId);
        header.setRequestingAgencyRequestId(params[1]);
        header.setSupplyingAgencyId(agencyId);
        final Calendar timestamp = Calendar.getInstance();
        timestamp.setTime(new Date());
        header.setTimestamp(timestamp);
        requestData.setHeader(header);
        final BibliographicInfo bibliographicInfo = new BibliographicInfo();
        bibliographicInfo.setTitle(params[2]);
        requestData.setBibliographicInfo(bibliographicInfo);
        return requestData;
    }

    @Override
    protected void reportSuccess(final ISO18626ConfirmationData confirmationData) {
        final RequestConfirmationData requestConfirmationData = (RequestConfirmationData) confirmationData;
        LOG.info("Request succeeded: " + requestConfirmationData);
    }
}
