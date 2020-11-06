/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncipversion;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;

import org.junit.Test;

/**
 * Unit tests of bean classes in this package.
 */
public class TestNonSVPBeans {

    @Test
    public void testLookupVersionInitiationData() {
        assertThat(LookupVersionInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLookupVersionResponseData() {
        assertThat(LookupVersionResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

}
