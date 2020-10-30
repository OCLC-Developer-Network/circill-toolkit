/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.common.ncip.NCIPProtocolHelper;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.LoanedItem;
import org.oclc.circill.toolkit.service.ncip.LoanedItemsCount;
import org.oclc.circill.toolkit.service.ncip.LookupUserResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestedItem;
import org.oclc.circill.toolkit.service.ncip.RequestedItemsCount;
import org.oclc.circill.toolkit.service.ncip.UserOptionalFields;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class TestLookupUser {

    private final NCIPProtocolHelper protocolHelper = new NCIPProtocolHelper();

    @Test
    public void testBasicLookup() throws ServiceException, ToolkitException, ParseException {

        DummyDatabase.load();

        final String userIdentifier = "abc";
        final NCIPResponseData responseData = (new SendLookupUser()).performService("dummy agency", userIdentifier);
        System.out.println("Response: " + responseData);

        final SimpleDateFormat dateFormatter = new SimpleDateFormat();

        if (responseData instanceof LookupUserResponseData) {

            final LookupUserResponseData lookupUserResponse = (LookupUserResponseData) responseData;

            System.out.println("User barcode: " + lookupUserResponse.getUserId().getUserIdentifierValue());
            if (lookupUserResponse.getLoanedItems() != null && lookupUserResponse.getLoanedItems().size() > 0) {

                for (final LoanedItem loanedItem : lookupUserResponse.getLoanedItems()) {

                    System.out.println("Loaned item id: " + loanedItem.getItemId().getItemIdentifierValue());
                    System.out.println("Loaned item title: " + loanedItem.getTitle());
                    System.out.println("Loaned item date due: " + (loanedItem.getDateDue() == null ? "" : dateFormatter.format(loanedItem.getDateDue().getTime())));
                    System.out
                        .println("Loaned item amount: " + protocolHelper.formatMonetaryAmount(loanedItem.getAmount().getMonetaryValue(), loanedItem.getAmount().getCurrencyCode()));
                    System.out.println("Loaned item indeterminate loan period flag: " + loanedItem.getIndeterminateLoanPeriodFlag());
                    System.out.println("Loaned item medium type: " + formatSVP(loanedItem.getMediumType()));
                    System.out.println("Loaned item reminder level: " + loanedItem.getReminderLevel());

                }

            } else {

                System.out.println("Loaned items: none.");
            }

            if (lookupUserResponse.getLoanedItemsCounts() != null && lookupUserResponse.getLoanedItemsCounts().size() > 0) {

                for (final LoanedItemsCount loanedItemsCount : lookupUserResponse.getLoanedItemsCounts()) {

                    System.out.println("Loaned item count circ status: " + formatSVP(loanedItemsCount.getCirculationStatus()));
                    System.out.println("Loaned item count use restriction: " + formatSVP(loanedItemsCount.getItemUseRestrictionType()));
                    System.out.println("Loaned item count value: " + loanedItemsCount.getLoanedItemCountValue());

                }

            } else {

                System.out.println("Loaned item counts: none.");
            }

            if (lookupUserResponse.getRequestedItems() != null && lookupUserResponse.getRequestedItems().size() > 0) {

                for (final RequestedItem requestedItem : lookupUserResponse.getRequestedItems()) {

                    System.out.println("Request id: " + requestedItem.getRequestId().getRequestIdentifierValue());
                    System.out.println("Requested item id: " + (requestedItem.getItemId() == null ? "" : requestedItem.getItemId().getItemIdentifierValue()));
                    System.out.println("Request status type: " + formatSVP(requestedItem.getRequestStatusType()));
                    System.out.println("Request type: " + formatSVP(requestedItem.getRequestType()));
                    System.out.println("Requested item title: " + requestedItem.getTitle());
                    System.out.println("Requested item medium type: " + formatSVP(requestedItem.getMediumType()));
                    System.out.println("Date placed: " + (requestedItem.getDatePlaced() == null ? "" : dateFormatter.format(requestedItem.getDatePlaced().getTime())));
                    System.out.println("Request queue position: " + requestedItem.getHoldQueuePosition());
                    System.out.println("Pickup date: " + (requestedItem.getPickupDate() == null ? "" : dateFormatter.format(requestedItem.getPickupDate().getTime())));
                    System.out.println("Pickup location: " + formatSVP(requestedItem.getPickupLocation()));
                    System.out
                        .println("Pickup expiry date: " + (requestedItem.getPickupExpiryDate() == null ? "" : dateFormatter.format(requestedItem.getPickupExpiryDate().getTime())));
                    System.out.println("Reminder level: " + requestedItem.getReminderLevel());

                }

            } else {

                System.out.println("Requested items: none.");
            }

            if (lookupUserResponse.getRequestedItemsCounts() != null && lookupUserResponse.getRequestedItemsCounts().size() > 0) {

                for (final RequestedItemsCount requestedItemsCount : lookupUserResponse.getRequestedItemsCounts()) {

                    System.out.println("Requested item count circ status: " + formatSVP(requestedItemsCount.getCirculationStatus()));
                    System.out.println("Requested item count use restriction: " + formatSVP(requestedItemsCount.getItemUseRestrictionType()));
                    System.out.println("Requested item count request type: " + formatSVP(requestedItemsCount.getRequestType()));
                    System.out.println("Requested item count value: " + requestedItemsCount.getRequestedItemCountValue());

                }

            } else {

                System.out.println("Requested item counts: none.");
            }

            System.out.println("User fiscal accounts: " + lookupUserResponse.getUserFiscalAccounts());

            if (lookupUserResponse.getUserOptionalFields() != null) {

                final UserOptionalFields userFields = lookupUserResponse.getUserOptionalFields();
                System.out.println("Name: " + userFields.getNameInformation());
                System.out.println("Block or traps: " + userFields.getBlockOrTraps());
                System.out.println("Date of birth: " + (userFields.getDateOfBirth() == null ? "" : dateFormatter.format(userFields.getDateOfBirth().getTime())));
                System.out.println("Previous user ids: " + userFields.getPreviousUserIds());
                System.out.println("User Address: " + userFields.getUserAddressInformations());
                System.out.println("User Ids: " + userFields.getUserIds());
                System.out.println("Languages: " + userFields.getUserLanguages());
                System.out.println("Privileges: " + userFields.getUserPrivileges());

            } else {

                System.out.println("User optional fields: none.");
            }

            System.out.println("Problems: " + lookupUserResponse.getProblems());

        }

    }

    /**
     * Return a formatted string representing the {@link }SchemeValuePair} object.
     * @param svp the SchemeValuePair object
     * @return the formatted string
     */
    public static String formatSVP(final SchemeValuePair svp) {

        return (svp == null ? "" : (svp.getScheme() == null ? "" : svp.getScheme() + ", ") + svp.getValue());

    }

}
