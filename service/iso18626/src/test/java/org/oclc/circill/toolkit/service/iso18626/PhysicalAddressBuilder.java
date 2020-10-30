/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class PhysicalAddressBuilder {

    private String line1;
    private String line2;
    private String locality;
    private String postalCode;
    private RegionType region;
    private CountryType country;

    /**
     * This utility class does not allow instances.
     */
    private PhysicalAddressBuilder() {
    }

    /**
     * -
     * @return a builder for {@link PhysicalAddress}
     */
    public static PhysicalAddressBuilder aPhysicalAddress() {
        final PhysicalAddressBuilder builder = new PhysicalAddressBuilder();
        return builder;
    }

    public PhysicalAddressBuilder withLine1(final String line1) {
        this.line1 = line1;
        return this;
    }

    public PhysicalAddressBuilder withLine2(final String line2) {
        this.line2 = line2;
        return this;
    }

    public PhysicalAddressBuilder withLocality(final String locality) {
        this.locality = locality;
        return this;
    }

    public PhysicalAddressBuilder withPostalCode(final String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public PhysicalAddressBuilder withRegion(final RegionType region) {
        this.region = region;
        return this;
    }

    public PhysicalAddressBuilder withCountry(final CountryType country) {
        this.country = country;
        return this;
    }

    public PhysicalAddress build() {
        final PhysicalAddress physicalAddress = new PhysicalAddress();
        physicalAddress.setLine1(line1);
        physicalAddress.setLine2(line2);
        physicalAddress.setLocality(locality);
        physicalAddress.setPostalCode(postalCode);
        physicalAddress.setRegion(region);
        physicalAddress.setCountry(country);
        return physicalAddress;
    }

}

