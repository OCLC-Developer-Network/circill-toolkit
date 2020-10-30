/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples.ncip;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.LookupItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupItemResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestId;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

/**
 * This class provides a simple NCIP Initiator that sends an item barcode to
 * an NCIP Responder at a target URL and displays the results.
 */
public final class SimpleLookupItemClient extends SimpleNCIPClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleLookupItemClient.class);

    /**
     * Construct an instance of this class and call {@link SimpleNCIPClient#execute(String[])}.
     * @param args command-line arguments
     * @throws IllegalAccessException -
     * @throws InvocationTargetException -
     * @throws InstantiationException -
     * @throws ToolkitException -
     * @throws NoSuchMethodException -
     * @throws ClassNotFoundException -
     */
    public static void main(final String[] args)
        throws IllegalAccessException, InvocationTargetException, InstantiationException, ToolkitException, NoSuchMethodException, ClassNotFoundException {
        final SimpleNCIPClient instance = new SimpleLookupItemClient();
        instance.execute(args);
    }

    @Override
    public NCIPInitiationData buildInitiationData(final String[] params) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {
        final LookupItemInitiationData lookupItemData;
        if (params.length >= 1) {
            if (params[0].matches("(?i)^-?r.*")) {
                final RequestId requestId = new RequestId();
                if (params[0].matches(".*=.*")) {
                    requestId.setRequestIdentifierValue(params[0].substring(params[0].indexOf('=') + 1));
                    lookupItemData = new LookupItemInitiationData();
                    lookupItemData.setRequestId(requestId);
                } else if (params.length > 1) {
                    requestId.setRequestIdentifierValue(params[1]);
                    lookupItemData = new LookupItemInitiationData();
                    lookupItemData.setRequestId(requestId);
                } else {
                    lookupItemData = null;
                }
            } else {
                lookupItemData = new LookupItemInitiationData();
                final ItemId itemId = new ItemId();
                if (params.length > 1) {
                    itemId.setItemIdentifierValue(params[1]);
                } else if (params[0].matches(".*=.*")) {
                    itemId.setItemIdentifierValue(params[0].substring(params[0].indexOf('=') + 1));
                } else {
                    itemId.setItemIdentifierValue(params[0]);
                }
                lookupItemData.setItemId(itemId);
            }
        } else {
            lookupItemData = null;
        }
        return lookupItemData;
    }

    @Override
    protected void reportSuccess(final NCIPResponseData responseData) {
        final LookupItemResponseData lookupItemResponseData = (LookupItemResponseData) responseData;
        LOG.info("Lookup Item succeeded: " + lookupItemResponseData);
        LOG.info("The item id is: " + lookupItemResponseData.getItemId().getItemIdentifierValue());
        if (lookupItemResponseData.getItemOptionalFields() != null) {
            if (lookupItemResponseData.getItemOptionalFields().getBibliographicDescription() != null
                && lookupItemResponseData.getItemOptionalFields().getBibliographicDescription().getTitle() != null) {
                LOG.info("The title is: " + lookupItemResponseData.getItemOptionalFields().getBibliographicDescription().getTitle());
            }
            if (lookupItemResponseData.getItemOptionalFields().getItemDescription() != null
                && lookupItemResponseData.getItemOptionalFields().getItemDescription().getCallNumber() != null) {
                LOG.info("The call number is: " + lookupItemResponseData.getItemOptionalFields().getItemDescription().getCallNumber());
            }
            if (lookupItemResponseData.getItemOptionalFields().getCirculationStatus() != null) {
                LOG.info("The circulation status is: " + (lookupItemResponseData.getItemOptionalFields().getCirculationStatus().getScheme() != null ? "scheme \""
                    + lookupItemResponseData.getItemOptionalFields().getCirculationStatus().getScheme() + "\"" : "") + ", value \"" + lookupItemResponseData
                    .getItemOptionalFields().getCirculationStatus().getValue() + "\"");
            }
        }
    }
}
