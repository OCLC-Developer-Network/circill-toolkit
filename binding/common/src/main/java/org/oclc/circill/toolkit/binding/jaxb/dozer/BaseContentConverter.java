/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import org.oclc.circill.toolkit.binding.jaxb.JAXBHelper;
import org.oclc.circill.toolkit.service.base.ProtocolHelper;
import org.oclc.circill.toolkit.service.base.ReflectionHelper;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;
import org.oclc.circill.toolkit.service.ncip.AgencyElementType;
import org.oclc.circill.toolkit.service.ncip.ItemElementType;
import org.oclc.circill.toolkit.service.ncip.RequestElementType;
import org.oclc.circill.toolkit.service.ncip.UserElementType;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import org.dozer.MappingException;
import org.w3c.dom.Node;

// TODO: Step 12: Refactor this so that the relevant NCIP or ISO classes are loaded via Spring config.

/**
 * The base class for converters of elements with content models for which JAXB uses a "catch-all" approach.
 * JAXB uses this approach for certain content models occurring in NCIP (e.g. this one:
 *<pre>{@code
 * <xsd:choice>
 *   <xsd:element ref = "ItemId"/>
 *   <xsd:sequence>
 *     <xsd:element ref = "RequestId"/>
 *     <xsd:element ref = "ItemId" minOccurs = "0"/>
 *   </xsd:sequence>
 * </xsd:choice>}
 * </pre>
 *
 * This catch-all approach is implemented by putting the child elements into a {@code List<Object>} which is
 * accessed via the {@code getContent()} method of the class. JAXB requires the application code
 * to put elements into the content list <em>in the order they are to be marshaled.</em>
 * To meet that expectation this class has to "know" the order of child elements for those classes.
 * This is hard-coded below and should the XML schema be changed this might need changing too.
 * A more dynamic approach would be to determine this at start-up time from the schema itself.
 * A much less difficult (?) approach would be to figure out how to put this element ordering into the
 * dozer mapping file rather than into this class; at least then the element-order information would
 * be in the same place where the element is configured to use this BaseContentConverter.
 *
 *  Note: You must create an instance of this class for <i>each</i> JAXB package.
 *
 * @param <SM> the type of {@link ServiceMessage}
 * @param <ID> the type of the {@link ServiceInitiationData}
 * @param <RD> the type of the {@link ServiceResponseData}
 * @param <JAXBSVPCLASS> the type of the JAXB-generated class that represents SchemeValuePair elements
 * @param <EXTCLASS> the type of the JAXB-generated class that represents extension elements
 */
