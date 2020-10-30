/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import javax.xml.bind.JAXBElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dozer.MappingException;

public final class JAXBHelper {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(JAXBHelper.class);

    /**
     * This utility class does not allow instances.
     */
    private JAXBHelper() {
    }

    /**
     * Get the name of the message associated with the provided object.
     * @param msg the message object
     * @return the name of the message
     * @throws ToolkitInternalException if the message name cannot be obtained
     */
    public static String getMessageName(final Object msg) throws ToolkitInternalException {
        try {
            String msgName = null;
            final Class objClass = msg.getClass();
            final Field[] fields = objClass.getDeclaredFields();
            for (final Field f : fields) {
                final Method getterMethod = ReflectionHelper.findMethod(objClass, "get" + f.getName());
                if (getterMethod != null) {
                    final Object innerObj = getterMethod.invoke(msg);
                    if (innerObj != null) {
                        if (ReflectionHelper.isCollection(innerObj.getClass())) {
                            // We've found the initiation or response object, which is a collection
                            final Collection coll = (Collection) innerObj;
                            if (!coll.isEmpty()) {
                                final Object collectionObj = coll.iterator().next();
                                msgName = collectionObj.getClass().getSimpleName();
                                break;
                            } // An empty collection is effectively a null field - continue with next field
                        } else {
                            // If this is an Ext object, look inside it to get the first object in it and treat that as the
                            // message, getting its simple name. This relies on the assumption that there can only be
                            // one immediate child of ServiceMessage/Ext that is a message (initiation or response),
                            // just like there can only be one immediate child of ServiceMessage itself.
                            final Method getAnyMethod = ReflectionHelper.findMethod(innerObj.getClass(), "getAny");
                            if (getAnyMethod != null) {
                                final List<Object> anyObjList = (List<Object>) getAnyMethod.invoke(innerObj);
                                if (anyObjList != null && !anyObjList.isEmpty()) {
                                    msgName = anyObjList.get(0).getClass().getSimpleName();
                                } else {
                                    // The extension list is null or empty - this is the best we can do.
                                    msgName = innerObj.getClass().getSimpleName();
                                }
                            } else {
                                msgName = innerObj.getClass().getSimpleName();
                            }
                            break;
                        }
                    }
                }
            }
            return msgName;
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new ToolkitInternalException("Exception getting name of message from JAXB object.", e);
        }
    }

