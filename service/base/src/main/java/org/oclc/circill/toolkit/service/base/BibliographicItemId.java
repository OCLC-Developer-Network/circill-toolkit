/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A bibliographic item idenifier. Examples are an ISBN, Government Document number, Legal Deposit Number, etc.
 */
public class BibliographicItemId {
    protected String bibliographicItemIdentifier;
    
    protected BibliographicItemIdentifierCode bibliographicItemIdentifierCode;

    public String getBibliographicItemIdentifier() {
        return bibliographicItemIdentifier;
    }

    public void setBibliographicItemIdentifier(final String bibliographicItemIdentifier) {
        this.bibliographicItemIdentifier = bibliographicItemIdentifier;
    }

    public BibliographicItemIdentifierCode getBibliographicItemIdentifierCode() {
        return bibliographicItemIdentifierCode;
    }

    public void setBibliographicItemIdentifierCode(final BibliographicItemIdentifierCode bibliographicItemIdentifierCode) {
        this.bibliographicItemIdentifierCode = bibliographicItemIdentifierCode;
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
        final BibliographicItemId rhs = (BibliographicItemId) obj;
        final boolean result = new EqualsBuilder()
            .append(bibliographicItemIdentifierCode, rhs.bibliographicItemIdentifierCode)
            .append(bibliographicItemIdentifier, rhs.bibliographicItemIdentifier)
            .isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(347434677, 346692973)
            .append(bibliographicItemIdentifier)
            .append(bibliographicItemIdentifierCode)
            .toHashCode();
        return result;
    }

}
