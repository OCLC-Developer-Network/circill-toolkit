/*
 * Copyright (c) 2015 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents identifiers for user notices.
 */
public class NoticeId {

    /**
     * The identifier of this notice.
     */
    protected String noticeIdentifierValue;
    /**
     * The id of the agency associated with this notice.
     */
    protected AgencyId agencyId;
    /**
     * The type of the identifier, indicates whether e.g. this is an notice record #, notice timestamp, etc.
     */
    protected NoticeIdentifierType noticeIdentifierType;

    public void setNoticeIdentifierValue(final String noticeIdentifierValue) {
        this.noticeIdentifierValue = noticeIdentifierValue;
    }

    /**
     * Returns the identifier value.
     *
     * @return the identifier value
     */
    public String getNoticeIdentifierValue() {
        return noticeIdentifierValue;
    }

    public void setNoticeIdentifierType(final NoticeIdentifierType noticeIdentifierType) {
        this.noticeIdentifierType = noticeIdentifierType;
    }

    /**
     * Returns the id's identifier type.
     *
     * @return the id's identifier type
     */
    public NoticeIdentifierType getNoticeIdentifierType() {
        return noticeIdentifierType;
    }

    public void setAgencyId(final AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * Returns the id's agency id.
     *
     * @return the id's agency id
     */
    public AgencyId getAgencyId() {
        return agencyId;
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
        final NoticeId rhs = (NoticeId) obj;
        return new EqualsBuilder().append(noticeIdentifierValue, rhs.noticeIdentifierValue).append(agencyId, rhs.agencyId).append(noticeIdentifierType, rhs.noticeIdentifierType)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1895508875, 652749153).append(noticeIdentifierValue).append(agencyId).append(noticeIdentifierType).toHashCode();
        return result;
    }
}
