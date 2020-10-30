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
 * Codes for {@link PublicationType} defined in ISO 18626-2017 p. 21.
 */
public class Version2017PublicationType extends PublicationType {

    private static final Logger LOG = Logger.getLogger(Version2017PublicationType.class);

    public static final String SCHEME
            = "http://illtransactions.org/ISO18626/OpenCodeList/PublicationTypeList-V1.0";

    // Archive material
    public static final Version2017PublicationType ARCHIVE_MATERIAL = new Version2017PublicationType(SCHEME, "ArchiveMaterial");

    // Article
    public static final Version2017PublicationType ARTICLE = new Version2017PublicationType(SCHEME, "Article");

    // Audio book
    public static final Version2017PublicationType AUDIOBOOK = new Version2017PublicationType(SCHEME, "AudioBook");

    // Book
    public static final Version2017PublicationType BOOK = new Version2017PublicationType(SCHEME, "Book");

    // Chapter
    public static final Version2017PublicationType CHAPTER = new Version2017PublicationType(SCHEME, "Chapter");

    // Conference proceedings
    public static final Version2017PublicationType CONFERENCE_PROC = new Version2017PublicationType(SCHEME, "ConferenceProc");

    // Game
    public static final Version2017PublicationType GAME = new Version2017PublicationType(SCHEME, "Game");

    // Government publication
    public static final Version2017PublicationType GOVERNMENT_PUBL = new Version2017PublicationType(SCHEME, "GovernmentPubl");

    // Image
    public static final Version2017PublicationType IMAGE = new Version2017PublicationType(SCHEME, "Image");

    // Journal
    public static final Version2017PublicationType JOURNAL = new Version2017PublicationType(SCHEME, "Journal");

    // Manuscript
    public static final Version2017PublicationType MANUSCRIPT = new Version2017PublicationType(SCHEME, "Manuscript");

    // Map
    public static final Version2017PublicationType MAP = new Version2017PublicationType(SCHEME, "Map");

    // Movie
    public static final Version2017PublicationType MOVIE = new Version2017PublicationType(SCHEME, "Movie");

    // Music recording
    public static final Version2017PublicationType MUSIC_RECORDING = new Version2017PublicationType(SCHEME, "MusicRecording");

    // Music score
    public static final Version2017PublicationType MUSIC_SCORE = new Version2017PublicationType(SCHEME, "MusicScore");

    // Newspaper
    public static final Version2017PublicationType NEWSPAPER = new Version2017PublicationType(SCHEME, "Newspaper");

    // Patent
    public static final Version2017PublicationType PATENT = new Version2017PublicationType(SCHEME, "Patent");

    // Report
    public static final Version2017PublicationType REPORT = new Version2017PublicationType(SCHEME, "Report");

    // Sound recording
    public static final Version2017PublicationType SOUND_RECORDING = new Version2017PublicationType(SCHEME, "SoundRecording");

    // Thesis
    public static final Version2017PublicationType THESIS = new Version2017PublicationType(SCHEME, "Thesis");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017PublicationType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017PublicationType(final String scheme, final String value) {
        super(scheme, value);
    }

}
