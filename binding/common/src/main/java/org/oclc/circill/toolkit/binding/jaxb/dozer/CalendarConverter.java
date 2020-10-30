/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

import org.dozer.DozerConverter;
import org.dozer.MappingException;

public class CalendarConverter extends DozerConverter<JAXBElement, GregorianCalendar> {

    public CalendarConverter() {
        super(JAXBElement.class, GregorianCalendar.class);
    }

    @Override
    public GregorianCalendar convertTo(final JAXBElement srcObj, final GregorianCalendar targetCalendar) {

        GregorianCalendar result = null;
        if (srcObj != null) {

            final XMLGregorianCalendar calendar = (XMLGregorianCalendar) srcObj.getValue();
            result = calendar.toGregorianCalendar();

        } // else do nothing - input object is null

        return result;

    }

    @Override
    public JAXBElement convertFrom(final GregorianCalendar srcCalendar, final JAXBElement targetObj) {

        throw new MappingException("CalendarConverter.convertFrom() method entered - this should never be called.");

    }

}
