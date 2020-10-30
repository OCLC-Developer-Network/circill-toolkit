/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.Version1CurrencyCode;
import org.oclc.circill.toolkit.service.ncip.BibliographicDescription;
import org.oclc.circill.toolkit.service.ncip.BibliographicRecordId;
import org.oclc.circill.toolkit.service.ncip.CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.Language;
import org.oclc.circill.toolkit.service.ncip.MediumType;
import org.oclc.circill.toolkit.service.ncip.Version1BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.ncip.Version1CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.Version1Language;
import org.oclc.circill.toolkit.service.ncip.Version1MediumType;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.util.ArrayList;
import java.util.List;

/**
 * ServiceManager is responsible for locating the correct back-end service; for
 * the Dummy back-end there are no services; this class always returns the same hard-coded values.
 * Note: If you're looking for a model of how to code your own ILS's RemoteServiceManager, do not
 * use this class's methods as an example. See the NCIP toolkit Connector developer's documentation for guidance.
 */
public class DummyRemoteServiceManager implements RemoteServiceManager {

    protected String libraryName;
    protected static final CurrencyCode TEST_LOCAL_CURRENCY_CODE = Version1CurrencyCode.CUC; // Purposely choosing a code that won't be expected in most locales.
    protected AgencyId agencyId;

    /**
     * Construct a DummyRemoteServiceManager.
     * @throws ToolkitException -
     */
    public DummyRemoteServiceManager() throws ToolkitException {
        // Do nothing
    }

    /**
     * Get the library's name.
     *
     * @return the library name
     */
    public String getLibraryName() {
        return libraryName;
    }

    public CurrencyCode getLocalCurrencyCode() {
        return TEST_LOCAL_CURRENCY_CODE;
    }

    public AgencyId getAgencyId() {

        return agencyId;

    }

    /**
     * Translate the circulation status from values internal to the Dummy system to NCIP Version1CirculationStatus values.
     *
     * @param circStatus the Dummy system's internal circulation status
     * @return a value from Version1CirculationStatus
     */
    public static CirculationStatus translateCircStatus(final DummyDatabase.CircStatus circStatus) {

        final CirculationStatus ncipCircStatus;

        switch (circStatus) {

        case ON_ORDER:
            ncipCircStatus = Version1CirculationStatus.ON_ORDER;
            break;

        case ON_SHELF:
            ncipCircStatus = Version1CirculationStatus.AVAILABLE_ON_SHELF;
            break;

        case CHECKED_OUT:
            ncipCircStatus = Version1CirculationStatus.ON_LOAN;
            break;

        case IN_TRANSIT:
            ncipCircStatus = Version1CirculationStatus.IN_TRANSIT_BETWEEN_LIBRARY_LOCATIONS;
            break;

        default:
            ncipCircStatus = Version1CirculationStatus.CIRCULATION_STATUS_UNDEFINED;

        }

        return ncipCircStatus;

    }

    /**
     * Translate the media type from values internal to the Dummy system to NCIP Version1CirculationStatus values.
     *
     * @param mediaType the Dummy system's internal media type
     * @return a value from Version1MediumType
     */
    public static MediumType translateMediaType(final DummyDatabase.MediaTypeEnum mediaType) {

        final MediumType ncipMediumType;

        switch (mediaType) {

        case BOOK:
            ncipMediumType = Version1MediumType.BOOK;
            break;

        case AUDIO_TAPE:
            ncipMediumType = Version1MediumType.AUDIO_TAPE;
            break;

        case CD:
            ncipMediumType = Version1MediumType.CD_ROM;
            break;

        case DVD:
            ncipMediumType = Version1MediumType.CD_ROM;
            break;

        case MAGAZINE:
            ncipMediumType = Version1MediumType.MAGAZINE;
            break;

        default:
            ncipMediumType = Version1MediumType.BOOK;
            break;

        }

        return ncipMediumType;

    }

    public BibliographicDescription getBibliographicDescription(final DummyDatabase.BibInfo bibInfo) {

        final BibliographicDescription bibDesc = new BibliographicDescription();

        bibDesc.setTitle(bibInfo.title);
        bibDesc.setAuthor(bibInfo.author);
        bibDesc.setPublisher(bibInfo.publisher);
        bibDesc.setEdition(bibInfo.edition);
        bibDesc.setPublicationDate(bibInfo.pubDate);
        bibDesc.setMediumType(translateMediaType(bibInfo.mediaType));

        final BibliographicRecordId localBibliographicRecordId = new BibliographicRecordId();
        localBibliographicRecordId.setBibliographicRecordIdentifier(bibInfo.bibNo);
        localBibliographicRecordId.setAgencyId(agencyId);
        final List<BibliographicRecordId> bibRecordIds = new ArrayList<>();
        bibRecordIds.add(localBibliographicRecordId);

        final BibliographicRecordId oclcBibliographicRecordId = new BibliographicRecordId();
        oclcBibliographicRecordId.setBibliographicRecordIdentifier(bibInfo.oclcNo);
        oclcBibliographicRecordId.setBibliographicRecordIdentifierCode(Version1BibliographicRecordIdentifierCode.OCLC);
        bibRecordIds.add(oclcBibliographicRecordId);

        bibDesc.setBibliographicRecordIds(bibRecordIds);

        final Language language = new Language(Version1Language.VERSION_1_LANGUAGE, bibInfo.language);
        bibDesc.setLanguage(language);

        return bibDesc;

    }

}
