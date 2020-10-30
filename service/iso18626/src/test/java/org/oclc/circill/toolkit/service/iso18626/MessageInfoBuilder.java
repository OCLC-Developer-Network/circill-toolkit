/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.Calendar;

@SuppressWarnings("ReturnOfThis")
public final class MessageInfoBuilder {

    private ReasonForMessage reasonForMessage;
    private YesNoType answerYesNo;
    private String note;
    private ReasonUnfilledType reasonUnfilled;
    private ReasonRetryType reasonRetry;
    private Costs offeredCosts;
    private Calendar retryAfter;
    private Calendar retryBefore;

    /**
     * This utility class does not allow instances.
     */
    private MessageInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link MessageInfo}
     */
    public static MessageInfoBuilder aMessageInfo() {
        final MessageInfoBuilder builder = new MessageInfoBuilder();
        return builder;
    }

    public MessageInfoBuilder withReasonForMessage(final ReasonForMessage reasonForMessage) {
        this.reasonForMessage = reasonForMessage;
        return this;
    }

    public MessageInfoBuilder withAnswerYesNo(final YesNoType answerYesNo) {
        this.answerYesNo = answerYesNo;
        return this;
    }

    public MessageInfoBuilder withNote(final String note) {
        this.note = note;
        return this;
    }

    public MessageInfoBuilder withReasonUnfilled(final ReasonUnfilledType reasonUnfilled) {
        this.reasonUnfilled = reasonUnfilled;
        return this;
    }

    public MessageInfoBuilder withReasonRetry(final ReasonRetryType reasonRetry) {
        this.reasonRetry = reasonRetry;
        return this;
    }

    public MessageInfoBuilder withOfferedCosts(final Costs offeredCosts) {
        this.offeredCosts = offeredCosts;
        return this;
    }

    public MessageInfoBuilder withRetryAfter(final Calendar retryAfter) {
        this.retryAfter = retryAfter;
        return this;
    }

    public MessageInfoBuilder withRetryBefore(final Calendar retryBefore) {
        this.retryBefore = retryBefore;
        return this;
    }

    public MessageInfo build() {
        final MessageInfo messageInfo = new MessageInfo();
        messageInfo.setReasonForMessage(reasonForMessage);
        messageInfo.setAnswerYesNo(answerYesNo);
        messageInfo.setNote(note);
        messageInfo.setReasonUnfilled(reasonUnfilled);
        messageInfo.setReasonRetry(reasonRetry);
        messageInfo.setOfferedCosts(offeredCosts);
        messageInfo.setRetryAfter(retryAfter);
        messageInfo.setRetryBefore(retryBefore);
        return messageInfo;
    }

}

