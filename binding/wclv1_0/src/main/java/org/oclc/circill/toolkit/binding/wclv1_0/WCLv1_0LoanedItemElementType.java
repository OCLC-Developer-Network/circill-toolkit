/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.SortField;

import org.apache.log4j.Logger;

public class WCLv1_0LoanedItemElementType extends SortField {

    private static final Logger LOG = Logger.getLogger(WCLv1_0LoanedItemElementType.class);

    public WCLv1_0LoanedItemElementType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the WCLv1_0LoanedItemElementType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an WCLv1_0LoanedItemElementType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static WCLv1_0LoanedItemElementType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (WCLv1_0LoanedItemElementType) find(scheme, value, WCLv1_0LoanedItemElementType.class);
    }

    public static final String VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE = "http://worldcat.org/ncip/schemes/v2/extensions/loaneditemelementtype.scm";

    /** This identifies the sub-element named "ItemId" in the LoanedItem element. */
    public static final WCLv1_0LoanedItemElementType ITEM_ID = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Item Id");
    /** This identifies the sub-element named "ReminderLevel" in the LoanedItem element. */
    public static final WCLv1_0LoanedItemElementType REMINDER_LEVEL = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Reminder Level");
    /** This identifies the sub-element named "DateDue" in the LoanedItem element. If a LoanedItem element has an IndeterminateLoanPeriodFlag instead of a DateDue element, they
     * should sort later, chronologically, than all other LoanedItem elements. "Later" could mean before or after depending on whether the sort is ascending or descending. */
    public static final WCLv1_0LoanedItemElementType DATE_DUE = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Date Due");
    /** This identifies the sub-element named "Amount" in the LoanedItem element. */
    public static final WCLv1_0LoanedItemElementType AMOUNT = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Amount");
    /** This identifies the sub-element named "Title" in the LoanedItem/Ext/BibliographicDescription element or the immediately within the LoanedItem element if the former is
     * not present. */
    public static final WCLv1_0LoanedItemElementType TITLE = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Title");
    /** This identifies the sub-element named "MediumType" in the LoanedItem or the LoanedItem/Ext/BibliographicDescription element. */
    public static final WCLv1_0LoanedItemElementType MEDIUM_TYPE = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Medium Type");
    /** This identifies the sub-element named "RenewalCount" in the LoanedItem/Ext element. */
    public static final WCLv1_0LoanedItemElementType RENEWAL_COUNT = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Renewal Count");
    /** This identifies the sub-element named "DateCheckedOut" in the LoanedItem/Ext element. */
    public static final WCLv1_0LoanedItemElementType DATE_CHECKED_OUT = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Date Checked Out");
    /** This identifies the sub-element named "BibliographicRecordId" in the LoanedItem/Ext/BibliographicDescription element. */
    public static final WCLv1_0LoanedItemElementType BIBLIOGRAPHIC_RECORD_ID = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Bibliographic Record Id");
    /** This identifies the sub-element named "Author" in the LoanedItem/Ext/BibliographicDescription element. */
    public static final WCLv1_0LoanedItemElementType AUTHOR = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Author");
    /** This identifies the sub-element named "Edition" in the LoanedItem/Ext/BibliographicDescription element. */
    public static final WCLv1_0LoanedItemElementType EDITION = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Edition");
    /** This identifies the sub-element named "PublicationDate" in the LoanedItem/Ext/BibliographicDescription element. */
    public static final WCLv1_0LoanedItemElementType PUBLICATION_DATE = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Publication Date");
    /** This identifies the sub-element named "Language" in the LoanedItem/Ext/BibliographicDescription element. */
    public static final WCLv1_0LoanedItemElementType LANGUAGE = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Language");
    /** This identifies the sub-element named "Publisher" in the LoanedItem/Ext/BibliographicDescription element. */
    public static final WCLv1_0LoanedItemElementType PUBLISHER = new WCLv1_0LoanedItemElementType(VERSION_1_WCL_LOANED_ITEM_ELEMENT_TYPE, "Publisher");

    public static void loadAll() {
        LOG.debug("Loading WCLv1_0LoanedItemElementType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

}
