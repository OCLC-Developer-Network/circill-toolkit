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
import org.oclc.circill.toolkit.service.base.SchemeValuePairHelper;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import org.dozer.DozerConverter;
import org.dozer.MappingException;

/**
 * Note: In every JAXB package you must implement a sub-class of this class for every sub-class of
 * {@link SchemeValuePair}, e.g. for ItemDescriptionLevel:
 * <pre>{@code
 * public class ItemDescriptionLevelSchemeValuePairConverter
 *   extends BaseSchemeValuePairConverter<org.oclc.circill.toolkit.binding.jaxb.elements.SchemeValuePair, ItemDescriptionLevel>
 * { ... }
 * }</pre>
 * Then the Dozer mapping file must have this custom converter configuration:
 * <pre>{@code
 * <converter type="org.oclc.circill.toolkit.binding.wclv1_1.jaxb.dozer.ItemDescriptionLevelSchemeValuePairConverter">
 *     <class-a>org.oclc.circill.toolkit.service.ncip.ItemDescriptionLevel</class-a>
 *     <class-b>org.oclc.circill.toolkit.binding.wclv1_1.jaxb.elements.SchemeValuePair</class-b>
 * </converter>
 * <converter type="org.oclc.circill.toolkit.binding.wclv1_1.jaxb.dozer.ItemDescriptionLevelJAXBElementSchemeValuePairConverter">
 *     <class-a>org.oclc.circill.toolkit.service.ncip.ItemDescriptionLevel</class-a>
 *     <class-b>javax.xml.bind.JAXBElement</class-b>
 * </converter>
 }</pre>
 *
 * @param <JAXBSVP> the JAXB-generated class representing the SchemeValuePair element
 * @param <SVCSVP> the Service package sub-class of SchemeValuePair representing the element
 */
public class BaseSchemeValuePairConverter<JAXBSVP, SVCSVP extends SchemeValuePair> extends DozerConverter<JAXBSVP, SVCSVP> {

    protected final Class jaxbSVPClass;
    protected final Class<SVCSVP> serviceSVPClass;

    public BaseSchemeValuePairConverter(final Class jaxbSVPClass, final Class serviceSVPClass) {
        super(jaxbSVPClass, serviceSVPClass);
        this.jaxbSVPClass = jaxbSVPClass;
        this.serviceSVPClass = serviceSVPClass;
    }

    @Override
    public SVCSVP convertTo(final JAXBSVP source, final SVCSVP destination) {

        SVCSVP result = null;
        if (source != null) {

            try {

                result = (SVCSVP) SchemeValuePairHelper.findSchemeValuePair(serviceSVPClass, JAXBHelper.getScheme(source), JAXBHelper.getValue(source));

            } catch (ToolkitException e) {

                throw new MappingException(e);

            }

        } else {

            if (destination != null) {

                throw new MappingException("Source is null but destination is not null.");

            } // else this is ok - return null

        }

        return result;

    }

    @Override
    public JAXBSVP convertFrom(final SVCSVP source, final JAXBSVP destination) {

        JAXBSVP result = null;
        if (source != null) {

            if (destination != null) {

                result = destination;
                JAXBHelper.setScheme(result, source.getScheme());
                JAXBHelper.setValue(result, source.getValue());

            } else {

                try {

                    result = (JAXBSVP) JAXBHelper.createJAXBSchemeValuePair(jaxbSVPClass, source.getScheme(), source.getValue());

                } catch (IllegalAccessException | InstantiationException e) {

                    throw new MappingException(e);

                }

            }

        } else {

            if (destination != null) {

                throw new MappingException("Source is null but destination is not null.");

            } // else this is ok - return null

        }

        return result;
    }

}
