/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

/**
 * Objects supporting this interface have an associated {@link javax.servlet.ServletRequest} and are (typically)
 * intended for use within a servlet container.
 */
public interface ServletRequestAware {
    javax.servlet.ServletRequest getServletRequest();

    void setServletRequest(javax.servlet.ServletRequest servletRequest);
}
