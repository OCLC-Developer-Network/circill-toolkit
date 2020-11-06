/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.ncip;

import org.oclc.circill.toolkit.service.base.BaseTestNonSVPBeans;
import org.oclc.circill.toolkit.service.base.BibliographicItemId;
import org.oclc.circill.toolkit.service.base.ElectronicAddress;
import org.oclc.circill.toolkit.service.base.PropertyInfo;
import org.oclc.circill.toolkit.service.base.Repeatability;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.TestNonSVPBeansException;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromSystemId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.OnBehalfOfAgency;
import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToStringExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSettersExcluding;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.code.beanmatchers.ValueGenerator;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

/**
 * Unit tests for beans which aren't sub-classes of {@link SchemeValuePair}.
 */
public class TestNonSVPBeans extends BaseTestNonSVPBeans {

    private static final String PROBLEM_ELEMENT_STRING = "PROBLEM ELEMENT";
    private static final String PROBLEM_VALUE_STRING = "PROBLEM VALUE";
    private static final String PROBLEM_DETAIL_STRING = "PROBLEM DETAIL";
    private static final String PROBLEM_TYPE_SCHEME_STRING = "PROBLEM TYPE SCHEME";
    private static final String PROBLEM_TYPE_VALUE_STRING = "PROBLEM TYPE VALUE";

