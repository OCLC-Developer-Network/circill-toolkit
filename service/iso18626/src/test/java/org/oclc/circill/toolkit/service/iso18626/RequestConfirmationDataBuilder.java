/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class RequestConfirmationDataBuilder {

    private ConfirmationHeader confirmationHeader;
    private ErrorData errorData;

    /**
     * This utility class does not allow instances.
     */
    private RequestConfirmationDataBuilder() {
    }

    /**
     * -
     * @return a builder for {@link RequestConfirmationData}
     */
    public static RequestConfirmationDataBuilder aRequestConfirmationData() {
        final RequestConfirmationDataBuilder builder = new RequestConfirmationDataBuilder();
        return builder;
    }

    public RequestConfirmationDataBuilder withConfirmationHeader(final ConfirmationHeader confirmationHeader) {
        this.confirmationHeader = confirmationHeader;
        return this;
    }

    public RequestConfirmationDataBuilder withErrorData(final ErrorData errorData) {
        this.errorData = errorData;
        return this;
    }

    public RequestConfirmationData build() {
        final RequestConfirmationData requestConfirmationData = new RequestConfirmationData();
        requestConfirmationData.setConfirmationHeader(confirmationHeader);
        requestConfirmationData.setErrorData(errorData);
        return requestConfirmationData;
    }

}

