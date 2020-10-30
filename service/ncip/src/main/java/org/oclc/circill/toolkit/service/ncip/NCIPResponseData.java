/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ServiceResponseData;

import java.util.List;

/**
 * Tagging interface for NCIP Response Data objects.
 */
public interface NCIPResponseData extends ServiceResponseData, NCIPData {

    List<Problem> getProblems();

}
