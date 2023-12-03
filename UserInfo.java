package OMS;

import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.RowFilter;

/* 
 * File: UserInfo
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Nov 30, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public class UserInfo implements Exportable {
    private String userId;
    private String userName;
    private String userPassword;
    private UserType userRole;
    
    /**
     * Constructor for creation of new users
     */
    public UserInfo(){
        this.userId = UUID.randomUUID().toString();
        this.userName = "";
        this.userPassword = "";
        this.userRole = UserType.Unknown;
    }

    /**
     * Constructor for importing of user objects
     * @param userId
     * @param userName
     * @param userPassword
     * @param userRole 
     */
    public UserInfo(String userId, String userName, String userPassword, UserType userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.setUserRole(userRole);
    }
    
    enum UserType{
        Customer,
        Employee,
        Unknown
    }

    /**
     * Exporting CSV format in manner that allows appending to the end
     * Used in inherited classes
     * @return 
     */
    @Override
    public String toCSV() {
        String output = "";
        
        output += this.userId + ",";
        output += this.userName + ",";
        output += this.userPassword + ",";
        output += this.userRole + ",";
        
        return output;
    }
    
    /**
     * Exporting XML format in manner that allows appending to the end
     * Used in inherited classes
     * @return 
     */
    @Override
    public String toXML() {
        String output = "";
        
        output += "<UserInfo>\n";
        output += "     <userId>" + this.userId + "</userId>\n";
        output += "     <userName>" + this.userName + "</userName>\n";
        output += "     <userPassword>" + this.userPassword + "</userPassword>\n";
        output += "     <userRole>" + this.userRole + "</userRole>\n";
        
        return output;
    }
    
    /**
     * Exporting CSV format user info specifically
     * @return 
     */
    public String toUserCSV(){
        String output = "";
        
        output += this.userId + ",";
        output += this.userName + ",";
        output += this.userPassword + ",";
        output += this.userRole + "\n";
        
        
        return output;
    }
    
    /**
     * Exporting XML format user info specifically 
     * @return 
     */
    public String toUserXML(){
        String output = "";
        
        output += "<UserInfo>\n";
        output += "     <userId>" + this.userId + "</userId>\n";
        output += "     <userName>" + this.userName + "</userName>\n";
        output += "     <userPassword>" + this.userPassword + "</userPassword>\n";
        output += "     <userRole>" + this.userRole + "</userRole>\n";
        output += "</UserInfo>\n";
        
        return output;
    }
    
    /**
     * Importing CSV formatted user info
     * @param input
     * @return 
     * @throws Exception
     */
    public UserInfo fromCSV(String input) throws Exception{
        UserInfo user = null;
        String[] Chunks;
        String userId = "";
        String userName = "";
        String userPassword = "";
        UserType userRole;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            Chunks = input.split(",");
            
            if (Chunks.length == 4){
                userId = Chunks[0];
                userName = Chunks[1];
                userPassword = Chunks[2];
                userRole = UserType.valueOf(Chunks[3]);
                
                if (( userId == null ) || (userId.length() == 0)){
                    throw new Exception("Error: Invalid userId parsed!");
                } else if (( userName == null ) || ( userName.length() == 0 )){
                    throw new Exception("Error: Invalid user name parsed!");
                } else if (( userPassword == null ) || ( userPassword.length() == 0 )){
                    throw new Exception("Error: Invalid user password parsed!");
                } else {
                    user = new UserInfo(userId, userName, userPassword, userRole);
                }
            }
        }
        
        return user;
    }
    
    /**
     * Importing XML formatted user info
     * @param input
     * @return
     * @throws Exception 
     */
    public UserInfo fromXML(String input) throws Exception{
        UserInfo user = null;
        String[] Chunks;
        String userId = "";
        String userName = "";
        String userPassword = "";
        UserType userRole = UserType.Unknown;
        
        if ( input == null ){
            throw new Exception("Error: Null input passed!");
        } else if ( input.length() == 0 ){
            throw new Exception("Error: Zero length input passed!");
        } else {
            java.util.regex.Pattern regex = Pattern.compile("<UserInfo>(.*)</UserInfo>");
            java.util.regex.Matcher matcher = regex.matcher(input);
            
            for (int index = 0; index < matcher.groupCount(); index++ ){
                if (matcher.find() == true ){
                    //Pattern for userId
                    regex = Pattern.compile("<userId>(.*)</userId>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        userId = matcher.group(1);
                    }
                    
                    //Pattern for userName 
                    regex = Pattern.compile("<userName>(.*)</userName>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        userName = matcher.group(1);
                    }
                    
                    //Pattern for userPassword
                    regex = Pattern.compile("<userPassword>(.*)</userPassword>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        userPassword = matcher.group(1);
                    }
                    
                    //Pattern for userRole
                    regex = Pattern.compile("<userRole>(.*)</userRole>");
                    matcher = regex.matcher(input);
                    if ( matcher.find() == true ){
                        userRole = UserType.valueOf( matcher.group(1));
                    }
                    
                    if (( userId == null ) || ( userId.length() == 0 )){
                        throw new Exception("Error: Invalid user id parsed!");
                    } else if (( userName == null ) || ( userName.length() == 0 )){
                        throw new Exception("Error: Invalid user name parsed!");
                    } else if (( userPassword == null ) || ( userPassword.length() == 0 )){
                        throw new Exception("Error: Invalid user password parsed!");
                    } else {
                        user = new UserInfo(userId, userName, userPassword, userRole);
                    }
                }
            }
            
        }
        return user;
    }
    
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the userRole
     */
    public UserType getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     * @return 
     */
    public boolean setUserRole(UserType userRole) {
        boolean results = false;
        
        if( userRole == UserInfo.UserType.Unknown){
            results = false; 
        } else {
            this.userRole = userRole;
            results = true;
        }
        
        return results;
    }
}


