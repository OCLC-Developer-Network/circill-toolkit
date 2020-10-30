/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.ncip;

import org.oclc.circill.toolkit.service.base.CurrencyCode;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.SchemeValuePairHelper;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.Version1CurrencyCode;
import org.oclc.circill.toolkit.service.ncip.LookupAgencyInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupAgencyResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPData;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.Problem;
import org.oclc.circill.toolkit.service.ncip.RequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.Version1MessagingError;
import org.oclc.circill.toolkit.service.ncip.Version1PaymentMethodType;
import org.oclc.circill.toolkit.service.ncip.Version1RequestItemProcessingError;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.xml.sax.SAXParseException;

public class TestNCIPProtocolHelper {

    private static final String PATH = "path";
    private static final String VALUE = "value";
    private static final String DETAILS = "details";
    private static final String EXCEPTION_MESSAGE = "An Exception Arose";
    private static final String CAUSE_MESSAGE = "Something is nothing";
    private static final BigDecimal TEST_MONETARY_AMOUNT = new BigDecimal(12345);
    private static final String JAVA_VERSION = System.getProperty("java.version");
    private static final String JAVA_VERSIONS_9_AND_UP = "^(9\\.|[1-9][0-9]+\\.).*$";

    private final NCIPProtocolHelper protocolHelper = new NCIPProtocolHelper();

    /**
     * Test formatting of a currency with a minor unit of 0.
     */
    @Test
    public void testFormattingOfMinorUnits0() {

        final CurrencyCode jpyCC = Version1CurrencyCode.JPY;
        final String formattedJPY = protocolHelper.formatMonetaryAmount(TEST_MONETARY_AMOUNT, jpyCC);
        assertEquals("12345", formattedJPY);
        final NumberFormat jpyCurrencyNumberFormat = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        final String jpyFormattedWithSymbol = jpyCurrencyNumberFormat.format(protocolHelper.decimalize(TEST_MONETARY_AMOUNT, jpyCC));
        // The \uFFE5 is the "full width Yen sign" in Unicode.
        assertEquals("\uFFE512,345", jpyFormattedWithSymbol);
    }

    /**
     * Test formatting of a currency with a minor unit of 2.
     */
    @Test
    public void testFormattingOfMinorUnits2() {
        final CurrencyCode usdCC = Version1CurrencyCode.USD;
        final String formattedUSD = protocolHelper.formatMonetaryAmount(TEST_MONETARY_AMOUNT, usdCC);
        assertEquals("123.45", formattedUSD);
        final NumberFormat usdCurrencyNumberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        final String usdFormattedWithSymbol = usdCurrencyNumberFormat.format(protocolHelper.decimalize(TEST_MONETARY_AMOUNT, usdCC));
        assertEquals("$123.45", usdFormattedWithSymbol);
    }

    /**
     * Test formatting of a currency with a minor unit of 3.
     */
    @Test
    public void testFormattingOfMinorUnits3() {
        final CurrencyCode bhdCC = Version1CurrencyCode.BHD;
        final String formattedBHD = protocolHelper.formatMonetaryAmount(TEST_MONETARY_AMOUNT, bhdCC);
        assertEquals("12.345", formattedBHD);

        final NumberFormat bhdCurrencyNumberFormat = NumberFormat.getCurrencyInstance(new Locale("ar", "BH"));
        final String bhdFormattedWithSymbol = bhdCurrencyNumberFormat.format(protocolHelper.decimalize(TEST_MONETARY_AMOUNT, bhdCC));
        // The Unicode-escaped hex string is the format for a barhaini dinar as formatted for the Bahrain locale.
        if (JAVA_VERSION.matches(JAVA_VERSIONS_9_AND_UP) ) {
            assertEquals("د.ب.\u200F ١٢٫٣٤٥", bhdFormattedWithSymbol);
        } else {
            assertEquals("\u062f\u002e\u0628\u002e\u200f 12.345", bhdFormattedWithSymbol);
        }
    }

    @Test
    public void test_generateProblems() {
        final List<Problem> problems = protocolHelper.generateProblems(Version1MessagingError.INVALID_MESSAGE_SYNTAX_ERROR, PATH, VALUE, DETAILS);
        assertEquals(1, problems.size());
        assertSame(Version1MessagingError.INVALID_MESSAGE_SYNTAX_ERROR, problems.get(0).getProblemType());
        assertEquals(PATH, problems.get(0).getProblemElement());
        assertEquals(DETAILS, problems.get(0).getProblemDetail());
        assertEquals(VALUE, problems.get(0).getProblemValue());
    }

    @Test
    public void test_generateProblemsWithNullElement() {
        final List<Problem> problems = protocolHelper.generateProblems(Version1MessagingError.INVALID_MESSAGE_SYNTAX_ERROR, null, VALUE, DETAILS);
        assertEquals(1, problems.size());
        assertSame(Version1MessagingError.INVALID_MESSAGE_SYNTAX_ERROR, problems.get(0).getProblemType());
        assertEquals(null, problems.get(0).getProblemElement());
        assertEquals(DETAILS, problems.get(0).getProblemDetail());
        assertEquals(VALUE, problems.get(0).getProblemValue());
    }

