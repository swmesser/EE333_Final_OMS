package OMS;

import java.util.regex.Pattern;

/* 
 * File: WirelessChargingInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class WirelessChargingCoilInfo extends InductorCoilAndChokesInfo {
    private double inductance;
    private double currentRating;
    private double selfResonantFreq;
    private double operatingTemp;
    private WirelessCoilFunction function;
    private String type;
    private String qAtFreq;
    private String size;

    /**
     * Constructor for init
     */
    public WirelessChargingCoilInfo() {
        super();
        this.inductance = 0.0;
        this.function = WirelessCoilFunction.Unknown;
        this.type = "";
        this.qAtFreq = "";
        this.currentRating = 0.0;
        this.selfResonantFreq = 0.0;
        this.operatingTemp = 0.0;
        this.size = "";
    }

    /**
     * Constructor for import
     * @param inductance
     * @param currentRating
     * @param selfResonantFreq
     * @param operatingTemp
     * @param function
     * @param type
     * @param qAtFreq
     * @param size
     * @param tolerance
     * @param mount
     * @param packageCase
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
    public WirelessChargingCoilInfo(double inductance, double currentRating, double selfResonantFreq, double operatingTemp, WirelessCoilFunction function, String type, String qAtFreq, String size, double tolerance, InductorMountingType mount, String packageCase, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(tolerance, mount, packageCase, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        this.inductance = inductance;
        this.currentRating = currentRating;
        this.selfResonantFreq = selfResonantFreq;
        this.operatingTemp = operatingTemp;
        this.function = function;
        this.type = type;
        this.qAtFreq = qAtFreq;
        this.size = size;
    }
    
    /**
     * Push information to CSV format for export
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getInductance() + ",";
        output += this.getFunction() + ",";
        output += this.getType() + ",";
        output += this.getqAtFreq() + ",";
        output += this.getCurrentRating() + ",";
        output += this.getSelfResonantFreq() + ",";
        output += this.getOperatingTemp() + ",";
        output += this.getSize() + "\n";
        
        return(output);
    }

    /**
     * Push information to XML format for export
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "         <WirelessCharingCoilInfo>\n";
        output += "             <inductance>" + this.getInductance() + "</inductance>\n";
        output += "             <function>" + this.getFunction() + "</function>\n";
        output += "             <type>" + this.getType() + "</type>\n";
        output += "             <qAtFreq>" + this.getqAtFreq() + "</qAtFreq>\n";
        output += "             <currentRating>" + this.getCurrentRating()+ "</currentRating>\n";
        output += "             <selfResonantFreq>" + this.getSelfResonantFreq() + "</selfResonantFreq>\n";
        output += "             <operatingTemp>" + this.getOperatingTemp() + "</operatingTemp>\n";
        output += "             <size>" + this.getSize() + "</size>\n";
        output += "         </WirelessChargingCoilInfo>\n";
        output += "     </InductorCoilAndChokesInfo>\n";
        output += "</ProductInfo>\n";
        
        return(output);
    }
    
    /**
     * CSV format for import
     * @param input
     * @return
     * @throws Exception 
     */
    public static WirelessChargingCoilInfo fromCSV( String input ) throws Exception {
        WirelessChargingCoilInfo wirelessCoil = new WirelessChargingCoilInfo();
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
        //InductorCoilAndChoke
        double tolerance = 0.0;
        InductorMountingType mount;
        String packageCase = "";
        //WirelessChargingCoil
        double inductance = 0.0;
        WirelessCoilFunction function;
        String type;
        String qAtFreq;
        double currentRating = 0.0;
        double selfResonantFreq = 0.0;
        double operatingTemp;
        String size;
        
        
        //Validate input 
        if ( input == null ){
            throw new Exception("Error: Null input for parsing!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length string provided!");
        } else {
            //Split line based on comma
            Chunks = input.split(",");
            if ( Chunks.length == 24 ){
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
                //InductorCoilAndChokeInfo Params
                tolerance = Double.parseDouble(Chunks[ 13 ]);
                mount = InductorMountingType.valueOf( Chunks[ 14 ]);
                packageCase = Chunks[ 15 ];
                //==================
                //WirelessChargingCoilInfo Params
                inductance = Double.parseDouble(Chunks[ 16 ]);
                function = WirelessCoilFunction.valueOf( Chunks[ 17 ]);
                type = Chunks[ 18 ];
                qAtFreq = Chunks[ 19 ];
                currentRating = Double.parseDouble(Chunks[ 20 ]);
                selfResonantFreq = Double.parseDouble(Chunks[ 21 ]);
                operatingTemp = Double.parseDouble(Chunks[ 22 ]);
                size = Chunks[ 23 ];
                
                //Param validation -> constructor
                wirelessCoil = new WirelessChargingCoilInfo(inductance, currentRating,
                        selfResonantFreq, operatingTemp, function, type, qAtFreq, size,
                        tolerance, mount, packageCase, id, name, description, manufacturer,
                        mfgPartNum, series, qtyAvailable, price);
            }
        }
        
        return( wirelessCoil );
    }
    
    /**
     * XML format for import
     * @param input
     * @return
     * @throws Exception 
     */
    public static WirelessChargingCoilInfo fromXML( String input ) throws Exception{
        WirelessChargingCoilInfo wirelessCoil = new WirelessChargingCoilInfo();
        //Product
        String id = "";
        String name = "";
        String description = "";
        String series = "";
        String manufacturer = "";
        String mfgPartNum = "";
        int qtyAvailable = 0;
        double price = 0.0;
        StockOption stock = StockOption.unknown;
        EnvironmentalOption hazard = EnvironmentalOption.unknown;
        MediaOption media = MediaOption.unknown;
        PackageOption shippingBox = PackageOption.unknown;
        ProductStatus status = ProductStatus.unknown;
        //InductorCoilAndChoke
        double tolerance = 0.0;
        InductorMountingType mount = InductorMountingType.Unknown;
        String packageCase = "";
        //WirelessChargingCoil
        double inductance = 0.0;
        WirelessCoilFunction function = WirelessCoilFunction.Unknown;
        String type = "";
        String qAtFreq = "";
        double currentRating = 0.0;
        double selfResonantFreq = 0.0;
        double operatingTemp = 0.0;
        String size = "";
        
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
                
                regex = Pattern.compile("<tolerance>(.*)</tolerance>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    tolerance = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<mount>(.*)</mount>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    mount = InductorMountingType.valueOf( matcher.group(1));
                }
                
                regex = Pattern.compile("<packageCase>(.*)</packageCase>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    packageCase = matcher.group(1);
                }
                
                regex = Pattern.compile("<inductance>(.*)</inductance>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    inductance = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<function>(.*)</function>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    function = WirelessCoilFunction.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<type>(.*)</type>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    type = matcher.group(1);
                }
                
                regex = Pattern.compile("<qAtFreq>(.*)</qAtFreq>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    qAtFreq = matcher.group(1);
                }
                
                regex = Pattern.compile("<selfResonantFreq>(.*)</selfResonantFreq>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    selfResonantFreq = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<operatingTemp>(.*)</operatingTemp>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    operatingTemp = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<size>(.*)</size>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    packageCase = matcher.group(1);
                }
                
                regex = Pattern.compile("<currentRating>(.*)</currentRating>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    currentRating = Double.parseDouble(matcher.group(1));
                }  
                
            }
        }
        
        wirelessCoil = new WirelessChargingCoilInfo(inductance, currentRating, selfResonantFreq,
                operatingTemp, function, type, qAtFreq, size, tolerance, mount, packageCase,
                id, name, description, manufacturer, mfgPartNum, series, qtyAvailable, price);
        
        return( wirelessCoil );
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
