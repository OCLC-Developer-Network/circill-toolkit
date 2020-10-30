/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.junit.Assert;
import org.junit.Test;

public class TestProblemType {

    final String TEST_VALUE = "Test problem type value";

    @Test
    public void testSchemelessInstance() {

        final ProblemType pt = new ProblemType(TEST_VALUE);
        Assert.assertSame("Problem Type's 'value' passed to constructor should be the same object as is returned by getter.", TEST_VALUE, pt.getValue());
        Assert.assertNull("Scheme should be null (since no Scheme was passed to constructor).", pt.getScheme());
    }
}
