/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class RequestingAgencyMessageDataBuilder {

    private Header header;
    private Action action;
    private String note;

    /**
     * This utility class does not allow instances.
     */
    private RequestingAgencyMessageDataBuilder() {
    }

    /**
     * -
     * @return a builder for {@link RequestingAgencyMessageData}
     */
    public static RequestingAgencyMessageDataBuilder aRequestingAgencyMessageData() {
        final RequestingAgencyMessageDataBuilder builder = new RequestingAgencyMessageDataBuilder();
        return builder;
    }

    public RequestingAgencyMessageDataBuilder withHeader(final Header header) {
        this.header = header;
        return this;
    }

    public RequestingAgencyMessageDataBuilder withAction(final Action action) {
        this.action = action;
        return this;
    }

    public RequestingAgencyMessageDataBuilder withNote(final String note) {
        this.note = note;
        return this;
    }

    public RequestingAgencyMessageData build() {
        final RequestingAgencyMessageData requestingAgencyMessageData = new RequestingAgencyMessageData();
        requestingAgencyMessageData.setHeader(header);
        requestingAgencyMessageData.setAction(action);
        requestingAgencyMessageData.setNote(note);
        return requestingAgencyMessageData;
    }

}

