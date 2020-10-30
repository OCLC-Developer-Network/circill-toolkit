/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.log4j.Logger;

/**
 * Codes for {@link PatronType} defined in ISO 18626-2017 p. 20.
 */
public class Version2017PatronType extends PatronType {

    private static final Logger LOG = Logger.getLogger(Version2017PatronType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/PatronTypeList-V1.0";
    
    // Adult
    public static final Version2017PatronType ADULT = new Version2017PatronType(SCHEME, "Adult");

    // Child
    public static final Version2017PatronType CHILD = new Version2017PatronType(SCHEME, "Child");

    // Faculty
    public static final Version2017PatronType FACULTY = new Version2017PatronType(SCHEME, "Faculty");

    // Graduate student
    public static final Version2017PatronType GRADUATE_STUDENT = new Version2017PatronType(SCHEME, "GraduateStudent");

    // Researcher
    public static final Version2017PatronType RESEARCHER = new Version2017PatronType(SCHEME, "Researcher");

    // Staff
    public static final Version2017PatronType STAFF = new Version2017PatronType(SCHEME, "Staff");

    // Student
    public static final Version2017PatronType STUDENT = new Version2017PatronType(SCHEME, "Student");

    // Under Graduate student
    public static final Version2017PatronType UNDERGRADUATE_STUDENT = new Version2017PatronType(SCHEME, "UnderGraduateStudent");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017PatronType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017PatronType(final String scheme, final String value) {
        super(scheme, value);
    }

}
