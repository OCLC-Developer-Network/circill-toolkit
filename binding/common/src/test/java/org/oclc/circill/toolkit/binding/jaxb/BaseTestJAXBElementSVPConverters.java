/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb;

import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseJAXBElementSchemeValuePairConverter;
import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.SchemeValueBehavior;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.SchemeValuePairHelper;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import javax.xml.bind.JAXBElement;
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
public abstract class BaseTestJAXBElementSVPConverters {

    private static final String SCHEME_URI = "info://" + BaseTestJAXBElementSVPConverters.class.getName();
    private static final String VALUE1 = BaseTestJAXBElementSVPConverters.class.getName() + " Value 1";
    private static final String VALUE2 = BaseTestJAXBElementSVPConverters.class.getName() + " Value 2";

    protected final BaseJAXBElementSchemeValuePairConverter jaxbElementSchemeValuePairConverter;
    protected final Method jaxbElementConvertToMethod;
    protected final Method jaxbElementConvertFromMethod;
    protected final SchemeValuePair svpObj;
    protected final SchemeValuePair otherSVPObj;
    protected final Class jaxbSVPClass;
    protected final JAXBElement jaxbElement;

    public BaseTestJAXBElementSVPConverters(final Class converterClass, final String packageName, final String[] servicePackageNames)
        throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, ToolkitException, InvocationTargetException {
        final String svpName = converterClass.getSimpleName().replace("JAXBElementSchemeValuePairConverter", "");
        final Class<? extends SchemeValuePair> svpClass = ReflectionHelper.findClass(svpName, servicePackageNames).asSubclass(SchemeValuePair.class);
        final Method mapBehaviorMethod = svpClass.getMethod("mapBehavior", String.class, SchemeValueBehavior.class);
        mapBehaviorMethod.invoke(null, svpClass.getName(), SchemeValueBehavior.ALLOW_ANY);
        svpObj = makeSVPObj(converterClass.getSimpleName(), svpClass, SCHEME_URI, VALUE1);
        otherSVPObj = makeSVPObj(converterClass.getSimpleName(), svpClass, SCHEME_URI, VALUE2);

        jaxbElementSchemeValuePairConverter = (BaseJAXBElementSchemeValuePairConverter) converterClass.newInstance();
        jaxbElementConvertToMethod = converterClass.getMethod("convertTo", Object.class, Object.class);
        jaxbElementConvertFromMethod = converterClass.getMethod("convertFrom", Object.class, Object.class);
        jaxbSVPClass = Class.forName(packageName + ".elements.SchemeValuePair");
        final Object jaxbSVP = JAXBHelper.createJAXBSchemeValuePair(jaxbSVPClass, SCHEME_URI, VALUE1);
        final Class objectFactoryClass = Class.forName(packageName + ".elements.ObjectFactory");
        final Object objectFactory = objectFactoryClass.newInstance();
        final Method jaxbElementCreateMethod = objectFactoryClass.getMethod("create" + svpName, jaxbSVPClass);
        jaxbElement = (JAXBElement) jaxbElementCreateMethod.invoke(objectFactory, jaxbSVP);

    }

    private static SchemeValuePair makeSVPObj(final String converterClassName, final Class svpClass, final String schemeURI, final String value) throws ToolkitException {
        final SchemeValuePair svpObject;
        if (converterClassName.compareToIgnoreCase("CurrencyCodeJAXBElementSchemeValuePairConverter") != 0) {
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
        final List<Class<BaseJAXBElementSchemeValuePairConverter>> classes = ReflectionHelper.findClassesInPackage(packageName + ".dozer", ".*\\.[^.]+JAXBElementSchemeValuePairConverter$", null, BaseJAXBElementSchemeValuePairConverter.class);
        final List<Object[]> testValuesList = new ArrayList<>(classes.size());
        for (final Class<BaseJAXBElementSchemeValuePairConverter> converterClass : classes) {
            if (BaseJAXBElementSchemeValuePairConverter.class.isAssignableFrom(converterClass) && BaseJAXBElementSchemeValuePairConverter.class != converterClass && !converterClass
                .isInterface()) {
                testValuesList.add(new Object[] { converterClass, packageName });
            }
        }

        return testValuesList;
    }

    @Test
    public void testConvertTo_NullSourceAndDestination() throws InvocationTargetException, IllegalAccessException {
        final Object bothNullResult = jaxbElementConvertToMethod.invoke(jaxbElementSchemeValuePairConverter, null, null);
        assertThat(bothNullResult, is(nullValue()));
    }

    @Test
    public void testConvertTo_NullDestination() throws InvocationTargetException, IllegalAccessException {
        final SchemeValuePair fromNullSVCResult = (SchemeValuePair) jaxbElementConvertToMethod.invoke(jaxbElementSchemeValuePairConverter, jaxbElement, null);
        assertThat(svpObj, is(equalTo(fromNullSVCResult)));
    }

    @Test
    public void testConvertTo_NonNullMatchingDestination() throws InvocationTargetException, IllegalAccessException {
        final SchemeValuePair matchingSVCResult = (SchemeValuePair) jaxbElementConvertToMethod.invoke(jaxbElementSchemeValuePairConverter, jaxbElement, svpObj);
        assertThat(svpObj, is(matchingSVCResult));
    }

    @Test
    public void testConvertTo_NonNullNonMatchingDestination() throws InvocationTargetException, IllegalAccessException {
        final SchemeValuePair nonMatchingSVCResult = (SchemeValuePair) jaxbElementConvertToMethod.invoke(jaxbElementSchemeValuePairConverter, jaxbElement, otherSVPObj);
        assertThat(otherSVPObj, is(not(nonMatchingSVCResult)));
        assertThat(svpObj, is(nonMatchingSVCResult));
    }

    @Test(expected = InvocationTargetException.class)
    public void testConvertTo_NullSourceNonNullDestination() throws InvocationTargetException, IllegalAccessException {
        jaxbElementConvertToMethod.invoke(jaxbElementSchemeValuePairConverter, null, svpObj);
    }

    @Test(expected = InvocationTargetException.class)
    public void testConvertFrom_NullSourceAndDestination() throws InvocationTargetException, IllegalAccessException {
        jaxbElementConvertFromMethod.invoke(jaxbElementSchemeValuePairConverter, null, null);
    }

    @Test(expected = InvocationTargetException.class)
    public void testConvertFrom_NullDestination() throws InvocationTargetException, IllegalAccessException {
        jaxbElementConvertFromMethod.invoke(jaxbElementSchemeValuePairConverter, svpObj, null);
    }

    @Test(expected = InvocationTargetException.class)
    public void testConvertFrom_NonNullMatchingDestination() throws InvocationTargetException, IllegalAccessException {
        jaxbElementConvertFromMethod.invoke(jaxbElementSchemeValuePairConverter, svpObj, jaxbElement);
    }

    @Test(expected = InvocationTargetException.class)
    public void testConvertFrom_NullSourceNonNullDestination() throws InvocationTargetException, IllegalAccessException {
        jaxbElementConvertFromMethod.invoke(jaxbElementSchemeValuePairConverter, null, jaxbElement);
    }

}
