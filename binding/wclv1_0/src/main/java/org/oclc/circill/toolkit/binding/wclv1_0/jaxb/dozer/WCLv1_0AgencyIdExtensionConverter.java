/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.JAXBHelper;
import org.oclc.circill.toolkit.binding.wclv1_0.jaxb.elements.Ext;
import org.oclc.circill.toolkit.binding.wclv1_0.jaxb.elements.ObjectFactory;
import org.oclc.circill.toolkit.binding.wclv1_0.jaxb.elements.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import javax.xml.bind.JAXBElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import org.dozer.MappingException;

// TODO: Most of this was copied out of BaseAtomicTypeExtensionConverter; try to consolidate

/**
 * custom-converter-param is the local part of the element name, e.g. "RelyingPartyId" for the RelyingPartyId
 * element in NCIP.
 */
public class WCLv1_0AgencyIdExtensionConverter extends DozerConverter<Ext, AgencyId> implements MapperAware {
    /** A cache of object-factory methods by method name. */
    protected static final Map<String, Method> objectFactoryMethodsByName = new HashMap<>();
    /** The Dozer mapper. */
    protected Mapper mapper;

    /**
     * Construct an instance.
     */
    public WCLv1_0AgencyIdExtensionConverter() {
        super(Ext.class, AgencyId.class);
    }

    @Override
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:ParameterAssignment"}) // Dozer converters assume the target object is modified
    public AgencyId convertTo(final Ext srcExt, AgencyId targetAgencyId) {
        if (srcExt != null) {
            final String fieldName = getParameter();
            for (final Object obj : JAXBHelper.getAnyList(srcExt)) {
                if (JAXBElement.class.isAssignableFrom(obj.getClass()) && ((JAXBElement) obj).getName().getLocalPart().compareTo(fieldName) == 0) {
                    final JAXBElement srcObj = (JAXBElement) obj;
                    final SchemeValuePair jaxbSVP = (SchemeValuePair) srcObj.getValue();
                    targetAgencyId = new AgencyId(jaxbSVP.getScheme(), jaxbSVP.getValue());
                }
            }
        }
        return targetAgencyId;
    }

    @Override
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:ParameterAssignment"}) // Dozer converters assume the target object is modified
    public Ext convertFrom(final AgencyId srcAgencyId, Ext targetExt) {
        if (targetExt == null) {
            targetExt = new Ext();
        }

        JAXBElement jaxbElement = null;
        if (srcAgencyId != null) {
            final SchemeValuePair jaxbSVP = new SchemeValuePair();
            jaxbSVP.setScheme(srcAgencyId.getScheme());
            jaxbSVP.setValue(srcAgencyId.getValue());
            final String fieldName = getParameter();
            final String createMethodName;
            if (fieldName.endsWith("s")) {
                createMethodName = "create" + fieldName.substring(0, fieldName.length() - 1);
            } else {
                createMethodName = "create" + fieldName;
            }
            Method createMethod = objectFactoryMethodsByName.get(createMethodName);
            if (createMethod == null) {
                createMethod = ReflectionHelper.findMethod(ObjectFactory.class, createMethodName, SchemeValuePair.class);
                objectFactoryMethodsByName.put(createMethodName, createMethod);
            }

            try {
                jaxbElement = (JAXBElement) createMethod.invoke(new ObjectFactory(), jaxbSVP);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new MappingException("Exception creating JAXBElement.", e);
            }
            JAXBHelper.addToExtension(targetExt, jaxbElement);
        } // else - do nothing - input object is null
        return targetExt;
    }

    @Override
    public void setMapper(final Mapper mapper) {
        this.mapper = mapper;
    }

}
