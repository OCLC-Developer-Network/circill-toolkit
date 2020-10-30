/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class ISO18626MessageBuilder {

    private static final String INVALID_SETTINGS_MESSAGE = "One and only one of these fields must be non-null to build this: request, requestConfirmation, supplyingAgencyMessage"
        + ", supplyingAgencyMessageConfirmation, requestingAgencyMessage or requestingAgencyMessageConfirmation.";

    private String version;
    private RequestData request;
    private RequestConfirmationData requestConfirmation;
    private SupplyingAgencyMessageData supplyingAgencyMessage;
    private SupplyingAgencyMessageConfirmationData supplyingAgencyMessageConfirmation;
    private RequestingAgencyMessageData requestingAgencyMessage;
    private RequestingAgencyMessageConfirmationData requestingAgencyMessageConfirmation;

    /**
     * This utility class does not allow instances.
     */
    private ISO18626MessageBuilder() {
    }

    /**
     * -
     * @return a builder for {@link ISO18626Message}
     */
    public static ISO18626MessageBuilder aISO18626Message() {
        final ISO18626MessageBuilder builder = new ISO18626MessageBuilder();
        return builder;
    }

    /**
     * -
     * @param version -
     * @return -
     */
    public ISO18626MessageBuilder withVersion(final String version) {
        this.version = version;
        return this;
    }

    /**
     * -
     * @param request -
     * @return -
     */
    public ISO18626MessageBuilder withRequest(final RequestData request) {
        this.request = request;
        return this;
    }

    /**
     * -
     * @param requestConfirmation -
     * @return -
     */
    public ISO18626MessageBuilder withRequestConfirmation(final RequestConfirmationData requestConfirmation) {
        this.requestConfirmation = requestConfirmation;
        return this;
    }

    /**
     * -
     * @param supplyingAgencyMessage -
     * @return -
     */
    public ISO18626MessageBuilder withSupplyingAgencyMessage(final SupplyingAgencyMessageData supplyingAgencyMessage) {
        this.supplyingAgencyMessage = supplyingAgencyMessage;
        return this;
    }

    /**
     * -
     * @param supplyingAgencyMessageConfirmation -
     * @return -
     */
    public ISO18626MessageBuilder withSupplyingAgencyMessageConfirmation(final SupplyingAgencyMessageConfirmationData supplyingAgencyMessageConfirmation) {
        this.supplyingAgencyMessageConfirmation = supplyingAgencyMessageConfirmation;
        return this;
    }

    /**
     * -
     * @param requestingAgencyMessage -
     * @return -
     */
    public ISO18626MessageBuilder withRequestingAgencyMessage(final RequestingAgencyMessageData requestingAgencyMessage) {
        this.requestingAgencyMessage = requestingAgencyMessage;
        return this;
    }

    /**
     * -
     * @param requestingAgencyMessageConfirmation -
     * @return -
     */
    public ISO18626MessageBuilder withRequestingAgencyMessageConfirmation(final RequestingAgencyMessageConfirmationData requestingAgencyMessageConfirmation) {
        this.requestingAgencyMessageConfirmation = requestingAgencyMessageConfirmation;
        return this;
    }

    /**
     * -
     * @return -
     */
    public ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> build() {
        final ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData> iSO18626Message = new ISO18626Message();
        validate();
        iSO18626Message.setVersion(version);
        if (request != null) {
            iSO18626Message.setRequest(request);
        } else if (requestConfirmation != null) {
            iSO18626Message.setRequestConfirmation(requestConfirmation);
        } else if (supplyingAgencyMessage != null) {
            iSO18626Message.setSupplyingAgencyMessage(supplyingAgencyMessage);
        } else if (supplyingAgencyMessageConfirmation != null) {
            iSO18626Message.setSupplyingAgencyMessageConfirmation(supplyingAgencyMessageConfirmation);
        } else if (requestingAgencyMessage != null) {
            iSO18626Message.setRequestingAgencyMessage(requestingAgencyMessage);
        } else if (requestingAgencyMessageConfirmation != null) {
            iSO18626Message.setRequestingAgencyMessageConfirmation(requestingAgencyMessageConfirmation);
        } else {
            throw new IllegalArgumentException(INVALID_SETTINGS_MESSAGE);
        }
        return iSO18626Message;
    }

    /**
     * Ensure that one-and-only-one field is set.
     */
    private void validate() {
        int fieldsSet = 0;
        if (request != null) {
            fieldsSet++;
        }
        if (requestConfirmation != null) {
            fieldsSet++;
        }
        if (supplyingAgencyMessage != null) {
            fieldsSet++;
        }
        if (supplyingAgencyMessageConfirmation != null) {
            fieldsSet++;
        }
        if (requestingAgencyMessage != null) {
            fieldsSet++;
        }
        if (requestingAgencyMessageConfirmation != null) {
            fieldsSet++;
        }
        if (fieldsSet != 1) {
            throw new IllegalArgumentException(INVALID_SETTINGS_MESSAGE);
        }
    }

}

