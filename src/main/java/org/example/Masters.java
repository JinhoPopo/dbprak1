package org.example;

public class Masters {
    private int id;
    private String Fname;
    public Masters(int id, String name){
        this.id = id;
        this.Fname = name;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return this.Fname;
    }

    public void setName(String name) {
        this.Fname = name;
    }
}
