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

/**
 * This class maps from a {@link SchemeValuePair} object to a String, which is used for some
 * enumerated types in Sage and DUI.
 * @param <FROM> the {@link SchemeValuePair} subclass to map from
 */
public class BaseSVPToStringMap<FROM extends SchemeValuePair> {

    private final Map<FROM, String> MAP = new HashMap<>();
    private boolean passUnmatchedValuesThru = true;

    /**
     * Construct an instance of the map.<p>
     * Note: the Toolkit has many classes that are direct subclasses of {@link org.oclc.circill.toolkit.service.base.SchemeValuePair} (e.g.
     * for MediumType), and various connectors have defined subclasses of
     * these subclasses. If you are mapping such a second-order sub-class of SchemeValuePair you should
     * use the first-order subclass of {@link org.oclc.circill.toolkit.service.base.SchemeValuePair}
     * for the fromClass parameter here to reduce the chance of run-time exceptions. But you should in any case
     * use the Scheme URI for the sub-class that has the values that you're mapping from. E.g.
     * <pre>{@code
     * BaseSVPToStringMap<MediumType> myMap = new BaseSVPToStringMap<MediumType>(MediumType.class,
     *     WCLv1_0MediumType.VERSION_1_WCL_MEDIUM_TYPE, properties);
     * }</pre><p>
     * Note: If you want to pass-thru the values of the Sage or DUI enumeration, without translation, the properties
     * parameter can be a Properties object with a single entry:
     * <pre>{@code
     * Properties props = new Properties();
     * props.put("*","*"); // The value of the second parameter doesn't matter
     * }</pre>
     * This class will set its {@link #passUnmatchedValuesThru} flag <code>true</code>, and if a value is given which
     * doesn't have a match it will pass try to use the value to construct the {@link org.oclc.circill.toolkit.service.base.SchemeValuePair} instance.
     * Of course, if you haven't set that to allow any values, and the supplied value isn't in the provided Scheme,
     * this will fail with an exception from the {@link org.oclc.circill.toolkit.service.base.SchemeValuePair#find(String, String, Class)}
     * method indicating that the value wasn't jfound in the Scheme. <p>
     * Note: Users can override the defaultSchemeURI parameter using a key with the format <code>defaultSchemeURI;value</code>, for example: <p>
     * <code>
     * http\u003A//www.niso.org/ncip/v1_0/schemes/processingerrortype/generalprocessingerror.scm;Agency\u0020Authentication\u0020Failed=AUTH_FAILED
     * </code>
     * <p>
     * If the key contains spaces, use the Unicode hexadecimal code sequence <code>&#92;u0020</code> for the space character;
     * if it contains a colon (as in the URI example) use <code>\u003A</code> for the colon character.
     *
     * @param fromClass the {@link Class} object for the {@link org.oclc.circill.toolkit.service.base.SchemeValuePair} class to be mapped.
     * @param defaultSchemeURI the default Scheme URI to define the mappings for; this can be overridden in the property file
     * @param properties a {@link java.util.Properties} object mapping the Scheme's Values to strings
     */
    public BaseSVPToStringMap(final Class<? extends SchemeValuePair> fromClass, final String defaultSchemeURI, final Properties properties) {

        for (final Map.Entry<Object, Object> entry : properties.entrySet()) {
            final String toString = (String) entry.getValue();
            if (toString != null && toString.compareTo("*") != 0) {

                final String fromString = (String) entry.getKey();
                final String scheme;
                final String value;
                if (fromString.contains(";")) {
                    final String[] svp = fromString.split(";");
                    scheme = svp[0];
                    value = svp[1];
                } else {
                    scheme = defaultSchemeURI;
                    value = fromString;
                }

                final FROM fromObject;
                try {
                    fromObject = (FROM) SchemeValuePairHelper.findSchemeValuePair(fromClass, scheme, value);
                } catch (ToolkitException e) {
                    throw new ExceptionInInitializerError(e);
                }
                MAP.put(fromObject, toString);

            } // The special meaning of '*' is handled immediately after this for loop
        }

        if (properties.size() > 0 && !properties.contains("*")) {
            passUnmatchedValuesThru = false;
        }

    }

    public String map(final FROM svp) throws MappingException {

        String toString = null;
        if (svp != null) {

            toString = MAP.get(svp);
            if (toString == null && passUnmatchedValuesThru) {
                toString = svp.getValue();
            }

        }

        return toString;

    }

}
