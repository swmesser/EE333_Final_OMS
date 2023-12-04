package OMS;

import java.util.regex.Pattern;

/* 
 * File: SignalRelayInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class SignalRelayInfo extends RelayInfo{
    private String coilInsulation;
    private String contactForm;
    private String sealRating;
    private String contactMaterial;
    private String relayType;
    
    /**
     * Constructor for signal relay object initialization
     */
    public SignalRelayInfo(){
        super();
        this.coilInsulation = "";
        this.contactForm = "";
        this.sealRating = "";
        this.contactMaterial = "";
        this.relayType = "";
    }

    /**
     * Constructor for importing signal relay objects
     * @param coilInsulation
     * @param contactForm
     * @param sealRating
     * @param contactMaterial
     * @param relayType
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
    public SignalRelayInfo(String coilInsulation, String contactForm, String sealRating, String contactMaterial, String relayType, double contactCurrentRating, double mustOperateVolt, double mustReleaseVolt, double operateTime, double releaseTime, double operationTemp, double coilVoltage, String features, String terminationStyle, RelayMountingType mount, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(contactCurrentRating, mustOperateVolt, mustReleaseVolt, operateTime, releaseTime, operationTemp, coilVoltage, features, terminationStyle, mount, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        
        if (( coilInsulation == null) || ( coilInsulation.length() == 0 )){
            throw new Exception("Error: Invalid coil insulation passed!");
        } else if (( contactForm == null ) || ( contactForm.length() == 0 )){
            throw new Exception("Error: Invalid contact form passed!");
        } else if (( sealRating == null ) || ( sealRating.length() == 0 )){
            throw new Exception("Error: Invalid seal rating passed!");
        } else if (( contactMaterial == null ) || ( contactMaterial.length() == 0 )){
            throw new Exception("Error: Invalid contact material passed!");
        } else {
            this.coilInsulation = coilInsulation;
            this.contactForm = contactForm;
            this.sealRating = sealRating;
            this.contactMaterial = contactMaterial;
            this.relayType = relayType;
        }
    }
    
    /**
     * CSV formatting for signal relay object
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += this.getContactForm() + ",";
        output += this.getSealRating() + ",";
        output += this.getCoilInsulation() + ",";
        output += this.getContactMaterial() + ",";
        output += this.getRelayType() + "\n";
        
        return(output);
    }

    /**
     * XML formatting for signal relay object
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += super.toXML(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        output += "         <SignalRelayInfo>\n";
        output += "             <contactForm>" + this.getContactForm() + "</contactForm>\n";
        output += "             <sealRating>" + this.getSealRating() + "</sealRating>\n";
        output += "             <coilInsulation>" + this.getCoilInsulation() + "</coilInsulation>\n";
        output += "             <contactMaterial>" + this.getContactMaterial() + "</contactMaterial>\n";
        output += "             <relayType>" + this.getRelayType() + "</relayType>\n";
        output += "         </SignalRelayInfo>\n";
        output += "     </RelayInfo>\n";
        output += "</ProductInfo>\n";
        
        return(output);
    }

    /**
     * Importing CSV formatted signal relay object
     * @param input
     * @return 
     */
    public static SignalRelayInfo fromCSV( String input ) throws Exception{
        SignalRelayInfo signalRelay = null;
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
        //Relay
        double contactCurrentRating = 0.0;
        double mustOperateVolt = 0.0;
        double mustReleaseVolt = 0.0;
        double operateTime = 0.0;
        double releaseTime = 0.0;
        double operationTemp = 0.0;
        double coilVoltage = 0.0;
        String features = "";
        String terminationStyle = "";
        RelayMountingType mount = RelayMountingType.Unknown;
        //SignalRelay
        String contactForm;
        String sealRating;
        String coilInsulation;
        String contactMaterial;
        String relayType;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            Chunks = input.split(",");
            if ( Chunks.length == 28 ){
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
                //RelayInfo Params
                contactCurrentRating = Double.parseDouble(Chunks[ 13 ]);
                mustOperateVolt = Double.parseDouble(Chunks[ 14 ]);
                mustReleaseVolt = Double.parseDouble(Chunks[ 15 ]);
                operateTime = Double.parseDouble(Chunks[ 16 ]);
                releaseTime =  Double.parseDouble(Chunks[ 17 ]);
                features = Chunks[ 18 ];
                terminationStyle = Chunks[ 19 ];
                operationTemp = Double.parseDouble(Chunks[ 20 ]);
                coilVoltage = Double.parseDouble(Chunks[ 21 ]);
                mount = RelayMountingType.valueOf( Chunks[ 22 ] );
                //=================
                //SignalRelayInfo
                contactForm = Chunks[ 23 ];
                sealRating = Chunks[ 24 ];
                coilInsulation = Chunks[ 25 ];
                contactMaterial = Chunks[ 26 ];
                relayType = Chunks[ 27 ];
                
                //Parameter validation is in constructors
                signalRelay = new SignalRelayInfo(coilInsulation, contactForm, sealRating,
                        contactMaterial, relayType, contactCurrentRating, mustOperateVolt,
                        mustReleaseVolt, operateTime, releaseTime, operationTemp, coilVoltage,
                        features, terminationStyle, mount, id, name, description, manufacturer,
                        mfgPartNum, series, qtyAvailable, price);
            }
            
        }
        
        return signalRelay;
    }
    
    public static SignalRelayInfo fromXML( String input ) throws Exception{
        SignalRelayInfo signalRelay = null;
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
        //Relay
        double contactCurrentRating = 0.0;
        double mustOperateVolt = 0.0;
        double mustReleaseVolt = 0.0;
        double operateTime = 0.0;
        double releaseTime = 0.0;
        double operationTemp = 0.0;
        double coilVoltage = 0.0;
        String features = "";
        String terminationStyle = "";
        RelayMountingType mount = RelayMountingType.Unknown;
        //SignalRelay
        String contactForm = "";
        String sealRating = "";
        String coilInsulation = "";
        String contactMaterial = "";
        String relayType = "";
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
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

                    regex = Pattern.compile("<contactCurrentRating>(.*)</contactCurrentRating>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        contactCurrentRating = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<mustOperateVolt>(.*)</mustOperateVolt>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        mustOperateVolt = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<mustReleaseVolt>(.*)</mustReleaseVolt>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        mustReleaseVolt = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<operateTime>(.*)</operateTime>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        operateTime = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<releaseTime>(.*)</releaseTime>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        releaseTime = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<features>(.*)</featuresd>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        features = matcher.group(1);
                    }

                    regex = Pattern.compile("<terminationStyle>(.*)</terminationStyle>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        terminationStyle = matcher.group(1);
                    }

                    regex = Pattern.compile("<operationTemp>(.*)</operationTemp>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        operationTemp = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<coilVoltage>(.*)</coilVoltage>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        coilVoltage = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<mount>(.*)</mount>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        mount = RelayMountingType.valueOf(matcher.group(1));
                    }

                    regex = Pattern.compile("<contactForm>(.*)</contactForm>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        contactForm = matcher.group(1);
                    }

                    regex = Pattern.compile("<sealRating>(.*)</sealRating>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        sealRating = matcher.group(1);
                    }

                    regex = Pattern.compile("<coilInsulation>(.*)</coilInsulation>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        coilInsulation = matcher.group(1);
                    }

                    regex = Pattern.compile("<contactMaterial>(.*)</contactMaterial>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        contactMaterial = matcher.group(1);
                    }

                    regex = Pattern.compile("<relayType>(.*)</relayType>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        relayType = matcher.group(1);
                    }

                }
            }

            signalRelay = new SignalRelayInfo(coilInsulation, contactForm, sealRating, contactMaterial,
                    relayType, contactCurrentRating, mustOperateVolt, mustReleaseVolt, operateTime,
                    releaseTime, operationTemp, coilVoltage, features, terminationStyle, mount, id,
                    name, description, manufacturer, mfgPartNum, series, qtyAvailable, price);
        }
        
        return signalRelay;
    }
    
    /**
     * @return the contactForm
     */
    public String getContactForm() {
        return contactForm;
    }

    /**
     * @param contactForm the contactForm to set
     */
    public void setContactForm(String contactForm) {
        this.contactForm = contactForm;
    }

    /**
     * @return the sealRating
     */
    public String getSealRating() {
        return sealRating;
    }

    /**
     * @param sealRating the sealRating to set
     */
    public void setSealRating(String sealRating) {
        this.sealRating = sealRating;
    }

    /**
     * @return the coilInsulation
     */
    public String getCoilInsulation() {
        return coilInsulation;
    }

    /**
     * @param coilInsulation the coilInsulation to set
     */
    public void setCoilInsulation(String coilInsulation) {
        this.coilInsulation = coilInsulation;
    }

    /**
     * @return the contactMaterial
     */
    public String getContactMaterial() {
        return contactMaterial;
    }

    /**
     * @param contactMaterial the contactMaterial to set
     */
    public void setContactMaterial(String contactMaterial) {
        this.contactMaterial = contactMaterial;
    }

    /**
     * @return the relayType
     */
    public String getRelayType() {
        return relayType;
    }

    /**
     * @param relayType the relayType to set
     */
    public void setRelayType(String relayType) {
        this.relayType = relayType;
    }
}
