/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BibliographicRecordIdentifierCode;

@SuppressWarnings("ReturnOfThis")
public final class BibliographicRecordIdBuilder {

    private String bibliographicRecordIdentifier;
    private BibliographicRecordIdentifierCode bibliographicRecordIdentifierCode;

    /**
     * This utility class does not allow instances.
     */
    private BibliographicRecordIdBuilder() {
    }

    /**
     * -
     * @return a builder for {@link BibliographicRecordId}
     */
    public static BibliographicRecordIdBuilder aBibliographicRecordId() {
        final BibliographicRecordIdBuilder builder = new BibliographicRecordIdBuilder();
        return builder;
    }

    public BibliographicRecordIdBuilder withBibliographicRecordIdentifier(final String bibliographicRecordIdentifier) {
        this.bibliographicRecordIdentifier = bibliographicRecordIdentifier;
        return this;
    }

    public BibliographicRecordIdBuilder withBibliographicRecordIdentifierCode(final BibliographicRecordIdentifierCode bibliographicRecordIdentifierCode) {
        this.bibliographicRecordIdentifierCode = bibliographicRecordIdentifierCode;
        return this;
    }

    public BibliographicRecordId build() {
        final BibliographicRecordId bibliographicRecordId = new BibliographicRecordId();
        bibliographicRecordId.setBibliographicRecordIdentifier(bibliographicRecordIdentifier);
        bibliographicRecordId.setBibliographicRecordIdentifierCode(bibliographicRecordIdentifierCode);
        return bibliographicRecordId;
    }

}

