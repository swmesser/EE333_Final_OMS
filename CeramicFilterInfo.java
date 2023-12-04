package OMS;

/* 
 * File: CeramicFilterInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class CeramicFilterInfo extends FilterInfo{
    private double impedanceValue;
    
    /**
     * Constructor for init
     */
    public CeramicFilterInfo(){
        super();
        this.impedanceValue = 0.0;
    }

    /**
     * Constructor for import
     * @param impedanceValue
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
    public CeramicFilterInfo(double impedanceValue, int resonantFreq, int bandwidth, double size, double height, FilterType filterType, MountingTypeEnum mountingType, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(resonantFreq, bandwidth, size, height, filterType, mountingType, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        this.impedanceValue = impedanceValue;
    }

    /**
     * CSV format for export
     * @return 
     */
    public String toCSV(){
        String output = "";
        
        output += super.toCSV();
        output += this.impedanceValue + "\n";
        
        return output;
    }
    
    /**
     * XML format for export
     * @return 
     */
    public String toXML(){
        String output = "";
        
        output += super.toXML();
        output += "         <CeramicFilterInfo>\n";
        output += "             <impedanceValue>" + this.impedanceValue + "</impedanceValue>\n";
        output += "         </CeramicFilterInfo>\n";
        output += "     </FilterInfo>\n";
        output += "</ProductInfo>\n";
        
        return output;
    }
    
    public static CeramicFilterInfo fromCSV( String input ) throws Exception{
        CeramicFilterInfo ceramicFilter = null;
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
        //Filter
        int resonantFreq;
        int bandwidth;
        double size;
        double height;
        FilterType filterType;
        MountingTypeEnum mountingType;
        //Ceramic
        double impedanceValue;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            Chunks = input.split(",");
            
            if ( Chunks.length == 20){
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
                price = Double.parseDouble( Chunks[ 12 ]);
                //FilterInfo params
                resonantFreq = Integer.parseInt(Chunks[13]);
                bandwidth = Integer.parseInt(Chunks[14]);
                size = Double.parseDouble(Chunks[15]);
                height = Double.parseDouble(Chunks[16]);
                filterType = FilterType.valueOf(Chunks[17]);
                mountingType = MountingTypeEnum.valueOf(Chunks[18]);
                //Ceramic
                impedanceValue = Double.parseDouble(Chunks[19]);
                
                
            }
        }
        
        return ceramicFilter;
    }
    
    /**
     * @return the impedanceValue
     */
    public double getImpedanceValue() {
        return impedanceValue;
    }

    /**
     * @param impedanceValue the impedanceValue to set
     */
    public void setImpedanceValue(double impedanceValue) {
        this.impedanceValue = impedanceValue;
    }
    
    
    
}
