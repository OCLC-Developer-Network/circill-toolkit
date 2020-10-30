/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.Test;

/**
 * Test EnsureProblemTypeServiceContext.
 */
public class TestEnsureProblemTypeServiceContext {

    private final EnsureProblemTypeServiceContext validator = new EnsureProblemTypeServiceContext();

    private static final ProblemType SPECIFIED_PROBLEM_TYPE = Version1AcceptItemProcessingError.CANNOT_ACCEPT_ITEM; // Any specific problem type will do.
    private static final ProblemType OTHER_SPECIFIED_PROBLEM_TYPE = Version1CancelRequestItemProcessingError.REQUEST_ALREADY_PROCESSED; // Any other specific problem type will do.
    private static final Problem PROBLEM_WITHOUT_PROBLEM_TYPE = new Problem();
    private static final Problem OTHER_PROBLEM_WITHOUT_PROBLEM_TYPE = new Problem();
    private static final Problem PROBLEM_WITH_PROBLEM_TYPE = new Problem();

    static {
        PROBLEM_WITH_PROBLEM_TYPE.setProblemType(SPECIFIED_PROBLEM_TYPE);
    }

    private static final Problem OTHER_PROBLEM_WITH_PROBLEM_TYPE = new Problem();

    static {
        OTHER_PROBLEM_WITH_PROBLEM_TYPE.setProblemType(OTHER_SPECIFIED_PROBLEM_TYPE);
    }

    @Test
    public void testInitiationDataAfterUnmarshalling() throws Exception {
        final NCIPMessage message = new NCIPMessage();
        message.setLookupUser(new LookupUserInitiationData());
        validator.validateAfterUnmarshalling(message);
    }

    @Test
    public void testInitiationDataBeforeMarshalling() throws Exception {
        final NCIPMessage message = new NCIPMessage();
        message.setLookupUser(new LookupUserInitiationData());
        validator.validateBeforeMarshalling(message);
    }

    @Test
    public void testNoProblemTypeAfterUnmarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITHOUT_PROBLEM_TYPE);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0).getProblemType(), is(EnsureProblemTypeServiceContext.UNSPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testValidProblemTypeAfterUnmarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITH_PROBLEM_TYPE);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0).getProblemType(), is(SPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testMultipleProblemTypesAllValidAfterUnmarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITH_PROBLEM_TYPE, OTHER_PROBLEM_WITH_PROBLEM_TYPE);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().stream().map(Problem::getProblemType).collect(Collectors.toList()),
            contains(SPECIFIED_PROBLEM_TYPE, OTHER_SPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testMultipleProblemTypesAllInvalidAfterUnmarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITHOUT_PROBLEM_TYPE, OTHER_PROBLEM_WITHOUT_PROBLEM_TYPE);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().stream().map(Problem::getProblemType).collect(Collectors.toList()),
            contains(EnsureProblemTypeServiceContext.UNSPECIFIED_PROBLEM_TYPE, EnsureProblemTypeServiceContext.UNSPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testMultipleProblemTypesMixOfValidAndInvalidAfterUnmarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITH_PROBLEM_TYPE, PROBLEM_WITHOUT_PROBLEM_TYPE);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().stream().map(Problem::getProblemType).collect(Collectors.toList()),
            contains(SPECIFIED_PROBLEM_TYPE, EnsureProblemTypeServiceContext.UNSPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testNoProblemTypeBeforeMarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITHOUT_PROBLEM_TYPE);
        validator.validateBeforeMarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0).getProblemType(), is(EnsureProblemTypeServiceContext.UNSPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testValidProblemTypeBeforeMarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITH_PROBLEM_TYPE);
        validator.validateBeforeMarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0).getProblemType(), is(SPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testMultipleProblemTypesAllValidBeforeMarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITH_PROBLEM_TYPE, OTHER_PROBLEM_WITH_PROBLEM_TYPE);
        validator.validateBeforeMarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().stream().map(Problem::getProblemType).collect(Collectors.toList()),
            contains(SPECIFIED_PROBLEM_TYPE, OTHER_SPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testMultipleProblemTypesAllInvalidBeforeMarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITHOUT_PROBLEM_TYPE, OTHER_PROBLEM_WITHOUT_PROBLEM_TYPE);
        validator.validateBeforeMarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().stream().map(Problem::getProblemType).collect(Collectors.toList()),
            contains(EnsureProblemTypeServiceContext.UNSPECIFIED_PROBLEM_TYPE, EnsureProblemTypeServiceContext.UNSPECIFIED_PROBLEM_TYPE));
    }

    @Test
    public void testMultipleProblemTypesMixOfValidAndInvalidBeforeMarshalling() throws Exception {
        final NCIPMessage message = setupMessage(PROBLEM_WITH_PROBLEM_TYPE, PROBLEM_WITHOUT_PROBLEM_TYPE);
        validator.validateBeforeMarshalling(message);
        assertThat(message.getProblemResponse(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems(), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().get(0), is(not(nullValue())));
        assertThat(message.getProblemResponse().getProblems().stream().map(Problem::getProblemType).collect(Collectors.toList()),
            contains(SPECIFIED_PROBLEM_TYPE, EnsureProblemTypeServiceContext.UNSPECIFIED_PROBLEM_TYPE));
    }

    private NCIPMessage setupMessage(final Problem... problems) {
        final NCIPMessage message = new NCIPMessage();
        message.setProblemResponse(new ProblemResponseData());
        final List<Problem> problemList = new ArrayList<>();
        for (final Problem p : problems) {
            problemList.add(copyProblem(p));
        }
        message.getProblemResponse().setProblems(problemList);
        return message;
    }

    /**
     * Copy the Problem so the Validator can change the ProblemType without affecting subsequent tests.
     * @param in the {@link Problem} to copy
     * @return a copy of the input {@link Problem}
     */
    private Problem copyProblem(final Problem in) {
        final Problem out = new Problem();
        out.setProblemType(in.getProblemType());
        out.setProblemDetail(in.getProblemDetail());
        out.setProblemElement(in.getProblemElement());
        out.setProblemValue(in.getProblemValue());
        return out;
    }
}
