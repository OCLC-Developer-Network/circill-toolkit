/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import java.time.ZonedDateTime;

/**
 * A message and the time at which it was added to the cache.
 */
public class MessageCacheEntry {
    /**
     * A MessageCacheEntry with the provided message and the timestamp set to 'now' in the default timezone.
     * @param message the message
     */
    public MessageCacheEntry(final String message) {
        timestamp = ZonedDateTime.now();
        this.message = message;
    }

    /** The date/time at which this entry was constructed. */
    private final ZonedDateTime timestamp;
    /** The message. */
    private final String message;

    /**
     * Get the date/time of this message.
     * @return the date/time
     */
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Get the message.
     * @return the message
     */
    public String getMessage() {
        return message;
    }
}
