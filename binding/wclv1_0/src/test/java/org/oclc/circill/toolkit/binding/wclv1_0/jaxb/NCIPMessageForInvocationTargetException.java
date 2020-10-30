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
public class NCIPMessageForInvocationTargetException extends NCIPMessage {
    {
        messageType = NCIPMessage.MessageType.INITIATION;
    }

    public String invalidField;

    public String getInvalidField() throws Throwable {
        throw new Throwable("This exception was thrown by a test class; it is by-design.");
    }

    public void setInvalidField(final String someString) {
        this.invalidField = someString;
    }

}
