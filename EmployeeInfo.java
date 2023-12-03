package OMS;

/* 
 * File: EmployeeInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 30, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public  class EmployeeInfo extends UserInfo {
    private String firstname;
    private String lastname;
    private EmployeeRole role;  
    
    /**
     * Constructor for initial construction of employee
     */
    public EmployeeInfo(){
        super();
        this.firstname = "";
        this.lastname = "";
        this.role = EmployeeRole.Unknown;
    }

    /**
     * Constructor for importing employee objects
     * @param firstname
     * @param lastname
     * @param role
     * @param userId
     * @param userName
     * @param userPassword
     * @param userRole 
     */
    public EmployeeInfo(String firstname, String lastname, EmployeeRole role, String userId, String userName, String userPassword, UserType userRole) {
        super(userId, userName, userPassword, userRole);
        this.firstname = firstname;
        this.lastname = lastname;
        this.setRole(role);
    }
    
    
    
    //Enum for Roles
    private enum EmployeeRole{
        Administrator,
        Assiociate,
        Unknown
    }
    
    /**
     * Pushing information to CSV format for export
     * @return 
     */
    @Override
    public String toCSV(){
        String output = "";
        
        output += super.toCSV();
        output += this.firstname + ",";
        output += this.lastname + ",";
        output += this.role + "\n";
        
        return output;
    }
    
    /**
     * Pushing information to XML format for export
     * @return 
     */
    @Override
    public String toXML(){
        String output = "";
        
        output += "     <EmployeeInfo>\n";
        output += "         <firstname>" + this.firstname + "</firstname>\n";
        output += "         <lastname>" + this.lastname + "</lastname>\n";
        output += "         <role>" + this.role + "</role>\n";
        output += "     </EmployeeInfo>\n";
        output += "</UserInfo>\n";
        
        return output;
    }
    
    /**
     * Pulling information from singular line in CSV format for import
     * @param input 
     * @return 
     * @throws java.lang.Exception 
     */
    @Override
    public EmployeeInfo fromCSV( String input ) throws Exception{
        EmployeeInfo employee = null;
        String[] Chunks;
        String userId = "";
        String userName = "";
        String userPassword = "";
        String firstname = "";
        String lastname = "";
        UserType userRole;
        EmployeeRole role;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            Chunks = input.split(",");
            
            if ( Chunks.length == 7 ){
                userId = Chunks[0];
                userName = Chunks[1];
                userPassword = Chunks[2];
                userRole = UserType.valueOf(Chunks[3]);
                firstname = Chunks[4];
                lastname = Chunks[5];
                role = EmployeeRole.valueOf(Chunks[6]);
                
                //validation of employee information
                if (( userId == null ) || (userId.length() == 0)){
                    throw new Exception("Error: Invalid userId parsed!");
                } else if (( userName == null ) || ( userName.length() == 0 )){
                    throw new Exception("Error: Invalid user name parsed!");
                } else if (( userPassword == null ) || ( userPassword.length() == 0 )){
                    throw new Exception("Error: Invalid user password parsed!");
                } else {
                    employee = new EmployeeInfo(firstname, lastname, role, userId, userName, userPassword, userRole);
                }
            }
        }
        
        return employee;
    }
    
    /**
     * Pulling information from XML formatted string for import
     * @param input 
     * @return  
     * @throws java.lang.Exception  
     */
    @Override
    public EmployeeInfo fromXML( String input ) throws Exception{
        EmployeeInfo employee = null;
        String[] Chunks;
        String userId = "";
        String userName = "";
        String userPassword = "";
        String firstname = "";
        String lastname = "";
        UserType userType;
        EmployeeRole role;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            
        }
        
        return employee;
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
     * @return the role
     */
    public EmployeeRole getRole() {
        return role;
    }

    /**
     * @param role the role to set
     * @return
     */
    public boolean setRole(EmployeeRole role) {
        boolean results = false;
        
        if ( role == EmployeeInfo.EmployeeRole.Unknown ){
            results = false;
        } else {
            this.role = role;    
            results = true;
        }
        
        return results;
    }
    
}


