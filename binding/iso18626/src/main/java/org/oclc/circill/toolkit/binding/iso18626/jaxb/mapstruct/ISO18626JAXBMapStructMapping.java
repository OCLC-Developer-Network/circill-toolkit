/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.TypeSchemeValuePair;
import org.oclc.circill.toolkit.binding.jaxb.mapstruct.BaseMapStructMapper;
import org.oclc.circill.toolkit.service.base.BibliographicItemIdentifierCode;
import org.oclc.circill.toolkit.service.base.BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.ElectronicAddressType;
import org.oclc.circill.toolkit.service.base.PaymentMethodType;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.iso18626.AgencyIdType;
import org.oclc.circill.toolkit.service.iso18626.BillingMethodType;
import org.oclc.circill.toolkit.service.iso18626.CopyrightComplianceType;
import org.oclc.circill.toolkit.service.iso18626.CountryType;
import org.oclc.circill.toolkit.service.iso18626.DeliveredFormatType;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;
import org.oclc.circill.toolkit.service.iso18626.LoanConditionType;
import org.oclc.circill.toolkit.service.iso18626.PatronType;
import org.oclc.circill.toolkit.service.iso18626.PreferredFormatType;
import org.oclc.circill.toolkit.service.iso18626.PublicationType;
import org.oclc.circill.toolkit.service.iso18626.ReasonRetryType;
import org.oclc.circill.toolkit.service.iso18626.ReasonUnfilledType;
import org.oclc.circill.toolkit.service.iso18626.RegionType;
import org.oclc.circill.toolkit.service.iso18626.SentViaType;
import org.oclc.circill.toolkit.service.iso18626.ServiceLevelType;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * A mapper for ISO 18626 objects that uses MapStruct.
 */
@Mapper(uses = { ActionMapper.class, ErrorTypeMapper.class, ReasonForMessageMapper.class, RequestTypeMapper.class, RequestSubTypeMapper.class, ServiceTypeMapper.class,
    StatusMapper.class })
public interface ISO18626JAXBMapStructMapping extends BaseMapStructMapper<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>,
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.ISO18626Message> {

    @SuppressWarnings("java:S1214")
    ISO18626JAXBMapStructMapping INSTANCE = Mappers.getMapper(ISO18626JAXBMapStructMapping.class);

    // Source is service classes, target is jaxb classes
    @Override
    @Mapping(source = "request.bibliographicInfo.bibliographicItemIds", target = "request.bibliographicInfo.bibliographicItemId")
    @Mapping(source = "request.bibliographicInfo.bibliographicRecordIds", target = "request.bibliographicInfo.bibliographicRecordId")
    @Mapping(source = "request.requestingAgencyInfo.addresses", target = "request.requestingAgencyInfo.address")
    @Mapping(source = "request.patronInfo.addresses", target = "request.patronInfo.address")
    @Mapping(source = "request.supplierInfos", target = "request.supplierInfo")
    @Mapping(source = "request.requestedDeliveryInfos", target = "request.requestedDeliveryInfo")
    @Mapping(source = "request.serviceInfo.requestSubTypes", target = "request.serviceInfo.requestSubType")
    org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.ISO18626Message mapMessage(ISO18626Message svcMsg);

    @Override
    @InheritInverseConfiguration
    // Ignoring the property names associated with single-value getters/setters which have collection getters/setters.
    // The mapping will be done using the collection getters/setters.
    @Mapping(ignore = true, target = "request.bibliographicInfo.bibliographicItemId")
    @Mapping(ignore = true, target = "request.bibliographicInfo.bibliographicRecordId")
    @Mapping(ignore = true, target = "request.patronInfo.address")
    @Mapping(ignore = true, target = "request.serviceInfo.requestSubType")
    @Mapping(ignore = true, target = "request.requestingAgencyInfo.address")
    @Mapping(ignore = true, target = "request.supplierInfo")
    @Mapping(ignore = true, target = "request.requestedDeliveryInfo")
    ISO18626Message mapMessage(org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.ISO18626Message jaxbMsg);

    default AgencyIdType typeSchemeValuePairToAgencyIdType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return AgencyIdType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default PublicationType typeSchemeValuePairToPublicationType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return PublicationType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default BibliographicRecordIdentifierCode typeSchemeValuePairToBibliographicRecordIdentifierCode(final TypeSchemeValuePair typeSchemeValuePair)
        throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return BibliographicRecordIdentifierCode.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default BibliographicItemIdentifierCode typeSchemeValuePairToBibliographicItemIdentifierCode(final TypeSchemeValuePair typeSchemeValuePair)
        throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return BibliographicItemIdentifierCode.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default DeliveredFormatType typeSchemeValuePairToDeliveredFormatType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return DeliveredFormatType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default LoanConditionType typeSchemeValuePairToLoanConditionType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return LoanConditionType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default SentViaType typeSchemeValuePairToSentViaType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return SentViaType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default ReasonRetryType typeSchemeValuePairToReasonRetryType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return ReasonRetryType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default ReasonUnfilledType typeSchemeValuePairToReasonUnfilledType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return ReasonUnfilledType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default BillingMethodType typeSchemeValuePairToBillingMethodType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return BillingMethodType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default CurrencyCode typeSchemeValuePairToCurrencyCode(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return CurrencyCode.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default PaymentMethodType typeSchemeValuePairToPaymentMethodType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return PaymentMethodType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default PatronType typeSchemeValuePairToPatronType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return PatronType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default CountryType typeSchemeValuePairToCountryType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return CountryType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default RegionType typeSchemeValuePairToRegionType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return RegionType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default ElectronicAddressType typeSchemeValuePairToElectronicAddressType(final TypeSchemeValuePair typeSchemeValuePair)
        throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return ElectronicAddressType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default ServiceLevelType typeSchemeValuePairToServiceLevelType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return ServiceLevelType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default PreferredFormatType typeSchemeValuePairToPreferredFormatType(final TypeSchemeValuePair typeSchemeValuePair) throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return PreferredFormatType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

    default CopyrightComplianceType typeSchemeValuePairToCopyrightComplianceType(final TypeSchemeValuePair typeSchemeValuePair)
        throws ToolkitInternalException, ConfigurationException {
        if (typeSchemeValuePair == null) {
            return null;
        }
        return CopyrightComplianceType.find(typeSchemeValuePair.getScheme(), typeSchemeValuePair.getValue());
    }

}
