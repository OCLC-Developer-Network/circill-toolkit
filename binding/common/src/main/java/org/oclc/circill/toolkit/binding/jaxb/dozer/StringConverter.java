/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import javax.xml.bind.JAXBElement;

import org.dozer.DozerConverter;
import org.dozer.MappingException;

public class StringConverter extends DozerConverter<JAXBElement, String> {

    public StringConverter() {
        super(JAXBElement.class, String.class);
    }

    @Override
    public String convertTo(final JAXBElement srcObj, final String targetBoolean) {

        String result = null;
        if (srcObj != null) {

            result = (String) srcObj.getValue();

        } // else Do nothing - input object is null

        return result;

    }

    @Override
    public JAXBElement convertFrom(final String srcBoolean, final JAXBElement targetObj) {

        throw new MappingException("StringConverter.convertFrom() method entered - this should never be called.");

    }

}