    protected final ValueGenerator<NCIPInitiationData> initiationDataValueGenerator = () -> {
        final LookupItemInitiationData value = new LookupItemInitiationData();
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue(Double.toString(Math.random()));
        value.setItemId(itemId);
        return value;
    };
    protected final ValueGenerator<NCIPResponseData> responseDataValueGenerator = () -> {
        final LookupItemResponseData value = new LookupItemResponseData();
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue(Double.toString(Math.random()));
        value.setItemId(itemId);
        return value;
    };
    protected final ValueGenerator<Problem> problemValueGenerator = () -> {
        final Problem value = new Problem();
        value.setProblemElement(Double.toString(Math.random()));
        value.setProblemValue(Double.toString(Math.random()));
        value.setProblemDetail(Double.toString(Math.random()));
        value.setProblemType(new ProblemType(Double.toString(Math.random()), Double.toString(Math.random())));
        return value;
    };
    protected final ValueGenerator<ItemUseRestrictionType> itemUseRestrictionTypeValueGenerator = () -> {
        final ItemUseRestrictionType value = new ItemUseRestrictionType(Double.toString(Math.random()), Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<List<ItemInformation>> itemInformationValueGenerator = (ValueGenerator) () -> {
        final ItemInformation value = new ItemInformation();
        value.setItemNote(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<EnumerationLevelInstance> enumerationLevelInstanceValueGenerator = () -> {
        final EnumerationLevelInstance value = new EnumerationLevelInstance();
        value.setEnumerationCaption(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<ChronologyLevelInstance> chronologyLevelInstanceValueGenerator = () -> {
        final ChronologyLevelInstance value = new ChronologyLevelInstance();
        value.setChronologyCaption(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<RelatedFiscalTransactionReferenceId> relatedFiscalTransactionReferenceIdValueGenerator = () -> {
        final RelatedFiscalTransactionReferenceId value = new RelatedFiscalTransactionReferenceId();
        value.setFiscalTransactionIdentifierValue(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<RequestId> requestIdValueGenerator = () -> {
        final RequestId value = new RequestId();
        value.setRequestIdentifierValue(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<BibliographicId> bibliographicIdValueGenerator = () -> {
        final BibliographicId value = new BibliographicId();
        final BibliographicRecordId bibliographicRecordId = new BibliographicRecordId();
        bibliographicRecordId.setBibliographicRecordIdentifier(Double.toString(Math.random()));
        value.setBibliographicRecordId(bibliographicRecordId);
        return value;
    };
    protected final ValueGenerator<BibliographicItemId> bibliographicItemIdValueGenerator = () -> {
        final BibliographicItemId value = new BibliographicItemId();
        value.setBibliographicItemIdentifier(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<BibliographicRecordId> bibliographicRecordIdValueGenerator = () -> {
        final BibliographicRecordId value = new BibliographicRecordId();
        value.setBibliographicRecordIdentifier(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<LocationNameInstance> locationNameInstanceValueGenerator = () -> {
        final LocationNameInstance value = new LocationNameInstance();
        value.setLocationNameValue(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<Location> locationValueGenerator = () -> {
        final Location value = new Location();
        final LocationName locationName = new LocationName();
        final LocationNameInstance lni = locationNameInstanceValueGenerator.generate();
        final List<LocationNameInstance> lniList = new ArrayList<>();
        lniList.add(lni);
        locationName.setLocationNameInstances(lniList);
        value.setLocationName(locationName);
        return value;
    };
    protected final ValueGenerator<ItemId> itemIdValueGenerator = () -> {
        final ItemId value = new ItemId();
        value.setItemIdentifierValue(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<HoldingsSet> holdingsSetValueGenerator = () -> {
        final HoldingsSet value = new HoldingsSet();
        value.setCallNumber(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<BibInformation> bibInformationValueGenerator = () -> {
        final BibliographicRecordId bibRecId = new BibliographicRecordId();
        bibRecId.setBibliographicRecordIdentifier(Double.toString(Math.random()));
        final BibliographicId bibId = new BibliographicId();
        bibId.setBibliographicRecordId(bibRecId);
        final BibInformation value = new BibInformation();
        value.setBibliographicId(bibId);
        return value;
    };
    protected final ValueGenerator<ResponseElementControl> responseElementControlValueGenerator = () -> {
        final ResponseElementControl value = new ResponseElementControl();
        value.setMaximumCount(BigDecimal.valueOf(Math.random()));
        return value;
    };
    protected final ValueGenerator<AuthenticationInput> authenticationInputValueGenerator = () -> {
        final AuthenticationInput value = new AuthenticationInput();
        value.setAuthenticationInputData(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<UserFiscalAccount> userFiscalAccountValueGenerator = () -> {
        final AccountBalance accountBalance = new AccountBalance();
        accountBalance.setMonetaryValue(BigDecimal.valueOf(Math.random()));
        final UserFiscalAccount value = new UserFiscalAccount();
        value.setAccountBalance(accountBalance);
        return value;
    };
    protected final ValueGenerator<LoanedItemsCount> loanedItemsCountValueGenerator = () -> {
        final LoanedItemsCount value = new LoanedItemsCount();
        value.setLoanedItemCountValue(BigDecimal.valueOf(Math.random()));
        return value;
    };
    protected final ValueGenerator<LoanedItem> loanedItemsValueGenerator = () -> {
        final LoanedItem value = new LoanedItem();
        value.setRenewalCount(BigDecimal.valueOf(Math.random()));
        return value;
    };
    protected final ValueGenerator<RequestedItemsCount> requestedItemsCountValueGenerator = () -> {
        final RequestedItemsCount value = new RequestedItemsCount();
        value.setRequestedItemCountValue(BigDecimal.valueOf(Math.random()));
        return value;
    };
    protected final ValueGenerator<RequestedItem> requestedItemValueGenerator = () -> {
        final RequestedItem value = new RequestedItem();
        value.setHoldQueueLength(BigDecimal.valueOf(Math.random()));
        return value;
    };
    protected final ValueGenerator<SubsequentElementControl> subsequentElementControlValueGenerator = () -> {
        final SubsequentElementControl value = new SubsequentElementControl();
        value.setNextElement(BigDecimal.valueOf(Math.random()));
        return value;
    };
    protected final ValueGenerator<OrganizationNameInformation> organizationNameInformationValueGenerator = () -> {
        final OrganizationNameInformation value = new OrganizationNameInformation();
        value.setOrganizationName(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<UserId> userIdValueGenerator = () -> {
        final UserId value = new UserId();
        value.setUserIdentifierValue(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<CurrentRequester> currentRequesterValueGenerator = () -> {
        final CurrentRequester value = new CurrentRequester();
        value.setUserId(userIdValueGenerator.generate());
        return value;
    };
    protected final ValueGenerator<UserLanguage> userLanguageValueGenerator = () -> {
        final UserLanguage value = new UserLanguage(Double.toString(Math.random()), Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<UserPrivilege> userPrivilegeValueGenerator = () -> {
        final UserPrivilege value = new UserPrivilege();
        value.setUserPrivilegeDescription(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<HoldingsChronology> holdingsChronologyValueGenerator = () -> {
        final HoldingsChronology value = new HoldingsChronology();
        final List<ChronologyLevelInstance> chronologyLevelInstanceList = new ArrayList<>();
        chronologyLevelInstanceList.add(chronologyLevelInstanceValueGenerator.generate());
        value.setChronologyLevelInstances(chronologyLevelInstanceList);
        return value;
    };
    protected final ValueGenerator<StructuredHoldingsData> structuredHoldingsDataValueGenerator = () -> {
        final StructuredHoldingsData value = new StructuredHoldingsData();
        value.setHoldingsChronology(holdingsChronologyValueGenerator.generate());
        return value;
    };
    protected final ValueGenerator<PreviousUserId> previousUserIdValueGenerator = () -> {
        final PreviousUserId value = new PreviousUserId();
        value.setUserIdentifierValue(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<String> stringValueGenerator = () -> {
        final String value = Double.toString(Math.random());
        return value;
    };
    protected final ValueGenerator<PermittedUserAction> permittedUserActionValueGenerator = () -> {
        final PermittedUserAction value = new PermittedUserAction(Double.toString(Math.random()), Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<NoticeId> noticeIdValueGenerator = () -> {
        final NoticeId value = new NoticeId();
        value.setAgencyId(new AgencyId(Double.toString(Math.random()), Double.toString(Math.random())));
        value.setNoticeIdentifierType(new NoticeIdentifierType(Double.toString(Math.random()), Double.toString(Math.random())));
        value.setNoticeIdentifierValue(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<NoticeInformation> noticeInformationValueGenerator = () -> {
        final NoticeInformation value = new NoticeInformation();
        value.setNoticeId(noticeIdValueGenerator.generate());
        value.setNoticeType(new NoticeType(Double.toString(Math.random()), Double.toString(Math.random())));
        return value;
    };
    //
    protected final ValueGenerator<UserLimit> userLimitsValueGenerator = () -> {
        final UserLimit value = new UserLimit();
        value.setLimitType(new LimitType(Double.toString(Math.random()), Double.toString(Math.random())));
        value.setLimitValue(BigDecimal.valueOf(Math.random()));
        return value;
    };
    protected final ValueGenerator<RelatedSystemRequestId> relatedSystemRequestIdValueGenerator = () -> {
        final RelatedSystemRequestId value = new RelatedSystemRequestId();
        value.setFromSystemId(new FromSystemId(Double.toString(Math.random())));
        value.setRequestId(requestIdValueGenerator.generate());
        return value;
    };
    private final Random random = new Random();
    protected final ValueGenerator<GregorianCalendar> dateRenewedValueGenerator = () -> {
        final GregorianCalendar value = new GregorianCalendar();
        value.add(Calendar.MINUTE, -randomInt(1, 100));
        return value;
    };
    protected final ValueGenerator<AccountDetails> accountDetailValueGenerator = () -> {
        final AccountDetails value = new AccountDetails();
        final GregorianCalendar c = new GregorianCalendar();
        c.add(Calendar.MINUTE, -randomInt(1, 100));
        value.setAccrualDate(c);
        return value;
    };
    protected final ValueGenerator<UserAddressInformation> userAddressInformationValueGenerator = () -> {
        final UserAddressInformation value = new UserAddressInformation();
        final GregorianCalendar c = new GregorianCalendar();
        c.add(Calendar.MINUTE, -randomInt(1, 100));
        value.setValidFromDate(c);
        return value;
    };
    protected final ValueGenerator<BlockOrTrap> blockOrTrapValueGenerator = () -> {
        final BlockOrTrap value = new BlockOrTrap();
        final GregorianCalendar c = new GregorianCalendar();
        c.add(Calendar.MINUTE, -randomInt(1, 100));
        value.setValidFromDate(c);
        return value;
    };

    protected int randomInt(final int min, final int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    @Test
    public void testNCIPMessage()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(NCIPMessage.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("initiationData", "initiationMessage", "responseData", "responseMessage"),
            hasValidBeanHashCodeExcluding("initiationData", "initiationMessage", "responseData", "responseMessage"),
            hasValidBeanEqualsExcluding("initiationData", "initiationMessage", "responseData", "responseMessage"),
            hasValidBeanToStringExcluding("initiationData", "initiationMessage", "responseData", "responseMessage")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.SIMPLE, "initiationData", initiationDataValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.SIMPLE, "responseData", responseDataValueGenerator));
        testExcludedProperties(NCIPMessage.class, propertyInfos);
    }

    @Test
    public void testUserUpdatedInitiationData() {
        assertThat(UserUpdatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserUpdatedResponseData() {
        assertThat(UserUpdatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testMandatedAction() {
        assertThat(MandatedAction.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCurrentBorrower() {
        assertThat(CurrentBorrower.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testSubsequentElementControl() {
        assertThat(SubsequentElementControl.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testStructuredHoldingsData() {
        assertThat(StructuredHoldingsData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testIndeterminateLoanPeriodFlag() {
        assertThat(IndeterminateLoanPeriodFlag.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
        final IndeterminateLoanPeriodFlag flag1 = new IndeterminateLoanPeriodFlag();
        final IndeterminateLoanPeriodFlag flag2 = new IndeterminateLoanPeriodFlag();
        assertEquals("Two instances of IndeterminateLoanFlag are not equal.", flag1, flag2);
    }

    @Test
    public void testComponentId() {
        assertThat(ComponentId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAmount() {
        assertThat(Amount.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAcknowledgedFeeAmount() {
        assertThat(AcknowledgedFeeAmount.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRequiredFeeAmount() {
        assertThat(RequiredFeeAmount.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAccountBalance() {
        assertThat(AccountBalance.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testPaidFeeAmount() {
        assertThat(PaidFeeAmount.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLocationNameInstance() {
        assertThat(LocationNameInstance.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserPrivilegeStatus() {
        assertThat(UserPrivilegeStatus.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testPhysicalCondition() {
        assertThat(PhysicalCondition.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testFiscalTransactionReferenceId() {
        assertThat(FiscalTransactionReferenceId.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCitationSource() {
        assertThat(CitationSource.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserFiscalAccountSummary() {
        assertThat(UserFiscalAccountSummary.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserPrivilegeFee() {
        assertThat(UserPrivilegeFee.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testPersonalNameInformation() {
        assertThat(PersonalNameInformation.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testBibliographicDescription()
        throws ToolkitException, TestNonSVPBeansException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        assertThat(BibliographicDescription.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("bibliographicItemId", "bibliographicRecordId"),
            hasValidBeanHashCodeExcluding("bibliographicItemId", "bibliographicRecordId"), hasValidBeanEqualsExcluding("bibliographicItemId", "bibliographicRecordId"),
            hasValidBeanToStringExcluding("bibliographicItemId", "bibliographicRecordId")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "bibliographicItemId", bibliographicItemIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "bibliographicRecordId", bibliographicRecordIdValueGenerator));
        testExcludedProperties(BibliographicDescription.class, propertyInfos);
    }

    @Test
    public void testBibliographicId() {
        assertThat(BibliographicId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testElectronicAddress() {
        assertThat(ElectronicAddress.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRelatedFiscalTransactionReferenceId() {
        assertThat(RelatedFiscalTransactionReferenceId.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testOrganizationNameInformation() {
        assertThat(OrganizationNameInformation.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDestination() {
        assertThat(Destination.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUnstructuredAddress() {
        assertThat(UnstructuredAddress.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testBibliographicItemId() {
        assertThat(BibliographicItemId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserId() {
        assertThat(UserId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAcceptItemInitiationData() {
        assertThat(AcceptItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAcceptItemResponseData()
        throws ToolkitException, TestNonSVPBeansException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        assertThat(AcceptItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("problem"), hasValidBeanHashCodeExcluding("problem"), hasValidBeanEqualsExcluding("problem"),
                hasValidBeanToStringExcluding("problem")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        testExcludedProperties(AcceptItemResponseData.class, propertyInfos);
    }

    @Test
    public void testAccountDetails() {
        assertThat(AccountDetails.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAddAgencyFields() {
        assertThat(AddAgencyFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAddItemFields() {
        assertThat(AddItemFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAddRequestFields() {
        assertThat(AddRequestFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAddUserFields() {
        assertThat(AddUserFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAgencyAddressInformation() {
        assertThat(AgencyAddressInformation.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAgencyCreatedInitiationData() {
        assertThat(AgencyCreatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAgencyCreatedResponseData() {
        assertThat(AgencyCreatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAgencyUpdatedInitiationData() {
        assertThat(AgencyUpdatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAgencyUpdatedResponseData() {
        assertThat(AgencyUpdatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAuthenticationInput() {
        assertThat(AuthenticationInput.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testAuthenticationPrompt() {
        assertThat(AuthenticationPrompt.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testBibInformation()
        throws ToolkitException, TestNonSVPBeansException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        assertThat(BibInformation.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("currentRequester", "holdingsSet", "problem"),
            hasValidBeanHashCodeExcluding("currentRequester", "holdingsSet", "problem"), hasValidBeanEqualsExcluding("currentRequester", "holdingsSet", "problem"),
            hasValidBeanToStringExcluding("currentRequester", "holdingsSet", "problem")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "currentRequester", currentRequesterValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "holdingsSet", holdingsSetValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        testExcludedProperties(BibInformation.class, propertyInfos);
    }

    @Test
    public void testBibliographicRecordId() {
        assertThat(BibliographicRecordId.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testBlockOrTrap() {
        assertThat(BlockOrTrap.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCancelRecallItemInitiationData() {
        assertThat(CancelRecallItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCancelRecallItemResponseData() {
        assertThat(CancelRecallItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCancelRequestItemInitiationData() {
        assertThat(CancelRequestItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCancelRequestItemResponseData() {
        assertThat(CancelRequestItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCheckInItemInitiationData() {
        assertThat(CheckInItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCheckInItemResponseData()
        throws ToolkitException, TestNonSVPBeansException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        assertThat(CheckInItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("problem"), hasValidBeanHashCodeExcluding("problem"), hasValidBeanEqualsExcluding("problem"),
                hasValidBeanToStringExcluding("problem")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        testExcludedProperties(CheckInItemResponseData.class, propertyInfos);
    }

    @Test
    public void testCheckOutItemInitiationData()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(CheckOutItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("authenticationInput", "acknowledgedItemUseRestrictionType"),
                hasValidBeanHashCodeExcluding("authenticationInput", "acknowledgedItemUseRestrictionType"),
                hasValidBeanEqualsExcluding("authenticationInput", "acknowledgedItemUseRestrictionType"),
                hasValidBeanToStringExcluding("authenticationInput", "acknowledgedItemUseRestrictionType")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "authenticationInput", authenticationInputValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "acknowledgedItemUseRestrictionType", itemUseRestrictionTypeValueGenerator));
        testExcludedProperties(CheckOutItemInitiationData.class, propertyInfos);
    }

    @Test
    public void testCheckOutItemResponseData()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(CheckOutItemResponseData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("problem", "requiredItemUseRestrictionType"),
            hasValidBeanHashCodeExcluding("problem", "requiredItemUseRestrictionType"), hasValidBeanEqualsExcluding("problem", "requiredItemUseRestrictionType"),
            hasValidBeanToStringExcluding("problem", "requiredItemUseRestrictionType")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "requiredItemUseRestrictionType", itemUseRestrictionTypeValueGenerator));
        testExcludedProperties(CheckOutItemResponseData.class, propertyInfos);
    }

    @Test
    public void testChronologyLevelInstance() {
        assertThat(ChronologyLevelInstance.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCirculationStatusChangeReportedInitiationData() {
        assertThat(CirculationStatusChangeReportedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCirculationStatusChangeReportedResponseData() {
        assertThat(CirculationStatusChangeReportedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCirculationStatusUpdatedInitiationData() {
        assertThat(CirculationStatusUpdatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCirculationStatusUpdatedResponseData() {
        assertThat(CirculationStatusUpdatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCreateAgencyInitiationData() {
        assertThat(CreateAgencyInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCreateAgencyResponseData() {
        assertThat(CreateAgencyResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCreateItemInitiationData() {
        assertThat(CreateItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCreateItemResponseData() {
        assertThat(CreateItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCreateUserFiscalTransactionInitiationData() {
        assertThat(CreateUserFiscalTransactionInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCreateUserFiscalTransactionResponseData() {
        assertThat(CreateUserFiscalTransactionResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCreateUserInitiationData() {
        assertThat(CreateUserInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCreateUserResponseData() {
        assertThat(CreateUserResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testCurrentRequester() {
        assertThat(CurrentRequester.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDeleteAgencyFields() {
        assertThat(DeleteAgencyFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDeleteItemFields() {
        assertThat(DeleteItemFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDeleteItemInitiationData() {
        assertThat(DeleteItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDeleteItemResponseData() {
        assertThat(DeleteItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDeleteRequestFields() {
        assertThat(DeleteRequestFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDeleteUserFields() {
        assertThat(DeleteUserFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDeleteUserInitiationData() {
        assertThat(DeleteUserInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testDeleteUserResponseData() {
        assertThat(DeleteUserResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testElectronicResource() {
        assertThat(ElectronicResource.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testEnumerationLevelInstance() {
        assertThat(EnumerationLevelInstance.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testFiscalTransactionInformation()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(FiscalTransactionInformation.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("relatedFiscalTransactionReferenceId"),
            hasValidBeanHashCodeExcluding("relatedFiscalTransactionReferenceId"), hasValidBeanEqualsExcluding("relatedFiscalTransactionReferenceId"),
            hasValidBeanToStringExcluding("relatedFiscalTransactionReferenceId")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "relatedFiscalTransactionReferenceId", relatedFiscalTransactionReferenceIdValueGenerator));
        testExcludedProperties(FiscalTransactionInformation.class, propertyInfos);
    }

    @Test
    public void testFromAgencyId() {
        assertThat(FromAgencyId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testHoldingsChronology()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(HoldingsChronology.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("chronologyLevelInstance"), hasValidBeanHashCodeExcluding("chronologyLevelInstance"),
                hasValidBeanEqualsExcluding("chronologyLevelInstance"), hasValidBeanToStringExcluding("chronologyLevelInstance")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "chronologyLevelInstance", chronologyLevelInstanceValueGenerator));
        testExcludedProperties(HoldingsChronology.class, propertyInfos);
    }

    @Test
    public void testHoldingsEnumeration()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(HoldingsEnumeration.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("enumerationLevelInstance"), hasValidBeanHashCodeExcluding("enumerationLevelInstance"),
                hasValidBeanEqualsExcluding("enumerationLevelInstance"), hasValidBeanToStringExcluding("enumerationLevelInstance")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "enumerationLevelInstance", enumerationLevelInstanceValueGenerator));
        testExcludedProperties(HoldingsEnumeration.class, propertyInfos);
    }

    @Test
    public void testHoldingsInformation()
        throws ToolkitException, TestNonSVPBeansException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        assertThat(HoldingsInformation.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("structuredHoldingsData"), hasValidBeanHashCodeExcluding("structuredHoldingsData"),
                hasValidBeanEqualsExcluding("structuredHoldingsData"), hasValidBeanToStringExcluding("structuredHoldingsData")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "structuredHoldingsData", structuredHoldingsDataValueGenerator));
        testExcludedProperties(HoldingsInformation.class, propertyInfos);
    }

    @Test
    public void testHoldingsSet()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(HoldingsSet.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("itemInformation", "problem"), hasValidBeanHashCodeExcluding("itemInformation", "problem"),
                hasValidBeanEqualsExcluding("itemInformation", "problem"), hasValidBeanToStringExcluding("itemInformation", "problem")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "itemInformation", itemInformationValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        testExcludedProperties(HoldingsSet.class, propertyInfos);
    }

    @Test
    public void testInitiationHeader() {
        assertThat(InitiationHeader.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemCheckedInInitiationData() {
        assertThat(ItemCheckedInInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemCheckedInResponseData() {
        assertThat(ItemCheckedInResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemCheckedOutInitiationData() {
        assertThat(ItemCheckedOutInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemCheckedOutResponseData() {
        assertThat(ItemCheckedOutResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemCreatedInitiationData() {
        assertThat(ItemCreatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemCreatedResponseData() {
        assertThat(ItemCreatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemDescription() {
        assertThat(ItemDescription.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemDetails()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(ItemDetails.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("dateRenewed"), hasValidBeanHashCodeExcluding("dateRenewed"),
            hasValidBeanEqualsExcluding("dateRenewed"), hasValidBeanToStringExcluding("dateRenewed")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "dateRenewed", dateRenewedValueGenerator));
        testExcludedProperties(ItemDetails.class, propertyInfos);
    }

    @Test
    public void testItemId() {
        assertThat(ItemId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemInformation()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(ItemInformation.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("requestId", "currentRequester", "problem"),
            hasValidBeanHashCodeExcluding("requestId", "currentRequester", "problem"), hasValidBeanEqualsExcluding("requestId", "currentRequester", "problem"),
            hasValidBeanToStringExcluding("requestId", "currentRequester", "problem")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "requestId", requestIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "currentRequester", currentRequesterValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        testExcludedProperties(ItemInformation.class, propertyInfos);
    }

    @Test
    public void testItemOptionalFields()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(ItemOptionalFields.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("itemUseRestrictionType", "location"),
            hasValidBeanHashCodeExcluding("itemUseRestrictionType", "location"), hasValidBeanEqualsExcluding("itemUseRestrictionType", "location"),
            hasValidBeanToStringExcluding("itemUseRestrictionType", "location")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "itemUseRestrictionType", itemUseRestrictionTypeValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "location", locationValueGenerator));
        testExcludedProperties(ItemOptionalFields.class, propertyInfos);
    }

    @Test
    public void testItemRecallCancelledInitiationData() {
        assertThat(ItemRecallCancelledInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRecallCancelledResponseData() {
        assertThat(ItemRecallCancelledResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRecalledInitiationData() {
        assertThat(ItemRecalledInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRecalledResponseData() {
        assertThat(ItemRecalledResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemReceivedInitiationData() {
        assertThat(ItemReceivedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemReceivedResponseData() {
        assertThat(ItemReceivedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRenewedInitiationData() {
        assertThat(ItemRenewedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRenewedResponseData() {
        assertThat(ItemRenewedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemReportedReturned() {
        assertThat(ItemReportedReturned.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRequestCancelledInitiationData() {
        assertThat(ItemRequestCancelledInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRequestCancelledResponseData() {
        assertThat(ItemRequestCancelledResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRequestedInitiationData() {
        assertThat(ItemRequestedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRequestedResponseData() {
        assertThat(ItemRequestedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRequestUpdatedInitiationData() {
        assertThat(ItemRequestUpdatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemRequestUpdatedResponseData() {
        assertThat(ItemRequestUpdatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemShippedInitiationData() {
        assertThat(ItemShippedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemShippedResponseData() {
        assertThat(ItemShippedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemTransaction()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(ItemTransaction.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("currentRequester"), hasValidBeanHashCodeExcluding("currentRequester"),
                hasValidBeanEqualsExcluding("currentRequester"), hasValidBeanToStringExcluding("currentRequester")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "currentRequester", currentRequesterValueGenerator));
        testExcludedProperties(ItemTransaction.class, propertyInfos);
    }

    @Test
    public void testItemUpdatedInitiationData() {
        assertThat(ItemUpdatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testItemUpdatedResponseData() {
        assertThat(ItemUpdatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLoanedItem() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException,
        NoSuchMethodException {
        assertThat(LoanedItem.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("bibliographicId", "relatedSystemRequestId"),
            hasValidBeanHashCodeExcluding("bibliographicId", "relatedSystemRequestId"), hasValidBeanEqualsExcluding("bibliographicId", "relatedSystemRequestId"),
            hasValidBeanToStringExcluding("bibliographicId", "relatedSystemRequestId")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "bibliographicId", bibliographicIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "relatedSystemRequestId", relatedSystemRequestIdValueGenerator));
        testExcludedProperties(LoanedItem.class, propertyInfos);
    }

    @Test
    public void testLoanedItemsCount() {
        assertThat(LoanedItemsCount.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLocation() {
        assertThat(Location.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLocationName()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(LocationName.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("locationNameInstance"), hasValidBeanHashCodeExcluding("locationNameInstance"),
                hasValidBeanEqualsExcluding("locationNameInstance"), hasValidBeanToStringExcluding("locationNameInstance")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "locationNameInstance", locationNameInstanceValueGenerator));
        testExcludedProperties(LocationName.class, propertyInfos);
    }

    @Test
    public void testLookupAgencyInitiationData() {
        assertThat(LookupAgencyInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLookupAgencyResponseData() {
        assertThat(LookupAgencyResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLookupItemInitiationData() {
        assertThat(LookupItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLookupItemResponseData() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(LookupItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("problem"), hasValidBeanHashCodeExcluding("problem"), hasValidBeanEqualsExcluding("problem"),
                hasValidBeanToStringExcluding("problem")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        testExcludedProperties(LookupItemResponseData.class, propertyInfos);
    }

    @Test
    public void testLookupItemSetInitiationData() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(LookupItemSetInitiationData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("itemId", "holdingsSetId", "bibliographicId"),
            hasValidBeanHashCodeExcluding("itemId", "holdingsSetId", "bibliographicId"), hasValidBeanEqualsExcluding("itemId", "holdingsSetId", "bibliographicId"),
            hasValidBeanToStringExcluding("itemId", "holdingsSetId", "bibliographicId")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "itemId", itemIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "holdingsSetId", stringValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "bibliographicId", bibliographicIdValueGenerator));
        testExcludedProperties(LookupItemSetInitiationData.class, propertyInfos);
    }

    @Test
    public void testLookupItemSetResponseData() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(LookupItemSetResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("problem", "bibInformation"), hasValidBeanHashCodeExcluding("problem", "bibInformation"),
                hasValidBeanEqualsExcluding("problem", "bibInformation"), hasValidBeanToStringExcluding("problem", "bibInformation")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "bibInformation", bibInformationValueGenerator));
        testExcludedProperties(LookupItemSetResponseData.class, propertyInfos);
    }

    @Test
    public void testLookupRequestInitiationData() {
        assertThat(LookupRequestInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLookupRequestResponseData() {
        assertThat(LookupRequestResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testLookupUserInitiationData() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(LookupUserInitiationData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("responseElementControl", "authenticationInput"),
            hasValidBeanHashCodeExcluding("responseElementControl", "authenticationInput"), hasValidBeanEqualsExcluding("responseElementControl", "authenticationInput"),
            hasValidBeanToStringExcluding("responseElementControl", "authenticationInput")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "responseElementControl", responseElementControlValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "authenticationInput", authenticationInputValueGenerator));
        testExcludedProperties(LookupUserInitiationData.class, propertyInfos);
    }

    @Test
    public void testLookupUserResponseData() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(LookupUserResponseData.class, allOf(hasValidBeanConstructor(),
            hasValidGettersAndSettersExcluding("problem", "userFiscalAccount", "loanedItemsCount", "loanedItem", "requestedItemsCount", "requestedItem",
                "subsequentElementControl"),
            hasValidBeanHashCodeExcluding("problem", "userFiscalAccount", "loanedItemsCount", "loanedItem", "requestedItemsCount", "requestedItem", "subsequentElementControl"),
            hasValidBeanEqualsExcluding("problem", "userFiscalAccount", "loanedItemsCount", "loanedItem", "requestedItemsCount", "requestedItem", "subsequentElementControl"),
            hasValidBeanToStringExcluding("problem", "userFiscalAccount", "loanedItemsCount", "loanedItem", "requestedItemsCount", "requestedItem", "subsequentElementControl")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "userFiscalAccount", userFiscalAccountValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "loanedItemsCount", loanedItemsCountValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "loanedItem", loanedItemsValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "requestedItemsCount", requestedItemsCountValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "requestedItem", requestedItemValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "subsequentElementControl", subsequentElementControlValueGenerator));
        testExcludedProperties(LookupUserResponseData.class, propertyInfos);
    }

    @Test
    public void testMaxFeeAmount() {
        assertThat(MaxFeeAmount.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testNameInformation() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(NameInformation.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("organizationNameInformation"), hasValidBeanHashCodeExcluding("organizationNameInformation"),
                hasValidBeanEqualsExcluding("organizationNameInformation"), hasValidBeanToStringExcluding("organizationNameInformation")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "organizationNameInformation", organizationNameInformationValueGenerator));
        testExcludedProperties(NameInformation.class, propertyInfos);
    }

    @Test
    public void testNoticeId() {
        assertThat(NoticeId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testNoticeInformation() {
        assertThat(NoticeInformation.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testNoticeItem() {
        assertThat(NoticeItem.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testOnBehalfOfAgency() {
        assertThat(OnBehalfOfAgency.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testPending() {
        assertThat(Pending.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testPhysicalAddress() {
        assertThat(PhysicalAddress.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testPreviousUserId() {
        assertThat(PreviousUserId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testProblem() {
        assertThat(Problem.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals()));
        final Problem problem1 = new Problem();
        problem1.setProblemElement(PROBLEM_ELEMENT_STRING);
        problem1.setProblemValue(PROBLEM_VALUE_STRING);
        problem1.setProblemDetail(PROBLEM_DETAIL_STRING);
        problem1.setProblemType(new ProblemType(PROBLEM_TYPE_SCHEME_STRING, PROBLEM_TYPE_VALUE_STRING));
        final String problem1String = problem1.toString();
        assertTrue("Problem.toString() for an instance with all properties set doesn't include ProblemElement.", problem1String.contains(PROBLEM_ELEMENT_STRING));
        assertTrue("Problem.toString() for an instance with all properties set doesn't include ProblemValue.", problem1String.contains(PROBLEM_VALUE_STRING));
        assertTrue("Problem.toString() for an instance with all properties set doesn't include ProblemDetail.", problem1String.contains(PROBLEM_DETAIL_STRING));
        assertTrue("Problem.toString() for an instance with all properties set doesn't include ProblemType's Scheme.", problem1String.contains(PROBLEM_TYPE_SCHEME_STRING));
        assertTrue("Problem.toString() for an instance with all properties set doesn't include ProblemType's Value.", problem1String.contains(PROBLEM_TYPE_VALUE_STRING));

        final Problem problem2 = new Problem(new ProblemType(PROBLEM_TYPE_SCHEME_STRING, PROBLEM_TYPE_VALUE_STRING), PROBLEM_ELEMENT_STRING, PROBLEM_VALUE_STRING,
            PROBLEM_DETAIL_STRING);
        final String problem2String = problem2.toString();
        assertEquals("Problem.toString() for an instance with all properties set doesn't return same string for Problem populated via setters versus a Problem populated via the "
            + "constructor that takes all properties.", problem1String, problem2String);

        final Problem problem3 = new Problem();
        problem3.setProblemElement(PROBLEM_ELEMENT_STRING);
        problem3.setProblemValue(PROBLEM_VALUE_STRING);
        problem3.setProblemType(new ProblemType(PROBLEM_TYPE_SCHEME_STRING, PROBLEM_TYPE_VALUE_STRING));
        final String problem3String = problem3.toString();
        assertTrue("Problem.toString() for an instance without ProblemDetail doesn't include ProblemElement.", problem3String.contains(PROBLEM_ELEMENT_STRING));
        assertTrue("Problem.toString() for an instance without ProblemDetail doesn't include ProblemValue.", problem3String.contains(PROBLEM_VALUE_STRING));
        assertFalse("Problem.toString() for an instance without ProblemDetail seems to include ProblemDetail.", problem3String.contains(PROBLEM_DETAIL_STRING));
        assertTrue("Problem.toString() for an instance without ProblemDetail doesn't include ProblemType's Scheme.", problem3String.contains(PROBLEM_TYPE_SCHEME_STRING));
        assertTrue("Problem.toString() for an instance without ProblemDetail doesn't include ProblemType's Value.", problem3String.contains(PROBLEM_TYPE_VALUE_STRING));

        final Problem problem4 = new Problem(new ProblemType(PROBLEM_TYPE_SCHEME_STRING, PROBLEM_TYPE_VALUE_STRING), PROBLEM_ELEMENT_STRING, PROBLEM_VALUE_STRING);
        final String problem4String = problem4.toString();
        assertEquals(
            "Problem.toString() doesn't return same string for Problem populated via setters (omitting ProblemDetail) versus a Problem populated via the constructor that takes "
                + "all properties (except ProblemDetail).", problem3String, problem4String);

        final Problem emptyProblem = new Problem();
        final String emptyProblemString = emptyProblem.toString();
        assertTrue("Problem.toString() for an instance with no properties set doesn't return an empty string.", emptyProblemString.isEmpty());

    }

    @Test
    public void testProblemResponseData() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(ProblemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("problem"), hasValidBeanHashCodeExcluding("problem"), hasValidBeanEqualsExcluding("problem"),
                hasValidBeanToStringExcluding("problem")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        testExcludedProperties(ProblemResponseData.class, propertyInfos);
    }

    @Test
    public void testPromptInput() {
        assertThat(PromptInput.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testPromptOutput() {
        assertThat(PromptOutput.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRecallItemInitiationData() {
        assertThat(RecallItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRecallItemResponseData() {
        assertThat(RecallItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRenewAllItemInitiationData() {
        assertThat(RenewAllItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRenewAllItemResponseData() {
        assertThat(RenewAllItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRenewInformation() throws ToolkitException, TestNonSVPBeansException, InstantiationException, IllegalAccessException, InvocationTargetException {
        assertThat(RenewInformation.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRenewItemInitiationData() {
        assertThat(RenewItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRenewItemResponseData() {
        assertThat(RenewItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testReportCirculationStatusChangeInitiationData() {
        assertThat(ReportCirculationStatusChangeInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testReportCirculationStatusChangeResponseData() {
        assertThat(ReportCirculationStatusChangeResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRequestedItem() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(RequestedItem.class, allOf(hasValidBeanConstructor(),
            hasValidGettersAndSettersExcluding("bibliographicId", "location", "noticeInformation", "permittedUserAction", "relatedSystemRequestId"),
            hasValidBeanHashCodeExcluding("bibliographicId", "location", "noticeInformation", "permittedUserAction", "relatedSystemRequestId"),
            hasValidBeanEqualsExcluding("bibliographicId", "location", "noticeInformation", "permittedUserAction", "relatedSystemRequestId"),
            hasValidBeanToStringExcluding("bibliographicId", "location", "noticeInformation", "permittedUserAction", "relatedSystemRequestId")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "bibliographicId", bibliographicIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "location", locationValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "noticeInformation", noticeInformationValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "permittedUserAction", permittedUserActionValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "relatedSystemRequestId", relatedSystemRequestIdValueGenerator));
        testExcludedProperties(RequestedItem.class, propertyInfos);
    }

    @Test
    public void testRequestedItemsCount() {
        assertThat(RequestedItemsCount.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRequestId() {
        assertThat(RequestId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRequestItemInitiationData()
        throws InvocationTargetException, ToolkitException, InstantiationException, IllegalAccessException, TestNonSVPBeansException, NoSuchMethodException {
        assertThat(RequestItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("authenticationInput", "userId", "bibliographicId", "itemId", "acknowledgedItemUseRestrictionType"),
                hasValidBeanHashCodeExcluding("authenticationInput", "userId", "bibliographicId", "itemId", "acknowledgedItemUseRestrictionType"),
                hasValidBeanEqualsExcluding("authenticationInput", "userId", "bibliographicId", "itemId", "acknowledgedItemUseRestrictionType"),
                hasValidBeanToStringExcluding("authenticationInput", "userId", "bibliographicId", "itemId", "acknowledgedItemUseRestrictionType")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "authenticationInput", authenticationInputValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "userId", userIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "bibliographicId", bibliographicIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "itemId", itemIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "acknowledgedItemUseRestrictionType", itemUseRestrictionTypeValueGenerator));
        testExcludedProperties(RequestItemInitiationData.class, propertyInfos);
    }

    @Test
    public void testRequestItemResponseData() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(RequestItemResponseData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("problem", "requiredItemUseRestrictionType"),
            hasValidBeanHashCodeExcluding("problem", "requiredItemUseRestrictionType"), hasValidBeanEqualsExcluding("problem", "requiredItemUseRestrictionType"),
            hasValidBeanToStringExcluding("problem", "requiredItemUseRestrictionType")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "problem", problemValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "requiredItemUseRestrictionType", itemUseRestrictionTypeValueGenerator));
        testExcludedProperties(RequestItemResponseData.class, propertyInfos);
    }

    @Test
    public void testResponseElementControl() {
        assertThat(ResponseElementControl.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testResponseHeader() {
        assertThat(ResponseHeader.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRoutingInformation() {
        assertThat(RoutingInformation.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testScheme() {
        assertThat(Scheme.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testSendUserNoticeInitiationData() {
        assertThat(SendUserNoticeInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testSendUserNoticeResponseData() {
        assertThat(SendUserNoticeResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testShippingInformation() {
        assertThat(ShippingInformation.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testStructuredAddress() {
        assertThat(StructuredAddress.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testStructuredPersonalUserName() {
        assertThat(StructuredPersonalUserName.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testSummaryHoldingsInformation()
        throws ToolkitException, TestNonSVPBeansException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        assertThat(SummaryHoldingsInformation.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("structuredHoldingsData"), hasValidBeanHashCodeExcluding("structuredHoldingsData"),
                hasValidBeanEqualsExcluding("structuredHoldingsData"), hasValidBeanToStringExcluding("structuredHoldingsData")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "structuredHoldingsData", structuredHoldingsDataValueGenerator));
        testExcludedProperties(SummaryHoldingsInformation.class, propertyInfos);
    }

    @Test
    public void testToAgencyId() {
        assertThat(ToAgencyId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUndoCheckOutItemInitiationData() {
        assertThat(UndoCheckOutItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUndoCheckOutItemResponseData() {
        assertThat(UndoCheckOutItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateAgencyInitiationData() {
        assertThat(UpdateAgencyInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateAgencyResponseData() {
        assertThat(UpdateAgencyResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateCirculationStatusInitiationData() {
        assertThat(UpdateCirculationStatusInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateCirculationStatusResponseData() {
        assertThat(UpdateCirculationStatusResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateItemInitiationData() {
        assertThat(UpdateItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateItemResponseData() {
        assertThat(UpdateItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateRequestItemInitiationData() {
        assertThat(UpdateRequestItemInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateRequestItemResponseData() {
        assertThat(UpdateRequestItemResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateUserInitiationData() {
        assertThat(UpdateUserInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUpdateUserResponseData() {
        assertThat(UpdateUserResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserAddressInformation() {
        assertThat(UserAddressInformation.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserCreatedInitiationData() {
        assertThat(UserCreatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserCreatedResponseData() {
        assertThat(UserCreatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserFiscalAccount() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(UserFiscalAccount.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("accountDetail"), hasValidBeanHashCodeExcluding("accountDetail"),
            hasValidBeanEqualsExcluding("accountDetail"), hasValidBeanToStringExcluding("accountDetail")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "accountDetail", accountDetailValueGenerator));
        testExcludedProperties(UserFiscalAccount.class, propertyInfos);
    }

    @Test
    public void testUserFiscalTransactionCreatedInitiationData() {
        assertThat(UserFiscalTransactionCreatedInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserFiscalTransactionCreatedResponseData() {
        assertThat(UserFiscalTransactionCreatedResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserLimit() {
        assertThat(UserLimit.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserNoticeDetails() {
        assertThat(UserNoticeDetails.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserNoticeSentInitiationData() {
        assertThat(UserNoticeSentInitiationData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserNoticeSentResponseData() {
        assertThat(UserNoticeSentResponseData.class,
            allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testUserOptionalFields() throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(UserOptionalFields.class, allOf(hasValidBeanConstructor(),
            hasValidGettersAndSettersExcluding("userAddressInformation", "userLanguage", "userPrivilege", "blockOrTrap", "userId", "previousUserId", "userLimit"),
            hasValidBeanHashCodeExcluding("userAddressInformation", "userLanguage", "userPrivilege", "blockOrTrap", "userId", "previousUserId", "userLimit"),
            hasValidBeanEqualsExcluding("userAddressInformation", "userLanguage", "userPrivilege", "blockOrTrap", "userId", "previousUserId", "userLimit"),
            hasValidBeanToStringExcluding("userAddressInformation", "userLanguage", "userPrivilege", "blockOrTrap", "userId", "previousUserId", "userLimit")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "userAddressInformation", userAddressInformationValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "userLanguage", userLanguageValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "userPrivilege", userPrivilegeValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "blockOrTrap", blockOrTrapValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "userId", userIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "previousUserId", previousUserIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.COLLECTION, "userLimit", userLimitsValueGenerator));
        testExcludedProperties(UserOptionalFields.class, propertyInfos);
    }

    @Test
    public void testUserPrivilege() {
        assertThat(UserPrivilege.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testRelatedSystemRequestId() {
        assertThat(RelatedSystemRequestId.class,
            CoreMatchers.allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testGetWithNoParmsMethodOfFieldsMadeRepeatableSinceVersion1WithNonNullList() {

        final ToAgencyId toAgencyId = new ToAgencyId();
        final AgencyId agencyId1 = new AgencyId("scheme uri 1", "value 1");
        toAgencyId.setAgencyId(agencyId1);
        final AgencyId agencyId2 = new AgencyId("scheme uri 2", "value 2");
        toAgencyId.setAgencyId(agencyId2);
        assertThat("ToAgencyId.getAgencyId() did not return most recently-added AgencyId.", toAgencyId.getAgencyId() == agencyId2);

        final FromAgencyId fromAgencyId = new FromAgencyId();
        fromAgencyId.setAgencyId(agencyId1);
        fromAgencyId.setAgencyId(agencyId2);
        assertThat("FromAgencyId.getAgencyId() did not return most recently-added AgencyId.", fromAgencyId.getAgencyId() == agencyId2);

        final RequestItemInitiationData riid = new RequestItemInitiationData();
        final List<BibliographicId> bibIds = new ArrayList<>();

        final BibliographicId bibId1 = new BibliographicId();
        final BibliographicItemId bibItemId1 = new BibliographicItemId();
        bibItemId1.setBibliographicItemIdentifier("FAKE BIB ITEM ID 1");
        bibId1.setBibliographicItemId(bibItemId1);
        bibIds.add(bibId1);
        final BibliographicId bibId2 = new BibliographicId();
        final BibliographicItemId bibItemId2 = new BibliographicItemId();
        bibItemId2.setBibliographicItemIdentifier("FAKE BIB ITEM ID 2");
        bibId2.setBibliographicItemId(bibItemId2);
        bibIds.add(bibId2);
        riid.setBibliographicIds(bibIds);
        assertThat("RequestItemInitiationData.getBibliographicId() did not return most recently-added BibliographicId.", riid.getBibliographicId() == bibId2);

    }

    @Test
    public void testGetWithNoParmsMethodOfFieldsMadeRepeatableSinceVersion1WithNullList() {

        final ToAgencyId toAgencyId = new ToAgencyId();
        toAgencyId.setAgencyIds(null);
        assertNull("ToAgencyId.getAgencyId() did not return null if list of agencyIds is null.", toAgencyId.getAgencyId());

        final FromAgencyId fromAgencyId = new FromAgencyId();
        fromAgencyId.setAgencyIds(null);
        assertNull("FromAgencyId.getAgencyId() did not return null if list of agencyIds is null.", fromAgencyId.getAgencyId());

        final RequestItemInitiationData riid = new RequestItemInitiationData();
        riid.setBibliographicIds(null);
        assertNull("RequestItemInitiationData.getBibliographicId() did not return null if list of bibliographicIds is null.", riid.getBibliographicId());

    }

    @Test
    public void testGetWithNoParmsMethodOfFieldsMadeRepeatableSinceVersion1WithEmptyList() {

        final ToAgencyId toAgencyId = new ToAgencyId();
        assertNull("ToAgencyId.getAgencyId() did not return null if list of agencyIds is empty.", toAgencyId.getAgencyId());

        final FromAgencyId fromAgencyId = new FromAgencyId();
        assertNull("FromAgencyId.getAgencyId() did not return null if list of agencyIds is empty.", fromAgencyId.getAgencyId());

        final RequestItemInitiationData riid = new RequestItemInitiationData();
        assertNull("RequestItemInitiationData.getBibliographicId() did not return null if list of bibliographicIds is empty.", riid.getBibliographicId());

    }


}
