/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class RequestingAgencyMessageConfirmationDataBuilder {

    private ConfirmationHeader confirmationHeader;
    private ErrorData errorData;
    private Action action;

    /**
     * This utility class does not allow instances.
     */
    private RequestingAgencyMessageConfirmationDataBuilder() {
    }

    /**
     * -
     * @return a builder for {@link RequestingAgencyMessageConfirmationData}
     */
    public static RequestingAgencyMessageConfirmationDataBuilder aRequestingAgencyMessageConfirmationData() {
        final RequestingAgencyMessageConfirmationDataBuilder builder = new RequestingAgencyMessageConfirmationDataBuilder();
        return builder;
    }

    public RequestingAgencyMessageConfirmationDataBuilder withConfirmationHeader(final ConfirmationHeader confirmationHeader) {
        this.confirmationHeader = confirmationHeader;
        return this;
    }

    public RequestingAgencyMessageConfirmationDataBuilder withErrorData(final ErrorData errorData) {
        this.errorData = errorData;
        return this;
    }

    public RequestingAgencyMessageConfirmationDataBuilder withAction(final Action action) {
        this.action = action;
        return this;
    }

    public RequestingAgencyMessageConfirmationData build() {
        final RequestingAgencyMessageConfirmationData requestingAgencyMessageConfirmationData = new RequestingAgencyMessageConfirmationData();
        requestingAgencyMessageConfirmationData.setConfirmationHeader(confirmationHeader);
        requestingAgencyMessageConfirmationData.setErrorData(errorData);
        requestingAgencyMessageConfirmationData.setAction(action);
        return requestingAgencyMessageConfirmationData;
    }

}

