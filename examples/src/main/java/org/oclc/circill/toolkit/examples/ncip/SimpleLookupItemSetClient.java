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
import org.oclc.circill.toolkit.service.ncip.BibInformation;
import org.oclc.circill.toolkit.service.ncip.BibliographicId;
import org.oclc.circill.toolkit.service.ncip.BibliographicRecordId;
import org.oclc.circill.toolkit.service.ncip.HoldingsSet;
import org.oclc.circill.toolkit.service.ncip.ItemInformation;
import org.oclc.circill.toolkit.service.ncip.LookupItemSetInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupItemSetResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * This class provides a simple NCIP Initiator that sends an item barcode to
 * an NCIP Responder at a target URL and displays the results.
 */
public final class SimpleLookupItemSetClient extends SimpleNCIPClient {
    /** The logger. */
    private static final Logger LOG = Logger.getLogger(SimpleLookupItemSetClient.class);

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
        final SimpleNCIPClient instance = new SimpleLookupItemSetClient();
        instance.execute(args);
    }

    @Override
    public NCIPInitiationData buildInitiationData(final String[] params) throws ConfigurationException, ToolkitInternalException, ServiceException, ValidationException {
        final LookupItemSetInitiationData lookupItemSetData = new LookupItemSetInitiationData();
        final BibliographicId bibId = new BibliographicId();
        final BibliographicRecordId bibRecordId = new BibliographicRecordId();
        bibRecordId.setBibliographicRecordIdentifier(params[0]);
        final AgencyId agencyId = new AgencyId(null, params[1]);
        bibRecordId.setAgencyId(agencyId);
        bibId.setBibliographicRecordId(bibRecordId);
        final List<BibliographicId> bibIds = new ArrayList<>();
        bibIds.add(bibId);
        lookupItemSetData.setBibliographicIds(bibIds);
        return lookupItemSetData;
    }

    @Override
    protected void reportSuccess(final NCIPResponseData responseData) {
        final LookupItemSetResponseData lookupItemSetResponseData = (LookupItemSetResponseData) responseData;
        LOG.info("Lookup Item Set succeeded: " + lookupItemSetResponseData);
        if (lookupItemSetResponseData.getBibInformations() != null && lookupItemSetResponseData.getBibInformations().size() > 0) {
            for (final BibInformation bibInformation : lookupItemSetResponseData.getBibInformations()) {
                if (bibInformation.getHoldingsSets() != null && bibInformation.getHoldingsSets().size() > 0) {
                    if (bibInformation.getBibliographicId() != null) {
                        LOG.info("BibliographicId: " + bibInformation.getBibliographicId());
                    }
                    for (final HoldingsSet holdingsSet : bibInformation.getHoldingsSets()) {
                        if (holdingsSet.getHoldingsSetId() != null) {
                            LOG.info("HoldingsSetId: " + holdingsSet.getHoldingsSetId());
                        }
                        if (holdingsSet.getLocation() != null) {
                            LOG.info("Location: " + holdingsSet.getLocation());
                        }
                        if (holdingsSet.getSummaryHoldingsInformation() != null) {
                            LOG.info("HoldingsInformation: " + holdingsSet.getSummaryHoldingsInformation());
                        }
                        if (holdingsSet.getItemInformations() != null && holdingsSet.getItemInformations().size() > 0) {
                            for (final ItemInformation itemInformation : holdingsSet.getItemInformations()) {
                                LOG.info("ItemInformation: " + itemInformation);
                            }
                        }
                    }
                }
            }
        }
        if (lookupItemSetResponseData.getNextItemToken() != null) {
            LOG.info("The next token is '" + lookupItemSetResponseData.getNextItemToken() + "'.");
        }
    }
}
