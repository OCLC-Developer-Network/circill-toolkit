/*
 * Copyright (c) 2012 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

/**
 * An object that identifies a version of a protocol.
 */
public interface ProtocolVersion extends ToolkitComponent {
    /**
     * Get the {@link ToolkitComponent} name.
     * @return the name
     */
    @Override
    default String getComponentName() {
        return ToolkitComponent.PROTOCOL_VERSION_COMPONENT_NAME;
    }
}
