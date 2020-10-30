/*
 * Copyright (c) 2015 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ElectronicAddressType;

import java.util.GregorianCalendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class NoticeInformation {

    /**
     * Notice Id
     */
    protected NoticeId noticeId;
    /**
     * Notice Type
     */
    protected NoticeType noticeType;

    /**
     * Notice Name
     */
    protected String noticeName;

    /**
     * Notice Date
     */
    protected GregorianCalendar noticeDate;

    /**
     * Channel
     */
    protected ElectronicAddressType electronicAddressType;

    /**
     * Get notice id.
     *
     * @return the {@link NoticeId}
     */
    public NoticeId getNoticeId() {
        return noticeId;
    }

    /**
     * Set notice id.
     *
     * @param noticeId the {@link NoticeId}
     */
    public void setNoticeId(final NoticeId noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * Get notice type.
     *
     * @return the {@link NoticeType}
     */
    public NoticeType getNoticeType() {
        return noticeType;
    }

    /**
     * Set notice type.
     *
     * @param noticeType the {@link NoticeType}
     */
    public void setNoticeType(final NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * Get notice name.
     *
     * @return the notice name
     */
    public String getNoticeName() {
        return noticeName;
    }

    /**
     * Set notice name.
     *
     * @param noticeName the name of the notice
     */
    public void setNoticeName(final String noticeName) {
        this.noticeName = noticeName;
    }

    /**
     * Get notice date.
     *
     * @return the notice date
     */
    public GregorianCalendar getNoticeDate() {
        return noticeDate;
    }

    /**
     * Set notice date.
     *
     * @param noticeDate the date of the notice
     */
    public void setNoticeDate(final GregorianCalendar noticeDate) {
        this.noticeDate = noticeDate;
    }

    /**
     * Get communication channel type.
     *
     * @return the {@link ElectronicAddressType}
     */
    public ElectronicAddressType getElectronicAddressType() {
        return electronicAddressType;
    }

    /**
     * Set communication channel type.
     *
     * @param electronicAddressType the {@link ElectronicAddressType}
     */
    public void setElectronicAddressType(final ElectronicAddressType electronicAddressType) {
        this.electronicAddressType = electronicAddressType;
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
        final NoticeInformation rhs = (NoticeInformation) obj;
        return new EqualsBuilder().append(noticeId, rhs.noticeId).append(noticeType, rhs.noticeType).append(noticeName, rhs.noticeName).append(noticeDate, rhs.noticeDate)
            .append(electronicAddressType, rhs.electronicAddressType).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1982601087, 1939746097).append(noticeId).append(noticeType).append(noticeName).append(noticeDate).append(electronicAddressType)
            .toHashCode();
        return result;
    }
}
