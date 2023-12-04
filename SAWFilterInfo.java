package OMS;

/* 
 * File: SAWFilterInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class SAWFilterInfo extends FilterInfo{
    private double frequencyCenter;
    private double insertionLoss;
    private Application application;
    
    /**
     * Constructor for init
     */
    public SAWFilterInfo(){
        super();
        this.frequencyCenter = 0.0;
        this.insertionLoss = 0.0;
        this.application = Application.Unknown;
    }

    /**
     * Constructor for importing
     * @param frequencyCenter
     * @param insertionLoss
     * @param application
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
    public SAWFilterInfo(double frequencyCenter, double insertionLoss, Application application, int resonantFreq, int bandwidth, double size, double height, FilterType filterType, MountingTypeEnum mountingType, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(resonantFreq, bandwidth, size, height, filterType, mountingType, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        
        if ( frequencyCenter < 0.0 ){
            throw new Exception("Error: Invalid frequency center passed!");
        } else if ( insertionLoss < 0.0 ){
            throw new Exception("Error: Invalid insertion loss passed!");
        } else {
            this.frequencyCenter = frequencyCenter;
            this.insertionLoss = insertionLoss;
            this.application = application;
        }
    }
    
    public String toCSV(){
        String output = "";
        
        
        return output;
    }
    
    private enum Application{
        Automotive,
        BaseStation,
        Bluetooth,
        CDMA,
        CableConverters,
        Cellphone,
        Cellular,
        DAB,
        DCS,
        GPS,
        HDTV,
        IF,
        ISM,
        LTE,
        Medical,
        LabUse,
        WLAN,
        TETRA,
        WirelessMethods,
        Unknown
    }

    /**
     * @return the frequencyCenter
     */
    public double getFrequencyCenter() {
        return frequencyCenter;
    }

    /**
     * @param frequencyCenter the frequencyCenter to set
     */
    public void setFrequencyCenter(double frequencyCenter) {
        this.frequencyCenter = frequencyCenter;
    }

    /**
     * @return the insertionLoss
     */
    public double getInsertionLoss() {
        return insertionLoss;
    }

    /**
     * @param insertionLoss the insertionLoss to set
     */
    public void setInsertionLoss(double insertionLoss) {
        this.insertionLoss = insertionLoss;
    }

    /**
     * @return the application
     */
    public Application getApplication() {
        return application;
    }

    /**
     * @param application the application to set
     */
    public void setApplication(Application application) {
        this.application = application;
    }
    
    
}
