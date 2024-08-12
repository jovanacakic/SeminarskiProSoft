/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import config.Config;
import domen.AbstractDomainObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jovana
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection connection;

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void otvoriKonekciju() {
        try {
            connection = DriverManager.getConnection(Config.getDatabaseUrl(), Config.getUsername(), Config.getPassword());
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            System.err.println("Neuspesno konektovanje sa bazom");
        }
    }

    public void zatvoriKonekciju() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       public ArrayList<AbstractDomainObject> select(AbstractDomainObject o) throws SQLException {
        String query = "SELECT * FROM " + o.getTableName() + o.getAlijas() + " " + o.getJoin() + " " + o.getUslov();
        System.out.println(query);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        return o.getListuSvih(rs);
    }

    public PreparedStatement insert(AbstractDomainObject o) throws SQLException {
        String query = "INSERT INTO " + o.getTableName()+ " " + o.getKoloneZaInsert() + " VALUES(" + o.getVrednostiZaInsert() + ")";
        System.out.println(query);
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        int i = ps.executeUpdate();
        return ps;
    }

    public boolean update(AbstractDomainObject o) throws SQLException {
        String query = "UPDATE " + o.getTableName()+ " SET " + o.getVrednostiZaUpdate() + " WHERE " + o.getVrednostZaPrimarniKljuc();
        System.out.println(query);
        Statement statement = connection.createStatement();
        int rezultat = statement.executeUpdate(query);
        
        if(rezultat == 0)
            return false;
        
        return true;
    }

    public boolean delete(AbstractDomainObject o) throws SQLException {
        String query = "DELETE FROM " + o.getTableName()+ " WHERE " + o.getVrednostZaPrimarniKljuc();
        System.out.println(query);
        Statement statement = connection.createStatement();
        int rezultat = statement.executeUpdate(query);
        
        if(rezultat == 0)
            return false;
        
        return true;
    }

}
