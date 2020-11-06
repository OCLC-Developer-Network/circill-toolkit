/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.ncip.BibliographicDescription;
import org.oclc.circill.toolkit.service.ncip.BibliographicRecordId;
import org.oclc.circill.toolkit.service.ncip.CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.HoldingsInformation;
import org.oclc.circill.toolkit.service.ncip.ItemDescription;
import org.oclc.circill.toolkit.service.ncip.ItemOptionalFields;
import org.oclc.circill.toolkit.service.ncip.Language;
import org.oclc.circill.toolkit.service.ncip.Version1CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.Version1Language;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;

public final class DummyDatabase {

    private static final Logger LOG = Logger.getLogger(DummyDatabase.class);

    private static final int RENEWAL_PERIOD = 14;
    private static final int MAX_RENEWALS = 3;
    private static final int DEFAULT_PICKUP_EXPIRY_INTERVAL = 7;
    private static final int TWENTY_DAYS = 20;
    private static final int THIRTY_FIVE_DAYS = 35;
    private static final int FOURTY_DAYS = 40;

    /**
     * This utility class does not allow instances.
     */
    private DummyDatabase() {
    }

    /**
     * This enumeration represents the Circulation Statuses in this ILS.
     */
    public enum CircStatus {
        /**
         * The item is on order, i.e. in acquisitions and not available for circulation.
         */
        ON_ORDER,
        /**
         * The item is on the shelf, i.e. available for circulation.
         */
        ON_SHELF,
        /**
         * The item is checked-out, i.e.e not available for circulation, possibly overdue.
         */
        CHECKED_OUT,
        /**
         * The item is in-transit between library locations and not available for circulation.
         */
        IN_TRANSIT
    }

    public enum HoldStatus {
        ON_HOLD, ON_SHELF
    }

    public enum RenewErrorCode {

        NOT_RENEWABLE, MAX_RENEWALS_EXCEEDED, ITEM_ON_HOLD, USER_BLOCKED, GENERAL_POLICY_PROBLEM, REQUIRES_APPROVAL

    }

    public enum MediaTypeEnum {
        BOOK, AUDIO_TAPE, CD, DVD, MAGAZINE
    }

    protected static class RequestInfo {

        protected static final Map<String, RequestInfo> REQUEST_INFOS = new HashMap<>();
        protected static final Map<String, List<RequestInfo>> REQUESTED_ITEMS_BY_ITEM_BARCODE = new HashMap<>();
        protected static final Map<String, List<RequestInfo>> REQUESTED_ITEMS_BY_USER_NO = new HashMap<>();

        protected static void insertIntoRequestInfoList(final Map<String, List<RequestInfo>> map, final String key, final RequestInfo requestInfo) {

            List<RequestInfo> list = map.get(key);
            if (list != null) {

                list.add(requestInfo);

            } else {

                list = new ArrayList<>();
                list.add(requestInfo);
                map.put(key, list);

            }
        }

        protected String requestNo;
        protected String userNo;
        protected String itemBarcode;
        protected GregorianCalendar createDate;
        protected String pickupLoc;
        protected GregorianCalendar pickupStart;
        protected GregorianCalendar pickupEnd;
        protected int itemAvailableCount;
        protected HoldStatus status;

        public RequestInfo(final String requestNo, final String userNo, final String itemBarcode, final String pickupLoc, final HoldStatus status) throws ServiceException {

            if (userNo == null) {

                throw new ServiceException("User number must not be null in call to RequestInfo constructor.");

            }
            if (itemBarcode == null) {

                throw new ServiceException("Item barcode must not be null in call to RequestInfo constructor.");

            }

            final String requestNoToUse;
            if (requestNo == null || requestNo.isEmpty()) {
                requestNoToUse = getNextRequestNo();
            } else {
                requestNoToUse = requestNo;
            }

            this.requestNo = requestNoToUse;
            this.userNo = userNo;
            this.itemBarcode = itemBarcode;
            this.pickupLoc = pickupLoc;
            this.status = status;

            this.createDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));

