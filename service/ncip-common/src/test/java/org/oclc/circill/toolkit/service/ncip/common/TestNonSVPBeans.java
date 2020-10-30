/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip.common;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;

import org.junit.Test;

/**
 * Created by bodfishj on 3/15/18.
 */
public class TestNonSVPBeans {
    @Test
    public void testFromAgencyId() {
        assertThat(FromAgencyId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testInitiationHeader() {
        assertThat(InitiationHeader.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testOnBehalfOfAgency() {
        assertThat(OnBehalfOfAgency.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testResponseHeader() {
        assertThat(ResponseHeader.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testToAgencyId() {
        assertThat(ToAgencyId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

}
