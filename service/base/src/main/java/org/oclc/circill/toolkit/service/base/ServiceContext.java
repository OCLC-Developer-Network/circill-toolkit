/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

/**
 * The context information for a given invocation of a service.
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public interface ServiceContext<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> {

    /**
     * Determines whether the {@link ServiceMessage} object represents a valid message for this service.
     * It may check version, app profile, etc. and possibly move data around and/or transform its representation to
     * "normalize" the message for this service. If the data is not valid and can't be made valid,
     * it throws a ValidationException which contains the Problem element to return.
     * @param message the {@link ServiceMessage}
     * @throws ValidationException if the message is invalid
     */
    void validateBeforeMarshalling(SM message) throws ValidationException;

    /**
     * Determines whether the {@link ServiceMessage} object represents a valid message for this service.
     * It may check version, app profile, etc. and possibly move data around and/or transform its representation to
     * "normalize" the message for this service. If the data is not valid and can't be made valid,
     * it throws a ValidationException which contains the Problem element to return.
     * @param message the {@link ServiceMessage}
     * @throws ValidationException if the message is invalid
     */
    void validateAfterUnmarshalling(SM message) throws ValidationException;

}
