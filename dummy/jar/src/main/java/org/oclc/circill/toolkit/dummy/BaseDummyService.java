/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.common.ncip.NCIPProtocolHelper;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPService;

/**
 * A dummy {@link Service} for NCIP messages.
 * @param <ID> the {@link NCIPInitiationData} type
 * @param <RD> the {@link NCIPResponseData} type
 */
public abstract class BaseDummyService<ID extends NCIPInitiationData, RD extends NCIPResponseData> implements NCIPService<ID, RD> {
    protected NCIPProtocolHelper protocolHelper = new NCIPProtocolHelper();

    public NCIPProtocolHelper getProtocolHelper() {
        return protocolHelper;
    }

    public void setProtocolHelper(final NCIPProtocolHelper protocolHelper) {
        this.protocolHelper = protocolHelper;
    }

}
