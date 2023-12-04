package OMS;

import java.util.regex.Pattern;

/* 
 * File: TrimmerAndVariableInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class TrimmerAndVariableInfo extends CapacitorInfo {
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
