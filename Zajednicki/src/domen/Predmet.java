/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jovana
 */
public class Predmet extends AbstractDomainObject {

    private int predmetID;
    private String naziv;
    private Univerzitet univerzitet;
    private String semestar;
    private int espb;
    Radnik radnik;

    @Override
    public String toString() {
        return naziv;
    }

    public Predmet() {
    }

    public Predmet(int predmetID, String naziv, Univerzitet univerzitet, String semestar, int espb, Radnik radnik) {
        this.predmetID = predmetID;
        this.naziv = naziv;
        this.univerzitet = univerzitet;
        this.semestar = semestar;
        this.espb = espb;
        this.radnik = radnik;
    }

    @Override
    public String getTableName() {
        return "predmet";
    }

    //@Override
    public String getParametre() {
        return String.format("%d, '%s', %d, '%s', %d, %d", predmetID, naziv, univerzitet.getUniverzitetID(), semestar, espb, radnik.getRadnikID());
    }

    //@Override
    public String getNaziveParametara() {
        return "predmetID, naziv, univerzitetID, semestar, espb";
    }

    //@Override
    public String getSelectUpit() {
        return "SELECT * FROM " + getTableName();
    }

    //@Override
    public String getSelectUpitPoParametru() {
        return "SELECT * FROM " + getTableName() + " WHERE predmetID = " + getPredmetID() + " OR univerzitetID = '" + univerzitet.getUniverzitetID() + "'";
    }

    public String getSelectUpitSaDodatnim(String dodatniUpit) {
        return "SELECT * FROM " + getTableName() + " " + dodatniUpit;
    }

    //@Override
    public String getInsertUpit() {
        return "INSERT INTO " + getTableName() + "(" + getNaziveParametara() + ")" + " VALUES (" + getParametre() + ")";
    }

    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSemestar() {
        return semestar;
    }

    public void setSemestar(String semestar) {
        this.semestar = semestar;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    @Override
    public String getAlias() {
        return " p ";
    }

    @Override
    public String getJoin() {
        return " JOIN univerzitet u ON u.UniverzitetID = p.univerzitetID JOIN radnik rad ON p.radnikID = rad.radnikID ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Radnik radnik = new Radnik(rs.getInt("rad.RadnikID"), rs.getString("rad.Username"), rs.getString("rad.Password"), rs.getString("rad.Ime"), rs.getString("rad.Prezime"));
            Univerzitet univerzitet = new Univerzitet(rs.getInt("UniverzitetID"), rs.getString("u.Naziv"), rs.getString("Grad"));
            Predmet predmet = new Predmet(rs.getInt("PredmetID"), rs.getString("p.Naziv"), univerzitet, rs.getString("Semestar"), rs.getInt("Espb"), radnik);
            lista.add(predmet);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(naziv, univerzitetID, Semestar, Espb, radnikID)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " PredmetID = " + predmetID;
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + naziv + "', " + univerzitet.getUniverzitetID() + ", '" + semestar + "', " + espb + ", " + radnik.getRadnikID();
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " naziv='" + naziv + "', univerzitetID=" + univerzitet.getUniverzitetID() + ", semestar='" + semestar + "', espb=" + espb + ", radnikID =" + radnik.getRadnikID();
    }

    @Override
    public String getUslov() {
        return " ORDER BY p.naziv ASC";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Predmet other = (Predmet) obj;

        // Poređenje predmetID
        if (predmetID != other.predmetID) {
            return false;
        }

        // Poređenje univerzitetID
        if (univerzitet == null || other.univerzitet == null) {
            return false;
        }
        if (univerzitet.getUniverzitetID() != other.univerzitet.getUniverzitetID()) {
            return false;
        }

        // Poređenje naziv bez obzira na mala i velika slova
        if (naziv == null) {
            if (other.naziv != null) {
                return false;
            }
        } else if (!naziv.equalsIgnoreCase(other.naziv)) {
            return false;
        }

        return true;
    }

    public Univerzitet getUniverzitet() {
        return univerzitet;
    }

    public void setUniverzitet(Univerzitet univerzitet) {
        this.univerzitet = univerzitet;
    }

    //@Override
    public String getUpdateUpit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //@Override
    public String getUpdateParametre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //@Override
    public String getDeleteUpit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
