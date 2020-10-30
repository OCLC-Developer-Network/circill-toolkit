/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.lookupversion.jaxb;

import org.oclc.circill.toolkit.binding.BaseTestTranslator;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionInitiationData;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionResponseData;
import org.oclc.circill.toolkit.service.ncipversion.NCIPVersionMessage;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TestLookupVersionJAXBTranslator
    extends BaseTestTranslator<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> {

    @Test
    public void testSampleFiles() throws FileNotFoundException, ToolkitException {
        doTest();
    }
}
