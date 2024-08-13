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

    private int id;
    private String naziv;
    private String ustanova;
    private String semestar;
    private int espb;

    @Override
    public String toString() {
        return naziv + ": " + ustanova;
    }

    public Predmet() {
    }

    public Predmet(int id, String naziv, String ustanova, String semestar, int espb) {
        this.id = id;
        this.naziv = naziv;
        this.ustanova = ustanova;
        this.semestar = semestar;
        this.espb = espb;
    }

    @Override
    public String getTableName() {
        return "predmet";
    }

    //@Override
    public String getParametre() {
        return String.format("%d, '%s', '%s', '%s', %d", id, naziv, ustanova, semestar, espb);
    }

    //@Override
    public String getNaziveParametara() {
        return "id, naziv, ustanova, semestar, espb";
    }

    //@Override
    public String getNazivPrimarnogKljuca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //@Override
    public Integer getVrednostPrimarnogKljuca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //@Override
    public String getSlozeniPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //@Override
    public List<AbstractDomainObject> konvertujRSUListu(ResultSet rs) {
        ArrayList<AbstractDomainObject> predmeti = new ArrayList<>();
        try {
            while (rs.next()) {
                int rsId = rs.getInt("id");
                String rsNaziv = rs.getString("naziv");
                String rsUstanova = rs.getString("ustanova");
                String rsSemestar = rs.getString("semestar");
                int rsEspb = rs.getInt("espb");

                predmeti.add(new Predmet(rsId, rsNaziv, rsUstanova, rsSemestar, rsEspb));
            }
        } catch (SQLException e) {
            System.out.println("Greska u Predmet::konvertujRSUListu\n" + e.getMessage());
        }
        return predmeti;
    }

    //@Override
    public String getSelectUpit() {
        return "SELECT * FROM " + getTableName();
    }

    //@Override
    public String getSelectUpitPoParametru() {
        return "SELECT * FROM " + getTableName() + " WHERE id = " + getId() + " OR ustanova = '" + getUstanova() + "'";
    }

    public String getSelectUpitSaDodatnim(String dodatniUpit) {
        return "SELECT * FROM " + getTableName() + " " + dodatniUpit;
    }

    //@Override
    public String getInsertUpit() {
        return "INSERT INTO " + getTableName() + "(" + getNaziveParametara() + ")" + " VALUES (" + getParametre() + ")";
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getUstanova() {
        return ustanova;
    }

    public void setUstanova(String ustanova) {
        this.ustanova = ustanova;
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
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Predmet predmet = new Predmet(rs.getInt("ID"), rs.getString("Naziv"), rs.getString("Ustanova"), rs.getString("Semestar"), rs.getInt("Espb"));
            lista.add(predmet);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(naziv, Ustanova, Semestar, Espb)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " id = " + id;
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + naziv + "', '" + ustanova + "', '" + semestar + "', '" + espb + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " naziv='" + naziv + "', ustanova='" + ustanova + "', semestar='" + semestar + "', espb=" + espb + " ";
    }

    @Override
    public String getUslov() {
        return " ORDER BY p.naziv ASC";
    }

}
