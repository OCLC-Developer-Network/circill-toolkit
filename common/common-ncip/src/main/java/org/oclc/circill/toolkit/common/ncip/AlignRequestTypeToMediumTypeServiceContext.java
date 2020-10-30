/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.service.base.BaseServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RequestType;
import org.oclc.circill.toolkit.service.ncip.Version1RequestType;

import org.apache.log4j.Logger;

/**
 * If the RequestType is null, set it to matchingRequestType if mediumType matches the
 * mediumTypePattern, otherwise to nonMatchingRequestType.
 */
public class AlignRequestTypeToMediumTypeServiceContext extends BaseServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> {

    private static final Logger LOG = Logger.getLogger(AlignRequestTypeToMediumTypeServiceContext.class);

    private static final String DEFAULT_MEDIUM_TYPE_PATTERN = "(?i).*(Magazine|Journal).*";
    private static final RequestType DEFAULT_MATCHING_REQUEST_TYPE = Version1RequestType.NON_RETURNABLE_COPY;
    private static final RequestType DEFAULT_NON_MATCHING_REQUEST_TYPE = Version1RequestType.LOAN;

    private String mediumTypePattern = DEFAULT_MEDIUM_TYPE_PATTERN;

    private RequestType matchingRequestType = DEFAULT_MATCHING_REQUEST_TYPE;

    private RequestType nonMatchingRequestType = DEFAULT_NON_MATCHING_REQUEST_TYPE;

    public String getMediumTypePattern() {
        return mediumTypePattern;
    }

    public void setMediumTypePattern(final String mediumTypePattern) {
        this.mediumTypePattern = mediumTypePattern;
    }

    public RequestType getMatchingRequestType() {
        return matchingRequestType;
    }

    public void setMatchingRequestType(final RequestType matchingRequestType) {
        this.matchingRequestType = matchingRequestType;
    }

    public RequestType getNonMatchingRequestType() {
        return nonMatchingRequestType;
    }

    public void setNonMatchingRequestType(final RequestType nonMatchingRequestType) {
        this.nonMatchingRequestType = nonMatchingRequestType;
    }

    /**
     * Perform validation.
     *
     * @param message the message to validate
     * @throws ValidationException if an exception is thrown by {@link NCIPMessage#getInitiationData()}
     */
    @Override
    public void validateAfterUnmarshalling(final NCIPMessage message) throws ValidationException {

        try {
            final NCIPInitiationData initiationData = message.getInitiationData();
            if (initiationData instanceof RequestItemInitiationData && ((RequestItemInitiationData) initiationData).getRequestType() == null) {
                final RequestItemInitiationData requestItemInitData = (RequestItemInitiationData) initiationData;
                if (mediumTypeMatches(requestItemInitData)) {
                    LOG.debug("Setting RequestType to matchingRequestType (" + matchingRequestType + ").");
                    requestItemInitData.setRequestType(matchingRequestType);
                } else {
                    LOG.debug("Setting RequestType to nonMatchingRequestType (" + nonMatchingRequestType + ").");
                    requestItemInitData.setRequestType(nonMatchingRequestType);
                }
            }
        } catch (ToolkitException e) {
            throw new ValidationException("Couldn't get initiation data from NCIPMessage.", e);
        }
    }

    /**
     * Test whether the MediumType matches the {@link #mediumTypePattern}.
     * @param requestItemInitData the RequestItemInitiationData object to test
     * @return true if the {@link RequestItemInitiationData}'s mediumType matches the {@link #mediumTypePattern}.
     */
    private boolean mediumTypeMatches(final RequestItemInitiationData requestItemInitData) {
        return requestItemInitData.getBibliographicDescription() != null && requestItemInitData.getBibliographicDescription().getMediumType() != null
            && requestItemInitData.getBibliographicDescription().getMediumType().getValue() != null && requestItemInitData.getBibliographicDescription().getMediumType().getValue()
            .matches(getMediumTypePattern());
    }
}
