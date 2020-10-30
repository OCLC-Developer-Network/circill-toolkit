/*
 * Copyright (c) 2013 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.lookupversion.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.dozer.BaseJAXBDozerTranslator;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionInitiationData;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionResponseData;
import org.oclc.circill.toolkit.service.ncipversion.NCIPVersionMessage;

public class LookupVersionJAXBDozerTranslator extends
    BaseJAXBDozerTranslator<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData,
        org.oclc.circill.toolkit.binding.lookupversion.jaxb.elements.NCIPVersionMessage> {

    /**
     * Default constructor, uses default configuration.
     * @throws ConfigurationException if the Toolkit is not configured properly
     */
    public LookupVersionJAXBDozerTranslator() throws ConfigurationException {
        super();
    }

    @Override
    protected NCIPVersionMessage mapMessage(final org.oclc.circill.toolkit.binding.lookupversion.jaxb.elements.NCIPVersionMessage svcMsg) {
        return mapper.map(svcMsg, NCIPVersionMessage.class);
    }

    @Override
    protected org.oclc.circill.toolkit.binding.lookupversion.jaxb.elements.NCIPVersionMessage mapMessage(final NCIPVersionMessage svcMsg) {
        return mapper.map(svcMsg, org.oclc.circill.toolkit.binding.lookupversion.jaxb.elements.NCIPVersionMessage.class);
    }

}
