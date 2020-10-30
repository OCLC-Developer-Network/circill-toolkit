/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.service.iso18626.Status;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatusMapper {

    @SuppressWarnings("java:S1214")
    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    // source is service classes, target is jaxb classes
    @ValueMapping(source = "RequestReceived", target = "REQUEST_RECEIVED")
    @ValueMapping(source = "ExpectToSupply", target = "EXPECT_TO_SUPPLY")
    @ValueMapping(source = "WillSupply", target = "WILL_SUPPLY")
    @ValueMapping(source = "Loaned", target = "LOANED")
    @ValueMapping(source = "Overdue", target = "OVERDUE")
    @ValueMapping(source = "Recalled", target = "RECALLED")
    @ValueMapping(source = "RetryPossible", target = "RETRY_POSSIBLE")
    @ValueMapping(source = "Unfilled", target = "UNFILLED")
    @ValueMapping(source = "CopyCompleted", target = "COPY_COMPLETED")
    @ValueMapping(source = "LoanCompleted", target = "LOAN_COMPLETED")
    @ValueMapping(source = "CompletedWithoutReturn", target = "COMPLETED_WITHOUT_RETURN")
    @ValueMapping(source = "Cancelled", target = "CANCELLED")
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeStatus mapStatus(Status status);

    @InheritInverseConfiguration
    Status mapStatus(org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeStatus status);

}
