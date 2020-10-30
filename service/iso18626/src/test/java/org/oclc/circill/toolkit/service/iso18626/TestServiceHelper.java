/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BaseTestServiceHelper;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

import org.junit.Test;

/**
 * Unit tests for the ServiceHelper.
 */
public class TestServiceHelper extends BaseTestServiceHelper {
    @Test
    public void testAllBeans()
        throws IOException, ClassNotFoundException, IntrospectionException, IllegalAccessException, InvocationTargetException, InstantiationException, ToolkitException,
        NoSuchMethodException {
        doTests(this.getClass().getPackage().getName(), Collections.emptyMap(), Collections.emptyMap());
    }
}
