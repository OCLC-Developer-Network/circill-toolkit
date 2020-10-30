/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class ReturnInfoBuilder {

    private AgencyId returnAgencyId;
    private String name;
    private PhysicalAddress physicalAddress;

    /**
     * This utility class does not allow instances.
     */
    private ReturnInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link ReturnInfo}
     */
    public static ReturnInfoBuilder aReturnInfo() {
        final ReturnInfoBuilder builder = new ReturnInfoBuilder();
        return builder;
    }

    public ReturnInfoBuilder withReturnAgencyId(final AgencyId returnAgencyId) {
        this.returnAgencyId = returnAgencyId;
        return this;
    }

    public ReturnInfoBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    public ReturnInfoBuilder withPhysicalAddress(final PhysicalAddress physicalAddress) {
        this.physicalAddress = physicalAddress;
        return this;
    }

    public ReturnInfo build() {
        final ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setReturnAgencyId(returnAgencyId);
        returnInfo.setName(name);
        returnInfo.setPhysicalAddress(physicalAddress);
        return returnInfo;
    }

}

