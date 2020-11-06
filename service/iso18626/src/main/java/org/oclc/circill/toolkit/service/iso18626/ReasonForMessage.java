/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

/**
 * A code defining the reason for the message.
 */
@SuppressWarnings("java:S115")
public enum ReasonForMessage { RequestResponse, StatusRequestResponse, RenewResponse, CancelResponse, StatusChange, Notification; }
