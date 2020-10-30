/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.common.base.MessageHandler;
import org.oclc.circill.toolkit.common.base.MessageHandlerAware;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.ncip.ElementType;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.LoanedItem;
import org.oclc.circill.toolkit.service.ncip.LookupUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupUserResponseData;
import org.oclc.circill.toolkit.service.ncip.Problem;
import org.oclc.circill.toolkit.service.ncip.ProblemType;
import org.oclc.circill.toolkit.service.ncip.RenewAllItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RenewAllItemResponseData;
import org.oclc.circill.toolkit.service.ncip.RenewAllItemService;
import org.oclc.circill.toolkit.service.ncip.RenewInformation;
import org.oclc.circill.toolkit.service.ncip.RenewItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RenewItemResponseData;
import org.oclc.circill.toolkit.service.ncip.ResponseElementControl;
import org.oclc.circill.toolkit.service.ncip.SortField;
import org.oclc.circill.toolkit.service.ncip.Version1GeneralProcessingError;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the RenewAllItem service for the Dummy back-end connector. Basically this just
 * calls the DummyRemoteServiceManager to get hard-coded data (e.g. due date).
 * <p>
 * Note: If you're looking for a model of how to code your own ILS's NCIPService classes, do not
 * use this class as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyRenewAllItemService extends BaseDummyService<RenewAllItemInitiationData, RenewAllItemResponseData> implements RenewAllItemService {

    /**
     * Handles a NCIP RenewAllItem service by returning hard-coded data.
     *
     * @param initData       the RenewAllItemInitiationData
     * @param serviceManager provides access to remote services
     * @return RenewAllItemResponseData
     */
    @Override
    public RenewAllItemResponseData performService(final RenewAllItemInitiationData initData, final ServiceContext serviceContext, final RemoteServiceManager serviceManager) {

        final RenewAllItemResponseData responseData = new RenewAllItemResponseData();

        try {

            if (serviceContext instanceof MessageHandlerAware) {
                final MessageHandler messageHandler = ((MessageHandlerAware) serviceContext).getMessageHandler();
                if (messageHandler != null) {
                    final LookupUserInitiationData lookupUserInitiationData = new LookupUserInitiationData();
                    lookupUserInitiationData.setInitiationHeader(initData.getInitiationHeader());
                    lookupUserInitiationData.setUserId(initData.getUserId());
                    lookupUserInitiationData.setRelyingPartyId(initData.getRelyingPartyId());
                    lookupUserInitiationData.setLoanedItemsDesired(true);
                    final List<ResponseElementControl> responseElementControlList = new ArrayList<>();
                    final ResponseElementControl loanedItemsResponseElementControl = new ResponseElementControl();
                    loanedItemsResponseElementControl.setSortField(new SortField("http://worldcat.org/ncip/schemes/v2/extensions/loaneditemelementtype.scm", "Item Id"));
                    loanedItemsResponseElementControl.setElementType(new ElementType("http://worldcat.org/ncip/schemes/v2/extensions/elementtype.scm", "Loaned Item"));
                    loanedItemsResponseElementControl.setStartElement(BigDecimal.ONE);
                    responseElementControlList.add(loanedItemsResponseElementControl);
                    lookupUserInitiationData.setResponseElementControls(responseElementControlList);

                    final LookupUserResponseData lookupUserResponseData = (LookupUserResponseData) messageHandler.performService(lookupUserInitiationData, serviceContext);
                    if (lookupUserResponseData.getProblems() == null || lookupUserResponseData.getProblems().isEmpty()) {
                        if (!lookupUserResponseData.getLoanedItems().isEmpty()) {

                            responseData.setUserId(initData.getUserId());

                            for (final LoanedItem loanedItem : lookupUserResponseData.getLoanedItems()) {

                                final ItemId loanedItemId = loanedItem.getItemId();
                                final RenewItemInitiationData renewItemInitiationData = new RenewItemInitiationData();
                                renewItemInitiationData.setInitiationHeader(initData.getInitiationHeader());
                                renewItemInitiationData.setUserId(initData.getUserId());
                                renewItemInitiationData.setRelyingPartyId(initData.getRelyingPartyId());
                                renewItemInitiationData.setItemId(loanedItemId);
                                final RenewItemResponseData renewItemResponseData = (RenewItemResponseData) messageHandler.performService(renewItemInitiationData, serviceContext);
                                final RenewInformation renewInformation = new RenewInformation();
                                renewInformation.setItemId(loanedItemId);
                                if (renewItemResponseData.getProblems() != null && !renewItemResponseData.getProblems().isEmpty()) {
                                    renewInformation.setProblems(renewItemResponseData.getProblems());
                                    renewInformation.setRequiredFeeAmount(renewItemResponseData.getRequiredFeeAmount());
                                    renewInformation.setRequiredItemUseRestrictionTypes(renewItemResponseData.getRequiredItemUseRestrictionTypes());
                                } else if (renewItemResponseData.getPending() != null) {
                                    renewInformation.setPending(renewItemResponseData.getPending());
                                } else {
                                    renewInformation.setDateDue(renewItemResponseData.getDateDue());
                                    renewInformation.setDateForReturn(renewItemResponseData.getDateForReturn());
                                    renewInformation.setFiscalTransactionInformation(renewItemResponseData.getFiscalTransactionInformation());
                                    renewInformation.setItemOptionalFields(renewItemResponseData.getItemOptionalFields());
                                    renewInformation.setRenewalCount(renewItemResponseData.getRenewalCount());
                                }
                                responseData.getRenewInformations().add(renewInformation);
                            }

                        } else {
                            final Problem noItemsCheckedOutProblem = new Problem();
                            noItemsCheckedOutProblem.setProblemType(
                                new ProblemType("http://worldcat.org/ncip/schemes/v2/processingerrortype/wclrenewallitemprocessingerror.scm", "No Items Checked Out"));
                            noItemsCheckedOutProblem.setProblemElement("//UserId");
                            noItemsCheckedOutProblem.setProblemDetail("This user has no items checked out.");
                            noItemsCheckedOutProblem.setProblemValue(initData.getUserId().getUserIdentifierValue());
                            final List<Problem> problems = new ArrayList<>();
                            problems.add(noItemsCheckedOutProblem);
                            responseData.setProblems(problems);
                        }
                    } else {
                        responseData.setProblems(lookupUserResponseData.getProblems());
                    }
                } else {
                    final Problem misConfiguredProblem = new Problem();
                    misConfiguredProblem.setProblemType(Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE);
                    misConfiguredProblem.setProblemDetail("This responder is not configured correctly. " + "The ServiceContext is not MessageHandlerAware.");
                    final List<Problem> problems = new ArrayList<>();
                    problems.add(misConfiguredProblem);
                    responseData.setProblems(problems);
                }
            }
        } catch (Exception e) {
            final List<Problem> problems = protocolHelper.generateProblems(Version1GeneralProcessingError.TEMPORARY_PROCESSING_FAILURE, null, null, null, e);
            responseData.setProblems(problems);
        }

        return responseData;
    }

}
