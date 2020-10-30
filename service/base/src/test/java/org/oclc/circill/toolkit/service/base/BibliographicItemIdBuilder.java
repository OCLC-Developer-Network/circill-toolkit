/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Build {@link BibliographicItemId}s.
 */
@SuppressWarnings("ReturnOfThis")
public final class BibliographicItemIdBuilder {

    private BibliographicItemIdentifierCode bibliographicItemIdentifierCode;
    private String bibliographicItemIdentifier;

    /**
     * This utility class does not allow instances.
     */
    private BibliographicItemIdBuilder() {
    }

    /**
     * -
     * @return a builder for {@link BibliographicItemId}
     */
    public static BibliographicItemIdBuilder aBibliographicItemId() {
        final BibliographicItemIdBuilder builder = new BibliographicItemIdBuilder();
        return builder;
    }

    public BibliographicItemIdBuilder withBibliographicItemIdentifierCode(final BibliographicItemIdentifierCode bibliographicItemIdentifierCode) {
        this.bibliographicItemIdentifierCode = bibliographicItemIdentifierCode;
        return this;
    }

    public BibliographicItemIdBuilder withBibliographicItemIdentifier(final String bibliographicItemIdentifier) {
        this.bibliographicItemIdentifier = bibliographicItemIdentifier;
        return this;
    }

    public BibliographicItemId build() {
        final BibliographicItemId bibliographicItemId = new BibliographicItemId();
        bibliographicItemId.setBibliographicItemIdentifierCode(bibliographicItemIdentifierCode);
        bibliographicItemId.setBibliographicItemIdentifier(bibliographicItemIdentifier);
        return bibliographicItemId;
    }

}

