/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BibliographicItemId;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Bibliographic information about the requested item.
 */
public class BibliographicInfo {
    protected String author;
    protected String authorOfComponent;
    protected List<BibliographicItemId> bibliographicItemIds = new ArrayList<>();
    protected List<BibliographicRecordId> bibliographicRecordIds = new ArrayList<>();
    protected String edition;
    protected String estimatedNoPages;
    protected String informationSource;
    protected String issue;
    protected String pagesRequested;
    protected String seriesTitle;
    protected String sponsor;
    protected String supplierUniqueRecordId;
    protected String subtitle;
    protected String title;
    protected String titleOfComponent;
    protected String volume;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getAuthorOfComponent() {
        return authorOfComponent;
    }

    public void setAuthorOfComponent(final String authorOfComponent) {
        this.authorOfComponent = authorOfComponent;
    }

    public List<BibliographicItemId> getBibliographicItemIds() {
        return bibliographicItemIds;
    }

    public BibliographicItemId getBibliographicItemId() {
        return bibliographicItemIds != null ? (bibliographicItemIds.size() > 0 ? bibliographicItemIds.get(bibliographicItemIds.size() - 1) : null) : null;
    }

    public BibliographicItemId getBibliographicItemId(final int index) {
        return bibliographicItemIds != null ? (bibliographicItemIds.size() > 0 ? bibliographicItemIds.get(index) : null) : null;
    }

    public void setBibliographicItemIds(final List<BibliographicItemId> bibliographicItemIds) {
        this.bibliographicItemIds = bibliographicItemIds;
    }

    public void setBibliographicItemId(final int index, final BibliographicItemId bibliographicItemId) {
        bibliographicItemIds.set(index, bibliographicItemId);
    }

    public void setBibliographicItemId(final BibliographicItemId bibliographicItemId) {
        if (this.bibliographicItemIds != null) {
            this.bibliographicItemIds.clear();
        }
        if (bibliographicItemId != null) {
            if (this.bibliographicItemIds == null) {
                this.bibliographicItemIds = new ArrayList<>();
            }
            this.bibliographicItemIds.add(bibliographicItemId);
        } else {
            this.bibliographicItemIds = null;
        }
    }

    public List<BibliographicRecordId> getBibliographicRecordIds() {
        return bibliographicRecordIds;
    }

    public BibliographicRecordId getBibliographicRecordId() {
        return bibliographicRecordIds != null ? (bibliographicRecordIds.size() > 0 ? bibliographicRecordIds.get(bibliographicRecordIds.size() - 1) : null) : null;
    }

    public BibliographicRecordId getBibliographicRecordId(final int index) {
        return bibliographicRecordIds != null ? (bibliographicRecordIds.size() > 0 ? bibliographicRecordIds.get(index) : null) : null;
    }

    public void setBibliographicRecordIds(final List<BibliographicRecordId> bibliographicRecordIds) {
        this.bibliographicRecordIds = bibliographicRecordIds;
    }

    public void setBibliographicRecordId(final int index, final BibliographicRecordId bibliographicRecordId) {
        bibliographicRecordIds.set(index, bibliographicRecordId);
    }

    public void setBibliographicRecordId(final BibliographicRecordId bibliographicRecordId) {
        if (this.bibliographicRecordIds != null) {
            this.bibliographicRecordIds.clear();
        }
        if (bibliographicRecordId != null) {
            if (this.bibliographicRecordIds == null) {
                this.bibliographicRecordIds = new ArrayList<>();
            }
            this.bibliographicRecordIds.add(bibliographicRecordId);
        } else {
            this.bibliographicRecordIds = null;
        }
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(final String edition) {
        this.edition = edition;
    }

    public String getEstimatedNoPages() {
        return estimatedNoPages;
    }

    public void setEstimatedNoPages(final String estimatedNoPages) {
        this.estimatedNoPages = estimatedNoPages;
    }

    public String getInformationSource() {
        return informationSource;
    }

    public void setInformationSource(final String informationSource) {
        this.informationSource = informationSource;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(final String issue) {
        this.issue = issue;
    }

    public String getPagesRequested() {
        return pagesRequested;
    }

    public void setPagesRequested(final String pagesRequested) {
        this.pagesRequested = pagesRequested;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(final String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSupplierUniqueRecordId() {
        return supplierUniqueRecordId;
    }

    public void setSupplierUniqueRecordId(final String supplierUniqueRecordId) {
        this.supplierUniqueRecordId = supplierUniqueRecordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getTitleOfComponent() {
        return titleOfComponent;
    }

    public void setTitleOfComponent(final String titleOfComponent) {
        this.titleOfComponent = titleOfComponent;
    }

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(final String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(final String subtitle) {
        this.subtitle = subtitle;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(final String volume) {
        this.volume = volume;
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
        final BibliographicInfo rhs = (BibliographicInfo) obj;
        final boolean result = new EqualsBuilder().append(author, rhs.author).append(authorOfComponent, rhs.authorOfComponent)
            .append(bibliographicItemIds, rhs.bibliographicItemIds).append(bibliographicRecordIds, rhs.bibliographicRecordIds).append(edition, rhs.edition)
            .append(estimatedNoPages, rhs.estimatedNoPages).append(informationSource, rhs.informationSource).append(issue, rhs.issue).append(pagesRequested, rhs.pagesRequested)
            .append(seriesTitle, rhs.seriesTitle).append(sponsor, rhs.sponsor).append(subtitle, rhs.subtitle).append(supplierUniqueRecordId, rhs.supplierUniqueRecordId)
            .append(title, rhs.title).append(titleOfComponent, rhs.titleOfComponent).append(volume, rhs.volume).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1564973119, 1130420885).append(author).append(authorOfComponent).append(bibliographicItemIds).append(bibliographicRecordIds)
            .append(edition).append(estimatedNoPages).append(informationSource).append(issue).append(pagesRequested).append(seriesTitle).append(sponsor).append(subtitle)
            .append(supplierUniqueRecordId).append(title).append(titleOfComponent).append(volume).toHashCode();
        return result;
    }
}
