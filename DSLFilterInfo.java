package OMS;

/* 
 * File: DSLFilterInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class DSLFilterInfo extends FilterInfo{
    private InputType input;
    private OutputType output;
            
    private enum InputType {
        DualLine,
        SingleLine,
        Unknown,
        
    }
    
    private enum OutputType{
        OneJack,
        OneFilteredJack,
        FourPhoneOneDSL,
        Unknown
    }
}
