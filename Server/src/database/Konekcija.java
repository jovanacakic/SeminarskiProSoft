/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import config.Config;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jovana
 */
public class Konekcija {

    private static Konekcija instance;
    private Connection connection;

    public static Konekcija getInstance() {
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
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
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
