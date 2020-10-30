/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

import org.apache.log4j.Logger;

/**
 * Codes for {@link RegionType} defined in ISO 3166-2, per ISO 18626-2017 p. 10.
 * Note: This is presently a subset derived from an OCLC enumeration.
 * Note: This class's &lt;clinit&gt; method is close enough to the JVM limit that Jacoco's instrumentation pushes
 * it over that limit and throws org.jacoco.agent.rt.internal_43f5073.asm.MethodTooLargeException: Method too large:
 * org/oclc/circill/toolkit/service/iso18626/Version2017RegionType.&lt;clinit&gt; ()V.
 * For now (2020) we've turned off coverage of this class.
 */
public class Version2017RegionType extends RegionType {

    private static final Logger LOG = Logger.getLogger(Version2017RegionType.class);

    public static final String SCHEME = "https://www.iso.org/iso-3166-country-codes.html#2012_iso3166-2";

    // AE Abu Dhabi
    public static final Version2017RegionType AE_ABU_DHABI = new Version2017RegionType(SCHEME, "AE-AZ");

    // AE Ajman
    public static final Version2017RegionType AE_AJMAN = new Version2017RegionType(SCHEME, "AE-AJ");

    // AE Al Fujayrah
    public static final Version2017RegionType AE_AL_FUJAYRAH = new Version2017RegionType(SCHEME, "AE-FU");

    // AE Dubai
    public static final Version2017RegionType AE_DUBAI = new Version2017RegionType(SCHEME, "AE-DU");

    // AE Ras Al Khaymah
    public static final Version2017RegionType AE_RAS_AL_KHAYMAH = new Version2017RegionType(SCHEME, "AE-RK");

    // AE Sharijah
    public static final Version2017RegionType AE_SHARIJAH = new Version2017RegionType(SCHEME, "AE-SH");

    // AE Umm Al Qaywayn
    public static final Version2017RegionType AE_UMM_AL_QAYWAYN = new Version2017RegionType(SCHEME, "AE-UQ");

    // AF Badakhshan
    public static final Version2017RegionType AF_BADAKHSHAN = new Version2017RegionType(SCHEME, "AF-BDS");

    // AF Badghis
    public static final Version2017RegionType AF_BADGHIS = new Version2017RegionType(SCHEME, "AF-BDG");

    // AF Baghlan
    public static final Version2017RegionType AF_BAGHLAN = new Version2017RegionType(SCHEME, "AF-BGL");

    // AF Balkh
    public static final Version2017RegionType AF_BALKH = new Version2017RegionType(SCHEME, "AF-BAL");

    // AF Baman
    public static final Version2017RegionType AF_BAMAN = new Version2017RegionType(SCHEME, "AF-BAM");

    // AF Farah
    public static final Version2017RegionType AF_FARAH = new Version2017RegionType(SCHEME, "AF-FRA");

    // AF Faryab
    public static final Version2017RegionType AF_FARYAB = new Version2017RegionType(SCHEME, "AF-FYB");

    // AF Ghazni
    public static final Version2017RegionType AF_GHAZNI = new Version2017RegionType(SCHEME, "AF-GHA");

    // AF Ghowr
    public static final Version2017RegionType AF_GHOWR = new Version2017RegionType(SCHEME, "AF-GHO");

    // AF Heart
    public static final Version2017RegionType AF_HEART = new Version2017RegionType(SCHEME, "AF-HER");

    // AF Helmand
    public static final Version2017RegionType AF_HELMAND = new Version2017RegionType(SCHEME, "AF-HEL");

    // AF Jowzjan
    public static final Version2017RegionType AF_JOWZJAN = new Version2017RegionType(SCHEME, "AF-JOW");

    // AF Kabol
    public static final Version2017RegionType AF_KABOL = new Version2017RegionType(SCHEME, "AF-KAB");

    // AF Kandahar
    public static final Version2017RegionType AF_KANDAHAR = new Version2017RegionType(SCHEME, "AF-KAN");

    // AF Kapisa
    public static final Version2017RegionType AF_KAPISA = new Version2017RegionType(SCHEME, "AF-KAP");

    // AF Khowst
    public static final Version2017RegionType AF_KHOWST = new Version2017RegionType(SCHEME, "AF-KHO");

    // AF Kunar
    public static final Version2017RegionType AF_KUNAR = new Version2017RegionType(SCHEME, "AF-KNR");

    // AF Kunduz
    public static final Version2017RegionType AF_KUNDUZ = new Version2017RegionType(SCHEME, "AF-KDZ");

    // AF Laghman
    public static final Version2017RegionType AF_LAGHMAN = new Version2017RegionType(SCHEME, "AF-LAG");

    // AF Lowgar
    public static final Version2017RegionType AF_LOWGAR = new Version2017RegionType(SCHEME, "AF-LOW");

    // AF Nagarhar
    public static final Version2017RegionType AF_NAGARHAR = new Version2017RegionType(SCHEME, "AF-NAN");

    // AF Nimruz
    public static final Version2017RegionType AF_NIMRUZ = new Version2017RegionType(SCHEME, "AF-NIM");

    // AF Nurestan
    public static final Version2017RegionType AF_NURESTAN = new Version2017RegionType(SCHEME, "AF-NUR");

    // AF Paktja
    public static final Version2017RegionType AF_PAKTJA = new Version2017RegionType(SCHEME, "AF-PIA");

    // AF Paktjka
    public static final Version2017RegionType AF_PAKTJKA = new Version2017RegionType(SCHEME, "AF-PKA");

    // AF Parwan
    public static final Version2017RegionType AF_PARWAN = new Version2017RegionType(SCHEME, "AF-PAR");

    // AF Samangan
    public static final Version2017RegionType AF_SAMANGAN = new Version2017RegionType(SCHEME, "AF-SAM");

    // AF Sar-e Pol
    public static final Version2017RegionType AF_SAR_E_POL = new Version2017RegionType(SCHEME, "AF-SAR");

    // AF Takhar
    public static final Version2017RegionType AF_TAKHAR = new Version2017RegionType(SCHEME, "AF-TAK");

    // AF Uruzgan
    public static final Version2017RegionType AF_URUZGAN = new Version2017RegionType(SCHEME, "AF-ORU");

    // AF Wardag
    public static final Version2017RegionType AF_WARDAG = new Version2017RegionType(SCHEME, "AF-WAR");

    // AF Zabol
    public static final Version2017RegionType AF_ZABOL = new Version2017RegionType(SCHEME, "AF-ZAB");

    // AL Berat
    public static final Version2017RegionType AL_BERAT = new Version2017RegionType(SCHEME, "AL-BR");

    // AL Bulqize
    public static final Version2017RegionType AL_BULQIZE = new Version2017RegionType(SCHEME, "AL-BU");

    // AL Delvine
    public static final Version2017RegionType AL_DELVINE = new Version2017RegionType(SCHEME, "AL-DL");

    // AL Devoll
    public static final Version2017RegionType AL_DEVOLL = new Version2017RegionType(SCHEME, "AL-DV");

    // AL Diber
    public static final Version2017RegionType AL_DIBER = new Version2017RegionType(SCHEME, "AL-DI");

    // AL Durres
    public static final Version2017RegionType AL_DURRES = new Version2017RegionType(SCHEME, "AL-DR");

    // AL Elbasan
    public static final Version2017RegionType AL_ELBASAN = new Version2017RegionType(SCHEME, "AL-EL");

    // AL Fier
    public static final Version2017RegionType AL_FIER = new Version2017RegionType(SCHEME, "AL-FR");

    // AL Gjirokaster
    public static final Version2017RegionType AL_GJIROKASTER = new Version2017RegionType(SCHEME, "AL-GJ");

    // AL Gramsh
    public static final Version2017RegionType AL_GRAMSH = new Version2017RegionType(SCHEME, "AL-GR");

    // AL Has
    public static final Version2017RegionType AL_HAS = new Version2017RegionType(SCHEME, "AL-HA");

    // AL Kavaje
    public static final Version2017RegionType AL_KAVAJE = new Version2017RegionType(SCHEME, "AL-KA");

    // AL Kolonje
    public static final Version2017RegionType AL_KOLONJE = new Version2017RegionType(SCHEME, "AL-ER");

    // AL Korce
    public static final Version2017RegionType AL_KORCE = new Version2017RegionType(SCHEME, "AL-KO");

    // AL Kruje
    public static final Version2017RegionType AL_KRUJE = new Version2017RegionType(SCHEME, "AL-KR");

    // AL Kucove
    public static final Version2017RegionType AL_KUCOVE = new Version2017RegionType(SCHEME, "AL-KC");

    // AL Kukes
    public static final Version2017RegionType AL_KUKES = new Version2017RegionType(SCHEME, "AL-KU");

    // AL Kurbin
    public static final Version2017RegionType AL_KURBIN = new Version2017RegionType(SCHEME, "AL-KB");

    // AL Lezhe
    public static final Version2017RegionType AL_LEZHE = new Version2017RegionType(SCHEME, "AL-LE");

    // AL Librazhd
    public static final Version2017RegionType AL_LIBRAZHD = new Version2017RegionType(SCHEME, "AL-LB");

    // AL Lushnje
    public static final Version2017RegionType AL_LUSHNJE = new Version2017RegionType(SCHEME, "AL-LU");

    // AL Malesi E Madhe
    public static final Version2017RegionType AL_MALESI_E_MADHE = new Version2017RegionType(SCHEME, "AL-MM");

    // AL Mallakaster
    public static final Version2017RegionType AL_MALLAKASTER = new Version2017RegionType(SCHEME, "AL-MK");

    // AL Mat
    public static final Version2017RegionType AL_MAT = new Version2017RegionType(SCHEME, "AL-MT");

    // AL Mirdite
    public static final Version2017RegionType AL_MIRDITE = new Version2017RegionType(SCHEME, "AL-MR");

    // AL Peqin
    public static final Version2017RegionType AL_PEQIN = new Version2017RegionType(SCHEME, "AL-PQ");

    // AL Permet
    public static final Version2017RegionType AL_PERMET = new Version2017RegionType(SCHEME, "AL-PR");

    // AL Pogradec
    public static final Version2017RegionType AL_POGRADEC = new Version2017RegionType(SCHEME, "AL-PG");

    // AL Puke
    public static final Version2017RegionType AL_PUKE = new Version2017RegionType(SCHEME, "AL-PU");

    // AL Sarande
    public static final Version2017RegionType AL_SARANDE = new Version2017RegionType(SCHEME, "AL-SR");

    // AL Shkoder
    public static final Version2017RegionType AL_SHKODER = new Version2017RegionType(SCHEME, "AL-SH");

    // AL Skrapar
    public static final Version2017RegionType AL_SKRAPAR = new Version2017RegionType(SCHEME, "AL-SK");

    // AL Tepelene
    public static final Version2017RegionType AL_TEPELENE = new Version2017RegionType(SCHEME, "AL-TE");

    // AL Tirane
    public static final Version2017RegionType AL_TIRANE = new Version2017RegionType(SCHEME, "AL-TR");

    // AL Tropoje
    public static final Version2017RegionType AL_TROPOJE = new Version2017RegionType(SCHEME, "AL-TP");

    // AL Vlore
    public static final Version2017RegionType AL_VLORE = new Version2017RegionType(SCHEME, "AL-VL");

    // AM Aragacotn
    public static final Version2017RegionType AM_ARAGACOTN = new Version2017RegionType(SCHEME, "AM-AG");

    // AM Ararat
    public static final Version2017RegionType AM_ARARAT = new Version2017RegionType(SCHEME, "AM-AR");

    // AM Armavir
    public static final Version2017RegionType AM_ARMAVIR = new Version2017RegionType(SCHEME, "AM-AV");

    // AM Erevan
    public static final Version2017RegionType AM_EREVAN = new Version2017RegionType(SCHEME, "AM-ER");

    // AM Gegark'unik'
    public static final Version2017RegionType AM_GEGARKUNIK = new Version2017RegionType(SCHEME, "AM-GR");

    // AM Kotayk'
    public static final Version2017RegionType AM_KOTAYK = new Version2017RegionType(SCHEME, "AM-KT");

    // AM Lory
    public static final Version2017RegionType AM_LORY = new Version2017RegionType(SCHEME, "AM-LO");

    // AM Sirak
    public static final Version2017RegionType AM_SIRAK = new Version2017RegionType(SCHEME, "AM-SH");

    // AM Syunik'
    public static final Version2017RegionType AM_SYUNIK = new Version2017RegionType(SCHEME, "AM-SU");

    // AM Tavut
    public static final Version2017RegionType AM_TAVUT = new Version2017RegionType(SCHEME, "AM-TV");

    // AM Vayoc Jor
    public static final Version2017RegionType AM_VAYOC_JOR = new Version2017RegionType(SCHEME, "AM-VD");

    // AO Bengo
    public static final Version2017RegionType AO_BENGO = new Version2017RegionType(SCHEME, "AO-BGO");

    // AO Benguela
    public static final Version2017RegionType AO_BENGUELA = new Version2017RegionType(SCHEME, "AO-BGU");

    // AO Bie
    public static final Version2017RegionType AO_BIE = new Version2017RegionType(SCHEME, "AO-BIE");

    // AO Cabinda
    public static final Version2017RegionType AO_CABINDA = new Version2017RegionType(SCHEME, "AO-CAB");

    // AO Cuando-cubango
    public static final Version2017RegionType AO_CUANDO_CUBANGO = new Version2017RegionType(SCHEME, "AO-CCU");

    // AO Cuanza Norte
    public static final Version2017RegionType AO_CUANZA_NORTE = new Version2017RegionType(SCHEME, "AO-CNO");

    // AO Cuanza Sul
    public static final Version2017RegionType AO_CUANZA_SUL = new Version2017RegionType(SCHEME, "AO-CUS");

    // AO Cunene
    public static final Version2017RegionType AO_CUNENE = new Version2017RegionType(SCHEME, "AO-CNN");

    // AO Huambo
    public static final Version2017RegionType AO_HUAMBO = new Version2017RegionType(SCHEME, "AO-HUA");

    // AO Huila, AO
    public static final Version2017RegionType AO_HUILA = new Version2017RegionType(SCHEME, "AO-HUI");

    // AO Luanda
    public static final Version2017RegionType AO_LUANDA = new Version2017RegionType(SCHEME, "AO-LUA");

    // AO Lunda Norte
    public static final Version2017RegionType AO_LUNDA_NORTE = new Version2017RegionType(SCHEME, "AO-LNO");

    // AO Lunda Sul
    public static final Version2017RegionType AO_LUNDA_SUL = new Version2017RegionType(SCHEME, "AO-LSU");

    // AO Malange
    public static final Version2017RegionType AO_MALANGE = new Version2017RegionType(SCHEME, "AO-MAL");

    // AO Moxico
    public static final Version2017RegionType AO_MOXICO = new Version2017RegionType(SCHEME, "AO-MOX");

    // AO Namibe
    public static final Version2017RegionType AO_NAMIBE = new Version2017RegionType(SCHEME, "AO-NAM");

    // AO Uige
    public static final Version2017RegionType AO_UIGE = new Version2017RegionType(SCHEME, "AO-UIG");

    // AO Zaire
    public static final Version2017RegionType AO_ZAIRE = new Version2017RegionType(SCHEME, "AO-ZAI");

    // AR Buenos Aires
    public static final Version2017RegionType AR_BUENOS_AIRES = new Version2017RegionType(SCHEME, "AR-B");

    // AR Capital Federal
    public static final Version2017RegionType AR_CAPITAL_FEDERAL = new Version2017RegionType(SCHEME, "AR-C");

    // AR Catamarca
    public static final Version2017RegionType AR_CATAMARCA = new Version2017RegionType(SCHEME, "AR-K");

    // AR Chaco
    public static final Version2017RegionType AR_CHACO = new Version2017RegionType(SCHEME, "AR-H");

    // AR Chubut
    public static final Version2017RegionType AR_CHUBUT = new Version2017RegionType(SCHEME, "AR-U");

    // AR Cordoba
    public static final Version2017RegionType AR_CORDOBA = new Version2017RegionType(SCHEME, "AR-X");

    // AR Corrientes
    public static final Version2017RegionType AR_CORRIENTES = new Version2017RegionType(SCHEME, "AR-W");

    // AR Entre Rios
    public static final Version2017RegionType AR_ENTRE_RIOS = new Version2017RegionType(SCHEME, "AR-E");

    // AR Formosa
    public static final Version2017RegionType AR_FORMOSA = new Version2017RegionType(SCHEME, "AR-P");

    // AR Jujuy
    public static final Version2017RegionType AR_JUJUY = new Version2017RegionType(SCHEME, "AR-Y");

    // AR La Pampa
    public static final Version2017RegionType AR_LA_PAMPA = new Version2017RegionType(SCHEME, "AR-L");

    // AR La Rioja, AR
    public static final Version2017RegionType AR_LA_RIOJA = new Version2017RegionType(SCHEME, "AR-F");

    // AR Mendoza
    public static final Version2017RegionType AR_MENDOZA = new Version2017RegionType(SCHEME, "AR-M");

    // AR Misiones, AR
    public static final Version2017RegionType AR_MISIONES = new Version2017RegionType(SCHEME, "AR-N");

    // AR Neuquen
    public static final Version2017RegionType AR_NEUQUEN = new Version2017RegionType(SCHEME, "AR-Q");

    // AR Rio Negro, AR
    public static final Version2017RegionType AR_RIO_NEGRO = new Version2017RegionType(SCHEME, "AR-R");

    // AR Salta
    public static final Version2017RegionType AR_SALTA = new Version2017RegionType(SCHEME, "AR-A");

    // AR Santa Cruz, AR
    public static final Version2017RegionType AR_SANTA_CRUZ = new Version2017RegionType(SCHEME, "AR-Z");

    // AR Santa Fe
    public static final Version2017RegionType AR_SANTA_FE = new Version2017RegionType(SCHEME, "AR-S");

    // AR Santiago Del Estero
    public static final Version2017RegionType AR_SANTIAGO_DEL_ESTERO = new Version2017RegionType(SCHEME, "AR-G");

    // AR San Juan
    public static final Version2017RegionType AR_SAN_JUAN = new Version2017RegionType(SCHEME, "AR-J");

    // AR San Luis
    public static final Version2017RegionType AR_SAN_LUIS = new Version2017RegionType(SCHEME, "AR-D");

    // AR Tierra Del Fuego
    public static final Version2017RegionType AR_TIERRA_DEL_FUEGO = new Version2017RegionType(SCHEME, "AR-V");

    // AR Tucuman
    public static final Version2017RegionType AR_TUCUMAN = new Version2017RegionType(SCHEME, "AR-T");

    // AT Burgenland
    public static final Version2017RegionType AT_BURGENLAND = new Version2017RegionType(SCHEME, "AT-1");

    // AT Karnten
    public static final Version2017RegionType AT_KARNTEN = new Version2017RegionType(SCHEME, "AT-2");

    // AT Niederosterreich
    public static final Version2017RegionType AT_NIEDEROSTERREICH = new Version2017RegionType(SCHEME, "AT-3");

    // AT Oberosterreich
    public static final Version2017RegionType AT_OBEROSTERREICH = new Version2017RegionType(SCHEME, "AT-4");

    // AT Salzburg
    public static final Version2017RegionType AT_SALZBURG = new Version2017RegionType(SCHEME, "AT-5");

    // AT Steiermark
    public static final Version2017RegionType AT_STEIERMARK = new Version2017RegionType(SCHEME, "AT-6");

    // AT Tirol
    public static final Version2017RegionType AT_TIROL = new Version2017RegionType(SCHEME, "AT-7");

    // AT Vorarlberg
    public static final Version2017RegionType AT_VORARLBERG = new Version2017RegionType(SCHEME, "AT-8");

    // AT Wien
    public static final Version2017RegionType AT_WIEN = new Version2017RegionType(SCHEME, "AT-9");

    // AU Australian Capital Territory
    public static final Version2017RegionType AU_AUSTRALIAN_CAPITAL_TERRITORY = new Version2017RegionType(SCHEME, "AU-CT");

    // AU New South Wales
    public static final Version2017RegionType AU_NEW_SOUTH_WALES = new Version2017RegionType(SCHEME, "AU-NS");

    // AU Northern Territory
    public static final Version2017RegionType AU_NORTHERN_TERRITORY = new Version2017RegionType(SCHEME, "AU-NT");

    // AU Queensland
    public static final Version2017RegionType AU_QUEENSLAND = new Version2017RegionType(SCHEME, "AU-QL");

    // AU South Australia
    public static final Version2017RegionType AU_SOUTH_AUSTRALIA = new Version2017RegionType(SCHEME, "AU-SA");

    // AU Tasmania
    public static final Version2017RegionType AU_TASMANIA = new Version2017RegionType(SCHEME, "AU-TS");

    // AU Victoria
    public static final Version2017RegionType AU_VICTORIA = new Version2017RegionType(SCHEME, "AU-VI");

    // AU Western Australia
    public static final Version2017RegionType AU_WESTERN_AUSTRALIA = new Version2017RegionType(SCHEME, "AU-WA");

    // AZ Abseron
    public static final Version2017RegionType AZ_ABSERON = new Version2017RegionType(SCHEME, "AZ-ABS");

    // AZ Agcabadi
    public static final Version2017RegionType AZ_AGCABADI = new Version2017RegionType(SCHEME, "AZ-AGC");

    // AZ Agdam
    public static final Version2017RegionType AZ_AGDAM = new Version2017RegionType(SCHEME, "AZ-AGM");

    // AZ Agdas
    public static final Version2017RegionType AZ_AGDAS = new Version2017RegionType(SCHEME, "AZ-AGS");

    // AZ Agstafa
    public static final Version2017RegionType AZ_AGSTAFA = new Version2017RegionType(SCHEME, "AZ-AGA");

    // AZ Agsu
    public static final Version2017RegionType AZ_AGSU = new Version2017RegionType(SCHEME, "AZ-AGU");

    // AZ Ali Bayramlı
    public static final Version2017RegionType AZ_ALI_BAYRAMLI = new Version2017RegionType(SCHEME, "AZ-AB");

    // AZ Astara
    public static final Version2017RegionType AZ_ASTARA = new Version2017RegionType(SCHEME, "AZ-AST");

    // AZ Babak
    public static final Version2017RegionType AZ_BABAK = new Version2017RegionType(SCHEME, "AZ-BAB");

    // AZ Bakı
    public static final Version2017RegionType AZ_BAKI = new Version2017RegionType(SCHEME, "AZ-BA");

    // AZ Balakan
    public static final Version2017RegionType AZ_BALAKAN = new Version2017RegionType(SCHEME, "AZ-BAL");

    // AZ Barda
    public static final Version2017RegionType AZ_BARDA = new Version2017RegionType(SCHEME, "AZ-BAR");

    // AZ Beylaqan
    public static final Version2017RegionType AZ_BEYLAQAN = new Version2017RegionType(SCHEME, "AZ-BEY");

    // AZ Bilasuvar
    public static final Version2017RegionType AZ_BILASUVAR = new Version2017RegionType(SCHEME, "AZ-BIL");

    // AZ Cabrayıl
    public static final Version2017RegionType AZ_CABRAYIL = new Version2017RegionType(SCHEME, "AZ-CAB");

    // AZ Calilabab
    public static final Version2017RegionType AZ_CALILABAB = new Version2017RegionType(SCHEME, "AZ-CAL");

    // AZ Culfa
    public static final Version2017RegionType AZ_CULFA = new Version2017RegionType(SCHEME, "AZ-CUL");

    // AZ Daskasan
    public static final Version2017RegionType AZ_DASKASAN = new Version2017RegionType(SCHEME, "AZ-DAS");

    // AZ Davaci
    public static final Version2017RegionType AZ_DAVACI = new Version2017RegionType(SCHEME, "AZ-DAV");

    // AZ Fuzuli
    public static final Version2017RegionType AZ_FUZULI = new Version2017RegionType(SCHEME, "AZ-FUZ");

    // AZ Gadabay
    public static final Version2017RegionType AZ_GADABAY = new Version2017RegionType(SCHEME, "AZ-GAD");

    // AZ Ganca
    public static final Version2017RegionType AZ_GANCA = new Version2017RegionType(SCHEME, "AZ-GA");

    // AZ Goranboy
    public static final Version2017RegionType AZ_GORANBOY = new Version2017RegionType(SCHEME, "AZ-GOR");

    // AZ Goycay
    public static final Version2017RegionType AZ_GOYCAY = new Version2017RegionType(SCHEME, "AZ-GOY");

    // AZ Hacıqabul
    public static final Version2017RegionType AZ_HACIQABUL = new Version2017RegionType(SCHEME, "AZ-HAC");

    // AZ Imisli
    public static final Version2017RegionType AZ_IMISLI = new Version2017RegionType(SCHEME, "AZ-IMI");

    // AZ Ismayıllı
    public static final Version2017RegionType AZ_ISMAYILLI = new Version2017RegionType(SCHEME, "AZ-ISM");

    // AZ Kalbacar
    public static final Version2017RegionType AZ_KALBACAR = new Version2017RegionType(SCHEME, "AZ-KAL");

    // AZ Kurdamir
    public static final Version2017RegionType AZ_KURDAMIR = new Version2017RegionType(SCHEME, "AZ-KUR");

    // AZ Lacın
    public static final Version2017RegionType AZ_LACIN = new Version2017RegionType(SCHEME, "AZ-LAC");

    // AZ Lankaran
    public static final Version2017RegionType AZ_LANKARAN = new Version2017RegionType(SCHEME, "AZ-LAN");

    // AZ Lankaran, AZ
    public static final Version2017RegionType AZ_LANKARAN_AZ_LA = new Version2017RegionType(SCHEME, "AZ-LA");

    // AZ Lerik
    public static final Version2017RegionType AZ_LERIK = new Version2017RegionType(SCHEME, "AZ-LER");

    // AZ Masallı
    public static final Version2017RegionType AZ_MASALLI = new Version2017RegionType(SCHEME, "AZ-MAS");

    // AZ Mingacevir
    public static final Version2017RegionType AZ_MINGACEVIR = new Version2017RegionType(SCHEME, "AZ-MI");

    // AZ Naftalan
    public static final Version2017RegionType AZ_NAFTALAN = new Version2017RegionType(SCHEME, "AZ-NA");

    // AZ Neftcala
    public static final Version2017RegionType AZ_NEFTCALA = new Version2017RegionType(SCHEME, "AZ-NEF");

    // AZ Oguz
    public static final Version2017RegionType AZ_OGUZ = new Version2017RegionType(SCHEME, "AZ-OGU");

    // AZ Ordubad
    public static final Version2017RegionType AZ_ORDUBAD = new Version2017RegionType(SCHEME, "AZ-ORD");

    // AZ Qabala
    public static final Version2017RegionType AZ_QABALA = new Version2017RegionType(SCHEME, "AZ-QAB");

    // AZ Qax
    public static final Version2017RegionType AZ_QAX = new Version2017RegionType(SCHEME, "AZ-QAX");

    // AZ Qazax
    public static final Version2017RegionType AZ_QAZAX = new Version2017RegionType(SCHEME, "AZ-QAZ");

    // AZ Qobustan
    public static final Version2017RegionType AZ_QOBUSTAN = new Version2017RegionType(SCHEME, "AZ-QOB");

    // AZ Quba
    public static final Version2017RegionType AZ_QUBA = new Version2017RegionType(SCHEME, "AZ-QBA");

    // AZ Qubadlı
    public static final Version2017RegionType AZ_QUBADLI = new Version2017RegionType(SCHEME, "AZ-QBI");

    // AZ Qusar
    public static final Version2017RegionType AZ_QUSAR = new Version2017RegionType(SCHEME, "AZ-QUS");

    // AZ Saatlı
    public static final Version2017RegionType AZ_SAATLI = new Version2017RegionType(SCHEME, "AZ-SAT");

    // AZ Sabirabad
    public static final Version2017RegionType AZ_SABIRABAD = new Version2017RegionType(SCHEME, "AZ-SAB");

    // AZ Sadarak
    public static final Version2017RegionType AZ_SADARAK = new Version2017RegionType(SCHEME, "AZ-SAD");

    // AZ Sahbuz
    public static final Version2017RegionType AZ_SAHBUZ = new Version2017RegionType(SCHEME, "AZ-SAH");

    // AZ Saki
    public static final Version2017RegionType AZ_SAKI = new Version2017RegionType(SCHEME, "AZ-SA");

    // AZ Saki, AZ
    public static final Version2017RegionType AZ_SAKI_AZ_SAK = new Version2017RegionType(SCHEME, "AZ-SAK");

    // AZ Salyan
    public static final Version2017RegionType AZ_SALYAN = new Version2017RegionType(SCHEME, "AZ-SAL");

    // AZ Samaxı
    public static final Version2017RegionType AZ_SAMAXI = new Version2017RegionType(SCHEME, "AZ-SMI");

    // AZ Samkir
    public static final Version2017RegionType AZ_SAMKIR = new Version2017RegionType(SCHEME, "AZ-SKR");

    // AZ Samux
    public static final Version2017RegionType AZ_SAMUX = new Version2017RegionType(SCHEME, "AZ-SMX");

    // AZ Sarur
    public static final Version2017RegionType AZ_SARUR = new Version2017RegionType(SCHEME, "AZ-SAR");

    // AZ Siyazan
    public static final Version2017RegionType AZ_SIYAZAN = new Version2017RegionType(SCHEME, "AZ-SIY");

    // AZ Sumqayıt
    public static final Version2017RegionType AZ_SUMQAYIT = new Version2017RegionType(SCHEME, "AZ-SM");

    // AZ Susa
    public static final Version2017RegionType AZ_SUSA = new Version2017RegionType(SCHEME, "AZ-SS");

    // AZ Susa, AZ
    public static final Version2017RegionType AZ_SUSA_AZ_SUS = new Version2017RegionType(SCHEME, "AZ-SUS");

    // AZ Tartar
    public static final Version2017RegionType AZ_TARTAR = new Version2017RegionType(SCHEME, "AZ-TAR");

    // AZ Tovuz
    public static final Version2017RegionType AZ_TOVUZ = new Version2017RegionType(SCHEME, "AZ-TOV");

    // AZ Ucar
    public static final Version2017RegionType AZ_UCAR = new Version2017RegionType(SCHEME, "AZ-UCA");

    // AZ Xacmaz
    public static final Version2017RegionType AZ_XACMAZ = new Version2017RegionType(SCHEME, "AZ-XAC");

    // AZ Xankandi
    public static final Version2017RegionType AZ_XANKANDI = new Version2017RegionType(SCHEME, "AZ-XA");

    // AZ Xanlar
    public static final Version2017RegionType AZ_XANLAR = new Version2017RegionType(SCHEME, "AZ-XAN");

    // AZ Xızı
    public static final Version2017RegionType AZ_XIZI = new Version2017RegionType(SCHEME, "AZ-XIZ");

    // AZ Xocalı
    public static final Version2017RegionType AZ_XOCALI = new Version2017RegionType(SCHEME, "AZ-XCI");

    // AZ Xocavand
    public static final Version2017RegionType AZ_XOCAVAND = new Version2017RegionType(SCHEME, "AZ-XVD");

    // AZ Yardımlı
    public static final Version2017RegionType AZ_YARDIMLI = new Version2017RegionType(SCHEME, "AZ-YAR");

    // AZ Yevlax
    public static final Version2017RegionType AZ_YEVLAX = new Version2017RegionType(SCHEME, "AZ-YEV");

    // AZ Yevlax, AZ
    public static final Version2017RegionType AZ_YEVLAX_AZ_YE = new Version2017RegionType(SCHEME, "AZ-YE");

    // AZ Zangilan
    public static final Version2017RegionType AZ_ZANGILAN = new Version2017RegionType(SCHEME, "AZ-ZAN");

    // AZ Zaqatala
    public static final Version2017RegionType AZ_ZAQATALA = new Version2017RegionType(SCHEME, "AZ-ZAQ");

    // AZ Zardab
    public static final Version2017RegionType AZ_ZARDAB = new Version2017RegionType(SCHEME, "AZ-ZAR");

    // BA Federacija Bosna I Hercegovina
    public static final Version2017RegionType BA_FEDERACIJA_BOSNA_I_HERCEGOVINA = new Version2017RegionType(SCHEME, "BA-BIH");

    // BA Republika Srpska
    public static final Version2017RegionType BA_REPUBLIKA_SRPSKA = new Version2017RegionType(SCHEME, "BA-SRP");

    // BD Bagerhat Zila
    public static final Version2017RegionType BD_BAGERHAT_ZILA = new Version2017RegionType(SCHEME, "BD-05");

    // BD Bandarban Zila
    public static final Version2017RegionType BD_BANDARBAN_ZILA = new Version2017RegionType(SCHEME, "BD-01");

    // BD Barguna Zila
    public static final Version2017RegionType BD_BARGUNA_ZILA = new Version2017RegionType(SCHEME, "BD-02");

    // BD Barisal Zila
    public static final Version2017RegionType BD_BARISAL_ZILA = new Version2017RegionType(SCHEME, "BD-06");

    // BD Bhola Zila
    public static final Version2017RegionType BD_BHOLA_ZILA = new Version2017RegionType(SCHEME, "BD-07");

    // BD Bogra Zila
    public static final Version2017RegionType BD_BOGRA_ZILA = new Version2017RegionType(SCHEME, "BD-03");

    // BD Brahmanbaria Zila
    public static final Version2017RegionType BD_BRAHMANBARIA_ZILA = new Version2017RegionType(SCHEME, "BD-04");

    // BD Chandpur Zila
    public static final Version2017RegionType BD_CHANDPUR_ZILA = new Version2017RegionType(SCHEME, "BD-09");

    // BD Chittagong Zila
    public static final Version2017RegionType BD_CHITTAGONG_ZILA = new Version2017RegionType(SCHEME, "BD-10");

    // BD Chuadanga Zila
    public static final Version2017RegionType BD_CHUADANGA_ZILA = new Version2017RegionType(SCHEME, "BD-12");

    // BD Comilla Zila
    public static final Version2017RegionType BD_COMILLA_ZILA = new Version2017RegionType(SCHEME, "BD-08");

    // BD Cox's Bazar Zila
    public static final Version2017RegionType BD_COXS_BAZAR_ZILA = new Version2017RegionType(SCHEME, "BD-11");

    // BD Dhaka Zila
    public static final Version2017RegionType BD_DHAKA_ZILA = new Version2017RegionType(SCHEME, "BD-13");

    // BD Dinajpur Zila
    public static final Version2017RegionType BD_DINAJPUR_ZILA = new Version2017RegionType(SCHEME, "BD-14");

    // BD Faridpur Zila
    public static final Version2017RegionType BD_FARIDPUR_ZILA = new Version2017RegionType(SCHEME, "BD-15");

    // BD Feni Zila
    public static final Version2017RegionType BD_FENI_ZILA = new Version2017RegionType(SCHEME, "BD-16");

    // BD Gaibandha Zila
    public static final Version2017RegionType BD_GAIBANDHA_ZILA = new Version2017RegionType(SCHEME, "BD-19");

    // BD Gazipur Zila
    public static final Version2017RegionType BD_GAZIPUR_ZILA = new Version2017RegionType(SCHEME, "BD-18");

    // BD Gopalganj Zila
    public static final Version2017RegionType BD_GOPALGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-17");

    // BD Habiganj Zila
    public static final Version2017RegionType BD_HABIGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-20");

    // BD Jaipurhat Zila
    public static final Version2017RegionType BD_JAIPURHAT_ZILA = new Version2017RegionType(SCHEME, "BD-24");

    // BD Jamalpur Zila
    public static final Version2017RegionType BD_JAMALPUR_ZILA = new Version2017RegionType(SCHEME, "BD-21");

    // BD Jessore Zila
    public static final Version2017RegionType BD_JESSORE_ZILA = new Version2017RegionType(SCHEME, "BD-22");

    // BD Jhalakati Zila
    public static final Version2017RegionType BD_JHALAKATI_ZILA = new Version2017RegionType(SCHEME, "BD-25");

    // BD Jhenaidah Zila
    public static final Version2017RegionType BD_JHENAIDAH_ZILA = new Version2017RegionType(SCHEME, "BD-23");

    // BD Khagrachari Zila
    public static final Version2017RegionType BD_KHAGRACHARI_ZILA = new Version2017RegionType(SCHEME, "BD-29");

    // BD Khulna Zila
    public static final Version2017RegionType BD_KHULNA_ZILA = new Version2017RegionType(SCHEME, "BD-27");

    // BD Kishoreganj Zila
    public static final Version2017RegionType BD_KISHOREGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-26");

    // BD Kurigram Zila
    public static final Version2017RegionType BD_KURIGRAM_ZILA = new Version2017RegionType(SCHEME, "BD-28");

    // BD Kushtia Zila
    public static final Version2017RegionType BD_KUSHTIA_ZILA = new Version2017RegionType(SCHEME, "BD-30");

    // BD Lakshmipur Zila
    public static final Version2017RegionType BD_LAKSHMIPUR_ZILA = new Version2017RegionType(SCHEME, "BD-31");

    // BD Lalmonirhat Zila
    public static final Version2017RegionType BD_LALMONIRHAT_ZILA = new Version2017RegionType(SCHEME, "BD-32");

    // BD Madaripur Zila
    public static final Version2017RegionType BD_MADARIPUR_ZILA = new Version2017RegionType(SCHEME, "BD-36");

    // BD Magura Zila
    public static final Version2017RegionType BD_MAGURA_ZILA = new Version2017RegionType(SCHEME, "BD-37");

    // BD Manikganj Zila
    public static final Version2017RegionType BD_MANIKGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-33");

    // BD Meherpur Zila
    public static final Version2017RegionType BD_MEHERPUR_ZILA = new Version2017RegionType(SCHEME, "BD-39");

    // BD Moulvibazar Zila
    public static final Version2017RegionType BD_MOULVIBAZAR_ZILA = new Version2017RegionType(SCHEME, "BD-38");

    // BD Munshiganj Zila
    public static final Version2017RegionType BD_MUNSHIGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-35");

    // BD Mymensingh Zila
    public static final Version2017RegionType BD_MYMENSINGH_ZILA = new Version2017RegionType(SCHEME, "BD-34");

    // BD Naogaon Zila
    public static final Version2017RegionType BD_NAOGAON_ZILA = new Version2017RegionType(SCHEME, "BD-48");

    // BD Narail Zila
    public static final Version2017RegionType BD_NARAIL_ZILA = new Version2017RegionType(SCHEME, "BD-43");

    // BD Narayanganj Zila
    public static final Version2017RegionType BD_NARAYANGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-40");

    // BD Narsingdi Zila
    public static final Version2017RegionType BD_NARSINGDI_ZILA = new Version2017RegionType(SCHEME, "BD-42");

    // BD Natore Zila
    public static final Version2017RegionType BD_NATORE_ZILA = new Version2017RegionType(SCHEME, "BD-44");

    // BD Nawabganj Zila
    public static final Version2017RegionType BD_NAWABGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-45");

    // BD Netrakona Zila
    public static final Version2017RegionType BD_NETRAKONA_ZILA = new Version2017RegionType(SCHEME, "BD-41");

    // BD Nilphamari Zila
    public static final Version2017RegionType BD_NILPHAMARI_ZILA = new Version2017RegionType(SCHEME, "BD-46");

    // BD Noakhali Zila
    public static final Version2017RegionType BD_NOAKHALI_ZILA = new Version2017RegionType(SCHEME, "BD-47");

    // BD Pabna Zila
    public static final Version2017RegionType BD_PABNA_ZILA = new Version2017RegionType(SCHEME, "BD-49");

    // BD Panchagarh Zila
    public static final Version2017RegionType BD_PANCHAGARH_ZILA = new Version2017RegionType(SCHEME, "BD-52");

    // BD Patuakhali Zila
    public static final Version2017RegionType BD_PATUAKHALI_ZILA = new Version2017RegionType(SCHEME, "BD-51");

    // BD Pirojpur Zila
    public static final Version2017RegionType BD_PIROJPUR_ZILA = new Version2017RegionType(SCHEME, "BD-50");

    // BD Rajbari Zila
    public static final Version2017RegionType BD_RAJBARI_ZILA = new Version2017RegionType(SCHEME, "BD-53");

    // BD Rajshahi Zila
    public static final Version2017RegionType BD_RAJSHAHI_ZILA = new Version2017RegionType(SCHEME, "BD-54");

    // BD Rangamati Zila
    public static final Version2017RegionType BD_RANGAMATI_ZILA = new Version2017RegionType(SCHEME, "BD-56");

    // BD Rangpur Zila
    public static final Version2017RegionType BD_RANGPUR_ZILA = new Version2017RegionType(SCHEME, "BD-55");

    // BD Satkhira Zila
    public static final Version2017RegionType BD_SATKHIRA_ZILA = new Version2017RegionType(SCHEME, "BD-58");

    // BD Shariatpur Zila
    public static final Version2017RegionType BD_SHARIATPUR_ZILA = new Version2017RegionType(SCHEME, "BD-62");

    // BD Sherpur Zila
    public static final Version2017RegionType BD_SHERPUR_ZILA = new Version2017RegionType(SCHEME, "BD-57");

    // BD Sirajganj Zila
    public static final Version2017RegionType BD_SIRAJGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-59");

    // BD Sunamganj Zila
    public static final Version2017RegionType BD_SUNAMGANJ_ZILA = new Version2017RegionType(SCHEME, "BD-61");

    // BD Sylhet Zila
    public static final Version2017RegionType BD_SYLHET_ZILA = new Version2017RegionType(SCHEME, "BD-60");

    // BD Tangail Zila
    public static final Version2017RegionType BD_TANGAIL_ZILA = new Version2017RegionType(SCHEME, "BD-63");

    // BD Thakurgaon Zila
    public static final Version2017RegionType BD_THAKURGAON_ZILA = new Version2017RegionType(SCHEME, "BD-64");

    // BE Antwerpen (nl)
    public static final Version2017RegionType BE_ANTWERPEN_NL = new Version2017RegionType(SCHEME, "BE-VAN");

    // BE Brabant Wallon (fr)
    public static final Version2017RegionType BE_BRABANT_WALLON_FR = new Version2017RegionType(SCHEME, "BE-WBR");

    // BE Hainaut (fr)
    public static final Version2017RegionType BE_HAINAUT_FR = new Version2017RegionType(SCHEME, "BE-WHT");

    // BE Liege (fr)
    public static final Version2017RegionType BE_LIEGE_FR = new Version2017RegionType(SCHEME, "BE-WLG");

    // BE Limburg (nl)
    public static final Version2017RegionType BE_LIMBURG_NL = new Version2017RegionType(SCHEME, "BE-VLI");

    // BE Luxembourg (fr), BE
    public static final Version2017RegionType BE_LUXEMBOURG_FR = new Version2017RegionType(SCHEME, "BE-WLX");

    // BE Namur (fr)
    public static final Version2017RegionType BE_NAMUR_FR = new Version2017RegionType(SCHEME, "BE-WNA");

    // BE Oost-vlaanderen (nl)
    public static final Version2017RegionType BE_OOST_VLAANDEREN_NL = new Version2017RegionType(SCHEME, "BE-VOV");

    // BE Vlaams Brabant (nl)
    public static final Version2017RegionType BE_VLAAMS_BRABANT_NL = new Version2017RegionType(SCHEME, "BE-VBR");

    // BE West-vlaanderen (nl)
    public static final Version2017RegionType BE_WEST_VLAANDEREN_NL = new Version2017RegionType(SCHEME, "BE-VWV");

    // BF Bale
    public static final Version2017RegionType BF_BALE = new Version2017RegionType(SCHEME, "BF-BAL");

    // BF Bam
    public static final Version2017RegionType BF_BAM = new Version2017RegionType(SCHEME, "BF-BAM");

    // BF Banwa
    public static final Version2017RegionType BF_BANWA = new Version2017RegionType(SCHEME, "BF-BAN");

    // BF Bazega
    public static final Version2017RegionType BF_BAZEGA = new Version2017RegionType(SCHEME, "BF-BAZ");

    // BF Bougouriba
    public static final Version2017RegionType BF_BOUGOURIBA = new Version2017RegionType(SCHEME, "BF-BGR");

    // BF Boulgou
    public static final Version2017RegionType BF_BOULGOU = new Version2017RegionType(SCHEME, "BF-BLG");

    // BF Boulkiemde
    public static final Version2017RegionType BF_BOULKIEMDE = new Version2017RegionType(SCHEME, "BF-BLK");

    // BF Comoe
    public static final Version2017RegionType BF_COMOE = new Version2017RegionType(SCHEME, "BF-COM");

    // BF Ganzourgou
    public static final Version2017RegionType BF_GANZOURGOU = new Version2017RegionType(SCHEME, "BF-GAN");

    // BF Gnagna
    public static final Version2017RegionType BF_GNAGNA = new Version2017RegionType(SCHEME, "BF-GNA");

    // BF Gourma
    public static final Version2017RegionType BF_GOURMA = new Version2017RegionType(SCHEME, "BF-GOU");

    // BF Houet
    public static final Version2017RegionType BF_HOUET = new Version2017RegionType(SCHEME, "BF-HOU");

    // BF Ioba
    public static final Version2017RegionType BF_IOBA = new Version2017RegionType(SCHEME, "BF-IOB");

    // BF Kadiogo
    public static final Version2017RegionType BF_KADIOGO = new Version2017RegionType(SCHEME, "BF-KAD");

    // BF Kenedougou
    public static final Version2017RegionType BF_KENEDOUGOU = new Version2017RegionType(SCHEME, "BF-KEN");

    // BF Komondjari
    public static final Version2017RegionType BF_KOMONDJARI = new Version2017RegionType(SCHEME, "BF-KMD");

    // BF Kompienga
    public static final Version2017RegionType BF_KOMPIENGA = new Version2017RegionType(SCHEME, "BF-KMP");

    // BF Kossi
    public static final Version2017RegionType BF_KOSSI = new Version2017RegionType(SCHEME, "BF-KOS");

    // BF Koulpelogo
    public static final Version2017RegionType BF_KOULPELOGO = new Version2017RegionType(SCHEME, "BF-KOP");

    // BF Kouritenga
    public static final Version2017RegionType BF_KOURITENGA = new Version2017RegionType(SCHEME, "BF-KOT");

    // BF Kourweogo
    public static final Version2017RegionType BF_KOURWEOGO = new Version2017RegionType(SCHEME, "BF-KOW");

    // BF Leraba
    public static final Version2017RegionType BF_LERABA = new Version2017RegionType(SCHEME, "BF-LER");

    // BF Loroum
    public static final Version2017RegionType BF_LOROUM = new Version2017RegionType(SCHEME, "BF-LOR");

    // BF Mouhoun
    public static final Version2017RegionType BF_MOUHOUN = new Version2017RegionType(SCHEME, "BF-MOU");

    // BF Nahouri
    public static final Version2017RegionType BF_NAHOURI = new Version2017RegionType(SCHEME, "BF-NAO");

    // BF Namentenga
    public static final Version2017RegionType BF_NAMENTENGA = new Version2017RegionType(SCHEME, "BF-NAM");

    // BF Nayala
    public static final Version2017RegionType BF_NAYALA = new Version2017RegionType(SCHEME, "BF-NAY");

    // BF Noumbiel
    public static final Version2017RegionType BF_NOUMBIEL = new Version2017RegionType(SCHEME, "BF-NOU");

    // BF Oubritenga
    public static final Version2017RegionType BF_OUBRITENGA = new Version2017RegionType(SCHEME, "BF-OUB");

    // BF Oudalan
    public static final Version2017RegionType BF_OUDALAN = new Version2017RegionType(SCHEME, "BF-OUD");

    // BF Passore
    public static final Version2017RegionType BF_PASSORE = new Version2017RegionType(SCHEME, "BF-PAS");

    // BF Poni
    public static final Version2017RegionType BF_PONI = new Version2017RegionType(SCHEME, "BF-PON");

    // BF Sanguie
    public static final Version2017RegionType BF_SANGUIE = new Version2017RegionType(SCHEME, "BF-SNG");

    // BF Sanmatenga
    public static final Version2017RegionType BF_SANMATENGA = new Version2017RegionType(SCHEME, "BF-SMT");

    // BF Seno
    public static final Version2017RegionType BF_SENO = new Version2017RegionType(SCHEME, "BF-SEN");

    // BF Sissili
    public static final Version2017RegionType BF_SISSILI = new Version2017RegionType(SCHEME, "BF-SIS");

    // BF Soum
    public static final Version2017RegionType BF_SOUM = new Version2017RegionType(SCHEME, "BF-SOM");

    // BF Sourou
    public static final Version2017RegionType BF_SOUROU = new Version2017RegionType(SCHEME, "BF-SOR");

    // BF Tapoa
    public static final Version2017RegionType BF_TAPOA = new Version2017RegionType(SCHEME, "BF-TAP");

    // BF Tui
    public static final Version2017RegionType BF_TUI = new Version2017RegionType(SCHEME, "BF-TUI");

    // BF Yagha
    public static final Version2017RegionType BF_YAGHA = new Version2017RegionType(SCHEME, "BF-YAG");

    // BF Yatenga
    public static final Version2017RegionType BF_YATENGA = new Version2017RegionType(SCHEME, "BF-YAT");

    // BF Ziro
    public static final Version2017RegionType BF_ZIRO = new Version2017RegionType(SCHEME, "BF-ZIR");

    // BF Zondoma
    public static final Version2017RegionType BF_ZONDOMA = new Version2017RegionType(SCHEME, "BF-ZON");

    // BF Zoundweogo
    public static final Version2017RegionType BF_ZOUNDWEOGO = new Version2017RegionType(SCHEME, "BF-ZOU");

    // BG Blagoevgrad
    public static final Version2017RegionType BG_BLAGOEVGRAD = new Version2017RegionType(SCHEME, "BG-01");

    // BG Burgas
    public static final Version2017RegionType BG_BURGAS = new Version2017RegionType(SCHEME, "BG-02");

    // BG Dobric
    public static final Version2017RegionType BG_DOBRIC = new Version2017RegionType(SCHEME, "BG-08");

    // BG Gabrovo
    public static final Version2017RegionType BG_GABROVO = new Version2017RegionType(SCHEME, "BG-07");

    // BG Haskovo
    public static final Version2017RegionType BG_HASKOVO = new Version2017RegionType(SCHEME, "BG-26");

    // BG Jambol
    public static final Version2017RegionType BG_JAMBOL = new Version2017RegionType(SCHEME, "BG-28");

    // BG Kardlali
    public static final Version2017RegionType BG_KARDLALI = new Version2017RegionType(SCHEME, "BG-09");

    // BG Kjustendil
    public static final Version2017RegionType BG_KJUSTENDIL = new Version2017RegionType(SCHEME, "BG-10");

    // BG Lovec
    public static final Version2017RegionType BG_LOVEC = new Version2017RegionType(SCHEME, "BG-11");

    // BG Lumen
    public static final Version2017RegionType BG_LUMEN = new Version2017RegionType(SCHEME, "BG-27");

    // BG Montana
    public static final Version2017RegionType BG_MONTANA = new Version2017RegionType(SCHEME, "BG-12");

    // BG Pazardlik
    public static final Version2017RegionType BG_PAZARDLIK = new Version2017RegionType(SCHEME, "BG-13");

    // BG Pernik
    public static final Version2017RegionType BG_PERNIK = new Version2017RegionType(SCHEME, "BG-14");

    // BG Pleven
    public static final Version2017RegionType BG_PLEVEN = new Version2017RegionType(SCHEME, "BG-15");

    // BG Plovdiv
    public static final Version2017RegionType BG_PLOVDIV = new Version2017RegionType(SCHEME, "BG-16");

    // BG Razgrad
    public static final Version2017RegionType BG_RAZGRAD = new Version2017RegionType(SCHEME, "BG-17");

    // BG Ruse
    public static final Version2017RegionType BG_RUSE = new Version2017RegionType(SCHEME, "BG-18");

    // BG Silistra
    public static final Version2017RegionType BG_SILISTRA = new Version2017RegionType(SCHEME, "BG-19");

    // BG Sliven
    public static final Version2017RegionType BG_SLIVEN = new Version2017RegionType(SCHEME, "BG-20");

    // BG Smoljan
    public static final Version2017RegionType BG_SMOLJAN = new Version2017RegionType(SCHEME, "BG-21");

    // BG Sofija
    public static final Version2017RegionType BG_SOFIJA = new Version2017RegionType(SCHEME, "BG-23");

    // BG Sofija-grad
    public static final Version2017RegionType BG_SOFIJA_GRAD = new Version2017RegionType(SCHEME, "BG-22");

    // BG Stara Zagora
    public static final Version2017RegionType BG_STARA_ZAGORA = new Version2017RegionType(SCHEME, "BG-24");

    // BG Targovolte
    public static final Version2017RegionType BG_TARGOVOLTE = new Version2017RegionType(SCHEME, "BG-25");

    // BG Varna
    public static final Version2017RegionType BG_VARNA = new Version2017RegionType(SCHEME, "BG-03");

    // BG Veliko Tarnovo
    public static final Version2017RegionType BG_VELIKO_TARNOVO = new Version2017RegionType(SCHEME, "BG-04");

    // BG Vidin
    public static final Version2017RegionType BG_VIDIN = new Version2017RegionType(SCHEME, "BG-05");

    // BG Vraca
    public static final Version2017RegionType BG_VRACA = new Version2017RegionType(SCHEME, "BG-06");

    // BH Al Hadd
    public static final Version2017RegionType BH_AL_HADD = new Version2017RegionType(SCHEME, "BH-01");

    // BH Al Manamah
    public static final Version2017RegionType BH_AL_MANAMAH = new Version2017RegionType(SCHEME, "BH-03");

    // BH Al Mintaqah Al Gharbiyah
    public static final Version2017RegionType BH_AL_MINTAQAH_AL_GHARBIYAH = new Version2017RegionType(SCHEME, "BH-10");

    // BH Al Mintaqah Al Wusta
    public static final Version2017RegionType BH_AL_MINTAQAH_AL_WUSTA = new Version2017RegionType(SCHEME, "BH-07");

    // BH Al Mirtaqah Ash Shamaliyah
    public static final Version2017RegionType BH_AL_MIRTAQAH_ASH_SHAMALIYAH = new Version2017RegionType(SCHEME, "BH-05");

    // BH Al Muharraq
    public static final Version2017RegionType BH_AL_MUHARRAQ = new Version2017RegionType(SCHEME, "BH-02");

    // BH Ar Rifa
    public static final Version2017RegionType BH_AR_RIFA = new Version2017RegionType(SCHEME, "BH-09");

    // BH Jidd Hafs
    public static final Version2017RegionType BH_JIDD_HAFS = new Version2017RegionType(SCHEME, "BH-04");

    // BH Madinat Hamad
    public static final Version2017RegionType BH_MADINAT_HAMAD = new Version2017RegionType(SCHEME, "BH-12");

    // BH Madinat Isa
    public static final Version2017RegionType BH_MADINAT_ISA = new Version2017RegionType(SCHEME, "BH-08");

    // BH Mintaqat Juzur Hawar
    public static final Version2017RegionType BH_MINTAQAT_JUZUR_HAWAR = new Version2017RegionType(SCHEME, "BH-11");

    // BH Sitrah
    public static final Version2017RegionType BH_SITRAH = new Version2017RegionType(SCHEME, "BH-06");

    // BI Bubanza
    public static final Version2017RegionType BI_BUBANZA = new Version2017RegionType(SCHEME, "BI-BB");

    // BI Bujumbura
    public static final Version2017RegionType BI_BUJUMBURA = new Version2017RegionType(SCHEME, "BI-BJ");

    // BI Bururi
    public static final Version2017RegionType BI_BURURI = new Version2017RegionType(SCHEME, "BI-BR");

    // BI Cankuzo
    public static final Version2017RegionType BI_CANKUZO = new Version2017RegionType(SCHEME, "BI-CA");

    // BI Cibitoke
    public static final Version2017RegionType BI_CIBITOKE = new Version2017RegionType(SCHEME, "BI-CI");

    // BI Gitega
    public static final Version2017RegionType BI_GITEGA = new Version2017RegionType(SCHEME, "BI-GI");

    // BI Karuzi
    public static final Version2017RegionType BI_KARUZI = new Version2017RegionType(SCHEME, "BI-KR");

    // BI Kayanza
    public static final Version2017RegionType BI_KAYANZA = new Version2017RegionType(SCHEME, "BI-KY");

    // BI Kirundo
    public static final Version2017RegionType BI_KIRUNDO = new Version2017RegionType(SCHEME, "BI-KI");

    // BI Makamba
    public static final Version2017RegionType BI_MAKAMBA = new Version2017RegionType(SCHEME, "BI-MA");

    // BI Muramvya
    public static final Version2017RegionType BI_MURAMVYA = new Version2017RegionType(SCHEME, "BI-MU");

    // BI Muyinga
    public static final Version2017RegionType BI_MUYINGA = new Version2017RegionType(SCHEME, "BI-MY");

    // BI Mwaro
    public static final Version2017RegionType BI_MWARO = new Version2017RegionType(SCHEME, "BI-MW");

    // BI Ngozi
    public static final Version2017RegionType BI_NGOZI = new Version2017RegionType(SCHEME, "BI-NG");

    // BI Rutana
    public static final Version2017RegionType BI_RUTANA = new Version2017RegionType(SCHEME, "BI-RT");

    // BI Ruyigi
    public static final Version2017RegionType BI_RUYIGI = new Version2017RegionType(SCHEME, "BI-RY");

    // BJ Alibori
    public static final Version2017RegionType BJ_ALIBORI = new Version2017RegionType(SCHEME, "BJ-AL");

    // BJ Atakora
    public static final Version2017RegionType BJ_ATAKORA = new Version2017RegionType(SCHEME, "BJ-AK");

    // BJ Atlantique
    public static final Version2017RegionType BJ_ATLANTIQUE = new Version2017RegionType(SCHEME, "BJ-AQ");

    // BJ Borgou
    public static final Version2017RegionType BJ_BORGOU = new Version2017RegionType(SCHEME, "BJ-BO");

    // BJ Collines
    public static final Version2017RegionType BJ_COLLINES = new Version2017RegionType(SCHEME, "BJ-CO");

    // BJ Donga
    public static final Version2017RegionType BJ_DONGA = new Version2017RegionType(SCHEME, "BJ-DO");

    // BJ Kouffo
    public static final Version2017RegionType BJ_KOUFFO = new Version2017RegionType(SCHEME, "BJ-KO");

    // BJ Littoral, BJ
    public static final Version2017RegionType BJ_LITTORAL = new Version2017RegionType(SCHEME, "BJ-LI");

    // BJ Mono
    public static final Version2017RegionType BJ_MONO = new Version2017RegionType(SCHEME, "BJ-MO");

    // BJ Oueme
    public static final Version2017RegionType BJ_OUEME = new Version2017RegionType(SCHEME, "BJ-OU");

    // BJ Plateau, BJ
    public static final Version2017RegionType BJ_PLATEAU = new Version2017RegionType(SCHEME, "BJ-PL");

    // BJ Zou
    public static final Version2017RegionType BJ_ZOU = new Version2017RegionType(SCHEME, "BJ-ZO");

    // BN Belait
    public static final Version2017RegionType BN_BELAIT = new Version2017RegionType(SCHEME, "BN-BE");

    // BN Brunei-muara
    public static final Version2017RegionType BN_BRUNEI_MUARA = new Version2017RegionType(SCHEME, "BN-BM");

    // BN Temburong
    public static final Version2017RegionType BN_TEMBURONG = new Version2017RegionType(SCHEME, "BN-TE");

    // BN Tutong
    public static final Version2017RegionType BN_TUTONG = new Version2017RegionType(SCHEME, "BN-TU");

    // BO Chuquisaca
    public static final Version2017RegionType BO_CHUQUISACA = new Version2017RegionType(SCHEME, "BO-H");

    // BO Cochabamba
    public static final Version2017RegionType BO_COCHABAMBA = new Version2017RegionType(SCHEME, "BO-C");

    // BO El Beni
    public static final Version2017RegionType BO_EL_BENI = new Version2017RegionType(SCHEME, "BO-B");

    // BO La Paz, BO
    public static final Version2017RegionType BO_LA_PAZ = new Version2017RegionType(SCHEME, "BO-L");

    // BO Oruro
    public static final Version2017RegionType BO_ORURO = new Version2017RegionType(SCHEME, "BO-O");

    // BO Pando
    public static final Version2017RegionType BO_PANDO = new Version2017RegionType(SCHEME, "BO-N");

    // BO Potosi
    public static final Version2017RegionType BO_POTOSI = new Version2017RegionType(SCHEME, "BO-P");

    // BO Santa Cruz
    public static final Version2017RegionType BO_SANTA_CRUZ = new Version2017RegionType(SCHEME, "BO-S");

    // BO Tarija
    public static final Version2017RegionType BO_TARIJA = new Version2017RegionType(SCHEME, "BO-T");

    // BR Acre
    public static final Version2017RegionType BR_ACRE = new Version2017RegionType(SCHEME, "BR-AC");

    // BR Alagoas
    public static final Version2017RegionType BR_ALAGOAS = new Version2017RegionType(SCHEME, "BR-AL");

    // BR Amapa
    public static final Version2017RegionType BR_AMAPA = new Version2017RegionType(SCHEME, "BR-AP");

    // BR Amazonas
    public static final Version2017RegionType BR_AMAZONAS = new Version2017RegionType(SCHEME, "BR-AM");

    // BR Bahia
    public static final Version2017RegionType BR_BAHIA = new Version2017RegionType(SCHEME, "BR-BA");

    // BR Ceara
    public static final Version2017RegionType BR_CEARA = new Version2017RegionType(SCHEME, "BR-CE");

    // BR Distrito Federal, BR
    public static final Version2017RegionType BR_DISTRITO_FEDERAL = new Version2017RegionType(SCHEME, "BR-DF");

    // BR Espirito Santo
    public static final Version2017RegionType BR_ESPIRITO_SANTO = new Version2017RegionType(SCHEME, "BR-ES");

    // BR Goias
    public static final Version2017RegionType BR_GOIAS = new Version2017RegionType(SCHEME, "BR-GO");

    // BR Maranhao
    public static final Version2017RegionType BR_MARANHAO = new Version2017RegionType(SCHEME, "BR-MA");

    // BR Mato Grosso
    public static final Version2017RegionType BR_MATO_GROSSO = new Version2017RegionType(SCHEME, "BR-MT");

    // BR Mato Grosso Do Sul
    public static final Version2017RegionType BR_MATO_GROSSO_DO_SUL = new Version2017RegionType(SCHEME, "BR-MS");

    // BR Minas Gerais
    public static final Version2017RegionType BR_MINAS_GERAIS = new Version2017RegionType(SCHEME, "BR-MG");

    // BR Para, BR
    public static final Version2017RegionType BR_PARA = new Version2017RegionType(SCHEME, "BR-PA");

    // BR Paraiba
    public static final Version2017RegionType BR_PARAIBA = new Version2017RegionType(SCHEME, "BR-PB");

    // BR Parana
    public static final Version2017RegionType BR_PARANA = new Version2017RegionType(SCHEME, "BR-PR");

    // BR Pernambuco
    public static final Version2017RegionType BR_PERNAMBUCO = new Version2017RegionType(SCHEME, "BR-PE");

    // BR Piaui
    public static final Version2017RegionType BR_PIAUI = new Version2017RegionType(SCHEME, "BR-PI");

    // BR Rio De Janeiro
    public static final Version2017RegionType BR_RIO_DE_JANEIRO = new Version2017RegionType(SCHEME, "BR-RJ");

    // BR Rio Grande Do Norte
    public static final Version2017RegionType BR_RIO_GRANDE_DO_NORTE = new Version2017RegionType(SCHEME, "BR-RN");

    // BR Rio Grande Do Sul
    public static final Version2017RegionType BR_RIO_GRANDE_DO_SUL = new Version2017RegionType(SCHEME, "BR-RS");

    // BR Rondonia
    public static final Version2017RegionType BR_RONDONIA = new Version2017RegionType(SCHEME, "BR-RO");

    // BR Roraima
    public static final Version2017RegionType BR_RORAIMA = new Version2017RegionType(SCHEME, "BR-RR");

    // BR Santa Catarina
    public static final Version2017RegionType BR_SANTA_CATARINA = new Version2017RegionType(SCHEME, "BR-SC");

    // BR Sao Paulo
    public static final Version2017RegionType BR_SAO_PAULO = new Version2017RegionType(SCHEME, "BR-SP");

    // BR Sergipe
    public static final Version2017RegionType BR_SERGIPE = new Version2017RegionType(SCHEME, "BR-SE");

    // BR Tocantins
    public static final Version2017RegionType BR_TOCANTINS = new Version2017RegionType(SCHEME, "BR-TO");

    // BS Acklins And Crooked Islands
    public static final Version2017RegionType BS_ACKLINS_AND_CROOKED_ISLANDS = new Version2017RegionType(SCHEME, "BS-AC");

    // BS Bimini
    public static final Version2017RegionType BS_BIMINI = new Version2017RegionType(SCHEME, "BS-BI");

    // BS Cat Island
    public static final Version2017RegionType BS_CAT_ISLAND = new Version2017RegionType(SCHEME, "BS-CI");

    // BS Exuma
    public static final Version2017RegionType BS_EXUMA = new Version2017RegionType(SCHEME, "BS-EX");

    // BS Freeport
    public static final Version2017RegionType BS_FREEPORT = new Version2017RegionType(SCHEME, "BS-FP");

    // BS Fresh Creek
    public static final Version2017RegionType BS_FRESH_CREEK = new Version2017RegionType(SCHEME, "BS-FC");

    // BS Governor's Harbour
    public static final Version2017RegionType BS_GOVERNORS_HARBOUR = new Version2017RegionType(SCHEME, "BS-GH");

    // BS Green Turtle Cay
    public static final Version2017RegionType BS_GREEN_TURTLE_CAY = new Version2017RegionType(SCHEME, "BS-GT");

    // BS Harbour Island
    public static final Version2017RegionType BS_HARBOUR_ISLAND = new Version2017RegionType(SCHEME, "BS-HI");

    // BS High Rock
    public static final Version2017RegionType BS_HIGH_ROCK = new Version2017RegionType(SCHEME, "BS-HR");

    // BS Inagua
    public static final Version2017RegionType BS_INAGUA = new Version2017RegionType(SCHEME, "BS-IN");

    // BS Kemps Bay
    public static final Version2017RegionType BS_KEMPS_BAY = new Version2017RegionType(SCHEME, "BS-KB");

    // BS Long Island
    public static final Version2017RegionType BS_LONG_ISLAND = new Version2017RegionType(SCHEME, "BS-LI");

    // BS Marsh Harbour
    public static final Version2017RegionType BS_MARSH_HARBOUR = new Version2017RegionType(SCHEME, "BS-MH");

    // BS Mayaguana
    public static final Version2017RegionType BS_MAYAGUANA = new Version2017RegionType(SCHEME, "BS-MG");

    // BS New Providence
    public static final Version2017RegionType BS_NEW_PROVIDENCE = new Version2017RegionType(SCHEME, "BS-NP");

    // BS Nicholls Town And Berry Islands
    public static final Version2017RegionType BS_NICHOLLS_TOWN_AND_BERRY_ISLANDS = new Version2017RegionType(SCHEME, "BS-NB");

    // BS Ragged Island
    public static final Version2017RegionType BS_RAGGED_ISLAND = new Version2017RegionType(SCHEME, "BS-RI");

    // BS Rock Sound
    public static final Version2017RegionType BS_ROCK_SOUND = new Version2017RegionType(SCHEME, "BS-RS");

    // BS Sandy Point
    public static final Version2017RegionType BS_SANDY_POINT = new Version2017RegionType(SCHEME, "BS-SP");

    // BS San Salvador And Rum Cay
    public static final Version2017RegionType BS_SAN_SALVADOR_AND_RUM_CAY = new Version2017RegionType(SCHEME, "BS-SR");

    // BT Bumthang
    public static final Version2017RegionType BT_BUMTHANG = new Version2017RegionType(SCHEME, "BT-33");

    // BT Chhukha
    public static final Version2017RegionType BT_CHHUKHA = new Version2017RegionType(SCHEME, "BT-12");

    // BT Dagana
    public static final Version2017RegionType BT_DAGANA = new Version2017RegionType(SCHEME, "BT-22");

    // BT Gasa
    public static final Version2017RegionType BT_GASA = new Version2017RegionType(SCHEME, "BT-GA");

    // BT Ha
    public static final Version2017RegionType BT_HA = new Version2017RegionType(SCHEME, "BT-13");

    // BT Lhuentse
    public static final Version2017RegionType BT_LHUENTSE = new Version2017RegionType(SCHEME, "BT-44");

    // BT Monggar
    public static final Version2017RegionType BT_MONGGAR = new Version2017RegionType(SCHEME, "BT-42");

    // BT Paro
    public static final Version2017RegionType BT_PARO = new Version2017RegionType(SCHEME, "BT-11");

    // BT Pemagatshel
    public static final Version2017RegionType BT_PEMAGATSHEL = new Version2017RegionType(SCHEME, "BT-43");

    // BT Punakha
    public static final Version2017RegionType BT_PUNAKHA = new Version2017RegionType(SCHEME, "BT-23");

    // BT Samdrup Jongkha
    public static final Version2017RegionType BT_SAMDRUP_JONGKHA = new Version2017RegionType(SCHEME, "BT-45");

    // BT Samtse
    public static final Version2017RegionType BT_SAMTSE = new Version2017RegionType(SCHEME, "BT-14");

    // BT Sarpang
    public static final Version2017RegionType BT_SARPANG = new Version2017RegionType(SCHEME, "BT-31");

    // BT Thimphu
    public static final Version2017RegionType BT_THIMPHU = new Version2017RegionType(SCHEME, "BT-15");

    // BT Trashigang
    public static final Version2017RegionType BT_TRASHIGANG = new Version2017RegionType(SCHEME, "BT-41");

    // BT Trashi Yangtse
    public static final Version2017RegionType BT_TRASHI_YANGTSE = new Version2017RegionType(SCHEME, "BT-TY");

    // BT Trongsa
    public static final Version2017RegionType BT_TRONGSA = new Version2017RegionType(SCHEME, "BT-32");

    // BT Tsirang
    public static final Version2017RegionType BT_TSIRANG = new Version2017RegionType(SCHEME, "BT-21");

    // BT Wangdue Phodrang
    public static final Version2017RegionType BT_WANGDUE_PHODRANG = new Version2017RegionType(SCHEME, "BT-24");

    // BT Zhemgang
    public static final Version2017RegionType BT_ZHEMGANG = new Version2017RegionType(SCHEME, "BT-34");

    // BW Central, BW
    public static final Version2017RegionType BW_CENTRAL = new Version2017RegionType(SCHEME, "BW-CE");

    // BW Ghanzi
    public static final Version2017RegionType BW_GHANZI = new Version2017RegionType(SCHEME, "BW-GH");

    // BW Kgalagadi
    public static final Version2017RegionType BW_KGALAGADI = new Version2017RegionType(SCHEME, "BW-KG");

    // BW Kgatleng
    public static final Version2017RegionType BW_KGATLENG = new Version2017RegionType(SCHEME, "BW-KL");

    // BW Kweneng
    public static final Version2017RegionType BW_KWENENG = new Version2017RegionType(SCHEME, "BW-KW");

    // BW North-east
    public static final Version2017RegionType BW_NORTH_EAST = new Version2017RegionType(SCHEME, "BW-NE");

    // BW North-west
    public static final Version2017RegionType BW_NORTH_WEST = new Version2017RegionType(SCHEME, "BW-NW");

    // BW Southern
    public static final Version2017RegionType BW_SOUTHERN = new Version2017RegionType(SCHEME, "BW-SO");

    // BW South-east
    public static final Version2017RegionType BW_SOUTH_EAST = new Version2017RegionType(SCHEME, "BW-SE");

    // BY Brestskaya Voblasts' (be) Brestskaya Oblast' (ru)
    public static final Version2017RegionType BY_BRESTSKAYA_VOBLASTS_BE_BRESTSKAYA_OBLAST_RU = new Version2017RegionType(SCHEME, "BY-BR");

    // BY Homyel'skaya Voblasts' (be) Gomel'skaya Oblast' (ru)
    public static final Version2017RegionType BY_HOMYELSKAYA_VOBLASTS_BE_GOMELSKAYA_OBLAST_RU = new Version2017RegionType(SCHEME, "BY-HO");

    // BY Hrodzenskaya Voblasts' (be) Grodnenskaya Oblast' (ru)
    public static final Version2017RegionType BY_HRODZENSKAYA_VOBLASTS_BE_GRODNENSKAYA_OBLAST_RU = new Version2017RegionType(SCHEME, "BY-HR");

    // BY Mahilyowskaya Voblasts' (be) Mogilevskaya Oblast' (ru)
    public static final Version2017RegionType BY_MAHILYOWSKAYA_VOBLASTS_BE_MOGILEVSKAYA_OBLAST_RU = new Version2017RegionType(SCHEME, "BY-MA");

    // BY Minskaya Voblasts' (be) Minskaya Oblast' (ru)
    public static final Version2017RegionType BY_MINSKAYA_VOBLASTS_BE_MINSKAYA_OBLAST_RU = new Version2017RegionType(SCHEME, "BY-MI");

    // BY Vitsyebskaya Voblasts' (be) Vitebskaya Oblast' (ru)
    public static final Version2017RegionType BY_VITSYEBSKAYA_VOBLASTS_BE_VITEBSKAYA_OBLAST_RU = new Version2017RegionType(SCHEME, "BY-VI");

    // BZ Belize
    public static final Version2017RegionType BZ_BELIZE = new Version2017RegionType(SCHEME, "BZ-BZ");

    // BZ Cayo
    public static final Version2017RegionType BZ_CAYO = new Version2017RegionType(SCHEME, "BZ-CY");

    // BZ Corozal
    public static final Version2017RegionType BZ_COROZAL = new Version2017RegionType(SCHEME, "BZ-CZL");

    // BZ Orange Walk
    public static final Version2017RegionType BZ_ORANGE_WALK = new Version2017RegionType(SCHEME, "BZ-OW");

    // BZ Stann Creek
    public static final Version2017RegionType BZ_STANN_CREEK = new Version2017RegionType(SCHEME, "BZ-SC");

    // BZ Toledo
    public static final Version2017RegionType BZ_TOLEDO = new Version2017RegionType(SCHEME, "BZ-TOL");

    // CA Alberta
    public static final Version2017RegionType CA_ALBERTA = new Version2017RegionType(SCHEME, "CA-AB");

    // CA British Columbia
    public static final Version2017RegionType CA_BRITISH_COLUMBIA = new Version2017RegionType(SCHEME, "CA-BC");

    // CA Manitoba
    public static final Version2017RegionType CA_MANITOBA = new Version2017RegionType(SCHEME, "CA-MB");

    // CA Newfoundland And Labrador
    public static final Version2017RegionType CA_NEWFOUNDLAND_AND_LABRADOR = new Version2017RegionType(SCHEME, "CA-NL");

    // CA New Brunswick
    public static final Version2017RegionType CA_NEW_BRUNSWICK = new Version2017RegionType(SCHEME, "CA-NB");

    // CA Northwest Territories
    public static final Version2017RegionType CA_NORTHWEST_TERRITORIES = new Version2017RegionType(SCHEME, "CA-NT");

    // CA Nova Scotia
    public static final Version2017RegionType CA_NOVA_SCOTIA = new Version2017RegionType(SCHEME, "CA-NS");

    // CA Nunavut
    public static final Version2017RegionType CA_NUNAVUT = new Version2017RegionType(SCHEME, "CA-NU");

    // CA Ontario
    public static final Version2017RegionType CA_ONTARIO = new Version2017RegionType(SCHEME, "CA-ON");

    // CA Prince Edward Island
    public static final Version2017RegionType CA_PRINCE_EDWARD_ISLAND = new Version2017RegionType(SCHEME, "CA-PE");

    // CA Quebec
    public static final Version2017RegionType CA_QUEBEC = new Version2017RegionType(SCHEME, "CA-QC");

    // CA Saskatchewan
    public static final Version2017RegionType CA_SASKATCHEWAN = new Version2017RegionType(SCHEME, "CA-SK");

    // CA Yukon Territory
    public static final Version2017RegionType CA_YUKON_TERRITORY = new Version2017RegionType(SCHEME, "CA-YT");

    // CD Bandundu
    public static final Version2017RegionType CD_BANDUNDU = new Version2017RegionType(SCHEME, "CD-BN");

    // CD Bas-congo
    public static final Version2017RegionType CD_BAS_CONGO = new Version2017RegionType(SCHEME, "CD-BC");

    // CD Equateur
    public static final Version2017RegionType CD_EQUATEUR = new Version2017RegionType(SCHEME, "CD-EQ");

    // CD Kasai-occidental
    public static final Version2017RegionType CD_KASAI_OCCIDENTAL = new Version2017RegionType(SCHEME, "CD-KW");

    // CD Kasai-oriental
    public static final Version2017RegionType CD_KASAI_ORIENTAL = new Version2017RegionType(SCHEME, "CD-KE");

    // CD Katanga
    public static final Version2017RegionType CD_KATANGA = new Version2017RegionType(SCHEME, "CD-KA");

    // CD Kinshasa
    public static final Version2017RegionType CD_KINSHASA = new Version2017RegionType(SCHEME, "CD-KN");

    // CD Maniema
    public static final Version2017RegionType CD_MANIEMA = new Version2017RegionType(SCHEME, "CD-MA");

    // CD Nord-kivu
    public static final Version2017RegionType CD_NORD_KIVU = new Version2017RegionType(SCHEME, "CD-NK");

    // CD Orientale
    public static final Version2017RegionType CD_ORIENTALE = new Version2017RegionType(SCHEME, "CD-OR");

    // CD Sud-kivu
    public static final Version2017RegionType CD_SUD_KIVU = new Version2017RegionType(SCHEME, "CD-SK");

    // CF Bamingui-bangoran
    public static final Version2017RegionType CF_BAMINGUI_BANGORAN = new Version2017RegionType(SCHEME, "CF-BB");

    // CF Bangui
    public static final Version2017RegionType CF_BANGUI = new Version2017RegionType(SCHEME, "CF-BGF");

    // CF Basse-kotto
    public static final Version2017RegionType CF_BASSE_KOTTO = new Version2017RegionType(SCHEME, "CF-BK");

    // CF Haute-kotto
    public static final Version2017RegionType CF_HAUTE_KOTTO = new Version2017RegionType(SCHEME, "CF-HK");

    // CF Haut-mbomou
    public static final Version2017RegionType CF_HAUT_MBOMOU = new Version2017RegionType(SCHEME, "CF-HM");

    // CF Kemo
    public static final Version2017RegionType CF_KEMO = new Version2017RegionType(SCHEME, "CF-KG");

    // CF Lobaye
    public static final Version2017RegionType CF_LOBAYE = new Version2017RegionType(SCHEME, "CF-LB");

    // CF Mambere-kadei
    public static final Version2017RegionType CF_MAMBERE_KADEI = new Version2017RegionType(SCHEME, "CF-HS");

    // CF Mbomou
    public static final Version2017RegionType CF_MBOMOU = new Version2017RegionType(SCHEME, "CF-MB");

    // CF Nana-grebizi
    public static final Version2017RegionType CF_NANA_GREBIZI = new Version2017RegionType(SCHEME, "CF-KB");

    // CF Nana-mambere
    public static final Version2017RegionType CF_NANA_MAMBERE = new Version2017RegionType(SCHEME, "CF-NM");

    // CF Ombella-mpoko
    public static final Version2017RegionType CF_OMBELLA_MPOKO = new Version2017RegionType(SCHEME, "CF-MP");

    // CF Ouaka
    public static final Version2017RegionType CF_OUAKA = new Version2017RegionType(SCHEME, "CF-UK");

    // CF Ouham
    public static final Version2017RegionType CF_OUHAM = new Version2017RegionType(SCHEME, "CF-AC");

    // CF Ouham-pende
    public static final Version2017RegionType CF_OUHAM_PENDE = new Version2017RegionType(SCHEME, "CF-OP");

    // CF Sangha-mbaere
    public static final Version2017RegionType CF_SANGHA_MBAERE = new Version2017RegionType(SCHEME, "CF-SE");

    // CF Vakaga
    public static final Version2017RegionType CF_VAKAGA = new Version2017RegionType(SCHEME, "CF-VK");

    // CG Bouenza
    public static final Version2017RegionType CG_BOUENZA = new Version2017RegionType(SCHEME, "CG-11");

    // CG Brazzaville
    public static final Version2017RegionType CG_BRAZZAVILLE = new Version2017RegionType(SCHEME, "CG-BZV");

    // CG Cuvette
    public static final Version2017RegionType CG_CUVETTE = new Version2017RegionType(SCHEME, "CG-8");

    // CG Cuvette-ouest
    public static final Version2017RegionType CG_CUVETTE_OUEST = new Version2017RegionType(SCHEME, "CG-15");

    // CG Kouilou
    public static final Version2017RegionType CG_KOUILOU = new Version2017RegionType(SCHEME, "CG-5");

    // CG Lekoumou
    public static final Version2017RegionType CG_LEKOUMOU = new Version2017RegionType(SCHEME, "CG-2");

    // CG Likouala
    public static final Version2017RegionType CG_LIKOUALA = new Version2017RegionType(SCHEME, "CG-7");

    // CG Niari
    public static final Version2017RegionType CG_NIARI = new Version2017RegionType(SCHEME, "CG-9");

    // CG Plateaux, CG
    public static final Version2017RegionType CG_PLATEAUX = new Version2017RegionType(SCHEME, "CG-14");

    // CG Pool
    public static final Version2017RegionType CG_POOL = new Version2017RegionType(SCHEME, "CG-12");

    // CG Sangha
    public static final Version2017RegionType CG_SANGHA = new Version2017RegionType(SCHEME, "CG-13");

    // CH Aargau (de)
    public static final Version2017RegionType CH_AARGAU_DE = new Version2017RegionType(SCHEME, "CH-AG");

    // CH Appenzell Ausserrhoden (de)
    public static final Version2017RegionType CH_APPENZELL_AUSSERRHODEN_DE = new Version2017RegionType(SCHEME, "CH-AR");

    // CH Appenzell Innerrhoden (de)
    public static final Version2017RegionType CH_APPENZELL_INNERRHODEN_DE = new Version2017RegionType(SCHEME, "CH-AI");

    // CH Basel-landschaft (de)
    public static final Version2017RegionType CH_BASEL_LANDSCHAFT_DE = new Version2017RegionType(SCHEME, "CH-BL");

    // CH Basel-stadt (de)
    public static final Version2017RegionType CH_BASEL_STADT_DE = new Version2017RegionType(SCHEME, "CH-BS");

    // CH Bern (de)
    public static final Version2017RegionType CH_BERN_DE = new Version2017RegionType(SCHEME, "CH-BE");

    // CH Fribourg (fr)
    public static final Version2017RegionType CH_FRIBOURG_FR = new Version2017RegionType(SCHEME, "CH-FR");

    // CH Geneve (fr)
    public static final Version2017RegionType CH_GENEVE_FR = new Version2017RegionType(SCHEME, "CH-GE");

    // CH Glarus (de)
    public static final Version2017RegionType CH_GLARUS_DE = new Version2017RegionType(SCHEME, "CH-GL");

    // CH Graubunden
    public static final Version2017RegionType CH_GRAUBUNDEN = new Version2017RegionType(SCHEME, "CH-GR");

    // CH Jura (fr)
    public static final Version2017RegionType CH_JURA_FR = new Version2017RegionType(SCHEME, "CH-JU");

    // CH Luzern (de)
    public static final Version2017RegionType CH_LUZERN_DE = new Version2017RegionType(SCHEME, "CH-LU");

    // CH Neuchatel (fr)
    public static final Version2017RegionType CH_NEUCHATEL_FR = new Version2017RegionType(SCHEME, "CH-NE");

    // CH Nidwalden (de)
    public static final Version2017RegionType CH_NIDWALDEN_DE = new Version2017RegionType(SCHEME, "CH-NW");

    // CH Obwalden (de)
    public static final Version2017RegionType CH_OBWALDEN_DE = new Version2017RegionType(SCHEME, "CH-OW");

    // CH Sankt Gallen (de)
    public static final Version2017RegionType CH_SANKT_GALLEN_DE = new Version2017RegionType(SCHEME, "CH-SG");

    // CH Schaffhausen (de)
    public static final Version2017RegionType CH_SCHAFFHAUSEN_DE = new Version2017RegionType(SCHEME, "CH-SH");

    // CH Schwyz (de)
    public static final Version2017RegionType CH_SCHWYZ_DE = new Version2017RegionType(SCHEME, "CH-SZ");

    // CH Solothurn (de)
    public static final Version2017RegionType CH_SOLOTHURN_DE = new Version2017RegionType(SCHEME, "CH-SO");

    // CH Thurgau (de)
    public static final Version2017RegionType CH_THURGAU_DE = new Version2017RegionType(SCHEME, "CH-TG");

    // CH Ticino (it)
    public static final Version2017RegionType CH_TICINO_IT = new Version2017RegionType(SCHEME, "CH-TI");

    // CH Uri (de)
    public static final Version2017RegionType CH_URI_DE = new Version2017RegionType(SCHEME, "CH-UR");

    // CH Valais (fr)
    public static final Version2017RegionType CH_VALAIS_FR = new Version2017RegionType(SCHEME, "CH-VS");

    // CH Vaud (fr)
    public static final Version2017RegionType CH_VAUD_FR = new Version2017RegionType(SCHEME, "CH-VD");

    // CH Zug (de)
    public static final Version2017RegionType CH_ZUG_DE = new Version2017RegionType(SCHEME, "CH-ZG");

    // CH Zurich
    public static final Version2017RegionType CH_ZURICH = new Version2017RegionType(SCHEME, "CH-ZH");

    // CI 18 Montagnes (region Des)
    public static final Version2017RegionType CI_18_MONTAGNES_REGION_DES = new Version2017RegionType(SCHEME, "CI-06");

    // CI Agnebi (region De L')
    public static final Version2017RegionType CI_AGNEBI_REGION_DE_L = new Version2017RegionType(SCHEME, "CI-16");

    // CI Bas-sassandra (region Du)
    public static final Version2017RegionType CI_BAS_SASSANDRA_REGION_DU = new Version2017RegionType(SCHEME, "CI-09");

    // CI Denguele (region Du)
    public static final Version2017RegionType CI_DENGUELE_REGION_DU = new Version2017RegionType(SCHEME, "CI-10");

    // CI Haut-sassandra (region Du)
    public static final Version2017RegionType CI_HAUT_SASSANDRA_REGION_DU = new Version2017RegionType(SCHEME, "CI-02");

    // CI Lacs (region Des)
    public static final Version2017RegionType CI_LACS_REGION_DES = new Version2017RegionType(SCHEME, "CI-07");

    // CI Lagunes (region Des)
    public static final Version2017RegionType CI_LAGUNES_REGION_DES = new Version2017RegionType(SCHEME, "CI-01");

    // CI Marahoue (region De La)
    public static final Version2017RegionType CI_MARAHOUE_REGION_DE_LA = new Version2017RegionType(SCHEME, "CI-12");

    // CI Moyen-comoe (region Du)
    public static final Version2017RegionType CI_MOYEN_COMOE_REGION_DU = new Version2017RegionType(SCHEME, "CI-05");

    // CI Nzi-comoe (region)
    public static final Version2017RegionType CI_NZI_COMOE_REGION = new Version2017RegionType(SCHEME, "CI-11");

    // CI Savanes (region Des)
    public static final Version2017RegionType CI_SAVANES_REGION_DES = new Version2017RegionType(SCHEME, "CI-03");

    // CI Sud-bandama (region Du)
    public static final Version2017RegionType CI_SUD_BANDAMA_REGION_DU = new Version2017RegionType(SCHEME, "CI-15");

    // CI Sud-comoe (region Du)
    public static final Version2017RegionType CI_SUD_COMOE_REGION_DU = new Version2017RegionType(SCHEME, "CI-13");

    // CI Vallee Du Bandama (region De La)
    public static final Version2017RegionType CI_VALLEE_DU_BANDAMA_REGION_DE_LA = new Version2017RegionType(SCHEME, "CI-04");

    // CI Worodougou (region Du)
    public static final Version2017RegionType CI_WORODOUGOU_REGION_DU = new Version2017RegionType(SCHEME, "CI-14");

    // CI Zanzan (region Du)
    public static final Version2017RegionType CI_ZANZAN_REGION_DU = new Version2017RegionType(SCHEME, "CI-08");

    // CL Aisen Del General Carlos Ibanez Del Campo
    public static final Version2017RegionType CL_AISEN_DEL_GENERAL_CARLOS_IBANEZ_DEL_CAMPO = new Version2017RegionType(SCHEME, "CL-AI");

    // CL Antofagasta
    public static final Version2017RegionType CL_ANTOFAGASTA = new Version2017RegionType(SCHEME, "CL-AN");

    // CL Araucania
    public static final Version2017RegionType CL_ARAUCANIA = new Version2017RegionType(SCHEME, "CL-AR");

    // CL Atacama
    public static final Version2017RegionType CL_ATACAMA = new Version2017RegionType(SCHEME, "CL-AT");

    // CL Bio-bio
    public static final Version2017RegionType CL_BIO_BIO = new Version2017RegionType(SCHEME, "CL-BI");

    // CL Coquimbo
    public static final Version2017RegionType CL_COQUIMBO = new Version2017RegionType(SCHEME, "CL-CO");

    // CL Libertador General Bernardo O'higgins
    public static final Version2017RegionType CL_LIBERTADOR_GENERAL_BERNARDO_OHIGGINS = new Version2017RegionType(SCHEME, "CL-LI");

    // CL Los Lagos
    public static final Version2017RegionType CL_LOS_LAGOS = new Version2017RegionType(SCHEME, "CL-LL");

    // CL Magallanes
    public static final Version2017RegionType CL_MAGALLANES = new Version2017RegionType(SCHEME, "CL-MA");

    // CL Maule
    public static final Version2017RegionType CL_MAULE = new Version2017RegionType(SCHEME, "CL-ML");

    // CL Region Metropolitana De Santiago
    public static final Version2017RegionType CL_REGION_METROPOLITANA_DE_SANTIAGO = new Version2017RegionType(SCHEME, "CL-RM");

    // CL Tarapaca
    public static final Version2017RegionType CL_TARAPACA = new Version2017RegionType(SCHEME, "CL-TA");

    // CL Valparaiso
    public static final Version2017RegionType CL_VALPARAISO = new Version2017RegionType(SCHEME, "CL-VS");

    // CM Adamaoua
    public static final Version2017RegionType CM_ADAMAOUA = new Version2017RegionType(SCHEME, "CM-AD");

    // CM Centre, CM
    public static final Version2017RegionType CM_CENTRE = new Version2017RegionType(SCHEME, "CM-CE");

    // CM East
    public static final Version2017RegionType CM_EAST = new Version2017RegionType(SCHEME, "CM-ES");

    // CM Far North
    public static final Version2017RegionType CM_FAR_NORTH = new Version2017RegionType(SCHEME, "CM-EN");

    // CM Littoral
    public static final Version2017RegionType CM_LITTORAL = new Version2017RegionType(SCHEME, "CM-LT");

    // CM North
    public static final Version2017RegionType CM_NORTH = new Version2017RegionType(SCHEME, "CM-NO");

    // CM North-west, CM
    public static final Version2017RegionType CM_NORTH_WEST = new Version2017RegionType(SCHEME, "CM-NW");

    // CM South
    public static final Version2017RegionType CM_SOUTH = new Version2017RegionType(SCHEME, "CM-SU");

    // CM South-west
    public static final Version2017RegionType CM_SOUTH_WEST = new Version2017RegionType(SCHEME, "CM-SW");

    // CM West
    public static final Version2017RegionType CM_WEST = new Version2017RegionType(SCHEME, "CM-OU");

    // CN Anhui
    public static final Version2017RegionType CN_ANHUI = new Version2017RegionType(SCHEME, "CN-34");

    // CN Aomen (zh) ***
    public static final Version2017RegionType CN_AOMEN_ZH_ = new Version2017RegionType(SCHEME, "CN-92");

    // CN Beijing
    public static final Version2017RegionType CN_BEIJING = new Version2017RegionType(SCHEME, "CN-11");

    // CN Chongqing
    public static final Version2017RegionType CN_CHONGQING = new Version2017RegionType(SCHEME, "CN-50");

    // CN Fujian
    public static final Version2017RegionType CN_FUJIAN = new Version2017RegionType(SCHEME, "CN-35");

    // CN Gansu
    public static final Version2017RegionType CN_GANSU = new Version2017RegionType(SCHEME, "CN-62");

    // CN Guangdong
    public static final Version2017RegionType CN_GUANGDONG = new Version2017RegionType(SCHEME, "CN-44");

    // CN Guangxi
    public static final Version2017RegionType CN_GUANGXI = new Version2017RegionType(SCHEME, "CN-45");

    // CN Guizhou
    public static final Version2017RegionType CN_GUIZHOU = new Version2017RegionType(SCHEME, "CN-52");

    // CN Hainan
    public static final Version2017RegionType CN_HAINAN = new Version2017RegionType(SCHEME, "CN-46");

    // CN Hebei
    public static final Version2017RegionType CN_HEBEI = new Version2017RegionType(SCHEME, "CN-13");

    // CN Heilongjiang
    public static final Version2017RegionType CN_HEILONGJIANG = new Version2017RegionType(SCHEME, "CN-23");

    // CN Henan
    public static final Version2017RegionType CN_HENAN = new Version2017RegionType(SCHEME, "CN-41");

    // CN Hubei
    public static final Version2017RegionType CN_HUBEI = new Version2017RegionType(SCHEME, "CN-42");

    // CN Hunan
    public static final Version2017RegionType CN_HUNAN = new Version2017RegionType(SCHEME, "CN-43");

    // CN Jiangsu
    public static final Version2017RegionType CN_JIANGSU = new Version2017RegionType(SCHEME, "CN-32");

    // CN Jiangxi
    public static final Version2017RegionType CN_JIANGXI = new Version2017RegionType(SCHEME, "CN-36");

    // CN Jilin
    public static final Version2017RegionType CN_JILIN = new Version2017RegionType(SCHEME, "CN-22");

    // CN Liaoning
    public static final Version2017RegionType CN_LIAONING = new Version2017RegionType(SCHEME, "CN-21");

    // CN Nei Mongol (mn)
    public static final Version2017RegionType CN_NEI_MONGOL_MN = new Version2017RegionType(SCHEME, "CN-15");

    // CN Ningxia
    public static final Version2017RegionType CN_NINGXIA = new Version2017RegionType(SCHEME, "CN-64");

    // CN Qinghai
    public static final Version2017RegionType CN_QINGHAI = new Version2017RegionType(SCHEME, "CN-63");

    // CN Shaanxi
    public static final Version2017RegionType CN_SHAANXI = new Version2017RegionType(SCHEME, "CN-61");

    // CN Shandong
    public static final Version2017RegionType CN_SHANDONG = new Version2017RegionType(SCHEME, "CN-37");

    // CN Shanghai
    public static final Version2017RegionType CN_SHANGHAI = new Version2017RegionType(SCHEME, "CN-31");

    // CN Shanxi
    public static final Version2017RegionType CN_SHANXI = new Version2017RegionType(SCHEME, "CN-14");

    // CN Sichuan
    public static final Version2017RegionType CN_SICHUAN = new Version2017RegionType(SCHEME, "CN-51");

    // CN Taiwan
    public static final Version2017RegionType CN_TAIWAN = new Version2017RegionType(SCHEME, "CN-71");

    // CN Tianjin
    public static final Version2017RegionType CN_TIANJIN = new Version2017RegionType(SCHEME, "CN-12");

    // CN Xinjiang
    public static final Version2017RegionType CN_XINJIANG = new Version2017RegionType(SCHEME, "CN-65");

    // CN Xizang
    public static final Version2017RegionType CN_XIZANG = new Version2017RegionType(SCHEME, "CN-54");

    // CN Yunnan
    public static final Version2017RegionType CN_YUNNAN = new Version2017RegionType(SCHEME, "CN-53");

    // CN Zh
    public static final Version2017RegionType CN_ZH = new Version2017RegionType(SCHEME, "CN-91");

    // CN Zhejiang
    public static final Version2017RegionType CN_ZHEJIANG = new Version2017RegionType(SCHEME, "CN-33");

    // CO Amazonas, CO
    public static final Version2017RegionType CO_AMAZONAS = new Version2017RegionType(SCHEME, "CO-AMA");

    // CO Antioquia
    public static final Version2017RegionType CO_ANTIOQUIA = new Version2017RegionType(SCHEME, "CO-ANT");

    // CO Arauca
    public static final Version2017RegionType CO_ARAUCA = new Version2017RegionType(SCHEME, "CO-ARA");

    // CO Atlantico
    public static final Version2017RegionType CO_ATLANTICO = new Version2017RegionType(SCHEME, "CO-ATL");

    // CO Bolivar, CO
    public static final Version2017RegionType CO_BOLIVAR = new Version2017RegionType(SCHEME, "CO-BOL");

    // CO Boyaca
    public static final Version2017RegionType CO_BOYACA = new Version2017RegionType(SCHEME, "CO-BOY");

    // CO Caldas
    public static final Version2017RegionType CO_CALDAS = new Version2017RegionType(SCHEME, "CO-CAL");

    // CO Caqueta
    public static final Version2017RegionType CO_CAQUETA = new Version2017RegionType(SCHEME, "CO-CAQ");

    // CO Casanare
    public static final Version2017RegionType CO_CASANARE = new Version2017RegionType(SCHEME, "CO-CAS");

    // CO Cauca
    public static final Version2017RegionType CO_CAUCA = new Version2017RegionType(SCHEME, "CO-CAU");

    // CO Cesar
    public static final Version2017RegionType CO_CESAR = new Version2017RegionType(SCHEME, "CO-CES");

    // CO Choco
    public static final Version2017RegionType CO_CHOCO = new Version2017RegionType(SCHEME, "CO-CHO");

    // CO Cordoba, CO
    public static final Version2017RegionType CO_CORDOBA = new Version2017RegionType(SCHEME, "CO-COR");

    // CO Cundinamarca
    public static final Version2017RegionType CO_CUNDINAMARCA = new Version2017RegionType(SCHEME, "CO-CUN");

    // CO Distrito Capital De Bogota
    public static final Version2017RegionType CO_DISTRITO_CAPITAL_DE_BOGOTA = new Version2017RegionType(SCHEME, "CO-DC");

    // CO Guainia
    public static final Version2017RegionType CO_GUAINIA = new Version2017RegionType(SCHEME, "CO-GUA");

    // CO Guaviare
    public static final Version2017RegionType CO_GUAVIARE = new Version2017RegionType(SCHEME, "CO-GUV");

    // CO Huila
    public static final Version2017RegionType CO_HUILA = new Version2017RegionType(SCHEME, "CO-HUI");

    // CO La Guajira
    public static final Version2017RegionType CO_LA_GUAJIRA = new Version2017RegionType(SCHEME, "CO-LAG");

    // CO Magdalena
    public static final Version2017RegionType CO_MAGDALENA = new Version2017RegionType(SCHEME, "CO-MAG");

    // CO Meta
    public static final Version2017RegionType CO_META = new Version2017RegionType(SCHEME, "CO-MET");

    // CO Narino
    public static final Version2017RegionType CO_NARINO = new Version2017RegionType(SCHEME, "CO-NAR");

    // CO Norte De Santander
    public static final Version2017RegionType CO_NORTE_DE_SANTANDER = new Version2017RegionType(SCHEME, "CO-NSA");

    // CO Putumayo
    public static final Version2017RegionType CO_PUTUMAYO = new Version2017RegionType(SCHEME, "CO-PUT");

    // CO Quindio
    public static final Version2017RegionType CO_QUINDIO = new Version2017RegionType(SCHEME, "CO-QUI");

    // CO Risaralda
    public static final Version2017RegionType CO_RISARALDA = new Version2017RegionType(SCHEME, "CO-RIS");

    // CO Santander
    public static final Version2017RegionType CO_SANTANDER = new Version2017RegionType(SCHEME, "CO-SAN");

    // CO San Andres, Providencia Y Santa Catalina
    public static final Version2017RegionType CO_SAN_ANDRES_PROVIDENCIA_Y_SANTA_CATALINA = new Version2017RegionType(SCHEME, "CO-SAP");

    // CO Sucre, CO
    public static final Version2017RegionType CO_SUCRE = new Version2017RegionType(SCHEME, "CO-SUC");

    // CO Tolima
    public static final Version2017RegionType CO_TOLIMA = new Version2017RegionType(SCHEME, "CO-TOL");

    // CO Valle Del Cauca
    public static final Version2017RegionType CO_VALLE_DEL_CAUCA = new Version2017RegionType(SCHEME, "CO-VAC");

    // CO Vaupes
    public static final Version2017RegionType CO_VAUPES = new Version2017RegionType(SCHEME, "CO-VAU");

    // CO Vichada
    public static final Version2017RegionType CO_VICHADA = new Version2017RegionType(SCHEME, "CO-VID");

    // CR Alajuela
    public static final Version2017RegionType CR_ALAJUELA = new Version2017RegionType(SCHEME, "CR-A");

    // CR Cartago
    public static final Version2017RegionType CR_CARTAGO = new Version2017RegionType(SCHEME, "CR-C");

    // CR Guanacaste
    public static final Version2017RegionType CR_GUANACASTE = new Version2017RegionType(SCHEME, "CR-G");

    // CR Heredia
    public static final Version2017RegionType CR_HEREDIA = new Version2017RegionType(SCHEME, "CR-H");

    // CR Limon
    public static final Version2017RegionType CR_LIMON = new Version2017RegionType(SCHEME, "CR-L");

    // CR Puntarenas
    public static final Version2017RegionType CR_PUNTARENAS = new Version2017RegionType(SCHEME, "CR-P");

    // CR San Jose, CR
    public static final Version2017RegionType CR_SAN_JOSE = new Version2017RegionType(SCHEME, "CR-SJ");

    // CS Crna Gora
    public static final Version2017RegionType CS_CRNA_GORA = new Version2017RegionType(SCHEME, "CS-CG");

    // CS Kosovo-metohija
    public static final Version2017RegionType CS_KOSOVO_METOHIJA = new Version2017RegionType(SCHEME, "CS-KM");

    // CS Srbija
    public static final Version2017RegionType CS_SRBIJA = new Version2017RegionType(SCHEME, "CS-SR");

    // CS Vojvodina
    public static final Version2017RegionType CS_VOJVODINA = new Version2017RegionType(SCHEME, "CS-VO");

    // CU Camaguey
    public static final Version2017RegionType CU_CAMAGUEY = new Version2017RegionType(SCHEME, "CU-09");

    // CU Ciego De Avila
    public static final Version2017RegionType CU_CIEGO_DE_AVILA = new Version2017RegionType(SCHEME, "CU-08");

    // CU Cienfuegos
    public static final Version2017RegionType CU_CIENFUEGOS = new Version2017RegionType(SCHEME, "CU-06");

    // CU Ciudad De La Habana
    public static final Version2017RegionType CU_CIUDAD_DE_LA_HABANA = new Version2017RegionType(SCHEME, "CU-03");

    // CU Granma
    public static final Version2017RegionType CU_GRANMA = new Version2017RegionType(SCHEME, "CU-12");

    // CU Guantanamo
    public static final Version2017RegionType CU_GUANTANAMO = new Version2017RegionType(SCHEME, "CU-14");

    // CU Holguin
    public static final Version2017RegionType CU_HOLGUIN = new Version2017RegionType(SCHEME, "CU-11");

    // CU Isla De La Juventud
    public static final Version2017RegionType CU_ISLA_DE_LA_JUVENTUD = new Version2017RegionType(SCHEME, "CU-99");

    // CU Las Tunas
    public static final Version2017RegionType CU_LAS_TUNAS = new Version2017RegionType(SCHEME, "CU-10");

    // CU La Habana
    public static final Version2017RegionType CU_LA_HABANA = new Version2017RegionType(SCHEME, "CU-02");

    // CU Matanzas
    public static final Version2017RegionType CU_MATANZAS = new Version2017RegionType(SCHEME, "CU-04");

    // CU Pinar Del Rio
    public static final Version2017RegionType CU_PINAR_DEL_RIO = new Version2017RegionType(SCHEME, "CU-01");

    // CU Sancti Spiritus
    public static final Version2017RegionType CU_SANCTI_SPIRITUS = new Version2017RegionType(SCHEME, "CU-07");

    // CU Santiago De Cuba
    public static final Version2017RegionType CU_SANTIAGO_DE_CUBA = new Version2017RegionType(SCHEME, "CU-13");

    // CU Villa Clara
    public static final Version2017RegionType CU_VILLA_CLARA = new Version2017RegionType(SCHEME, "CU-05");

    // CV Boa Vista
    public static final Version2017RegionType CV_BOA_VISTA = new Version2017RegionType(SCHEME, "CV-BV");

    // CV Brava
    public static final Version2017RegionType CV_BRAVA = new Version2017RegionType(SCHEME, "CV-BR");

    // CV Calheta De Sao Miguel
    public static final Version2017RegionType CV_CALHETA_DE_SAO_MIGUEL = new Version2017RegionType(SCHEME, "CV-CS");

    // CV Maio
    public static final Version2017RegionType CV_MAIO = new Version2017RegionType(SCHEME, "CV-MA");

    // CV Mosteiros
    public static final Version2017RegionType CV_MOSTEIROS = new Version2017RegionType(SCHEME, "CV-MO");

    // CV Paul
    public static final Version2017RegionType CV_PAUL = new Version2017RegionType(SCHEME, "CV-PA");

    // CV Porto Novo
    public static final Version2017RegionType CV_PORTO_NOVO = new Version2017RegionType(SCHEME, "CV-PN");

    // CV Praia
    public static final Version2017RegionType CV_PRAIA = new Version2017RegionType(SCHEME, "CV-PR");

    // CV Ribeira Grande
    public static final Version2017RegionType CV_RIBEIRA_GRANDE = new Version2017RegionType(SCHEME, "CV-RG");

    // CV Sal
    public static final Version2017RegionType CV_SAL = new Version2017RegionType(SCHEME, "CV-SL");

    // CV Santa Catarina, CV
    public static final Version2017RegionType CV_SANTA_CATARINA = new Version2017RegionType(SCHEME, "CV-CA");

    // CV Santa Cruz, CV
    public static final Version2017RegionType CV_SANTA_CRUZ = new Version2017RegionType(SCHEME, "CV-CR");

    // CV Sao Domingos
    public static final Version2017RegionType CV_SAO_DOMINGOS = new Version2017RegionType(SCHEME, "CV-SD");

    // CV Sao Filipe
    public static final Version2017RegionType CV_SAO_FILIPE = new Version2017RegionType(SCHEME, "CV-SF");

    // CV Sao Nicolau
    public static final Version2017RegionType CV_SAO_NICOLAU = new Version2017RegionType(SCHEME, "CV-SN");

    // CV Sao Vicente
    public static final Version2017RegionType CV_SAO_VICENTE = new Version2017RegionType(SCHEME, "CV-SV");

    // CV Tarrafal
    public static final Version2017RegionType CV_TARRAFAL = new Version2017RegionType(SCHEME, "CV-TA");

    // CY Ammochostos
    public static final Version2017RegionType CY_AMMOCHOSTOS = new Version2017RegionType(SCHEME, "CY-04");

    // CY Keryneia
    public static final Version2017RegionType CY_KERYNEIA = new Version2017RegionType(SCHEME, "CY-06");

    // CY Larnaka
    public static final Version2017RegionType CY_LARNAKA = new Version2017RegionType(SCHEME, "CY-03");

    // CY Lefkosia
    public static final Version2017RegionType CY_LEFKOSIA = new Version2017RegionType(SCHEME, "CY-01");

    // CY Lemesos
    public static final Version2017RegionType CY_LEMESOS = new Version2017RegionType(SCHEME, "CY-02");

    // CY Pafos
    public static final Version2017RegionType CY_PAFOS = new Version2017RegionType(SCHEME, "CY-05");

    // CZ Jihocesky Kraj
    public static final Version2017RegionType CZ_JIHOCESKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-JC");

    // CZ Jihomoravsky Kraj
    public static final Version2017RegionType CZ_JIHOMORAVSKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-JM");

    // CZ Karlovarsky Kraj
    public static final Version2017RegionType CZ_KARLOVARSKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-KA");

    // CZ Kralovehradecky Kraj
    public static final Version2017RegionType CZ_KRALOVEHRADECKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-KR");

    // CZ Liberecky Kraj
    public static final Version2017RegionType CZ_LIBERECKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-LI");

    // CZ Moravskoslezsky Kraj
    public static final Version2017RegionType CZ_MORAVSKOSLEZSKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-MO");

    // CZ Olomoucky Kraj
    public static final Version2017RegionType CZ_OLOMOUCKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-OL");

    // CZ Pardubicky Kraj
    public static final Version2017RegionType CZ_PARDUBICKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-PA");

    // CZ Plzensky Kraj
    public static final Version2017RegionType CZ_PLZENSKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-PL");

    // CZ Praha, Hlavni Mesto
    public static final Version2017RegionType CZ_PRAHA_HLAVNI_MESTO = new Version2017RegionType(SCHEME, "CZ-PR");

    // CZ Stredocesky Kraj
    public static final Version2017RegionType CZ_STREDOCESKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-ST");

    // CZ Ustecky Kraj
    public static final Version2017RegionType CZ_USTECKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-US");

    // CZ Vysocina
    public static final Version2017RegionType CZ_VYSOCINA = new Version2017RegionType(SCHEME, "CZ-VY");

    // CZ Zlinsky Kraj
    public static final Version2017RegionType CZ_ZLINSKY_KRAJ = new Version2017RegionType(SCHEME, "CZ-ZL");

    // DE Baden-wurttemberg
    public static final Version2017RegionType DE_BADEN_WURTTEMBERG = new Version2017RegionType(SCHEME, "DE-BW");

    // DE Bayern
    public static final Version2017RegionType DE_BAYERN = new Version2017RegionType(SCHEME, "DE-BY");

    // DE Berlin
    public static final Version2017RegionType DE_BERLIN = new Version2017RegionType(SCHEME, "DE-BE");

    // DE Brandenburg
    public static final Version2017RegionType DE_BRANDENBURG = new Version2017RegionType(SCHEME, "DE-BB");

    // DE Bremen
    public static final Version2017RegionType DE_BREMEN = new Version2017RegionType(SCHEME, "DE-HB");

    // DE Hamburg
    public static final Version2017RegionType DE_HAMBURG = new Version2017RegionType(SCHEME, "DE-HH");

    // DE Hessen
    public static final Version2017RegionType DE_HESSEN = new Version2017RegionType(SCHEME, "DE-HE");

    // DE Mecklenburg-vorpommern
    public static final Version2017RegionType DE_MECKLENBURG_VORPOMMERN = new Version2017RegionType(SCHEME, "DE-MV");

    // DE Niedersachsen
    public static final Version2017RegionType DE_NIEDERSACHSEN = new Version2017RegionType(SCHEME, "DE-NI");

    // DE Nordrhein-westfalen
    public static final Version2017RegionType DE_NORDRHEIN_WESTFALEN = new Version2017RegionType(SCHEME, "DE-NW");

    // DE Rheinland-pfalz
    public static final Version2017RegionType DE_RHEINLAND_PFALZ = new Version2017RegionType(SCHEME, "DE-RP");

    // DE Saarland
    public static final Version2017RegionType DE_SAARLAND = new Version2017RegionType(SCHEME, "DE-SL");

    // DE Sachsen
    public static final Version2017RegionType DE_SACHSEN = new Version2017RegionType(SCHEME, "DE-SN");

    // DE Sachsen-anhalt
    public static final Version2017RegionType DE_SACHSEN_ANHALT = new Version2017RegionType(SCHEME, "DE-ST");

    // DE Schleswig-holstein
    public static final Version2017RegionType DE_SCHLESWIG_HOLSTEIN = new Version2017RegionType(SCHEME, "DE-SH");

    // DE Thuringen
    public static final Version2017RegionType DE_THURINGEN = new Version2017RegionType(SCHEME, "DE-TH");

    // DJ Ali Sabieh
    public static final Version2017RegionType DJ_ALI_SABIEH = new Version2017RegionType(SCHEME, "DJ-AS");

    // DJ Dikhil
    public static final Version2017RegionType DJ_DIKHIL = new Version2017RegionType(SCHEME, "DJ-DI");

    // DJ Djibouti
    public static final Version2017RegionType DJ_DJIBOUTI = new Version2017RegionType(SCHEME, "DJ-DJ");

    // DJ Obock
    public static final Version2017RegionType DJ_OBOCK = new Version2017RegionType(SCHEME, "DJ-OB");

    // DJ Tadjoura
    public static final Version2017RegionType DJ_TADJOURA = new Version2017RegionType(SCHEME, "DJ-TA");

    // DK Arhus
    public static final Version2017RegionType DK_ARHUS = new Version2017RegionType(SCHEME, "DK-070");

    // DK Bornholm
    public static final Version2017RegionType DK_BORNHOLM = new Version2017RegionType(SCHEME, "DK-040");

    // DK Frederiksberg
    public static final Version2017RegionType DK_FREDERIKSBERG = new Version2017RegionType(SCHEME, "DK-147");

    // DK Frederiksborg
    public static final Version2017RegionType DK_FREDERIKSBORG = new Version2017RegionType(SCHEME, "DK-020");

    // DK Fyn
    public static final Version2017RegionType DK_FYN = new Version2017RegionType(SCHEME, "DK-042");

    // DK Kobenhaven
    public static final Version2017RegionType DK_KOBENHAVEN = new Version2017RegionType(SCHEME, "DK-101");

    // DK Kobenhavn
    public static final Version2017RegionType DK_KOBENHAVN = new Version2017RegionType(SCHEME, "DK-015");

    // DK Nordjylland
    public static final Version2017RegionType DK_NORDJYLLAND = new Version2017RegionType(SCHEME, "DK-080");

    // DK Ribe
    public static final Version2017RegionType DK_RIBE = new Version2017RegionType(SCHEME, "DK-055");

    // DK Ringkobing
    public static final Version2017RegionType DK_RINGKOBING = new Version2017RegionType(SCHEME, "DK-065");

    // DK Roskilde
    public static final Version2017RegionType DK_ROSKILDE = new Version2017RegionType(SCHEME, "DK-025");

    // DK Sonderjylland
    public static final Version2017RegionType DK_SONDERJYLLAND = new Version2017RegionType(SCHEME, "DK-050");

    // DK Storstrom
    public static final Version2017RegionType DK_STORSTROM = new Version2017RegionType(SCHEME, "DK-035");

    // DK Vejle
    public static final Version2017RegionType DK_VEJLE = new Version2017RegionType(SCHEME, "DK-060");

    // DK Vestsjaelland
    public static final Version2017RegionType DK_VESTSJAELLAND = new Version2017RegionType(SCHEME, "DK-030");

    // DK Viborg
    public static final Version2017RegionType DK_VIBORG = new Version2017RegionType(SCHEME, "DK-076");

    // DO Azua
    public static final Version2017RegionType DO_AZUA = new Version2017RegionType(SCHEME, "DO-02");

    // DO Bahoruco
    public static final Version2017RegionType DO_BAHORUCO = new Version2017RegionType(SCHEME, "DO-03");

    // DO Barahona
    public static final Version2017RegionType DO_BARAHONA = new Version2017RegionType(SCHEME, "DO-04");

    // DO Dajabon
    public static final Version2017RegionType DO_DAJABON = new Version2017RegionType(SCHEME, "DO-05");

    // DO Distrito Nacional (santo Domingo)
    public static final Version2017RegionType DO_DISTRITO_NACIONAL_SANTO_DOMINGO = new Version2017RegionType(SCHEME, "DO-01");

    // DO Duarte
    public static final Version2017RegionType DO_DUARTE = new Version2017RegionType(SCHEME, "DO-06");

    // DO Elias Pina
    public static final Version2017RegionType DO_ELIAS_PINA = new Version2017RegionType(SCHEME, "DO-07");

    // DO El Seibo
    public static final Version2017RegionType DO_EL_SEIBO = new Version2017RegionType(SCHEME, "DO-08");

    // DO Espaillat
    public static final Version2017RegionType DO_ESPAILLAT = new Version2017RegionType(SCHEME, "DO-09");

    // DO Hato Mayor
    public static final Version2017RegionType DO_HATO_MAYOR = new Version2017RegionType(SCHEME, "DO-30");

    // DO Independencia
    public static final Version2017RegionType DO_INDEPENDENCIA = new Version2017RegionType(SCHEME, "DO-10");

    // DO La Altagracia
    public static final Version2017RegionType DO_LA_ALTAGRACIA = new Version2017RegionType(SCHEME, "DO-11");

    // DO La Romana
    public static final Version2017RegionType DO_LA_ROMANA = new Version2017RegionType(SCHEME, "DO-12");

    // DO La Vega
    public static final Version2017RegionType DO_LA_VEGA = new Version2017RegionType(SCHEME, "DO-13");

    // DO Maria Trinidad Sanchez
    public static final Version2017RegionType DO_MARIA_TRINIDAD_SANCHEZ = new Version2017RegionType(SCHEME, "DO-14");

    // DO Monsenor Nouel
    public static final Version2017RegionType DO_MONSENOR_NOUEL = new Version2017RegionType(SCHEME, "DO-28");

    // DO Monte Cristi
    public static final Version2017RegionType DO_MONTE_CRISTI = new Version2017RegionType(SCHEME, "DO-15");

    // DO Monte Plata
    public static final Version2017RegionType DO_MONTE_PLATA = new Version2017RegionType(SCHEME, "DO-29");

    // DO Pedernales
    public static final Version2017RegionType DO_PEDERNALES = new Version2017RegionType(SCHEME, "DO-16");

    // DO Peravia
    public static final Version2017RegionType DO_PERAVIA = new Version2017RegionType(SCHEME, "DO-17");

    // DO Puerto Plata
    public static final Version2017RegionType DO_PUERTO_PLATA = new Version2017RegionType(SCHEME, "DO-18");

    // DO Salcedo
    public static final Version2017RegionType DO_SALCEDO = new Version2017RegionType(SCHEME, "DO-19");

    // DO Samana
    public static final Version2017RegionType DO_SAMANA = new Version2017RegionType(SCHEME, "DO-20");

    // DO Sanchez Ramirez
    public static final Version2017RegionType DO_SANCHEZ_RAMIREZ = new Version2017RegionType(SCHEME, "DO-24");

    // DO Santiago
    public static final Version2017RegionType DO_SANTIAGO = new Version2017RegionType(SCHEME, "DO-25");

    // DO Santiago Rodriguez
    public static final Version2017RegionType DO_SANTIAGO_RODRIGUEZ = new Version2017RegionType(SCHEME, "DO-26");

    // DO San Cristobal
    public static final Version2017RegionType DO_SAN_CRISTOBAL = new Version2017RegionType(SCHEME, "DO-21");

    // DO San Juan, DO
    public static final Version2017RegionType DO_SAN_JUAN = new Version2017RegionType(SCHEME, "DO-22");

    // DO San Pedro De Macoris
    public static final Version2017RegionType DO_SAN_PEDRO_DE_MACORIS = new Version2017RegionType(SCHEME, "DO-23");

    // DO Valverde
    public static final Version2017RegionType DO_VALVERDE = new Version2017RegionType(SCHEME, "DO-27");

    // DZ Adrar
    public static final Version2017RegionType DZ_ADRAR = new Version2017RegionType(SCHEME, "DZ-01");

    // DZ Ain Defla
    public static final Version2017RegionType DZ_AIN_DEFLA = new Version2017RegionType(SCHEME, "DZ-44");

    // DZ Ain Temouchent
    public static final Version2017RegionType DZ_AIN_TEMOUCHENT = new Version2017RegionType(SCHEME, "DZ-46");

    // DZ Alger
    public static final Version2017RegionType DZ_ALGER = new Version2017RegionType(SCHEME, "DZ-16");

    // DZ Annaba
    public static final Version2017RegionType DZ_ANNABA = new Version2017RegionType(SCHEME, "DZ-23");

    // DZ Batna
    public static final Version2017RegionType DZ_BATNA = new Version2017RegionType(SCHEME, "DZ-05");

    // DZ Bechar
    public static final Version2017RegionType DZ_BECHAR = new Version2017RegionType(SCHEME, "DZ-08");

    // DZ Bejaia
    public static final Version2017RegionType DZ_BEJAIA = new Version2017RegionType(SCHEME, "DZ-06");

    // DZ Biskra
    public static final Version2017RegionType DZ_BISKRA = new Version2017RegionType(SCHEME, "DZ-07");

    // DZ Blida
    public static final Version2017RegionType DZ_BLIDA = new Version2017RegionType(SCHEME, "DZ-09");

    // DZ Bordj Bou Arreridj
    public static final Version2017RegionType DZ_BORDJ_BOU_ARRERIDJ = new Version2017RegionType(SCHEME, "DZ-34");

    // DZ Bouira
    public static final Version2017RegionType DZ_BOUIRA = new Version2017RegionType(SCHEME, "DZ-10");

    // DZ Boumerdes
    public static final Version2017RegionType DZ_BOUMERDES = new Version2017RegionType(SCHEME, "DZ-35");

    // DZ Chlef
    public static final Version2017RegionType DZ_CHLEF = new Version2017RegionType(SCHEME, "DZ-02");

    // DZ Constantine
    public static final Version2017RegionType DZ_CONSTANTINE = new Version2017RegionType(SCHEME, "DZ-25");

    // DZ Djelfa
    public static final Version2017RegionType DZ_DJELFA = new Version2017RegionType(SCHEME, "DZ-17");

    // DZ El Bayadh
    public static final Version2017RegionType DZ_EL_BAYADH = new Version2017RegionType(SCHEME, "DZ-32");

    // DZ El Oued
    public static final Version2017RegionType DZ_EL_OUED = new Version2017RegionType(SCHEME, "DZ-39");

    // DZ El Tarf
    public static final Version2017RegionType DZ_EL_TARF = new Version2017RegionType(SCHEME, "DZ-36");

    // DZ Ghardaia
    public static final Version2017RegionType DZ_GHARDAIA = new Version2017RegionType(SCHEME, "DZ-47");

    // DZ Guelma
    public static final Version2017RegionType DZ_GUELMA = new Version2017RegionType(SCHEME, "DZ-24");

    // DZ Illizi
    public static final Version2017RegionType DZ_ILLIZI = new Version2017RegionType(SCHEME, "DZ-33");

    // DZ Jijel
    public static final Version2017RegionType DZ_JIJEL = new Version2017RegionType(SCHEME, "DZ-18");

    // DZ Khenchela
    public static final Version2017RegionType DZ_KHENCHELA = new Version2017RegionType(SCHEME, "DZ-40");

    // DZ Laghouat
    public static final Version2017RegionType DZ_LAGHOUAT = new Version2017RegionType(SCHEME, "DZ-03");

    // DZ Mascara
    public static final Version2017RegionType DZ_MASCARA = new Version2017RegionType(SCHEME, "DZ-29");

    // DZ Medea
    public static final Version2017RegionType DZ_MEDEA = new Version2017RegionType(SCHEME, "DZ-26");

    // DZ Mila
    public static final Version2017RegionType DZ_MILA = new Version2017RegionType(SCHEME, "DZ-43");

    // DZ Mostaganem
    public static final Version2017RegionType DZ_MOSTAGANEM = new Version2017RegionType(SCHEME, "DZ-27");

    // DZ Msila
    public static final Version2017RegionType DZ_MSILA = new Version2017RegionType(SCHEME, "DZ-28");

    // DZ Naama
    public static final Version2017RegionType DZ_NAAMA = new Version2017RegionType(SCHEME, "DZ-45");

    // DZ Oran
    public static final Version2017RegionType DZ_ORAN = new Version2017RegionType(SCHEME, "DZ-31");

    // DZ Ouargla
    public static final Version2017RegionType DZ_OUARGLA = new Version2017RegionType(SCHEME, "DZ-30");

    // DZ Oum El Bouaghi
    public static final Version2017RegionType DZ_OUM_EL_BOUAGHI = new Version2017RegionType(SCHEME, "DZ-04");

    // DZ Relizane
    public static final Version2017RegionType DZ_RELIZANE = new Version2017RegionType(SCHEME, "DZ-48");

    // DZ Saida
    public static final Version2017RegionType DZ_SAIDA = new Version2017RegionType(SCHEME, "DZ-20");

    // DZ Setif
    public static final Version2017RegionType DZ_SETIF = new Version2017RegionType(SCHEME, "DZ-19");

    // DZ Sidi Bel Abbes
    public static final Version2017RegionType DZ_SIDI_BEL_ABBES = new Version2017RegionType(SCHEME, "DZ-22");

    // DZ Skikda
    public static final Version2017RegionType DZ_SKIKDA = new Version2017RegionType(SCHEME, "DZ-21");

    // DZ Souk Ahras
    public static final Version2017RegionType DZ_SOUK_AHRAS = new Version2017RegionType(SCHEME, "DZ-41");

    // DZ Tamanghasset
    public static final Version2017RegionType DZ_TAMANGHASSET = new Version2017RegionType(SCHEME, "DZ-11");

    // DZ Tebessa
    public static final Version2017RegionType DZ_TEBESSA = new Version2017RegionType(SCHEME, "DZ-12");

    // DZ Tiaret
    public static final Version2017RegionType DZ_TIARET = new Version2017RegionType(SCHEME, "DZ-14");

    // DZ Tindouf
    public static final Version2017RegionType DZ_TINDOUF = new Version2017RegionType(SCHEME, "DZ-37");

    // DZ Tipaza
    public static final Version2017RegionType DZ_TIPAZA = new Version2017RegionType(SCHEME, "DZ-42");

    // DZ Tissemsilt
    public static final Version2017RegionType DZ_TISSEMSILT = new Version2017RegionType(SCHEME, "DZ-38");

    // DZ Tizi Ouzou
    public static final Version2017RegionType DZ_TIZI_OUZOU = new Version2017RegionType(SCHEME, "DZ-15");

    // DZ Tlemcen
    public static final Version2017RegionType DZ_TLEMCEN = new Version2017RegionType(SCHEME, "DZ-13");

    // EC Azuay
    public static final Version2017RegionType EC_AZUAY = new Version2017RegionType(SCHEME, "EC-A");

    // EC Bolivar, EC
    public static final Version2017RegionType EC_BOLIVAR = new Version2017RegionType(SCHEME, "EC-B");

    // EC Canar
    public static final Version2017RegionType EC_CANAR = new Version2017RegionType(SCHEME, "EC-F");

    // EC Carchi
    public static final Version2017RegionType EC_CARCHI = new Version2017RegionType(SCHEME, "EC-C");

    // EC Chimborazo
    public static final Version2017RegionType EC_CHIMBORAZO = new Version2017RegionType(SCHEME, "EC-H");

    // EC Cotopaxi
    public static final Version2017RegionType EC_COTOPAXI = new Version2017RegionType(SCHEME, "EC-X");

    // EC El Oro
    public static final Version2017RegionType EC_EL_ORO = new Version2017RegionType(SCHEME, "EC-O");

    // EC Esmeraldas
    public static final Version2017RegionType EC_ESMERALDAS = new Version2017RegionType(SCHEME, "EC-E");

    // EC Galapagos
    public static final Version2017RegionType EC_GALAPAGOS = new Version2017RegionType(SCHEME, "EC-W");

    // EC Guayas
    public static final Version2017RegionType EC_GUAYAS = new Version2017RegionType(SCHEME, "EC-G");

    // EC Imbabura
    public static final Version2017RegionType EC_IMBABURA = new Version2017RegionType(SCHEME, "EC-I");

    // EC Loja
    public static final Version2017RegionType EC_LOJA = new Version2017RegionType(SCHEME, "EC-L");

    // EC Los Rios
    public static final Version2017RegionType EC_LOS_RIOS = new Version2017RegionType(SCHEME, "EC-R");

    // EC Manabi
    public static final Version2017RegionType EC_MANABI = new Version2017RegionType(SCHEME, "EC-M");

    // EC Morona-santiago
    public static final Version2017RegionType EC_MORONA_SANTIAGO = new Version2017RegionType(SCHEME, "EC-S");

    // EC Napo
    public static final Version2017RegionType EC_NAPO = new Version2017RegionType(SCHEME, "EC-N");

    // EC Orellana
    public static final Version2017RegionType EC_ORELLANA = new Version2017RegionType(SCHEME, "EC-D");

    // EC Pastaza
    public static final Version2017RegionType EC_PASTAZA = new Version2017RegionType(SCHEME, "EC-Y");

    // EC Pichincha
    public static final Version2017RegionType EC_PICHINCHA = new Version2017RegionType(SCHEME, "EC-P");

    // EC Sucumbios
    public static final Version2017RegionType EC_SUCUMBIOS = new Version2017RegionType(SCHEME, "EC-U");

    // EC Tungurahua
    public static final Version2017RegionType EC_TUNGURAHUA = new Version2017RegionType(SCHEME, "EC-T");

    // EC Zamora-chinchipe
    public static final Version2017RegionType EC_ZAMORA_CHINCHIPE = new Version2017RegionType(SCHEME, "EC-Z");

    // EE Harjumaa
    public static final Version2017RegionType EE_HARJUMAA = new Version2017RegionType(SCHEME, "EE-37");

    // EE Hiiumaa
    public static final Version2017RegionType EE_HIIUMAA = new Version2017RegionType(SCHEME, "EE-39");

    // EE Ida-virumaa
    public static final Version2017RegionType EE_IDA_VIRUMAA = new Version2017RegionType(SCHEME, "EE-44");

    // EE Jarvamaa
    public static final Version2017RegionType EE_JARVAMAA = new Version2017RegionType(SCHEME, "EE-51");

    // EE Jogevamaa
    public static final Version2017RegionType EE_JOGEVAMAA = new Version2017RegionType(SCHEME, "EE-49");

    // EE Laanemaa
    public static final Version2017RegionType EE_LAANEMAA = new Version2017RegionType(SCHEME, "EE-57");

    // EE Laane-virumaa
    public static final Version2017RegionType EE_LAANE_VIRUMAA = new Version2017RegionType(SCHEME, "EE-59");

    // EE Parnumaa
    public static final Version2017RegionType EE_PARNUMAA = new Version2017RegionType(SCHEME, "EE-67");

    // EE Polvamaa
    public static final Version2017RegionType EE_POLVAMAA = new Version2017RegionType(SCHEME, "EE-65");

    // EE Raplamaa
    public static final Version2017RegionType EE_RAPLAMAA = new Version2017RegionType(SCHEME, "EE-70");

    // EE Saaremaa
    public static final Version2017RegionType EE_SAAREMAA = new Version2017RegionType(SCHEME, "EE-74");

    // EE Tartumaa
    public static final Version2017RegionType EE_TARTUMAA = new Version2017RegionType(SCHEME, "EE-78");

    // EE Valgamaa
    public static final Version2017RegionType EE_VALGAMAA = new Version2017RegionType(SCHEME, "EE-82");

    // EE Viljandimaa
    public static final Version2017RegionType EE_VILJANDIMAA = new Version2017RegionType(SCHEME, "EE-84");

    // EE Vorumaa
    public static final Version2017RegionType EE_VORUMAA = new Version2017RegionType(SCHEME, "EE-86");

    // EG Ad Daqahiyah
    public static final Version2017RegionType EG_AD_DAQAHIYAH = new Version2017RegionType(SCHEME, "EG-DK");

    // EG Al Bahr Al Ahmar
    public static final Version2017RegionType EG_AL_BAHR_AL_AHMAR = new Version2017RegionType(SCHEME, "EG-BA");

    // EG Al Buhayarh
    public static final Version2017RegionType EG_AL_BUHAYARH = new Version2017RegionType(SCHEME, "EG-BH");

    // EG Al Fayyum
    public static final Version2017RegionType EG_AL_FAYYUM = new Version2017RegionType(SCHEME, "EG-FYM");

    // EG Al Gharbiyah
    public static final Version2017RegionType EG_AL_GHARBIYAH = new Version2017RegionType(SCHEME, "EG-GH");

    // EG Al Iskandanyah
    public static final Version2017RegionType EG_AL_ISKANDANYAH = new Version2017RegionType(SCHEME, "EG-ALX");

    // EG Al Ismailiyah
    public static final Version2017RegionType EG_AL_ISMAILIYAH = new Version2017RegionType(SCHEME, "EG-IS");

    // EG Al Jizah
    public static final Version2017RegionType EG_AL_JIZAH = new Version2017RegionType(SCHEME, "EG-GZ");

    // EG Al Minufiyah
    public static final Version2017RegionType EG_AL_MINUFIYAH = new Version2017RegionType(SCHEME, "EG-MNF");

    // EG Al Minya
    public static final Version2017RegionType EG_AL_MINYA = new Version2017RegionType(SCHEME, "EG-MN");

    // EG Al Qahirah
    public static final Version2017RegionType EG_AL_QAHIRAH = new Version2017RegionType(SCHEME, "EG-C");

    // EG Al Qalyubiyah
    public static final Version2017RegionType EG_AL_QALYUBIYAH = new Version2017RegionType(SCHEME, "EG-KB");

    // EG Al Wad Al Jadd
    public static final Version2017RegionType EG_AL_WAD_AL_JADD = new Version2017RegionType(SCHEME, "EG-WAD");

    // EG Ash Sharoiyah
    public static final Version2017RegionType EG_ASH_SHAROIYAH = new Version2017RegionType(SCHEME, "EG-SHR");

    // EG Aswan
    public static final Version2017RegionType EG_ASWAN = new Version2017RegionType(SCHEME, "EG-ASN");

    // EG Asyut
    public static final Version2017RegionType EG_ASYUT = new Version2017RegionType(SCHEME, "EG-AST");

    // EG As Suways
    public static final Version2017RegionType EG_AS_SUWAYS = new Version2017RegionType(SCHEME, "EG-SUZ");

    // EG Bari Suwayf
    public static final Version2017RegionType EG_BARI_SUWAYF = new Version2017RegionType(SCHEME, "EG-BNS");

    // EG Bur Said
    public static final Version2017RegionType EG_BUR_SAID = new Version2017RegionType(SCHEME, "EG-PTS");

    // EG Dumat
    public static final Version2017RegionType EG_DUMAT = new Version2017RegionType(SCHEME, "EG-DT");

    // EG Janub Sina
    public static final Version2017RegionType EG_JANUB_SINA = new Version2017RegionType(SCHEME, "EG-JS");

    // EG Kafr Ash Shaykh
    public static final Version2017RegionType EG_KAFR_ASH_SHAYKH = new Version2017RegionType(SCHEME, "EG-KFS");

    // EG Matruh
    public static final Version2017RegionType EG_MATRUH = new Version2017RegionType(SCHEME, "EG-MT");

    // EG Qina
    public static final Version2017RegionType EG_QINA = new Version2017RegionType(SCHEME, "EG-KN");

    // EG Shamal Sina
    public static final Version2017RegionType EG_SHAMAL_SINA = new Version2017RegionType(SCHEME, "EG-SIN");

    // EG Suhaj
    public static final Version2017RegionType EG_SUHAJ = new Version2017RegionType(SCHEME, "EG-SHG");

    // ER Anseba
    public static final Version2017RegionType ER_ANSEBA = new Version2017RegionType(SCHEME, "ER-AN");

    // ER Debub
    public static final Version2017RegionType ER_DEBUB = new Version2017RegionType(SCHEME, "ER-DU");

    // ER Debub-keih-bahri
    public static final Version2017RegionType ER_DEBUB_KEIH_BAHRI = new Version2017RegionType(SCHEME, "ER-DK");

    // ER Gash-barka
    public static final Version2017RegionType ER_GASH_BARKA = new Version2017RegionType(SCHEME, "ER-GB");

    // ER Maekel
    public static final Version2017RegionType ER_MAEKEL = new Version2017RegionType(SCHEME, "ER-MA");

    // ER Semien-keih-bahri
    public static final Version2017RegionType ER_SEMIEN_KEIH_BAHRI = new Version2017RegionType(SCHEME, "ER-SK");

    // ES Alava
    public static final Version2017RegionType ES_ALAVA = new Version2017RegionType(SCHEME, "ES-VI");

    // ES Albacete
    public static final Version2017RegionType ES_ALBACETE = new Version2017RegionType(SCHEME, "ES-AB");

    // ES Alicante
    public static final Version2017RegionType ES_ALICANTE = new Version2017RegionType(SCHEME, "ES-A");

    // ES Almeria
    public static final Version2017RegionType ES_ALMERIA = new Version2017RegionType(SCHEME, "ES-AL");

    // ES Asturias
    public static final Version2017RegionType ES_ASTURIAS = new Version2017RegionType(SCHEME, "ES-O");

    // ES Avila
    public static final Version2017RegionType ES_AVILA = new Version2017RegionType(SCHEME, "ES-AV");

    // ES A Coruna
    public static final Version2017RegionType ES_A_CORUNA = new Version2017RegionType(SCHEME, "ES-C");

    // ES Badajoz
    public static final Version2017RegionType ES_BADAJOZ = new Version2017RegionType(SCHEME, "ES-BA");

    // ES Baleares
    public static final Version2017RegionType ES_BALEARES = new Version2017RegionType(SCHEME, "ES-PM");

    // ES Barcelona
    public static final Version2017RegionType ES_BARCELONA = new Version2017RegionType(SCHEME, "ES-B");

    // ES Burgos
    public static final Version2017RegionType ES_BURGOS = new Version2017RegionType(SCHEME, "ES-BU");

    // ES Caceres
    public static final Version2017RegionType ES_CACERES = new Version2017RegionType(SCHEME, "ES-CC");

    // ES Cadiz
    public static final Version2017RegionType ES_CADIZ = new Version2017RegionType(SCHEME, "ES-CA");

    // ES Cantabria
    public static final Version2017RegionType ES_CANTABRIA = new Version2017RegionType(SCHEME, "ES-S");

    // ES Castellon
    public static final Version2017RegionType ES_CASTELLON = new Version2017RegionType(SCHEME, "ES-CS");

    // ES Ceuta
    public static final Version2017RegionType ES_CEUTA = new Version2017RegionType(SCHEME, "ES-CE");

    // ES Ciudad Real
    public static final Version2017RegionType ES_CIUDAD_REAL = new Version2017RegionType(SCHEME, "ES-CR");

    // ES Cordoba, ES
    public static final Version2017RegionType ES_CORDOBA = new Version2017RegionType(SCHEME, "ES-CO");

    // ES Cuenca
    public static final Version2017RegionType ES_CUENCA = new Version2017RegionType(SCHEME, "ES-CU");

    // ES Girona
    public static final Version2017RegionType ES_GIRONA = new Version2017RegionType(SCHEME, "ES-GI");

    // ES Granada, ES
    public static final Version2017RegionType ES_GRANADA = new Version2017RegionType(SCHEME, "ES-GR");

    // ES Guadalajara
    public static final Version2017RegionType ES_GUADALAJARA = new Version2017RegionType(SCHEME, "ES-GU");

    // ES Guipuzcoa
    public static final Version2017RegionType ES_GUIPUZCOA = new Version2017RegionType(SCHEME, "ES-SS");

    // ES Huelva
    public static final Version2017RegionType ES_HUELVA = new Version2017RegionType(SCHEME, "ES-H");

    // ES Huesca
    public static final Version2017RegionType ES_HUESCA = new Version2017RegionType(SCHEME, "ES-HU");

    // ES Jaen
    public static final Version2017RegionType ES_JAEN = new Version2017RegionType(SCHEME, "ES-J");

    // ES Las Palmas
    public static final Version2017RegionType ES_LAS_PALMAS = new Version2017RegionType(SCHEME, "ES-GC");

    // ES La Rioja
    public static final Version2017RegionType ES_LA_RIOJA = new Version2017RegionType(SCHEME, "ES-LO");

    // ES Leon, ES
    public static final Version2017RegionType ES_LEON = new Version2017RegionType(SCHEME, "ES-LE");

    // ES Lleida
    public static final Version2017RegionType ES_LLEIDA = new Version2017RegionType(SCHEME, "ES-L");

    // ES Lugo
    public static final Version2017RegionType ES_LUGO = new Version2017RegionType(SCHEME, "ES-LU");

    // ES Madrid
    public static final Version2017RegionType ES_MADRID = new Version2017RegionType(SCHEME, "ES-M");

    // ES Malaga
    public static final Version2017RegionType ES_MALAGA = new Version2017RegionType(SCHEME, "ES-MA");

    // ES Melilla
    public static final Version2017RegionType ES_MELILLA = new Version2017RegionType(SCHEME, "ES-ML");

    // ES Murcia
    public static final Version2017RegionType ES_MURCIA = new Version2017RegionType(SCHEME, "ES-MU");

    // ES Navarra
    public static final Version2017RegionType ES_NAVARRA = new Version2017RegionType(SCHEME, "ES-NA");

    // ES Ourense
    public static final Version2017RegionType ES_OURENSE = new Version2017RegionType(SCHEME, "ES-OR");

    // ES Palencia
    public static final Version2017RegionType ES_PALENCIA = new Version2017RegionType(SCHEME, "ES-P");

    // ES Pontevedra
    public static final Version2017RegionType ES_PONTEVEDRA = new Version2017RegionType(SCHEME, "ES-PO");

    // ES Salamanca
    public static final Version2017RegionType ES_SALAMANCA = new Version2017RegionType(SCHEME, "ES-SA");

    // ES Santa Cruz De Tenerife
    public static final Version2017RegionType ES_SANTA_CRUZ_DE_TENERIFE = new Version2017RegionType(SCHEME, "ES-TF");

    // ES Segovia
    public static final Version2017RegionType ES_SEGOVIA = new Version2017RegionType(SCHEME, "ES-SG");

    // ES Sevilla
    public static final Version2017RegionType ES_SEVILLA = new Version2017RegionType(SCHEME, "ES-SE");

    // ES Soria
    public static final Version2017RegionType ES_SORIA = new Version2017RegionType(SCHEME, "ES-SO");

    // ES Tarragona
    public static final Version2017RegionType ES_TARRAGONA = new Version2017RegionType(SCHEME, "ES-T");

    // ES Teruel
    public static final Version2017RegionType ES_TERUEL = new Version2017RegionType(SCHEME, "ES-TE");

    // ES Toledo, ES
    public static final Version2017RegionType ES_TOLEDO = new Version2017RegionType(SCHEME, "ES-TO");

    // ES Valencia
    public static final Version2017RegionType ES_VALENCIA = new Version2017RegionType(SCHEME, "ES-V");

    // ES Valladolid
    public static final Version2017RegionType ES_VALLADOLID = new Version2017RegionType(SCHEME, "ES-VA");

    // ES Vizcaya
    public static final Version2017RegionType ES_VIZCAYA = new Version2017RegionType(SCHEME, "ES-BI");

    // ES Zamora
    public static final Version2017RegionType ES_ZAMORA = new Version2017RegionType(SCHEME, "ES-ZA");

    // ES Zaragoza
    public static final Version2017RegionType ES_ZARAGOZA = new Version2017RegionType(SCHEME, "ES-Z");

    // ET Ads Abeba
    public static final Version2017RegionType ET_ADS_ABEBA = new Version2017RegionType(SCHEME, "ET-AA");

    // ET Afar
    public static final Version2017RegionType ET_AFAR = new Version2017RegionType(SCHEME, "ET-AF");

    // ET Amara
    public static final Version2017RegionType ET_AMARA = new Version2017RegionType(SCHEME, "ET-AM");

    // ET Binshangul Gumuz
    public static final Version2017RegionType ET_BINSHANGUL_GUMUZ = new Version2017RegionType(SCHEME, "ET-BE");

    // ET Dire Dawa
    public static final Version2017RegionType ET_DIRE_DAWA = new Version2017RegionType(SCHEME, "ET-DD");

    // ET Gambela Hizboch
    public static final Version2017RegionType ET_GAMBELA_HIZBOCH = new Version2017RegionType(SCHEME, "ET-GA");

    // ET Hareri Hizb
    public static final Version2017RegionType ET_HARERI_HIZB = new Version2017RegionType(SCHEME, "ET-HA");

    // ET Oromya
    public static final Version2017RegionType ET_OROMYA = new Version2017RegionType(SCHEME, "ET-OR");

    // ET Sumale
    public static final Version2017RegionType ET_SUMALE = new Version2017RegionType(SCHEME, "ET-SO");

    // ET Tigray
    public static final Version2017RegionType ET_TIGRAY = new Version2017RegionType(SCHEME, "ET-TI");

    // ET Yedebub Biheroch Bihereseboch Na Hizboch
    public static final Version2017RegionType ET_YEDEBUB_BIHEROCH_BIHERESEBOCH_NA_HIZBOCH = new Version2017RegionType(SCHEME, "ET-SN");

    // FI Ahvenanmaan Laani
    public static final Version2017RegionType FI_AHVENANMAAN_LAANI = new Version2017RegionType(SCHEME, "FI-AL");

    // FI Etela-suomen Laani
    public static final Version2017RegionType FI_ETELA_SUOMEN_LAANI = new Version2017RegionType(SCHEME, "FI-ES");

    // FI Ita-suomen Laani
    public static final Version2017RegionType FI_ITA_SUOMEN_LAANI = new Version2017RegionType(SCHEME, "FI-IS");

    // FI Lansi-suomen Laani
    public static final Version2017RegionType FI_LANSI_SUOMEN_LAANI = new Version2017RegionType(SCHEME, "FI-LS");

    // FI Lapin Laani
    public static final Version2017RegionType FI_LAPIN_LAANI = new Version2017RegionType(SCHEME, "FI-LL");

    // FI Oulun Laani
    public static final Version2017RegionType FI_OULUN_LAANI = new Version2017RegionType(SCHEME, "FI-OL");

    // FJ Central, FJ
    public static final Version2017RegionType FJ_CENTRAL = new Version2017RegionType(SCHEME, "FJ-C");

    // FJ Eastern, FJ
    public static final Version2017RegionType FJ_EASTERN = new Version2017RegionType(SCHEME, "FJ-E");

    // FJ Northern
    public static final Version2017RegionType FJ_NORTHERN = new Version2017RegionType(SCHEME, "FJ-N");

    // FJ Rotuma
    public static final Version2017RegionType FJ_ROTUMA = new Version2017RegionType(SCHEME, "FJ-R");

    // FJ Western
    public static final Version2017RegionType FJ_WESTERN = new Version2017RegionType(SCHEME, "FJ-W");

    // FM Chuuk
    public static final Version2017RegionType FM_CHUUK = new Version2017RegionType(SCHEME, "FM-TRK");

    // FM Kosrae
    public static final Version2017RegionType FM_KOSRAE = new Version2017RegionType(SCHEME, "FM-KSA");

    // FM Pohnpei
    public static final Version2017RegionType FM_POHNPEI = new Version2017RegionType(SCHEME, "FM-PNI");

    // FM Yap
    public static final Version2017RegionType FM_YAP = new Version2017RegionType(SCHEME, "FM-YAP");

    // FR Ain
    public static final Version2017RegionType FR_AIN = new Version2017RegionType(SCHEME, "FR-01");

    // FR Aisne
    public static final Version2017RegionType FR_AISNE = new Version2017RegionType(SCHEME, "FR-02");

    // FR Allier
    public static final Version2017RegionType FR_ALLIER = new Version2017RegionType(SCHEME, "FR-03");

    // FR Alpes-de-haute-provence
    public static final Version2017RegionType FR_ALPES_DE_HAUTE_PROVENCE = new Version2017RegionType(SCHEME, "FR-04");

    // FR Alpes-maritimes
    public static final Version2017RegionType FR_ALPES_MARITIMES = new Version2017RegionType(SCHEME, "FR-06");

    // FR Ardeche
    public static final Version2017RegionType FR_ARDECHE = new Version2017RegionType(SCHEME, "FR-07");

    // FR Ardennes
    public static final Version2017RegionType FR_ARDENNES = new Version2017RegionType(SCHEME, "FR-08");

    // FR Ariege
    public static final Version2017RegionType FR_ARIEGE = new Version2017RegionType(SCHEME, "FR-09");

    // FR Aube
    public static final Version2017RegionType FR_AUBE = new Version2017RegionType(SCHEME, "FR-10");

    // FR Aude
    public static final Version2017RegionType FR_AUDE = new Version2017RegionType(SCHEME, "FR-11");

    // FR Aveyron
    public static final Version2017RegionType FR_AVEYRON = new Version2017RegionType(SCHEME, "FR-12");

    // FR Bas-rhin
    public static final Version2017RegionType FR_BAS_RHIN = new Version2017RegionType(SCHEME, "FR-67");

    // FR Bouches-du-rhone
    public static final Version2017RegionType FR_BOUCHES_DU_RHONE = new Version2017RegionType(SCHEME, "FR-13");

    // FR Calvados
    public static final Version2017RegionType FR_CALVADOS = new Version2017RegionType(SCHEME, "FR-14");

    // FR Cantal
    public static final Version2017RegionType FR_CANTAL = new Version2017RegionType(SCHEME, "FR-15");

    // FR Charente
    public static final Version2017RegionType FR_CHARENTE = new Version2017RegionType(SCHEME, "FR-16");

    // FR Charente-maritime
    public static final Version2017RegionType FR_CHARENTE_MARITIME = new Version2017RegionType(SCHEME, "FR-17");

    // FR Cher
    public static final Version2017RegionType FR_CHER = new Version2017RegionType(SCHEME, "FR-18");

    // FR Correze
    public static final Version2017RegionType FR_CORREZE = new Version2017RegionType(SCHEME, "FR-19");

    // FR Corse-du-sud
    public static final Version2017RegionType FR_CORSE_DU_SUD = new Version2017RegionType(SCHEME, "FR-2A");

    // FR Cotes-d'armor
    public static final Version2017RegionType FR_COTES_DARMOR = new Version2017RegionType(SCHEME, "FR-22");

    // FR Cote-d'or
    public static final Version2017RegionType FR_COTE_DOR = new Version2017RegionType(SCHEME, "FR-21");

    // FR Creuse
    public static final Version2017RegionType FR_CREUSE = new Version2017RegionType(SCHEME, "FR-23");

    // FR Deux-sevres
    public static final Version2017RegionType FR_DEUX_SEVRES = new Version2017RegionType(SCHEME, "FR-79");

    // FR Dordogne
    public static final Version2017RegionType FR_DORDOGNE = new Version2017RegionType(SCHEME, "FR-24");

    // FR Doubs
    public static final Version2017RegionType FR_DOUBS = new Version2017RegionType(SCHEME, "FR-25");

    // FR Drome
    public static final Version2017RegionType FR_DROME = new Version2017RegionType(SCHEME, "FR-26");

    // FR Essonne
    public static final Version2017RegionType FR_ESSONNE = new Version2017RegionType(SCHEME, "FR-91");

    // FR Eure
    public static final Version2017RegionType FR_EURE = new Version2017RegionType(SCHEME, "FR-27");

    // FR Eure-et-loir
    public static final Version2017RegionType FR_EURE_ET_LOIR = new Version2017RegionType(SCHEME, "FR-28");

    // FR Finistere
    public static final Version2017RegionType FR_FINISTERE = new Version2017RegionType(SCHEME, "FR-29");

    // FR Gard
    public static final Version2017RegionType FR_GARD = new Version2017RegionType(SCHEME, "FR-30");

    // FR Gers
    public static final Version2017RegionType FR_GERS = new Version2017RegionType(SCHEME, "FR-32");

    // FR Gironde
    public static final Version2017RegionType FR_GIRONDE = new Version2017RegionType(SCHEME, "FR-33");

    // FR Hautes-alpes
    public static final Version2017RegionType FR_HAUTES_ALPES = new Version2017RegionType(SCHEME, "FR-05");

    // FR Hautes-pyrenees
    public static final Version2017RegionType FR_HAUTES_PYRENEES = new Version2017RegionType(SCHEME, "FR-65");

    // FR Haute-corse
    public static final Version2017RegionType FR_HAUTE_CORSE = new Version2017RegionType(SCHEME, "FR-2B");

    // FR Haute-garonne
    public static final Version2017RegionType FR_HAUTE_GARONNE = new Version2017RegionType(SCHEME, "FR-31");

    // FR Haute-loire
    public static final Version2017RegionType FR_HAUTE_LOIRE = new Version2017RegionType(SCHEME, "FR-43");

    // FR Haute-marne
    public static final Version2017RegionType FR_HAUTE_MARNE = new Version2017RegionType(SCHEME, "FR-52");

    // FR Haute-saone
    public static final Version2017RegionType FR_HAUTE_SAONE = new Version2017RegionType(SCHEME, "FR-70");

    // FR Haute-savoie
    public static final Version2017RegionType FR_HAUTE_SAVOIE = new Version2017RegionType(SCHEME, "FR-74");

    // FR Haute-vienne
    public static final Version2017RegionType FR_HAUTE_VIENNE = new Version2017RegionType(SCHEME, "FR-87");

    // FR Hauts-de-seine
    public static final Version2017RegionType FR_HAUTS_DE_SEINE = new Version2017RegionType(SCHEME, "FR-92");

    // FR Haut-rhin
    public static final Version2017RegionType FR_HAUT_RHIN = new Version2017RegionType(SCHEME, "FR-68");

    // FR Herault
    public static final Version2017RegionType FR_HERAULT = new Version2017RegionType(SCHEME, "FR-34");

    // FR Ille-et-vilaine
    public static final Version2017RegionType FR_ILLE_ET_VILAINE = new Version2017RegionType(SCHEME, "FR-35");

    // FR Indre
    public static final Version2017RegionType FR_INDRE = new Version2017RegionType(SCHEME, "FR-36");

    // FR Indre-et-loire
    public static final Version2017RegionType FR_INDRE_ET_LOIRE = new Version2017RegionType(SCHEME, "FR-37");

    // FR Isere
    public static final Version2017RegionType FR_ISERE = new Version2017RegionType(SCHEME, "FR-38");

    // FR Jura
    public static final Version2017RegionType FR_JURA = new Version2017RegionType(SCHEME, "FR-39");

    // FR Landes
    public static final Version2017RegionType FR_LANDES = new Version2017RegionType(SCHEME, "FR-40");

    // FR Loire
    public static final Version2017RegionType FR_LOIRE = new Version2017RegionType(SCHEME, "FR-42");

    // FR Loiret
    public static final Version2017RegionType FR_LOIRET = new Version2017RegionType(SCHEME, "FR-45");

    // FR Loire-atlantique
    public static final Version2017RegionType FR_LOIRE_ATLANTIQUE = new Version2017RegionType(SCHEME, "FR-44");

    // FR Loir-et-cher
    public static final Version2017RegionType FR_LOIR_ET_CHER = new Version2017RegionType(SCHEME, "FR-41");

    // FR Lot
    public static final Version2017RegionType FR_LOT = new Version2017RegionType(SCHEME, "FR-46");

    // FR Lot-et-garonne
    public static final Version2017RegionType FR_LOT_ET_GARONNE = new Version2017RegionType(SCHEME, "FR-47");

    // FR Lozere
    public static final Version2017RegionType FR_LOZERE = new Version2017RegionType(SCHEME, "FR-48");

    // FR Maine-et-loire
    public static final Version2017RegionType FR_MAINE_ET_LOIRE = new Version2017RegionType(SCHEME, "FR-49");

    // FR Manche
    public static final Version2017RegionType FR_MANCHE = new Version2017RegionType(SCHEME, "FR-50");

    // FR Marne
    public static final Version2017RegionType FR_MARNE = new Version2017RegionType(SCHEME, "FR-51");

    // FR Mayenne
    public static final Version2017RegionType FR_MAYENNE = new Version2017RegionType(SCHEME, "FR-53");

    // FR Mayotte (see also separate entry under Yt)
    public static final Version2017RegionType FR_MAYOTTE = new Version2017RegionType(SCHEME, "FR-YT");

    // FR Meurthe-et-moselle
    public static final Version2017RegionType FR_MEURTHE_ET_MOSELLE = new Version2017RegionType(SCHEME, "FR-54");

    // FR Meuse
    public static final Version2017RegionType FR_MEUSE = new Version2017RegionType(SCHEME, "FR-55");

    // FR Morbihan
    public static final Version2017RegionType FR_MORBIHAN = new Version2017RegionType(SCHEME, "FR-56");

    // FR Moselle
    public static final Version2017RegionType FR_MOSELLE = new Version2017RegionType(SCHEME, "FR-57");

    // FR Nievre
    public static final Version2017RegionType FR_NIEVRE = new Version2017RegionType(SCHEME, "FR-58");

    // FR Nord, FR
    public static final Version2017RegionType FR_NORD = new Version2017RegionType(SCHEME, "FR-59");

    // FR Nouvelle-caledonie (see also separate entry under Nc)
    public static final Version2017RegionType FR_NOUVELLE_CALEDONIE = new Version2017RegionType(SCHEME, "FR-NC");

    // FR Oise
    public static final Version2017RegionType FR_OISE = new Version2017RegionType(SCHEME, "FR-60");

    // FR Orne
    public static final Version2017RegionType FR_ORNE = new Version2017RegionType(SCHEME, "FR-61");

    // FR Paris
    public static final Version2017RegionType FR_PARIS = new Version2017RegionType(SCHEME, "FR-75");

    // FR Pas-de-calais
    public static final Version2017RegionType FR_PAS_DE_CALAIS = new Version2017RegionType(SCHEME, "FR-62");

    // FR Polynesie Francaise
    public static final Version2017RegionType FR_POLYNESIE_FRANCAISE = new Version2017RegionType(SCHEME, "FR-PF");

    // FR Pyrenees-atlantiques
    public static final Version2017RegionType FR_PYRENEES_ATLANTIQUES = new Version2017RegionType(SCHEME, "FR-64");

    // FR Pyrenees-orientales
    public static final Version2017RegionType FR_PYRENEES_ORIENTALES = new Version2017RegionType(SCHEME, "FR-66");

    // FR Py-de-dome
    public static final Version2017RegionType FR_PY_DE_DOME = new Version2017RegionType(SCHEME, "FR-63");

    // FR Rhone
    public static final Version2017RegionType FR_RHONE = new Version2017RegionType(SCHEME, "FR-69");

    // FR Saint-pierre-et-miquelon (see also separate entry under Pm)
    public static final Version2017RegionType FR_SAINT_PIERRE_ET_MIQUELON = new Version2017RegionType(SCHEME, "FR-PM");

    // FR Saone-et-loire
    public static final Version2017RegionType FR_SAONE_ET_LOIRE = new Version2017RegionType(SCHEME, "FR-71");

    // FR Sarthe
    public static final Version2017RegionType FR_SARTHE = new Version2017RegionType(SCHEME, "FR-72");

    // FR Savoie
    public static final Version2017RegionType FR_SAVOIE = new Version2017RegionType(SCHEME, "FR-73");

    // FR Seine-et-marne
    public static final Version2017RegionType FR_SEINE_ET_MARNE = new Version2017RegionType(SCHEME, "FR-77");

    // FR Seine-maritime
    public static final Version2017RegionType FR_SEINE_MARITIME = new Version2017RegionType(SCHEME, "FR-76");

    // FR Seine-saint-denis
    public static final Version2017RegionType FR_SEINE_SAINT_DENIS = new Version2017RegionType(SCHEME, "FR-93");

    // FR Somme
    public static final Version2017RegionType FR_SOMME = new Version2017RegionType(SCHEME, "FR-80");

    // FR Tarn
    public static final Version2017RegionType FR_TARN = new Version2017RegionType(SCHEME, "FR-81");

    // FR Tarn-et-garonne
    public static final Version2017RegionType FR_TARN_ET_GARONNE = new Version2017RegionType(SCHEME, "FR-82");

    // FR Terres Australes Francaises
    public static final Version2017RegionType FR_TERRES_AUSTRALES_FRANCAISES = new Version2017RegionType(SCHEME, "FR-TF");

    // FR Territoire De Belfort
    public static final Version2017RegionType FR_TERRITOIRE_DE_BELFORT = new Version2017RegionType(SCHEME, "FR-90");

    // FR Val-de-marne
    public static final Version2017RegionType FR_VAL_DE_MARNE = new Version2017RegionType(SCHEME, "FR-94");

    // FR Val-d'oise
    public static final Version2017RegionType FR_VAL_DOISE = new Version2017RegionType(SCHEME, "FR-95");

    // FR Var
    public static final Version2017RegionType FR_VAR = new Version2017RegionType(SCHEME, "FR-83");

    // FR Vaucluse
    public static final Version2017RegionType FR_VAUCLUSE = new Version2017RegionType(SCHEME, "FR-84");

    // FR Vendee
    public static final Version2017RegionType FR_VENDEE = new Version2017RegionType(SCHEME, "FR-85");

    // FR Vienne
    public static final Version2017RegionType FR_VIENNE = new Version2017RegionType(SCHEME, "FR-86");

    // FR Vosges
    public static final Version2017RegionType FR_VOSGES = new Version2017RegionType(SCHEME, "FR-88");

    // FR Wallis Et Futuna (see also separate entry under Wf)
    public static final Version2017RegionType FR_WALLIS_ET_FUTUNA = new Version2017RegionType(SCHEME, "FR-WF");

    // FR Yonne
    public static final Version2017RegionType FR_YONNE = new Version2017RegionType(SCHEME, "FR-89");

    // FR Yvelines
    public static final Version2017RegionType FR_YVELINES = new Version2017RegionType(SCHEME, "FR-78");

    // GA Estuaire
    public static final Version2017RegionType GA_ESTUAIRE = new Version2017RegionType(SCHEME, "GA-1");

    // GA Haut-ogooue
    public static final Version2017RegionType GA_HAUT_OGOOUE = new Version2017RegionType(SCHEME, "GA-2");

    // GA Moyen-ogooue
    public static final Version2017RegionType GA_MOYEN_OGOOUE = new Version2017RegionType(SCHEME, "GA-3");

    // GA Ngounie
    public static final Version2017RegionType GA_NGOUNIE = new Version2017RegionType(SCHEME, "GA-4");

    // GA Nyanga
    public static final Version2017RegionType GA_NYANGA = new Version2017RegionType(SCHEME, "GA-5");

    // GA Ogooue-ivindo
    public static final Version2017RegionType GA_OGOOUE_IVINDO = new Version2017RegionType(SCHEME, "GA-6");

    // GA Ogooue-lolo
    public static final Version2017RegionType GA_OGOOUE_LOLO = new Version2017RegionType(SCHEME, "GA-7");

    // GA Ogooue-maritime
    public static final Version2017RegionType GA_OGOOUE_MARITIME = new Version2017RegionType(SCHEME, "GA-8");

    // GA Woleu-ntem
    public static final Version2017RegionType GA_WOLEU_NTEM = new Version2017RegionType(SCHEME, "GA-9");

    // GB Aberdeenshire
    public static final Version2017RegionType GB_ABERDEENSHIRE = new Version2017RegionType(SCHEME, "GB-ABD");

    // GB Aberdeen City
    public static final Version2017RegionType GB_ABERDEEN_CITY = new Version2017RegionType(SCHEME, "GB-ABE");

    // GB Abertawe Gb-ata
    public static final Version2017RegionType GB_ABERTAWE_GB_ATA = new Version2017RegionType(SCHEME, "GB-SWA");

    // GB Angus
    public static final Version2017RegionType GB_ANGUS = new Version2017RegionType(SCHEME, "GB-ANS");

    // GB Antrim
    public static final Version2017RegionType GB_ANTRIM = new Version2017RegionType(SCHEME, "GB-ANT");

    // GB Ards
    public static final Version2017RegionType GB_ARDS = new Version2017RegionType(SCHEME, "GB-ARD");

    // GB Argyll And Bute
    public static final Version2017RegionType GB_ARGYLL_AND_BUTE = new Version2017RegionType(SCHEME, "GB-AGB");

    // GB Armagh
    public static final Version2017RegionType GB_ARMAGH = new Version2017RegionType(SCHEME, "GB-ARM");

    // GB Ballymena
    public static final Version2017RegionType GB_BALLYMENA = new Version2017RegionType(SCHEME, "GB-BLA");

    // GB Ballymoney
    public static final Version2017RegionType GB_BALLYMONEY = new Version2017RegionType(SCHEME, "GB-BLY");

    // GB Banbridge
    public static final Version2017RegionType GB_BANBRIDGE = new Version2017RegionType(SCHEME, "GB-BNB");

    // GB Barking And Dagenham
    public static final Version2017RegionType GB_BARKING_AND_DAGENHAM = new Version2017RegionType(SCHEME, "GB-BDG");

    // GB Barnet
    public static final Version2017RegionType GB_BARNET = new Version2017RegionType(SCHEME, "GB-BNE");

    // GB Barnsley
    public static final Version2017RegionType GB_BARNSLEY = new Version2017RegionType(SCHEME, "GB-BNS");

    // GB Bath And North East Somerset
    public static final Version2017RegionType GB_BATH_AND_NORTH_EAST_SOMERSET = new Version2017RegionType(SCHEME, "GB-BAS");

    // GB Bedfordshire
    public static final Version2017RegionType GB_BEDFORDSHIRE = new Version2017RegionType(SCHEME, "GB-BDF");

    // GB Belfast
    public static final Version2017RegionType GB_BELFAST = new Version2017RegionType(SCHEME, "GB-BFS");

    // GB Bexley
    public static final Version2017RegionType GB_BEXLEY = new Version2017RegionType(SCHEME, "GB-BEX");

    // GB Birmingham
    public static final Version2017RegionType GB_BIRMINGHAM = new Version2017RegionType(SCHEME, "GB-BIR");

    // GB Blackburn With Darwen
    public static final Version2017RegionType GB_BLACKBURN_WITH_DARWEN = new Version2017RegionType(SCHEME, "GB-BBD");

    // GB Blackpool
    public static final Version2017RegionType GB_BLACKPOOL = new Version2017RegionType(SCHEME, "GB-BPL");

    // GB Blaenau Gwent
    public static final Version2017RegionType GB_BLAENAU_GWENT = new Version2017RegionType(SCHEME, "GB-BGW");

    // GB Bolton
    public static final Version2017RegionType GB_BOLTON = new Version2017RegionType(SCHEME, "GB-BOL");

    // GB Bournemouth
    public static final Version2017RegionType GB_BOURNEMOUTH = new Version2017RegionType(SCHEME, "GB-BMH");

    // GB Bracknell Forest
    public static final Version2017RegionType GB_BRACKNELL_FOREST = new Version2017RegionType(SCHEME, "GB-BRC");

    // GB Bradford
    public static final Version2017RegionType GB_BRADFORD = new Version2017RegionType(SCHEME, "GB-BRD");

    // GB Brent
    public static final Version2017RegionType GB_BRENT = new Version2017RegionType(SCHEME, "GB-BEN");

    // GB Brighton And Hove
    public static final Version2017RegionType GB_BRIGHTON_AND_HOVE = new Version2017RegionType(SCHEME, "GB-BNH");

    // GB Bristol, City Of
    public static final Version2017RegionType GB_BRISTOL_CITY_OF = new Version2017RegionType(SCHEME, "GB-BST");

    // GB Bromley
    public static final Version2017RegionType GB_BROMLEY = new Version2017RegionType(SCHEME, "GB-BRY");

    // GB Bro Morgannwg Gb-bmg
    public static final Version2017RegionType GB_BRO_MORGANNWG_GB_BMG = new Version2017RegionType(SCHEME, "GB-VGL");

    // GB Buckinghamshire
    public static final Version2017RegionType GB_BUCKINGHAMSHIRE = new Version2017RegionType(SCHEME, "GB-BKM");

    // GB Bury
    public static final Version2017RegionType GB_BURY = new Version2017RegionType(SCHEME, "GB-BUR");

    // GB Caerdydd Gb-crd
    public static final Version2017RegionType GB_CAERDYDD_GB_CRD = new Version2017RegionType(SCHEME, "GB-CRF");

    // GB Caerffili Gb-caf
    public static final Version2017RegionType GB_CAERFFILI_GB_CAF = new Version2017RegionType(SCHEME, "GB-CAY");

    // GB Calderdale
    public static final Version2017RegionType GB_CALDERDALE = new Version2017RegionType(SCHEME, "GB-CLD");

    // GB Cambridgeshire
    public static final Version2017RegionType GB_CAMBRIDGESHIRE = new Version2017RegionType(SCHEME, "GB-CAM");

    // GB Camden
    public static final Version2017RegionType GB_CAMDEN = new Version2017RegionType(SCHEME, "GB-CMD");

    // GB Carrickfergus
    public static final Version2017RegionType GB_CARRICKFERGUS = new Version2017RegionType(SCHEME, "GB-CKF");

    // GB Casnewydd Gb-cnw
    public static final Version2017RegionType GB_CASNEWYDD_GB_CNW = new Version2017RegionType(SCHEME, "GB-NWP");

    // GB Castell-nedd Port Talbot Gb-ctl
    public static final Version2017RegionType GB_CASTELL_NEDD_PORT_TALBOT_GB_CTL = new Version2017RegionType(SCHEME, "GB-NTL");

    // GB Castlereagh
    public static final Version2017RegionType GB_CASTLEREAGH = new Version2017RegionType(SCHEME, "GB-CSR");

    // GB Cheshire
    public static final Version2017RegionType GB_CHESHIRE = new Version2017RegionType(SCHEME, "GB-CHS");

    // GB Clackmannanshire
    public static final Version2017RegionType GB_CLACKMANNANSHIRE = new Version2017RegionType(SCHEME, "GB-CLK");

    // GB Coleraine
    public static final Version2017RegionType GB_COLERAINE = new Version2017RegionType(SCHEME, "GB-CLR");

    // GB Conwy
    public static final Version2017RegionType GB_CONWY = new Version2017RegionType(SCHEME, "GB-CWY");

    // GB Cookstown
    public static final Version2017RegionType GB_COOKSTOWN = new Version2017RegionType(SCHEME, "GB-CKT");

    // GB Cornwall
    public static final Version2017RegionType GB_CORNWALL = new Version2017RegionType(SCHEME, "GB-CON");

    // GB Coventry
    public static final Version2017RegionType GB_COVENTRY = new Version2017RegionType(SCHEME, "GB-COV");

    // GB Craigavon
    public static final Version2017RegionType GB_CRAIGAVON = new Version2017RegionType(SCHEME, "GB-CGV");

    // GB Croydon
    public static final Version2017RegionType GB_CROYDON = new Version2017RegionType(SCHEME, "GB-CRY");

    // GB Cumbria
    public static final Version2017RegionType GB_CUMBRIA = new Version2017RegionType(SCHEME, "GB-CMA");

    // GB Darlington
    public static final Version2017RegionType GB_DARLINGTON = new Version2017RegionType(SCHEME, "GB-DAL");

    // GB Derby
    public static final Version2017RegionType GB_DERBY = new Version2017RegionType(SCHEME, "GB-DER");

    // GB Derbyshire
    public static final Version2017RegionType GB_DERBYSHIRE = new Version2017RegionType(SCHEME, "GB-DBY");

    // GB Derry
    public static final Version2017RegionType GB_DERRY = new Version2017RegionType(SCHEME, "GB-DRY");

    // GB Devon
    public static final Version2017RegionType GB_DEVON = new Version2017RegionType(SCHEME, "GB-DEV");

    // GB Doncaster
    public static final Version2017RegionType GB_DONCASTER = new Version2017RegionType(SCHEME, "GB-DNC");

    // GB Dorset
    public static final Version2017RegionType GB_DORSET = new Version2017RegionType(SCHEME, "GB-DOR");

    // GB Down
    public static final Version2017RegionType GB_DOWN = new Version2017RegionType(SCHEME, "GB-DOW");

    // GB Dudley
    public static final Version2017RegionType GB_DUDLEY = new Version2017RegionType(SCHEME, "GB-DUD");

    // GB Dumfries And Galloway
    public static final Version2017RegionType GB_DUMFRIES_AND_GALLOWAY = new Version2017RegionType(SCHEME, "GB-DGY");

    // GB Dundee City
    public static final Version2017RegionType GB_DUNDEE_CITY = new Version2017RegionType(SCHEME, "GB-DND");

    // GB Dungannon
    public static final Version2017RegionType GB_DUNGANNON = new Version2017RegionType(SCHEME, "GB-DGN");

    // GB Durham
    public static final Version2017RegionType GB_DURHAM = new Version2017RegionType(SCHEME, "GB-DUR");

    // GB Ealing
    public static final Version2017RegionType GB_EALING = new Version2017RegionType(SCHEME, "GB-EAL");

    // GB East Ayrshire
    public static final Version2017RegionType GB_EAST_AYRSHIRE = new Version2017RegionType(SCHEME, "GB-EAY");

    // GB East Dunbartonshire
    public static final Version2017RegionType GB_EAST_DUNBARTONSHIRE = new Version2017RegionType(SCHEME, "GB-EDU");

    // GB East Lothian
    public static final Version2017RegionType GB_EAST_LOTHIAN = new Version2017RegionType(SCHEME, "GB-ELN");

    // GB East Renfrewshire
    public static final Version2017RegionType GB_EAST_RENFREWSHIRE = new Version2017RegionType(SCHEME, "GB-ERW");

    // GB East Riding Of Yorkshire
    public static final Version2017RegionType GB_EAST_RIDING_OF_YORKSHIRE = new Version2017RegionType(SCHEME, "GB-ERY");

    // GB East Sussex
    public static final Version2017RegionType GB_EAST_SUSSEX = new Version2017RegionType(SCHEME, "GB-ESX");

    // GB Edinburgh, City Of
    public static final Version2017RegionType GB_EDINBURGH_CITY_OF = new Version2017RegionType(SCHEME, "GB-EDH");

    // GB Eilean Siar
    public static final Version2017RegionType GB_EILEAN_SIAR = new Version2017RegionType(SCHEME, "GB-ELS");

    // GB Enfield
    public static final Version2017RegionType GB_ENFIELD = new Version2017RegionType(SCHEME, "GB-ENF");

    // GB Essex
    public static final Version2017RegionType GB_ESSEX = new Version2017RegionType(SCHEME, "GB-ESS");

    // GB Falkirk
    public static final Version2017RegionType GB_FALKIRK = new Version2017RegionType(SCHEME, "GB-FAL");

    // GB Fermanagh
    public static final Version2017RegionType GB_FERMANAGH = new Version2017RegionType(SCHEME, "GB-FER");

    // GB Fife
    public static final Version2017RegionType GB_FIFE = new Version2017RegionType(SCHEME, "GB-FIF");

    // GB Gateshead
    public static final Version2017RegionType GB_GATESHEAD = new Version2017RegionType(SCHEME, "GB-GAT");

    // GB Glasgow City
    public static final Version2017RegionType GB_GLASGOW_CITY = new Version2017RegionType(SCHEME, "GB-GLG");

    // GB Gloucestershire
    public static final Version2017RegionType GB_GLOUCESTERSHIRE = new Version2017RegionType(SCHEME, "GB-GLS");

    // GB Greenwich
    public static final Version2017RegionType GB_GREENWICH = new Version2017RegionType(SCHEME, "GB-GRE");

    // GB Guernesey
    public static final Version2017RegionType GB_GUERNESEY = new Version2017RegionType(SCHEME, "GB-GSY");

    // GB Gwynedd
    public static final Version2017RegionType GB_GWYNEDD = new Version2017RegionType(SCHEME, "GB-GWN");

    // GB Hackney
    public static final Version2017RegionType GB_HACKNEY = new Version2017RegionType(SCHEME, "GB-HCK");

    // GB Halton
    public static final Version2017RegionType GB_HALTON = new Version2017RegionType(SCHEME, "GB-HAL");

    // GB Hammersmith And Fulham
    public static final Version2017RegionType GB_HAMMERSMITH_AND_FULHAM = new Version2017RegionType(SCHEME, "GB-HMF");

    // GB Hampshire
    public static final Version2017RegionType GB_HAMPSHIRE = new Version2017RegionType(SCHEME, "GB-HAM");

    // GB Haringey
    public static final Version2017RegionType GB_HARINGEY = new Version2017RegionType(SCHEME, "GB-HRY");

    // GB Harrow
    public static final Version2017RegionType GB_HARROW = new Version2017RegionType(SCHEME, "GB-HRW");

    // GB Hartlepool
    public static final Version2017RegionType GB_HARTLEPOOL = new Version2017RegionType(SCHEME, "GB-HPL");

    // GB Havering
    public static final Version2017RegionType GB_HAVERING = new Version2017RegionType(SCHEME, "GB-HAV");

    // GB Herefordshire, County Of
    public static final Version2017RegionType GB_HEREFORDSHIRE_COUNTY_OF = new Version2017RegionType(SCHEME, "GB-HEF");

    // GB Hertfordshire
    public static final Version2017RegionType GB_HERTFORDSHIRE = new Version2017RegionType(SCHEME, "GB-HRT");

    // GB Highland
    public static final Version2017RegionType GB_HIGHLAND = new Version2017RegionType(SCHEME, "GB-HLD");

    // GB Hillingdon
    public static final Version2017RegionType GB_HILLINGDON = new Version2017RegionType(SCHEME, "GB-HIL");

    // GB Hounslow
    public static final Version2017RegionType GB_HOUNSLOW = new Version2017RegionType(SCHEME, "GB-HNS");

    // GB Inverclyde
    public static final Version2017RegionType GB_INVERCLYDE = new Version2017RegionType(SCHEME, "GB-IVC");

    // GB Isles Of Scilly
    public static final Version2017RegionType GB_ISLES_OF_SCILLY = new Version2017RegionType(SCHEME, "GB-IOS");

    // GB Isle Of Anglesey
    public static final Version2017RegionType GB_ISLE_OF_ANGLESEY = new Version2017RegionType(SCHEME, "GB-AGY");

    // GB Isle Of Wight
    public static final Version2017RegionType GB_ISLE_OF_WIGHT = new Version2017RegionType(SCHEME, "GB-IOW");

    // GB Islington
    public static final Version2017RegionType GB_ISLINGTON = new Version2017RegionType(SCHEME, "GB-ISL");

    // GB Jersey
    public static final Version2017RegionType GB_JERSEY = new Version2017RegionType(SCHEME, "GB-JSY");

    // GB Kensington And Chelsea
    public static final Version2017RegionType GB_KENSINGTON_AND_CHELSEA = new Version2017RegionType(SCHEME, "GB-KEC");

    // GB Kent
    public static final Version2017RegionType GB_KENT = new Version2017RegionType(SCHEME, "GB-KEN");

    // GB Kingston Upon Hull, City Of
    public static final Version2017RegionType GB_KINGSTON_UPON_HULL_CITY_OF = new Version2017RegionType(SCHEME, "GB-KHL");

    // GB Kingston Upon Thames
    public static final Version2017RegionType GB_KINGSTON_UPON_THAMES = new Version2017RegionType(SCHEME, "GB-KTT");

    // GB Kirklees
    public static final Version2017RegionType GB_KIRKLEES = new Version2017RegionType(SCHEME, "GB-KIR");

    // GB Knowsley
    public static final Version2017RegionType GB_KNOWSLEY = new Version2017RegionType(SCHEME, "GB-KWL");

    // GB Lambeth
    public static final Version2017RegionType GB_LAMBETH = new Version2017RegionType(SCHEME, "GB-LBH");

    // GB Lancashire
    public static final Version2017RegionType GB_LANCASHIRE = new Version2017RegionType(SCHEME, "GB-LAN");

    // GB Larne
    public static final Version2017RegionType GB_LARNE = new Version2017RegionType(SCHEME, "GB-LRN");

    // GB Leeds
    public static final Version2017RegionType GB_LEEDS = new Version2017RegionType(SCHEME, "GB-LDS");

    // GB Leicester
    public static final Version2017RegionType GB_LEICESTER = new Version2017RegionType(SCHEME, "GB-LCE");

    // GB Leicestershire
    public static final Version2017RegionType GB_LEICESTERSHIRE = new Version2017RegionType(SCHEME, "GB-LEC");

    // GB Lewisham
    public static final Version2017RegionType GB_LEWISHAM = new Version2017RegionType(SCHEME, "GB-LEW");

    // GB Limavady
    public static final Version2017RegionType GB_LIMAVADY = new Version2017RegionType(SCHEME, "GB-LMV");

    // GB Lincolnshire
    public static final Version2017RegionType GB_LINCOLNSHIRE = new Version2017RegionType(SCHEME, "GB-LIN");

    // GB Lisburn
    public static final Version2017RegionType GB_LISBURN = new Version2017RegionType(SCHEME, "GB-LSB");

    // GB Liverpool
    public static final Version2017RegionType GB_LIVERPOOL = new Version2017RegionType(SCHEME, "GB-LIV");

    // GB London, City Of
    public static final Version2017RegionType GB_LONDON_CITY_OF = new Version2017RegionType(SCHEME, "GB-LND");

    // GB Luton
    public static final Version2017RegionType GB_LUTON = new Version2017RegionType(SCHEME, "GB-LUT");

    // GB Magherafelt
    public static final Version2017RegionType GB_MAGHERAFELT = new Version2017RegionType(SCHEME, "GB-MFT");

    // GB Manchester, GB
    public static final Version2017RegionType GB_MANCHESTER = new Version2017RegionType(SCHEME, "GB-MAN");

    // GB Medway
    public static final Version2017RegionType GB_MEDWAY = new Version2017RegionType(SCHEME, "GB-MDW");

    // GB Merthyr Tudful Gb-mtu
    public static final Version2017RegionType GB_MERTHYR_TUDFUL_GB_MTU = new Version2017RegionType(SCHEME, "GB-MTY");

    // GB Merton
    public static final Version2017RegionType GB_MERTON = new Version2017RegionType(SCHEME, "GB-MRT");

    // GB Middlesbrough
    public static final Version2017RegionType GB_MIDDLESBROUGH = new Version2017RegionType(SCHEME, "GB-MDB");

    // GB Midlothian
    public static final Version2017RegionType GB_MIDLOTHIAN = new Version2017RegionType(SCHEME, "GB-MLN");

    // GB Milton Keynes
    public static final Version2017RegionType GB_MILTON_KEYNES = new Version2017RegionType(SCHEME, "GB-MIK");

    // GB Moray
    public static final Version2017RegionType GB_MORAY = new Version2017RegionType(SCHEME, "GB-MRY");

    // GB Moyle
    public static final Version2017RegionType GB_MOYLE = new Version2017RegionType(SCHEME, "GB-MYL");

    // GB Newcastle Upon Tyne
    public static final Version2017RegionType GB_NEWCASTLE_UPON_TYNE = new Version2017RegionType(SCHEME, "GB-NET");

    // GB Newham
    public static final Version2017RegionType GB_NEWHAM = new Version2017RegionType(SCHEME, "GB-NWM");

    // GB Newry And Mourne
    public static final Version2017RegionType GB_NEWRY_AND_MOURNE = new Version2017RegionType(SCHEME, "GB-NYM");

    // GB Newtownabbey
    public static final Version2017RegionType GB_NEWTOWNABBEY = new Version2017RegionType(SCHEME, "GB-NTA");

    // GB Norfolk
    public static final Version2017RegionType GB_NORFOLK = new Version2017RegionType(SCHEME, "GB-NFK");

    // GB Northamptonshire
    public static final Version2017RegionType GB_NORTHAMPTONSHIRE = new Version2017RegionType(SCHEME, "GB-NTH");

    // GB Northumberland
    public static final Version2017RegionType GB_NORTHUMBERLAND = new Version2017RegionType(SCHEME, "GB-NBL");

    // GB North Ayrshire
    public static final Version2017RegionType GB_NORTH_AYRSHIRE = new Version2017RegionType(SCHEME, "GB-NAY");

    // GB North Down
    public static final Version2017RegionType GB_NORTH_DOWN = new Version2017RegionType(SCHEME, "GB-NDN");

    // GB North East Lincolnshire
    public static final Version2017RegionType GB_NORTH_EAST_LINCOLNSHIRE = new Version2017RegionType(SCHEME, "GB-NEL");

    // GB North Lanarkshire
    public static final Version2017RegionType GB_NORTH_LANARKSHIRE = new Version2017RegionType(SCHEME, "GB-NLK");

    // GB North Lincolnshire
    public static final Version2017RegionType GB_NORTH_LINCOLNSHIRE = new Version2017RegionType(SCHEME, "GB-NLN");

    // GB North Somerset
    public static final Version2017RegionType GB_NORTH_SOMERSET = new Version2017RegionType(SCHEME, "GB-NSM");

    // GB North Tyneside
    public static final Version2017RegionType GB_NORTH_TYNESIDE = new Version2017RegionType(SCHEME, "GB-NTY");

    // GB North Yorkshire
    public static final Version2017RegionType GB_NORTH_YORKSHIRE = new Version2017RegionType(SCHEME, "GB-NYK");

    // GB Nottingham
    public static final Version2017RegionType GB_NOTTINGHAM = new Version2017RegionType(SCHEME, "GB-NGM");

    // GB Nottinghamshire
    public static final Version2017RegionType GB_NOTTINGHAMSHIRE = new Version2017RegionType(SCHEME, "GB-NTT");

    // GB Oldham
    public static final Version2017RegionType GB_OLDHAM = new Version2017RegionType(SCHEME, "GB-OLD");

    // GB Omagh
    public static final Version2017RegionType GB_OMAGH = new Version2017RegionType(SCHEME, "GB-OMH");

    // GB Orkney Islands
    public static final Version2017RegionType GB_ORKNEY_ISLANDS = new Version2017RegionType(SCHEME, "GB-ORK");

    // GB Oxfordshire
    public static final Version2017RegionType GB_OXFORDSHIRE = new Version2017RegionType(SCHEME, "GB-OXF");

    // GB Pen-y-bont Ar Ogwr Gb-pog
    public static final Version2017RegionType GB_PEN_Y_BONT_AR_OGWR_GB_POG = new Version2017RegionType(SCHEME, "GB-BGE");

    // GB Perth And Kinross
    public static final Version2017RegionType GB_PERTH_AND_KINROSS = new Version2017RegionType(SCHEME, "GB-PKN");

    // GB Peterborough
    public static final Version2017RegionType GB_PETERBOROUGH = new Version2017RegionType(SCHEME, "GB-PTE");

    // GB Plymouth
    public static final Version2017RegionType GB_PLYMOUTH = new Version2017RegionType(SCHEME, "GB-PLY");

    // GB Poole
    public static final Version2017RegionType GB_POOLE = new Version2017RegionType(SCHEME, "GB-POL");

    // GB Portsmouth
    public static final Version2017RegionType GB_PORTSMOUTH = new Version2017RegionType(SCHEME, "GB-POR");

    // GB Powys
    public static final Version2017RegionType GB_POWYS = new Version2017RegionType(SCHEME, "GB-POW");

    // GB Reading
    public static final Version2017RegionType GB_READING = new Version2017RegionType(SCHEME, "GB-RDG");

    // GB Redbridge
    public static final Version2017RegionType GB_REDBRIDGE = new Version2017RegionType(SCHEME, "GB-RDB");

    // GB Redcar And Cleveland
    public static final Version2017RegionType GB_REDCAR_AND_CLEVELAND = new Version2017RegionType(SCHEME, "GB-RCC");

    // GB Renfrewshire
    public static final Version2017RegionType GB_RENFREWSHIRE = new Version2017RegionType(SCHEME, "GB-RFW");

    // GB Rhondda, Cynon,taf
    public static final Version2017RegionType GB_RHONDDA_CYNONTAF = new Version2017RegionType(SCHEME, "GB-RCT");

    // GB Richmond Upon Thames
    public static final Version2017RegionType GB_RICHMOND_UPON_THAMES = new Version2017RegionType(SCHEME, "GB-RIC");

    // GB Rochdale
    public static final Version2017RegionType GB_ROCHDALE = new Version2017RegionType(SCHEME, "GB-RCH");

    // GB Rotherham
    public static final Version2017RegionType GB_ROTHERHAM = new Version2017RegionType(SCHEME, "GB-ROT");

    // GB Rutland
    public static final Version2017RegionType GB_RUTLAND = new Version2017RegionType(SCHEME, "GB-RUT");

    // GB Salford
    public static final Version2017RegionType GB_SALFORD = new Version2017RegionType(SCHEME, "GB-SLF");

    // GB Sandwell
    public static final Version2017RegionType GB_SANDWELL = new Version2017RegionType(SCHEME, "GB-SAW");

    // GB Scottish Borders, The
    public static final Version2017RegionType GB_SCOTTISH_BORDERS_THE = new Version2017RegionType(SCHEME, "GB-SCB");

    // GB Sefton
    public static final Version2017RegionType GB_SEFTON = new Version2017RegionType(SCHEME, "GB-SFT");

    // GB Sheffield
    public static final Version2017RegionType GB_SHEFFIELD = new Version2017RegionType(SCHEME, "GB-SHF");

    // GB Shetland Islands
    public static final Version2017RegionType GB_SHETLAND_ISLANDS = new Version2017RegionType(SCHEME, "GB-ZET");

    // GB Shropshire
    public static final Version2017RegionType GB_SHROPSHIRE = new Version2017RegionType(SCHEME, "GB-SHR");

    // GB Sir Benfro Gb-bnf
    public static final Version2017RegionType GB_SIR_BENFRO_GB_BNF = new Version2017RegionType(SCHEME, "GB-PEM");

    // GB Sir Ceredigion
    public static final Version2017RegionType GB_SIR_CEREDIGION = new Version2017RegionType(SCHEME, "GB-CGN");

    // GB Sir Ddinbych Gb-ddb
    public static final Version2017RegionType GB_SIR_DDINBYCH_GB_DDB = new Version2017RegionType(SCHEME, "GB-DEN");

    // GB Sir Fynwy Gb-fyn
    public static final Version2017RegionType GB_SIR_FYNWY_GB_FYN = new Version2017RegionType(SCHEME, "GB-MON");

    // GB Sir Gaerfyrddin Gb-gfy
    public static final Version2017RegionType GB_SIR_GAERFYRDDIN_GB_GFY = new Version2017RegionType(SCHEME, "GB-CMN");

    // GB Sir Y Fflint Gb-ffl
    public static final Version2017RegionType GB_SIR_Y_FFLINT_GB_FFL = new Version2017RegionType(SCHEME, "GB-FLN");

    // GB Slough
    public static final Version2017RegionType GB_SLOUGH = new Version2017RegionType(SCHEME, "GB-SLG");

    // GB Solihull
    public static final Version2017RegionType GB_SOLIHULL = new Version2017RegionType(SCHEME, "GB-SOL");

    // GB Somerset
    public static final Version2017RegionType GB_SOMERSET = new Version2017RegionType(SCHEME, "GB-SOM");

    // GB Southampton
    public static final Version2017RegionType GB_SOUTHAMPTON = new Version2017RegionType(SCHEME, "GB-STH");

    // GB Southend-on-sea
    public static final Version2017RegionType GB_SOUTHEND_ON_SEA = new Version2017RegionType(SCHEME, "GB-SOS");

    // GB Southwark
    public static final Version2017RegionType GB_SOUTHWARK = new Version2017RegionType(SCHEME, "GB-SWK");

    // GB South Ayrshire
    public static final Version2017RegionType GB_SOUTH_AYRSHIRE = new Version2017RegionType(SCHEME, "GB-SAY");

    // GB South Gloucestershire
    public static final Version2017RegionType GB_SOUTH_GLOUCESTERSHIRE = new Version2017RegionType(SCHEME, "GB-SGC");

    // GB South Lanarkshire
    public static final Version2017RegionType GB_SOUTH_LANARKSHIRE = new Version2017RegionType(SCHEME, "GB-SLK");

    // GB South Tyneside
    public static final Version2017RegionType GB_SOUTH_TYNESIDE = new Version2017RegionType(SCHEME, "GB-STY");

    // GB Staffordshire
    public static final Version2017RegionType GB_STAFFORDSHIRE = new Version2017RegionType(SCHEME, "GB-STS");

    // GB Stirling
    public static final Version2017RegionType GB_STIRLING = new Version2017RegionType(SCHEME, "GB-STG");

    // GB Stockport
    public static final Version2017RegionType GB_STOCKPORT = new Version2017RegionType(SCHEME, "GB-SKP");

    // GB Stockton-on-tees
    public static final Version2017RegionType GB_STOCKTON_ON_TEES = new Version2017RegionType(SCHEME, "GB-STT");

    // GB Stoke-on-trent
    public static final Version2017RegionType GB_STOKE_ON_TRENT = new Version2017RegionType(SCHEME, "GB-STE");

    // GB Strabane
    public static final Version2017RegionType GB_STRABANE = new Version2017RegionType(SCHEME, "GB-STB");

    // GB St. Helens
    public static final Version2017RegionType GB_ST_HELENS = new Version2017RegionType(SCHEME, "GB-SHN");

    // GB Suffolk
    public static final Version2017RegionType GB_SUFFOLK = new Version2017RegionType(SCHEME, "GB-SFK");

    // GB Sunderland
    public static final Version2017RegionType GB_SUNDERLAND = new Version2017RegionType(SCHEME, "GB-SND");

    // GB Surrey
    public static final Version2017RegionType GB_SURREY = new Version2017RegionType(SCHEME, "GB-SRY");

    // GB Sutton
    public static final Version2017RegionType GB_SUTTON = new Version2017RegionType(SCHEME, "GB-STN");

    // GB Swindon
    public static final Version2017RegionType GB_SWINDON = new Version2017RegionType(SCHEME, "GB-SWD");

    // GB Tameside
    public static final Version2017RegionType GB_TAMESIDE = new Version2017RegionType(SCHEME, "GB-TAM");

    // GB Telford And Wrekin
    public static final Version2017RegionType GB_TELFORD_AND_WREKIN = new Version2017RegionType(SCHEME, "GB-TFW");

    // GB Thurrock
    public static final Version2017RegionType GB_THURROCK = new Version2017RegionType(SCHEME, "GB-THR");

    // GB Torbay
    public static final Version2017RegionType GB_TORBAY = new Version2017RegionType(SCHEME, "GB-TOB");

    // GB Tor-faen
    public static final Version2017RegionType GB_TOR_FAEN = new Version2017RegionType(SCHEME, "GB-TOF");

    // GB Tower Hamlets
    public static final Version2017RegionType GB_TOWER_HAMLETS = new Version2017RegionType(SCHEME, "GB-TWH");

    // GB Trafford
    public static final Version2017RegionType GB_TRAFFORD = new Version2017RegionType(SCHEME, "GB-TRF");

    // GB Wakefield
    public static final Version2017RegionType GB_WAKEFIELD = new Version2017RegionType(SCHEME, "GB-WKF");

    // GB Walsall
    public static final Version2017RegionType GB_WALSALL = new Version2017RegionType(SCHEME, "GB-WLL");

    // GB Waltham Forest
    public static final Version2017RegionType GB_WALTHAM_FOREST = new Version2017RegionType(SCHEME, "GB-WFT");

    // GB Wandsworth
    public static final Version2017RegionType GB_WANDSWORTH = new Version2017RegionType(SCHEME, "GB-WND");

    // GB Warrington
    public static final Version2017RegionType GB_WARRINGTON = new Version2017RegionType(SCHEME, "GB-WRT");

    // GB Warwickshire
    public static final Version2017RegionType GB_WARWICKSHIRE = new Version2017RegionType(SCHEME, "GB-WAR");

    // GB Westminster
    public static final Version2017RegionType GB_WESTMINSTER = new Version2017RegionType(SCHEME, "GB-WSM");

    // GB West Berkshire
    public static final Version2017RegionType GB_WEST_BERKSHIRE = new Version2017RegionType(SCHEME, "GB-WBK");

    // GB West Dunbartonshire
    public static final Version2017RegionType GB_WEST_DUNBARTONSHIRE = new Version2017RegionType(SCHEME, "GB-WDU");

    // GB West Lothian
    public static final Version2017RegionType GB_WEST_LOTHIAN = new Version2017RegionType(SCHEME, "GB-WLN");

    // GB West Sussex
    public static final Version2017RegionType GB_WEST_SUSSEX = new Version2017RegionType(SCHEME, "GB-WSX");

    // GB Wigan
    public static final Version2017RegionType GB_WIGAN = new Version2017RegionType(SCHEME, "GB-WGN");

    // GB Wiltshire
    public static final Version2017RegionType GB_WILTSHIRE = new Version2017RegionType(SCHEME, "GB-WIL");

    // GB Windsor And Maidenhead
    public static final Version2017RegionType GB_WINDSOR_AND_MAIDENHEAD = new Version2017RegionType(SCHEME, "GB-WNM");

    // GB Wirral
    public static final Version2017RegionType GB_WIRRAL = new Version2017RegionType(SCHEME, "GB-WRL");

    // GB Wokingham
    public static final Version2017RegionType GB_WOKINGHAM = new Version2017RegionType(SCHEME, "GB-WOK");

    // GB Wolverhampton
    public static final Version2017RegionType GB_WOLVERHAMPTON = new Version2017RegionType(SCHEME, "GB-WLV");

    // GB Worcestershire
    public static final Version2017RegionType GB_WORCESTERSHIRE = new Version2017RegionType(SCHEME, "GB-WOR");

    // GB Wrecsam Gb-wrc
    public static final Version2017RegionType GB_WRECSAM_GB_WRC = new Version2017RegionType(SCHEME, "GB-WRX");

    // GB York
    public static final Version2017RegionType GB_YORK = new Version2017RegionType(SCHEME, "GB-YOR");

    // GE Abkhazia
    public static final Version2017RegionType GE_ABKHAZIA = new Version2017RegionType(SCHEME, "GE-AB");

    // GE Ajaria
    public static final Version2017RegionType GE_AJARIA = new Version2017RegionType(SCHEME, "GE-AJ");

    // GE And
    public static final Version2017RegionType GE_AND = new Version2017RegionType(SCHEME, "GE-RL");

    // GE Guria
    public static final Version2017RegionType GE_GURIA = new Version2017RegionType(SCHEME, "GE-GU");

    // GE Imereti
    public static final Version2017RegionType GE_IMERETI = new Version2017RegionType(SCHEME, "GE-IM");

    // GE Kakheti
    public static final Version2017RegionType GE_KAKHETI = new Version2017RegionType(SCHEME, "GE-KA");

    // GE Kvemo Kartli
    public static final Version2017RegionType GE_KVEMO_KARTLI = new Version2017RegionType(SCHEME, "GE-KK");

    // GE Mtskheta-mtianeti
    public static final Version2017RegionType GE_MTSKHETA_MTIANETI = new Version2017RegionType(SCHEME, "GE-MM");

    // GE Samegrelo-zemo Svaneti
    public static final Version2017RegionType GE_SAMEGRELO_ZEMO_SVANETI = new Version2017RegionType(SCHEME, "GE-SZ");

    // GE Samtskhe-javakheti
    public static final Version2017RegionType GE_SAMTSKHE_JAVAKHETI = new Version2017RegionType(SCHEME, "GE-SJ");

    // GE Shida Kartli
    public static final Version2017RegionType GE_SHIDA_KARTLI = new Version2017RegionType(SCHEME, "GE-SK");

    // GE Tbilisi
    public static final Version2017RegionType GE_TBILISI = new Version2017RegionType(SCHEME, "GE-TB");

    // GH Ashanti
    public static final Version2017RegionType GH_ASHANTI = new Version2017RegionType(SCHEME, "GH-AH");

    // GH Brong-ahafo
    public static final Version2017RegionType GH_BRONG_AHAFO = new Version2017RegionType(SCHEME, "GH-BA");

    // GH Central
    public static final Version2017RegionType GH_CENTRAL = new Version2017RegionType(SCHEME, "GH-CP");

    // GH Eastern, GH
    public static final Version2017RegionType GH_EASTERN = new Version2017RegionType(SCHEME, "GH-EP");

    // GH Greater Accra
    public static final Version2017RegionType GH_GREATER_ACCRA = new Version2017RegionType(SCHEME, "GH-AA");

    // GH Northern, GH
    public static final Version2017RegionType GH_NORTHERN = new Version2017RegionType(SCHEME, "GH-NP");

    // GH Upper East
    public static final Version2017RegionType GH_UPPER_EAST = new Version2017RegionType(SCHEME, "GH-UE");

    // GH Upper West
    public static final Version2017RegionType GH_UPPER_WEST = new Version2017RegionType(SCHEME, "GH-UW");

    // GH Volta
    public static final Version2017RegionType GH_VOLTA = new Version2017RegionType(SCHEME, "GH-TV");

    // GH Western, GH
    public static final Version2017RegionType GH_WESTERN = new Version2017RegionType(SCHEME, "GH-WP");

    // GM Banjul
    public static final Version2017RegionType GM_BANJUL = new Version2017RegionType(SCHEME, "GM-B");

    // GM Lower River
    public static final Version2017RegionType GM_LOWER_RIVER = new Version2017RegionType(SCHEME, "GM-L");

    // GM Maccarthy Island
    public static final Version2017RegionType GM_MACCARTHY_ISLAND = new Version2017RegionType(SCHEME, "GM-M");

    // GM North Bank
    public static final Version2017RegionType GM_NORTH_BANK = new Version2017RegionType(SCHEME, "GM-N");

    // GM Upper River
    public static final Version2017RegionType GM_UPPER_RIVER = new Version2017RegionType(SCHEME, "GM-U");

    // GM Western, GM
    public static final Version2017RegionType GM_WESTERN = new Version2017RegionType(SCHEME, "GM-W");

    // GN Beyla
    public static final Version2017RegionType GN_BEYLA = new Version2017RegionType(SCHEME, "GN-BE");

    // GN Boffa
    public static final Version2017RegionType GN_BOFFA = new Version2017RegionType(SCHEME, "GN-BF");

    // GN Boke
    public static final Version2017RegionType GN_BOKE = new Version2017RegionType(SCHEME, "GN-BK");

    // GN Coyah
    public static final Version2017RegionType GN_COYAH = new Version2017RegionType(SCHEME, "GN-CO");

    // GN Dabola
    public static final Version2017RegionType GN_DABOLA = new Version2017RegionType(SCHEME, "GN-DB");

    // GN Dalaba
    public static final Version2017RegionType GN_DALABA = new Version2017RegionType(SCHEME, "GN-DL");

    // GN Dinguiraye
    public static final Version2017RegionType GN_DINGUIRAYE = new Version2017RegionType(SCHEME, "GN-DI");

    // GN Dubreka
    public static final Version2017RegionType GN_DUBREKA = new Version2017RegionType(SCHEME, "GN-DU");

    // GN Faranah
    public static final Version2017RegionType GN_FARANAH = new Version2017RegionType(SCHEME, "GN-FA");

    // GN Forecariah
    public static final Version2017RegionType GN_FORECARIAH = new Version2017RegionType(SCHEME, "GN-FO");

    // GN Fria
    public static final Version2017RegionType GN_FRIA = new Version2017RegionType(SCHEME, "GN-FR");

    // GN Gaoual
    public static final Version2017RegionType GN_GAOUAL = new Version2017RegionType(SCHEME, "GN-GA");

    // GN Guekedou
    public static final Version2017RegionType GN_GUEKEDOU = new Version2017RegionType(SCHEME, "GN-GU");

    // GN Kankan
    public static final Version2017RegionType GN_KANKAN = new Version2017RegionType(SCHEME, "GN-KA");

    // GN Kerouane
    public static final Version2017RegionType GN_KEROUANE = new Version2017RegionType(SCHEME, "GN-KE");

    // GN Kindia
    public static final Version2017RegionType GN_KINDIA = new Version2017RegionType(SCHEME, "GN-KD");

    // GN Kissidougou
    public static final Version2017RegionType GN_KISSIDOUGOU = new Version2017RegionType(SCHEME, "GN-KS");

    // GN Koubia
    public static final Version2017RegionType GN_KOUBIA = new Version2017RegionType(SCHEME, "GN-KB");

    // GN Koundara
    public static final Version2017RegionType GN_KOUNDARA = new Version2017RegionType(SCHEME, "GN-KN");

    // GN Kouroussa
    public static final Version2017RegionType GN_KOUROUSSA = new Version2017RegionType(SCHEME, "GN-KO");

    // GN Labe
    public static final Version2017RegionType GN_LABE = new Version2017RegionType(SCHEME, "GN-LA");

    // GN Lelouma
    public static final Version2017RegionType GN_LELOUMA = new Version2017RegionType(SCHEME, "GN-LE");

    // GN Lola
    public static final Version2017RegionType GN_LOLA = new Version2017RegionType(SCHEME, "GN-LO");

    // GN Macenta
    public static final Version2017RegionType GN_MACENTA = new Version2017RegionType(SCHEME, "GN-MC");

    // GN Mali
    public static final Version2017RegionType GN_MALI = new Version2017RegionType(SCHEME, "GN-ML");

    // GN Mamou
    public static final Version2017RegionType GN_MAMOU = new Version2017RegionType(SCHEME, "GN-MM");

    // GN Mandiana
    public static final Version2017RegionType GN_MANDIANA = new Version2017RegionType(SCHEME, "GN-MD");

    // GN Nzerekore
    public static final Version2017RegionType GN_NZEREKORE = new Version2017RegionType(SCHEME, "GN-NZ");

    // GN Pita
    public static final Version2017RegionType GN_PITA = new Version2017RegionType(SCHEME, "GN-PI");

    // GN Siguiri
    public static final Version2017RegionType GN_SIGUIRI = new Version2017RegionType(SCHEME, "GN-SI");

    // GN Telimele
    public static final Version2017RegionType GN_TELIMELE = new Version2017RegionType(SCHEME, "GN-TE");

    // GN Tougue
    public static final Version2017RegionType GN_TOUGUE = new Version2017RegionType(SCHEME, "GN-TO");

    // GN Yomou
    public static final Version2017RegionType GN_YOMOU = new Version2017RegionType(SCHEME, "GN-YO");

    // GQ Annobon
    public static final Version2017RegionType GQ_ANNOBON = new Version2017RegionType(SCHEME, "GQ-AN");

    // GQ Bioko Norte
    public static final Version2017RegionType GQ_BIOKO_NORTE = new Version2017RegionType(SCHEME, "GQ-BN");

    // GQ Bioko Sur
    public static final Version2017RegionType GQ_BIOKO_SUR = new Version2017RegionType(SCHEME, "GQ-BS");

    // GQ Centro Sur
    public static final Version2017RegionType GQ_CENTRO_SUR = new Version2017RegionType(SCHEME, "GQ-CS");

    // GQ Kie-ntem
    public static final Version2017RegionType GQ_KIE_NTEM = new Version2017RegionType(SCHEME, "GQ-KN");

    // GQ Litoral
    public static final Version2017RegionType GQ_LITORAL = new Version2017RegionType(SCHEME, "GQ-LI");

    // GQ Region Continental
    public static final Version2017RegionType GQ_REGION_CONTINENTAL = new Version2017RegionType(SCHEME, "GQ-C");

    // GQ Region Insular
    public static final Version2017RegionType GQ_REGION_INSULAR = new Version2017RegionType(SCHEME, "GQ-I");

    // GQ Wele-nzas
    public static final Version2017RegionType GQ_WELE_NZAS = new Version2017RegionType(SCHEME, "GQ-WN");

    // GR Achaia
    public static final Version2017RegionType GR_ACHAIA = new Version2017RegionType(SCHEME, "GR-13");

    // GR Agio Oros
    public static final Version2017RegionType GR_AGIO_OROS = new Version2017RegionType(SCHEME, "GR-69");

    // GR Aitolia-akarnania
    public static final Version2017RegionType GR_AITOLIA_AKARNANIA = new Version2017RegionType(SCHEME, "GR-01");

    // GR Argolis
    public static final Version2017RegionType GR_ARGOLIS = new Version2017RegionType(SCHEME, "GR-11");

    // GR Arkadia
    public static final Version2017RegionType GR_ARKADIA = new Version2017RegionType(SCHEME, "GR-12");

    // GR Arta
    public static final Version2017RegionType GR_ARTA = new Version2017RegionType(SCHEME, "GR-31");

    // GR Attiki
    public static final Version2017RegionType GR_ATTIKI = new Version2017RegionType(SCHEME, "GR-A1");

    // GR Chalkidiki
    public static final Version2017RegionType GR_CHALKIDIKI = new Version2017RegionType(SCHEME, "GR-64");

    // GR Chania
    public static final Version2017RegionType GR_CHANIA = new Version2017RegionType(SCHEME, "GR-94");

    // GR Chios
    public static final Version2017RegionType GR_CHIOS = new Version2017RegionType(SCHEME, "GR-85");

    // GR Dodekanisos
    public static final Version2017RegionType GR_DODEKANISOS = new Version2017RegionType(SCHEME, "GR-81");

    // GR Drama
    public static final Version2017RegionType GR_DRAMA = new Version2017RegionType(SCHEME, "GR-52");

    // GR Evros
    public static final Version2017RegionType GR_EVROS = new Version2017RegionType(SCHEME, "GR-71");

    // GR Evrytania
    public static final Version2017RegionType GR_EVRYTANIA = new Version2017RegionType(SCHEME, "GR-05");

    // GR Evvoia
    public static final Version2017RegionType GR_EVVOIA = new Version2017RegionType(SCHEME, "GR-04");

    // GR Florina
    public static final Version2017RegionType GR_FLORINA = new Version2017RegionType(SCHEME, "GR-63");

    // GR Fokis
    public static final Version2017RegionType GR_FOKIS = new Version2017RegionType(SCHEME, "GR-07");

    // GR Fthiotis
    public static final Version2017RegionType GR_FTHIOTIS = new Version2017RegionType(SCHEME, "GR-06");

    // GR Grevena
    public static final Version2017RegionType GR_GREVENA = new Version2017RegionType(SCHEME, "GR-51");

    // GR Ileia
    public static final Version2017RegionType GR_ILEIA = new Version2017RegionType(SCHEME, "GR-14");

    // GR Imathia
    public static final Version2017RegionType GR_IMATHIA = new Version2017RegionType(SCHEME, "GR-53");

    // GR Ioannina
    public static final Version2017RegionType GR_IOANNINA = new Version2017RegionType(SCHEME, "GR-33");

    // GR Irakleion
    public static final Version2017RegionType GR_IRAKLEION = new Version2017RegionType(SCHEME, "GR-91");

    // GR Karditsa
    public static final Version2017RegionType GR_KARDITSA = new Version2017RegionType(SCHEME, "GR-41");

    // GR Kastoria
    public static final Version2017RegionType GR_KASTORIA = new Version2017RegionType(SCHEME, "GR-56");

    // GR Kavalla
    public static final Version2017RegionType GR_KAVALLA = new Version2017RegionType(SCHEME, "GR-55");

    // GR Kefallinia
    public static final Version2017RegionType GR_KEFALLINIA = new Version2017RegionType(SCHEME, "GR-23");

    // GR Kerkyra
    public static final Version2017RegionType GR_KERKYRA = new Version2017RegionType(SCHEME, "GR-22");

    // GR Kilkis
    public static final Version2017RegionType GR_KILKIS = new Version2017RegionType(SCHEME, "GR-57");

    // GR Korinthia
    public static final Version2017RegionType GR_KORINTHIA = new Version2017RegionType(SCHEME, "GR-15");

    // GR Kozani
    public static final Version2017RegionType GR_KOZANI = new Version2017RegionType(SCHEME, "GR-58");

    // GR Kyklades
    public static final Version2017RegionType GR_KYKLADES = new Version2017RegionType(SCHEME, "GR-82");

    // GR Lakonia
    public static final Version2017RegionType GR_LAKONIA = new Version2017RegionType(SCHEME, "GR-16");

    // GR Larisa
    public static final Version2017RegionType GR_LARISA = new Version2017RegionType(SCHEME, "GR-42");

    // GR Lasithion
    public static final Version2017RegionType GR_LASITHION = new Version2017RegionType(SCHEME, "GR-92");

    // GR Lefkas
    public static final Version2017RegionType GR_LEFKAS = new Version2017RegionType(SCHEME, "GR-24");

    // GR Lesvos
    public static final Version2017RegionType GR_LESVOS = new Version2017RegionType(SCHEME, "GR-83");

    // GR Magnisia
    public static final Version2017RegionType GR_MAGNISIA = new Version2017RegionType(SCHEME, "GR-43");

    // GR Messinia
    public static final Version2017RegionType GR_MESSINIA = new Version2017RegionType(SCHEME, "GR-17");

    // GR Pella
    public static final Version2017RegionType GR_PELLA = new Version2017RegionType(SCHEME, "GR-59");

    // GR Pieria
    public static final Version2017RegionType GR_PIERIA = new Version2017RegionType(SCHEME, "GR-61");

    // GR Preveza
    public static final Version2017RegionType GR_PREVEZA = new Version2017RegionType(SCHEME, "GR-34");

    // GR Rethymnon
    public static final Version2017RegionType GR_RETHYMNON = new Version2017RegionType(SCHEME, "GR-93");

    // GR Rodopi
    public static final Version2017RegionType GR_RODOPI = new Version2017RegionType(SCHEME, "GR-73");

    // GR Samos
    public static final Version2017RegionType GR_SAMOS = new Version2017RegionType(SCHEME, "GR-84");

    // GR Serrai
    public static final Version2017RegionType GR_SERRAI = new Version2017RegionType(SCHEME, "GR-62");

    // GR Thesprotia
    public static final Version2017RegionType GR_THESPROTIA = new Version2017RegionType(SCHEME, "GR-32");

    // GR Thessaloniki
    public static final Version2017RegionType GR_THESSALONIKI = new Version2017RegionType(SCHEME, "GR-54");

    // GR Trikala
    public static final Version2017RegionType GR_TRIKALA = new Version2017RegionType(SCHEME, "GR-44");

    // GR Voiotia
    public static final Version2017RegionType GR_VOIOTIA = new Version2017RegionType(SCHEME, "GR-03");

    // GR Xanthi
    public static final Version2017RegionType GR_XANTHI = new Version2017RegionType(SCHEME, "GR-72");

    // GR Zakynthos
    public static final Version2017RegionType GR_ZAKYNTHOS = new Version2017RegionType(SCHEME, "GR-21");

    // GT Alta Verapaz
    public static final Version2017RegionType GT_ALTA_VERAPAZ = new Version2017RegionType(SCHEME, "GT-AV");

    // GT Baja Verapaz
    public static final Version2017RegionType GT_BAJA_VERAPAZ = new Version2017RegionType(SCHEME, "GT-BV");

    // GT Chimaltenango
    public static final Version2017RegionType GT_CHIMALTENANGO = new Version2017RegionType(SCHEME, "GT-CM");

    // GT Chiquimula
    public static final Version2017RegionType GT_CHIQUIMULA = new Version2017RegionType(SCHEME, "GT-CQ");

    // GT El Progreso
    public static final Version2017RegionType GT_EL_PROGRESO = new Version2017RegionType(SCHEME, "GT-PR");

    // GT Escuintla
    public static final Version2017RegionType GT_ESCUINTLA = new Version2017RegionType(SCHEME, "GT-ES");

    // GT Guatemala
    public static final Version2017RegionType GT_GUATEMALA = new Version2017RegionType(SCHEME, "GT-GU");

    // GT Huehuetenango
    public static final Version2017RegionType GT_HUEHUETENANGO = new Version2017RegionType(SCHEME, "GT-HU");

    // GT Izabal
    public static final Version2017RegionType GT_IZABAL = new Version2017RegionType(SCHEME, "GT-IZ");

    // GT Jalapa
    public static final Version2017RegionType GT_JALAPA = new Version2017RegionType(SCHEME, "GT-JA");

    // GT Jutiapa
    public static final Version2017RegionType GT_JUTIAPA = new Version2017RegionType(SCHEME, "GT-JU");

    // GT Peten
    public static final Version2017RegionType GT_PETEN = new Version2017RegionType(SCHEME, "GT-PE");

    // GT Quetzaltenango
    public static final Version2017RegionType GT_QUETZALTENANGO = new Version2017RegionType(SCHEME, "GT-QZ");

    // GT Quiche
    public static final Version2017RegionType GT_QUICHE = new Version2017RegionType(SCHEME, "GT-QC");

    // GT Retalhuleu
    public static final Version2017RegionType GT_RETALHULEU = new Version2017RegionType(SCHEME, "GT-RE");

    // GT Sacatepequez
    public static final Version2017RegionType GT_SACATEPEQUEZ = new Version2017RegionType(SCHEME, "GT-SA");

    // GT Santa Rosa
    public static final Version2017RegionType GT_SANTA_ROSA = new Version2017RegionType(SCHEME, "GT-SR");

    // GT San Marcos
    public static final Version2017RegionType GT_SAN_MARCOS = new Version2017RegionType(SCHEME, "GT-SM");

    // GT Solola
    public static final Version2017RegionType GT_SOLOLA = new Version2017RegionType(SCHEME, "GT-SO");

    // GT Suchitepequez
    public static final Version2017RegionType GT_SUCHITEPEQUEZ = new Version2017RegionType(SCHEME, "GT-SU");

    // GT Totonicapan
    public static final Version2017RegionType GT_TOTONICAPAN = new Version2017RegionType(SCHEME, "GT-TO");

    // GT Zacapa
    public static final Version2017RegionType GT_ZACAPA = new Version2017RegionType(SCHEME, "GT-ZA");

    // GW Bafata
    public static final Version2017RegionType GW_BAFATA = new Version2017RegionType(SCHEME, "GW-BA");

    // GW Biombo
    public static final Version2017RegionType GW_BIOMBO = new Version2017RegionType(SCHEME, "GW-BM");

    // GW Bissau
    public static final Version2017RegionType GW_BISSAU = new Version2017RegionType(SCHEME, "GW-BS");

    // GW Bolama
    public static final Version2017RegionType GW_BOLAMA = new Version2017RegionType(SCHEME, "GW-BL");

    // GW Cacheu
    public static final Version2017RegionType GW_CACHEU = new Version2017RegionType(SCHEME, "GW-CA");

    // GW Gabu
    public static final Version2017RegionType GW_GABU = new Version2017RegionType(SCHEME, "GW-GA");

    // GW Oio
    public static final Version2017RegionType GW_OIO = new Version2017RegionType(SCHEME, "GW-OI");

    // GW Quinara
    public static final Version2017RegionType GW_QUINARA = new Version2017RegionType(SCHEME, "GW-QU");

    // GW Tombali
    public static final Version2017RegionType GW_TOMBALI = new Version2017RegionType(SCHEME, "GW-TO");

    // GY Barima-waini
    public static final Version2017RegionType GY_BARIMA_WAINI = new Version2017RegionType(SCHEME, "GY-BA");

    // GY Cuyuni-mazaruni
    public static final Version2017RegionType GY_CUYUNI_MAZARUNI = new Version2017RegionType(SCHEME, "GY-CU");

    // GY Demerara-mahaica
    public static final Version2017RegionType GY_DEMERARA_MAHAICA = new Version2017RegionType(SCHEME, "GY-DE");

    // GY East Berbice-corentyne
    public static final Version2017RegionType GY_EAST_BERBICE_CORENTYNE = new Version2017RegionType(SCHEME, "GY-EB");

    // GY Essequibo Islands-west Demerara
    public static final Version2017RegionType GY_ESSEQUIBO_ISLANDS_WEST_DEMERARA = new Version2017RegionType(SCHEME, "GY-ES");

    // GY Mahaica-berbice
    public static final Version2017RegionType GY_MAHAICA_BERBICE = new Version2017RegionType(SCHEME, "GY-MA");

    // GY Pomeroon-supenaam
    public static final Version2017RegionType GY_POMEROON_SUPENAAM = new Version2017RegionType(SCHEME, "GY-PM");

    // GY Potaro-siparuni
    public static final Version2017RegionType GY_POTARO_SIPARUNI = new Version2017RegionType(SCHEME, "GY-PT");

    // GY Upper Demerara-berbice
    public static final Version2017RegionType GY_UPPER_DEMERARA_BERBICE = new Version2017RegionType(SCHEME, "GY-UD");

    // GY Upper Takutu-upper Essequibo
    public static final Version2017RegionType GY_UPPER_TAKUTU_UPPER_ESSEQUIBO = new Version2017RegionType(SCHEME, "GY-UT");

    // HN Atlantida
    public static final Version2017RegionType HN_ATLANTIDA = new Version2017RegionType(SCHEME, "HN-AT");

    // HN Choluteca
    public static final Version2017RegionType HN_CHOLUTECA = new Version2017RegionType(SCHEME, "HN-CH");

    // HN Colon
    public static final Version2017RegionType HN_COLON = new Version2017RegionType(SCHEME, "HN-CL");

    // HN Comayagua
    public static final Version2017RegionType HN_COMAYAGUA = new Version2017RegionType(SCHEME, "HN-CM");

    // HN Copan
    public static final Version2017RegionType HN_COPAN = new Version2017RegionType(SCHEME, "HN-CP");

    // HN Cortes
    public static final Version2017RegionType HN_CORTES = new Version2017RegionType(SCHEME, "HN-CR");

    // HN El Paraiso
    public static final Version2017RegionType HN_EL_PARAISO = new Version2017RegionType(SCHEME, "HN-EP");

    // HN Francisco Morazan
    public static final Version2017RegionType HN_FRANCISCO_MORAZAN = new Version2017RegionType(SCHEME, "HN-FM");

    // HN Gracias A Dios
    public static final Version2017RegionType HN_GRACIAS_A_DIOS = new Version2017RegionType(SCHEME, "HN-GD");

    // HN Intibuca
    public static final Version2017RegionType HN_INTIBUCA = new Version2017RegionType(SCHEME, "HN-IN");

    // HN Islas De La Bahia
    public static final Version2017RegionType HN_ISLAS_DE_LA_BAHIA = new Version2017RegionType(SCHEME, "HN-IB");

    // HN La Paz, HN
    public static final Version2017RegionType HN_LA_PAZ = new Version2017RegionType(SCHEME, "HN-LP");

    // HN Lempira
    public static final Version2017RegionType HN_LEMPIRA = new Version2017RegionType(SCHEME, "HN-LE");

    // HN Ocotepeque
    public static final Version2017RegionType HN_OCOTEPEQUE = new Version2017RegionType(SCHEME, "HN-OC");

    // HN Olancho
    public static final Version2017RegionType HN_OLANCHO = new Version2017RegionType(SCHEME, "HN-OL");

    // HN Santa Barbara
    public static final Version2017RegionType HN_SANTA_BARBARA = new Version2017RegionType(SCHEME, "HN-SB");

    // HN Valle
    public static final Version2017RegionType HN_VALLE = new Version2017RegionType(SCHEME, "HN-VA");

    // HN Yoro
    public static final Version2017RegionType HN_YORO = new Version2017RegionType(SCHEME, "HN-YO");

    // HR Bjelovarsko-bilogorska Zupanija
    public static final Version2017RegionType HR_BJELOVARSKO_BILOGORSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-07");

    // HR Brodsko-posavska Zupanija
    public static final Version2017RegionType HR_BRODSKO_POSAVSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-12");

    // HR Dubrovacko-neretvanska Zupanija
    public static final Version2017RegionType HR_DUBROVACKO_NERETVANSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-19");

    // HR Grad Zagreb
    public static final Version2017RegionType HR_GRAD_ZAGREB = new Version2017RegionType(SCHEME, "HR-21");

    // HR Istarska Zupanija
    public static final Version2017RegionType HR_ISTARSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-18");

    // HR Karlovacka Zupanija
    public static final Version2017RegionType HR_KARLOVACKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-04");

    // HR Koprivnicko-krizevacka Zupanija
    public static final Version2017RegionType HR_KOPRIVNICKO_KRIZEVACKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-06");

    // HR Krapinsko-zagorska Zupanija
    public static final Version2017RegionType HR_KRAPINSKO_ZAGORSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-02");

    // HR Licko-senjska Zupanija
    public static final Version2017RegionType HR_LICKO_SENJSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-09");

    // HR Medimurska Zupanija
    public static final Version2017RegionType HR_MEDIMURSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-20");

    // HR Osjecko-baranjska Zupanija
    public static final Version2017RegionType HR_OSJECKO_BARANJSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-14");

    // HR Pozetko-slavonska Zupanija
    public static final Version2017RegionType HR_POZETKO_SLAVONSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-11");

    // HR Primorsko-goranska Zupanija
    public static final Version2017RegionType HR_PRIMORSKO_GORANSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-08");

    // HR Sibensko-kninska Zupanija
    public static final Version2017RegionType HR_SIBENSKO_KNINSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-15");

    // HR Sisacko-moslavacka Zupanija
    public static final Version2017RegionType HR_SISACKO_MOSLAVACKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-03");

    // HR Splitsko-dalmatinska Zupanija
    public static final Version2017RegionType HR_SPLITSKO_DALMATINSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-17");

    // HR Varazdinska Zupanija
    public static final Version2017RegionType HR_VARAZDINSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-05");

    // HR Viroviticko-podravska Zupanija
    public static final Version2017RegionType HR_VIROVITICKO_PODRAVSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-10");

    // HR Vukovarsko-srijemska Zupanija
    public static final Version2017RegionType HR_VUKOVARSKO_SRIJEMSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-16");

    // HR Zadarska Zupanija
    public static final Version2017RegionType HR_ZADARSKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-13");

    // HR Zagrebacka Zupanija
    public static final Version2017RegionType HR_ZAGREBACKA_ZUPANIJA = new Version2017RegionType(SCHEME, "HR-01");

    // HT Artibonite
    public static final Version2017RegionType HT_ARTIBONITE = new Version2017RegionType(SCHEME, "HT-AR");

    // HT Centre, HT
    public static final Version2017RegionType HT_CENTRE = new Version2017RegionType(SCHEME, "HT-CE");

    // HT Grande-anse
    public static final Version2017RegionType HT_GRANDE_ANSE = new Version2017RegionType(SCHEME, "HT-GA");

    // HT Nord
    public static final Version2017RegionType HT_NORD = new Version2017RegionType(SCHEME, "HT-ND");

    // HT Nord-est
    public static final Version2017RegionType HT_NORD_EST = new Version2017RegionType(SCHEME, "HT-NE");

    // HT Nord-ouest
    public static final Version2017RegionType HT_NORD_OUEST = new Version2017RegionType(SCHEME, "HT-NO");

    // HT Ouest
    public static final Version2017RegionType HT_OUEST = new Version2017RegionType(SCHEME, "HT-OU");

    // HT Sud
    public static final Version2017RegionType HT_SUD = new Version2017RegionType(SCHEME, "HT-SD");

    // HT Sud-est
    public static final Version2017RegionType HT_SUD_EST = new Version2017RegionType(SCHEME, "HT-SE");

    // HU Bacs-kiskun
    public static final Version2017RegionType HU_BACS_KISKUN = new Version2017RegionType(SCHEME, "HU-BK");

    // HU Baranya
    public static final Version2017RegionType HU_BARANYA = new Version2017RegionType(SCHEME, "HU-BA");

    // HU Bekes
    public static final Version2017RegionType HU_BEKES = new Version2017RegionType(SCHEME, "HU-BE");

    // HU Bekescsaba
    public static final Version2017RegionType HU_BEKESCSABA = new Version2017RegionType(SCHEME, "HU-BC");

    // HU Borsod-abauj-zemplen
    public static final Version2017RegionType HU_BORSOD_ABAUJ_ZEMPLEN = new Version2017RegionType(SCHEME, "HU-BZ");

    // HU Budapest
    public static final Version2017RegionType HU_BUDAPEST = new Version2017RegionType(SCHEME, "HU-BU");

    // HU Csongrad
    public static final Version2017RegionType HU_CSONGRAD = new Version2017RegionType(SCHEME, "HU-CS");

    // HU Debrecen
    public static final Version2017RegionType HU_DEBRECEN = new Version2017RegionType(SCHEME, "HU-DE");

    // HU Dunaujvaros
    public static final Version2017RegionType HU_DUNAUJVAROS = new Version2017RegionType(SCHEME, "HU-DU");

    // HU Eger
    public static final Version2017RegionType HU_EGER = new Version2017RegionType(SCHEME, "HU-EG");

    // HU Fejer
    public static final Version2017RegionType HU_FEJER = new Version2017RegionType(SCHEME, "HU-FE");

    // HU Gyor
    public static final Version2017RegionType HU_GYOR = new Version2017RegionType(SCHEME, "HU-GY");

    // HU Gyor-moson-sopron
    public static final Version2017RegionType HU_GYOR_MOSON_SOPRON = new Version2017RegionType(SCHEME, "HU-GS");

    // HU Hajdu-bihar
    public static final Version2017RegionType HU_HAJDU_BIHAR = new Version2017RegionType(SCHEME, "HU-HB");

    // HU Heves
    public static final Version2017RegionType HU_HEVES = new Version2017RegionType(SCHEME, "HU-HE");

    // HU Hodmezovasarhely
    public static final Version2017RegionType HU_HODMEZOVASARHELY = new Version2017RegionType(SCHEME, "HU-HV");

    // HU Jasz-nagykun-szolnok
    public static final Version2017RegionType HU_JASZ_NAGYKUN_SZOLNOK = new Version2017RegionType(SCHEME, "HU-JN");

    // HU Kaposvar
    public static final Version2017RegionType HU_KAPOSVAR = new Version2017RegionType(SCHEME, "HU-KV");

    // HU Kecskemet
    public static final Version2017RegionType HU_KECSKEMET = new Version2017RegionType(SCHEME, "HU-KM");

    // HU Komarom-esztergom
    public static final Version2017RegionType HU_KOMAROM_ESZTERGOM = new Version2017RegionType(SCHEME, "HU-KE");

    // HU Miskolc
    public static final Version2017RegionType HU_MISKOLC = new Version2017RegionType(SCHEME, "HU-MI");

    // HU Nagykanizsa
    public static final Version2017RegionType HU_NAGYKANIZSA = new Version2017RegionType(SCHEME, "HU-NK");

    // HU Nograd
    public static final Version2017RegionType HU_NOGRAD = new Version2017RegionType(SCHEME, "HU-NO");

    // HU Nyiregyhaza
    public static final Version2017RegionType HU_NYIREGYHAZA = new Version2017RegionType(SCHEME, "HU-NY");

    // HU Pecs
    public static final Version2017RegionType HU_PECS = new Version2017RegionType(SCHEME, "HU-PS");

    // HU Pest
    public static final Version2017RegionType HU_PEST = new Version2017RegionType(SCHEME, "HU-PE");

    // HU Salgotarjan
    public static final Version2017RegionType HU_SALGOTARJAN = new Version2017RegionType(SCHEME, "HU-ST");

    // HU Somogy
    public static final Version2017RegionType HU_SOMOGY = new Version2017RegionType(SCHEME, "HU-SO");

    // HU Sopron
    public static final Version2017RegionType HU_SOPRON = new Version2017RegionType(SCHEME, "HU-SN");

    // HU Szabolcs-szatmar-bereg
    public static final Version2017RegionType HU_SZABOLCS_SZATMAR_BEREG = new Version2017RegionType(SCHEME, "HU-SZ");

    // HU Szeged
    public static final Version2017RegionType HU_SZEGED = new Version2017RegionType(SCHEME, "HU-SD");

    // HU Szekesfehervar
    public static final Version2017RegionType HU_SZEKESFEHERVAR = new Version2017RegionType(SCHEME, "HU-SF");

    // HU Szekszard
    public static final Version2017RegionType HU_SZEKSZARD = new Version2017RegionType(SCHEME, "HU-SS");

    // HU Szolnok
    public static final Version2017RegionType HU_SZOLNOK = new Version2017RegionType(SCHEME, "HU-SK");

    // HU Szombathely
    public static final Version2017RegionType HU_SZOMBATHELY = new Version2017RegionType(SCHEME, "HU-SH");

    // HU Tatabanya
    public static final Version2017RegionType HU_TATABANYA = new Version2017RegionType(SCHEME, "HU-TB");

    // HU Tolna
    public static final Version2017RegionType HU_TOLNA = new Version2017RegionType(SCHEME, "HU-TO");

    // HU Vas
    public static final Version2017RegionType HU_VAS = new Version2017RegionType(SCHEME, "HU-VA");

    // HU Veszprem
    public static final Version2017RegionType HU_VESZPREM = new Version2017RegionType(SCHEME, "HU-VE");

    // HU Veszprem, HU
    public static final Version2017RegionType HU_VESZPREM_HU_VM = new Version2017RegionType(SCHEME, "HU-VM");

    // HU Zala
    public static final Version2017RegionType HU_ZALA = new Version2017RegionType(SCHEME, "HU-ZA");

    // HU Zalaegerszeg
    public static final Version2017RegionType HU_ZALAEGERSZEG = new Version2017RegionType(SCHEME, "HU-ZE");

    // ID Aceh
    public static final Version2017RegionType ID_ACEH = new Version2017RegionType(SCHEME, "ID-AC");

    // ID Bali
    public static final Version2017RegionType ID_BALI = new Version2017RegionType(SCHEME, "ID-BA");

    // ID Bangka Belitung
    public static final Version2017RegionType ID_BANGKA_BELITUNG = new Version2017RegionType(SCHEME, "ID-BB");

    // ID Banten
    public static final Version2017RegionType ID_BANTEN = new Version2017RegionType(SCHEME, "ID-BT");

    // ID Bengkulu
    public static final Version2017RegionType ID_BENGKULU = new Version2017RegionType(SCHEME, "ID-BE");

    // ID Gorontalo
    public static final Version2017RegionType ID_GORONTALO = new Version2017RegionType(SCHEME, "ID-GO");

    // ID Jakarta Raya
    public static final Version2017RegionType ID_JAKARTA_RAYA = new Version2017RegionType(SCHEME, "ID-JK");

    // ID Jambi
    public static final Version2017RegionType ID_JAMBI = new Version2017RegionType(SCHEME, "ID-JA");

    // ID Jawa Barat
    public static final Version2017RegionType ID_JAWA_BARAT = new Version2017RegionType(SCHEME, "ID-JB");

    // ID Jawa Tengah
    public static final Version2017RegionType ID_JAWA_TENGAH = new Version2017RegionType(SCHEME, "ID-JT");

    // ID Jawa Timur
    public static final Version2017RegionType ID_JAWA_TIMUR = new Version2017RegionType(SCHEME, "ID-JI");

    // ID Kalimantan Barat
    public static final Version2017RegionType ID_KALIMANTAN_BARAT = new Version2017RegionType(SCHEME, "ID-KB");

    // ID Kalimantan Selatan
    public static final Version2017RegionType ID_KALIMANTAN_SELATAN = new Version2017RegionType(SCHEME, "ID-KS");

    // ID Kalimantan Tengah
    public static final Version2017RegionType ID_KALIMANTAN_TENGAH = new Version2017RegionType(SCHEME, "ID-KT");

    // ID Kalimantan Timur
    public static final Version2017RegionType ID_KALIMANTAN_TIMUR = new Version2017RegionType(SCHEME, "ID-KI");

    // ID Kepulauan Riau
    public static final Version2017RegionType ID_KEPULAUAN_RIAU = new Version2017RegionType(SCHEME, "ID-KR");

    // ID Lampung
    public static final Version2017RegionType ID_LAMPUNG = new Version2017RegionType(SCHEME, "ID-LA");

    // ID Maluku
    public static final Version2017RegionType ID_MALUKU = new Version2017RegionType(SCHEME, "ID-MA");

    // ID Maluku Utara
    public static final Version2017RegionType ID_MALUKU_UTARA = new Version2017RegionType(SCHEME, "ID-MU");

    // ID Nusa Tenggara Barat
    public static final Version2017RegionType ID_NUSA_TENGGARA_BARAT = new Version2017RegionType(SCHEME, "ID-NB");

    // ID Nusa Tenggara Timur
    public static final Version2017RegionType ID_NUSA_TENGGARA_TIMUR = new Version2017RegionType(SCHEME, "ID-NT");

    // ID Papua
    public static final Version2017RegionType ID_PAPUA = new Version2017RegionType(SCHEME, "ID-PA");

    // ID Riau
    public static final Version2017RegionType ID_RIAU = new Version2017RegionType(SCHEME, "ID-RI");

    // ID Sulawesi Selatan
    public static final Version2017RegionType ID_SULAWESI_SELATAN = new Version2017RegionType(SCHEME, "ID-SN");

    // ID Sulawesi Tengah
    public static final Version2017RegionType ID_SULAWESI_TENGAH = new Version2017RegionType(SCHEME, "ID-ST");

    // ID Sulawesi Tenggara
    public static final Version2017RegionType ID_SULAWESI_TENGGARA = new Version2017RegionType(SCHEME, "ID-SG");

    // ID Sulawesi Utara
    public static final Version2017RegionType ID_SULAWESI_UTARA = new Version2017RegionType(SCHEME, "ID-SA");

    // ID Sumatera Barat
    public static final Version2017RegionType ID_SUMATERA_BARAT = new Version2017RegionType(SCHEME, "ID-SB");

    // ID Sumatera Selatan
    public static final Version2017RegionType ID_SUMATERA_SELATAN = new Version2017RegionType(SCHEME, "ID-SS");

    // ID Sumatera Utara
    public static final Version2017RegionType ID_SUMATERA_UTARA = new Version2017RegionType(SCHEME, "ID-SU");

    // ID Yogyakarta
    public static final Version2017RegionType ID_YOGYAKARTA = new Version2017RegionType(SCHEME, "ID-YO");

    // IE Carlow
    public static final Version2017RegionType IE_CARLOW = new Version2017RegionType(SCHEME, "IE-CW");

    // IE Cavan
    public static final Version2017RegionType IE_CAVAN = new Version2017RegionType(SCHEME, "IE-CN");

    // IE Clare
    public static final Version2017RegionType IE_CLARE = new Version2017RegionType(SCHEME, "IE-CE");

    // IE Cork
    public static final Version2017RegionType IE_CORK = new Version2017RegionType(SCHEME, "IE-C");

    // IE Donegal
    public static final Version2017RegionType IE_DONEGAL = new Version2017RegionType(SCHEME, "IE-DL");

    // IE Dublin
    public static final Version2017RegionType IE_DUBLIN = new Version2017RegionType(SCHEME, "IE-D");

    // IE Galway
    public static final Version2017RegionType IE_GALWAY = new Version2017RegionType(SCHEME, "IE-G");

    // IE Kerry
    public static final Version2017RegionType IE_KERRY = new Version2017RegionType(SCHEME, "IE-KY");

    // IE Kildare
    public static final Version2017RegionType IE_KILDARE = new Version2017RegionType(SCHEME, "IE-KE");

    // IE Kilkenny
    public static final Version2017RegionType IE_KILKENNY = new Version2017RegionType(SCHEME, "IE-KK");

    // IE Laois
    public static final Version2017RegionType IE_LAOIS = new Version2017RegionType(SCHEME, "IE-LS");

    // IE Leitrim
    public static final Version2017RegionType IE_LEITRIM = new Version2017RegionType(SCHEME, "IE-LM");

    // IE Limerick
    public static final Version2017RegionType IE_LIMERICK = new Version2017RegionType(SCHEME, "IE-LK");

    // IE Longford
    public static final Version2017RegionType IE_LONGFORD = new Version2017RegionType(SCHEME, "IE-LD");

    // IE Louth
    public static final Version2017RegionType IE_LOUTH = new Version2017RegionType(SCHEME, "IE-LH");

    // IE Mayo
    public static final Version2017RegionType IE_MAYO = new Version2017RegionType(SCHEME, "IE-MO");

    // IE Meath
    public static final Version2017RegionType IE_MEATH = new Version2017RegionType(SCHEME, "IE-MH");

    // IE Monaghan
    public static final Version2017RegionType IE_MONAGHAN = new Version2017RegionType(SCHEME, "IE-MN");

    // IE Offaly
    public static final Version2017RegionType IE_OFFALY = new Version2017RegionType(SCHEME, "IE-OY");

    // IE Roscommon
    public static final Version2017RegionType IE_ROSCOMMON = new Version2017RegionType(SCHEME, "IE-RN");

    // IE Sligo
    public static final Version2017RegionType IE_SLIGO = new Version2017RegionType(SCHEME, "IE-SO");

    // IE Tipperary
    public static final Version2017RegionType IE_TIPPERARY = new Version2017RegionType(SCHEME, "IE-TA");

    // IE Waterford
    public static final Version2017RegionType IE_WATERFORD = new Version2017RegionType(SCHEME, "IE-WD");

    // IE Westmeath
    public static final Version2017RegionType IE_WESTMEATH = new Version2017RegionType(SCHEME, "IE-WH");

    // IE Wexford
    public static final Version2017RegionType IE_WEXFORD = new Version2017RegionType(SCHEME, "IE-WX");

    // IE Wicklow
    public static final Version2017RegionType IE_WICKLOW = new Version2017RegionType(SCHEME, "IE-WW");

    // IL Hadarom
    public static final Version2017RegionType IL_HADAROM = new Version2017RegionType(SCHEME, "IL-D");

    // IL Hamerkaz
    public static final Version2017RegionType IL_HAMERKAZ = new Version2017RegionType(SCHEME, "IL-M");

    // IL Ha Zafon
    public static final Version2017RegionType IL_HA_ZAFON = new Version2017RegionType(SCHEME, "IL-Z");

    // IL Hefa
    public static final Version2017RegionType IL_HEFA = new Version2017RegionType(SCHEME, "IL-HA");

    // IL Tel-aviv
    public static final Version2017RegionType IL_TEL_AVIV = new Version2017RegionType(SCHEME, "IL-TA");

    // IL Yerushalayim
    public static final Version2017RegionType IL_YERUSHALAYIM = new Version2017RegionType(SCHEME, "IL-JM");

    // IN Andaman And Nicobar Islands
    public static final Version2017RegionType IN_ANDAMAN_AND_NICOBAR_ISLANDS = new Version2017RegionType(SCHEME, "IN-AN");

    // IN Andhra Pradesh
    public static final Version2017RegionType IN_ANDHRA_PRADESH = new Version2017RegionType(SCHEME, "IN-AP");

    // IN Arunachal Pradesh
    public static final Version2017RegionType IN_ARUNACHAL_PRADESH = new Version2017RegionType(SCHEME, "IN-AR");

    // IN Assam
    public static final Version2017RegionType IN_ASSAM = new Version2017RegionType(SCHEME, "IN-AS");

    // IN Bihar
    public static final Version2017RegionType IN_BIHAR = new Version2017RegionType(SCHEME, "IN-BR");

    // IN Chancigarh
    public static final Version2017RegionType IN_CHANCIGARH = new Version2017RegionType(SCHEME, "IN-CH");

    // IN Chhattisgarh
    public static final Version2017RegionType IN_CHHATTISGARH = new Version2017RegionType(SCHEME, "IN-CT");

    // IN Dadra And Nagar Haveli
    public static final Version2017RegionType IN_DADRA_AND_NAGAR_HAVELI = new Version2017RegionType(SCHEME, "IN-DN");

    // IN Daman And Diu
    public static final Version2017RegionType IN_DAMAN_AND_DIU = new Version2017RegionType(SCHEME, "IN-DD");

    // IN Delhi
    public static final Version2017RegionType IN_DELHI = new Version2017RegionType(SCHEME, "IN-DL");

    // IN Goa
    public static final Version2017RegionType IN_GOA = new Version2017RegionType(SCHEME, "IN-GA");

    // IN Gujarat
    public static final Version2017RegionType IN_GUJARAT = new Version2017RegionType(SCHEME, "IN-GJ");

    // IN Haryana
    public static final Version2017RegionType IN_HARYANA = new Version2017RegionType(SCHEME, "IN-HR");

    // IN Himachal Pradesh
    public static final Version2017RegionType IN_HIMACHAL_PRADESH = new Version2017RegionType(SCHEME, "IN-HP");

    // IN Jammu And Kashrrir
    public static final Version2017RegionType IN_JAMMU_AND_KASHRRIR = new Version2017RegionType(SCHEME, "IN-JK");

    // IN Jharkhand
    public static final Version2017RegionType IN_JHARKHAND = new Version2017RegionType(SCHEME, "IN-JH");

    // IN Karnataka
    public static final Version2017RegionType IN_KARNATAKA = new Version2017RegionType(SCHEME, "IN-KA");

    // IN Kerala
    public static final Version2017RegionType IN_KERALA = new Version2017RegionType(SCHEME, "IN-KL");

    // IN Lakshadweep
    public static final Version2017RegionType IN_LAKSHADWEEP = new Version2017RegionType(SCHEME, "IN-LD");

    // IN Madhya Pradesh
    public static final Version2017RegionType IN_MADHYA_PRADESH = new Version2017RegionType(SCHEME, "IN-MP");

    // IN Maharashtra
    public static final Version2017RegionType IN_MAHARASHTRA = new Version2017RegionType(SCHEME, "IN-MH");

    // IN Manipur
    public static final Version2017RegionType IN_MANIPUR = new Version2017RegionType(SCHEME, "IN-MN");

    // IN Meghalaya
    public static final Version2017RegionType IN_MEGHALAYA = new Version2017RegionType(SCHEME, "IN-ML");

    // IN Mizoram
    public static final Version2017RegionType IN_MIZORAM = new Version2017RegionType(SCHEME, "IN-MZ");

    // IN Nagaland
    public static final Version2017RegionType IN_NAGALAND = new Version2017RegionType(SCHEME, "IN-NL");

    // IN Orissa
    public static final Version2017RegionType IN_ORISSA = new Version2017RegionType(SCHEME, "IN-OR");

    // IN Pondicherry
    public static final Version2017RegionType IN_PONDICHERRY = new Version2017RegionType(SCHEME, "IN-PY");

    // IN Punjab
    public static final Version2017RegionType IN_PUNJAB = new Version2017RegionType(SCHEME, "IN-PB");

    // IN Rajasthan
    public static final Version2017RegionType IN_RAJASTHAN = new Version2017RegionType(SCHEME, "IN-RJ");

    // IN Sikkim
    public static final Version2017RegionType IN_SIKKIM = new Version2017RegionType(SCHEME, "IN-SK");

    // IN Tamil Nadu
    public static final Version2017RegionType IN_TAMIL_NADU = new Version2017RegionType(SCHEME, "IN-TN");

    // IN Tripura
    public static final Version2017RegionType IN_TRIPURA = new Version2017RegionType(SCHEME, "IN-TR");

    // IN Uttaranchal
    public static final Version2017RegionType IN_UTTARANCHAL = new Version2017RegionType(SCHEME, "IN-UL");

    // IN Uttar Pradesh
    public static final Version2017RegionType IN_UTTAR_PRADESH = new Version2017RegionType(SCHEME, "IN-UP");

    // IN West Bengal
    public static final Version2017RegionType IN_WEST_BENGAL = new Version2017RegionType(SCHEME, "IN-WB");

    // IQ Al Anbar
    public static final Version2017RegionType IQ_AL_ANBAR = new Version2017RegionType(SCHEME, "IQ-AN");

    // IQ Al Basrah
    public static final Version2017RegionType IQ_AL_BASRAH = new Version2017RegionType(SCHEME, "IQ-BA");

    // IQ Al Muthanna
    public static final Version2017RegionType IQ_AL_MUTHANNA = new Version2017RegionType(SCHEME, "IQ-MU");

    // IQ Al Qadisiyah
    public static final Version2017RegionType IQ_AL_QADISIYAH = new Version2017RegionType(SCHEME, "IQ-QA");

    // IQ An Najaf
    public static final Version2017RegionType IQ_AN_NAJAF = new Version2017RegionType(SCHEME, "IQ-NA");

    // IQ Arbil
    public static final Version2017RegionType IQ_ARBIL = new Version2017RegionType(SCHEME, "IQ-AR");

    // IQ As Sulaymaniyah
    public static final Version2017RegionType IQ_AS_SULAYMANIYAH = new Version2017RegionType(SCHEME, "IQ-SU");

    // IQ At Ta'mim
    public static final Version2017RegionType IQ_AT_TAMIM = new Version2017RegionType(SCHEME, "IQ-TS");

    // IQ Babil
    public static final Version2017RegionType IQ_BABIL = new Version2017RegionType(SCHEME, "IQ-BB");

    // IQ Baghdad
    public static final Version2017RegionType IQ_BAGHDAD = new Version2017RegionType(SCHEME, "IQ-BG");

    // IQ Dahuk
    public static final Version2017RegionType IQ_DAHUK = new Version2017RegionType(SCHEME, "IQ-DA");

    // IQ Dhi Qar
    public static final Version2017RegionType IQ_DHI_QAR = new Version2017RegionType(SCHEME, "IQ-DQ");

    // IQ Diyala
    public static final Version2017RegionType IQ_DIYALA = new Version2017RegionType(SCHEME, "IQ-DI");

    // IQ Karbala'
    public static final Version2017RegionType IQ_KARBALA = new Version2017RegionType(SCHEME, "IQ-KA");

    // IQ Maysan
    public static final Version2017RegionType IQ_MAYSAN = new Version2017RegionType(SCHEME, "IQ-MA");

    // IQ Ninawa
    public static final Version2017RegionType IQ_NINAWA = new Version2017RegionType(SCHEME, "IQ-NI");

    // IQ Salah Ad Din
    public static final Version2017RegionType IQ_SALAH_AD_DIN = new Version2017RegionType(SCHEME, "IQ-SD");

    // IQ Wasit
    public static final Version2017RegionType IQ_WASIT = new Version2017RegionType(SCHEME, "IQ-WA");

    // IR Ardabil
    public static final Version2017RegionType IR_ARDABIL = new Version2017RegionType(SCHEME, "IR-03");

    // IR Azarbayjan-e Gharbi
    public static final Version2017RegionType IR_AZARBAYJAN_E_GHARBI = new Version2017RegionType(SCHEME, "IR-02");

    // IR Azarbayjan-e Sharqi
    public static final Version2017RegionType IR_AZARBAYJAN_E_SHARQI = new Version2017RegionType(SCHEME, "IR-01");

    // IR Bushehr
    public static final Version2017RegionType IR_BUSHEHR = new Version2017RegionType(SCHEME, "IR-06");

    // IR Chahar Mahall Va Bakhtan
    public static final Version2017RegionType IR_CHAHAR_MAHALL_VA_BAKHTAN = new Version2017RegionType(SCHEME, "IR-08");

    // IR Esfahan
    public static final Version2017RegionType IR_ESFAHAN = new Version2017RegionType(SCHEME, "IR-04");

    // IR Fars
    public static final Version2017RegionType IR_FARS = new Version2017RegionType(SCHEME, "IR-14");

    // IR Gilan
    public static final Version2017RegionType IR_GILAN = new Version2017RegionType(SCHEME, "IR-19");

    // IR Golestan
    public static final Version2017RegionType IR_GOLESTAN = new Version2017RegionType(SCHEME, "IR-27");

    // IR Hamadan
    public static final Version2017RegionType IR_HAMADAN = new Version2017RegionType(SCHEME, "IR-24");

    // IR Hormozgan
    public static final Version2017RegionType IR_HORMOZGAN = new Version2017RegionType(SCHEME, "IR-23");

    // IR Ilam
    public static final Version2017RegionType IR_ILAM = new Version2017RegionType(SCHEME, "IR-05");

    // IR Kerman
    public static final Version2017RegionType IR_KERMAN = new Version2017RegionType(SCHEME, "IR-15");

    // IR Kermanshah
    public static final Version2017RegionType IR_KERMANSHAH = new Version2017RegionType(SCHEME, "IR-17");

    // IR Khorasan
    public static final Version2017RegionType IR_KHORASAN = new Version2017RegionType(SCHEME, "IR-09");

    // IR Khuzestan
    public static final Version2017RegionType IR_KHUZESTAN = new Version2017RegionType(SCHEME, "IR-10");

    // IR Kohkiluyeh Va Buyer Ahmad
    public static final Version2017RegionType IR_KOHKILUYEH_VA_BUYER_AHMAD = new Version2017RegionType(SCHEME, "IR-18");

    // IR Kordestan
    public static final Version2017RegionType IR_KORDESTAN = new Version2017RegionType(SCHEME, "IR-16");

    // IR Lorestan
    public static final Version2017RegionType IR_LORESTAN = new Version2017RegionType(SCHEME, "IR-20");

    // IR Markazi
    public static final Version2017RegionType IR_MARKAZI = new Version2017RegionType(SCHEME, "IR-22");

    // IR Mazandaran
    public static final Version2017RegionType IR_MAZANDARAN = new Version2017RegionType(SCHEME, "IR-21");

    // IR Qazvin
    public static final Version2017RegionType IR_QAZVIN = new Version2017RegionType(SCHEME, "IR-28");

    // IR Qom
    public static final Version2017RegionType IR_QOM = new Version2017RegionType(SCHEME, "IR-26");

    // IR Semnan
    public static final Version2017RegionType IR_SEMNAN = new Version2017RegionType(SCHEME, "IR-12");

    // IR Sistan Va Baluchestan
    public static final Version2017RegionType IR_SISTAN_VA_BALUCHESTAN = new Version2017RegionType(SCHEME, "IR-13");

    // IR Tehran
    public static final Version2017RegionType IR_TEHRAN = new Version2017RegionType(SCHEME, "IR-07");

    // IR Yazd
    public static final Version2017RegionType IR_YAZD = new Version2017RegionType(SCHEME, "IR-25");

    // IR Zanjan
    public static final Version2017RegionType IR_ZANJAN = new Version2017RegionType(SCHEME, "IR-11");

    // IS Austurland
    public static final Version2017RegionType IS_AUSTURLAND = new Version2017RegionType(SCHEME, "IS-7");

    // IS Hofuðborgarsvaði Utan Reykjavikur
    public static final Version2017RegionType IS_HOFUÐBORGARSVAÐI_UTAN_REYKJAVIKUR = new Version2017RegionType(SCHEME, "IS-1");

    // IS Norðurland Eystra
    public static final Version2017RegionType IS_NORÐURLAND_EYSTRA = new Version2017RegionType(SCHEME, "IS-6");

    // IS Norðurland Vestra
    public static final Version2017RegionType IS_NORÐURLAND_VESTRA = new Version2017RegionType(SCHEME, "IS-5");

    // IS Reykjavik
    public static final Version2017RegionType IS_REYKJAVIK = new Version2017RegionType(SCHEME, "IS-0");

    // IS Suðurland
    public static final Version2017RegionType IS_SUÐURLAND = new Version2017RegionType(SCHEME, "IS-8");

    // IS Suðurnes
    public static final Version2017RegionType IS_SUÐURNES = new Version2017RegionType(SCHEME, "IS-2");

    // IS Vestfirðir
    public static final Version2017RegionType IS_VESTFIRÐIR = new Version2017RegionType(SCHEME, "IS-4");

    // IS Vesturland
    public static final Version2017RegionType IS_VESTURLAND = new Version2017RegionType(SCHEME, "IS-3");

    // IT Agrigento
    public static final Version2017RegionType IT_AGRIGENTO = new Version2017RegionType(SCHEME, "IT-AG");

    // IT Alessandria
    public static final Version2017RegionType IT_ALESSANDRIA = new Version2017RegionType(SCHEME, "IT-AL");

    // IT Ancona
    public static final Version2017RegionType IT_ANCONA = new Version2017RegionType(SCHEME, "IT-AN");

    // IT Aosta
    public static final Version2017RegionType IT_AOSTA = new Version2017RegionType(SCHEME, "IT-AO");

    // IT Arezzo
    public static final Version2017RegionType IT_AREZZO = new Version2017RegionType(SCHEME, "IT-AR");

    // IT Ascoli Piceno
    public static final Version2017RegionType IT_ASCOLI_PICENO = new Version2017RegionType(SCHEME, "IT-AP");

    // IT Asti
    public static final Version2017RegionType IT_ASTI = new Version2017RegionType(SCHEME, "IT-AT");

    // IT Avellino
    public static final Version2017RegionType IT_AVELLINO = new Version2017RegionType(SCHEME, "IT-AV");

    // IT Bari, IT
    public static final Version2017RegionType IT_BARI = new Version2017RegionType(SCHEME, "IT-BA");

    // IT Belluno
    public static final Version2017RegionType IT_BELLUNO = new Version2017RegionType(SCHEME, "IT-BL");

    // IT Benevento
    public static final Version2017RegionType IT_BENEVENTO = new Version2017RegionType(SCHEME, "IT-BN");

    // IT Bergamo
    public static final Version2017RegionType IT_BERGAMO = new Version2017RegionType(SCHEME, "IT-BG");

    // IT Biella
    public static final Version2017RegionType IT_BIELLA = new Version2017RegionType(SCHEME, "IT-BI");

    // IT Bologna
    public static final Version2017RegionType IT_BOLOGNA = new Version2017RegionType(SCHEME, "IT-BO");

    // IT Bolzano
    public static final Version2017RegionType IT_BOLZANO = new Version2017RegionType(SCHEME, "IT-BZ");

    // IT Brescia
    public static final Version2017RegionType IT_BRESCIA = new Version2017RegionType(SCHEME, "IT-BS");

    // IT Brindisi
    public static final Version2017RegionType IT_BRINDISI = new Version2017RegionType(SCHEME, "IT-BR");

    // IT Cagliari
    public static final Version2017RegionType IT_CAGLIARI = new Version2017RegionType(SCHEME, "IT-CA");

    // IT Caltanissetta
    public static final Version2017RegionType IT_CALTANISSETTA = new Version2017RegionType(SCHEME, "IT-CL");

    // IT Campobasso
    public static final Version2017RegionType IT_CAMPOBASSO = new Version2017RegionType(SCHEME, "IT-CB");

    // IT Caserta
    public static final Version2017RegionType IT_CASERTA = new Version2017RegionType(SCHEME, "IT-CE");

    // IT Catania
    public static final Version2017RegionType IT_CATANIA = new Version2017RegionType(SCHEME, "IT-CT");

    // IT Catanzaro
    public static final Version2017RegionType IT_CATANZARO = new Version2017RegionType(SCHEME, "IT-CZ");

    // IT Chieti
    public static final Version2017RegionType IT_CHIETI = new Version2017RegionType(SCHEME, "IT-CH");

    // IT Como
    public static final Version2017RegionType IT_COMO = new Version2017RegionType(SCHEME, "IT-CO");

    // IT Cosenza
    public static final Version2017RegionType IT_COSENZA = new Version2017RegionType(SCHEME, "IT-CS");

    // IT Cremona
    public static final Version2017RegionType IT_CREMONA = new Version2017RegionType(SCHEME, "IT-CR");

    // IT Crotone
    public static final Version2017RegionType IT_CROTONE = new Version2017RegionType(SCHEME, "IT-KR");

    // IT Cuneo
    public static final Version2017RegionType IT_CUNEO = new Version2017RegionType(SCHEME, "IT-CN");

    // IT Enna
    public static final Version2017RegionType IT_ENNA = new Version2017RegionType(SCHEME, "IT-EN");

    // IT Ferrara
    public static final Version2017RegionType IT_FERRARA = new Version2017RegionType(SCHEME, "IT-FE");

    // IT Firenze
    public static final Version2017RegionType IT_FIRENZE = new Version2017RegionType(SCHEME, "IT-FI");

    // IT Foggia
    public static final Version2017RegionType IT_FOGGIA = new Version2017RegionType(SCHEME, "IT-FG");

    // IT Forli
    public static final Version2017RegionType IT_FORLI = new Version2017RegionType(SCHEME, "IT-FO");

    // IT Frosinone
    public static final Version2017RegionType IT_FROSINONE = new Version2017RegionType(SCHEME, "IT-FR");

    // IT Genova
    public static final Version2017RegionType IT_GENOVA = new Version2017RegionType(SCHEME, "IT-GE");

    // IT Gorizia
    public static final Version2017RegionType IT_GORIZIA = new Version2017RegionType(SCHEME, "IT-GO");

    // IT Grosseto
    public static final Version2017RegionType IT_GROSSETO = new Version2017RegionType(SCHEME, "IT-GR");

    // IT Imperia
    public static final Version2017RegionType IT_IMPERIA = new Version2017RegionType(SCHEME, "IT-IM");

    // IT Isernia
    public static final Version2017RegionType IT_ISERNIA = new Version2017RegionType(SCHEME, "IT-IS");

    // IT L'aquila
    public static final Version2017RegionType IT_LAQUILA = new Version2017RegionType(SCHEME, "IT-AQ");

    // IT Latina
    public static final Version2017RegionType IT_LATINA = new Version2017RegionType(SCHEME, "IT-LT");

    // IT La Spezia
    public static final Version2017RegionType IT_LA_SPEZIA = new Version2017RegionType(SCHEME, "IT-SP");

    // IT Lecce
    public static final Version2017RegionType IT_LECCE = new Version2017RegionType(SCHEME, "IT-LE");

    // IT Lecco
    public static final Version2017RegionType IT_LECCO = new Version2017RegionType(SCHEME, "IT-LC");

    // IT Livorno
    public static final Version2017RegionType IT_LIVORNO = new Version2017RegionType(SCHEME, "IT-LI");

    // IT Lodi
    public static final Version2017RegionType IT_LODI = new Version2017RegionType(SCHEME, "IT-LO");

    // IT Lucca
    public static final Version2017RegionType IT_LUCCA = new Version2017RegionType(SCHEME, "IT-LU");

    // IT Macerata
    public static final Version2017RegionType IT_MACERATA = new Version2017RegionType(SCHEME, "IT-MC");

    // IT Mantova
    public static final Version2017RegionType IT_MANTOVA = new Version2017RegionType(SCHEME, "IT-MN");

    // IT Massa-carrara
    public static final Version2017RegionType IT_MASSA_CARRARA = new Version2017RegionType(SCHEME, "IT-MS");

    // IT Matera
    public static final Version2017RegionType IT_MATERA = new Version2017RegionType(SCHEME, "IT-MT");

    // IT Messina
    public static final Version2017RegionType IT_MESSINA = new Version2017RegionType(SCHEME, "IT-ME");

    // IT Milano
    public static final Version2017RegionType IT_MILANO = new Version2017RegionType(SCHEME, "IT-MI");

    // IT Modena
    public static final Version2017RegionType IT_MODENA = new Version2017RegionType(SCHEME, "IT-MO");

    // IT Napoli
    public static final Version2017RegionType IT_NAPOLI = new Version2017RegionType(SCHEME, "IT-NA");

    // IT Novara
    public static final Version2017RegionType IT_NOVARA = new Version2017RegionType(SCHEME, "IT-NO");

    // IT Nuoro
    public static final Version2017RegionType IT_NUORO = new Version2017RegionType(SCHEME, "IT-NU");

    // IT Oristano
    public static final Version2017RegionType IT_ORISTANO = new Version2017RegionType(SCHEME, "IT-OR");

    // IT Padova
    public static final Version2017RegionType IT_PADOVA = new Version2017RegionType(SCHEME, "IT-PD");

    // IT Palermo
    public static final Version2017RegionType IT_PALERMO = new Version2017RegionType(SCHEME, "IT-PA");

    // IT Parma
    public static final Version2017RegionType IT_PARMA = new Version2017RegionType(SCHEME, "IT-PR");

    // IT Pavia
    public static final Version2017RegionType IT_PAVIA = new Version2017RegionType(SCHEME, "IT-PV");

    // IT Perugia
    public static final Version2017RegionType IT_PERUGIA = new Version2017RegionType(SCHEME, "IT-PG");

    // IT Pesaro E Urbino
    public static final Version2017RegionType IT_PESARO_E_URBINO = new Version2017RegionType(SCHEME, "IT-PS");

    // IT Pescara
    public static final Version2017RegionType IT_PESCARA = new Version2017RegionType(SCHEME, "IT-PE");

    // IT Piacenza
    public static final Version2017RegionType IT_PIACENZA = new Version2017RegionType(SCHEME, "IT-PC");

    // IT Pisa
    public static final Version2017RegionType IT_PISA = new Version2017RegionType(SCHEME, "IT-PI");

    // IT Pistoia
    public static final Version2017RegionType IT_PISTOIA = new Version2017RegionType(SCHEME, "IT-PT");

    // IT Pordenone
    public static final Version2017RegionType IT_PORDENONE = new Version2017RegionType(SCHEME, "IT-PN");

    // IT Potenza
    public static final Version2017RegionType IT_POTENZA = new Version2017RegionType(SCHEME, "IT-PZ");

    // IT Prato
    public static final Version2017RegionType IT_PRATO = new Version2017RegionType(SCHEME, "IT-PO");

    // IT Ragusa
    public static final Version2017RegionType IT_RAGUSA = new Version2017RegionType(SCHEME, "IT-RG");

    // IT Ravenna
    public static final Version2017RegionType IT_RAVENNA = new Version2017RegionType(SCHEME, "IT-RA");

    // IT Reggio Calabria
    public static final Version2017RegionType IT_REGGIO_CALABRIA = new Version2017RegionType(SCHEME, "IT-RC");

    // IT Reggio Emilia
    public static final Version2017RegionType IT_REGGIO_EMILIA = new Version2017RegionType(SCHEME, "IT-RE");

    // IT Rieti
    public static final Version2017RegionType IT_RIETI = new Version2017RegionType(SCHEME, "IT-RI");

    // IT Rimini
    public static final Version2017RegionType IT_RIMINI = new Version2017RegionType(SCHEME, "IT-RN");

    // IT Roma
    public static final Version2017RegionType IT_ROMA = new Version2017RegionType(SCHEME, "IT-RM");

    // IT Rovigo
    public static final Version2017RegionType IT_ROVIGO = new Version2017RegionType(SCHEME, "IT-RO");

    // IT Salerno
    public static final Version2017RegionType IT_SALERNO = new Version2017RegionType(SCHEME, "IT-SA");

    // IT Sassari
    public static final Version2017RegionType IT_SASSARI = new Version2017RegionType(SCHEME, "IT-SS");

    // IT Savona
    public static final Version2017RegionType IT_SAVONA = new Version2017RegionType(SCHEME, "IT-SV");

    // IT Siena
    public static final Version2017RegionType IT_SIENA = new Version2017RegionType(SCHEME, "IT-SI");

    // IT Siracusa
    public static final Version2017RegionType IT_SIRACUSA = new Version2017RegionType(SCHEME, "IT-SR");

    // IT Sondrio
    public static final Version2017RegionType IT_SONDRIO = new Version2017RegionType(SCHEME, "IT-SO");

    // IT Taranto
    public static final Version2017RegionType IT_TARANTO = new Version2017RegionType(SCHEME, "IT-TA");

    // IT Teramo
    public static final Version2017RegionType IT_TERAMO = new Version2017RegionType(SCHEME, "IT-TE");

    // IT Terni
    public static final Version2017RegionType IT_TERNI = new Version2017RegionType(SCHEME, "IT-TR");

    // IT Torino
    public static final Version2017RegionType IT_TORINO = new Version2017RegionType(SCHEME, "IT-TO");

    // IT Trapani
    public static final Version2017RegionType IT_TRAPANI = new Version2017RegionType(SCHEME, "IT-TP");

    // IT Trento
    public static final Version2017RegionType IT_TRENTO = new Version2017RegionType(SCHEME, "IT-TN");

    // IT Treviso
    public static final Version2017RegionType IT_TREVISO = new Version2017RegionType(SCHEME, "IT-TV");

    // IT Trieste
    public static final Version2017RegionType IT_TRIESTE = new Version2017RegionType(SCHEME, "IT-TS");

    // IT Udine
    public static final Version2017RegionType IT_UDINE = new Version2017RegionType(SCHEME, "IT-UD");

    // IT Varese
    public static final Version2017RegionType IT_VARESE = new Version2017RegionType(SCHEME, "IT-VA");

    // IT Venezia
    public static final Version2017RegionType IT_VENEZIA = new Version2017RegionType(SCHEME, "IT-VE");

    // IT Verbano-cusio-ossola
    public static final Version2017RegionType IT_VERBANO_CUSIO_OSSOLA = new Version2017RegionType(SCHEME, "IT-VB");

    // IT Vercelli
    public static final Version2017RegionType IT_VERCELLI = new Version2017RegionType(SCHEME, "IT-VC");

    // IT Verona
    public static final Version2017RegionType IT_VERONA = new Version2017RegionType(SCHEME, "IT-VR");

    // IT Vibo Valentia
    public static final Version2017RegionType IT_VIBO_VALENTIA = new Version2017RegionType(SCHEME, "IT-VV");

    // IT Vicenza
    public static final Version2017RegionType IT_VICENZA = new Version2017RegionType(SCHEME, "IT-VI");

    // IT Viterbo
    public static final Version2017RegionType IT_VITERBO = new Version2017RegionType(SCHEME, "IT-VT");

    // JM Clarendon
    public static final Version2017RegionType JM_CLARENDON = new Version2017RegionType(SCHEME, "JM-13");

    // JM Hanover
    public static final Version2017RegionType JM_HANOVER = new Version2017RegionType(SCHEME, "JM-09");

    // JM Kingston
    public static final Version2017RegionType JM_KINGSTON = new Version2017RegionType(SCHEME, "JM-01");

    // JM Manchester
    public static final Version2017RegionType JM_MANCHESTER = new Version2017RegionType(SCHEME, "JM-12");

    // JM Portland
    public static final Version2017RegionType JM_PORTLAND = new Version2017RegionType(SCHEME, "JM-04");

    // JM Saint Andrew
    public static final Version2017RegionType JM_SAINT_ANDREW = new Version2017RegionType(SCHEME, "JM-02");

    // JM Saint Ann
    public static final Version2017RegionType JM_SAINT_ANN = new Version2017RegionType(SCHEME, "JM-06");

    // JM Saint Catherine
    public static final Version2017RegionType JM_SAINT_CATHERINE = new Version2017RegionType(SCHEME, "JM-14");

    // JM Saint Elizabeth
    public static final Version2017RegionType JM_SAINT_ELIZABETH = new Version2017RegionType(SCHEME, "JM-11");

    // JM Saint James
    public static final Version2017RegionType JM_SAINT_JAMES = new Version2017RegionType(SCHEME, "JM-08");

    // JM Saint Mary
    public static final Version2017RegionType JM_SAINT_MARY = new Version2017RegionType(SCHEME, "JM-05");

    // JM Saint Thomas
    public static final Version2017RegionType JM_SAINT_THOMAS = new Version2017RegionType(SCHEME, "JM-03");

    // JM Trelawny
    public static final Version2017RegionType JM_TRELAWNY = new Version2017RegionType(SCHEME, "JM-07");

    // JM Westmoreland
    public static final Version2017RegionType JM_WESTMORELAND = new Version2017RegionType(SCHEME, "JM-10");

    // JO Ajlun
    public static final Version2017RegionType JO_AJLUN = new Version2017RegionType(SCHEME, "JO-AJ");

    // JO Al Aqaba
    public static final Version2017RegionType JO_AL_AQABA = new Version2017RegionType(SCHEME, "JO-AQ");

    // JO Al Balqa
    public static final Version2017RegionType JO_AL_BALQA = new Version2017RegionType(SCHEME, "JO-BA");

    // JO Al Karak
    public static final Version2017RegionType JO_AL_KARAK = new Version2017RegionType(SCHEME, "JO-KA");

    // JO Al Mafraq
    public static final Version2017RegionType JO_AL_MAFRAQ = new Version2017RegionType(SCHEME, "JO-MA");

    // JO Amman
    public static final Version2017RegionType JO_AMMAN = new Version2017RegionType(SCHEME, "JO-AM");

    // JO At Tafilah
    public static final Version2017RegionType JO_AT_TAFILAH = new Version2017RegionType(SCHEME, "JO-AT");

    // JO Az Zarqa
    public static final Version2017RegionType JO_AZ_ZARQA = new Version2017RegionType(SCHEME, "JO-AZ");

    // JO Irbid
    public static final Version2017RegionType JO_IRBID = new Version2017RegionType(SCHEME, "JO-IR");

    // JO Jarash
    public static final Version2017RegionType JO_JARASH = new Version2017RegionType(SCHEME, "JO-JA");

    // JO Madaba
    public static final Version2017RegionType JO_MADABA = new Version2017RegionType(SCHEME, "JO-MD");

    // JO Ma An
    public static final Version2017RegionType JO_MA_AN = new Version2017RegionType(SCHEME, "JO-MN");

    // JP Aichi
    public static final Version2017RegionType JP_AICHI = new Version2017RegionType(SCHEME, "JP-23");

    // JP Akita
    public static final Version2017RegionType JP_AKITA = new Version2017RegionType(SCHEME, "JP-05");

    // JP Aomori
    public static final Version2017RegionType JP_AOMORI = new Version2017RegionType(SCHEME, "JP-02");

    // JP Chiba
    public static final Version2017RegionType JP_CHIBA = new Version2017RegionType(SCHEME, "JP-12");

    // JP Ehime
    public static final Version2017RegionType JP_EHIME = new Version2017RegionType(SCHEME, "JP-38");

    // JP Fukui
    public static final Version2017RegionType JP_FUKUI = new Version2017RegionType(SCHEME, "JP-18");

    // JP Fukuoka
    public static final Version2017RegionType JP_FUKUOKA = new Version2017RegionType(SCHEME, "JP-40");

    // JP Fukushima
    public static final Version2017RegionType JP_FUKUSHIMA = new Version2017RegionType(SCHEME, "JP-07");

    // JP Gifu
    public static final Version2017RegionType JP_GIFU = new Version2017RegionType(SCHEME, "JP-21");

    // JP Gunma
    public static final Version2017RegionType JP_GUNMA = new Version2017RegionType(SCHEME, "JP-10");

    // JP Hiroshima
    public static final Version2017RegionType JP_HIROSHIMA = new Version2017RegionType(SCHEME, "JP-34");

    // JP Hokkaido
    public static final Version2017RegionType JP_HOKKAIDO = new Version2017RegionType(SCHEME, "JP-01");

    // JP Hyogo
    public static final Version2017RegionType JP_HYOGO = new Version2017RegionType(SCHEME, "JP-28");

    // JP Ibaraki
    public static final Version2017RegionType JP_IBARAKI = new Version2017RegionType(SCHEME, "JP-08");

    // JP Ishikawa
    public static final Version2017RegionType JP_ISHIKAWA = new Version2017RegionType(SCHEME, "JP-17");

    // JP Iwate
    public static final Version2017RegionType JP_IWATE = new Version2017RegionType(SCHEME, "JP-03");

    // JP Kagawa
    public static final Version2017RegionType JP_KAGAWA = new Version2017RegionType(SCHEME, "JP-37");

    // JP Kagoshima
    public static final Version2017RegionType JP_KAGOSHIMA = new Version2017RegionType(SCHEME, "JP-46");

    // JP Kanagawa
    public static final Version2017RegionType JP_KANAGAWA = new Version2017RegionType(SCHEME, "JP-14");

    // JP Koti
    public static final Version2017RegionType JP_KOTI = new Version2017RegionType(SCHEME, "JP-39");

    // JP Kumamoto
    public static final Version2017RegionType JP_KUMAMOTO = new Version2017RegionType(SCHEME, "JP-43");

    // JP Kyoto
    public static final Version2017RegionType JP_KYOTO = new Version2017RegionType(SCHEME, "JP-26");

    // JP Mie
    public static final Version2017RegionType JP_MIE = new Version2017RegionType(SCHEME, "JP-24");

    // JP Miyagi
    public static final Version2017RegionType JP_MIYAGI = new Version2017RegionType(SCHEME, "JP-04");

    // JP Miyazaki
    public static final Version2017RegionType JP_MIYAZAKI = new Version2017RegionType(SCHEME, "JP-45");

    // JP Nagano
    public static final Version2017RegionType JP_NAGANO = new Version2017RegionType(SCHEME, "JP-20");

    // JP Nagasaki
    public static final Version2017RegionType JP_NAGASAKI = new Version2017RegionType(SCHEME, "JP-42");

    // JP Nara
    public static final Version2017RegionType JP_NARA = new Version2017RegionType(SCHEME, "JP-29");

    // JP Niigata
    public static final Version2017RegionType JP_NIIGATA = new Version2017RegionType(SCHEME, "JP-15");

    // JP Oita
    public static final Version2017RegionType JP_OITA = new Version2017RegionType(SCHEME, "JP-44");

    // JP Okayama
    public static final Version2017RegionType JP_OKAYAMA = new Version2017RegionType(SCHEME, "JP-33");

    // JP Okinawa
    public static final Version2017RegionType JP_OKINAWA = new Version2017RegionType(SCHEME, "JP-47");

    // JP Osaka
    public static final Version2017RegionType JP_OSAKA = new Version2017RegionType(SCHEME, "JP-27");

    // JP Saga
    public static final Version2017RegionType JP_SAGA = new Version2017RegionType(SCHEME, "JP-41");

    // JP Saitama
    public static final Version2017RegionType JP_SAITAMA = new Version2017RegionType(SCHEME, "JP-11");

    // JP Shiga
    public static final Version2017RegionType JP_SHIGA = new Version2017RegionType(SCHEME, "JP-25");

    // JP Shimane
    public static final Version2017RegionType JP_SHIMANE = new Version2017RegionType(SCHEME, "JP-32");

    // JP Shizuoka
    public static final Version2017RegionType JP_SHIZUOKA = new Version2017RegionType(SCHEME, "JP-22");

    // JP Tochigi
    public static final Version2017RegionType JP_TOCHIGI = new Version2017RegionType(SCHEME, "JP-09");

    // JP Tokushima
    public static final Version2017RegionType JP_TOKUSHIMA = new Version2017RegionType(SCHEME, "JP-36");

    // JP Tokyo
    public static final Version2017RegionType JP_TOKYO = new Version2017RegionType(SCHEME, "JP-13");

    // JP Tottori
    public static final Version2017RegionType JP_TOTTORI = new Version2017RegionType(SCHEME, "JP-31");

    // JP Toyama
    public static final Version2017RegionType JP_TOYAMA = new Version2017RegionType(SCHEME, "JP-16");

    // JP Wakayama
    public static final Version2017RegionType JP_WAKAYAMA = new Version2017RegionType(SCHEME, "JP-30");

    // JP Yamagata
    public static final Version2017RegionType JP_YAMAGATA = new Version2017RegionType(SCHEME, "JP-06");

    // JP Yamaguchi
    public static final Version2017RegionType JP_YAMAGUCHI = new Version2017RegionType(SCHEME, "JP-35");

    // JP Yamanashi
    public static final Version2017RegionType JP_YAMANASHI = new Version2017RegionType(SCHEME, "JP-19");

    // KE Central, KE
    public static final Version2017RegionType KE_CENTRAL = new Version2017RegionType(SCHEME, "KE-200");

    // KE Coast
    public static final Version2017RegionType KE_COAST = new Version2017RegionType(SCHEME, "KE-300");

    // KE Eastern, KE
    public static final Version2017RegionType KE_EASTERN = new Version2017RegionType(SCHEME, "KE-400");

    // KE Nairobi Municipality
    public static final Version2017RegionType KE_NAIROBI_MUNICIPALITY = new Version2017RegionType(SCHEME, "KE-110");

    // KE North-eastern
    public static final Version2017RegionType KE_NORTH_EASTERN = new Version2017RegionType(SCHEME, "KE-500");

    // KE Nyanza
    public static final Version2017RegionType KE_NYANZA = new Version2017RegionType(SCHEME, "KE-600");

    // KE Rift Valley
    public static final Version2017RegionType KE_RIFT_VALLEY = new Version2017RegionType(SCHEME, "KE-700");

    // KE Western, KE
    public static final Version2017RegionType KE_WESTERN = new Version2017RegionType(SCHEME, "KE-900");

    // KG Batken
    public static final Version2017RegionType KG_BATKEN = new Version2017RegionType(SCHEME, "KG-B");

    // KG Bishkek
    public static final Version2017RegionType KG_BISHKEK = new Version2017RegionType(SCHEME, "KG-GB");

    // KG Chu
    public static final Version2017RegionType KG_CHU = new Version2017RegionType(SCHEME, "KG-C");

    // KG Jalal-abad
    public static final Version2017RegionType KG_JALAL_ABAD = new Version2017RegionType(SCHEME, "KG-J");

    // KG Naryn
    public static final Version2017RegionType KG_NARYN = new Version2017RegionType(SCHEME, "KG-N");

    // KG Osh
    public static final Version2017RegionType KG_OSH = new Version2017RegionType(SCHEME, "KG-O");

    // KG Talas
    public static final Version2017RegionType KG_TALAS = new Version2017RegionType(SCHEME, "KG-T");

    // KG Ysyk-kol
    public static final Version2017RegionType KG_YSYK_KOL = new Version2017RegionType(SCHEME, "KG-Y");

    // KH Baat Dambang
    public static final Version2017RegionType KH_BAAT_DAMBANG = new Version2017RegionType(SCHEME, "KH-2");

    // KH Banteay Meanchey
    public static final Version2017RegionType KH_BANTEAY_MEANCHEY = new Version2017RegionType(SCHEME, "KH-1");

    // KH Kampong Cham
    public static final Version2017RegionType KH_KAMPONG_CHAM = new Version2017RegionType(SCHEME, "KH-3");

    // KH Kampong Chhnang
    public static final Version2017RegionType KH_KAMPONG_CHHNANG = new Version2017RegionType(SCHEME, "KH-4");

    // KH Kampong Spo
    public static final Version2017RegionType KH_KAMPONG_SPO = new Version2017RegionType(SCHEME, "KH-5");

    // KH Kampong Thum
    public static final Version2017RegionType KH_KAMPONG_THUM = new Version2017RegionType(SCHEME, "KH-6");

    // KH Kampot
    public static final Version2017RegionType KH_KAMPOT = new Version2017RegionType(SCHEME, "KH-7");

    // KH Kandal
    public static final Version2017RegionType KH_KANDAL = new Version2017RegionType(SCHEME, "KH-8");

    // KH Kaoh Kong
    public static final Version2017RegionType KH_KAOH_KONG = new Version2017RegionType(SCHEME, "KH-9");

    // KH Kracheh
    public static final Version2017RegionType KH_KRACHEH = new Version2017RegionType(SCHEME, "KH-10");

    // KH Krong Kaeb
    public static final Version2017RegionType KH_KRONG_KAEB = new Version2017RegionType(SCHEME, "KH-23");

    // KH Krong Pailin
    public static final Version2017RegionType KH_KRONG_PAILIN = new Version2017RegionType(SCHEME, "KH-24");

    // KH Krong Preah Sihanouk
    public static final Version2017RegionType KH_KRONG_PREAH_SIHANOUK = new Version2017RegionType(SCHEME, "KH-18");

    // KH Mondol Kiri
    public static final Version2017RegionType KH_MONDOL_KIRI = new Version2017RegionType(SCHEME, "KH-11");

    // KH Otdar Mean Chey
    public static final Version2017RegionType KH_OTDAR_MEAN_CHEY = new Version2017RegionType(SCHEME, "KH-22");

    // KH Phnum Penh
    public static final Version2017RegionType KH_PHNUM_PENH = new Version2017RegionType(SCHEME, "KH-12");

    // KH Pouthisat
    public static final Version2017RegionType KH_POUTHISAT = new Version2017RegionType(SCHEME, "KH-15");

    // KH Preah Vihear
    public static final Version2017RegionType KH_PREAH_VIHEAR = new Version2017RegionType(SCHEME, "KH-13");

    // KH Prey Veng
    public static final Version2017RegionType KH_PREY_VENG = new Version2017RegionType(SCHEME, "KH-14");

    // KH Rotanokiri
    public static final Version2017RegionType KH_ROTANOKIRI = new Version2017RegionType(SCHEME, "KH-16");

    // KH Siemreab
    public static final Version2017RegionType KH_SIEMREAB = new Version2017RegionType(SCHEME, "KH-17");

    // KH Stueng Traeng
    public static final Version2017RegionType KH_STUENG_TRAENG = new Version2017RegionType(SCHEME, "KH-19");

    // KH Svaay Rieng
    public static final Version2017RegionType KH_SVAAY_RIENG = new Version2017RegionType(SCHEME, "KH-20");

    // KH Takev
    public static final Version2017RegionType KH_TAKEV = new Version2017RegionType(SCHEME, "KH-21");

    // KI Gilbert Islands
    public static final Version2017RegionType KI_GILBERT_ISLANDS = new Version2017RegionType(SCHEME, "KI-G");

    // KI Line Islands
    public static final Version2017RegionType KI_LINE_ISLANDS = new Version2017RegionType(SCHEME, "KI-L");

    // KI Phoenix Islands
    public static final Version2017RegionType KI_PHOENIX_ISLANDS = new Version2017RegionType(SCHEME, "KI-P");

    // KM Anjouan
    public static final Version2017RegionType KM_ANJOUAN = new Version2017RegionType(SCHEME, "KM-A");

    // KM Grande Comore
    public static final Version2017RegionType KM_GRANDE_COMORE = new Version2017RegionType(SCHEME, "KM-G");

    // KM Moheli
    public static final Version2017RegionType KM_MOHELI = new Version2017RegionType(SCHEME, "KM-M");

    // KP Chagang-do
    public static final Version2017RegionType KP_CHAGANG_DO = new Version2017RegionType(SCHEME, "KP-CHA");

    // KP Hamgyongbuk-do
    public static final Version2017RegionType KP_HAMGYONGBUK_DO = new Version2017RegionType(SCHEME, "KP-HAB");

    // KP Hamgyongnam-do
    public static final Version2017RegionType KP_HAMGYONGNAM_DO = new Version2017RegionType(SCHEME, "KP-HAN");

    // KP Hwanghaebuk-do
    public static final Version2017RegionType KP_HWANGHAEBUK_DO = new Version2017RegionType(SCHEME, "KP-HWB");

    // KP Hwanghaenam-do
    public static final Version2017RegionType KP_HWANGHAENAM_DO = new Version2017RegionType(SCHEME, "KP-HWN");

    // KP Kaesong-si
    public static final Version2017RegionType KP_KAESONG_SI = new Version2017RegionType(SCHEME, "KP-KAE");

    // KP Kangwon-do
    public static final Version2017RegionType KP_KANGWON_DO = new Version2017RegionType(SCHEME, "KP-KAN");

    // KP Najin Sonbong-si
    public static final Version2017RegionType KP_NAJIN_SONBONG_SI = new Version2017RegionType(SCHEME, "KP-NAJ");

    // KP Nampo-si
    public static final Version2017RegionType KP_NAMPO_SI = new Version2017RegionType(SCHEME, "KP-NAM");

    // KP Pyonganbuk-do
    public static final Version2017RegionType KP_PYONGANBUK_DO = new Version2017RegionType(SCHEME, "KP-PYB");

    // KP Pyongannam-do
    public static final Version2017RegionType KP_PYONGANNAM_DO = new Version2017RegionType(SCHEME, "KP-PYN");

    // KP Pyongyang-si
    public static final Version2017RegionType KP_PYONGYANG_SI = new Version2017RegionType(SCHEME, "KP-PYO");

    // KP Yanggang-do
    public static final Version2017RegionType KP_YANGGANG_DO = new Version2017RegionType(SCHEME, "KP-YAN");

    // KR Busan Gwangyeogsi
    public static final Version2017RegionType KR_BUSAN_GWANGYEOGSI = new Version2017RegionType(SCHEME, "KR-26");

    // KR Cheju-do
    public static final Version2017RegionType KR_CHEJU_DO = new Version2017RegionType(SCHEME, "KR-49");

    // KR Chungcheongbugdo
    public static final Version2017RegionType KR_CHUNGCHEONGBUGDO = new Version2017RegionType(SCHEME, "KR-43");

    // KR Chungcheongnamdo
    public static final Version2017RegionType KR_CHUNGCHEONGNAMDO = new Version2017RegionType(SCHEME, "KR-44");

    // KR Daegu Gwangyeogsi
    public static final Version2017RegionType KR_DAEGU_GWANGYEOGSI = new Version2017RegionType(SCHEME, "KR-27");

    // KR Daejeon Gwangyeogsi
    public static final Version2017RegionType KR_DAEJEON_GWANGYEOGSI = new Version2017RegionType(SCHEME, "KR-30");

    // KR Gwangju Gwangyeogsi
    public static final Version2017RegionType KR_GWANGJU_GWANGYEOGSI = new Version2017RegionType(SCHEME, "KR-29");

    // KR Gyeonggido
    public static final Version2017RegionType KR_GYEONGGIDO = new Version2017RegionType(SCHEME, "KR-41");

    // KR Gyeongsangbugdo
    public static final Version2017RegionType KR_GYEONGSANGBUGDO = new Version2017RegionType(SCHEME, "KR-47");

    // KR Gyeongsangnamdo
    public static final Version2017RegionType KR_GYEONGSANGNAMDO = new Version2017RegionType(SCHEME, "KR-48");

    // KR Incheon Gwangyeogsi
    public static final Version2017RegionType KR_INCHEON_GWANGYEOGSI = new Version2017RegionType(SCHEME, "KR-28");

    // KR Jeonrabugdo
    public static final Version2017RegionType KR_JEONRABUGDO = new Version2017RegionType(SCHEME, "KR-45");

    // KR Jeonranamdo
    public static final Version2017RegionType KR_JEONRANAMDO = new Version2017RegionType(SCHEME, "KR-46");

    // KR Kang-won-do
    public static final Version2017RegionType KR_KANG_WON_DO = new Version2017RegionType(SCHEME, "KR-42");

    // KR Seoul Teugbyeolsi
    public static final Version2017RegionType KR_SEOUL_TEUGBYEOLSI = new Version2017RegionType(SCHEME, "KR-11");

    // KR Ulsan Gwangyeogsi
    public static final Version2017RegionType KR_ULSAN_GWANGYEOGSI = new Version2017RegionType(SCHEME, "KR-31");

    // KW Al Ahmadi
    public static final Version2017RegionType KW_AL_AHMADI = new Version2017RegionType(SCHEME, "KW-AH");

    // KW Al Farwaniyah
    public static final Version2017RegionType KW_AL_FARWANIYAH = new Version2017RegionType(SCHEME, "KW-FA");

    // KW Al Jahrah
    public static final Version2017RegionType KW_AL_JAHRAH = new Version2017RegionType(SCHEME, "KW-JA");

    // KW Al Kuwayt
    public static final Version2017RegionType KW_AL_KUWAYT = new Version2017RegionType(SCHEME, "KW-KU");

    // KW Hawalli
    public static final Version2017RegionType KW_HAWALLI = new Version2017RegionType(SCHEME, "KW-HA");

    // KZ Almaty
    public static final Version2017RegionType KZ_ALMATY = new Version2017RegionType(SCHEME, "KZ-ALA");

    // KZ Almaty Oblysy
    public static final Version2017RegionType KZ_ALMATY_OBLYSY = new Version2017RegionType(SCHEME, "KZ-ALM");

    // KZ Aqmola Oblysy
    public static final Version2017RegionType KZ_AQMOLA_OBLYSY = new Version2017RegionType(SCHEME, "KZ-AKM");

    // KZ Aqtobe Oblysy
    public static final Version2017RegionType KZ_AQTOBE_OBLYSY = new Version2017RegionType(SCHEME, "KZ-AKT");

    // KZ Astana
    public static final Version2017RegionType KZ_ASTANA = new Version2017RegionType(SCHEME, "KZ-AST");

    // KZ Atyrau Oblysy
    public static final Version2017RegionType KZ_ATYRAU_OBLYSY = new Version2017RegionType(SCHEME, "KZ-ATY");

    // KZ Batys Qazaqstan Oblysy
    public static final Version2017RegionType KZ_BATYS_QAZAQSTAN_OBLYSY = new Version2017RegionType(SCHEME, "KZ-ZAP");

    // KZ Mangghystau Oblysy
    public static final Version2017RegionType KZ_MANGGHYSTAU_OBLYSY = new Version2017RegionType(SCHEME, "KZ-MAN");

    // KZ Ongtustik Qazaqstan Oblysy
    public static final Version2017RegionType KZ_ONGTUSTIK_QAZAQSTAN_OBLYSY = new Version2017RegionType(SCHEME, "KZ-YUZ");

    // KZ Pavlodar Oblysy
    public static final Version2017RegionType KZ_PAVLODAR_OBLYSY = new Version2017RegionType(SCHEME, "KZ-PAV");

    // KZ Qaraghandy Oblysy
    public static final Version2017RegionType KZ_QARAGHANDY_OBLYSY = new Version2017RegionType(SCHEME, "KZ-KAR");

    // KZ Qostanay Oblysy
    public static final Version2017RegionType KZ_QOSTANAY_OBLYSY = new Version2017RegionType(SCHEME, "KZ-KUS");

    // KZ Qyzylorda Oblysy
    public static final Version2017RegionType KZ_QYZYLORDA_OBLYSY = new Version2017RegionType(SCHEME, "KZ-KZY");

    // KZ Shyghys Qazaqstan Oblysy
    public static final Version2017RegionType KZ_SHYGHYS_QAZAQSTAN_OBLYSY = new Version2017RegionType(SCHEME, "KZ-VOS");

    // KZ Soltustik Qazaqstan Oblysy
    public static final Version2017RegionType KZ_SOLTUSTIK_QAZAQSTAN_OBLYSY = new Version2017RegionType(SCHEME, "KZ-SEV");

    // KZ Zhambyl Oblysy
    public static final Version2017RegionType KZ_ZHAMBYL_OBLYSY = new Version2017RegionType(SCHEME, "KZ-ZHA");

    // LA Attopeu
    public static final Version2017RegionType LA_ATTOPEU = new Version2017RegionType(SCHEME, "LA-AT");

    // LA Bokeo
    public static final Version2017RegionType LA_BOKEO = new Version2017RegionType(SCHEME, "LA-BK");

    // LA Borikhane
    public static final Version2017RegionType LA_BORIKHANE = new Version2017RegionType(SCHEME, "LA-BL");

    // LA Champassak
    public static final Version2017RegionType LA_CHAMPASSAK = new Version2017RegionType(SCHEME, "LA-CH");

    // LA Houaphan
    public static final Version2017RegionType LA_HOUAPHAN = new Version2017RegionType(SCHEME, "LA-HO");

    // LA Khammouan
    public static final Version2017RegionType LA_KHAMMOUAN = new Version2017RegionType(SCHEME, "LA-KH");

    // LA Louang Namtha
    public static final Version2017RegionType LA_LOUANG_NAMTHA = new Version2017RegionType(SCHEME, "LA-LM");

    // LA Louang Prabang
    public static final Version2017RegionType LA_LOUANG_PRABANG = new Version2017RegionType(SCHEME, "LA-LP");

    // LA Oudomsai
    public static final Version2017RegionType LA_OUDOMSAI = new Version2017RegionType(SCHEME, "LA-OU");

    // LA Phong Saly
    public static final Version2017RegionType LA_PHONG_SALY = new Version2017RegionType(SCHEME, "LA-PH");

    // LA Saravane
    public static final Version2017RegionType LA_SARAVANE = new Version2017RegionType(SCHEME, "LA-SL");

    // LA Savannakhet
    public static final Version2017RegionType LA_SAVANNAKHET = new Version2017RegionType(SCHEME, "LA-SV");

    // LA Sayaboury
    public static final Version2017RegionType LA_SAYABOURY = new Version2017RegionType(SCHEME, "LA-XA");

    // LA Sekong
    public static final Version2017RegionType LA_SEKONG = new Version2017RegionType(SCHEME, "LA-XE");

    // LA Vientiane
    public static final Version2017RegionType LA_VIENTIANE = new Version2017RegionType(SCHEME, "LA-VT");

    // LA Vientiane, LA
    public static final Version2017RegionType LA_VIENTIANE_LA_VI = new Version2017RegionType(SCHEME, "LA-VI");

    // LA Xaisomboun
    public static final Version2017RegionType LA_XAISOMBOUN = new Version2017RegionType(SCHEME, "LA-XN");

    // LA Xieng Khouang
    public static final Version2017RegionType LA_XIENG_KHOUANG = new Version2017RegionType(SCHEME, "LA-XI");

    // LB Beirout
    public static final Version2017RegionType LB_BEIROUT = new Version2017RegionType(SCHEME, "LB-BA");

    // LB El Beqaa
    public static final Version2017RegionType LB_EL_BEQAA = new Version2017RegionType(SCHEME, "LB-BI");

    // LB Jabal Loubnane
    public static final Version2017RegionType LB_JABAL_LOUBNANE = new Version2017RegionType(SCHEME, "LB-JL");

    // LB Loubnane Ech Chemali
    public static final Version2017RegionType LB_LOUBNANE_ECH_CHEMALI = new Version2017RegionType(SCHEME, "LB-AS");

    // LB Loubnane Ej Jnoubi
    public static final Version2017RegionType LB_LOUBNANE_EJ_JNOUBI = new Version2017RegionType(SCHEME, "LB-JA");

    // LB Nabatiye
    public static final Version2017RegionType LB_NABATIYE = new Version2017RegionType(SCHEME, "LB-NA");

    // LK Ampara
    public static final Version2017RegionType LK_AMPARA = new Version2017RegionType(SCHEME, "LK-52");

    // LK Anuradhapura
    public static final Version2017RegionType LK_ANURADHAPURA = new Version2017RegionType(SCHEME, "LK-71");

    // LK Badulla
    public static final Version2017RegionType LK_BADULLA = new Version2017RegionType(SCHEME, "LK-81");

    // LK Batticaloa
    public static final Version2017RegionType LK_BATTICALOA = new Version2017RegionType(SCHEME, "LK-51");

    // LK Colombo
    public static final Version2017RegionType LK_COLOMBO = new Version2017RegionType(SCHEME, "LK-11");

    // LK Galle
    public static final Version2017RegionType LK_GALLE = new Version2017RegionType(SCHEME, "LK-31");

    // LK Gampaha
    public static final Version2017RegionType LK_GAMPAHA = new Version2017RegionType(SCHEME, "LK-12");

    // LK Hambantota
    public static final Version2017RegionType LK_HAMBANTOTA = new Version2017RegionType(SCHEME, "LK-33");

    // LK Jaffna
    public static final Version2017RegionType LK_JAFFNA = new Version2017RegionType(SCHEME, "LK-41");

    // LK Kalutara
    public static final Version2017RegionType LK_KALUTARA = new Version2017RegionType(SCHEME, "LK-13");

    // LK Kandy
    public static final Version2017RegionType LK_KANDY = new Version2017RegionType(SCHEME, "LK-21");

    // LK Kegalla
    public static final Version2017RegionType LK_KEGALLA = new Version2017RegionType(SCHEME, "LK-92");

    // LK Kilinochchi
    public static final Version2017RegionType LK_KILINOCHCHI = new Version2017RegionType(SCHEME, "LK-42");

    // LK Kurunegala
    public static final Version2017RegionType LK_KURUNEGALA = new Version2017RegionType(SCHEME, "LK-61");

    // LK Mannar
    public static final Version2017RegionType LK_MANNAR = new Version2017RegionType(SCHEME, "LK-43");

    // LK Matale
    public static final Version2017RegionType LK_MATALE = new Version2017RegionType(SCHEME, "LK-22");

    // LK Matara
    public static final Version2017RegionType LK_MATARA = new Version2017RegionType(SCHEME, "LK-32");

    // LK Monaragala
    public static final Version2017RegionType LK_MONARAGALA = new Version2017RegionType(SCHEME, "LK-82");

    // LK Mullaittivu
    public static final Version2017RegionType LK_MULLAITTIVU = new Version2017RegionType(SCHEME, "LK-45");

    // LK Nuwara Eliya
    public static final Version2017RegionType LK_NUWARA_ELIYA = new Version2017RegionType(SCHEME, "LK-23");

    // LK Polonnaruwa
    public static final Version2017RegionType LK_POLONNARUWA = new Version2017RegionType(SCHEME, "LK-72");

    // LK Puttalam
    public static final Version2017RegionType LK_PUTTALAM = new Version2017RegionType(SCHEME, "LK-62");

    // LK Ratnapura
    public static final Version2017RegionType LK_RATNAPURA = new Version2017RegionType(SCHEME, "LK-91");

    // LK Trincomalee
    public static final Version2017RegionType LK_TRINCOMALEE = new Version2017RegionType(SCHEME, "LK-53");

    // LK Vavuniya
    public static final Version2017RegionType LK_VAVUNIYA = new Version2017RegionType(SCHEME, "LK-44");

    // LR Bomi
    public static final Version2017RegionType LR_BOMI = new Version2017RegionType(SCHEME, "LR-BM");

    // LR Bong
    public static final Version2017RegionType LR_BONG = new Version2017RegionType(SCHEME, "LR-BG");

    // LR Grand Bassa
    public static final Version2017RegionType LR_GRAND_BASSA = new Version2017RegionType(SCHEME, "LR-GB");

    // LR Grand Cape Mount
    public static final Version2017RegionType LR_GRAND_CAPE_MOUNT = new Version2017RegionType(SCHEME, "LR-CM");

    // LR Grand Gedeh
    public static final Version2017RegionType LR_GRAND_GEDEH = new Version2017RegionType(SCHEME, "LR-GG");

    // LR Grand Kru
    public static final Version2017RegionType LR_GRAND_KRU = new Version2017RegionType(SCHEME, "LR-GK");

    // LR Lofa
    public static final Version2017RegionType LR_LOFA = new Version2017RegionType(SCHEME, "LR-LO");

    // LR Margibi
    public static final Version2017RegionType LR_MARGIBI = new Version2017RegionType(SCHEME, "LR-MG");

    // LR Maryland, LR
    public static final Version2017RegionType LR_MARYLAND = new Version2017RegionType(SCHEME, "LR-MY");

    // LR Montserrado
    public static final Version2017RegionType LR_MONTSERRADO = new Version2017RegionType(SCHEME, "LR-MO");

    // LR Nimba
    public static final Version2017RegionType LR_NIMBA = new Version2017RegionType(SCHEME, "LR-NI");

    // LR Rivercess
    public static final Version2017RegionType LR_RIVERCESS = new Version2017RegionType(SCHEME, "LR-RI");

    // LR Sinoe
    public static final Version2017RegionType LR_SINOE = new Version2017RegionType(SCHEME, "LR-SI");

    // LS Berea
    public static final Version2017RegionType LS_BEREA = new Version2017RegionType(SCHEME, "LS-D");

    // LS Butha-buthe
    public static final Version2017RegionType LS_BUTHA_BUTHE = new Version2017RegionType(SCHEME, "LS-B");

    // LS Leribe
    public static final Version2017RegionType LS_LERIBE = new Version2017RegionType(SCHEME, "LS-C");

    // LS Mafeteng
    public static final Version2017RegionType LS_MAFETENG = new Version2017RegionType(SCHEME, "LS-E");

    // LS Maseru
    public static final Version2017RegionType LS_MASERU = new Version2017RegionType(SCHEME, "LS-A");

    // LS Mohale's Hoek
    public static final Version2017RegionType LS_MOHALES_HOEK = new Version2017RegionType(SCHEME, "LS-F");

    // LS Mokhotlong
    public static final Version2017RegionType LS_MOKHOTLONG = new Version2017RegionType(SCHEME, "LS-J");

    // LS Qacha's Nek
    public static final Version2017RegionType LS_QACHAS_NEK = new Version2017RegionType(SCHEME, "LS-H");

    // LS Quthing
    public static final Version2017RegionType LS_QUTHING = new Version2017RegionType(SCHEME, "LS-G");

    // LS Thaba-tseka
    public static final Version2017RegionType LS_THABA_TSEKA = new Version2017RegionType(SCHEME, "LS-K");

    // LT Alytaus Apskritis
    public static final Version2017RegionType LT_ALYTAUS_APSKRITIS = new Version2017RegionType(SCHEME, "LT-AL");

    // LT Kauno Apskritis
    public static final Version2017RegionType LT_KAUNO_APSKRITIS = new Version2017RegionType(SCHEME, "LT-KU");

    // LT Klaipedos Apskritis
    public static final Version2017RegionType LT_KLAIPEDOS_APSKRITIS = new Version2017RegionType(SCHEME, "LT-KL");

    // LT Liauliu Apskritis
    public static final Version2017RegionType LT_LIAULIU_APSKRITIS = new Version2017RegionType(SCHEME, "LT-SA");

    // LT Marijampoles Apskritis
    public static final Version2017RegionType LT_MARIJAMPOLES_APSKRITIS = new Version2017RegionType(SCHEME, "LT-MR");

    // LT Panevelio Apskritis
    public static final Version2017RegionType LT_PANEVELIO_APSKRITIS = new Version2017RegionType(SCHEME, "LT-PN");

    // LT Taurages Apskritis
    public static final Version2017RegionType LT_TAURAGES_APSKRITIS = new Version2017RegionType(SCHEME, "LT-TA");

    // LT Teliu Apskritis
    public static final Version2017RegionType LT_TELIU_APSKRITIS = new Version2017RegionType(SCHEME, "LT-TE");

    // LT Utenos Apskritis
    public static final Version2017RegionType LT_UTENOS_APSKRITIS = new Version2017RegionType(SCHEME, "LT-UT");

    // LT Vilniaus Apskritis
    public static final Version2017RegionType LT_VILNIAUS_APSKRITIS = new Version2017RegionType(SCHEME, "LT-VL");

    // LU Diekirch
    public static final Version2017RegionType LU_DIEKIRCH = new Version2017RegionType(SCHEME, "LU-D");

    // LU Grevenmacher
    public static final Version2017RegionType LU_GREVENMACHER = new Version2017RegionType(SCHEME, "LU-G");

    // LU Luxembourg (fr)
    public static final Version2017RegionType LU_LUXEMBOURG_FR = new Version2017RegionType(SCHEME, "LU-L");

    // LV Aizkraukles Aprinkis
    public static final Version2017RegionType LV_AIZKRAUKLES_APRINKIS = new Version2017RegionType(SCHEME, "LV-AI");

    // LV Aluksnes Aprinkis
    public static final Version2017RegionType LV_ALUKSNES_APRINKIS = new Version2017RegionType(SCHEME, "LV-AL");

    // LV Balvu Aprinkis
    public static final Version2017RegionType LV_BALVU_APRINKIS = new Version2017RegionType(SCHEME, "LV-BL");

    // LV Bauskas Aprinkis
    public static final Version2017RegionType LV_BAUSKAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-BU");

    // LV Cesu Aprinkis
    public static final Version2017RegionType LV_CESU_APRINKIS = new Version2017RegionType(SCHEME, "LV-CE");

    // LV Daugavpils
    public static final Version2017RegionType LV_DAUGAVPILS = new Version2017RegionType(SCHEME, "LV-DGV");

    // LV Daugavpils Aprinkis
    public static final Version2017RegionType LV_DAUGAVPILS_APRINKIS = new Version2017RegionType(SCHEME, "LV-DA");

    // LV Dobeles Aprinkis
    public static final Version2017RegionType LV_DOBELES_APRINKIS = new Version2017RegionType(SCHEME, "LV-DO");

    // LV Gulbenes Aprinkis
    public static final Version2017RegionType LV_GULBENES_APRINKIS = new Version2017RegionType(SCHEME, "LV-GU");

    // LV Jekabpils Aprinkis
    public static final Version2017RegionType LV_JEKABPILS_APRINKIS = new Version2017RegionType(SCHEME, "LV-JK");

    // LV Jelgava
    public static final Version2017RegionType LV_JELGAVA = new Version2017RegionType(SCHEME, "LV-JEL");

    // LV Jelgavas Aprinkis
    public static final Version2017RegionType LV_JELGAVAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-JL");

    // LV Jurmala
    public static final Version2017RegionType LV_JURMALA = new Version2017RegionType(SCHEME, "LV-JUR");

    // LV Kraslavas Aprinkis
    public static final Version2017RegionType LV_KRASLAVAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-KR");

    // LV Kuldigas Aprinkis
    public static final Version2017RegionType LV_KULDIGAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-KU");

    // LV Liepaja
    public static final Version2017RegionType LV_LIEPAJA = new Version2017RegionType(SCHEME, "LV-LPX");

    // LV Liepajas Aprinkis
    public static final Version2017RegionType LV_LIEPAJAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-LE");

    // LV Limbazu Aprinkis
    public static final Version2017RegionType LV_LIMBAZU_APRINKIS = new Version2017RegionType(SCHEME, "LV-LM");

    // LV Ludzas Aprinkis
    public static final Version2017RegionType LV_LUDZAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-LU");

    // LV Madonas Aprinkis
    public static final Version2017RegionType LV_MADONAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-MA");

    // LV Ogres Aprinkis
    public static final Version2017RegionType LV_OGRES_APRINKIS = new Version2017RegionType(SCHEME, "LV-OG");

    // LV Preilu Aprinkis
    public static final Version2017RegionType LV_PREILU_APRINKIS = new Version2017RegionType(SCHEME, "LV-PR");

    // LV Rezekne
    public static final Version2017RegionType LV_REZEKNE = new Version2017RegionType(SCHEME, "LV-REZ");

    // LV Rezeknes Aprinkis
    public static final Version2017RegionType LV_REZEKNES_APRINKIS = new Version2017RegionType(SCHEME, "LV-RE");

    // LV Riga
    public static final Version2017RegionType LV_RIGA = new Version2017RegionType(SCHEME, "LV-RIX");

    // LV Rigas Aprinkis
    public static final Version2017RegionType LV_RIGAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-RI");

    // LV Saldus Aprinkis
    public static final Version2017RegionType LV_SALDUS_APRINKIS = new Version2017RegionType(SCHEME, "LV-SA");

    // LV Talsu Aprinkis
    public static final Version2017RegionType LV_TALSU_APRINKIS = new Version2017RegionType(SCHEME, "LV-TA");

    // LV Tukuma Aprinkis
    public static final Version2017RegionType LV_TUKUMA_APRINKIS = new Version2017RegionType(SCHEME, "LV-TU");

    // LV Valkas Aprinkis
    public static final Version2017RegionType LV_VALKAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-VK");

    // LV Valmieras Aprinkis
    public static final Version2017RegionType LV_VALMIERAS_APRINKIS = new Version2017RegionType(SCHEME, "LV-VM");

    // LV Ventspils
    public static final Version2017RegionType LV_VENTSPILS = new Version2017RegionType(SCHEME, "LV-VEN");

    // LV Ventspils Aprinkis
    public static final Version2017RegionType LV_VENTSPILS_APRINKIS = new Version2017RegionType(SCHEME, "LV-VE");

    // LY Ajdabiya
    public static final Version2017RegionType LY_AJDABIYA = new Version2017RegionType(SCHEME, "LY-AJ");

    // LY Al Butnan
    public static final Version2017RegionType LY_AL_BUTNAN = new Version2017RegionType(SCHEME, "LY-BU");

    // LY Al Hizam Al Akhdar
    public static final Version2017RegionType LY_AL_HIZAM_AL_AKHDAR = new Version2017RegionType(SCHEME, "LY-HZ");

    // LY Al Jabal Al Akhdar
    public static final Version2017RegionType LY_AL_JABAL_AL_AKHDAR = new Version2017RegionType(SCHEME, "LY-JA");

    // LY Al Jifarah
    public static final Version2017RegionType LY_AL_JIFARAH = new Version2017RegionType(SCHEME, "LY-JI");

    // LY Al Jufrah
    public static final Version2017RegionType LY_AL_JUFRAH = new Version2017RegionType(SCHEME, "LY-JU");

    // LY Al Kufrah
    public static final Version2017RegionType LY_AL_KUFRAH = new Version2017RegionType(SCHEME, "LY-KF");

    // LY Al Marj
    public static final Version2017RegionType LY_AL_MARJ = new Version2017RegionType(SCHEME, "LY-MJ");

    // LY Al Marqab
    public static final Version2017RegionType LY_AL_MARQAB = new Version2017RegionType(SCHEME, "LY-MB");

    // LY Al Qatrun
    public static final Version2017RegionType LY_AL_QATRUN = new Version2017RegionType(SCHEME, "LY-QT");

    // LY Al Qubbah
    public static final Version2017RegionType LY_AL_QUBBAH = new Version2017RegionType(SCHEME, "LY-QB");

    // LY Al Wahah
    public static final Version2017RegionType LY_AL_WAHAH = new Version2017RegionType(SCHEME, "LY-WA");

    // LY An Nuqat Al Khams
    public static final Version2017RegionType LY_AN_NUQAT_AL_KHAMS = new Version2017RegionType(SCHEME, "LY-NQ");

    // LY Ash Shati'
    public static final Version2017RegionType LY_ASH_SHATI = new Version2017RegionType(SCHEME, "LY-SH");

    // LY Az Zawiyah
    public static final Version2017RegionType LY_AZ_ZAWIYAH = new Version2017RegionType(SCHEME, "LY-ZA");

    // LY Banghazi
    public static final Version2017RegionType LY_BANGHAZI = new Version2017RegionType(SCHEME, "LY-BA");

    // LY Bani Walid
    public static final Version2017RegionType LY_BANI_WALID = new Version2017RegionType(SCHEME, "LY-BW");

    // LY Darnah
    public static final Version2017RegionType LY_DARNAH = new Version2017RegionType(SCHEME, "LY-DR");

    // LY Ghadamis
    public static final Version2017RegionType LY_GHADAMIS = new Version2017RegionType(SCHEME, "LY-GD");

    // LY Gharyan
    public static final Version2017RegionType LY_GHARYAN = new Version2017RegionType(SCHEME, "LY-GR");

    // LY Ghat
    public static final Version2017RegionType LY_GHAT = new Version2017RegionType(SCHEME, "LY-GT");

    // LY Jaghbub
    public static final Version2017RegionType LY_JAGHBUB = new Version2017RegionType(SCHEME, "LY-JB");

    // LY Misratah
    public static final Version2017RegionType LY_MISRATAH = new Version2017RegionType(SCHEME, "LY-MI");

    // LY Mizdah
    public static final Version2017RegionType LY_MIZDAH = new Version2017RegionType(SCHEME, "LY-MZ");

    // LY Murzuq
    public static final Version2017RegionType LY_MURZUQ = new Version2017RegionType(SCHEME, "LY-MQ");

    // LY Nalut
    public static final Version2017RegionType LY_NALUT = new Version2017RegionType(SCHEME, "LY-NL");

    // LY Sabha
    public static final Version2017RegionType LY_SABHA = new Version2017RegionType(SCHEME, "LY-SB");

    // LY Sabratah Surman
    public static final Version2017RegionType LY_SABRATAH_SURMAN = new Version2017RegionType(SCHEME, "LY-SS");

    // LY Surt
    public static final Version2017RegionType LY_SURT = new Version2017RegionType(SCHEME, "LY-SR");

    // LY Tajura Wa An Nawahi Arba
    public static final Version2017RegionType LY_TAJURA_WA_AN_NAWAHI_ARBA = new Version2017RegionType(SCHEME, "LY-TN");

    // LY Tarabulus
    public static final Version2017RegionType LY_TARABULUS = new Version2017RegionType(SCHEME, "LY-TB");

    // LY Tarhunah-masallatah
    public static final Version2017RegionType LY_TARHUNAH_MASALLATAH = new Version2017RegionType(SCHEME, "LY-TM");

    // LY Wadi Al Hayat
    public static final Version2017RegionType LY_WADI_AL_HAYAT = new Version2017RegionType(SCHEME, "LY-WD");

    // LY Yafran-jadu
    public static final Version2017RegionType LY_YAFRAN_JADU = new Version2017RegionType(SCHEME, "LY-YJ");

    // MA Agadir*
    public static final Version2017RegionType MA_AGADIR = new Version2017RegionType(SCHEME, "MA-AGD");

    // MA Ait Baha
    public static final Version2017RegionType MA_AIT_BAHA = new Version2017RegionType(SCHEME, "MA-BAH");

    // MA Ait Melloul
    public static final Version2017RegionType MA_AIT_MELLOUL = new Version2017RegionType(SCHEME, "MA-MEL");

    // MA Al Haouz
    public static final Version2017RegionType MA_AL_HAOUZ = new Version2017RegionType(SCHEME, "MA-HAO");

    // MA Al Hoceima
    public static final Version2017RegionType MA_AL_HOCEIMA = new Version2017RegionType(SCHEME, "MA-HOC");

    // MA Assa-zag
    public static final Version2017RegionType MA_ASSA_ZAG = new Version2017RegionType(SCHEME, "MA-ASZ");

    // MA Azilal
    public static final Version2017RegionType MA_AZILAL = new Version2017RegionType(SCHEME, "MA-AZI");

    // MA Beni Mellal
    public static final Version2017RegionType MA_BENI_MELLAL = new Version2017RegionType(SCHEME, "MA-BEM");

    // MA Ben Slimane
    public static final Version2017RegionType MA_BEN_SLIMANE = new Version2017RegionType(SCHEME, "MA-BES");

    // MA Berkane
    public static final Version2017RegionType MA_BERKANE = new Version2017RegionType(SCHEME, "MA-BER");

    // MA Boujdour (eh)
    public static final Version2017RegionType MA_BOUJDOUR_EH = new Version2017RegionType(SCHEME, "MA-BOD");

    // MA Boulemane
    public static final Version2017RegionType MA_BOULEMANE = new Version2017RegionType(SCHEME, "MA-BOM");

    // MA Chefchaouene
    public static final Version2017RegionType MA_CHEFCHAOUENE = new Version2017RegionType(SCHEME, "MA-CHE");

    // MA Chichaoua
    public static final Version2017RegionType MA_CHICHAOUA = new Version2017RegionType(SCHEME, "MA-CHI");

    // MA Dar El Beida
    public static final Version2017RegionType MA_DAR_EL_BEIDA = new Version2017RegionType(SCHEME, "MA-CAS");

    // MA El Hajeb
    public static final Version2017RegionType MA_EL_HAJEB = new Version2017RegionType(SCHEME, "MA-HAJ");

    // MA El Jadida
    public static final Version2017RegionType MA_EL_JADIDA = new Version2017RegionType(SCHEME, "MA-JDI");

    // MA Errachidia
    public static final Version2017RegionType MA_ERRACHIDIA = new Version2017RegionType(SCHEME, "MA-ERR");

    // MA Essaouira
    public static final Version2017RegionType MA_ESSAOUIRA = new Version2017RegionType(SCHEME, "MA-ESI");

    // MA Es Smara (eh)
    public static final Version2017RegionType MA_ES_SMARA_EH = new Version2017RegionType(SCHEME, "MA-ESM");

    // MA Fes*
    public static final Version2017RegionType MA_FES = new Version2017RegionType(SCHEME, "MA-FES");

    // MA Figuig
    public static final Version2017RegionType MA_FIGUIG = new Version2017RegionType(SCHEME, "MA-FIG");

    // MA Guelmim
    public static final Version2017RegionType MA_GUELMIM = new Version2017RegionType(SCHEME, "MA-GUE");

    // MA Ifrane
    public static final Version2017RegionType MA_IFRANE = new Version2017RegionType(SCHEME, "MA-IFR");

    // MA Jerada
    public static final Version2017RegionType MA_JERADA = new Version2017RegionType(SCHEME, "MA-JRA");

    // MA Kelaat Sraghna
    public static final Version2017RegionType MA_KELAAT_SRAGHNA = new Version2017RegionType(SCHEME, "MA-KES");

    // MA Kenitra
    public static final Version2017RegionType MA_KENITRA = new Version2017RegionType(SCHEME, "MA-KEN");

    // MA Khemisset
    public static final Version2017RegionType MA_KHEMISSET = new Version2017RegionType(SCHEME, "MA-KHE");

    // MA Khenifra
    public static final Version2017RegionType MA_KHENIFRA = new Version2017RegionType(SCHEME, "MA-KHN");

    // MA Khouribga
    public static final Version2017RegionType MA_KHOURIBGA = new Version2017RegionType(SCHEME, "MA-KHO");

    // MA Laayoune* (eh)
    public static final Version2017RegionType MA_LAAYOUNE_EH = new Version2017RegionType(SCHEME, "MA-LAA");

    // MA Larache
    public static final Version2017RegionType MA_LARACHE = new Version2017RegionType(SCHEME, "MA-LAR");

    // MA Marrakech*
    public static final Version2017RegionType MA_MARRAKECH = new Version2017RegionType(SCHEME, "MA-MAR");

    // MA Meknes*
    public static final Version2017RegionType MA_MEKNES = new Version2017RegionType(SCHEME, "MA-MEK");

    // MA Nador
    public static final Version2017RegionType MA_NADOR = new Version2017RegionType(SCHEME, "MA-NAD");

    // MA Ouarzazate
    public static final Version2017RegionType MA_OUARZAZATE = new Version2017RegionType(SCHEME, "MA-OUA");

    // MA Oued Ed Dahab (eh)
    public static final Version2017RegionType MA_OUED_ED_DAHAB_EH = new Version2017RegionType(SCHEME, "MA-OUD");

    // MA Oujda*
    public static final Version2017RegionType MA_OUJDA = new Version2017RegionType(SCHEME, "MA-OUJ");

    // MA Rabat-sale*
    public static final Version2017RegionType MA_RABAT_SALE = new Version2017RegionType(SCHEME, "MA-RBA");

    // MA Safi
    public static final Version2017RegionType MA_SAFI = new Version2017RegionType(SCHEME, "MA-SAF");

    // MA Sefrou
    public static final Version2017RegionType MA_SEFROU = new Version2017RegionType(SCHEME, "MA-SEF");

    // MA Settat
    public static final Version2017RegionType MA_SETTAT = new Version2017RegionType(SCHEME, "MA-SET");

    // MA Sidi Kacem
    public static final Version2017RegionType MA_SIDI_KACEM = new Version2017RegionType(SCHEME, "MA-SIK");

    // MA Tanger
    public static final Version2017RegionType MA_TANGER = new Version2017RegionType(SCHEME, "MA-TNG");

    // MA Tan-tan
    public static final Version2017RegionType MA_TAN_TAN = new Version2017RegionType(SCHEME, "MA-TNT");

    // MA Taounate
    public static final Version2017RegionType MA_TAOUNATE = new Version2017RegionType(SCHEME, "MA-TAO");

    // MA Taroudannt
    public static final Version2017RegionType MA_TAROUDANNT = new Version2017RegionType(SCHEME, "MA-TAR");

    // MA Tata
    public static final Version2017RegionType MA_TATA = new Version2017RegionType(SCHEME, "MA-TAT");

    // MA Taza
    public static final Version2017RegionType MA_TAZA = new Version2017RegionType(SCHEME, "MA-TAZ");

    // MA Tetouan*
    public static final Version2017RegionType MA_TETOUAN = new Version2017RegionType(SCHEME, "MA-TET");

    // MA Tiznit
    public static final Version2017RegionType MA_TIZNIT = new Version2017RegionType(SCHEME, "MA-TIZ");

    // MD Balti
    public static final Version2017RegionType MD_BALTI = new Version2017RegionType(SCHEME, "MD-BA");

    // MD Bender
    public static final Version2017RegionType MD_BENDER = new Version2017RegionType(SCHEME, "MD-TI");

    // MD Cahul
    public static final Version2017RegionType MD_CAHUL = new Version2017RegionType(SCHEME, "MD-CA");

    // MD Chisinau
    public static final Version2017RegionType MD_CHISINAU = new Version2017RegionType(SCHEME, "MD-CH");

    // MD Chisinau, MD
    public static final Version2017RegionType MD_CHISINAU_MD_CU = new Version2017RegionType(SCHEME, "MD-CU");

    // MD Edinet
    public static final Version2017RegionType MD_EDINET = new Version2017RegionType(SCHEME, "MD-ED");

    // MD Gagauzia, Unitate Teritoriala Autonoma (utag)
    public static final Version2017RegionType MD_GAGAUZIA_UNITATE_TERITORIALA_AUTONOMA_UTAG = new Version2017RegionType(SCHEME, "MD-GA");

    // MD Lapusna
    public static final Version2017RegionType MD_LAPUSNA = new Version2017RegionType(SCHEME, "MD-LA");

    // MD Orhei
    public static final Version2017RegionType MD_ORHEI = new Version2017RegionType(SCHEME, "MD-OR");

    // MD Soroca
    public static final Version2017RegionType MD_SOROCA = new Version2017RegionType(SCHEME, "MD-SO");

    // MD Stinga Nistrului, Unitatea Teritoriala Din
    public static final Version2017RegionType MD_STINGA_NISTRULUI_UNITATEA_TERITORIALA_DIN = new Version2017RegionType(SCHEME, "MD-SN");

    // MD Taraclia
    public static final Version2017RegionType MD_TARACLIA = new Version2017RegionType(SCHEME, "MD-TA");

    // MD Ungheni
    public static final Version2017RegionType MD_UNGHENI = new Version2017RegionType(SCHEME, "MD-UN");

    // MG Antananarivo
    public static final Version2017RegionType MG_ANTANANARIVO = new Version2017RegionType(SCHEME, "MG-T");

    // MG Antsiranana
    public static final Version2017RegionType MG_ANTSIRANANA = new Version2017RegionType(SCHEME, "MG-D");

    // MG Fianarantsoa
    public static final Version2017RegionType MG_FIANARANTSOA = new Version2017RegionType(SCHEME, "MG-F");

    // MG Mahajanga
    public static final Version2017RegionType MG_MAHAJANGA = new Version2017RegionType(SCHEME, "MG-M");

    // MG Toamasina
    public static final Version2017RegionType MG_TOAMASINA = new Version2017RegionType(SCHEME, "MG-A");

    // MG Toliara
    public static final Version2017RegionType MG_TOLIARA = new Version2017RegionType(SCHEME, "MG-U");

    // MH Ailinglapalap
    public static final Version2017RegionType MH_AILINGLAPALAP = new Version2017RegionType(SCHEME, "MH-ALL");

    // MH Ailuk
    public static final Version2017RegionType MH_AILUK = new Version2017RegionType(SCHEME, "MH-ALK");

    // MH Arno
    public static final Version2017RegionType MH_ARNO = new Version2017RegionType(SCHEME, "MH-ARN");

    // MH Aur
    public static final Version2017RegionType MH_AUR = new Version2017RegionType(SCHEME, "MH-AUR");

    // MH Ebon
    public static final Version2017RegionType MH_EBON = new Version2017RegionType(SCHEME, "MH-EBO");

    // MH Eniwetok
    public static final Version2017RegionType MH_ENIWETOK = new Version2017RegionType(SCHEME, "MH-ENI");

    // MH Jaluit
    public static final Version2017RegionType MH_JALUIT = new Version2017RegionType(SCHEME, "MH-JAL");

    // MH Kili
    public static final Version2017RegionType MH_KILI = new Version2017RegionType(SCHEME, "MH-KIL");

    // MH Kwajalein
    public static final Version2017RegionType MH_KWAJALEIN = new Version2017RegionType(SCHEME, "MH-KWA");

    // MH Lae
    public static final Version2017RegionType MH_LAE = new Version2017RegionType(SCHEME, "MH-LAE");

    // MH Lib
    public static final Version2017RegionType MH_LIB = new Version2017RegionType(SCHEME, "MH-LIB");

    // MH Likiep
    public static final Version2017RegionType MH_LIKIEP = new Version2017RegionType(SCHEME, "MH-LIK");

    // MH Majuro
    public static final Version2017RegionType MH_MAJURO = new Version2017RegionType(SCHEME, "MH-MAJ");

    // MH Maloelap
    public static final Version2017RegionType MH_MALOELAP = new Version2017RegionType(SCHEME, "MH-MAL");

    // MH Mejit
    public static final Version2017RegionType MH_MEJIT = new Version2017RegionType(SCHEME, "MH-MEJ");

    // MH Mili
    public static final Version2017RegionType MH_MILI = new Version2017RegionType(SCHEME, "MH-MIL");

    // MH Namorik
    public static final Version2017RegionType MH_NAMORIK = new Version2017RegionType(SCHEME, "MH-NMK");

    // MH Namu
    public static final Version2017RegionType MH_NAMU = new Version2017RegionType(SCHEME, "MH-NMU");

    // MH Rongelap
    public static final Version2017RegionType MH_RONGELAP = new Version2017RegionType(SCHEME, "MH-RON");

    // MH Ujae
    public static final Version2017RegionType MH_UJAE = new Version2017RegionType(SCHEME, "MH-UJA");

    // MH Ujelang
    public static final Version2017RegionType MH_UJELANG = new Version2017RegionType(SCHEME, "MH-UJL");

    // MH Utirik
    public static final Version2017RegionType MH_UTIRIK = new Version2017RegionType(SCHEME, "MH-UTI");

    // MH Wotho
    public static final Version2017RegionType MH_WOTHO = new Version2017RegionType(SCHEME, "MH-WTH");

    // MH Wotje
    public static final Version2017RegionType MH_WOTJE = new Version2017RegionType(SCHEME, "MH-WTJ");

    // ML Bamako
    public static final Version2017RegionType ML_BAMAKO = new Version2017RegionType(SCHEME, "ML-BKO");

    // ML Gao
    public static final Version2017RegionType ML_GAO = new Version2017RegionType(SCHEME, "ML-7");

    // ML Kayes
    public static final Version2017RegionType ML_KAYES = new Version2017RegionType(SCHEME, "ML-1");

    // ML Kidal
    public static final Version2017RegionType ML_KIDAL = new Version2017RegionType(SCHEME, "ML-8");

    // ML Koulikoro
    public static final Version2017RegionType ML_KOULIKORO = new Version2017RegionType(SCHEME, "ML-2");

    // ML Mopti
    public static final Version2017RegionType ML_MOPTI = new Version2017RegionType(SCHEME, "ML-5");

    // ML Segou
    public static final Version2017RegionType ML_SEGOU = new Version2017RegionType(SCHEME, "ML-4");

    // ML Sikasso
    public static final Version2017RegionType ML_SIKASSO = new Version2017RegionType(SCHEME, "ML-3");

    // ML Tombouctou
    public static final Version2017RegionType ML_TOMBOUCTOU = new Version2017RegionType(SCHEME, "ML-6");

    // MM Ayeyarwady
    public static final Version2017RegionType MM_AYEYARWADY = new Version2017RegionType(SCHEME, "MM-07");

    // MM Bago
    public static final Version2017RegionType MM_BAGO = new Version2017RegionType(SCHEME, "MM-02");

    // MM Chin
    public static final Version2017RegionType MM_CHIN = new Version2017RegionType(SCHEME, "MM-14");

    // MM Kachin
    public static final Version2017RegionType MM_KACHIN = new Version2017RegionType(SCHEME, "MM-11");

    // MM Kayah
    public static final Version2017RegionType MM_KAYAH = new Version2017RegionType(SCHEME, "MM-12");

    // MM Kayin
    public static final Version2017RegionType MM_KAYIN = new Version2017RegionType(SCHEME, "MM-13");

    // MM Magway
    public static final Version2017RegionType MM_MAGWAY = new Version2017RegionType(SCHEME, "MM-03");

    // MM Mandalay
    public static final Version2017RegionType MM_MANDALAY = new Version2017RegionType(SCHEME, "MM-04");

    // MM Mon
    public static final Version2017RegionType MM_MON = new Version2017RegionType(SCHEME, "MM-15");

    // MM Rakhine
    public static final Version2017RegionType MM_RAKHINE = new Version2017RegionType(SCHEME, "MM-16");

    // MM Sagaing
    public static final Version2017RegionType MM_SAGAING = new Version2017RegionType(SCHEME, "MM-01");

    // MM Shan
    public static final Version2017RegionType MM_SHAN = new Version2017RegionType(SCHEME, "MM-17");

    // MM Tanintharyi
    public static final Version2017RegionType MM_TANINTHARYI = new Version2017RegionType(SCHEME, "MM-05");

    // MM Yangon
    public static final Version2017RegionType MM_YANGON = new Version2017RegionType(SCHEME, "MM-06");

    // MN Arhangay
    public static final Version2017RegionType MN_ARHANGAY = new Version2017RegionType(SCHEME, "MN-073");

    // MN Bayanhongor
    public static final Version2017RegionType MN_BAYANHONGOR = new Version2017RegionType(SCHEME, "MN-069");

    // MN Bayan-olgiy
    public static final Version2017RegionType MN_BAYAN_OLGIY = new Version2017RegionType(SCHEME, "MN-071");

    // MN Bulgan
    public static final Version2017RegionType MN_BULGAN = new Version2017RegionType(SCHEME, "MN-067");

    // MN Darhan Uul
    public static final Version2017RegionType MN_DARHAN_UUL = new Version2017RegionType(SCHEME, "MN-037");

    // MN Dornod
    public static final Version2017RegionType MN_DORNOD = new Version2017RegionType(SCHEME, "MN-061");

    // MN Dornogovi
    public static final Version2017RegionType MN_DORNOGOVI = new Version2017RegionType(SCHEME, "MN-063");

    // MN Dundgovi
    public static final Version2017RegionType MN_DUNDGOVI = new Version2017RegionType(SCHEME, "MN-059");

    // MN Dzavhan
    public static final Version2017RegionType MN_DZAVHAN = new Version2017RegionType(SCHEME, "MN-057");

    // MN Govi-altay
    public static final Version2017RegionType MN_GOVI_ALTAY = new Version2017RegionType(SCHEME, "MN-065");

    // MN Govi-sumber
    public static final Version2017RegionType MN_GOVI_SUMBER = new Version2017RegionType(SCHEME, "MN-064");

    // MN Hentiy
    public static final Version2017RegionType MN_HENTIY = new Version2017RegionType(SCHEME, "MN-039");

    // MN Hovd
    public static final Version2017RegionType MN_HOVD = new Version2017RegionType(SCHEME, "MN-043");

    // MN Hovsgol
    public static final Version2017RegionType MN_HOVSGOL = new Version2017RegionType(SCHEME, "MN-041");

    // MN Omnogovi
    public static final Version2017RegionType MN_OMNOGOVI = new Version2017RegionType(SCHEME, "MN-053");

    // MN Orhon
    public static final Version2017RegionType MN_ORHON = new Version2017RegionType(SCHEME, "MN-035");

    // MN Ovorhangay
    public static final Version2017RegionType MN_OVORHANGAY = new Version2017RegionType(SCHEME, "MN-055");

    // MN Selenge
    public static final Version2017RegionType MN_SELENGE = new Version2017RegionType(SCHEME, "MN-049");

    // MN Suhbaatar
    public static final Version2017RegionType MN_SUHBAATAR = new Version2017RegionType(SCHEME, "MN-051");

    // MN Tov
    public static final Version2017RegionType MN_TOV = new Version2017RegionType(SCHEME, "MN-047");

    // MN Ulaanbaatar
    public static final Version2017RegionType MN_ULAANBAATAR = new Version2017RegionType(SCHEME, "MN-1");

    // MN Uvs
    public static final Version2017RegionType MN_UVS = new Version2017RegionType(SCHEME, "MN-046");

    // MR Adrar, MR
    public static final Version2017RegionType MR_ADRAR = new Version2017RegionType(SCHEME, "MR-07");

    // MR Assaba
    public static final Version2017RegionType MR_ASSABA = new Version2017RegionType(SCHEME, "MR-03");

    // MR Brakna
    public static final Version2017RegionType MR_BRAKNA = new Version2017RegionType(SCHEME, "MR-05");

    // MR Dakhlet Nouadhibou
    public static final Version2017RegionType MR_DAKHLET_NOUADHIBOU = new Version2017RegionType(SCHEME, "MR-08");

    // MR Gorgol
    public static final Version2017RegionType MR_GORGOL = new Version2017RegionType(SCHEME, "MR-04");

    // MR Guidimaka
    public static final Version2017RegionType MR_GUIDIMAKA = new Version2017RegionType(SCHEME, "MR-10");

    // MR Hodh Ech Chargui
    public static final Version2017RegionType MR_HODH_ECH_CHARGUI = new Version2017RegionType(SCHEME, "MR-01");

    // MR Hodh El Gharbi
    public static final Version2017RegionType MR_HODH_EL_GHARBI = new Version2017RegionType(SCHEME, "MR-02");

    // MR Inchiri
    public static final Version2017RegionType MR_INCHIRI = new Version2017RegionType(SCHEME, "MR-12");

    // MR Nouakchott
    public static final Version2017RegionType MR_NOUAKCHOTT = new Version2017RegionType(SCHEME, "MR-NKC");

    // MR Tagant
    public static final Version2017RegionType MR_TAGANT = new Version2017RegionType(SCHEME, "MR-09");

    // MR Tiris Zemmour
    public static final Version2017RegionType MR_TIRIS_ZEMMOUR = new Version2017RegionType(SCHEME, "MR-11");

    // MR Trarza
    public static final Version2017RegionType MR_TRARZA = new Version2017RegionType(SCHEME, "MR-06");

    // MU Agalega Islands
    public static final Version2017RegionType MU_AGALEGA_ISLANDS = new Version2017RegionType(SCHEME, "MU-AG");

    // MU Beau Bassin-rose Hill
    public static final Version2017RegionType MU_BEAU_BASSIN_ROSE_HILL = new Version2017RegionType(SCHEME, "MU-BR");

    // MU Black River
    public static final Version2017RegionType MU_BLACK_RIVER = new Version2017RegionType(SCHEME, "MU-BL");

    // MU Curepipe
    public static final Version2017RegionType MU_CUREPIPE = new Version2017RegionType(SCHEME, "MU-CU");

    // MU Flacq
    public static final Version2017RegionType MU_FLACQ = new Version2017RegionType(SCHEME, "MU-FL");

    // MU Grand Port
    public static final Version2017RegionType MU_GRAND_PORT = new Version2017RegionType(SCHEME, "MU-GP");

    // MU Moka
    public static final Version2017RegionType MU_MOKA = new Version2017RegionType(SCHEME, "MU-MO");

    // MU Pamplemousses
    public static final Version2017RegionType MU_PAMPLEMOUSSES = new Version2017RegionType(SCHEME, "MU-PA");

    // MU Plaines Wilhems
    public static final Version2017RegionType MU_PLAINES_WILHEMS = new Version2017RegionType(SCHEME, "MU-PW");

    // MU Port Louis
    public static final Version2017RegionType MU_PORT_LOUIS = new Version2017RegionType(SCHEME, "MU-PU");

    // MU Port Louis, MU
    public static final Version2017RegionType MU_PORT_LOUIS_MU_PL = new Version2017RegionType(SCHEME, "MU-PL");

    // MU Quatre Bornes
    public static final Version2017RegionType MU_QUATRE_BORNES = new Version2017RegionType(SCHEME, "MU-QB");

    // MU Riviere Du Rempart
    public static final Version2017RegionType MU_RIVIERE_DU_REMPART = new Version2017RegionType(SCHEME, "MU-RR");

    // MU Rodrigues Island
    public static final Version2017RegionType MU_RODRIGUES_ISLAND = new Version2017RegionType(SCHEME, "MU-RO");

    // MU Saint Brandon Islands
    public static final Version2017RegionType MU_SAINT_BRANDON_ISLANDS = new Version2017RegionType(SCHEME, "MU-CC");

    // MU Savanne
    public static final Version2017RegionType MU_SAVANNE = new Version2017RegionType(SCHEME, "MU-SA");

    // MU Vacoas-phoenix
    public static final Version2017RegionType MU_VACOAS_PHOENIX = new Version2017RegionType(SCHEME, "MU-VP");

    // MV Alif
    public static final Version2017RegionType MV_ALIF = new Version2017RegionType(SCHEME, "MV-02");

    // MV Baa
    public static final Version2017RegionType MV_BAA = new Version2017RegionType(SCHEME, "MV-20");

    // MV Dhaalu
    public static final Version2017RegionType MV_DHAALU = new Version2017RegionType(SCHEME, "MV-17");

    // MV Faafu
    public static final Version2017RegionType MV_FAAFU = new Version2017RegionType(SCHEME, "MV-14");

    // MV Gaafu Dhaalu
    public static final Version2017RegionType MV_GAAFU_DHAALU = new Version2017RegionType(SCHEME, "MV-28");

    // MV Gaaf Alif
    public static final Version2017RegionType MV_GAAF_ALIF = new Version2017RegionType(SCHEME, "MV-27");

    // MV Gnaviyani
    public static final Version2017RegionType MV_GNAVIYANI = new Version2017RegionType(SCHEME, "MV-29");

    // MV Haa Alif
    public static final Version2017RegionType MV_HAA_ALIF = new Version2017RegionType(SCHEME, "MV-07");

    // MV Haa Dhaalu
    public static final Version2017RegionType MV_HAA_DHAALU = new Version2017RegionType(SCHEME, "MV-23");

    // MV Kaafu
    public static final Version2017RegionType MV_KAAFU = new Version2017RegionType(SCHEME, "MV-26");

    // MV Laamu
    public static final Version2017RegionType MV_LAAMU = new Version2017RegionType(SCHEME, "MV-05");

    // MV Lhaviyani
    public static final Version2017RegionType MV_LHAVIYANI = new Version2017RegionType(SCHEME, "MV-03");

    // MV Male
    public static final Version2017RegionType MV_MALE = new Version2017RegionType(SCHEME, "MV-MLE");

    // MV Meemu
    public static final Version2017RegionType MV_MEEMU = new Version2017RegionType(SCHEME, "MV-12");

    // MV Noonu
    public static final Version2017RegionType MV_NOONU = new Version2017RegionType(SCHEME, "MV-25");

    // MV Raa
    public static final Version2017RegionType MV_RAA = new Version2017RegionType(SCHEME, "MV-13");

    // MV Seenu
    public static final Version2017RegionType MV_SEENU = new Version2017RegionType(SCHEME, "MV-01");

    // MV Shaviyani
    public static final Version2017RegionType MV_SHAVIYANI = new Version2017RegionType(SCHEME, "MV-24");

    // MV Thaa
    public static final Version2017RegionType MV_THAA = new Version2017RegionType(SCHEME, "MV-08");

    // MV Vaavu
    public static final Version2017RegionType MV_VAAVU = new Version2017RegionType(SCHEME, "MV-04");

    // MW Balaka
    public static final Version2017RegionType MW_BALAKA = new Version2017RegionType(SCHEME, "MW-BA");

    // MW Blantyre
    public static final Version2017RegionType MW_BLANTYRE = new Version2017RegionType(SCHEME, "MW-BL");

    // MW Chikwawa
    public static final Version2017RegionType MW_CHIKWAWA = new Version2017RegionType(SCHEME, "MW-CK");

    // MW Chiradzulu
    public static final Version2017RegionType MW_CHIRADZULU = new Version2017RegionType(SCHEME, "MW-CR");

    // MW Chitipa
    public static final Version2017RegionType MW_CHITIPA = new Version2017RegionType(SCHEME, "MW-CT");

    // MW Dedza
    public static final Version2017RegionType MW_DEDZA = new Version2017RegionType(SCHEME, "MW-DE");

    // MW Dowa
    public static final Version2017RegionType MW_DOWA = new Version2017RegionType(SCHEME, "MW-DO");

    // MW Karonga
    public static final Version2017RegionType MW_KARONGA = new Version2017RegionType(SCHEME, "MW-KR");

    // MW Kasungu
    public static final Version2017RegionType MW_KASUNGU = new Version2017RegionType(SCHEME, "MW-KS");

    // MW Likoma Island
    public static final Version2017RegionType MW_LIKOMA_ISLAND = new Version2017RegionType(SCHEME, "MW-LK");

    // MW Lilongwe
    public static final Version2017RegionType MW_LILONGWE = new Version2017RegionType(SCHEME, "MW-LI");

    // MW Machinga
    public static final Version2017RegionType MW_MACHINGA = new Version2017RegionType(SCHEME, "MW-MH");

    // MW Mangochi
    public static final Version2017RegionType MW_MANGOCHI = new Version2017RegionType(SCHEME, "MW-MG");

    // MW Mchinji
    public static final Version2017RegionType MW_MCHINJI = new Version2017RegionType(SCHEME, "MW-MC");

    // MW Mulanje
    public static final Version2017RegionType MW_MULANJE = new Version2017RegionType(SCHEME, "MW-MU");

    // MW Mwanza
    public static final Version2017RegionType MW_MWANZA = new Version2017RegionType(SCHEME, "MW-MW");

    // MW Mzimba
    public static final Version2017RegionType MW_MZIMBA = new Version2017RegionType(SCHEME, "MW-MZ");

    // MW Nkhata Bay
    public static final Version2017RegionType MW_NKHATA_BAY = new Version2017RegionType(SCHEME, "MW-NB");

    // MW Nkhotakota
    public static final Version2017RegionType MW_NKHOTAKOTA = new Version2017RegionType(SCHEME, "MW-NK");

    // MW Nsanje
    public static final Version2017RegionType MW_NSANJE = new Version2017RegionType(SCHEME, "MW-NS");

    // MW Ntcheu
    public static final Version2017RegionType MW_NTCHEU = new Version2017RegionType(SCHEME, "MW-NU");

    // MW Ntchisi
    public static final Version2017RegionType MW_NTCHISI = new Version2017RegionType(SCHEME, "MW-NI");

    // MW Phalombe
    public static final Version2017RegionType MW_PHALOMBE = new Version2017RegionType(SCHEME, "MW-PH");

    // MW Rumphi
    public static final Version2017RegionType MW_RUMPHI = new Version2017RegionType(SCHEME, "MW-RU");

    // MW Salima
    public static final Version2017RegionType MW_SALIMA = new Version2017RegionType(SCHEME, "MW-SA");

    // MW Thyolo
    public static final Version2017RegionType MW_THYOLO = new Version2017RegionType(SCHEME, "MW-TH");

    // MW Zomba
    public static final Version2017RegionType MW_ZOMBA = new Version2017RegionType(SCHEME, "MW-ZO");

    // MX Aguascalientes
    public static final Version2017RegionType MX_AGUASCALIENTES = new Version2017RegionType(SCHEME, "MX-AGU");

    // MX Baja California
    public static final Version2017RegionType MX_BAJA_CALIFORNIA = new Version2017RegionType(SCHEME, "MX-BCN");

    // MX Baja California Sur
    public static final Version2017RegionType MX_BAJA_CALIFORNIA_SUR = new Version2017RegionType(SCHEME, "MX-BCS");

    // MX Campeche
    public static final Version2017RegionType MX_CAMPECHE = new Version2017RegionType(SCHEME, "MX-CAM");

    // MX Chiapas
    public static final Version2017RegionType MX_CHIAPAS = new Version2017RegionType(SCHEME, "MX-CHP");

    // MX Chihuahua
    public static final Version2017RegionType MX_CHIHUAHUA = new Version2017RegionType(SCHEME, "MX-CHH");

    // MX Coahuila
    public static final Version2017RegionType MX_COAHUILA = new Version2017RegionType(SCHEME, "MX-COA");

    // MX Colima
    public static final Version2017RegionType MX_COLIMA = new Version2017RegionType(SCHEME, "MX-COL");

    // MX Distrito Federal, MX
    public static final Version2017RegionType MX_DISTRITO_FEDERAL = new Version2017RegionType(SCHEME, "MX-DIF");

    // MX Durango
    public static final Version2017RegionType MX_DURANGO = new Version2017RegionType(SCHEME, "MX-DUR");

    // MX Guanajuato
    public static final Version2017RegionType MX_GUANAJUATO = new Version2017RegionType(SCHEME, "MX-GUA");

    // MX Guerrero
    public static final Version2017RegionType MX_GUERRERO = new Version2017RegionType(SCHEME, "MX-GRO");

    // MX Hidalgo
    public static final Version2017RegionType MX_HIDALGO = new Version2017RegionType(SCHEME, "MX-HID");

    // MX Jalisco
    public static final Version2017RegionType MX_JALISCO = new Version2017RegionType(SCHEME, "MX-JAL");

    // MX Mexico
    public static final Version2017RegionType MX_MEXICO = new Version2017RegionType(SCHEME, "MX-MEX");

    // MX Michoacan
    public static final Version2017RegionType MX_MICHOACAN = new Version2017RegionType(SCHEME, "MX-MIC");

    // MX Morelos
    public static final Version2017RegionType MX_MORELOS = new Version2017RegionType(SCHEME, "MX-MOR");

    // MX Nayarit
    public static final Version2017RegionType MX_NAYARIT = new Version2017RegionType(SCHEME, "MX-NAY");

    // MX Nuevo Leon
    public static final Version2017RegionType MX_NUEVO_LEON = new Version2017RegionType(SCHEME, "MX-NLE");

    // MX Oaxaca
    public static final Version2017RegionType MX_OAXACA = new Version2017RegionType(SCHEME, "MX-OAX");

    // MX Puebla
    public static final Version2017RegionType MX_PUEBLA = new Version2017RegionType(SCHEME, "MX-PUE");

    // MX Queretaro
    public static final Version2017RegionType MX_QUERETARO = new Version2017RegionType(SCHEME, "MX-QUE");

    // MX Quintana Roo
    public static final Version2017RegionType MX_QUINTANA_ROO = new Version2017RegionType(SCHEME, "MX-ROO");

    // MX San Luis Potosi
    public static final Version2017RegionType MX_SAN_LUIS_POTOSI = new Version2017RegionType(SCHEME, "MX-SLP");

    // MX Sinaloa
    public static final Version2017RegionType MX_SINALOA = new Version2017RegionType(SCHEME, "MX-SIN");

    // MX Sonora
    public static final Version2017RegionType MX_SONORA = new Version2017RegionType(SCHEME, "MX-SON");

    // MX Tabasco
    public static final Version2017RegionType MX_TABASCO = new Version2017RegionType(SCHEME, "MX-TAB");

    // MX Tamaulipas
    public static final Version2017RegionType MX_TAMAULIPAS = new Version2017RegionType(SCHEME, "MX-TAM");

    // MX Tlaxcala
    public static final Version2017RegionType MX_TLAXCALA = new Version2017RegionType(SCHEME, "MX-TLA");

    // MX Veracruz
    public static final Version2017RegionType MX_VERACRUZ = new Version2017RegionType(SCHEME, "MX-VER");

    // MX Yucatan
    public static final Version2017RegionType MX_YUCATAN = new Version2017RegionType(SCHEME, "MX-YUC");

    // MX Zacatecas
    public static final Version2017RegionType MX_ZACATECAS = new Version2017RegionType(SCHEME, "MX-ZAC");

    // MY Johor
    public static final Version2017RegionType MY_JOHOR = new Version2017RegionType(SCHEME, "MY-01");

    // MY Kedah
    public static final Version2017RegionType MY_KEDAH = new Version2017RegionType(SCHEME, "MY-02");

    // MY Kelantan
    public static final Version2017RegionType MY_KELANTAN = new Version2017RegionType(SCHEME, "MY-03");

    // MY Melaka
    public static final Version2017RegionType MY_MELAKA = new Version2017RegionType(SCHEME, "MY-04");

    // MY Negeri Sembilan
    public static final Version2017RegionType MY_NEGERI_SEMBILAN = new Version2017RegionType(SCHEME, "MY-05");

    // MY Pahang
    public static final Version2017RegionType MY_PAHANG = new Version2017RegionType(SCHEME, "MY-06");

    // MY Perak
    public static final Version2017RegionType MY_PERAK = new Version2017RegionType(SCHEME, "MY-08");

    // MY Perlis
    public static final Version2017RegionType MY_PERLIS = new Version2017RegionType(SCHEME, "MY-09");

    // MY Pulau Pinang
    public static final Version2017RegionType MY_PULAU_PINANG = new Version2017RegionType(SCHEME, "MY-07");

    // MY Sabah
    public static final Version2017RegionType MY_SABAH = new Version2017RegionType(SCHEME, "MY-12");

    // MY Sarawak
    public static final Version2017RegionType MY_SARAWAK = new Version2017RegionType(SCHEME, "MY-13");

    // MY Selangor
    public static final Version2017RegionType MY_SELANGOR = new Version2017RegionType(SCHEME, "MY-10");

    // MY Terengganu
    public static final Version2017RegionType MY_TERENGGANU = new Version2017RegionType(SCHEME, "MY-11");

    // MY Wilayah Persekutuan Kuala Lumpur
    public static final Version2017RegionType MY_WILAYAH_PERSEKUTUAN_KUALA_LUMPUR = new Version2017RegionType(SCHEME, "MY-14");

    // MY Wilayah Persekutuan Labuan
    public static final Version2017RegionType MY_WILAYAH_PERSEKUTUAN_LABUAN = new Version2017RegionType(SCHEME, "MY-15");

    // MY Wilayah Persekutuan Putrajaya
    public static final Version2017RegionType MY_WILAYAH_PERSEKUTUAN_PUTRAJAYA = new Version2017RegionType(SCHEME, "MY-16");

    // MZ Cabo Delgado
    public static final Version2017RegionType MZ_CABO_DELGADO = new Version2017RegionType(SCHEME, "MZ-P");

    // MZ Gaza
    public static final Version2017RegionType MZ_GAZA = new Version2017RegionType(SCHEME, "MZ-G");

    // MZ Inhambane
    public static final Version2017RegionType MZ_INHAMBANE = new Version2017RegionType(SCHEME, "MZ-I");

    // MZ Manica
    public static final Version2017RegionType MZ_MANICA = new Version2017RegionType(SCHEME, "MZ-B");

    // MZ Maputo
    public static final Version2017RegionType MZ_MAPUTO = new Version2017RegionType(SCHEME, "MZ-MPM");

    // MZ Maputo, MZ
    public static final Version2017RegionType MZ_MAPUTO_MZ_L = new Version2017RegionType(SCHEME, "MZ-L");

    // MZ Nampula
    public static final Version2017RegionType MZ_NAMPULA = new Version2017RegionType(SCHEME, "MZ-N");

    // MZ Niassa
    public static final Version2017RegionType MZ_NIASSA = new Version2017RegionType(SCHEME, "MZ-A");

    // MZ Sofala
    public static final Version2017RegionType MZ_SOFALA = new Version2017RegionType(SCHEME, "MZ-S");

    // MZ Tete
    public static final Version2017RegionType MZ_TETE = new Version2017RegionType(SCHEME, "MZ-T");

    // MZ Zambezia
    public static final Version2017RegionType MZ_ZAMBEZIA = new Version2017RegionType(SCHEME, "MZ-Q");

    // NA Caprivi
    public static final Version2017RegionType NA_CAPRIVI = new Version2017RegionType(SCHEME, "NA-CA");

    // NA Erongo
    public static final Version2017RegionType NA_ERONGO = new Version2017RegionType(SCHEME, "NA-ER");

    // NA Hardap
    public static final Version2017RegionType NA_HARDAP = new Version2017RegionType(SCHEME, "NA-HA");

    // NA Karas
    public static final Version2017RegionType NA_KARAS = new Version2017RegionType(SCHEME, "NA-KA");

    // NA Khomas
    public static final Version2017RegionType NA_KHOMAS = new Version2017RegionType(SCHEME, "NA-KH");

    // NA Kunene
    public static final Version2017RegionType NA_KUNENE = new Version2017RegionType(SCHEME, "NA-KU");

    // NA Ohangwena
    public static final Version2017RegionType NA_OHANGWENA = new Version2017RegionType(SCHEME, "NA-OW");

    // NA Okavango
    public static final Version2017RegionType NA_OKAVANGO = new Version2017RegionType(SCHEME, "NA-OK");

    // NA Omaheke
    public static final Version2017RegionType NA_OMAHEKE = new Version2017RegionType(SCHEME, "NA-OH");

    // NA Omusati
    public static final Version2017RegionType NA_OMUSATI = new Version2017RegionType(SCHEME, "NA-OS");

    // NA Oshana
    public static final Version2017RegionType NA_OSHANA = new Version2017RegionType(SCHEME, "NA-ON");

    // NA Oshikoto
    public static final Version2017RegionType NA_OSHIKOTO = new Version2017RegionType(SCHEME, "NA-OT");

    // NA Otjozondjupa
    public static final Version2017RegionType NA_OTJOZONDJUPA = new Version2017RegionType(SCHEME, "NA-OD");

    // NE Agadez
    public static final Version2017RegionType NE_AGADEZ = new Version2017RegionType(SCHEME, "NE-1");

    // NE Diffa
    public static final Version2017RegionType NE_DIFFA = new Version2017RegionType(SCHEME, "NE-2");

    // NE Dosso
    public static final Version2017RegionType NE_DOSSO = new Version2017RegionType(SCHEME, "NE-3");

    // NE Maradi
    public static final Version2017RegionType NE_MARADI = new Version2017RegionType(SCHEME, "NE-4");

    // NE Niamey
    public static final Version2017RegionType NE_NIAMEY = new Version2017RegionType(SCHEME, "NE-8");

    // NE Tahoua
    public static final Version2017RegionType NE_TAHOUA = new Version2017RegionType(SCHEME, "NE-5");

    // NE Tillaberi
    public static final Version2017RegionType NE_TILLABERI = new Version2017RegionType(SCHEME, "NE-6");

    // NE Zinder
    public static final Version2017RegionType NE_ZINDER = new Version2017RegionType(SCHEME, "NE-7");

    // NG Abia
    public static final Version2017RegionType NG_ABIA = new Version2017RegionType(SCHEME, "NG-AB");

    // NG Abuja Capital Territory
    public static final Version2017RegionType NG_ABUJA_CAPITAL_TERRITORY = new Version2017RegionType(SCHEME, "NG-FC");

    // NG Adamawa
    public static final Version2017RegionType NG_ADAMAWA = new Version2017RegionType(SCHEME, "NG-AD");

    // NG Akwa Ibom
    public static final Version2017RegionType NG_AKWA_IBOM = new Version2017RegionType(SCHEME, "NG-AK");

    // NG Anambra
    public static final Version2017RegionType NG_ANAMBRA = new Version2017RegionType(SCHEME, "NG-AN");

    // NG Bauchi
    public static final Version2017RegionType NG_BAUCHI = new Version2017RegionType(SCHEME, "NG-BA");

    // NG Bayelsa
    public static final Version2017RegionType NG_BAYELSA = new Version2017RegionType(SCHEME, "NG-BY");

    // NG Benue
    public static final Version2017RegionType NG_BENUE = new Version2017RegionType(SCHEME, "NG-BE");

    // NG Borno
    public static final Version2017RegionType NG_BORNO = new Version2017RegionType(SCHEME, "NG-BO");

    // NG Cross River
    public static final Version2017RegionType NG_CROSS_RIVER = new Version2017RegionType(SCHEME, "NG-CR");

    // NG Delta
    public static final Version2017RegionType NG_DELTA = new Version2017RegionType(SCHEME, "NG-DE");

    // NG Ebonyi
    public static final Version2017RegionType NG_EBONYI = new Version2017RegionType(SCHEME, "NG-EB");

    // NG Edo
    public static final Version2017RegionType NG_EDO = new Version2017RegionType(SCHEME, "NG-ED");

    // NG Ekiti
    public static final Version2017RegionType NG_EKITI = new Version2017RegionType(SCHEME, "NG-EK");

    // NG Enugu
    public static final Version2017RegionType NG_ENUGU = new Version2017RegionType(SCHEME, "NG-EN");

    // NG Gombe
    public static final Version2017RegionType NG_GOMBE = new Version2017RegionType(SCHEME, "NG-GO");

    // NG Imo
    public static final Version2017RegionType NG_IMO = new Version2017RegionType(SCHEME, "NG-IM");

    // NG Jigawa
    public static final Version2017RegionType NG_JIGAWA = new Version2017RegionType(SCHEME, "NG-JI");

    // NG Kaduna
    public static final Version2017RegionType NG_KADUNA = new Version2017RegionType(SCHEME, "NG-KD");

    // NG Kano
    public static final Version2017RegionType NG_KANO = new Version2017RegionType(SCHEME, "NG-KN");

    // NG Katsina
    public static final Version2017RegionType NG_KATSINA = new Version2017RegionType(SCHEME, "NG-KT");

    // NG Kebbi
    public static final Version2017RegionType NG_KEBBI = new Version2017RegionType(SCHEME, "NG-KE");

    // NG Kogi
    public static final Version2017RegionType NG_KOGI = new Version2017RegionType(SCHEME, "NG-KO");

    // NG Kwara
    public static final Version2017RegionType NG_KWARA = new Version2017RegionType(SCHEME, "NG-KW");

    // NG Lagos
    public static final Version2017RegionType NG_LAGOS = new Version2017RegionType(SCHEME, "NG-LA");

    // NG Nassarawa
    public static final Version2017RegionType NG_NASSARAWA = new Version2017RegionType(SCHEME, "NG-NA");

    // NG Niger
    public static final Version2017RegionType NG_NIGER = new Version2017RegionType(SCHEME, "NG-NI");

    // NG Ogun
    public static final Version2017RegionType NG_OGUN = new Version2017RegionType(SCHEME, "NG-OG");

    // NG Ondo
    public static final Version2017RegionType NG_ONDO = new Version2017RegionType(SCHEME, "NG-ON");

    // NG Osun
    public static final Version2017RegionType NG_OSUN = new Version2017RegionType(SCHEME, "NG-OS");

    // NG Oyo
    public static final Version2017RegionType NG_OYO = new Version2017RegionType(SCHEME, "NG-OY");

    // NG Plateau
    public static final Version2017RegionType NG_PLATEAU = new Version2017RegionType(SCHEME, "NG-PL");

    // NG Rivers
    public static final Version2017RegionType NG_RIVERS = new Version2017RegionType(SCHEME, "NG-RI");

    // NG Sokoto
    public static final Version2017RegionType NG_SOKOTO = new Version2017RegionType(SCHEME, "NG-SO");

    // NG Taraba
    public static final Version2017RegionType NG_TARABA = new Version2017RegionType(SCHEME, "NG-TA");

    // NG Yobe
    public static final Version2017RegionType NG_YOBE = new Version2017RegionType(SCHEME, "NG-YO");

    // NG Zamfara
    public static final Version2017RegionType NG_ZAMFARA = new Version2017RegionType(SCHEME, "NG-ZA");

    // NI Atlantico Norte*
    public static final Version2017RegionType NI_ATLANTICO_NORTE = new Version2017RegionType(SCHEME, "NI-AN");

    // NI Atlantico Sur*
    public static final Version2017RegionType NI_ATLANTICO_SUR = new Version2017RegionType(SCHEME, "NI-AS");

    // NI Boaco
    public static final Version2017RegionType NI_BOACO = new Version2017RegionType(SCHEME, "NI-BO");

    // NI Carazo
    public static final Version2017RegionType NI_CARAZO = new Version2017RegionType(SCHEME, "NI-CA");

    // NI Chinandega
    public static final Version2017RegionType NI_CHINANDEGA = new Version2017RegionType(SCHEME, "NI-CI");

    // NI Chontales
    public static final Version2017RegionType NI_CHONTALES = new Version2017RegionType(SCHEME, "NI-CO");

    // NI Esteli
    public static final Version2017RegionType NI_ESTELI = new Version2017RegionType(SCHEME, "NI-ES");

    // NI Granada
    public static final Version2017RegionType NI_GRANADA = new Version2017RegionType(SCHEME, "NI-GR");

    // NI Jinotega
    public static final Version2017RegionType NI_JINOTEGA = new Version2017RegionType(SCHEME, "NI-JI");

    // NI Leon
    public static final Version2017RegionType NI_LEON = new Version2017RegionType(SCHEME, "NI-LE");

    // NI Madriz
    public static final Version2017RegionType NI_MADRIZ = new Version2017RegionType(SCHEME, "NI-MD");

    // NI Managua
    public static final Version2017RegionType NI_MANAGUA = new Version2017RegionType(SCHEME, "NI-MN");

    // NI Masaya
    public static final Version2017RegionType NI_MASAYA = new Version2017RegionType(SCHEME, "NI-MS");

    // NI Matagalpa
    public static final Version2017RegionType NI_MATAGALPA = new Version2017RegionType(SCHEME, "NI-MT");

    // NI Nueva Segovia
    public static final Version2017RegionType NI_NUEVA_SEGOVIA = new Version2017RegionType(SCHEME, "NI-NS");

    // NI Rio San Juan
    public static final Version2017RegionType NI_RIO_SAN_JUAN = new Version2017RegionType(SCHEME, "NI-SJ");

    // NI Rivas
    public static final Version2017RegionType NI_RIVAS = new Version2017RegionType(SCHEME, "NI-RI");

    // NL Drenthe
    public static final Version2017RegionType NL_DRENTHE = new Version2017RegionType(SCHEME, "NL-DR");

    // NL Flevoland
    public static final Version2017RegionType NL_FLEVOLAND = new Version2017RegionType(SCHEME, "NL-FL");

    // NL Friesland
    public static final Version2017RegionType NL_FRIESLAND = new Version2017RegionType(SCHEME, "NL-FR");

    // NL Gelderland
    public static final Version2017RegionType NL_GELDERLAND = new Version2017RegionType(SCHEME, "NL-GE");

    // NL Groningen
    public static final Version2017RegionType NL_GRONINGEN = new Version2017RegionType(SCHEME, "NL-GR");

    // NL Limburg
    public static final Version2017RegionType NL_LIMBURG = new Version2017RegionType(SCHEME, "NL-LI");

    // NL Noord-brabant
    public static final Version2017RegionType NL_NOORD_BRABANT = new Version2017RegionType(SCHEME, "NL-NB");

    // NL Noord-holland
    public static final Version2017RegionType NL_NOORD_HOLLAND = new Version2017RegionType(SCHEME, "NL-NH");

    // NL Overijssel
    public static final Version2017RegionType NL_OVERIJSSEL = new Version2017RegionType(SCHEME, "NL-OV");

    // NL Utrecht
    public static final Version2017RegionType NL_UTRECHT = new Version2017RegionType(SCHEME, "NL-UT");

    // NL Zeeland
    public static final Version2017RegionType NL_ZEELAND = new Version2017RegionType(SCHEME, "NL-ZE");

    // NL Zuid-holland
    public static final Version2017RegionType NL_ZUID_HOLLAND = new Version2017RegionType(SCHEME, "NL-ZH");

    // NO Akershus
    public static final Version2017RegionType NO_AKERSHUS = new Version2017RegionType(SCHEME, "NO-02");

    // NO Aust-agder
    public static final Version2017RegionType NO_AUST_AGDER = new Version2017RegionType(SCHEME, "NO-09");

    // NO Buskerud
    public static final Version2017RegionType NO_BUSKERUD = new Version2017RegionType(SCHEME, "NO-06");

    // NO Finnmark
    public static final Version2017RegionType NO_FINNMARK = new Version2017RegionType(SCHEME, "NO-20");

    // NO Hedmark
    public static final Version2017RegionType NO_HEDMARK = new Version2017RegionType(SCHEME, "NO-04");

    // NO Hordaland
    public static final Version2017RegionType NO_HORDALAND = new Version2017RegionType(SCHEME, "NO-12");

    // NO Jan Mayen (arctic Region) (see also country code Sj)
    public static final Version2017RegionType NO_JAN_MAYEN_ARCTIC_REGION_SEE_ALSO_COUNTRY_CODE_SJ = new Version2017RegionType(SCHEME, "NO-22");

    // NO More Og Romsdal
    public static final Version2017RegionType NO_MORE_OG_ROMSDAL = new Version2017RegionType(SCHEME, "NO-15");

    // NO Nordland
    public static final Version2017RegionType NO_NORDLAND = new Version2017RegionType(SCHEME, "NO-18");

    // NO Nord-trondelag
    public static final Version2017RegionType NO_NORD_TRONDELAG = new Version2017RegionType(SCHEME, "NO-17");

    // NO Oppland
    public static final Version2017RegionType NO_OPPLAND = new Version2017RegionType(SCHEME, "NO-05");

    // NO Oslo
    public static final Version2017RegionType NO_OSLO = new Version2017RegionType(SCHEME, "NO-03");

    // NO Ostfold
    public static final Version2017RegionType NO_OSTFOLD = new Version2017RegionType(SCHEME, "NO-01");

    // NO Rogaland
    public static final Version2017RegionType NO_ROGALAND = new Version2017RegionType(SCHEME, "NO-11");

    // NO Sogn Og Fjordane
    public static final Version2017RegionType NO_SOGN_OG_FJORDANE = new Version2017RegionType(SCHEME, "NO-14");

    // NO Sor-trondelag
    public static final Version2017RegionType NO_SOR_TRONDELAG = new Version2017RegionType(SCHEME, "NO-16");

    // NO Svalbard (arctic Region) (see also country code Sj)
    public static final Version2017RegionType NO_SVALBARD_ARCTIC_REGION_SEE_ALSO_COUNTRY_CODE_SJ = new Version2017RegionType(SCHEME, "NO-21");

    // NO Telemark
    public static final Version2017RegionType NO_TELEMARK = new Version2017RegionType(SCHEME, "NO-08");

    // NO Troms
    public static final Version2017RegionType NO_TROMS = new Version2017RegionType(SCHEME, "NO-19");

    // NO Vestfold
    public static final Version2017RegionType NO_VESTFOLD = new Version2017RegionType(SCHEME, "NO-07");

    // NO Vest-agder
    public static final Version2017RegionType NO_VEST_AGDER = new Version2017RegionType(SCHEME, "NO-10");

    // NP Bagmati
    public static final Version2017RegionType NP_BAGMATI = new Version2017RegionType(SCHEME, "NP-BA");

    // NP Bheri
    public static final Version2017RegionType NP_BHERI = new Version2017RegionType(SCHEME, "NP-BH");

    // NP Dhawalagiri
    public static final Version2017RegionType NP_DHAWALAGIRI = new Version2017RegionType(SCHEME, "NP-DH");

    // NP Gandaki
    public static final Version2017RegionType NP_GANDAKI = new Version2017RegionType(SCHEME, "NP-GA");

    // NP Janakpur
    public static final Version2017RegionType NP_JANAKPUR = new Version2017RegionType(SCHEME, "NP-JA");

    // NP Karnali
    public static final Version2017RegionType NP_KARNALI = new Version2017RegionType(SCHEME, "NP-KA");

    // NP Koshi
    public static final Version2017RegionType NP_KOSHI = new Version2017RegionType(SCHEME, "NP-KO");

    // NP Lumbini
    public static final Version2017RegionType NP_LUMBINI = new Version2017RegionType(SCHEME, "NP-LU");

    // NP Mahakali
    public static final Version2017RegionType NP_MAHAKALI = new Version2017RegionType(SCHEME, "NP-MA");

    // NP Mechi
    public static final Version2017RegionType NP_MECHI = new Version2017RegionType(SCHEME, "NP-ME");

    // NP Narayani
    public static final Version2017RegionType NP_NARAYANI = new Version2017RegionType(SCHEME, "NP-NA");

    // NP Rapti
    public static final Version2017RegionType NP_RAPTI = new Version2017RegionType(SCHEME, "NP-RA");

    // NP Sagarmatha
    public static final Version2017RegionType NP_SAGARMATHA = new Version2017RegionType(SCHEME, "NP-SA");

    // NP Seti
    public static final Version2017RegionType NP_SETI = new Version2017RegionType(SCHEME, "NP-SE");

    // NZ Auckland
    public static final Version2017RegionType NZ_AUCKLAND = new Version2017RegionType(SCHEME, "NZ-AUK");

    // NZ Bay Of Plenty
    public static final Version2017RegionType NZ_BAY_OF_PLENTY = new Version2017RegionType(SCHEME, "NZ-BOP");

    // NZ Canterbury
    public static final Version2017RegionType NZ_CANTERBURY = new Version2017RegionType(SCHEME, "NZ-CAN");

    // NZ Gisborne
    public static final Version2017RegionType NZ_GISBORNE = new Version2017RegionType(SCHEME, "NZ-GIS");

    // NZ Hawkes's Bay
    public static final Version2017RegionType NZ_HAWKESS_BAY = new Version2017RegionType(SCHEME, "NZ-HKB");

    // NZ Manawatu-wanganui
    public static final Version2017RegionType NZ_MANAWATU_WANGANUI = new Version2017RegionType(SCHEME, "NZ-MWT");

    // NZ Marlborough
    public static final Version2017RegionType NZ_MARLBOROUGH = new Version2017RegionType(SCHEME, "NZ-MBH");

    // NZ Nelson
    public static final Version2017RegionType NZ_NELSON = new Version2017RegionType(SCHEME, "NZ-NSN");

    // NZ Northland
    public static final Version2017RegionType NZ_NORTHLAND = new Version2017RegionType(SCHEME, "NZ-NTL");

    // NZ Otago
    public static final Version2017RegionType NZ_OTAGO = new Version2017RegionType(SCHEME, "NZ-OTA");

    // NZ Southland
    public static final Version2017RegionType NZ_SOUTHLAND = new Version2017RegionType(SCHEME, "NZ-STL");

    // NZ Taranaki
    public static final Version2017RegionType NZ_TARANAKI = new Version2017RegionType(SCHEME, "NZ-TKI");

    // NZ Tasman
    public static final Version2017RegionType NZ_TASMAN = new Version2017RegionType(SCHEME, "NZ-TAS");

    // NZ Waikato
    public static final Version2017RegionType NZ_WAIKATO = new Version2017RegionType(SCHEME, "NZ-WKO");

    // NZ Wellington
    public static final Version2017RegionType NZ_WELLINGTON = new Version2017RegionType(SCHEME, "NZ-WGN");

    // NZ West Coast
    public static final Version2017RegionType NZ_WEST_COAST = new Version2017RegionType(SCHEME, "NZ-WTC");

    // OM Ad Dakhiliyah
    public static final Version2017RegionType OM_AD_DAKHILIYAH = new Version2017RegionType(SCHEME, "OM-DA");

    // OM Al Batinah
    public static final Version2017RegionType OM_AL_BATINAH = new Version2017RegionType(SCHEME, "OM-BA");

    // OM Al Janubiyah
    public static final Version2017RegionType OM_AL_JANUBIYAH = new Version2017RegionType(SCHEME, "OM-JA");

    // OM Al Wusta
    public static final Version2017RegionType OM_AL_WUSTA = new Version2017RegionType(SCHEME, "OM-WU");

    // OM Ash Sharqiyah
    public static final Version2017RegionType OM_ASH_SHARQIYAH = new Version2017RegionType(SCHEME, "OM-SH");

    // OM Az Zahirah
    public static final Version2017RegionType OM_AZ_ZAHIRAH = new Version2017RegionType(SCHEME, "OM-ZA");

    // OM Masqat
    public static final Version2017RegionType OM_MASQAT = new Version2017RegionType(SCHEME, "OM-MA");

    // OM Musandam
    public static final Version2017RegionType OM_MUSANDAM = new Version2017RegionType(SCHEME, "OM-MU");

    // PA Bocas Del Toro
    public static final Version2017RegionType PA_BOCAS_DEL_TORO = new Version2017RegionType(SCHEME, "PA-1");

    // PA Chiriqui
    public static final Version2017RegionType PA_CHIRIQUI = new Version2017RegionType(SCHEME, "PA-4");

    // PA Cocle
    public static final Version2017RegionType PA_COCLE = new Version2017RegionType(SCHEME, "PA-2");

    // PA Colon, PA
    public static final Version2017RegionType PA_COLON = new Version2017RegionType(SCHEME, "PA-3");

    // PA Comarca De San Blas
    public static final Version2017RegionType PA_COMARCA_DE_SAN_BLAS = new Version2017RegionType(SCHEME, "PA-0");

    // PA Darien
    public static final Version2017RegionType PA_DARIEN = new Version2017RegionType(SCHEME, "PA-5");

    // PA Herrera
    public static final Version2017RegionType PA_HERRERA = new Version2017RegionType(SCHEME, "PA-6");

    // PA Los Santos
    public static final Version2017RegionType PA_LOS_SANTOS = new Version2017RegionType(SCHEME, "PA-7");

    // PA Panama
    public static final Version2017RegionType PA_PANAMA = new Version2017RegionType(SCHEME, "PA-8");

    // PA Veraguas
    public static final Version2017RegionType PA_VERAGUAS = new Version2017RegionType(SCHEME, "PA-9");

    // PE Amazonas, PE
    public static final Version2017RegionType PE_AMAZONAS = new Version2017RegionType(SCHEME, "PE-AMA");

    // PE Ancash
    public static final Version2017RegionType PE_ANCASH = new Version2017RegionType(SCHEME, "PE-ANC");

    // PE Apurimac
    public static final Version2017RegionType PE_APURIMAC = new Version2017RegionType(SCHEME, "PE-APU");

    // PE Arequipa
    public static final Version2017RegionType PE_AREQUIPA = new Version2017RegionType(SCHEME, "PE-ARE");

    // PE Ayacucho
    public static final Version2017RegionType PE_AYACUCHO = new Version2017RegionType(SCHEME, "PE-AYA");

    // PE Cajamarca
    public static final Version2017RegionType PE_CAJAMARCA = new Version2017RegionType(SCHEME, "PE-CAJ");

    // PE Cusco
    public static final Version2017RegionType PE_CUSCO = new Version2017RegionType(SCHEME, "PE-CUS");

    // PE El Callao
    public static final Version2017RegionType PE_EL_CALLAO = new Version2017RegionType(SCHEME, "PE-CAL");

    // PE Huancavelica
    public static final Version2017RegionType PE_HUANCAVELICA = new Version2017RegionType(SCHEME, "PE-HUV");

    // PE Huanuco
    public static final Version2017RegionType PE_HUANUCO = new Version2017RegionType(SCHEME, "PE-HUC");

    // PE Ica
    public static final Version2017RegionType PE_ICA = new Version2017RegionType(SCHEME, "PE-ICA");

    // PE Junin
    public static final Version2017RegionType PE_JUNIN = new Version2017RegionType(SCHEME, "PE-JUN");

    // PE Lambayeque
    public static final Version2017RegionType PE_LAMBAYEQUE = new Version2017RegionType(SCHEME, "PE-LAM");

    // PE La Libertad, PE
    public static final Version2017RegionType PE_LA_LIBERTAD = new Version2017RegionType(SCHEME, "PE-LAL");

    // PE Lima
    public static final Version2017RegionType PE_LIMA = new Version2017RegionType(SCHEME, "PE-LIM");

    // PE Loreto
    public static final Version2017RegionType PE_LORETO = new Version2017RegionType(SCHEME, "PE-LOR");

    // PE Madre De Dios
    public static final Version2017RegionType PE_MADRE_DE_DIOS = new Version2017RegionType(SCHEME, "PE-MDD");

    // PE Moquegua
    public static final Version2017RegionType PE_MOQUEGUA = new Version2017RegionType(SCHEME, "PE-MOQ");

    // PE Pasco
    public static final Version2017RegionType PE_PASCO = new Version2017RegionType(SCHEME, "PE-PAS");

    // PE Piura
    public static final Version2017RegionType PE_PIURA = new Version2017RegionType(SCHEME, "PE-PIU");

    // PE Puno
    public static final Version2017RegionType PE_PUNO = new Version2017RegionType(SCHEME, "PE-PUN");

    // PE San Martin
    public static final Version2017RegionType PE_SAN_MARTIN = new Version2017RegionType(SCHEME, "PE-SAM");

    // PE Tacna
    public static final Version2017RegionType PE_TACNA = new Version2017RegionType(SCHEME, "PE-TAC");

    // PE Tumbes
    public static final Version2017RegionType PE_TUMBES = new Version2017RegionType(SCHEME, "PE-TUM");

    // PE Ucayali
    public static final Version2017RegionType PE_UCAYALI = new Version2017RegionType(SCHEME, "PE-UCA");

    // PG Central, PG
    public static final Version2017RegionType PG_CENTRAL = new Version2017RegionType(SCHEME, "PG-CPM");

    // PG Chimbu
    public static final Version2017RegionType PG_CHIMBU = new Version2017RegionType(SCHEME, "PG-CPK");

    // PG Eastern Highlands
    public static final Version2017RegionType PG_EASTERN_HIGHLANDS = new Version2017RegionType(SCHEME, "PG-EHG");

    // PG East New Britain
    public static final Version2017RegionType PG_EAST_NEW_BRITAIN = new Version2017RegionType(SCHEME, "PG-EBR");

    // PG East Sepik
    public static final Version2017RegionType PG_EAST_SEPIK = new Version2017RegionType(SCHEME, "PG-ESW");

    // PG Enga
    public static final Version2017RegionType PG_ENGA = new Version2017RegionType(SCHEME, "PG-EPW");

    // PG Gulf
    public static final Version2017RegionType PG_GULF = new Version2017RegionType(SCHEME, "PG-GPK");

    // PG Madang
    public static final Version2017RegionType PG_MADANG = new Version2017RegionType(SCHEME, "PG-MPM");

    // PG Manus
    public static final Version2017RegionType PG_MANUS = new Version2017RegionType(SCHEME, "PG-MRL");

    // PG Milne Bay
    public static final Version2017RegionType PG_MILNE_BAY = new Version2017RegionType(SCHEME, "PG-MBA");

    // PG Morobe
    public static final Version2017RegionType PG_MOROBE = new Version2017RegionType(SCHEME, "PG-MPL");

    // PG National Capital District (port Moresby)
    public static final Version2017RegionType PG_NATIONAL_CAPITAL_DISTRICT_PORT_MORESBY = new Version2017RegionType(SCHEME, "PG-NCD");

    // PG New Ireland
    public static final Version2017RegionType PG_NEW_IRELAND = new Version2017RegionType(SCHEME, "PG-NIK");

    // PG Northern, PG
    public static final Version2017RegionType PG_NORTHERN = new Version2017RegionType(SCHEME, "PG-NPP");

    // PG North Solomons
    public static final Version2017RegionType PG_NORTH_SOLOMONS = new Version2017RegionType(SCHEME, "PG-NSA");

    // PG Southern Highlands
    public static final Version2017RegionType PG_SOUTHERN_HIGHLANDS = new Version2017RegionType(SCHEME, "PG-SHM");

    // PG Western, PG
    public static final Version2017RegionType PG_WESTERN = new Version2017RegionType(SCHEME, "PG-WPD");

    // PG Western Highlands
    public static final Version2017RegionType PG_WESTERN_HIGHLANDS = new Version2017RegionType(SCHEME, "PG-WHM");

    // PG West New Britain
    public static final Version2017RegionType PG_WEST_NEW_BRITAIN = new Version2017RegionType(SCHEME, "PG-WBK");

    // PG West Sepik
    public static final Version2017RegionType PG_WEST_SEPIK = new Version2017RegionType(SCHEME, "PG-SAN");

    // PH Abra
    public static final Version2017RegionType PH_ABRA = new Version2017RegionType(SCHEME, "PH-ABR");

    // PH Agusan Del Norte
    public static final Version2017RegionType PH_AGUSAN_DEL_NORTE = new Version2017RegionType(SCHEME, "PH-AGN");

    // PH Agusan Del Sur
    public static final Version2017RegionType PH_AGUSAN_DEL_SUR = new Version2017RegionType(SCHEME, "PH-AGS");

    // PH Aklan
    public static final Version2017RegionType PH_AKLAN = new Version2017RegionType(SCHEME, "PH-AKL");

    // PH Albay
    public static final Version2017RegionType PH_ALBAY = new Version2017RegionType(SCHEME, "PH-ALB");

    // PH Antique
    public static final Version2017RegionType PH_ANTIQUE = new Version2017RegionType(SCHEME, "PH-ANT");

    // PH Apayao
    public static final Version2017RegionType PH_APAYAO = new Version2017RegionType(SCHEME, "PH-APA");

    // PH Aurora
    public static final Version2017RegionType PH_AURORA = new Version2017RegionType(SCHEME, "PH-AUR");

    // PH Basilan
    public static final Version2017RegionType PH_BASILAN = new Version2017RegionType(SCHEME, "PH-BAS");

    // PH Bataan
    public static final Version2017RegionType PH_BATAAN = new Version2017RegionType(SCHEME, "PH-BAN");

    // PH Batanes
    public static final Version2017RegionType PH_BATANES = new Version2017RegionType(SCHEME, "PH-BTN");

    // PH Batangas
    public static final Version2017RegionType PH_BATANGAS = new Version2017RegionType(SCHEME, "PH-BTG");

    // PH Benguet
    public static final Version2017RegionType PH_BENGUET = new Version2017RegionType(SCHEME, "PH-BEN");

    // PH Biliran
    public static final Version2017RegionType PH_BILIRAN = new Version2017RegionType(SCHEME, "PH-BIL");

    // PH Bohol
    public static final Version2017RegionType PH_BOHOL = new Version2017RegionType(SCHEME, "PH-BOH");

    // PH Bukidnon
    public static final Version2017RegionType PH_BUKIDNON = new Version2017RegionType(SCHEME, "PH-BUK");

    // PH Bulacan
    public static final Version2017RegionType PH_BULACAN = new Version2017RegionType(SCHEME, "PH-BUL");

    // PH Cagayan
    public static final Version2017RegionType PH_CAGAYAN = new Version2017RegionType(SCHEME, "PH-CAG");

    // PH Camarines Norte
    public static final Version2017RegionType PH_CAMARINES_NORTE = new Version2017RegionType(SCHEME, "PH-CAN");

    // PH Camarines Sur
    public static final Version2017RegionType PH_CAMARINES_SUR = new Version2017RegionType(SCHEME, "PH-CAS");

    // PH Camiguin
    public static final Version2017RegionType PH_CAMIGUIN = new Version2017RegionType(SCHEME, "PH-CAM");

    // PH Capiz
    public static final Version2017RegionType PH_CAPIZ = new Version2017RegionType(SCHEME, "PH-CAP");

    // PH Catanduanes
    public static final Version2017RegionType PH_CATANDUANES = new Version2017RegionType(SCHEME, "PH-CAT");

    // PH Cavite
    public static final Version2017RegionType PH_CAVITE = new Version2017RegionType(SCHEME, "PH-CAV");

    // PH Cebu
    public static final Version2017RegionType PH_CEBU = new Version2017RegionType(SCHEME, "PH-CEB");

    // PH Compostela Valley
    public static final Version2017RegionType PH_COMPOSTELA_VALLEY = new Version2017RegionType(SCHEME, "PH-COM");

    // PH Davao Del Norte
    public static final Version2017RegionType PH_DAVAO_DEL_NORTE = new Version2017RegionType(SCHEME, "PH-DAV");

    // PH Davao Del Sur
    public static final Version2017RegionType PH_DAVAO_DEL_SUR = new Version2017RegionType(SCHEME, "PH-DAS");

    // PH Davao Oriental
    public static final Version2017RegionType PH_DAVAO_ORIENTAL = new Version2017RegionType(SCHEME, "PH-DAO");

    // PH Eastern Samar
    public static final Version2017RegionType PH_EASTERN_SAMAR = new Version2017RegionType(SCHEME, "PH-EAS");

    // PH Guimaras
    public static final Version2017RegionType PH_GUIMARAS = new Version2017RegionType(SCHEME, "PH-GUI");

    // PH Ifugao
    public static final Version2017RegionType PH_IFUGAO = new Version2017RegionType(SCHEME, "PH-IFU");

    // PH Ilocos Norte
    public static final Version2017RegionType PH_ILOCOS_NORTE = new Version2017RegionType(SCHEME, "PH-ILN");

    // PH Ilocos Sur
    public static final Version2017RegionType PH_ILOCOS_SUR = new Version2017RegionType(SCHEME, "PH-ILS");

    // PH Iloilo
    public static final Version2017RegionType PH_ILOILO = new Version2017RegionType(SCHEME, "PH-ILI");

    // PH Isabela
    public static final Version2017RegionType PH_ISABELA = new Version2017RegionType(SCHEME, "PH-ISA");

    // PH Kalinga
    public static final Version2017RegionType PH_KALINGA = new Version2017RegionType(SCHEME, "PH-KAL");

    // PH Laguna
    public static final Version2017RegionType PH_LAGUNA = new Version2017RegionType(SCHEME, "PH-LAG");

    // PH Lanao Del Norte
    public static final Version2017RegionType PH_LANAO_DEL_NORTE = new Version2017RegionType(SCHEME, "PH-LAN");

    // PH Lanao Del Sur
    public static final Version2017RegionType PH_LANAO_DEL_SUR = new Version2017RegionType(SCHEME, "PH-LAS");

    // PH La Union
    public static final Version2017RegionType PH_LA_UNION = new Version2017RegionType(SCHEME, "PH-LUN");

    // PH Leyte
    public static final Version2017RegionType PH_LEYTE = new Version2017RegionType(SCHEME, "PH-LEY");

    // PH Maguindanao
    public static final Version2017RegionType PH_MAGUINDANAO = new Version2017RegionType(SCHEME, "PH-MAG");

    // PH Marinduque
    public static final Version2017RegionType PH_MARINDUQUE = new Version2017RegionType(SCHEME, "PH-MAD");

    // PH Masbate
    public static final Version2017RegionType PH_MASBATE = new Version2017RegionType(SCHEME, "PH-MAS");

    // PH Mindoro Occidental
    public static final Version2017RegionType PH_MINDORO_OCCIDENTAL = new Version2017RegionType(SCHEME, "PH-MDC");

    // PH Mindoro Oriental
    public static final Version2017RegionType PH_MINDORO_ORIENTAL = new Version2017RegionType(SCHEME, "PH-MDR");

    // PH Misamis Occidental
    public static final Version2017RegionType PH_MISAMIS_OCCIDENTAL = new Version2017RegionType(SCHEME, "PH-MSC");

    // PH Misamis Oriental
    public static final Version2017RegionType PH_MISAMIS_ORIENTAL = new Version2017RegionType(SCHEME, "PH-MSR");

    // PH Mountain Province
    public static final Version2017RegionType PH_MOUNTAIN_PROVINCE = new Version2017RegionType(SCHEME, "PH-MOU");

    // PH Negros Occidental
    public static final Version2017RegionType PH_NEGROS_OCCIDENTAL = new Version2017RegionType(SCHEME, "PH-NEC");

    // PH Negros Oriental
    public static final Version2017RegionType PH_NEGROS_ORIENTAL = new Version2017RegionType(SCHEME, "PH-NER");

    // PH Northern Samar
    public static final Version2017RegionType PH_NORTHERN_SAMAR = new Version2017RegionType(SCHEME, "PH-NSA");

    // PH North Cotabato
    public static final Version2017RegionType PH_NORTH_COTABATO = new Version2017RegionType(SCHEME, "PH-NCO");

    // PH Nueva Ecija
    public static final Version2017RegionType PH_NUEVA_ECIJA = new Version2017RegionType(SCHEME, "PH-NUE");

    // PH Nueva Vizcaya
    public static final Version2017RegionType PH_NUEVA_VIZCAYA = new Version2017RegionType(SCHEME, "PH-NUV");

    // PH Palawan
    public static final Version2017RegionType PH_PALAWAN = new Version2017RegionType(SCHEME, "PH-PLW");

    // PH Pampanga
    public static final Version2017RegionType PH_PAMPANGA = new Version2017RegionType(SCHEME, "PH-PAM");

    // PH Pangasinan
    public static final Version2017RegionType PH_PANGASINAN = new Version2017RegionType(SCHEME, "PH-PAN");

    // PH Quezon
    public static final Version2017RegionType PH_QUEZON = new Version2017RegionType(SCHEME, "PH-QUE");

    // PH Quirino
    public static final Version2017RegionType PH_QUIRINO = new Version2017RegionType(SCHEME, "PH-QUI");

    // PH Rizal
    public static final Version2017RegionType PH_RIZAL = new Version2017RegionType(SCHEME, "PH-RIZ");

    // PH Romblon
    public static final Version2017RegionType PH_ROMBLON = new Version2017RegionType(SCHEME, "PH-ROM");

    // PH Sarangani
    public static final Version2017RegionType PH_SARANGANI = new Version2017RegionType(SCHEME, "PH-SAR");

    // PH Siquijor
    public static final Version2017RegionType PH_SIQUIJOR = new Version2017RegionType(SCHEME, "PH-SIG");

    // PH Sorsogon
    public static final Version2017RegionType PH_SORSOGON = new Version2017RegionType(SCHEME, "PH-SOR");

    // PH Southern Leyte
    public static final Version2017RegionType PH_SOUTHERN_LEYTE = new Version2017RegionType(SCHEME, "PH-SLE");

    // PH South Cotabato
    public static final Version2017RegionType PH_SOUTH_COTABATO = new Version2017RegionType(SCHEME, "PH-SCO");

    // PH Sultan Kudarat
    public static final Version2017RegionType PH_SULTAN_KUDARAT = new Version2017RegionType(SCHEME, "PH-SUK");

    // PH Sulu
    public static final Version2017RegionType PH_SULU = new Version2017RegionType(SCHEME, "PH-SLU");

    // PH Surigao Del Norte
    public static final Version2017RegionType PH_SURIGAO_DEL_NORTE = new Version2017RegionType(SCHEME, "PH-SUN");

    // PH Surigao Del Sur
    public static final Version2017RegionType PH_SURIGAO_DEL_SUR = new Version2017RegionType(SCHEME, "PH-SUR");

    // PH Tarlac
    public static final Version2017RegionType PH_TARLAC = new Version2017RegionType(SCHEME, "PH-TAR");

    // PH Tawi-tawi
    public static final Version2017RegionType PH_TAWI_TAWI = new Version2017RegionType(SCHEME, "PH-TAW");

    // PH Western Samar
    public static final Version2017RegionType PH_WESTERN_SAMAR = new Version2017RegionType(SCHEME, "PH-WSA");

    // PH Zambales
    public static final Version2017RegionType PH_ZAMBALES = new Version2017RegionType(SCHEME, "PH-ZMB");

    // PH Zamboanga Del Norte
    public static final Version2017RegionType PH_ZAMBOANGA_DEL_NORTE = new Version2017RegionType(SCHEME, "PH-ZAN");

    // PH Zamboanga Del Sur
    public static final Version2017RegionType PH_ZAMBOANGA_DEL_SUR = new Version2017RegionType(SCHEME, "PH-ZAS");

    // PH Zamboanga Sibugay
    public static final Version2017RegionType PH_ZAMBOANGA_SIBUGAY = new Version2017RegionType(SCHEME, "PH-ZSI");

    // PK Azad Kashmir
    public static final Version2017RegionType PK_AZAD_KASHMIR = new Version2017RegionType(SCHEME, "PK-JK");

    // PK Baluchistan (en)
    public static final Version2017RegionType PK_BALUCHISTAN_EN = new Version2017RegionType(SCHEME, "PK-BA");

    // PK Federally Administered Tribal Areas
    public static final Version2017RegionType PK_FEDERALLY_ADMINISTERED_TRIBAL_AREAS = new Version2017RegionType(SCHEME, "PK-TA");

    // PK Islamabad
    public static final Version2017RegionType PK_ISLAMABAD = new Version2017RegionType(SCHEME, "PK-IS");

    // PK Northern Areas
    public static final Version2017RegionType PK_NORTHERN_AREAS = new Version2017RegionType(SCHEME, "PK-NA");

    // PK North-west Frontier
    public static final Version2017RegionType PK_NORTH_WEST_FRONTIER = new Version2017RegionType(SCHEME, "PK-NW");

    // PK Punjab, PK
    public static final Version2017RegionType PK_PUNJAB = new Version2017RegionType(SCHEME, "PK-PB");

    // PK Sind (en)
    public static final Version2017RegionType PK_SIND_EN = new Version2017RegionType(SCHEME, "PK-SD");

    // PL Dolnoslaskie
    public static final Version2017RegionType PL_DOLNOSLASKIE = new Version2017RegionType(SCHEME, "PL-DS");

    // PL Kujawsko-pomorskie
    public static final Version2017RegionType PL_KUJAWSKO_POMORSKIE = new Version2017RegionType(SCHEME, "PL-KP");

    // PL Lodzkie
    public static final Version2017RegionType PL_LODZKIE = new Version2017RegionType(SCHEME, "PL-LD");

    // PL Lubelskie
    public static final Version2017RegionType PL_LUBELSKIE = new Version2017RegionType(SCHEME, "PL-LU");

    // PL Lubuskie
    public static final Version2017RegionType PL_LUBUSKIE = new Version2017RegionType(SCHEME, "PL-LB");

    // PL Matopolskie
    public static final Version2017RegionType PL_MATOPOLSKIE = new Version2017RegionType(SCHEME, "PL-MA");

    // PL Mazowieckie
    public static final Version2017RegionType PL_MAZOWIECKIE = new Version2017RegionType(SCHEME, "PL-MZ");

    // PL Opolskie
    public static final Version2017RegionType PL_OPOLSKIE = new Version2017RegionType(SCHEME, "PL-OP");

    // PL Podkarpackie
    public static final Version2017RegionType PL_PODKARPACKIE = new Version2017RegionType(SCHEME, "PL-PK");

    // PL Podlaskie
    public static final Version2017RegionType PL_PODLASKIE = new Version2017RegionType(SCHEME, "PL-PD");

    // PL Pomorskie
    public static final Version2017RegionType PL_POMORSKIE = new Version2017RegionType(SCHEME, "PL-PM");

    // PL Slaskie
    public static final Version2017RegionType PL_SLASKIE = new Version2017RegionType(SCHEME, "PL-SL");

    // PL Swietokrzyskie
    public static final Version2017RegionType PL_SWIETOKRZYSKIE = new Version2017RegionType(SCHEME, "PL-SK");

    // PL Warminsko-mazurskie
    public static final Version2017RegionType PL_WARMINSKO_MAZURSKIE = new Version2017RegionType(SCHEME, "PL-WN");

    // PL Wielkopolskie
    public static final Version2017RegionType PL_WIELKOPOLSKIE = new Version2017RegionType(SCHEME, "PL-WP");

    // PL Zachodniopomorskie
    public static final Version2017RegionType PL_ZACHODNIOPOMORSKIE = new Version2017RegionType(SCHEME, "PL-ZP");

    // PT Aveiro
    public static final Version2017RegionType PT_AVEIRO = new Version2017RegionType(SCHEME, "PT-01");

    // PT Beja
    public static final Version2017RegionType PT_BEJA = new Version2017RegionType(SCHEME, "PT-02");

    // PT Braga
    public static final Version2017RegionType PT_BRAGA = new Version2017RegionType(SCHEME, "PT-03");

    // PT Braganca
    public static final Version2017RegionType PT_BRAGANCA = new Version2017RegionType(SCHEME, "PT-04");

    // PT Castelo Branco
    public static final Version2017RegionType PT_CASTELO_BRANCO = new Version2017RegionType(SCHEME, "PT-05");

    // PT Coimbra
    public static final Version2017RegionType PT_COIMBRA = new Version2017RegionType(SCHEME, "PT-06");

    // PT Evora
    public static final Version2017RegionType PT_EVORA = new Version2017RegionType(SCHEME, "PT-07");

    // PT Faro
    public static final Version2017RegionType PT_FARO = new Version2017RegionType(SCHEME, "PT-08");

    // PT Guarda
    public static final Version2017RegionType PT_GUARDA = new Version2017RegionType(SCHEME, "PT-09");

    // PT Leiria
    public static final Version2017RegionType PT_LEIRIA = new Version2017RegionType(SCHEME, "PT-10");

    // PT Lisboa
    public static final Version2017RegionType PT_LISBOA = new Version2017RegionType(SCHEME, "PT-11");

    // PT Portalegre
    public static final Version2017RegionType PT_PORTALEGRE = new Version2017RegionType(SCHEME, "PT-12");

    // PT Porto
    public static final Version2017RegionType PT_PORTO = new Version2017RegionType(SCHEME, "PT-13");

    // PT Regiao Autonoma Da Madeira
    public static final Version2017RegionType PT_REGIAO_AUTONOMA_DA_MADEIRA = new Version2017RegionType(SCHEME, "PT-30");

    // PT Regiao Autonoma Dos Acores
    public static final Version2017RegionType PT_REGIAO_AUTONOMA_DOS_ACORES = new Version2017RegionType(SCHEME, "PT-20");

    // PT Santarem
    public static final Version2017RegionType PT_SANTAREM = new Version2017RegionType(SCHEME, "PT-14");

    // PT Setubal
    public static final Version2017RegionType PT_SETUBAL = new Version2017RegionType(SCHEME, "PT-15");

    // PT Viana Do Castelo
    public static final Version2017RegionType PT_VIANA_DO_CASTELO = new Version2017RegionType(SCHEME, "PT-16");

    // PT Vila Real
    public static final Version2017RegionType PT_VILA_REAL = new Version2017RegionType(SCHEME, "PT-17");

    // PT Viseu
    public static final Version2017RegionType PT_VISEU = new Version2017RegionType(SCHEME, "PT-18");

    // PY Alto Paraguay
    public static final Version2017RegionType PY_ALTO_PARAGUAY = new Version2017RegionType(SCHEME, "PY-16");

    // PY Alto Parana
    public static final Version2017RegionType PY_ALTO_PARANA = new Version2017RegionType(SCHEME, "PY-10");

    // PY Amambay
    public static final Version2017RegionType PY_AMAMBAY = new Version2017RegionType(SCHEME, "PY-13");

    // PY Asuncion
    public static final Version2017RegionType PY_ASUNCION = new Version2017RegionType(SCHEME, "PY-ASU");

    // PY Boqueron
    public static final Version2017RegionType PY_BOQUERON = new Version2017RegionType(SCHEME, "PY-19");

    // PY Caaguazu
    public static final Version2017RegionType PY_CAAGUAZU = new Version2017RegionType(SCHEME, "PY-5");

    // PY Caazapa
    public static final Version2017RegionType PY_CAAZAPA = new Version2017RegionType(SCHEME, "PY-6");

    // PY Canindeyu
    public static final Version2017RegionType PY_CANINDEYU = new Version2017RegionType(SCHEME, "PY-14");

    // PY Central, PY
    public static final Version2017RegionType PY_CENTRAL = new Version2017RegionType(SCHEME, "PY-11");

    // PY Concepcion
    public static final Version2017RegionType PY_CONCEPCION = new Version2017RegionType(SCHEME, "PY-1");

    // PY Cordillera
    public static final Version2017RegionType PY_CORDILLERA = new Version2017RegionType(SCHEME, "PY-3");

    // PY Guaira
    public static final Version2017RegionType PY_GUAIRA = new Version2017RegionType(SCHEME, "PY-4");

    // PY Itapua
    public static final Version2017RegionType PY_ITAPUA = new Version2017RegionType(SCHEME, "PY-7");

    // PY Misiones
    public static final Version2017RegionType PY_MISIONES = new Version2017RegionType(SCHEME, "PY-8");

    // PY Neembucu
    public static final Version2017RegionType PY_NEEMBUCU = new Version2017RegionType(SCHEME, "PY-12");

    // PY Paraguari
    public static final Version2017RegionType PY_PARAGUARI = new Version2017RegionType(SCHEME, "PY-9");

    // PY Presidente Hayes
    public static final Version2017RegionType PY_PRESIDENTE_HAYES = new Version2017RegionType(SCHEME, "PY-15");

    // PY San Pedro
    public static final Version2017RegionType PY_SAN_PEDRO = new Version2017RegionType(SCHEME, "PY-2");

    // QA Ad Dawhah
    public static final Version2017RegionType QA_AD_DAWHAH = new Version2017RegionType(SCHEME, "QA-DA");

    // QA Al Ghuwayriyah
    public static final Version2017RegionType QA_AL_GHUWAYRIYAH = new Version2017RegionType(SCHEME, "QA-GH");

    // QA Al Jumayliyah
    public static final Version2017RegionType QA_AL_JUMAYLIYAH = new Version2017RegionType(SCHEME, "QA-JU");

    // QA Al Khawr
    public static final Version2017RegionType QA_AL_KHAWR = new Version2017RegionType(SCHEME, "QA-KH");

    // QA Al Wakrah
    public static final Version2017RegionType QA_AL_WAKRAH = new Version2017RegionType(SCHEME, "QA-WA");

    // QA Ar Rayyan
    public static final Version2017RegionType QA_AR_RAYYAN = new Version2017RegionType(SCHEME, "QA-RA");

    // QA Jariyan Al Batnah
    public static final Version2017RegionType QA_JARIYAN_AL_BATNAH = new Version2017RegionType(SCHEME, "QA-JB");

    // QA Madinat Ash Shamal
    public static final Version2017RegionType QA_MADINAT_ASH_SHAMAL = new Version2017RegionType(SCHEME, "QA-MS");

    // QA Umm Salal
    public static final Version2017RegionType QA_UMM_SALAL = new Version2017RegionType(SCHEME, "QA-US");

    // RO Alba
    public static final Version2017RegionType RO_ALBA = new Version2017RegionType(SCHEME, "RO-AB");

    // RO Arad
    public static final Version2017RegionType RO_ARAD = new Version2017RegionType(SCHEME, "RO-AR");

    // RO Arges
    public static final Version2017RegionType RO_ARGES = new Version2017RegionType(SCHEME, "RO-AG");

    // RO Bacau
    public static final Version2017RegionType RO_BACAU = new Version2017RegionType(SCHEME, "RO-BC");

    // RO Bihor
    public static final Version2017RegionType RO_BIHOR = new Version2017RegionType(SCHEME, "RO-BH");

    // RO Bistrita-nasaud
    public static final Version2017RegionType RO_BISTRITA_NASAUD = new Version2017RegionType(SCHEME, "RO-BN");

    // RO Botosani
    public static final Version2017RegionType RO_BOTOSANI = new Version2017RegionType(SCHEME, "RO-BT");

    // RO Braila
    public static final Version2017RegionType RO_BRAILA = new Version2017RegionType(SCHEME, "RO-BR");

    // RO Brasov
    public static final Version2017RegionType RO_BRASOV = new Version2017RegionType(SCHEME, "RO-BV");

    // RO Bucuresti
    public static final Version2017RegionType RO_BUCURESTI = new Version2017RegionType(SCHEME, "RO-B");

    // RO Buzau
    public static final Version2017RegionType RO_BUZAU = new Version2017RegionType(SCHEME, "RO-BZ");

    // RO Calarasi
    public static final Version2017RegionType RO_CALARASI = new Version2017RegionType(SCHEME, "RO-CL");

    // RO Caras-severin
    public static final Version2017RegionType RO_CARAS_SEVERIN = new Version2017RegionType(SCHEME, "RO-CS");

    // RO Cluj
    public static final Version2017RegionType RO_CLUJ = new Version2017RegionType(SCHEME, "RO-CJ");

    // RO Constanta
    public static final Version2017RegionType RO_CONSTANTA = new Version2017RegionType(SCHEME, "RO-CT");

    // RO Covasna
    public static final Version2017RegionType RO_COVASNA = new Version2017RegionType(SCHEME, "RO-CV");

    // RO Dambovita
    public static final Version2017RegionType RO_DAMBOVITA = new Version2017RegionType(SCHEME, "RO-DB");

    // RO Dolj
    public static final Version2017RegionType RO_DOLJ = new Version2017RegionType(SCHEME, "RO-DJ");

    // RO Galati
    public static final Version2017RegionType RO_GALATI = new Version2017RegionType(SCHEME, "RO-GL");

    // RO Giurgiu
    public static final Version2017RegionType RO_GIURGIU = new Version2017RegionType(SCHEME, "RO-GR");

    // RO Gorj
    public static final Version2017RegionType RO_GORJ = new Version2017RegionType(SCHEME, "RO-GJ");

    // RO Harghita
    public static final Version2017RegionType RO_HARGHITA = new Version2017RegionType(SCHEME, "RO-HR");

    // RO Hunedoara
    public static final Version2017RegionType RO_HUNEDOARA = new Version2017RegionType(SCHEME, "RO-HD");

    // RO Ialomta
    public static final Version2017RegionType RO_IALOMTA = new Version2017RegionType(SCHEME, "RO-IL");

    // RO Iasi
    public static final Version2017RegionType RO_IASI = new Version2017RegionType(SCHEME, "RO-IS");

    // RO Ilfov
    public static final Version2017RegionType RO_ILFOV = new Version2017RegionType(SCHEME, "RO-IF");

    // RO Maramures
    public static final Version2017RegionType RO_MARAMURES = new Version2017RegionType(SCHEME, "RO-MM");

    // RO Mehedirti
    public static final Version2017RegionType RO_MEHEDIRTI = new Version2017RegionType(SCHEME, "RO-MH");

    // RO Mures
    public static final Version2017RegionType RO_MURES = new Version2017RegionType(SCHEME, "RO-MS");

    // RO Neamt
    public static final Version2017RegionType RO_NEAMT = new Version2017RegionType(SCHEME, "RO-NT");

    // RO Olt
    public static final Version2017RegionType RO_OLT = new Version2017RegionType(SCHEME, "RO-OT");

    // RO Prahova
    public static final Version2017RegionType RO_PRAHOVA = new Version2017RegionType(SCHEME, "RO-PH");

    // RO Salaj
    public static final Version2017RegionType RO_SALAJ = new Version2017RegionType(SCHEME, "RO-SJ");

    // RO Satu Mare
    public static final Version2017RegionType RO_SATU_MARE = new Version2017RegionType(SCHEME, "RO-SM");

    // RO Sibiu
    public static final Version2017RegionType RO_SIBIU = new Version2017RegionType(SCHEME, "RO-SB");

    // RO Suceava
    public static final Version2017RegionType RO_SUCEAVA = new Version2017RegionType(SCHEME, "RO-SV");

    // RO Teleorman
    public static final Version2017RegionType RO_TELEORMAN = new Version2017RegionType(SCHEME, "RO-TR");

    // RO Timis
    public static final Version2017RegionType RO_TIMIS = new Version2017RegionType(SCHEME, "RO-TM");

    // RO Tulcea
    public static final Version2017RegionType RO_TULCEA = new Version2017RegionType(SCHEME, "RO-TL");

    // RO Valcea
    public static final Version2017RegionType RO_VALCEA = new Version2017RegionType(SCHEME, "RO-VL");

    // RO Vaslui
    public static final Version2017RegionType RO_VASLUI = new Version2017RegionType(SCHEME, "RO-VS");

    // RO Vrancea
    public static final Version2017RegionType RO_VRANCEA = new Version2017RegionType(SCHEME, "RO-VN");

    // RU Adygeya, Respublika
    public static final Version2017RegionType RU_ADYGEYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-AD");

    // RU Aginskiy Buryatskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_AGINSKIY_BURYATSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-AGB");

    // RU Alaniya
    public static final Version2017RegionType RU_ALANIYA = new Version2017RegionType(SCHEME, "RU-SE");

    // RU Altayskiy Kray
    public static final Version2017RegionType RU_ALTAYSKIY_KRAY = new Version2017RegionType(SCHEME, "RU-ALT");

    // RU Altay, Respublika
    public static final Version2017RegionType RU_ALTAY_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-AL");

    // RU Amurskaya Oblast'
    public static final Version2017RegionType RU_AMURSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-AMU");

    // RU Arkhangel'skaya Oblast'
    public static final Version2017RegionType RU_ARKHANGELSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-ARK");

    // RU Astrakhanskaya Oblast'
    public static final Version2017RegionType RU_ASTRAKHANSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-AST");

    // RU Bashkortostan, Respublika
    public static final Version2017RegionType RU_BASHKORTOSTAN_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-BA");

    // RU Belgorodskaya Oblast'
    public static final Version2017RegionType RU_BELGORODSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-BEL");

    // RU Bryanskaya Oblast'
    public static final Version2017RegionType RU_BRYANSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-BRY");

    // RU Buryatiya, Respublika
    public static final Version2017RegionType RU_BURYATIYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-BU");

    // RU Chechenskaya Respublika
    public static final Version2017RegionType RU_CHECHENSKAYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-CE");

    // RU Chelyabinskaya Oblast'
    public static final Version2017RegionType RU_CHELYABINSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-CHE");

    // RU Chitinskaya Oblast'
    public static final Version2017RegionType RU_CHITINSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-CHI");

    // RU Chukotskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_CHUKOTSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-CHU");

    // RU Chuvashskaya Respublika
    public static final Version2017RegionType RU_CHUVASHSKAYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-CU");

    // RU Dagestan, Respublika
    public static final Version2017RegionType RU_DAGESTAN_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-DA");

    // RU Evenkiyskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_EVENKIYSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-EVE");

    // RU Irkutskaya Oblast'
    public static final Version2017RegionType RU_IRKUTSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-IRK");

    // RU Ivanovskaya Oblast'
    public static final Version2017RegionType RU_IVANOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-IVA");

    // RU Kabardino-balkarskaya Respublika
    public static final Version2017RegionType RU_KABARDINO_BALKARSKAYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-KB");

    // RU Kaliningradskaya Oblast'
    public static final Version2017RegionType RU_KALININGRADSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-KGD");

    // RU Kalmykiya, Respublika
    public static final Version2017RegionType RU_KALMYKIYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-KL");

    // RU Kaluzhskaya Oblast'
    public static final Version2017RegionType RU_KALUZHSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-KLU");

    // RU Kamchatskaya Oblast'
    public static final Version2017RegionType RU_KAMCHATSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-KAM");

    // RU Karachayevo-cherkesskaya Respublika
    public static final Version2017RegionType RU_KARACHAYEVO_CHERKESSKAYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-KC");

    // RU Kareliya, Respublika
    public static final Version2017RegionType RU_KARELIYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-KR");

    // RU Kemerovskaya Oblast'
    public static final Version2017RegionType RU_KEMEROVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-KEM");

    // RU Khabarovskiy Kray
    public static final Version2017RegionType RU_KHABAROVSKIY_KRAY = new Version2017RegionType(SCHEME, "RU-KHA");

    // RU Khakasiya, Respublika
    public static final Version2017RegionType RU_KHAKASIYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-KK");

    // RU Khanty-mansiyskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_KHANTY_MANSIYSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-KHM");

    // RU Kirovskaya Oblast'
    public static final Version2017RegionType RU_KIROVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-KIR");

    // RU Komi-permyatskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_KOMI_PERMYATSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-KOP");

    // RU Komi, Respublika
    public static final Version2017RegionType RU_KOMI_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-KO");

    // RU Koryakskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_KORYAKSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-KOR");

    // RU Kostromskaya Oblast'
    public static final Version2017RegionType RU_KOSTROMSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-KOS");

    // RU Krasnodarskiy Kray
    public static final Version2017RegionType RU_KRASNODARSKIY_KRAY = new Version2017RegionType(SCHEME, "RU-KDA");

    // RU Krasnoyarskiy Kray
    public static final Version2017RegionType RU_KRASNOYARSKIY_KRAY = new Version2017RegionType(SCHEME, "RU-KYA");

    // RU Kurganskaya Oblast'
    public static final Version2017RegionType RU_KURGANSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-KGN");

    // RU Kurskaya Oblast'
    public static final Version2017RegionType RU_KURSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-KRS");

    // RU Leningradskaya Oblast'
    public static final Version2017RegionType RU_LENINGRADSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-LEN");

    // RU Lipetskaya Oblast'
    public static final Version2017RegionType RU_LIPETSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-LIP");

    // RU Magadanskaya Oblast'
    public static final Version2017RegionType RU_MAGADANSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-MAG");

    // RU Mariy El, Respublika
    public static final Version2017RegionType RU_MARIY_EL_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-ME");

    // RU Mordoviya, Respublika
    public static final Version2017RegionType RU_MORDOVIYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-MO");

    // RU Moskovskaya Oblast'
    public static final Version2017RegionType RU_MOSKOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-MOS");

    // RU Moskva
    public static final Version2017RegionType RU_MOSKVA = new Version2017RegionType(SCHEME, "RU-MOW");

    // RU Murmanskaya Oblast'
    public static final Version2017RegionType RU_MURMANSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-MUR");

    // RU Nenetskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_NENETSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-NEN");

    // RU Nizhegorodskaya Oblast'
    public static final Version2017RegionType RU_NIZHEGORODSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-NIZ");

    // RU Novgorodskaya Oblast'
    public static final Version2017RegionType RU_NOVGORODSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-NGR");

    // RU Novosibirskaya Oblast'
    public static final Version2017RegionType RU_NOVOSIBIRSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-NVS");

    // RU Omskaya Oblast'
    public static final Version2017RegionType RU_OMSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-OMS");

    // RU Orenburgskaya Oblast'
    public static final Version2017RegionType RU_ORENBURGSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-ORE");

    // RU Orlovskaya Oblast'
    public static final Version2017RegionType RU_ORLOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-ORL");

    // RU Penzenskaya Oblast'
    public static final Version2017RegionType RU_PENZENSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-PNZ");

    // RU Permskaya Oblast'
    public static final Version2017RegionType RU_PERMSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-PER");

    // RU Primorskiy Kray
    public static final Version2017RegionType RU_PRIMORSKIY_KRAY = new Version2017RegionType(SCHEME, "RU-PRI");

    // RU Pskovskaya Oblast'
    public static final Version2017RegionType RU_PSKOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-PSK");

    // RU Respublika Ingushetiya
    public static final Version2017RegionType RU_RESPUBLIKA_INGUSHETIYA = new Version2017RegionType(SCHEME, "RU-IN");

    // RU Rostovskaya Oblast'
    public static final Version2017RegionType RU_ROSTOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-ROS");

    // RU Ryazanskaya Oblast'
    public static final Version2017RegionType RU_RYAZANSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-RYA");

    // RU Sakhalinskaya Oblast'
    public static final Version2017RegionType RU_SAKHALINSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-SAK");

    // RU Samarskaya Oblast'
    public static final Version2017RegionType RU_SAMARSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-SAM");

    // RU Sankt-peterburg
    public static final Version2017RegionType RU_SANKT_PETERBURG = new Version2017RegionType(SCHEME, "RU-SPE");

    // RU Saratovskaya Oblast'
    public static final Version2017RegionType RU_SARATOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-SAR");

    // RU Smolenskaya Oblast'
    public static final Version2017RegionType RU_SMOLENSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-SMO");

    // RU Stavropol'skiy Kray
    public static final Version2017RegionType RU_STAVROPOLSKIY_KRAY = new Version2017RegionType(SCHEME, "RU-STA");

    // RU Sverdlovskaya Oblast'
    public static final Version2017RegionType RU_SVERDLOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-SVE");

    // RU Tambovskaya Oblast'
    public static final Version2017RegionType RU_TAMBOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-TAM");

    // RU Tatarstan, Respublika
    public static final Version2017RegionType RU_TATARSTAN_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-TA");

    // RU Taymyrskiy (dolgano-nenetskiy) Avtonomnyy Okrug
    public static final Version2017RegionType RU_TAYMYRSKIY_DOLGANO_NENETSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-TAY");

    // RU Tomskaya Oblast'
    public static final Version2017RegionType RU_TOMSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-TOM");

    // RU Tul'skaya Oblast'
    public static final Version2017RegionType RU_TULSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-TUL");

    // RU Tuva
    public static final Version2017RegionType RU_TUVA = new Version2017RegionType(SCHEME, "RU-TY");

    // RU Tverskaya Oblast'
    public static final Version2017RegionType RU_TVERSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-TVE");

    // RU Tyumenskaya Oblast'
    public static final Version2017RegionType RU_TYUMENSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-TYU");

    // RU Udmurtskaya Respublika
    public static final Version2017RegionType RU_UDMURTSKAYA_RESPUBLIKA = new Version2017RegionType(SCHEME, "RU-UD");

    // RU Ul'yanovskaya Oblast'
    public static final Version2017RegionType RU_ULYANOVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-ULY");

    // RU Ust'-ordynskiy Buryatskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_UST_ORDYNSKIY_BURYATSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-UOB");

    // RU Vladimirskaya Oblast'
    public static final Version2017RegionType RU_VLADIMIRSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-VLA");

    // RU Volgogradskaya Oblast'
    public static final Version2017RegionType RU_VOLGOGRADSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-VGG");

    // RU Vologodskaya Oblast'
    public static final Version2017RegionType RU_VOLOGODSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-VLG");

    // RU Voronezhskaya Oblast'
    public static final Version2017RegionType RU_VORONEZHSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-VOR");

    // RU Yakutiya
    public static final Version2017RegionType RU_YAKUTIYA = new Version2017RegionType(SCHEME, "RU-SA");

    // RU Yamalo-nenetskiy Avtonomnyy Okrug
    public static final Version2017RegionType RU_YAMALO_NENETSKIY_AVTONOMNYY_OKRUG = new Version2017RegionType(SCHEME, "RU-YAN");

    // RU Yaroslavskaya Oblast'
    public static final Version2017RegionType RU_YAROSLAVSKAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-YAR");

    // RU Yevreyskaya Avtonomnaya Oblast'
    public static final Version2017RegionType RU_YEVREYSKAYA_AVTONOMNAYA_OBLAST = new Version2017RegionType(SCHEME, "RU-YEV");

    // RW Butare
    public static final Version2017RegionType RW_BUTARE = new Version2017RegionType(SCHEME, "RW-C");

    // RW Byumba
    public static final Version2017RegionType RW_BYUMBA = new Version2017RegionType(SCHEME, "RW-I");

    // RW Cyangugu
    public static final Version2017RegionType RW_CYANGUGU = new Version2017RegionType(SCHEME, "RW-E");

    // RW Gikongoro
    public static final Version2017RegionType RW_GIKONGORO = new Version2017RegionType(SCHEME, "RW-D");

    // RW Gisenyi
    public static final Version2017RegionType RW_GISENYI = new Version2017RegionType(SCHEME, "RW-G");

    // RW Gitarama
    public static final Version2017RegionType RW_GITARAMA = new Version2017RegionType(SCHEME, "RW-B");

    // RW Kibungo
    public static final Version2017RegionType RW_KIBUNGO = new Version2017RegionType(SCHEME, "RW-J");

    // RW Kibuye
    public static final Version2017RegionType RW_KIBUYE = new Version2017RegionType(SCHEME, "RW-F");

    // RW Kigali-rural
    public static final Version2017RegionType RW_KIGALI_RURAL = new Version2017RegionType(SCHEME, "RW-K");

    // RW Kigali-ville
    public static final Version2017RegionType RW_KIGALI_VILLE = new Version2017RegionType(SCHEME, "RW-L");

    // RW Mutara
    public static final Version2017RegionType RW_MUTARA = new Version2017RegionType(SCHEME, "RW-M");

    // RW Ruhengeri
    public static final Version2017RegionType RW_RUHENGERI = new Version2017RegionType(SCHEME, "RW-H");

    // SA Al Bahah
    public static final Version2017RegionType SA_AL_BAHAH = new Version2017RegionType(SCHEME, "SA-11");

    // SA Al Hudud Ash Shamaliyah
    public static final Version2017RegionType SA_AL_HUDUD_ASH_SHAMALIYAH = new Version2017RegionType(SCHEME, "SA-08");

    // SA Al Jawf
    public static final Version2017RegionType SA_AL_JAWF = new Version2017RegionType(SCHEME, "SA-12");

    // SA Al Macinah
    public static final Version2017RegionType SA_AL_MACINAH = new Version2017RegionType(SCHEME, "SA-03");

    // SA Al Qasim
    public static final Version2017RegionType SA_AL_QASIM = new Version2017RegionType(SCHEME, "SA-05");

    // SA Ar Riyad
    public static final Version2017RegionType SA_AR_RIYAD = new Version2017RegionType(SCHEME, "SA-01");

    // SA Ash Sharqiyah, SA
    public static final Version2017RegionType SA_ASH_SHARQIYAH = new Version2017RegionType(SCHEME, "SA-04");

    // SA Asir
    public static final Version2017RegionType SA_ASIR = new Version2017RegionType(SCHEME, "SA-14");

    // SA Ha'il
    public static final Version2017RegionType SA_HAIL = new Version2017RegionType(SCHEME, "SA-06");

    // SA Jizan
    public static final Version2017RegionType SA_JIZAN = new Version2017RegionType(SCHEME, "SA-09");

    // SA Makkah
    public static final Version2017RegionType SA_MAKKAH = new Version2017RegionType(SCHEME, "SA-02");

    // SA Najran
    public static final Version2017RegionType SA_NAJRAN = new Version2017RegionType(SCHEME, "SA-10");

    // SA Tabuk
    public static final Version2017RegionType SA_TABUK = new Version2017RegionType(SCHEME, "SA-07");

    // SB Capital Territory (honiara)
    public static final Version2017RegionType SB_CAPITAL_TERRITORY_HONIARA = new Version2017RegionType(SCHEME, "SB-CT");

    // SB Central, SB
    public static final Version2017RegionType SB_CENTRAL = new Version2017RegionType(SCHEME, "SB-CE");

    // SB Guadalcanal
    public static final Version2017RegionType SB_GUADALCANAL = new Version2017RegionType(SCHEME, "SB-GU");

    // SB Isabel
    public static final Version2017RegionType SB_ISABEL = new Version2017RegionType(SCHEME, "SB-IS");

    // SB Makira
    public static final Version2017RegionType SB_MAKIRA = new Version2017RegionType(SCHEME, "SB-MK");

    // SB Malaita
    public static final Version2017RegionType SB_MALAITA = new Version2017RegionType(SCHEME, "SB-ML");

    // SB Temotu
    public static final Version2017RegionType SB_TEMOTU = new Version2017RegionType(SCHEME, "SB-TE");

    // SB Western, SB
    public static final Version2017RegionType SB_WESTERN = new Version2017RegionType(SCHEME, "SB-WE");

    // SD Aali An Nil
    public static final Version2017RegionType SD_AALI_AN_NIL = new Version2017RegionType(SCHEME, "SD-23");

    // SD Al Bahr Al Ahmar, SD
    public static final Version2017RegionType SD_AL_BAHR_AL_AHMAR = new Version2017RegionType(SCHEME, "SD-26");

    // SD Al Buhayrat
    public static final Version2017RegionType SD_AL_BUHAYRAT = new Version2017RegionType(SCHEME, "SD-18");

    // SD Al Jazirah
    public static final Version2017RegionType SD_AL_JAZIRAH = new Version2017RegionType(SCHEME, "SD-07");

    // SD Al Khartum
    public static final Version2017RegionType SD_AL_KHARTUM = new Version2017RegionType(SCHEME, "SD-03");

    // SD Al Qadarif
    public static final Version2017RegionType SD_AL_QADARIF = new Version2017RegionType(SCHEME, "SD-06");

    // SD Al Wahdah
    public static final Version2017RegionType SD_AL_WAHDAH = new Version2017RegionType(SCHEME, "SD-22");

    // SD An Nil
    public static final Version2017RegionType SD_AN_NIL = new Version2017RegionType(SCHEME, "SD-04");

    // SD An Nil Al Abyad
    public static final Version2017RegionType SD_AN_NIL_AL_ABYAD = new Version2017RegionType(SCHEME, "SD-08");

    // SD An Nil Al Azraq
    public static final Version2017RegionType SD_AN_NIL_AL_AZRAQ = new Version2017RegionType(SCHEME, "SD-24");

    // SD Ash Shamaliyah
    public static final Version2017RegionType SD_ASH_SHAMALIYAH = new Version2017RegionType(SCHEME, "SD-01");

    // SD Bahr Al Jabal
    public static final Version2017RegionType SD_BAHR_AL_JABAL = new Version2017RegionType(SCHEME, "SD-17");

    // SD Gharb Al Istiwa'iyah
    public static final Version2017RegionType SD_GHARB_AL_ISTIWAIYAH = new Version2017RegionType(SCHEME, "SD-16");

    // SD Gharb Bahr Al Ghazal
    public static final Version2017RegionType SD_GHARB_BAHR_AL_GHAZAL = new Version2017RegionType(SCHEME, "SD-14");

    // SD Gharb Darfur
    public static final Version2017RegionType SD_GHARB_DARFUR = new Version2017RegionType(SCHEME, "SD-12");

    // SD Gharb Kurdufan
    public static final Version2017RegionType SD_GHARB_KURDUFAN = new Version2017RegionType(SCHEME, "SD-10");

    // SD Janub Darfur
    public static final Version2017RegionType SD_JANUB_DARFUR = new Version2017RegionType(SCHEME, "SD-11");

    // SD Janub Kurdufan
    public static final Version2017RegionType SD_JANUB_KURDUFAN = new Version2017RegionType(SCHEME, "SD-13");

    // SD Junqali
    public static final Version2017RegionType SD_JUNQALI = new Version2017RegionType(SCHEME, "SD-20");

    // SD Kassala
    public static final Version2017RegionType SD_KASSALA = new Version2017RegionType(SCHEME, "SD-05");

    // SD Shamal Bahr Al Ghazal
    public static final Version2017RegionType SD_SHAMAL_BAHR_AL_GHAZAL = new Version2017RegionType(SCHEME, "SD-15");

    // SD Shamal Darfur
    public static final Version2017RegionType SD_SHAMAL_DARFUR = new Version2017RegionType(SCHEME, "SD-02");

    // SD Shamal Kurdufan
    public static final Version2017RegionType SD_SHAMAL_KURDUFAN = new Version2017RegionType(SCHEME, "SD-09");

    // SD Sharq Al Istiwa'iyah
    public static final Version2017RegionType SD_SHARQ_AL_ISTIWAIYAH = new Version2017RegionType(SCHEME, "SD-19");

    // SD Sinnar
    public static final Version2017RegionType SD_SINNAR = new Version2017RegionType(SCHEME, "SD-25");

    // SD Warab
    public static final Version2017RegionType SD_WARAB = new Version2017RegionType(SCHEME, "SD-21");

    // SE Se-01
    public static final Version2017RegionType SE_SE_01 = new Version2017RegionType(SCHEME, "SE-AB");

    // SE Se-03
    public static final Version2017RegionType SE_SE_03 = new Version2017RegionType(SCHEME, "SE-C");

    // SE Se-04
    public static final Version2017RegionType SE_SE_04 = new Version2017RegionType(SCHEME, "SE-D");

    // SE Se-05
    public static final Version2017RegionType SE_SE_05 = new Version2017RegionType(SCHEME, "SE-E");

    // SE Se-06
    public static final Version2017RegionType SE_SE_06 = new Version2017RegionType(SCHEME, "SE-F");

    // SE Se-07
    public static final Version2017RegionType SE_SE_07 = new Version2017RegionType(SCHEME, "SE-G");

    // SE Se-08
    public static final Version2017RegionType SE_SE_08 = new Version2017RegionType(SCHEME, "SE-H");

    // SE Se-09
    public static final Version2017RegionType SE_SE_09 = new Version2017RegionType(SCHEME, "SE-I");

    // SE Se-10
    public static final Version2017RegionType SE_SE_10 = new Version2017RegionType(SCHEME, "SE-K");

    // SE Se-12
    public static final Version2017RegionType SE_SE_12 = new Version2017RegionType(SCHEME, "SE-M");

    // SE Se-13
    public static final Version2017RegionType SE_SE_13 = new Version2017RegionType(SCHEME, "SE-N");

    // SE Se-14
    public static final Version2017RegionType SE_SE_14 = new Version2017RegionType(SCHEME, "SE-O");

    // SE Se-17
    public static final Version2017RegionType SE_SE_17 = new Version2017RegionType(SCHEME, "SE-S");

    // SE Se-18
    public static final Version2017RegionType SE_SE_18 = new Version2017RegionType(SCHEME, "SE-T");

    // SE Se-19
    public static final Version2017RegionType SE_SE_19 = new Version2017RegionType(SCHEME, "SE-U");

    // SE Se-20
    public static final Version2017RegionType SE_SE_20 = new Version2017RegionType(SCHEME, "SE-W");

    // SE Se-21
    public static final Version2017RegionType SE_SE_21 = new Version2017RegionType(SCHEME, "SE-X");

    // SE Se-22
    public static final Version2017RegionType SE_SE_22 = new Version2017RegionType(SCHEME, "SE-Y");

    // SE Se-23
    public static final Version2017RegionType SE_SE_23 = new Version2017RegionType(SCHEME, "SE-Z");

    // SE Se-24
    public static final Version2017RegionType SE_SE_24 = new Version2017RegionType(SCHEME, "SE-AC");

    // SE Se-25
    public static final Version2017RegionType SE_SE_25 = new Version2017RegionType(SCHEME, "SE-BD");

    // SH Ascension
    public static final Version2017RegionType SH_ASCENSION = new Version2017RegionType(SCHEME, "SH-AC");

    // SH Saint Helena
    public static final Version2017RegionType SH_SAINT_HELENA = new Version2017RegionType(SCHEME, "SH-SH");

    // SH Tristan Da Cunha
    public static final Version2017RegionType SH_TRISTAN_DA_CUNHA = new Version2017RegionType(SCHEME, "SH-TA");

    // SI Ajdovtcina
    public static final Version2017RegionType SI_AJDOVTCINA = new Version2017RegionType(SCHEME, "SI-001");

    // SI Beltinci
    public static final Version2017RegionType SI_BELTINCI = new Version2017RegionType(SCHEME, "SI-002");

    // SI Benedikt
    public static final Version2017RegionType SI_BENEDIKT = new Version2017RegionType(SCHEME, "SI-148");

    // SI Bistrica Ob Sotli
    public static final Version2017RegionType SI_BISTRICA_OB_SOTLI = new Version2017RegionType(SCHEME, "SI-149");

    // SI Bled
    public static final Version2017RegionType SI_BLED = new Version2017RegionType(SCHEME, "SI-003");

    // SI Bloke
    public static final Version2017RegionType SI_BLOKE = new Version2017RegionType(SCHEME, "SI-150");

    // SI Bohinj
    public static final Version2017RegionType SI_BOHINJ = new Version2017RegionType(SCHEME, "SI-004");

    // SI Borovnica
    public static final Version2017RegionType SI_BOROVNICA = new Version2017RegionType(SCHEME, "SI-005");

    // SI Bovec
    public static final Version2017RegionType SI_BOVEC = new Version2017RegionType(SCHEME, "SI-006");

    // SI Braslovce
    public static final Version2017RegionType SI_BRASLOVCE = new Version2017RegionType(SCHEME, "SI-151");

    // SI Brda
    public static final Version2017RegionType SI_BRDA = new Version2017RegionType(SCHEME, "SI-007");

    // SI Brezice
    public static final Version2017RegionType SI_BREZICE = new Version2017RegionType(SCHEME, "SI-009");

    // SI Brezovica
    public static final Version2017RegionType SI_BREZOVICA = new Version2017RegionType(SCHEME, "SI-008");

    // SI Cankova
    public static final Version2017RegionType SI_CANKOVA = new Version2017RegionType(SCHEME, "SI-152");

    // SI Celje
    public static final Version2017RegionType SI_CELJE = new Version2017RegionType(SCHEME, "SI-011");

    // SI Cerklje Na Gorenjskem
    public static final Version2017RegionType SI_CERKLJE_NA_GORENJSKEM = new Version2017RegionType(SCHEME, "SI-012");

    // SI Cerknica
    public static final Version2017RegionType SI_CERKNICA = new Version2017RegionType(SCHEME, "SI-013");

    // SI Cerkno
    public static final Version2017RegionType SI_CERKNO = new Version2017RegionType(SCHEME, "SI-014");

    // SI Cerkvenjak
    public static final Version2017RegionType SI_CERKVENJAK = new Version2017RegionType(SCHEME, "SI-153");

    // SI Crentovci
    public static final Version2017RegionType SI_CRENTOVCI = new Version2017RegionType(SCHEME, "SI-015");

    // SI Crna Na Korotkem
    public static final Version2017RegionType SI_CRNA_NA_KOROTKEM = new Version2017RegionType(SCHEME, "SI-016");

    // SI Crnomelj
    public static final Version2017RegionType SI_CRNOMELJ = new Version2017RegionType(SCHEME, "SI-017");

    // SI Destrnik
    public static final Version2017RegionType SI_DESTRNIK = new Version2017RegionType(SCHEME, "SI-018");

    // SI Divaca
    public static final Version2017RegionType SI_DIVACA = new Version2017RegionType(SCHEME, "SI-019");

    // SI Dobje
    public static final Version2017RegionType SI_DOBJE = new Version2017RegionType(SCHEME, "SI-154");

    // SI Dobrepolje
    public static final Version2017RegionType SI_DOBREPOLJE = new Version2017RegionType(SCHEME, "SI-020");

    // SI Dobrna
    public static final Version2017RegionType SI_DOBRNA = new Version2017RegionType(SCHEME, "SI-155");

    // SI Dobrova-polhov Gradec
    public static final Version2017RegionType SI_DOBROVA_POLHOV_GRADEC = new Version2017RegionType(SCHEME, "SI-021");

    // SI Dobrovnik
    public static final Version2017RegionType SI_DOBROVNIK = new Version2017RegionType(SCHEME, "SI-156");

    // SI Dolenjske Toplice
    public static final Version2017RegionType SI_DOLENJSKE_TOPLICE = new Version2017RegionType(SCHEME, "SI-157");

    // SI Dol Pri Ljubljani
    public static final Version2017RegionType SI_DOL_PRI_LJUBLJANI = new Version2017RegionType(SCHEME, "SI-022");

    // SI Domzale
    public static final Version2017RegionType SI_DOMZALE = new Version2017RegionType(SCHEME, "SI-023");

    // SI Dornava
    public static final Version2017RegionType SI_DORNAVA = new Version2017RegionType(SCHEME, "SI-024");

    // SI Dravograd
    public static final Version2017RegionType SI_DRAVOGRAD = new Version2017RegionType(SCHEME, "SI-025");

    // SI Duplek
    public static final Version2017RegionType SI_DUPLEK = new Version2017RegionType(SCHEME, "SI-026");

    // SI Gorenja Vas-poljane
    public static final Version2017RegionType SI_GORENJA_VAS_POLJANE = new Version2017RegionType(SCHEME, "SI-027");

    // SI Goritnica
    public static final Version2017RegionType SI_GORITNICA = new Version2017RegionType(SCHEME, "SI-028");

    // SI Gornja Radgona
    public static final Version2017RegionType SI_GORNJA_RADGONA = new Version2017RegionType(SCHEME, "SI-029");

    // SI Gornji Grad
    public static final Version2017RegionType SI_GORNJI_GRAD = new Version2017RegionType(SCHEME, "SI-030");

    // SI Gornji Petrovci
    public static final Version2017RegionType SI_GORNJI_PETROVCI = new Version2017RegionType(SCHEME, "SI-031");

    // SI Grad
    public static final Version2017RegionType SI_GRAD = new Version2017RegionType(SCHEME, "SI-158");

    // SI Grosuplje
    public static final Version2017RegionType SI_GROSUPLJE = new Version2017RegionType(SCHEME, "SI-032");

    // SI Hajdina
    public static final Version2017RegionType SI_HAJDINA = new Version2017RegionType(SCHEME, "SI-159");

    // SI Hoce-slivnica
    public static final Version2017RegionType SI_HOCE_SLIVNICA = new Version2017RegionType(SCHEME, "SI-160");

    // SI Hodot
    public static final Version2017RegionType SI_HODOT = new Version2017RegionType(SCHEME, "SI-161");

    // SI Horjul
    public static final Version2017RegionType SI_HORJUL = new Version2017RegionType(SCHEME, "SI-162");

    // SI Hrastnik
    public static final Version2017RegionType SI_HRASTNIK = new Version2017RegionType(SCHEME, "SI-034");

    // SI Hrpelje-kozina
    public static final Version2017RegionType SI_HRPELJE_KOZINA = new Version2017RegionType(SCHEME, "SI-035");

    // SI Idrija
    public static final Version2017RegionType SI_IDRIJA = new Version2017RegionType(SCHEME, "SI-036");

    // SI Ig
    public static final Version2017RegionType SI_IG = new Version2017RegionType(SCHEME, "SI-037");

    // SI Ilirska Bistrica
    public static final Version2017RegionType SI_ILIRSKA_BISTRICA = new Version2017RegionType(SCHEME, "SI-038");

    // SI Ivancna Gorica
    public static final Version2017RegionType SI_IVANCNA_GORICA = new Version2017RegionType(SCHEME, "SI-039");

    // SI Izola
    public static final Version2017RegionType SI_IZOLA = new Version2017RegionType(SCHEME, "SI-040");

    // SI Jesenice
    public static final Version2017RegionType SI_JESENICE = new Version2017RegionType(SCHEME, "SI-041");

    // SI Jezersko
    public static final Version2017RegionType SI_JEZERSKO = new Version2017RegionType(SCHEME, "SI-163");

    // SI Jurtinci
    public static final Version2017RegionType SI_JURTINCI = new Version2017RegionType(SCHEME, "SI-042");

    // SI Kamnik
    public static final Version2017RegionType SI_KAMNIK = new Version2017RegionType(SCHEME, "SI-043");

    // SI Kanal
    public static final Version2017RegionType SI_KANAL = new Version2017RegionType(SCHEME, "SI-044");

    // SI Kidricevo
    public static final Version2017RegionType SI_KIDRICEVO = new Version2017RegionType(SCHEME, "SI-045");

    // SI Kobarid
    public static final Version2017RegionType SI_KOBARID = new Version2017RegionType(SCHEME, "SI-046");

    // SI Kobilje
    public static final Version2017RegionType SI_KOBILJE = new Version2017RegionType(SCHEME, "SI-047");

    // SI Kocevje
    public static final Version2017RegionType SI_KOCEVJE = new Version2017RegionType(SCHEME, "SI-048");

    // SI Komen
    public static final Version2017RegionType SI_KOMEN = new Version2017RegionType(SCHEME, "SI-049");

    // SI Komenda
    public static final Version2017RegionType SI_KOMENDA = new Version2017RegionType(SCHEME, "SI-164");

    // SI Koper
    public static final Version2017RegionType SI_KOPER = new Version2017RegionType(SCHEME, "SI-050");

    // SI Kostel
    public static final Version2017RegionType SI_KOSTEL = new Version2017RegionType(SCHEME, "SI-165");

    // SI Kozje
    public static final Version2017RegionType SI_KOZJE = new Version2017RegionType(SCHEME, "SI-051");

    // SI Kranj
    public static final Version2017RegionType SI_KRANJ = new Version2017RegionType(SCHEME, "SI-052");

    // SI Kranjska Gora
    public static final Version2017RegionType SI_KRANJSKA_GORA = new Version2017RegionType(SCHEME, "SI-053");

    // SI Krizevci
    public static final Version2017RegionType SI_KRIZEVCI = new Version2017RegionType(SCHEME, "SI-166");

    // SI Krtko
    public static final Version2017RegionType SI_KRTKO = new Version2017RegionType(SCHEME, "SI-054");

    // SI Kungota
    public static final Version2017RegionType SI_KUNGOTA = new Version2017RegionType(SCHEME, "SI-055");

    // SI Kuzma
    public static final Version2017RegionType SI_KUZMA = new Version2017RegionType(SCHEME, "SI-056");

    // SI Latko
    public static final Version2017RegionType SI_LATKO = new Version2017RegionType(SCHEME, "SI-057");

    // SI Lenart
    public static final Version2017RegionType SI_LENART = new Version2017RegionType(SCHEME, "SI-058");

    // SI Lendava
    public static final Version2017RegionType SI_LENDAVA = new Version2017RegionType(SCHEME, "SI-059");

    // SI Litija
    public static final Version2017RegionType SI_LITIJA = new Version2017RegionType(SCHEME, "SI-060");

    // SI Ljubljana
    public static final Version2017RegionType SI_LJUBLJANA = new Version2017RegionType(SCHEME, "SI-061");

    // SI Ljubno
    public static final Version2017RegionType SI_LJUBNO = new Version2017RegionType(SCHEME, "SI-062");

    // SI Ljutomer
    public static final Version2017RegionType SI_LJUTOMER = new Version2017RegionType(SCHEME, "SI-063");

    // SI Logatec
    public static final Version2017RegionType SI_LOGATEC = new Version2017RegionType(SCHEME, "SI-064");

    // SI Lotka Dolina
    public static final Version2017RegionType SI_LOTKA_DOLINA = new Version2017RegionType(SCHEME, "SI-065");

    // SI Lotki Potok
    public static final Version2017RegionType SI_LOTKI_POTOK = new Version2017RegionType(SCHEME, "SI-066");

    // SI Lovrenc Na Pohorju
    public static final Version2017RegionType SI_LOVRENC_NA_POHORJU = new Version2017RegionType(SCHEME, "SI-167");

    // SI Luce
    public static final Version2017RegionType SI_LUCE = new Version2017RegionType(SCHEME, "SI-067");

    // SI Lukovica
    public static final Version2017RegionType SI_LUKOVICA = new Version2017RegionType(SCHEME, "SI-068");

    // SI Majtperk
    public static final Version2017RegionType SI_MAJTPERK = new Version2017RegionType(SCHEME, "SI-069");

    // SI Maribor
    public static final Version2017RegionType SI_MARIBOR = new Version2017RegionType(SCHEME, "SI-070");

    // SI Markovci
    public static final Version2017RegionType SI_MARKOVCI = new Version2017RegionType(SCHEME, "SI-168");

    // SI Medvode
    public static final Version2017RegionType SI_MEDVODE = new Version2017RegionType(SCHEME, "SI-071");

    // SI Menget
    public static final Version2017RegionType SI_MENGET = new Version2017RegionType(SCHEME, "SI-072");

    // SI Metlika
    public static final Version2017RegionType SI_METLIKA = new Version2017RegionType(SCHEME, "SI-073");

    // SI Mezica
    public static final Version2017RegionType SI_MEZICA = new Version2017RegionType(SCHEME, "SI-074");

    // SI Miklavz Na Dravskem Polju
    public static final Version2017RegionType SI_MIKLAVZ_NA_DRAVSKEM_POLJU = new Version2017RegionType(SCHEME, "SI-169");

    // SI Miren-kostanjevica
    public static final Version2017RegionType SI_MIREN_KOSTANJEVICA = new Version2017RegionType(SCHEME, "SI-075");

    // SI Mirna Pec
    public static final Version2017RegionType SI_MIRNA_PEC = new Version2017RegionType(SCHEME, "SI-170");

    // SI Mislinja
    public static final Version2017RegionType SI_MISLINJA = new Version2017RegionType(SCHEME, "SI-076");

    // SI Moravce
    public static final Version2017RegionType SI_MORAVCE = new Version2017RegionType(SCHEME, "SI-077");

    // SI Moravske Toplice
    public static final Version2017RegionType SI_MORAVSKE_TOPLICE = new Version2017RegionType(SCHEME, "SI-078");

    // SI Mozirje
    public static final Version2017RegionType SI_MOZIRJE = new Version2017RegionType(SCHEME, "SI-079");

    // SI Murska Sobota
    public static final Version2017RegionType SI_MURSKA_SOBOTA = new Version2017RegionType(SCHEME, "SI-080");

    // SI Muta
    public static final Version2017RegionType SI_MUTA = new Version2017RegionType(SCHEME, "SI-081");

    // SI Naklo
    public static final Version2017RegionType SI_NAKLO = new Version2017RegionType(SCHEME, "SI-082");

    // SI Nazarje
    public static final Version2017RegionType SI_NAZARJE = new Version2017RegionType(SCHEME, "SI-083");

    // SI Nova Gorica
    public static final Version2017RegionType SI_NOVA_GORICA = new Version2017RegionType(SCHEME, "SI-084");

    // SI Novo Mesto
    public static final Version2017RegionType SI_NOVO_MESTO = new Version2017RegionType(SCHEME, "SI-085");

    // SI Odranci
    public static final Version2017RegionType SI_ODRANCI = new Version2017RegionType(SCHEME, "SI-086");

    // SI Oplotnica
    public static final Version2017RegionType SI_OPLOTNICA = new Version2017RegionType(SCHEME, "SI-171");

    // SI Ormoz
    public static final Version2017RegionType SI_ORMOZ = new Version2017RegionType(SCHEME, "SI-087");

    // SI Osilnica
    public static final Version2017RegionType SI_OSILNICA = new Version2017RegionType(SCHEME, "SI-088");

    // SI Pesnica
    public static final Version2017RegionType SI_PESNICA = new Version2017RegionType(SCHEME, "SI-089");

    // SI Piran
    public static final Version2017RegionType SI_PIRAN = new Version2017RegionType(SCHEME, "SI-090");

    // SI Pivka
    public static final Version2017RegionType SI_PIVKA = new Version2017RegionType(SCHEME, "SI-091");

    // SI Podcetrtek
    public static final Version2017RegionType SI_PODCETRTEK = new Version2017RegionType(SCHEME, "SI-092");

    // SI Podlehnik
    public static final Version2017RegionType SI_PODLEHNIK = new Version2017RegionType(SCHEME, "SI-172");

    // SI Podvelka
    public static final Version2017RegionType SI_PODVELKA = new Version2017RegionType(SCHEME, "SI-093");

    // SI Polzela
    public static final Version2017RegionType SI_POLZELA = new Version2017RegionType(SCHEME, "SI-173");

    // SI Postojna
    public static final Version2017RegionType SI_POSTOJNA = new Version2017RegionType(SCHEME, "SI-094");

    // SI Prebold
    public static final Version2017RegionType SI_PREBOLD = new Version2017RegionType(SCHEME, "SI-174");

    // SI Preddvor
    public static final Version2017RegionType SI_PREDDVOR = new Version2017RegionType(SCHEME, "SI-095");

    // SI Prevalje
    public static final Version2017RegionType SI_PREVALJE = new Version2017RegionType(SCHEME, "SI-175");

    // SI Ptuj
    public static final Version2017RegionType SI_PTUJ = new Version2017RegionType(SCHEME, "SI-096");

    // SI Puconci
    public static final Version2017RegionType SI_PUCONCI = new Version2017RegionType(SCHEME, "SI-097");

    // SI Race-fram
    public static final Version2017RegionType SI_RACE_FRAM = new Version2017RegionType(SCHEME, "SI-098");

    // SI Radece
    public static final Version2017RegionType SI_RADECE = new Version2017RegionType(SCHEME, "SI-099");

    // SI Radenci
    public static final Version2017RegionType SI_RADENCI = new Version2017RegionType(SCHEME, "SI-100");

    // SI Radlje Ob Dravi
    public static final Version2017RegionType SI_RADLJE_OB_DRAVI = new Version2017RegionType(SCHEME, "SI-101");

    // SI Radovljica
    public static final Version2017RegionType SI_RADOVLJICA = new Version2017RegionType(SCHEME, "SI-102");

    // SI Ravne Na Korotkem
    public static final Version2017RegionType SI_RAVNE_NA_KOROTKEM = new Version2017RegionType(SCHEME, "SI-103");

    // SI Razkrizje
    public static final Version2017RegionType SI_RAZKRIZJE = new Version2017RegionType(SCHEME, "SI-176");

    // SI Ribnica
    public static final Version2017RegionType SI_RIBNICA = new Version2017RegionType(SCHEME, "SI-104");

    // SI Ribnica Na Pohorju
    public static final Version2017RegionType SI_RIBNICA_NA_POHORJU = new Version2017RegionType(SCHEME, "SI-177");

    // SI Rogatec
    public static final Version2017RegionType SI_ROGATEC = new Version2017RegionType(SCHEME, "SI-107");

    // SI Rogatka Slatina
    public static final Version2017RegionType SI_ROGATKA_SLATINA = new Version2017RegionType(SCHEME, "SI-106");

    // SI Rogatovci
    public static final Version2017RegionType SI_ROGATOVCI = new Version2017RegionType(SCHEME, "SI-105");

    // SI Rute
    public static final Version2017RegionType SI_RUTE = new Version2017RegionType(SCHEME, "SI-108");

    // SI Salovci
    public static final Version2017RegionType SI_SALOVCI = new Version2017RegionType(SCHEME, "SI-033");

    // SI Selnica Ob Dravi
    public static final Version2017RegionType SI_SELNICA_OB_DRAVI = new Version2017RegionType(SCHEME, "SI-178");

    // SI Semic
    public static final Version2017RegionType SI_SEMIC = new Version2017RegionType(SCHEME, "SI-109");

    // SI Sempeter-vrtojba
    public static final Version2017RegionType SI_SEMPETER_VRTOJBA = new Version2017RegionType(SCHEME, "SI-183");

    // SI Sencur
    public static final Version2017RegionType SI_SENCUR = new Version2017RegionType(SCHEME, "SI-117");

    // SI Sentilj
    public static final Version2017RegionType SI_SENTILJ = new Version2017RegionType(SCHEME, "SI-118");

    // SI Sentjernej
    public static final Version2017RegionType SI_SENTJERNEJ = new Version2017RegionType(SCHEME, "SI-119");

    // SI Sentjur Pri Celju
    public static final Version2017RegionType SI_SENTJUR_PRI_CELJU = new Version2017RegionType(SCHEME, "SI-120");

    // SI Sevnica
    public static final Version2017RegionType SI_SEVNICA = new Version2017RegionType(SCHEME, "SI-110");

    // SI Sezana
    public static final Version2017RegionType SI_SEZANA = new Version2017RegionType(SCHEME, "SI-111");

    // SI Skocjan
    public static final Version2017RegionType SI_SKOCJAN = new Version2017RegionType(SCHEME, "SI-121");

    // SI Skofja Loka
    public static final Version2017RegionType SI_SKOFJA_LOKA = new Version2017RegionType(SCHEME, "SI-122");

    // SI Skofljica
    public static final Version2017RegionType SI_SKOFLJICA = new Version2017RegionType(SCHEME, "SI-123");

    // SI Slovenj Gradec
    public static final Version2017RegionType SI_SLOVENJ_GRADEC = new Version2017RegionType(SCHEME, "SI-112");

    // SI Slovenska Bistrica
    public static final Version2017RegionType SI_SLOVENSKA_BISTRICA = new Version2017RegionType(SCHEME, "SI-113");

    // SI Slovenske Konjice
    public static final Version2017RegionType SI_SLOVENSKE_KONJICE = new Version2017RegionType(SCHEME, "SI-114");

    // SI Smarje Pri Jeltah
    public static final Version2017RegionType SI_SMARJE_PRI_JELTAH = new Version2017RegionType(SCHEME, "SI-124");

    // SI Smartno Ob Paki
    public static final Version2017RegionType SI_SMARTNO_OB_PAKI = new Version2017RegionType(SCHEME, "SI-125");

    // SI Smartno Pri Litiji
    public static final Version2017RegionType SI_SMARTNO_PRI_LITIJI = new Version2017RegionType(SCHEME, "SI-194");

    // SI Sodrazica
    public static final Version2017RegionType SI_SODRAZICA = new Version2017RegionType(SCHEME, "SI-179");

    // SI Solcava
    public static final Version2017RegionType SI_SOLCAVA = new Version2017RegionType(SCHEME, "SI-180");

    // SI Sottanj
    public static final Version2017RegionType SI_SOTTANJ = new Version2017RegionType(SCHEME, "SI-126");

    // SI Starte
    public static final Version2017RegionType SI_STARTE = new Version2017RegionType(SCHEME, "SI-115");

    // SI Store
    public static final Version2017RegionType SI_STORE = new Version2017RegionType(SCHEME, "SI-127");

    // SI Sveta Ana
    public static final Version2017RegionType SI_SVETA_ANA = new Version2017RegionType(SCHEME, "SI-181");

    // SI Sveti Andraz V Slovenskih Goricah
    public static final Version2017RegionType SI_SVETI_ANDRAZ_V_SLOVENSKIH_GORICAH = new Version2017RegionType(SCHEME, "SI-182");

    // SI Sveti Jurij
    public static final Version2017RegionType SI_SVETI_JURIJ = new Version2017RegionType(SCHEME, "SI-116");

    // SI Tabor
    public static final Version2017RegionType SI_TABOR = new Version2017RegionType(SCHEME, "SI-184");

    // SI Titina
    public static final Version2017RegionType SI_TITINA = new Version2017RegionType(SCHEME, "SI-010");

    // SI Tolmin
    public static final Version2017RegionType SI_TOLMIN = new Version2017RegionType(SCHEME, "SI-128");

    // SI Trbovlje
    public static final Version2017RegionType SI_TRBOVLJE = new Version2017RegionType(SCHEME, "SI-129");

    // SI Trebnje
    public static final Version2017RegionType SI_TREBNJE = new Version2017RegionType(SCHEME, "SI-130");

    // SI Trnovska Vas
    public static final Version2017RegionType SI_TRNOVSKA_VAS = new Version2017RegionType(SCHEME, "SI-185");

    // SI Trzic
    public static final Version2017RegionType SI_TRZIC = new Version2017RegionType(SCHEME, "SI-131");

    // SI Trzin
    public static final Version2017RegionType SI_TRZIN = new Version2017RegionType(SCHEME, "SI-186");

    // SI Turnitce
    public static final Version2017RegionType SI_TURNITCE = new Version2017RegionType(SCHEME, "SI-132");

    // SI Velenje
    public static final Version2017RegionType SI_VELENJE = new Version2017RegionType(SCHEME, "SI-133");

    // SI Velika Polana
    public static final Version2017RegionType SI_VELIKA_POLANA = new Version2017RegionType(SCHEME, "SI-187");

    // SI Velike Latce
    public static final Version2017RegionType SI_VELIKE_LATCE = new Version2017RegionType(SCHEME, "SI-134");

    // SI Verzej
    public static final Version2017RegionType SI_VERZEJ = new Version2017RegionType(SCHEME, "SI-188");

    // SI Videm
    public static final Version2017RegionType SI_VIDEM = new Version2017RegionType(SCHEME, "SI-135");

    // SI Vipava
    public static final Version2017RegionType SI_VIPAVA = new Version2017RegionType(SCHEME, "SI-136");

    // SI Vitanje
    public static final Version2017RegionType SI_VITANJE = new Version2017RegionType(SCHEME, "SI-137");

    // SI Vodice
    public static final Version2017RegionType SI_VODICE = new Version2017RegionType(SCHEME, "SI-138");

    // SI Vojnik
    public static final Version2017RegionType SI_VOJNIK = new Version2017RegionType(SCHEME, "SI-139");

    // SI Vransko
    public static final Version2017RegionType SI_VRANSKO = new Version2017RegionType(SCHEME, "SI-189");

    // SI Vrhnika
    public static final Version2017RegionType SI_VRHNIKA = new Version2017RegionType(SCHEME, "SI-140");

    // SI Vuzenica
    public static final Version2017RegionType SI_VUZENICA = new Version2017RegionType(SCHEME, "SI-141");

    // SI Zagorje Ob Savi
    public static final Version2017RegionType SI_ZAGORJE_OB_SAVI = new Version2017RegionType(SCHEME, "SI-142");

    // SI Zalec
    public static final Version2017RegionType SI_ZALEC = new Version2017RegionType(SCHEME, "SI-190");

    // SI Zavrc
    public static final Version2017RegionType SI_ZAVRC = new Version2017RegionType(SCHEME, "SI-143");

    // SI Zelezniki
    public static final Version2017RegionType SI_ZELEZNIKI = new Version2017RegionType(SCHEME, "SI-146");

    // SI Zetale
    public static final Version2017RegionType SI_ZETALE = new Version2017RegionType(SCHEME, "SI-191");

    // SI Ziri
    public static final Version2017RegionType SI_ZIRI = new Version2017RegionType(SCHEME, "SI-147");

    // SI Zirovnica
    public static final Version2017RegionType SI_ZIROVNICA = new Version2017RegionType(SCHEME, "SI-192");

    // SI Zrece
    public static final Version2017RegionType SI_ZRECE = new Version2017RegionType(SCHEME, "SI-144");

    // SI Zuzemberk
    public static final Version2017RegionType SI_ZUZEMBERK = new Version2017RegionType(SCHEME, "SI-193");

    // SK Banskobystricky Kraj
    public static final Version2017RegionType SK_BANSKOBYSTRICKY_KRAJ = new Version2017RegionType(SCHEME, "SK-BC");

    // SK Bratislavsky Kraj
    public static final Version2017RegionType SK_BRATISLAVSKY_KRAJ = new Version2017RegionType(SCHEME, "SK-BL");

    // SK Kolicky Kraj
    public static final Version2017RegionType SK_KOLICKY_KRAJ = new Version2017RegionType(SCHEME, "SK-KI");

    // SK Lilinsky Kraj
    public static final Version2017RegionType SK_LILINSKY_KRAJ = new Version2017RegionType(SCHEME, "SK-ZI");

    // SK Nitriansky Kraj
    public static final Version2017RegionType SK_NITRIANSKY_KRAJ = new Version2017RegionType(SCHEME, "SK-NI");

    // SK Prelovsky Kraj
    public static final Version2017RegionType SK_PRELOVSKY_KRAJ = new Version2017RegionType(SCHEME, "SK-PV");

    // SK Trenciansky Kraj
    public static final Version2017RegionType SK_TRENCIANSKY_KRAJ = new Version2017RegionType(SCHEME, "SK-TC");

    // SK Trnavsky Kraj
    public static final Version2017RegionType SK_TRNAVSKY_KRAJ = new Version2017RegionType(SCHEME, "SK-TA");

    // SL Eastern, SL
    public static final Version2017RegionType SL_EASTERN = new Version2017RegionType(SCHEME, "SL-E");

    // SL Northern, SL
    public static final Version2017RegionType SL_NORTHERN = new Version2017RegionType(SCHEME, "SL-N");

    // SL Southern, SL
    public static final Version2017RegionType SL_SOUTHERN = new Version2017RegionType(SCHEME, "SL-S");

    // SL Western Area (freetown)
    public static final Version2017RegionType SL_WESTERN_AREA_FREETOWN = new Version2017RegionType(SCHEME, "SL-W");

    // SN Dakar
    public static final Version2017RegionType SN_DAKAR = new Version2017RegionType(SCHEME, "SN-DK");

    // SN Diourbel
    public static final Version2017RegionType SN_DIOURBEL = new Version2017RegionType(SCHEME, "SN-DB");

    // SN Fatick
    public static final Version2017RegionType SN_FATICK = new Version2017RegionType(SCHEME, "SN-FK");

    // SN Kaolack
    public static final Version2017RegionType SN_KAOLACK = new Version2017RegionType(SCHEME, "SN-KL");

    // SN Kolda
    public static final Version2017RegionType SN_KOLDA = new Version2017RegionType(SCHEME, "SN-KD");

    // SN Louga
    public static final Version2017RegionType SN_LOUGA = new Version2017RegionType(SCHEME, "SN-LG");

    // SN Matam
    public static final Version2017RegionType SN_MATAM = new Version2017RegionType(SCHEME, "SN-MT");

    // SN Saint-louis
    public static final Version2017RegionType SN_SAINT_LOUIS = new Version2017RegionType(SCHEME, "SN-SL");

    // SN Tambacounda
    public static final Version2017RegionType SN_TAMBACOUNDA = new Version2017RegionType(SCHEME, "SN-TC");

    // SN Thies
    public static final Version2017RegionType SN_THIES = new Version2017RegionType(SCHEME, "SN-TH");

    // SN Ziguinchor
    public static final Version2017RegionType SN_ZIGUINCHOR = new Version2017RegionType(SCHEME, "SN-ZG");

    // SO Awdal
    public static final Version2017RegionType SO_AWDAL = new Version2017RegionType(SCHEME, "SO-AW");

    // SO Bakool
    public static final Version2017RegionType SO_BAKOOL = new Version2017RegionType(SCHEME, "SO-BK");

    // SO Banaadir
    public static final Version2017RegionType SO_BANAADIR = new Version2017RegionType(SCHEME, "SO-BN");

    // SO Bari
    public static final Version2017RegionType SO_BARI = new Version2017RegionType(SCHEME, "SO-BR");

    // SO Bay
    public static final Version2017RegionType SO_BAY = new Version2017RegionType(SCHEME, "SO-BY");

    // SO Galguduud
    public static final Version2017RegionType SO_GALGUDUUD = new Version2017RegionType(SCHEME, "SO-GA");

    // SO Gedo
    public static final Version2017RegionType SO_GEDO = new Version2017RegionType(SCHEME, "SO-GE");

    // SO Hiiraan
    public static final Version2017RegionType SO_HIIRAAN = new Version2017RegionType(SCHEME, "SO-HI");

    // SO Jubbada Dhexe
    public static final Version2017RegionType SO_JUBBADA_DHEXE = new Version2017RegionType(SCHEME, "SO-JD");

    // SO Jubbada Hoose
    public static final Version2017RegionType SO_JUBBADA_HOOSE = new Version2017RegionType(SCHEME, "SO-JH");

    // SO Mudug
    public static final Version2017RegionType SO_MUDUG = new Version2017RegionType(SCHEME, "SO-MU");

    // SO Nugaal
    public static final Version2017RegionType SO_NUGAAL = new Version2017RegionType(SCHEME, "SO-NU");

    // SO Sanaag
    public static final Version2017RegionType SO_SANAAG = new Version2017RegionType(SCHEME, "SO-SA");

    // SO Shabeellaha Dhexe
    public static final Version2017RegionType SO_SHABEELLAHA_DHEXE = new Version2017RegionType(SCHEME, "SO-SD");

    // SO Shabeellaha Hoose
    public static final Version2017RegionType SO_SHABEELLAHA_HOOSE = new Version2017RegionType(SCHEME, "SO-SH");

    // SO Sool
    public static final Version2017RegionType SO_SOOL = new Version2017RegionType(SCHEME, "SO-SO");

    // SO Togdheer
    public static final Version2017RegionType SO_TOGDHEER = new Version2017RegionType(SCHEME, "SO-TO");

    // SO Woqooyi Galbeed
    public static final Version2017RegionType SO_WOQOOYI_GALBEED = new Version2017RegionType(SCHEME, "SO-WO");

    // SR Brokopondo
    public static final Version2017RegionType SR_BROKOPONDO = new Version2017RegionType(SCHEME, "SR-BR");

    // SR Commewijne
    public static final Version2017RegionType SR_COMMEWIJNE = new Version2017RegionType(SCHEME, "SR-CM");

    // SR Coronie
    public static final Version2017RegionType SR_CORONIE = new Version2017RegionType(SCHEME, "SR-CR");

    // SR Marowijne
    public static final Version2017RegionType SR_MAROWIJNE = new Version2017RegionType(SCHEME, "SR-MA");

    // SR Nickerie
    public static final Version2017RegionType SR_NICKERIE = new Version2017RegionType(SCHEME, "SR-NI");

    // SR Para
    public static final Version2017RegionType SR_PARA = new Version2017RegionType(SCHEME, "SR-PR");

    // SR Paramaribo
    public static final Version2017RegionType SR_PARAMARIBO = new Version2017RegionType(SCHEME, "SR-PM");

    // SR Saramacca
    public static final Version2017RegionType SR_SARAMACCA = new Version2017RegionType(SCHEME, "SR-SA");

    // SR Sipaliwini
    public static final Version2017RegionType SR_SIPALIWINI = new Version2017RegionType(SCHEME, "SR-SI");

    // SR Wanica
    public static final Version2017RegionType SR_WANICA = new Version2017RegionType(SCHEME, "SR-WA");

    // ST Principe
    public static final Version2017RegionType ST_PRINCIPE = new Version2017RegionType(SCHEME, "ST-P");

    // ST Sao Tome
    public static final Version2017RegionType ST_SAO_TOME = new Version2017RegionType(SCHEME, "ST-S");

    // SV Ahuachapan
    public static final Version2017RegionType SV_AHUACHAPAN = new Version2017RegionType(SCHEME, "SV-AH");

    // SV Cabanas
    public static final Version2017RegionType SV_CABANAS = new Version2017RegionType(SCHEME, "SV-CA");

    // SV Chalatenango
    public static final Version2017RegionType SV_CHALATENANGO = new Version2017RegionType(SCHEME, "SV-CH");

    // SV Cuscatlan
    public static final Version2017RegionType SV_CUSCATLAN = new Version2017RegionType(SCHEME, "SV-CU");

    // SV La Libertad
    public static final Version2017RegionType SV_LA_LIBERTAD = new Version2017RegionType(SCHEME, "SV-LI");

    // SV La Paz
    public static final Version2017RegionType SV_LA_PAZ = new Version2017RegionType(SCHEME, "SV-PA");

    // SV La Union, SV
    public static final Version2017RegionType SV_LA_UNION = new Version2017RegionType(SCHEME, "SV-UN");

    // SV Morazan
    public static final Version2017RegionType SV_MORAZAN = new Version2017RegionType(SCHEME, "SV-MO");

    // SV Santa Ana
    public static final Version2017RegionType SV_SANTA_ANA = new Version2017RegionType(SCHEME, "SV-SA");

    // SV San Miguel
    public static final Version2017RegionType SV_SAN_MIGUEL = new Version2017RegionType(SCHEME, "SV-SM");

    // SV San Salvador
    public static final Version2017RegionType SV_SAN_SALVADOR = new Version2017RegionType(SCHEME, "SV-SS");

    // SV San Vicente
    public static final Version2017RegionType SV_SAN_VICENTE = new Version2017RegionType(SCHEME, "SV-SV");

    // SV Sonsonate
    public static final Version2017RegionType SV_SONSONATE = new Version2017RegionType(SCHEME, "SV-SO");

    // SV Usulutan
    public static final Version2017RegionType SV_USULUTAN = new Version2017RegionType(SCHEME, "SV-US");

    // SY Al Hasakah
    public static final Version2017RegionType SY_AL_HASAKAH = new Version2017RegionType(SCHEME, "SY-HA");

    // SY Al Ladhiqiyah
    public static final Version2017RegionType SY_AL_LADHIQIYAH = new Version2017RegionType(SCHEME, "SY-LA");

    // SY Al Qunaytirah
    public static final Version2017RegionType SY_AL_QUNAYTIRAH = new Version2017RegionType(SCHEME, "SY-QU");

    // SY Ar Raqqah
    public static final Version2017RegionType SY_AR_RAQQAH = new Version2017RegionType(SCHEME, "SY-RA");

    // SY As Suwayda'
    public static final Version2017RegionType SY_AS_SUWAYDA = new Version2017RegionType(SCHEME, "SY-SU");

    // SY Dara
    public static final Version2017RegionType SY_DARA = new Version2017RegionType(SCHEME, "SY-DR");

    // SY Dayr Az Zawr
    public static final Version2017RegionType SY_DAYR_AZ_ZAWR = new Version2017RegionType(SCHEME, "SY-DY");

    // SY Dimashq
    public static final Version2017RegionType SY_DIMASHQ = new Version2017RegionType(SCHEME, "SY-DI");

    // SY Halab
    public static final Version2017RegionType SY_HALAB = new Version2017RegionType(SCHEME, "SY-HL");

    // SY Hamah
    public static final Version2017RegionType SY_HAMAH = new Version2017RegionType(SCHEME, "SY-HM");

    // SY Hims
    public static final Version2017RegionType SY_HIMS = new Version2017RegionType(SCHEME, "SY-HI");

    // SY Idlib
    public static final Version2017RegionType SY_IDLIB = new Version2017RegionType(SCHEME, "SY-ID");

    // SY Rif Dimashq
    public static final Version2017RegionType SY_RIF_DIMASHQ = new Version2017RegionType(SCHEME, "SY-RD");

    // SY Tartus
    public static final Version2017RegionType SY_TARTUS = new Version2017RegionType(SCHEME, "SY-TA");

    // SZ Hhohho
    public static final Version2017RegionType SZ_HHOHHO = new Version2017RegionType(SCHEME, "SZ-HH");

    // SZ Lubombo
    public static final Version2017RegionType SZ_LUBOMBO = new Version2017RegionType(SCHEME, "SZ-LU");

    // SZ Manzini
    public static final Version2017RegionType SZ_MANZINI = new Version2017RegionType(SCHEME, "SZ-MA");

    // SZ Shiselweni
    public static final Version2017RegionType SZ_SHISELWENI = new Version2017RegionType(SCHEME, "SZ-SH");

    // TD Batha
    public static final Version2017RegionType TD_BATHA = new Version2017RegionType(SCHEME, "TD-BA");

    // TD Biltine
    public static final Version2017RegionType TD_BILTINE = new Version2017RegionType(SCHEME, "TD-BI");

    // TD Borkou-ennedi-tibesti
    public static final Version2017RegionType TD_BORKOU_ENNEDI_TIBESTI = new Version2017RegionType(SCHEME, "TD-BET");

    // TD Chari-baguirmi
    public static final Version2017RegionType TD_CHARI_BAGUIRMI = new Version2017RegionType(SCHEME, "TD-CB");

    // TD Guera
    public static final Version2017RegionType TD_GUERA = new Version2017RegionType(SCHEME, "TD-GR");

    // TD Kanem
    public static final Version2017RegionType TD_KANEM = new Version2017RegionType(SCHEME, "TD-KA");

    // TD Lac
    public static final Version2017RegionType TD_LAC = new Version2017RegionType(SCHEME, "TD-LC");

    // TD Logone-occidental
    public static final Version2017RegionType TD_LOGONE_OCCIDENTAL = new Version2017RegionType(SCHEME, "TD-LO");

    // TD Logone-oriental
    public static final Version2017RegionType TD_LOGONE_ORIENTAL = new Version2017RegionType(SCHEME, "TD-LR");

    // TD Mayo-kebbi
    public static final Version2017RegionType TD_MAYO_KEBBI = new Version2017RegionType(SCHEME, "TD-MK");

    // TD Moyen-chari
    public static final Version2017RegionType TD_MOYEN_CHARI = new Version2017RegionType(SCHEME, "TD-MC");

    // TD Ouaddai
    public static final Version2017RegionType TD_OUADDAI = new Version2017RegionType(SCHEME, "TD-OD");

    // TD Salamat
    public static final Version2017RegionType TD_SALAMAT = new Version2017RegionType(SCHEME, "TD-SA");

    // TD Tandjile
    public static final Version2017RegionType TD_TANDJILE = new Version2017RegionType(SCHEME, "TD-TA");

    // TG Centre
    public static final Version2017RegionType TG_CENTRE = new Version2017RegionType(SCHEME, "TG-C");

    // TG Kara
    public static final Version2017RegionType TG_KARA = new Version2017RegionType(SCHEME, "TG-K");

    // TG Maritime (region)
    public static final Version2017RegionType TG_MARITIME_REGION = new Version2017RegionType(SCHEME, "TG-M");

    // TG Plateaux
    public static final Version2017RegionType TG_PLATEAUX = new Version2017RegionType(SCHEME, "TG-P");

    // TG Savannes
    public static final Version2017RegionType TG_SAVANNES = new Version2017RegionType(SCHEME, "TG-S");

    // TH Amnat Charoen
    public static final Version2017RegionType TH_AMNAT_CHAROEN = new Version2017RegionType(SCHEME, "TH-37");

    // TH Ang Thong
    public static final Version2017RegionType TH_ANG_THONG = new Version2017RegionType(SCHEME, "TH-15");

    // TH Bangkok
    public static final Version2017RegionType TH_BANGKOK = new Version2017RegionType(SCHEME, "TH-10");

    // TH Buri Ram
    public static final Version2017RegionType TH_BURI_RAM = new Version2017RegionType(SCHEME, "TH-31");

    // TH Chachoengsao
    public static final Version2017RegionType TH_CHACHOENGSAO = new Version2017RegionType(SCHEME, "TH-24");

    // TH Chaiyaphum
    public static final Version2017RegionType TH_CHAIYAPHUM = new Version2017RegionType(SCHEME, "TH-36");

    // TH Chai Nat
    public static final Version2017RegionType TH_CHAI_NAT = new Version2017RegionType(SCHEME, "TH-18");

    // TH Chanthaburi
    public static final Version2017RegionType TH_CHANTHABURI = new Version2017RegionType(SCHEME, "TH-22");

    // TH Chiang Mai
    public static final Version2017RegionType TH_CHIANG_MAI = new Version2017RegionType(SCHEME, "TH-50");

    // TH Chiang Rai
    public static final Version2017RegionType TH_CHIANG_RAI = new Version2017RegionType(SCHEME, "TH-57");

    // TH Chon Buri
    public static final Version2017RegionType TH_CHON_BURI = new Version2017RegionType(SCHEME, "TH-20");

    // TH Chumphon
    public static final Version2017RegionType TH_CHUMPHON = new Version2017RegionType(SCHEME, "TH-86");

    // TH Kalasin
    public static final Version2017RegionType TH_KALASIN = new Version2017RegionType(SCHEME, "TH-46");

    // TH Kamphaeng Phet
    public static final Version2017RegionType TH_KAMPHAENG_PHET = new Version2017RegionType(SCHEME, "TH-62");

    // TH Kanchanaburi
    public static final Version2017RegionType TH_KANCHANABURI = new Version2017RegionType(SCHEME, "TH-71");

    // TH Khon Kaen
    public static final Version2017RegionType TH_KHON_KAEN = new Version2017RegionType(SCHEME, "TH-40");

    // TH Krabi
    public static final Version2017RegionType TH_KRABI = new Version2017RegionType(SCHEME, "TH-81");

    // TH Lampang
    public static final Version2017RegionType TH_LAMPANG = new Version2017RegionType(SCHEME, "TH-52");

    // TH Lamphun
    public static final Version2017RegionType TH_LAMPHUN = new Version2017RegionType(SCHEME, "TH-51");

    // TH Loei
    public static final Version2017RegionType TH_LOEI = new Version2017RegionType(SCHEME, "TH-42");

    // TH Lop Buri
    public static final Version2017RegionType TH_LOP_BURI = new Version2017RegionType(SCHEME, "TH-16");

    // TH Mae Hong Son
    public static final Version2017RegionType TH_MAE_HONG_SON = new Version2017RegionType(SCHEME, "TH-58");

    // TH Maha Sarakham
    public static final Version2017RegionType TH_MAHA_SARAKHAM = new Version2017RegionType(SCHEME, "TH-44");

    // TH Mukdahan
    public static final Version2017RegionType TH_MUKDAHAN = new Version2017RegionType(SCHEME, "TH-49");

    // TH Nakhon Nayok
    public static final Version2017RegionType TH_NAKHON_NAYOK = new Version2017RegionType(SCHEME, "TH-26");

    // TH Nakhon Pathom
    public static final Version2017RegionType TH_NAKHON_PATHOM = new Version2017RegionType(SCHEME, "TH-73");

    // TH Nakhon Phanom
    public static final Version2017RegionType TH_NAKHON_PHANOM = new Version2017RegionType(SCHEME, "TH-48");

    // TH Nakhon Ratchasima
    public static final Version2017RegionType TH_NAKHON_RATCHASIMA = new Version2017RegionType(SCHEME, "TH-30");

    // TH Nakhon Sawan
    public static final Version2017RegionType TH_NAKHON_SAWAN = new Version2017RegionType(SCHEME, "TH-60");

    // TH Nakhon Si Thammarat
    public static final Version2017RegionType TH_NAKHON_SI_THAMMARAT = new Version2017RegionType(SCHEME, "TH-80");

    // TH Nan
    public static final Version2017RegionType TH_NAN = new Version2017RegionType(SCHEME, "TH-55");

    // TH Narathiwat
    public static final Version2017RegionType TH_NARATHIWAT = new Version2017RegionType(SCHEME, "TH-96");

    // TH Nong Bua Lam Phu
    public static final Version2017RegionType TH_NONG_BUA_LAM_PHU = new Version2017RegionType(SCHEME, "TH-39");

    // TH Nong Khai
    public static final Version2017RegionType TH_NONG_KHAI = new Version2017RegionType(SCHEME, "TH-43");

    // TH Nonthaburi
    public static final Version2017RegionType TH_NONTHABURI = new Version2017RegionType(SCHEME, "TH-12");

    // TH Pathum Thani
    public static final Version2017RegionType TH_PATHUM_THANI = new Version2017RegionType(SCHEME, "TH-13");

    // TH Pattani
    public static final Version2017RegionType TH_PATTANI = new Version2017RegionType(SCHEME, "TH-94");

    // TH Phangnga
    public static final Version2017RegionType TH_PHANGNGA = new Version2017RegionType(SCHEME, "TH-82");

    // TH Phatthalung
    public static final Version2017RegionType TH_PHATTHALUNG = new Version2017RegionType(SCHEME, "TH-93");

    // TH Phatthaya
    public static final Version2017RegionType TH_PHATTHAYA = new Version2017RegionType(SCHEME, "TH-S");

    // TH Phayao
    public static final Version2017RegionType TH_PHAYAO = new Version2017RegionType(SCHEME, "TH-56");

    // TH Phetchabun
    public static final Version2017RegionType TH_PHETCHABUN = new Version2017RegionType(SCHEME, "TH-67");

    // TH Phetchaburi
    public static final Version2017RegionType TH_PHETCHABURI = new Version2017RegionType(SCHEME, "TH-76");

    // TH Phichit
    public static final Version2017RegionType TH_PHICHIT = new Version2017RegionType(SCHEME, "TH-66");

    // TH Phitsanulok
    public static final Version2017RegionType TH_PHITSANULOK = new Version2017RegionType(SCHEME, "TH-65");

    // TH Phrae
    public static final Version2017RegionType TH_PHRAE = new Version2017RegionType(SCHEME, "TH-54");

    // TH Phra Nakhon Si Ayutthaya
    public static final Version2017RegionType TH_PHRA_NAKHON_SI_AYUTTHAYA = new Version2017RegionType(SCHEME, "TH-14");

    // TH Phuket
    public static final Version2017RegionType TH_PHUKET = new Version2017RegionType(SCHEME, "TH-83");

    // TH Prachin Buri
    public static final Version2017RegionType TH_PRACHIN_BURI = new Version2017RegionType(SCHEME, "TH-25");

    // TH Prachuap Khiri Khan
    public static final Version2017RegionType TH_PRACHUAP_KHIRI_KHAN = new Version2017RegionType(SCHEME, "TH-77");

    // TH Ranong
    public static final Version2017RegionType TH_RANONG = new Version2017RegionType(SCHEME, "TH-85");

    // TH Ratchaburi
    public static final Version2017RegionType TH_RATCHABURI = new Version2017RegionType(SCHEME, "TH-70");

    // TH Rayong
    public static final Version2017RegionType TH_RAYONG = new Version2017RegionType(SCHEME, "TH-21");

    // TH Roi Et
    public static final Version2017RegionType TH_ROI_ET = new Version2017RegionType(SCHEME, "TH-45");

    // TH Sakon Nakhon
    public static final Version2017RegionType TH_SAKON_NAKHON = new Version2017RegionType(SCHEME, "TH-47");

    // TH Samut Prakan
    public static final Version2017RegionType TH_SAMUT_PRAKAN = new Version2017RegionType(SCHEME, "TH-11");

    // TH Samut Sakhon
    public static final Version2017RegionType TH_SAMUT_SAKHON = new Version2017RegionType(SCHEME, "TH-74");

    // TH Samut Songkhram
    public static final Version2017RegionType TH_SAMUT_SONGKHRAM = new Version2017RegionType(SCHEME, "TH-75");

    // TH Saraburi
    public static final Version2017RegionType TH_SARABURI = new Version2017RegionType(SCHEME, "TH-19");

    // TH Satun
    public static final Version2017RegionType TH_SATUN = new Version2017RegionType(SCHEME, "TH-91");

    // TH Sa Kaeo
    public static final Version2017RegionType TH_SA_KAEO = new Version2017RegionType(SCHEME, "TH-27");

    // TH Sing Buri
    public static final Version2017RegionType TH_SING_BURI = new Version2017RegionType(SCHEME, "TH-17");

    // TH Si Sa Ket
    public static final Version2017RegionType TH_SI_SA_KET = new Version2017RegionType(SCHEME, "TH-33");

    // TH Songkhla
    public static final Version2017RegionType TH_SONGKHLA = new Version2017RegionType(SCHEME, "TH-90");

    // TH Sukhothai
    public static final Version2017RegionType TH_SUKHOTHAI = new Version2017RegionType(SCHEME, "TH-64");

    // TH Suphan Buri
    public static final Version2017RegionType TH_SUPHAN_BURI = new Version2017RegionType(SCHEME, "TH-72");

    // TH Surat Thani
    public static final Version2017RegionType TH_SURAT_THANI = new Version2017RegionType(SCHEME, "TH-84");

    // TH Surin
    public static final Version2017RegionType TH_SURIN = new Version2017RegionType(SCHEME, "TH-32");

    // TH Tak
    public static final Version2017RegionType TH_TAK = new Version2017RegionType(SCHEME, "TH-63");

    // TH Trang
    public static final Version2017RegionType TH_TRANG = new Version2017RegionType(SCHEME, "TH-92");

    // TH Trat
    public static final Version2017RegionType TH_TRAT = new Version2017RegionType(SCHEME, "TH-23");

    // TH Ubon Ratchathani
    public static final Version2017RegionType TH_UBON_RATCHATHANI = new Version2017RegionType(SCHEME, "TH-34");

    // TH Udon Thani
    public static final Version2017RegionType TH_UDON_THANI = new Version2017RegionType(SCHEME, "TH-41");

    // TH Uthai Thani
    public static final Version2017RegionType TH_UTHAI_THANI = new Version2017RegionType(SCHEME, "TH-61");

    // TH Uttaradit
    public static final Version2017RegionType TH_UTTARADIT = new Version2017RegionType(SCHEME, "TH-53");

    // TH Yala
    public static final Version2017RegionType TH_YALA = new Version2017RegionType(SCHEME, "TH-95");

    // TH Yasothon
    public static final Version2017RegionType TH_YASOTHON = new Version2017RegionType(SCHEME, "TH-35");

    // TJ Gorno-badakhshan
    public static final Version2017RegionType TJ_GORNO_BADAKHSHAN = new Version2017RegionType(SCHEME, "TJ-GB");

    // TJ Khatlon
    public static final Version2017RegionType TJ_KHATLON = new Version2017RegionType(SCHEME, "TJ-KT");

    // TJ Sughd
    public static final Version2017RegionType TJ_SUGHD = new Version2017RegionType(SCHEME, "TJ-SU");

    // TL Aileu
    public static final Version2017RegionType TL_AILEU = new Version2017RegionType(SCHEME, "TL-AL");

    // TL Ainaro
    public static final Version2017RegionType TL_AINARO = new Version2017RegionType(SCHEME, "TL-AN");

    // TL Baucau
    public static final Version2017RegionType TL_BAUCAU = new Version2017RegionType(SCHEME, "TL-BA");

    // TL Bobonaro
    public static final Version2017RegionType TL_BOBONARO = new Version2017RegionType(SCHEME, "TL-BO");

    // TL Cova Lima
    public static final Version2017RegionType TL_COVA_LIMA = new Version2017RegionType(SCHEME, "TL-CO");

    // TL Dili
    public static final Version2017RegionType TL_DILI = new Version2017RegionType(SCHEME, "TL-DI");

    // TL Ermera
    public static final Version2017RegionType TL_ERMERA = new Version2017RegionType(SCHEME, "TL-ER");

    // TL Lautem
    public static final Version2017RegionType TL_LAUTEM = new Version2017RegionType(SCHEME, "TL-LA");

    // TL Liquica
    public static final Version2017RegionType TL_LIQUICA = new Version2017RegionType(SCHEME, "TL-LI");

    // TL Manatuto
    public static final Version2017RegionType TL_MANATUTO = new Version2017RegionType(SCHEME, "TL-MT");

    // TL Manufahi
    public static final Version2017RegionType TL_MANUFAHI = new Version2017RegionType(SCHEME, "TL-MF");

    // TL Oecussi
    public static final Version2017RegionType TL_OECUSSI = new Version2017RegionType(SCHEME, "TL-OE");

    // TL Viqueque
    public static final Version2017RegionType TL_VIQUEQUE = new Version2017RegionType(SCHEME, "TL-VI");

    // TM Ahal
    public static final Version2017RegionType TM_AHAL = new Version2017RegionType(SCHEME, "TM-A");

    // TM Balkan
    public static final Version2017RegionType TM_BALKAN = new Version2017RegionType(SCHEME, "TM-B");

    // TM Dasoguz
    public static final Version2017RegionType TM_DASOGUZ = new Version2017RegionType(SCHEME, "TM-D");

    // TM Lebap
    public static final Version2017RegionType TM_LEBAP = new Version2017RegionType(SCHEME, "TM-L");

    // TM Mary
    public static final Version2017RegionType TM_MARY = new Version2017RegionType(SCHEME, "TM-M");

    // TN Beja, TN
    public static final Version2017RegionType TN_BEJA = new Version2017RegionType(SCHEME, "TN-31");

    // TN Ben Arous
    public static final Version2017RegionType TN_BEN_AROUS = new Version2017RegionType(SCHEME, "TN-13");

    // TN Bizerte
    public static final Version2017RegionType TN_BIZERTE = new Version2017RegionType(SCHEME, "TN-23");

    // TN Gabes
    public static final Version2017RegionType TN_GABES = new Version2017RegionType(SCHEME, "TN-81");

    // TN Gafsa
    public static final Version2017RegionType TN_GAFSA = new Version2017RegionType(SCHEME, "TN-71");

    // TN Jendouba
    public static final Version2017RegionType TN_JENDOUBA = new Version2017RegionType(SCHEME, "TN-32");

    // TN Kairouan
    public static final Version2017RegionType TN_KAIROUAN = new Version2017RegionType(SCHEME, "TN-41");

    // TN Kasserine
    public static final Version2017RegionType TN_KASSERINE = new Version2017RegionType(SCHEME, "TN-42");

    // TN Kebili
    public static final Version2017RegionType TN_KEBILI = new Version2017RegionType(SCHEME, "TN-73");

    // TN L'ariana
    public static final Version2017RegionType TN_LARIANA = new Version2017RegionType(SCHEME, "TN-12");

    // TN La Manouba
    public static final Version2017RegionType TN_LA_MANOUBA = new Version2017RegionType(SCHEME, "TN-14");

    // TN Le Kef
    public static final Version2017RegionType TN_LE_KEF = new Version2017RegionType(SCHEME, "TN-33");

    // TN Mahdia
    public static final Version2017RegionType TN_MAHDIA = new Version2017RegionType(SCHEME, "TN-53");

    // TN Medenine
    public static final Version2017RegionType TN_MEDENINE = new Version2017RegionType(SCHEME, "TN-82");

    // TN Monastir
    public static final Version2017RegionType TN_MONASTIR = new Version2017RegionType(SCHEME, "TN-52");

    // TN Nabeul
    public static final Version2017RegionType TN_NABEUL = new Version2017RegionType(SCHEME, "TN-21");

    // TN Sfax
    public static final Version2017RegionType TN_SFAX = new Version2017RegionType(SCHEME, "TN-61");

    // TN Sidi Bouzid
    public static final Version2017RegionType TN_SIDI_BOUZID = new Version2017RegionType(SCHEME, "TN-43");

    // TN Siliana
    public static final Version2017RegionType TN_SILIANA = new Version2017RegionType(SCHEME, "TN-34");

    // TN Sousse
    public static final Version2017RegionType TN_SOUSSE = new Version2017RegionType(SCHEME, "TN-51");

    // TN Tataouine
    public static final Version2017RegionType TN_TATAOUINE = new Version2017RegionType(SCHEME, "TN-83");

    // TN Tozeur
    public static final Version2017RegionType TN_TOZEUR = new Version2017RegionType(SCHEME, "TN-72");

    // TN Tunis
    public static final Version2017RegionType TN_TUNIS = new Version2017RegionType(SCHEME, "TN-11");

    // TN Zaghouan
    public static final Version2017RegionType TN_ZAGHOUAN = new Version2017RegionType(SCHEME, "TN-22");

    // TR Adana
    public static final Version2017RegionType TR_ADANA = new Version2017RegionType(SCHEME, "TR-01");

    // TR Adyaman
    public static final Version2017RegionType TR_ADYAMAN = new Version2017RegionType(SCHEME, "TR-02");

    // TR Afyon
    public static final Version2017RegionType TR_AFYON = new Version2017RegionType(SCHEME, "TR-03");

    // TR Agn
    public static final Version2017RegionType TR_AGN = new Version2017RegionType(SCHEME, "TR-04");

    // TR Aksaray
    public static final Version2017RegionType TR_AKSARAY = new Version2017RegionType(SCHEME, "TR-68");

    // TR Amasya
    public static final Version2017RegionType TR_AMASYA = new Version2017RegionType(SCHEME, "TR-05");

    // TR Ankara
    public static final Version2017RegionType TR_ANKARA = new Version2017RegionType(SCHEME, "TR-06");

    // TR Antalya
    public static final Version2017RegionType TR_ANTALYA = new Version2017RegionType(SCHEME, "TR-07");

    // TR Ardahan
    public static final Version2017RegionType TR_ARDAHAN = new Version2017RegionType(SCHEME, "TR-75");

    // TR Artvin
    public static final Version2017RegionType TR_ARTVIN = new Version2017RegionType(SCHEME, "TR-08");

    // TR Aydn
    public static final Version2017RegionType TR_AYDN = new Version2017RegionType(SCHEME, "TR-09");

    // TR Balkesir
    public static final Version2017RegionType TR_BALKESIR = new Version2017RegionType(SCHEME, "TR-10");

    // TR Bartin
    public static final Version2017RegionType TR_BARTIN = new Version2017RegionType(SCHEME, "TR-74");

    // TR Batman
    public static final Version2017RegionType TR_BATMAN = new Version2017RegionType(SCHEME, "TR-72");

    // TR Bayburt
    public static final Version2017RegionType TR_BAYBURT = new Version2017RegionType(SCHEME, "TR-69");

    // TR Bilecik
    public static final Version2017RegionType TR_BILECIK = new Version2017RegionType(SCHEME, "TR-11");

    // TR Bingol
    public static final Version2017RegionType TR_BINGOL = new Version2017RegionType(SCHEME, "TR-12");

    // TR Bitlis
    public static final Version2017RegionType TR_BITLIS = new Version2017RegionType(SCHEME, "TR-13");

    // TR Bolu
    public static final Version2017RegionType TR_BOLU = new Version2017RegionType(SCHEME, "TR-14");

    // TR Burdur
    public static final Version2017RegionType TR_BURDUR = new Version2017RegionType(SCHEME, "TR-15");

    // TR Bursa
    public static final Version2017RegionType TR_BURSA = new Version2017RegionType(SCHEME, "TR-16");

    // TR Canakkale
    public static final Version2017RegionType TR_CANAKKALE = new Version2017RegionType(SCHEME, "TR-17");

    // TR Cankin
    public static final Version2017RegionType TR_CANKIN = new Version2017RegionType(SCHEME, "TR-18");

    // TR Corum
    public static final Version2017RegionType TR_CORUM = new Version2017RegionType(SCHEME, "TR-19");

    // TR Denizli
    public static final Version2017RegionType TR_DENIZLI = new Version2017RegionType(SCHEME, "TR-20");

    // TR Diyarbakir
    public static final Version2017RegionType TR_DIYARBAKIR = new Version2017RegionType(SCHEME, "TR-21");

    // TR Duzce
    public static final Version2017RegionType TR_DUZCE = new Version2017RegionType(SCHEME, "TR-81");

    // TR Edirne
    public static final Version2017RegionType TR_EDIRNE = new Version2017RegionType(SCHEME, "TR-22");

    // TR Elazig
    public static final Version2017RegionType TR_ELAZIG = new Version2017RegionType(SCHEME, "TR-23");

    // TR Erzincan
    public static final Version2017RegionType TR_ERZINCAN = new Version2017RegionType(SCHEME, "TR-24");

    // TR Erzurum
    public static final Version2017RegionType TR_ERZURUM = new Version2017RegionType(SCHEME, "TR-25");

    // TR Eskisehir
    public static final Version2017RegionType TR_ESKISEHIR = new Version2017RegionType(SCHEME, "TR-26");

    // TR Gaziantep
    public static final Version2017RegionType TR_GAZIANTEP = new Version2017RegionType(SCHEME, "TR-27");

    // TR Giresun
    public static final Version2017RegionType TR_GIRESUN = new Version2017RegionType(SCHEME, "TR-28");

    // TR Gumushane
    public static final Version2017RegionType TR_GUMUSHANE = new Version2017RegionType(SCHEME, "TR-29");

    // TR Hakkari
    public static final Version2017RegionType TR_HAKKARI = new Version2017RegionType(SCHEME, "TR-30");

    // TR Hatay
    public static final Version2017RegionType TR_HATAY = new Version2017RegionType(SCHEME, "TR-31");

    // TR Icel
    public static final Version2017RegionType TR_ICEL = new Version2017RegionType(SCHEME, "TR-33");

    // TR Igdir
    public static final Version2017RegionType TR_IGDIR = new Version2017RegionType(SCHEME, "TR-76");

    // TR Isparta
    public static final Version2017RegionType TR_ISPARTA = new Version2017RegionType(SCHEME, "TR-32");

    // TR Istanbul
    public static final Version2017RegionType TR_ISTANBUL = new Version2017RegionType(SCHEME, "TR-34");

    // TR Izmir
    public static final Version2017RegionType TR_IZMIR = new Version2017RegionType(SCHEME, "TR-35");

    // TR Kahrananmaras
    public static final Version2017RegionType TR_KAHRANANMARAS = new Version2017RegionType(SCHEME, "TR-46");

    // TR Karabuk
    public static final Version2017RegionType TR_KARABUK = new Version2017RegionType(SCHEME, "TR-78");

    // TR Karaman
    public static final Version2017RegionType TR_KARAMAN = new Version2017RegionType(SCHEME, "TR-70");

    // TR Kars
    public static final Version2017RegionType TR_KARS = new Version2017RegionType(SCHEME, "TR-36");

    // TR Kastamonu
    public static final Version2017RegionType TR_KASTAMONU = new Version2017RegionType(SCHEME, "TR-37");

    // TR Kayseri
    public static final Version2017RegionType TR_KAYSERI = new Version2017RegionType(SCHEME, "TR-38");

    // TR Kilis
    public static final Version2017RegionType TR_KILIS = new Version2017RegionType(SCHEME, "TR-79");

    // TR Kinkkale
    public static final Version2017RegionType TR_KINKKALE = new Version2017RegionType(SCHEME, "TR-71");

    // TR Kirklareli
    public static final Version2017RegionType TR_KIRKLARELI = new Version2017RegionType(SCHEME, "TR-39");

    // TR Kirsehir
    public static final Version2017RegionType TR_KIRSEHIR = new Version2017RegionType(SCHEME, "TR-40");

    // TR Kocaeli
    public static final Version2017RegionType TR_KOCAELI = new Version2017RegionType(SCHEME, "TR-41");

    // TR Konya
    public static final Version2017RegionType TR_KONYA = new Version2017RegionType(SCHEME, "TR-42");

    // TR Kutahya
    public static final Version2017RegionType TR_KUTAHYA = new Version2017RegionType(SCHEME, "TR-43");

    // TR Malatya
    public static final Version2017RegionType TR_MALATYA = new Version2017RegionType(SCHEME, "TR-44");

    // TR Manisa
    public static final Version2017RegionType TR_MANISA = new Version2017RegionType(SCHEME, "TR-45");

    // TR Mardin
    public static final Version2017RegionType TR_MARDIN = new Version2017RegionType(SCHEME, "TR-47");

    // TR Mugla
    public static final Version2017RegionType TR_MUGLA = new Version2017RegionType(SCHEME, "TR-48");

    // TR Mus
    public static final Version2017RegionType TR_MUS = new Version2017RegionType(SCHEME, "TR-49");

    // TR Nevsehir
    public static final Version2017RegionType TR_NEVSEHIR = new Version2017RegionType(SCHEME, "TR-50");

    // TR Nigde
    public static final Version2017RegionType TR_NIGDE = new Version2017RegionType(SCHEME, "TR-51");

    // TR Ordu
    public static final Version2017RegionType TR_ORDU = new Version2017RegionType(SCHEME, "TR-52");

    // TR Osmaniye
    public static final Version2017RegionType TR_OSMANIYE = new Version2017RegionType(SCHEME, "TR-80");

    // TR Rize
    public static final Version2017RegionType TR_RIZE = new Version2017RegionType(SCHEME, "TR-53");

    // TR Sakarya
    public static final Version2017RegionType TR_SAKARYA = new Version2017RegionType(SCHEME, "TR-54");

    // TR Samsun
    public static final Version2017RegionType TR_SAMSUN = new Version2017RegionType(SCHEME, "TR-55");

    // TR Sanlurfa
    public static final Version2017RegionType TR_SANLURFA = new Version2017RegionType(SCHEME, "TR-63");

    // TR Siirt
    public static final Version2017RegionType TR_SIIRT = new Version2017RegionType(SCHEME, "TR-56");

    // TR Sinop
    public static final Version2017RegionType TR_SINOP = new Version2017RegionType(SCHEME, "TR-57");

    // TR Sirnak
    public static final Version2017RegionType TR_SIRNAK = new Version2017RegionType(SCHEME, "TR-73");

    // TR Sivas
    public static final Version2017RegionType TR_SIVAS = new Version2017RegionType(SCHEME, "TR-58");

    // TR Tekirdag
    public static final Version2017RegionType TR_TEKIRDAG = new Version2017RegionType(SCHEME, "TR-59");

    // TR Tokat
    public static final Version2017RegionType TR_TOKAT = new Version2017RegionType(SCHEME, "TR-60");

    // TR Trabzon
    public static final Version2017RegionType TR_TRABZON = new Version2017RegionType(SCHEME, "TR-61");

    // TR Tunceli
    public static final Version2017RegionType TR_TUNCELI = new Version2017RegionType(SCHEME, "TR-62");

    // TR Usak
    public static final Version2017RegionType TR_USAK = new Version2017RegionType(SCHEME, "TR-64");

    // TR Van
    public static final Version2017RegionType TR_VAN = new Version2017RegionType(SCHEME, "TR-65");

    // TR Yalova
    public static final Version2017RegionType TR_YALOVA = new Version2017RegionType(SCHEME, "TR-77");

    // TR Yozgat
    public static final Version2017RegionType TR_YOZGAT = new Version2017RegionType(SCHEME, "TR-66");

    // TR Zonguldak
    public static final Version2017RegionType TR_ZONGULDAK = new Version2017RegionType(SCHEME, "TR-67");

    // TT Arima
    public static final Version2017RegionType TT_ARIMA = new Version2017RegionType(SCHEME, "TT-ARI");

    // TT Chaguanas
    public static final Version2017RegionType TT_CHAGUANAS = new Version2017RegionType(SCHEME, "TT-CHA");

    // TT Couva-tabaquite-talparo
    public static final Version2017RegionType TT_COUVA_TABAQUITE_TALPARO = new Version2017RegionType(SCHEME, "TT-CTT");

    // TT Diego Martin
    public static final Version2017RegionType TT_DIEGO_MARTIN = new Version2017RegionType(SCHEME, "TT-DMN");

    // TT Eastern Tobago
    public static final Version2017RegionType TT_EASTERN_TOBAGO = new Version2017RegionType(SCHEME, "TT-ETO");

    // TT Penal-debe
    public static final Version2017RegionType TT_PENAL_DEBE = new Version2017RegionType(SCHEME, "TT-PED");

    // TT Point Fortin
    public static final Version2017RegionType TT_POINT_FORTIN = new Version2017RegionType(SCHEME, "TT-PTF");

    // TT Port Of Spain
    public static final Version2017RegionType TT_PORT_OF_SPAIN = new Version2017RegionType(SCHEME, "TT-POS");

    // TT Princes Town
    public static final Version2017RegionType TT_PRINCES_TOWN = new Version2017RegionType(SCHEME, "TT-PRT");

    // TT Rio Claro-mayaro
    public static final Version2017RegionType TT_RIO_CLARO_MAYARO = new Version2017RegionType(SCHEME, "TT-RCM");

    // TT Sangre Grande
    public static final Version2017RegionType TT_SANGRE_GRANDE = new Version2017RegionType(SCHEME, "TT-SGE");

    // TT San Fernando
    public static final Version2017RegionType TT_SAN_FERNANDO = new Version2017RegionType(SCHEME, "TT-SFO");

    // TT San Juan-laventille
    public static final Version2017RegionType TT_SAN_JUAN_LAVENTILLE = new Version2017RegionType(SCHEME, "TT-SJL");

    // TT Siparia
    public static final Version2017RegionType TT_SIPARIA = new Version2017RegionType(SCHEME, "TT-SIP");

    // TT Tunapuna-piarco
    public static final Version2017RegionType TT_TUNAPUNA_PIARCO = new Version2017RegionType(SCHEME, "TT-TUP");

    // TT Western Tobago
    public static final Version2017RegionType TT_WESTERN_TOBAGO = new Version2017RegionType(SCHEME, "TT-WTO");

    // TW Changhua
    public static final Version2017RegionType TW_CHANGHUA = new Version2017RegionType(SCHEME, "TW-CHA");

    // TW Chiayi
    public static final Version2017RegionType TW_CHIAYI = new Version2017RegionType(SCHEME, "TW-CYI");

    // TW Chiayi, TW
    public static final Version2017RegionType TW_CHIAYI_TW_CYQ = new Version2017RegionType(SCHEME, "TW-CYQ");

    // TW Hsinchu
    public static final Version2017RegionType TW_HSINCHU = new Version2017RegionType(SCHEME, "TW-HSZ");

    // TW Hsinchu, TW
    public static final Version2017RegionType TW_HSINCHU_TW_HSQ = new Version2017RegionType(SCHEME, "TW-HSQ");

    // TW Hualien
    public static final Version2017RegionType TW_HUALIEN = new Version2017RegionType(SCHEME, "TW-HUA");

    // TW Ilan
    public static final Version2017RegionType TW_ILAN = new Version2017RegionType(SCHEME, "TW-ILA");

    // TW Kaohsiung
    public static final Version2017RegionType TW_KAOHSIUNG = new Version2017RegionType(SCHEME, "TW-KHH");

    // TW Kaohsiung, TW
    public static final Version2017RegionType TW_KAOHSIUNG_TW_KHQ = new Version2017RegionType(SCHEME, "TW-KHQ");

    // TW Keelung
    public static final Version2017RegionType TW_KEELUNG = new Version2017RegionType(SCHEME, "TW-KEE");

    // TW Miaoli
    public static final Version2017RegionType TW_MIAOLI = new Version2017RegionType(SCHEME, "TW-MIA");

    // TW Nantou
    public static final Version2017RegionType TW_NANTOU = new Version2017RegionType(SCHEME, "TW-NAN");

    // TW Penghu
    public static final Version2017RegionType TW_PENGHU = new Version2017RegionType(SCHEME, "TW-PEN");

    // TW Pingtung
    public static final Version2017RegionType TW_PINGTUNG = new Version2017RegionType(SCHEME, "TW-PIF");

    // TW Taichung
    public static final Version2017RegionType TW_TAICHUNG = new Version2017RegionType(SCHEME, "TW-TXQ");

    // TW Taichung, TW
    public static final Version2017RegionType TW_TAICHUNG_TW_TXG = new Version2017RegionType(SCHEME, "TW-TXG");

    // TW Tainan
    public static final Version2017RegionType TW_TAINAN = new Version2017RegionType(SCHEME, "TW-TNQ");

    // TW Tainan, TW
    public static final Version2017RegionType TW_TAINAN_TW_TNN = new Version2017RegionType(SCHEME, "TW-TNN");

    // TW Taipei
    public static final Version2017RegionType TW_TAIPEI = new Version2017RegionType(SCHEME, "TW-TPE");

    // TW Taipei, TW
    public static final Version2017RegionType TW_TAIPEI_TW_TPQ = new Version2017RegionType(SCHEME, "TW-TPQ");

    // TW Taitung
    public static final Version2017RegionType TW_TAITUNG = new Version2017RegionType(SCHEME, "TW-TTT");

    // TW Taoyuan
    public static final Version2017RegionType TW_TAOYUAN = new Version2017RegionType(SCHEME, "TW-TAO");

    // TW Yunlin
    public static final Version2017RegionType TW_YUNLIN = new Version2017RegionType(SCHEME, "TW-YUN");

    // TZ Arusha
    public static final Version2017RegionType TZ_ARUSHA = new Version2017RegionType(SCHEME, "TZ-01");

    // TZ Dar Es Salaam
    public static final Version2017RegionType TZ_DAR_ES_SALAAM = new Version2017RegionType(SCHEME, "TZ-02");

    // TZ Dodoma
    public static final Version2017RegionType TZ_DODOMA = new Version2017RegionType(SCHEME, "TZ-03");

    // TZ Iringa
    public static final Version2017RegionType TZ_IRINGA = new Version2017RegionType(SCHEME, "TZ-04");

    // TZ Kagera
    public static final Version2017RegionType TZ_KAGERA = new Version2017RegionType(SCHEME, "TZ-05");

    // TZ Kaskazini Pemba
    public static final Version2017RegionType TZ_KASKAZINI_PEMBA = new Version2017RegionType(SCHEME, "TZ-06");

    // TZ Kaskazini Unguja
    public static final Version2017RegionType TZ_KASKAZINI_UNGUJA = new Version2017RegionType(SCHEME, "TZ-07");

    // TZ Kigoma
    public static final Version2017RegionType TZ_KIGOMA = new Version2017RegionType(SCHEME, "TZ-08");

    // TZ Kilimanjaro
    public static final Version2017RegionType TZ_KILIMANJARO = new Version2017RegionType(SCHEME, "TZ-09");

    // TZ Kusini Pemba
    public static final Version2017RegionType TZ_KUSINI_PEMBA = new Version2017RegionType(SCHEME, "TZ-10");

    // TZ Kusini Unguja
    public static final Version2017RegionType TZ_KUSINI_UNGUJA = new Version2017RegionType(SCHEME, "TZ-11");

    // TZ Lindi
    public static final Version2017RegionType TZ_LINDI = new Version2017RegionType(SCHEME, "TZ-12");

    // TZ Manyara
    public static final Version2017RegionType TZ_MANYARA = new Version2017RegionType(SCHEME, "TZ-26");

    // TZ Mara
    public static final Version2017RegionType TZ_MARA = new Version2017RegionType(SCHEME, "TZ-13");

    // TZ Mbeya
    public static final Version2017RegionType TZ_MBEYA = new Version2017RegionType(SCHEME, "TZ-14");

    // TZ Mjini Magharibi
    public static final Version2017RegionType TZ_MJINI_MAGHARIBI = new Version2017RegionType(SCHEME, "TZ-15");

    // TZ Morogoro
    public static final Version2017RegionType TZ_MOROGORO = new Version2017RegionType(SCHEME, "TZ-16");

    // TZ Mtwara
    public static final Version2017RegionType TZ_MTWARA = new Version2017RegionType(SCHEME, "TZ-17");

    // TZ Mwanza, TZ
    public static final Version2017RegionType TZ_MWANZA = new Version2017RegionType(SCHEME, "TZ-18");

    // TZ Pwani
    public static final Version2017RegionType TZ_PWANI = new Version2017RegionType(SCHEME, "TZ-19");

    // TZ Rukwa
    public static final Version2017RegionType TZ_RUKWA = new Version2017RegionType(SCHEME, "TZ-20");

    // TZ Ruvuma
    public static final Version2017RegionType TZ_RUVUMA = new Version2017RegionType(SCHEME, "TZ-21");

    // TZ Shinyanga
    public static final Version2017RegionType TZ_SHINYANGA = new Version2017RegionType(SCHEME, "TZ-22");

    // TZ Singida
    public static final Version2017RegionType TZ_SINGIDA = new Version2017RegionType(SCHEME, "TZ-23");

    // TZ Tabora
    public static final Version2017RegionType TZ_TABORA = new Version2017RegionType(SCHEME, "TZ-24");

    // TZ Tanga
    public static final Version2017RegionType TZ_TANGA = new Version2017RegionType(SCHEME, "TZ-25");

    // UA Cherkas'ka Oblast'
    public static final Version2017RegionType UA_CHERKASKA_OBLAST = new Version2017RegionType(SCHEME, "UA-71");

    // UA Chernihivs'ka Oblast'
    public static final Version2017RegionType UA_CHERNIHIVSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-74");

    // UA Chernivets'ka Oblast'
    public static final Version2017RegionType UA_CHERNIVETSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-77");

    // UA Dnipropetrovs'ka Oblast'
    public static final Version2017RegionType UA_DNIPROPETROVSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-12");

    // UA Donets'ka Oblast'
    public static final Version2017RegionType UA_DONETSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-14");

    // UA Ivano-frankivs'ka Oblast'
    public static final Version2017RegionType UA_IVANO_FRANKIVSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-26");

    // UA Kharkivs'ka Oblast'
    public static final Version2017RegionType UA_KHARKIVSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-63");

    // UA Khersons'ka Oblast'
    public static final Version2017RegionType UA_KHERSONSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-65");

    // UA Khmel'nyts'ka Oblast'
    public static final Version2017RegionType UA_KHMELNYTSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-68");

    // UA Kirovohrads'ka Oblast'
    public static final Version2017RegionType UA_KIROVOHRADSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-35");

    // UA Kyiv
    public static final Version2017RegionType UA_KYIV = new Version2017RegionType(SCHEME, "UA-30");

    // UA Kyivs'ka Oblast'
    public static final Version2017RegionType UA_KYIVSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-32");

    // UA Luhans'ka Oblast'
    public static final Version2017RegionType UA_LUHANSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-09");

    // UA L'vivs'ka Oblast'
    public static final Version2017RegionType UA_LVIVSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-46");

    // UA Mykolaivs'ka Oblast'
    public static final Version2017RegionType UA_MYKOLAIVSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-48");

    // UA Odes'ka Oblast'
    public static final Version2017RegionType UA_ODESKA_OBLAST = new Version2017RegionType(SCHEME, "UA-51");

    // UA Poltavs'ka Oblast'
    public static final Version2017RegionType UA_POLTAVSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-53");

    // UA Respublika Krym
    public static final Version2017RegionType UA_RESPUBLIKA_KRYM = new Version2017RegionType(SCHEME, "UA-43");

    // UA Rivnens'ka Oblast'
    public static final Version2017RegionType UA_RIVNENSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-56");

    // UA Sevastopol'
    public static final Version2017RegionType UA_SEVASTOPOL = new Version2017RegionType(SCHEME, "UA-40");

    // UA Sums'ka Oblast'
    public static final Version2017RegionType UA_SUMSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-59");

    // UA Ternopil's'ka Oblast'
    public static final Version2017RegionType UA_TERNOPILSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-61");

    // UA Vinnyts'ka Oblast'
    public static final Version2017RegionType UA_VINNYTSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-05");

    // UA Volyns'ka Oblast'
    public static final Version2017RegionType UA_VOLYNSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-07");

    // UA Zakarpats'ka Oblast'
    public static final Version2017RegionType UA_ZAKARPATSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-21");

    // UA Zaporiz'ka Oblast'
    public static final Version2017RegionType UA_ZAPORIZKA_OBLAST = new Version2017RegionType(SCHEME, "UA-23");

    // UA Zhytomyrs'ka Oblast'
    public static final Version2017RegionType UA_ZHYTOMYRSKA_OBLAST = new Version2017RegionType(SCHEME, "UA-18");

    // UG Adjumani
    public static final Version2017RegionType UG_ADJUMANI = new Version2017RegionType(SCHEME, "UG-301");

    // UG Apac
    public static final Version2017RegionType UG_APAC = new Version2017RegionType(SCHEME, "UG-302");

    // UG Arua
    public static final Version2017RegionType UG_ARUA = new Version2017RegionType(SCHEME, "UG-303");

    // UG Bugiri
    public static final Version2017RegionType UG_BUGIRI = new Version2017RegionType(SCHEME, "UG-201");

    // UG Bundibugyo
    public static final Version2017RegionType UG_BUNDIBUGYO = new Version2017RegionType(SCHEME, "UG-401");

    // UG Bushenyi
    public static final Version2017RegionType UG_BUSHENYI = new Version2017RegionType(SCHEME, "UG-402");

    // UG Busia
    public static final Version2017RegionType UG_BUSIA = new Version2017RegionType(SCHEME, "UG-202");

    // UG Gulu
    public static final Version2017RegionType UG_GULU = new Version2017RegionType(SCHEME, "UG-304");

    // UG Hoima
    public static final Version2017RegionType UG_HOIMA = new Version2017RegionType(SCHEME, "UG-403");

    // UG Iganga
    public static final Version2017RegionType UG_IGANGA = new Version2017RegionType(SCHEME, "UG-203");

    // UG Jinja
    public static final Version2017RegionType UG_JINJA = new Version2017RegionType(SCHEME, "UG-204");

    // UG Kabale
    public static final Version2017RegionType UG_KABALE = new Version2017RegionType(SCHEME, "UG-404");

    // UG Kabarole
    public static final Version2017RegionType UG_KABAROLE = new Version2017RegionType(SCHEME, "UG-405");

    // UG Kaberamaido
    public static final Version2017RegionType UG_KABERAMAIDO = new Version2017RegionType(SCHEME, "UG-213");

    // UG Kalangala
    public static final Version2017RegionType UG_KALANGALA = new Version2017RegionType(SCHEME, "UG-101");

    // UG Kampala
    public static final Version2017RegionType UG_KAMPALA = new Version2017RegionType(SCHEME, "UG-102");

    // UG Kamuli
    public static final Version2017RegionType UG_KAMULI = new Version2017RegionType(SCHEME, "UG-205");

    // UG Kamwenge
    public static final Version2017RegionType UG_KAMWENGE = new Version2017RegionType(SCHEME, "UG-413");

    // UG Kanungu
    public static final Version2017RegionType UG_KANUNGU = new Version2017RegionType(SCHEME, "UG-414");

    // UG Kapchorwa
    public static final Version2017RegionType UG_KAPCHORWA = new Version2017RegionType(SCHEME, "UG-206");

    // UG Kasese
    public static final Version2017RegionType UG_KASESE = new Version2017RegionType(SCHEME, "UG-406");

    // UG Katakwi
    public static final Version2017RegionType UG_KATAKWI = new Version2017RegionType(SCHEME, "UG-207");

    // UG Kayunga
    public static final Version2017RegionType UG_KAYUNGA = new Version2017RegionType(SCHEME, "UG-112");

    // UG Kibaale
    public static final Version2017RegionType UG_KIBAALE = new Version2017RegionType(SCHEME, "UG-407");

    // UG Kiboga
    public static final Version2017RegionType UG_KIBOGA = new Version2017RegionType(SCHEME, "UG-103");

    // UG Kisoro
    public static final Version2017RegionType UG_KISORO = new Version2017RegionType(SCHEME, "UG-408");

    // UG Kitgum
    public static final Version2017RegionType UG_KITGUM = new Version2017RegionType(SCHEME, "UG-305");

    // UG Kotido
    public static final Version2017RegionType UG_KOTIDO = new Version2017RegionType(SCHEME, "UG-306");

    // UG Kumi
    public static final Version2017RegionType UG_KUMI = new Version2017RegionType(SCHEME, "UG-208");

    // UG Kyenjojo
    public static final Version2017RegionType UG_KYENJOJO = new Version2017RegionType(SCHEME, "UG-415");

    // UG Lira
    public static final Version2017RegionType UG_LIRA = new Version2017RegionType(SCHEME, "UG-307");

    // UG Luwero
    public static final Version2017RegionType UG_LUWERO = new Version2017RegionType(SCHEME, "UG-104");

    // UG Masaka
    public static final Version2017RegionType UG_MASAKA = new Version2017RegionType(SCHEME, "UG-105");

    // UG Masindi
    public static final Version2017RegionType UG_MASINDI = new Version2017RegionType(SCHEME, "UG-409");

    // UG Mayuge
    public static final Version2017RegionType UG_MAYUGE = new Version2017RegionType(SCHEME, "UG-214");

    // UG Mbale
    public static final Version2017RegionType UG_MBALE = new Version2017RegionType(SCHEME, "UG-209");

    // UG Mbarara
    public static final Version2017RegionType UG_MBARARA = new Version2017RegionType(SCHEME, "UG-410");

    // UG Moroto
    public static final Version2017RegionType UG_MOROTO = new Version2017RegionType(SCHEME, "UG-308");

    // UG Moyo
    public static final Version2017RegionType UG_MOYO = new Version2017RegionType(SCHEME, "UG-309");

    // UG Mpigi
    public static final Version2017RegionType UG_MPIGI = new Version2017RegionType(SCHEME, "UG-106");

    // UG Mubende
    public static final Version2017RegionType UG_MUBENDE = new Version2017RegionType(SCHEME, "UG-107");

    // UG Mukono
    public static final Version2017RegionType UG_MUKONO = new Version2017RegionType(SCHEME, "UG-108");

    // UG Nakapiripirit
    public static final Version2017RegionType UG_NAKAPIRIPIRIT = new Version2017RegionType(SCHEME, "UG-311");

    // UG Nakasongola
    public static final Version2017RegionType UG_NAKASONGOLA = new Version2017RegionType(SCHEME, "UG-109");

    // UG Nebbi
    public static final Version2017RegionType UG_NEBBI = new Version2017RegionType(SCHEME, "UG-310");

    // UG Ntungamo
    public static final Version2017RegionType UG_NTUNGAMO = new Version2017RegionType(SCHEME, "UG-411");

    // UG Pader
    public static final Version2017RegionType UG_PADER = new Version2017RegionType(SCHEME, "UG-312");

    // UG Pallisa
    public static final Version2017RegionType UG_PALLISA = new Version2017RegionType(SCHEME, "UG-210");

    // UG Rakai
    public static final Version2017RegionType UG_RAKAI = new Version2017RegionType(SCHEME, "UG-110");

    // UG Rukungiri
    public static final Version2017RegionType UG_RUKUNGIRI = new Version2017RegionType(SCHEME, "UG-412");

    // UG Sembabule
    public static final Version2017RegionType UG_SEMBABULE = new Version2017RegionType(SCHEME, "UG-111");

    // UG Sironko
    public static final Version2017RegionType UG_SIRONKO = new Version2017RegionType(SCHEME, "UG-215");

    // UG Soroti
    public static final Version2017RegionType UG_SOROTI = new Version2017RegionType(SCHEME, "UG-211");

    // UG Tororo
    public static final Version2017RegionType UG_TORORO = new Version2017RegionType(SCHEME, "UG-212");

    // UG Wakiso
    public static final Version2017RegionType UG_WAKISO = new Version2017RegionType(SCHEME, "UG-113");

    // UG Yumbe
    public static final Version2017RegionType UG_YUMBE = new Version2017RegionType(SCHEME, "UG-313");

    // UM Baker Island
    public static final Version2017RegionType UM_BAKER_ISLAND = new Version2017RegionType(SCHEME, "UM-81");

    // UM Howland Island
    public static final Version2017RegionType UM_HOWLAND_ISLAND = new Version2017RegionType(SCHEME, "UM-84");

    // UM Jarvis Island
    public static final Version2017RegionType UM_JARVIS_ISLAND = new Version2017RegionType(SCHEME, "UM-86");

    // UM Johnston Atoll
    public static final Version2017RegionType UM_JOHNSTON_ATOLL = new Version2017RegionType(SCHEME, "UM-67");

    // UM Kingman Reef
    public static final Version2017RegionType UM_KINGMAN_REEF = new Version2017RegionType(SCHEME, "UM-89");

    // UM Midway Islands
    public static final Version2017RegionType UM_MIDWAY_ISLANDS = new Version2017RegionType(SCHEME, "UM-71");

    // UM Navassa Island
    public static final Version2017RegionType UM_NAVASSA_ISLAND = new Version2017RegionType(SCHEME, "UM-76");

    // UM Palmyra Atoll
    public static final Version2017RegionType UM_PALMYRA_ATOLL = new Version2017RegionType(SCHEME, "UM-95");

    // UM Wake Island
    public static final Version2017RegionType UM_WAKE_ISLAND = new Version2017RegionType(SCHEME, "UM-79");

    // US Alabama
    public static final Version2017RegionType US_ALABAMA = new Version2017RegionType(SCHEME, "US-AL");

    // US Alaska
    public static final Version2017RegionType US_ALASKA = new Version2017RegionType(SCHEME, "US-AK");

    // US American Samoa (see also separate entry under As)
    public static final Version2017RegionType US_AMERICAN_SAMOA = new Version2017RegionType(SCHEME, "US-AS");

    // US Arizona
    public static final Version2017RegionType US_ARIZONA = new Version2017RegionType(SCHEME, "US-AZ");

    // US Arkansas
    public static final Version2017RegionType US_ARKANSAS = new Version2017RegionType(SCHEME, "US-AR");

    // US California
    public static final Version2017RegionType US_CALIFORNIA = new Version2017RegionType(SCHEME, "US-CA");

    // US Colorado
    public static final Version2017RegionType US_COLORADO = new Version2017RegionType(SCHEME, "US-CO");

    // US Connecticut
    public static final Version2017RegionType US_CONNECTICUT = new Version2017RegionType(SCHEME, "US-CT");

    // US Delaware
    public static final Version2017RegionType US_DELAWARE = new Version2017RegionType(SCHEME, "US-DE");

    // US District Of Columbia
    public static final Version2017RegionType US_DISTRICT_OF_COLUMBIA = new Version2017RegionType(SCHEME, "US-DC");

    // US Florida
    public static final Version2017RegionType US_FLORIDA = new Version2017RegionType(SCHEME, "US-FL");

    // US Georgia
    public static final Version2017RegionType US_GEORGIA = new Version2017RegionType(SCHEME, "US-GA");

    // US Guam (see also separate entry under Gu)
    public static final Version2017RegionType US_GUAM = new Version2017RegionType(SCHEME, "US-GU");

    // US Hawaii
    public static final Version2017RegionType US_HAWAII = new Version2017RegionType(SCHEME, "US-HI");

    // US Idaho
    public static final Version2017RegionType US_IDAHO = new Version2017RegionType(SCHEME, "US-ID");

    // US Illinois
    public static final Version2017RegionType US_ILLINOIS = new Version2017RegionType(SCHEME, "US-IL");

    // US Indiana
    public static final Version2017RegionType US_INDIANA = new Version2017RegionType(SCHEME, "US-IN");

    // US Iowa
    public static final Version2017RegionType US_IOWA = new Version2017RegionType(SCHEME, "US-IA");

    // US Kansas
    public static final Version2017RegionType US_KANSAS = new Version2017RegionType(SCHEME, "US-KS");

    // US Kentucky
    public static final Version2017RegionType US_KENTUCKY = new Version2017RegionType(SCHEME, "US-KY");

    // US Louisiana
    public static final Version2017RegionType US_LOUISIANA = new Version2017RegionType(SCHEME, "US-LA");

    // US Maine
    public static final Version2017RegionType US_MAINE = new Version2017RegionType(SCHEME, "US-ME");

    // US Maryland
    public static final Version2017RegionType US_MARYLAND = new Version2017RegionType(SCHEME, "US-MD");

    // US Massachusetts
    public static final Version2017RegionType US_MASSACHUSETTS = new Version2017RegionType(SCHEME, "US-MA");

    // US Michigan
    public static final Version2017RegionType US_MICHIGAN = new Version2017RegionType(SCHEME, "US-MI");

    // US Minnesota
    public static final Version2017RegionType US_MINNESOTA = new Version2017RegionType(SCHEME, "US-MN");

    // US Mississippi
    public static final Version2017RegionType US_MISSISSIPPI = new Version2017RegionType(SCHEME, "US-MS");

    // US Missouri
    public static final Version2017RegionType US_MISSOURI = new Version2017RegionType(SCHEME, "US-MO");

    // US Montana, US
    public static final Version2017RegionType US_MONTANA = new Version2017RegionType(SCHEME, "US-MT");

    // US Nebraska
    public static final Version2017RegionType US_NEBRASKA = new Version2017RegionType(SCHEME, "US-NE");

    // US Nevada
    public static final Version2017RegionType US_NEVADA = new Version2017RegionType(SCHEME, "US-NV");

    // US New Hampshire
    public static final Version2017RegionType US_NEW_HAMPSHIRE = new Version2017RegionType(SCHEME, "US-NH");

    // US New Jersey
    public static final Version2017RegionType US_NEW_JERSEY = new Version2017RegionType(SCHEME, "US-NJ");

    // US New Mexico
    public static final Version2017RegionType US_NEW_MEXICO = new Version2017RegionType(SCHEME, "US-NM");

    // US New York
    public static final Version2017RegionType US_NEW_YORK = new Version2017RegionType(SCHEME, "US-NY");

    // US Northern Mariana Islands (see also separate entry under Mp)
    public static final Version2017RegionType US_NORTHERN_MARIANA_ISLANDS = new Version2017RegionType(SCHEME, "US-MP");

    // US North Carolina
    public static final Version2017RegionType US_NORTH_CAROLINA = new Version2017RegionType(SCHEME, "US-NC");

    // US North Dakota
    public static final Version2017RegionType US_NORTH_DAKOTA = new Version2017RegionType(SCHEME, "US-ND");

    // US Ohio
    public static final Version2017RegionType US_OHIO = new Version2017RegionType(SCHEME, "US-OH");

    // US Oklahoma
    public static final Version2017RegionType US_OKLAHOMA = new Version2017RegionType(SCHEME, "US-OK");

    // US Oregon
    public static final Version2017RegionType US_OREGON = new Version2017RegionType(SCHEME, "US-OR");

    // US Pennsylvania
    public static final Version2017RegionType US_PENNSYLVANIA = new Version2017RegionType(SCHEME, "US-PA");

    // US Puerto Rico (see also separate entry under Pr)
    public static final Version2017RegionType US_PUERTO_RICO = new Version2017RegionType(SCHEME, "US-PR");

    // US Rhode Island
    public static final Version2017RegionType US_RHODE_ISLAND = new Version2017RegionType(SCHEME, "US-RI");

    // US South Carolina
    public static final Version2017RegionType US_SOUTH_CAROLINA = new Version2017RegionType(SCHEME, "US-SC");

    // US South Dakota
    public static final Version2017RegionType US_SOUTH_DAKOTA = new Version2017RegionType(SCHEME, "US-SD");

    // US Tennessee
    public static final Version2017RegionType US_TENNESSEE = new Version2017RegionType(SCHEME, "US-TN");

    // US Texas
    public static final Version2017RegionType US_TEXAS = new Version2017RegionType(SCHEME, "US-TX");

    // US United States Minor Outlying Islands (see also separate entry under Um)
    public static final Version2017RegionType US_UNITED_STATES_MINOR_OUTLYING_ISLANDS = new Version2017RegionType(SCHEME, "US-UM");

    // US Utah
    public static final Version2017RegionType US_UTAH = new Version2017RegionType(SCHEME, "US-UT");

    // US Vermont
    public static final Version2017RegionType US_VERMONT = new Version2017RegionType(SCHEME, "US-VT");

    // US Virginia
    public static final Version2017RegionType US_VIRGINIA = new Version2017RegionType(SCHEME, "US-VA");

    // US Virgin Islands, U.s. (see also separate entry under Vi)
    public static final Version2017RegionType US_VIRGIN_ISLANDS_US = new Version2017RegionType(SCHEME, "US-VI");

    // US Washington
    public static final Version2017RegionType US_WASHINGTON = new Version2017RegionType(SCHEME, "US-WA");

    // US West Virginia
    public static final Version2017RegionType US_WEST_VIRGINIA = new Version2017RegionType(SCHEME, "US-WV");

    // US Wisconsin
    public static final Version2017RegionType US_WISCONSIN = new Version2017RegionType(SCHEME, "US-WI");

    // US Wyoming
    public static final Version2017RegionType US_WYOMING = new Version2017RegionType(SCHEME, "US-WY");

    // UY Artigas
    public static final Version2017RegionType UY_ARTIGAS = new Version2017RegionType(SCHEME, "UY-AR");

    // UY Canelones
    public static final Version2017RegionType UY_CANELONES = new Version2017RegionType(SCHEME, "UY-CA");

    // UY Cerro Largo
    public static final Version2017RegionType UY_CERRO_LARGO = new Version2017RegionType(SCHEME, "UY-CL");

    // UY Colonia
    public static final Version2017RegionType UY_COLONIA = new Version2017RegionType(SCHEME, "UY-CO");

    // UY Durazno
    public static final Version2017RegionType UY_DURAZNO = new Version2017RegionType(SCHEME, "UY-DU");

    // UY Flores
    public static final Version2017RegionType UY_FLORES = new Version2017RegionType(SCHEME, "UY-FS");

    // UY Florida, UY
    public static final Version2017RegionType UY_FLORIDA = new Version2017RegionType(SCHEME, "UY-FD");

    // UY Lavalleja
    public static final Version2017RegionType UY_LAVALLEJA = new Version2017RegionType(SCHEME, "UY-LA");

    // UY Maldonado
    public static final Version2017RegionType UY_MALDONADO = new Version2017RegionType(SCHEME, "UY-MA");

    // UY Montevideo
    public static final Version2017RegionType UY_MONTEVIDEO = new Version2017RegionType(SCHEME, "UY-MO");

    // UY Paysandu
    public static final Version2017RegionType UY_PAYSANDU = new Version2017RegionType(SCHEME, "UY-PA");

    // UY Rio Negro
    public static final Version2017RegionType UY_RIO_NEGRO = new Version2017RegionType(SCHEME, "UY-RN");

    // UY Rivera
    public static final Version2017RegionType UY_RIVERA = new Version2017RegionType(SCHEME, "UY-RV");

    // UY Rocha
    public static final Version2017RegionType UY_ROCHA = new Version2017RegionType(SCHEME, "UY-RO");

    // UY Salto
    public static final Version2017RegionType UY_SALTO = new Version2017RegionType(SCHEME, "UY-SA");

    // UY San Jose
    public static final Version2017RegionType UY_SAN_JOSE = new Version2017RegionType(SCHEME, "UY-SJ");

    // UY Soriano
    public static final Version2017RegionType UY_SORIANO = new Version2017RegionType(SCHEME, "UY-SO");

    // UY Tacuarembo
    public static final Version2017RegionType UY_TACUAREMBO = new Version2017RegionType(SCHEME, "UY-TA");

    // UY Treinta Y Tres
    public static final Version2017RegionType UY_TREINTA_Y_TRES = new Version2017RegionType(SCHEME, "UY-TT");

    // UZ Andijon
    public static final Version2017RegionType UZ_ANDIJON = new Version2017RegionType(SCHEME, "UZ-AN");

    // UZ Buxoro
    public static final Version2017RegionType UZ_BUXORO = new Version2017RegionType(SCHEME, "UZ-BU");

    // UZ Fargona
    public static final Version2017RegionType UZ_FARGONA = new Version2017RegionType(SCHEME, "UZ-FA");

    // UZ Jizzax
    public static final Version2017RegionType UZ_JIZZAX = new Version2017RegionType(SCHEME, "UZ-JI");

    // UZ Namangan
    public static final Version2017RegionType UZ_NAMANGAN = new Version2017RegionType(SCHEME, "UZ-NG");

    // UZ Navoiy
    public static final Version2017RegionType UZ_NAVOIY = new Version2017RegionType(SCHEME, "UZ-NW");

    // UZ Qashqadaryo
    public static final Version2017RegionType UZ_QASHQADARYO = new Version2017RegionType(SCHEME, "UZ-QA");

    // UZ Qoraqalpogiston Respublikasi
    public static final Version2017RegionType UZ_QORAQALPOGISTON_RESPUBLIKASI = new Version2017RegionType(SCHEME, "UZ-QR");

    // UZ Samarqand
    public static final Version2017RegionType UZ_SAMARQAND = new Version2017RegionType(SCHEME, "UZ-SA");

    // UZ Sirdaryo
    public static final Version2017RegionType UZ_SIRDARYO = new Version2017RegionType(SCHEME, "UZ-SI");

    // UZ Surxondaryo
    public static final Version2017RegionType UZ_SURXONDARYO = new Version2017RegionType(SCHEME, "UZ-SU");

    // UZ Toshkent
    public static final Version2017RegionType UZ_TOSHKENT = new Version2017RegionType(SCHEME, "UZ-TO");

    // UZ Toshkent, UZ
    public static final Version2017RegionType UZ_TOSHKENT_UZ_TK = new Version2017RegionType(SCHEME, "UZ-TK");

    // UZ Xorazm
    public static final Version2017RegionType UZ_XORAZM = new Version2017RegionType(SCHEME, "UZ-XO");

    // VE Amazonas, VE
    public static final Version2017RegionType VE_AMAZONAS = new Version2017RegionType(SCHEME, "VE-Z");

    // VE Anzoategui
    public static final Version2017RegionType VE_ANZOATEGUI = new Version2017RegionType(SCHEME, "VE-B");

    // VE Apure
    public static final Version2017RegionType VE_APURE = new Version2017RegionType(SCHEME, "VE-C");

    // VE Aragua
    public static final Version2017RegionType VE_ARAGUA = new Version2017RegionType(SCHEME, "VE-D");

    // VE Barinas
    public static final Version2017RegionType VE_BARINAS = new Version2017RegionType(SCHEME, "VE-E");

    // VE Bolivar
    public static final Version2017RegionType VE_BOLIVAR = new Version2017RegionType(SCHEME, "VE-F");

    // VE Carabobo
    public static final Version2017RegionType VE_CARABOBO = new Version2017RegionType(SCHEME, "VE-G");

    // VE Cojedes
    public static final Version2017RegionType VE_COJEDES = new Version2017RegionType(SCHEME, "VE-H");

    // VE Delta Amacuro
    public static final Version2017RegionType VE_DELTA_AMACURO = new Version2017RegionType(SCHEME, "VE-Y");

    // VE Dependencias Federales
    public static final Version2017RegionType VE_DEPENDENCIAS_FEDERALES = new Version2017RegionType(SCHEME, "VE-W");

    // VE Distrito Federal
    public static final Version2017RegionType VE_DISTRITO_FEDERAL = new Version2017RegionType(SCHEME, "VE-A");

    // VE Falcon
    public static final Version2017RegionType VE_FALCON = new Version2017RegionType(SCHEME, "VE-I");

    // VE Guarico
    public static final Version2017RegionType VE_GUARICO = new Version2017RegionType(SCHEME, "VE-J");

    // VE Lara
    public static final Version2017RegionType VE_LARA = new Version2017RegionType(SCHEME, "VE-K");

    // VE Merida
    public static final Version2017RegionType VE_MERIDA = new Version2017RegionType(SCHEME, "VE-L");

    // VE Miranda
    public static final Version2017RegionType VE_MIRANDA = new Version2017RegionType(SCHEME, "VE-M");

    // VE Monagas
    public static final Version2017RegionType VE_MONAGAS = new Version2017RegionType(SCHEME, "VE-N");

    // VE Nueva Esparta
    public static final Version2017RegionType VE_NUEVA_ESPARTA = new Version2017RegionType(SCHEME, "VE-O");

    // VE Portuguesa
    public static final Version2017RegionType VE_PORTUGUESA = new Version2017RegionType(SCHEME, "VE-P");

    // VE Sucre
    public static final Version2017RegionType VE_SUCRE = new Version2017RegionType(SCHEME, "VE-R");

    // VE Tachira
    public static final Version2017RegionType VE_TACHIRA = new Version2017RegionType(SCHEME, "VE-S");

    // VE Trujillo
    public static final Version2017RegionType VE_TRUJILLO = new Version2017RegionType(SCHEME, "VE-T");

    // VE Vargas
    public static final Version2017RegionType VE_VARGAS = new Version2017RegionType(SCHEME, "VE-X");

    // VE Yaracuy
    public static final Version2017RegionType VE_YARACUY = new Version2017RegionType(SCHEME, "VE-U");

    // VE Zulia
    public static final Version2017RegionType VE_ZULIA = new Version2017RegionType(SCHEME, "VE-V");

    // VN An Giang
    public static final Version2017RegionType VN_AN_GIANG = new Version2017RegionType(SCHEME, "VN-44");

    // VN Bac Can
    public static final Version2017RegionType VN_BAC_CAN = new Version2017RegionType(SCHEME, "VN-53");

    // VN Bac Giang
    public static final Version2017RegionType VN_BAC_GIANG = new Version2017RegionType(SCHEME, "VN-54");

    // VN Bac Lieu
    public static final Version2017RegionType VN_BAC_LIEU = new Version2017RegionType(SCHEME, "VN-55");

    // VN Bac Ninh
    public static final Version2017RegionType VN_BAC_NINH = new Version2017RegionType(SCHEME, "VN-56");

    // VN Ba Ria - Vung Tau
    public static final Version2017RegionType VN_BA_RIA_VUNG_TAU = new Version2017RegionType(SCHEME, "VN-43");

    // VN Ben Tre
    public static final Version2017RegionType VN_BEN_TRE = new Version2017RegionType(SCHEME, "VN-50");

    // VN Binh Dinh
    public static final Version2017RegionType VN_BINH_DINH = new Version2017RegionType(SCHEME, "VN-31");

    // VN Binh Duong
    public static final Version2017RegionType VN_BINH_DUONG = new Version2017RegionType(SCHEME, "VN-57");

    // VN Binh Phuoc
    public static final Version2017RegionType VN_BINH_PHUOC = new Version2017RegionType(SCHEME, "VN-58");

    // VN Binh Thuan
    public static final Version2017RegionType VN_BINH_THUAN = new Version2017RegionType(SCHEME, "VN-40");

    // VN Can Tho
    public static final Version2017RegionType VN_CAN_THO = new Version2017RegionType(SCHEME, "VN-48");

    // VN Cao Bang
    public static final Version2017RegionType VN_CAO_BANG = new Version2017RegionType(SCHEME, "VN-04");

    // VN Ca Mau
    public static final Version2017RegionType VN_CA_MAU = new Version2017RegionType(SCHEME, "VN-59");

    // VN Dac Lac
    public static final Version2017RegionType VN_DAC_LAC = new Version2017RegionType(SCHEME, "VN-33");

    // VN Da Nang, Thanh Pho
    public static final Version2017RegionType VN_DA_NANG_THANH_PHO = new Version2017RegionType(SCHEME, "VN-60");

    // VN Dong Nai
    public static final Version2017RegionType VN_DONG_NAI = new Version2017RegionType(SCHEME, "VN-39");

    // VN Dong Thap
    public static final Version2017RegionType VN_DONG_THAP = new Version2017RegionType(SCHEME, "VN-45");

    // VN Gia Lai
    public static final Version2017RegionType VN_GIA_LAI = new Version2017RegionType(SCHEME, "VN-30");

    // VN Hai Duong
    public static final Version2017RegionType VN_HAI_DUONG = new Version2017RegionType(SCHEME, "VN-61");

    // VN Hai Phong, Thanh Pho
    public static final Version2017RegionType VN_HAI_PHONG_THANH_PHO = new Version2017RegionType(SCHEME, "VN-62");

    // VN Ha Giang
    public static final Version2017RegionType VN_HA_GIANG = new Version2017RegionType(SCHEME, "VN-03");

    // VN Ha Nam
    public static final Version2017RegionType VN_HA_NAM = new Version2017RegionType(SCHEME, "VN-63");

    // VN Ha Noi, Thu Do
    public static final Version2017RegionType VN_HA_NOI_THU_DO = new Version2017RegionType(SCHEME, "VN-64");

    // VN Ha Tay
    public static final Version2017RegionType VN_HA_TAY = new Version2017RegionType(SCHEME, "VN-15");

    // VN Ha Tinh
    public static final Version2017RegionType VN_HA_TINH = new Version2017RegionType(SCHEME, "VN-23");

    // VN Hoa Binh
    public static final Version2017RegionType VN_HOA_BINH = new Version2017RegionType(SCHEME, "VN-14");

    // VN Hung Yen
    public static final Version2017RegionType VN_HUNG_YEN = new Version2017RegionType(SCHEME, "VN-66");

    // VN Khanh Hoa
    public static final Version2017RegionType VN_KHANH_HOA = new Version2017RegionType(SCHEME, "VN-34");

    // VN Kien Giang
    public static final Version2017RegionType VN_KIEN_GIANG = new Version2017RegionType(SCHEME, "VN-47");

    // VN Kon Tum
    public static final Version2017RegionType VN_KON_TUM = new Version2017RegionType(SCHEME, "VN-28");

    // VN Lai Chau
    public static final Version2017RegionType VN_LAI_CHAU = new Version2017RegionType(SCHEME, "VN-01");

    // VN Lam Dong
    public static final Version2017RegionType VN_LAM_DONG = new Version2017RegionType(SCHEME, "VN-35");

    // VN Lang Son
    public static final Version2017RegionType VN_LANG_SON = new Version2017RegionType(SCHEME, "VN-09");

    // VN Lao Cai
    public static final Version2017RegionType VN_LAO_CAI = new Version2017RegionType(SCHEME, "VN-02");

    // VN Long An
    public static final Version2017RegionType VN_LONG_AN = new Version2017RegionType(SCHEME, "VN-41");

    // VN Nam Dinh
    public static final Version2017RegionType VN_NAM_DINH = new Version2017RegionType(SCHEME, "VN-67");

    // VN Nghe An
    public static final Version2017RegionType VN_NGHE_AN = new Version2017RegionType(SCHEME, "VN-22");

    // VN Ninh Binh
    public static final Version2017RegionType VN_NINH_BINH = new Version2017RegionType(SCHEME, "VN-18");

    // VN Ninh Thuan
    public static final Version2017RegionType VN_NINH_THUAN = new Version2017RegionType(SCHEME, "VN-36");

    // VN Phu Tho
    public static final Version2017RegionType VN_PHU_THO = new Version2017RegionType(SCHEME, "VN-68");

    // VN Phu Yen
    public static final Version2017RegionType VN_PHU_YEN = new Version2017RegionType(SCHEME, "VN-32");

    // VN Quang Binh
    public static final Version2017RegionType VN_QUANG_BINH = new Version2017RegionType(SCHEME, "VN-24");

    // VN Quang Nam
    public static final Version2017RegionType VN_QUANG_NAM = new Version2017RegionType(SCHEME, "VN-27");

    // VN Quang Ngai
    public static final Version2017RegionType VN_QUANG_NGAI = new Version2017RegionType(SCHEME, "VN-29");

    // VN Quang Ninh
    public static final Version2017RegionType VN_QUANG_NINH = new Version2017RegionType(SCHEME, "VN-13");

    // VN Quang Tri
    public static final Version2017RegionType VN_QUANG_TRI = new Version2017RegionType(SCHEME, "VN-25");

    // VN Sai Gon
    public static final Version2017RegionType VN_SAI_GON = new Version2017RegionType(SCHEME, "VN-65");

    // VN Soc Trang
    public static final Version2017RegionType VN_SOC_TRANG = new Version2017RegionType(SCHEME, "VN-52");

    // VN Son La
    public static final Version2017RegionType VN_SON_LA = new Version2017RegionType(SCHEME, "VN-05");

    // VN Tay Ninh
    public static final Version2017RegionType VN_TAY_NINH = new Version2017RegionType(SCHEME, "VN-37");

    // VN Thai Binh
    public static final Version2017RegionType VN_THAI_BINH = new Version2017RegionType(SCHEME, "VN-20");

    // VN Thai Nguyen
    public static final Version2017RegionType VN_THAI_NGUYEN = new Version2017RegionType(SCHEME, "VN-69");

    // VN Thanh Hoa
    public static final Version2017RegionType VN_THANH_HOA = new Version2017RegionType(SCHEME, "VN-21");

    // VN Thua Thien-hue
    public static final Version2017RegionType VN_THUA_THIEN_HUE = new Version2017RegionType(SCHEME, "VN-26");

    // VN Tien Giang
    public static final Version2017RegionType VN_TIEN_GIANG = new Version2017RegionType(SCHEME, "VN-46");

    // VN Tra Vinh
    public static final Version2017RegionType VN_TRA_VINH = new Version2017RegionType(SCHEME, "VN-51");

    // VN Tuyen Quang
    public static final Version2017RegionType VN_TUYEN_QUANG = new Version2017RegionType(SCHEME, "VN-07");

    // VN Vinh Long
    public static final Version2017RegionType VN_VINH_LONG = new Version2017RegionType(SCHEME, "VN-49");

    // VN Vinh Phuc
    public static final Version2017RegionType VN_VINH_PHUC = new Version2017RegionType(SCHEME, "VN-70");

    // VN Yen Bai
    public static final Version2017RegionType VN_YEN_BAI = new Version2017RegionType(SCHEME, "VN-06");

    // VU Malampa
    public static final Version2017RegionType VU_MALAMPA = new Version2017RegionType(SCHEME, "VU-MAP");

    // VU Penama
    public static final Version2017RegionType VU_PENAMA = new Version2017RegionType(SCHEME, "VU-PAM");

    // VU Sanma
    public static final Version2017RegionType VU_SANMA = new Version2017RegionType(SCHEME, "VU-SAM");

    // VU Shefa
    public static final Version2017RegionType VU_SHEFA = new Version2017RegionType(SCHEME, "VU-SEE");

    // VU Tafea
    public static final Version2017RegionType VU_TAFEA = new Version2017RegionType(SCHEME, "VU-TAE");

    // VU Torba
    public static final Version2017RegionType VU_TORBA = new Version2017RegionType(SCHEME, "VU-TOB");

    // WS A'ana
    public static final Version2017RegionType WS_AANA = new Version2017RegionType(SCHEME, "WS-AA");

    // WS Aiga-i-le-tai
    public static final Version2017RegionType WS_AIGA_I_LE_TAI = new Version2017RegionType(SCHEME, "WS-AL");

    // WS Atua
    public static final Version2017RegionType WS_ATUA = new Version2017RegionType(SCHEME, "WS-AT");

    // WS Fa'asaleleaga
    public static final Version2017RegionType WS_FAASALELEAGA = new Version2017RegionType(SCHEME, "WS-FA");

    // WS Gaga'emauga
    public static final Version2017RegionType WS_GAGAEMAUGA = new Version2017RegionType(SCHEME, "WS-GE");

    // WS Gagaifomauga
    public static final Version2017RegionType WS_GAGAIFOMAUGA = new Version2017RegionType(SCHEME, "WS-GI");

    // WS Palauli
    public static final Version2017RegionType WS_PALAULI = new Version2017RegionType(SCHEME, "WS-PA");

    // WS Satupa'itea
    public static final Version2017RegionType WS_SATUPAITEA = new Version2017RegionType(SCHEME, "WS-SA");

    // WS Tuamasaga
    public static final Version2017RegionType WS_TUAMASAGA = new Version2017RegionType(SCHEME, "WS-TU");

    // WS Va'a-o-fonoti
    public static final Version2017RegionType WS_VAA_O_FONOTI = new Version2017RegionType(SCHEME, "WS-VF");

    // WS Vaisigano
    public static final Version2017RegionType WS_VAISIGANO = new Version2017RegionType(SCHEME, "WS-VS");

    // YE Abyan
    public static final Version2017RegionType YE_ABYAN = new Version2017RegionType(SCHEME, "YE-AB");

    // YE 'adan
    public static final Version2017RegionType YE_ADAN = new Version2017RegionType(SCHEME, "YE-AD");

    // YE Ad Dali
    public static final Version2017RegionType YE_AD_DALI = new Version2017RegionType(SCHEME, "YE-DA");

    // YE Al Bayda'
    public static final Version2017RegionType YE_AL_BAYDA = new Version2017RegionType(SCHEME, "YE-BA");

    // YE Al Hudaydah
    public static final Version2017RegionType YE_AL_HUDAYDAH = new Version2017RegionType(SCHEME, "YE-HU");

    // YE Al Jawf, YE
    public static final Version2017RegionType YE_AL_JAWF = new Version2017RegionType(SCHEME, "YE-JA");

    // YE Al Mahrah
    public static final Version2017RegionType YE_AL_MAHRAH = new Version2017RegionType(SCHEME, "YE-MR");

    // YE Al Mahwit
    public static final Version2017RegionType YE_AL_MAHWIT = new Version2017RegionType(SCHEME, "YE-MW");

    // YE 'amran
    public static final Version2017RegionType YE_AMRAN = new Version2017RegionType(SCHEME, "YE-AM");

    // YE Dhamar
    public static final Version2017RegionType YE_DHAMAR = new Version2017RegionType(SCHEME, "YE-DH");

    // YE Hadramawt
    public static final Version2017RegionType YE_HADRAMAWT = new Version2017RegionType(SCHEME, "YE-HD");

    // YE Hajjah
    public static final Version2017RegionType YE_HAJJAH = new Version2017RegionType(SCHEME, "YE-HJ");

    // YE Ibb
    public static final Version2017RegionType YE_IBB = new Version2017RegionType(SCHEME, "YE-IB");

    // YE Lahij
    public static final Version2017RegionType YE_LAHIJ = new Version2017RegionType(SCHEME, "YE-LA");

    // YE Ma'rib
    public static final Version2017RegionType YE_MARIB = new Version2017RegionType(SCHEME, "YE-MA");

    // YE Sadah
    public static final Version2017RegionType YE_SADAH = new Version2017RegionType(SCHEME, "YE-SD");

    // YE Sana
    public static final Version2017RegionType YE_SANA = new Version2017RegionType(SCHEME, "YE-SN");

    // YE Shabwah
    public static final Version2017RegionType YE_SHABWAH = new Version2017RegionType(SCHEME, "YE-SH");

    // YE Taizz
    public static final Version2017RegionType YE_TAIZZ = new Version2017RegionType(SCHEME, "YE-TA");

    // ZA Eastern Cape
    public static final Version2017RegionType ZA_EASTERN_CAPE = new Version2017RegionType(SCHEME, "ZA-EC");

    // ZA Free State
    public static final Version2017RegionType ZA_FREE_STATE = new Version2017RegionType(SCHEME, "ZA-FS");

    // ZA Gauteng
    public static final Version2017RegionType ZA_GAUTENG = new Version2017RegionType(SCHEME, "ZA-GT");

    // ZA Kwazulu-natal
    public static final Version2017RegionType ZA_KWAZULU_NATAL = new Version2017RegionType(SCHEME, "ZA-NL");

    // ZA Limpopo
    public static final Version2017RegionType ZA_LIMPOPO = new Version2017RegionType(SCHEME, "ZA-LP");

    // ZA Mpumalanga
    public static final Version2017RegionType ZA_MPUMALANGA = new Version2017RegionType(SCHEME, "ZA-MP");

    // ZA Northern Cape
    public static final Version2017RegionType ZA_NORTHERN_CAPE = new Version2017RegionType(SCHEME, "ZA-NC");

    // ZA North-west, ZA
    public static final Version2017RegionType ZA_NORTH_WEST = new Version2017RegionType(SCHEME, "ZA-NW");

    // ZA Western Cape
    public static final Version2017RegionType ZA_WESTERN_CAPE = new Version2017RegionType(SCHEME, "ZA-WC");

    // ZM Central, ZM
    public static final Version2017RegionType ZM_CENTRAL = new Version2017RegionType(SCHEME, "ZM-02");

    // ZM Copperbelt
    public static final Version2017RegionType ZM_COPPERBELT = new Version2017RegionType(SCHEME, "ZM-08");

    // ZM Eastern
    public static final Version2017RegionType ZM_EASTERN = new Version2017RegionType(SCHEME, "ZM-03");

    // ZM Luapula
    public static final Version2017RegionType ZM_LUAPULA = new Version2017RegionType(SCHEME, "ZM-04");

    // ZM Lusaka
    public static final Version2017RegionType ZM_LUSAKA = new Version2017RegionType(SCHEME, "ZM-09");

    // ZM Northern, ZM
    public static final Version2017RegionType ZM_NORTHERN = new Version2017RegionType(SCHEME, "ZM-05");

    // ZM North-western
    public static final Version2017RegionType ZM_NORTH_WESTERN = new Version2017RegionType(SCHEME, "ZM-06");

    // ZM Southern, ZM
    public static final Version2017RegionType ZM_SOUTHERN = new Version2017RegionType(SCHEME, "ZM-07");

    // ZM Western, ZM
    public static final Version2017RegionType ZM_WESTERN = new Version2017RegionType(SCHEME, "ZM-01");

    // ZW Bulawayo
    public static final Version2017RegionType ZW_BULAWAYO = new Version2017RegionType(SCHEME, "ZW-BU");

    // ZW Harare
    public static final Version2017RegionType ZW_HARARE = new Version2017RegionType(SCHEME, "ZW-HA");

    // ZW Manicaland
    public static final Version2017RegionType ZW_MANICALAND = new Version2017RegionType(SCHEME, "ZW-MA");

    // ZW Mashonaland Central
    public static final Version2017RegionType ZW_MASHONALAND_CENTRAL = new Version2017RegionType(SCHEME, "ZW-MC");

    // ZW Mashonaland East
    public static final Version2017RegionType ZW_MASHONALAND_EAST = new Version2017RegionType(SCHEME, "ZW-ME");

    // ZW Mashonaland West
    public static final Version2017RegionType ZW_MASHONALAND_WEST = new Version2017RegionType(SCHEME, "ZW-MW");

    // ZW Masvingo
    public static final Version2017RegionType ZW_MASVINGO = new Version2017RegionType(SCHEME, "ZW-MV");

    // ZW Matabeleland North
    public static final Version2017RegionType ZW_MATABELELAND_NORTH = new Version2017RegionType(SCHEME, "ZW-MN");

    // ZW Matabeleland South
    public static final Version2017RegionType ZW_MATABELELAND_SOUTH = new Version2017RegionType(SCHEME, "ZW-MS");

    // ZW Midlands
    public static final Version2017RegionType ZW_MIDLANDS = new Version2017RegionType(SCHEME, "ZW-MI");

    /**
     * Load all instances.
     */
    public static void loadAll() {
        LOG.debug("Loading Version2017RegionType.");
        // Do nothing - merely invoking this method forces the creation of the instances defined above.
    }

    /**
     * Construct an instance.
     * @param scheme the Scheme URI
     * @param value the value
     */
    public Version2017RegionType(final String scheme, final String value) {
        super(scheme, value);
    }
}
