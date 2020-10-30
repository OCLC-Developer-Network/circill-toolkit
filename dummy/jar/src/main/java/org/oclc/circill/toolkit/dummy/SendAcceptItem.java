/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy;

import org.oclc.circill.toolkit.common.base.ConfigurationHelper;
import org.oclc.circill.toolkit.common.base.MessageHandler;
import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.ToolkitComponent;
import org.oclc.circill.toolkit.service.base.BibliographicItemId;
import org.oclc.circill.toolkit.service.base.BibliographicItemIdentifierCode;
import org.oclc.circill.toolkit.service.base.BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.base.ConfigurationException;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.SchemeValuePairHelper;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ToolkitInternalException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.AcceptItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.BibliographicDescription;
import org.oclc.circill.toolkit.service.ncip.BibliographicLevel;
import org.oclc.circill.toolkit.service.ncip.BibliographicRecordId;
import org.oclc.circill.toolkit.service.ncip.ComponentId;
import org.oclc.circill.toolkit.service.ncip.ComponentIdentifierType;
import org.oclc.circill.toolkit.service.ncip.ElectronicDataFormatType;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.ItemOptionalFields;
import org.oclc.circill.toolkit.service.ncip.ItemUseRestrictionType;
import org.oclc.circill.toolkit.service.ncip.Language;
import org.oclc.circill.toolkit.service.ncip.MediumType;
import org.oclc.circill.toolkit.service.ncip.NCIPInitiationData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.PickupLocation;
import org.oclc.circill.toolkit.service.ncip.RequestId;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.Version1BibliographicItemIdentifierCode;
import org.oclc.circill.toolkit.service.ncip.Version1BibliographicLevel;
import org.oclc.circill.toolkit.service.ncip.Version1BibliographicRecordIdentifierCode;
import org.oclc.circill.toolkit.service.ncip.Version1ComponentIdentifierType;
import org.oclc.circill.toolkit.service.ncip.Version1ElectronicDataFormatType;
import org.oclc.circill.toolkit.service.ncip.Version1ItemUseRestrictionType;
import org.oclc.circill.toolkit.service.ncip.Version1Language;
import org.oclc.circill.toolkit.service.ncip.Version1MediumType;
import org.oclc.circill.toolkit.service.ncip.Version1RequestedActionType;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Command line utility to send a simple AcceptItem message.
 */
public class SendAcceptItem {

    private static final Logger LOG = Logger.getLogger(SendAcceptItem.class);
    protected static final int AUTHOR_INDEX = 0;
    protected static final int AUTHOR_OF_COMPONENT_INDEX = 1;
    protected static final int BIBLIOGRAPHIC_ITEM_ID_CODE_INDEX = 2;
    protected static final int BIBLIOGRAPHIC_ITEM_ID_INDEX = 3;
    protected static final int BIBLIOGRAPHIC_LEVEL_INDEX = 4;
    protected static final int BIBLIOGRAPHIC_RECORD_ID_CODE_INDEX = 5;
    protected static final int BIBLIOGRAPHIC_RECORD_ID_INDEX = 6;
    protected static final int COMPONENT_ID_TYPE_INDEX = 7;
    protected static final int COMPONENT_ID_INDEX = 8;
    protected static final int EDITION_INDEX = 9;
    protected static final int ELECTRONIC_DATA_FORMAT_TYPE_INDEX = 10;
    protected static final int LANGUAGE_INDEX = 11;
    protected static final int MEDIUM_TYPE_INDEX = 12;
    protected static final int PAGINATION_INDEX = 13;
    protected static final int PLACE_OF_PUBLICATION_INDEX = 14;
    protected static final int PUBLICATION_DATE_INDEX = 15;
    protected static final int PUBLICATION_DATE_OF_COMPONENT_INDEX = 16;
    protected static final int PUBLISHER_INDEX = 17;
    protected static final int SERIES_TITLE_NUMBER_INDEX = 18;
    protected static final int SPONSORING_BODY_INDEX = 19;
    protected static final int TITLE_INDEX = 20;
    protected static final int TITLE_OF_COMPONENT_INDEX = 21;

