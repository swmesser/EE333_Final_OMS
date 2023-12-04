package OMS;

/* 
 * File: WirelessChargingInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class WirelessChargingInfo extends InductorCoilAndChokesInfo {
    private double inductance;
    private double currentRating;
    private double selfResonantFreq;
    private double operatingTemp;
    private WirelessCoilFunction function;
    private String type;
    private String qAtFreq;
    private String size;

    /**
     * Push information to CSV format for export
     * @return 
     */
    @Override
    public String toCSV() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Push information to XML format for export
     * @return 
     */
    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void fromCSV( String input ){
        
    }
    
    /**
     * @return the inductance
     */
    public double getInductance() {
        return inductance;
    }

    /**
     * @param inductance the inductance to set
     */
    public void setInductance(double inductance) {
        this.inductance = inductance;
    }

    /**
     * @return the function
     */
    public WirelessCoilFunction getFunction() {
        return function;
    }

    /**
     * @param function the function to set
     */
    public void setFunction(WirelessCoilFunction function) {
        this.function = function;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the qAtFreq
     */
    public String getqAtFreq() {
        return qAtFreq;
    }

    /**
     * @param qAtFreq the qAtFreq to set
     */
    public void setqAtFreq(String qAtFreq) {
        this.qAtFreq = qAtFreq;
    }

    /**
     * @return the currentRating
     */
    public double getCurrentRating() {
        return currentRating;
    }

    /**
     * @param currentRating the currentRating to set
     */
    public void setCurrentRating(double currentRating) {
        this.currentRating = currentRating;
    }

    /**
     * @return the selfResonantFreq
     */
    public double getSelfResonantFreq() {
        return selfResonantFreq;
    }

    /**
     * @param selfResonantFreq the selfResonantFreq to set
     */
    public void setSelfResonantFreq(double selfResonantFreq) {
        this.selfResonantFreq = selfResonantFreq;
    }

    /**
     * @return the operatingTemp
     */
    public double getOperatingTemp() {
        return operatingTemp;
    }

    /**
     * @param operatingTemp the operatingTemp to set
     */
    public void setOperatingTemp(double operatingTemp) {
        this.operatingTemp = operatingTemp;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }
}
