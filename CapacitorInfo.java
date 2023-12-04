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

final class TrimmerAndVariableInfo extends CapacitorInfo{
    private String capacitanceRange;
    private String adjustmentType;
    private String qAtFreq;
    private String features;
    
    /**
     * Constructor for use of creation of empty objects
     */
    public TrimmerAndVariableInfo() {
        super();
        this.capacitanceRange = "";
        this.adjustmentType = "";
        this.qAtFreq = "";
        this.features = "";
    }

    /**
     * Constructor for importing trimmer objects
     * @param capacitanceRange
     * @param adjustmentType
     * @param qAtFreq
     * @param features
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
    public TrimmerAndVariableInfo(String capacitanceRange, String adjustmentType, String qAtFreq, String features, double capacitance, double tolerance, double voltageRating, double operationTemp, String size, String dielectricMat, CapacitorMountingType mount, String packageCase, String seatedHeight, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(capacitance, tolerance, voltageRating, operationTemp, size, dielectricMat, mount, packageCase, seatedHeight, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        
        if ((capacitanceRange.length() == 0) || (capacitanceRange == null)){
            throw new Exception("Error: Invalid capacitance range passed!");
        } else if ((adjustmentType.length() == 0) || (adjustmentType == null)){
            throw new Exception("Error: Invalid adjustment type passed!");
        } else if ((qAtFreq.length() == 0) || (qAtFreq == null)){
            throw new Exception("Error: Invalid q at frequency passed!");
        } else if ((features.length() == 0) || (features == null)){
            throw new Exception("Error: Invalid features passed!");
        } else {
            this.capacitanceRange = capacitanceRange;
            this.adjustmentType = adjustmentType;
            this.qAtFreq = qAtFreq;
            this.features = features;
        }
    }
    
    /**
     * CSV formatting for trimmer object
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getCapacitanceRange() + ",";
        output += this.getAdjustmentType() + ",";
        output += this.getqAtFreq() + ",";
        output += this.getFeatures() + "\n";
        
        return(output);
    }

    /**
     * XML formatting for trimmer object
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "         <TrimmerAndVariableInfo>\n";
        output += "             <capacitanceRange>" + this.getCapacitanceRange() + "</capacitanceRange>\n";
        output += "             <adjustmentType>" + this.getAdjustmentType() + "</adjustmentType>\n";
        output += "             <qAtFreq>" + this.getqAtFreq() + "</qAtFreq>\n";
        output += "             <features>" + this.getFeatures() + "</features>\n";
        output += "         </TrimmerAndVariableInfo>\n";
        output += "     </CapacitorInfo>\n";
        output += "</ProductInfo>\n";
        
        return(output);
    }
    
    /**
     * Import of CSV formatted trimmer object
     * @param input
     * @return
     * @throws Exception 
     */
    public static TrimmerAndVariableInfo fromCSV( String input ) throws Exception{
        TrimmerAndVariableInfo trimmerAndVariableInfo = new TrimmerAndVariableInfo();
        String[] Chunks;
        //Product
        String id = "";
        String name = "";
        String description = "";
        String series = "";
        String manufacturer = "";
        String mfgPartNum = "";
        int qtyAvailable = 0;
        double price = 0.0;
        StockOption stock;
        EnvironmentalOption hazard;
        MediaOption media;
        PackageOption shippingBox;
        ProductStatus status;
        //Capacitor
        double capacitance = 0.0;
        double tolerance = 0.0;
        double voltageRating = 0.0;
        double operationTemp = 0.0;
        String size = "";
        String dielectricMat = "";
        CapacitorMountingType mount;
        String packageCase = "";
        String seatedHeight = "";
        //TrimmerAndVariable
        String capacitanceRange = "";
        String adjustmentType = "";
        String qAtFreq = "";
        String features = "";
        
        //Validate input 
        if ( input == null ){
            throw new Exception("Error: Null input for parsing!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length string provided!");
        } else {
            //Split line based on comma
            Chunks = input.split(",");
            if ( Chunks.length == 26 ){
                //Assign all parameters
                //ProductInfo Params
                id = Chunks[ 0 ];
                name = Chunks[ 1 ];
                description = Chunks[ 2 ];
                manufacturer = Chunks[ 3 ];
                mfgPartNum = Chunks[ 4 ];
                series = Chunks[ 5 ];
                stock = StockOption.valueOf( Chunks[ 6 ]);
                hazard = EnvironmentalOption.valueOf( Chunks[ 7 ]);
                media = MediaOption.valueOf( Chunks[ 8 ]);
                shippingBox = PackageOption.valueOf( Chunks[ 9 ]);
                status = ProductStatus.valueOf( Chunks[ 10 ]);
                qtyAvailable = Integer.valueOf(Chunks[ 11 ]);
                price = Double.valueOf( Chunks[ 12 ]);
                //==================
                //CapacitorInfo
                capacitance = Double.parseDouble(Chunks[ 13 ]);
                tolerance = Double.parseDouble(Chunks[ 14 ]);
                voltageRating = Double.parseDouble(Chunks[ 15 ]);
                operationTemp = Double.parseDouble(Chunks[ 16 ]);
                size = Chunks[ 17 ];
                dielectricMat = Chunks[ 18 ];
                mount = CapacitorMountingType.valueOf( Chunks[ 19 ]);
                packageCase = Chunks[ 20 ];
                seatedHeight = Chunks[ 21 ];
                //=================
                //TrimmerAndVariableInfo
                capacitanceRange = Chunks[ 22 ];
                adjustmentType = Chunks[ 23 ];
                qAtFreq = Chunks[ 24 ];
                features = Chunks[ 25 ];
                
                //Param Validation -> construct.
                trimmerAndVariableInfo = new TrimmerAndVariableInfo(capacitanceRange, adjustmentType, qAtFreq,
                        features, capacitance, tolerance, voltageRating, operationTemp, 
                        size, dielectricMat, mount, packageCase, seatedHeight, id, name, 
                        description, manufacturer, mfgPartNum, series, qtyAvailable, price);
                
            }
        }
        
        return( trimmerAndVariableInfo );
    }
    
