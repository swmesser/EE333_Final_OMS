package OMS;

import java.util.regex.Pattern;

/* 
 * File: EDLCAndSupercapacitorInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class EDLCAndSupercapacitorInfo extends CapacitorInfo{
    private double equivalentSeriesResistance;
    private String lifetimeAtTemp;
    private String termination;
    private String leadSpacing;

    /**
     * Constructor for initialization of edlc object
     */
    public EDLCAndSupercapacitorInfo(){
        super();
        this.equivalentSeriesResistance = 0.0;
        this.lifetimeAtTemp = "";
        this.termination = "";
        this.leadSpacing = "";
    }

    /**
     * Constructor for importing of edlc object
     * @param equivalentSeriesResistance
     * @param lifetimeAtTemp
     * @param termination
     * @param leadSpacing
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
    public EDLCAndSupercapacitorInfo(double equivalentSeriesResistance, String lifetimeAtTemp, String termination, String leadSpacing, double capacitance, double tolerance, double voltageRating, double operationTemp, String size, String dielectricMat, CapacitorMountingType mount, String packageCase, String seatedHeight, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(capacitance, tolerance, voltageRating, operationTemp, size, dielectricMat, mount, packageCase, seatedHeight, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        
        if ((lifetimeAtTemp.length() == 0) || (lifetimeAtTemp == null)){
            throw new Exception("Error: Invalid lifetime at temperature passed!");
        } else if ((termination.length() == 0) || (termination == null)){
            throw new Exception("Error: Invalid termination passed!");
        } else if ((leadSpacing.length() == 0) || (leadSpacing == null)){
            throw new Exception("Error: Invalid lead spacing passed!");
        } else {
            this.equivalentSeriesResistance = equivalentSeriesResistance;
            this.lifetimeAtTemp = lifetimeAtTemp;
            this.termination = termination;
            this.leadSpacing = leadSpacing;
        }
    }
    
    /**
     * CSV format for export of edlc object
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getEquivalentSeriesResistance() + ",";
        output += this.getLifetimeAtTemp() + ",";
        output += this.getTermination() + ",";
        output += this.getLeadSpacing() + "\n";
        
        return(output);
    }

    /**
     * XML format for export of edlc object
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "         <EDLCAndSupercapacitorInfo>\n";
        output += "             <equivalentSeriesResistance>" + this.getEquivalentSeriesResistance() + "</equivalentSeriesResistance>\n";
        output += "             <lifetimeAtTemp>" + this.getLifetimeAtTemp() + "</lifetimeAtTemp>\n";
        output += "             <termination>" + this.getTermination() + "</termination>\n";
        output += "             <leadSpacing>" + this.getLeadSpacing() + "</leadSpacing>\n";
        output += "         </EDLCAndSupercapacitorInfo>\n";
        output += "     </CapacitorInfo>\n";
        output += "</ProductInfo>\n";
        
        return(output);
    }
    
    /**
     * Importing CSV formatted edlc objects
     * @param input
     * @return
     * @throws Exception 
     */
     public static EDLCAndSupercapacitorInfo fromCSV( String input ) throws Exception{
        EDLCAndSupercapacitorInfo edlcAndSupercapacitor = null;
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
        //EDLCAndSupercapacitor
        double equivalentSeriesResistance;
        String lifetimeAtTemp;
        String termination;
        String leadSpacing;
        
        
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
                //EDLCAndSupercapacitors
                equivalentSeriesResistance = Double.parseDouble(Chunks[ 22 ]);
                lifetimeAtTemp = Chunks[ 23 ];
                termination = Chunks[ 24 ];
                leadSpacing = Chunks[ 25 ];
                
                //Param validation -> constructor
                edlcAndSupercapacitor = new EDLCAndSupercapacitorInfo(equivalentSeriesResistance,
                        lifetimeAtTemp, termination, leadSpacing, capacitance, tolerance,
                        voltageRating, operationTemp, size, dielectricMat, mount, packageCase,
                        seatedHeight, id, name, description, manufacturer, mfgPartNum, series, qtyAvailable, price);
            }
            
        }
        
        return( edlcAndSupercapacitor );
    }
     
    public static EDLCAndSupercapacitorInfo fromXML( String input ) throws Exception{
        EDLCAndSupercapacitorInfo edlcAndSupercapacitor = new EDLCAndSupercapacitorInfo();
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
        //EDLCAndSupercapacitor
        double equivalentSeriesResistance = 0.0;
        String lifetimeAtTemp = "";
        String termination = "";
        String leadSpacing = "";
        
        //Validate input 
        if ( input == null ){
            throw new Exception("Error: Null input for parsing!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length string provided!");
        } else {
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

                    regex = Pattern.compile("<equivalentSeriesResistance>(.*)</equivalentSeriesResistance>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        equivalentSeriesResistance = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<lifetimeAtTemp>(.*)</lifetimeAtTemp>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        lifetimeAtTemp = matcher.group(1);
                    }

                    regex = Pattern.compile("<termination>(.*)</termination>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        termination = matcher.group(1);
                    }

                    regex = Pattern.compile("<leadSpacing>(.*)</leadSpacing>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        leadSpacing = matcher.group(1);
                    }

                    edlcAndSupercapacitor = new EDLCAndSupercapacitorInfo(equivalentSeriesResistance,
                            lifetimeAtTemp, termination, leadSpacing, capacitance, tolerance, 
                            voltageRating, operationTemp, size, dielectricMat, mount, packageCase,
                            seatedHeight, id, name, description, manufacturer, mfgPartNum, series, qtyAvailable, price);
                }
            }
        }
        return edlcAndSupercapacitor;
    }

    /**
     * @return the equivalentSeriesResistance
     */
    public double getEquivalentSeriesResistance() {
        return equivalentSeriesResistance;
    }

    /**
     * @param equivalentSeriesResistance the equivalentSeriesResistance to set
     */
    public void setEquivalentSeriesResistance(double equivalentSeriesResistance) {
        this.equivalentSeriesResistance = equivalentSeriesResistance;
    }

    /**
     * @return the lifetimeAtTemp
     */
    public String getLifetimeAtTemp() {
        return lifetimeAtTemp;
    }

    /**
     * @param lifetimeAtTemp the lifetimeAtTemp to set
     */
    public void setLifetimeAtTemp(String lifetimeAtTemp) {
        this.lifetimeAtTemp = lifetimeAtTemp;
    }

    /**
     * @return the termination
     */
    public String getTermination() {
        return termination;
    }

    /**
     * @param termination the termination to set
     */
    public void setTermination(String termination) {
        this.termination = termination;
    }

    /**
     * @return the leadSpacing
     */
    public String getLeadSpacing() {
        return leadSpacing;
    }

    /**
     * @param leadSpacing the leadSpacing to set
     */
    public void setLeadSpacing(String leadSpacing) {
        this.leadSpacing = leadSpacing;
    }
}
