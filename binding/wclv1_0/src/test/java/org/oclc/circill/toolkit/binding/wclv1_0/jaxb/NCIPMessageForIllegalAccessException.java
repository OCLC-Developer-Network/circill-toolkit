/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0.jaxb;

import org.oclc.circill.toolkit.service.ncip.NCIPMessage;

/**
 * For testing.
 */
public class NCIPMessageForIllegalAccessException extends NCIPMessage {
    {
        messageType = MessageType.INITIATION;
    }

    public String invalidField;

    private String getInvalidField() {
        return invalidField;
    }

    public void setInvalidField(final String someString) {
        this.invalidField = someString;
    }

}
