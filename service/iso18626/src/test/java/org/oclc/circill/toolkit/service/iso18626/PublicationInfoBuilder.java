/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class PublicationInfoBuilder {

    private String publisher;
    private PublicationType publicationType;
    private String publicationDate;
    private String placeOfPublication;

    /**
     * This utility class does not allow instances.
     */
    private PublicationInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link PublicationInfo}
     */
    public static PublicationInfoBuilder aPublicationInfo() {
        final PublicationInfoBuilder builder = new PublicationInfoBuilder();
        return builder;
    }

    public PublicationInfoBuilder withPublisher(final String publisher) {
        this.publisher = publisher;
        return this;
    }

    public PublicationInfoBuilder withPublicationType(final PublicationType publicationType) {
        this.publicationType = publicationType;
        return this;
    }

    public PublicationInfoBuilder withPublicationDate(final String publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public PublicationInfoBuilder withPlaceOfPublication(final String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
        return this;
    }

    public PublicationInfo build() {
        final PublicationInfo publicationInfo = new PublicationInfo();
        publicationInfo.setPublisher(publisher);
        publicationInfo.setPublicationType(publicationType);
        publicationInfo.setPublicationDate(publicationDate);
        publicationInfo.setPlaceOfPublication(placeOfPublication);
        return publicationInfo;
    }

}