// TODO: There is some common functionality with BaseAtomicTypeExtensionConverter; try to refactor or share.
@SuppressWarnings({ "squid:S1192", "squid:S00119" })
public abstract class BaseContentConverter<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData, JAXBSVPCLASS, EXTCLASS>
    extends DozerConverter<Object /* service package */, Object /* jaxb */> implements MapperAware {

    private static final Logger LOG = Logger.getLogger(BaseContentConverter.class);

    /**
     * These are the known cases where a property's type is not a primitive type and
     * does not (allowing for pluralization) match the simple name of the class used
     * to represent it in the Toolkit.
     * This list should have a matching list (with the exception that the keys begin with lower-case letters) in TestPropertyTypes.
     */
    private static final Map<String /*Property Name*/, String /*Type Name*/> ALIASES;

    static {
        final Map<String, String> tempMap = new HashMap<>();
        tempMap.put("RelyingPartyId", "AgencyId");
        tempMap.put("AcknowledgedItemUseRestrictionType", "ItemUseRestrictionType");
        tempMap.put("AcknowledgedItemUseRestrictionTypes", "ItemUseRestrictionTypes");
        tempMap.put("RequiredItemUseRestrictionType", "ItemUseRestrictionType");
        tempMap.put("RequiredItemUseRestrictionTypes", "ItemUseRestrictionTypes");
        ALIASES = Collections.unmodifiableMap(tempMap);
    }

    private static final DatatypeFactory DEFAULT_DATATYPE_FACTORY;

    static {
        try {
            DEFAULT_DATATYPE_FACTORY = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            LOG.error("Exception creating a datatype factory:", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /** A list of elements in the {@code CanelRequestItem} message. */
    private static final List<String> cancelRequestItemElementOrder = new ArrayList<>();

    static {
        cancelRequestItemElementOrder.add("InitiationHeader");
        cancelRequestItemElementOrder.add("MandatedAction");
        cancelRequestItemElementOrder.add("UserId");
        cancelRequestItemElementOrder.add("AuthenticationInput");
        cancelRequestItemElementOrder.add("RequestId");
        cancelRequestItemElementOrder.add("ItemId");
        cancelRequestItemElementOrder.add("RequestType");
        cancelRequestItemElementOrder.add("RequestScopeType");
        cancelRequestItemElementOrder.add("AcknowledgedFeeAmount");
        cancelRequestItemElementOrder.add("PaidFeeAmount");
        cancelRequestItemElementOrder.add("ItemElementType");
        cancelRequestItemElementOrder.add("UserElementType");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> cancelRequestItemExtensions = new ArrayList<>();

    static {
        cancelRequestItemExtensions.add("RelyingPartyId");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> cancelRequestItemResponseElementOrder = new ArrayList<>();

    static {
        cancelRequestItemResponseElementOrder.add("ResponseHeader");
        cancelRequestItemResponseElementOrder.add("Problem");
        cancelRequestItemResponseElementOrder.add("RequestId");
        cancelRequestItemResponseElementOrder.add("ItemId");
        cancelRequestItemResponseElementOrder.add("UserId");
        cancelRequestItemResponseElementOrder.add("FiscalTransactionInformation");
        cancelRequestItemResponseElementOrder.add("ItemOptionalFields");
        cancelRequestItemResponseElementOrder.add("UserOptionalFields");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> chronologyLevelInstanceElementOrder = new ArrayList<>();

    static {
        chronologyLevelInstanceElementOrder.add("ChronologyLevel");
        chronologyLevelInstanceElementOrder.add("ChronologyCaption");
        chronologyLevelInstanceElementOrder.add("ChronologyValue");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> destinationElementOrder = new ArrayList<>();

    static {
        destinationElementOrder.add("BinNumber");
        destinationElementOrder.add("Location");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> enumerationLevelInstanceElementOrder = new ArrayList<>();

    static {
        enumerationLevelInstanceElementOrder.add("EnumerationLevel");
        enumerationLevelInstanceElementOrder.add("EnumerationCaption");
        enumerationLevelInstanceElementOrder.add("EnumerationValue");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> itemRequestCancelledElementOrder = new ArrayList<>();

    static {
        itemRequestCancelledElementOrder.add("InitiationHeader");
        itemRequestCancelledElementOrder.add("UserId");
        itemRequestCancelledElementOrder.add("RequestId");
        itemRequestCancelledElementOrder.add("ItemId");
        itemRequestCancelledElementOrder.add("RequestType");
        itemRequestCancelledElementOrder.add("RequestScopeType");
        itemRequestCancelledElementOrder.add("FiscalTransactionInformation");
        itemRequestCancelledElementOrder.add("ItemOptionalFields");
        itemRequestCancelledElementOrder.add("UserOptionalFields");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> itemShippedElementOrder = new ArrayList<>();

    static {
        itemShippedElementOrder.add("InitiationHeader");
        itemShippedElementOrder.add("RequestId");
        itemShippedElementOrder.add("ItemId");
        itemShippedElementOrder.add("UserId");
        itemShippedElementOrder.add("DateShipped");
        itemShippedElementOrder.add("ShippingInformation");
        itemShippedElementOrder.add("ItemOptionalFields");
        itemShippedElementOrder.add("UserOptionalFields");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> lookupItemResponseElementOrder = new ArrayList<>();

    static {
        lookupItemResponseElementOrder.add("ResponseHeader");
        lookupItemResponseElementOrder.add("Problem");
        lookupItemResponseElementOrder.add("RequestId");
        lookupItemResponseElementOrder.add("ItemId");
        lookupItemResponseElementOrder.add("HoldPickupDate");
        lookupItemResponseElementOrder.add("DateRecalled");
        lookupItemResponseElementOrder.add("ItemTransaction");
        lookupItemResponseElementOrder.add("ItemOptionalFields");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> lookupRequestResponseElementOrder = new ArrayList<>();

    static {
        lookupRequestResponseElementOrder.add("ResponseHeader");
        lookupRequestResponseElementOrder.add("Problem");
        lookupRequestResponseElementOrder.add("RequestId");
        lookupRequestResponseElementOrder.add("ItemId");
        lookupRequestResponseElementOrder.add("UserId");
        lookupRequestResponseElementOrder.add("RequestType");
        lookupRequestResponseElementOrder.add("RequestScopeType");
        lookupRequestResponseElementOrder.add("RequestStatusType");
        lookupRequestResponseElementOrder.add("HoldQueuePosition");
        lookupRequestResponseElementOrder.add("ShippingInformation");
        lookupRequestResponseElementOrder.add("EarliestDateNeeded");
        lookupRequestResponseElementOrder.add("NeedBeforeDate");
        lookupRequestResponseElementOrder.add("PickupDate");
        lookupRequestResponseElementOrder.add("PickupLocation");
        lookupRequestResponseElementOrder.add("PickupExpiryDate");
        lookupRequestResponseElementOrder.add("DateOfUserRequest");
        lookupRequestResponseElementOrder.add("DateAvailable");
        lookupRequestResponseElementOrder.add("AcknowledgedFeeAmount");
        lookupRequestResponseElementOrder.add("PaidFeeAmount");
        lookupRequestResponseElementOrder.add("ItemOptionalFields");
        lookupRequestResponseElementOrder.add("UserOptionalFields");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> personalNameInformationElementOrder = new ArrayList<>();

    static {
        personalNameInformationElementOrder.add("StructuredPersonalUserName");
        personalNameInformationElementOrder.add("UnstructuredPersonalUserName");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> requestedItemElementOrder = new ArrayList<>();

    static {
        requestedItemElementOrder.add("RequestId");
        requestedItemElementOrder.add("ItemId");
        requestedItemElementOrder.add("BibliographicId");
        requestedItemElementOrder.add("RequestType");
        requestedItemElementOrder.add("RequestStatusType");
        requestedItemElementOrder.add("DatePlaced");
        requestedItemElementOrder.add("PickupDate");
        requestedItemElementOrder.add("PickupLocation");
        requestedItemElementOrder.add("PickupExpiryDate");
        requestedItemElementOrder.add("ReminderLevel");
        requestedItemElementOrder.add("HoldQueuePosition");
        requestedItemElementOrder.add("Title");
        requestedItemElementOrder.add("MediumType");
        requestedItemElementOrder.add("Ext");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> requestedItemExtensions = new ArrayList<>();

    static {
        requestedItemExtensions.add("BibliographicDescription");
        requestedItemExtensions.add("DateDue");
        requestedItemExtensions.add("EarliestDateNeeded");
        requestedItemExtensions.add("ElectronicResource");
        requestedItemExtensions.add("HoldQueueLength");
        requestedItemExtensions.add("IsActive");
        requestedItemExtensions.add("ItemDescription");
        requestedItemExtensions.add("Location");
        requestedItemExtensions.add("NeedBeforeDate");
        requestedItemExtensions.add("NoticeCount");
        requestedItemExtensions.add("NoticeInformation");
        requestedItemExtensions.add("PermittedUserAction");
        requestedItemExtensions.add("RelatedSystemRequestId");
        requestedItemExtensions.add("SuspensionEndDate");
        requestedItemExtensions.add("SuspensionStartDate");
        requestedItemExtensions.add("UserLimit");
        requestedItemExtensions.add("UserNote");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> requestItemElementOrder = new ArrayList<>();

    static {
        requestItemElementOrder.add("InitiationHeader");
        requestItemElementOrder.add("MandatedAction");
        requestItemElementOrder.add("UserId");
        requestItemElementOrder.add("AuthenticationInput");
        requestItemElementOrder.add("BibliographicId");
        requestItemElementOrder.add("ItemId");
        requestItemElementOrder.add("RequestId");
        requestItemElementOrder.add("RequestType");
        requestItemElementOrder.add("RequestScopeType");
        requestItemElementOrder.add("ItemOptionalFields");
        requestItemElementOrder.add("ShippingInformation");
        requestItemElementOrder.add("EarliestDateNeeded");
        requestItemElementOrder.add("NeedBeforeDate");
        requestItemElementOrder.add("PickupLocation");
        requestItemElementOrder.add("PickupExpiryDate");
        requestItemElementOrder.add("AcknowledgedFeeAmount");
        requestItemElementOrder.add("PaidFeeAmount");
        requestItemElementOrder.add("AcknowledgedItemUseRestrictionType");
        requestItemElementOrder.add("ItemElementType");
        requestItemElementOrder.add("UserElementType");
        requestItemElementOrder.add("Ext");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> requestItemExtensions = new ArrayList<>();

    static {
        requestItemExtensions.add("BibliographicDescription");
        requestItemExtensions.add("DesiredEdition");
        requestItemExtensions.add("EditionSubstitutionType");
        requestItemExtensions.add("MaxFeeAmount");
        requestItemExtensions.add("RelyingPartyId");
        requestItemExtensions.add("SuspensionStartDate");
        requestItemExtensions.add("SuspensionEndDate");
        requestItemExtensions.add("UserNote");
        requestItemExtensions.add("UserOptionalFields");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> requestItemResponseElementOrder = new ArrayList<>();

    static {
        requestItemResponseElementOrder.add("ResponseHeader");
        requestItemResponseElementOrder.add("Problem");
        requestItemResponseElementOrder.add("RequiredFeeAmount");
        requestItemResponseElementOrder.add("RequiredItemUseRestrictionType");
        requestItemResponseElementOrder.add("RequestId");
        requestItemResponseElementOrder.add("ItemId");
        requestItemResponseElementOrder.add("UserId");
        requestItemResponseElementOrder.add("RequestType");
        requestItemResponseElementOrder.add("RequestScopeType");
        requestItemResponseElementOrder.add("ShippingInformation");
        requestItemResponseElementOrder.add("DateAvailable");
        requestItemResponseElementOrder.add("HoldPickupDate");
        requestItemResponseElementOrder.add("FiscalTransactionInformation");
        requestItemResponseElementOrder.add("ItemOptionalFields");
        requestItemResponseElementOrder.add("UserOptionalFields");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> requestItemResponseExtensions = new ArrayList<>();

    static {
        requestItemResponseExtensions.add("HoldQueueLength");
        requestItemResponseExtensions.add("HoldQueuePosition");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> structuredAddressElementOrder = new ArrayList<>();

    static {
        structuredAddressElementOrder.add("LocationWithinBuilding");
        structuredAddressElementOrder.add("HouseName");
        structuredAddressElementOrder.add("Street");
        structuredAddressElementOrder.add("PostOfficeBox");
        structuredAddressElementOrder.add("District");
        structuredAddressElementOrder.add("Line1");
        structuredAddressElementOrder.add("Line2");
        structuredAddressElementOrder.add("Locality");
        structuredAddressElementOrder.add("Region");
        structuredAddressElementOrder.add("Country");
        structuredAddressElementOrder.add("PostalCode");
        structuredAddressElementOrder.add("CareOf");
    }

    /** A list of elements in the {@code REPLACE} message. */
    private static final List<String> structuredHoldingsDataElementOrder = new ArrayList<>();

    static {
        structuredHoldingsDataElementOrder.add("HoldingsEnumeration");
        structuredHoldingsDataElementOrder.add("HoldingsChronology");
    }

    /** A map by parent element name, of the lists of their child elements, in the order they should be marshalled. */
    private static final Map<String, List<String>> elementOrderByParentElementName = new HashMap<>();

    static {
        elementOrderByParentElementName.put("CancelRequestItem", cancelRequestItemElementOrder);
        elementOrderByParentElementName.put("CancelRequestItemResponse", cancelRequestItemResponseElementOrder);
        elementOrderByParentElementName.put("ChronologyLevelInstance", chronologyLevelInstanceElementOrder);
        elementOrderByParentElementName.put("Destination", destinationElementOrder);
        elementOrderByParentElementName.put("EnumerationLevelInstance", enumerationLevelInstanceElementOrder);
        elementOrderByParentElementName.put("ItemRequestCancelled", itemRequestCancelledElementOrder);
        elementOrderByParentElementName.put("ItemShipped", itemShippedElementOrder);
        elementOrderByParentElementName.put("LookupItemResponse", lookupItemResponseElementOrder);
        elementOrderByParentElementName.put("LookupRequestResponse", lookupRequestResponseElementOrder);
        elementOrderByParentElementName.put("PersonalNameInformation", personalNameInformationElementOrder);
        elementOrderByParentElementName.put("RequestedItem", requestedItemElementOrder);
        elementOrderByParentElementName.put("RequestItem", requestItemElementOrder);
        elementOrderByParentElementName.put("RequestItemResponse", requestItemResponseElementOrder);
        elementOrderByParentElementName.put("StructuredAddress", structuredAddressElementOrder);
        elementOrderByParentElementName.put("StructuredHoldingsData", structuredHoldingsDataElementOrder);
    }

    /** A map by element name of the list of its child extension elements. */
    private static final Map<String, List<String>> extensionElementsByParentObjectName = new HashMap<>();

    static {
        extensionElementsByParentObjectName.put("CancelRequestItem", cancelRequestItemExtensions);
        extensionElementsByParentObjectName.put("RequestedItem", requestedItemExtensions);
        extensionElementsByParentObjectName.put("RequestItem", requestItemExtensions);
        extensionElementsByParentObjectName.put("RequestItemResponse", requestItemResponseExtensions);
    }

    /**
     * A pattern the name of the create method (in the JAXB ObjectFactory) for empty elements which appear
     * in extension elements.
     */
    private static final Pattern EMPTY_CONTENT_FIELDS_REGEX = Pattern.compile("create(IsActive)$");

    /**
     * The {@link DatatypeFactory}.
     */
    private DatatypeFactory datatypeFactory = DEFAULT_DATATYPE_FACTORY;

    /**
     * The {@link ProtocolHelper} for this converter.
     */
    private ProtocolHelper<SM, ID, RD> protocolHelper;

    /** The type of the JAXB-generated class that represents SchemeValuePair elements. */
    private final Class<JAXBSVPCLASS> jaxbSVPClass;
    /** The package name for JAXB classes. */
    private final String jaxbPackageNameWithPeriod;
    /** The package name for Service classes. */
    private final String svcPackageNameWithPeriod;
    /** Map of JAXB ObjectFactory methods by method name. */
    private final Map<String, Method> objectFactoryMethodsByName = new HashMap<>();
    /** Map of the fields of JAXB-generated classes representing AgencyElementType elements. */
    private final Map<String, JAXBSVPCLASS> svpAgencyElementTypeFields;
    /** Map of the fields of JAXB-generated classes representing ItemElementType elements. */
    private final Map<String, JAXBSVPCLASS> svpItemElementTypeFields;
    /** Map of the fields of JAXB-generated classes representing RequestElementType elements. */
    private final Map<String, JAXBSVPCLASS> svpRequestElementTypeFields;
    /** Map of the fields of JAXB-generated classes representing UserElementType elements. */
    private final Map<String, JAXBSVPCLASS> svpUserElementTypeFields;
    /** The Dozer mapper. */
    private Mapper mapper;

    /**
     * Construct a BaseContentConverter.
     * @param jaxbSVPClass the JAXB-generated class used to represent NCIP's SchemeValuePair
     * @param svcPackage the name of the service package containing the model objects that the JAXB objects are mapped to
     */
    protected BaseContentConverter(final Class<JAXBSVPCLASS> jaxbSVPClass, final Package svcPackage) {

        super(Object.class, Object.class);
        this.jaxbSVPClass = jaxbSVPClass;
        this.jaxbPackageNameWithPeriod = jaxbSVPClass.getPackage().getName() + ".";
        this.svcPackageNameWithPeriod = svcPackage.getName() + ".";
        svpAgencyElementTypeFields = createElementNameToJAXBObjectMap(AgencyElementType.iterator());
        svpItemElementTypeFields = createElementNameToJAXBObjectMap(ItemElementType.iterator());
        svpRequestElementTypeFields = createElementNameToJAXBObjectMap(RequestElementType.iterator());
        svpUserElementTypeFields = createElementNameToJAXBObjectMap(UserElementType.iterator());

    }

    /**
     * Create a map by element name of JAXB objects representing an ElementType element.
     * @param iterator iterator over the element's Service class's values.
     * @return the map
     */
    private Map<String, JAXBSVPCLASS> createElementNameToJAXBObjectMap(final Iterator<? extends SchemeValuePair> iterator) {

        final Map<String, JAXBSVPCLASS> map = new HashMap<>();
        while (iterator.hasNext()) {

            final SchemeValuePair svcSVP = iterator.next();
            final String scheme = svcSVP.getScheme();
            final String value = svcSVP.getValue();
            final String fieldName = convertSVPValueToFieldName(value);
            final JAXBSVPCLASS jaxbSVP;
            try {

                jaxbSVP = JAXBHelper.createJAXBSchemeValuePair(jaxbSVPClass, scheme, value);

            } catch (IllegalAccessException | InstantiationException e) {

                throw new MappingException(e);

            }
            map.put(fieldName, jaxbSVP);

        }

        return map;

    }

    /**
     * Convert the Value part of a SchemeValuePair to a field name.
     * Note: The current implementations strips spaces; this is sufficient for all ElementType SchemeValuePair instances, which is the only case where this method is used.
     * @param value the value
     * @return the field name
     */
    private static String convertSVPValueToFieldName(final String value) {
        return value.replace(" ", "");
    }

    private Object mapToSVCObject(final Object jaxbFieldObj) {

        Object svcFieldObj = null;

        final String jaxbElementName = getElementName(jaxbFieldObj);
        final String elementName = ALIASES.getOrDefault(jaxbElementName, jaxbElementName);
        try {
            final String svcClassName = svcPackageNameWithPeriod + elementName;
            final Class<?> svcFieldClass = Class.forName(svcClassName);
            svcFieldObj = mapper.map(jaxbFieldObj, svcFieldClass);
        } catch (ClassNotFoundException e) {
            LOG.warn("Element " + elementName + " for type " + jaxbFieldObj.getClass().getName() + " not mapped.", e);
        }

        return svcFieldObj;
    }

    private Object mapToJAXBObject(final Object svcFieldObj, final String createMethodName) {

        Object jaxbFieldObj = null;

        final Class<?> svcClass = svcFieldObj.getClass();

        if (Boolean.class.isAssignableFrom(svcClass)) {

            if (EMPTY_CONTENT_FIELDS_REGEX.matcher(createMethodName).matches()) {
                if (((boolean) svcFieldObj)) {
                    jaxbFieldObj = JAXBHelper.createEmptyJAXBObject(getObjectFactory(), objectFactoryMethodsByName, createMethodName);
                } // else omit if false
            } else {
                jaxbFieldObj = JAXBHelper.createJAXBObject(getObjectFactory(), objectFactoryMethodsByName, createMethodName, svcFieldObj);
            }

        } else if (BigDecimal.class.isAssignableFrom(svcClass) || String.class.isAssignableFrom(svcClass)) {

            jaxbFieldObj = JAXBHelper.createJAXBObject(getObjectFactory(), objectFactoryMethodsByName, createMethodName, svcFieldObj);

        } else if (GregorianCalendar.class.isAssignableFrom(svcClass)) {

            final XMLGregorianCalendar xmlGregorianCalendar = getDatatypeFactory().newXMLGregorianCalendar((GregorianCalendar) svcFieldObj);

            jaxbFieldObj = JAXBHelper.createJAXBObject(getObjectFactory(), objectFactoryMethodsByName, createMethodName, xmlGregorianCalendar);

        } else if (SchemeValuePair.class.isAssignableFrom(svcClass)) {

            final SchemeValuePair svcSVP = (SchemeValuePair) svcFieldObj;
            final JAXBSVPCLASS jaxbSVP;
            try {

                jaxbSVP = JAXBHelper.createJAXBSchemeValuePair(jaxbSVPClass, svcSVP.getScheme(), svcSVP.getValue());

            } catch (IllegalAccessException | InstantiationException e) {

                throw new MappingException(e);

            }
            jaxbFieldObj = JAXBHelper.createJAXBObject(getObjectFactory(), objectFactoryMethodsByName, createMethodName, jaxbSVP);

        } else {

            final String elementName = svcClass.getSimpleName();
            try {
                final String jaxbClassName = jaxbPackageNameWithPeriod + elementName;
                final Class<?> jaxbClass = Class.forName(jaxbClassName);
                jaxbFieldObj = mapper.map(svcFieldObj, jaxbClass);

            } catch (ClassNotFoundException e) {
                throw new MappingException("Exception creating JAXB object.", e);
            }
        }

        return jaxbFieldObj;
    }

    /**
     * Make a create method name (e.g. "createDateDue") out of a get method name (e.g. "getDateDue"),
     * handling plural forms of the get method (e.g. "getDateDues").
     *
     * @param getMethodName the getter method name
     * @return the method name
     */

    private String makeCreateMethodName(final String getMethodName) {

        String createMethodName = getMethodName;
        if (createMethodName.endsWith("s")) {
            createMethodName = createMethodName.substring(0, createMethodName.length() - 1);
        }
        if (createMethodName.startsWith("get")) {
            createMethodName = createMethodName.substring(3);
        }
        if (!createMethodName.startsWith("create")) {
            createMethodName = "create" + createMethodName;
        }

        return createMethodName;

    }

    // DozerConverter.convertTo is convert to type A, the first generic parm, which in our case is service package class
    @Override
    public Object convertTo(final Object srcObj, final Object destObj) {

        return determineObjectTypeAndConvert(srcObj, destObj);

    }

    // DozerConverter.convertFrom is convert from type B, the second generic parm, which in our case is JAXB class
    @Override
    public Object convertFrom(final Object srcObj, final Object destObj) {

        return determineObjectTypeAndConvert(srcObj, destObj);

    }

    private Object determineObjectTypeAndConvert(final Object srcObj, final Object destObj) {

        final Object newDestObj;
        if (srcObj != null) {

            if (srcObj.getClass().getPackage().getName().matches(ToolkitHelper.TOOLKIT_SERVICE_PACKAGE_PATTERN)) {
                newDestObj = convertToJAXBFromSVC(srcObj, destObj);
            } else if (srcObj.getClass().getPackage().getName().contains(".jaxb.")) {
                newDestObj = convertFromJAXBToSVC(srcObj);
            } else {
                throw new MappingException("The source object does not appear to be a member of Service package " + "or of a JAXB bindings package.");
            }
        } else {
            newDestObj = null;
        }

        return newDestObj;

    }

    /**
     * Convert the JAXB-generated object into the Service object.
     * @param srcJAXBObj the source JAXB-generated object
     * @return the SVC object
     */
    private Object convertFromJAXBToSVC(final Object srcJAXBObj) {

        Object result = null;
        if (srcJAXBObj != null) {

            final Class<?> jaxbClass = srcJAXBObj.getClass();
            final Class<?> svcClass = getSVCClassForElement(jaxbClass.getSimpleName());

            try {
                final Constructor<?> svcCtor = svcClass.getConstructor();
                final Object svcObj = svcCtor.newInstance();
                final Method getContentMethod = jaxbClass.getMethod("getContent");
                final List<Object> contentList = (List<Object>) getContentMethod.invoke(srcJAXBObj);
                for (final Object jaxbFieldObj : contentList) {
                    mapAndSetSVCFieldFromJAXBFieldObject(jaxbFieldObj, svcObj);
                }
                result = svcObj;
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                throw new MappingException("Exception creating service object.", e);
            }
        }

        return result;

    }

    private void mapAndSetSVCFieldFromJAXBFieldObject(final Object jaxbFieldObj, final Object svcObj) {

        final String elementName = getElementName(jaxbFieldObj);
        final Field field = ReflectionHelper.findField(svcObj.getClass(), elementName);
        if (field != null) {
            final Class<?> svcFieldClass = field.getType();
            if (List.class.isAssignableFrom(svcFieldClass)) {
                mapAndSetSVCListFieldFromJAXBObject(jaxbFieldObj, svcObj, elementName);
            } else {
                mapAndSetSVCObjectFieldFromJAXBObject(jaxbFieldObj, svcFieldClass, svcObj, elementName);
            }
        } else {
            if (elementName.compareTo("Ext") == 0) {
                mapSVCFieldFromExtension(jaxbFieldObj, svcObj);
            } else {
                LOG.warn(
                    "content list contained an element (" + elementName + ") for which no similarly-named field was found on the service object (" + svcObj.getClass().getName()
                        + "); skipping that field.");
            }
        }
    }

    private String getExtensionName(final Object jaxbObj) {
        final String extensionName;
        if (jaxbObj instanceof JAXBElement) {
            final JAXBElement<?> jaxbElement = (JAXBElement) jaxbObj;
            extensionName = jaxbElement.getName().getLocalPart();
        } else if (jaxbObj instanceof Node) {
            extensionName = ((Node) jaxbObj).getLocalName();
        } else {
            extensionName = jaxbObj.getClass().getSimpleName();
        }
        return extensionName;
    }

    private void mapSVCFieldFromExtension(final Object jaxbFieldObj, final Object svcObj) {

        final EXTCLASS ext = (EXTCLASS) jaxbFieldObj;
        for (final Object innerJAXBObj : JAXBHelper.getAnyList(ext)) {

            final String extensionName = getExtensionName(innerJAXBObj);
            final Field field = ReflectionHelper.findField(svcObj.getClass(), extensionName);
            if (field != null) {

                final Class<?> svcFieldClass = field.getType();
                if (List.class.isAssignableFrom(svcFieldClass)) {
                    final Method svcSetterMethod = ReflectionHelper.findIndexedCollectionSetter(svcObj.getClass(), extensionName);
                    if (svcSetterMethod != null) {
                        final Class<?>[] svcListTypeClasses = svcSetterMethod.getParameterTypes();
                        if (svcListTypeClasses.length == 2) {
                            final Class<?> svcListTypeClass = svcListTypeClasses[1];
                            final Object svcFieldObj = mapper.map(innerJAXBObj, svcListTypeClass);
                            try {
                                final Method svcGetterMethod = ReflectionHelper.findCollectionGetter(svcObj.getClass(), extensionName);
                                List<Object> svcList = (List<Object>) svcGetterMethod.invoke(svcObj);
                                if (svcList == null) {
                                    svcList = new ArrayList<>();
                                    final Method setMethod = ReflectionHelper.findMethod(svcObj.getClass(), "set" + extensionName, svcFieldClass);
                                    setMethod.invoke(svcList);
                                }
                                svcList.add(svcFieldObj);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new MappingException("Exception invoking get method on service object.", e);
                            }
                        } else {
                            throw new MappingException("Service class's indexed setter method does not have 2 parameters as expected (int index, Object serviceObj).");
                        }
                    } else {
                        throw new MappingException("Service object " + svcObj.getClass() + " field " + extensionName + " is a Collection type but doesn't have a matching getter.");
                    }
                } else if (Boolean.class.isAssignableFrom(svcFieldClass) || boolean.class.isAssignableFrom(svcFieldClass)) {
                    final Method setMethod = ReflectionHelper.findMethod(svcObj.getClass(), "set" + extensionName, svcFieldClass);
                    try {
                        // If the object is there in the JAXB structure, it means 'true'; its absence means 'false' and the service field should default to false.
                        setMethod.invoke(svcObj, true);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new MappingException("Exception invoking set method on service object.", e);
                    }
                } else {
                    final Object svcFieldObj = mapper.map(innerJAXBObj, svcFieldClass);
                    final Method setMethod = ReflectionHelper.findMethod(svcObj.getClass(), "set" + extensionName, svcFieldClass);
                    try {
                        setMethod.invoke(svcObj, svcFieldObj);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new MappingException("Exception invoking set method on service object.", e);
                    }
                }
            } else {
                LOG.warn("content list contained an extension element (" + extensionName + ") for which no similarly-named field" + " was found on the service object (" + svcObj
                    .getClass().getName() + "); skipping that field.");
            }
        }
    }

    private void mapAndSetSVCListFieldFromJAXBObject(final Object jaxbFieldObj, final Object svcObj, final String fieldName) {

        final Object svcFieldObj = mapToSVCObject(jaxbFieldObj);
        final Method getMethod = ReflectionHelper.findMethod(svcObj.getClass(), "get" + fieldName + "s");
        try {

            List<Object> svcList = (List<Object>) getMethod.invoke(svcObj);

            if (svcList == null) {

                svcList = new ArrayList<>();
                final Method setMethod = ReflectionHelper.findMethod(svcObj.getClass(), "set" + fieldName + "s", List.class);

                try {

                    setMethod.invoke(svcObj, svcList);

                } catch (IllegalAccessException | InvocationTargetException e) {

                    throw new MappingException("Exception invoking set method on service object.", e);

                }
            }

            svcList.add(svcFieldObj);

        } catch (IllegalAccessException | InvocationTargetException e) {

            throw new MappingException("Exception invoking get method on service object.", e);

        }

    }

    private void mapAndSetSVCObjectFieldFromJAXBObject(final Object jaxbFieldObj, final Class<?> svcFieldClass, final Object svcObj, final String fieldName) {

        final Object svcFieldObj = mapper.map(jaxbFieldObj, svcFieldClass);
        final Method setMethod = ReflectionHelper.findMethod(svcObj.getClass(), "set" + fieldName, svcFieldClass);
        try {

            setMethod.invoke(svcObj, svcFieldObj);

        } catch (IllegalAccessException | InvocationTargetException e) {

            throw new MappingException("Exception invoking set method on service object.", e);

        }

    }

    // TODO: This doesn't handle the case where jaxbFieldObj is an instanceof Node; but getExtensionName does. Can they be merged?
    private String getElementName(final Object jaxbFieldObj) {

        final String elementName;

        if (jaxbFieldObj instanceof JAXBElement) {

            final JAXBElement<?> jaxbElement = (JAXBElement) jaxbFieldObj;
            elementName = jaxbElement.getName().getLocalPart();

        } else {

            elementName = jaxbFieldObj.getClass().getSimpleName();

        }

        return elementName;
    }

    private Object convertToJAXBFromSVC(final Object srcSVCObj, final Object destJAXBObj) {

        Object result = null;
        LOG.debug("Entered convertToJAXBFromSVC with svcObject " + srcSVCObj + " and destJAXBObj " + destJAXBObj);

        if (srcSVCObj != null) {

            final Class<?> svcClass = srcSVCObj.getClass();
            final String elementName = protocolHelper.getElementName(svcClass);
            final Class<?> jaxbClass = getJAXBClassForElement(elementName);

            try {

                final Object jaxbObj = jaxbClass.getConstructor().newInstance();
                final Method getContentMethod = jaxbObj.getClass().getMethod("getContent");
                final List<Object> workingJAXBContentList = new ArrayList<>();
                final List<Object> jaxbExtensionList = new ArrayList<>();

                final Method[] svcMethods = srcSVCObj.getClass().getMethods();
                final Map<String, Method> getMethods = new HashMap<>();
                for (final Method svcGetMethod : svcMethods) {

                    if (svcGetMethod.getParameterTypes().length == 0) {

                        if (svcGetMethod.getName().startsWith("get")) {

                            String fieldName = svcGetMethod.getName().substring(3);

                            if ("ServiceName".equalsIgnoreCase(fieldName) || "MessageName".equalsIgnoreCase(fieldName) || "Class".equalsIgnoreCase(fieldName)) {
                                continue;
                            }

                            final boolean isCollectionGetter = ReflectionHelper.isCollectionOrMap(svcGetMethod.getReturnType()) && fieldName.charAt(fieldName.length() - 1) == 's';

                            if (isCollectionGetter) {

                                fieldName = fieldName.substring(0, fieldName.length() - 1);

                                // Collection getters always win over non-collection getters.
                                if (getMethods.containsKey(fieldName)) {
                                    LOG.debug("Replacing get method " + getMethods.get(fieldName).getName() + " for field " + fieldName + " with " + svcGetMethod.getName() + ".");
                                } else {
                                    LOG.debug("Adding get method " + svcGetMethod.getName() + " for field " + fieldName);
                                }
                                getMethods.put(fieldName, svcGetMethod);

                            } else {

                                // Don't replace what's already there, it may (or will always) be a collection getter.
                                if (getMethods.containsKey(fieldName)) {
                                    LOG.debug(
                                        "Not replacing get method " + getMethods.get(fieldName).getName() + " for field " + fieldName + " with " + svcGetMethod.getName() + ".");
                                } else {
                                    LOG.debug("Adding get method " + svcGetMethod.getName() + " for field " + fieldName);
                                    getMethods.put(fieldName, svcGetMethod);
                                }

                            }

                        } else {

                            LOG.debug("Method " + svcGetMethod.getName() + " is not a getter; skipping.");

                        }

                    } else {

                        LOG.debug("Method " + svcGetMethod.getName() + " has parameters; skipping.");

                    }

                }

                for (final Method svcGetMethod : getMethods.values()) {
                    mapJAXBFieldFromSVCObject(svcGetMethod, srcSVCObj, workingJAXBContentList, jaxbExtensionList, elementName);
                }

                final List<Object> jaxbContentList = (List<Object>) getContentMethod.invoke(jaxbObj);
                jaxbContentList.clear();

                if (!workingJAXBContentList.isEmpty()) {

                    sortContentList(jaxbContentList, workingJAXBContentList, elementName);

                }

                if (!jaxbExtensionList.isEmpty()) {

                    sortExtensionList(jaxbExtensionList, jaxbContentList, elementName);

                }

                result = jaxbObj;

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

                throw new MappingException("Exception creating JAXB object.", e);

            }

        }

        return result;

    }

    private void sortExtensionList(final List<Object> jaxbExtensionList, final List<Object> jaxbContentList, final String elementName) {

        final ContentMappingComparator comparator = new ContentMappingComparator(extensionElementsByParentObjectName.get(elementName));
        jaxbExtensionList.sort(comparator);

        final EXTCLASS ext = createExtension();
        JAXBHelper.addAllToExtension(ext, jaxbExtensionList);

        jaxbContentList.add(ext);

    }

    private void sortContentList(final List<Object> jaxbContentList, final List<Object> workingJAXBContentList, final String elementName) {

        final ContentMappingComparator comparator = new ContentMappingComparator(elementOrderByParentElementName.get(elementName));
        workingJAXBContentList.sort(comparator);

        jaxbContentList.addAll(workingJAXBContentList);

    }

    private void mapJAXBFieldFromSVCObject(final Method svcGetMethod, final Object srcSVCObj, final List<Object> workingJAXBContentList, final List<Object> jaxbExtensionList,
        final String elementName) {

        LOG.debug("Entered mapJAXBFieldFromSVCObject for " + svcGetMethod.getName());

        final Object svcFieldObj;
        try {

            svcFieldObj = svcGetMethod.invoke(srcSVCObj);

        } catch (IllegalAccessException | InvocationTargetException e) {

            throw new MappingException("Exception invoking get method on service object.", e);

        }

        if (svcFieldObj != null) {

            final Class<?> svcFieldClass = svcGetMethod.getReturnType();

            mapJAXBFieldFromSVCField(srcSVCObj, svcGetMethod, svcFieldClass, svcFieldObj, workingJAXBContentList, jaxbExtensionList, elementName);

        } // If the srcObj's field is null there's nothing to copy

    }

    private void mapJAXBFieldFromSVCField(final Object srcSVCObj, final Method svcGetMethod, final Class<?> svcFieldClass, final Object svcFieldObj,
        final List<Object> workingJAXBContentList, final List<Object> jaxbExtensionList, final String elementName) {

        LOG.debug("Entered mapJAXBFieldFromSVCField for svcFieldClass " + svcFieldClass.getName());

        if (SchemeValuePair.class.getName().compareTo(svcFieldClass.getName()) == 0) {

            throw new MappingException(
                "BaseContentConverter found field named '" + svcGetMethod.getName().substring("get".length()) + "' of type SchemeValuePair in " + srcSVCObj.getClass()
                    + "; this field should have a more narrow type.");

        } else if (isExtension(svcGetMethod, elementName)) {

            final Class<?> svcClass = svcFieldObj.getClass();
            final String createMethodName = makeCreateMethodName(svcGetMethod.getName());

            if (List.class.isAssignableFrom(svcClass)) {
                final List<?> svcFieldList = (List<?>) svcFieldObj;
                for (final Object innerSVCFieldObj : svcFieldList) {
                    final Object jaxbObj = mapToJAXBObject(innerSVCFieldObj, createMethodName);
                    if (jaxbObj != null) {
                        jaxbExtensionList.add(jaxbObj);
                    }
                }
            } else {
                final Object jaxbFieldObj = mapToJAXBObject(svcFieldObj, createMethodName);
                if (jaxbFieldObj != null) {
                    jaxbExtensionList.add(jaxbFieldObj);
                } else {
                    LOG.warn("Got null jaxbFieldObj back from mapping of " + svcFieldObj + ", skipping adding to the JAXB Ext list.");
                }
            }

        } else if (List.class.isAssignableFrom(svcFieldClass)) {

            mapList(svcGetMethod, (List<?>) svcFieldObj, workingJAXBContentList);

        } else if (boolean.class.isInstance(svcFieldObj) || Boolean.class.isInstance(svcFieldObj)) {

            final Boolean svcFieldBoolean = (Boolean) svcFieldObj;
            mapJAXBFieldFromSVCBoolean(svcGetMethod, svcFieldBoolean);

        } else {

            final String createMethodName = makeCreateMethodName(svcGetMethod.getName());
            final Object jaxbFieldObj = mapToJAXBObject(svcFieldObj, createMethodName);
            workingJAXBContentList.add(jaxbFieldObj);

        }

    }

    private boolean isExtension(final Method svcGetMethod, final String elementName) {
        boolean result = false;
        final List<String> extensionElementsList = extensionElementsByParentObjectName.get(elementName);

        final String fieldName = svcGetMethod.getName().substring(3);
        if (extensionElementsList != null && !extensionElementsList.isEmpty() && (fieldNameInList(fieldName, extensionElementsList))) {
            result = true;
        }
        return result;
    }

    private static boolean fieldNameInList(final String fieldName, final List<String> list) {
        boolean result = false;
        if (list.contains(fieldName) || (fieldName.endsWith("s") && list.contains(fieldName.substring(0, fieldName.length() - 1)))) {
            result = true;
        }
        return result;
    }

    private void mapList(final Method svcGetMethod, final List<?> svcFieldObjList, final List<Object> workingJAXBContentList) {

        for (final Object innerSVCFieldObj : svcFieldObjList) {

            final String createMethodName = makeCreateMethodName(svcGetMethod.getName());
            final Object jaxbFieldObj = mapToJAXBObject(innerSVCFieldObj, createMethodName);
            if (jaxbFieldObj != null) {
                workingJAXBContentList.add(jaxbFieldObj);
            }
        }

    }

    private void mapJAXBFieldFromSVCBoolean(final Method svcGetMethod, final Boolean svcFieldValue) {

        // TODO: These need to be references to the lists in the JAXB bean
        final List<JAXBSVPCLASS> agencyElementTypeList = new ArrayList<>();
        final List<JAXBSVPCLASS> itemElementTypeList = new ArrayList<>();
        final List<JAXBSVPCLASS> requestElementTypeList = new ArrayList<>();
        final List<JAXBSVPCLASS> userElementTypeList = new ArrayList<>();

        final String fieldName = svcGetMethod.getName().substring(3);

        if ((boolean) svcFieldValue) {

            if (getAgencyElementType(fieldName) != null) {

                agencyElementTypeList.add(getAgencyElementType(fieldName));

            } else if (getItemElementType(fieldName) != null) {

                itemElementTypeList.add(getItemElementType(fieldName));

            } else if (getRequestElementType(fieldName) != null) {

                requestElementTypeList.add(getRequestElementType(fieldName));

            } else if (getUserElementType(fieldName) != null) {

                userElementTypeList.add(getUserElementType(fieldName));

            } else {

                throw new MappingException("Boolean field " + fieldName + " not recognized.");

            }

        }
        // Otherwise skip it - "false" ElementType fields in the svc object are represented by omitting the ElementType from the jaxb object

    }

    private Class<?> getSVCClassForElement(final String elementName) {

        Class<?> svcClass;
        try {

            svcClass = getElementNamesToServiceClassMap().get(elementName);
            if (svcClass == null) {

                final String className = this.svcPackageNameWithPeriod + elementName;
                svcClass = Class.forName(className);

            }

            return svcClass;

        } catch (ClassNotFoundException e) {

            throw new MappingException("Could not find service-package class for element name '" + elementName + "'.", e);

        }

    }

    private Class<?> getJAXBClassForElement(final String elementName) {

        Class<?> jaxbClass;
        try {

            jaxbClass = getElementNamesToJAXBClassMap().get(elementName);
            if (jaxbClass == null) {

                final String className = this.jaxbPackageNameWithPeriod + elementName;
                jaxbClass = Class.forName(className);

            }

            return jaxbClass;

        } catch (ClassNotFoundException e) {

            throw new MappingException("Could not find JAXB package class for element name '" + elementName + "'.", e);

        }

    }

    public DatatypeFactory getDatatypeFactory() {
        return datatypeFactory;
    }

    /**
     * Set the datatype factory.
     * @param datatypeFactory the factory
     */
    public void setDatatypeFactory(final DatatypeFactory datatypeFactory) {
        this.datatypeFactory = datatypeFactory;
    }

    private JAXBSVPCLASS getAgencyElementType(final String fieldName) {

        return svpAgencyElementTypeFields.get(fieldName);

    }

    private JAXBSVPCLASS getItemElementType(final String fieldName) {

        return svpItemElementTypeFields.get(fieldName);

    }

    private JAXBSVPCLASS getRequestElementType(final String fieldName) {

        return svpRequestElementTypeFields.get(fieldName);

    }

    private JAXBSVPCLASS getUserElementType(final String fieldName) {

        return svpUserElementTypeFields.get(fieldName);

    }

    /**
     * Create an instance of the EXTCLASS type.
     * @return the instance
     */
    protected abstract EXTCLASS createExtension();

    /**
     * Gets the object factory.
     * @return the object factory
     */
    protected abstract Object getObjectFactory();

    /**
     * Gets the mapping of XML element names to service classes representing them.
     * @return the mapping
     */
    protected abstract Map<String, Class<?>> getElementNamesToServiceClassMap();

    /**
     * Gets the mapping of XML element names to JAXB classes representing them.
     * @return the mapping
     */
    protected abstract Map<String, Class<?>> getElementNamesToJAXBClassMap();

    @Override
    public void setMapper(final Mapper mapper) {
        this.mapper = mapper;
    }

    public ProtocolHelper<SM, ID, RD> getProtocolHelper() {
        return protocolHelper;
    }

    public void setProtocolHelper(final ProtocolHelper<SM, ID, RD> protocolHelper) {
        this.protocolHelper = protocolHelper;
    }
}
