/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.wclv1_0.jaxb;

import org.oclc.circill.toolkit.binding.wclv1_0.WCLApplicationProfileType;
import org.oclc.circill.toolkit.binding.wclv1_0.WCLNCIPServiceContext;
import org.oclc.circill.toolkit.binding.wclv1_0.WCLv1_0CirculationStatus;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.LoanedItemsCount;
import org.oclc.circill.toolkit.service.ncip.LookupUserInitiationData;
import org.oclc.circill.toolkit.service.ncip.LookupUserResponseData;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.RequestedItemsCount;
import org.oclc.circill.toolkit.service.ncip.Version1CirculationStatus;
import org.oclc.circill.toolkit.service.ncip.Version1ItemUseRestrictionType;
import org.oclc.circill.toolkit.service.ncip.common.ApplicationProfileType;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.Assert;
import org.junit.Test;

public class TestWCLNCIPServiceContext {

    @Test
    public void testOnLoanChargedItemWithoutItemUseRestrictionTypeInResponseValidateAfterMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<LoanedItemsCount> lics = new ArrayList<>();
        final LoanedItemsCount lic1 = new LoanedItemsCount();
        lic1.setCirculationStatus(Version1CirculationStatus.ON_LOAN);
        lic1.setLoanedItemCountValue(BigDecimal.TEN);
        lics.add(lic1);
        lurd.setLoanedItemsCounts(lics);

        (new WCLNCIPServiceContext()).validateAfterUnmarshalling(ncipMessage);

