package OMS;

/* 
 * File: SAWFilterInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class SAWFilterInfo extends FilterInfo{
    private double frequencyCenter;
    private double insertionLoss;
    private Application application;
            
    private enum Application{
        Automotive,
        BaseStation,
        Bluetooth,
        CDMA,
        CableConverters,
        Cellphone,
        Cellular,
        DAB,
        DCS,
        GPS,
        HDTV,
        IF,
        ISM,
        LTE,
        Medical,
        LabUse,
        WLAN,
        TETRA,
        WirelessMethods,
        Unknown
    }
}
