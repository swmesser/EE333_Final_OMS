package OMS;

import java.util.regex.Pattern;

/* 
 * File: NetworksAndArraysInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class NetworksAndArraysInfo extends CapacitorInfo{
    private int capacitorCount;
    private String tempCoefficient;
    private String supplierDevicePackage;
    private CapacitorRatings rating;
    private CapacitorCircuitType circuit;

    /**
     * Constructor used for initialization of networks object
     */
    public NetworksAndArraysInfo() {
        this.capacitorCount = 0;
        this.tempCoefficient = "";
        this.supplierDevicePackage = "";
        this.rating = CapacitorRatings.Unknown;
        this.circuit = CapacitorCircuitType.Unknown;
    }

    /**
     * Constructor used for importing networks object
     * @param capacitorCount
     * @param tempCoefficient
     * @param supplierDevicePackage
     * @param rating
     * @param circuit
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
    public NetworksAndArraysInfo(int capacitorCount, String tempCoefficient, String supplierDevicePackage, CapacitorRatings rating, CapacitorCircuitType circuit, double capacitance, double tolerance, double voltageRating, double operationTemp, String size, String dielectricMat, CapacitorMountingType mount, String packageCase, String seatedHeight, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(capacitance, tolerance, voltageRating, operationTemp, size, dielectricMat, mount, packageCase, seatedHeight, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        
        if ( capacitorCount < 0 ){
            throw new Exception("Error: Invalid capacitor count passed!");
        } else if ((tempCoefficient.length() == 0) || (tempCoefficient == null)){
            throw new Exception("Error: Invalid temperature coefficient passed!");
        } else if ((supplierDevicePackage.length() == 0) || (supplierDevicePackage == null)){
            throw new Exception("Error: Invalid supplier device package passed!");
        } else {
            this.capacitorCount = capacitorCount;
            this.tempCoefficient = tempCoefficient;
            this.supplierDevicePackage = supplierDevicePackage;
            this.rating = rating;
            this.circuit = circuit;
        }
    }
    
    /**
     * CSV formatting of network objects
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getCapacitorCount() + ",";
        output += this.getTempCoefficient() + ",";
        output += this.getSupplierDevicePackage() + ",";
        output += this.getRating() + ",";
        output += this.getCircuit() + "\n";
        
        return(output);
    }

    /**
     * XML formatting of network objects
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "         <NetworksAndArraysInfo>\n";
        output += "             <capacitorCount>" + this.getCapacitorCount() + "</capacitorCount>\n";
        output += "             <tempCoefficient>" + this.getTempCoefficient() + "</tempCoefficient>\n";
        output += "             <supplierDevicePackage>" + this.getSupplierDevicePackage() + "</supplierDevicePackage>\n";
        output += "             <rating>" + this.getRating() + "</rating>\n";
        output += "             <circuit>" + this.getCircuit() + "</circuit>\n";
        output += "         </NetworksAndArraysInfo>\n";
        output += "     </CapacitorInfo>\n";
        output += "</ProductInfo>\n";
        
        return(output);
    }
    
    public static NetworksAndArraysInfo fromCSV( String input ) throws Exception{
        NetworksAndArraysInfo networkAndArray = new NetworksAndArraysInfo();
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
        CapacitorMountingType mount = CapacitorMountingType.Unknown;
        String packageCase = "";
        String seatedHeight = "";
        //NetworkAndArray
        int capacitorCount = 0;
        String tempCoefficient = "";
        String supplierDevicePackage = "";
        CapacitorRatings rating = CapacitorRatings.Unknown;
        CapacitorCircuitType circuit = CapacitorCircuitType.Unknown;
        
        //Validate input 
        if ( input == null ){
            throw new Exception("Error: Null input for parsing!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length string provided!");
        } else {
            //Split line based on comma
            Chunks = input.split(",");
            if ( Chunks.length == 27 ){
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
                //NetworkAndArray
                capacitorCount = Integer.valueOf( Chunks[ 22 ]);
                tempCoefficient = Chunks[ 23 ];
                supplierDevicePackage = Chunks[ 24 ];
                rating = CapacitorRatings.valueOf( Chunks[ 25 ]);
                circuit = CapacitorCircuitType.valueOf( Chunks[ 26 ]);
                
                //Param Validation -> constructor
                networkAndArray = new NetworksAndArraysInfo(capacitorCount, tempCoefficient, supplierDevicePackage,
                        rating, circuit, capacitance, tolerance, voltageRating, operationTemp, size, dielectricMat,
                        mount, packageCase, seatedHeight, id, name, description, manufacturer, mfgPartNum, series,
                        qtyAvailable, price);
            }
        }
        
        return networkAndArray;
    }
    
    public static NetworksAndArraysInfo fromXML( String input ) throws Exception{
        NetworksAndArraysInfo networkAndArray = new NetworksAndArraysInfo();
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
        //NetworkAndArray
        int capacitorCount = 0;
        String tempCoefficient = "";
        String supplierDevicePackage = "";
        CapacitorRatings rating = CapacitorRatings.Unknown;
        CapacitorCircuitType circuit = CapacitorCircuitType.Unknown;
        
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

                    regex = Pattern.compile("<capacitorCount>(.*)</capacitorCount>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        capacitorCount = Integer.parseInt(matcher.group(1));
                    }

                    regex = Pattern.compile("<tempCoefficient>(.*)</tempCoefficient>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        tempCoefficient = matcher.group(1);
                    }

                    regex = Pattern.compile("<supplierDevicePackage>(.*)</supplierDevicePackage>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        supplierDevicePackage = matcher.group(1);
                    }

                    regex = Pattern.compile("<rating>(.*)</rating>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        rating = CapacitorRatings.valueOf(matcher.group(1));
                    }

                    regex = Pattern.compile("<circuit>(.*)</circuit>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        circuit = CapacitorCircuitType.valueOf(matcher.group(1));
                    }

                    networkAndArray = new NetworksAndArraysInfo(capacitorCount, tempCoefficient, supplierDevicePackage,
                            rating, circuit, capacitance, tolerance, voltageRating, operationTemp, size, dielectricMat,
                            mount, packageCase, seatedHeight, id, name, description, id, mfgPartNum, series, index, price);

                }
            }
        }
        
        return( networkAndArray );
    }

    /**
     * @return the capacitorCount
     */
    public int getCapacitorCount() {
        return capacitorCount;
    }

    /**
     * @param capacitorCount the capacitorCount to set
     */
    public void setCapacitorCount(int capacitorCount) {
        this.capacitorCount = capacitorCount;
    }

    /**
     * @return the tempCoefficient
     */
    public String getTempCoefficient() {
        return tempCoefficient;
    }

    /**
     * @param tempCoefficient the tempCoefficient to set
     */
    public void setTempCoefficient(String tempCoefficient) {
        this.tempCoefficient = tempCoefficient;
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

    /**
     * @return the rating
     */
    public CapacitorRatings getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(CapacitorRatings rating) {
        this.rating = rating;
    }

    /**
     * @return the circuit
     */
    public CapacitorCircuitType getCircuit() {
        return circuit;
    }

    /**
     * @param circuit the circuit to set
     */
    public void setCircuit(CapacitorCircuitType circuit) {
        this.circuit = circuit;
    }
}
