package OMS;

import java.util.regex.Pattern;

/* 
 * File: FixedInductorInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class FixedInductorInfo extends InductorCoilAndChokesInfo{
    private String coreMaterial;
    private double inductance;
    private double currentRating;
    private double currentSaturation;
    private String inductorType;
    private FixedInductorShielding shielding;
    private double dcResistance;
    private String qAtFreq;
    private double selfResonantFreq;
    private InductorRating rating;
    private double operatingTemp;
    private String inductanceFreqTest;
    private String features;
    private String supplierDevicePackage;
    private String size;
    private String seatedHeight;

    /**
     * Constructor for init
     */
    public FixedInductorInfo(){
        super();
        this.coreMaterial = "";
        this.inductance = 0.0;
        this.currentRating = 0.0;
        this.currentSaturation = 0.0;
        this.inductorType = "";
        this.shielding = FixedInductorShielding.Unknown;
        this.dcResistance = 0.0;
        this.qAtFreq = "";
        this.selfResonantFreq = 0.0;
        this.rating = InductorRating.Unknown;
        this.operatingTemp = 0.0;
        this.inductanceFreqTest = "";
        this.features = "";
        this.supplierDevicePackage = "";
        this.size = "";
        this.seatedHeight = "";
    }

    /**
     * Constructor for import
     * @param coreMaterial
     * @param inductance
     * @param currentRating
     * @param currentSaturation
     * @param inductorType
     * @param shielding
     * @param dcResistance
     * @param qAtFreq
     * @param selfResonantFreq
     * @param rating
     * @param operatingTemp
     * @param inductanceFreqTest
     * @param features
     * @param supplierDevicePackage
     * @param size
     * @param seatedHeight
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
    public FixedInductorInfo(String coreMaterial, double inductance, double currentRating, double currentSaturation, String inductorType, FixedInductorShielding shielding, double dcResistance, String qAtFreq, double selfResonantFreq, InductorRating rating, double operatingTemp, String inductanceFreqTest, String features, String supplierDevicePackage, String size, String seatedHeight, double tolerance, InductorMountingType mount, String packageCase, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(tolerance, mount, packageCase, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        this.coreMaterial = coreMaterial;
        this.inductance = inductance;
        this.currentRating = currentRating;
        this.currentSaturation = currentSaturation;
        this.inductorType = inductorType;
        this.shielding = shielding;
        this.dcResistance = dcResistance;
        this.qAtFreq = qAtFreq;
        this.selfResonantFreq = selfResonantFreq;
        this.rating = rating;
        this.operatingTemp = operatingTemp;
        this.inductanceFreqTest = inductanceFreqTest;
        this.features = features;
        this.supplierDevicePackage = supplierDevicePackage;
        this.size = size;
        this.seatedHeight = seatedHeight;
    }
    
    /**
     * CSV format for export
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getCoreMaterial() + ",";
        output += this.getInductance() + ",";
        output += this.getCurrentRating() + ",";
        output += this.getCurrentSaturation() + ",";
        output += this.getInductorType() + ",";
        output += this.getShielding() + ",";
        output += this.getDcResistance() + ",";
        output += this.getqAtFreq() + ",";
        output += this.getSelfResonantFreq() + ",";
        output += this.getRating() + ",";
        output += this.getOperatingTemp() + ",";
        output += this.getInductanceFreqTest() + ",";
        output += this.getFeatures() + ",";
        output += this.getSupplierDevicePackage() + ",";
        output += this.getSize() + ",";
        output += this.getSeatedHeight() + "\n";
        
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
        output += "         <FixedInductorInfo>\n";
        output += "             <coreMaterial>" + this.getCoreMaterial() + "</coreMaterial>\n";
        output += "             <inductance>" + this.getInductance() + "</inductance>\n";
        output += "             <currentRating>" + this.getCurrentRating() + "</currentRating>\n";
        output += "             <currentSaturation>" + this.getCurrentSaturation() + "</currentSaturation>\n";
        output += "             <inductorType>" + this.getInductorType() + "</inductorType>\n";
        output += "             <shielding>" + this.getShielding() + "</shielding>\n";
        output += "             <dcResistance>" + this.getDcResistance() + "</dcResistance>\n";
        output += "             <qAtFreq>" + this.getqAtFreq() + "</qAtFreq>\n";
        output += "             <selfResonantFreq>" + this.getSelfResonantFreq() + "</selfResonantFreq>\n";
        output += "             <rating>" + this.getRating() + "</rating>\n";
        output += "             <operatingTemp>" + this.getOperatingTemp() + "</operatingTemp>\n";
        output += "             <inductanceFreqTest>" + this.getInductanceFreqTest() + "</inductanceFreqTest>\n";
        output += "             <features>" + this.getFeatures() + "</features>\n";
        output += "             <supplierDevicePackage>" + this.getSupplierDevicePackage() + "</supplierDevicePackage>\n";
        output += "             <size>" + this.getSize() + "</size>\n";
        output += "             <seatedHeight>" + this.getSeatedHeight() + "</seatedHeight>\n";
        output += "         </FixedInductorInfo>\n";
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
    public static FixedInductorInfo fromCSV( String input ) throws Exception {
        FixedInductorInfo fixedInductor = new FixedInductorInfo();
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
        //FixedInductor
        String coreMaterial;
        double inductance;
        double currentRating;
        double currentSaturation;
        String inductorType;
        FixedInductorShielding shielding;
        double dcResistance;
        String qAtFreq;
        double selfResonantFreq;
        InductorRating rating;
        double operatingTemp;
        String inductanceFreqTest;
        String features;
        String supplierDevicePackage;
        String size;
        String seatedHeight;
        
        
        //Validate input 
        if ( input == null ){
            throw new Exception("Error: Null input for parsing!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length string provided!");
        } else {
            //Split line based on comma
            Chunks = input.split(",");
            if ( Chunks.length == 32 ){
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
                //FixedInductorInfo
                coreMaterial = Chunks[ 16 ];
                inductance = Double.parseDouble(Chunks[ 18 ]);
                currentRating = Double.parseDouble(Chunks[ 18 ]);
                currentSaturation = Double.parseDouble(Chunks[ 19 ]);
                inductorType = Chunks[ 20 ];
                shielding = FixedInductorShielding.valueOf( Chunks[ 21 ]);
                dcResistance = Double.parseDouble(Chunks[ 22 ]);
                qAtFreq = Chunks[ 23 ];
                selfResonantFreq = Double.parseDouble(Chunks[ 24 ]);
                rating = InductorRating.valueOf( Chunks[ 25 ]);
                operatingTemp = Double.parseDouble(Chunks[ 26 ]);
                inductanceFreqTest = Chunks[ 27 ];
                features = Chunks[ 28 ];
                supplierDevicePackage = Chunks[ 329 ];
                size = Chunks[ 30 ];
                seatedHeight = Chunks[ 31 ];
                
                fixedInductor = new FixedInductorInfo(coreMaterial, inductance, currentRating,
                        currentSaturation, inductorType, shielding, dcResistance, qAtFreq, 
                        selfResonantFreq, rating, operatingTemp, inductanceFreqTest, features,
                        supplierDevicePackage, size, seatedHeight, tolerance, mount, packageCase,
                        id, name, description, manufacturer, mfgPartNum, series, qtyAvailable, price);
            }
        }
        return( fixedInductor );
    }
    
    /**
     * XML format for import
     * @param input
     * @return
     * @throws Exception 
     */
    public static FixedInductorInfo fromXML( String input ) throws Exception {
        FixedInductorInfo fixedInductor = new FixedInductorInfo();
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
        //FixedInductor
        String coreMaterial = "";
        double inductance = 0.0;
        double currentRating = 0.0;
        double currentSaturation = 0.0;
        String inductorType = "";
        FixedInductorShielding shielding = FixedInductorShielding.Unknown;
        double dcResistance = 0.0;
        String qAtFreq = "";
        double selfResonantFreq = 0.0;
        InductorRating rating = InductorRating.Unknown;
        double operatingTemp = 0.0;
        String inductanceFreqTest = "";
        String features = "";
        String supplierDevicePackage = "";
        String size = "";
        String seatedHeight = "";
        
        
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
                
                regex = Pattern.compile("<coreMaterial>(.*)</coreMaterial>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    coreMaterial = matcher.group(1);
                }
                
                regex = Pattern.compile("<inductance>(.*)</inductance>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    inductance = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<currentRating>(.*)</currentRating>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    currentRating = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<currentSaturation>(.*)</currentSaturation>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    currentSaturation = Double.parseDouble(matcher.group(1));
                }
                
                regex = Pattern.compile("<inductorType>(.*)</inductorType>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    inductorType = matcher.group(1);
                }
                
                regex = Pattern.compile("<shielding>(.*)</shielding>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    shielding = FixedInductorShielding.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<dcResistance>(.*)</dcResistance>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    dcResistance = Double.parseDouble(matcher.group(1));
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
                
                regex = Pattern.compile("<rating>(.*)</rating>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    rating = InductorRating.valueOf(matcher.group(1));
                }
                
                regex = Pattern.compile("<operatingTemp>(.*)</operatingTemp>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    packageCase = matcher.group(1);
                }
                
                regex = Pattern.compile("<inductanceFreqTest>(.*)</inductanceFreqTest>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    inductanceFreqTest = matcher.group(1);
                }
                
                regex = Pattern.compile("<features>(.*)</features>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    features = matcher.group(1);
                }
                
                regex = Pattern.compile("<supplierDevicePackage>(.*)</supplierDevicePackage>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    supplierDevicePackage = matcher.group(1);
                }
                
                regex = Pattern.compile("<size>(.*)</size>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    size = matcher.group(1);
                }
                
                regex = Pattern.compile("<seatedHeight>(.*)</seatedHeight>");
                matcher = regex.matcher(input);
                if ( matcher.find() == true ){
                    seatedHeight = matcher.group(1);
                }
                
                fixedInductor = new FixedInductorInfo(coreMaterial, inductance, currentRating,
                        currentSaturation, inductorType, shielding, dcResistance, qAtFreq,
                        selfResonantFreq, rating, operatingTemp, inductanceFreqTest, features,
                        supplierDevicePackage, size, seatedHeight, tolerance, mount,
                        packageCase, id, name, description, manufacturer, mfgPartNum, series, qtyAvailable, price);
            }
        }
        
        return (fixedInductor);
    }
    
    /**
     * @return the coreMaterial
     */
    public String getCoreMaterial() {
        return coreMaterial;
    }

    /**
     * @param coreMaterial the coreMaterial to set
     */
    public void setCoreMaterial(String coreMaterial) {
        this.coreMaterial = coreMaterial;
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
     * @return the currentSaturation
     */
    public double getCurrentSaturation() {
        return currentSaturation;
    }

    /**
     * @param currentSaturation the currentSaturation to set
     */
    public void setCurrentSaturation(double currentSaturation) {
        this.currentSaturation = currentSaturation;
    }

    /**
     * @return the inductorType
     */
    public String getInductorType() {
        return inductorType;
    }

    /**
     * @param inductorType the inductorType to set
     */
    public void setInductorType(String inductorType) {
        this.inductorType = inductorType;
    }

    /**
     * @return the shielding
     */
    public FixedInductorShielding getShielding() {
        return shielding;
    }

    /**
     * @param shielding the shielding to set
     */
    public void setShielding(FixedInductorShielding shielding) {
        this.shielding = shielding;
    }

    /**
     * @return the dcResistance
     */
    public double getDcResistance() {
        return dcResistance;
    }

    /**
     * @param dcResistance the dcResistance to set
     */
    public void setDcResistance(double dcResistance) {
        this.dcResistance = dcResistance;
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
     * @return the inductanceFreqTest
     */
    public String getInductanceFreqTest() {
        return inductanceFreqTest;
    }

    /**
     * @param inductanceFreqTest the inductanceFreqTest to set
     */
    public void setInductanceFreqTest(String inductanceFreqTest) {
        this.inductanceFreqTest = inductanceFreqTest;
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
