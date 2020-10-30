/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */


package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class AgencyIdBuilder {

    private AgencyIdType agencyIdType;
    private String agencyIdValue;

    /**
     * This utility class does not allow instances.
     */
    private AgencyIdBuilder() {
    }

    /**
     * -
     * @return a builder for {@link AgencyId}
     */
    public static AgencyIdBuilder aAgencyId() {
        final AgencyIdBuilder builder = new AgencyIdBuilder();
        return builder;
    }

    public AgencyIdBuilder withAgencyIdType(final AgencyIdType agencyIdType) {
        this.agencyIdType = agencyIdType;
        return this;
    }

    public AgencyIdBuilder withAgencyIdValue(final String agencyIdValue) {
        this.agencyIdValue = agencyIdValue;
        return this;
    }

    public AgencyId build() {
        final AgencyId agencyId = new AgencyId();
        agencyId.setAgencyIdType(agencyIdType);
        agencyId.setAgencyIdValue(agencyIdValue);
        return agencyId;
    }

}