     public static TrimmerAndVariableInfo fromXML( String input ) throws Exception {
        TrimmerAndVariableInfo trimmerAndVariable = new TrimmerAndVariableInfo();
        //Product
        String id = "";
        String name = "";
        String description = "";
        String series = "";
        String manufacturer = "";
        String mfgPartNum = "";
        int qtyAvailable = 0;
        double price = 0.0;
        StockOption stock;
        EnvironmentalOption hazard;
        MediaOption media;
        PackageOption shippingBox;
        ProductStatus status;
        //Capacitor
        double capacitance = 0.0;
        double tolerance = 0.0;
        double voltageRating = 0.0;
        double operationTemp = 0.0;
        String size = "";
        String dielectricMat = "";
        CapacitorMountingType mount = CapacitorMountingType.Unknown;
        String packageCase = "";
        String seatedHeight = "";
        //TrimmerAndVariableInfo
        String capacitanceRange = "";
        String adjustmentType = "";
        String qAtFreq = "";
        String features = "";
        
        
        //Parsing input using regex
        java.util.regex.Pattern regex = java.util.regex.Pattern.compile("<ProductInfo>(.*)</ProductInfo>");
        //Matching the Pattern
        java.util.regex.Matcher matcher = regex.matcher( input );
        
        //Looping through the groups captured using pattern matching
        for ( int index = 0; index < matcher.groupCount(); index++){
            //Testing to find match
            if ( matcher.find() == true ){
                //Pattern match for each of the fields in the Object
                regex = Pattern.compile("<itemId>(.*)</itemId>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    id = matcher.group(1);
                }
                
                regex = Pattern.compile("<name>(.*)</name>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    name = matcher.group(1);
                }
                
                regex = Pattern.compile("<description>(.*)</description>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    description = matcher.group(1);
                }
                
                regex = Pattern.compile("<manufacturer>(.*)</manufacturer>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    manufacturer = matcher.group(1);
                }
                
                regex = Pattern.compile("<mfgPartNumber>(.*)</mfgPartNumber>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    mfgPartNum = matcher.group(1);
                }
                
                regex = Pattern.compile("<series>(.*)</series>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    series = matcher.group(1);
                }
                
                regex = Pattern.compile("<availability>(.*)</availability>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    stock = StockOption.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<status>(.*)</status>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    status = ProductStatus.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<media>(.*)</media>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    media = MediaOption.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<hazards>(.*)</hazards>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    hazard = EnvironmentalOption.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<shippingPackage>(.*)</shippingPackage>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    shippingBox = PackageOption.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<qtyAvailabile>(.*)</qtyAvailable>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    qtyAvailable = Integer.parseInt(matcher.group(1));
                }
                
                regex = Pattern.compile("<price>(.*)</price>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    price = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<capacitance>(.*)</capacitance>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    capacitance = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<tolerance>(.*)</tolerance>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    tolerance = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<voltageRating>(.*)</voltageRating>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    voltageRating = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<operationTemp>(.*)</operationTemp>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    operationTemp = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<size>(.*)</size>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    size = matcher.group(1);
                }
                
                regex = Pattern.compile("<dielectricMat>(.*)</dielectricMat>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    dielectricMat = matcher.group(1);
                }
                
                regex = Pattern.compile("<mount>(.*)</mount>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    mount = CapacitorMountingType.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<packageCase>(.*)</packageCase>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    packageCase = matcher.group(1);
                }
                
                regex = Pattern.compile("<seatedHeight>(.*)</seatedHeight>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    seatedHeight = matcher.group(1);
                }
                
                regex = Pattern.compile("<capacitanceRange>(.*)</capacitanceRange>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    capacitanceRange = matcher.group(1);
                }
                
                regex = Pattern.compile("<adjustmentType>(.*)</adjustmentType>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    adjustmentType = matcher.group(1);
                }
                
                regex = Pattern.compile("<qAtFreq>(.*)</qAtFreq>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    qAtFreq = matcher.group(1);
                }
                
                regex = Pattern.compile("<features>(.*)</features>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    features = matcher.group(1);
                }
                
                trimmerAndVariable = new TrimmerAndVariableInfo(capacitanceRange, adjustmentType,
                        qAtFreq, features, capacitance, tolerance, voltageRating, operationTemp,
                        size, dielectricMat, mount, packageCase, seatedHeight, id, name,
                        description, manufacturer, mfgPartNum, series, qtyAvailable, price);
                
            }
        }
        
        return( trimmerAndVariable );
    }

    /**
     * @return the capacitanceRange
     */
    public String getCapacitanceRange() {
        return capacitanceRange;
    }

    /**
     * @param capacitanceRange the capacitanceRange to set
     */
    public void setCapacitanceRange(String capacitanceRange) {
        this.capacitanceRange = capacitanceRange;
    }

    /**
     * @return the adjustmentType
     */
    public String getAdjustmentType() {
        return adjustmentType;
    }

    /**
     * @param adjustmentType the adjustmentType to set
     */
    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
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