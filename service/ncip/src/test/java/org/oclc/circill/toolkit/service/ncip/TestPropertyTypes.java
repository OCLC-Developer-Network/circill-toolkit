/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.BaseTestPropertyTypes;
import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Matcher;

import org.junit.Test;

/**
 * {@inheritDoc}
 */
public class TestPropertyTypes extends BaseTestPropertyTypes {

    /**
     * These are the known cases where a property's type is not a primitive type and
     * does not (allowing for pluralization) match the simple name of the class used
     * to represent it in the Toolkit.
     * This list should have a matching list (with the exception that keys begin with upper case letters) in BaseContentConverter.
     */
    private static final Map<String /*Property Name*/, String /*Type Name*/> ALIASES;

    static {
        final Map<String, String> tempMap = new HashMap<>();
        tempMap.put("relyingPartyId", "AgencyId");
        tempMap.put("acknowledgedItemUseRestrictionType", "ItemUseRestrictionType");
        tempMap.put("acknowledgedItemUseRestrictionTypes", "ItemUseRestrictionTypes");
        tempMap.put("requiredItemUseRestrictionType", "ItemUseRestrictionType");
        tempMap.put("requiredItemUseRestrictionTypes", "ItemUseRestrictionTypes");
        tempMap.put("holdingsSetIds", "Strings");
        tempMap.put("dateReneweds", "GregorianCalendars");
        ALIASES = Collections.unmodifiableMap(tempMap);
    }

    /**
     * The classes have no testable properties.
     * These rules don't apply to the NCIPMessage class.
     */
    private static final Predicate<Class<?>> SKIPPABLE_CLASSES = NCIPMessage.class::equals;

    /**
     * The properties which can be skipped.
     * CurrencyCode is a SchemeValuePair with an additional property, minorUnit, which is expected to have only a read method.
     */
    private static final BiPredicate<Class<?>, String> SKIPPABLE_PROPERTIES = (c, s) -> Version1CurrencyCode.class.isAssignableFrom(c) && "minorUnit".equals(s);

    @Test
    public void testPropertyNamesMatchGetterAndSetterTypes() throws ReflectiveOperationException, ToolkitException, ServiceException, IOException, IntrospectionException {
        final String packageName = NCIPMessage.class.getPackage().getName();
        super.testPropertyNamesMatchGetterAndSetterTypes(packageName, ALIASES, SKIPPABLE_CLASSES, SKIPPABLE_PROPERTIES);
    }

    @Override
    protected String getSimplifiedTypeName(final String input) {
        final String simpleTypeName;
        final Matcher rawTypeMatcher = SIMPLIFY_RAW_TYPE_NAME_PATTERN.matcher(input);
        if (rawTypeMatcher.matches()) {
            // The non-collection read and write methods for this property in UserFiscalAccount is named getAccountDetail to distinguish it from the collection getter,
            // getAccountDetails.
            if (input.matches(".*\\.AccountDetails$")) {
                simpleTypeName = rawTypeMatcher.group(1).substring(0, rawTypeMatcher.group(1).length() - 1);
            } else {
                simpleTypeName = rawTypeMatcher.group(1);
            }
        } else {
            final Matcher genericTypeMatcher = SIMPLIFY_GENERIC_TYPE_NAME_PATTERN.matcher(input);
            if (genericTypeMatcher.matches()) {
                // If the type is a List, pluralize the type name so that it matches the read and write method naming pattern used in the Toolkit.
                // There are two exceptions to the naming pattern, that is StructuredHoldingsData and AccountDetails, because "datas" and "detailses" are unnatural.
                if (input.matches("java.util.List<.*>$") && !input.matches("java.util.List<.*(StructuredHoldingsDatas|AccountDetails)>$")) {
                    simpleTypeName = genericTypeMatcher.group(1) + "s";
                } else {
                    simpleTypeName = genericTypeMatcher.group(1);
                }
            } else {
                simpleTypeName = input;
            }
        }
        return simpleTypeName;
    }

}
