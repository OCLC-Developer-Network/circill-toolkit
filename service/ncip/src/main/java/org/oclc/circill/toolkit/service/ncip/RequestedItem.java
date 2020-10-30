/*
 * Copyright (c) 2015 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Describes a RequestedItem result from an NCIP response
 */
public class RequestedItem {

    protected ItemId itemId;
    protected List<BibliographicId> bibliographicIds = new ArrayList<>();
    protected RequestId requestId;
    protected RequestType requestType;
    protected RequestStatusType requestStatusType;
    protected GregorianCalendar datePlaced;
    protected GregorianCalendar pickupDate;
    protected PickupLocation pickupLocation;
    protected GregorianCalendar pickupExpiryDate;
    protected BigDecimal reminderLevel;
    protected BigDecimal holdQueuePosition;
    protected String title;
    protected MediumType mediumType;
    protected BibliographicDescription bibliographicDescription;
    protected BigDecimal holdQueueLength;
    protected GregorianCalendar earliestDateNeeded;
    protected GregorianCalendar needBeforeDate;
    protected GregorianCalendar suspensionStartDate;
    protected GregorianCalendar suspensionEndDate;
    protected List<PermittedUserAction> permittedUserActions = new ArrayList<>();
    /**
     * Date Due
     */
    protected GregorianCalendar dateDue;
    /**
     * Indeterminate Loan Period Flag
     */
    protected Boolean indeterminateLoanPeriodFlag;
    /**
     * Non-Returnable Flag
     */
    protected Boolean nonReturnableFlag;
    protected ElectronicResource electronicResource;
    protected BigDecimal noticeCount;
    protected List<NoticeInformation> noticeInformations = new ArrayList<>();
    protected boolean isActive = false;
    protected String userNote;
    /** When adding BibliographicDescription, should've foreseen needing this for article volume/issue/pages and included ItemOptionalFields in place of it.
     * Now, we're stuck with adding successive fields from ItemOptionalFields directly to this class. */
    protected ItemDescription itemDescription;

    protected List<Location> locations = new ArrayList<>();

    protected List<RelatedSystemRequestId> relatedSystemRequestIds = new ArrayList<>();

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(final ItemId itemId) {
        this.itemId = itemId;
    }

    public List<BibliographicId> getBibliographicIds() {
        return bibliographicIds;
    }

    public BibliographicId getBibliographicId(final int index) {
        return bibliographicIds != null ? (bibliographicIds.size() > 0 ? bibliographicIds.get(index) : null) : null;
    }

    public void setBibliographicIds(final List<BibliographicId> bibliographicIds) {
        this.bibliographicIds = bibliographicIds;
    }

    public void setBibliographicId(final int index, final BibliographicId bibliographicId) {
        bibliographicIds.set(index, bibliographicId);
    }

    public RequestId getRequestId() {
        return requestId;
    }

