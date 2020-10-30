/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the UserNoticeSent service.
 */
public class UserNoticeSentInitiationData implements NCIPInitiationData {

    /**
     * InitiationHeader
     */
    protected InitiationHeader initiationHeader;

    /**
     * Set InitiationHeader.
     */
    @Override
    public void setInitiationHeader(final InitiationHeader initiationHeader) {

        this.initiationHeader = initiationHeader;

    }

    /**
     * Get InitiationHeader.
     */
    @Override
    public InitiationHeader getInitiationHeader() {

        return initiationHeader;

    }

    /**
     * Relying Party Id
     */
    protected AgencyId relyingPartyId;

    /**
     * Get the RelyingPartyId.
     *
     * @return the RelyingPartyId
     */
    @Override
    public AgencyId getRelyingPartyId() {
        return relyingPartyId;
    }

    /**
     * Set the RelyingPartyId.
     *
     * @param relyingPartyId the RelyingPartyId
     */
    @Override
    public void setRelyingPartyId(final AgencyId relyingPartyId) {
        this.relyingPartyId = relyingPartyId;
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
     * @return the date the notice was sent
     */
    public GregorianCalendar getDateSent() {

        return dateSent;

    }

    /**
     * UserNoticeDetails
     */
    protected UserNoticeDetails userNoticeDetails;

    /**
     * Set UserNoticeDetails.
     *
     * @param userNoticeDetails the {@link UserNoticeDetails}
     */
    public void setUserNoticeDetails(final UserNoticeDetails userNoticeDetails) {

        this.userNoticeDetails = userNoticeDetails;

    }

    /**
     * Get UserNoticeDetails.
     *
     * @return the {@link UserNoticeDetails}
     */
    public UserNoticeDetails getUserNoticeDetails() {

        return userNoticeDetails;

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
        final UserNoticeSentInitiationData rhs = (UserNoticeSentInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId).append(userId, rhs.userId)
            .append(dateSent, rhs.dateSent).append(userNoticeDetails, rhs.userNoticeDetails).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(120999981, 324050179).append(initiationHeader).append(relyingPartyId).append(userId).append(dateSent)
            .append(userNoticeDetails).toHashCode();
        return result;
    }
}
