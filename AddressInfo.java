package OMS;

import java.util.regex.Pattern;

/* 
 * File: AddressInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 29, 2023 SWM - Original Coding
 * Desc: Address class for I/O
 */

public class AddressInfo {
    private String street;
    private String city;
    private String state;
    private String zipcode;

    /**
     * Constructor for creation of address object
     * Pair with the sets
     */
    public AddressInfo(){
        this.street = "";
        this.state = "";
        this.city = "";
        this.zipcode = "";
    }
    
    /** 
     * Constructor for reading of address object
     */
    public AddressInfo(String street, String city, String state, String zipcode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    /**
     * Pushing address info into CSV format for customer to export
     * @return 
     */
    public String toCSV() {
        String output = "";
        
        output += this.street + ",";
        output += this.city + ",";
        output += this.state + ",";
        output += this.zipcode + "\n";
        
        return output;
    }
    
    /**
     * Pushing address info into XML format for customer to export
     * @return 
     */
    public String toXML(){
        String output = "";
        
        output += "<AddressInfo>\n";
        output += "     <street>" + this.street + "</street>\n";
        output += "     <city>" + this.city + "</city>\n";
        output += "     <state>" + this.state + "</state>\n";
        output += "     <zipcode>" + this.zipcode + "</zipcode>\n";
        output += "</AddressInfo>\n";
        
        return output;
    }
    
    /**
     * Reading CSV formatted string to return address object to customer
     * @param input 
     * @return 
     * @throws Exception
     */
    public AddressInfo fromCSV( String input ) throws Exception{
        AddressInfo address = null;
        String[] Chunks;
        String street;
        String city;
        String state;
        String zipcode;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            Chunks = input.split(",");
            
            if ( Chunks.length == 4 ){
                street = Chunks[0];
                city = Chunks[1];
                state = Chunks[2];
                zipcode = Chunks[3];
                
                if (( street.length() == 0 ) || ( street == null )){
                    throw new Exception("Error: Invalid street parsed!");
                } else if (( city.length() == 0) || ( city == null )){
                    throw new Exception("Error: Invalid city parsed!");
                } else if (( state.length() == 0 ) || ( state == null )){
                    throw new Exception("Error: Invalid state parsed!");
                } else if (( zipcode.length() == 0 ) || ( zipcode == null )){
                    throw new Exception("Error: Invalid zipcode parsed!");
                } else {
                    address = new AddressInfo(street, city, state, zipcode);
                }
            }
        }
        
        return address ;
    }
    
    /**
     * Reading XML formatted string to return address object to customer
     * @param input 
     * @return
     * @throws Exception
     */
    public AddressInfo fromXML( String input ) throws Exception{
        AddressInfo address = null;
        String[] Chunks;
        String street = "";
        String city = "";
        String state = "";
        String zipcode = "";
        
        if( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        }else {
            //Main pattern for XML address
            java.util.regex.Pattern regex = Pattern.compile("<AddressInfo>(.*)</AddressInfo>");
            java.util.regex.Matcher matcher = regex.matcher(input);
            
            for ( int index = 0; index < matcher.groupCount(); index++ ){
                //Test for matches
                if( matcher.find() == true ){
                    
                    //Pattern for street
                    regex = Pattern.compile("<street>(.*)</street>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        street = matcher.group(1);
                    }
                    
                    //Pattern for city 
                    regex = Pattern.compile("<city>(.*)</city>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        city = matcher.group(1);
                    }
                    
                    //Pattern for state 
                    regex = Pattern.compile("<state>(.*)</state>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        state = matcher.group(1);
                    }
                    
                    //Pattern for zipcode
                    regex = Pattern.compile("<zipcode>(.*)</zipcode>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        zipcode = matcher.group(1);
                    }
                }
                
                if (( street == null) || ( street.length() == 0)){
                    throw new Exception("Error: Invalid street parsed!");
                } else if (( city == null ) || ( city.length() == 0 )){
                    throw new Exception("Error: Invalid city parsed!");
                } else if (( state == null ) || ( state.length() == 0 )){
                    throw new Exception("Error: Invalid state parsed!");
                } else if (( zipcode == null ) || ( zipcode.length() == 0 )){
                    throw new Exception("Error: Invalid zipcode parsed!");
                } else {
                    address = new AddressInfo(street, city, state, zipcode);
                }
            }
        }
        
        return address;
    }
    
    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    
    
}
