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
 * Codes for {@link PreferredFormatType} defined in ISO 18626-2017 p. 20.
 */
public class Version2017PreferredFormatType extends PreferredFormatType {

    private static final Logger LOG = Logger.getLogger(Version2017PreferredFormatType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/PreferredFormatList-V1.0";

    // Blu-ray
    public static final Version2017PreferredFormatType BLU_RAY = new Version2017PreferredFormatType(SCHEME, "Blu-ray");

    // Braille
    public static final Version2017PreferredFormatType BRAILLE = new Version2017PreferredFormatType(SCHEME, "Braille");

    // Compact cassette tape
    public static final Version2017PreferredFormatType CASSETTETAPE = new Version2017PreferredFormatType(SCHEME, "CassetteTape");

    // Compact Disk
    public static final Version2017PreferredFormatType CD = new Version2017PreferredFormatType(SCHEME, "CD"); 

    // CD-ROM
    public static final Version2017PreferredFormatType CD_ROM = new Version2017PreferredFormatType(SCHEME, "CD-ROM");

    // Daisy-ROM
    public static final Version2017PreferredFormatType DAISY_ROM = new Version2017PreferredFormatType(SCHEME, "Daisy-ROM");

    // DVD disk
    public static final Version2017PreferredFormatType DVD = new Version2017PreferredFormatType(SCHEME, "DVD"); 

    // JPEG image file
    public static final Version2017PreferredFormatType JPEG = new Version2017PreferredFormatType(SCHEME, "JPEG"); 

    // Large print
    public static final Version2017PreferredFormatType LARGE_PRINT = new Version2017PreferredFormatType(SCHEME, "LargePrint");

    // Long play vinyl record
    public static final Version2017PreferredFormatType LP = new Version2017PreferredFormatType(SCHEME, "LP"); 

    // Microform
    public static final Version2017PreferredFormatType MICROFORM = new Version2017PreferredFormatType(SCHEME, "Microform");

    // MPEG-1 or MPEG-2 Audio Layer III file
    public static final Version2017PreferredFormatType MP3 = new Version2017PreferredFormatType(SCHEME, "MP3"); 

    // Combined media
    public static final Version2017PreferredFormatType MULTIMEDIA = new Version2017PreferredFormatType(SCHEME, "Multimedia");

    // Photocopy or print on pieces of paper
    public static final Version2017PreferredFormatType PAPER_COPY = new Version2017PreferredFormatType(SCHEME, "PaperCopy");

    // PDF or PDF/A file
    public static final Version2017PreferredFormatType PDF = new Version2017PreferredFormatType(SCHEME, "PDF"); 

    // Printed book, journal, etc.
    public static final Version2017PreferredFormatType PRINTED = new Version2017PreferredFormatType(SCHEME, "Printed");

    // Tape
    public static final Version2017PreferredFormatType TAPE = new Version2017PreferredFormatType(SCHEME, "Tape");

    // TIFF file
    public static final Version2017PreferredFormatType TIFF = new Version2017PreferredFormatType(SCHEME, "TIFF"); 

    // VHS
    public static final Version2017PreferredFormatType VHS = new Version2017PreferredFormatType(SCHEME, "VHS"); 

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017PreferredFormatType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017PreferredFormatType(final String scheme, final String value) {
        super(scheme, value);
    }

}
