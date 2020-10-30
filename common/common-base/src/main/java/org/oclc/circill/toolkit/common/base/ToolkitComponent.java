/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A marker interface for Toolkit components.
 * All Toolkit components are expected to use constructor injection for required properties, and setter injection for optional ones, per
 * https://spring.io/blog/2007/07/11/setter-injection-versus-constructor-injection-and-the-use-of-required/.
 */
public interface ToolkitComponent {
    String INITIATOR_COMPONENT_NAME = "InitiatorService";
    String MARSHALLER_FACTORY_COMPONENT_NAME = "MarshallerFactory";
    String MESSAGE_HANDLER_COMPONENT_NAME = "MessageHandler";
    String SERVICE_CONTEXT_FACTORY_COMPONENT_NAME = "ServiceContextFactory";
    String STATISTICS_BEAN_COMPONENT_NAME = "StatisticsBean";
    String TRANSLATOR_COMPONENT_NAME = "Translator";
    String PROTOCOL_VERSION_COMPONENT_NAME = "ProtocolVersoin";
    List<String> COMPONENT_NAMES = Collections.unmodifiableList(Arrays
        .asList(INITIATOR_COMPONENT_NAME, MARSHALLER_FACTORY_COMPONENT_NAME, MESSAGE_HANDLER_COMPONENT_NAME, SERVICE_CONTEXT_FACTORY_COMPONENT_NAME, STATISTICS_BEAN_COMPONENT_NAME,
            TRANSLATOR_COMPONENT_NAME, PROTOCOL_VERSION_COMPONENT_NAME));

    String getComponentName();
}