    protected static final String LINE_SEPARATOR = System.lineSeparator();
    private static final int AGENCY_ID_ARG = 0;
    private static final int ITEM_ID_ARG = 1;
    private static final int BIB_DESCRIPTION_ARG = 2;
    private static final int USE_RESTRICTIONS_ARG = 3;
    private static final int REQUEST_ID_ARG = 4;
    // private static final int SERVICE_TYPE_ARG = 5; not used
    private static final int USER_ID_ARG = 6;
    private static final int DUE_DATE_ARG = 7;
    private static final int PICKUP_LOCATION_ARG = 8;
    private static final int MAX_ARG_LENGTH = 9;

    protected static final String USAGE_STRING = "Usage: SendAcceptItem agencyId " + "local-item-id \\" + LINE_SEPARATOR
        + " \"author,author of component,bibliographic item id code,bibliographic item id,\\" + LINE_SEPARATOR
        + " bibliographic level,bibliographic record id code,bibliographic record id,\\" + LINE_SEPARATOR
        + " component id type,component id,edition,electronic data format type,language,medium type,\\" + LINE_SEPARATOR
        + " pagination,place of publication,publication date,publication date of component,publisher,\\" + LINE_SEPARATOR
        + " series title numnber,sponsoring body,title,title of component\"\\" + LINE_SEPARATOR
        + " \"library use only,no reproduction,supervision required,user signature required\"\\" + LINE_SEPARATOR
        + " request-id (Loan|Hold|Copy) local-user-id local-due-date [pickup-location]" + LINE_SEPARATOR
        + "Note: If the local-item-id has a slash (/) in it, the portion preceding the slash " + LINE_SEPARATOR
        + "   will be treated as the value of the agencyid, and the portion following it as the local-item-id." + LINE_SEPARATOR
        + "Note: The \"author,author of component,bibliographic item id code,bibliographic item id,..." + LINE_SEPARATOR
        + "   parameter is used to supply bibliographic information and has some special rules:" + LINE_SEPARATOR
        + "   A) You may supply none, some or all of these parameters, but they must be comma-delimited" + LINE_SEPARATOR
        + "      and there is no provision for embedded commas and it must be quoted." + LINE_SEPARATOR
        + "   B) You must put parameters in order, and use adjacent commas for omitted parameters." + LINE_SEPARATOR
        + "   C) For instance, to enter the title alone you would provide:" + LINE_SEPARATOR + "        \",,,,,,,,,,,,,,,,,,,,,A History of Cape Cod,\"" + LINE_SEPARATOR
        + "      That's 21 commas, the title, and a trailing comma." + LINE_SEPARATOR
        + "Note: For the \"library use only,no reproduction,supervision required,user signature required\"" + LINE_SEPARATOR
        + "   parameter, this is used to provide item use restrictions and similarly you may provide" + LINE_SEPARATOR
        + "   none, some or all of the values, but in this case you provide the text \"true\"" + LINE_SEPARATOR
        + "   (case is not significant) for restrictions you wish to impose." + LINE_SEPARATOR + "   To set any value other than the first you must provide the preceding ones,"
        + LINE_SEPARATOR + "   so for example to set only the \"no reproduction\" parameter you could provide only \"false,true\".";

    protected static final int NUMBER_OF_BIB_FIELDS = 22;

    protected final MessageHandler<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> messageHandler;

    /**
     * Construct an instance of {@link SendAcceptItem}.
     * @throws ConfigurationException -
     */
    public SendAcceptItem() throws ConfigurationException {
        messageHandler = ConfigurationHelper.getComponent(ToolkitComponent.MESSAGE_HANDLER_COMPONENT_NAME);
    }

