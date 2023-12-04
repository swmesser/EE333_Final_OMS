package OMS;

import java.util.regex.Pattern;

/* 
 * File: CustomerInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 30, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public  class CustomerInfo extends UserInfo {
    private String firstname;
    private String lastname;
    private String email;
    private AddressInfo shippingAddress;
    private AddressInfo billingAddress;
    private CustomerStatus status;
    
    public CustomerInfo(){
        super();
        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.shippingAddress = new AddressInfo();
        this.billingAddress = new AddressInfo();
        this.status = CustomerStatus.Unknown;
        
    }

    public CustomerInfo(String firstname, String lastname, String email, AddressInfo shippingAddress, AddressInfo billingAddress, CustomerStatus status, String userId, String userName, String userPassword, UserType userRole) {
        super(userId, userName, userPassword, userRole);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.status = status;
    }
    
    
    
    private enum CustomerStatus{
        Active,
        Inactive,
        Unknown
    }

    /**
     * Pushing info into CSV format for export
     * @return 
     */
    @Override
    public String toCSV(){
        String output = "";
        
        output += super.toCSV();
        output += this.firstname + ",";
        output += this.lastname + ",";
        output += this.email + ",";
        output += shippingAddress.toCSV() + ",";
        output += billingAddress.toCSV() + "\n";
        
        return output;
    }
    
    /**
     * Pushing info to XML format for export
     * @return 
     */
    @Override
    public String toXML(){
        String output = "";
        
        output += super.toXML();
        output += "     <CustomerInfo>\n";
        output += "         <firstname>" + this.firstname + "</firstname>\n";
        output += "         <lastname>" + this.lastname + "</lastname>\n";
        output += shippingAddress.toXML();
        output += billingAddress.toXML();
        output += "         <status>" + this.status + "</status>\n";
        output += "     </CustomerInfo>\n";
        output += "</UserInfo>\n";
        
        return output;
    }
    
    /**
     * Pulling info from single line in CSV format to return customer object
     * @param input 
     * @return
     * @throws Exception
     */
    public static CustomerInfo fromCSV( String input ) throws Exception{
        CustomerInfo customer = null;
        AddressInfo shipping = null;
        AddressInfo billing = null;
        String[] Chunks;
        //User
        String userId = "";
        String userName = "";
        String userPassword = "";
        UserType userRole = UserType.Unknown;
        //Customer
        String firstname = "";
        String lastname = "";
        String email = "";
        String shippingStreet = "";
        String shippingCity = "";
        String shippingState = "";
        String shippingZipcode = "";
        String billingStreet = "";
        String billingCity = "";
        String billingState = "";
        String billingZipcode = "";
        CustomerStatus status = null;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            Chunks = input.split(",");
            
            if ( Chunks.length == 16 ){
                userId = Chunks[0];
                userName = Chunks[1];
                userPassword = Chunks[2];
                userRole = UserType.valueOf(Chunks[3]); 
                firstname = Chunks[4];
                lastname = Chunks[5];
                email = Chunks[6];
                shippingStreet = Chunks[7];
                shippingCity = Chunks[8];
                shippingState = Chunks[9];
                shippingZipcode = Chunks[10];
                billingStreet = Chunks[11];
                billingCity = Chunks[12];
                billingState = Chunks[13];
                billingZipcode = Chunks[14];
                status = CustomerStatus.valueOf(Chunks[15]);
                
                if (( shippingStreet == null ) || ( shippingStreet.length() == 0 )){
                    throw new Exception("Error: Invalid street address parsed!");
                } else if (( shippingCity == null ) || ( shippingCity.length() == 0 )){
                    throw new Exception("Error: Invalid city parsed!");
                } else if (( shippingState == null ) || ( shippingState.length() == 0 )){
                    throw new Exception("Error: Invalid state parsed!");
                } else if (( shippingZipcode == null ) || ( shippingZipcode.length() == 0)){
                    throw new Exception("Error: Invalid zipcode parsed!");
                } else {
                    shipping = new AddressInfo( shippingStreet, shippingCity, shippingState, shippingZipcode);
                    
                    //If shipping is valid test billing
                    if (( billingStreet == null ) || ( billingStreet.length() == 0 )){
                        throw new Exception("Error: Invalid street address parsed!");
                    } else if (( billingCity == null ) || ( billingCity.length() == 0 )){
                        throw new Exception("Error: Invalid city parsed!");
                    } else if (( billingState == null ) || ( billingState.length() == 0 )){
                        throw new Exception("Error: Invalid state parsed!");
                    } else if (( billingZipcode == null ) || ( billingZipcode.length() == 0)){
                        throw new Exception("Error: Invalid zipcode parsed!");
                    } else {
                        billing = new AddressInfo( billingStreet, billingCity, billingState, billingZipcode);
                        //if billing is valid create customer
                        if (( firstname == null ) || ( firstname.length() == 0 )){
                            throw new Exception("Error: Invalid firstname parsed!");
                        } else if (( lastname == null ) || ( lastname.length() == 0 )){
                            throw new Exception("Error: Invalid lastname parsed!");
                        } else if (( email == null ) || ( email.length() == 0 )){
                            throw new Exception("Error: Invalid email parsed!");
                        } else {
                            customer = new CustomerInfo(firstname, lastname, email, shipping, billing, 
                                    status, userId, userName, userPassword, userRole);
                        }
                    }
                }
            }
        }
        
        return customer;
    }
    
    /**
     * Pulling info from XML formatted string to return customer object
     * @param input 
     * @return 
     * @throws Exception
     */
    public static CustomerInfo fromXML( String input ) throws Exception{
        CustomerInfo customer = null;
        AddressInfo shipping = null;
        AddressInfo billing = null;
        //User
        String userId = "";
        String userName = "";
        String userPassword = "";
        UserType userRole = UserType.Unknown;
        //Customer
        String firstname = "";
        String lastname = "";
        String email = "";
        String shippingStreet = "";
        String shippingCity = "";
        String shippingState = "";
        String shippingZipcode = "";
        String billingStreet = "";
        String billingCity = "";
        String billingState = "";
        String billingZipcode = "";
        CustomerStatus status = null;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            //Main Pattern
            java.util.regex.Pattern regex = Pattern.compile("<UserInfo>(.*)</UserInfo>");
            //matcher
            java.util.regex.Matcher matcher = regex.matcher(input);
            
            for ( int index = 0; index < matcher.groupCount(); index++ ){
                if( matcher.find() == true ){
                    //Secondary pattern
                    regex = Pattern.compile("<CustomerInfo>(.*)</CustomerInfo>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        //userId Pattern
                        regex = Pattern.compile("<userId>(.*)</userId>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            userId = matcher.group(1);
                        }
                        
                        //userName Pattern
                        regex = Pattern.compile("<userName>(.*)</userName>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            userName = matcher.group(1);
                        }
                        
                        //userPassword Pattern
                        regex = Pattern.compile("<userPassword>(.*)</userPassword>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            userPassword = matcher.group(1);
                        }
                        
                        //userRole Pattern
                        regex = Pattern.compile("<userRole>(.*)</userRole>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            userRole = UserType.valueOf( matcher.group(1));
                        }
                        
                        //firstname Pattern
                        regex = Pattern.compile("<firstname>(.*)</firstname>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            firstname = matcher.group(1);
                        }
                        
                        //lastname Pattern
                        regex = Pattern.compile("<lastname>(.*)</lastname>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            lastname = matcher.group(1);
                        }
                        
                        //email Pattern
                        regex = Pattern.compile("<email>(.*)</email>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            email = matcher.group(1);
                        }
                        
                        //Shipping Address Patterns
                        regex = Pattern.compile("<street>(.*)</street>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            shippingStreet = matcher.group(1);
                        }
                        
                        regex = Pattern.compile("<city>(.*)</city>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            shippingCity = matcher.group(1);
                        }
                        
                        regex = Pattern.compile("<state>(.*)</state>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            shippingState = matcher.group(1);
                        }
                        
                        regex = Pattern.compile("<zipcode>(.*)</zipcode>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            shippingZipcode = matcher.group(1);
                        }
                        
                        //Billing Address Patterns
                        regex = Pattern.compile("<street>(.*)</street>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            billingStreet = matcher.group(1);
                        }
                        
                        regex = Pattern.compile("<city>(.*)</city>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            billingCity = matcher.group(1);
                        }
                        
                        regex = Pattern.compile("<state>(.*)</state>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            billingState = matcher.group(1);
                        }
                        
                        regex = Pattern.compile("<zipcode>(.*)</zipcode>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            billingZipcode = matcher.group(1);
                        }
  
                        //Status pattern
                        regex = Pattern.compile("<status>(.*)</status>");
                        matcher = regex.matcher(input);
                        if( matcher.find() == true ){
                            status = CustomerStatus.valueOf( matcher.group(1));
                        }
  
                        if (( shippingStreet == null ) || ( shippingStreet.length() == 0 )){
                            throw new Exception("Error: Invalid street address parsed!");
                        } else if (( shippingCity == null ) || ( shippingCity.length() == 0 )){
                            throw new Exception("Error: Invalid city parsed!");
                        } else if (( shippingState == null ) || ( shippingState.length() == 0 )){
                            throw new Exception("Error: Invalid state parsed!");
                        } else if (( shippingZipcode == null ) || ( shippingZipcode.length() == 0)){
                            throw new Exception("Error: Invalid zipcode parsed!");
                        } else {
                            shipping = new AddressInfo( shippingStreet, shippingCity, shippingState, shippingZipcode);

                            //If shipping is valid test billing
                            if (( billingStreet == null ) || ( billingStreet.length() == 0 )){
                                throw new Exception("Error: Invalid street address parsed!");
                            } else if (( billingCity == null ) || ( billingCity.length() == 0 )){
                                throw new Exception("Error: Invalid city parsed!");
                            } else if (( billingState == null ) || ( billingState.length() == 0 )){
                                throw new Exception("Error: Invalid state parsed!");
                            } else if (( billingZipcode == null ) || ( billingZipcode.length() == 0)){
                                throw new Exception("Error: Invalid zipcode parsed!");
                            } else {
                                billing = new AddressInfo( billingStreet, billingCity, billingState, billingZipcode);
                                //if billing is valid create customer
                                if (( firstname == null ) || ( firstname.length() == 0 )){
                                    throw new Exception("Error: Invalid firstname parsed!");
                                } else if (( lastname == null ) || ( lastname.length() == 0 )){
                                    throw new Exception("Error: Invalid lastname parsed!");
                                } else if (( email == null ) || ( email.length() == 0 )){
                                    throw new Exception("Error: Invalid email parsed!");
                                } else {
                                    customer = new CustomerInfo(firstname, lastname, email, shipping, billing, 
                                            status, userId, userName, userPassword, userRole);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return customer;
    }
    
    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the shippingAddress
     */
    public AddressInfo getShippingAddress() {
        return shippingAddress;
    }

    /**
     * @param shippingAddress the shippingAddress to set
     */
    public void setShippingAddress(AddressInfo shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * @return the billingAddress
     */
    public AddressInfo getBillingAddress() {
        return billingAddress;
    }

    /**
     * @param billingAddress the billingAddress to set
     */
    public void setBillingAddress(AddressInfo billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * @return the status
     */
    public CustomerStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(CustomerStatus status) {
        this.status = status;
    }
}


