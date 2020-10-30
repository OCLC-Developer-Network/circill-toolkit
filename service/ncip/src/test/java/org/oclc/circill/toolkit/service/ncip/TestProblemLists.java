/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import static org.oclc.circill.toolkit.service.base.ReflectionHelper.ALL_CLASSES_NAME_PATTERN;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * Ensure that all classes with a "problems" property (i.e., a list of Problem objects) initialize the list (to an empty list) on construction.
 */
public class TestProblemLists {

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    private static final Set<Class> EXCLUDED_CLASSES;

    static {
        final Set<Class> tempSet = new HashSet<>();
        tempSet.add(ValidationException.class); // The problem list is a final list that must be set on construction, so this test doesn't apply.
        EXCLUDED_CLASSES = Collections.unmodifiableSet(tempSet);
    }

    @Test
    public void testProblemListIsInitializedToEmptyArrayList() throws ReflectiveOperationException, ServiceException, IOException, IntrospectionException,
        ToolkitInternalException {

        final String rawPackageName = NCIPMessage.class.getPackage().getName();
        final List<Class<Object>> classes = ReflectionHelper.findClassesInPackage(rawPackageName, ALL_CLASSES_NAME_PATTERN);
        for (final Class<Object> clazz : classes) {
            if (clazz.isInterface() || EXCLUDED_CLASSES.contains(clazz)) {
                continue;
            }
            for (final PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(clazz).getPropertyDescriptors()) {
                if ("problems".equals(propertyDescriptor.getName())) {
                    final Object obj = clazz.newInstance();
                    final Method getProblemsMethod = propertyDescriptor.getReadMethod();
                    final List<Problem> problemsList = (List<Problem>) getProblemsMethod.invoke(obj);
                    collector.checkThat(clazz.getName() + " has null problems list", problemsList, is(not(nullValue())));
                    if (problemsList != null) {
                        collector.checkThat(clazz.getName() + " problems list is not empty immediately after construction", problemsList.size(), is(0));
                    }
                }
            }
        }
    }

}
