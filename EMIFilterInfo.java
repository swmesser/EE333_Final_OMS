package OMS;

/* 
 * File: EMIFilterInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class EMIFilterInfo extends FilterInfo{
    private int channelCount;
    private int channelResistance;
    private int current;
    private int attenuationValue;
    private double frequencyCenter;
    private double ratedVoltage;
    private double capacitance;
    private FilterOrder filterOrder;
    private Technology technology;
    private ESDProtection esdProtection;
    private Application application;
    
    
    private enum FilterOrder {
        First,
        Second,
        Third,
        Fourth,
        Fifth,
        Sixth,
        Unknown
    }
    
    private enum Technology {
        LC,
        RC,
        RLC,
        ThinFilm,
        Unknown
    }
    
    private enum ESDProtection {
        Yes,
        No,
        Unknown
    }
    
    private enum Application {
        Audio,
        Automotive,
        Bluetooth,
        DataLines,
        GSM,
        LAN,
        USB,
        Telecommunications,
        Unknown
    }
}
