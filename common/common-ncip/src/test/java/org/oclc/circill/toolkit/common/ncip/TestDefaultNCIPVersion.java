/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestDefaultNCIPVersion {

    public final DefaultNCIPVersion protocolVersion;
    public final String expectedVersionString;
    public final DefaultNCIPVersion expectedCanonicalVersion;

    public TestDefaultNCIPVersion(final DefaultNCIPVersion protocolVersion, final String expectedVersionString, final DefaultNCIPVersion expectedCanonicalVersion) {
        this.protocolVersion = protocolVersion;
        this.expectedVersionString = expectedVersionString;
        this.expectedCanonicalVersion = expectedCanonicalVersion;
    }

    @Test
    public final void testVersionString() {
        final String versionString = protocolVersion.getVersionAttribute();
        assertEquals(expectedVersionString, versionString);
    }

    @Test
    public final void testCanonicalVersionString() {
        final DefaultNCIPVersion canonicalVersion = protocolVersion.getCanonicalVersion();
        assertEquals(expectedCanonicalVersion, canonicalVersion);
    }

    @Test
    public final void testFindByVersion() {
        assertEquals(protocolVersion, DefaultNCIPVersion.findByVersionAttribute(expectedVersionString));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() throws ToolkitException {
        return Arrays.asList(new Object[] { DefaultNCIPVersion.VERSION_1_0, "http://www.niso.org/ncip/v1_0/imp1/dtd/ncip_v1_0.dtd", null },
            new Object[] { DefaultNCIPVersion.VERSION_1_01, "http://www.niso.org/ncip/v1_01/imp1/dtd/ncip_v1_01.dtd", null },
            new Object[] { DefaultNCIPVersion.VERSION_2_0, "http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_0.xsd", null },
            new Object[] { DefaultNCIPVersion.VERSION_2_01, "http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_01.xsd", null },
            new Object[] { DefaultNCIPVersion.VERSION_2_02, "http://www.niso.org/schemas/ncip/v2_0/imp1/xsd/ncip_v2_02.xsd", null },
            new Object[] { new DefaultNCIPVersion("ncip_v1_0.dtd", DefaultNCIPVersion.VERSION_1_0), "ncip_v1_0.dtd", DefaultNCIPVersion.VERSION_1_0 },
            new Object[] { new DefaultNCIPVersion("ncip_v1_01.dtd", DefaultNCIPVersion.VERSION_1_01), "ncip_v1_01.dtd", DefaultNCIPVersion.VERSION_1_01 },
            new Object[] { new DefaultNCIPVersion("ncip_v2_0.xsd", DefaultNCIPVersion.VERSION_2_0), "ncip_v2_0.xsd", DefaultNCIPVersion.VERSION_2_0 },
            new Object[] { new DefaultNCIPVersion("ncip_v2_01.xsd", DefaultNCIPVersion.VERSION_2_01), "ncip_v2_01.xsd", DefaultNCIPVersion.VERSION_2_01 },
            new Object[] { new DefaultNCIPVersion("ncip_v2_02.xsd", DefaultNCIPVersion.VERSION_2_02), "ncip_v2_02.xsd", DefaultNCIPVersion.VERSION_2_02 },
            new Object[] { new DefaultNCIPVersion(null, null), null, null });
    }

}
