/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseJAXBDozerTranslator;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;

public class ILSDIv1_0_bc_JAXBDozerTranslator extends
    BaseJAXBDozerTranslator<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData,
        org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.NCIPMessage> {

    /**
     * Default constructor, uses default configuration.
     * @throws ConfigurationException if the Toolkit is not configured properly
     */
    public ILSDIv1_0_bc_JAXBDozerTranslator() throws ConfigurationException {
        super();
    }

    @Override
    protected org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.NCIPMessage mapMessage(final NCIPMessage svcMsg) {
        return mapper.map(svcMsg, org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.NCIPMessage.class);
    }

    @Override
    protected NCIPMessage mapMessage(final org.oclc.circill.toolkit.binding.ilsdiv1_0_bc.jaxb.elements.NCIPMessage svcMsg) {
        return mapper.map(svcMsg, NCIPMessage.class);
    }

}
