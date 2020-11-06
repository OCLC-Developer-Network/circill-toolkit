/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

/**
 * Type of service. Values: Copy, Loan or CopyOrLoan.
 * If Copy is requested, then the requesting library is interested only in a copy.
 * If Loan is requested, then the requesting library is interested only in a loan.
 * If CopyOrLoan is requested, then the requesting library is willing to accept either a copy or a loan.
 */
@SuppressWarnings("java:S115")
public enum ServiceType { Copy, Loan, CopyOrLoan; }
