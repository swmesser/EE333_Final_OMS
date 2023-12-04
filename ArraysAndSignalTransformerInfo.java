package OMS;

import java.util.regex.Pattern;

/* 
 * File: ArraysAndSignalTransformerInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class ArraysAndSignalTransformerInfo extends InductorCoilAndChokesInfo {
    private int coilNumber;
    private double parallelInductance;
    private double seriesInductance;
    private double parallelCurrentRating;
    private double seriesCurrentRating;
    private double parallelCurrentSaturation;
    private double seriesCurrentSaturation;
    private double parallelDCResistance;
    private double seriesDCResistance;
    private double operatingTemp;
    private ArrayInductorShielding shielding;
    private InductorRating rating;
    private String height;
    private String size;

    /**
     * Constructor for init
     */
    public ArraysAndSignalTransformerInfo(){
        super();
        this.coilNumber = 0;
        this.parallelInductance = 0.0;
        this.seriesInductance = 0.0;
        this.parallelCurrentRating = 0.0;
        this.seriesCurrentRating = 0.0;
        this.parallelCurrentSaturation = 0.0;
        this.seriesCurrentSaturation = 0.0;
        this.parallelDCResistance = 0.0;
        this.seriesDCResistance = 0.0;
        this.operatingTemp = 0.0;
        this.shielding = ArrayInductorShielding.Unknown;
        this.rating = InductorRating.Unknown;
        this.height = "";
        this.size = "";
    }

    /**
     * Constructor for importing
     * @param coilNumber
     * @param parallelInductance
     * @param seriesInductance
     * @param parallelCurrentRating
     * @param seriesCurrentRating
     * @param parallelCurrentSaturation
     * @param seriesCurrentSaturation
     * @param parallelDCResistance
     * @param seriesDCResistance
     * @param operatingTemp
     * @param shielding
     * @param rating
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
    public ArraysAndSignalTransformerInfo(int coilNumber, double parallelInductance, double seriesInductance, double parallelCurrentRating, double seriesCurrentRating, double parallelCurrentSaturation, double seriesCurrentSaturation, double parallelDCResistance, double seriesDCResistance, double operatingTemp, ArrayInductorShielding shielding, InductorRating rating, String height, String size, double tolerance, InductorMountingType mount, String packageCase, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(tolerance, mount, packageCase, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        this.coilNumber = coilNumber;
        this.parallelInductance = parallelInductance;
        this.seriesInductance = seriesInductance;
        this.parallelCurrentRating = parallelCurrentRating;
        this.seriesCurrentRating = seriesCurrentRating;
        this.parallelCurrentSaturation = parallelCurrentSaturation;
        this.seriesCurrentSaturation = seriesCurrentSaturation;
        this.parallelDCResistance = parallelDCResistance;
        this.seriesDCResistance = seriesDCResistance;
        this.operatingTemp = operatingTemp;
        this.shielding = shielding;
        this.rating = rating;
        this.height = height;
        this.size = size;
    }

    /**
     * CSV format for export
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.coilNumber + ",";
        output += this.parallelInductance + ",";
        output += this.seriesInductance + ",";
        output += this.parallelCurrentRating + ",";
        output += this.seriesCurrentRating + ",";
        output += this.parallelCurrentSaturation + ",";
        output += this.seriesCurrentSaturation + ",";
        output += this.parallelDCResistance + ",";
        output += this.seriesDCResistance + ",";
        output += this.operatingTemp + ",";
        output += this.shielding + ",";
        output += this.rating + ",";
        output += this.height + ",";
        output += this.size + "\n";
        
        return(output);
    }

    /**
     * XML format for export
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "         <ArraysAndSignalTransformerInfo>\n";
        output += "             <coilNumber>" + this.getCoilNumber() + "</coilNumber>\n";
        output += "             <parallelInductance>" + this.getParallelInductance() + "</parallelInductance>\n";
        output += "             <seriesInductance>" + this.getSeriesInductance() + "</seriesInductance>\n";
        output += "             <parallelCurrentRating>" + this.getParallelCurrentRating() + "</parallelCurrentRating>\n";
        output += "             <seriesCurrentRating>" + this.getSeriesCurrentRating() + "</seriesCurrentRating>\n";
        output += "             <parallelCurrentSaturation>" + this.getParallelCurrentSaturation() + "</parallelCurrentSaturation>\n";
        output += "             <seriesCurrentSaturation>" + this.getSeriesCurrentSaturation() + "</seriesCurrentSaturation>\n";
        output += "             <parallelDCResistance>" + this.getParallelDCResistance() + "</parallelDCResistance>\n";
        output += "             <seriesDCResistance>" + this.getSeriesDCResistance() + "</seriesDCResistance>\n";
        output += "             <operatingTemp>" + this.getOperatingTemp() + "</operatingTemp>\n";
        output += "             <shielding>" + this.getShielding() + "</shielding>\n";
        output += "             <rating>" + this.getRating() + "</rating>\n";
        output += "             <height>" + this.getHeight() + "</height>\n";
        output += "             <size>" + this.getSize() + "</size>\n";
        output += "         </ArraysAndSignalTransformerInfo>\n";
        output += "     </InductorCoilAndChokesInfo>\n";
        output += "</ProductInfo>\n";
        
        return(output);
    }

    /**
     * Importing CSV format
     * @param input
     * @return
     * @throws Exception 
     */
    public static ArraysAndSignalTransformerInfo fromCSV( String input ) throws Exception {
        ArraysAndSignalTransformerInfo arraysAndSignalTransformer = new ArraysAndSignalTransformerInfo();
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
        //ArraysAndSignalTransformer
        int coilNumber;
        double parallelInductance;
        double seriesInductance;
        double parallelCurrentRating;
        double seriesCurrentRating;
        double parallelCurrentSaturation;
        double seriesCurrentSaturation;
        double parallelDCResistance;
        double seriesDCResistance;
        double operatingTemp;
        ArrayInductorShielding shielding;
        InductorRating rating;
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
            if ( Chunks.length == 30 ){
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
                //ArraysAndSignalsTranformerInfo Params
                coilNumber = Integer.parseInt( Chunks[ 16 ]);
                parallelInductance = Double.parseDouble(Chunks[ 17 ]);
                seriesInductance = Double.parseDouble(Chunks[ 18 ]);
                parallelCurrentRating = Double.parseDouble(Chunks[ 19 ]);
                seriesCurrentRating = Double.parseDouble(Chunks[ 20 ]);
                parallelCurrentSaturation = Double.parseDouble(Chunks[ 21 ]);
                seriesCurrentSaturation = Double.parseDouble(Chunks[ 22 ]);
                parallelDCResistance = Double.parseDouble(Chunks[ 23 ]);
                seriesDCResistance = Double.parseDouble(Chunks[ 24 ]);
                operatingTemp = Double.parseDouble(Chunks[ 25 ]);
                shielding = ArrayInductorShielding.valueOf( Chunks[ 26 ] );
                rating = InductorRating.valueOf( Chunks[ 27 ] );
                height = Chunks[ 28 ];
                size = Chunks[ 29 ];
                
                arraysAndSignalTransformer = new ArraysAndSignalTransformerInfo(coilNumber, parallelInductance, seriesInductance,
                        parallelCurrentRating, seriesCurrentRating, parallelCurrentSaturation, seriesCurrentSaturation,
                        parallelDCResistance, seriesDCResistance, operatingTemp, shielding, rating,
                        height, size, tolerance, mount, packageCase, id, name, description,
                        manufacturer, mfgPartNum, series, qtyAvailable, price);
            }
        }
        
        return( arraysAndSignalTransformer );
    }
    
    /**
     * XML format for importing
     * @param input
     * @return
     * @throws Exception 
     */
    public static ArraysAndSignalTransformerInfo fromXML( String input ) throws Exception {
        ArraysAndSignalTransformerInfo arraysAndSignalTransformer = new ArraysAndSignalTransformerInfo();
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
        //ArraysAndSignalTransformer
        int coilNumber = 0;
        double parallelInductance = 0.0;
        double seriesInductance = 0.0;
        double parallelCurrentRating = 0.0;
        double seriesCurrentRating = 0.0;
        double parallelCurrentSaturation = 0.0;
        double seriesCurrentSaturation = 0.0;
        double parallelDCResistance = 0.0;
        double seriesDCResistance = 0.0;
        double operatingTemp = 0.0;
        ArrayInductorShielding shielding = ArrayInductorShielding.Unknown;
        InductorRating rating = InductorRating.Unknown;
        String height = "";
        String size = "";
        
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

                    regex = Pattern.compile("<coilNumber>(.*)</coilNumber>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        coilNumber = Integer.parseInt( matcher.group(1));
                    }

                    regex = Pattern.compile("<parallelInductance>(.*)</parallelInductance>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        parallelInductance = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<seriesInductance>(.*)</seriesInductance>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        seriesInductance = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<parallelCurrentRating>(.*)</parallelCurrentRating>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        parallelCurrentRating = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<seriesCurrentRating>(.*)</seriesCurrentRating>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        seriesCurrentRating = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<parallelCurrentSaturation>(.*)</parallelCurrentSaturation>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        parallelCurrentSaturation = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<seriesCurrentSaturation>(.*)</seriesCurrentSaturation>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        seriesCurrentSaturation = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<parallelDCResistance>(.*)</parallelDCResistance>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        parallelDCResistance = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<seriesDCResistance>(.*)</seriesDCResistance>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        seriesDCResistance = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<operatingTemp>(.*)</operatingTemp>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        operatingTemp = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<shielding>(.*)</shielding>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        shielding = ArrayInductorShielding.valueOf(matcher.group(1));
                    }

                    regex = Pattern.compile("<rating>(.*)</rating>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        rating = InductorRating.valueOf(matcher.group(1));
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

                    arraysAndSignalTransformer = new ArraysAndSignalTransformerInfo(coilNumber,
                            parallelInductance, seriesInductance, parallelCurrentRating, seriesCurrentRating,
                            parallelCurrentSaturation, seriesCurrentSaturation, parallelDCResistance, 
                            seriesDCResistance, operatingTemp, shielding, rating, height, size, tolerance, 
                            mount, packageCase, id, name, description, manufacturer, mfgPartNum, series, qtyAvailable, price);

                    }
            
                }
            }
        
        
        return (arraysAndSignalTransformer);
    }
    
    /**
     * @return the coilNumber
     */
    public int getCoilNumber() {
        return coilNumber;
    }

    /**
     * @param coilNumber the coilNumber to set
     */
    public void setCoilNumber(int coilNumber) {
        this.coilNumber = coilNumber;
    }

    /**
     * @return the parallelInductance
     */
    public double getParallelInductance() {
        return parallelInductance;
    }

    /**
     * @param parallelInductance the parallelInductance to set
     */
    public void setParallelInductance(double parallelInductance) {
        this.parallelInductance = parallelInductance;
    }

    /**
     * @return the seriesInductance
     */
    public double getSeriesInductance() {
        return seriesInductance;
    }

    /**
     * @param seriesInductance the seriesInductance to set
     */
    public void setSeriesInductance(double seriesInductance) {
        this.seriesInductance = seriesInductance;
    }

    /**
     * @return the parallelCurrentRating
     */
    public double getParallelCurrentRating() {
        return parallelCurrentRating;
    }

    /**
     * @param parallelCurrentRating the parallelCurrentRating to set
     */
    public void setParallelCurrentRating(double parallelCurrentRating) {
        this.parallelCurrentRating = parallelCurrentRating;
    }

    /**
     * @return the seriesCurrentRating
     */
    public double getSeriesCurrentRating() {
        return seriesCurrentRating;
    }

    /**
     * @param seriesCurrentRating the seriesCurrentRating to set
     */
    public void setSeriesCurrentRating(double seriesCurrentRating) {
        this.seriesCurrentRating = seriesCurrentRating;
    }

    /**
     * @return the parallelCurrentSaturation
     */
    public double getParallelCurrentSaturation() {
        return parallelCurrentSaturation;
    }

    /**
     * @param parallelCurrentSaturation the parallelCurrentSaturation to set
     */
    public void setParallelCurrentSaturation(double parallelCurrentSaturation) {
        this.parallelCurrentSaturation = parallelCurrentSaturation;
    }

    /**
     * @return the seriesCurrentSaturation
     */
    public double getSeriesCurrentSaturation() {
        return seriesCurrentSaturation;
    }

    /**
     * @param seriesCurrentSaturation the seriesCurrentSaturation to set
     */
    public void setSeriesCurrentSaturation(double seriesCurrentSaturation) {
        this.seriesCurrentSaturation = seriesCurrentSaturation;
    }

    /**
     * @return the parallelDCResistance
     */
    public double getParallelDCResistance() {
        return parallelDCResistance;
    }

    /**
     * @param parallelDCResistance the parallelDCResistance to set
     */
    public void setParallelDCResistance(double parallelDCResistance) {
        this.parallelDCResistance = parallelDCResistance;
    }

    /**
     * @return the seriesDCResistance
     */
    public double getSeriesDCResistance() {
        return seriesDCResistance;
    }

    /**
     * @param seriesDCResistance the seriesDCResistance to set
     */
    public void setSeriesDCResistance(double seriesDCResistance) {
        this.seriesDCResistance = seriesDCResistance;
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
     * @return the shielding
     */
    public ArrayInductorShielding getShielding() {
        return shielding;
    }

    /**
     * @param shielding the shielding to set
     */
    public void setShielding(ArrayInductorShielding shielding) {
        this.shielding = shielding;
    }

    /**
     * @return the rating
     */
    public InductorRating getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(InductorRating rating) {
        this.rating = rating;
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
