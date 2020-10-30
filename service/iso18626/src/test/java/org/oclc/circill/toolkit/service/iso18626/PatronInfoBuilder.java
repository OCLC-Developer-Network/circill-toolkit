/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ReturnOfThis")
public final class PatronInfoBuilder {

    private String patronId;
    private String surname;
    private String givenName;
    private PatronType patronType;
    private YesNoType sendToPatron;
    private List<Address> addresses = new ArrayList<>();

    /**
     * This utility class does not allow instances.
     */
    private PatronInfoBuilder() {
    }

    /**
     * -
     * @return a builder for {@link PatronInfo}
     */
    public static PatronInfoBuilder aPatronInfo() {
        final PatronInfoBuilder builder = new PatronInfoBuilder();
        return builder;
    }

    public PatronInfoBuilder withPatronId(final String patronId) {
        this.patronId = patronId;
        return this;
    }

    public PatronInfoBuilder withSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public PatronInfoBuilder withGivenName(final String givenName) {
        this.givenName = givenName;
        return this;
    }

    public PatronInfoBuilder withPatronType(final PatronType patronType) {
        this.patronType = patronType;
        return this;
    }

    public PatronInfoBuilder withSendToPatron(final YesNoType sendToPatron) {
        this.sendToPatron = sendToPatron;
        return this;
    }

    public PatronInfoBuilder withAddresses(final List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public PatronInfo build() {
        final PatronInfo patronInfo = new PatronInfo();
        patronInfo.setPatronId(patronId);
        patronInfo.setSurname(surname);
        patronInfo.setGivenName(givenName);
        patronInfo.setPatronType(patronType);
        patronInfo.setSendToPatron(sendToPatron);
        patronInfo.setAddresses(addresses);
        return patronInfo;
    }

}

