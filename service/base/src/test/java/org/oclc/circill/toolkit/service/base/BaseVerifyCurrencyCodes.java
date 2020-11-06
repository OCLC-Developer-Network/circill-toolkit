/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.lang.reflect.Field;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Base for verification of CurrencyCode subclasses.
 * This class compares the JVM's currency code list to a {@link CurrencyCode} subclass's list of values and reports any discrepancies.
 * It is <em>not</em> a unit test, since the Toolkit's functionality does not rely on the two lists matching. Instead it serves to:
 * 1) Alert Toolkit maintainers when the subclasses need updating (e.g. when a code is added to ISO 4217).
 * 2) Document any disagreements between the CurrencyCode subclasses and the JVM (e.g. minor units).
 */
public class BaseVerifyCurrencyCodes {

    private static final Logger LOG = Logger.getLogger(BaseVerifyCurrencyCodes.class);

    private static final String JAVA_VERSION = System.getProperty("java.version");
    private static final String JAVA_VERSION_1_6 = "^1\\.6[^0-9].*";
    private static final String JAVA_VERSION_1_7 = "^1\\.7[^0-9].*$";
    private static final String JAVA_VERSIONS_1_8_THRU_1_8_065 = "^1\\.8\\.0_([0-5][0-9]|6[0-5])$";
    private static final String JAVA_VERSIONS_1_8_065_THRU_1_8_180 = "^1\\.8\\.0_(06[5-9]|0[7-9][0-9]|1[0-7][0-9]|180)$";
    private static final String JAVA_VERSIONS_1_8_AND_UP = "^(1\\.8\\.|9\\.|[1-9][0-9]+\\.).*$";

    static final Set<Currency> JAVA_CURRENCY_CODE_SET = new HashSet<>();
    static final String TOOLKIT_CURRENCIES_NOT_KNOWN_TO_JAVA;
    static final String JAVA_CURRENCIES_NOT_IN_SERVICE_CLASS;

    static {
        if (JAVA_VERSION.matches(JAVA_VERSION_1_6)) {
            addCurrenciesFromLocale(JAVA_CURRENCY_CODE_SET);

            // These lists are based on tests conducted on Java 1.6.025
            JAVA_CURRENCIES_NOT_IN_SERVICE_CLASS = "^(SKK|CSD)$";
            TOOLKIT_CURRENCIES_NOT_KNOWN_TO_JAVA = "^(TMT|CUC|SSP|COU|UYI|CHE|CHW|ZWL)$";

        } else if (JAVA_VERSION.matches(JAVA_VERSION_1_7)) {
            // This will only compile on 1.7 or later
            JAVA_CURRENCY_CODE_SET.addAll(Currency.getAvailableCurrencies());
            // This is what worked in 1.6:
            // addCurrenciesFromLocale(JAVA_CURRENCY_CODE_SET);

            // These lists are based on tests conducted on Java 1.7.02
            JAVA_CURRENCIES_NOT_IN_SERVICE_CLASS =
                "^(YUM|ZWD|ROL|SDD|XXX|PTE|XTS|XSU|ZWN|XBC|BEF|XDR|XAU|NLG|XBD|XUA|TRL|ADP|XPT|BGL|AZM|ATS|XFO|XBB|CSD|XAG|FIM|ESP|XPD|SKK|RUR|SRG|TMM|TPE|MZM|MGF|ITL|FRF|AFA"
                    + "|AYM|GHC|SIT|MTL|ZWR|DEM|VEB|LUF|GWP|GRD|BYB|CYP|XFU|XBA|IEP)$";
            TOOLKIT_CURRENCIES_NOT_KNOWN_TO_JAVA = "^(SSP|COU|UYI|CHE|CHW)$";

        } else if (JAVA_VERSION.matches(JAVA_VERSIONS_1_8_THRU_1_8_065)) {
            JAVA_CURRENCIES_NOT_IN_SERVICE_CLASS = "^$";
            TOOLKIT_CURRENCIES_NOT_KNOWN_TO_JAVA = "^(COU|UYI|CHE|CHW)$";
        } else if (JAVA_VERSION.matches(JAVA_VERSIONS_1_8_065_THRU_1_8_180)){
            JAVA_CURRENCIES_NOT_IN_SERVICE_CLASS = "^$";
            TOOLKIT_CURRENCIES_NOT_KNOWN_TO_JAVA = "^(MRU|STN|UYW|VES|BYN)$";
        } else {
            JAVA_CURRENCIES_NOT_IN_SERVICE_CLASS = "^$";
            TOOLKIT_CURRENCIES_NOT_KNOWN_TO_JAVA = "^(MRU|STN|UYW|VES)$";
        }
    }

