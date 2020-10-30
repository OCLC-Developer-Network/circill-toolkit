/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.SchemeValuePairHelper;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.dozer.MappingException;

public class BaseStringToSVPMap<TO extends SchemeValuePair> {

    private final Map<String, TO> MAP = new HashMap<>();

    /**
     * Note: This defaults to <code>true</code> to cover cases where there is no properties file.
     */
    private boolean passUnmatchedValuesThru = true;
    private final Class<? extends SchemeValuePair> toClass;
    private final String defaultSchemeURI;

    public BaseStringToSVPMap(final Class<? extends SchemeValuePair> toClass, final String defaultSchemeURI, final Properties properties) {

        this.toClass = toClass;
        this.defaultSchemeURI = defaultSchemeURI;

        for (final Map.Entry<Object, Object> entry : properties.entrySet()) {
            final String fromString = (String) entry.getKey();
            if (fromString != null && fromString.compareTo("*") != 0) {

                final String toString = (String) entry.getValue();
                final String scheme;
                final String value;
                if (toString.contains(";")) {
                    final String[] svp = toString.split(";");
                    scheme = svp[0];
                    value = svp[1];
                } else {
                    scheme = defaultSchemeURI;
                    value = toString;
                }

                final TO toObject;
                try {
                    toObject = (TO) SchemeValuePairHelper.findSchemeValuePair(toClass, scheme, value);
                } catch (ToolkitException e) {
                    throw new ExceptionInInitializerError(e);
                }
                MAP.put(fromString, toObject);

            } // The special meaning of '*' is handled immediately after this for loop

        }

        if (properties.size() > 0 && !properties.contains("*")) {
            passUnmatchedValuesThru = false;
        }

    }

    public TO map(final String fromString) throws MappingException {

        TO toObject = null;
        if (fromString != null) {

            toObject = MAP.get(fromString);
            if (toObject == null && passUnmatchedValuesThru) {

                try {

                    toObject = (TO) SchemeValuePairHelper.findSchemeValuePair(toClass, defaultSchemeURI, fromString);

                } catch (ToolkitException e) {

                    throw new MappingException(e);

                }

            }
        }

        return toObject;

    }

}
