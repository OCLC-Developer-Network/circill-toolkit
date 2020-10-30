/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 */
public class RequestingAgencyMessageData implements ISO18626RequestData {
    /**
     * Header
     */
    protected Header header;
    /**
     * Action
     */
    protected Action action;
    /**
     * Note
     */
    protected String note;

    /**
     * Get the header.
     *
     * @return the header
     */
    @Override
    public Header getHeader() {
        return header;
    }

    /**
     * Set the header.
     *
     * @param header the header
     */
    @Override
    public void setHeader(final Header header) {
        this.header = header;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(final Action action) {
        this.action = action;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
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
        final RequestingAgencyMessageData rhs = (RequestingAgencyMessageData) obj;
        return new EqualsBuilder().append(header, rhs.header).append(action, rhs.action).append(note, rhs.note).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1250672043, 1262386611).append(header).append(action).append(note).toHashCode();
        return result;
    }
}
