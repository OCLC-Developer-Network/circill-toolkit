/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.mapstruct;

import org.oclc.circill.toolkit.binding.jaxb.BaseJAXBTranslator;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;

public abstract class BaseJAXBMapStructTranslator<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData, JAXBM extends Object>
    extends BaseJAXBTranslator<SM, ID, RD, JAXBM> {

    /** The {@link BaseMapStructMapper}. */
    protected BaseMapStructMapper<SM, JAXBM> mapper;

    /**
     * Create an instance of the translator.
     * @throws ConfigurationException if the Toolkit is not configured properly
     */
    public BaseJAXBMapStructTranslator() throws ConfigurationException {
        super();
    }

    public BaseMapStructMapper<SM, JAXBM> getMapper() {
        return mapper;
    }

    /** If you inject a mapper, you are responsible for configuring it, especially setting the mapping files
     * it's to use.
     * @param mapper the {@link BaseMapStructMapper} to use
     */
    public void setMapper(final BaseMapStructMapper<SM, JAXBM> mapper) {
        this.mapper = mapper;
    }

    @Override
    protected JAXBM mapMessage(final SM svcMsg) {
        return mapper.mapMessage(svcMsg);
    }

    @Override
    protected SM mapMessage(final JAXBM jaxbMsg) {
        return mapper.mapMessage(jaxbMsg);
    }

}
