/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.common.base.ProtocolVersion;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Default NCIP {@link ProtocolVersion}.
 */
public class DefaultNCIPVersion implements ProtocolVersion {

    protected static final Map<String, DefaultNCIPVersion> VERSIONS_BY_ATTRIBUTE = new HashMap<>();

    protected String versionAttribute;
    protected DefaultNCIPVersion canonicalVersion;

    /**
     * Construct an uninitialized instance.
     */
    public DefaultNCIPVersion() {
        // Do nothing
    }

    /**
     * Construct an instance with provided version attribute and canonical version attribute.
     * @param versionAttribute the version attribute
     * @param canonicalVersion the canonical version attribute
     */
    public DefaultNCIPVersion(final String versionAttribute, final DefaultNCIPVersion canonicalVersion) {

        this.versionAttribute = versionAttribute;
        this.canonicalVersion = canonicalVersion;
        synchronized (DefaultNCIPVersion.class) {
            if (!VERSIONS_BY_ATTRIBUTE.containsKey(this.versionAttribute)) {
                VERSIONS_BY_ATTRIBUTE.put(this.versionAttribute, this);
            }
        }

    }

    /**
     * Construct an instance with provided version attribute and a null canonical version attribute.
     * @param versionAttribute the version attribute
     */
    public DefaultNCIPVersion(final String versionAttribute) {

        this(versionAttribute, null);
    }

    public static final DefaultNCIPVersion VERSION_1_0 = new DefaultNCIPVersion("http://www.niso.org/ncip/v1_0/imp1/dtd/ncip_v1_0.dtd");
    public static final DefaultNCIPVersion VERSION_1_01 = new DefaultNCIPVersion("http://www.niso.org/ncip/v1_01/imp1/dtd/ncip_v1_01.dtd");
    public static final DefaultNCIPVersion VERSION_2_0 = new DefaultNCIPVersion("http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd");
    public static final DefaultNCIPVersion VERSION_2_01 = new DefaultNCIPVersion("http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_01.xsd");
    public static final DefaultNCIPVersion VERSION_2_02 = new DefaultNCIPVersion("http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_02.xsd");

    public String getVersionAttribute() {

        return this.versionAttribute;

    }

    public DefaultNCIPVersion getCanonicalVersion() {

        return this.canonicalVersion;

    }

    /**
     * Find the {@link DefaultNCIPVersion} instance for the provided version attribute value.
     * @param versionAttribute the value of the <code>version</code> attribute on the message
     * @return the {@link DefaultNCIPVersion}
     */
    public static DefaultNCIPVersion findByVersionAttribute(final String versionAttribute) {

        return VERSIONS_BY_ATTRIBUTE.get(versionAttribute);

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
        final DefaultNCIPVersion rhs = (DefaultNCIPVersion) obj;
        return new EqualsBuilder().append(versionAttribute, rhs.versionAttribute).append(canonicalVersion, rhs.canonicalVersion).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(1018898499, 1938329131).append(versionAttribute).append(canonicalVersion).toHashCode();
        return result;
    }

}
