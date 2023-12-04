package OMS;

/* 
 * File: GateDriverInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class GateDriverInfo extends IsolatorInfo{
    private int forwardDCCureent;
    private double pulseWidthDistortion;
    private double peakOutputCurrent;
    private double forwardVoltage;
    private String qualification;
    
    private enum Technology{
        CapacitiveCoupling,
        OpticalCoupling,
        MagneticCoupling,
        RFCoupling,
        Unknown
    }
    
    private enum GradeType{
        Automotive,
        Unknown
    }
}
