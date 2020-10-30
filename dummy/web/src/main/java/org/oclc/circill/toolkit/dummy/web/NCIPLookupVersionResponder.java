/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy.web;

import org.oclc.circill.toolkit.responder.implprof1.ServiceResponder;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionInitiationData;
import org.oclc.circill.toolkit.service.ncipversion.LookupVersionResponseData;
import org.oclc.circill.toolkit.service.ncipversion.NCIPVersionMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Implements an NCIP responder for HTTP and HTTPS transport according to
 * the NCIP Implementation Profile 1; for use as a Spring bean with a dispatcher.
 */
@Controller
@RequestMapping("/ncip/version")
public class NCIPLookupVersionResponder
    extends ServiceResponder<NCIPVersionMessage<LookupVersionInitiationData, LookupVersionResponseData>, LookupVersionInitiationData, LookupVersionResponseData> {
    /**
     * Construct an instance.
     */
    public NCIPLookupVersionResponder() {
        super();
    }

}
