/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the SendUserNoticeResponse.
 */
public class SendUserNoticeResponseData implements NCIPResponseData {

    /**
     * ResponseHeader
     */
    protected ResponseHeader responseHeader;

    /**
     * Set ResponseHeader.
     * @param responseHeader the {@link ResponseHeader}
     */
    public void setResponseHeader(final ResponseHeader responseHeader) {

        this.responseHeader = responseHeader;

    }

    /**
     * Get ResponseHeader.
     *
     * @return the {@link ResponseHeader}
     */
    public ResponseHeader getResponseHeader() {

        return responseHeader;

    }

    /**
     * Problems
     */
    protected List<Problem> problems = new ArrayList<>();

    /**
     * Set Problems.
     * @param problems the (possibly null) list of (possibly empty) Problems
     */
    public void setProblems(final List<Problem> problems) {

        this.problems = problems;

    }

    /**
     * Get Problems.
     */
    @Override
    public List<Problem> getProblems() {

        return problems;

    }

    /**
     * UserId
     */
    protected UserId userId;

    /**
     * Set UserId.
     * @param userId the {@link UserId}
     */
    public void setUserId(final UserId userId) {

        this.userId = userId;

    }

    /**
     * Get UserId.
     *
     * @return the {@link UserId}
     */
    public UserId getUserId() {

        return userId;

    }

    /**
     * DateSent
     */
    protected GregorianCalendar dateSent;

    /**
     * Set DateSent.
     *
     * @param dateSent the date the notice was sent
     */
    public void setDateSent(final GregorianCalendar dateSent) {

        this.dateSent = dateSent;

    }

    /**
     * Get DateSent.
     *
     * @return the date/time the notice was sent
     */
    public GregorianCalendar getDateSent() {

        return dateSent;

    }

    /**
     * DateWillSend
     */
    protected GregorianCalendar dateWillSend;

    /**
     * Set DateWillSend.
     *
     * @param dateWillSend when the agency will send the notice
     */
    public void setDateWillSend(final GregorianCalendar dateWillSend) {

        this.dateWillSend = dateWillSend;

    }

    /**
     * Get DateWillSend.
     *
     * @return the date/time the notie will be sent
     */
    public GregorianCalendar getDateWillSend() {

        return dateWillSend;

    }

    /**
     * Generic toString() implementation.
     *
     * @return String
     */
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
        final SendUserNoticeResponseData rhs = (SendUserNoticeResponseData) obj;
        return new EqualsBuilder().append(responseHeader, rhs.responseHeader).append(problems, rhs.problems).append(userId, rhs.userId)
            .append(dateSent, rhs.dateSent).append(dateWillSend, rhs.dateWillSend).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1355378725, 1099675467).append(responseHeader).append(problems).append(userId).append(dateSent).append(dateWillSend)
            .toHashCode();
        return result;
    }
}
