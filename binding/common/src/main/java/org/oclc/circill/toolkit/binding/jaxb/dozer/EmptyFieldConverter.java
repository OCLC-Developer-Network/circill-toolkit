/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerConverter;
import org.dozer.MappingException;

public class EmptyFieldConverter extends DozerConverter<Object, Boolean> {

    protected static final Map<String, Constructor> defaultCtorsByClassName = new HashMap<>();

    public EmptyFieldConverter() {
        super(Object.class, Boolean.class);
    }

    @Override
    public Boolean convertTo(final Object srcObj, final Boolean targetBoolean) {

        final Boolean result;
        if (srcObj != null) {

            result = Boolean.TRUE;

        } else {

            result = Boolean.FALSE;

        }

        return result;

    }

    @Override
    public Object convertFrom(final Boolean srcBoolean, final Object targetObj) {

        final Object result;

        if (srcBoolean) {

            try {

                final Constructor ctor = getDefaultConstructor(getParameter());

                result = ctor.newInstance();

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {

                throw new MappingException(e);

            }

        } else {

            result = null;

        }

        return result;

    }

    protected Constructor getDefaultConstructor(final String className) {

        Constructor ctor = defaultCtorsByClassName.get(className);

        if (ctor == null) {

            try {

                final Class<?> clazz = Class.forName(className);
                ctor = clazz.getConstructor();
                defaultCtorsByClassName.put(className, ctor);

            } catch (NoSuchMethodException | ClassNotFoundException e) {

                throw new MappingException(e);

            }

        }

        return ctor;
    }

}
