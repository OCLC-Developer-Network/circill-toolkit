/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.JAXBHelper;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerConverter;
import org.dozer.MappingException;

/**
 * This class assumes that all service package SchemeValuePair sub-classes have been populated.
 * @param <JAXBSVP> the JAXB-generated type that represents the {@link SchemeValuePair}
 */
public class BaseSchemeValuePairToBooleanConverter<JAXBSVP> extends DozerConverter<List<JAXBSVP>, Boolean> {

    protected final Class<JAXBSVP> jaxbSVPClass;

    /**
     * Construct an instance for the two provided types.
     * @param jaxbSVPListClass the type for lists of &lt;JAXBSVP&gt; objects
     * @param jaxbSVPClass the &lt;JAXBSVP&gt; type
     */
    public BaseSchemeValuePairToBooleanConverter(final Class<List<JAXBSVP>> jaxbSVPListClass, final Class<JAXBSVP> jaxbSVPClass) {

        super(jaxbSVPListClass, Boolean.class);
        this.jaxbSVPClass = jaxbSVPClass;

    }

    @Override
    public Boolean convertTo(final List srcObj, final Boolean targetBoolean) {

        // TODO: This approach means that SVP elements that don't match a boolean flag attribute of the target class are silently ignored. It would be ideal to throw an exception
        Boolean result = Boolean.FALSE;

        if (srcObj != null) {
            try {
                final SchemeValuePair svcSVP = getServiceSVP();
                // Search the list to see if it has a matching entry
                final List<JAXBSVP> jaxbSVPList = srcObj;
                for (final JAXBSVP jaxbSVPObj : jaxbSVPList) {

                    final String scheme = JAXBHelper.getScheme(jaxbSVPObj);
                    final String value = JAXBHelper.getValue(jaxbSVPObj);
                    if (svcSVP.matches(scheme, value)) {
                        result = Boolean.TRUE;
                        break;
                    }
                }
            } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
                throw new MappingException(e);
            }
        }

        return result;
    }

    @Override
    public List<JAXBSVP> convertFrom(final Boolean srcBoolean, final List targetObj) {

        final List<JAXBSVP> result;

        if (targetObj != null) {

            result = targetObj;

        } else {

            result = new ArrayList<>();

        }

        if (Boolean.TRUE.equals(srcBoolean)) {

            try {

                final SchemeValuePair svcSVP = getServiceSVP();

                final JAXBSVP jaxbSVPObject = JAXBHelper.createJAXBSchemeValuePair(jaxbSVPClass, svcSVP.getScheme(), svcSVP.getValue());

                result.add(jaxbSVPObject);

            } catch (IllegalAccessException | ClassNotFoundException | NoSuchFieldException | InstantiationException e) {

                throw new MappingException(e);

            }

        } // else do nothing - leave the list alone

        return result;

    }

    /**
     * Return the instance of the service package sub-class of SchemeValuePair identified by the
     * custom-converter-param on the dozer mapping's field element for this conversion.
     * @return the {@link SchemeValuePair} instance
     * @throws ClassNotFoundException if there is no such sub-class as that in the custom-converter-param.
     * @throws NoSuchFieldException if there is no such field on the sub-class
     * @throws IllegalAccessException if the field is inaccessible
     */
    protected SchemeValuePair getServiceSVP() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        final String valueClassAndField = getParameter();
        final String className = valueClassAndField.substring(0, valueClassAndField.lastIndexOf('.'));
        final String fieldName = valueClassAndField.substring(valueClassAndField.lastIndexOf('.') + 1);
        final Class<SchemeValuePair> svcSVPClass = (Class<SchemeValuePair>) Class.forName(className);
        final Field svpField = svcSVPClass.getField(fieldName);
        final SchemeValuePair svcSVP = (SchemeValuePair) svpField.get(null);
        return svcSVP;

    }

}
