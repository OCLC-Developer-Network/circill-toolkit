/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ValidationException;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * To reduce the chance of validation errors, ensure that any returned Problem elements have a ProblemType;
 * if not set it to a ProblemType with null scheme and value {@link #UNSPECIFIED_PROBLEM_TYPE_VALUE}.
 */
public class EnsureProblemTypeServiceContext implements ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> {

    private static final String UNSPECIFIED_PROBLEM_TYPE_VALUE = "Unspecified Type";
    public static final ProblemType UNSPECIFIED_PROBLEM_TYPE = new ProblemType(UNSPECIFIED_PROBLEM_TYPE_VALUE);

    /**
     * Ensure all Problem elements have a ProblemType.
     *
     * @param message the message to validate
     * @throws ValidationException if {@link #validate} throws an exception
     */
    @Override
    public void validateBeforeMarshalling(final NCIPMessage<NCIPInitiationData, NCIPResponseData> message) throws ValidationException {
        if (message.isResponseMessage()) {
            try {
                validate(message.getResponseData());
            } catch (ToolkitException e) {
                throw new ValidationException("Can't get ResponseData.", e);
            }
        }
    }

    /**
     * Ensure all Problem elements have a ProblemType.
     *
     * @param message the message to validate
     * @throws ValidationException if {@link #validate} throws an exception
     */
    @Override
    public void validateAfterUnmarshalling(final NCIPMessage<NCIPInitiationData, NCIPResponseData> message) throws ValidationException {
        if (message.isResponseMessage()) {
            try {
                validate(message.getResponseData());
            } catch (ToolkitException e) {
                throw new ValidationException("Can't get ResponseData.", e);
            }
        }
    }

    /**
     * If the ncipMessage has a list of Problems, call the {@link #setMissingProblemTypes(Collection)} method on it.
     * @param ncipMessage the {@link NCIPMessage} to validate
     * @throws ValidationException if an exception is thrown getting the list of Problems
     */
    private void validate(final NCIPResponseData ncipMessage) throws ValidationException {
        try {
            final List<Problem> problems = ncipMessage.getProblems();
            setMissingProblemTypes(problems);
        } catch (Exception e) {
            throw new ValidationException("Exception getting Problem eleents from message.", Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getScheme(),
                Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE.getValue(), null, null, e);
        }
    }

    /**
     * For any {@link Problem}s that have a null ProblemType, set them to {@link #UNSPECIFIED_PROBLEM_TYPE}.
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    private void setMissingProblemTypes(final Collection<Problem> problems) {
        if (CollectionUtils.isNotEmpty(problems)) {
            for (final Problem problem : problems) {
                if (problem.getProblemType() == null) {
                    problem.setProblemType(UNSPECIFIED_PROBLEM_TYPE);
                }
            }
        }
    }

}
