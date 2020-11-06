/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ServiceMessage;

/**
 * Subclass of {@link ServiceMessage} for tests.
 */
public class FakeMessage<ID extends FakeInitiationData, RD extends FakeResponseData> implements ServiceMessage<ID, RD> {
}
