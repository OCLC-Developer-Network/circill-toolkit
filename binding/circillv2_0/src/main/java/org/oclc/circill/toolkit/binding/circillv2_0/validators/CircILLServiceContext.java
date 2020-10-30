/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.circillv2_0.validators;

import org.oclc.circill.toolkit.binding.circillv2_0.ncip.schemes.CircILLApplicationProfileType;
import org.oclc.circill.toolkit.common.ncip.NCIPServiceContext;
import org.oclc.circill.toolkit.service.base.ExceptionDescription;
import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * ServiceContext to validate the requirements in the Circ/ILL Application Profile.
 */
public class CircILLServiceContext extends NCIPServiceContext {

    @Override
    public void validateAfterUnmarshalling(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ValidationException {

        super.validateAfterUnmarshalling(ncipMessage);
        validateForCircILL(ncipMessage);
    }

    @Override
    public void validateBeforeMarshalling(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ValidationException {

        super.validateBeforeMarshalling(ncipMessage);
        validateForCircILL(ncipMessage);
    }

    private static void validateForCircILL(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ValidationException {
        final List<ExceptionDescription> problemList;
        if (ncipMessage.isInitiationMessage()) {
            problemList = validateInitiationMessage(ncipMessage);
        } else {
            problemList = validateResponseMessage(ncipMessage);
        }
        if (CollectionUtils.isNotEmpty(problemList)) {
            throw new ValidationException(problemList);
        }
    }

    private static List<ExceptionDescription> validateInitiationMessage(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ValidationException {
        final List<ExceptionDescription> problemList = new ArrayList<>();
        try {
            final NCIPInitiationData initData = ncipMessage.getInitiationData();
            final InitiationHeader initHeader = initData.getInitiationHeader();
            if (initHeader != null) {
                if (initHeader.getToAgencyId() == null) {
                    problemList.add(createExceptionDescriptionForMissingElement("ToAgencyId"));
                }
                if (initHeader.getFromAgencyId() == null) {
                    problemList.add(createExceptionDescriptionForMissingElement("FromAgencyId"));
                }
                if (initHeader.getApplicationProfileType() == null) {
                    problemList.add(createExceptionDescriptionForMissingElement("ApplicationProfileType"));
                } else if (!CircILLApplicationProfileType.VERSION_2_0.equals(initHeader.getApplicationProfileType())) {
                    problemList.add(new ExceptionDescription(
                        "Circ/ILL NCIP Application Profile Version 2.00 requires Scheme URI \"" + CircILLApplicationProfileType.VERSION_2_0.getScheme() + "\", Value \""
                            + CircILLApplicationProfileType.VERSION_2_0.getValue() + "\".", Version1GeneralProcessingError.NEEDED_DATA_MISSING.getScheme(),
                        Version1GeneralProcessingError.NEEDED_DATA_MISSING.getValue(), "//ApplicationProfileType", null));
                }
            } else {
                problemList.add(createExceptionDescriptionForMissingElement("InitiationHeader"));
            }
        } catch (ToolkitException e) {
            throw new ValidationException(e.getLocalizedMessage(), Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(),
                Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), "NCIPMessage", null);
        }
        return problemList;
    }

    private static List<ExceptionDescription> validateResponseMessage(final NCIPMessage<NCIPInitiationData, NCIPResponseData> ncipMessage) throws ValidationException {
        final List<ExceptionDescription> problemList = new ArrayList<>();
        try {
            final NCIPResponseData responseData = ncipMessage.getResponseData();
            final ResponseHeader responseHeader = (ResponseHeader) ReflectionHelper.getSimpleField(responseData, "ResponseHeader");
            if (responseHeader != null) {
                if (responseHeader.getToAgencyId() == null) {
                    problemList.add(createExceptionDescriptionForMissingElement("ToAgencyId"));
                }
                if (responseHeader.getFromAgencyId() == null) {
                    problemList.add(createExceptionDescriptionForMissingElement("FromAgencyId"));
                }
            } else {
                problemList.add(createExceptionDescriptionForMissingElement("ResponseHeader"));
            }
        } catch (ToolkitException e) {
            throw new ValidationException(e.getLocalizedMessage(), Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(),
                Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), "NCIPMessage", null);
        }
        return problemList;
    }

    private static ExceptionDescription createExceptionDescriptionForMissingElement(final String elementName) {
        return new ExceptionDescription("Circ/ILL NCIP Application Profile Version 2.00 requires " + elementName + ".",
            Version1GeneralProcessingError.NEEDED_DATA_MISSING.getScheme(), Version1GeneralProcessingError.NEEDED_DATA_MISSING.getValue(), "//" + elementName, null);
    }
}
