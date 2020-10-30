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

import org.junit.Test;

public class TestRequestItem {

    @Test
    public void testBasicRequest() throws ServiceException, ToolkitException {

        final String oclcNumber = "53934212";
        final String userIdentifier = "367";
        final NCIPResponseData responseData = (new SendRequestItem()).performService("dummy agency", oclcNumber, "oclc", userIdentifier);
        System.out.println("Response: " + responseData);

    }

}
