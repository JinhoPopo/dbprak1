package org.example;

import javax.swing.text.MutableAttributeSet;

public class Cliets {
    private int id;
    private String name;
    private Masters idMaster;
    public Cliets(int id, String name, Masters idMaster) {
        this.id = id;
        this.name = name;
        this.idMaster = idMaster;
    }
    public int getId(){return this.id;}
    public void setId(int id) {this.id = id;}
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    public Masters getIdMaster(){return this.idMaster;}
    public void setIdMaster(Masters idMaster){this.idMaster = idMaster;}


}