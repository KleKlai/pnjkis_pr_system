package com.recordmanagement.classes;

public class Teeth {
    private int id;
    private int patientID;
    private int serviceID;
    private int cost;
    private String date;
    
    public Teeth(int id, int patientID, int serviceID, int cost, String date){
    this.id = id;
    this.patientID = patientID;
    this.serviceID = serviceID;
    this.cost = cost;
    this.date = date;

    } 
    public int getID(){
        return id;
    }
    public int getpatientID(){
        return patientID;
    }
    public int getserviceID(){
        return serviceID;
    }
     public int getCost(){
        return cost;
    }
         public String getDate(){
        return date;
    }
}
