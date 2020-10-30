/*
 * Copyright (c) 2018 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods used by Service package classes.
 */
public final class ServiceHelper {

    /**
     * This utility class does not allow instances.
     */
    private ServiceHelper() {
    }

    public static <T> List<T> setList(final List<T> list, final T newEntry) {
        final List<T> resultList;
        if (list != null) {
            list.clear();
        }
        if (newEntry != null) {
            if (list == null) {
                resultList = new ArrayList<>();
            } else {
                resultList = list;
            }
            resultList.add(newEntry);
        } else {
            resultList = null;
        }
        return resultList;
    }

}
