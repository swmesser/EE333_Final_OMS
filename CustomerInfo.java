package OMS;

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
    private CustomerInfo status;
    
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
        
        return output;
    }
    
    /**
     * Pushing info to XML format for export
     * @return 
     */
    @Override
    public String toXML(){
        String output = "";
        
        return output;
    }
    
    /**
     * Pulling info from single line in CSV format to return customer object
     * @param input 
     * @return
     * @throws Exception
     */
    public CustomerInfo fromCSV( String input ) throws Exception{
        CustomerInfo customer = null;
        
        return customer;
    }
    
    /**
     * Pulling info from XML formatted string to return customer object
     * @param input 
     * @return 
     * @throws Exception
     */
    public CustomerInfo fromXML( String input ) throws Exception{
        CustomerInfo customer = null;
        
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
    public CustomerInfo getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(CustomerInfo status) {
        this.status = status;
    }
}


