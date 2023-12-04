package OMS;

import java.util.regex.Pattern;

/* 
 * File: RelayInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 29, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public abstract class RelayInfo extends ProductInfo{
    private double contactCurrentRating;
    private double mustOperateVolt;
    private double mustReleaseVolt;
    private double operateTime;
    private double releaseTime;
    private double operationTemp;
    private double coilVoltage;
    private String features;
    private String terminationStyle;
    private RelayMountingType mount;

    /**
     * Constructor for initialization of relay object
     */
    public RelayInfo() {
        this.contactCurrentRating = 0.0;
        this.mustOperateVolt = 0.0;
        this.mustReleaseVolt = 0.0;
        this.operateTime = 0.0;
        this.releaseTime = 0.0;
        this.operationTemp = 0.0;
        this.coilVoltage = 0.0;
        this.features = "";
        this.terminationStyle = "";
        this.mount = RelayMountingType.Unknown;
    }

    /**
     * Constructor for importing of relay objects
     * @param contactCurrentRating
     * @param mustOperateVolt
     * @param mustReleaseVolt
     * @param operateTime
     * @param releaseTime
     * @param operationTemp
     * @param coilVoltage
     * @param features
     * @param terminationStyle
     * @param mount
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
    public RelayInfo(double contactCurrentRating, double mustOperateVolt, double mustReleaseVolt, double operateTime, double releaseTime, double operationTemp, double coilVoltage, String features, String terminationStyle, RelayMountingType mount, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(itemId, name, description, mfg, mfgPartNum, series, qty, price);
        this.contactCurrentRating = contactCurrentRating;
        this.mustOperateVolt = mustOperateVolt;
        this.mustReleaseVolt = mustReleaseVolt;
        this.operateTime = operateTime;
        this.releaseTime = releaseTime;
        this.operationTemp = operationTemp;
        this.coilVoltage = coilVoltage;
        this.features = features;
        this.terminationStyle = terminationStyle;
        this.mount = mount;
    }
    
    /**
     * CSV format of relay object for export
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getContactCurrentRating() + ",";
        output += this.getMustOperateVolt() + ",";
        output += this.getMustReleaseVolt() + ",";
        output += this.getOperateTime() + ",";
        output += this.getReleaseTime() + ",";
        output += this.getFeatures() + ",";
        output += this.getTerminationStyle() + ",";
        output += this.getOperationTemp() + ",";
        output += this.getCoilVoltage() + ",";
        output += this.getMount() + ",";
        
        return(output);
    }
    
    /**
     * XML format of relay object for export
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "     <RelayInfo>\n";
        output += "         <contactCurrentRating>" + this.getContactCurrentRating() + "</contactCurrentRating>\n";
        output += "         <mustOperateVolt>" + this.getMustOperateVolt() + "</mustOperateVolt>\n";
        output += "         <mustReleaseVolt>" + this.getMustReleaseVolt() + "</mustReleaseVolt>\n";
        output += "         <operateTime>" + this.getOperateTime() + "</operateTime>\n";
        output += "         <releaseTime>" + this.getReleaseTime() + "</releaseTime>\n";
        output += "         <features>" + this.getFeatures() + "</features>\n";
        output += "         <terminationStyle>" + this.getTerminationStyle() + "</terminationStyle>\n";
        output += "         <operationTemp>" + this.getOperationTemp() + "</operationTemp>\n";
        output += "         <coilVoltage>" + this.getCoilVoltage() + "</coilVoltage>\n";
        output += "         <mount>" + this.getMount() + "</mount>\n";
        
        
        return(output);
    }
    
    /**
     * @return the contactCurrentRating
     */
    public double getContactCurrentRating() {
        return contactCurrentRating;
    }

    /**
     * @param contactCurrentRating the contactCurrentRating to set
     */
    public void setContactCurrentRating(double contactCurrentRating) {
        this.contactCurrentRating = contactCurrentRating;
    }

    /**
     * @return the mustOperateVolt
     */
    public double getMustOperateVolt() {
        return mustOperateVolt;
    }

    /**
     * @param mustOperateVolt the mustOperateVolt to set
     */
    public void setMustOperateVolt(double mustOperateVolt) {
        this.mustOperateVolt = mustOperateVolt;
    }

    /**
     * @return the mustReleaseVolt
     */
    public double getMustReleaseVolt() {
        return mustReleaseVolt;
    }

    /**
     * @param mustReleaseVolt the mustReleaseVolt to set
     */
    public void setMustReleaseVolt(double mustReleaseVolt) {
        this.mustReleaseVolt = mustReleaseVolt;
    }

    /**
     * @return the operateTime
     */
    public double getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateTime the operateTime to set
     */
    public void setOperateTime(double operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * @return the releaseTime
     */
    public double getReleaseTime() {
        return releaseTime;
    }

    /**
     * @param releaseTime the releaseTime to set
     */
    public void setReleaseTime(double releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * @return the features
     */
    public String getFeatures() {
        return features;
    }

    /**
     * @param features the features to set
     */
    public void setFeatures(String features) {
        this.features = features;
    }

    /**
     * @return the terminationStyle
     */
    public String getTerminationStyle() {
        return terminationStyle;
    }

    /**
     * @param terminationStyle the terminationStyle to set
     */
    public void setTerminationStyle(String terminationStyle) {
        this.terminationStyle = terminationStyle;
    }

    /**
     * @return the operationTemp
     */
    public double getOperationTemp() {
        return operationTemp;
    }

    /**
     * @param operationTemp the operationTemp to set
     */
    public void setOperationTemp(double operationTemp) {
        this.operationTemp = operationTemp;
    }

    /**
     * @return the coilVoltage
     */
    public double getCoilVoltage() {
        return coilVoltage;
    }

    /**
     * @param coilVoltage the coilVoltage to set
     */
    public void setCoilVoltage(double coilVoltage) {
        this.coilVoltage = coilVoltage;
    }

    /**
     * @return the mount
     */
    public RelayMountingType getMount() {
        return mount;
    }

    /**
     * @param mount the mount to set
     */
    public void setMount(RelayMountingType mount) {
        this.mount = mount;
    }
}


//Relay Enum
enum RelayCoilType{
        LatchingDualCoil,
        LatchingSingleCoil,
        NonLatching,
        Unknown
    }

enum RelayMountingType {
        ChassisMount,
        SurfaceMount,
        PanelMount,
        ThroughHole,
        ThroughHoleRightAngle,
        FreeHanging,
        Socketable,
        SocketableThroughHole,
        DINRail,
        Unknown
    }