package OMS;

/* 
 * File: DigitalIsolatorInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class DigitalIsolatorInfo extends IsolatorInfo{
     private double dataRate;
    private double pulseWidthDistortion;
    private String type;
    private String inputsSide1Side2;
    private String qualification;
    
    private enum Technology {
        CapacitiveCoupling,
        GMR,
        MagneticCoupling,
        Unknown
    }
    
    private enum IsolatedPower {
        Yes,
        No,
        Unknown
    }
    
    private enum ChannelType {
        Bidirectional,
        Unidirectional,
        Unknown
    }
    
    private enum GradeType {
        Automotive,
        Unknown
    }
}
