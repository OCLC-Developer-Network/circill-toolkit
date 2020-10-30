/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.service.iso18626.ServiceType;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceTypeMapper {

    @SuppressWarnings("java:S1214")
    ServiceTypeMapper INSTANCE = Mappers.getMapper(ServiceTypeMapper.class);

    // source is service classes, target is jaxb classes
    @ValueMapping(source = "Copy", target = "COPY")
    @ValueMapping(source = "Loan", target = "LOAN")
    @ValueMapping(source = "CopyOrLoan", target = "COPY_OR_LOAN")
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeServiceType mapServiceType(ServiceType serviceType);

    @InheritInverseConfiguration
    ServiceType mapServiceType(org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeServiceType serviceType);

}