    /**
     * Perform the AcceptItem service.
     * @param agencyIdString the {@link AgencyId} value
     * @param localItemIdString an item identifier
     * @param itemAgencyIdString the value of the item's AgencyId
     * @param bibDescriptions the fields that describe the bibliograhic item
     * @param itemUseRestrictions the item use restrictions
     * @param requestIdString the request id
     * @param userIdString the user id
     * @param localDueDateString the local due date
     * @param pickupLocIdString the pickup location
     * @return the {@link NCIPResponseData} object
     * @throws ParseException -
     * @throws ServiceException -
     * @throws ConfigurationException -
     * @throws ValidationException -
     * @throws ToolkitInternalException -
     */
    @SuppressWarnings("squid:S00107") // Excessive parameters are not significant in sample code.
    public NCIPResponseData performService(final String agencyIdString, final String localItemIdString, final String itemAgencyIdString, final String[] bibDescriptions,
        final boolean[] itemUseRestrictions, final String requestIdString, final String userIdString, final String localDueDateString, final String pickupLocIdString)
        throws ParseException, ServiceException, ConfigurationException, ValidationException, ToolkitInternalException {

        final AcceptItemInitiationData initData = new AcceptItemInitiationData();

        final AgencyId agencyId = new AgencyId(agencyIdString);

        final InitiationHeader initHdr = new InitiationHeader();
        final ToAgencyId toAgencyId = new ToAgencyId();
        toAgencyId.setAgencyId(agencyId);
        initHdr.setToAgencyId(toAgencyId);
        final FromAgencyId fromAgencyId = new FromAgencyId();
        fromAgencyId.setAgencyId(agencyId);
        initHdr.setFromAgencyId(fromAgencyId);
        initData.setInitiationHeader(initHdr);

        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue(localItemIdString);
        if (itemAgencyIdString != null && !itemAgencyIdString.isEmpty()) {

            itemId.setAgencyId(AgencyId.find(null, itemAgencyIdString));

        } else {

            itemId.setAgencyId(agencyId);

        }
        initData.setItemId(itemId);

        final ItemOptionalFields itemOptionalFields = new ItemOptionalFields();
        itemOptionalFields.setBibliographicDescription(makeBibliographicDescription(bibDescriptions, agencyId));
        itemOptionalFields.setItemUseRestrictionTypes(makeItemUseRestrictions(itemUseRestrictions));
        initData.setItemOptionalFields(itemOptionalFields);

        final RequestId requestId = new RequestId();
        requestId.setAgencyId(agencyId);
        requestId.setRequestIdentifierValue(requestIdString);
        initData.setRequestId(requestId);

        final UserId userId = new UserId();
        userId.setAgencyId(agencyId);
        userId.setUserIdentifierValue(userIdString);
        initData.setUserId(userId);

        if (localDueDateString != null) {

            final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
            final Date localDueDate = dateFormat.parse(localDueDateString);
            final GregorianCalendar calendarLocalDueDate = new GregorianCalendar();
            calendarLocalDueDate.setTime(localDueDate);
            initData.setDateForReturn(calendarLocalDueDate);

        }

        if (pickupLocIdString != null && !pickupLocIdString.isEmpty()) {

            final PickupLocation pickupLocation = PickupLocation.find(null, pickupLocIdString);
            initData.setPickupLocation(pickupLocation);

        }

        initData.setRequestedActionType(Version1RequestedActionType.CIRCULATE);

        final ServiceContextFactory<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContextFactory = ConfigurationHelper
            .getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
        final ServiceContext<NCIPMessage<NCIPInitiationData, NCIPResponseData>, NCIPInitiationData, NCIPResponseData> serviceContext = serviceContextFactory
            .getInitialServiceContext();

        final NCIPResponseData responseData = messageHandler.performService(initData, serviceContext);

        return responseData;

    }

    /**
     * Run the process to send an AcceptItem message.
     * @param args command-line arguments; see Javadoc for this class.
     * @throws ConfigurationException -
     * @throws ParseException -
     * @throws ServiceException -
     * @throws ToolkitInternalException -
     * @throws ValidationException -
     */
    public static void main(final String[] args) throws ConfigurationException, ParseException, ServiceException, ToolkitInternalException, ValidationException {

        final SendAcceptItem service = new SendAcceptItem();

        if (args == null || args.length < DUE_DATE_ARG) {
            LOG.error("Error: Missing required parameter.");
            LOG.error(USAGE_STRING);
        } else if (args.length == PICKUP_LOCATION_ARG || args.length == MAX_ARG_LENGTH) {
            final String agencyIdString = args[AGENCY_ID_ARG];
            final String localItemAgencyIdString = getLocaItemAgencyId(args[ITEM_ID_ARG]);
            final String localItemIdString = getLocaItemId(args[ITEM_ID_ARG]);
            final String localDueDateString = args[DUE_DATE_ARG];
            final String[] bibDescriptions = getBibDescriptions(args[BIB_DESCRIPTION_ARG]);
            final String pickupLocIdString = getPickupLocation(args);
            final boolean[] itemUseRestrictions = getItemUseRestrictions(args[USE_RESTRICTIONS_ARG]);
            final String requestIdString = args[REQUEST_ID_ARG];
            final String userIdString = args[USER_ID_ARG];
            final NCIPResponseData responseData = service
                .performService(agencyIdString, localItemIdString, localItemAgencyIdString, bibDescriptions, itemUseRestrictions, requestIdString, userIdString, localDueDateString,
                    pickupLocIdString);
            LOG.info("Response: " + responseData);
        } else {
            LOG.error("Error: Too many parameters - found " + args.length + ", expecting " + PICKUP_LOCATION_ARG + " or " + MAX_ARG_LENGTH + ".");
            LOG.error(USAGE_STRING);
        }
    }

