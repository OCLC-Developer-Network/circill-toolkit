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

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSVPIterators {

    static {
        Version1AgencyElementType.loadAll();
        Version1ItemElementType.loadAll();
        Version1RequestElementType.loadAll();
        Version1UserElementType.loadAll();
    }

    @Test
    public void testAgencyElementType() throws InvocationTargetException, IllegalAccessException {

        final int iteratorCount = countInstancesByIterator(Version1AgencyElementType.iterator());
        final int classCount = countNonTestSVPInstances(Version1AgencyElementType.class);
        Assert.assertEquals("The iterator for this class doesn't return the same number of entries as expected (which is the number of non-test instances of it).", classCount,
            iteratorCount);

    }

    @Test
    public void testItemElementType() throws InvocationTargetException, IllegalAccessException {

        final int iteratorCount = countInstancesByIterator(Version1ItemElementType.iterator());
        final int classCount = countNonTestSVPInstances(Version1ItemElementType.class);
        Assert.assertEquals("The iterator for this class doesn't return the same number of entries as expected (which is the number of non-test instances of it).", classCount,
            iteratorCount);

    }

    @Test
    public void testRequestElementType() throws InvocationTargetException, IllegalAccessException {

        final int iteratorCount = countInstancesByIterator(Version1RequestElementType.iterator());
        final int classCount = countNonTestSVPInstances(Version1RequestElementType.class);
        Assert.assertEquals("The iterator for this class doesn't return the same number of entries as expected (which is the number of non-test instances of it).", classCount,
            iteratorCount);

    }

    @Test
    public void testUserElementType() throws InvocationTargetException, IllegalAccessException {

        final int iteratorCount = countInstancesByIterator(Version1UserElementType.iterator());
        final int classCount = countNonTestSVPInstances(Version1UserElementType.class);
        Assert.assertEquals("The iterator for this class doesn't return the same number of entries as expected (which is the number of non-test instances of it).", classCount,
            iteratorCount);

    }

    private int countInstancesByIterator(final Iterator<? extends SchemeValuePair> iterator) {
        int iteratorCount = 0;
        while (iterator.hasNext()) {
            final SchemeValuePair svp = iterator.next();
            if (svp.getClass().getSimpleName().startsWith("Test")) {
                continue;
            }
            iteratorCount++;
        }
        return iteratorCount;
    }

    private int countNonTestSVPInstances(final Class<? extends SchemeValuePair> clazz) throws InvocationTargetException, IllegalAccessException {
        final List<SchemeValuePair> list = ReflectionHelper.findAllSVPInstances(clazz);
        int classCount = 0;
        for (final SchemeValuePair c : list) {
            if (!c.getClass().getSimpleName().startsWith("Test")) {
                classCount++;
            }
        }
        return classCount;
    }
}
