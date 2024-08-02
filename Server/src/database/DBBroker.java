/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import config.Config;
import domen.AbstractDomainObject;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jovana
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection konekcija;

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void otvoriKonekciju() {
        try {
            konekcija = DriverManager.getConnection(Config.getDatabaseUrl(), Config.getUsername(), Config.getPassword());
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            System.err.println("Neuspesno konektovanje sa bazom");
        }
    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized List<AbstractDomainObject> getAllOpstiDomenskiObjekats(AbstractDomainObject o) {
        try {
            String upit = o.getSelectUpit();
            List<AbstractDomainObject> lista;
            try (Statement s = konekcija.createStatement()) {
                System.out.println(upit);
                ResultSet rs = s.executeQuery(upit);
                lista = o.konvertujRSUListu(rs);
            }
            
            return lista;
        } catch (SQLException ex) {
            System.err.println("Greska prilikom vracanja opstih domenskih objkekata tabele: " + o.getTableName());
        }
        return null;
    }

    public synchronized AbstractDomainObject getOpstiDomenskiObjekatPoParametru(AbstractDomainObject o) {
        try {
            String upit = o.getSelectUpitPoParametru();
            List<AbstractDomainObject> lista;
            try (Statement s = konekcija.createStatement()) {
                ResultSet rs = s.executeQuery(upit);
                lista = o.konvertujRSUListu(rs);
            }
            return lista.isEmpty() ? null : lista.get(0);
        } catch (SQLException ex) {
            System.err.println("Greska prilikom vracanja opstih domenskih objkekata tabele: " + o.getTableName());
        }
        return null;
    }

    public synchronized boolean saveOpstiDomenskiObjekat(AbstractDomainObject o) {
        try {
            String upit = o.getInsertUpit();
            System.out.println(upit);
            try (Statement s = konekcija.createStatement()) {
                s.executeUpdate(upit);
            }
            return true;
        } catch (SQLException ex) {
            System.err.println("Greska prilikom cuvanja novog domenskog objekta u tabelu: " + o.getTableName() + "Greska: " + ex.getMessage());
        }
        return false;
    }

    public synchronized boolean updateOpstiDomenskiObjekat(AbstractDomainObject o) {
        try {
            String upit = o.getUpdateUpit();
            try (Statement s = konekcija.createStatement()) {
                s.executeUpdate(upit);
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("Greska prilikom azuriranja objekta: " + o.getTableName() + " Greska: " + ex.getMessage());
        }
        return false;
    }

    public synchronized boolean deleteOpstiDomenskiObjekat(AbstractDomainObject o) {
        try {
            String upit = o.getDeleteUpit();
            try (Statement s = konekcija.createStatement()) {
                s.executeUpdate(upit);
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("Greska prilikom brisanja objekta: " + o.getTableName() + " Greska: " + ex.getMessage());
        }
        return false;
    }

}
