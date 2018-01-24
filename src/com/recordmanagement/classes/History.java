package com.recordmanagement.classes;
public class History {
    private String name;
    private String date;
    private String status;
    
    public History(String name, String date, String status){
    this.name = name;
    this.date = date;
    this.status = status;
    }
    
    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getStatus(){
        return status;
    }    
}
