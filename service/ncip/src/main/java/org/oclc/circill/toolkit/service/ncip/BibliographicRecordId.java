/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A bibliographic record identifier. Examples are Australian National Bibliography Number,
 * OCLC number, or (if the Agency Id attribute is provided instead of the Bibliographic
 * Record Identifier Code), the local system control number.
 */
public class BibliographicRecordId {

    protected AgencyId agencyId;

    protected String bibliographicRecordIdentifier;

    protected BibliographicRecordIdentifierCode bibliographicRecordIdentifierCode;

    public AgencyId getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(final AgencyId agencyId) {
        this.agencyId = agencyId;
    }

    public String getBibliographicRecordIdentifier() {
        return bibliographicRecordIdentifier;
    }

    public void setBibliographicRecordIdentifier(final String bibliographicRecordIdentifier) {
        this.bibliographicRecordIdentifier = bibliographicRecordIdentifier;
    }

    public BibliographicRecordIdentifierCode getBibliographicRecordIdentifierCode() {
        return bibliographicRecordIdentifierCode;
    }

    public void setBibliographicRecordIdentifierCode(final BibliographicRecordIdentifierCode bibliographicRecordIdentifierCode) {
        this.bibliographicRecordIdentifierCode = bibliographicRecordIdentifierCode;
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
        final BibliographicRecordId rhs = (BibliographicRecordId) obj;
        return new EqualsBuilder()
            .append(agencyId, rhs.agencyId)
            .append(bibliographicRecordIdentifier, rhs.bibliographicRecordIdentifier)
            .append(bibliographicRecordIdentifierCode, rhs.bibliographicRecordIdentifierCode)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(28862543, 406489413)
            .append(agencyId)
            .append(bibliographicRecordIdentifier)
            .append(bibliographicRecordIdentifierCode)
            .toHashCode();
        return result;
    }

}
