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

public class TestCancelRequestItem {

    @Test
    public void test() throws ServiceException, ToolkitException {

        final String reservationId = "1123";
        final NCIPResponseData responseData = (new SendCancelRequestItem()).performService("dummy agency", reservationId);
        System.out.println("Response: " + responseData);

    }

}
