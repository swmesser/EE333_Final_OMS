package OMS;

import java.util.regex.Pattern;

/* 
 * File: CapacitorInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 29, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public abstract class CapacitorInfo extends ProductInfo{
    private double capacitance;
    private double tolerance;
    private double voltageRating;
    private double operationTemp;
    private String size;
    private String dielectricMat;
    private CapacitorMountingType mount;
    private String packageCase;
    private String seatedHeight;

    /**
     * Parameterless constructor for creation of blank capactior objects
     */
    public CapacitorInfo(){
        super();
        this.capacitance = 0.0;
        this.tolerance = 0.0;
        this.voltageRating = 0.0;
        this.operationTemp = 0.0;
        this.size = "";
        this.dielectricMat = "";
        this.mount = CapacitorMountingType.Unknown;
        this.packageCase = "";
        this.seatedHeight = "";
    }

    /**
     * Constructor used in importing capacitor objects
     * @param capacitance
     * @param tolerance
     * @param voltageRating
     * @param operationTemp
     * @param size
     * @param dielectricMat
     * @param mount
     * @param packageCase
     * @param seatedHeight
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
    public CapacitorInfo(double capacitance, double tolerance, double voltageRating, double operationTemp, String size, String dielectricMat, CapacitorMountingType mount, String packageCase, String seatedHeight, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(itemId, name, description, mfg, mfgPartNum, series, qty, price);
        
        if ( capacitance <= 0.0 ){
            throw new Exception("Error: Invalid capacitance passed!");
        } else if ( tolerance <= 0.0 ){
            throw new Exception("Error: Invalid tolerance passed!");
        } else if ( voltageRating <= 0.0 ){
            throw new Exception("Error: Invalid voltage rating passed!");
        } else if ( operationTemp <= 0.0 ){
            throw new Exception("Error: Invalid operation temperature passed!");
        } else if (( size == null ) || ( size.length() == 0 )){
            throw new Exception("Error: Invalid size passed!");
        } else if (( dielectricMat == null ) || ( dielectricMat.length() == 0 )){
            throw new Exception("Error: Invalid dielectric material passed!");
        } else if ((packageCase.length() == 0) || (packageCase == null)){
            throw new Exception("Error: Invalid package case passed!");
        } else if ((seatedHeight.length() == 0) || (seatedHeight == null)){
            throw new Exception("Error: Invalid seated height passed!");
        } else {
            this.capacitance = capacitance;
            this.tolerance = tolerance;
            this.voltageRating = voltageRating;
            this.operationTemp = operationTemp;
            this.size = size;
            this.dielectricMat = dielectricMat;
            this.mount = mount;
            this.packageCase = packageCase;
            this.seatedHeight = seatedHeight;
        }
    }
    
    /**
     * CSV formatting for export of capacitor object
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
 
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getCapacitance() + ",";
        output += this.getTolerance() + ",";
        output += this.getVoltageRating() + ",";
        output += this.getOperationTemp() + ",";
        output += this.getSize() + ",";
        output += this.getDielectricMat() + ",";
        output += this.getMount() + ",";
        output += this.getPackageCase() + ",";
        output += this.getSeatedHeight() + ",";
        
        return( output );
    }
    
    /**
     * XML formatting for export of capacitor object
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "     <CapacitorInfo>\n";
        output += "         <capacitance>" + this.getCapacitance() + "</capacitance>\n";
        output += "         <tolerance>" + this.getTolerance() + "</tolerance>\n";
        output += "         <voltageRating>" + this.getVoltageRating() + "</voltageRating>\n";
        output += "         <operationTemp>" + this.getOperationTemp() + "</operationTemp>\n";
        output += "         <size>" + this.getSize() + "</size>\n";
        output += "         <dielectricMat>" + this.getDielectricMat() + "</dielectricMat>\n";
        output += "         <mount>" + this.getMount() + "</mount>\n";
        output += "         <packageCase>" + this.getPackageCase() + "</packageCase>\n";
        output += "         <seatedHeight>" + this.getSeatedHeight() + "</seatedHeight>\n";
        
        
        return( output );
    }
    
    /**
     * @return the capacitance
     */
    public double getCapacitance() {
        return capacitance;
    }

    /**
     * @param capacitance the capacitance to set
     */
    public void setCapacitance(double capacitance) {
        this.capacitance = capacitance;
    }

    /**
     * @return the tolerance
     */
    public double getTolerance() {
        return tolerance;
    }

    /**
     * @param tolerance the tolerance to set
     */
    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    /**
     * @return the voltageRating
     */
    public double getVoltageRating() {
        return voltageRating;
    }

    /**
     * @param voltageRating the voltageRating to set
     */
    public void setVoltageRating(double voltageRating) {
        this.voltageRating = voltageRating;
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

    /**
     * @return the dielectricMat
     */
    public String getDielectricMat() {
        return dielectricMat;
    }

    /**
     * @param dielectricMat the dielectricMat to set
     */
    public void setDielectricMat(String dielectricMat) {
        this.dielectricMat = dielectricMat;
    }

    /**
     * @return the mount
     */
    public CapacitorMountingType getMount() {
        return mount;
    }

    /**
     * @param mount the mount to set
     */
    public void setMount(CapacitorMountingType mount) {
        this.mount = mount;
    }

    /**
     * @return the packageCase
     */
    public String getPackageCase() {
        return packageCase;
    }

    /**
     * @param packageCase the packageCase to set
     */
    public void setPackageCase(String packageCase) {
        this.packageCase = packageCase;
    }

    /**
     * @return the seatedHeight
     */
    public String getSeatedHeight() {
        return seatedHeight;
    }

    /**
     * @param seatedHeight the seatedHeight to set
     */
    public void setSeatedHeight(String seatedHeight) {
        this.seatedHeight = seatedHeight;
    }
}


// ENUM for Capacitors
enum CapacitorMountingType{
    ChassisMount,
    PanelMount,
    BracketMount,
    UserDefined,
    ChassisMountRequiresHolder,
    ChassisStudMount,
    SurfaceMount,
    ThroughHole,
    Unknown
}

enum CapacitorRatings{
    AEC_Q200,
    Unknown
}

enum CapacitorCircuitType{
    Bussed,
    Isolated,
    Unknown
}