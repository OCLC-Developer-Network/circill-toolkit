/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.ExceptionDescription;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;

import org.junit.Assert;
import org.junit.Test;

public class TestToolkitException {

    // Note: Every string test value should begin with "This" and end with a period; the toString tests rely on this to avoid false positives.
    final String CAUSE_MESSAGE = "This is the first cause.";
    final Exception CAUSE = new IllegalArgumentException(CAUSE_MESSAGE);

    final String EXCEPTION_DETAIL_1 = "This is the first exception detail.";
    final String EXCEPTION_CODE_SCHEME_1 = "This is the first exception code scheme.";
    final String EXCEPTION_CODE_VALUE_1 = "This is the first exception code value.";
    final String EXCEPTION_LOCATION_1 = "This is the first exception location.";
    final String EXCEPTION_VALUE_1 = "This is the first exception value.";
    final String EXCEPTION_DETAIL_2 = "This is the second exception detail.";
    final String EXCEPTION_CODE_SCHEME_2 = "This is the second exception code scheme.";
    final String EXCEPTION_CODE_VALUE_2 = "This is the second exception code value.";
    final String EXCEPTION_LOCATION_2 = "This is the second exception location.";
    final String EXCEPTION_VALUE_2 = "This is the second exception value.";

    @Test
    public void TestSingleExceptionDescriptionWithCause() {
        final ToolkitException e = new ServiceException(EXCEPTION_DETAIL_1, EXCEPTION_CODE_SCHEME_1, EXCEPTION_CODE_VALUE_1, EXCEPTION_LOCATION_1, EXCEPTION_VALUE_1, CAUSE);

        Assert.assertSame("Cause is not the same as was given to constructor.", CAUSE, e.getCause());

        final List<ExceptionDescription> descriptions = e.getExceptionDescriptions();
        final ExceptionDescription d = descriptions.get(0);
        Assert.assertSame("Exception detail is not the same as was given to constructor.", EXCEPTION_DETAIL_1, d.getExceptionDetail());
        Assert.assertSame("Exception code scheme is not the same as was given to constructor.", EXCEPTION_CODE_SCHEME_1, d.getExceptionCodeScheme());
        Assert.assertSame("Exception code value is not the same as was given to constructor.", EXCEPTION_CODE_VALUE_1, d.getExceptionCodeValue());
        Assert.assertSame("Exception location is not the same as was given to constructor.", EXCEPTION_LOCATION_1, d.getExceptionLocation());
        Assert.assertSame("Exception value is not the same as was given to constructor.", EXCEPTION_VALUE_1, d.getExceptionValue());

        Assert.assertThat("Exception code scheme is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_SCHEME_1));
        Assert.assertThat("Exception detail is not in the string representation.", e.toString(), containsString(EXCEPTION_DETAIL_1));
        Assert.assertThat("Exception code value is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_VALUE_1));
        Assert.assertThat("Exception location is not in the string representation.", e.toString(), containsString(EXCEPTION_LOCATION_1));
        Assert.assertThat("Exception value is not in the string representation.", e.toString(), containsString(EXCEPTION_VALUE_1));

    }

    @Test
    public void TestSingleExceptionDescriptionWithoutCause() {
        final ToolkitException e = new ServiceException(EXCEPTION_DETAIL_1, EXCEPTION_CODE_SCHEME_1, EXCEPTION_CODE_VALUE_1, EXCEPTION_LOCATION_1, EXCEPTION_VALUE_1);

        Assert.assertNull("Cause is not null.", e.getCause());

        final List<ExceptionDescription> descriptions = e.getExceptionDescriptions();
        final ExceptionDescription d = descriptions.get(0);
        Assert.assertSame("Exception detail is not the same as was given to constructor.", EXCEPTION_DETAIL_1, d.getExceptionDetail());
        Assert.assertSame("Exception code scheme is not the same as was given to constructor.", EXCEPTION_CODE_SCHEME_1, d.getExceptionCodeScheme());
        Assert.assertSame("Exception code value is not the same as was given to constructor.", EXCEPTION_CODE_VALUE_1, d.getExceptionCodeValue());
        Assert.assertSame("Exception location is not the same as was given to constructor.", EXCEPTION_LOCATION_1, d.getExceptionLocation());
        Assert.assertSame("Exception value is not the same as was given to constructor.", EXCEPTION_VALUE_1, d.getExceptionValue());

        Assert.assertThat("Exception code scheme is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_SCHEME_1));
        Assert.assertThat("Exception detail is not in the string representation.", e.toString(), containsString(EXCEPTION_DETAIL_1));
        Assert.assertThat("Exception code value is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_VALUE_1));
        Assert.assertThat("Exception location is not in the string representation.", e.toString(), containsString(EXCEPTION_LOCATION_1));
        Assert.assertThat("Exception value is not in the string representation.", e.toString(), containsString(EXCEPTION_VALUE_1));
    }

    @Test
    public void TestMultipleExceptionDescriptionsWithCause() {
        final List<ExceptionDescription> descriptions = new ArrayList<>(2);
        descriptions.add(new ExceptionDescription(EXCEPTION_DETAIL_1, EXCEPTION_CODE_SCHEME_1, EXCEPTION_CODE_VALUE_1, EXCEPTION_LOCATION_1, EXCEPTION_VALUE_1));
        descriptions.add(new ExceptionDescription(EXCEPTION_DETAIL_2, EXCEPTION_CODE_SCHEME_2, EXCEPTION_CODE_VALUE_2, EXCEPTION_LOCATION_2, EXCEPTION_VALUE_2));
        final ToolkitException e = new ServiceException(descriptions, CAUSE);

        Assert.assertSame("Cause is not the same as was given to constructor.", CAUSE, e.getCause());

        final ExceptionDescription afterDescription1 = descriptions.get(0);
        Assert.assertSame("Exception detail is not the same as was given to constructor.", EXCEPTION_DETAIL_1, afterDescription1.getExceptionDetail());
        Assert.assertSame("Exception code scheme is not the same as was given to constructor.", EXCEPTION_CODE_SCHEME_1, afterDescription1.getExceptionCodeScheme());
        Assert.assertSame("Exception code value is not the same as was given to constructor.", EXCEPTION_CODE_VALUE_1, afterDescription1.getExceptionCodeValue());
        Assert.assertSame("Exception location is not the same as was given to constructor.", EXCEPTION_LOCATION_1, afterDescription1.getExceptionLocation());
        Assert.assertSame("Exception value is not the same as was given to constructor.", EXCEPTION_VALUE_1, afterDescription1.getExceptionValue());
        final ExceptionDescription afterDescription2 = descriptions.get(1);
        Assert.assertSame("Exception detail is not the same as was given to constructor.", EXCEPTION_DETAIL_2, afterDescription2.getExceptionDetail());
        Assert.assertSame("Exception code scheme is not the same as was given to constructor.", EXCEPTION_CODE_SCHEME_2, afterDescription2.getExceptionCodeScheme());
        Assert.assertSame("Exception code value is not the same as was given to constructor.", EXCEPTION_CODE_VALUE_2, afterDescription2.getExceptionCodeValue());
        Assert.assertSame("Exception location is not the same as was given to constructor.", EXCEPTION_LOCATION_2, afterDescription2.getExceptionLocation());
        Assert.assertSame("Exception value is not the same as was given to constructor.", EXCEPTION_VALUE_2, afterDescription2.getExceptionValue());

        Assert.assertThat("Exception code scheme is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_SCHEME_1));
        Assert.assertThat("Exception detail is not in the string representation.", e.toString(), containsString(EXCEPTION_DETAIL_1));
        Assert.assertThat("Exception code value is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_VALUE_1));
        Assert.assertThat("Exception location is not in the string representation.", e.toString(), containsString(EXCEPTION_LOCATION_1));
        Assert.assertThat("Exception value is not in the string representation.", e.toString(), containsString(EXCEPTION_VALUE_1));
        Assert.assertThat("Exception code scheme is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_SCHEME_2));
        Assert.assertThat("Exception detail is not in the string representation.", e.toString(), containsString(EXCEPTION_DETAIL_2));
        Assert.assertThat("Exception code value is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_VALUE_2));
        Assert.assertThat("Exception location is not in the string representation.", e.toString(), containsString(EXCEPTION_LOCATION_2));
        Assert.assertThat("Exception value is not in the string representation.", e.toString(), containsString(EXCEPTION_VALUE_2));
    }

    @Test
    public void TestMultipleExceptionDescriptionsWithoutCause() {
        final List<ExceptionDescription> descriptions = new ArrayList<>(2);
        descriptions.add(new ExceptionDescription(EXCEPTION_DETAIL_1, EXCEPTION_CODE_SCHEME_1, EXCEPTION_CODE_VALUE_1, EXCEPTION_LOCATION_1, EXCEPTION_VALUE_1));
        descriptions.add(new ExceptionDescription(EXCEPTION_DETAIL_2, EXCEPTION_CODE_SCHEME_2, EXCEPTION_CODE_VALUE_2, EXCEPTION_LOCATION_2, EXCEPTION_VALUE_2));
        final ToolkitException e = new ServiceException(descriptions);

        Assert.assertNull("Cause is not null.", e.getCause());

        final ExceptionDescription afterDescription1 = descriptions.get(0);
        Assert.assertSame("Exception detail is not the same as was given to constructor.", EXCEPTION_DETAIL_1, afterDescription1.getExceptionDetail());
        Assert.assertSame("Exception code scheme is not the same as was given to constructor.", EXCEPTION_CODE_SCHEME_1, afterDescription1.getExceptionCodeScheme());
        Assert.assertSame("Exception code value is not the same as was given to constructor.", EXCEPTION_CODE_VALUE_1, afterDescription1.getExceptionCodeValue());
        Assert.assertSame("Exception location is not the same as was given to constructor.", EXCEPTION_LOCATION_1, afterDescription1.getExceptionLocation());
        Assert.assertSame("Exception value is not the same as was given to constructor.", EXCEPTION_VALUE_1, afterDescription1.getExceptionValue());
        final ExceptionDescription afterDescription2 = descriptions.get(1);
        Assert.assertSame("Exception detail is not the same as was given to constructor.", EXCEPTION_DETAIL_2, afterDescription2.getExceptionDetail());
        Assert.assertSame("Exception code scheme is not the same as was given to constructor.", EXCEPTION_CODE_SCHEME_2, afterDescription2.getExceptionCodeScheme());
        Assert.assertSame("Exception code value is not the same as was given to constructor.", EXCEPTION_CODE_VALUE_2, afterDescription2.getExceptionCodeValue());
        Assert.assertSame("Exception location is not the same as was given to constructor.", EXCEPTION_LOCATION_2, afterDescription2.getExceptionLocation());
        Assert.assertSame("Exception value is not the same as was given to constructor.", EXCEPTION_VALUE_2, afterDescription2.getExceptionValue());

        Assert.assertThat("Exception code scheme is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_SCHEME_1));
        Assert.assertThat("Exception detail is not in the string representation.", e.toString(), containsString(EXCEPTION_DETAIL_1));
        Assert.assertThat("Exception code value is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_VALUE_1));
        Assert.assertThat("Exception location is not in the string representation.", e.toString(), containsString(EXCEPTION_LOCATION_1));
        Assert.assertThat("Exception value is not in the string representation.", e.toString(), containsString(EXCEPTION_VALUE_1));
        Assert.assertThat("Exception code scheme is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_SCHEME_2));
        Assert.assertThat("Exception detail is not in the string representation.", e.toString(), containsString(EXCEPTION_DETAIL_2));
        Assert.assertThat("Exception code value is not in the string representation.", e.toString(), containsString(EXCEPTION_CODE_VALUE_2));
        Assert.assertThat("Exception location is not in the string representation.", e.toString(), containsString(EXCEPTION_LOCATION_2));
        Assert.assertThat("Exception value is not in the string representation.", e.toString(), containsString(EXCEPTION_VALUE_2));

    }

}
