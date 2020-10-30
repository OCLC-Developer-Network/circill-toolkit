/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ncipv2_01.jaxb;

import org.oclc.circill.toolkit.binding.BaseTestTranslator;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TestNCIPv2_01JAXBTranslator extends BaseTestTranslator<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> {

    @Test
    public void testSampleFiles() throws FileNotFoundException, ToolkitException {

        doTest();

    }
}
