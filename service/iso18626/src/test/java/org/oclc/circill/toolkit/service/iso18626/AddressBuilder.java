/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */


package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.ElectronicAddress;

@SuppressWarnings("ReturnOfThis")
public final class AddressBuilder {

    private ElectronicAddress electronicAddress;
    private PhysicalAddress physicalAddress;

    /**
     * This utility class does not allow instances.
     */
    private AddressBuilder() {
    }

    /**
     * -
     * @return a builder for {@link Address}
     */
    public static AddressBuilder aAddress() {
        final AddressBuilder builder = new AddressBuilder();
        return builder;
    }

    public AddressBuilder withElectronicAddress(final ElectronicAddress electronicAddress) {
        this.electronicAddress = electronicAddress;
        return this;
    }

    public AddressBuilder withPhysicalAddress(final PhysicalAddress physicalAddress) {
        this.physicalAddress = physicalAddress;
        return this;
    }

    public Address build() {
        final Address address = new Address();
        address.setElectronicAddress(electronicAddress);
        address.setPhysicalAddress(physicalAddress);
        return address;
    }

}