    private static String getLocaItemAgencyId(final String arg) {
        String localItemAgencyId = null;
        final int positionOfSlash = arg.indexOf('/');
        if (positionOfSlash >= 0) {
            localItemAgencyId = arg.substring(0, positionOfSlash);
        }
        return localItemAgencyId;
    }

    private static String getLocaItemId(final String arg) {
        String trimmedLocalItemId = arg;
        final int positionOfSlash = arg.indexOf('/');
        if (positionOfSlash >= 0) {
            trimmedLocalItemId = arg.substring(positionOfSlash + 1);
        }
        return trimmedLocalItemId;
    }

    private static String[] getBibDescriptions(final String arg) {
        final String[] bibDescriptions;
        if (arg == null || arg.isEmpty()) {
            bibDescriptions = ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,".split(",", -1);
        } else {
            bibDescriptions = arg.split(",", -1);
        }
        if (bibDescriptions.length != NUMBER_OF_BIB_FIELDS) {
            LOG.error(bibDescriptions.length + " descriptions found; must provide " + NUMBER_OF_BIB_FIELDS
                + " descriptions; use commmas to separate and you may omit values by leaving nothing" + " between the commas.");
        }
        return bibDescriptions;
    }

    private static String getPickupLocation(final String[] args) {
        String pickupLocIdString = null;
        if (args.length == MAX_ARG_LENGTH && args[PICKUP_LOCATION_ARG] != null && !args[PICKUP_LOCATION_ARG].isEmpty()) {
            pickupLocIdString = args[PICKUP_LOCATION_ARG];
        }
        return pickupLocIdString;
    }

    private static boolean[] getItemUseRestrictions(final String arg) {
        final String[] itemUseRestrictionStrings;
        if (arg == null || arg.compareTo("") == 0) {
            itemUseRestrictionStrings = ",,,,".split(",", -1);
        } else {
            itemUseRestrictionStrings = arg.split(",", -1);
        }
        final boolean[] itemUseRestrictions = { false, false, false, false };
        for (int i = 0; i < itemUseRestrictionStrings.length && i < 4; ++i) {
            itemUseRestrictions[i] = Boolean.parseBoolean(itemUseRestrictionStrings[i]);
        }
        return itemUseRestrictions;
    }

    /**
     * Compose a {@link BiConsumer} that calls a setter method to set the String in the associated field of the BibliographicDescription.
     * @param setter the setter method
     * @return the BiConsumer
     */
    static BiConsumer<String, BibliographicDescription> composeCallToSetter(final BiConsumer<BibliographicDescription, String> setter) {
        return (d, bd) -> {
            if (!d.isEmpty()) {
                setter.accept(bd, d);
            }
        };
    }

    /**
     * Compose a {@link BiConsumer} that calls the {@link SchemeValuePairHelper#findSchemeValuePair(Class, String, String)} to find the {@link SchemeValuePair} instance
     * associated with the class, uri and the String to be passed to the BiConsumer, and then calls the setter to set the instance in the associated field of the
     * BibliographicDescription.
     * @param c the Class for the {@link SchemeValuePair} sub-class
     * @param uri the Scheme URI to which the String passed to the BiConsumer belongs
     * @param setter the setter method
     * @param <SVP> a {@link SchemeValuePair} sub-class
     * @return the BiConsumer
     */
    static <SVP extends SchemeValuePair> BiConsumer<String, BibliographicDescription> composeCallToFindAndSetter(final Class<SVP> c, final String uri,
        final BiConsumer<BibliographicDescription, SVP> setter) {
        return (d, bd) -> {
            try {
                final SVP svp = (SVP) SchemeValuePairHelper.findSchemeValuePair(c, uri, d);
                setter.accept(bd, svp);
            } catch (ToolkitException e) {
                LOG.error(e);
            }
        };
    }

