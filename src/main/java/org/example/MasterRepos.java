package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MasterRepos implements Repos<Masters> {
    @Override
    public void Update(Masters masters) throws SQLException{
        String str = String.format("UPDATE masters SET idMaster = %s', Fname = %s WHERE idCliets = %s",
                masters.getId(),
                masters.getName(),
                masters.getId());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(str);
        stmt.close();
    }
    @Override
    public void Insert(Masters masters) throws SQLException {
        String str = String.format("INSERT INTO master (id,Fname) VALUES (%s, '%s')",
                masters.getId(),
                masters.getName());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(str);
        stmt.close();
    }
    @Override
    public void Delete(Masters masters)throws SQLException{
        String str = String.format("DELETE FROM masters where id = %s", masters.getId());
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(str);
        stmt.close();
    }
    @Override
    public List<Masters> getList() throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        ResultSet rs = stmt.executeQuery("SELECT st.id, st.Fname FROM Masters AS st");
        List<Masters> masters = new ArrayList<>();
        while (rs.next()){
            Masters tmpMaster = new Masters(rs.getInt("id"), rs.getString("Fname"));
            masters.add(tmpMaster);
        }
        this.closeConnection(stmt);
        return masters;
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
