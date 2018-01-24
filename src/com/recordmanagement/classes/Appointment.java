package com.recordmanagement.classes;
public class Appointment {
    private int id;
    private String name;
    private String treatment;
    private String doctor;
    private String date;
    private String time;
    
    public Appointment(int Id, String Name, String Treatment, String Doctor, String Date, String Time){
    this.id = Id;
    this.name = Name;
    this.treatment = Treatment;
    this.doctor = Doctor;
    this.date = Date;
    this.time = Time;
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getTreatment(){
        return treatment;
    }
    public String getDoctor(){
        return doctor;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
}
