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
 * A physical address.
 */
public class PhysicalAddress {

    protected String line1;
    protected String line2;
    protected String locality;
    protected String postalCode;
    protected RegionType region;
    protected CountryType country;

    /**
     * Gets the value of the line1 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLine1() {
        return line1;
    }

    /**
     * Sets the value of the line1 property.
     *
     * @param line1
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLine1(final String line1) {
        this.line1 = line1;
    }

    /**
     * Gets the value of the line2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLine2() {
        return line2;
    }

    /**
     * Sets the value of the line2 property.
     *
     * @param line2
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLine2(final String line2) {
        this.line2 = line2;
    }

    /**
     * Gets the value of the locality property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLocality() {
        return locality;
    }

    /**
     * Sets the value of the locality property.
     *
     * @param locality
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLocality(final String locality) {
        this.locality = locality;
    }

    /**
     * Gets the value of the postalCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     *
     * @param postalCode
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the value of the region property.
     *
     * @return
     *     possible object is
     *     {@link RegionType }
     *
     */
    public RegionType getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     *
     * @param region
     *     allowed object is
     *     {@link RegionType }
     *
     */
    public void setRegion(final RegionType region) {
        this.region = region;
    }

    /**
     * Gets the value of the country property.
     *
     * @return
     *     possible object is
     *     {@link CountryType }
     *
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param country
     *     allowed object is
     *     {@link CountryType }
     *
     */
    public void setCountry(final CountryType country) {
        this.country = country;
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
        final PhysicalAddress rhs = (PhysicalAddress) obj;
        final boolean result = new EqualsBuilder().append(line1, rhs.line1).append(line2, rhs.line2).append(locality, rhs.locality).append(postalCode, rhs.postalCode)
            .append(region, rhs.region).append(country, rhs.country).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(714917853, 832678153).append(line1).append(line2).append(locality).append(postalCode).append(region).append(country).toHashCode();
        return result;
    }
}
