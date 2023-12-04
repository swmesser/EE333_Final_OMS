package OMS;

/* 
 * File: InductorCoilAndChokesInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 29, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */


public abstract class InductorCoilAndChokesInfo extends ProductInfo{
    private double tolerance;
    private InductorMountingType mount;
    private String packageCase;

    /**
     * Constructor for inductor object initialization
     */
    public InductorCoilAndChokesInfo(){
        super();
        this.tolerance = 0.0;
        this.mount = InductorMountingType.Unknown;
        this.packageCase = "";
    }

    /**
     * Constructor for importing inductor objects
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
    public InductorCoilAndChokesInfo(double tolerance, InductorMountingType mount, String packageCase, String itemId, String name, String description, String mfg, String mfgPartNum, String series, int qty, double price) throws Exception {
        super(itemId, name, description, mfg, mfgPartNum, series, qty, price);
        this.tolerance = tolerance;
        this.mount = mount;
        this.packageCase = packageCase;
    }
    
    /**
     * CSV format for inductor object
     * @return 
     */
    public String toCSV(){
        String output = "";
        
        output += super.toCSV();
        output += this.tolerance + ",";
        output += this.mount + ",";
        output += this.packageCase + ",";
        
        return output;
    }
    
    /**
     * XML format for 
     * @return 
     */
    public String toXML(){
        String output = "";
        
        output += "         <InductorCoilAndChokesInfo>\n";
        output += "             <tolerance>" + this.tolerance + "</tolerance>\n";
        output += "             <mount>" + this.mount + "</mount>\n";
        output += "             <packageCase>" + this.packageCase + "</packageCase>\n";
        
        return output;
    }
    
    /**
     * @return the tolerance
     */
    public double getTolerance() {
        return tolerance;
    }

    /**
     * @param tolerance the tolerance to set
     */
    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    /**
     * @return the mount
     */
    public InductorMountingType getMount() {
        return mount;
    }

    /**
     * @param mount the mount to set
     */
    public void setMount(InductorMountingType mount) {
        this.mount = mount;
    }

    /**
     * @return the packageCase
     */
    public String getPackageCase() {
        return packageCase;
    }

    /**
     * @param packageCase the packageCase to set
     */
    public void setPackageCase(String packageCase) {
        this.packageCase = packageCase;
    }
}

//Inductor Enums 
enum ArrayInductorShielding{
    Shielded,
    Unshielded,
    Unknown
}

enum FixedInductorShielding{
    Shielded,
    Semi_Shielding,
    Unshielded,
    Unknown
}

enum WirelessCoilFunction{
    Receiver,
    ReceiverTransmitter,
    Transmitter,
    Unknown
}

enum InductorMountingType{
    ChassisMount,
    FreeHanging,
    SurfaceMount,
    ThroughHole,
    UserDefined,
    Unknown
}

enum InductorRating{
    AEC_Q200,
    Unknown
}
