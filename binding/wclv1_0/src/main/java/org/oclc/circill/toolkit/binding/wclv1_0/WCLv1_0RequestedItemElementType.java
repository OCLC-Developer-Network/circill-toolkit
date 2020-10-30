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

public class WCLv1_0RequestedItemElementType extends SortField {

    private static final Logger LOG = Logger.getLogger(WCLv1_0RequestedItemElementType.class);

    public WCLv1_0RequestedItemElementType(final String scheme, final String value) {
        super(scheme, value);
    }

    /**
     * Find the WCLv1_0RequestedItemElementType that matches the scheme &amp; value strings supplied.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme.
     * @return an WCLv1_0RequestedItemElementType that matches, or null if none is found to match.
     * @throws ConfigurationException if the Toolkit is not configured properly
     * @throws ToolkitInternalException if there is an unexpected condition
     */
    public static WCLv1_0RequestedItemElementType find(final String scheme, final String value) throws ConfigurationException, ToolkitInternalException {
        return (WCLv1_0RequestedItemElementType) find(scheme, value, WCLv1_0RequestedItemElementType.class);
    }

    public static final String VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE = "http://worldcat.org/ncip/schemes/v2/extensions/requesteditemelementtype.scm";

    /** This identifies the sub-element named ItemId in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType ITEM_ID = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Item Id");

    /** This identifies the sub-element named RequestId in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType REQUEST_ID = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Request Id");

    /** This identifies the sub-element named RequestType in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType REQUEST_TYPE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Request Type");

    /** This identifies the sub-element named RequestStatusType in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType REQUEST_STATUS_TYPE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Request Status Type");

    /** This identifies the sub-element named DatePlaced in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType DATE_PLACED = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Date Placed");

    /** This identifies the sub-element named PickupDate in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType PICKUP_DATE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Pickup Date");

    /** This identifies the sub-element named PickupLocation in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType PICKUP_LOCATION = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Pickup Location");

    /** This identifies the sub-element named PickupExpiryDate in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType PICKUP_EXPIRY_DATE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Pickup Expiry Date");

    /** This identifies the sub-element named ReminderLevel in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType REMINDER_LEVEL = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Reminder Level");

    /** This identifies the sub-element named HoldQueuePosition in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType HOLD_QUEUE_POSITION = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Hold Queue Position");

    /** This identifies the sub-element named BibliographicDescription in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType BIBLIOGRAPHIC_DESCRIPTION = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE,
        "Bibliographic Description");

    /** This identifies the sub-element named BibliographicRecordId in the RequestedItem /Ext/BibliographicDescription element. */
    public static final WCLv1_0RequestedItemElementType BIBLIOGRAPHIC_RECORD_ID = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE,
        "Bibliographic Record Id");

    /** This identifies the sub-element named MediumType in the RequestedItem /Ext/BibliographicDescription element. */
    public static final WCLv1_0RequestedItemElementType MEDIUM_TYPE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Medium Type");

    /** This identifies the sub-element named Author in the RequestedItem /Ext/BibliographicDescription element. */
    public static final WCLv1_0RequestedItemElementType AUTHOR = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Author");

    /** This identifies the sub-element named Edition in the RequestedItem /Ext/BibliographicDescription element. */
    public static final WCLv1_0RequestedItemElementType EDITION = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Edition");

    /** This identifies the sub-element named PublicationDate in the RequestedItem /Ext/BibliographicDescription element. */
    public static final WCLv1_0RequestedItemElementType PUBLICATION_DATE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Publication Date");

    /** This identifies the sub-element named Language in the RequestedItem /Ext/BibliographicDescription element. */
    public static final WCLv1_0RequestedItemElementType LANGUAGE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Language");

    /** This identifies the sub-element named Publisher in the RequestedItem /Ext/BibliographicDescription element. */
    public static final WCLv1_0RequestedItemElementType PUBLISHER = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Publisher");

    /** This identifies the sub-element named HoldQueueLength in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType HOLD_QUEUE_LENGTH = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Hold Queue Length");

    /** This identifies the sub-element named EarliestDateNeeded in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType EARLIEST_DATE_NEEDED = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE,
        "Earliest Date Needed");

    /** This identifies the sub-element named NeedBeforeDate in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType NEED_BEFORE_DATE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Need Before Date");

    /** This identifies the sub-element named SuspensionStartDate in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType SUSPENSION_START_DATE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE,
        "Suspension Start Date");

    /** This identifies the sub-element named SuspensionEndDate in the RequestedItem element. */
    public static final WCLv1_0RequestedItemElementType SUSPENSION_END_DATE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Suspension End Date");

    /** This identifies the sub-element named Title in the RequestedItem/Ext/BibliographicDescription element. */
    public static final WCLv1_0RequestedItemElementType TITLE = new WCLv1_0RequestedItemElementType(VERSION_1_WCL_REQUESTED_ITEM_ELEMENT_TYPE, "Title");

    public static void loadAll() {
        LOG.debug("Loading WCLv1_0LoanedItemElementType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

}