            // These are set when the request is filled.
            this.pickupStart = null;
            this.pickupEnd = null;
            this.itemAvailableCount = 0;

            REQUEST_INFOS.put(requestNoToUse, this);
            insertIntoRequestInfoList(REQUESTED_ITEMS_BY_ITEM_BARCODE, this.itemBarcode, this);
            insertIntoRequestInfoList(REQUESTED_ITEMS_BY_USER_NO, this.userNo, this);
        }

        public static RequestInfo getByRequestNo(final String requestNo) {

            return REQUEST_INFOS.get(requestNo);

        }

        public static List<RequestInfo> getByUserNo(final String userNo) {

            return REQUESTED_ITEMS_BY_USER_NO.get(userNo);

        }

        public int getQueuePosition() {

            int queuePosition = 0;
            // Queue position zero means the hold is awaiting pickup, i.e. it's the first one in this list.
            for (final RequestInfo requestInfo : REQUESTED_ITEMS_BY_ITEM_BARCODE.get(this.itemBarcode)) {

                if (requestInfo.requestNo.compareToIgnoreCase(this.requestNo) == 0) {

                    break;
                }

                queuePosition++;

            }

            return queuePosition;

        }

        public void fill() {

            this.pickupStart = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
            this.pickupEnd = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
            this.pickupEnd.add(Calendar.DAY_OF_YEAR, DEFAULT_PICKUP_EXPIRY_INTERVAL);
            // Pretend we sent the "Your item is available" notice
            this.itemAvailableCount = 1;

        }

    }

    protected static class UserInfo {

        protected static final Map<String, UserInfo> USER_INFOS = new HashMap<>();

        protected final String userNo;

        public UserInfo(final String userNo) {

            this.userNo = userNo;
            USER_INFOS.put(userNo, this);

        }

        public static UserInfo getByUserNo(final String userNo) {
            return USER_INFOS.get(userNo);
        }

    }

    protected static class BibInfo {

        protected static final Map<String, BibInfo> BIB_INFOS = new HashMap<>();
        protected static final Map<String, List<BibInfo>> BIBS_BY_OCLC_NO = new HashMap<>();

        protected static void insertIntoBibInfoList(final Map<String, List<BibInfo>> map, final String key, final BibInfo bibInfo) {

            List<BibInfo> list = map.get(key);
            if (list != null) {

                list.add(bibInfo);

            } else {

                list = new ArrayList<>();
                list.add(bibInfo);
                map.put(key, list);

            }
        }

        protected final String bibNo;
        protected final String title;
        protected final String author;
        protected final String publisher;
        protected final String edition;
        protected final String pubDate;
        protected final String language;
        protected final String oclcNo;
        protected final MediaTypeEnum mediaType;
        protected HoldingInfo[] holdings;

        @SuppressWarnings("java:S107")
        public BibInfo(final String bibNo, final String title, final String author, final String publisher, final String edition, final String pubDate, final String language,
            final String oclcNo, final MediaTypeEnum mediaType) {

            this.bibNo = bibNo;
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.edition = edition;
            this.pubDate = pubDate;
            this.language = language;
            this.oclcNo = oclcNo;
            this.mediaType = mediaType;
            BIB_INFOS.put(bibNo, this);
            insertIntoBibInfoList(BIBS_BY_OCLC_NO, this.oclcNo, this);

        }

        public void addHolding(final HoldingInfo holding) {
            if (this.holdings == null) {
                this.holdings = new HoldingInfo[1];
                this.holdings[0] = holding;
            } else {
                final int originalLength = this.holdings.length;
                this.holdings = Arrays.copyOf(this.holdings, this.holdings.length + 1);
                this.holdings[originalLength] = holding;
            }
        }

        public static BibInfo getByBibNo(final String bibNo) {
            return BIB_INFOS.get(bibNo);
        }

        public static List<BibInfo> getBibsByOCLCNo(final String oclcNo) {
            return BIBS_BY_OCLC_NO.get(oclcNo);
        }
    }

    protected static class HoldingInfo {

        protected static final Map<String, HoldingInfo> HOLDING_INFOS = new HashMap<>();
        protected static final Map<String, HoldingInfo> HOLDING_INFOS_BY_ITEM_BARCODE = new HashMap<>();

        protected final String holdingId;
        protected final BibInfo bibInfo;
        protected final String location;
        protected final String summaryHoldings;
        protected ItemInfo[] items;

        public HoldingInfo(final String holdingId, final BibInfo bibInfo, final String location, final String summaryHoldings) {

            this.holdingId = holdingId;
            this.bibInfo = bibInfo;
            bibInfo.addHolding(this);
            this.location = location;
            this.summaryHoldings = summaryHoldings;
            HOLDING_INFOS.put(holdingId, this);

        }

        public void addItem(final ItemInfo itemInfo) {
            if (items == null) {
                this.items = new ItemInfo[1];
                this.items[0] = itemInfo;
            } else {
                final int originalLength = this.items.length;
                this.items = Arrays.copyOf(this.items, this.items.length + 1);
                this.items[originalLength] = itemInfo;
            }
            HOLDING_INFOS_BY_ITEM_BARCODE.put(itemInfo.barcode, this);

        }

        public static HoldingInfo getByHoldingId(final String holdingId) {
            return HOLDING_INFOS.get(holdingId);
        }

        public static HoldingInfo getByItemBarcode(final String barcode) {
            return HOLDING_INFOS_BY_ITEM_BARCODE.get(barcode);
        }
    }

    protected static final Map<String, ItemInfo> ITEM_INFOS = new HashMap<>();
    protected static class ItemInfo {

        protected static Map<String, BibInfo> bibByItemBarcode = new HashMap<>();
        protected static Map<String, HoldingInfo> holdingByItemBarcode = new HashMap<>();
        protected static final Map<String, List<ItemInfo>> CHARGED_ITEMS_BY_USER_NO = new HashMap<>();

        protected static void insertIntoItemInfoList(final Map<String, List<ItemInfo>> map, final String key, final ItemInfo itemInfo) {

            List<ItemInfo> list = map.get(key);
            if (list != null) {

                list.add(itemInfo);

            } else {

                list = new ArrayList<>();
                list.add(itemInfo);
                map.put(key, list);

            }
        }

        protected static void removeFromItemInfoList(final Map<String, List<ItemInfo>> map, final String key, final ItemInfo itemInfo) {

            final List<ItemInfo> itemList = map.get(key);
            if (itemList != null) {

                if (!itemList.remove(itemInfo)) {

                    LOG.error("(removeFromItemInfoList) Item " + itemInfo.barcode + " was not in the list.");

                } // else - this is the expected case.

            } else {

                LOG.error("(removeFromItemInfoList) Key " + key + " is not in the map.");

            }

        }

        protected final String barcode;
        protected final HoldingInfo holdingInfo;
        protected final String callNo;
        protected final String copyNo;
        protected CircStatus circStatus = CircStatus.ON_SHELF;
        protected String userNo;
        protected ZonedDateTime checkoutDate;
        protected ZonedDateTime dateDue;
        protected ZonedDateTime dateRenewed;
        protected int overdueReminderCount;
        protected int renewalCount;
        protected boolean renewRequiresApproval = false;

        public ItemInfo(final String barcode, final HoldingInfo holdingInfo, final String callNo, final String copyNo) {

            this.barcode = barcode;
            this.holdingInfo = holdingInfo;
            holdingInfo.addItem(this);
            this.callNo = callNo;
            this.copyNo = copyNo;
        }

        public void checkout(final String userNo, final ZonedDateTime dateDue) {

            if (userNo == null) {
                throw new IllegalArgumentException("userNo parameter must not be null.");
            }
            if (this.userNo != null) {
                throw new IllegalArgumentException("this.userNo must be null.");
            }

            this.circStatus = CircStatus.CHECKED_OUT;
            this.userNo = userNo;
            this.dateDue = dateDue;
            this.overdueReminderCount = 0;
            this.renewalCount = 0;
            this.checkoutDate = ZonedDateTime.now(ZoneId.of("UTC"));
            insertIntoItemInfoList(CHARGED_ITEMS_BY_USER_NO, this.userNo, this);

        }

        public void sendOverdueReminder() {

            overdueReminderCount++;
            // No reminder is actually sent - this is a dummy ILS.

        }

        public RenewErrorCode renew() {

            RenewErrorCode result = null;
            if (this.renewRequiresApproval) {
                result = RenewErrorCode.REQUIRES_APPROVAL;
            } else if (this.renewalCount < MAX_RENEWALS) {

                this.renewalCount++;
                this.dateRenewed = ZonedDateTime.now(ZoneId.of("UTC"));
                this.dateDue = this.dateDue.plus(RENEWAL_PERIOD, ChronoUnit.DAYS);

            } else {

                result = RenewErrorCode.MAX_RENEWALS_EXCEEDED;

            }

            return result;

        }

        public void setRenewRequiresApproval() {
            this.renewRequiresApproval = true;
        }

        public void checkin() {

            removeFromItemInfoList(CHARGED_ITEMS_BY_USER_NO, this.userNo, this);
            this.circStatus = CircStatus.ON_SHELF;
            this.userNo = null;
            this.dateDue = null;
            this.checkoutDate = null;
            this.dateRenewed = null;
            this.overdueReminderCount = 0;

        }

        public RequestInfo placeOnHold(final String requestNo, final String userNo, final String pickupLoc) throws ToolkitException {

            final RequestInfo requestInfo = new RequestInfo(requestNo, userNo, this.barcode, pickupLoc, HoldStatus.ON_HOLD);
            return requestInfo;

        }

        public static ItemInfo getByBarcode(final String barcode) {

            return ITEM_INFOS.get(barcode);

        }

        public static List<ItemInfo> getChargedItemsByUserNo(final String userNo) {

            return CHARGED_ITEMS_BY_USER_NO.get(userNo);

        }

    }

    protected static int nextRequestId = RandomUtils.nextInt();
    protected static final ZonedDateTime TODAY_PLUS_20_DAYS = ZonedDateTime.now(ZoneId.of("UTC")).plusDays(TWENTY_DAYS);
    protected static final ZonedDateTime TODAY_PLUS_35_DAYS = ZonedDateTime.now(ZoneId.of("UTC")).plusDays(THIRTY_FIVE_DAYS);
    protected static final ZonedDateTime TODAY_PLUS_40_DAYS = ZonedDateTime.now(ZoneId.of("UTC")).plusDays(FOURTY_DAYS);

    /**
     * Load the "database" (via static inializers).
     */
    public static void load() {
        // Just invoke static initiatlizers.
    }

    static {

        try {

            final UserInfo userMeganRichards = new UserInfo("760ecd7d-3e17-4433-e040-ae843b716ecd");
            final UserInfo userABC = new UserInfo("abc");
            final UserInfo userDEF = new UserInfo("def");
            new UserInfo("NoItemsCharged");
            final UserInfo userRenewRequestWillGoToPending = new UserInfo("RenewWillGoToPending");

            final BibInfo bib123 = new BibInfo("123", "Of Mice and Men", "Steinway", "Odd Books, Old York", "1st", "1967", "eng", "987", MediaTypeEnum.BOOK);

            final HoldingInfo holdingInfo123_1 = new HoldingInfo("bib123-1", bib123, "Main", "2 copies");

            final ItemInfo itemInfo123_1_1 = new ItemInfo("25556192919132", holdingInfo123_1, "813.52 St34yV c.1", "copy 1");
            ITEM_INFOS.put("25556192919132", itemInfo123_1_1);

            itemInfo123_1_1.checkout(userABC.userNo, TODAY_PLUS_20_DAYS);

            final ItemInfo itemInfo123_1_2 = new ItemInfo("25556192919198", holdingInfo123_1, "813.52 St34yV c.2", "copy 2");
            ITEM_INFOS.put("25556192919198", itemInfo123_1_2);

            itemInfo123_1_2.checkout(userMeganRichards.userNo, TODAY_PLUS_20_DAYS);

            final BibInfo bib345 = new BibInfo("345", "The Mouse That Roared", "Rodent, Rodney", "Dog-eared Press, Chicago", "7th expanded", "1907", "eng", "765",
                MediaTypeEnum.BOOK);

            final HoldingInfo holdingInfo345_1 = new HoldingInfo("bib345-1", bib345, "Law", "1 copy");

            final ItemInfo itemInfo345_1_1 = new ItemInfo("25556192919171", holdingInfo345_1, "813.52 St34yV c.1", "copy 1");
            ITEM_INFOS.put("25556192919171", itemInfo345_1_1);

            itemInfo345_1_1.checkout(userMeganRichards.userNo, TODAY_PLUS_40_DAYS);
            itemInfo345_1_1.renew();

            final BibInfo bib567 = new BibInfo("567", "Sense and Non-sense", "Merlot-Pouley", "Hieronymous Bach, Sheffield", "1st", "2012", "eng", "543", MediaTypeEnum.BOOK);

            final HoldingInfo holdingInfo567_1 = new HoldingInfo("bib567-1", bib567, "Main", "2 copies");

            final ItemInfo itemInfo567_1_1 = new ItemInfo("25556119105917", holdingInfo567_1, "113.52 St34yV c.1", "copy 1");
            ITEM_INFOS.put("25556119105917", itemInfo567_1_1);

            itemInfo567_1_1.checkout(userABC.userNo, TODAY_PLUS_40_DAYS);
            itemInfo567_1_1.renew();
            final RequestInfo requestInfo567_1_1 = itemInfo567_1_1.placeOnHold("1239", userDEF.userNo, "Main Circ Desk");
            // Backdate the request
            requestInfo567_1_1.createDate.add(Calendar.DAY_OF_YEAR, 10);
            requestInfo567_1_1.fill();

            final ItemInfo itemInfo567_1_2 = new ItemInfo("25559171261518", holdingInfo567_1, "113.52 St34yV c.2", "copy 2");
            ITEM_INFOS.put("25559171261518", itemInfo567_1_2);

            itemInfo567_1_2.checkout(userDEF.userNo, TODAY_PLUS_35_DAYS);
            final RequestInfo requestInfo567_1_2_7891 = itemInfo567_1_2.placeOnHold("7891", userABC.userNo, "Main Circ Desk");
            // Backdate the request
            requestInfo567_1_2_7891.createDate.add(Calendar.DAY_OF_YEAR, 10);

            final RequestInfo requestInfo567_1_2_8917 = itemInfo567_1_2.placeOnHold("8917", userMeganRichards.userNo, "South Side Branch");
            // Backdate the request
            requestInfo567_1_2_8917.createDate.add(Calendar.DAY_OF_YEAR, 10);

            final BibInfo bib789 = new BibInfo("789", "Easy Money", "Jones, Edward", "Vanity Publishers, Corning, NY.", "8th", "1990", "eng", "321", MediaTypeEnum.BOOK);

            final HoldingInfo holdingInfo789_1 = new HoldingInfo("bib789-1", bib789, "Econ", "");

            final ItemInfo itemInfo_789_1_1 = new ItemInfo("25556819818614", holdingInfo789_1, "918.1 XH c.1", "copy 1");
            ITEM_INFOS.put("25556819818614", itemInfo_789_1_1);

            final BibInfo bibFor981 = new BibInfo("981", "Impending Doom", "Daley", "Chicago Historical Society, Chicago", "1st", "2009", "eng", "2928187321", MediaTypeEnum.BOOK);

            final HoldingInfo holdingInfo981_1 = new HoldingInfo("bib981-1", bibFor981, "Main", "1 copy");

            final ItemInfo itemInfo981_1_1 = new ItemInfo("109283091823098123", holdingInfo981_1, "423.01 DBY c.1", "copy 1");
            ITEM_INFOS.put("109283091823098123", itemInfo981_1_1);

            itemInfo981_1_1.checkout(userRenewRequestWillGoToPending.userNo, TODAY_PLUS_20_DAYS);
            itemInfo981_1_1.setRenewRequiresApproval();

        } catch (ToolkitException e) {

            throw new ExceptionInInitializerError(e);

        }

    }

    public static synchronized String getNextRequestNo() {

        return Integer.toString(nextRequestId++);

    }

    /**
     * Populate the "database" with an item.
     * @param dummySvcMgr the remote service manager
     * @param bibInfo bibliographic info
     * @param holdingInfo holdings info
     * @param itemInfo item info
     * @return the {@link ItemOptionalFields}
     * @throws ToolkitInternalException if there is an unexpected error in the Toolkit
     * @throws ConfigurationException if the Toolkit is not properly configured
     */
    public static ItemOptionalFields populateItemOptionalFields(final DummyRemoteServiceManager dummySvcMgr, final BibInfo bibInfo, final HoldingInfo holdingInfo,
        final ItemInfo itemInfo) throws ToolkitInternalException, ConfigurationException {

        final BibliographicDescription bibDesc = new BibliographicDescription();
        bibDesc.setTitle(bibInfo.title);

        final BibliographicRecordId bibliographicRecordId = new BibliographicRecordId();
        bibliographicRecordId.setBibliographicRecordIdentifier(bibInfo.bibNo);
        final AgencyId agencyId = new AgencyId(dummySvcMgr.getLibraryName());
        bibliographicRecordId.setAgencyId(agencyId);
        final List<BibliographicRecordId> bibRecordIds = new ArrayList<>();
        bibRecordIds.add(bibliographicRecordId);
        bibDesc.setBibliographicRecordIds(bibRecordIds);

        final Language language = Language.find(Version1Language.VERSION_1_LANGUAGE, bibInfo.language);
        bibDesc.setLanguage(language);

        // Item information
        final CircStatus ilsCircStatus = itemInfo.circStatus;

        // Map from the Dummy ILS's circulation status values to the Scheme Value Pair used in NCIP.
        final CirculationStatus circStatus;
        switch (ilsCircStatus) {
        case ON_ORDER:
            circStatus = Version1CirculationStatus.IN_PROCESS;
            break;
        case ON_SHELF:
            circStatus = Version1CirculationStatus.AVAILABLE_ON_SHELF;
            break;
        case CHECKED_OUT:
            circStatus = Version1CirculationStatus.ON_LOAN;
            break;
        case IN_TRANSIT:
            circStatus = Version1CirculationStatus.IN_TRANSIT_BETWEEN_LIBRARY_LOCATIONS;
            break;
        default:
            circStatus = Version1CirculationStatus.CIRCULATION_STATUS_UNDEFINED;
            break;
        }

        // Item Description
        final ItemDescription itemDescription = new ItemDescription();
        itemDescription.setCallNumber(itemInfo.callNo);

        if (holdingInfo != null) {

            final HoldingsInformation holdingsInfo = new HoldingsInformation();
            holdingsInfo.setUnstructuredHoldingsData(holdingInfo.summaryHoldings);
            itemDescription.setHoldingsInformation(holdingsInfo);

        }

        itemDescription.setNumberOfPieces(BigDecimal.ONE);

        final ItemOptionalFields itemOptionalFields = new ItemOptionalFields();
        itemOptionalFields.setBibliographicDescription(bibDesc);
        itemOptionalFields.setCirculationStatus(circStatus);
        itemOptionalFields.setItemDescription(itemDescription);

        return itemOptionalFields;

    }

}
