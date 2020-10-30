/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import java.util.List;

/**
 * Cache of messages.
 */
public interface MessageCache {

    /**
     * Return the count of messages in the cache.
     * @return the count of messages in the cache
     */
    Integer getCount();

    /**
     * Add the message to the cache.
     * @param message the message
     */
    void add(String message);

    List<MessageCacheEntry> getAll();

    /**
     * Remove all messages.
     */
    void removeAll();

    void setCapacity(int capacity);

    int getCapacity();
}
