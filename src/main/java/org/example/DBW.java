package org.example;

import java.io.PrintStream;

public class DBW {
    public DBW() {
    }

    public static void printMaster(Masters master) {
        System.out.println(master.getId()+" "+ master.getName());
    }

    public static void printCliet(Cliets cliet) {
        System.out.println(cliet.getId()+""+cliet.getName()+cliet.getIdMaster());
    }

    public static void printClietMaster(Cliets cliet) {
        System.out.println(cliet.getId()+""+cliet.getName()+"");
        printMaster(cliet.getIdMaster());
    }
}
