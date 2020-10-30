/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

import java.text.ParseException;

import org.junit.Test;

public class TestAcceptItem {

    @Test
    public void testBasicAccept() throws ServiceException, ToolkitException, ParseException {

        final String[] bibDescriptions = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Fake title", "", "" };

        final NCIPResponseData responseData = (new SendAcceptItem()).performService("dummy agency", "12398191", null, bibDescriptions, null, "NAV123", "230913", null, null);
        System.out.println("Response: " + responseData);

    }

}
