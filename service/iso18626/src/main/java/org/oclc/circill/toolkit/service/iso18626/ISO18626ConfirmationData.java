/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.ServiceResponseData;

/**
 * ISO 18626 confirmation message.
 */
public interface ISO18626ConfirmationData extends ServiceResponseData, ISO18626Data {

    ConfirmationHeader getConfirmationHeader();
    void setConfirmationHeader(ConfirmationHeader confirmationHeader);
    ErrorData getErrorData();
    void setErrorData(ErrorData errorData);

}
