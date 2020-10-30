/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncipversion;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The NCIP LookupVersion message, either the initiation or a response form.
 * @param <ID> the {@link ServiceInitiationData} type
 * @param <RD> the {@link ServiceResponseData} type
 */
public class NCIPVersionMessage<ID extends LookupVersionInitiationData, RD extends LookupVersionResponseData>
    implements ServiceMessage<LookupVersionInitiationData, LookupVersionResponseData> {

    /**
     * Enumerates the types of message: Initiation, Response or unknown (if not set or determinable).
     */
    public enum MessageType {UNKNOWN, INITIATION, RESPONSE}

    protected MessageType messageType = MessageType.UNKNOWN;

    public boolean isInitiationMessage() {
        return messageType == MessageType.INITIATION;
    }

    public boolean isResponseMessage() {
        return messageType == MessageType.RESPONSE;
    }

    public ID getInitiationData() throws ToolkitInternalException {

        try {
            final ID initData;
            final NCIPLookupVersionData ncipData = (NCIPLookupVersionData) ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(this);
            if (ncipData != null) {
                if (ncipData instanceof LookupVersionInitiationData) {
                    initData = (ID) ncipData;
                } else {
                    throw new ToolkitInternalException("Initiation message not a recognized type. (Found '" + ncipData.getClass().getSimpleName() + "'.)");
                }
            } else {
                initData = null;
            }

            return initData;
        } catch (Exception e) {
            throw new ToolkitInternalException("Exception getting initiation data from NCIPMessage.", e);
        }

    }

    public RD getResponseData() throws ToolkitInternalException {

        try {
            final RD respData;
            final NCIPLookupVersionData ncipData = (NCIPLookupVersionData) ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(this);
            if (ncipData != null) {
                if (ncipData instanceof LookupVersionResponseData) {
                    respData = (RD) ncipData;
                } else {
                    throw new ToolkitInternalException("Response message not a recognized type. (Found '" + ncipData.getClass().getSimpleName() + "'.)");
                }
            } else {
                respData = null;
            }

            return respData;
        } catch (Exception e) {
            throw new ToolkitInternalException("Exception getting response data from NCIPMessage.", e);
        }

    }

    public void setInitiationData(final LookupVersionInitiationData initiationData) throws ToolkitInternalException {
        ReflectionHelper.setField(this, initiationData, "LookupVersion");
    }

    public void setResponseData(final LookupVersionResponseData responseData) throws ToolkitInternalException {
        ReflectionHelper.setField(this, responseData, "LookupVersionResponse");
    }

    protected String version;

    protected LookupVersionInitiationData lookupVersion;
    protected LookupVersionResponseData lookupVersionResponse;

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public LookupVersionInitiationData getLookupVersion() {
        return lookupVersion;
    }

    public void setLookupVersion(final LookupVersionInitiationData lookupVersion) {
        this.lookupVersion = lookupVersion;
        messageType = MessageType.INITIATION;
    }

    public LookupVersionResponseData getLookupVersionResponse() {
        return lookupVersionResponse;
    }

    public void setLookupVersionResponse(final LookupVersionResponseData lookupVersionResponse) {
        this.lookupVersionResponse = lookupVersionResponse;
        messageType = MessageType.RESPONSE;
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
        final NCIPVersionMessage rhs = (NCIPVersionMessage) obj;
        return new EqualsBuilder().append(messageType, rhs.messageType).append(version, rhs.version).append(lookupVersion, rhs.lookupVersion)
            .append(lookupVersionResponse, rhs.lookupVersionResponse).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1412285223, 660406619).append(messageType).append(version).append(lookupVersion).append(lookupVersionResponse).toHashCode();
        return result;
    }
}
