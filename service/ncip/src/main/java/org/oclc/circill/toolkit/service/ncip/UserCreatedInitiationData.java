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

import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Data to initiate the UserCreated service.
 */
public class UserCreatedInitiationData implements NCIPInitiationData {

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
     * NameInformation
     */
    protected NameInformation nameInformation;

    /**
     * Set NameInformation.
     *
     * @param nameInformation the {@link NameInformation}
     */
    public void setNameInformation(final NameInformation nameInformation) {

        this.nameInformation = nameInformation;

    }

    /**
     * Get NameInformation.
     *
     * @return the {@link NameInformation}
     */
    public NameInformation getNameInformation() {

        return nameInformation;

    }

    /**
     * UserAddressInformations
     */
    protected List<UserAddressInformation> userAddressInformations;

    /**
     * Set UserAddressInformations.
     *
     * @param userAddressInformations the list of {@link UserAddressInformation}s
     */
    public void setUserAddressInformations(final List<UserAddressInformation> userAddressInformations) {

        this.userAddressInformations = userAddressInformations;

    }

    /**
     * Get UserAddressInformations.
     *
     * @return the list of {@link UserAddressInformation}s
     */
    public List<UserAddressInformation> getUserAddressInformations() {

        return userAddressInformations;

    }

    /**
     * DateOfBirth
     */
    protected GregorianCalendar dateOfBirth;

    /**
     * Set DateOfBirth.
     *
     * @param dateOfBirth the user's date of birth
     */
    public void setDateOfBirth(final GregorianCalendar dateOfBirth) {

        this.dateOfBirth = dateOfBirth;

    }

    /**
     * Get DateOfBirth.
     *
     * @return the date/time of the user's birth
     */
    public GregorianCalendar getDateOfBirth() {

        return dateOfBirth;

    }

    /**
     * UserLanguages
     */
    protected List<UserLanguage> userLanguages;

    /**
     * Set UserLanguages.
     *
     * @param userLanguages the list of {@link UserLanguage}s
     */
    public void setUserLanguages(final List<UserLanguage> userLanguages) {

        this.userLanguages = userLanguages;

    }

    /**
     * Get UserLanguages.
     *
     * @return the list of {@link UserLanguage}s
     */
    public List<UserLanguage> getUserLanguages() {

        return userLanguages;

    }

    /**
     * UserPrivileges
     */
    protected List<UserPrivilege> userPrivileges;

    /**
     * Set UserPrivileges.
     *
     * @param userPrivileges the list of {@link UserPrivilege}s
     */
    public void setUserPrivileges(final List<UserPrivilege> userPrivileges) {

        this.userPrivileges = userPrivileges;

    }

    /**
     * Get UserPrivileges.
     *
     * @return a list of {@link UserPrivilege}s
     */
    public List<UserPrivilege> getUserPrivileges() {

        return userPrivileges;

    }

    /**
     * BlockOrTraps
     */
    protected List<BlockOrTrap> blockOrTraps;

    /**
     * Set BlockOrTraps.
     *
     * @param blockOrTraps the list of {@link BlockOrTrap}s
     */
    public void setBlockOrTraps(final List<BlockOrTrap> blockOrTraps) {

        this.blockOrTraps = blockOrTraps;

    }

    /**
     * Get BlockOrTraps.
     *
     * @return a list of {@link BlockOrTrap}s
     */
    public List<BlockOrTrap> getBlockOrTraps() {

        return blockOrTraps;

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
        final UserCreatedInitiationData rhs = (UserCreatedInitiationData) obj;
        return new EqualsBuilder().append(initiationHeader, rhs.initiationHeader).append(relyingPartyId, rhs.relyingPartyId).append(userId, rhs.userId)
            .append(nameInformation, rhs.nameInformation).append(userAddressInformations, rhs.userAddressInformations).append(dateOfBirth, rhs.dateOfBirth)
            .append(userLanguages, rhs.userLanguages).append(userPrivileges, rhs.userPrivileges).append(blockOrTraps, rhs.blockOrTraps).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1671592897, 1323047669).append(initiationHeader).append(relyingPartyId).append(userId).append(nameInformation)
            .append(userAddressInformations).append(dateOfBirth).append(userLanguages).append(userPrivileges).append(blockOrTraps).toHashCode();
        return result;
    }
}
