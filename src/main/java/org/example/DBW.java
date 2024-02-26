package org.example;

import java.io.PrintStream;

public class DBW {
    public DBW() {
    }

    public static void printMaster(Masters master) {
        PrintStream var10000 = System.out;
        int var10001 = master.getId();
        var10000.println("" + var10001 + " " + master.getName());
    }

    public static void printCliet(Cliets cliet) {
        PrintStream var10000 = System.out;
        int var10001 = cliet.getId();
        var10000.println("" + var10001 + " " + cliet.getName() + " " + cliet.getIdMaster().getName());
    }

    public static void printClietMaster(Cliets cliet) {
        PrintStream var10000 = System.out;
        int var10001 = cliet.getId();
        var10000.print("" + var10001 + " " + cliet.getName() + " ");
        printMaster(cliet.getIdMaster());
    }
}
