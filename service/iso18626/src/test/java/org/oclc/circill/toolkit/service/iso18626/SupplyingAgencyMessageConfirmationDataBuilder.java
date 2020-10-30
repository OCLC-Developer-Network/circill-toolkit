/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class SupplyingAgencyMessageConfirmationDataBuilder {

    private ConfirmationHeader confirmationHeader;
    private ErrorData errorData;
    private ReasonForMessage reasonForMessage;

    /**
     * This utility class does not allow instances.
     */
    private SupplyingAgencyMessageConfirmationDataBuilder() {
    }

    /**
     * -
     * @return a builder for {@link SupplyingAgencyMessageConfirmationData}
     */
    public static SupplyingAgencyMessageConfirmationDataBuilder aSupplyingAgencyMessageConfirmationData() {
        final SupplyingAgencyMessageConfirmationDataBuilder builder = new SupplyingAgencyMessageConfirmationDataBuilder();
        return builder;
    }

    public SupplyingAgencyMessageConfirmationDataBuilder withConfirmationHeader(final ConfirmationHeader confirmationHeader) {
        this.confirmationHeader = confirmationHeader;
        return this;
    }

    public SupplyingAgencyMessageConfirmationDataBuilder withErrorData(final ErrorData errorData) {
        this.errorData = errorData;
        return this;
    }

    public SupplyingAgencyMessageConfirmationDataBuilder withReasonForMessage(final ReasonForMessage reasonForMessage) {
        this.reasonForMessage = reasonForMessage;
        return this;
    }

    public SupplyingAgencyMessageConfirmationData build() {
        final SupplyingAgencyMessageConfirmationData supplyingAgencyMessageConfirmationData = new SupplyingAgencyMessageConfirmationData();
        supplyingAgencyMessageConfirmationData.setConfirmationHeader(confirmationHeader);
        supplyingAgencyMessageConfirmationData.setErrorData(errorData);
        supplyingAgencyMessageConfirmationData.setReasonForMessage(reasonForMessage);
        return supplyingAgencyMessageConfirmationData;
    }

}

