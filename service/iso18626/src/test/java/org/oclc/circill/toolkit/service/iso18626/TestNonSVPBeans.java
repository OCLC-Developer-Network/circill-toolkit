package org.oclc.circill.toolkit.service.iso18626;

import org.oclc.circill.toolkit.service.base.BaseTestNonSVPBeans;
import org.oclc.circill.toolkit.service.base.BibliographicItemId;
import org.oclc.circill.toolkit.service.base.PropertyInfo;
import org.oclc.circill.toolkit.service.base.Repeatability;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.TestNonSVPBeansException;
import org.oclc.circill.toolkit.service.base.ToolkitException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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

import com.google.code.beanmatchers.ValueGenerator;
import org.junit.Test;

/**
 * Unit tests for beans which aren't sub-classes of {@link SchemeValuePair}.
 * See TestNonSVPBeans in service.ncip package for extensive documentation.
 */
public class TestNonSVPBeans extends BaseTestNonSVPBeans {

    protected final ValueGenerator<AgencyId> agencyIdValueGenerator = () -> {
        final AgencyId value = new AgencyId();
        value.setAgencyIdType(Version2017AgencyIdType.ISIL);
        value.setAgencyIdValue(Double.toString(Math.random()));
        return value;
    };
    protected final ValueGenerator<Header> headerValueGenerator = () -> {
        final Header value = new Header();
        value.setRequestingAgencyId(agencyIdValueGenerator.generate());
        value.setSupplyingAgencyId(agencyIdValueGenerator.generate());
        return value;
    };
    protected final ValueGenerator<ConfirmationHeader> confirmationHeaderValueGenerator = () -> {
        final ConfirmationHeader value = new ConfirmationHeader();
        value.setRequestingAgencyId(agencyIdValueGenerator.generate());
        value.setSupplyingAgencyId(agencyIdValueGenerator.generate());
        return value;
    };
    protected final ValueGenerator<ISO18626RequestData> requestDataValueGenerator = () -> {
        final RequestData value = new RequestData();
        value.setHeader(headerValueGenerator.generate());
        return value;
    };
    protected final ValueGenerator<RequestConfirmationData> confirmationDataValueGenerator = () -> {
        final RequestConfirmationData value = new RequestConfirmationData();
        value.setConfirmationHeader(confirmationHeaderValueGenerator.generate());
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

    @Test
    public void testISO18626Message()
        throws InvocationTargetException, ToolkitException, TestNonSVPBeansException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        assertThat(ISO18626Message.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("requestData", "initiationMessage", "confirmationData", "responseMessage"),
            hasValidBeanHashCodeExcluding("requestData", "initiationMessage", "confirmationData", "responseMessage"),
            hasValidBeanEqualsExcluding("requestData", "initiationMessage", "confirmationData", "responseMessage"),
            hasValidBeanToStringExcluding("requestData", "initiationMessage", "confirmationData", "responseMessage")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.SIMPLE, "requestData", requestDataValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.SIMPLE, "confirmationData", confirmationDataValueGenerator));
        testExcludedProperties(ISO18626Message.class, propertyInfos);
    }

    @Test
    public void SupplyingAgencyMessageConfirmationData() {
        assertThat(SupplyingAgencyMessageConfirmationData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void SupplyingAgencyMessageData() {
        assertThat(SupplyingAgencyMessageData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void RequestConfirmationData() {
        assertThat(RequestConfirmationData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void RequestingAgencyMessageConfirmationData() {
        assertThat(RequestingAgencyMessageConfirmationData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void ErrorData() {
        assertThat(ErrorData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void RequestData() {
        assertThat(RequestData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void RequestingAgencyMessageData() {
        assertThat(RequestingAgencyMessageData.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void Costs() {
        assertThat(Costs.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void StatusInfo() {
        assertThat(StatusInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void RequestingAgencyInfo() {
        assertThat(RequestingAgencyInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void RequestingAgencyAuthentication() {
        assertThat(RequestingAgencyAuthentication.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void testBibliographicInfo()
        throws ToolkitException, TestNonSVPBeansException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        assertThat(BibliographicInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSettersExcluding("bibliographicItemId", "bibliographicRecordId"),
            hasValidBeanHashCodeExcluding("bibliographicItemId", "bibliographicRecordId"), hasValidBeanEqualsExcluding("bibliographicItemId", "bibliographicRecordId"),
            hasValidBeanToStringExcluding("bibliographicItemId", "bibliographicRecordId")));
        final List<PropertyInfo<?>> propertyInfos = new ArrayList<>();
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "bibliographicItemId", bibliographicItemIdValueGenerator));
        propertyInfos.add(new PropertyInfo(Repeatability.BOTH, "bibliographicRecordId", bibliographicRecordIdValueGenerator));
        testExcludedProperties(BibliographicInfo.class, propertyInfos);
    }

    @Test
    public void BillingInfo() {
        assertThat(BillingInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void ConfirmationHeader() {
        assertThat(ConfirmationHeader.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void ReturnInfo() {
        assertThat(ReturnInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void Address() {
        assertThat(Address.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void AgencyId() {
        assertThat(AgencyId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void PublicationInfo() {
        assertThat(PublicationInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void ServiceInfo() {
        assertThat(ServiceInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void BibliographicRecordId() {
        assertThat(BibliographicRecordId.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void MessageInfo() {
        assertThat(MessageInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void SupplierInfo() {
        assertThat(SupplierInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void DeliveryInfo() {
        assertThat(DeliveryInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void RequestedDeliveryInfo() {
        assertThat(RequestedDeliveryInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void PhysicalAddress() {
        assertThat(PhysicalAddress.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void Header() {
        assertThat(Header.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }

    @Test
    public void PatronInfo() {
        assertThat(PatronInfo.class, allOf(hasValidBeanConstructor(), hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanEquals(), hasValidBeanToString()));
    }


}
