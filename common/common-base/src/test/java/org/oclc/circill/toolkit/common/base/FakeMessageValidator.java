/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ValidationException;

/**
 * This validates the coherence of the NCIPMessage object and is intended for use in unit testing the binding packages.
 * It would not be useful elsewhere except perhaps to diagnose failures due to violations of the conditions it tests
 * for.
 */
public class FakeMessageValidator implements ServiceContext<FakeMessage<FakeInitiationData, FakeResponseData>, FakeInitiationData, FakeResponseData> {
    @Override
    public void validateBeforeMarshalling(final FakeMessage<FakeInitiationData, FakeResponseData> message) throws ValidationException {
        if (message == null) {
            throw new FakeValidationException("Message is null");
        }
    }

    @Override
    public void validateAfterUnmarshalling(final FakeMessage<FakeInitiationData, FakeResponseData> message) throws ValidationException {
        if (message == null) {
            throw new FakeValidationException("Message is null");
        }
    }

}
