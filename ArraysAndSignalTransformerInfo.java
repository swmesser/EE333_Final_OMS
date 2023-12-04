package OMS;

/* 
 * File: ArraysAndSignalTransformerInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public final class ArraysAndSignalTransformerInfo extends InductorCoilAndChokesInfo {
    
    private double operatingTemp;
    private double inductance;
    private double currentRating;
    private double dcResistance;
    private double currentSaturation;
    private double selfResonantFreq;
    private String coreMaterial;
    private String inductorType;
    private FixedInductorShielding shielding;
    private String qAtFreq;
    private InductorRating rating;
    private String inductanceFreqTest;
    private String features;
    private String supplierDevicePackage;
    private String size;
    private String seatedHeight;

    /**
     * Constructor for init
     */
    public ArraysAndSignalTransformerInfo(){
        super();
        this.operatingTemp = 0.0;
        this.inductance = 0.0;
        this.currentRating = 0.0;
        this.dcResistance = 0.0;
        this.currentSaturation = 0.0;
        this.selfResonantFreq = 0.0;
        this.coreMaterial = "";
        this.inductorType = "";
        this.shielding = FixedInductorShielding.Unknown;
        this.qAtFreq = "";
        this.rating = InductorRating.Unknown;
        this.inductanceFreqTest = "";
        this.features = "";
        this.supplierDevicePackage = "";
        this.size = "";
        this.seatedHeight = "";
    }

    /**
     * Constructor for importing array transformers
     * @param operatingTemp
     * @param inductance
     * @param currentRating
     * @param dcResistance
     * @param currentSaturation
     * @param selfResonantFreq
     * @param coreMaterial
     * @param inductorType
     * @param shielding
     * @param qAtFreq
     * @param rating
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
    public ArraysAndSignalTransformerInfo(double operatingTemp, double inductance, double currentRating, double dcResistance, double currentSaturation, double selfResonantFreq, String coreMaterial, String inductorType, FixedInductorShielding shielding, String qAtFreq, InductorRating rating, String inductanceFreqTest, String features, String supplierDevicePackage, String size, String seatedHeight, double tolerance, InductorMountingType mount, String packageCase, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(tolerance, mount, packageCase, itemId, name, description, mfg, mfgPartNum, series, qty, price);
        this.operatingTemp = operatingTemp;
        this.inductance = inductance;
        this.currentRating = currentRating;
        this.dcResistance = dcResistance;
        this.currentSaturation = currentSaturation;
        this.selfResonantFreq = selfResonantFreq;
        this.coreMaterial = coreMaterial;
        this.inductorType = inductorType;
        this.shielding = shielding;
        this.qAtFreq = qAtFreq;
        this.rating = rating;
        this.inductanceFreqTest = inductanceFreqTest;
        this.features = features;
        this.supplierDevicePackage = supplierDevicePackage;
        this.size = size;
        this.seatedHeight = seatedHeight;
    }
    
    @Override
    public String toCSV() {
        String output = "";
        
        output += super.toCSV(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        
        
        return(output);
    }

    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