    public void setRequestId(final RequestId requestId) {
        this.requestId = requestId;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(final RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestStatusType getRequestStatusType() {
        return requestStatusType;
    }

    public void setRequestStatusType(final RequestStatusType requestStatusType) {
        this.requestStatusType = requestStatusType;
    }

    public GregorianCalendar getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(final GregorianCalendar datePlaced) {
        this.datePlaced = datePlaced;
    }

    public GregorianCalendar getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(final GregorianCalendar pickupDate) {
        this.pickupDate = pickupDate;
    }

    public PickupLocation getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(final PickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public GregorianCalendar getPickupExpiryDate() {
        return pickupExpiryDate;
    }

    public void setPickupExpiryDate(final GregorianCalendar pickupExpiryDate) {
        this.pickupExpiryDate = pickupExpiryDate;
    }

    public BigDecimal getReminderLevel() {
        return reminderLevel;
    }

    public void setReminderLevel(final BigDecimal reminderLevel) {
        this.reminderLevel = reminderLevel;
    }

    public BigDecimal getHoldQueuePosition() {
        return holdQueuePosition;
    }

    public void setHoldQueuePosition(final BigDecimal holdQueuePosition) {
        this.holdQueuePosition = holdQueuePosition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public MediumType getMediumType() {
        return mediumType;
    }

    public void setMediumType(final MediumType mediumType) {
        this.mediumType = mediumType;
    }

    public GregorianCalendar getSuspensionStartDate() {
        return suspensionStartDate;
    }

    public void setSuspensionStartDate(final GregorianCalendar suspensionStartDate) {
        this.suspensionStartDate = suspensionStartDate;
    }

    public GregorianCalendar getSuspensionEndDate() {
        return suspensionEndDate;
    }

    public void setSuspensionEndDate(final GregorianCalendar suspensionEndDate) {
        this.suspensionEndDate = suspensionEndDate;
    }

    public BibliographicDescription getBibliographicDescription() {
        return bibliographicDescription;
    }

    public void setBibliographicDescription(final BibliographicDescription bibliographicDescription) {
        this.bibliographicDescription = bibliographicDescription;
    }

    public BigDecimal getHoldQueueLength() {
        return holdQueueLength;
    }

    public void setHoldQueueLength(final BigDecimal holdQueueLength) {
        this.holdQueueLength = holdQueueLength;
    }

    public GregorianCalendar getEarliestDateNeeded() {
        return earliestDateNeeded;
    }

    public void setEarliestDateNeeded(final GregorianCalendar earliestDateNeeded) {
        this.earliestDateNeeded = earliestDateNeeded;
    }

    public GregorianCalendar getNeedBeforeDate() {
        return needBeforeDate;
    }

    public void setNeedBeforeDate(final GregorianCalendar needBeforeDate) {
        this.needBeforeDate = needBeforeDate;
    }

    public List<PermittedUserAction> getPermittedUserActions() {
        return permittedUserActions;
    }

    public PermittedUserAction getPermittedUserAction(final int index) {
        return permittedUserActions != null ? (permittedUserActions.size() > 0 ? permittedUserActions.get(index) : null) : null;
    }

    public void setPermittedUserActions(final List<PermittedUserAction> permittedUserActions) {
        this.permittedUserActions = permittedUserActions;
    }

    public void setPermittedUserAction(final int index, final PermittedUserAction permittedUserAction) {
        permittedUserActions.set(index, permittedUserAction);
    }

    public GregorianCalendar getDateDue() {
        return dateDue;
    }

    public void setDateDue(final GregorianCalendar dateDue) {
        this.dateDue = dateDue;
    }

    public Boolean getIndeterminateLoanPeriodFlag() {
        return indeterminateLoanPeriodFlag;
    }

    public void setIndeterminateLoanPeriodFlag(final Boolean indeterminateLoanPeriodFlag) {
        this.indeterminateLoanPeriodFlag = indeterminateLoanPeriodFlag;
    }

    public Boolean getNonReturnableFlag() {
        return nonReturnableFlag;
    }

    public void setNonReturnableFlag(final Boolean nonReturnableFlag) {
        this.nonReturnableFlag = nonReturnableFlag;
    }

    public ElectronicResource getElectronicResource() {
        return electronicResource;
    }

    public void setElectronicResource(final ElectronicResource electronicResource) {
        this.electronicResource = electronicResource;
    }

    public BigDecimal getNoticeCount() {
        return noticeCount;
    }

    public void setNoticeCount(final BigDecimal noticeCount) {
        this.noticeCount = noticeCount;
    }

    public List<NoticeInformation> getNoticeInformations() {
        return noticeInformations;
    }

    public NoticeInformation getNoticeInformation(final int index) {
        return noticeInformations != null ? (noticeInformations.size() > 0 ? noticeInformations.get(index) : null) : null;
    }

    public void setNoticeInformations(final List<NoticeInformation> noticeInformations) {
        this.noticeInformations = noticeInformations;
    }

    public void setNoticeInformation(final int index, final NoticeInformation noticeInformation) {
        noticeInformations.set(index, noticeInformation);
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(final boolean isActive) {
        this.isActive = isActive;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(final String userNote) {
        this.userNote = userNote;
    }

    public ItemDescription getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(final ItemDescription itemDescription) {
        this.itemDescription = itemDescription;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Location getLocation(final int index) {
        return locations != null ? (locations.size() > 0 ? locations.get(index) : null) : null;
    }

    public void setLocations(final List<Location> locations) {
        this.locations = locations;
    }

    public void setLocation(final int index, final Location location) {
        locations.set(index, location);
    }

    public List<RelatedSystemRequestId> getRelatedSystemRequestIds() {
        return relatedSystemRequestIds;
    }

    public RelatedSystemRequestId getRelatedSystemRequestId(final int index) {
        return relatedSystemRequestIds != null ? (relatedSystemRequestIds.size() > 0 ? relatedSystemRequestIds.get(index) : null) : null;
    }

    public void setRelatedSystemRequestIds(final List<RelatedSystemRequestId> relatedSystemRequestIds) {
        this.relatedSystemRequestIds = relatedSystemRequestIds;
    }

    public void setRelatedSystemRequestId(final int index, final RelatedSystemRequestId relatedSystemRequestId) {
        relatedSystemRequestIds.set(index, relatedSystemRequestId);
    }

    /*
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
        final RequestedItem rhs = (RequestedItem) obj;
        return new EqualsBuilder().append(itemId, rhs.itemId).append(bibliographicIds, rhs.bibliographicIds).append(requestId, rhs.requestId).append(requestType, rhs.requestType)
            .append(requestStatusType, rhs.requestStatusType).append(datePlaced, rhs.datePlaced).append(pickupDate, rhs.pickupDate).append(pickupLocation, rhs.pickupLocation)
            .append(pickupExpiryDate, rhs.pickupExpiryDate).append(reminderLevel, rhs.reminderLevel).append(holdQueuePosition, rhs.holdQueuePosition).append(title, rhs.title)
            .append(mediumType, rhs.mediumType).append(bibliographicDescription, rhs.bibliographicDescription).append(holdQueueLength, rhs.holdQueueLength)
            .append(earliestDateNeeded, rhs.earliestDateNeeded).append(needBeforeDate, rhs.needBeforeDate).append(suspensionStartDate, rhs.suspensionStartDate)
            .append(suspensionEndDate, rhs.suspensionEndDate).append(permittedUserActions, rhs.permittedUserActions).append(dateDue, rhs.dateDue)
            .append(indeterminateLoanPeriodFlag, rhs.indeterminateLoanPeriodFlag).append(nonReturnableFlag, rhs.nonReturnableFlag)
            .append(electronicResource, rhs.electronicResource).append(noticeCount, rhs.noticeCount).append(noticeInformations, rhs.noticeInformations)
            .append(isActive, rhs.isActive).append(userNote, rhs.userNote).append(itemDescription, rhs.itemDescription).append(locations, rhs.locations)
            .append(relatedSystemRequestIds, rhs.relatedSystemRequestIds).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(21246821, 1156381965).append(itemId).append(bibliographicIds).append(requestId).append(requestType).append(requestStatusType)
            .append(datePlaced).append(pickupDate).append(pickupLocation).append(pickupExpiryDate).append(reminderLevel).append(holdQueuePosition).append(title).append(mediumType)
            .append(bibliographicDescription).append(holdQueueLength).append(earliestDateNeeded).append(needBeforeDate).append(suspensionStartDate).append(suspensionEndDate)
            .append(permittedUserActions).append(dateDue).append(indeterminateLoanPeriodFlag).append(nonReturnableFlag).append(electronicResource).append(noticeCount)
            .append(noticeInformations).append(isActive).append(userNote).append(itemDescription).append(locations).append(relatedSystemRequestIds).toHashCode();
        return result;
    }
}
