/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.service.iso18626.ReasonForMessage;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReasonForMessageMapper {

    @SuppressWarnings("java:S1214")
    ReasonForMessageMapper INSTANCE = Mappers.getMapper(ReasonForMessageMapper.class);

    // source is service classes, target is jaxb classes
    @ValueMapping(source = "RequestResponse", target = "REQUEST_RESPONSE")
    @ValueMapping(source = "StatusRequestResponse", target = "STATUS_REQUEST_RESPONSE")
    @ValueMapping(source = "RenewResponse", target = "RENEW_RESPONSE")
    @ValueMapping(source = "CancelResponse", target = "CANCEL_RESPONSE")
    @ValueMapping(source = "StatusChange", target = "STATUS_CHANGE")
    @ValueMapping(source = "Notification", target = "NOTIFICATION")
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeReasonForMessage mapReasonForMessage(ReasonForMessage reasonForMessage);

    @InheritInverseConfiguration
    ReasonForMessage mapReasonForMessage(org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeReasonForMessage reasonForMessage);

}
