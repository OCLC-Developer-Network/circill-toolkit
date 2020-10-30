/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test DatatypeConverter.
 */
public class TestDatatypeConverter {

    private static final String VALID_DATE = "2014-08-30T23:59:59Z";
    private static final String VALID_DATE_IN_OTHER_TZ = "2014-08-30T21:59:59-0200";
    private static final String DATE_WITH_INVALID_TIMEZONE = "2014-08-30T23:59:59-0500";
    private static final String DATE_WITH_OMITTED_TIMEZONE = "2014-08-30T23:59:59";
    private static final String DATE_WITH_OMITTED_TIMEZONE_AS_MARSHALED = "2014-08-30T23:59:59Z";

    @Test
    public void testValidDateRoundTrip() {
        final XMLGregorianCalendar cal = DatatypeConverter.parseDateTime(VALID_DATE);
        final String newDate = DatatypeConverter.printDateTime(cal);
        assertEquals(VALID_DATE, newDate);
    }

    @Test
    public void testMarshallsValidDateInOtherTZ() throws ParseException, DatatypeConfigurationException {
        final DateFormat format = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssZ");
        final Date date = format.parse(VALID_DATE_IN_OTHER_TZ);

        final GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        final XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

        final String newDate = DatatypeConverter.printDateTime(xmlGregorianCalendar);
        assertEquals(VALID_DATE, newDate);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testDateWithInvalidTimezone() {
        final XMLGregorianCalendar cal = DatatypeConverter.parseDateTime(DATE_WITH_INVALID_TIMEZONE);
        final String newDate = DatatypeConverter.printDateTime(cal);
        assertEquals(DATE_WITH_INVALID_TIMEZONE, newDate);
    }

    @Test
    public void testDateWithOmittedTimezone() {
        final XMLGregorianCalendar cal = DatatypeConverter.parseDateTime(DATE_WITH_OMITTED_TIMEZONE);
        final String newDate = DatatypeConverter.printDateTime(cal);
        assertEquals(DATE_WITH_OMITTED_TIMEZONE_AS_MARSHALED, newDate);
    }
}
