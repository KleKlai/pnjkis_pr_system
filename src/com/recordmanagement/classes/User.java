package com.recordmanagement.classes;
public class User {   
    private int id;
    private String fname;
    private String lname;
    private String street;
    private String city;
    private String gender;
    private String age;
    private String phoneno;
    private String status;
    
    public static String name;
    public static String username;   
    public static String password;
    public static String pass;
    public static String division;
    
    
    public User(int id, String fname, String lname, String gender, String age, String street, String city, String phoneno,String status)
    {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.gender = gender;
    this.age = age;
    this.street = street;
    this.city = city;
    this.phoneno = phoneno;
    this.status = status;
    }
    
   public int getId()
    {
        return id;
    } 
   public String getFname()
    {
        return fname;
    }
   public String getLname()
    {
        return lname;
    }
   public String getGender()
    {
        return gender;
    }
   public String getAge()
    {
        return age;
    }
   public String getStreet()
    {
        return street;
    }
   public String getCity()
    {
        return city;
    }
   public String getPhone()
    {
        return phoneno;
    }
   public String getStatus()
    {
        return status;
    }

}




      
