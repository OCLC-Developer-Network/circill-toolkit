/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy.web;

import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.iso18626.AgencyId;
import org.oclc.circill.toolkit.service.iso18626.BibliographicInfo;
import org.oclc.circill.toolkit.service.iso18626.Header;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.RequestData;
import org.oclc.circill.toolkit.service.iso18626.Version2017AgencyIdType;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Integration tests for ISO 18626's Request message.
 */
public class ISO18626RequestClientTest extends ISO18626ClientTestBase {

    private static final Logger LOG = Logger.getLogger(ISO18626RequestClientTest.class);

    @Test
    public void sendMessage_ExpectOK() throws ToolkitException, IOException {
        LOG.debug("Entered DummyResponderTestISO18626Request.sendMessage_ExpectOK");

        final RequestData requestData = new RequestData();
        final Header header = new Header();
        header.setMultipleItemRequestId("");
        final AgencyId agencyId = new AgencyId();
        agencyId.setAgencyIdValue("oclc-NDOSU");
        agencyId.setAgencyIdType(Version2017AgencyIdType.ISIL);
        header.setRequestingAgencyId(agencyId);
        header.setRequestingAgencyRequestId("1");
        header.setSupplyingAgencyId(agencyId);
        final Calendar timestamp = Calendar.getInstance();
        timestamp.setTime(new Date());
        header.setTimestamp(timestamp);
        requestData.setHeader(header);
        final BibliographicInfo bibliographicInfo = new BibliographicInfo();
        bibliographicInfo.setTitle("Test title.");
        requestData.setBibliographicInfo(bibliographicInfo);

        final ISO18626ConfirmationData confirmationData = sendMessage(requestData);

        assertNull(confirmationData.getErrorData());

        LOG.debug("Leaving DummyResponderTestISO18626Request.sendMessage_ExpectOK");
    }

}
