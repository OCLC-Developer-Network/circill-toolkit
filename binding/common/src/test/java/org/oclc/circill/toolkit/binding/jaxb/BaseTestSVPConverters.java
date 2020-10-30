/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb;

import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseSchemeValuePairConverter;
import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.SchemeValueBehavior;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.SchemeValuePairHelper;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runners.Parameterized;

/**
 * A base class for testing JAXB-SchemeValuePair Dozer converters.
 */
public abstract class BaseTestSVPConverters<JAXBSVP> {

    private static final String SCHEME_URI = "info://" + BaseTestSVPConverters.class.getName();
    private static final String VALUE1 = BaseTestSVPConverters.class.getName() + " Value 1";
    private static final String VALUE2 = BaseTestSVPConverters.class.getName() + " Value 2";

    protected final BaseSchemeValuePairConverter svpConverter;
    protected final Method convertToMethod;
    protected final Method convertFromMethod;
    protected final SchemeValuePair svpObj;
    protected final SchemeValuePair otherSVPObj;
    protected final Class jaxbSVPClass;
    protected final JAXBSVP jaxbSVPObj;
    protected final JAXBSVP otherJAXBSVPObj;

    public BaseTestSVPConverters(final Class converterClass, final String jaxbPackageName, final String[] servicePackageNames)
        throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, ToolkitException, InvocationTargetException {
        final String svpName = converterClass.getSimpleName().replace("SchemeValuePairConverter", "");
        final Class<? extends SchemeValuePair> svpClass = ReflectionHelper.findClass(svpName, servicePackageNames).asSubclass(SchemeValuePair.class);
        final Method mapBehaviorMethod = svpClass.getMethod("mapBehavior", String.class, SchemeValueBehavior.class);
        mapBehaviorMethod.invoke(null, svpClass.getName(), SchemeValueBehavior.ALLOW_ANY);
        svpObj = makeSVPObj(converterClass.getSimpleName(), svpClass, SCHEME_URI, VALUE1);
        otherSVPObj = makeSVPObj(converterClass.getSimpleName(), svpClass, SCHEME_URI, VALUE2);

        svpConverter = (BaseSchemeValuePairConverter) converterClass.newInstance();
        convertToMethod = converterClass.getMethod("convertTo", Object.class, Object.class);
        convertFromMethod = converterClass.getMethod("convertFrom", Object.class, Object.class);
        jaxbSVPClass = Class.forName(jaxbPackageName + ".elements.SchemeValuePair");
        jaxbSVPObj = (JAXBSVP) JAXBHelper.createJAXBSchemeValuePair(jaxbSVPClass, SCHEME_URI, VALUE1);
        otherJAXBSVPObj = (JAXBSVP) JAXBHelper.createJAXBSchemeValuePair(jaxbSVPClass, SCHEME_URI, VALUE2);

    }

    private static SchemeValuePair makeSVPObj(final String converterClassName, final Class svpClass, final String schemeURI, final String value) throws ToolkitException {
        final SchemeValuePair svpObject;
        if (converterClassName.compareToIgnoreCase("CurrencyCodeSchemeValuePairConverter") != 0) {
            svpObject = SchemeValuePairHelper.findSchemeValuePair(svpClass, schemeURI, value);
        } else {
            // The first time through the findSchemeValuePair will fail to create the CurrencyCode instance because
            // the CurrencyCode constructor requires three parameters; it will then directly call the constructor.
            // On subsequent passes, the findSchemeValuePair will work.
            // This is necessitated by the requirements of the test_MatchingSVCResult which expects the object
            // instances to be the same.
            SchemeValuePair tempSVPObj;
            try {
                tempSVPObj = SchemeValuePairHelper.findSchemeValuePair(svpClass, schemeURI, value);
            } catch (ToolkitException e) {
                tempSVPObj = new CurrencyCode(SCHEME_URI, value, 0);
            }
            svpObject = tempSVPObj;
        }
        return svpObject;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest(final String packageName)
        throws ToolkitException, IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        final List<Class<BaseSchemeValuePairConverter>> classes = ReflectionHelper
            .findClassesInPackage(packageName + ".dozer", ".*\\.[^.]+SchemeValuePairConverter$", null, BaseSchemeValuePairConverter.class);
        final List<Object[]> testValuesList = new ArrayList<>(classes.size());
        for (final Class converterClass : classes) {
            if (BaseSchemeValuePairConverter.class.isAssignableFrom(converterClass) && BaseSchemeValuePairConverter.class != converterClass && !converterClass.isInterface()) {
                testValuesList.add(new Object[] { converterClass, packageName });
            }
        }

        return testValuesList;
    }

