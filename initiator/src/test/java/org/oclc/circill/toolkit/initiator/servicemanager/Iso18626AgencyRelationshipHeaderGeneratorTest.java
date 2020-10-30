package org.oclc.circill.toolkit.initiator.servicemanager;

import org.oclc.circill.toolkit.service.iso18626.AgencyId;
import org.oclc.circill.toolkit.service.iso18626.Header;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;
import org.oclc.circill.toolkit.service.iso18626.RequestData;
import org.oclc.circill.toolkit.service.iso18626.RequestingAgencyMessageData;
import org.oclc.circill.toolkit.service.iso18626.SupplyingAgencyMessageData;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests of the {@link Iso18626AgencyRelationshipHeaderGenerator}.
 */
public class Iso18626AgencyRelationshipHeaderGeneratorTest {

    private static final String TEST1_AGENCY_ID = "TEST1";
    private static final String TEST2_AGENCY_ID = "TEST2";
    private static final String TEST3_AGENCY_ID = "TEST3";

    private static final Map<String, String> TEST1_VALUE_MAP = new HashMap<>();

    static {
        TEST1_VALUE_MAP.put(TEST1_AGENCY_ID, "test 1 to test 1 value");
        TEST1_VALUE_MAP.put(TEST2_AGENCY_ID, "test 1 to test 2 value");
    }

    private static final Map<String, String> TEST2_VALUE_MAP = new HashMap<>();

    static {
        TEST2_VALUE_MAP.put(TEST1_AGENCY_ID, "test 2 to test 1 value");
        TEST2_VALUE_MAP.put(TEST2_AGENCY_ID, "test 2 to test 2 value");
    }

    private static final String NONMATCHING_HEADER_VALUE = "Non matching header value";

    @Test
    public void testHappyPathForRequest() {
        final Map<String, Map<String, String>> valueMap = new HashMap<>();
        valueMap.put(TEST1_AGENCY_ID, TEST1_VALUE_MAP);
        testGetHeaders(new RequestData(), TEST1_AGENCY_ID, TEST2_AGENCY_ID, null, valueMap, TEST1_VALUE_MAP.get(TEST2_AGENCY_ID));
    }

    @Test
    public void testHappyPathForRequestingAgencyMessage() {
        final Map<String, Map<String, String>> valueMap = new HashMap<>();
        valueMap.put(TEST1_AGENCY_ID, TEST1_VALUE_MAP);
        testGetHeaders(new RequestingAgencyMessageData(), TEST1_AGENCY_ID, TEST2_AGENCY_ID, null, valueMap, TEST1_VALUE_MAP.get(TEST2_AGENCY_ID));
    }

    @Test
    public void testHappyPathForSupplyingAgencyMessage() {
        final Map<String, Map<String, String>> valueMap = new HashMap<>();
        valueMap.put(TEST2_AGENCY_ID, TEST2_VALUE_MAP);
        testGetHeaders(new SupplyingAgencyMessageData(), TEST1_AGENCY_ID, TEST2_AGENCY_ID, null, valueMap, TEST2_VALUE_MAP.get(TEST1_AGENCY_ID));
    }

    @Test
    public void testDefaultGeneratorInitialization() {
        final Map<String, Map<String, String>> valueMap = new HashMap<>();
        testGetHeaders(new RequestData(), TEST1_AGENCY_ID, TEST2_AGENCY_ID, null, valueMap, null);
    }

    @Test
    public void testAlternateHeaderName() {
        final Map<String, Map<String, String>> valueMap = new HashMap<>();
        valueMap.put(TEST1_AGENCY_ID, TEST1_VALUE_MAP);
        testGetHeaders(new RequestData(), TEST1_AGENCY_ID, TEST2_AGENCY_ID, "Alternate header", valueMap, TEST1_VALUE_MAP.get(TEST2_AGENCY_ID));
    }

    @Test
    public void testNoMatchingKeyInValueMap() {
        final Map<String, Map<String, String>> valueMap = new HashMap<>();
        valueMap.put(TEST1_AGENCY_ID, Collections.singletonMap(TEST3_AGENCY_ID, NONMATCHING_HEADER_VALUE));
        testGetHeaders(new RequestData(), TEST1_AGENCY_ID, TEST2_AGENCY_ID, null, valueMap, null);
    }

    private static Header buildHeader(final String requestingAgency, final String supplyingAgency) {
        final Header header = new Header();
        final AgencyId requestingAgencyId = new AgencyId();
        requestingAgencyId.setAgencyIdValue(requestingAgency);
        header.setRequestingAgencyId(requestingAgencyId);
        final AgencyId supplyingAgencyId = new AgencyId();
        supplyingAgencyId.setAgencyIdValue(supplyingAgency);
        header.setSupplyingAgencyId(supplyingAgencyId);
        return header;
    }

    private static void testGetHeaders(final ISO18626RequestData iso18626RequestData, final String requesterAgencyId, final String supplierAgencyId,
        final String alternateHeaderName, final Map<String, Map<String, String>> valueMap, final String expectedHeaderValue) {

        iso18626RequestData.setHeader(buildHeader(requesterAgencyId, supplierAgencyId));
        Map<String, String> expectedHeaders = null;
        if (expectedHeaderValue != null) {
            expectedHeaders = new HashMap<>();
            if (alternateHeaderName != null) {
                expectedHeaders.put(alternateHeaderName, expectedHeaderValue);
            } else {
                expectedHeaders.put(Iso18626AgencyRelationshipHeaderGenerator.DEFAULT_HEADER_NAME, expectedHeaderValue);
            }
        }
        final Iso18626AgencyRelationshipHeaderGenerator testSubject = new Iso18626AgencyRelationshipHeaderGenerator(valueMap);
        if (alternateHeaderName != null) {
            testSubject.setHeaderName(alternateHeaderName);
        }

        final Map<String, String> actualHeaders = testSubject.generateHeaders(iso18626RequestData);
        if (expectedHeaders != null) {
            assertEquals(expectedHeaders, actualHeaders);
        } else {
            assertTrue(actualHeaders.isEmpty());
        }
    }
}
