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

public class RoutingInformation {

    /**
     * Routing Instructions
     */
    protected String routingInstructions;
    /**
     * Destination
     */
    protected Destination destination;

    public String getRoutingInstructions() {
        return routingInstructions;
    }

    public void setRoutingInstructions(final String routingInstructions) {
        this.routingInstructions = routingInstructions;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(final Destination destination) {
        this.destination = destination;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(final RequestType requestType) {
        this.requestType = requestType;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(final UserId userId) {
        this.userId = userId;
    }

    public NameInformation getNameInformation() {
        return nameInformation;
    }

    public void setNameInformation(final NameInformation nameInformation) {
        this.nameInformation = nameInformation;
    }

    /**
     * Request Type
     */
    protected RequestType requestType;
    /**
     * User Id
     */
    protected UserId userId;
    /**
     * Name Information
     */
    protected NameInformation nameInformation;

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
        final RoutingInformation rhs = (RoutingInformation) obj;
        return new EqualsBuilder().append(routingInstructions, rhs.routingInstructions).append(destination, rhs.destination).append(requestType, rhs.requestType)
            .append(userId, rhs.userId).append(nameInformation, rhs.nameInformation).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1021714959, 393090629).append(routingInstructions).append(destination).append(requestType).append(userId).append(nameInformation)
            .toHashCode();
        return result;
    }
}
