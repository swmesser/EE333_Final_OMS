package OMS;

import java.util.regex.Pattern;

/* 
 * File: RFFilterInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class RFFilterInfo extends FilterInfo{
    private double ripple;
    
    /**
     * Constructor for init 
     */
    public RFFilterInfo(){
        super();
        this.ripple = 0.0;
    }

    /**
     * Constructor for importing
     * @param ripple
     * @param resonantFreq
     * @param bandwidth
     * @param size
     * @param height
     * @param filterType
     * @param mountingType
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
    public RFFilterInfo(double ripple, int resonantFreq, int bandwidth, double size, double height, FilterType filterType, MountingTypeEnum mountingType, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(resonantFreq, bandwidth, size, height, filterType, mountingType, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        
        if ( ripple < 0.0 ){
            throw new Exception("Error: Invalid ripple passed!");
        } else {
            this.ripple = ripple;
        }
    }
    
    /**
     * CSV format for export
     * @return 
     */
    public String toCSV(){
        String output = "";
        
        output += super.toCSV();
        output += this.ripple + "\n";
        
        return output;
    }
    
    public String toXML(){
        String output = "";
        
        output += super.toXML();
        output += "         <RFFilterInfo>\n";
        output += "             <ripple>" + this.ripple + "</ripple>\n";
        output += "         </RFFilterInfo>\n";
        output += "     </FilterInfo>\n";
        output += "</ProductInfo>\n";
        
        return output;
    }

    /**
     * Import for CSV format
     * @param input
     * @return
     * @throws Exception 
     */
    public static RFFilterInfo fromCSV( String input ) throws Exception{
        RFFilterInfo rfFilter = null;
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
        //FilterInfo
        int resonantFreq = 0; 
        int bandwidth = 0;
        double size = 0.0;
        double height = 0.0;
        FilterType filterType;
        MountingTypeEnum mountingType;
        //RFFilter
        double ripple = 0.0;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            Chunks = input.split(",");
            
            if ( Chunks.length == 20 ){
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
                //FilterInfo Params
                resonantFreq = Integer.parseInt(Chunks[13]);
                bandwidth = Integer.parseInt(Chunks[14]);
                size = Double.parseDouble(Chunks[15]);
                height = Double.parseDouble(Chunks[16]);
                filterType = FilterType.valueOf(Chunks[17]);
                mountingType = MountingTypeEnum.valueOf(Chunks[18]);
                //==================
                //RFFilterInfo params
                ripple = Double.parseDouble(Chunks[19]);
                
                rfFilter = new RFFilterInfo(ripple, resonantFreq, bandwidth, size, height,
                        filterType, mountingType, id, name, description, manufacturer, mfgPartNum, series, bandwidth, price);
            }
        }
        
        return rfFilter;
    }
    
    public static RFFilterInfo fromXML( String input ) throws Exception {
        RFFilterInfo rfFilter = null;
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
        //FilterInfo
        int resonantFreq = 0; 
        int bandwidth = 0;
        double size = 0.0;
        double height = 0.0;
        FilterType filterType = FilterType.Unknown;
        MountingTypeEnum mountingType = MountingTypeEnum.Unknown;
        //RFFilter
        double ripple = 0.0;
        
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

                    regex = Pattern.compile("<resonantFreq>(.*)</resonantFreq>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        resonantFreq = Integer.parseInt(matcher.group(1));
                    }

                    regex = Pattern.compile("<bandwidth>(.*)</bandwidth>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        bandwidth = Integer.parseInt(matcher.group(1));
                    }

                    regex = Pattern.compile("<size>(.*)</size>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        size = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<height>(.*)</height>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        height = Double.parseDouble(matcher.group(1));
                    }

                    regex = Pattern.compile("<filterType>(.*)</filterType>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        filterType = FilterType.valueOf(matcher.group(1));
                    }

                    regex = Pattern.compile("<mountingType>(.*)</mountingType>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        mountingType = MountingTypeEnum.valueOf(matcher.group(1));
                    }

                    regex = Pattern.compile("<ripple>(.*)</ripple>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        ripple = Double.parseDouble(matcher.group(1));
                    }

                    rfFilter = new RFFilterInfo(ripple, resonantFreq, bandwidth, size,
                            height, filterType, mountingType, id, name, description, manufacturer,
                            mfgPartNum, series, qtyAvailable, price);
                }
        }
    }
        
        return rfFilter;
}
    
    /**
     * @return the ripple
     */
    public double getRipple() {
        return ripple;
    }

    /**
     * @param ripple the ripple to set
     */
    public void setRipple(double ripple) {
        this.ripple = ripple;
    }
    
    
    
}
