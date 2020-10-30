/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A message cache that uses a {@link List} to store the messages; new messages are added to the front of the list.
 */
public class FixedLengthMessageCache implements MessageCache {

    private static final int DEFAULT_SIZE = 100;

    /** The message store. */
    protected List<MessageCacheEntry> cacheArray = new ArrayList<>();

    /** The size of the message store. */
    protected int capacity = DEFAULT_SIZE;

    @Override
    public Integer getCount() {
        return cacheArray.size();
    }

    @Override
    public void add(final String message) {
        final MessageCacheEntry messageCacheEntry = new MessageCacheEntry(message);
        cacheArray.add(0, messageCacheEntry);
        final int excess = cacheArray.size() - capacity;
        if (excess > 0) {
            cacheArray.subList(cacheArray.size() - excess, cacheArray.size()).clear();
        }
    }

    @Override
    public List<MessageCacheEntry> getAll() {
        return Collections.unmodifiableList(cacheArray);
    }

    @Override
    public void removeAll() {
        cacheArray.clear();
    }

    @Override
    public void setCapacity(final int newCapacity) {
        final int excess = cacheArray.size() - newCapacity;
        if (excess > 0) {
            cacheArray.subList(cacheArray.size() - excess, cacheArray.size()).clear();
        }
        capacity = newCapacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
