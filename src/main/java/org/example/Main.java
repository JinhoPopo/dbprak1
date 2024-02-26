package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception var8) {
            System.err.println("Не удалось загрузить драйвер: " + String.valueOf(var8));
            return;
        }

        Connection conn = DriverManager.getConnection("jdbc:sqlite:D:/sqlite/Salon.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM cliets AS cl JOIN Masters AS st ON cl.IDMASTERS = st.idMaster");
        List<Cliets> cliets = new ArrayList();
        List<Masters> masters = new ArrayList();

        while(rs.next()) {
            Masters tmpStylist = new Masters(rs.getInt("idMaster"), rs.getString("Fname"));
            cliets.add(new Cliets(rs.getInt("idCliet"), rs.getString("name"), tmpStylist));
            masters.add(tmpStylist);
        }

        stmt.close();
        Iterator var9 = cliets.iterator();

        Cliets cliet;
        while(var9.hasNext()) {
            cliet = (Cliets)var9.next();
            DBW.printCliet(cliet);
        }

        var9 = masters.iterator();

        while(var9.hasNext()) {
            Masters stylist = (Masters) var9.next();
            DBW.printMaster(stylist);
        }

        var9 = cliets.iterator();

        while(var9.hasNext()) {
            cliet = (Cliets)var9.next();
            DBW.printClietMaster(cliet);
        }

    }
}
