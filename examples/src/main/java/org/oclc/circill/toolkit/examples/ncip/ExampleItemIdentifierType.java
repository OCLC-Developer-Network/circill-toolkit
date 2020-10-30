/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.examples.ncip;

import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.ncip.ItemIdentifierType;

public class ExampleItemIdentifierType extends ItemIdentifierType {
    public static final String EXAMPLE_ITEM_IDENTIFIER_TYPE = "http://www.extensiblecatalog.ncip.v2.org/schemes/itemidentifiertype/exampleitemidentifiertype.scm";

    public static final ExampleItemIdentifierType ITEM_ID = new ExampleItemIdentifierType(EXAMPLE_ITEM_IDENTIFIER_TYPE, "Item Id");

    /**
     * Load all instances of this class (so that they are available in the {@link SchemeValuePair#SCHEME_REGISTRY}.
     */
    public static void loadAll() {
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    protected ExampleItemIdentifierType(final String scheme, final String value) {
        super(scheme, value);
    }
}
