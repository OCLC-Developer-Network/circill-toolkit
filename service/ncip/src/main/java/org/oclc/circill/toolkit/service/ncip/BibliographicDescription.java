/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.BibliographicItemId;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * BibliographicDescription describes a bibliographic entity.
 */
public class BibliographicDescription {
    protected String author;

    protected String authorOfComponent;

    protected List<BibliographicItemId> bibliographicItemIds = new ArrayList<>();

    protected List<BibliographicRecordId> bibliographicRecordIds = new ArrayList<>();

    protected ComponentId componentId;

    protected String edition;

    protected String pagination;

    protected String placeOfPublication;

    protected String publicationDate;

    protected String publicationDateOfComponent;

    protected String publisher;

    protected String seriesTitleNumber;

    protected String title;

    protected String uniformTitle;

    protected String titleOfComponent;

    protected BibliographicLevel bibliographicLevel;

    protected String sponsoringBody;

    protected ElectronicDataFormatType electronicDataFormatType;

    protected Language language;

    protected MediumType mediumType;

    protected CitationSource citationSource;

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

    /**
     * Set the list of {@link BibliographicItemId}s to this bibliographicItemId.
     *
     * @param bibliographicItemId the {@link BibliographicItemId}
     */
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

    /**
     * Set the list of {@link BibliographicRecordId}s to this bibliographicRecordId.
     *
     * @param bibliographicRecordId the {@link BibliographicRecordId}
     */
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

    public void setBibliographicRecordId(final int index, final BibliographicRecordId bibliographicRecordId) {
        bibliographicRecordIds.set(index, bibliographicRecordId);
    }

    public ComponentId getComponentId() {
        return componentId;
    }

    public void setComponentId(final ComponentId componentId) {
        this.componentId = componentId;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(final String edition) {
        this.edition = edition;
    }

    public String getPagination() {
        return pagination;
    }

    public void setPagination(final String pagination) {
        this.pagination = pagination;
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public void setPlaceOfPublication(final String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(final String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublicationDateOfComponent() {
        return publicationDateOfComponent;
    }

    public void setPublicationDateOfComponent(final String publicationDateOfComponent) {
        this.publicationDateOfComponent = publicationDateOfComponent;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    public String getSeriesTitleNumber() {
        return seriesTitleNumber;
    }

    public void setSeriesTitleNumber(final String seriesTitleNumber) {
        this.seriesTitleNumber = seriesTitleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getUniformTitle() {
        return uniformTitle;
    }

    public void setUniformTitle(final String uniformTitle) {
        this.uniformTitle = uniformTitle;
    }

    public String getTitleOfComponent() {
        return titleOfComponent;
    }

    public void setTitleOfComponent(final String titleOfComponent) {
        this.titleOfComponent = titleOfComponent;
    }

    public BibliographicLevel getBibliographicLevel() {
        return bibliographicLevel;
    }

    public void setBibliographicLevel(final BibliographicLevel bibliographicLevel) {
        this.bibliographicLevel = bibliographicLevel;
    }

    public String getSponsoringBody() {
        return sponsoringBody;
    }

    public void setSponsoringBody(final String sponsoringBody) {
        this.sponsoringBody = sponsoringBody;
    }

    public ElectronicDataFormatType getElectronicDataFormatType() {
        return electronicDataFormatType;
    }

    public void setElectronicDataFormatType(final ElectronicDataFormatType electronicDataFormatType) {
        this.electronicDataFormatType = electronicDataFormatType;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public MediumType getMediumType() {
        return mediumType;
    }

    public void setMediumType(final MediumType mediumType) {
        this.mediumType = mediumType;
    }

    public CitationSource getCitationSource() {
        return citationSource;
    }

    public void setCitationSource(final CitationSource citationSource) {
        this.citationSource = citationSource;
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
        final BibliographicDescription rhs = (BibliographicDescription) obj;
        final boolean result = new EqualsBuilder().append(author, rhs.author).append(authorOfComponent, rhs.authorOfComponent)
            .append(bibliographicItemIds, rhs.bibliographicItemIds).append(bibliographicRecordIds, rhs.bibliographicRecordIds).append(componentId, rhs.componentId)
            .append(edition, rhs.edition).append(pagination, rhs.pagination).append(placeOfPublication, rhs.placeOfPublication).append(publicationDate, rhs.publicationDate)
            .append(publicationDateOfComponent, rhs.publicationDateOfComponent).append(publisher, rhs.publisher).append(seriesTitleNumber, rhs.seriesTitleNumber)
            .append(title, rhs.title).append(uniformTitle, rhs.uniformTitle).append(titleOfComponent, rhs.titleOfComponent).append(bibliographicLevel, rhs.bibliographicLevel)
            .append(sponsoringBody, rhs.sponsoringBody).append(electronicDataFormatType, rhs.electronicDataFormatType).append(language, rhs.language)
            .append(mediumType, rhs.mediumType).append(citationSource, rhs.citationSource).isEquals();
        return result;
    }

    public int hashCode() {
        final int result = new HashCodeBuilder(1722852809, 851084505).append(author).append(authorOfComponent).append(bibliographicItemIds).append(bibliographicRecordIds)
            .append(componentId).append(edition).append(pagination).append(placeOfPublication).append(publicationDate).append(publicationDateOfComponent).append(publisher)
            .append(seriesTitleNumber).append(title).append(uniformTitle).append(titleOfComponent).append(bibliographicLevel).append(sponsoringBody)
            .append(electronicDataFormatType).append(language).append(mediumType).append(citationSource).toHashCode();
        return result;
    }
}
