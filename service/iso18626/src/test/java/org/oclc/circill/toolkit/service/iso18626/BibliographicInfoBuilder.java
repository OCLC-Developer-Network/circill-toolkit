/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BibliographicItemId;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ReturnOfThis")
public final class BibliographicInfoBuilder {

    private String author;
    private String authorOfComponent;
    private List<BibliographicItemId> bibliographicItemIds = new ArrayList<>();
    private List<BibliographicRecordId> bibliographicRecordIds = new ArrayList<>();
    private String edition;
    private String estimatedNoPages;
    private String informationSource;
    private String issue;
    private String pagesRequested;
    private String seriesTitle;
    private String sponsor;
    private String supplierUniqueRecordId;
    private String subtitle;
    private String title;
    private String titleOfComponent;
    private String volume;

    /**
     * This utility class does not allow instances.
     */
    private BibliographicInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link BibliographicInfo}
     */
    public static BibliographicInfoBuilder aBibliographicInfo() {
        final BibliographicInfoBuilder builder = new BibliographicInfoBuilder();
        return builder;
    }

    public BibliographicInfoBuilder withAuthor(final String author) {
        this.author = author;
        return this;
    }

    public BibliographicInfoBuilder withAuthorOfComponent(final String authorOfComponent) {
        this.authorOfComponent = authorOfComponent;
        return this;
    }

    public BibliographicInfoBuilder withBibliographicItemIds(final List<BibliographicItemId> bibliographicItemIds) {
        this.bibliographicItemIds = bibliographicItemIds;
        return this;
    }

    public BibliographicInfoBuilder withBibliographicRecordIds(final List<BibliographicRecordId> bibliographicRecordIds) {
        this.bibliographicRecordIds = bibliographicRecordIds;
        return this;
    }

    public BibliographicInfoBuilder withEdition(final String edition) {
        this.edition = edition;
        return this;
    }

    public BibliographicInfoBuilder withEstimatedNoPages(final String estimatedNoPages) {
        this.estimatedNoPages = estimatedNoPages;
        return this;
    }

    public BibliographicInfoBuilder withInformationSource(final String informationSource) {
        this.informationSource = informationSource;
        return this;
    }

    public BibliographicInfoBuilder withIssue(final String issue) {
        this.issue = issue;
        return this;
    }

    public BibliographicInfoBuilder withPagesRequested(final String pagesRequested) {
        this.pagesRequested = pagesRequested;
        return this;
    }

    public BibliographicInfoBuilder withSeriesTitle(final String seriesTitle) {
        this.seriesTitle = seriesTitle;
        return this;
    }

    public BibliographicInfoBuilder withSponsor(final String sponsor) {
        this.sponsor = sponsor;
        return this;
    }

    public BibliographicInfoBuilder withSupplierUniqueRecordId(final String supplierUniqueRecordId) {
        this.supplierUniqueRecordId = supplierUniqueRecordId;
        return this;
    }

    public BibliographicInfoBuilder withSubtitle(final String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public BibliographicInfoBuilder withTitle(final String title) {
        this.title = title;
        return this;
    }

    public BibliographicInfoBuilder withTitleOfComponent(final String titleOfComponent) {
        this.titleOfComponent = titleOfComponent;
        return this;
    }

    public BibliographicInfoBuilder withVolume(final String volume) {
        this.volume = volume;
        return this;
    }

    public BibliographicInfo build() {
        final BibliographicInfo bibliographicInfo = new BibliographicInfo();
        bibliographicInfo.setAuthor(author);
        bibliographicInfo.setAuthorOfComponent(authorOfComponent);
        bibliographicInfo.setBibliographicItemIds(bibliographicItemIds);
        bibliographicInfo.setBibliographicRecordIds(bibliographicRecordIds);
        bibliographicInfo.setEdition(edition);
        bibliographicInfo.setEstimatedNoPages(estimatedNoPages);
        bibliographicInfo.setInformationSource(informationSource);
        bibliographicInfo.setIssue(issue);
        bibliographicInfo.setPagesRequested(pagesRequested);
        bibliographicInfo.setSeriesTitle(seriesTitle);
        bibliographicInfo.setSponsor(sponsor);
        bibliographicInfo.setSupplierUniqueRecordId(supplierUniqueRecordId);
        bibliographicInfo.setSubtitle(subtitle);
        bibliographicInfo.setTitle(title);
        bibliographicInfo.setTitleOfComponent(titleOfComponent);
        bibliographicInfo.setVolume(volume);
        return bibliographicInfo;
    }

}