    public static String getScheme(final Object jaxbObject) {
        final String result;
        try {
            result = (String) ReflectionHelper.findMethod(jaxbObject.getClass(), "getScheme").invoke(jaxbObject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MappingException(e);
        }
        return result;
    }

    public static String getValue(final Object jaxbObject) {
        final String result;
        try {
            result = (String) ReflectionHelper.findMethod(jaxbObject.getClass(), "getValue").invoke(jaxbObject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MappingException(e);
        }
        return result;
    }

    public static void setScheme(final JAXBElement element, final String scheme) {
        setScheme(element.getValue(), scheme);
    }

    public static void setScheme(final Object jaxbObject, final String scheme) {
        try {
            ReflectionHelper.findMethod(jaxbObject.getClass(), "setScheme", String.class).invoke(jaxbObject, scheme);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MappingException(e);
        }
    }

    public static void setValue(final JAXBElement element, final String value) {
        setValue(element.getValue(), value);
    }

    public static void setValue(final Object jaxbObject, final String value) {
        try {
            ReflectionHelper.findMethod(jaxbObject.getClass(), "setValue", String.class).invoke(jaxbObject, value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MappingException(e);
        }
    }

    public static List<Object> getAnyList(final Object extension) {
        final List<Object> result;
        final Method getAnyMethod = ReflectionHelper.findMethod(extension.getClass(), "getAny");
        if (getAnyMethod != null) {
            try {
                result = (List<Object>) getAnyMethod.invoke(extension);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new MappingException(e);
            }
        } else {
            throw new MappingException("Object " + extension.getClass() + " does not appear to be an Ext element" + " (no 'getAny' method).");
        }
        return result;
    }

    /**
     * Add the provided object to the extension.
     * @param extension the extension
     * @param obj the object to add
     */
    public static void addToExtension(final Object extension, final Object obj) {
        final List<Object> list = JAXBHelper.getAnyList(extension);
        list.add(obj);
    }

    /**
     * Add all of the objects in the provided list to the provided extension.
     * @param extension the extension
     * @param listToAdd the list of objetcs to add
     */
    public static void addAllToExtension(final Object extension, final List<Object> listToAdd) {
        final List<Object> list = JAXBHelper.getAnyList(extension);
        list.addAll(listToAdd);
    }

    /**
     * Create an instance of a JAXB-generated SchemeValuePair class.
     * @param jaxbSVPClass the JAXB-generated SchemeValuePair class
     * @param scheme the scheme URI
     * @param value the value
     * @param <JAXBSVP> the type of the JAXB-generated SchemeValuePiar
     * @return the instance of the JAXB-generated SchemeValuePair
     * @throws IllegalAccessException if it's not permitted to set the scheme or value
     * @throws InstantiationException if it's not permitted to consruct an instance of the JAXB-generated SchemeValuePair class
     */
    public static <JAXBSVP> JAXBSVP createJAXBSchemeValuePair(final Class<JAXBSVP> jaxbSVPClass, final String scheme, final String value)
        throws IllegalAccessException, InstantiationException {
        final JAXBSVP jaxbSVP = jaxbSVPClass.newInstance();
        setScheme(jaxbSVP, scheme);
        setValue(jaxbSVP, value);
        return jaxbSVP;
    }

    /**
     * Create an instance of a JAXB-generated class.
     * @param objectFactory the JAXB object factory
     * @param objectFactoryMethodsByName the cache of object factory methods used to create instances previously
     * @param createMethodName the name of the method on the object factory which creates instances of the JAXB-generated class
     * @param srcObj the parameter passed to the method
     * @return the created instance
     */
    public static Object createJAXBObject(final Object objectFactory, final Map<String, Method> objectFactoryMethodsByName, final String createMethodName, final Object srcObj) {
        final Object jaxbObject;
        LOG.debug("Creating JAB object via " + createMethodName);
        final Method objFactoryMethod = getObjectFactoryMethod(objectFactory, objectFactoryMethodsByName, createMethodName, srcObj.getClass());
        try {
            jaxbObject = objFactoryMethod.invoke(objectFactory, srcObj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MappingException("Exception creating JAXB object.", e);
        }
        return jaxbObject;
    }

    /**
     * Create a JAXB object with empty content.
     * @param objectFactory the JAXB ObjectFactory on which to find the method
     * @param objectFactoryMethodsByName a cache of methods previously obtained from this factory
     * @param createMethodName the name of the create method, e.g. createIsActive
     * @return the create method
     */
    public static Object createEmptyJAXBObject(final Object objectFactory, final Map<String, Method> objectFactoryMethodsByName, final String createMethodName) {
        final Object jaxbObject;
        final Method objFactoryMethod = getObjectFactoryMethod(objectFactory, objectFactoryMethodsByName, createMethodName);
        if (objFactoryMethod != null) {
            try {
                jaxbObject = objFactoryMethod.invoke(objectFactory);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new MappingException("Exception creating JAXB object.", e);
            }
        } else {
            throw new MappingException("No objectFactory method on " + objectFactory.getClass().getName() + " for " + createMethodName);
        }
        return jaxbObject;
    }

    private static Method getObjectFactoryMethod(final Object objectFactory, final Map<String, Method> objectFactoryMethodsByName, final String methodName,
        final Class srcObjClass) {
        // Note that this assumes that there's only ever one method by this name, i.e. it doesn't
        // account for different parameter types
        Method method = objectFactoryMethodsByName.get(methodName);
        if (method == null) {
            method = ReflectionHelper.findMethod(objectFactory.getClass(), methodName, srcObjClass);
            objectFactoryMethodsByName.put(methodName, method);
        }
        return method;
    }

    /**
     * Get ObjectFactory method for a method with no parameters.
     * @param objectFactory the JAXB ObjectFactory on which to find the method
     * @param objectFactoryMethodsByName a cache of methods previously obtained from this factory
     * @param methodName the name of the method, e.g. createAmount
     * @return the ObjectFactory method
     */
    private static Method getObjectFactoryMethod(final Object objectFactory, final Map<String, Method> objectFactoryMethodsByName, final String methodName) {
        // Note that this assumes that there's only ever one method by this name, i.e. it doesn't
        // account for different parameter types
        Method method = objectFactoryMethodsByName.get(methodName);
        if (method == null) {
            method = ReflectionHelper.findMethod(objectFactory.getClass(), methodName);
            objectFactoryMethodsByName.put(methodName, method);
        }
        return method;
    }
}
