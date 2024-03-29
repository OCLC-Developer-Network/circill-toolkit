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

public class TestCheckInItem {

    @Test
    public void testBasicCheckin() throws ServiceException, ToolkitException {

        final String itemIdentifier = "abc";
        final NCIPResponseData responseData = (new SendCheckInItem()).performService(itemIdentifier);
        System.out.println("Response: " + responseData);

    }

}
