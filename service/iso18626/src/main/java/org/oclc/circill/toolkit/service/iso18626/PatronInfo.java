/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Details of the patron for whom the request is being made.
 * Only used according to 5.2.4 of ISO 18626:2017.
 */
public class PatronInfo {

    protected String patronId;
    protected String surname;
    protected String givenName;
    protected PatronType patronType;
    protected YesNoType sendToPatron;
    protected List<Address> addresses = new ArrayList<>();

    public YesNoType getSendToPatron() {
        return sendToPatron;
    }

    public void setSendToPatron(final YesNoType sendToPatron) {
        this.sendToPatron = sendToPatron;
    }

    public PatronType getPatronType() {

        return patronType;
    }

    public void setPatronType(final PatronType patronType) {
        this.patronType = patronType;
    }

    public String getGivenName() {

        return givenName;
    }

    public void setGivenName(final String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getPatronId() {

        return patronId;
    }

    public void setPatronId(final String patronId) {
        this.patronId = patronId;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Address getAddress() {
        return addresses != null ? (addresses.size() > 0 ? addresses.get(addresses.size() - 1) : null) : null;
    }

    public Address getAddress(final int index) {
        return addresses != null ? (addresses.size() > 0 ? addresses.get(index) : null) : null;
    }

    public void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setAddress(final int index, final Address address) {
        addresses.set(index, address);
    }

    public void setAddress(final Address address) {
        if (this.addresses != null) {
            this.addresses.clear();
        }
        if (address != null) {
            if (this.addresses == null) {
                this.addresses = new ArrayList<>();
            }
            this.addresses.add(address);
        } else {
            this.addresses = null;
        }
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
        final PatronInfo rhs = (PatronInfo) obj;
        final boolean result = new EqualsBuilder().append(patronId, rhs.patronId).append(surname, rhs.surname).append(givenName, rhs.givenName).append(patronType, rhs.patronType)
            .append(sendToPatron, rhs.sendToPatron).append(addresses, rhs.addresses).isEquals();
        return result;
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2145574993, 1678526393).append(patronId).append(surname).append(givenName).append(patronType).append(sendToPatron).append(addresses)
            .toHashCode();
        return result;
    }

}
