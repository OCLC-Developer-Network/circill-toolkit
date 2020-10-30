/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The NCIP message, either an initiation or a response form.
 * @param <ID> the {@link ServiceInitiationData} type
 * @param <RD> the {@link ServiceResponseData} type
 */
public class NCIPMessage<ID extends NCIPInitiationData, RD extends NCIPResponseData> implements ServiceMessage<ID, RD> {

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

    public NCIPInitiationData getInitiationData() throws ToolkitInternalException {

        try {
            final NCIPInitiationData initData;
            final NCIPData ncipData = (NCIPData) ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(this);
            if (ncipData != null) {
                if (ncipData instanceof NCIPInitiationData) {
                    initData = (NCIPInitiationData) ncipData;
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

    public NCIPResponseData getResponseData() throws ToolkitInternalException {

        try {
            final NCIPResponseData respData;
            final NCIPData ncipData = (NCIPData) ReflectionHelper.unwrapFirstNonNullServiceDataFieldViaGetter(this);
            if (ncipData != null) {
                if (ncipData instanceof NCIPResponseData) {
                    respData = (NCIPResponseData) ncipData;
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

    public void setInitiationData(final NCIPInitiationData initiationData) throws ToolkitInternalException {
        ReflectionHelper.setField(this, initiationData, initiationData.getServiceName());
    }

    public void setResponseData(final NCIPResponseData responseData) throws ToolkitInternalException {
        ReflectionHelper.setField(this, responseData, responseData.getServiceName() + "Response");
    }

    protected String version;
    protected AcceptItemInitiationData acceptItem;
    protected AcceptItemResponseData acceptItemResponse;
    protected AgencyCreatedInitiationData agencyCreated;
    protected AgencyCreatedResponseData agencyCreatedResponse;
    protected AgencyUpdatedInitiationData agencyUpdated;
    protected AgencyUpdatedResponseData agencyUpdatedResponse;
    protected CancelRecallItemInitiationData cancelRecallItem;
    protected CancelRecallItemResponseData cancelRecallItemResponse;
    protected CancelRequestItemInitiationData cancelRequestItem;
    protected CancelRequestItemResponseData cancelRequestItemResponse;
    protected CheckInItemInitiationData checkInItem;
    protected CheckInItemResponseData checkInItemResponse;
    protected CheckOutItemInitiationData checkOutItem;
    protected CheckOutItemResponseData checkOutItemResponse;
    protected CirculationStatusChangeReportedInitiationData circulationStatusChangeReported;
    protected CirculationStatusChangeReportedResponseData circulationStatusChangeReportedResponse;
    protected CirculationStatusUpdatedInitiationData circulationStatusUpdated;
    protected CirculationStatusUpdatedResponseData circulationStatusUpdatedResponse;
    protected CreateAgencyInitiationData createAgency;
    protected CreateAgencyResponseData createAgencyResponse;
    protected CreateItemInitiationData createItem;
    protected CreateItemResponseData createItemResponse;
    protected CreateUserInitiationData createUser;
    protected CreateUserResponseData createUserResponse;
    protected CreateUserFiscalTransactionInitiationData createUserFiscalTransaction;
    protected CreateUserFiscalTransactionResponseData createUserFiscalTransactionResponse;
    protected DeleteItemInitiationData deleteItem;
    protected DeleteItemResponseData deleteItemResponse;
    protected DeleteUserInitiationData deleteUser;
    protected DeleteUserResponseData deleteUserResponse;
    protected ItemCheckedInInitiationData itemCheckedIn;
    protected ItemCheckedInResponseData itemCheckedInResponse;
    protected ItemCheckedOutInitiationData itemCheckedOut;
    protected ItemCheckedOutResponseData itemCheckedOutResponse;
    protected ItemCreatedInitiationData itemCreated;
    protected ItemCreatedResponseData itemCreatedResponse;
    protected ItemRecallCancelledInitiationData itemRecallCancelled;
    protected ItemRecallCancelledResponseData itemRecallCancelledResponse;
    protected ItemRecalledInitiationData itemRecalled;
    protected ItemRecalledResponseData itemRecalledResponse;
    protected ItemReceivedInitiationData itemReceived;
    protected ItemReceivedResponseData itemReceivedResponse;
    protected ItemRenewedInitiationData itemRenewed;
    protected ItemRenewedResponseData itemRenewedResponse;
    protected ItemRequestCancelledInitiationData itemRequestCancelled;
    protected ItemRequestCancelledResponseData itemRequestCancelledResponse;
    protected ItemRequestUpdatedInitiationData itemRequestUpdated;
    protected ItemRequestUpdatedResponseData itemRequestUpdatedResponse;
    protected ItemRequestedInitiationData itemRequested;
    protected ItemRequestedResponseData itemRequestedResponse;
    protected ItemShippedInitiationData itemShipped;
    protected ItemShippedResponseData itemShippedResponse;
    protected ItemUpdatedInitiationData itemUpdated;
    protected ItemUpdatedResponseData itemUpdatedResponse;
    protected LookupAgencyInitiationData lookupAgency;
    protected LookupAgencyResponseData lookupAgencyResponse;
    protected LookupItemSetInitiationData lookupItemSet;
    protected LookupItemSetResponseData lookupItemSetResponse;
    protected LookupItemInitiationData lookupItem;
    protected LookupItemResponseData lookupItemResponse;
    protected LookupRequestInitiationData lookupRequest;
    protected LookupRequestResponseData lookupRequestResponse;
    protected LookupUserInitiationData lookupUser;
    protected LookupUserResponseData lookupUserResponse;
    protected RecallItemInitiationData recallItem;
    protected RecallItemResponseData recallItemResponse;
    protected RenewAllItemInitiationData renewAllItem;
    protected RenewAllItemResponseData renewAllItemResponse;
    protected RenewItemInitiationData renewItem;
    protected RenewItemResponseData renewItemResponse;
    protected ReportCirculationStatusChangeInitiationData reportCirculationStatusChange;
    protected ReportCirculationStatusChangeResponseData reportCirculationStatusChangeResponse;
    protected RequestItemInitiationData requestItem;
    protected RequestItemResponseData requestItemResponse;
    protected SendUserNoticeInitiationData sendUserNotice;
    protected SendUserNoticeResponseData sendUserNoticeResponse;
    protected UndoCheckOutItemInitiationData undoCheckOutItem;
    protected UndoCheckOutItemResponseData undoCheckOutItemResponse;
    protected UpdateAgencyInitiationData updateAgency;
    protected UpdateAgencyResponseData updateAgencyResponse;
    protected UpdateCirculationStatusInitiationData updateCirculationStatus;
    protected UpdateCirculationStatusResponseData updateCirculationStatusResponse;
    protected UpdateItemInitiationData updateItem;
    protected UpdateItemResponseData updateItemResponse;
    protected UpdateRequestItemInitiationData updateRequestItem;
    protected UpdateRequestItemResponseData updateRequestItemResponse;
    protected UpdateUserInitiationData updateUser;
    protected UpdateUserResponseData updateUserResponse;
    protected UserCreatedInitiationData userCreated;
    protected UserCreatedResponseData userCreatedResponse;
    protected UserFiscalTransactionCreatedInitiationData userFiscalTransactionCreated;
    protected UserFiscalTransactionCreatedResponseData userFiscalTransactionCreatedResponse;
    protected UserNoticeSentInitiationData userNoticeSent;
    protected UserNoticeSentResponseData userNoticeSentResponse;
    protected UserUpdatedInitiationData userUpdated;
    protected UserUpdatedResponseData userUpdatedResponse;
    protected ProblemResponseData problemResponse;

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public AcceptItemInitiationData getAcceptItem() {
        return acceptItem;
    }

    public void setAcceptItem(final AcceptItemInitiationData acceptItem) {
        this.acceptItem = acceptItem;
        messageType = MessageType.INITIATION;
    }

    public AcceptItemResponseData getAcceptItemResponse() {
        return acceptItemResponse;
    }

    public void setAcceptItemResponse(final AcceptItemResponseData acceptItemResponse) {
        this.acceptItemResponse = acceptItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public AgencyCreatedInitiationData getAgencyCreated() {
        return agencyCreated;
    }

    public void setAgencyCreated(final AgencyCreatedInitiationData agencyCreated) {
        this.agencyCreated = agencyCreated;
        messageType = MessageType.INITIATION;
    }

    public AgencyCreatedResponseData getAgencyCreatedResponse() {
        return agencyCreatedResponse;
    }

    public void setAgencyCreatedResponse(final AgencyCreatedResponseData agencyCreatedResponse) {
        this.agencyCreatedResponse = agencyCreatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public AgencyUpdatedInitiationData getAgencyUpdated() {
        return agencyUpdated;
    }

    public void setAgencyUpdated(final AgencyUpdatedInitiationData agencyUpdated) {
        this.agencyUpdated = agencyUpdated;
        messageType = MessageType.INITIATION;
    }

    public AgencyUpdatedResponseData getAgencyUpdatedResponse() {
        return agencyUpdatedResponse;
    }

    public void setAgencyUpdatedResponse(final AgencyUpdatedResponseData agencyUpdatedResponse) {
        this.agencyUpdatedResponse = agencyUpdatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public CancelRecallItemInitiationData getCancelRecallItem() {
        return cancelRecallItem;
    }

    public void setCancelRecallItem(final CancelRecallItemInitiationData cancelRecallItem) {
        this.cancelRecallItem = cancelRecallItem;
        messageType = MessageType.INITIATION;
    }

    public CancelRecallItemResponseData getCancelRecallItemResponse() {
        return cancelRecallItemResponse;
    }

    public void setCancelRecallItemResponse(final CancelRecallItemResponseData cancelRecallItemResponse) {
        this.cancelRecallItemResponse = cancelRecallItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public CancelRequestItemInitiationData getCancelRequestItem() {
        return cancelRequestItem;
    }

    public void setCancelRequestItem(final CancelRequestItemInitiationData cancelRequestItem) {
        this.cancelRequestItem = cancelRequestItem;
        messageType = MessageType.INITIATION;
    }

    public CancelRequestItemResponseData getCancelRequestItemResponse() {
        return cancelRequestItemResponse;
    }

    public void setCancelRequestItemResponse(final CancelRequestItemResponseData cancelRequestItemResponse) {
        this.cancelRequestItemResponse = cancelRequestItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public CheckInItemInitiationData getCheckInItem() {
        return checkInItem;
    }

    public void setCheckInItem(final CheckInItemInitiationData checkInItem) {
        this.checkInItem = checkInItem;
        messageType = MessageType.INITIATION;
    }

    public CheckInItemResponseData getCheckInItemResponse() {
        return checkInItemResponse;
    }

    public void setCheckInItemResponse(final CheckInItemResponseData checkInItemResponse) {
        this.checkInItemResponse = checkInItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public CheckOutItemInitiationData getCheckOutItem() {
        return checkOutItem;
    }

    public void setCheckOutItem(final CheckOutItemInitiationData checkOutItem) {
        this.checkOutItem = checkOutItem;
        messageType = MessageType.INITIATION;
    }

    public CheckOutItemResponseData getCheckOutItemResponse() {
        return checkOutItemResponse;
    }

    public void setCheckOutItemResponse(final CheckOutItemResponseData checkOutItemResponse) {
        this.checkOutItemResponse = checkOutItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public CirculationStatusChangeReportedInitiationData getCirculationStatusChangeReported() {
        return circulationStatusChangeReported;
    }

    public void setCirculationStatusChangeReported(final CirculationStatusChangeReportedInitiationData circulationStatusChangeReported) {
        this.circulationStatusChangeReported = circulationStatusChangeReported;
        messageType = MessageType.INITIATION;
    }

    public CirculationStatusChangeReportedResponseData getCirculationStatusChangeReportedResponse() {
        return circulationStatusChangeReportedResponse;
    }

    public void setCirculationStatusChangeReportedResponse(final CirculationStatusChangeReportedResponseData circulationStatusChangeReportedResponse) {
        this.circulationStatusChangeReportedResponse = circulationStatusChangeReportedResponse;
        messageType = MessageType.RESPONSE;
    }

    public CirculationStatusUpdatedInitiationData getCirculationStatusUpdated() {
        return circulationStatusUpdated;
    }

    public void setCirculationStatusUpdated(final CirculationStatusUpdatedInitiationData circulationStatusUpdated) {
        this.circulationStatusUpdated = circulationStatusUpdated;
        messageType = MessageType.INITIATION;
    }

    public CirculationStatusUpdatedResponseData getCirculationStatusUpdatedResponse() {
        return circulationStatusUpdatedResponse;
    }

    public void setCirculationStatusUpdatedResponse(final CirculationStatusUpdatedResponseData circulationStatusUpdatedResponse) {
        this.circulationStatusUpdatedResponse = circulationStatusUpdatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public CreateAgencyInitiationData getCreateAgency() {
        return createAgency;
    }

    public void setCreateAgency(final CreateAgencyInitiationData createAgency) {
        this.createAgency = createAgency;
        messageType = MessageType.INITIATION;
    }

    public CreateAgencyResponseData getCreateAgencyResponse() {
        return createAgencyResponse;
    }

    public void setCreateAgencyResponse(final CreateAgencyResponseData createAgencyResponse) {
        this.createAgencyResponse = createAgencyResponse;
        messageType = MessageType.RESPONSE;
    }

    public CreateItemInitiationData getCreateItem() {
        return createItem;
    }

    public void setCreateItem(final CreateItemInitiationData createItem) {
        this.createItem = createItem;
        messageType = MessageType.INITIATION;
    }

    public CreateItemResponseData getCreateItemResponse() {
        return createItemResponse;
    }

    public void setCreateItemResponse(final CreateItemResponseData createItemResponse) {
        this.createItemResponse = createItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public CreateUserInitiationData getCreateUser() {
        return createUser;
    }

    public void setCreateUser(final CreateUserInitiationData createUser) {
        this.createUser = createUser;
        messageType = MessageType.INITIATION;
    }

    public CreateUserResponseData getCreateUserResponse() {
        return createUserResponse;
    }

    public void setCreateUserResponse(final CreateUserResponseData createUserResponse) {
        this.createUserResponse = createUserResponse;
        messageType = MessageType.RESPONSE;
    }

    public CreateUserFiscalTransactionInitiationData getCreateUserFiscalTransaction() {
        return createUserFiscalTransaction;
    }

    public void setCreateUserFiscalTransaction(final CreateUserFiscalTransactionInitiationData createUserFiscalTransaction) {
        this.createUserFiscalTransaction = createUserFiscalTransaction;
        messageType = MessageType.INITIATION;
    }

    public CreateUserFiscalTransactionResponseData getCreateUserFiscalTransactionResponse() {
        return createUserFiscalTransactionResponse;
    }

    public void setCreateUserFiscalTransactionResponse(final CreateUserFiscalTransactionResponseData createUserFiscalTransactionResponse) {
        this.createUserFiscalTransactionResponse = createUserFiscalTransactionResponse;
        messageType = MessageType.RESPONSE;
    }

    public DeleteItemInitiationData getDeleteItem() {
        return deleteItem;
    }

    public void setDeleteItem(final DeleteItemInitiationData deleteItem) {
        this.deleteItem = deleteItem;
        messageType = MessageType.INITIATION;
    }

    public DeleteItemResponseData getDeleteItemResponse() {
        return deleteItemResponse;
    }

    public void setDeleteItemResponse(final DeleteItemResponseData deleteItemResponse) {
        this.deleteItemResponse = deleteItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public DeleteUserInitiationData getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(final DeleteUserInitiationData deleteUser) {
        this.deleteUser = deleteUser;
        messageType = MessageType.INITIATION;
    }

    public DeleteUserResponseData getDeleteUserResponse() {
        return deleteUserResponse;
    }

    public void setDeleteUserResponse(final DeleteUserResponseData deleteUserResponse) {
        this.deleteUserResponse = deleteUserResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemCheckedInInitiationData getItemCheckedIn() {
        return itemCheckedIn;
    }

    public void setItemCheckedIn(final ItemCheckedInInitiationData itemCheckedIn) {
        this.itemCheckedIn = itemCheckedIn;
        messageType = MessageType.INITIATION;
    }

    public ItemCheckedInResponseData getItemCheckedInResponse() {
        return itemCheckedInResponse;
    }

    public void setItemCheckedInResponse(final ItemCheckedInResponseData itemCheckedInResponse) {
        this.itemCheckedInResponse = itemCheckedInResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemCheckedOutInitiationData getItemCheckedOut() {
        return itemCheckedOut;
    }

    public void setItemCheckedOut(final ItemCheckedOutInitiationData itemCheckedOut) {
        this.itemCheckedOut = itemCheckedOut;
        messageType = MessageType.INITIATION;
    }

    public ItemCheckedOutResponseData getItemCheckedOutResponse() {
        return itemCheckedOutResponse;
    }

    public void setItemCheckedOutResponse(final ItemCheckedOutResponseData itemCheckedOutResponse) {
        this.itemCheckedOutResponse = itemCheckedOutResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemCreatedInitiationData getItemCreated() {
        return itemCreated;
    }

    public void setItemCreated(final ItemCreatedInitiationData itemCreated) {
        this.itemCreated = itemCreated;
        messageType = MessageType.INITIATION;
    }

    public ItemCreatedResponseData getItemCreatedResponse() {
        return itemCreatedResponse;
    }

    public void setItemCreatedResponse(final ItemCreatedResponseData itemCreatedResponse) {
        this.itemCreatedResponse = itemCreatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemRecallCancelledInitiationData getItemRecallCancelled() {
        return itemRecallCancelled;
    }

    public void setItemRecallCancelled(final ItemRecallCancelledInitiationData itemRecallCancelled) {
        this.itemRecallCancelled = itemRecallCancelled;
        messageType = MessageType.INITIATION;
    }

    public ItemRecallCancelledResponseData getItemRecallCancelledResponse() {
        return itemRecallCancelledResponse;
    }

    public void setItemRecallCancelledResponse(final ItemRecallCancelledResponseData itemRecallCancelledResponse) {
        this.itemRecallCancelledResponse = itemRecallCancelledResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemRecalledInitiationData getItemRecalled() {
        return itemRecalled;
    }

    public void setItemRecalled(final ItemRecalledInitiationData itemRecalled) {
        this.itemRecalled = itemRecalled;
        messageType = MessageType.INITIATION;
    }

    public ItemRecalledResponseData getItemRecalledResponse() {
        return itemRecalledResponse;
    }

    public void setItemRecalledResponse(final ItemRecalledResponseData itemRecalledResponse) {
        this.itemRecalledResponse = itemRecalledResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemReceivedInitiationData getItemReceived() {
        return itemReceived;
    }

    public void setItemReceived(final ItemReceivedInitiationData itemReceived) {
        this.itemReceived = itemReceived;
        messageType = MessageType.INITIATION;
    }

    public ItemReceivedResponseData getItemReceivedResponse() {
        return itemReceivedResponse;
    }

    public void setItemReceivedResponse(final ItemReceivedResponseData itemReceivedResponse) {
        this.itemReceivedResponse = itemReceivedResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemRenewedInitiationData getItemRenewed() {
        return itemRenewed;
    }

    public void setItemRenewed(final ItemRenewedInitiationData itemRenewed) {
        this.itemRenewed = itemRenewed;
        messageType = MessageType.INITIATION;
    }

    public ItemRenewedResponseData getItemRenewedResponse() {
        return itemRenewedResponse;
    }

    public void setItemRenewedResponse(final ItemRenewedResponseData itemRenewedResponse) {
        this.itemRenewedResponse = itemRenewedResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemRequestCancelledInitiationData getItemRequestCancelled() {
        return itemRequestCancelled;
    }

    public void setItemRequestCancelled(final ItemRequestCancelledInitiationData itemRequestCancelled) {
        this.itemRequestCancelled = itemRequestCancelled;
        messageType = MessageType.INITIATION;
    }

    public ItemRequestCancelledResponseData getItemRequestCancelledResponse() {
        return itemRequestCancelledResponse;
    }

    public void setItemRequestCancelledResponse(final ItemRequestCancelledResponseData itemRequestCancelledResponse) {
        this.itemRequestCancelledResponse = itemRequestCancelledResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemRequestUpdatedInitiationData getItemRequestUpdated() {
        return itemRequestUpdated;
    }

    public void setItemRequestUpdated(final ItemRequestUpdatedInitiationData itemRequestUpdated) {
        this.itemRequestUpdated = itemRequestUpdated;
        messageType = MessageType.INITIATION;
    }

    public ItemRequestUpdatedResponseData getItemRequestUpdatedResponse() {
        return itemRequestUpdatedResponse;
    }

    public void setItemRequestUpdatedResponse(final ItemRequestUpdatedResponseData itemRequestUpdatedResponse) {
        this.itemRequestUpdatedResponse = itemRequestUpdatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemRequestedInitiationData getItemRequested() {
        return itemRequested;
    }

    public void setItemRequested(final ItemRequestedInitiationData itemRequested) {
        this.itemRequested = itemRequested;
        messageType = MessageType.INITIATION;
    }

    public ItemRequestedResponseData getItemRequestedResponse() {
        return itemRequestedResponse;
    }

    public void setItemRequestedResponse(final ItemRequestedResponseData itemRequestedResponse) {
        this.itemRequestedResponse = itemRequestedResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemShippedInitiationData getItemShipped() {
        return itemShipped;
    }

    public void setItemShipped(final ItemShippedInitiationData itemShipped) {
        this.itemShipped = itemShipped;
        messageType = MessageType.INITIATION;
    }

    public ItemShippedResponseData getItemShippedResponse() {
        return itemShippedResponse;
    }

    public void setItemShippedResponse(final ItemShippedResponseData itemShippedResponse) {
        this.itemShippedResponse = itemShippedResponse;
        messageType = MessageType.RESPONSE;
    }

    public ItemUpdatedInitiationData getItemUpdated() {
        return itemUpdated;
    }

    public void setItemUpdated(final ItemUpdatedInitiationData itemUpdated) {
        this.itemUpdated = itemUpdated;
        messageType = MessageType.INITIATION;
    }

    public ItemUpdatedResponseData getItemUpdatedResponse() {
        return itemUpdatedResponse;
    }

    public void setItemUpdatedResponse(final ItemUpdatedResponseData itemUpdatedResponse) {
        this.itemUpdatedResponse = itemUpdatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public LookupAgencyInitiationData getLookupAgency() {
        return lookupAgency;
    }

    public void setLookupAgency(final LookupAgencyInitiationData lookupAgency) {
        this.lookupAgency = lookupAgency;
        messageType = MessageType.INITIATION;
    }

    public LookupAgencyResponseData getLookupAgencyResponse() {
        return lookupAgencyResponse;
    }

    public void setLookupAgencyResponse(final LookupAgencyResponseData lookupAgencyResponse) {
        this.lookupAgencyResponse = lookupAgencyResponse;
        messageType = MessageType.RESPONSE;
    }

    public LookupItemInitiationData getLookupItem() {
        return lookupItem;
    }

    public void setLookupItem(final LookupItemInitiationData lookupItem) {
        this.lookupItem = lookupItem;
        messageType = MessageType.INITIATION;
    }

    public LookupItemResponseData getLookupItemResponse() {
        return lookupItemResponse;
    }

    public void setLookupItemResponse(final LookupItemResponseData lookupItemResponse) {
        this.lookupItemResponse = lookupItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public void setLookupItemSet(final LookupItemSetInitiationData lookupItemSet) {
        this.lookupItemSet = lookupItemSet;
        messageType = MessageType.INITIATION;
    }

    public LookupItemSetInitiationData getLookupItemSet() {
        return lookupItemSet;
    }

    public LookupItemSetResponseData getLookupItemSetResponse() {
        return lookupItemSetResponse;
    }

    public void setLookupItemSetResponse(final LookupItemSetResponseData lookupItemSetResponse) {
        this.lookupItemSetResponse = lookupItemSetResponse;
        messageType = MessageType.RESPONSE;
    }

    public LookupRequestInitiationData getLookupRequest() {
        return lookupRequest;
    }

    public void setLookupRequest(final LookupRequestInitiationData lookupRequest) {
        this.lookupRequest = lookupRequest;
        messageType = MessageType.INITIATION;
    }

    public LookupRequestResponseData getLookupRequestResponse() {
        return lookupRequestResponse;
    }

    public void setLookupRequestResponse(final LookupRequestResponseData lookupRequestResponse) {
        this.lookupRequestResponse = lookupRequestResponse;
        messageType = MessageType.RESPONSE;
    }

    public LookupUserInitiationData getLookupUser() {
        return lookupUser;
    }

    public void setLookupUser(final LookupUserInitiationData lookupUser) {
        this.lookupUser = lookupUser;
        messageType = MessageType.INITIATION;
    }

    public LookupUserResponseData getLookupUserResponse() {
        return lookupUserResponse;
    }

    public void setLookupUserResponse(final LookupUserResponseData lookupUserResponse) {
        this.lookupUserResponse = lookupUserResponse;
        messageType = MessageType.RESPONSE;
    }

    public RecallItemInitiationData getRecallItem() {
        return recallItem;
    }

    public void setRecallItem(final RecallItemInitiationData recallItem) {
        this.recallItem = recallItem;
        messageType = MessageType.INITIATION;
    }

    public RecallItemResponseData getRecallItemResponse() {
        return recallItemResponse;
    }

    public void setRecallItemResponse(final RecallItemResponseData recallItemResponse) {
        this.recallItemResponse = recallItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public RenewAllItemInitiationData getRenewAllItem() {
        return renewAllItem;
    }

    public void setRenewAllItem(final RenewAllItemInitiationData renewAllItem) {
        this.renewAllItem = renewAllItem;
        messageType = MessageType.INITIATION;
    }

    public RenewAllItemResponseData getRenewAllItemResponse() {
        return renewAllItemResponse;
    }

    public void setRenewAllItemResponse(final RenewAllItemResponseData renewAllItemResponse) {
        this.renewAllItemResponse = renewAllItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public RenewItemInitiationData getRenewItem() {
        return renewItem;
    }

    public void setRenewItem(final RenewItemInitiationData renewItem) {
        this.renewItem = renewItem;
        messageType = MessageType.INITIATION;
    }

    public RenewItemResponseData getRenewItemResponse() {
        return renewItemResponse;
    }

    public void setRenewItemResponse(final RenewItemResponseData renewItemResponse) {
        this.renewItemResponse = renewItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public ReportCirculationStatusChangeInitiationData getReportCirculationStatusChange() {
        return reportCirculationStatusChange;
    }

    public void setReportCirculationStatusChange(final ReportCirculationStatusChangeInitiationData reportCirculationStatusChange) {
        this.reportCirculationStatusChange = reportCirculationStatusChange;
        messageType = MessageType.INITIATION;
    }

    public ReportCirculationStatusChangeResponseData getReportCirculationStatusChangeResponse() {
        return reportCirculationStatusChangeResponse;
    }

    public void setReportCirculationStatusChangeResponse(final ReportCirculationStatusChangeResponseData reportCirculationStatusChangeResponse) {
        this.reportCirculationStatusChangeResponse = reportCirculationStatusChangeResponse;
        messageType = MessageType.RESPONSE;
    }

    public RequestItemInitiationData getRequestItem() {
        return requestItem;
    }

    public void setRequestItem(final RequestItemInitiationData requestItem) {
        this.requestItem = requestItem;
        messageType = MessageType.INITIATION;
    }

    public RequestItemResponseData getRequestItemResponse() {
        return requestItemResponse;
    }

    public void setRequestItemResponse(final RequestItemResponseData requestItemResponse) {
        this.requestItemResponse = requestItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public SendUserNoticeInitiationData getSendUserNotice() {
        return sendUserNotice;
    }

    public void setSendUserNotice(final SendUserNoticeInitiationData sendUserNotice) {
        this.sendUserNotice = sendUserNotice;
        messageType = MessageType.INITIATION;
    }

    public SendUserNoticeResponseData getSendUserNoticeResponse() {
        return sendUserNoticeResponse;
    }

    public void setSendUserNoticeResponse(final SendUserNoticeResponseData sendUserNoticeResponse) {
        this.sendUserNoticeResponse = sendUserNoticeResponse;
        messageType = MessageType.RESPONSE;
    }

    public UndoCheckOutItemInitiationData getUndoCheckOutItem() {
        return undoCheckOutItem;
    }

    public void setUndoCheckOutItem(final UndoCheckOutItemInitiationData undoCheckOutItem) {
        this.undoCheckOutItem = undoCheckOutItem;
        messageType = MessageType.INITIATION;
    }

    public UndoCheckOutItemResponseData getUndoCheckOutItemResponse() {
        return undoCheckOutItemResponse;
    }

    public void setUndoCheckOutItemResponse(final UndoCheckOutItemResponseData undoCheckOutItemResponse) {
        this.undoCheckOutItemResponse = undoCheckOutItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public UpdateAgencyInitiationData getUpdateAgency() {
        return updateAgency;
    }

    public void setUpdateAgency(final UpdateAgencyInitiationData updateAgency) {
        this.updateAgency = updateAgency;
        messageType = MessageType.INITIATION;
    }

    public UpdateAgencyResponseData getUpdateAgencyResponse() {
        return updateAgencyResponse;
    }

    public void setUpdateAgencyResponse(final UpdateAgencyResponseData updateAgencyResponse) {
        this.updateAgencyResponse = updateAgencyResponse;
        messageType = MessageType.RESPONSE;
    }

    public UpdateCirculationStatusInitiationData getUpdateCirculationStatus() {
        return updateCirculationStatus;
    }

    public void setUpdateCirculationStatus(final UpdateCirculationStatusInitiationData updateCirculationStatus) {
        this.updateCirculationStatus = updateCirculationStatus;
        messageType = MessageType.INITIATION;
    }

    public UpdateCirculationStatusResponseData getUpdateCirculationStatusResponse() {
        return updateCirculationStatusResponse;
    }

    public void setUpdateCirculationStatusResponse(final UpdateCirculationStatusResponseData updateCirculationStatusResponse) {
        this.updateCirculationStatusResponse = updateCirculationStatusResponse;
        messageType = MessageType.RESPONSE;
    }

    public UpdateItemInitiationData getUpdateItem() {
        return updateItem;
    }

    public void setUpdateItem(final UpdateItemInitiationData updateItem) {
        this.updateItem = updateItem;
        messageType = MessageType.INITIATION;
    }

    public UpdateItemResponseData getUpdateItemResponse() {
        return updateItemResponse;
    }

    public void setUpdateItemResponse(final UpdateItemResponseData updateItemResponse) {
        this.updateItemResponse = updateItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public UpdateRequestItemInitiationData getUpdateRequestItem() {
        return updateRequestItem;
    }

    public void setUpdateRequestItem(final UpdateRequestItemInitiationData updateRequestItem) {
        this.updateRequestItem = updateRequestItem;
        messageType = MessageType.INITIATION;
    }

    public UpdateRequestItemResponseData getUpdateRequestItemResponse() {
        return updateRequestItemResponse;
    }

    public void setUpdateRequestItemResponse(final UpdateRequestItemResponseData updateRequestItemResponse) {
        this.updateRequestItemResponse = updateRequestItemResponse;
        messageType = MessageType.RESPONSE;
    }

    public UpdateUserInitiationData getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(final UpdateUserInitiationData updateUser) {
        this.updateUser = updateUser;
        messageType = MessageType.INITIATION;
    }

    public UpdateUserResponseData getUpdateUserResponse() {
        return updateUserResponse;
    }

    public void setUpdateUserResponse(final UpdateUserResponseData updateUserResponse) {
        this.updateUserResponse = updateUserResponse;
        messageType = MessageType.RESPONSE;
    }

    public UserCreatedInitiationData getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(final UserCreatedInitiationData userCreated) {
        this.userCreated = userCreated;
        messageType = MessageType.INITIATION;
    }

    public UserCreatedResponseData getUserCreatedResponse() {
        return userCreatedResponse;
    }

    public void setUserCreatedResponse(final UserCreatedResponseData userCreatedResponse) {
        this.userCreatedResponse = userCreatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public UserFiscalTransactionCreatedInitiationData getUserFiscalTransactionCreated() {
        return userFiscalTransactionCreated;
    }

    public void setUserFiscalTransactionCreated(final UserFiscalTransactionCreatedInitiationData userFiscalTransactionCreated) {
        this.userFiscalTransactionCreated = userFiscalTransactionCreated;
        messageType = MessageType.INITIATION;
    }

    public UserFiscalTransactionCreatedResponseData getUserFiscalTransactionCreatedResponse() {
        return userFiscalTransactionCreatedResponse;
    }

    public void setUserFiscalTransactionCreatedResponse(final UserFiscalTransactionCreatedResponseData userFiscalTransactionCreatedResponse) {
        this.userFiscalTransactionCreatedResponse = userFiscalTransactionCreatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public UserNoticeSentInitiationData getUserNoticeSent() {
        return userNoticeSent;
    }

    public void setUserNoticeSent(final UserNoticeSentInitiationData userNoticeSent) {
        this.userNoticeSent = userNoticeSent;
        messageType = MessageType.INITIATION;
    }

    public UserNoticeSentResponseData getUserNoticeSentResponse() {
        return userNoticeSentResponse;
    }

    public void setUserNoticeSentResponse(final UserNoticeSentResponseData userNoticeSentResponse) {
        this.userNoticeSentResponse = userNoticeSentResponse;
        messageType = MessageType.RESPONSE;
    }

    public UserUpdatedInitiationData getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(final UserUpdatedInitiationData userUpdated) {
        this.userUpdated = userUpdated;
        messageType = MessageType.INITIATION;
    }

    public UserUpdatedResponseData getUserUpdatedResponse() {
        return userUpdatedResponse;
    }

    public void setUserUpdatedResponse(final UserUpdatedResponseData userUpdatedResponse) {
        this.userUpdatedResponse = userUpdatedResponse;
        messageType = MessageType.RESPONSE;
    }

    public ProblemResponseData getProblemResponse() {
        return problemResponse;
    }

    public void setProblemResponse(final ProblemResponseData problemResponse) {
        this.problemResponse = problemResponse;
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
        final NCIPMessage rhs = (NCIPMessage) obj;
        return new EqualsBuilder().append(messageType, rhs.messageType).append(version, rhs.version).append(acceptItem, rhs.acceptItem)
            .append(acceptItemResponse, rhs.acceptItemResponse).append(agencyCreated, rhs.agencyCreated).append(agencyCreatedResponse, rhs.agencyCreatedResponse)
            .append(agencyUpdated, rhs.agencyUpdated).append(agencyUpdatedResponse, rhs.agencyUpdatedResponse).append(cancelRecallItem, rhs.cancelRecallItem)
            .append(cancelRecallItemResponse, rhs.cancelRecallItemResponse).append(cancelRequestItem, rhs.cancelRequestItem)
            .append(cancelRequestItemResponse, rhs.cancelRequestItemResponse).append(checkInItem, rhs.checkInItem).append(checkInItemResponse, rhs.checkInItemResponse)
            .append(checkOutItem, rhs.checkOutItem).append(checkOutItemResponse, rhs.checkOutItemResponse)
            .append(circulationStatusChangeReported, rhs.circulationStatusChangeReported)
            .append(circulationStatusChangeReportedResponse, rhs.circulationStatusChangeReportedResponse).append(circulationStatusUpdated, rhs.circulationStatusUpdated)
            .append(circulationStatusUpdatedResponse, rhs.circulationStatusUpdatedResponse).append(createAgency, rhs.createAgency)
            .append(createAgencyResponse, rhs.createAgencyResponse).append(createItem, rhs.createItem).append(createItemResponse, rhs.createItemResponse)
            .append(createUser, rhs.createUser).append(createUserResponse, rhs.createUserResponse).append(createUserFiscalTransaction, rhs.createUserFiscalTransaction)
            .append(createUserFiscalTransactionResponse, rhs.createUserFiscalTransactionResponse).append(deleteItem, rhs.deleteItem)
            .append(deleteItemResponse, rhs.deleteItemResponse).append(deleteUser, rhs.deleteUser).append(deleteUserResponse, rhs.deleteUserResponse)
            .append(itemCheckedIn, rhs.itemCheckedIn).append(itemCheckedInResponse, rhs.itemCheckedInResponse).append(itemCheckedOut, rhs.itemCheckedOut)
            .append(itemCheckedOutResponse, rhs.itemCheckedOutResponse).append(itemCreated, rhs.itemCreated).append(itemCreatedResponse, rhs.itemCreatedResponse)
            .append(itemRecallCancelled, rhs.itemRecallCancelled).append(itemRecallCancelledResponse, rhs.itemRecallCancelledResponse).append(itemRecalled, rhs.itemRecalled)
            .append(itemRecalledResponse, rhs.itemRecalledResponse).append(itemReceived, rhs.itemReceived).append(itemReceivedResponse, rhs.itemReceivedResponse)
            .append(itemRenewed, rhs.itemRenewed).append(itemRenewedResponse, rhs.itemRenewedResponse).append(itemRequestCancelled, rhs.itemRequestCancelled)
            .append(itemRequestCancelledResponse, rhs.itemRequestCancelledResponse).append(itemRequestUpdated, rhs.itemRequestUpdated)
            .append(itemRequestUpdatedResponse, rhs.itemRequestUpdatedResponse).append(itemRequested, rhs.itemRequested).append(itemRequestedResponse, rhs.itemRequestedResponse)
            .append(itemShipped, rhs.itemShipped).append(itemShippedResponse, rhs.itemShippedResponse).append(itemUpdated, rhs.itemUpdated)
            .append(itemUpdatedResponse, rhs.itemUpdatedResponse).append(lookupAgency, rhs.lookupAgency).append(lookupAgencyResponse, rhs.lookupAgencyResponse)
            .append(lookupItemSet, rhs.lookupItemSet).append(lookupItemSetResponse, rhs.lookupItemSetResponse).append(lookupItem, rhs.lookupItem)
            .append(lookupItemResponse, rhs.lookupItemResponse).append(lookupRequest, rhs.lookupRequest).append(lookupRequestResponse, rhs.lookupRequestResponse)
            .append(lookupUser, rhs.lookupUser).append(lookupUserResponse, rhs.lookupUserResponse).append(recallItem, rhs.recallItem)
            .append(recallItemResponse, rhs.recallItemResponse).append(renewAllItem, rhs.renewAllItem).append(renewAllItemResponse, rhs.renewAllItemResponse)
            .append(renewItem, rhs.renewItem).append(renewItemResponse, rhs.renewItemResponse).append(renewAllItem, rhs.renewAllItem)
            .append(renewAllItemResponse, rhs.renewAllItemResponse).append(reportCirculationStatusChange, rhs.reportCirculationStatusChange)
            .append(reportCirculationStatusChangeResponse, rhs.reportCirculationStatusChangeResponse).append(requestItem, rhs.requestItem)
            .append(requestItemResponse, rhs.requestItemResponse).append(sendUserNotice, rhs.sendUserNotice).append(sendUserNoticeResponse, rhs.sendUserNoticeResponse)
            .append(undoCheckOutItem, rhs.undoCheckOutItem).append(undoCheckOutItemResponse, rhs.undoCheckOutItemResponse).append(updateAgency, rhs.updateAgency)
            .append(updateAgencyResponse, rhs.updateAgencyResponse).append(updateCirculationStatus, rhs.updateCirculationStatus)
            .append(updateCirculationStatusResponse, rhs.updateCirculationStatusResponse).append(updateItem, rhs.updateItem).append(updateItemResponse, rhs.updateItemResponse)
            .append(updateRequestItem, rhs.updateRequestItem).append(updateRequestItemResponse, rhs.updateRequestItemResponse).append(updateUser, rhs.updateUser)
            .append(updateUserResponse, rhs.updateUserResponse).append(userCreated, rhs.userCreated).append(userCreatedResponse, rhs.userCreatedResponse)
            .append(userFiscalTransactionCreated, rhs.userFiscalTransactionCreated).append(userFiscalTransactionCreatedResponse, rhs.userFiscalTransactionCreatedResponse)
            .append(userNoticeSent, rhs.userNoticeSent).append(userNoticeSentResponse, rhs.userNoticeSentResponse).append(userUpdated, rhs.userUpdated)
            .append(userUpdatedResponse, rhs.userUpdatedResponse).append(problemResponse, rhs.problemResponse).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1412285223, 660406619).append(messageType).append(version).append(acceptItem).append(acceptItemResponse).append(agencyCreated)
            .append(agencyCreatedResponse).append(agencyUpdated).append(agencyUpdatedResponse).append(cancelRecallItem).append(cancelRecallItemResponse).append(cancelRequestItem)
            .append(cancelRequestItemResponse).append(checkInItem).append(checkInItemResponse).append(checkOutItem).append(checkOutItemResponse)
            .append(circulationStatusChangeReported).append(circulationStatusChangeReportedResponse).append(circulationStatusUpdated).append(circulationStatusUpdatedResponse)
            .append(createAgency).append(createAgencyResponse).append(createItem).append(createItemResponse).append(createUser).append(createUserResponse)
            .append(createUserFiscalTransaction).append(createUserFiscalTransactionResponse).append(deleteItem).append(deleteItemResponse).append(deleteUser)
            .append(deleteUserResponse).append(itemCheckedIn).append(itemCheckedInResponse).append(itemCheckedOut).append(itemCheckedOutResponse).append(itemCreated)
            .append(itemCreatedResponse).append(itemRecallCancelled).append(itemRecallCancelledResponse).append(itemRecalled).append(itemRecalledResponse).append(itemReceived)
            .append(itemReceivedResponse).append(itemRenewed).append(itemRenewedResponse).append(itemRequestCancelled).append(itemRequestCancelledResponse)
            .append(itemRequestUpdated).append(itemRequestUpdatedResponse).append(itemRequested).append(itemRequestedResponse).append(itemShipped).append(itemShippedResponse)
            .append(itemUpdated).append(itemUpdatedResponse).append(lookupAgency).append(lookupAgencyResponse).append(lookupItemSet).append(lookupItemSetResponse)
            .append(lookupItem).append(lookupItemResponse).append(lookupRequest).append(lookupRequestResponse).append(lookupUser).append(lookupUserResponse).append(recallItem)
            .append(recallItemResponse).append(renewAllItem).append(renewAllItemResponse).append(renewItem).append(renewItemResponse).append(renewAllItem)
            .append(renewAllItemResponse).append(reportCirculationStatusChange).append(reportCirculationStatusChangeResponse).append(requestItem).append(requestItemResponse)
            .append(sendUserNotice).append(sendUserNoticeResponse).append(undoCheckOutItem).append(undoCheckOutItemResponse).append(updateAgency).append(updateAgencyResponse)
            .append(updateCirculationStatus).append(updateCirculationStatusResponse).append(updateItem).append(updateItemResponse).append(updateRequestItem)
            .append(updateRequestItemResponse).append(updateUser).append(updateUserResponse).append(userCreated).append(userCreatedResponse).append(userFiscalTransactionCreated)
            .append(userFiscalTransactionCreatedResponse).append(userNoticeSent).append(userNoticeSentResponse).append(userUpdated).append(userUpdatedResponse)
            .append(problemResponse).toHashCode();
        return result;
    }
}
