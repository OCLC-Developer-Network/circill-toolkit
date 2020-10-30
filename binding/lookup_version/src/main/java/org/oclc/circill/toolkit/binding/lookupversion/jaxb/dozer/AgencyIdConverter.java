/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.lookupversion.jaxb.dozer;

import org.oclc.circill.toolkit.binding.lookupversion.jaxb.elements.UniqueAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

/**
 * Convert to/from the UniqueAgencyId from the NCIP LookupVersion schema to the AgencyId used in NCIP version 2 & later.
 */
public class AgencyIdConverter implements CustomConverter {

    @Override
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:ParameterAssignment", "java:S1226"}) // Dozer converters assume the target object is modified
    public Object convert(Object destination, final Object source, final Class destClass, final Class sourceClass) {
        if (source == null) {
            return null;
        }

        if (source instanceof AgencyId) {
            final AgencyId agencyId = (AgencyId) source;
            destination = new UniqueAgencyId();
            ((UniqueAgencyId) destination).setScheme(agencyId.getScheme());
            ((UniqueAgencyId) destination).setValue(agencyId.getValue());
        } else if (source instanceof UniqueAgencyId) {
            final UniqueAgencyId uniqueAgencyId = (UniqueAgencyId) source;
            destination = new AgencyId(uniqueAgencyId.getScheme(), uniqueAgencyId.getValue());
        } else {
            throw new MappingException("source must be " + AgencyId.class.getName() + " or " + UniqueAgencyId.class.getName() + ".");
        }
        return destination;
    }
}
