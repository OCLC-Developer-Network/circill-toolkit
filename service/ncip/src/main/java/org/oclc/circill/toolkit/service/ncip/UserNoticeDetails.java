/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the UserNoticeDetails.
 */
public class UserNoticeDetails {

    /**
     * NoticeType
     */
    protected NoticeType noticeType;

    /**
     * Set NoticeType.
     *
     * @param noticeType the {@link NoticeType}
     */
    public void setNoticeType(final NoticeType noticeType) {

        this.noticeType = noticeType;

    }

    /**
     * Get NoticeType.
     *
     * @return a {@link NoticeType}
     */
    public NoticeType getNoticeType() {

        return noticeType;

    }

    /**
     * NoticeContent
     */
    protected String noticeContent;

    /**
     * Set NoticeContent.
     *
     * @param noticeContent the notice's content
     */
    public void setNoticeContent(final String noticeContent) {

        this.noticeContent = noticeContent;

    }

    /**
     * Get NoticeContent.
     *
     * @return the notice content
     */
    public String getNoticeContent() {

        return noticeContent;

    }

    /**
     * NoticeItems
     */
    protected List<NoticeItem> noticeItems;

    /**
     * Set NoticeItems.
     *
     * @param noticeItems the list of {@link NoticeItem}s
     */
    public void setNoticeItems(final List<NoticeItem> noticeItems) {

        this.noticeItems = noticeItems;

    }

    /**
     * Get NoticeItems.
     *
     * @return a list of {@link NoticeItem}s
     */
    public List<NoticeItem> getNoticeItems() {

        return noticeItems;

    }

    /**
     * UserFiscalAccount
     */
    protected UserFiscalAccount userFiscalAccount;

    /**
     * Set UserFiscalAccount.
     * @param userFiscalAccount the {@link UserFiscalAccount}
     */
    public void setUserFiscalAccount(final UserFiscalAccount userFiscalAccount) {

        this.userFiscalAccount = userFiscalAccount;

    }

    /**
     * Get UserFiscalAccount.
     *
     * @return the {@link UserFiscalAccount}
     */
    public UserFiscalAccount getUserFiscalAccount() {

        return userFiscalAccount;

    }

    /**
     * UserPrivilege
     */
    protected UserPrivilege userPrivilege;

    /**
     * Set UserPrivilege.
     *
     * @param userPrivilege the {@link UserPrivilege}
     */
    public void setUserPrivilege(final UserPrivilege userPrivilege) {

        this.userPrivilege = userPrivilege;

    }

    /**
     * Get UserPrivilege.
     *
     * @return the {@link UserPrivilege}
     */
    public UserPrivilege getUserPrivilege() {

        return userPrivilege;

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
        final UserNoticeDetails rhs = (UserNoticeDetails) obj;
        return new EqualsBuilder().append(noticeType, rhs.noticeType).append(noticeContent, rhs.noticeContent).append(noticeItems, rhs.noticeItems)
            .append(userFiscalAccount, rhs.userFiscalAccount).append(userPrivilege, rhs.userPrivilege).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(120999981, 324050179).append(noticeType).append(noticeContent).append(noticeItems).append(userFiscalAccount).append(userPrivilege)
            .toHashCode();
        return result;
    }
}
