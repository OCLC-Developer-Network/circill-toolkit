/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the UpdateUser service.
 */
public class UpdateUserInitiationData implements NCIPInitiationData {

    /**
     * InitiationHeader
     */
    protected InitiationHeader initiationHeader;

    /**
     * Set InitiationHeader.
     */
    @Override
    public void setInitiationHeader(final InitiationHeader initiationHeader) {

        this.initiationHeader = initiationHeader;

    }

    /**
     * Get InitiationHeader.
     */
    @Override
    public InitiationHeader getInitiationHeader() {

        return initiationHeader;

    }

    /**
     * Relying Party Id
     */
    protected AgencyId relyingPartyId;

    /**
     * Get the RelyingPartyId.
     *
     * @return the RelyingPartyId
     */
    @Override
    public AgencyId getRelyingPartyId() {
        return relyingPartyId;
    }

    /**
     * Set the RelyingPartyId.
     *
     * @param relyingPartyId the RelyingPartyId
     */
    @Override
    public void setRelyingPartyId(final AgencyId relyingPartyId) {
        this.relyingPartyId = relyingPartyId;
    }

    /**
     * MandatedAction
     */
    protected MandatedAction mandatedAction;

    /**
     * Set MandatedAction.
     *
     * @param mandatedAction the {@link MandatedAction}
     */
    public void setMandatedAction(final MandatedAction mandatedAction) {

        this.mandatedAction = mandatedAction;

    }

    /**
     * Get MandatedAction.
     *
     * @return the {@link MandatedAction}
     */
    public MandatedAction getMandatedAction() {

        return mandatedAction;

    }

    /**
     * UserId
     */
    protected UserId userId;

    /**
     * Set UserId.
     * @param userId the {@link UserId}
     */
    public void setUserId(final UserId userId) {

        this.userId = userId;

    }

    /**
     * Get UserId.
     *
     * @return the {@link UserId}
     */
    public UserId getUserId() {

        return userId;

    }

    /**
     * AuthenticationInputs
     */
    protected List<AuthenticationInput> authenticationInputs;

    /**
     * Set AuthenticationInputs.
     *
     * @param authenticationInputs the list of {@link AuthenticationInput}s
     */
    public void setAuthenticationInputs(final List<AuthenticationInput> authenticationInputs) {

        this.authenticationInputs = authenticationInputs;

    }

    /**
     * Get AuthenticationInputs.
     *
     * @return the list of {@link AuthenticationInput}s
     */
    public List<AuthenticationInput> getAuthenticationInputs() {

        return authenticationInputs;

    }

    /**
     * DeleteUserFields
     */
    protected DeleteUserFields deleteUserFields;

    /**
     * Set DeleteUserFields.
     *
     * @param deleteUserFields the {@link DeleteUserFields}
     */
    public void setDeleteUserFields(final DeleteUserFields deleteUserFields) {

        this.deleteUserFields = deleteUserFields;

    }

    /**
     * Get DeleteUserFields.
     *
     * @return the {@link DeleteUserFields}
     */
    public DeleteUserFields getDeleteUserFields() {

        return deleteUserFields;

    }

    /**
     * AddUserFields
     */
    protected AddUserFields addUserFields;

    /**
     * Set AddUserFields.
     *
     * @param addUserFields the {@link AddUserFields}
     */
    public void setAddUserFields(final AddUserFields addUserFields) {

        this.addUserFields = addUserFields;

    }

    /**
     * Get AddUserFields.
     *
     * @return the {@link AddUserFields}
     */
    public AddUserFields getAddUserFields() {

        return addUserFields;

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
        final UpdateUserInitiationData rhs = (UpdateUserInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId)
            .append(mandatedAction, rhs.mandatedAction).append(userId, rhs.userId).append(authenticationInputs, rhs.authenticationInputs)
            .append(deleteUserFields, rhs.deleteUserFields).append(addUserFields, rhs.addUserFields).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1582209955, 1398070133).append(initiationHeader).append(relyingPartyId).append(mandatedAction).append(userId)
            .append(authenticationInputs).append(deleteUserFields).append(addUserFields).toHashCode();
        return result;
    }
}
