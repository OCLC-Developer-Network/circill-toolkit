/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bodfishj on 2/7/18.
 */
public class PublicationInfo {

    protected String publisher;
    protected PublicationType publicationType;
    protected String publicationDate;
    protected String placeOfPublication;

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

    public PublicationType getPublicationType() {

        return publicationType;
    }

    public void setPublicationType(final PublicationType publicationType) {
        this.publicationType = publicationType;
    }

    public String getPublisher() {

        return publisher;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

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
        final PublicationInfo rhs = (PublicationInfo) obj;
        final boolean result = new EqualsBuilder().append(publisher, rhs.publisher).append(publicationType, rhs.publicationType).append(publicationDate, rhs.publicationDate)
            .append(placeOfPublication, rhs.placeOfPublication).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(436109981, 1574615655).append(publisher).append(publicationType).append(publicationDate).append(placeOfPublication).toHashCode();
        return result;
    }
}
