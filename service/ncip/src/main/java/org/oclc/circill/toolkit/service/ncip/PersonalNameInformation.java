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

public class PersonalNameInformation {
    /**
     * Unstructured Personal User Name
     */
    protected String unstructuredPersonalUserName;
    /**
     * Structured Personal User Name
     */
    protected StructuredPersonalUserName structuredPersonalUserName;

    public String getUnstructuredPersonalUserName() {
        return unstructuredPersonalUserName;
    }

    public void setUnstructuredPersonalUserName(final String unstructuredPersonalUserName) {
        this.unstructuredPersonalUserName = unstructuredPersonalUserName;
    }

    public StructuredPersonalUserName getStructuredPersonalUserName() {
        return structuredPersonalUserName;
    }

    public void setStructuredPersonalUserName(final StructuredPersonalUserName structuredPersonalUserName) {
        this.structuredPersonalUserName = structuredPersonalUserName;
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
        final PersonalNameInformation rhs = (PersonalNameInformation) obj;
        return new EqualsBuilder().append(unstructuredPersonalUserName, rhs.unstructuredPersonalUserName).append(structuredPersonalUserName, rhs.structuredPersonalUserName)
            .isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1887512689, 676326953).append(unstructuredPersonalUserName).append(structuredPersonalUserName).toHashCode();
        return result;
    }

}
