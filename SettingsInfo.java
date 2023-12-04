package OMS;

import java.util.regex.Pattern;

/* 
 * File: SettingsInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 30, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public class SettingsInfo {
    private String userRepo; //user file
    private String customerRepo;    // customer file
    private String employeeRepo;    //employee file
    private String productsRepo; // products file
    private String format;
    
    /**
     * Constructor for initialization of settings objects
     */
    public SettingsInfo(){
        this.userRepo = "";
        this.customerRepo = "";
        this.employeeRepo = "";
        this.productsRepo = "";
        this.format = "";
    }

    /**
     * Constructor for importing settings objects
     * @param userRepo
     * @param customerRepo
     * @param employeeRepo
     * @param productsRepo
     * @param format 
     */
    public SettingsInfo(String userRepo, String customerRepo, String employeeRepo, String productsRepo, String format) {
        this.userRepo = userRepo;
        this.customerRepo = customerRepo;
        this.employeeRepo = employeeRepo;
        this.productsRepo = productsRepo;
        this.format = format;
    }
    
    /**
     * Pushing Settings to CSV format for exporting
     * @return 
     */
    public String toCSV(){
        String output = "";
        
        output += this.userRepo + ",";
        output += this.customerRepo + ",";
        output += this.employeeRepo + ",";
        output += this.productsRepo + ",";
        output += this.format + "\n";
        
        return(output);
    }
    
    /**
     * Pushing Settings to XML format for exporting
     * @return 
     */
    public String toXML(){
        String output = "";
        
        output += "<SettingsInfo>\n";
        output += "     <userRepo>" + this.userRepo + "</userRepo>\n";
        output += "     <customerRepo>" + this.customerRepo + "</customerRepo>\n";
        output += "     <employeeRepo>" + this.employeeRepo + "</employeeRepo>\n";
        output += "     <productsRepo>" + this.productsRepo + "</productsRepo>\n";
        output += "</SettingsInfo>\n";
        
        return(output);
    }

    /**
     * Pulling information from a singular line in to create setting object
     * @param input 
     */
    public static SettingsInfo fromCSV( String input ) throws Exception{
        SettingsInfo settings = null;
        String[] Chunks;
        String userRepo = ""; //user file
        String customerRepo = "";    // customer file
        String employeeRepo = "";    //employee file
        String productsRepo = ""; // products file
        String format = "";
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            Chunks = input.split(",");
            
            if ( Chunks.length == 5 ){
                userRepo = Chunks[0];
                customerRepo = Chunks[1];
                employeeRepo = Chunks[2];
                productsRepo = Chunks[3];
                format = Chunks[4];
                
                if (( userRepo == null) || ( userRepo.length() == 0 )){
                    throw new Exception("Error: Invalid user repo parsed!");
                } else if (( customerRepo == null ) || ( customerRepo.length() == 0 )){
                    throw new Exception("Error: Invalid customer repo parsed!");
                } else if (( employeeRepo == null ) || ( employeeRepo.length() == 0 )){
                    throw new Exception("Error: Invalid employee repo parsed!");
                } else if (( productsRepo == null ) || ( productsRepo.length() == 0 )){
                    throw new Exception("Error: Invalid products repo parsed!");
                } else if (( format == null ) || ( format.length() == 0 )){
                    throw new Exception("Error: Invalid format parsed!");
                } else {
                    settings = new SettingsInfo(userRepo, customerRepo, employeeRepo, productsRepo, format);
                }
            }
        }
        
        return ( settings );
    }
    
    /**
     * Pulling information from a string input using regex to create setting object
     * @param input 
     */
    public static SettingsInfo fromXML( String input ) throws Exception{
        SettingsInfo settings = null;
        String userRepo = ""; //user file
        String customerRepo = "";    // customer file
        String employeeRepo = "";    //employee file
        String productsRepo = ""; // products file
        String format = "";
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            //Main pattern
            java.util.regex.Pattern regex = Pattern.compile("<SettingsInfo>(.*)</SettingsInfo>");
            //matcher
            java.util.regex.Matcher matcher = regex.matcher(input);
            
            for ( int index = 0; index < matcher.groupCount(); index++ ){
                if( matcher.find() == true ){
                    //userRepo pattern
                    regex = Pattern.compile("<userRepo>(.*)</userRepo>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        userRepo = matcher.group(1);
                    }
                    
                    //customerRepo pattern
                    regex = Pattern.compile("<customerRepo>(.*)</customerRepo>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        customerRepo = matcher.group(1);
                    }
                    
                    //employeeRepo pattern
                    regex = Pattern.compile("<employeeRepo>(.*)</employeeRepo>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        employeeRepo = matcher.group(1);
                    }
                    
                    //productsRepo pattern
                    regex = Pattern.compile("<productsRepo>(.*)</productsRepo>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        productsRepo = matcher.group(1);
                    }
                    
                    //format pattern
                    regex = Pattern.compile("<format>(.*)</format>");
                    matcher = regex.matcher(input);
                    if( matcher.find() == true ){
                        format = matcher.group(1);
                    }
                    
                    if (( userRepo == null) || ( userRepo.length() == 0 )){
                        throw new Exception("Error: Invalid user repo parsed!");
                    } else if (( customerRepo == null ) || ( customerRepo.length() == 0 )){
                        throw new Exception("Error: Invalid customer repo parsed!");
                    } else if (( employeeRepo == null ) || ( employeeRepo.length() == 0 )){
                        throw new Exception("Error: Invalid employee repo parsed!");
                    } else if (( productsRepo == null ) || ( productsRepo.length() == 0 )){
                        throw new Exception("Error: Invalid products repo parsed!");
                    } else if (( format == null ) || ( format.length() == 0 )){
                        throw new Exception("Error: Invalid format parsed!");
                    } else {
                        settings = new SettingsInfo(userRepo, customerRepo, employeeRepo, productsRepo, format);
                    }
                }
            }
        }
        
        return ( settings );
    }
    
    /**
     * @return the userRepo
     */
    public String getUserRepo() {
        return userRepo;
    }

    /**
     * @param userRepo the userRepo to set
     */
    public void setUserRepo(String userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * @return the customerRepo
     */
    public String getCustomerRepo() {
        return customerRepo;
    }

    /**
     * @param customerRepo the customerRepo to set
     */
    public void setCustomerRepo(String customerRepo) {
        this.customerRepo = customerRepo;
    }

    /**
     * @return the employeeRepo
     */
    public String getEmployeeRepo() {
        return employeeRepo;
    }

    /**
     * @param employeeRepo the employeeRepo to set
     */
    public void setEmployeeRepo(String employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /**
     * @return the productsRepo
     */
    public String getProductsRepo() {
        return productsRepo;
    }

    /**
     * @param productsRepo the productsRepo to set
     */
    public void setProductsRepo(String productsRepo) {
        this.productsRepo = productsRepo;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }
    
}
