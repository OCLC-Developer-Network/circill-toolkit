/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * Base class for {@link ServiceContext}s.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public class BaseServiceContext<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> implements ServiceContext<SM, ID, RD> {
    @Override
    public void validateBeforeMarshalling(final SM message) throws ValidationException {
        // Do nothing - sub classes may implement.
    }

    @Override
    public void validateAfterUnmarshalling(final SM message) throws ValidationException {
        // Do nothing - sub classes may implement.
    }
}
