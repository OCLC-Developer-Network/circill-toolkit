/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy.web;

import org.oclc.circill.toolkit.dummy.ConfigurableService;
import org.oclc.circill.toolkit.dummy.ConfigurableServiceHandler;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.iso18626.ConfirmationHeader;
import org.oclc.circill.toolkit.service.iso18626.ErrorData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;
import org.oclc.circill.toolkit.service.iso18626.MessageStatus;

import java.util.List;

/**
 * Defines additional methods for scripts used by the {@link ConfigurableService} can implement to support
 * configuration at run time.
 */
public interface DynamicConfigurableServiceHandler extends ConfigurableServiceHandler {

    /**
     * Returns a list of descriptions of the options offered by this handler, e.g. “Return UnsupportedAction”, “Return UnrecognizedElement”, “Return OK for Request”, etc.
     * @return list of descriptions of the options
     */
    List<String> getOptions();

    /**
     * Set the active option
     * @param description a description that matches one of those returned by {@link #getOptions}
     * @throws IllegalArgumentException if the description is not in the list
     */
    void setOption(String description) throws IllegalArgumentException;

    /**
     * Returns the description of the currently-selected option.
     * @return the current option's description
     */
    String currentOption();

    @Override
    default ServiceResponseData handle(final ServiceInitiationData initiationData) {
        ServiceResponseData serviceResponseData = new ServiceResponseData() {};
        if (initiationData instanceof ISO18626RequestData) {
            try {
                final ISO18626ConfirmationData iso18626ConfirmationData =
                    (ISO18626ConfirmationData) Class.forName(initiationData.getClass().getSimpleName().replace("Data", "ConfirmationData")).getDeclaredConstructor().newInstance();
                final String currentOption = currentOption();
                final ConfirmationHeader confirmationHeader = new ConfirmationHeader();
                final ErrorData errorData = new ErrorData();
                if (currentOption.contains("OK")) {
                    confirmationHeader.setMessageStatus(MessageStatus.OK);
                } else {
                    confirmationHeader.setMessageStatus(MessageStatus.ERROR);
                    errorData.setErrorValue(currentOption);
                }
                iso18626ConfirmationData.setConfirmationHeader(confirmationHeader);
                iso18626ConfirmationData.setErrorData(errorData);
                serviceResponseData = iso18626ConfirmationData;
            } catch (Exception e) {
                //Ignore
            }
        }
        return serviceResponseData;
    }

}
