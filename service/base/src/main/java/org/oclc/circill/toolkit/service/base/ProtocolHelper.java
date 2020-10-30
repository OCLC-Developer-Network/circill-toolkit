/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.math.BigDecimal;

/**
 * Helper methods for a particular protocol (e.g. NCIP or ISO18626).
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of {@link ServiceInitiationData}
 * @param <RD> the type of {@link ServiceResponseData}
 */
public interface ProtocolHelper<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> {

    /**
     * Get the message's name.
     * @param message the {@link ServiceMessage}
     * @return the message's name
     * @throws ToolkitInternalException -
     */
    String getMessageName(SM message) throws ToolkitInternalException;

    /**
     * Convert the exception to a response data object.
     * @param e the exception
     * @return the response data object
     */
    RD convertExceptionToResponse(Exception e);

    /**
     * Create an error/problem response data object with the message.
     * @param msg the message
     * @param initiationData the {@link ServiceInitiationData} object associated with the error/problem
     * @return the response data object
     */
    RD createProblemResponse(String msg, ID initiationData);

    /**
     * Create a String that represents the message as the HTTP servlet response.
     * Note: If a valid {@link ServiceContext} is available, then use {@link #returnProblem(String, ServiceContext)} instead of this.
     * @param msg the message
     * @return the HTTP response as a string
     */
    String returnProblem(String msg);

    /**
     * Create a String that represents the message as the HTTP servlet response.
     * @param msg the message
     * @param serviceContext the {@link ServiceContext}
     * @return the HTTP response as a string
     */
    String returnProblem(String msg, ServiceContext<SM, ID, RD> serviceContext);

    /**
     * Create a String that represents the exception as the HTTP servlet response.
     * @param msg the message
     * @param e the exception
     * @param serviceContext the {@link ServiceContext}
     * @param includeStackTracesInProblemResponse whether to include stack traces in the response
     * @param includeExceptionMessagesInProblemResponse whether to include exception messages in the response
     * @return the HTTP response as a string
     */
    String returnException(String msg, Throwable e, ServiceContext<SM, ID, RD> serviceContext, boolean includeStackTracesInProblemResponse,
        boolean includeExceptionMessagesInProblemResponse);

    /**
     * Create a {@link ServiceMessage} from the {@link ServiceInitiationData} object.
     * @param initiationData the {@link ServiceInitiationData} object to put in the message
     * @return the {@link ServiceMessage}
     * @throws ToolkitInternalException if a failure occurs
     */
    SM createServiceMessage(ID initiationData) throws ToolkitInternalException;

    /**
     * Create a {@link ServiceMessage} from the {@link ServiceResponseData} object.
     * @param responseData the {@link ServiceResponseData} object to put in the message
     * @return the {@link ServiceMessage}
     * @throws ToolkitInternalException if a failure occurs
     */
    SM createServiceMessage(RD responseData) throws ToolkitInternalException;

    /**
     * Get the {@link ServiceInitiationData} from the {@link ServiceMessage} object.
     * @param serviceMessage the {@link ServiceMessage}
     * @return the {@link ServiceInitiationData} object from the message
     * @throws ToolkitInternalException if a failure occurs
     */
    ID getInitiationData(SM serviceMessage) throws ToolkitInternalException;

    /**
     * Get the {@link ServiceResponseData} from the {@link ServiceMessage} object.
     * @param serviceMessage the {@link ServiceMessage}
     * @return the {@link ServiceResponseData} object from the message
     * @throws ToolkitInternalException if a failure occurs
     */
    RD getResponseData(SM serviceMessage) throws ToolkitInternalException;

    /**
     * Get the element name associated with the class.
     * @param svcClass a class from the Service package
     * @return the element name
     */
    String getElementName(Class<?> svcClass);

    /**
     * Convert an integer currency amount (represented as a BigDecimal object) to a fixed point form.
     * @param amount the integer amount (e.g. $20.15 is represented as 2015; and the sum of 12.357 Bahraini Dinar is represented as 12357)
     * @param cc the {@link CurrencyCode} of the amount
     * @return the amount in major-dot-minor currency units, e.g. $20.15 is represented as 20.15; 12.357 Bahraini Dinar is represented as 12.357
     */
    BigDecimal decimalize(BigDecimal amount, CurrencyCode cc);

    /**
     * Convert a fixed-point amount to an integer value represented as a BigDecimal object.
     * @param amount the fixed-point amount (e.g. $20.15 is represented as 20.15; and 12357 Bahraini Dinar is represented as 12.357)
     * @param cc the {@link CurrencyCode} of the amount
     * @return the amount in major-minor currency units, e.g. $20.15 is represented as 2015; 12.357 Bahraini Dinar is represented as 12357
     */
    BigDecimal undecimalize(BigDecimal amount, CurrencyCode cc);

    /**
     * Format a monetary amount as a String.
     * @param amount the fixed-point amount (e.g. $20.15 is represented as 20.15; and 12357 Bahraini Dinar is represented as 12.357)
     * @param cc the {@link CurrencyCode} of the amount
     * @return a formatted String representation of the amount, e.g. "20.15"; note this is without the currency symbol or code
     */
    String formatMonetaryAmount(BigDecimal amount, CurrencyCode cc);
}
