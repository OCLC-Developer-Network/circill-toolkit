/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * An ISO 18626 message.
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public class ISO18626Message<ID extends ISO18626RequestData, RD extends ISO18626ConfirmationData> implements ServiceMessage<ID, RD> {

    /**
     * The type of message.
     */
    public enum MessageType {UNKNOWN, REQUEST, CONFIRMATION}

    private MessageType messageType = MessageType.UNKNOWN;

    public boolean isInitiationMessage() {
        return messageType == MessageType.REQUEST;
    }

    public boolean isResponseMessage() {
        return messageType == MessageType.CONFIRMATION;
    }

    public ISO18626RequestData getRequestData() throws ToolkitInternalException {

        try {
            final ISO18626RequestData initData;
            final ISO18626Data iSO18626Data = (ISO18626Data) ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(this);
            if (iSO18626Data != null) {
                if (iSO18626Data instanceof ISO18626RequestData) {
                    initData = (ISO18626RequestData) iSO18626Data;
                } else {
                    throw new ToolkitInternalException("Initiation message not a recognized type. (Found '" + iSO18626Data.getClass().getSimpleName() + "'.)");
                }
            } else {
                initData = null;
            }

            return initData;
        } catch (Exception e) {
            throw new ToolkitInternalException("Exception getting initiation data from ISO18626Message.", e);
        }

    }

    public ISO18626ConfirmationData getConfirmationData() throws ToolkitInternalException {

        try {
            final ISO18626ConfirmationData respData;
            final ISO18626Data iSO18626Data = (ISO18626Data) ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(this);
            if (iSO18626Data != null) {
                if (iSO18626Data instanceof ISO18626ConfirmationData) {
                    respData = (ISO18626ConfirmationData) iSO18626Data;
                } else {
                    throw new ToolkitInternalException("Response message not a recognized type. (Found '" + iSO18626Data.getClass().getSimpleName() + "'.)");
                }
            } else {
                respData = null;
            }

            return respData;
        } catch (Exception e) {
            throw new ToolkitInternalException("Exception getting response data from ISO18626Message.", e);
        }

    }

    public void setRequestData(final ISO18626RequestData requestData) throws ToolkitInternalException {
        ReflectionHelper.setField(this, requestData, requestData.getServiceName());
    }

    public void setConfirmationData(final ISO18626ConfirmationData confirmationData) throws ToolkitInternalException {
        ReflectionHelper.setField(this, confirmationData, confirmationData.getServiceName() + "Confirmation");
    }

    protected String version;
    protected RequestData request;
    protected RequestConfirmationData requestConfirmation;
    protected SupplyingAgencyMessageData supplyingAgencyMessage;
    protected SupplyingAgencyMessageConfirmationData supplyingAgencyMessageConfirmation;
    protected RequestingAgencyMessageData requestingAgencyMessage;
    protected RequestingAgencyMessageConfirmationData requestingAgencyMessageConfirmation;

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public RequestData getRequest() {
        return request;
    }

    public void setRequest(final RequestData request) {
        this.request = request;
        if (request != null) {
            messageType = MessageType.REQUEST;
        }
    }

    public RequestConfirmationData getRequestConfirmation() {
        return requestConfirmation;
    }

    public void setRequestConfirmation(final RequestConfirmationData requestConfirmation) {
        this.requestConfirmation = requestConfirmation;
        if (requestConfirmation != null) {
            messageType = MessageType.CONFIRMATION;
        }
    }

    public SupplyingAgencyMessageData getSupplyingAgencyMessage() {
        return supplyingAgencyMessage;
    }

    public void setSupplyingAgencyMessage(final SupplyingAgencyMessageData supplyingAgencyMessage) {
        this.supplyingAgencyMessage = supplyingAgencyMessage;
        if (supplyingAgencyMessage != null) {
            messageType = MessageType.REQUEST;
        }
    }

    public SupplyingAgencyMessageConfirmationData getSupplyingAgencyMessageConfirmation() {
        return supplyingAgencyMessageConfirmation;
    }

    public void setSupplyingAgencyMessageConfirmation(final SupplyingAgencyMessageConfirmationData supplyingAgencyMessageConfirmation) {
        this.supplyingAgencyMessageConfirmation = supplyingAgencyMessageConfirmation;
        if (supplyingAgencyMessageConfirmation != null) {
            messageType = MessageType.CONFIRMATION;
        }
    }

    public RequestingAgencyMessageData getRequestingAgencyMessage() {
        return requestingAgencyMessage;
    }

    public void setRequestingAgencyMessage(final RequestingAgencyMessageData requestingAgencyMessage) {
        this.requestingAgencyMessage = requestingAgencyMessage;
        if (requestingAgencyMessage != null) {
            messageType = MessageType.REQUEST;
        }
    }

    public RequestingAgencyMessageConfirmationData getRequestingAgencyMessageConfirmation() {
        return requestingAgencyMessageConfirmation;
    }

    public void setRequestingAgencyMessageConfirmation(final RequestingAgencyMessageConfirmationData requestingAgencyMessageConfirmation) {
        this.requestingAgencyMessageConfirmation = requestingAgencyMessageConfirmation;
        if (requestingAgencyMessageConfirmation != null) {
            messageType = MessageType.CONFIRMATION;
        }
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
        final ISO18626Message rhs = (ISO18626Message) obj;
        return new EqualsBuilder().append(messageType, rhs.messageType).append(version, rhs.version)
            .append(request, rhs.request)
            .append(requestConfirmation, rhs.requestConfirmation)
            .append(supplyingAgencyMessage, rhs.supplyingAgencyMessage)
            .append(supplyingAgencyMessageConfirmation, rhs.supplyingAgencyMessageConfirmation)
            .append(requestingAgencyMessage, rhs.requestingAgencyMessage)
            .append(requestingAgencyMessageConfirmation, rhs.requestingAgencyMessageConfirmation)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1467119481, 1758816681).append(messageType).append(version)
            .append(request).append(requestConfirmation).append(supplyingAgencyMessage).append(supplyingAgencyMessageConfirmation)
            .append(requestingAgencyMessage).append(requestingAgencyMessageConfirmation).toHashCode();
        return result;
    }
}
