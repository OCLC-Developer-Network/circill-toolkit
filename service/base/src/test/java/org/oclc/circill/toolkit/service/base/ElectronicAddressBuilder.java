/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Build an ElectronicAddress.
 */
public final class ElectronicAddressBuilder {
    protected String electronicAddressData;
    protected ElectronicAddressType electronicAddressType;

    /**
     * This utility class does not allow instances.
     */

    private ElectronicAddressBuilder() {
    }

    /**
     * -
     * @return a builder for {@link ElectronicAddress}
     */

    public static ElectronicAddressBuilder anElectronicAddress() {
        final ElectronicAddressBuilder builder = new ElectronicAddressBuilder();
        return builder;
    }

    public ElectronicAddressBuilder withElectronicAddressData(final String electronicAddressData) {
        this.electronicAddressData = electronicAddressData;
        return this;
    }

    public ElectronicAddressBuilder withElectronicAddressType(final ElectronicAddressType electronicAddressType) {
        this.electronicAddressType = electronicAddressType;
        return this;
    }

    public ElectronicAddress build() {
        final ElectronicAddress electronicAddress = new ElectronicAddress();
        electronicAddress.setElectronicAddressData(electronicAddressData);
        electronicAddress.setElectronicAddressType(electronicAddressType);
        return electronicAddress;
    }
}