        Assert.assertEquals(1, ncipMessage.getLookupUserResponse().getLoanedItemsCounts().size());
        Assert.assertTrue(ncipMessage.getLookupUserResponse().getLoanedItemsCount(0).getCirculationStatus().equals(WCLv1_0CirculationStatus.ON_LOAN));

    }

    @Test
    public void testOnLoanChargedItemWithTwoDifferentItemUseRestrictionTypesInResponseValidateAfterMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<LoanedItemsCount> lics = new ArrayList<>();
        final LoanedItemsCount lic1 = new LoanedItemsCount();
        lic1.setCirculationStatus(Version1CirculationStatus.ON_LOAN);
        lic1.setLoanedItemCountValue(BigDecimal.TEN);
        lic1.setItemUseRestrictionType(Version1ItemUseRestrictionType.IN_LIBRARY_USE_ONLY);
        lics.add(lic1);
        final LoanedItemsCount lic2 = new LoanedItemsCount();
        lic2.setCirculationStatus(Version1CirculationStatus.ON_LOAN);
        lic2.setLoanedItemCountValue(BigDecimal.TEN);
        lic2.setItemUseRestrictionType(Version1ItemUseRestrictionType.NO_REPRODUCTION);
        lics.add(lic2);
        lurd.setLoanedItemsCounts(lics);

        (new WCLNCIPServiceContext()).validateAfterUnmarshalling(ncipMessage);

        Assert.assertEquals(2, ncipMessage.getLookupUserResponse().getLoanedItemsCounts().size());
        Assert.assertTrue(ncipMessage.getLookupUserResponse().getLoanedItemsCount(0).getCirculationStatus().equals(WCLv1_0CirculationStatus.ON_LOAN));

    }

    @Test
    public void testOverdueChargedItemWithoutItemUseRestrictionTypeInResponseValidateAfterMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<LoanedItemsCount> lics = new ArrayList<>();
        final LoanedItemsCount lic1 = new LoanedItemsCount();
        lic1.setCirculationStatus(new CirculationStatus(Version1CirculationStatus.VERSION_1_CIRCULATION_STATUS, "Overdue"));
        lic1.setLoanedItemCountValue(BigDecimal.TEN);
        lics.add(lic1);
        lurd.setLoanedItemsCounts(lics);

        (new WCLNCIPServiceContext()).validateAfterUnmarshalling(ncipMessage);

        Assert.assertEquals(1, ncipMessage.getLookupUserResponse().getLoanedItemsCounts().size());
        Assert.assertTrue(ncipMessage.getLookupUserResponse().getLoanedItemsCount(0).getCirculationStatus().equals(WCLv1_0CirculationStatus.OVERDUE));

    }

    @Test
    public void testOverdueAndOnLoanChargedItemsWithoutItemUseRestrictionTypeInResponseValidateAfterMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<LoanedItemsCount> lics = new ArrayList<>();
        final LoanedItemsCount lic1 = new LoanedItemsCount();
        lic1.setCirculationStatus(new CirculationStatus(Version1CirculationStatus.VERSION_1_CIRCULATION_STATUS, "Overdue"));
        lic1.setLoanedItemCountValue(BigDecimal.TEN);
        lics.add(lic1);
        final LoanedItemsCount lic2 = new LoanedItemsCount();
        lic2.setCirculationStatus(Version1CirculationStatus.ON_LOAN);
        lic2.setLoanedItemCountValue(new BigDecimal(14));
        lics.add(lic2);
        lurd.setLoanedItemsCounts(lics);

        final List<LoanedItemsCount> originalLics = new ArrayList<>(lics);

        (new WCLNCIPServiceContext()).validateAfterUnmarshalling(ncipMessage);

        assertThat(ncipMessage.getLookupUserResponse().getLoanedItemsCounts(), containsInAnyOrder(originalLics.toArray()));

    }

    @Test
    public void testChargedItemWithUntranslatedCircStatusValueWithoutItemUseRestrictionTypeInResponseValidateBeforeMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<LoanedItemsCount> lics = new ArrayList<>();
        final LoanedItemsCount lic1 = new LoanedItemsCount();
        lic1.setCirculationStatus(new CirculationStatus(Version1CirculationStatus.VERSION_1_CIRCULATION_STATUS, "Madeup"));
        lic1.setLoanedItemCountValue(BigDecimal.TEN);
        lics.add(lic1);
        lurd.setLoanedItemsCounts(lics);

        (new WCLNCIPServiceContext()).validateBeforeMarshalling(ncipMessage);

        Assert.assertEquals(1, ncipMessage.getLookupUserResponse().getLoanedItemsCounts().size());
        Assert.assertFalse(ncipMessage.getLookupUserResponse().getLoanedItemsCount(0).getCirculationStatus().equals(WCLv1_0CirculationStatus.ON_LOAN));

    }

    @Test
    public void testAvailForPickupRequestedItemWithTwoOfSameItemUseRestrictionTypesInResponseValidateAfterMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<RequestedItemsCount> lics = new ArrayList<>();
        final RequestedItemsCount ric1 = new RequestedItemsCount();
        ric1.setCirculationStatus(Version1CirculationStatus.AVAILABLE_FOR_PICKUP);
        ric1.setRequestedItemCountValue(BigDecimal.TEN);
        ric1.setItemUseRestrictionType(Version1ItemUseRestrictionType.IN_LIBRARY_USE_ONLY);
        lics.add(ric1);
        final RequestedItemsCount ric2 = new RequestedItemsCount();
        ric2.setCirculationStatus(Version1CirculationStatus.AVAILABLE_FOR_PICKUP);
        ric2.setRequestedItemCountValue(BigDecimal.TEN);
        ric2.setItemUseRestrictionType(Version1ItemUseRestrictionType.IN_LIBRARY_USE_ONLY);
        lics.add(ric2);
        lurd.setRequestedItemsCounts(lics);

        (new WCLNCIPServiceContext()).validateAfterUnmarshalling(ncipMessage);

        // The two RequestedItemsCount have the same circ status & item use restrictions, so we test that they got combined.
        Assert.assertEquals(1, ncipMessage.getLookupUserResponse().getRequestedItemsCounts().size());
        Assert.assertEquals(BigDecimal.valueOf(20), ncipMessage.getLookupUserResponse().getRequestedItemsCount(0).getRequestedItemCountValue());
        Assert.assertTrue(ncipMessage.getLookupUserResponse().getRequestedItemsCount(0).getCirculationStatus().equals(WCLv1_0CirculationStatus.ON_HOLD));

    }

    @Test
    public void testAvailForPickupRequestedItemWithTwoDifferentItemUseRestrictionTypesInResponseValidateAfterMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<RequestedItemsCount> lics = new ArrayList<>();
        final RequestedItemsCount ric1 = new RequestedItemsCount();
        ric1.setCirculationStatus(Version1CirculationStatus.AVAILABLE_FOR_PICKUP);
        ric1.setRequestedItemCountValue(BigDecimal.TEN);
        ric1.setItemUseRestrictionType(Version1ItemUseRestrictionType.IN_LIBRARY_USE_ONLY);
        lics.add(ric1);
        final RequestedItemsCount ric2 = new RequestedItemsCount();
        ric2.setCirculationStatus(Version1CirculationStatus.AVAILABLE_FOR_PICKUP);
        ric2.setRequestedItemCountValue(BigDecimal.TEN);
        ric2.setItemUseRestrictionType(Version1ItemUseRestrictionType.NO_REPRODUCTION);
        lics.add(ric2);
        lurd.setRequestedItemsCounts(lics);

        (new WCLNCIPServiceContext()).validateAfterUnmarshalling(ncipMessage);

        Assert.assertEquals(2, ncipMessage.getLookupUserResponse().getRequestedItemsCounts().size());
        Assert.assertTrue(ncipMessage.getLookupUserResponse().getRequestedItemsCount(0).getCirculationStatus().equals(WCLv1_0CirculationStatus.ON_HOLD));

    }

    @Test
    public void testInTransitRequestedItemWithoutItemUseRestrictionTypeInResponseValidateAfterMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<RequestedItemsCount> lics = new ArrayList<>();
        final RequestedItemsCount ric1 = new RequestedItemsCount();
        ric1.setCirculationStatus(Version1CirculationStatus.IN_TRANSIT_BETWEEN_LIBRARY_LOCATIONS);
        ric1.setRequestedItemCountValue(BigDecimal.TEN);
        lics.add(ric1);
        lurd.setRequestedItemsCounts(lics);

        (new WCLNCIPServiceContext()).validateAfterUnmarshalling(ncipMessage);

        Assert.assertEquals(1, ncipMessage.getLookupUserResponse().getRequestedItemsCounts().size());
        Assert.assertTrue(ncipMessage.getLookupUserResponse().getRequestedItemsCount(0).getCirculationStatus().equals(WCLv1_0CirculationStatus.DISPATCHED));

    }

    @Test
    public void testRequestedItemWithUntranslatedCircStatusValueWithoutItemUseRestrictionTypeInResponseValidateBeforeMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserResponseData lurd = new LookupUserResponseData();
        ncipMessage.setLookupUserResponse(lurd);
        final List<RequestedItemsCount> rics = new ArrayList<>();
        final RequestedItemsCount ric1 = new RequestedItemsCount();
        ric1.setCirculationStatus(new CirculationStatus(Version1CirculationStatus.VERSION_1_CIRCULATION_STATUS, "Madeup"));
        ric1.setRequestedItemCountValue(BigDecimal.TEN);
        rics.add(ric1);
        lurd.setRequestedItemsCounts(rics);

        (new WCLNCIPServiceContext()).validateBeforeMarshalling(ncipMessage);

        Assert.assertEquals(1, ncipMessage.getLookupUserResponse().getRequestedItemsCounts().size());
        Assert.assertFalse(ncipMessage.getLookupUserResponse().getRequestedItemsCount(0).getCirculationStatus().equals(WCLv1_0CirculationStatus.ON_LOAN));

    }

    @Test
    public void testInitiationWithAppProfileTypeButNotRequiredValidateBeforeMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserInitiationData luid = new LookupUserInitiationData();
        ncipMessage.setLookupUser(luid);
        final InitiationHeader initHdr = new InitiationHeader();
        initHdr.setApplicationProfileType(WCLApplicationProfileType.VERSION_2011);
        luid.setInitiationHeader(initHdr);

        (new WCLNCIPServiceContext()).validateBeforeMarshalling(ncipMessage);

        Assert.assertEquals(ncipMessage.getLookupUser().getInitiationHeader().getApplicationProfileType(), WCLApplicationProfileType.VERSION_2011);

    }

    @Test
    public void testInitiationWithAppProfileTypeAndRequiredValidateBeforeMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserInitiationData luid = new LookupUserInitiationData();
        ncipMessage.setLookupUser(luid);
        final InitiationHeader initHdr = new InitiationHeader();
        initHdr.setApplicationProfileType(WCLApplicationProfileType.VERSION_2011);
        luid.setInitiationHeader(initHdr);

        final WCLNCIPServiceContext serviceContext = new WCLNCIPServiceContext();
        serviceContext.setRequireApplicationProfileType(true);
        serviceContext.validateBeforeMarshalling(ncipMessage);

        Assert.assertEquals(ncipMessage.getLookupUser().getInitiationHeader().getApplicationProfileType(), WCLApplicationProfileType.VERSION_2011);

    }

    @Test(expected = ValidationException.class)
    public void testInitiationWithoutAppProfileTypeAndRequiredValidateBeforeMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserInitiationData luid = new LookupUserInitiationData();
        ncipMessage.setLookupUser(luid);
        final InitiationHeader initHdr = new InitiationHeader();
        luid.setInitiationHeader(initHdr);

        final WCLNCIPServiceContext serviceContext = new WCLNCIPServiceContext();
        serviceContext.setRequireApplicationProfileType(true);
        serviceContext.validateBeforeMarshalling(ncipMessage);

    }

    @Test(expected = ValidationException.class)
    public void testInitiationWithoutInitHdrAndRequiredValidateBeforeMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserInitiationData luid = new LookupUserInitiationData();
        ncipMessage.setLookupUser(luid);

        final WCLNCIPServiceContext serviceContext = new WCLNCIPServiceContext();
        serviceContext.setRequireApplicationProfileType(true);
        serviceContext.validateBeforeMarshalling(ncipMessage);

    }

    @Test(expected = ValidationException.class)
    public void testInitiationWithWrongAppProfileTypeAndRequiredValidateBeforeMarshalling() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final LookupUserInitiationData luid = new LookupUserInitiationData();
        ncipMessage.setLookupUser(luid);
        final InitiationHeader initHdr = new InitiationHeader();
        initHdr.setApplicationProfileType(new ApplicationProfileType("fake scheme", "fake value"));
        luid.setInitiationHeader(initHdr);

        final WCLNCIPServiceContext serviceContext = new WCLNCIPServiceContext();
        serviceContext.setRequireApplicationProfileType(true);
        serviceContext.validateBeforeMarshalling(ncipMessage);

    }

    @Test(expected = ValidationException.class)
    public void testNCIPMessageWithNeitherInitiationNorResponseMessage() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        final WCLNCIPServiceContext serviceContext = new WCLNCIPServiceContext();
        serviceContext.validateBeforeMarshalling(ncipMessage);

    }

    @Test(expected = ValidationException.class)
    public void testNCIPMessageClaimingToBeAnInitiationButWithoutAnyNcipDataObject() throws ToolkitException, ValidationException {
        final NCIPMessage ncipMessage = new NCIPMessage();
        ncipMessage.setLookupUser(null);
        final WCLNCIPServiceContext serviceContext = new WCLNCIPServiceContext();
        serviceContext.setRequireApplicationProfileType(true);
        serviceContext.validateBeforeMarshalling(ncipMessage);

    }

    @Test(expected = ValidationException.class)
    public void testNCIPMessageWithInvocationTargetException() throws ToolkitException, ValidationException {
        final NCIPMessageForInvocationTargetException ncipMessage = new NCIPMessageForInvocationTargetException();
        final WCLNCIPServiceContext serviceContext = new WCLNCIPServiceContext();
        serviceContext.setRequireApplicationProfileType(true);
        serviceContext.validateBeforeMarshalling(ncipMessage);

    }

    @Test(expected = ValidationException.class)
    public void testNCIPMessageWithInvalidAccessException() throws ToolkitException, ValidationException {
        final NCIPMessageForIllegalAccessException ncipMessage = new NCIPMessageForIllegalAccessException();
        final WCLNCIPServiceContext serviceContext = new WCLNCIPServiceContext();
        serviceContext.setRequireApplicationProfileType(true);
        serviceContext.validateBeforeMarshalling(ncipMessage);

    }
}
