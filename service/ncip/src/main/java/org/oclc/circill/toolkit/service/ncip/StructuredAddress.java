/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StructuredAddress {

    /**
     * Location Within Building
     */
    protected String locationWithinBuilding;
    /**
     * House Name
     */
    protected String houseName;
    /**
     * Street
     */
    protected String street;
    /**
     * PostOfficeBox
     */
    protected String postOfficeBox;
    /**
     * District
     */
    protected String district;
    /**
     * Line 1
     */
    protected String line1;
    /**
     * Line 2
     */
    protected String line2;
    /**
     * Locality
     */
    protected String locality;
    /**
     * Region
     */
    protected String region;
    /**
     * Country
     */
    protected String country;
    /**
     * PostalCode
     */
    protected String postalCode;
    /**
     * CareOf
     */
    protected String careOf;

    public String getLocationWithinBuilding() {
        return locationWithinBuilding;
    }

    public void setLocationWithinBuilding(final String locationWithinBuilding) {
        this.locationWithinBuilding = locationWithinBuilding;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(final String houseName) {
        this.houseName = houseName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getPostOfficeBox() {
        return postOfficeBox;
    }

    public void setPostOfficeBox(final String postOfficeBox) {
        this.postOfficeBox = postOfficeBox;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(final String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(final String line2) {
        this.line2 = line2;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(final String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCareOf() {
        return careOf;
    }

    public void setCareOf(final String careOf) {
        this.careOf = careOf;
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
        final StructuredAddress rhs = (StructuredAddress) obj;
        return new EqualsBuilder().append(locationWithinBuilding, rhs.locationWithinBuilding).append(houseName, rhs.houseName).append(street, rhs.street)
            .append(postOfficeBox, rhs.postOfficeBox).append(district, rhs.district).append(line1, rhs.line1).append(line2, rhs.line2).append(locality, rhs.locality)
            .append(region, rhs.region).append(country, rhs.country).append(postalCode, rhs.postalCode).append(careOf, rhs.careOf).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(113904473, 1544410473).append(locationWithinBuilding).append(houseName).append(street).append(postOfficeBox).append(district)
            .append(line1).append(line2).append(locality).append(region).append(country).append(postalCode).append(careOf).toHashCode();
        return result;
    }
}
