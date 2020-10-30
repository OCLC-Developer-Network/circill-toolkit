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

import javax.xml.bind.JAXBElement;

import org.dozer.DozerConverter;
import org.dozer.MappingException;

/**
 * Note: In every JAXB package you must implement a sub-class of this class for every sub-class of
 * {@link SchemeValuePair}, e.g.
 <code>
 public class ItemDescriptionLevelJAXBElementSchemeValuePairConverter
 extends BaseJAXBElementSchemeValuePairConverter&lt;ItemDescriptionLevel&gt;
 { ... }
 </code>
 *
 * @param <SVCSVP> the service-package {@link SchemeValuePair} class
 */
public class BaseJAXBElementSchemeValuePairConverter<SVCSVP extends SchemeValuePair> extends DozerConverter<JAXBElement, SVCSVP> {

    protected final Class jaxbSVPClass;
    protected final Class<SVCSVP> serviceSVPClass;

    public BaseJAXBElementSchemeValuePairConverter(final Class jaxbSVPClass, final Class serviceSVPClass) {
        super(jaxbSVPClass, serviceSVPClass);
        this.jaxbSVPClass = jaxbSVPClass;
        this.serviceSVPClass = serviceSVPClass;
    }

    @Override
    public SVCSVP convertTo(final JAXBElement source, final SVCSVP destination) {
        // Convert from JAXB svp to< service SVP
        // If the parent JAXB object uses the get-Content catch-all, then SchemeValuePair objects are contained
        //  w/i JAXBElement objects, so we have to unwrap them here.

        SVCSVP result = null;
        if (source != null) {

            try {

                result = (SVCSVP) SchemeValuePairHelper
                    .findSchemeValuePair(serviceSVPClass, JAXBHelper.getScheme((source).getValue()), JAXBHelper.getValue((source).getValue()));

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
    public JAXBElement convertFrom(final SVCSVP source, final JAXBElement destination) {

        // Convert from service SVP to JAXBElement
        throw new MappingException("Unsupported mapping from service.SchemeValuePair to JAXBElement.");

    }

}
