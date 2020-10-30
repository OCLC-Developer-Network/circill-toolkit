/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.service.iso18626.Action;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActionMapper {

    @SuppressWarnings("java:S1214")
    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    // source is service classes, target is jaxb classes
    @ValueMapping(source = "StatusRequest", target = "STATUS_REQUEST")
    @ValueMapping(source = "Received", target = "RECEIVED")
    @ValueMapping(source = "Cancel", target = "CANCEL")
    @ValueMapping(source = "Renew", target = "RENEW")
    @ValueMapping(source = "ShippedReturn", target = "SHIPPED_RETURN")
    @ValueMapping(source = "ShippedForward", target = "SHIPPED_FORWARD")
    @ValueMapping(source = "Notification", target = "NOTIFICATION")
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeAction mapAction(Action action);

    @InheritInverseConfiguration
    Action mapAction(org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeAction action);

}
