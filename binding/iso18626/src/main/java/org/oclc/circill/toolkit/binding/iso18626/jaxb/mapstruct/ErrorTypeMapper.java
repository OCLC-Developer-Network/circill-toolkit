/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.service.iso18626.ErrorType;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorTypeMapper {

    @SuppressWarnings("java:S1214")
    ErrorTypeMapper INSTANCE = Mappers.getMapper(ErrorTypeMapper.class);

    // source is service classes, target is jaxb classes
    @ValueMapping(source = "UnsupportedActionType", target = "UNSUPPORTED_ACTION_TYPE")
    @ValueMapping(source = "UnsupportedReasonForMessageType", target = "UNSUPPORTED_REASON_FOR_MESSAGE_TYPE")
    @ValueMapping(source = "UnrecognisedDataElement", target = "UNRECOGNISED_DATA_ELEMENT")
    @ValueMapping(source = "UnrecognisedDataValue", target = "UNRECOGNISED_DATA_VALUE")
    @ValueMapping(source = "BadlyFormedMessage", target = "BADLY_FORMED_MESSAGE")
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeErrorType mapErrorType(ErrorType errorType);

    @InheritInverseConfiguration
    ErrorType mapErrorType(org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeErrorType errorType);

}