    static final Map<Integer, BiConsumer<String, BibliographicDescription>> BIBLIOGRAPHIC_SETTERS;

    static {
        final Map<Integer, BiConsumer<String, BibliographicDescription>> tempMap = new HashMap<>();
        // @formatter:off
        // Properties set by directly calling the setter method.
        tempMap.put(AUTHOR_INDEX,                        (d, b) -> composeCallToSetter(BibliographicDescription::setAuthor).accept(d, b));
        tempMap.put(AUTHOR_OF_COMPONENT_INDEX,           (d, b) -> composeCallToSetter(BibliographicDescription::setAuthorOfComponent).accept(d, b));
        tempMap.put(EDITION_INDEX,                       (d, b) -> composeCallToSetter(BibliographicDescription::setEdition).accept(d, b));
        tempMap.put(PAGINATION_INDEX,                    (d, b) -> composeCallToSetter(BibliographicDescription::setPagination).accept(d, b));
        tempMap.put(PLACE_OF_PUBLICATION_INDEX,          (d, b) -> composeCallToSetter(BibliographicDescription::setPlaceOfPublication).accept(d, b));
        tempMap.put(PUBLICATION_DATE_INDEX,              (d, b) -> composeCallToSetter(BibliographicDescription::setPublicationDate).accept(d, b));
        tempMap.put(PUBLICATION_DATE_OF_COMPONENT_INDEX, (d, b) -> composeCallToSetter(BibliographicDescription::setPublicationDateOfComponent).accept(d, b));
        tempMap.put(PUBLISHER_INDEX,                     (d, b) -> composeCallToSetter(BibliographicDescription::setPublisher).accept(d, b));
        tempMap.put(SERIES_TITLE_NUMBER_INDEX,           (d, b) -> composeCallToSetter(BibliographicDescription::setSeriesTitleNumber).accept(d, b));
        tempMap.put(SPONSORING_BODY_INDEX,               (d, b) -> composeCallToSetter(BibliographicDescription::setSponsoringBody).accept(d, b));
        tempMap.put(TITLE_INDEX,                         (d, b) -> composeCallToSetter(BibliographicDescription::setTitle).accept(d, b));
        tempMap.put(TITLE_OF_COMPONENT_INDEX,            (d, b) -> composeCallToSetter(BibliographicDescription::setTitleOfComponent).accept(d, b));
        // Properties set by finding the SchemeValuePair instance and calling the setter method with it.
        tempMap.put(BIBLIOGRAPHIC_LEVEL_INDEX,           (d, b) -> composeCallToFindAndSetter(BibliographicLevel.class,
            Version1BibliographicLevel.VERSION_1_BIBLIOGRAPHIC_LEVEL, BibliographicDescription::setBibliographicLevel).accept(d, b));
        tempMap.put(ELECTRONIC_DATA_FORMAT_TYPE_INDEX,   (d, b) -> composeCallToFindAndSetter(ElectronicDataFormatType.class,
            Version1ElectronicDataFormatType.VERSION_1_ELECTRONIC_DATA_FORMAT_TYPE, BibliographicDescription::setElectronicDataFormatType).accept(d, b));
        tempMap.put(LANGUAGE_INDEX,                      (d, b) -> composeCallToFindAndSetter(Language.class,
            Version1Language.VERSION_1_LANGUAGE, BibliographicDescription::setLanguage).accept(d, b));
        tempMap.put(MEDIUM_TYPE_INDEX,                   (d, b) -> composeCallToFindAndSetter(MediumType.class,
            Version1MediumType.VERSION_1_MEDIUM_TYPE, BibliographicDescription::setMediumType).accept(d, b));
        // @formatter:on
        BIBLIOGRAPHIC_SETTERS = Collections.unmodifiableMap(tempMap);
    }

