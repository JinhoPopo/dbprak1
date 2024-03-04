package org.example;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ClietsRepos implements Repos<Cliets> {
    @Override
    public void Update(Cliets cliets) throws SQLException{
        String str = String.format("UPDATE cliets SET idCliets = %s', idMaster = %s WHERE idCliets = %s",
                cliets.getId(),
                cliets.getName(),
                cliets.getIdMaster().getId(),
                cliets.getId());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(str);
        stmt.close();

    }
    @Override
    public void Insert(Cliets cliets) throws SQLException {
        MasterRepos masterRepos = new MasterRepos();
        masterRepos.Insert(cliets.getIdMaster());
        String str = String.format("INSERT INTO cliet (idCliet, name, idMaster) VALUES (%s, '%s', %s)",
                cliets.getId(),
                cliets.getName(),
                cliets.getIdMaster().getId());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(str);
        stmt.close();
    }
    @Override
    public void Delete(Cliets cliets)throws SQLException{
        String str = String.format("DELETE FROM cliets where idCliets = %s", cliets.getId());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(str);
        stmt.close();
    }
    @Override
    public List<Cliets> getList() throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        ResultSet rs = stmt.executeQuery("SELECT cl.id, cl.name, cl.idMaster, st.id, st.Fname FROM Cliets AS cl JOIN Masters AS st ON cl.IDMASTER = st.id");

        List<Cliets> cliets = new ArrayList<>();
        while(rs.next()) {
            cliets.add(new Cliets(rs.getInt("id"),
                    rs.getString("name"),
                    new Masters(rs.getInt("id"), rs.getString("Fname"))));
        }
        this.closeConnection(stmt);
        return cliets;
}
    @Override
    public Connection connectToDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:D:/sqlite/Salon.db");
        if (conn==null){
            System.out.println("Error with connection with DataBase!");
            System.exit(0);
        }
        return conn;
    }
    @Override
    public Statement getStatement(Connection conn) throws SQLException {
        return conn.createStatement();
    }
    public void closeConnection(Statement stmt) throws SQLException {
        stmt.close();
    }
}
