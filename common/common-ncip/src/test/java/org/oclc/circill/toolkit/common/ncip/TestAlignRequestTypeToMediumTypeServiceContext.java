/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.BibliographicDescription;
import org.oclc.circill.toolkit.service.ncip.LookupItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.MediumType;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RequestType;
import org.oclc.circill.toolkit.service.ncip.Version1MediumType;
import org.oclc.circill.toolkit.service.ncip.Version1RequestType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.Test;

/**
 * Test AlignRequestTypeToMediumTypeServiceContext.
 */
public class TestAlignRequestTypeToMediumTypeServiceContext {

    private final RequestType LOAN = Version1RequestType.LOAN;
    private final RequestType COPY = Version1RequestType.NON_RETURNABLE_COPY;
    private final MediumType BOOK = Version1MediumType.BOOK;
    private final MediumType MAGAZINE = Version1MediumType.MAGAZINE;
    private final MediumType JOURNAL = Version1MediumType.BOUND_JOURNAL;

    private final AlignRequestTypeToMediumTypeServiceContext validator = new AlignRequestTypeToMediumTypeServiceContext();

    @Test
    public void testNotRequestItem() throws ValidationException {
        final NCIPMessage message = new NCIPMessage();
        message.setLookupItem(new LookupItemInitiationData());
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem(), is(nullValue()));
    }

    @Test
    public void testNoBibDesc() throws ValidationException {
        final NCIPMessage message = new NCIPMessage();
        message.setRequestItem(new RequestItemInitiationData());
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(LOAN)));
        assertThat(message.getRequestItem().getBibliographicDescription(), is(nullValue()));
    }

    @Test
    public void testNoMediumType() throws ValidationException {
        final NCIPMessage message = createMessage(null, null);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(LOAN)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(nullValue()));
    }

    @Test
    public void testLoanWithBookMediumType() throws ValidationException {
        final NCIPMessage message = createMessage(BOOK, LOAN);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(LOAN)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(BOOK)));
    }

    @Test
    public void testCopyWithMagazineMediumType() throws ValidationException {
        final NCIPMessage message = createMessage(MAGAZINE, COPY);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(COPY)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(MAGAZINE)));
    }

    @Test
    public void testUnsetRequestTypeWithBookMediumType() throws ValidationException {
        final NCIPMessage message = createMessage(BOOK, null);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(LOAN)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(BOOK)));
    }

    @Test
    public void testUnsetRequestTypeWithMagazineMediumType() throws ValidationException {
        final NCIPMessage message = createMessage(MAGAZINE, null);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(COPY)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(MAGAZINE)));
    }

    @Test
    public void testUnsetRequestTypeWithJournalMediumType() throws ValidationException {
        final NCIPMessage message = createMessage(JOURNAL, null);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(COPY)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(JOURNAL)));
    }

    @Test
    public void testPatternOverrideMatches() throws ValidationException {
        final NCIPMessage message = createMessage(Version1MediumType.BOOK_WITH_AUDIO_TAPE, null);
        final AlignRequestTypeToMediumTypeServiceContext validator = new AlignRequestTypeToMediumTypeServiceContext();
        validator.setMediumTypePattern("(?i).*with audio tape.*");
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(COPY)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(Version1MediumType.BOOK_WITH_AUDIO_TAPE)));
    }

    @Test
    public void testPatternOverrideDoesntMatch() throws ValidationException {
        final NCIPMessage message = createMessage(Version1MediumType.BOOK_WITH_COMPACT_DISC, null);
        final AlignRequestTypeToMediumTypeServiceContext validator = new AlignRequestTypeToMediumTypeServiceContext();
        validator.setMediumTypePattern("(?i).*with audio tape.*");
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(not(equalTo(COPY))));
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(LOAN)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(Version1MediumType.BOOK_WITH_COMPACT_DISC)));
    }

    @Test
    public void testPatternAndMatchNonMatchTypeOverridesDoesMatch() throws ValidationException {
        final NCIPMessage message = createMessage(Version1MediumType.BOOK_WITH_COMPACT_DISC, null);
        final AlignRequestTypeToMediumTypeServiceContext validator = new AlignRequestTypeToMediumTypeServiceContext();
        validator.setMediumTypePattern("(?i).* Compact Disc.*");
        validator.setMatchingRequestType(Version1RequestType.ESTIMATE);
        validator.setNonMatchingRequestType(Version1RequestType.STACK_RETRIEVAL);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(Version1RequestType.ESTIMATE)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(Version1MediumType.BOOK_WITH_COMPACT_DISC)));
    }

    @Test
    public void testPatternAndMatchNonMatchTypeOverridesDoesntMatch() throws ValidationException {
        final NCIPMessage message = createMessage(Version1MediumType.BOOK_WITH_COMPACT_DISC, null);
        final AlignRequestTypeToMediumTypeServiceContext validator = new AlignRequestTypeToMediumTypeServiceContext();
        validator.setMediumTypePattern("(?i).*with audio tape.*");
        validator.setMatchingRequestType(Version1RequestType.ESTIMATE);
        validator.setNonMatchingRequestType(Version1RequestType.STACK_RETRIEVAL);
        validator.validateAfterUnmarshalling(message);
        assertThat(message.getRequestItem().getRequestType(), is(not(equalTo(Version1RequestType.ESTIMATE))));
        assertThat(message.getRequestItem().getRequestType(), is(equalTo(Version1RequestType.STACK_RETRIEVAL)));
        assertThat(message.getRequestItem().getBibliographicDescription().getMediumType(), is(equalTo(Version1MediumType.BOOK_WITH_COMPACT_DISC)));
    }

    private NCIPMessage createMessage(final MediumType mediumType, final RequestType requestType) {
        final BibliographicDescription bibDesc = new BibliographicDescription();
        bibDesc.setMediumType(mediumType);
        final RequestItemInitiationData initData = new RequestItemInitiationData();
        initData.setBibliographicDescription(bibDesc);
        initData.setRequestType(requestType);
        final NCIPMessage message = new NCIPMessage();
        message.setRequestItem(initData);
        return message;
    }
}
