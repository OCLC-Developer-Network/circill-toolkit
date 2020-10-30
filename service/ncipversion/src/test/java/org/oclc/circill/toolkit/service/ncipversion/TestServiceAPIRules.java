/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncipversion;

import org.oclc.circill.toolkit.service.base.BaseTestServiceAPIRules;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import java.io.IOException;

import org.junit.Test;

/**
 * Test that classes conform to the rules of the API.
 */
public class TestServiceAPIRules extends BaseTestServiceAPIRules {

    @Test
    public void testAll() throws ToolkitInternalException, NoSuchMethodException, IOException, ClassNotFoundException {
        testAll(this.getClass().getPackage().getName());
    }
}
