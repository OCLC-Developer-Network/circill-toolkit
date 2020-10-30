/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.JAXBHelper;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import org.dozer.MappingException;

/**
 * Base class for {@link DozerConverter}s that convert atomic types from an extension element ({@code <ext>}).
 * @param <EXT> the type
 */
public abstract class BaseAtomicTypeExtensionConverter<EXT> extends DozerConverter<Object, EXT> implements MapperAware {

    private static final Logger LOG = Logger.getLogger(BaseAtomicTypeExtensionConverter.class);

    private static final int LENGTH_OF_LIST_PREFIX = "List<".length();

    private static final DatatypeFactory DEFAULT_DATATYPE_FACTORY;

    static {
        try {
            DEFAULT_DATATYPE_FACTORY = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            LOG.error("Exception creating a datatype factory:", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * The {@link DatatypeFactory}.
     */
    protected DatatypeFactory datatypeFactory = DEFAULT_DATATYPE_FACTORY;

    /** The cache of ObjectFactory methods by method name. */
    protected static final Map<String, Method> OBJECT_FACTORY_METHODS_BY_NAME = new HashMap<>();

    /** The {@link Mapper}. */
    protected Mapper mapper;
    /** The field name. */
    protected String fieldName;
    /** The Class of the service object. */
    protected Class<?> svcClass;
    /** Whether the {@link #svcClass} is a List. */
    protected boolean svcClassIsList = false;

    /**
     * Construct a instance.
     * @param extensionClass the {@link Class} of the {@code <EXT>} object
     */
    public BaseAtomicTypeExtensionConverter(final Class<EXT> extensionClass) {
        super(Object.class, extensionClass);
    }

    @Override
    public EXT convertTo(final Object source, final EXT destination) {

        init();

        EXT result = destination;

        if (List.class.isAssignableFrom(source.getClass())) {

            final List<Object> sourceList = (List<Object>) source;
            for (final Object srcObj : sourceList) {

                final Object innerObj = createJAXBObject(srcObj, fieldName);
                if (innerObj != null) {
                    if (result == null) {
                        result = createExtension();
                    }
                    JAXBHelper.addToExtension(destination, innerObj);
                }

            }

        } else {

            final Object innerObj = createJAXBObject(source, fieldName);
            if (innerObj != null) {
                if (result == null) {
                    result = createExtension();
                }
                JAXBHelper.addToExtension(result, innerObj);
            }

        }

        return result;

    }

    @Override
    public Object convertFrom(final EXT source, final Object destination) {

        init();
        LOG.debug("In " + this.getClass().getSimpleName() + " for " + fieldName);

        Object result = destination;

        if (source != null) {

            // For every object in the extension
            for (final Object obj : JAXBHelper.getAnyList(source)) {

                if (Boolean.class.isAssignableFrom(svcClass)) {
                    // Boolean fields are represented by an optional complexType
                    if (obj.getClass().getSimpleName().compareTo(fieldName) == 0) {
                        result = Boolean.TRUE;
                    } else {
                        LOG.debug(obj.getClass().getSimpleName() + " is not " + fieldName + ", so this converter is doing nothing.");
                    }
                }
                if (JAXBElement.class.isAssignableFrom(obj.getClass()) && ((JAXBElement) obj).getName().getLocalPart().compareTo(fieldName) == 0) {

                    LOG.debug("Converting " + ((JAXBElement) obj).getName().getLocalPart() + " to a " + fieldName);
                    final Object svcObj = mapper.map(obj, svcClass);
                    if (svcClassIsList) {

                        if (result == null) {

                            result = new ArrayList<>();

                        }
                        ((List<Object>) result).add(svcObj);

                    } else {

                        result = svcObj;

                    }

                } else {
                    if (!JAXBElement.class.isAssignableFrom(obj.getClass())) {
                        LOG.debug(obj.getClass() + " is not assignable from JAXBElement, so this converter is doing nothing.");
                    } else {
                        LOG.debug(((JAXBElement) obj).getName().getLocalPart() + " is not " + fieldName + ", so this converter is doing nothing.");
                    }
                }

            }

        }

        return result;

    }

    /**
     * Initialize this converter.
     */
    protected void init() {

        final String parameter = getParameter();
        final String[] parameters = parameter.split(",");
        if (parameters.length == 2) {
            String className = parameters[0];
            if (className.matches("^List<.*>$")) {

                svcClassIsList = true;
                className = className.substring(LENGTH_OF_LIST_PREFIX, className.length() - 1);

            }

            try {

                svcClass = Class.forName(className);

            } catch (ClassNotFoundException e) {

                throw new MappingException("Could not find class \"" + className + "\".", e);

            }

            fieldName = parameters[1];

        } else {

            throw new MappingException("Parameter must be in the format \"className,fieldName\", not \"" + parameter + "\".");

        }

    }

    /**
     * Create JAXBObject for the field named, from the svcObj.
     * Note: Returns null if the JAXB representation is to omit the object (this is for flag elements that are omitted if false).
     * @param svcObj the service-package object from which to create the JAXBObject
     * @param fieldName the name of the field for which the object will  be created
     * @return the JAXB object
     */
    protected Object createJAXBObject(final Object svcObj, final String fieldName) {

        Object jaxbFieldObj = null;

        final Class svcClass = svcObj.getClass();

        final String createMethodName;
        if (fieldName.endsWith("s")) {
            createMethodName = "create" + fieldName.substring(0, fieldName.length() - 1);
        } else {
            createMethodName = "create" + fieldName;
        }

        if (BigDecimal.class.isAssignableFrom(svcClass)) {

            jaxbFieldObj = JAXBHelper.createJAXBObject(getObjectFactory(), OBJECT_FACTORY_METHODS_BY_NAME, createMethodName, svcObj);

        } else if (String.class.isAssignableFrom(svcClass)) {

            jaxbFieldObj = JAXBHelper.createJAXBObject(getObjectFactory(), OBJECT_FACTORY_METHODS_BY_NAME, createMethodName, svcObj);

        } else if (Boolean.class.isAssignableFrom(svcClass)) {

            if (((Boolean) svcObj)) {
                jaxbFieldObj = JAXBHelper.createEmptyJAXBObject(getObjectFactory(), OBJECT_FACTORY_METHODS_BY_NAME, createMethodName);
            } // else return null

        } else if (GregorianCalendar.class.isAssignableFrom(svcClass)) {

            final XMLGregorianCalendar xmlGregorianCalendar = DEFAULT_DATATYPE_FACTORY.newXMLGregorianCalendar((GregorianCalendar) svcObj);

            jaxbFieldObj = JAXBHelper.createJAXBObject(getObjectFactory(), OBJECT_FACTORY_METHODS_BY_NAME, createMethodName, xmlGregorianCalendar);

        } else {

            throw new MappingException("This converter does not handle the '" + svcClass.getName() + "' class.");

        }

        return jaxbFieldObj;
    }

    /**
     * Create an instance of the EXT type.
     * @return the instance
     */
    protected abstract EXT createExtension();

    protected abstract Object getObjectFactory();

    public DatatypeFactory getDatatypeFactory() {
        return datatypeFactory;
    }

    /**
     * Set the datatype factory.
     * @param datatypeFactory the factory
     */
    public void setDatatypeFactory(final DatatypeFactory datatypeFactory) {
        this.datatypeFactory = datatypeFactory;
    }

    /**
     * Set the {@link Mapper}.
     * @param mapper the mapper
     */
    @Override
    public void setMapper(final Mapper mapper) {
        this.mapper = mapper;
    }
}