    /**
     * Test the {@link CurrencyCode#minorUnit} for all supported Currency Codes.
     * @param serviceCurrencyCodesClass a subclass of {@link CurrencyCode}
     * @throws ToolkitInternalException if one of the serviceCurrencyCodesClass' static fields isn't accessible
     */
    protected static void validateServiceClassCodesAreInJava(final Class<? extends CurrencyCode> serviceCurrencyCodesClass) throws ToolkitInternalException {
        final Field[] fields = serviceCurrencyCodesClass.getDeclaredFields();
        for (final Field f : fields) {
            if (f.getName().matches("^[A-Z]*$") && !f.getName().matches("^LOG$")) {
                final CurrencyCode currencyCode;
                try {
                    currencyCode = (CurrencyCode) f.get(null);
                } catch (IllegalAccessException e) {
                    throw new ToolkitInternalException("Can't access field '" + f.getName() + "'.", e);
                }
                final String currencyCodeString = currencyCode.getValue();
                if (!currencyCodeString.matches(TOOLKIT_CURRENCIES_NOT_KNOWN_TO_JAVA)) {
                    LOG.debug("Testing " + currencyCodeString);
                    try {
                        final Currency javaCC = Currency.getInstance(currencyCodeString);
                        final int javaCCFractionalDigits = javaCC.getDefaultFractionDigits();
                        if (currencyCodeString.compareTo("VND") == 0 && !JAVA_VERSION.matches(JAVA_VERSIONS_1_8_AND_UP)) {
                            // Java's Currency definition for VND prior to version 1.8 has a minor unit of 2, but as of 2011-09-09
                            // the ISO 4217 spreadsheet (dl_iso_table_a1-1.xls) has 0, which is what Toolkit uses.
                            if (javaCCFractionalDigits != 2) {
                                LOG.warn("VND currency's minor unit in Java's representation is wrong.");
                            }
                            if (currencyCode.getMinorUnit() != 0) {
                                LOG.warn("VND currency's minor unit in " + serviceCurrencyCodesClass.getName() + " is wrong.");
                            }
                        } else if (currencyCodeString.compareTo("UGX") == 0 && JAVA_VERSION.matches(JAVA_VERSIONS_1_8_AND_UP)) {
                            // Java's Currency definition for UGX in version 1.8 has a minor unit of 0, but as of 2011-09-09
                            // the ISO 4217 spreadsheet (dl_iso_table_a1-1.xls) has 2, which is what the Toolkit uses.
                            if (javaCCFractionalDigits != 0) {
                                LOG.warn("UGX currency's minor unit in Java's representation is wrong.");
                            }
                            if (currencyCode.getMinorUnit() != 2) {
                                LOG.warn("UGX currency's minor unit in " + serviceCurrencyCodesClass.getName() + " is wrong.");
                            }
                        } else if (currencyCodeString.compareTo("CLF") == 0 && JAVA_VERSION.matches(JAVA_VERSIONS_1_8_THRU_1_8_065)) {
                            // Java's Currency definition for CLF in version 1.8 up thru 1.8.0_66 has a minor unit of 0, but
                            // the ISO 4217 spreadsheet (dl_iso_table_a1-1.xls) has 4, which is what the Toolkit uses.
                            if (javaCCFractionalDigits != 0) {
                                LOG.warn("CLF currency's minor unit in Java's representation is wrong.");
                            }
                            if (currencyCode.getMinorUnit() != 4) {
                                LOG.warn("CLF currency's minor unit in " + serviceCurrencyCodesClass.getName() + " is wrong.");
                            }
                        } else {
                            if (javaCCFractionalDigits != currencyCode.getMinorUnit()) {
                                LOG.warn(currencyCodeString + "'s minor units do not match between Java and " + serviceCurrencyCodesClass.getName());
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        LOG.error("Java's currency code tables do not have currency code '" + currencyCodeString + "'.");
                    }
                } else {
                    try {
                        Currency.getInstance(currencyCodeString);
                        LOG.error("Java's currency code tables DO have currency code '" + currencyCodeString
                            + "'; the TOOLKIT_CURRENCIES_NOT_KNOWN_TO_JAVA variable needs to be updated to expect this code in this version of Java.");
                    } catch (IllegalArgumentException e) {
                        LOG.debug("Confirmed that currency code '" + currencyCodeString + "' from the Toolkit list isn't in Java's list.");
                    }
                }
            }
        }
    }

    /**
     *
     * Test the {@link CurrencyCode#minorUnit} for all supported Currency Codes.
     * @param serviceCurrencyCodeClass a subclass of {@link CurrencyCode}
     * @throws ToolkitInternalException if there is an unexpected condition (other than a mismatch in the currency codes
     */
    protected static void validateJavaCodesAreInServiceClass(final Class<? extends CurrencyCode> serviceCurrencyCodeClass, final String schemeURI) throws ToolkitInternalException {

        for (final Currency javaCurrency : JAVA_CURRENCY_CODE_SET) {
            final String javaCC = javaCurrency.getCurrencyCode();
            if (!javaCC.matches(JAVA_CURRENCIES_NOT_IN_SERVICE_CLASS)) {
                try {
                    SchemeValuePairHelper.findSchemeValuePair(serviceCurrencyCodeClass, schemeURI, javaCurrency.getCurrencyCode());
                } catch (ConfigurationException e) {
                    LOG.error("Java's currency code " + javaCurrency.getCurrencyCode() + " is not in " + serviceCurrencyCodeClass.getName());
                }
            } else {
                try {
                    SchemeValuePairHelper.findSchemeValuePair(serviceCurrencyCodeClass, schemeURI, javaCurrency.getCurrencyCode());
                    LOG.error("Java's currency code " + javaCurrency.getCurrencyCode()
                        + " IS in the Toolkit's list; the JAVA_CURRENCIES_NOT_IN_SERVICE_CLASS variable needs to be updated.");
                } catch (ConfigurationException e) {
                    LOG.debug("Confirmed that currency code '" + javaCurrency.getCurrencyCode() + "' from the Java list isn't in the Toolkit's list.");
                }
            }
        }
    }

    private static void addCurrenciesFromLocale(final Set<Currency> javaCCSet) {
        final Locale[] locs = Locale.getAvailableLocales();

        for (final Locale loc : locs) {
            try {
                final Currency currency = Currency.getInstance(loc);
                LOG.debug("Currency for " + loc.getDisplayName() + " is '" + currency.getCurrencyCode() + "'.");
                javaCCSet.add(currency);
            } catch (IllegalArgumentException e) {
                LOG.debug("No currency for " + loc.getDisplayName());
                // Ignore - some locales aren't in the Currency list, e.g. "English" isn't, "English (United States)" is.
            }
        }

    }
}
