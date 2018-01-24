package com.recordmanagement.classes;
public class Procedure {
    private String PatientName;
    private String TreatmentName;
    private String date;
    private int cost;
    
    public Procedure(String PName, String TName, String Date, int Cost){
    this.PatientName = PName;
    this.TreatmentName = TName;
    this.date = Date;
    this.cost = Cost;
    }
    
    public String getPName(){
        return PatientName;
    }
    public String getTName(){
        return TreatmentName;
    }
    public String getDate(){
        return date;
    }
    public int getCost(){
        return cost;
    }
}
