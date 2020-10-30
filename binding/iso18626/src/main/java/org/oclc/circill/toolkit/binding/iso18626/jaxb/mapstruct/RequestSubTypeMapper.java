/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.service.iso18626.RequestSubType;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestSubTypeMapper {

    @SuppressWarnings("java:S1214")
    RequestSubTypeMapper INSTANCE = Mappers.getMapper(RequestSubTypeMapper.class);

    // source is service classes, target is jaxb classes
    @ValueMapping(source = "BookingRequest", target = "BOOKING_REQUEST")
    @ValueMapping(source = "MultipleItemRequest", target = "MULTIPLE_ITEM_REQUEST")
    @ValueMapping(source = "PatronRequest", target = "PATRON_REQUEST")
    @ValueMapping(source = "TransferRequest", target = "TRANSFER_REQUEST")
    @ValueMapping(source = "SupplyingLibrarysChoice", target = "SUPPLYING_LIBRARYS_CHOICE")
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeRequestSubType mapRequestSubType(RequestSubType requestSubType);

    @InheritInverseConfiguration
    RequestSubType mapRequestSubType(org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeRequestSubType requestSubType);

}
