/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;

import static java.lang.String.format;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * Test that {@link ElementType} iterators contain all expected instances.
 */
public class TestElementTypeIterators {

    private static final Logger LOG = Logger.getLogger(TestElementTypeIterators.class);

    @Before
    public void before() {
        Version1AgencyElementType.loadAll();
        Version1ItemElementType.loadAll();
        Version1RequestElementType.loadAll();
        Version1UserElementType.loadAll();
    }

    @Test
    public void testAgencyElementType() throws InvocationTargetException, IllegalAccessException {
        testElementType(Version1AgencyElementType.class, Version1AgencyElementType.VERSION_1_AGENCY_ELEMENT_TYPE, Version1AgencyElementType.iterator());
    }

    @Test
    public void testItemElementType() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        testElementType(Version1ItemElementType.class, Version1ItemElementType.VERSION_1_ITEM_ELEMENT_TYPE, Version1ItemElementType.iterator());
    }

    @Test
    public void testRequestElementType() throws InvocationTargetException, IllegalAccessException {
        testElementType(Version1RequestElementType.class, Version1RequestElementType.VERSION_1_REQUEST_ELEMENT_TYPE, Version1RequestElementType.iterator());
    }

    @Test
    public void testUserElementType() throws InvocationTargetException, IllegalAccessException {
        testElementType(Version1UserElementType.class, Version1UserElementType.VERSION_1_USER_ELEMENT_TYPE, Version1UserElementType.iterator());
    }

    private void testElementType(final Class<? extends SchemeValuePair> elementTypeClass, final String schemeURI, final Iterator<? extends SchemeValuePair> iterator) throws InvocationTargetException, IllegalAccessException {
        final int iteratorCount = countInstancesByIterator(iterator, schemeURI);
        final int classCount = countInstanceFields(elementTypeClass);
        assertEquals(
            format("The iterator for %s returned %d entries but %d (the number of non-test instances of it) were expected.", elementTypeClass.getSimpleName(), iteratorCount,
                classCount), iteratorCount, classCount);
    }

    private int countInstancesByIterator(final Iterator<? extends SchemeValuePair> iterator, final String schemeURI) {
        int iteratorCount = 0;
        while (iterator.hasNext()) {
            final SchemeValuePair svp = iterator.next();
            if (svp.getClass().getSimpleName().startsWith("Test")) {
                LOG.debug(format("Skipping %s in iterator because it starts with 'Test'.", svp));
                continue;
            }
            if (schemeURI.compareTo(svp.getScheme()) != 0) {
                LOG.debug(format("Skipping %s in iterator because the schemeURI doesn't match.", svp));
                continue;
            }
            LOG.debug(format("Counting %s by iterator.", svp));
            iteratorCount++;
        }
        return iteratorCount;
    }

    private int countInstanceFields(final Class<? extends SchemeValuePair> clazz) throws InvocationTargetException, IllegalAccessException {
        final List<SchemeValuePair> list = ReflectionHelper.findAllSVPInstances(clazz);
        int classCount = 0;
        for (final SchemeValuePair svp : list) {
            if (!svp.getClass().getSimpleName().startsWith("Test")) {
                LOG.debug(format("Counting %s by instance.", svp));
                classCount++;
            } else {
                LOG.debug(format("Skipping %s instance because it starts with 'Test'.", svp));
            }
        }
        return classCount;
    }
}
