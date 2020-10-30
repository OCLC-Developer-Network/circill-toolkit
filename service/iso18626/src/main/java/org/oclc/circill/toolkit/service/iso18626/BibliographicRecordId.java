/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BibliographicRecordIdentifierCode;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A bibliographic record identifier. Examples are Canadian National Catalogue code
 * OCLC number, or FAUST number (Denmark).
 */
public class BibliographicRecordId {

    protected String bibliographicRecordIdentifier;

    protected BibliographicRecordIdentifierCode bibliographicRecordIdentifierCode;

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
        final boolean result = new EqualsBuilder()
            .append(bibliographicRecordIdentifier, rhs.bibliographicRecordIdentifier)
            .append(bibliographicRecordIdentifierCode, rhs.bibliographicRecordIdentifierCode)
            .isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(315354063, 1545841017)
            .append(bibliographicRecordIdentifier)
            .append(bibliographicRecordIdentifierCode)
            .toHashCode();
        return result;
    }
}
