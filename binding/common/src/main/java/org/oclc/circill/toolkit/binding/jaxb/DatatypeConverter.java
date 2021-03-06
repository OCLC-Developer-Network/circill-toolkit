/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb;

import static java.util.Calendar.getInstance;
import static java.util.TimeZone.getTimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

@SuppressWarnings("java:S5843") // The regex patterns are necessarily complex
public final class DatatypeConverter {

    private static final Logger LOG = Logger.getLogger(DatatypeConverter.class);

    // We are trusting that hasSameRules has no side-effects, i.e. is thread-safe.
    private static final TimeZone UTC_TIMEZONE = getTimeZone("Etc/UTC");

    private static final DatatypeFactory DEFAULT_DATATYPE_FACTORY;

    @SuppressWarnings("java:S5164") // There's no convenient moment to "remove" the thread-local object.
    private static final ThreadLocal<DateFormat> DATETIME_FORMAT_WITHOUT_MILLIS_SUPPLIER = ThreadLocal.withInitial(() -> {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormat.setTimeZone(UTC_TIMEZONE);
        return dateFormat;
    });

    static {

        try {

            DEFAULT_DATATYPE_FACTORY = DatatypeFactory.newInstance();

        } catch (DatatypeConfigurationException e) {

            LOG.error("Exception creating a datatype factory:", e);
            throw new ExceptionInInitializerError(e);

        }

    }

    private static DatatypeFactory dataTypeFactory = DEFAULT_DATATYPE_FACTORY;

    // Pattern Javadoc says it's thread-safe, but Matcher isn't.
    private static final Pattern TIME_HAS_EXCESS_MILLISECONDS_PATTERN = Pattern.compile("(.*T[0-9]{2}:[0-9]{2}:[0-9]{2}\\.[0-9]{3})([0-9]+)((Z|(\\+|-)?[0-9]{2}:?[0-9]{2})?)$");
    private static final Pattern TIME_HAS_ANY_MILLISECONDS_PATTERN = Pattern.compile("(.*T[0-9]{2}:[0-9]{2}:[0-9]{2})(\\.[0-9]+)((Z|(\\+|-)?[0-9]{2}:?[0-9]{2})?)$");

    private DatatypeConverter() {
        // Utility class
    }

    /**
     * Get the {@link DatatypeFactory}.
     * @return the factory
     */
    public static DatatypeFactory getDataTypeFactory() {
        return dataTypeFactory;
    }

    /**
     * Set the {@link DatatypeFactory}.
     * @param dataTypeFactory the factory
     */
    public static void setDataTypeFactory(final DatatypeFactory dataTypeFactory) {
        DatatypeConverter.dataTypeFactory = dataTypeFactory;
    }

    /**
     * Parse (unmarshall) the date/time, including milliseconds.
     * @param value the string (marshalled) representation of the date/time
     * @return an {@link XMLGregorianCalendar} representation of the date/time
     */
    public static XMLGregorianCalendar parseDateTime(final String value) {

        // Note: To support greater precision than milliseconds we'd have to devise our own date/time class.
        // This simply drops the extra fractional digits so we can use Java's GregorianCalendar.
        String adjustedValue = value;
        if (value != null) {

            final Matcher matcher = TIME_HAS_EXCESS_MILLISECONDS_PATTERN.matcher(value);
            if (matcher.matches()) {

                adjustedValue = matcher.group(1) + matcher.group(3);
                if (LOG.isDebugEnabled() && matcher.group(2).length() > 0) {

                    LOG.debug("Stripped sub-millisecond portion of time '" + value + "', leaving '" + adjustedValue + "'.");

                }

            } // no need to fix this value

        }

        final XMLGregorianCalendar cal = getDataTypeFactory().newXMLGregorianCalendar(adjustedValue);
        if (cal.getTimezone() == DatatypeConstants.FIELD_UNDEFINED) {
            cal.setTimezone(0);
        }
        return cal;

    }

    /**
     * Parse (unmarshall) the date/time, stripping milliseconds.
     * @param value the string (marshalled) representation of the date/time
     * @return an {@link XMLGregorianCalendar} representation of the date/time
     */
    public static XMLGregorianCalendar parseDateTimeStrippingMillis(final String value) {

        String adjustedValue = value;
        if (value != null) {

            final Matcher matcher = TIME_HAS_ANY_MILLISECONDS_PATTERN.matcher(value);
            if (matcher.matches()) {

                adjustedValue = matcher.group(1) + matcher.group(3);
                if (LOG.isDebugEnabled() && matcher.group(2).length() > 0) {

                    LOG.debug("Stripped millisecond portion of time '" + value + "', leaving '" + adjustedValue + "'.");

                }

            } // no need to fix this value

        }

        final XMLGregorianCalendar cal = getDataTypeFactory().newXMLGregorianCalendar(adjustedValue);
        if (cal.getTimezone() == DatatypeConstants.FIELD_UNDEFINED) {
            cal.setTimezone(0);
        }
        return cal;

    }

    /**
     * Print (marshall) the date/time (with milliseconds).
     * @param calendar the {@link XMLGregorianCalendar}
     * @return the printed (marsahlled) representation of the date/time
     */
    public static String printDateTime(final XMLGregorianCalendar calendar) {

        final String result;
        final TimeZone tz = calendar.getTimeZone(DatatypeConstants.FIELD_UNDEFINED);
        if (tz.hasSameRules(UTC_TIMEZONE)) {

            result = javax.xml.bind.DatatypeConverter.printDateTime(calendar.toGregorianCalendar());

        } else {

            // Convert to UTC and then print it
            final Date utcDateTime = calendar.toGregorianCalendar().getTime();
            final GregorianCalendar utcCalendar = (GregorianCalendar) getInstance(getTimeZone("Etc/UTC"));
            utcCalendar.setTime(utcDateTime);

            result = javax.xml.bind.DatatypeConverter.printDateTime(utcCalendar);

        }

        return result;

    }

    /**
     * Print (marshall) the date/time (without milliseconds).
     * @param calendar the {@link XMLGregorianCalendar}
     * @return the printed (marsahlled) representation of the date/time
     */
    public static String printDateTimeWithoutMillis(final XMLGregorianCalendar calendar) {

        final String result;
        final TimeZone tz = calendar.getTimeZone(DatatypeConstants.FIELD_UNDEFINED);
        if (tz.hasSameRules(UTC_TIMEZONE)) {

            result = DATETIME_FORMAT_WITHOUT_MILLIS_SUPPLIER.get().format(calendar.toGregorianCalendar().getTime());

        } else {

            // Convert to UTC and then print it without millis
            final Date utcDateTime = calendar.toGregorianCalendar().getTime();
            final GregorianCalendar utcCalendar = (GregorianCalendar) getInstance(getTimeZone("Etc/UTC"));
            utcCalendar.setTime(utcDateTime);

            result = DATETIME_FORMAT_WITHOUT_MILLIS_SUPPLIER.get().format(utcCalendar.getTime());

        }

        return result;

    }
}