    @Test
    public void test_generateProblemsForException() {
        final Throwable cause = new SAXParseException(CAUSE_MESSAGE, "", "", 0, 0);
        final Throwable exception = new IllegalArgumentException(EXCEPTION_MESSAGE, cause);
        final List<Problem> problems = protocolHelper.generateProblems(Version1MessagingError.INVALID_MESSAGE_SYNTAX_ERROR, PATH, VALUE, DETAILS, exception);
        assertEquals(1, problems.size());
        assertSame(Version1MessagingError.INVALID_MESSAGE_SYNTAX_ERROR, problems.get(0).getProblemType());
        assertEquals(PATH, problems.get(0).getProblemElement());
        assertEquals(problems.get(0).getProblemDetail(), DETAILS + System.lineSeparator() + protocolHelper.convertExceptionToString(exception));
        assertEquals(VALUE, problems.get(0).getProblemValue());

    }

    @Test
    public void test_getServiceNameWithNullNCIPData() {
        assertEquals("null", protocolHelper.getServiceName((NCIPData) null));
    }

    @Test
    public void test_getServiceNameWithNullNCIPService() {
        assertEquals("null", protocolHelper.getServiceName((NCIPData) null));
    }

    @Test
    public void test_getElementName() {
        assertEquals("LookupAgency", protocolHelper.getElementName(LookupAgencyInitiationData.class));
        assertEquals("LookupAgencyResponse", protocolHelper.getElementName(LookupAgencyResponseData.class));
        assertEquals("AgencyId", protocolHelper.getElementName(AgencyId.class));
    }

    @Test
    public void test_getMessageName() {
        assertEquals("LookupAgency", (new LookupAgencyInitiationData()).getMessageName());
    }

    @Test
    public void test_decimalize() {
        assertEquals(BigDecimal.valueOf(10.01), protocolHelper.decimalize(BigDecimal.valueOf(1001L), Version1CurrencyCode.USD));
        assertEquals(BigDecimal.valueOf(10.001), protocolHelper.decimalize(BigDecimal.valueOf(10001L), Version1CurrencyCode.BHD));
    }

    @Test
    public void test_undecimalize() {
        assertEquals(BigDecimal.valueOf(1001L), protocolHelper.undecimalize(BigDecimal.valueOf(10.01), Version1CurrencyCode.USD));
        assertEquals(BigDecimal.valueOf(10001L), protocolHelper.undecimalize(BigDecimal.valueOf(10.001), Version1CurrencyCode.BHD));
    }

    @Test
    public void test_formatMonetaryAmount() {
        assertEquals("10.01", protocolHelper.formatMonetaryAmount(BigDecimal.valueOf(1001L), Version1CurrencyCode.USD));
        assertEquals("10.923", protocolHelper.formatMonetaryAmount(BigDecimal.valueOf(10923L), Version1CurrencyCode.BHD));
    }

    @Test
    public void test_createAgencyId() {
        assertEquals(new AgencyId("mine", "yours"), protocolHelper.createAgencyId("mine/yours"));
        assertEquals(new AgencyId("ours"), protocolHelper.createAgencyId("ours"));
    }

    @Test
    public void test_getProblems() throws ServiceException {
        assertEquals("NCIP response object with no problems does not return an empty list", 0, protocolHelper.getProblems(new RequestItemResponseData()).size());
        final NCIPResponseData problemData = new RequestItemResponseData();
        problemData.getProblems().addAll(protocolHelper.generateProblems(Version1MessagingError.INVALID_MESSAGE_SYNTAX_ERROR, PATH, VALUE, DETAILS));
        assertEquals("NCIP response object with one problem does not return a list with size of 1", 1, protocolHelper.getProblems(problemData).size());
        problemData.getProblems().addAll(protocolHelper.generateProblems(Version1RequestItemProcessingError.DUPLICATE_REQUEST, PATH, VALUE, DETAILS));
        assertEquals("NCIP response object with two problems does not return a list with size of 2", 2, protocolHelper.getProblems(problemData).size());
    }

    @Test
    public void test_findSchemeValuePair() throws ToolkitException {
        assertSame("findSchemeValuePair method does not return expected instance", Version1PaymentMethodType.CREDIT_CARD, SchemeValuePairHelper
            .findSchemeValuePair(Version1PaymentMethodType.class, Version1PaymentMethodType.CREDIT_CARD.getScheme(), Version1PaymentMethodType.CREDIT_CARD.getValue()));
    }

    @Test(expected = ToolkitException.class)
    public void test_findSchemeValuePairBadObject() throws ToolkitException {
        class BadSchemeValuePair extends SchemeValuePair {
            BadSchemeValuePair(final String scheme, final String value) {
                super(scheme, value);
            }

            // This is private to force an exception in tested method
            private BadSchemeValuePair find(final String x, final String y) {
                return null;
            }
        }
        SchemeValuePairHelper.findSchemeValuePair(BadSchemeValuePair.class, "", "");
    }

    @Test
    public void test_getFindMethod_Caching() throws ToolkitException {
        final Method method1 = SchemeValuePairHelper.getFindMethod(Version1CurrencyCode.class);
        final Method method2 = SchemeValuePairHelper.getFindMethod(Version1CurrencyCode.class);
        assertSame("getFindMethod did not return the same method object when called with the same class.", method1, method2);
    }
}
