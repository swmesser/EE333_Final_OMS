package OMS;

import java.io.EOFException;

/* 
 * File: IsolatorInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 30, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public abstract class IsolatorInfo extends ProductInfo{
    private int channelCount;
    private int voltageIsolation;
    private double commonModeTransientImmunity;
    private double propagationDelay;
    private double riseFallTime;
    private double voltageSupply;
    private double operatingTemp;
    private MountingType mountType;
    private String approvalAgency;
    private String supplierDevicePackage;
    
    /**
     * Constructor for isolator initialization
     */
    public IsolatorInfo(){
        super();
        this.channelCount = 0;
        this.voltageIsolation = 0;
        this.commonModeTransientImmunity = 0.0;
        this.propagationDelay = 0.0;
        this.riseFallTime = 0.0;
        this.voltageSupply = 0.0;
        this.operatingTemp = 0.0;
        this.mountType = MountingType.Unknown;
        this.approvalAgency = "";
        this.supplierDevicePackage = "";
    }

    /**
     * Constructor for importing of isolator object
     * @param channelCount
     * @param voltageIsolation
     * @param commonModeTransientImmunity
     * @param propagationDelay
     * @param riseFallTime
     * @param voltageSupply
     * @param operatingTemp
     * @param mountType
     * @param approvalAgency
     * @param supplierDevicePackage
     * @param itemId
     * @param name
     * @param description
     * @param mfg
     * @param mfgPartNum
     * @param series
     * @param qty
     * @param price
     * @throws Exception 
     */
    public IsolatorInfo(int channelCount, int voltageIsolation, double commonModeTransientImmunity, double propagationDelay, double riseFallTime, double voltageSupply, double operatingTemp, MountingType mountType, String approvalAgency, String supplierDevicePackage, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(itemId, name, description, mfg, mfgPartNum, series, qty, price);
        if (channelCount < 0 ){
            throw new Exception("Error: Invalid channel count passed!");
        } else if ( voltageIsolation < 0 ){
            throw new Exception("Error: Invalid voltage isolation passed!");
        } else if ( commonModeTransientImmunity < 0 ){
            throw new Exception("Error: Invalid common mode transient immunity passed!");
        } else if ( propagationDelay < 0.0 ){
            throw new Exception("Error: Invalid propagation delay passed!");
        } else if ( riseFallTime < 0.0 ){
            throw new Exception("Error: Invalid rise fall time passed!");
        } else if ( voltageSupply < 0.0 ){
            throw new Exception("Error: Invalid voltage supply passed!");
        } else if ( operatingTemp < 0.0 ){
            throw new Exception("Error: Invalid operating temperature passed!");
        } else if (( approvalAgency == null ) || ( approvalAgency.length() == 0 )){
            throw new Exception("Error: Invalid approval agency passed!");
        } else if (( supplierDevicePackage == null ) || ( supplierDevicePackage.length() == 0 )){
            throw new Exception("Error: Invalid supplier device package passed!");
        }else {
            this.channelCount = channelCount;
            this.voltageIsolation = voltageIsolation;
            this.commonModeTransientImmunity = commonModeTransientImmunity;
            this.propagationDelay = propagationDelay;
            this.riseFallTime = riseFallTime;
            this.voltageSupply = voltageSupply;
            this.operatingTemp = operatingTemp;
            this.mountType = mountType;
            this.approvalAgency = approvalAgency;
            this.supplierDevicePackage = supplierDevicePackage;
        }
    }
    
    private enum MountingType {
        Surface,
        Hole,
        DinRail,
        Connector,
        FreeHanging,
        Unknown
    }

    /**
     * CSV format for isolator object
     * @return 
     */
    public String toCSV(){
       String output = "";
       
       output += super.toCSV();
       output += this.channelCount + ",";
       output += this.voltageIsolation + ",";
       output += this.commonModeTransientImmunity + ",";
       output += this.propagationDelay + ",";
       output += this.riseFallTime + ",";
       output += this.voltageSupply + ",";
       output += this.operatingTemp + ",";
       output += this.mountType + ",";
       output += this.approvalAgency + ",";
       output += this.supplierDevicePackage + ",";
       
       return output;
    }
    
    /**
     * XML format for isolator object
     * @return 
     */
    public String toXML(){
        String output = "";
        
        output += "         <IsolatorInfo>\n";
        output += "             <channelCount>" + this.channelCount + "</channelCount>\n";
        output += "             <voltageIsolation>" + this.voltageIsolation + "</voltageIsolation>\n";
        output += "             <commonModeTransientImmunity>" + this.commonModeTransientImmunity + "</commonModeTransientImmunity>\n";
        output += "             <propagationDelay>" + this.propagationDelay + "</propagationDelay>\n";
        output += "             <riseFallTime>" + this.riseFallTime + "</riseFallTime>\n";
        output += "             <voltageSupply>" + this.voltageSupply + "</voltageSupply>\n";
        output += "             <operatingTemp>" + this.operatingTemp + "</operatingTemp>\n";
        output += "             <mountType>" + this.mountType + "</mountType>\n";
        output += "             <approvalAgency>" + this.approvalAgency + "</approvalAgency>\n";
        output += "             <supplierDevicePackage>" + this.supplierDevicePackage + "</supplierDevicePackage>\n";
        
        return output;
    }
    
    /**
     * @return the channelCount
     */
    public int getChannelCount() {
        return channelCount;
    }

    /**
     * @param channelCount the channelCount to set
     */
    public void setChannelCount(int channelCount) {
        this.channelCount = channelCount;
    }

    /**
     * @return the voltageIsolation
     */
    public int getVoltageIsolation() {
        return voltageIsolation;
    }

    /**
     * @param voltageIsolation the voltageIsolation to set
     */
    public void setVoltageIsolation(int voltageIsolation) {
        this.voltageIsolation = voltageIsolation;
    }

    /**
     * @return the commonModeTransientImmunity
     */
    public double getCommonModeTransientImmunity() {
        return commonModeTransientImmunity;
    }

    /**
     * @param commonModeTransientImmunity the commonModeTransientImmunity to set
     */
    public void setCommonModeTransientImmunity(double commonModeTransientImmunity) {
        this.commonModeTransientImmunity = commonModeTransientImmunity;
    }

    /**
     * @return the propagationDelay
     */
    public double getPropagationDelay() {
        return propagationDelay;
    }

    /**
     * @param propagationDelay the propagationDelay to set
     */
    public void setPropagationDelay(double propagationDelay) {
        this.propagationDelay = propagationDelay;
    }

    /**
     * @return the riseFallTime
     */
    public double getRiseFallTime() {
        return riseFallTime;
    }

    /**
     * @param riseFallTime the riseFallTime to set
     */
    public void setRiseFallTime(double riseFallTime) {
        this.riseFallTime = riseFallTime;
    }

    /**
     * @return the voltageSupply
     */
    public double getVoltageSupply() {
        return voltageSupply;
    }

    /**
     * @param voltageSupply the voltageSupply to set
     */
    public void setVoltageSupply(double voltageSupply) {
        this.voltageSupply = voltageSupply;
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
     * @return the mountType
     */
    public MountingType getMountType() {
        return mountType;
    }

    /**
     * @param mountType the mountType to set
     */
    public void setMountType(MountingType mountType) {
        this.mountType = mountType;
    }

    /**
     * @return the approvalAgency
     */
    public String getApprovalAgency() {
        return approvalAgency;
    }

    /**
     * @param approvalAgency the approvalAgency to set
     */
    public void setApprovalAgency(String approvalAgency) {
        this.approvalAgency = approvalAgency;
    }

    /**
     * @return the supplierDevicePackage
     */
    public String getSupplierDevicePackage() {
        return supplierDevicePackage;
    }

    /**
     * @param supplierDevicePackage the supplierDevicePackage to set
     */
    public void setSupplierDevicePackage(String supplierDevicePackage) {
        this.supplierDevicePackage = supplierDevicePackage;
    }
    
    
}
