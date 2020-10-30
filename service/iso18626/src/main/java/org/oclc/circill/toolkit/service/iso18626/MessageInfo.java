/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/13/18.
 */
public class MessageInfo {

    protected ReasonForMessage reasonForMessage;
    protected YesNoType answerYesNo;
    protected String note;
    protected ReasonUnfilledType reasonUnfilled;
    protected ReasonRetryType reasonRetry;
    protected Costs offeredCosts;
    protected Calendar retryAfter;
    protected Calendar retryBefore;

    public ReasonForMessage getReasonForMessage() {
        return reasonForMessage;
    }

    public void setReasonForMessage(final ReasonForMessage reasonForMessage) {
        this.reasonForMessage = reasonForMessage;
    }

    public YesNoType getAnswerYesNo() {
        return answerYesNo;
    }

    public void setAnswerYesNo(final YesNoType answerYesNo) {
        this.answerYesNo = answerYesNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    public ReasonUnfilledType getReasonUnfilled() {
        return reasonUnfilled;
    }

    public void setReasonUnfilled(final ReasonUnfilledType reasonUnfilled) {
        this.reasonUnfilled = reasonUnfilled;
    }

    public ReasonRetryType getReasonRetry() {
        return reasonRetry;
    }

    public void setReasonRetry(final ReasonRetryType reasonRetry) {
        this.reasonRetry = reasonRetry;
    }

    public Costs getOfferedCosts() {
        return offeredCosts;
    }

    public void setOfferedCosts(final Costs offeredCosts) {
        this.offeredCosts = offeredCosts;
    }

    public Calendar getRetryAfter() {
        return retryAfter;
    }

    public void setRetryAfter(final Calendar retryAfter) {
        this.retryAfter = retryAfter;
    }

    public Calendar getRetryBefore() {
        return retryBefore;
    }

    public void setRetryBefore(final Calendar retryBefore) {
        this.retryBefore = retryBefore;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final MessageInfo rhs = (MessageInfo) obj;
        final boolean result = new EqualsBuilder().append(reasonForMessage, rhs.reasonForMessage).append(answerYesNo, rhs.answerYesNo).append(note, rhs.note)
            .append(reasonUnfilled, rhs.reasonUnfilled).append(reasonRetry, rhs.reasonRetry).append(offeredCosts, rhs.offeredCosts).append(retryAfter, rhs.retryAfter)
            .append(retryBefore, rhs.retryBefore).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(804872853, 1004693249).append(reasonForMessage).append(answerYesNo).append(note).append(reasonUnfilled).append(reasonRetry)
            .append(offeredCosts).append(retryAfter).append(retryBefore).toHashCode();
        return result;
    }

}
