/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.dozer;

import org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.Ext;
import org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.ObjectFactory;
import org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.SchemeValuePair;
import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseContentConverter;
import org.oclc.circill.toolkit.service.ncip.AcceptItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.AcceptItemResponseData;
import org.oclc.circill.toolkit.service.ncip.AgencyCreatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.AgencyCreatedResponseData;
import org.oclc.circill.toolkit.service.ncip.AgencyUpdatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.AgencyUpdatedResponseData;
import org.oclc.circill.toolkit.service.ncip.CancelRecallItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.CancelRecallItemResponseData;
import org.oclc.circill.toolkit.service.ncip.CancelRequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.CancelRequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.CheckInItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.CheckInItemResponseData;
import org.oclc.circill.toolkit.service.ncip.CheckOutItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.CheckOutItemResponseData;
import org.oclc.circill.toolkit.service.ncip.CirculationStatusChangeReportedInitiationData;
import org.oclc.circill.toolkit.service.ncip.CirculationStatusChangeReportedResponseData;
import org.oclc.circill.toolkit.service.ncip.CirculationStatusUpdatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.CirculationStatusUpdatedResponseData;
import org.oclc.circill.toolkit.service.ncip.CreateAgencyInitiationData;
import org.oclc.circill.toolkit.service.ncip.CreateAgencyResponseData;
import org.oclc.circill.toolkit.service.ncip.CreateItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.CreateItemResponseData;
import org.oclc.circill.toolkit.service.ncip.CreateUserFiscalTransactionInitiationData;
import org.oclc.circill.toolkit.service.ncip.CreateUserFiscalTransactionResponseData;
import org.oclc.circill.toolkit.service.ncip.CreateUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.CreateUserResponseData;
import org.oclc.circill.toolkit.service.ncip.DeleteItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.DeleteItemResponseData;
import org.oclc.circill.toolkit.service.ncip.DeleteUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.DeleteUserResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemCheckedInInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemCheckedInResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemCheckedOutInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemCheckedOutResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemCreatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemCreatedResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemRecallCancelledInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemRecallCancelledResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemRecalledInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemRecalledResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemReceivedInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemReceivedResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemRenewedInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemRenewedResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemRequestCancelledInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemRequestCancelledResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemRequestUpdatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemRequestUpdatedResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemRequestedInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemRequestedResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemShippedInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemShippedResponseData;
import org.oclc.circill.toolkit.service.ncip.ItemUpdatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.ItemUpdatedResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupAgencyInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupAgencyResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupItemResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupItemSetInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupItemSetResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupRequestInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupRequestResponseData;
import org.oclc.circill.toolkit.service.ncip.LookupUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupUserResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.ProblemResponseData;
import org.oclc.circill.toolkit.service.ncip.RecallItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RecallItemResponseData;
import org.oclc.circill.toolkit.service.ncip.RenewItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RenewItemResponseData;
import org.oclc.circill.toolkit.service.ncip.ReportCirculationStatusChangeInitiationData;
import org.oclc.circill.toolkit.service.ncip.ReportCirculationStatusChangeResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.SendUserNoticeInitiationData;
import org.oclc.circill.toolkit.service.ncip.SendUserNoticeResponseData;
import org.oclc.circill.toolkit.service.ncip.UndoCheckOutItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.UndoCheckOutItemResponseData;
import org.oclc.circill.toolkit.service.ncip.UpdateAgencyInitiationData;
import org.oclc.circill.toolkit.service.ncip.UpdateAgencyResponseData;
import org.oclc.circill.toolkit.service.ncip.UpdateCirculationStatusInitiationData;
import org.oclc.circill.toolkit.service.ncip.UpdateCirculationStatusResponseData;
import org.oclc.circill.toolkit.service.ncip.UpdateItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.UpdateItemResponseData;
import org.oclc.circill.toolkit.service.ncip.UpdateRequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.UpdateRequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.UpdateUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.UpdateUserResponseData;
import org.oclc.circill.toolkit.service.ncip.UserCreatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.UserCreatedResponseData;
import org.oclc.circill.toolkit.service.ncip.UserFiscalTransactionCreatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.UserFiscalTransactionCreatedResponseData;
import org.oclc.circill.toolkit.service.ncip.UserNoticeSentInitiationData;
import org.oclc.circill.toolkit.service.ncip.UserNoticeSentResponseData;
import org.oclc.circill.toolkit.service.ncip.UserUpdatedInitiationData;
import org.oclc.circill.toolkit.service.ncip.UserUpdatedResponseData;

