package com.recordmanagement.classes;
public class Treatment {
    private int id;
    private String name;
    private String desc;
    
    public Treatment(int id, String name, String desc){
    this.id = id;
    this.name = name;
    this.desc = desc;
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }
}
