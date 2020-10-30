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

/**
 * Identifies component part of another bibliographic item.
 */
public class ComponentId {
    protected ComponentIdentifierType componentIdentifierType;
    protected String componentIdentifier;

    public ComponentIdentifierType getComponentIdentifierType() {
        return componentIdentifierType;
    }

    public void setComponentIdentifierType(final ComponentIdentifierType componentIdentifierType) {
        this.componentIdentifierType = componentIdentifierType;
    }

    public String getComponentIdentifier() {
        return componentIdentifier;
    }

    public void setComponentIdentifier(final String componentIdentifier) {
        this.componentIdentifier = componentIdentifier;
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
        final ComponentId rhs = (ComponentId) obj;
        return new EqualsBuilder().append(componentIdentifierType, rhs.componentIdentifierType).append(componentIdentifier, rhs.componentIdentifier).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(73415793, 1602649873).append(componentIdentifierType).append(componentIdentifier).toHashCode();
        return result;
    }
}
