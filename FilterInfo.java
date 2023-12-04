package OMS;

/* 
 * File: FilterInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 30, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public abstract class FilterInfo extends ProductInfo {
    private int resonantFreq;
    private int bandwidth;
    private double size;
    private double height;
    private FilterType filterType;
    private MountingTypeEnum mountingType;
    
    /**
     * Constructor for filter object init
     */
    public FilterInfo(){
        super();
        this.resonantFreq = 0;
        this.bandwidth = 0;
        this.size = 0.0;
        this.height = 0.0;
        this.filterType = FilterType.Unknown;
        this.mountingType = MountingTypeEnum.Unknown;
    }
    
    /**
     * Constructor for importing filter object
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
    public FilterInfo(int resonantFreq, int bandwidth, double size, double height, FilterType filterType, MountingTypeEnum mountingType, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(itemId, name, description, mfg, mfgPartNum, series, qty, price);
        this.resonantFreq = resonantFreq;
        this.bandwidth = bandwidth;
        this.size = size;
        this.height = height;
        this.filterType = filterType;
        this.mountingType = mountingType;
    }
    
    /**
     * CSV format for filters
     * @return 
     */
    public String toCSV(){
        String output = "";
        
        output += super.toCSV();
        output += this.resonantFreq + ",";
        output += this.bandwidth + ",";
        output += this.size + ",";
        output += this.height + ",";
        output += this.filterType + ",";
        output += this.mountingType + ",";
        
        return output;
    }
    
    public String toXML(){
        String output = "";
        
        output += super.toXML();
        output += "         <FilterInfo>\n";
        output += "             <resonantFreq>" + this.resonantFreq + "</resonantFreq>\n";
        output += "             <bandwidth>" + this.bandwidth + "</bandwidth>\n";
        output += "             <size>" + this.size + "</size>\n";
        output += "             <filterType>" + this.filterType + "</filterType>\n";
        output += "             <mountingType>" + this.mountingType + "</mountingType>\n";
        
        return output;
    }
    
    //Filter Enum
    private enum FilterType {
        AM,
        FM,
        BandPass,
        HighPass,
        LowPass,
        Discriminator,
        Unknown
    }

    private enum MountingTypeEnum{
        FreeHanging,
        SurfaceMount,
        ThroughHole,
        Chassis,
        Inline,
        Wall,
        Bolt,
        DinRail,
        WireLead,
        Unknown
    }

    /**
     * @return the resonantFreq
     */
    public int getResonantFreq() {
        return resonantFreq;
    }

    /**
     * @param resonantFreq the resonantFreq to set
     */
    public void setResonantFreq(int resonantFreq) {
        this.resonantFreq = resonantFreq;
    }

    /**
     * @return the bandwidth
     */
    public int getBandwidth() {
        return bandwidth;
    }

    /**
     * @param bandwidth the bandwidth to set
     */
    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * @return the size
     */
    public double getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the filterType
     */
    public FilterType getFilterType() {
        return filterType;
    }

    /**
     * @param filterType the filterType to set
     */
    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    /**
     * @return the mountingType
     */
    public MountingTypeEnum getMountingType() {
        return mountingType;
    }

    /**
     * @param mountingType the mountingType to set
     */
    public void setMountingType(MountingTypeEnum mountingType) {
        this.mountingType = mountingType;
    }
    
    
}







