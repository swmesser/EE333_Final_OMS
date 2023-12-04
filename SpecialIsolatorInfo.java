package OMS;

/* 
 * File: SpecialIsolatorInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class SpecialIsolatorInfo extends IsolatorInfo{
    private int outputCurrent;
    private int forwardCurrent;
    private double forwardVoltage;
    private InputType inputType;
    
    private enum InputType{
        AC,
        DC,
        I2C,
        Logic,
        Unknown
    }
}
