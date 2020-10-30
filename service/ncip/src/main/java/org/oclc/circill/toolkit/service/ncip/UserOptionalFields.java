/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserOptionalFields {
    /**
     * Name Information
     */
    protected NameInformation nameInformation;
    /**
     * User Address Information
     */
    protected List<UserAddressInformation> userAddressInformations = new ArrayList<>();
    /**
     * DateOfBirth
     */
    protected GregorianCalendar dateOfBirth;
    /**
     * User Language
     */
    protected List<UserLanguage> userLanguages = new ArrayList<>();
    /**
     * User Privilege
     */
    protected List<UserPrivilege> userPrivileges = new ArrayList<>();
    /**
     * Block Or Trap
     */
    protected List<BlockOrTrap> blockOrTraps = new ArrayList<>();
    /**
     * User Id
     */
    protected List<UserId> userIds = new ArrayList<>();
    /**
     * Previous User Id
     */
    protected List<PreviousUserId> previousUserIds = new ArrayList<>();
    /**
     * User Limit
     */
    protected List<UserLimit> userLimits = new ArrayList<>();

    public NameInformation getNameInformation() {
        return nameInformation;
    }

    public void setNameInformation(final NameInformation nameInformation) {
        this.nameInformation = nameInformation;
    }

    public List<UserAddressInformation> getUserAddressInformations() {
        return userAddressInformations;
    }

    public UserAddressInformation getUserAddressInformation(final int index) {
        return userAddressInformations != null ? (userAddressInformations.size() > 0 ? userAddressInformations.get(index) : null) : null;
    }

    public void setUserAddressInformations(final List<UserAddressInformation> userAddressInformations) {
        this.userAddressInformations = userAddressInformations;
    }

    public void setUserAddressInformation(final int index, final UserAddressInformation userAddressInformation) {
        userAddressInformations.set(index, userAddressInformation);
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<UserLanguage> getUserLanguages() {
        return userLanguages;
    }

    public UserLanguage getUserLanguage(final int index) {
        return userLanguages != null ? (userLanguages.size() > 0 ? userLanguages.get(index) : null) : null;
    }

    public void setUserLanguages(final List<UserLanguage> userLanguages) {
        this.userLanguages = userLanguages;
    }

    public void setUserLanguage(final int index, final UserLanguage userLanguage) {
        userLanguages.set(index, userLanguage);
    }

    public List<UserPrivilege> getUserPrivileges() {
        return userPrivileges;
    }

    public UserPrivilege getUserPrivilege(final int index) {
        return userPrivileges != null ? (userPrivileges.size() > 0 ? userPrivileges.get(index) : null) : null;
    }

    public void setUserPrivileges(final List<UserPrivilege> userPrivileges) {
        this.userPrivileges = userPrivileges;
    }

    public void setUserPrivilege(final int index, final UserPrivilege userPrivilege) {
        userPrivileges.set(index, userPrivilege);
    }

    public List<BlockOrTrap> getBlockOrTraps() {
        return blockOrTraps;
    }

    public BlockOrTrap getBlockOrTrap(final int index) {
        return blockOrTraps != null ? (blockOrTraps.size() > 0 ? blockOrTraps.get(index) : null) : null;
    }

    public void setBlockOrTraps(final List<BlockOrTrap> blockOrTraps) {
        this.blockOrTraps = blockOrTraps;
    }

    public void setBlockOrTrap(final int index, final BlockOrTrap blockOrTrap) {
        blockOrTraps.set(index, blockOrTrap);
    }

    public List<UserId> getUserIds() {
        return userIds;
    }

    public UserId getUserId(final int index) {
        return userIds != null ? (userIds.size() > 0 ? userIds.get(index) : null) : null;
    }

    public void setUserIds(final List<UserId> userIds) {
        this.userIds = userIds;
    }

    public void setUserId(final int index, final UserId userId) {
        userIds.set(index, userId);
    }

    public List<PreviousUserId> getPreviousUserIds() {
        return previousUserIds;
    }

    public PreviousUserId getPreviousUserId(final int index) {
        return previousUserIds != null ? (previousUserIds.size() > 0 ? previousUserIds.get(index) : null) : null;
    }

    public void setPreviousUserIds(final List<PreviousUserId> previousUserIds) {
        this.previousUserIds = previousUserIds;
    }

    public void setPreviousUserId(final int index, final PreviousUserId previousUserId) {
        previousUserIds.set(index, previousUserId);
    }

    public List<UserLimit> getUserLimits() {
        return userLimits;
    }

    public UserLimit getUserLimit(final int index) {
        return userLimits != null ? (userLimits.size() > 0 ? userLimits.get(index) : null) : null;
    }

    public void setUserLimits(final List<UserLimit> userLimits) {
        this.userLimits = userLimits;
    }

    public void setUserLimit(final int index, final UserLimit userLimit) {
        userLimits.set(index, userLimit);
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
        final UserOptionalFields rhs = (UserOptionalFields) obj;
        return new EqualsBuilder().append(nameInformation, rhs.nameInformation).append(userAddressInformations, rhs.userAddressInformations).append(dateOfBirth, rhs.dateOfBirth)
            .append(userLanguages, rhs.userLanguages).append(userPrivileges, rhs.userPrivileges).append(blockOrTraps, rhs.blockOrTraps).append(userIds, rhs.userIds)
            .append(previousUserIds, rhs.previousUserIds).append(userLimits, rhs.userLimits).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(908340999, 1800095579).append(nameInformation).append(userAddressInformations).append(dateOfBirth).append(userLanguages)
            .append(userPrivileges).append(blockOrTraps).append(userIds).append(previousUserIds).append(userLimits).toHashCode();
        return result;
    }
}
