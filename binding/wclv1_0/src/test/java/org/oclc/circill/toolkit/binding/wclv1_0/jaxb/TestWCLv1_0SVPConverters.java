/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0.jaxb;

import org.oclc.circill.toolkit.binding.jaxb.BaseTestSVPConverters;
import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Test JAXB-SchemeValuePair Dozer converters.
 */
@RunWith(Parameterized.class)
public class TestWCLv1_0SVPConverters extends BaseTestSVPConverters {

    private static final String[] SERVICE_PACKAGE_NAMES = { NCIPMessage.class.getPackage().getName(), // From service.ncip package
        AgencyId.class.getPackage().getName(),    // From service.common package
        CurrencyCode.class.getPackage().getName() // From service.base package
    };

    public TestWCLv1_0SVPConverters(final Class converterClass, final String packageName)
        throws IllegalAccessException, InvocationTargetException, InstantiationException, ToolkitException, NoSuchMethodException, ClassNotFoundException {
        super(converterClass, packageName, SERVICE_PACKAGE_NAMES);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest()
        throws ToolkitException, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        return BaseTestSVPConverters.instancesToTest(TestWCLv1_0SVPConverters.class.getPackage().getName());
    }
}
