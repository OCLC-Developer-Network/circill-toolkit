/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

/**
 * Type of error; see 4.10 of ISO 18626:2017.
 */
@SuppressWarnings("java:S115")
public enum ErrorType {UnsupportedActionType, UnsupportedReasonForMessageType, UnrecognisedDataElement, UnrecognisedDataValue, BadlyFormedMessage}
