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
 * Data to initiate the SendUserNotice service.
 */
public class SendUserNoticeInitiationData implements NCIPInitiationData {

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
     * MandatedAction
     */
    protected MandatedAction mandatedAction;

    /**
     * Set MandatedAction.
     *
     * @param mandatedAction the {@link MandatedAction}
     */
    public void setMandatedAction(final MandatedAction mandatedAction) {

        this.mandatedAction = mandatedAction;

    }

    /**
     * Get MandatedAction.
     *
     * @return the {@link MandatedAction}
     */
    public MandatedAction getMandatedAction() {

        return mandatedAction;

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
     * DateToSend
     */
    protected GregorianCalendar dateToSend;

    /**
     * Set DateToSend.
     *
     * @param dateToSend when the notice should be sent
     */
    public void setDateToSend(final GregorianCalendar dateToSend) {

        this.dateToSend = dateToSend;

    }

    /**
     * Get DateToSend.
     *
     * @return the date/time the notice should be sent
     */
    public GregorianCalendar getDateToSend() {

        return dateToSend;

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
        final SendUserNoticeInitiationData rhs = (SendUserNoticeInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId)
            .append(mandatedAction, rhs.mandatedAction).append(userId, rhs.userId).append(dateToSend, rhs.dateToSend).append(userNoticeDetails, rhs.userNoticeDetails).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(465702855, 1025975273).append(initiationHeader).append(relyingPartyId).append(mandatedAction).append(userId)
            .append(dateToSend).append(userNoticeDetails).toHashCode();
        return result;
    }
}
