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
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/**
 * Test DatatypeConverter.
 */
public class TestDatatypeConverter {

    private static final XMLGregorianCalendar REFERENCE_DATETIME_IN_UTC;
    private static final XMLGregorianCalendar REFERENCE_DATETIME_WITHOUT_MILLIS_IN_UTC;
    private static final XMLGregorianCalendar REFERENCE_DATETIME_IN_OTHER_TZ;
    static {
        final GregorianCalendar referenceCalendarInUtc = new GregorianCalendar(TimeZone.getTimeZone("Etc/UTC"));
        referenceCalendarInUtc.set(Calendar.YEAR, 2014);
        referenceCalendarInUtc.set(Calendar.MONTH, 7);
        referenceCalendarInUtc.set(Calendar.DAY_OF_MONTH, 30);
        referenceCalendarInUtc.set(Calendar.HOUR_OF_DAY, 23);
        referenceCalendarInUtc.set(Calendar.MINUTE, 59);
        referenceCalendarInUtc.set(Calendar.SECOND, 59);
        referenceCalendarInUtc.set(Calendar.MILLISECOND, 17);

        final GregorianCalendar referenceCalendarWithoutMillisInUtc = new GregorianCalendar(TimeZone.getTimeZone("Etc/UTC"));
        referenceCalendarWithoutMillisInUtc.set(Calendar.YEAR, 2014);
        referenceCalendarWithoutMillisInUtc.set(Calendar.MONTH, 7);
        referenceCalendarWithoutMillisInUtc.set(Calendar.DAY_OF_MONTH, 30);
        referenceCalendarWithoutMillisInUtc.set(Calendar.HOUR_OF_DAY, 23);
        referenceCalendarWithoutMillisInUtc.set(Calendar.MINUTE, 59);
        referenceCalendarWithoutMillisInUtc.set(Calendar.SECOND, 59);
        referenceCalendarWithoutMillisInUtc.set(Calendar.MILLISECOND, 0);

        final GregorianCalendar referenceCalendarInOtherTZ = new GregorianCalendar(TimeZone.getTimeZone("Etc/GMT-2"));
        referenceCalendarInOtherTZ.set(Calendar.YEAR, 2014);
        referenceCalendarInOtherTZ.set(Calendar.MONTH, 7);
        referenceCalendarInOtherTZ.set(Calendar.DAY_OF_MONTH, 30);
        referenceCalendarInOtherTZ.set(Calendar.HOUR_OF_DAY, 21);
        referenceCalendarInOtherTZ.set(Calendar.MINUTE, 59);
        referenceCalendarInOtherTZ.set(Calendar.SECOND, 59);
        referenceCalendarInOtherTZ.set(Calendar.MILLISECOND, 17);

        try {
            REFERENCE_DATETIME_IN_UTC = DatatypeFactory.newInstance().newXMLGregorianCalendar(referenceCalendarInUtc);
            REFERENCE_DATETIME_WITHOUT_MILLIS_IN_UTC = DatatypeFactory.newInstance().newXMLGregorianCalendar(referenceCalendarWithoutMillisInUtc);
            final Date utcDateTime = REFERENCE_DATETIME_IN_UTC.toGregorianCalendar().getTime();
            final GregorianCalendar utcCalendar = (GregorianCalendar) GregorianCalendar.getInstance(TimeZone.getTimeZone("Etc/GMT-2"));
            utcCalendar.setTime(utcDateTime);
            REFERENCE_DATETIME_IN_OTHER_TZ = DatatypeFactory.newInstance().newXMLGregorianCalendar(utcCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static final String FORMATTED_DATETIME_WITH_MILLIS_IN_UTC = "2014-08-30T23:59:59.017Z";
    private static final String FORMATTED_DATETIME_WITHOUT_MILLIS_IN_UTC = "2014-08-30T23:59:59Z";
    private static final String FORMATTED_DATETIME_WITH_MILLIS_IN_OTHER_TZ = "2014-08-30T21:59:59.017-02:00";
    private static final String FORMATTED_DATETIME_WITHOUT_MILLIS_IN_OTHER_TZ = "2014-08-30T21:59:59-02:00";
    private static final String FORMATTED_DATETIME_WITH_INVALID_TIMEZONE = "2014-08-30T23:59:59-0500";
    private static final String FORMATTED_DATETIME_WITH_OMITTED_TIMEZONE = "2014-08-30T23:59:59";
    private static final String FORMATTED_DATETIME_WITH_OMITTED_TIMEZONE_AS_MARSHALED = "2014-08-30T23:59:59Z";

    @Test
    public void testMarshallDateTimeWithMillisInUTC() {
        final String newDate = DatatypeConverter.printDateTime(REFERENCE_DATETIME_IN_UTC);
        assertEquals(FORMATTED_DATETIME_WITH_MILLIS_IN_UTC, newDate);
    }

    @Test
    public void testUnmarshallDateTimeWithMillisInUTC() {
        final XMLGregorianCalendar newXMLGregorianCalendar = DatatypeConverter.parseDateTime(FORMATTED_DATETIME_WITH_MILLIS_IN_UTC);
        assertEquals(REFERENCE_DATETIME_IN_UTC, newXMLGregorianCalendar);
    }

    @Test
    public void testMarshallDateTimeWithMillisInOtherTZ() throws ParseException, DatatypeConfigurationException {
        final String newDate = DatatypeConverter.printDateTime(REFERENCE_DATETIME_IN_OTHER_TZ);
        assertEquals(FORMATTED_DATETIME_WITH_MILLIS_IN_UTC, newDate);
    }

    @Test
    public void testUnmarshallDateTimeWithMillisInOtherTZ() {
        final XMLGregorianCalendar newXMLGregorianCalendar = DatatypeConverter.parseDateTime(FORMATTED_DATETIME_WITH_MILLIS_IN_OTHER_TZ);
        assertEquals(REFERENCE_DATETIME_IN_UTC, newXMLGregorianCalendar);
    }

    @Test
    public void testMarshallDateTimeWithoutMillisInUTC() {
        final String newDate = DatatypeConverter.printDateTimeWithoutMillis(REFERENCE_DATETIME_IN_UTC);
        assertEquals(FORMATTED_DATETIME_WITHOUT_MILLIS_IN_UTC, newDate);
    }

    @Test
    public void testUnmarshallDateTimeWithoutMillisFromDateTimeWithoutMillisInUTC() {
        final XMLGregorianCalendar newXMLGregorianCalendar = DatatypeConverter.parseDateTimeStrippingMillis(FORMATTED_DATETIME_WITHOUT_MILLIS_IN_UTC);
        assertEquals(REFERENCE_DATETIME_WITHOUT_MILLIS_IN_UTC, newXMLGregorianCalendar);
    }

    @Test
    public void testUnmarshallDateTimeWithoutMillisFromDateTimeWithMillisInUTC() {
        final XMLGregorianCalendar newXMLGregorianCalendar = DatatypeConverter.parseDateTimeStrippingMillis(FORMATTED_DATETIME_WITH_MILLIS_IN_UTC);
        assertEquals(REFERENCE_DATETIME_WITHOUT_MILLIS_IN_UTC, newXMLGregorianCalendar);
    }

    @Test
    public void testMarshallDateTimeWithoutMillisInOtherTZ() throws ParseException, DatatypeConfigurationException {
        final String newDate = DatatypeConverter.printDateTimeWithoutMillis(REFERENCE_DATETIME_IN_OTHER_TZ);
        assertEquals(FORMATTED_DATETIME_WITHOUT_MILLIS_IN_UTC, newDate);
    }

    @Test
    public void testUnmarshallDateTimeWithoutMillisFromDateTimeWithoutMillisInOtherTZ() {
        final XMLGregorianCalendar newXMLGregorianCalendar = DatatypeConverter.parseDateTime(FORMATTED_DATETIME_WITHOUT_MILLIS_IN_OTHER_TZ);
        assertEquals(REFERENCE_DATETIME_WITHOUT_MILLIS_IN_UTC, newXMLGregorianCalendar);
    }

    @Test
    public void testUnmarshallDateTimeWithoutMillisFromDateTimeWithMillisInOtherTZ() {
        final XMLGregorianCalendar newXMLGregorianCalendar = DatatypeConverter.parseDateTimeStrippingMillis(FORMATTED_DATETIME_WITH_MILLIS_IN_OTHER_TZ);
        assertEquals(REFERENCE_DATETIME_WITHOUT_MILLIS_IN_UTC, newXMLGregorianCalendar);
    }

    @Test
    public void testUnmarhallsDateWithInvalidTimezone() {
        assertThrows(IllegalArgumentException.class, () -> DatatypeConverter.parseDateTime(FORMATTED_DATETIME_WITH_INVALID_TIMEZONE));
    }

    @Test
    public void testUnmarhallsDateWithOmittedTimezone() {
        final XMLGregorianCalendar cal = DatatypeConverter.parseDateTime(FORMATTED_DATETIME_WITH_OMITTED_TIMEZONE);
        final String newDate = DatatypeConverter.printDateTime(cal);
        assertEquals(FORMATTED_DATETIME_WITH_OMITTED_TIMEZONE_AS_MARSHALED, newDate);
    }
}
