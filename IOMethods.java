package OMS;

import java.util.ArrayList;

/* 
 * File: IOMethods
 * Copy: Copyright (c) 2023 Samuel W. Messer
 * BlazerID: swmesser
 * Vers: 1.0.0 Dec 3, 2023 SWM - Original Coding
 * Desc: Driver for testing concepts
 */

public class IOMethods {
    //private arrayList for each product type with individual variables for importings
    
    public static ArrayList<UserInfo> ImportUsers( String Repository, String format ){
        ArrayList<UserInfo> users = new ArrayList<UserInfo>();
        UserInfo newUser = new UserInfo();
        
        return users;
    }
    
    public static ArrayList<EmployeeInfo> ImportEmployees( String Repository, String format ){
        ArrayList<EmployeeInfo> employees = new ArrayList<EmployeeInfo>();
        EmployeeInfo newEmployee = new EmployeeInfo();
        
        return employees;
    }
    
    public static ArrayList<CustomerInfo> ImportCustomers( String Repository, String format ){
        ArrayList<CustomerInfo> customers = new ArrayList<CustomerInfo>();
        CustomerInfo newCustomer = new CustomerInfo();
        
        return customers;
    }
    
    public static ArrayList<OrderInfo> ImportOrders( String Repository, String format ){
        ArrayList<OrderInfo> orders = new ArrayList<OrderInfo>();
        OrderInfo newOrder = new OrderInfo();
        
        return orders;
    }
    
    public static void ImportProducts( String Repository, String format ){
        //Using private arraylist and objects
    }
    
    //Possible ways to approach the import of products
    //      1.Use drop down to select main category and sub category then import  all info that way
    //      2. function will void return type 
    //          import all from one folder with private arraylist of each type of product and fill from single call
//    public static void ImportProducts( String Repository, String format ){
//    }
//    public static ArrayList<< any >> ImportProducts( String Repository, String format ){
//    }
}
