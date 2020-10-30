/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.iso18626.jaxb.mapstruct;

import org.oclc.circill.toolkit.binding.jaxb.mapstruct.BaseJAXBMapStructTranslator;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;

/**
 * Created by bodfishj on 2/7/18.
 */
public class ISO18626JAXBMapStructTranslator extends
    BaseJAXBMapStructTranslator<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData,
        org.oclc.circill.toolkit.binding.iso18626.jaxb.elements.ISO18626Message> {

    /**
     * Default constructor, uses default configuration.
     * @throws ConfigurationException if the Toolkit is not configured properly
     */
    public ISO18626JAXBMapStructTranslator() throws ConfigurationException {
        super();
    }
}
