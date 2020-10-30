/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.iso18626;

import org.oclc.circill.toolkit.service.base.BaseTestServiceAPIRules;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.BeansException;

/**
 * Test that classes conform to the rules of the API.
 */
public class TestServiceAPIRules extends BaseTestServiceAPIRules {

    @Test
    public void testAll() throws ToolkitInternalException, NoSuchMethodException, IOException, ClassNotFoundException {
        final Set<Class<? extends Throwable>> setApplicationContextAllowedExceptions = Collections.singleton(BeansException.class);
        final Map<String, Set<Class<? extends Throwable>>> setApplicationContextMethods = Collections.singletonMap("setApplicationContext", setApplicationContextAllowedExceptions);
        final Map<String, Map<String, Set<Class<? extends Throwable>>>> otherAllowedExceptions = new HashMap<>();
        otherAllowedExceptions.put(ISO18626ServiceContextFactory.class.getName(), setApplicationContextMethods);
        testAll(this.getClass().getPackage().getName(), otherAllowedExceptions);
    }
}