import java.util.HashMap;
import java.util.Map;

/**
 * Content mapping factory for the package.
 * @see BaseContentConverter BaseContentConverter for usage.
 */
@SuppressWarnings({"checkstyle:TypeName", "checkstyle:ConstantName"})
public class ILSDIv1_0_bc_ContentMappingFactory
    extends BaseContentConverter<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData, SchemeValuePair, Ext> {

    /**
     * Maps element names (derived in this case from JAXB field names) to service-package class names.
     */
    protected static final Map<String, Class<?>> elementNamesToServiceClassMap = new HashMap<>();

    static {

        elementNamesToServiceClassMap.put("AcceptItem", AcceptItemInitiationData.class);
        elementNamesToServiceClassMap.put("AcceptItemResponse", AcceptItemResponseData.class);
        elementNamesToServiceClassMap.put("AgencyCreated", AgencyCreatedInitiationData.class);
        elementNamesToServiceClassMap.put("AgencyCreatedResponse", AgencyCreatedResponseData.class);
        elementNamesToServiceClassMap.put("AgencyUpdated", AgencyUpdatedInitiationData.class);
        elementNamesToServiceClassMap.put("AgencyUpdatedResponse", AgencyUpdatedResponseData.class);
        elementNamesToServiceClassMap.put("CancelRecallItem", CancelRecallItemInitiationData.class);
        elementNamesToServiceClassMap.put("CancelRecallItemResponse", CancelRecallItemResponseData.class);
        elementNamesToServiceClassMap.put("CancelRequestItem", CancelRequestItemInitiationData.class);
        elementNamesToServiceClassMap.put("CancelRequestItemResponse", CancelRequestItemResponseData.class);
        elementNamesToServiceClassMap.put("CheckInItem", CheckInItemInitiationData.class);
        elementNamesToServiceClassMap.put("CheckInItemResponse", CheckInItemResponseData.class);
        elementNamesToServiceClassMap.put("CheckOutItem", CheckOutItemInitiationData.class);
        elementNamesToServiceClassMap.put("CheckOutItemResponse", CheckOutItemResponseData.class);
        elementNamesToServiceClassMap.put("CirculationStatusChangeReported", CirculationStatusChangeReportedInitiationData.class);
        elementNamesToServiceClassMap.put("CirculationStatusChangeReportedResponse", CirculationStatusChangeReportedResponseData.class);
        elementNamesToServiceClassMap.put("CirculationStatusUpdated", CirculationStatusUpdatedInitiationData.class);
        elementNamesToServiceClassMap.put("CirculationStatusUpdatedResponse", CirculationStatusUpdatedResponseData.class);
        elementNamesToServiceClassMap.put("CreateAgency", CreateAgencyInitiationData.class);
        elementNamesToServiceClassMap.put("CreateAgencyResponse", CreateAgencyResponseData.class);
        elementNamesToServiceClassMap.put("CreateItem", CreateItemInitiationData.class);
        elementNamesToServiceClassMap.put("CreateItemResponse", CreateItemResponseData.class);
        elementNamesToServiceClassMap.put("CreateUser", CreateUserInitiationData.class);
        elementNamesToServiceClassMap.put("CreateUserResponse", CreateUserResponseData.class);
        elementNamesToServiceClassMap.put("CreateUserFiscalTransaction", CreateUserFiscalTransactionInitiationData.class);
        elementNamesToServiceClassMap.put("CreateUserFiscalTransactionResponse", CreateUserFiscalTransactionResponseData.class);
        elementNamesToServiceClassMap.put("DeleteItem", DeleteItemInitiationData.class);
        elementNamesToServiceClassMap.put("DeleteItemResponse", DeleteItemResponseData.class);
        elementNamesToServiceClassMap.put("DeleteUser", DeleteUserInitiationData.class);
        elementNamesToServiceClassMap.put("DeleteUserResponse", DeleteUserResponseData.class);
        elementNamesToServiceClassMap.put("ItemCheckedIn", ItemCheckedInInitiationData.class);
        elementNamesToServiceClassMap.put("ItemCheckedInResponse", ItemCheckedInResponseData.class);
        elementNamesToServiceClassMap.put("ItemCheckedOut", ItemCheckedOutInitiationData.class);
        elementNamesToServiceClassMap.put("ItemCheckedOutResponse", ItemCheckedOutResponseData.class);
        elementNamesToServiceClassMap.put("ItemCreated", ItemCreatedInitiationData.class);
        elementNamesToServiceClassMap.put("ItemCreatedResponse", ItemCreatedResponseData.class);
        elementNamesToServiceClassMap.put("ItemRecallCancelled", ItemRecallCancelledInitiationData.class);
        elementNamesToServiceClassMap.put("ItemRecallCancelledResponse", ItemRecallCancelledResponseData.class);
        elementNamesToServiceClassMap.put("ItemRecalled", ItemRecalledInitiationData.class);
        elementNamesToServiceClassMap.put("ItemRecalledResponse", ItemRecalledResponseData.class);
        elementNamesToServiceClassMap.put("ItemReceived", ItemReceivedInitiationData.class);
        elementNamesToServiceClassMap.put("ItemReceivedResponse", ItemReceivedResponseData.class);
        elementNamesToServiceClassMap.put("ItemRenewed", ItemRenewedInitiationData.class);
        elementNamesToServiceClassMap.put("ItemRenewedResponse", ItemRenewedResponseData.class);
        elementNamesToServiceClassMap.put("ItemRequestCancelled", ItemRequestCancelledInitiationData.class);
        elementNamesToServiceClassMap.put("ItemRequestCancelledResponse", ItemRequestCancelledResponseData.class);
        elementNamesToServiceClassMap.put("ItemRequestUpdated", ItemRequestUpdatedInitiationData.class);
        elementNamesToServiceClassMap.put("ItemRequestUpdatedResponse", ItemRequestUpdatedResponseData.class);
        elementNamesToServiceClassMap.put("ItemRequested", ItemRequestedInitiationData.class);
        elementNamesToServiceClassMap.put("ItemRequestedResponse", ItemRequestedResponseData.class);
        elementNamesToServiceClassMap.put("ItemShipped", ItemShippedInitiationData.class);
        elementNamesToServiceClassMap.put("ItemShippedResponse", ItemShippedResponseData.class);
        elementNamesToServiceClassMap.put("ItemUpdated", ItemUpdatedInitiationData.class);
        elementNamesToServiceClassMap.put("ItemUpdatedResponse", ItemUpdatedResponseData.class);
        elementNamesToServiceClassMap.put("LookupAgency", LookupAgencyInitiationData.class);
        elementNamesToServiceClassMap.put("LookupAgencyResponse", LookupAgencyResponseData.class);
        elementNamesToServiceClassMap.put("LookupItemSet", LookupItemSetInitiationData.class);
        elementNamesToServiceClassMap.put("LookupItemSetResponse", LookupItemSetResponseData.class);
        elementNamesToServiceClassMap.put("LookupItem", LookupItemInitiationData.class);
        elementNamesToServiceClassMap.put("LookupItemResponse", LookupItemResponseData.class);
        elementNamesToServiceClassMap.put("LookupRequest", LookupRequestInitiationData.class);
        elementNamesToServiceClassMap.put("LookupRequestResponse", LookupRequestResponseData.class);
        elementNamesToServiceClassMap.put("LookupUser", LookupUserInitiationData.class);
        elementNamesToServiceClassMap.put("LookupUserResponse", LookupUserResponseData.class);
        elementNamesToServiceClassMap.put("RecallItem", RecallItemInitiationData.class);
        elementNamesToServiceClassMap.put("RecallItemResponse", RecallItemResponseData.class);
        elementNamesToServiceClassMap.put("RenewItem", RenewItemInitiationData.class);
        elementNamesToServiceClassMap.put("RenewItemResponse", RenewItemResponseData.class);
        elementNamesToServiceClassMap.put("ReportCirculationStatusChange", ReportCirculationStatusChangeInitiationData.class);
        elementNamesToServiceClassMap.put("ReportCirculationStatusChangeResponse", ReportCirculationStatusChangeResponseData.class);
        elementNamesToServiceClassMap.put("RequestItem", RequestItemInitiationData.class);
        elementNamesToServiceClassMap.put("RequestItemResponse", RequestItemResponseData.class);
        elementNamesToServiceClassMap.put("SendUserNotice", SendUserNoticeInitiationData.class);
        elementNamesToServiceClassMap.put("SendUserNoticeResponse", SendUserNoticeResponseData.class);
        elementNamesToServiceClassMap.put("UndoCheckOutItem", UndoCheckOutItemInitiationData.class);
        elementNamesToServiceClassMap.put("UndoCheckOutItemResponse", UndoCheckOutItemResponseData.class);
        elementNamesToServiceClassMap.put("UpdateAgency", UpdateAgencyInitiationData.class);
        elementNamesToServiceClassMap.put("UpdateAgencyResponse", UpdateAgencyResponseData.class);
        elementNamesToServiceClassMap.put("UpdateCirculationStatus", UpdateCirculationStatusInitiationData.class);
        elementNamesToServiceClassMap.put("UpdateCirculationStatusResponse", UpdateCirculationStatusResponseData.class);
        elementNamesToServiceClassMap.put("UpdateItem", UpdateItemInitiationData.class);
        elementNamesToServiceClassMap.put("UpdateItemResponse", UpdateItemResponseData.class);
        elementNamesToServiceClassMap.put("UpdateRequestItem", UpdateRequestItemInitiationData.class);
        elementNamesToServiceClassMap.put("UpdateRequestItemResponse", UpdateRequestItemResponseData.class);
        elementNamesToServiceClassMap.put("UpdateUser", UpdateUserInitiationData.class);
        elementNamesToServiceClassMap.put("UpdateUserResponse", UpdateUserResponseData.class);
        elementNamesToServiceClassMap.put("UserCreated", UserCreatedInitiationData.class);
        elementNamesToServiceClassMap.put("UserCreatedResponse", UserCreatedResponseData.class);
        elementNamesToServiceClassMap.put("UserFiscalTransactionCreated", UserFiscalTransactionCreatedInitiationData.class);
        elementNamesToServiceClassMap.put("UserFiscalTransactionCreatedResponse", UserFiscalTransactionCreatedResponseData.class);
        elementNamesToServiceClassMap.put("UserNoticeSent", UserNoticeSentInitiationData.class);
        elementNamesToServiceClassMap.put("UserNoticeSentResponse", UserNoticeSentResponseData.class);
        elementNamesToServiceClassMap.put("UserUpdated", UserUpdatedInitiationData.class);
        elementNamesToServiceClassMap.put("UserUpdatedResponse", UserUpdatedResponseData.class);
        elementNamesToServiceClassMap.put("ProblemResponse", ProblemResponseData.class);

    }

    /**
     * Maps element names (derived in this case from names of fields in service classes) to JAXB package class names.
     */
    protected static final Map<String, Class<?>> elementNamesToJAXBClassMap = new HashMap<>();

    static {

        // There are no element names (as yet) which don't match their JAXB class' simple name,
        // so this map can be empty.
    }

    /**
     * Construct an instance of the factory.
     */
    public ILSDIv1_0_bc_ContentMappingFactory() {
        super(SchemeValuePair.class, NCIPMessage.class.getPackage());
    }

    @Override
    protected Ext createExtension() {

        return new Ext();

    }

    @Override
    protected Object getObjectFactory() {

        return new ObjectFactory();

    }

    @Override
    protected Map<String, Class<?>> getElementNamesToServiceClassMap() {

        return elementNamesToServiceClassMap;

    }

    @Override
    protected Map<String, Class<?>> getElementNamesToJAXBClassMap() {

        return elementNamesToJAXBClassMap;

    }
}
