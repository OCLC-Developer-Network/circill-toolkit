/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BaseTestPropertyTypes;
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
        tempMap.put("requestingAgencyId", "AgencyId");
        tempMap.put("supplyingAgencyId", "AgencyId");
        tempMap.put("returnAgencyId", "AgencyId");
        tempMap.put("timestamp", "Calendar");
        tempMap.put("timestampReceived", "Calendar");
        tempMap.put("anyEdition", "YesNoType");
        tempMap.put("copyrightCompliance", "CopyrightComplianceType");
        tempMap.put("endDate", "Calendar");
        tempMap.put("startDate", "Calendar");
        tempMap.put("needBeforeDate", "Calendar");
        tempMap.put("preferredFormat", "PreferredFormatType");
        tempMap.put("serviceLevel", "ServiceLevelType");
        tempMap.put("billingMethod", "BillingMethodType");
        tempMap.put("maximumCosts", "Costs");
        tempMap.put("paymentMethod", "PaymentMethodType");
        tempMap.put("country", "CountryType");
        tempMap.put("region", "RegionType");
        tempMap.put("answerYesNo", "YesNoType");
        tempMap.put("offeredCosts", "Costs");
        tempMap.put("reasonRetry", "ReasonRetryType");
        tempMap.put("reasonUnfilled", "ReasonUnfilledType");
        tempMap.put("retryAfter", "Calendar");
        tempMap.put("retryBefore", "Calendar");
        tempMap.put("sendToPatron", "YesNoType");
        tempMap.put("dueDate", "Calendar");
        tempMap.put("expectedDeliveryDate", "Calendar");
        tempMap.put("lastChange", "Calendar");
        tempMap.put("dateSent", "Calendar");
        tempMap.put("deliveredFormat", "DeliveredFormatType");
        tempMap.put("deliveryCosts", "Costs");
        tempMap.put("loanCondition", "LoanConditionType");
        tempMap.put("sentVia", "SentViaType");
        tempMap.put("supplierCode", "AgencyId");
        ALIASES = Collections.unmodifiableMap(tempMap);
    }

    /**
     * The classes have no testable properties.
     * These rules don't apply to the ISO18626Message class.
     */
    private static final Predicate<Class<?>> SKIPPABLE_CLASSES = ISO18626Message.class::equals;

    /**
     * The properties which can be skipped.
     * CurrencyCode is a SchemeValuePair with an additional property, minorUnit, which is expected to have only a read method.
     */
    private static final BiPredicate<Class<?>, String> SKIPPABLE_PROPERTIES = (c, s) -> Version2017CurrencyCode.class.isAssignableFrom(c) && "minorUnit".equals(s);

    @Test
    public void testPropertyNamesMatchGetterAndSetterTypes() throws ReflectiveOperationException, ToolkitException, ServiceException, IOException, IntrospectionException {
        final String packageName = ISO18626Message.class.getPackage().getName();
        super.testPropertyNamesMatchGetterAndSetterTypes(packageName, ALIASES, SKIPPABLE_CLASSES, SKIPPABLE_PROPERTIES);
    }

    @Override
    protected String getSimplifiedTypeName(final String input) {
        final String simpleTypeName;
        final Matcher rawTypeMatcher = SIMPLIFY_RAW_TYPE_NAME_PATTERN.matcher(input);
        if (rawTypeMatcher.matches()) {
            simpleTypeName = rawTypeMatcher.group(1);
        } else {
            final Matcher genericTypeMatcher = SIMPLIFY_GENERIC_TYPE_NAME_PATTERN.matcher(input);
            if (genericTypeMatcher.matches()) {
                if (input.matches("java.util.List<.*>$")) {
                    if (input.matches(".*\\.Address>$")) {
                        simpleTypeName = genericTypeMatcher.group(1) + "es";
                    } else {
                        simpleTypeName = genericTypeMatcher.group(1) + "s";
                    }
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