    @Test
    public void testConvertTo_NullSourceAndDestination() throws InvocationTargetException, IllegalAccessException {
        final Object bothNullResult = convertToMethod.invoke(svpConverter, null, null);
        assertThat(bothNullResult, is(nullValue()));
    }

    @Test
    public void testConvertTo_NullDestination() throws InvocationTargetException, IllegalAccessException {
        final SchemeValuePair fromNullSVCResult = (SchemeValuePair) convertToMethod.invoke(svpConverter, jaxbSVPObj, null);
        assertThat(fromNullSVCResult, is(equalTo(svpObj)));
    }

    @Test
    public void testConvertTo_NonNullMatchingDestination() throws InvocationTargetException, IllegalAccessException {
        final SchemeValuePair matchingSVCResult = (SchemeValuePair) convertToMethod.invoke(svpConverter, jaxbSVPObj, svpObj);
        assertThat(matchingSVCResult, is(svpObj));
    }

    @Test
    public void testConvertTo_NonNullNonMatchingDestination() throws InvocationTargetException, IllegalAccessException {
        final SchemeValuePair nonMatchingSVCResult = (SchemeValuePair) convertToMethod.invoke(svpConverter, jaxbSVPObj, otherSVPObj);
        assertThat(nonMatchingSVCResult, is(not(otherSVPObj)));
        assertThat(nonMatchingSVCResult, is(svpObj));
    }

    @Test(expected = InvocationTargetException.class)
    public void testConvertTo_NullSourceNonNullDestination() throws InvocationTargetException, IllegalAccessException {
        convertToMethod.invoke(svpConverter, null, svpObj);
    }

    @Test
    public void testConvertFrom_NullSourceAndDestination() throws InvocationTargetException, IllegalAccessException {
        final JAXBSVP newJAXBSVPObj = (JAXBSVP) convertFromMethod.invoke(svpConverter, null, null);
        assertThat(newJAXBSVPObj, is(nullValue()));
    }

    @Test
    public void testConvertFrom_NullDestination() throws InvocationTargetException, IllegalAccessException {
        final JAXBSVP newJAXBSVPObj = (JAXBSVP) convertFromMethod.invoke(svpConverter, svpObj, null);
        assertThat(JAXBHelper.getScheme(newJAXBSVPObj), is(equalTo(svpObj.getScheme())));
        assertThat(JAXBHelper.getValue(newJAXBSVPObj), is(equalTo(svpObj.getValue())));
    }

    @Test
    public void testConvertFrom_NonNullMatchingDestination() throws InvocationTargetException, IllegalAccessException {
        final JAXBSVP newJAXBSVPObj = (JAXBSVP) convertFromMethod.invoke(svpConverter, svpObj, jaxbSVPObj);
        assertThat(JAXBHelper.getScheme(newJAXBSVPObj), is(equalTo(svpObj.getScheme())));
        assertThat(JAXBHelper.getValue(newJAXBSVPObj), is(equalTo(svpObj.getValue())));
    }

    @Test
    public void testConvertFrom_NonNullNonMatchingDestination() throws InvocationTargetException, IllegalAccessException {
        final JAXBSVP newJAXBSVPObj = (JAXBSVP) convertFromMethod.invoke(svpConverter, svpObj, otherJAXBSVPObj);
        assertThat(JAXBHelper.getValue(newJAXBSVPObj), is(not(otherSVPObj.getValue())));
        assertThat(JAXBHelper.getScheme(newJAXBSVPObj), is(equalTo(svpObj.getScheme())));
        assertThat(JAXBHelper.getValue(newJAXBSVPObj), is(equalTo(svpObj.getValue())));
    }

    @Test(expected = InvocationTargetException.class)
    public void testConvertFrom_NullSourceNonNullDestination() throws InvocationTargetException, IllegalAccessException {
        convertFromMethod.invoke(svpConverter, null, svpObj);
    }

}
