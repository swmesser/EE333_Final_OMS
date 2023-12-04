package OMS;

import java.util.regex.Pattern;

/* 
 * File: AdjustableInductorsInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class AdjustableInductorsInfo extends InductorCoilAndChokesInfo {
    private double inductance;
    private String qAtFreq;
    private String height;
    private String size;

    /**
     * Constructor for adjustable inductor init
     */
    public AdjustableInductorsInfo(){
        super();
        this.inductance = 0.0;
        this.qAtFreq = "";
        this.height = "";
        this.size = "";
    }

    /**
     * Constructor for importing adjustable inductors
     * @param inductance
     * @param qAtFreq
     * @param height
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
    public AdjustableInductorsInfo(double inductance, String qAtFreq, String height, String size, double tolerance, InductorMountingType mount, String packageCase, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(tolerance, mount, packageCase, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        
        if ( inductance < 0.0 ){
            throw new Exception("Error: Invalid inductance passed!");
        } else if (( qAtFreq == null ) || ( qAtFreq.length() == 0 )){
            throw new Exception("Error: Invalid q at frequency passed!");
        } else if (( height == null ) || ( height.length() == 0 )){
            throw new Exception("Error: Invalid height passed!");
        } else if (( size == null ) || ( size.length() == 0 )){
            throw new Exception("Error: Invalid size passed!");
        } else {
            this.inductance = inductance;
            this.qAtFreq = qAtFreq;
            this.height = height;
            this.size = size;
        }
    }

    /**
     * CSV format for adjustable inductors
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getInductance() + ",";
        output += this.getqAtFreq() + ",";
        output += this.getHeight() + ",";
        output += this.getSize() + "\n";
        
        return(output);
    }

    /**
     * XML format for adjustable inductors
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "         <AdjustableInductors>\n";
        output += "             <inductance>" + this.getInductance() + "</inductance>\n";
        output += "             <qAtFreq>" + this.getqAtFreq() + "</qAtFreq>\n";
        output += "             <height>" + this.getHeight() + "</height>\n";
        output += "             <size>" + this.getSize() + "</size>\n";
        output += "         </AdjustableInductors>\n";
        output += "     </InductorCoilAndChokesInfo>\n";
        output += "</ProductInfo>\n";
        
        return(output);
    }

    /**
     * CSV importing of adjustable inductors
     * @param input
     * @return
     * @throws Exception 
     */
    public static AdjustableInductorsInfo fromCSV( String input ) throws Exception {
        AdjustableInductorsInfo adjustableInductor = new AdjustableInductorsInfo();
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
        InductorMountingType mount = InductorMountingType.Unknown;
        String packageCase = "";
        //AdjustableInductors
        double inductance = 0.0;
        String qAtFreq;
        String height;
        String size;
        
        //Validate input 
        if ( input == null ){
            throw new Exception("Error: Null input for parsing!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length string provided!");
        } else {
            //Split line based on comma
            Chunks = input.split(",");
            if ( Chunks.length == 20 ){
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
                //AdjustableInductorsInfo Params
                inductance = Double.parseDouble(Chunks[ 16 ]);
                qAtFreq = Chunks[ 17 ];
                height = Chunks[ 18 ];
                size = Chunks[ 19 ];
                
                adjustableInductor = new AdjustableInductorsInfo(inductance, qAtFreq, height, size, 
                        tolerance, mount, packageCase, id, name, description, manufacturer, mfgPartNum,
                        series, qtyAvailable, price);
            }
        }
        
        return ( adjustableInductor );
    }
    
    /**
     * XML importing of adjustable inductors
     * @param input
     * @return
     * @throws Exception 
     */
    public static AdjustableInductorsInfo fromXML( String input ) throws Exception {
        AdjustableInductorsInfo adjustableInductor = new AdjustableInductorsInfo();
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
        //InductorCoilAndChokes
        double tolerance = 0.0;
        InductorMountingType mount = InductorMountingType.Unknown;
        String packageCase = "";
        //AdjustableInductors
        double inductance = 0.0;
        String qAtFreq = "";
        String height = "";
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
                
                regex = Pattern.compile("<qAtFreq>(.*)</qAtFreq>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    qAtFreq = matcher.group(1);
                }
                
                regex = Pattern.compile("<height>(.*)</height>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    height = matcher.group(1);
                }
                
                regex = Pattern.compile("<size>(.*)</size>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    size = matcher.group(1);
                }
            }
        }
        
        adjustableInductor = new AdjustableInductorsInfo(inductance, qAtFreq, height,
                size, tolerance, mount, packageCase, id, name, description, manufacturer,
                mfgPartNum, series, qtyAvailable, price);
        
        return ( adjustableInductor );
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
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
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
