/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

/**
 * Interface for all objects used to initiate a service.
 */
public interface NCIPInitiationData extends ServiceInitiationData, NCIPData {

    InitiationHeader getInitiationHeader();

    void setInitiationHeader(InitiationHeader initiationHeader);

    AgencyId getRelyingPartyId();

    void setRelyingPartyId(AgencyId agencyId);

}
