/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.mapstruct;

import org.oclc.circill.toolkit.service.base.ServiceMessage;

public interface BaseMapStructMapper<SM extends ServiceMessage, JAXBM extends Object> {

    JAXBM mapMessage(SM svcMsg);

    SM mapMessage(JAXBM jaxbMsg);

}
