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
 * Codes for {@link DeliveredFormatType} defined in ISO 18626-2017 p. 20.
 */
public class Version2017DeliveredFormatType extends DeliveredFormatType {

    private static final Logger LOG = Logger.getLogger(Version2017DeliveredFormatType.class);

    public static final String SCHEME
        = "http://illtransactions.org/ISO18626/OpenCodeList/DeliveredFormatList-V1.0";

    // Blu-ray
    public static final Version2017DeliveredFormatType BLU_RAY = new Version2017DeliveredFormatType(SCHEME, "Blu-ray");

    // Braille
    public static final Version2017DeliveredFormatType BRAILLE = new Version2017DeliveredFormatType(SCHEME, "Braille");

    // Compact cassette tape
    public static final Version2017DeliveredFormatType CASSETTE_TAPE = new Version2017DeliveredFormatType(SCHEME, "CassetteTape");

    // Compact Disk
    public static final Version2017DeliveredFormatType CD = new Version2017DeliveredFormatType(SCHEME, "CD");

    // CD-ROM
    public static final Version2017DeliveredFormatType CD_ROM = new Version2017DeliveredFormatType(SCHEME, "CD-ROM");

    // Daisy-ROM
    public static final Version2017DeliveredFormatType DAISY_ROM = new Version2017DeliveredFormatType(SCHEME, "Daisy-ROM");

    // DVD disk
    public static final Version2017DeliveredFormatType DVD = new Version2017DeliveredFormatType(SCHEME, "DVD");

    // JPEG image file
    public static final Version2017DeliveredFormatType JPEG = new Version2017DeliveredFormatType(SCHEME, "JPEG");

    // Large print
    public static final Version2017DeliveredFormatType LARGE_PRINT = new Version2017DeliveredFormatType(SCHEME, "LargePrint");

    // Long play vinyl record
    public static final Version2017DeliveredFormatType LP = new Version2017DeliveredFormatType(SCHEME, "LP");

    // Microform
    public static final Version2017DeliveredFormatType MICROFORM = new Version2017DeliveredFormatType(SCHEME, "Microform");

    // MPEG-1 or MPEG-2 Audio Layer III file
    public static final Version2017DeliveredFormatType MP3 = new Version2017DeliveredFormatType(SCHEME, "MP3");

    // Combined media
    public static final Version2017DeliveredFormatType MULTIMEDIA = new Version2017DeliveredFormatType(SCHEME, "Multimedia");

    // Photocopy or print on pieces of paper
    public static final Version2017DeliveredFormatType PAPER_COPY = new Version2017DeliveredFormatType(SCHEME, "PaperCopy");

    // PDF or PDF/A file
    public static final Version2017DeliveredFormatType PDF = new Version2017DeliveredFormatType(SCHEME, "PDF");

    // Printed book, journal, etc.
    public static final Version2017DeliveredFormatType PRINTED = new Version2017DeliveredFormatType(SCHEME, "Printed");

    // Tape
    public static final Version2017DeliveredFormatType TAPE = new Version2017DeliveredFormatType(SCHEME, "Tape");

    // TIFF file
    public static final Version2017DeliveredFormatType TIFF = new Version2017DeliveredFormatType(SCHEME, "TIFF");

    // VHS
    public static final Version2017DeliveredFormatType VHS = new Version2017DeliveredFormatType(SCHEME, "VHS");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017DeliveredFormatType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017DeliveredFormatType(final String scheme, final String value) {
        super(scheme, value);
    }

}
