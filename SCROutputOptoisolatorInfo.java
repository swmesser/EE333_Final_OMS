package OMS;

/* 
 * File: SCROutputOptoisolatorInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class SCROutputOptoisolatorInfo extends IsolatorInfo{
    private int turnOnTime;
    private int forwardCurrent;
    private double voltageOffState;
    private double maximumLEDTriggerCurrent;
    private double currentOnState;
    private double holdCurrent;
    private double forwardVoltage;
    private double staticDvDt;
    
    
    private enum OutputType {
        SCR,
        Triac,
        PowerTriac,
        Unknown
    }
    
    private enum ZeroCrossingCircuit {
        Yes,
        No,
        Unknown
    }
}