    /**
     * Construct a {@link BibliographicDescription} from the input array of strings.
     *
     * @param bibDescriptions  the array of <code>String</code> descriptive elements
     * @param agencyId used in the BibliographicRecordId, if there is one
     * @return the BibliographicDescription object
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static BibliographicDescription makeBibliographicDescription(final String[] bibDescriptions, final AgencyId agencyId)
        throws ConfigurationException, ToolkitInternalException {

        LOG.debug("Entering makeBibliographicDescription");
        final BibliographicDescription result = new BibliographicDescription();

        for (int index = 0; index < bibDescriptions.length; index++) {
            final BiConsumer<String, BibliographicDescription> setter = BIBLIOGRAPHIC_SETTERS.get(index);
            if (setter != null) {
                setter.accept(bibDescriptions[index], result);
            }
        }

        setBibItemId(bibDescriptions, result);
        setBibRecordId(bibDescriptions, result, agencyId);
        setComponentId(bibDescriptions, result);

        LOG.debug("Returning " + result);
        return result;
    }

    private static void setBibItemId(final String[] bibDescriptions, final BibliographicDescription bibliographicDescription)
        throws ToolkitInternalException, ConfigurationException {
        if (!bibDescriptions[BIBLIOGRAPHIC_ITEM_ID_INDEX].isEmpty()) {
            final BibliographicItemId bibItemId = makeBibItemId(bibDescriptions[BIBLIOGRAPHIC_ITEM_ID_CODE_INDEX], bibDescriptions[BIBLIOGRAPHIC_ITEM_ID_INDEX]);
            final List<BibliographicItemId> bibItemIds = new ArrayList<>();
            bibItemIds.add(bibItemId);
            bibliographicDescription.setBibliographicItemIds(bibItemIds);
        } else if (LOG.isEnabledFor(Level.WARN) && !bibDescriptions[BIBLIOGRAPHIC_ITEM_ID_CODE_INDEX].isEmpty()) {
            LOG.warn("Must provide bibliographic item id when providing bibliographic item id code");
        }
    }

    private static void setBibRecordId(final String[] bibDescriptions, final BibliographicDescription bibliographicDescription, final AgencyId agencyId)
        throws ToolkitInternalException, ConfigurationException {
        if (!bibDescriptions[BIBLIOGRAPHIC_RECORD_ID_CODE_INDEX].isEmpty() && !bibDescriptions[BIBLIOGRAPHIC_RECORD_ID_INDEX].isEmpty()) {
            final BibliographicRecordId bibRecordId = makeBibRecordId(bibDescriptions[BIBLIOGRAPHIC_RECORD_ID_CODE_INDEX], bibDescriptions[BIBLIOGRAPHIC_RECORD_ID_INDEX],
                agencyId);
            final List<BibliographicRecordId> bibRecordIds = new ArrayList<>();
            bibRecordIds.add(bibRecordId);
            bibliographicDescription.setBibliographicRecordIds(bibRecordIds);
        } else if (bibDescriptions[BIBLIOGRAPHIC_RECORD_ID_CODE_INDEX].isEmpty() ^ bibDescriptions[BIBLIOGRAPHIC_RECORD_ID_INDEX].isEmpty()) {
            LOG.warn("Must provide both bibliographic record id code and bibliographic record id or neither of them.");
        }
    }

    private static void setComponentId(final String[] bibDescriptions, final BibliographicDescription bibliographicDescription)
        throws ToolkitInternalException, ConfigurationException {
        if (!bibDescriptions[COMPONENT_ID_TYPE_INDEX].isEmpty() && !bibDescriptions[COMPONENT_ID_INDEX].isEmpty()) {
            final ComponentId componentId = makeComponentId(bibDescriptions[COMPONENT_ID_TYPE_INDEX], bibDescriptions[COMPONENT_ID_INDEX]);
            bibliographicDescription.setComponentId(componentId);
        } else if (bibDescriptions[COMPONENT_ID_TYPE_INDEX].isEmpty() ^ bibDescriptions[COMPONENT_ID_INDEX].isEmpty()) {
            LOG.warn("Must provide both component id type and component id or neither of them.");
        }
    }

    /**
     * Make the item use restrictions list.
     * @param itemUseRestrictions an array of booleans for the restrictions in the order library use only, no reproduction, supervision required, user signature required
     * @return the list of restrictions, or null if there are none
     */
    private List<ItemUseRestrictionType> makeItemUseRestrictions(final boolean[] itemUseRestrictions) {
        final List<ItemUseRestrictionType> itemUseRestrictionsList;
        if (itemUseRestrictions != null) {
            itemUseRestrictionsList = new ArrayList<>();
            if (itemUseRestrictions[0]) {
                itemUseRestrictionsList.add(Version1ItemUseRestrictionType.IN_LIBRARY_USE_ONLY);
            }
            if (itemUseRestrictions[1]) {
                itemUseRestrictionsList.add(Version1ItemUseRestrictionType.NO_REPRODUCTION);
            }
            if (itemUseRestrictions[2]) {
                itemUseRestrictionsList.add(Version1ItemUseRestrictionType.SUPERVISION_REQUIRED);
            }
            if (itemUseRestrictions[3]) {
                itemUseRestrictionsList.add(Version1ItemUseRestrictionType.USER_SIGNATURE_REQUIRED);
            }
        } else {
            itemUseRestrictionsList = null;
        }
        return itemUseRestrictionsList;
    }

