package OMS;

import java.util.UUID;
import java.util.regex.Pattern;


/* 
 * File: OrderInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 29, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public class OrderInfo implements Exportable{
    private String id;
    private String name;
    private double subTotal;
    private double total;
    //Status of order is handledd through location of orderId.txt
    //Split files between a folder "Shipped" and "Not Shipped"
    //Import pulls data from the "Not Shipped" folder and archives them by moving to "Shipped"

    /**
     * Constructor for creation of order objects
     */
    public OrderInfo(){
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.subTotal = 0.0;
        this.total = 0.0;
    }
    
    /**
     * Constructor used in importing of order objects
     * @param id
     * @param name
     * @param subTotal 
     */
    public OrderInfo(String id, String name, double subTotal) throws Exception{
        //verification of valid parameters
        if (( id == null ) | ( id.length() == 0 )){
            throw new Exception("Error: Invalid Id parsed!");
        } else if (( name == null ) | ( name.length() == 0 )){
            throw new Exception("Error: Invalid name parsed!");
        } else {
            this.id = id;
            this.name = name;
            this.subTotal = subTotal;
            //Setting total using the setTotal function
        }
    }
    
    /**
     * Pushing information to CSV format for export
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += this.id + ",";
        output += this.name + ",";
        output += this.subTotal + ",";
        output += this.total + "\n";
        
        return output;
    }

    /**
     * Pushing information to XML format for export
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += "<OrderInfo>\n";
        output += "     <id>" + this.id + "</id>\n";
        output += "     <name>" + this.name + "</name>\n";
        output += "     <subTotal>" + this.subTotal + "</subTotal>\n";
        output += "     <total>" + this.total + "</total>\n";
        output += "</OrderInfo>\n";
        
        return output;
    }
    
    /**
     * Pulling information from singular line from file to create order object
     * @param input 
     */
    public OrderInfo fromCSV( String input ) throws Exception{
        OrderInfo order = null;
        String[] Chunks;
        String id = "";
        String name = "";
        double subTotal = 0.0;
        double total = 0.0;
        
        // Validation of input string from call
        if ( input == null ){
            throw new Exception("Error: Null input!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input!");
        } else {
            Chunks = input.split(",");
            
            //validation of correct variable counts
            if ( Chunks.length == 4 ) {
                id = Chunks[0];
                name = Chunks[1];
                subTotal = Double.parseDouble(Chunks[2]);
                total = Double.parseDouble(Chunks[3]);
                
                order = new OrderInfo(id, name, subTotal);
                order.setTotal(total);
                
            }
        }
        return order;
    }
    
    /**
     * Pulling information from singular line from file to read using regex to create order object
     * @param input 
     */
    public OrderInfo fromXML( String input )throws Exception{
        OrderInfo order = null;
        String[] Chunks;
        String id = "";
        String name = "";
        double subTotal = 0.0;
        double total = 0.0;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else{
            //REGEX for orderInfo
            java.util.regex.Pattern regex = java.util.regex.Pattern.compile("<OrderInfo>(.*)</OrderInfo>");
            //Checking for matches
            java.util.regex.Matcher matcher = regex.matcher( input );

            for ( int index = 0; index < matcher.groupCount(); index++ ){
                if( matcher.find() == true ){
                    //Pattern for id 
                    regex = Pattern.compile("<id>(.*)</id>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        id = matcher.group(1);
                    }

                    //Pattern for name
                    regex = Pattern.compile("<name>(.*)</name>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        name = matcher.group(1);
                    }

                    //Pattern for subTotal
                    regex = Pattern.compile("<subTotal>(.*)</subTotal>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        subTotal = Double.parseDouble( matcher.group(1));
                    }

                    //Pattern for total
                    regex = Pattern.compile("<total>(.*)</total>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        total = Double.parseDouble( matcher.group(1));
                    }
                }

                //Verification of valid parameters for object creation
                if (( id == null ) | ( id.length() == 0 )){
                    throw new Exception("Error: Invalid Id parsed!");
                } else if (( name == null ) | ( name.length() == 0 )){
                    throw new Exception("Error: Invalid name parsed!");
                } else {
                    order = new OrderInfo(id, name, subTotal);
                    order.setTotal(total);
                }

            }
        }
        return order;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = ( this.subTotal * 0.10) + this.subTotal;
    }

}
