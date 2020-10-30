/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy.web;

import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.LookupItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by bodfishj on 10/18/17.
 */
public class NCIPLookupItemClientTest extends NCIPClientTestBase {

    private static final Logger LOG = Logger.getLogger(NCIPLookupItemClientTest.class);

    @Test
    public void sendMessage_ExpectUnsupportedService() throws ToolkitException, IOException {
        LOG.debug("Entered DummyResponderTestLookupItem.sendMessage_ExpectUnsupportedService");

        final AgencyId agencyId = new AgencyId("NDOSU");
        final LookupItemInitiationData initData = new LookupItemInitiationData();
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue("25556192919132");
        itemId.setAgencyId(agencyId);
        initData.setItemId(itemId);
        initData.setBibliographicDescriptionDesired(true);
        initData.setCirculationStatusDesired(true);
        initData.setItemDescriptionDesired(true);
        initData.setLocationDesired(true);
        initData.setCurrentBorrowerDesired(true);

        final NCIPResponseData responseData = sendMessage(initData);

        assertEquals(1, responseData.getProblems().size());
        assertEquals(Version1GeneralProcessingError.UNSUPPORTED_SERVICE, responseData.getProblems().get(0).getProblemType());

        LOG.debug("Leaving DummyResponderTestLookupItem.sendMessage_ExpectUnsupportedService");
    }

}
