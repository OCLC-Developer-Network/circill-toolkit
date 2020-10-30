/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.ServiceInitiationData;

/**
 * Created by bodfishj on 2/7/18.
 */
public interface ISO18626RequestData extends ServiceInitiationData, ISO18626Data {

    Header getHeader();
    void setHeader(Header header);

}
