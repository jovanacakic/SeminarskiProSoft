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
public class Ekvivalenti extends AbstractDomainObject {

    private int id;
    private Predmet predmetFon;
    private Predmet predmetDrugiFakultet;
    int godinaDodavanja;

    public Ekvivalenti() {
    }

    public Ekvivalenti(int id, Predmet predmetFon, Predmet predmetDrugiFakultet, int godinaDodavanja) {
        this.id = id;
        this.predmetFon = predmetFon;
        this.predmetDrugiFakultet = predmetDrugiFakultet;
        this.godinaDodavanja = godinaDodavanja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Predmet getPredmetFon() {
        return predmetFon;
    }

    public void setPredmetFon(Predmet predmetFon) {
        this.predmetFon = predmetFon;
    }

    public Predmet getPredmetDrugiFakultet() {
        return predmetDrugiFakultet;
    }

    public void setPredmetDrugiFakultet(Predmet predmetDrugiFakultet) {
        this.predmetDrugiFakultet = predmetDrugiFakultet;
    }

    public int getGodinaDodavanja() {
        return godinaDodavanja;
    }

    public void setGodinaDodavanja(int godinaDodavanja) {
        this.godinaDodavanja = godinaDodavanja;
    }

    @Override
    public String getTableName() {
        return "ekvivalenti";
    }

    @Override
    public String getAlias() {
        return " e ";
    }

    @Override
    public String getJoin() {
        // Ako je potrebno joinovati druge tabele za dobijanje kompletnih informacija o ekvivalentima
        return " JOIN predmet p1 ON e.predmetFon = p1.ID "
                + " JOIN predmet p2 ON e.predmetDrugiFakultet = p2.ID ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getListuSvih(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Predmet predmetFon = new Predmet(
                    rs.getInt("p1.ID"), rs.getString("p1.Naziv"), rs.getString("p1.Ustanova"),
                    rs.getString("p1.Semestar"), rs.getInt("p1.Espb"));
            Predmet predmetDrugiFakultet = new Predmet(
                    rs.getInt("p2.ID"), rs.getString("p2.Naziv"), rs.getString("p2.Ustanova"),
                    rs.getString("p2.Semestar"), rs.getInt("p2.Espb"));

            Ekvivalenti ekvivalent = new Ekvivalenti(
                    rs.getInt("e.ID"), predmetFon, predmetDrugiFakultet, rs.getInt("e.GodinaDodavanja"));
            lista.add(ekvivalent);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getKoloneZaInsert() {
        return "(PredmetFon, PredmetDrugiFakultet, GodinaDodavanja)";
    }

    @Override
    public String getVrednostZaPrimarniKljuc() {
        return " id = " + id;
    }

    @Override
    public String getVrednostiZaInsert() {
        return predmetFon.getPredmetID() + ", " + predmetDrugiFakultet.getPredmetID() + ", " + godinaDodavanja;
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " PredmetFon = " + predmetFon.getPredmetID()
                + ", PredmetDrugiFakultet = " + predmetDrugiFakultet.getPredmetID()
                + ", GodinaDodavanja = " + godinaDodavanja;
    }

    @Override
    public String getUslov() {
        return " ORDER BY e.GodinaDodavanja DESC, p1.Naziv ASC, p2.Naziv ASC";
    }

    @Override
    public String toString() {
        return predmetFon.getNaziv() + " <-> " + predmetDrugiFakultet.getNaziv()
                + " (" + godinaDodavanja + ")";
    }

}
