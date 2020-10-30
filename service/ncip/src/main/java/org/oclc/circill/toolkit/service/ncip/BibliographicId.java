/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.BibliographicItemId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BibliographicId {

    /**
     * Bibliographic Item Id
     */
    protected BibliographicItemId bibliographicItemId;
    /**
     * Bibliographic Record Id
     */
    protected BibliographicRecordId bibliographicRecordId;

    public BibliographicItemId getBibliographicItemId() {
        return bibliographicItemId;
    }

    public void setBibliographicItemId(final BibliographicItemId bibliographicItemId) {
        this.bibliographicItemId = bibliographicItemId;
    }

    public BibliographicRecordId getBibliographicRecordId() {
        return bibliographicRecordId;
    }

    public void setBibliographicRecordId(final BibliographicRecordId bibliographicRecordId) {
        this.bibliographicRecordId = bibliographicRecordId;
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
        final BibliographicId rhs = (BibliographicId) obj;
        return new EqualsBuilder().append(bibliographicItemId, rhs.bibliographicItemId).append(bibliographicRecordId, rhs.bibliographicRecordId).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1757851327, 1107776447).append(bibliographicItemId).append(bibliographicRecordId).toHashCode();
        return result;
    }

}