    /**
     * Construct a {@link BibliographicItemId} object using the NCIP Bibliographic Item Id Scheme and the provided value.
     *
     * @param value String that matches one of the Values in the Bibliographic Item Identifier Code Scheme
     * @param id    String that identifies the bibliographic item id
     * @return the {@link BibliographicItemId} object
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static BibliographicItemId makeBibItemId(final String value, final String id) throws ConfigurationException, ToolkitInternalException {

        final BibliographicItemId result = new BibliographicItemId();
        result.setBibliographicItemIdentifier(id);

        if (value != null && !value.isEmpty()) {

            final BibliographicItemIdentifierCode code = BibliographicItemIdentifierCode
                .find(Version1BibliographicItemIdentifierCode.VERSION_1_BIBLIOGRAPHIC_ITEM_IDENTIFIER_CODE, value);
            result.setBibliographicItemIdentifierCode(code);

        }

        return result;

    }

    /**
     * Construct a {@link ComponentId} object using the NCIP Component Id Scheme and the provided value.
     *
     * @param value String that matches one of the Values in the NCIP Component Identifier Type Scheme
     * @param id    the component id
     * @return the {@link ComponentId} object
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static ComponentId makeComponentId(final String value, final String id) throws ConfigurationException, ToolkitInternalException {

        final ComponentId result = new ComponentId();
        final ComponentIdentifierType type = ComponentIdentifierType.find(Version1ComponentIdentifierType.VERSION_1_COMPONENT_IDENTIFIER_TYPE, value);
        result.setComponentIdentifierType(type);
        result.setComponentIdentifier(id);
        return result;

    }

    /**
     * Constructs a {@link BibliographicRecordId} object using the NCIP
     * Bibliographic Record Id Scheme, the provided value and id. If the
     * value parameter matches the special code <code>local</code>, then
     * the returned object will contain the UniqueAgencyId (signifying the
     * id is a local system record id), otherwise
     * it will contain the BibliographicRecordIdentifierCode (signifying
     * the id is that of a bibliographic record in a national bibliography,
     * bibliographic utility or other well-known database).
     *
     * @param value        String that matches on of the values in the NCIP Bibliographic Record, or "local"
     * @param id           String containing the record id
     * @param agencyId     {@link AgencyId} object designating the agency associated with the <code>id</code>
     * @return the {@link BibliographicRecordId}
     * @throws ConfigurationException -
     * @throws ToolkitInternalException -
     */
    public static BibliographicRecordId makeBibRecordId(final String value, final String id, final AgencyId agencyId) throws ConfigurationException, ToolkitInternalException {

        final BibliographicRecordId result = new BibliographicRecordId();
        result.setBibliographicRecordIdentifier(id);

        if (value.compareTo("local") == 0) {

            result.setAgencyId(agencyId);

        } else {

            final BibliographicRecordIdentifierCode bibRecIdCode = BibliographicRecordIdentifierCode
                .find(Version1BibliographicRecordIdentifierCode.VERSION_1_BIBLIOGRAPHIC_RECORD_IDENTIFIER_CODE, value);
            result.setBibliographicRecordIdentifierCode(bibRecIdCode);

        }

        return result;

    }

}
