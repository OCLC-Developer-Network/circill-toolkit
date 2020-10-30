/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.service.iso18626.RequestType;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestTypeMapper {

    @SuppressWarnings("java:S1214")
    RequestTypeMapper INSTANCE = Mappers.getMapper(RequestTypeMapper.class);

    // source is service classes, target is jaxb classes
    @ValueMapping(source = "New", target = "NEW")
    @ValueMapping(source = "Retry", target = "RETRY")
    @ValueMapping(source = "Reminder", target = "REMINDER")
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeRequestType mapRequestType(RequestType requestType);

    @InheritInverseConfiguration
    RequestType mapRequestType(org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeRequestType requestType);

}
