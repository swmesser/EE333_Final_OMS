package OMS;

import java.util.regex.Pattern;

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
    public EmployeeInfo(String firstname, String lastname, EmployeeRole role, String userId, String userName, String userPassword, UserType userRole) throws Exception{
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
    public static EmployeeInfo fromCSV( String input ) throws Exception{
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
                
                employee = new EmployeeInfo(firstname, lastname, role, userId, userName, userPassword, userRole);
                
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
    public static EmployeeInfo fromXML( String input ) throws Exception{
        EmployeeInfo employee = null;
        String userId = "";
        String userName = "";
        String userPassword = "";
        String firstname = "";
        String lastname = "";
        UserType userRole = UserType.Unknown;
        EmployeeRole role = EmployeeRole.Unknown;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            //Main Pattern 
            java.util.regex.Pattern regex = Pattern.compile("<UserInfo>(.*)</UserInfo>");
            //Matcher 
            java.util.regex.Matcher matcher = regex.matcher(input);
            
            for ( int index = 0; index < matcher.groupCount(); index++ ){
                if ( matcher.find() == true ){
                    //Secondary Pattern
                    regex = Pattern.compile("<EmployeeInfo>(.*)</EmployeeInfo>");
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
                        
                        //role Pattern 
                        regex = Pattern.compile("<role>(.*)</role>");
                        matcher = regex.matcher(input);
                        if ( matcher.find() == true ){
                            role = EmployeeRole.valueOf( matcher.group(1));
                        }
                        
                        
                        employee = new EmployeeInfo(firstname, lastname, role,
                                    userId, userName, userPassword, userRole);
                        
                    }
                    
                }
            }
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


