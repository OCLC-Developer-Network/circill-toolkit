/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanMap;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

/**
 * Abstract {@link DozerConverter} for converting complex beans (i.e. those with one or more properties) that
 * returns null when the input (i.e. 'from') object is empty. An "empty" object is one where all properties are null.
 * @param <A> the 'A' class
 * @param <B> the 'B' class
 */
public abstract class BaseNullIfEmptyConverter<A, B> extends DozerConverter<A, B> implements MapperAware {

    private static final Set<String> DEFAULT_IGNORED_PROPERTY_NAMES = new HashSet<>(Collections.singletonList("class"));

    /** The {@link Mapper} from which this converter was invoked, used for mapping properties between the A &amp; B classes. */
    protected Mapper mapper;
    /** The 'A' class to be mapped. */
    protected final Class<A> aClass;
    /** The 'B' class to be mapped. */
    protected final Class<B> bClass;
    /** Any property names to be ignored, e.g. if they're primitive types (as those won't be null). */
    protected final Set<String> ignoredPropertyNames;

    /**
     * Construct an instance with property names to be ignored.
     * @param aClass the 'A' class
     * @param bClass the 'B' class
     * @param ignoredPropertyNames property names to ignore (from either 'A' or 'B' classes)
     */
    protected BaseNullIfEmptyConverter(final Class<A> aClass, final Class<B> bClass, final Set<String> ignoredPropertyNames) {
        super(aClass, bClass);
        this.aClass = aClass;
        this.bClass = bClass;
        this.ignoredPropertyNames = new HashSet<>(DEFAULT_IGNORED_PROPERTY_NAMES);
        this.ignoredPropertyNames.addAll(ignoredPropertyNames);
    }

    /**
     * Construct an instance with no property names to be ignored.
     * @param aClass the 'A' class
     * @param bClass the 'B' class
     */
    protected BaseNullIfEmptyConverter(final Class<A> aClass, final Class<B> bClass) {
        this(aClass, bClass, Collections.emptySet());
    }

    @Override
    public B convertTo(final A a, final B b) {
        if (a == null) {
            return null;
        }
        final B result = mapper.map(a, bClass);
        if (beanIsEmpty(result)) {
            return null;
        } else {
            return result;
        }
    }

    @Override
    public A convertFrom(final B b, final A a) {
        if (b == null) {
            return null;
        }
        final A result = mapper.map(b, aClass);
        if (beanIsEmpty(result)) {
            return null;
        } else {
            return result;
        }
    }

    private boolean beanIsEmpty(final Object bean) {
        final BeanMap beanMap = new BeanMap(bean);
        final Set<Map.Entry<Object, Object>> entrySet = beanMap.entrySet();
        for (final Map.Entry<Object, Object> entry : entrySet) {
            final String propertyName = (String) entry.getKey();
            if (ignoredPropertyNames.contains(propertyName)) {
                continue;
            }
            final Type type = beanMap.getType(propertyName);
            if (((Class<?>) type).isPrimitive()) {
                return false;
            } else {
                if (entry.getValue() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void setMapper(final Mapper mapper) {
        this.mapper = mapper;
    }
}
